<%--
  Created by IntelliJ IDEA.
  User: 啊
  Date: 2023/3/20
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      form{
        text-align: center;
      }
    </style>
  </head>
  <body>
  <form action="master?op=login" method="post">
    username:<input type="text" name="username" placeholder="请输入账户"><br>
    password:<input type="password" name="password" placeholder="请输入密码"><br>
    <input type="submit" value="登录">
  </form>
<%--  <a href="login.jsp" class="a1"><input type="submit" value="登录" class="i1"></a>--%>
<%--    <a href="master?op=findAll">查询所有</a><br>--%>
<%--    <a href="add.jsp">新增</a>--%>
  </body>
</html>
