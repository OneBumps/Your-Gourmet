package cn.yourgourmet.service;

import cn.yourgourmet.entity.Recipe;
import cn.yourgourmet.entity.Step;
import cn.yourgourmet.mapper.*;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MenuOperation {
    public static String getRecipe(String id) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            System.out.println("读取配置文件失败");
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession(true);) {
            // 得到Mapper
            RecipeMapper recipeMapper = session.getMapper(RecipeMapper.class);
            StepMapper stepMapper = session.getMapper(StepMapper.class);
            BelongMapper belongMapper = session.getMapper(BelongMapper.class);
            CuisineMapper cuisineMapper = session.getMapper(CuisineMapper.class);
            UsesMapper usesMapper = session.getMapper(UsesMapper.class);
            // 菜谱信息
            Recipe recipe = recipeMapper.selectById(id);
            if(recipe == null || recipe.getUserId() == null) return null;
            // 步骤信息
            List<Step> steps = stepMapper.selectBySteps(id);
            // 归属菜系信息
            Integer cuisineId = belongMapper.selectCuisineIdByRecipeId(id);
            String cuisineName = cuisineMapper.selectCuisineNameByRecipeId(cuisineId);
            // 用料信息
            List<Map<String, Object>> uses = usesMapper.selectUsesByRecipeId(id);
            // 得到JSON
            JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(recipe));
            JSONArray stepsJson = new JSONArray(steps);
            JSONArray usesJson = new JSONArray(uses);
            jsonObject.put("cuisineName", cuisineName);
            jsonObject.put("steps", stepsJson);
            jsonObject.put("ingredient", usesJson);
            return jsonObject.toJSONString();
        } catch (Exception e) {
            System.out.println("事务操作失败");
            throw new RuntimeException(e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                System.out.println("关闭输入流失败");
            }
        }
    }
}
