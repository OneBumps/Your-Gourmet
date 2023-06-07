package cn.yourgourmet.servlet;

import cn.yourgourmet.entity.Recipe;
import cn.yourgourmet.service.SearchEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/SearchEngine")
public class SearchServlet extends HttpServlet {
    private List<Recipe> dataList = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        List<Recipe> recipeList = SearchEngine.search(request.getParameter("search"));
        response.sendRedirect(getServletContext().getRealPath("/html/search.html" + "?search=" + request.getParameter("search")));
    }
}
