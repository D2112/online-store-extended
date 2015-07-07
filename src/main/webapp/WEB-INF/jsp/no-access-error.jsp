<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<page:genericPage title="The Suspicious Shop">
    <jsp:attribute name="leftSideBar">
        <page:userSideBar/>
    </jsp:attribute>
    <jsp:body>
        <div style="text-align: center;">
            <h1><spring:message code="error.message.noAccess"/></h1>
        </div>
    </jsp:body>
</page:genericPage>