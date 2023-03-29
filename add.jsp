<%--
  Created by IntelliJ IDEA.
  User: 啊
  Date: 2023/3/29
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        form{text-align: center}
    </style>
</head>
<body>
<form action="master?op=add" method="post">
    username:<input type="text" name="username" placeholder="请输入用户名"><br>
    password:<input type="password" name="password" placeholder="请输入密码"><br>
    money:<input type="text" name="money" placeholder="请输入金额"><br>
    <input type="submit" value="添加">
</form>
</body>
</html>
