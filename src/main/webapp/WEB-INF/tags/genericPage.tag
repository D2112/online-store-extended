<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@attribute name="title" fragment="false" required="false" %>
<%@attribute name="leftSideBar" fragment="true" required="false" %>
<%@attribute name="rightSideBar" fragment="true" required="false" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/style.css"/>"/>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <title>LK</title>
</head>
<body>

<page:menuTab/>

<jsp:invoke fragment="leftSideBar"/>

<div class="center_content">
    <jsp:doBody/>
</div>

</body>
</html>
