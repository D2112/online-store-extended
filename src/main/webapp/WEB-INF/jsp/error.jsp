<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><%--<spring:message code="title.error"/>--%> ${statusCode}</title>
</head>
<body>
<div style="text-align: center;">
    <h1>
        ERROR: ${statusCode}
    </h1>
</div>
</body>
</html>
