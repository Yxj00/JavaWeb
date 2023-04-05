package com.icss.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("添加了属性~");
        // 获取servletContext
        ServletContext servletContext = event.getServletContext();
        // 直接获取当前的属性名称
        String name = event.getName();
        Object value = event.getValue();
        System.out.println(name+"---"+value);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("移除了属性~");
        // 获取servletContext
        ServletContext servletContext = event.getServletContext();
        // 直接获取当前的属性名称
        String name = event.getName();
        Object value = event.getValue();
        System.out.println(name+"---"+value);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("替换了属性~");
        // 获取servletContext
        ServletContext servletContext = event.getServletContext();
        // 直接获取当前的属性名称
        String name = event.getName();
        Object value = event.getValue();
        System.out.println(name+"---"+value);
    }
}
