<%--
  Created by IntelliJ IDEA.
  User: kyle
  Date: 2021/8/8
  Time: 1:47 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Result</title>
</head>
<body>
    <p>User name: ${userName}</p><br>
    <p>Score: ${score}</p><br>
    <p>Pass: ${isPass}</p><br>
    <p>User answer(N for blank):</p><br>
    <c:forEach varStatus="loop" begin="1" end="10" step="1">
        <p>Question ${loop.count}: User answer: ${answer[loop.count - 1]} Correct answer: ${trueAnswer[loop.count - 1]}</p>
    </c:forEach>
    <br>

    <c:url value="quiz" var="home" scope="request">
        <c:param name="goHome" value="true" />
    </c:url>
    <a href="/<c:out value="${home}"/>"> Home</a>

    <c:url value="quiz" var="another_quiz" scope="request">
        <c:param name="reset" value="true" />
    </c:url>
    <a href="/<c:out value="${another_quiz}"/>">Another quiz</a>
</body>
</html>
