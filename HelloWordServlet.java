package com.csi.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //服务器自动执行该方法，在方法中写入浏览器要的东西，以流的形式写入
        //数据在进行渲染一个HTML页面
        //resp响应  服务器给客户端的东西
        //通过resp获取输入输出流，写入到页面中
        // 设置字符集utf-8
        resp.setContentType("text/html;charset=utf-8");
        // 声明流对象  向浏览器写入数据
        PrintWriter writer = resp.getWriter();
        writer.write("<html><head><meta charset=utf-8>");
        writer.write("<title>第一个servlet应用</title></head>");
        writer.write("<body><h1>HelloWord我的一个应用</h1></body></html>");
    }
}
