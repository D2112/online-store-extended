<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="<c:url value="/static/js/ajax-common-methods.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/user-ajax-requests.js"/>"></script>

<page:genericPage title="The Suspicious Shop">
    <jsp:attribute name="leftSideBar">
        <page:userSideBar/>
    </jsp:attribute>
    <jsp:body>
        <page:displayProducts products="${products}"/>
    </jsp:body>
</page:genericPage>



