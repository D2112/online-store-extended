<%@ tag description="Writes HTML code to display cart's info box" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="cart" type="com.epam.store.model.Cart" %>

<div class="shopping_cart">
    <div class="title_box"><spring:message code="cart-preview.label.cart"/></div>
    <div id="cart-preview-info" class="cart_details">
        ${cart.productAmount} <spring:message code="cart-preview.label.items"/><br/>
        <span class="border_cart"></span>
        <spring:message code="cart-preview.label.total"/>
        <span class="value"> <page:price value="${cart.totalPrice}"/> </span>
    </div>
    <div class="cart_icon">
        <a href="<c:url value="/cart"/>">
            <img src="<c:url value="/static/img/cart.png"/>" alt="" width="75" height="75" border="0"/>
        </a>
    </div>
</div>

<%--
<div class="shopping_cart">
    <div class="title_box"><spring:message code="cart-preview.label.cart"/></div>
    <div class="cart_details">
        ${cart.productAmount} <spring:message code="cart-preview.label.items"/><br/>
        <span class="border_cart"></span>
        <spring:message code="cart-preview.label.total"/>
        <span class="value"> <page:price value="${cart.totalPrice}"/> </span>
    </div>
    <div class="cart_icon">
        <a href="<c:url value="/cart"/>">
            <img src="<c:url value="/static/img/cart.png"/>" alt="" width="75" height="75" border="0"/>
        </a>
    </div>
</div>--%>
