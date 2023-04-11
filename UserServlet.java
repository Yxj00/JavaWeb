package com.icss.servlet;

import com.icss.pojo.PageBean;
import com.icss.service.UserService;
import com.icss.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BaseServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取当前展示的页码
        String current_page = req.getParameter("currentPage");
        // 声明一个当前展示页码
        int currentPage=1;
        // 声明一个每页显示几条数据
        int count=4;
        // 不为空，并且不是“”
        if (current_page!=null&&!"".equals(current_page)){
            // string 转为 int
            currentPage=Integer.parseInt(current_page);
        }
        //每页显示固定的个数
        UserService service=new UserServiceImpl();
        PageBean pageBean=service.selectPageBean(currentPage,count);
        // 将pageBean返回给客户端
        req.setAttribute("pageBean",pageBean);
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }
}
