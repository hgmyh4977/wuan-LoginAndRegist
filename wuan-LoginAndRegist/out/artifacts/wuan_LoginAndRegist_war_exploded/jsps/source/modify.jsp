<%--
  Created by IntelliJ IDEA.
  User: hgmyh
  Date: 2020/8/21
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改用户信息</title>
</head>
<body>
<h1>修改用户信息</h1>
<font color="red">${msg}</font>
<form action="${pageContext.request.contextPath}/Modify" method="post">
    <input type="hidden" name="uid" value="${session_user.uid}"/>
    用户名:<input type="text" readonly="readonly" name="username" value="${session_user.username}"/><font color="red">${errors.username}</font><br/>
    密码:<input type="password" name="password" value="${session_user.password}"/><font color="red">${errors.password}</font><br/>
    邮箱:<input type="text" name="email" value="${session_user.email}"/><font color="red">${errors.email}</font><br/>
    年龄:<input type="text" name="age" value="${session_user.age}"/><font color="red">${errors.age}</font><br/>
    <c:choose>
        <c:when test="${session_user.gender eq 'male'}">
            性别:男<input type="radio" name="gender" value="male" checked="checked" /> 女<input type="radio" name="gender" value="female"/><br/>
        </c:when>
        <c:otherwise>
            性别:男<input type="radio" name="gender" value="male"  /> 女<input type="radio" name="gender" value="female" checked="checked"/><br/>
        </c:otherwise>
    </c:choose>
    <input type="submit" value="修改" />
</form>
</body>
</html>
