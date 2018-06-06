<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>TEST</title>
</head>
<body>
<h1>
    <c:out value='${requestScope["hello"]}'/>
</h1>
</body>
</html>
