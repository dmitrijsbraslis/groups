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
<div style="width: 715px;">
	<div style="border-bottom: 1px solid #8b9fa4; font-size: 18px; line-height: 1.5; font-family: Arial,Helvetica,sans-serif;">
		Groups
	</div>
</div>
<div style="margin-top: 20px; width: 715px;">
    <c:forEach var="group" items="${allGroups}">
        <a href="group/${group.id}"><div style="width: 128px; height: 128px; border: 1px solid; display: inline-block; line-height: 3; text-align: center; font-size: 40px; font-family: Arial,Helvetica,sans-serif; color: gray;">
        ${group.id}
        </div></a>
    </c:forEach>
</div>
</body>
</html>