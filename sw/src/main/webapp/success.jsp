<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\3\21 0021
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>登录成功</h1>
    <shiro:guest>
        游客访问,<a href="${pageContext.request.contextPath}/login.jsp">登录</a>
    </shiro:guest>

    <%--如果已经登录，则进行授权--%>
    <shiro:authenticated>
        欢迎你：<shiro:principal/><a href="${pageContext.request.contextPath}/logout">注销</a>
    </shiro:authenticated>
</body>
</html>
