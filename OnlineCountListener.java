package com.icss.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class OnlineCountListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /**
         * 一个session创建  在线人数+1
         * 在线人数存哪？上下文ServletContext中 统计的是整个应用程序的数据
         * 获取当前的count，先通过servletContext
         */
        ServletContext servletContext = se.getSession().getServletContext();
        Object count = servletContext.getAttribute("count");
        System.out.println(count);
        int onlineCount=0;
        if (count!=null){
            onlineCount=(int) count;
        }
        se.getSession().getServletContext().setAttribute("count",++onlineCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
