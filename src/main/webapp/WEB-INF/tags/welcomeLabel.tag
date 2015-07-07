<%@ tag description="Prints user's name" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="user" type="com.epam.store.model.User" %>

<div class="welcome_label">
    <c:choose>
        <c:when test="${empty user}">
            <label><spring:message code="main.label.notAuthorized"/></label><br>
            <a href="<c:url value="/login"/>"><spring:message code="main.label.login"/></a>
            <spring:message code="main.label.or"/>
            <a href="<c:url value="/registration"/>"><spring:message code="main.label.register"/></a>
        </c:when>
        <c:otherwise>
            <label><spring:message code="main.label.hello"/>, ${user.name}!</label><br>
            <a href="<c:url value="/logout"/>"><spring:message code="main.label.logout"/></a>
        </c:otherwise>
    </c:choose>
</div>
