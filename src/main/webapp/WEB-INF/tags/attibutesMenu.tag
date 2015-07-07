<%@tag description="displays attriutes input menu" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="input_field">
    <label><spring:message code="creating-product.label.attributes"/>:<br></label>
    <table class="attributes_table">
        <tr>
            <th><spring:message code="creating-product.label.attributeName"/></th>
            <th><spring:message code="creating-product.label.value"/></th>
        </tr>
        <tr>
            <th><input form="creatingProduct" type="text" name="attributeNames" class="attribute_input"/></th>
            <th><input form="creatingProduct" type="text" name="attributeValues" class="attribute_input"/></th>
        </tr>
        <tr>
            <th colspan="2">
                <button form="creatingProduct" formaction="<c:url value="creating-product/setAttributesAmount"/>"
                        type="submit" class="base_button">
                    <spring:message code="creating-product.button.setAttributesNumber"/>
                </button>
                <input form="creatingProduct" type="number" name="attributesAmount"
                       value="${attributesAmount}" min="0" max="20"/>
            </th>
        </tr>
    </table>
</div>
