<%@ tag description="Writes the HTML code for inserting a date." pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ attribute name="date" required="true" %>

<span class="value">
    <joda:format value="${date}" pattern="dd/MM/yyyy"/>
</span>