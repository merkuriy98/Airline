<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<body>
<h1>Вход в систему</h1>
<form action="/entry" method="POST">
    <table>
        <tr>
            <td>Логин:</td>
            <td><input type="text" name="login" pattern="(?U)\\w" required><br></td>
        </tr>
        <tr>
            <td>Пароль</td>
            <td><input type="password" name="password" min="4"><br><br></td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="entry" value="Войти">
            </td>
        </tr>
    </table>
</form>

<form method="post" action="registration.jsp">
    <input type="submit" value="Регистрация" />
</form>
</body>
</html>
