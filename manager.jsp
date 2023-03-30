<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 啊
  Date: 2023/3/30
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    /**
     * 利用cookie实现访问次数
     * 获取cookie
     */
    Cookie[] cookies = request.getCookies();
    /**
     * 每访问一次都需要创建cookie，写入到一个变量中进行存储，响应到客户端才能从客户端拿到cookie
     * 声明一个变量
     */
    int count=1;
    Cookie cookie_count = new Cookie("count", +count + "");
    // 判断cookie是否为null，如果不是第一次比较好判断，只要找到name
    if (cookies!=null){
        for (Cookie cookie : cookies) {
            // 找name为count的cookie
            if ("count".equals(cookie.getName())){
                // 说明你不是第一次访问，需要当前次数加1
                count=Integer.parseInt(cookie.getValue())+1;
            }
        }
    }
    // 如果是第一次访问 上面的比对为false
    out.println("这是您第"+count+"访问了本网站，欢迎常来！");
    // 将count的值设置到cookie
    cookie_count.setValue(count+"");
    // 设置cookie的最大有效时间
    cookie_count.setMaxAge(Integer.MAX_VALUE);
    // 将cookie响应到客户端
    response.addCookie(cookie_count);
%>
</body>
</html>
