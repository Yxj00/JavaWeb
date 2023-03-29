package com.csi.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    public MyServlet() {
        System.out.println("我是构造方法");
    }



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我是servlet方法   我进行实例化请求");
    }

    @Override
    public void destroy() {
        System.out.println("我是destroy方法");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("我是初始化方法 ");
    }
}
