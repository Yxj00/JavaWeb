<%@ page import="com.icss.pojo.PageBean" %>
<%@ page import="java.util.List" %>
<%@ page import="com.icss.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: 啊
  Date: 2023/4/10
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> </title>
    <script src="js/jquery-1.12.4.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css"/>
</head>
<body>
<div style="width: 800px;margin: 0 auto">
    <table class="table">
        <tr>
            <th><button>批量删除</button></th>
            <th>用户名</th>
            <th>密码</th>
            <th>姓名</th>
            <th>电话</th>
            <th>邮箱</th>
            <th></th>
            <th></th>
        </tr>
        <%
        // 从requser中取出pagebean
            PageBean pageBean= (PageBean) request.getAttribute("pageBean");
            // pagebean中封装了当前所有的用户对象
            if (pageBean!=null){
                List<User> users=pageBean.getUsers();
                // 遍历
                for (User user : users) {
                    out.write("<tr>");
                    out.write("<td class='item'><input type='checkbox' name='id' value='"+user.getId()+"'></td>");
                    out.write("<td class='username'>"+user.getUsername()+"</td>");
                    out.write("<td class='password'>"+user.getPassword()+"</td>");
                    out.write("<td class='name'>"+user.getName()+"</td>");
                    out.write("<td class='phone'>"+user.getPhone()+"</td>");
                    out.write("<td class='email'>"+user.getEmail()+"</td>");
                    /*user*/
                    out.write("<td><a class='update' href='"+request.getContextPath()+"/user?id="+user.getId()+"'>修改</a></td>");
                    out.write("<td><a class='del' href='javascript:void(0)' onclick='goDelete()'>删除</a></td>");
                    out.write("</tr>");
                }
            }
        %>
    </table>

    <div class="page">
        <a class="previous"
                <%
                    //如果当前页是对一页，不响应
                    if (pageBean.getCurrentPage() == 1){
                        out.write("href='javascript:void(0)'");
                    }else {
                        out.write("href='"+request.getContextPath()+"/user?method=selectPageBean&currentPage="+(pageBean.getCurrentPage()-1)+"'");
                    }
                %>
        >&lt;
        </a>
        <%
            //获取page中的总页数
            int totalPage = pageBean.getTotalPage();
            for (int i=1;i<=totalPage;i++){
                //如果当前页面的值与当前页相同
                if (i==pageBean.getCurrentPage()){
                    //添加active类名，可以不响应点击
                    out.write("<a class='pageNum active' href='javascript:void(0)'>"+i+"</a>");
                }else {
                    out.write("<a class='pageNum' href='"+request.getContextPath()+"/user?method=selectPageBean&currentPage="+i+"'>"+i+"</a>");
                }
            }
        %>
        <a class="next"
                <%
                    System.out.println( pageBean.getCurrentPage()+"@@@@");
                    System.out.println(pageBean.getTotalPage()+"!!!!");
                    //如果当前页是最大页面
                    if (pageBean.getCurrentPage()==pageBean.getTotalPage()){
                        out.write("href='javascript:void(0)'");
                    }else {
                        out.write("href='user?method=selectPageBean&currentPage="+(pageBean.getCurrentPage()+1)+"'");
                    }
                %>
        >&gt;
        </a>
    </div>
</div>
</body>
</html>
