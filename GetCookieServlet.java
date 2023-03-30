package com.icss.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        // 创建能够获取所有的cookie，如果没有，结果null
        Cookie[] cookies = req.getCookies();
        // 先判断是否有cookie
        if (cookies!=null){
            // 想要获取某一个cookie ，遍历数组来寻找
            for (Cookie c : cookies) {
                if ("username".equals(c.getName())){
                    // 找到当前cookie中存储的内容
                    String value = c.getValue();
                    out.println(value);
                }
            }
        }
    }
}
