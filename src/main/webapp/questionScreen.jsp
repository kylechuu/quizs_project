<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kyle
  Date: 2021/8/2
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Exam</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $('.slectOne').on('change', function() {
                $('.slectOne').not(this).prop('checked', false);
                $('#result').html($(this).data( "id" ));
                if($(this).is(":checked"))
                    $('#result').html($(this).data( "id" ));
                else
                    $('#result').html('Empty...!');
            });
        });
    </script>
</head>
<body>
    <form action = "quiz" method = "GET">
        <p>Question ${currentPage + 1}: </p>
        <p>${question}</p>
        <input id="prodId" name="currentPage" type="hidden" value="${currentPage}">

        <c:forEach items="${optionList}" var="option">
            <c:if test="${answer[currentPage] == option}">
                <input type="radio" class="selectOne" name="questionId" value="${option}" checked="checked"> ${option}<br>
            </c:if>
            <c:if test="${answer[currentPage] != option}">
                <input type="radio" class="selectOne" name="questionId" value="${option}"> ${option}<br>
            </c:if>
        </c:forEach>

        <c:if test="${currentPage > 0}">
            <input type="submit" name="movePage" value="Back">
        </c:if>
        <c:if test="${currentPage < 9}">
            <input type="submit" name="movePage" value="Next">
        </c:if>
        <input type="submit" name="movePage" value="Submit">

        <br>

        <c:forEach varStatus="loop" begin="1" end="10" step="1">
            <input type="submit" name="movePage" value="${loop.count}">
        </c:forEach>
    </form>
</body>
</html>
