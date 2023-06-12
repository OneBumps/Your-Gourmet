package cn.yourgourmet.service;

import cn.yourgourmet.entity.Recipe;
import cn.yourgourmet.entity.Step;
import cn.yourgourmet.mapper.RecipeMapper;
import cn.yourgourmet.mapper.StepMapper;
import com.alibaba.fastjson2.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
            RecipeMapper recipeMapper = session.getMapper(RecipeMapper.class);
            Recipe recipe = recipeMapper.selectById(id);
            StepMapper stepMapper = session.getMapper(StepMapper.class);
            List<Step> steps = stepMapper.selectBySteps(id);
            //得到json
            return JSON.toJSONString(recipe) + JSON.toJSONString(steps);
        } catch (
                Exception e) {
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
