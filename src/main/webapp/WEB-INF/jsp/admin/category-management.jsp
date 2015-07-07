<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="<c:url value="/static/js/ajax-common-methods.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/admin-ajax-requests.js"/>"></script>

<spring:message code="title.category-management" var="titleMsg"/>
<page:genericPage title="${titleMsg}">
    <jsp:attribute name="leftSideBar">
        <page:adminSideBar/>
    </jsp:attribute>
    <jsp:body>
        <div class="management_form">
            <fieldset>
                <legend><spring:message code="adding-category.label.categories"/></legend>
                <form id="addCategoryForm" action="<c:url value="categories/add"/>">
                    <spring:message code="category-adding.label.categoryName" var="categoryNameLabel"/>

                    <label>${categoryNameLabel}
                        <input type="text" id="categoryToAdd" value="${categoryName}" form="addCategoryForm"
                               class="product_input"/>
                    </label>

                    <button type="submit" class="base_button"
                            onclick="addCategory(event, $('#addCategoryForm'), $('#categoryToAdd'))">
                        <spring:message code="category-adding.button.add"/>
                    </button>
                </form>
                <br/>

                <form id="deleteCategoryForm" action="<c:url value="categories/delete"/>">
                    <spring:message code="category-adding.label.selectToDelete" var="selectToDeleteLabel"/>

                    <label>${selectToDeleteLabel}
                        <select form="deleteCategoryForm" id="categoryToDeleteSelect">
                            <page:fillSelectMenuWithCategories/>
                        </select>
                    </label>

                    <button type="submit" class="base_button"
                            onclick="deleteCategory(event, $('#deleteCategoryForm'), $('#categoryToDeleteSelect'))">
                        <spring:message code="category-adding.button.deleteCategory"/>
                    </button>
                </form>

                <div id="successResponse" class="response_success"></div>
                <div id="errorResponse" class="error_message"></div>

            </fieldset>
        </div>
    </jsp:body>
</page:genericPage>

