<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="toolbar_all">
    <div class="toolbar_c">
        <a class="logo_link" href="${pageContext.request.contextPath}">
             <div class="logo">
                Группы
             </div>
        </a>
    </div>
    <div class="toolbar_u">
        <div class="user_name">
            ${user_name}(${user_id})
        </div>
        <div class="logout">
            <a href="/test-mvn-app/logout"><img src="${pageContext.request.contextPath}/resources/img/exit.png"></a>
        </div>
    </div>
</div>