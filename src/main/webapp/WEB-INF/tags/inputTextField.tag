<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="label" %>
<%@ attribute name="name" %>
<%@ attribute name="form" required="true" %>
<%@ attribute name="value" required="false" %>

<label class="input_field">${label}
    <input type="text" name="${name}" value="${value}" form="${form}" class="product_input"/>
</label>
