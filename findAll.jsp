<%@ page import="com.csi.pojo.Master" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 啊
  Date: 2023/3/28
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            margin: 0 auto;
            width: 400px;
            border-collapse: collapse;
            text-align: center;
        }
        table,th,td{
            border: 1px solid black;
        }
        .a1{text-align: center;}
        .i1{text-align: center}
    </style>
</head>
<body>
<%
    List<Master> all = (List<Master>)request.getAttribute("all");

%>
<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>金额</th>
        <th>操作</th>
    </tr>
    <%
        for (Master m:all){
    %>
    <tr>
        <td><%=m.getId()%></td>
        <td><%=m.getName()%></td>
        <td><%=m.getPassword()%></td>
        <td><%=m.getMoney()%></td>
        <td><a href="master?op=findById&id=<%=m.getId()%>">编辑</a> &nbsp;<a href="master?op=delete&id=<%=m.getId()%>">删除</a></td>
    </tr>
    <%
        }
    %>

</table>
<a href="add.jsp" class="a1"><input type="submit" name="" value="新增" class="i1" ></a>
</body>
</html>
