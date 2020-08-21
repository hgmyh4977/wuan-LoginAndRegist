<%--
  Created by IntelliJ IDEA.
  User: hgmyh
  Date: 2020/8/21
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>msg</title>
</head>
<body>
<h1>${msg}</h1>
<a href="${pageContext.request.contextPath}/jsps/login.jsp">登录</a>
<a href="${pageContext.request.contextPath}/jsps/regist.jsp">注册</a>
<a href="${pageContext.request.contextPath}/jsps/source/source.jsp">资源</a>
<a href="${pageContext.request.contextPath}/jsps/source/user.jsp">查看用户信息</a>
</body>
</html>
