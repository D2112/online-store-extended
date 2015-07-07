<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><spring:message code="title.changePassword"/></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/registration-style.css"/>"/>
</head>
<body>
<div align="center" class="registration_box">
    <h1><spring:message code="change-password.label.header"/></h1>
    <hr>
    <spring:message code="change-password.placeholder.oldPassword" var="oldPasswordPlaceholder"/>
    <spring:message code="change-password.placeholder.newPassword" var="newPasswordPlaceholder"/>
    <spring:message code="change-password.placeholder.confirmNewPassword" var="confirmNewPasswordPlaceholder"/>
    <form action="<c:url value="changePassword"/>" method="post">
        <input type="password" name="oldPassword" placeholder="${oldPasswordPlaceholder}" required="true"/>
        <input type="password" name="newPassword" placeholder="${newPasswordPlaceholder}" required="true"/>
        <input type="password" name="confirmNewPassword" placeholder="${confirmNewPasswordPlaceholder}"
               required="true"/>
        <span><button type="submit" class="button"><spring:message
                code="change-password.button.submit"/></button></span>
    </form>
    <c:forEach items="${errors}" var="error">
        <br/>
        <h4><span class="error_message">${error}</span></h4>
    </c:forEach>
</div>
</body>
</html>
