<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Регистрация</title>
    <meta charset="UTF-8">
</head>
<body>
<form method="POST">
    <table>
        <tr>
            <td>Имя</td>
            <td><input type="text" name="firstName"  pattern="(?U)[A-aА-я]" required <c:if test="${not empty param.firstName}">value='<c:out value="${param.firstName}"/>'</c:if>></td>
        </tr>
        <tr>
            <td>Фамилия</td>
            <td><input type="text" name="lastName" <c:if test="${not empty param.lastName}"> value='<c:out value="${param.lastName}"/>'</c:if> pattern="(?U)\\w" required></td>
        </tr>
        <tr>
            <td>Логин</td>
            <td><input type="text" name="login"  <c:if test="${not empty param.login}"> value='<c:out value="${param.login}"/>'</c:if> pattern="(?U)\\w" required></td>
        </tr>
        <tr>
            <td>Дата Рождения</td>
            <td>
                <input type="date" name="birthday" <c:if test="${not empty param.birthday}"> value='<c:out value="${param.birthday}"/>'</c:if> >
            </td>
        </tr>
        <tr>
            <td>Телефон</td>
            <td><input type="text" name="phone" <c:if test="${not empty param.phone}"> value='<c:out value="${param.phone}"/>'</c:if> pattern="+\\d{12}"></td>
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
            <td><select name="role">
                <c:forEach var="role" items="${roleService.roles}">
                    <option <c:if test="${param.role eq role}"> selected </c:if>>
                        <c:out value="${role}"/>
                    </option>
                </c:forEach>
            </select></td>
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
