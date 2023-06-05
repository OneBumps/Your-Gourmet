package cn.yourgourmet.servlet;

import cn.yourgourmet.service.UserOperation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/GetInfo")
public class GetInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        String type = request.getParameter("type");
        if(Objects.equals(type, "getUserInfo")){
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
