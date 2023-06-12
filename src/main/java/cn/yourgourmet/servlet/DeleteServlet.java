package cn.yourgourmet.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import cn.yourgourmet.service.UserOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if (Objects.equals(type, "deleteUser")) {
            PrintWriter out = response.getWriter();
            Boolean result = UserOperation.deleteUser(request.getParameter("userId"), request.getParameter("userPassword"));
            if (result) {
                out.print("true");
            } else {
                out.print("false");
            }
        }
    }
}
