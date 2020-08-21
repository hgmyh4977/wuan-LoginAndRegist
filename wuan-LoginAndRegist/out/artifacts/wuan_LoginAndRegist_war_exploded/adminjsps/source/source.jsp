<%--
  Created by IntelliJ IDEA.
  User: hgmyh
  Date: 2020/8/21
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员页面</title>
</head>
<body>
<h1>欢迎您，管理员${session_admin.username}</h1>
<a href="${pageContext.request.contextPath}/AdminLogin">查看用户信息</a>
</body>
</html>
