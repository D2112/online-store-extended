<%@ tag description="Writes the HTML code for details button" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="product" type="com.epam.store.model.Product" %>


<form method="GET" action="<c:url value="/details/${product.id}"/>">
    <button type="submit" class="details_button">
        <spring:message code="product.button.details"/>
    </button>
</form>
