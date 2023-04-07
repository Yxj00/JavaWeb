package com.icss.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@WebFilter(filterName = "CharacterFilter" ,urlPatterns = "/*")
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 设置响应编码
        servletResponse.setContentType("text/html;charset=utf-8");
        // 想要调用httpServletRequest  getMethod-form ajax 必须向下转型
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        // 如果是post请求
        if ("POST".equalsIgnoreCase(request.getMethod())){
            request.setCharacterEncoding("utf-8");
        }
        // 向下传递
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
