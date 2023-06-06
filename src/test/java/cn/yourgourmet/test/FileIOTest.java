package cn.yourgourmet.test;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
public class FileIOTest {
    @Test
    public void getProvinceList() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("json/province.json");
        StringBuilder sb = new StringBuilder();
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader bfReader = new BufferedReader(reader);
        String content = null;
        while ((content = bfReader.readLine()) != null) {
            sb.append(content);
        }
        bfReader.close();
        reader.close();
        inputStream.close();
        JSONObject jsonObject = JSON.parseObject(sb.toString());
        JSONArray provinces = jsonObject.getJSONArray("provinces");
    }
}
