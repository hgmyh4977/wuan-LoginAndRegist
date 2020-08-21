<%--
  Created by IntelliJ IDEA.
  User: hgmyh
  Date: 2020/8/21
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>资源</title>
</head>
<body>
<h1>欢迎您！${sessionScope.session_user.username}</h1>
资源页面<br/>
<hr/>
<form action="${pageContext.request.contextPath}/jsps/source/user.jsp" method="post">
    <input type="submit" value="查看用户信息">
</form>
<form action="${pageContext.request.contextPath}/jsps/source/modify.jsp" method="post">
    <input type="submit" value="修改用户信息">
</form>
<form action="${pageContext.request.contextPath}/Logout" method="post">
    <input type="submit" value="退出登录">
</form>
</body>
</html>
