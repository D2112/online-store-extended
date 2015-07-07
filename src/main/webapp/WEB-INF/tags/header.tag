<%@ tag description="Writes the HTML code for inserting a tab menu." pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="header">
    <div class="language">
        <spring:message code="main.label.languages"/>:
        <a href="<c:url value="/changeLang?lang=en"/>"><img src="<c:url value="/static/img/en.gif"/>"/></a>
        <a href="<c:url value="/changeLang?lang=ru"/>"><img src="<c:url value="/static/img/rus.jpg"/>"/></a>
    </div>
</div>