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
public class VerifyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        String type = request.getParameter("type");
        if (Objects.equals(type, "updatePassword")) {
            PrintWriter out = response.getWriter();
            HttpSession session = request.getSession(false);
            if (UserOperation.changePassword((String) session.getAttribute("user_id"), request.getParameter("oldPassword"), request.getParameter("newPassword"))) {
                out.print("true");
            } else {
                out.print("false");
            }
        }
        if (Objects.equals(type, "updateUserInfo")) {
            PrintWriter out = response.getWriter();
            HttpSession session = request.getSession(false);
            if (UserOperation.updateUserInfo((String) session.getAttribute("user_id"), request.getParameter("userName"), request.getParameter("userPhone"), request.getParameter("userEmail"), request.getParameter("userGender"), request.getParameter("userIntroduction"))) {
                //转发至个人信息页面
                String contextPath = request.getContextPath();
                response.sendRedirect(request.getContextPath() + "/html/edit-profile.html");
            } else {
                response.sendRedirect(request.getContextPath() + "/html/edit-profile.html");
            }
        }
        if (Objects.equals(type, "SignIn")) {
            String userId = UserOperation.signIn(request.getParameter("username"), request.getParameter("password"));
            if (!userId.isEmpty()) {
                // 创建会话
                HttpSession session = request.getSession(false);
                session.setAttribute("user_id", userId);
                // 设置cookie
                Cookie cookie = new Cookie("JSESSIONID", session.getId());
                cookie.setMaxAge(15 * 24 * 60 * 60); // 保存15天
                response.addCookie(cookie);
                response.sendRedirect(request.getContextPath() + "/html/index.html");
            } else {
                response.sendRedirect(request.getContextPath() + "/html/login.html");
            }
        }
        if (Objects.equals(type, "SignUp")) {
            String userId = UserOperation.signUp(request.getParameter("username"), request.getParameter("user_password"), request.getParameter("user_email"), request.getParameter("user_phone"));
            if (!userId.isEmpty()) {
                // 创建会话
                HttpSession session = request.getSession(false);
                session.setAttribute("user_id", userId);
                // 设置cookie
                Cookie cookie = new Cookie("JSESSIONID", session.getId());
                cookie.setMaxAge(15 * 24 * 60 * 60); // 保存15天
                response.addCookie(cookie);
                response.sendRedirect(request.getContextPath() + "/html/index.html");
            } else {
                response.sendRedirect(request.getContextPath() + "/html/register.html");
            }
        }
    }
}
