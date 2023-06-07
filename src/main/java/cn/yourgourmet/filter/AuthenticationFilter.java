package cn.yourgourmet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter")
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // 验证会话
        HttpSession session = httpRequest.getSession(false);
        if (session != null && session.getAttribute("user_id") != null) {
            // 用户已经登录，继续处理请求
            chain.doFilter(request, response);
        } else {
            // 判断是否已经是登录或注册页面
            String path = httpRequest.getRequestURI();
            if (path.endsWith("/html/login.html") || path.endsWith("/html/register.html")) {
                chain.doFilter(request, response);
                return;
            } else if (path.endsWith("Verify")) {
                if (httpRequest.getParameter("type").equals("SignIn") || httpRequest.getParameter("type").equals("SignUp")) {
                    chain.doFilter(request, response);
                    return;
                }
            }
            // 用户未登录，重定向到登录页面
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/html/login.html");
        }
    }
}