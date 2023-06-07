package cn.yourgourmet.servlet;

import cn.yourgourmet.service.UserOperation;
import cn.yourgourmet.service.VerifyUpdateMenu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


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
        String type = request.getParameter("type");
        if (Objects.equals(type, "updatePassword")) {
            PrintWriter out = response.getWriter();
            if (UserOperation.changePassword(request.getParameter("userId"), request.getParameter("oldPassword"), request.getParameter("newPassword"))) {
                out.print("true");
            } else {
                out.print("false");
            }
        }
        if (Objects.equals(type, "updateUserInfo")) {
            PrintWriter out = response.getWriter();
            if (UserOperation.updateUserInfo(request.getParameter("userId"), request.getParameter("userName"), request.getParameter("userPhone"), request.getParameter("userEmail"), request.getParameter("userGender"), request.getParameter("userIntroduction"))) {
                //转发至个人信息页面
                String contextPath = request.getContextPath();
                response.sendRedirect(request.getContextPath() + "/html/edit-profile.html");
            } else {
                response.sendRedirect(request.getContextPath() + "/html/edit-profile.html");
            }
        }
        if (Objects.equals(type, "SignIn")) {
            String usernames = request.getParameter("username");
            String userId = UserOperation.signIn(request.getParameter("username"), request.getParameter("password"));
            if (!userId.isEmpty()) {
                // 创建会话
                HttpSession session = request.getSession();
                session.setAttribute("user_id", request.getParameter("username"));
                // 设置cookie
                Cookie cookie = new Cookie("JSESSIONID", session.getId());
                cookie.setMaxAge(15 * 24 * 60 * 60); // 保存15天
                response.addCookie(cookie);
                response.sendRedirect(request.getContextPath() + "/html/index.html");
            } else {
                response.sendRedirect(request.getContextPath() + "/html/login.html");
            }
        }
    }
}
