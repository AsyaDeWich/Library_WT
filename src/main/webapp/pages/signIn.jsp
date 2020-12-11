<%--
  Created by IntelliJ IDEA.
  User: Asya
  Date: 11.12.2020
  Time: 5:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход в систему</title>
</head>
<body>
    <h1>Авторизация</h1>
    <form action="<%= request.getContextPath() %>" method="POST">
        <table>
            <tr>
                <td>Введите логин</td>
                <td><input type="login" name="login" required/></td>
            </tr>
            <tr>
                <td>Пароль</td>
                <td><input type="password" name="password" required/></td>
            </tr>
        </table>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
