<%@tag description="displays black list table" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="blackList" required="true" type="java.util.Collection" %>

<div class="center_text">
    <table>
        <tr>
            <th><spring:message code="users.label.name"/></th>
            <th><spring:message code="users.label.email"/></th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${blackList}" var="user">
            <tr id="${user.id}">
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td width="130">
                    <a href="purchase-list/${user.id}"><spring:message code="users.label.seePurchaseList"/></a>
                </td>
                <td width="10">
                    <form method="POST" action="<c:url value="/admin/users/ban"/>">
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="hidden" name="banValue" value="false">
                        <button type="submit" onclick="setUserBanValue(event, '${user.id}', false)"
                                class="base_button"><spring:message code="users.button.unban"/></button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>