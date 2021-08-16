<%--
  Created by IntelliJ IDEA.
  User: kyle
  Date: 2021/8/8
  Time: 7:28 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Record</title>
</head>
<body>
    <p>Quiz History</p>
    <c:forEach items="${userRecord}" var="Record">
        <p>${Record.toString()}</p>
    </c:forEach>

    <c:url value="index.html" var="home" scope="request"></c:url>
    <a href="/<c:out value="${home}"/>"> Home</a>
</body>

</html>
