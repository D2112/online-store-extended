<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><spring:message code="title.register-success"/></title>
</head>
<body>
<div style="text-align: center;">
    <h1><spring:message code="registration-success.label.successHeader"/></h1>
    <label>
        <a href="<c:url value="/login"/>"><spring:message code="registration-success.label.login"/></a>
    </label>
</div>
</body>
</html>
