<%@ tag description="Writes the HTML code for inserting a product view." %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="product" type="com.epam.store.model.Product" %>

<div class="prod_box">
    <div class="product_title">
        <c:out value="${product.name}"/>
    </div>
    <img src="<c:out value="image/${product.image.id}"/>" class="product_img" border="0"/>

    <div class="prod_details_tab">
        <page:detailsButton product="${product}"/>
        <page:addToCartButton product="${product}"/>
        <page:price value="${product.price.value}"/>
    </div>
</div>

