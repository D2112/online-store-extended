<%@ tag description="Writes HTML code to display cart info box" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="cart" type="com.epam.store.model.Cart" %>

<form id="deleteProductsForm" method="POST" action="<c:url value="/deleteFromCart"/>">
    <table>
        <tr>
            <th><spring:message code="cart.label.product"/></th>
            <th><spring:message code="cart.label.category"/></th>
            <th><spring:message code="cart.label.price"/></th>
            <th><spring:message code="cart.label.delete"/></th>
        </tr>
        <c:forEach var="product" items="${cart.products}">
            <tr id="${product.id}">
                <td><a href="<c:url value="details/${product.id}"/>">${product.name}</a></td>
                <td>${product.category.name}</td>
                <td><page:price value="${product.price.value}"/></td>
                <td>
                    <label>
                        <input type="checkbox" form="deleteProductsForm" name="productIdToDelete"
                               value="${product.id}"/>
                    </label>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <th colspan="2"><spring:message code="cart.label.total"/>:</th>
            <th><page:price value="${cart.totalPrice}"/></th>
            <th width="60">
                <button type="submit" onclick="deleteProducts(event)" form="deleteProductsForm" class="base_button">
                    <spring:message code="cart.button.delete"/>
                </button>
            </th>
        </tr>
    </table>
</form>

<form method="POST" action="<c:url value="/user/confirmOrder"/>">
    <div class="center_text" style="padding-top: 20px">
        <button type="submit" onclick="confirmOrder(event)" class="base_button creating_product_button">
            <spring:message code="cart.button.confirm"/>
        </button>
    </div>
</form>


