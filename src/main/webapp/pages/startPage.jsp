<%@ page import="beans.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Asya
  Date: 08.12.2020
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) request.getSession().getAttribute("user");
%>
<html>
<head>
    <title>Библиотека</title>
</head>
<body>
    <h1>Добро пожаловать в библиотеку! Зайдите в систему</h1>
<%
    if (user == null) {
        out.print("<p>\n" +
                "        <a href=\"signin\">Войти в систему</a>\n" +
                "    </p>\n" +
                "    <p>\n" +
                "        <a href=\"signup\">Зарегистрироваться</a>\n" +
                "    </p>");
    }
%>
</body>
</html>
