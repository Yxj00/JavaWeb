package com.icss.servlet;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+":"+password);
        // 创建json对象
        JSONObject jsonObject = new JSONObject();
        // 向json对象输入键值对
        jsonObject.put("userInfo","用户数据接收成功");
        // 服务器返回数据，以json格式返回
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(jsonObject.toJSONString());
    }
}
