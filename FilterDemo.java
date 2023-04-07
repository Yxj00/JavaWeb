package com.icss.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(filterName = "FilterDemo" ,urlPatterns = "/filterDemo")
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 获取请求头的来源，httpServletRequest方向
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        // 获取请求中的来源信息
        String referer = request.getHeader("referer");
        // 获取域名
        String scheme = request.getScheme();
        // 获取地址
        String localAddr = request.getLocalAddr();
        // 端口
        int serverPort = request.getServerPort();
        // 路径
        String contextPath = request.getContextPath();
        System.out.println(scheme+localAddr+serverPort+contextPath);
        System.out.println(referer);
        // 拼接当前应用的路径开头
        String besaPath=scheme+"://"+localAddr+":"+serverPort+contextPath;
        System.out.println(besaPath);
        // 如果是应用的内容，跳转过来路径，一定是以上面的路径开头
        if (referer!=null && referer.startsWith(besaPath)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            System.out.println("不符合访问条件");
            HttpServletResponse response= (HttpServletResponse) servletResponse;
            response.sendRedirect("error.jsp");
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
