package com.icss.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        // 判断
        if (username!= null && password !=null){
            if ("admin".equals(username)&&"admin".equals(password)){
                servletRequest.getRequestDispatcher("admin.jsp").forward(servletRequest,servletResponse);

            }else {
                servletRequest.getRequestDispatcher("welcome.jsp").forward(servletRequest,servletResponse);
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
