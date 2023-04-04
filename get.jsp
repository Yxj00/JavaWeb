<%--
  Created by IntelliJ IDEA.
  User: 啊
  Date: 2023/4/3
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=request.getContextPath()%>/js/jquery-1.12.4.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button>发送ajax请求</button>
</body>
<script>
    $("button").click(function (){
        //发送ajax
        $.ajax({
            //请求方式
            type:"GET",
            // 请求路径
            url:"<%=request.getContextPath()%>/get?username=zhangsan&password=123456",
            //请求成功后回调函数，参数data就是服务器返回的结果
            success:function (data){
                alert(data.userInfo)
            },

            dataType:"json"
        });
    });
</script>
</html>
