<%@tag description="displays category management form" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="management_form">
    <page:findAndDisplayMessage/>
    <fieldset>
        <legend><spring:message code="adding-category.label.categories"/></legend>
        <form id="addCategory" action="<c:url value="categories/add"/>" method="POST">
            <spring:message code="category-adding.label.categoryName" var="categoryNameLabel"/>
            <page:inputTextField label="${categoryNameLabel}:" name="categoryName" value="${categoryName}"
                                 form="addCategory"/>
            <button type="submit" class="base_button">
                <spring:message code="category-adding.button.add"/>
            </button>
        </form>
        <br/>

        <form id="deleteCategory" action="<c:url value="categories/delete"/>" method="POST">
            <spring:message code="category-adding.label.selectToDelete" var="selectToDeleteLabel"/>
            <page:fillSelectMenuWithCategories form="deleteCategory" name="categoryName"
                                               label="${selectToDeleteLabel}:"/>
            <button type="submit" class="base_button">
                <spring:message code="category-adding.button.deleteCategory"/>
            </button>
        </form>
    </fieldset>
</div>