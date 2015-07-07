<%@ tag description="Writes the HTML code for adding to cart button" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="product" type="com.epam.store.model.Product" %>

<form id="addToCartForm" method="POST" action="<c:url value="/addToCart/${product.id}"/>">
    <button type="submit" onclick="addToCart(event)" class="buy_button">
        <spring:message code="product.button.add"/>
    </button>
</form>
