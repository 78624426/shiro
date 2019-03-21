<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\3\21 0021
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input placeholder="用户名" name="name"><br>
        <input type="password" name="pass"><br>
        <input type="submit"><span style="color: red;">${msg}</span>
    </form>
</body>
</html>
