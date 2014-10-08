<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!DOCTYPE html>
<html>
<head>
    <title>Группы</title>
</head>
<body>
Group ID: ${groupid}<br>

<a href="">Лента</a><br>
<a href="${groupid}/themes">Темы</a><br>
<a href="${groupid}/photos">Фотогрфии</a><br>
<a href="${groupid}/users">Участники</a><br>
<a href="${groupid}/links"></a><br>


</body>
</html>
