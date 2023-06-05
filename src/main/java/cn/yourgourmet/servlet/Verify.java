package cn.yourgourmet.servlet;

import cn.yourgourmet.service.UserOperation;
import cn.yourgourmet.service.VerifyUpdateMenu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/Verify")
public class Verify extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String type = request.getParameter("type");
        if (Objects.equals(type, "verifyMenuName")) {
            PrintWriter out = response.getWriter();
            if (VerifyUpdateMenu.verifyMenuName(request.getParameter("name"))) {
                out.print("true");
            } else {
                out.print("false");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        String type = request.getParameter("type");
        if (Objects.equals(type, "updatePassword")) {
            PrintWriter out = response.getWriter();
            if (UserOperation.changePassword(request.getParameter("userId"), request.getParameter("oldPassword"), request.getParameter("newPassword"))) {
                out.print("true");
            } else {
                out.print("false");
            }
        }
        if(Objects.equals(type, "updateUserInfo")){
            PrintWriter out = response.getWriter();
            if (UserOperation.updateUserInfo(request.getParameter("userId"), request.getParameter("userName"), request.getParameter("userPhone"), request.getParameter("userEmail"), request.getParameter("userGender"), request.getParameter("userIntroduction"))) {
                //转发至根页面
                String contextPath = request.getContextPath();
                response.sendRedirect(request.getContextPath() + "/html/edit-profile.html");
            } else {
                response.sendRedirect(request.getContextPath() + "/html/edit-profile.html");
            }
        }
    }
}
