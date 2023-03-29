package com.csi.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 请求转码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 接收login页面中的表单数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 进行账户密码比较
        if (username.equals("admin")&&password.equals("admin")){
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("error.jsp");//重定向
        }

    }
}
