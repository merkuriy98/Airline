<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Регистрация</title>
    <meta charset="UTF-8">
</head>
<body>
<form method="POST" action="/entry">
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
            <td>Год
                <select name="year" size="1">
                    <c:forEach begin="1950" end="2018" var="i">
                        <option><c:out value='${i}'/></option>
                    </c:forEach>
                </select>
            </td>
            <td>Месяц
                <select name="month" size="1">
                    <c:forEach begin="1" end="12" var="i">
                        <option><c:out value='${i}'/></option>
                    </c:forEach>
                </select>
            </td>
            <td>День
                <select name="day" size="1">
                    <c:forEach begin="1" end="31" var="i">
                        <option><c:out value='${i}'/></option>
                    </c:forEach>
                </select>
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
