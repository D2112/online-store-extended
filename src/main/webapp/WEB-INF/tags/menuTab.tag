<%@ tag description="Writes the HTML code for inserting a tab menu." pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="menu">
    <a href="<c:url value="/"/>" class="nav"> <spring:message code="menu.label.home"/> </a>

    <c:if test="${empty sessionScope.user}">
        <a href="<c:url value="/login"/>" class="nav"><spring:message code="menu.label.login"/></a>
    </c:if>

    <c:if test="${not empty sessionScope.user}">
        <a href="<c:url value="/user"/>" class="nav"><spring:message code="menu.label.profile"/></a>
    </c:if>

    <c:if test="${sessionScope.user.role.name == 'Admin'}">
        <a href="<c:url value="/admin"/>" class="nav"><spring:message code="menu.label.adminPanel"/></a>
    </c:if>

    <a href="<c:url value="/changeLang?language=ru_RU"/>" class="nav_lang"> <img src="<c:url value="/static/img/rus.jpg"/>"> </a>
    <a href="<c:url value="/changeLang?language=en"/>" class="nav_lang"> <img src="<c:url value="/static/img/en.gif"/>"> </a>
</div>