package cn.yourgourmet.servlet;

import cn.yourgourmet.service.FileToJSON;
import cn.yourgourmet.service.UserOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/GetInfo")
public class GetInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String type = request.getParameter("type");
        if(Objects.equals(type, "getProvinceList")){
            PrintWriter out = response.getWriter();
            String provinceList = FileToJSON.getProvinceList();
            if(!provinceList.isEmpty()){
                out.print(provinceList);
            }else{
                out.print("false");
            }
        }
        if(Objects.equals(type,"getCityList")){
            PrintWriter out = response.getWriter();
            String provinceId = request.getParameter("provinceId");
            String cityList = FileToJSON.getCityList(provinceId);
            if(!cityList.isEmpty()){
                out.print(cityList);
            }else{
                out.print("false");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        if(Objects.equals(type, "getUserInfo")){
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            String userId = request.getParameter("userId");
            String userInfo = UserOperation.getUserInfo(userId);
            if(!userInfo.isEmpty()){
                out.print(userInfo);
            }else{
                out.print("false");
            }
        }
    }
}
