<%--
  Created by IntelliJ IDEA.
  User: kyle
  Date: 2021/8/8
  Time: 10:49 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <h1>Admin</h1>
</head>
<body>
    <h1>User Information: </h1>
    <c:forEach items="${userInfos}" var="userInfo">
        <p>${userInfo.toString()}</p>
    </c:forEach>

    <h1>User Records: </h1>
    <c:forEach items="${Records}" var="Record">
        <p>${Record.toString()}</p>
    </c:forEach>

    <h1>User Feedback: </h1>
    <c:forEach items="${feedBacks}" var="feedBack">
        <p>${feedBack.toString()}</p>
    </c:forEach>

    <c:url value="index.html" var="home" scope="request"></c:url>
    <a href="/<c:out value="${home}"/>"> Home</a>
</body>
</html>
