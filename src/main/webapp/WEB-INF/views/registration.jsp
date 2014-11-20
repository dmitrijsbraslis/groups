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
    <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="toolbar">
    <div class="toolbar_c">
        <a class="logo_link" href="${pageContext.request.contextPath}">
            <div class="logo">
                Группы
            </div>
        </a>
    </div>
</div>
<div class="login">
    <div class="post_form">
        <form action="" method="POST">
            <div><input type="text" name="name" value="Имя" class="login_input" onfocus="if(value=='Имя') value = ''" onblur="if(value=='') value = 'Имя'"></div>
            <div><input type="text" name="surname" value="Фамилия" class="login_input" onfocus="if(value=='Фамилия') value = ''" onblur="if(value=='') value = 'Фамилия'"></div>
            <div><input type="text" name="login" value="Логин" class="login_input" onfocus="if(value=='Логин') value = ''" onblur="if(value=='') value = 'Логин'"></div>
            <div><input type="password" name="password" value="Пароль" class="login_input" onfocus="if(value=='Пароль') value = ''" onblur="if(value=='') value = 'Пароль'"></div>
            <div class="login_buttons"><input type="submit" class="login_btn" value="Зарегестрироваться"></div>
        </form>
    </div>
</div>
</body>
</html>