<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pohja>
        <h1>Aktiivinen projekti</h1>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Henkilöstö</th>
                        <th>Työtehtävä</th>
                        <th>Viimeisin kirjaus</th>
                        <th>Työtunnit yhteensä</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>tembo</td>
                        <td>Koodaaminen</td>
                        <td>1.1.1990</td>
                        <td>10</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>pine</td>
                        <td>Väsyminen</td>
                        <td>1.1.1990</td>
                        <td>30</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>pine</td>
                        <td>Hajoaminen</td>
                        <td>10.6.1994</td>
                        <td>30</td>
                    </tr>
                </tbody>
            </table>
            <a href="/Aikaseuranta/html-demo/muokkausdemo.html"><button type="button" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span> Muokkaa</button></a>
            <h2>Projektivalikko</h2>
            <div class="panel panel-default">
                <ul class="nav">
                    <li class="active"><a href="#">Ensimmäinen</a></li>
                    <li><a href="#">Toinen</a></li>
                    <li><a href="#">Kolmas linkki projektiin</a></li>
                </ul>
            </div>
</t:pohja>