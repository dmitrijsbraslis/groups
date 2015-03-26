<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!DOCTYPE html>
<html>
<head>
    <title>Группы</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/resources/css/reset.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</head>
<body>
<div class="toolbar">
    <jsp:include page="toolbar.jsp"/>
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
        <div class="catalog_main">
            <ul class="catalog_ul">
                  <li class="catalog_li"><a class="catalog_link" href="/">Все</a></li>
                <c:forEach var="cat" items="${allCat}">
                  <li class="catalog_li"><a class="catalog_link" href="./${cat.category}">${cat.text}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="content">
        <div class="header">
            ${categoryName}
        </div>
        <c:if test="${empty groups}" >
            <div class="no_content" onClick="openPopUp();">
                В этой категории групп нет, но вы можете их создать!
            </div>
        </c:if>
        <c:if test="${not empty groups}" >
            <div class="group_list">
                <c:forEach var="myGroup" items="${groups}">
                    <div class="group_card">
                        <a href="group/${myGroup.id}">
                            <div class="group_image">
                                <img src="${pageContext.request.contextPath}/resources/img/group-interest190.png" class="no_avatar">
                            </div>
                        </a>
                        <a href="group/${myGroup.id}" class="group_link_txt">
                            ${myGroup.name}
                        </a>
                    </div>
                </c:forEach>
            </div>
        </c:if>
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