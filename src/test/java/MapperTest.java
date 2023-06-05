import cn.yourgourmet.entity.User;
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
        UserMapper mapper = session.getMapper(UserMapper.class);
        System.out.println(mapper.deleteUser("e5114d9b020e11eebd064ccc6a7eb102", "csirhtvoeirhier"));
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