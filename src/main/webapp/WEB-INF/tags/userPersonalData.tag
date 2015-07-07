<%@ tag description="Writes the HTML code for inserting a tab menu." %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="user" type="com.epam.store.model.User" %>

<h2><spring:message code="profile.label.yourName"/>: ${user.name}</h2>

<h2><spring:message code="profile.label.yourEmail"/>: ${user.email}</h2>
