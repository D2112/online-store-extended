<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:choose>
    <c:when test="${cart.productAmount != 0}">
        <page:cartInfoTable cart="${sessionScope.cart}"/>
    </c:when>
    <c:when test="${successMessage != null}">
        <page:message success="true" text="${successMessage}"/>
    </c:when>
    <c:otherwise>
        <spring:message code="cart.message.emptyCart" var="emptyCartMessage"/>
        <page:message text="${emptyCartMessage}"/>
    </c:otherwise>
</c:choose>
