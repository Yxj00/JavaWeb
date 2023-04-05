package com.icss.servlet;

import com.icss.pojo.Person;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class SetAttributeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取servletContext对象
        ServletContext servletContext = getServletContext();
        Person person = new Person();
        person.setId(UUID.randomUUID().toString().replaceAll("-",""));
        person.setName("jack");
        person.setAge(18);
        // 存入 属性数据
        servletContext.setAttribute("person",person);
    }
}
