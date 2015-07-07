<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="label" %>
<%@ attribute name="inputName" %>
<%@ attribute name="formName" required="false" %>
<%@ attribute name="value" required="false" %>
<%@ attribute name="maxLength" required="false" %>

<div class="input_field">
    <label>${label}<br/>
        <textarea form="${formName}" class="product_description" name="${inputName}"
                  maxlength="${maxLength}">${value}</textarea>
    </label>
</div>