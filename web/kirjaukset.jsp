<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pohja>
    <div class="dropdown">
        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Valitse projekti (dropdown ei toimi!)
            <span class="caret"></span></button>
        <ul class="dropdown-menu">
            <li>Ensimmäinen</li>
            <li>Toinen</li>
            <li>Kolmas</li>
        </ul>
        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Valitse työtehtävä (dropdown ei toimi!)
            <span class="caret"></span></button>
        <ul class="dropdown-menu">
            <li>Ensimmäinen</li>
            <li>Toinen</li>
            <li>Kolmas</li>
        </ul>
    </div>
    <div class="col-lg-6">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Työtunnit kokonaislukuna">
            <span class="input-group-btn">
                <button class="btn btn-default" type="button">Kirjaa</button>
            </span>
        </div>
    </div>
    <p>Popuppina kirjauksen vahvistus tai virheilmoitus. Sivujen rakenne vielä vähän hakusessa.</p>
</t:pohja>