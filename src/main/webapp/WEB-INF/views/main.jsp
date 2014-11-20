<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!DOCTYPE html>
<html>
<head>
    <title>Группы</title>
    <link href="${pageContext.request.contextPath}/resources/css/reset.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" type="text/css">

</head>
<body>
<div class="toolbar">
    <jsp:include page="toolbar.jsp"/>
</div>
<div class="content_w">
    <div class="misc_block">

    </div>
    <div class="content">
        <div style="font-size: 25px; line-height: 28px; color: #333; font-family: Arial,Helvetica,sans-serif;">
            Group ID: ${groupName}
        </div>
        <div style="font-family: Arial,Helvetica,sans-serif; margin-top: 10px;">
            <a href="" style="font-size: 15px; color: #333; text-decoration: none; padding-right: 10px;">Лента</a>
            <a href="${groupId}/themes" style="font-size: 15px; color: #333; text-decoration: none; padding-right: 10px;">Темы</a>
            <a href="${groupId}/photos" style="font-size: 15px; color: #333; text-decoration: none; padding-right: 10px;">Фотогрфии</a>
            <a href="${groupId}/users" style="font-size: 15px; color: #333; text-decoration: none; padding-right: 10px;">Участники</a>
            <a href="${groupId}/links" style="font-size: 15px; color: #333; text-decoration: none;">Ссылки</a>
        </div><br><br><br><br>
        <div id="calendar"></div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/calendar.js"></script>
</body>
</html>
