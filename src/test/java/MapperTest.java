import cn.yourgourmet.entity.Recipe;
import cn.yourgourmet.entity.Step;
import cn.yourgourmet.entity.User;
import cn.yourgourmet.mapper.RecipeMapper;
import cn.yourgourmet.mapper.StepMapper;
import cn.yourgourmet.mapper.UserMapper;
import com.alibaba.fastjson2.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MapperTest {

    public void SQLSample(SqlSession session) {
        String id = "1";
        RecipeMapper recipeMapper = session.getMapper(RecipeMapper.class);
        Recipe recipe = recipeMapper.selectById(id);
        StepMapper stepMapper = session.getMapper(StepMapper.class);
        List<Step> steps = stepMapper.selectBySteps(id);
        //得到json
        System.out.println(JSON.toJSONString(recipe) + JSON.toJSONString(steps));
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