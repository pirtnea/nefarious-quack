<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="message"%>

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
    <body>
        <nav class="navbar navbar-default">
            <h1 class="navbar-text">Projektin työaikaseuranta</h1>
            <a href="/Aikaseuranta/kirjautuminen.jsp" class="navbar-link navbar-right">Kirjaudu ulos</a>
        </nav>
        <ul class="nav nav-pills">
            <li><a href="/Aikaseuranta/etusivu.jsp">Etusivu</a></li>
            <li><a href="/Aikaseuranta/projektit.jsp">Projektinhallinta</a></li>
            <li><a href="/Aikaseuranta/raportit.jsp">Raportit</a></li>
            <li><a href="/Aikaseuranta/kirjaukset.jsp">Kirjaukset</a></li>
        </ul>
        <div class="container">
            <jsp:doBody/>
        </div>
    </body>
</html>