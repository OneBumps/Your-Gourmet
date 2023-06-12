package cn.yourgourmet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebFilter(filterName = "SearchFilter")
public class SearchFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        if (httpRequest.getHeader("Referer").endsWith("/html/search.html")) {
            chain.doFilter(request, response);
        }
        httpResponse.sendRedirect(httpRequest.getContextPath() + "/html/search.html" + "?search=" + httpRequest.getParameter("search"));
    }
}