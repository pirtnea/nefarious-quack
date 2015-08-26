<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pohja>
    <body>
        <h2>Olet kirjautuneena käyttäjänä ${kirjautunut.kayttajatunnus}.</h2>

        <table>
            <th>Projektit</th>
                <c:forEach var="projekti" items="${kayttajanProjektit}">
                <tr>
                    <td>${projekti}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</t:pohja>
