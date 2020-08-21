<%--
  Created by IntelliJ IDEA.
  User: hgmyh
  Date: 2020/8/21
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>查看所有用户信息</h1>
<table border="2px" align="center">
    <tr>
        <th>uid</th>
        <th>username</th>
        <th>password</th>
        <th>email</th>
        <th>age</th>
        <th>gender</th>
    </tr>

    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.uid}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>${user.age}</td>
            <td>${user.gender}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
