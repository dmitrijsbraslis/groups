<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!DOCTYPE html>
<html>
<head>
    <title>Группы</title>
    <link href="${pageContext.request.contextPath}/resources/css/reset.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="login">
    <div class="post_form">
        <form action="login" method="POST">
            <div class="login_image"><img src="${pageContext.request.contextPath}/resources/img/groups190.png" class="group_logo"></div>
            <div><input name="login" type="text" value="Логин" class="login_input" onfocus="if(value=='Логин') value = ''" onblur="if(value=='') value = 'Логин'"></div>
            <div><input name="password" type="password" value="Пароль" class="login_input" onfocus="if(value=='Пароль') value = ''" onblur="if(value=='') value = 'Пароль'"></div>
            <div class="login_buttons"><input type="submit" class="login_btn" value="Войти"><a href="registration" class="login_register">Регистрация</a></div>
        </form>
    </div>
</div>
</body>
</html>
