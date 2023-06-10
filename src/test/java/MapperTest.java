import cn.yourgourmet.entity.User;
import cn.yourgourmet.mapper.RecipeMapper;
import cn.yourgourmet.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MapperTest {

    public void SQLSample(SqlSession session) {
        RecipeMapper mapper = session.getMapper(RecipeMapper.class);
        System.out.println(mapper.selectByMenuName("汤"));
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
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SQLSample(session);
        } catch (Exception e) {
            System.out.println("事务操作失败");
            throw new RuntimeException(e);
        }
    }
}