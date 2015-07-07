<%@tag description="displays creating product form" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${categories}" var="category">
    <option value="${category.name}">${category.name}</option>
</c:forEach>

