<%@tag description="displays creating product form" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<spring:message code="creating-product.label.selectCategory" var="selectCategoryLabel"/>
<spring:message code="creating-product.label.name" var="nameLabel"/>
<spring:message code="creating-product.label.price" var="priceLabel"/>
<spring:message code="creating-product.label.description" var="descriptionLabel"/>

<div class="management_form">
    <div align="center">
        <page:findAndDisplayMessage/>
        <page:displayErrors errors="${errors}"/>
    </div>
    <form id="creatingProduct" action="<c:url value="creating-product/create"/>" method="POST"
          enctype="multipart/form-data">
        <fieldset>
            <legend><spring:message code="admin.label.header"/></legend>
            <page:fillSelectMenuWithCategories form="creatingProduct" name="categoryName"
                                               label="${selectCategoryLabel}:"/>
            <page:inputTextField label="${nameLabel}:" name="productName" value="${productName}"
                                 form="creatingProduct"/>
            <page:inputTextField label="${priceLabel}:" name="price" value="${price}"
                                 form="creatingProduct"/>

            <page:inputTextArea label="${descriptionLabel}:" inputName="description" value="${description}"
                                formName="creatingProduct" maxLength="1024"/>
            <br/>
            <label class="input_field"> <spring:message code="creating-product.label.image"/>:
                <input type="file" name="image"/>
            </label>
            <br/>
            <page:attibutesMenu/>
            <div class="center_text" style="padding-top: 20px">
                <button type="submit" form="creatingProduct" class="base_button creating_product_button">
                    <spring:message code="creating-product.button.create"/>
                </button>
            </div>
        </fieldset>
    </form>
</div>


