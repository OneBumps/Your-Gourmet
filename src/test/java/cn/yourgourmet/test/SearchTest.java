package cn.yourgourmet.test;

import cn.yourgourmet.entity.Recipe;
import cn.yourgourmet.entity.User;
import cn.yourgourmet.mapper.RecipeMapper;
import cn.yourgourmet.mapper.UserMapper;
import cn.yourgourmet.service.SearchEngine;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SearchTest {
    @Test
    public void testSearch() {
        List<Recipe> recipeList = SearchEngine.search("莲鱼");
        System.out.println(recipeList);
    }
    @Test
    public void testMapper() {
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
            RecipeMapper mapper = session.getMapper(RecipeMapper.class);
            System.out.println(JSON.toJSONString(mapper.selectByMenuName("汤")));
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
