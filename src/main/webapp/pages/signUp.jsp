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
    <title>Регистрация</title>
</head>
<body>
    <h1>Регистрация</h1>
    <form action="<%= request.getContextPath() %>" method="post">
        <table>
            <tr>
                <td>Логин</td>
                <td><input type="text" name="login" required/></td>
            </tr>
            <tr>
                <td>Имя</td>
                <td><input type="text" name="firstName" required/></td>
            </tr>
            <tr>
                <td>Фамилия</td>
                <td><input type="text" name="lastName" required/></td>
            </tr>
            <tr>
                <td>Возраст</td>
                <td><input type="text" name="age" required/></td>
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
