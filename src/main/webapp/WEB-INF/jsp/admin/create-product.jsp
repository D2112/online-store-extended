<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="<c:url value="/static/js/ajax-common-methods.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/admin-ajax-requests.js"/>"></script>

<spring:message code="title.creating-product" var="titleMsg"/>
<spring:message code="creating-product.label.selectCategory" var="selectCategoryLabel"/>
<spring:message code="creating-product.label.name" var="nameLabel"/>
<spring:message code="creating-product.label.price" var="priceLabel"/>
<spring:message code="creating-product.label.description" var="descriptionLabel"/>


<page:genericPage title="${titleMsg}">
    <jsp:attribute name="leftSideBar">
        <page:adminSideBar/>
    </jsp:attribute>
    <jsp:body>
        <div class="management_form">
            <form:form id="createProductForm" commandName="createProductForm" action="/admin/create-product"
                       method="POST" enctype="multipart/form-data">
                <fieldset>
                    <legend><spring:message code="admin.label.header"/></legend>
                    <label>${selectCategoryLabel}
                        <form:select path="categoryName" form="createProductForm" id="categoryName">
                            <page:fillSelectMenuWithCategories/>
                        </form:select>
                    </label>
                    <label>
                            ${nameLabel}: <form:input path="productName" cssClass="product_input"/>
                    </label>
                    <label>
                            ${priceLabel}: <form:input path="price" cssClass="product_input"/>
                    </label>
                    <br/>
                    <br/>
                    <label>
                            ${descriptionLabel}: <form:textarea path="description" cssClass="product_description"/>
                    </label>
                    <br/>
                    <label> <spring:message code="creating-product.label.image"/>:
                        <input class="image_input" id="image" type="file" name="image"/>
                    </label>
                    <br/>

                    <div id="successResponse" class="response_success"></div>
                    <div id="errorResponse" class="error_message"></div>

                    <div class="create_product_btn">
                        <button id="createProductSubmit" onclick="createProduct(event, $('#createProductForm'))"
                                type="submit" form="createProductForm" class="base_button creating_product_button">
                            <spring:message code="creating-product.button.create"/>
                        </button>
                    </div>

                </fieldset>
            </form:form>
        </div>

    </jsp:body>
</page:genericPage>
