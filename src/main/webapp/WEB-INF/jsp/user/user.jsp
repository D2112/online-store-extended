<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="title.profile" var="titleMsg"/>
<page:genericPage title="${titleMsg}">

    <jsp:attribute name="leftSideBar">
        <page:userSideBar/>
    </jsp:attribute>

    <jsp:body>

        <page:findAndDisplayMessage/> <%--changing password succesMessage--%>
        <page:userPersonalData user="${sessionScope.user}"/>
        <a href="<c:url value="/user/change-password"/>">
            <h2><spring:message code="profile.label.changePassword"/></h2>
        </a>
        <br/>
        <c:choose>
            <c:when test="${fn:length(purchaseList) > 0}">
                <h2><spring:message code="profile.label.orderList"/>:<h2>
                <page:purchaseList purchaseList="${purchaseList}"/>
            </c:when>
            <c:otherwise>
                <spring:message code="profile.label.orderListIsEmpty"/>
            </c:otherwise>
        </c:choose>

    </jsp:body>

</page:genericPage>
