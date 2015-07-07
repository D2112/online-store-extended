<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="<c:url value="/static/js/ajax-common-methods.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/user-ajax-requests.js"/>"></script>

<spring:message code="title.cart" var="titleMsg"/>
<page:genericPage title="${titleMsg}">
    <jsp:attribute name="leftSideBar">
        <page:userSideBar/>
    </jsp:attribute>
    <jsp:body>
        <div id="cart-table-content">
            <jsp:include page="/WEB-INF/jsp/fragment/cart-info-table.jsp"/>
        </div>
        <div id="successResponse" class="response_success"></div>
        <div id="errorResponse" class="error_message"></div>
    </jsp:body>
</page:genericPage>