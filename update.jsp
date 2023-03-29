<%@ page import="com.csi.pojo.Master" %><%--
  Created by IntelliJ IDEA.
  User: 啊
  Date: 2023/3/29
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Master master=(Master) request.getAttribute("master");
%>
<form action="master?op=update" method="post">
    <input type="text" name="id" hidden value="<%=master.getId()%>">
    username: <input type="text" name="username" placeholder="请输入用户名" value="<%=master.getName()%>"><br>
    password: <input type="password" name="password" placeholder="请输入密码" value="<%=master.getPassword()%>"><br>
    money: <input type="text" name="money" placeholder="请输入金额" value="<%=master.getMoney()%>"><br>
    <input type="submit"  value="修改">
</form>
</body>
</html>
