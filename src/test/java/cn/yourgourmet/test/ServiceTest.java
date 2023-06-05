package cn.yourgourmet.test;

import cn.yourgourmet.entity.User;
import cn.yourgourmet.mapper.UserMapper;
import com.alibaba.fastjson2.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ServiceTest {
    @Test
    public void getUserInfo(){
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
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = new User();
            user.setUserId("e5114d66020e11eebd064ccc6a7eb102");
            user.setUserName("nihao");
            user.setUserPhone("1212121212");
            user.setUserEmail("sdsd");
            user.setUserGender("女");
            user.setUserIntroduction("的覅当年覅覅i呼唤3和23和ihiuhi");
            int res = mapper.updateUserInfo(user);
            System.out.println(res);
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
