<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="message"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Työaikaseuranta</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./css/bootstrap.css" rel="stylesheet">
        <link href="./css/bootstrap-theme.css" rel="stylesheet">
        <link href="./css/main.css" rel="stylesheet">
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="./js/bootstrap.js"></script>
    </head>

    <div class="container">
        <jsp:doBody/>
        <c:if test="${virheViesti != null}">
            <div class="alert alert-danger">${virheViesti}</div>
        </c:if>
    </div>
</html>