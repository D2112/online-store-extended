<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ attribute name="purchaseList" required="true" type="java.util.Collection" %>

<div class="center_text">
    <table>
        <tr>
            <th> Name</th>
            <th> Price</th>
            <th><spring:message code="order-list.label.status"/></th>
            <th> Quantity</th>
            <th> Date</th>
        </tr>
        <c:forEach items="${purchaseList}" var="purchase">
            <tr>
                <td width="550">${purchase.product.name}</td>
                <td><page:price value="${purchase.price.value}"/></td>
                <td><spring:message code="status.${purchase.status.name}"/></td>
                <td>${purchase.quantity}</td>
                <td> <joda:format value="${purchase.date}" pattern="dd/MM/yyyy"/> </td>
            </tr>
        </c:forEach>
    </table>
</div>