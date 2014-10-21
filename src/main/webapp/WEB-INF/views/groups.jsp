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
<div class="content_w">
    <div class="misc_block">

    </div>
    <div class="content">
        <div class="header">
		    Groups
        </div>
        <div class="group_list">
            <c:forEach var="group" items="${allGroups}">
                <div class="group_card">
                    <a href="group/${group.id}"><div style="width: 128px; height: 128px; border: 1px solid; display: inline-block; line-height: 3; text-align: center; font-size: 40px; font-family: Arial,Helvetica,sans-serif; color: gray;">
                    ${group.id}
                    </div></a>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>