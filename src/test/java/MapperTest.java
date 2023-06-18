import cn.yourgourmet.entity.*;
import cn.yourgourmet.mapper.*;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MapperTest {

    public void SQLSample(SqlSession session) {
        String id = "1";
        // 得到Mapper
        RecipeMapper recipeMapper = session.getMapper(RecipeMapper.class);
        StepMapper stepMapper = session.getMapper(StepMapper.class);
        BelongMapper belongMapper = session.getMapper(BelongMapper.class);
        CuisineMapper cuisineMapper = session.getMapper(CuisineMapper.class);
        UsesMapper usesMapper = session.getMapper(UsesMapper.class);
        // 菜谱信息
        Recipe recipe = recipeMapper.selectById(id);
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
        System.out.println(jsonObject.toJSONString());
    }

    @Test
    public void getMapper() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            System.out.println("读取配置文件失败");
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            SQLSample(session);
        } catch (Exception e) {
            System.out.println("事务操作失败");
            throw new RuntimeException(e);
        }
    }
}