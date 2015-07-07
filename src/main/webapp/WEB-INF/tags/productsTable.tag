<%@ tag description="Writes HTML code to display cart's info box" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="categoryName" %>
<%@ attribute name="products" type="java.util.Collection" %>

<table>
    <tr>
        <th><spring:message code="cart.label.product"/></th>
        <th><spring:message code="cart.label.price"/></th>
        <th><spring:message code="product.button.details"/></th>
        <th><spring:message code="cart.label.delete"/></th>
    </tr>
    <form id="deleteProductsForm" action="<c:url value="/admin/products/delete"/>">
        <c:forEach var="product" items="${products}">
            <tr id="${product.id}">
                <td>${product.name}</td>
                <td><page:price value="${product.price.value}"/></td>
                <td>
                    <a href="<c:url value="/details/${product.id}"/>">
                        <spring:message code="product.button.details"/>
                    </a>
                </td>
                <td>
                    <label>
                        <input type="checkbox" form="deleteProductsForm" name="productIdToDelete"
                               value="${product.id}"/>
                    </label>
                </td>
            </tr>
        </c:forEach>
    </form>
    <tr>
        <th colspan="3"></th>
        <th width="60">
            <button type="submit" onclick="deleteProducts(event)" form="deleteProductsForm" class="base_button">
                <spring:message code="cart.button.delete"/>
            </button>
        </th>
    </tr>
</table>