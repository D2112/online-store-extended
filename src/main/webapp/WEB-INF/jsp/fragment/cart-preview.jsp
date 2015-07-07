<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

${sessionScope.cart.productAmount} <spring:message code="cart-preview.label.items"/><br/>
<span class="border_cart"></span>
<spring:message code="cart-preview.label.total"/>
<span class="value"> <page:price value="${sessionScope.cart.totalPrice}"/> </span>
