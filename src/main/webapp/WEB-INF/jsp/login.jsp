<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><spring:message code="title.login"/></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/registration-style.css"/>"/>
</head>
<body>
<div align="center" class="registration_box">
    <h1><spring:message code="login.label.header"/></h1>

    <spring:message code="login.placeholder.email" var="emailPlaceholder"/>
    <spring:message code="login.placeholder.password" var="passwordPlaceholder"/>

    <form id="loginForm" action="<c:url value="/login"/>" method="post">
        <hr>
        <input type="text" name="email" placeholder="${emailPlaceholder}" value="<c:out value="${email}"/>" required/>
        <input type="password" name="password" placeholder="${passwordPlaceholder}" required/>
        <button type="submit" class="button"><spring:message code="login.button.submit"/></button>
    </form>

    <a href="<c:url value="/registration"/>"><spring:message code="login.label.register"/></a>

    <c:if test="${loginFailed == true}">
        <h4><span style="color: red;"> <spring:message code="login.error.loginFailed"/> </span></h4>
    </c:if>
</div>
</body>
</html>