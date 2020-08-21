<%--
  Created by IntelliJ IDEA.
  User: hgmyh
  Date: 2020/8/21
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h1>注册</h1>
<font color="red">${msg}</font>
<form action="${pageContext.request.contextPath}/Regist" method="post">
    用户名:<input type="text" name="username" value="${user.username}"/><font color="red">${errors.username}</font><br/>
    密码:<input type="password" name="password" value="${user.password}"/><font color="red">${errors.password}</font><br/>
    邮箱:<input type="text" name="email" value="${user.email}"/><font color="red">${errors.email}</font><br/>
    年龄:<input type="text" name="age" value="${user.age}"/><font color="red">${errors.age}</font><br/>
    性别:男<input type="radio" name="gender" value="male" checked="checked" /> 女<input type="radio" name="gender" value="female"/><br/>
    <input type="submit" value="注册" />
</form>
</html>
