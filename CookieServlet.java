package com.icss.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 现在没有cookie 我需要创建cookie
         * 必须给定cookie的name和value
         */
        Cookie cookie = new Cookie("username", "李四");
        /**
         * 设置cookie的属性
         * 可以让她存活多长时间 单位秒
         */
        cookie.setMaxAge(60*60*24);//-1变成会话  相当于删除时间
        resp.addCookie(cookie);
        // 可设置value 就相当于更改了原来的value值
        cookie.setValue("张三");
        // 获取路径
        String path=cookie.getPath();
        cookie.setPath("/");
        System.out.println(cookie);
    }
}
