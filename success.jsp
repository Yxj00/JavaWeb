<%--
  Created by IntelliJ IDEA.
  User: 啊
  Date: 2023/3/28
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{text-align: center}
    </style>
</head>
<body>
【<%=request.getAttribute("message")%>】<br>
<%--<%@include file="index.jsp"%>--%>
<a href="master?op=findAll">查询所有</a><br>
<a href="add.jsp">新增</a>
</body>
</html>
