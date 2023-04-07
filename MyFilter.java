package com.icss.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    private FilterConfig filterConfig=null;
    public MyFilter() {
        System.out.println("构造方法执行了。。。");
    }

    @Override
    public void init(FilterConfig Config) throws ServletException {
        System.out.println("初始化方法~~~");
        filterConfig=Config;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 执行过滤器的功能
        System.out.println("dofilter方法执行了");
        // 获取dofilter中可以使用的变量
        String ip = filterConfig.getInitParameter("ip");
        System.out.println(ip);
        // ip存入到request  后面的资源能不能获取到IP
        servletRequest.setAttribute("ip",ip);
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("dofilter方法又执行了");
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法。。");
    }
}
