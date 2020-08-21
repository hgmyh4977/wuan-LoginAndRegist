<%--
  Created by IntelliJ IDEA.
  User: hgmyh
  Date: 2020/8/21
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
<h1>用户信息</h1>
用户名:<input type="text" readonly="readonly" name="username" value="${session_user.username}"/><font color="red">${errors.username}</font><br/>
邮箱:<input type="text" name="email" readonly="readonly"  value="${session_user.email}"/><font color="red">${errors.email}</font><br/>
年龄:<input type="text" name="age" readonly="readonly"  value="${session_user.age}"/><font color="red">${errors.age}</font><br/>
<c:choose>
    <c:when test="${session_user.gender eq 'male'}">
        性别:男<input type="radio" name="gender" value="male" checked="checked"/>
    </c:when>
    <c:otherwise>
        性别:女<input type="radio" name="gender" value="female" checked="checked"/><br/>
    </c:otherwise>
</c:choose>
<form action="${pageContext.request.contextPath}/jsps/source/modify.jsp" method="post">
    <input type="submit" value="修改用户信息">
</form>
<form action="${pageContext.request.contextPath}/Logout" method="post">
    <input type="submit" value="退出登录">
</form>
</body>
</html>
