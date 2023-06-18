package cn.yourgourmet.servlet;

import cn.yourgourmet.entity.Recipe;
import cn.yourgourmet.service.SearchEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
    private List<Recipe> dataList = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String type = request.getParameter("type");
        if(type == null) {
            response.sendRedirect(getServletContext().getRealPath("/html/search.html" + "?search=" + request.getParameter("search")));
        }else if(type.equals("start")){
            String recipeList = SearchEngine.search(request.getParameter("search"));
            PrintWriter out = response.getWriter();
            out.print(recipeList);
        }
    }
}
