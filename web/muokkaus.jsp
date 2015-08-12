<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pohja>
        <div class="input-group">
            <span class="input-group-addon" id="basic-addon1">Projektin nimi</span>
            <input type="text" class="form-control" aria-describedby="basic-addon1">
        </div>
        <div class="input-group">
            <span class="input-group-addon" id="basic-addon1">Kuvaus</span>
            <input type="text" class="form-control" aria-describedby="basic-addon1">
        </div>
        <div class="container">
            <ul>
                <li>Mahdolliset</li>
                <li>työtehtävät</li>
                <li>projektissa.</li>
            </ul>
        </div>
        <div class="btn-group" role="group">
            <button type="button" class="btn btn-default">Lisää työtehtävä</button>
            <button type="button" class="btn btn-default">Tallenna</button>
            <button type="button" class="btn btn-default">Poista</button>
        </div>
</t:pohja>