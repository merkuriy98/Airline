<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Регистрация</title>
    <meta charset="UTF-8">
</head>
<body>
<form method="POST" action="/registration">
    <table>
        <tr>
            <td>Имя</td>
            <td><input type="text" name="firstName" pattern="(?U)[A-aА-я]" required></td>
        </tr>
        <tr>
            <td>Фамилия</td>
            <td><input type="text" name="lastName" pattern="(?U)\\w" required></td>
        </tr>
        <tr>
            <td>Логин</td>
            <td><input type="text" name="login" pattern="(?U)\\w" required></td>
        </tr>
        <tr>
            <td>Дата Рождения</td>
            <td>
                <input type="date" name="date">
            </td>
        </tr>
        <tr>
            <td>Телефон</td>
            <td><input type="text" name="phone" pattern="+\\d{12}"></td>
        </tr>
        <tr>
            <td>Пароль</td>
            <td><input type="password" name="pass1" min="4"></td>
        </tr>
        <tr>
            <td>Повторите пароль</td>
            <td><input type="password" name="pass2" min="4"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Регистрация" name="registration">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
