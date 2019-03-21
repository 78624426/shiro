<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\3\21 0021
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/regist" method="post">
        <input name="name"><br>
        <input type="password" name="pass"><br>
        <input type="submit"><span style="color: red;">${err}</span>
    </form>
</body>
</html>
