<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><spring:message code="title.registration"/></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/registration-style.css"/>"/>
    <script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="<c:url value="/static/js/user-ajax-requests.js"/>"></script>
</head>
<body>
<div align="center" class="registration_box">
    <h1><spring:message code="registration.label.header"/></h1>
    <hr>
    <spring:message code="registration.placeholder.name" var="namePlaceholder"/>
    <spring:message code="registration.placeholder.name" var="namePlaceholder"/>
    <spring:message code="registration.placeholder.email" var="emailPlaceholder"/>
    <spring:message code="registration.placeholder.password" var="passwordPlaceholder"/>
    <spring:message code="registration.placeholder.confirmPassword" var="confirmPasswordPlaceholder"/>
    <spring:message code="registration.button.submit" var="submitButton"/>

    <form:form id="registrationForm" method="POST" commandName="registrationForm" action="registration">
        <form:input placeholder="${namePlaceholder}" path="name"/>
        <form:input placeholder="${emailPlaceholder}" path="email"/>
        <form:password placeholder="${passwordPlaceholder}" path="password"/>
        <form:password placeholder="${confirmPasswordPlaceholder}" path="passwordConfirm"/>
        <button type="submit" onclick="submitRegistration(event)" class="button">${submitButton}</button>
    </form:form>
    <br/>

    <div id="response" class="error_message"></div>
</div>
</body>
</html>