<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="defaultValue" required="false" %>
<%@ attribute name="formName" required="false" %>

<select form="${formName}" name="purchaseStatus">
    <option value="Delivery"><spring:message code="status.Delivery"/></option>
    <option value="Canceled"><spring:message code="status.Canceled"/></option>
    <option value="Paid"><spring:message code="status.Paid"/></option>
    <option value="Unpaid"><spring:message code="status.Unpaid"/></option>
    <option selected><spring:message code="status.${defaultValue}"/></option>
</select>