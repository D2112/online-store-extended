<%@ tag description="Writes the HTML code for output managements menu." %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="title_box"><spring:message code="admin.label.management"/></div>
<ul class="list_menu">
    <li class="odd">
        <a href="<c:url value="/admin/create-product"/>"><spring:message code="admin.label.createProduct"/></a>
    </li>
    <li class="even">
        <a href="<c:url value="/admin/products"/>"><spring:message code="admin.label.products"/></a>
    </li>
    <li class="odd">
        <a href="<c:url value="/admin/categories"/>"><spring:message code="admin.label.categories"/></a>
    </li>
    <li class="even">
        <a href="<c:url value="/admin/users"/>"><spring:message code="admin.label.users"/></a>
    </li>
    <li class="odd">
        <a href="<c:url value="/admin/black-list"/>"><spring:message code="admin.label.blackList"/></a>
    </li>
</ul>