package Aikaseuranta.Models;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Roinat extends HttpServlet {

    public Roinat() {

    }

    public static void naytaJSP(String sivu, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Kayttaja kirjautunut = (Kayttaja) request.getSession().getAttribute("kirjautunut");

        if (kirjautunut != null) {
            request.setAttribute("kayttajaKirjautunut", kirjautunut.getKayttajatunnus());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(sivu);
        dispatcher.forward(request, response);
    }

    public static void asetaVirhe(String virheViesti, HttpServletRequest request) {
        request.setAttribute("virheViesti", virheViesti);  
    }

    public static boolean onkoKirjautunut(HttpServletRequest request, HttpServletResponse response) {
        Kayttaja k = (Kayttaja) request.getSession().getAttribute("kirjautunut");

        if (k == null) {
            return false;
        } else {
            return true;
        }
    }
}
