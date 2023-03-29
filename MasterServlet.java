package com.csi.servlet;

import com.csi.pojo.Master;
import com.csi.service.MasterService;
import com.csi.service.impl.MasterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MasterServlet extends HttpServlet {
    // 控制层要和业务层绑定
    private MasterService service=new MasterServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 接收页面传递的数据
        String op = req.getParameter("op");

        String dl = req.getParameter("dl");
        // 判断op
        if ("findAll".equals(op)){
            // 查询所有方法
            List<Master> all = this.service.findAll();
            // 设置请求信息
            req.setAttribute("all",all);
            // 请求转发给页面
            req.getRequestDispatcher("findAll.jsp").forward(req,resp);

        } else if ("add".equals(op)) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
           Integer money = Integer.valueOf(req.getParameter("money"));
            boolean flag = this.service.insert(new Master(username, password, money));
            if (flag==true){
                req.setAttribute("message","新增成功");
                req.getRequestDispatcher("success.jsp").forward(req,resp);
            }else {
                req.setAttribute("message","新增失败");
                req.getRequestDispatcher("success.jsp").forward(req,resp);
            }
        } else if ("findById".equals(op)) {
            Integer id = Integer.valueOf(req.getParameter("id"));
            Master master= this.service.findById(id);
            req.setAttribute("master",master);
            req.getRequestDispatcher("update.jsp").forward(req,resp);
        } else if ("update".equals(op)) {
            Integer id=Integer.valueOf(req.getParameter("id"));
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            Integer money=Integer.parseInt(req.getParameter("money"));
            boolean flag = this.service.update(new Master(id, username, password, money));
            if (flag==true){
                req.setAttribute("message","修改成功");
                req.getRequestDispatcher("success.jsp").forward(req,resp);
            }else {
                req.setAttribute("message","修改失败");
                req.getRequestDispatcher("success.jsp").forward(req,resp);
            }
        } else if ("delete".equals(op)) {
            Integer id=Integer.valueOf(req.getParameter("id"));
            boolean flag = this.service.delete(id);
            if (flag==true){
                req.setAttribute("message","删除成功");
                req.getRequestDispatcher("success.jsp").forward(req,resp);
            }else {
                req.setAttribute("message","删除失败");
                req.getRequestDispatcher("success.jsp").forward(req,resp);
            }
        }else if ("login".equals(op)){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            if (username.equals("admin")&&password.equals("123")){
                req.setAttribute("message","登录成功");
                req.getRequestDispatcher("success.jsp").forward(req,resp);
            }else {
                req.setAttribute("message","登录失败");
                req.getRequestDispatcher("error.jsp").forward(req,resp);
            }
        }

    }
}
