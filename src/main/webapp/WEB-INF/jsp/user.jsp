<%--
  Created by IntelliJ IDEA.
  User: Рома
  Date: 13.06.2018
  Time: 4:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Uset test</title>
</head>
<body>
<table border="1">
    <c:forEach items='${user}' var="j">
        <tr>
            <c:out value='${j.firstName}'/>
        </tr>
    </c:forEach>
</table>
</body>
</html>
