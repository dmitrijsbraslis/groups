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
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
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
<div class="content_w">
    <div class="misc_block">
        <a class="add_group_link" onClick="openPopUp();">
            <div class="add_group">
                <div class="add_group_img">
                </div>
                <div class="add_group_txt">
                    Создать группу
                </div>
            </div>
        </a>
    </div>
    <div class="content">
        <div class="header">
		    Groups
        </div>
        <div class="group_list">
            <c:forEach var="group" items="${allGroups}">
                <div class="group_card">
                    <a href="group/${group.id}">
                        <div class="group_image">
                            ${group.id}
                        </div>
                    </a>
                    <a href="group/${group.id}" class="group_link_txt">
                        ${group.name}
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<div id="popUp" class="popUp_w_close">
    <div class="popUp">
        <div class="popUp_cnt">
            <div class="popUp_title">
                Создать группу
            </div>
            <form action="" method="POST">
            <div class="create_group_form">
                <div class="form_i">
                    <div class="form_label">
                        <label for="name">Название</label>
                    </div>
                    <div class="form_field">
                        <input id="name" type="text" name="name" class="create_input">
                    </div>
                </div>
                <div class="form_i">
                    <div class="form_label">
                        <label for="description">Описание</label>
                    </div>
                    <div class="form_field">
                        <textarea id="description" rows="6" cols="35" name="description" class="create_txt"></textarea>
                    </div>
                </div>
                <div class="form_i">
                    <div class="form_label">
                        <label for="category">Тематика</label>
                    </div>
                    <div class="form_field">
                        <select id="category" name="category" class="create_select">
                            <c:forEach var="cat" items="${allCat}">
                                <option value="${cat.category}">${cat.text}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form_ii">
                    <input id="open" type="radio" checked="checked" value="true" name="is_open" class="radio">
                    <label for="open">открытая группа</label>
                </div>
                <div class="form_ii">
                    <input id="close" type="radio" value="false" name="is_open" class="radio">
                    <label for="close">закрытая группа</label>
                </div>
            </div>
            <div class="popUp_btm">
                <input type="submit" value="Создать" class="button">
                <a onClick="closePopUp();" class="close_form">Отменить</a>
            </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>