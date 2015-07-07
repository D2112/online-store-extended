<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="<c:url value="/static/js/ajax-common-methods.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/admin-ajax-requests.js"/>"></script>

<spring:message code="title.adminPanel" var="titleMsg"/>
<page:genericPage title="${titleMsg}">
    <jsp:attribute name="leftSideBar">
        <page:adminSideBar/>
    </jsp:attribute>
    <jsp:body>
        <c:choose>
            <c:when test="${users != null}">
                <page:usersTable users="${users}"/>
            </c:when>
            <c:when test="${blackList != null}">
                <page:blackListTable blackList="${blackList}"/>
            </c:when>
            <c:otherwise>
                <div class="center_text">
                    <h2><spring:message code="admin.message.chooseManagement"/></h2>
                </div>
            </c:otherwise>
        </c:choose>
    </jsp:body>
</page:genericPage>
