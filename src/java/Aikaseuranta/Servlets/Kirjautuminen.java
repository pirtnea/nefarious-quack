package Aikaseuranta.Servlets;

import Aikaseuranta.Models.Kayttaja;
import static Aikaseuranta.Models.Kayttaja.etsiKayttajatunnuksilla;
import static Aikaseuranta.Models.Roinat.asetaVirhe;
import static Aikaseuranta.Models.Roinat.naytaJSP;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Kirjautuminen extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Kayttaja k = new Kayttaja();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false);
        String salasana = request.getParameter("password");
        String kayttaja = request.getParameter("username");
        
        if (session != null) {
            session.invalidate();
        }
        
        session = request.getSession(true);        

        /* Jos kummatkin parametrit ovat null, käyttäjä ei ole edes yrittänyt vielä kirjautua. 
         * Näytetään pelkkä lomake */
        if (kayttaja == null && salasana == null) {
            naytaJSP("kirjautuminen.jsp", request, response);
            return;
        }

        //Tarkistetaan että vaaditut kentät on täytetty:
        if (kayttaja == null || kayttaja.equals("")) {
            asetaVirhe("Kirjautuminen epäonnistui! Et antanut käyttäjätunnusta.", request);
            naytaJSP("kirjautuminen.jsp", request, response);
            return;
        }

        /* Välitetään näkymille tieto siitä, mikä tunnus yritti kirjautumista */
        request.setAttribute("kayttaja", kayttaja);

        if (salasana == null || salasana.equals("")) {
            asetaVirhe("Kirjautuminen epäonnistui! Et antanut salasanaa.", request);
            naytaJSP("kirjautuminen.jsp", request, response);
            return;
        }

        k = etsiKayttajatunnuksilla(kayttaja, salasana);

        if (k != null) {
            //Tallennetaan istuntoon käyttäjäolio
            session.setAttribute("kirjautunut", k);
        }
        
        /* Tarkistetaan onko parametrina saatu oikeat tunnukset */
        if (k != null && kayttaja.equals(k.getKayttajatunnus()) && salasana.equals(k.getSalasana())) {
            /* Jos tunnus on oikea, ohjataan käyttäjä HTTP-ohjauksella kissalistaan. */
            response.sendRedirect("etusivu.jsp");
        } else {
            /* Väärän tunnuksen syöttänyt saa eteensä lomakkeen ja virheen.
             * Tässä käytetään omalta yläluokalta perittyjä yleiskäyttöisiä metodeja.
             */
            asetaVirhe("Kirjautuminen epäonnistui! Antamasi tunnus tai salasana on väärä.", request);
            naytaJSP("kirjautuminen.jsp", request, response);
        }

        /*if (kayttaja.equals(kayttaja) && salasana.equals(salasana)) {
         response.sendRedirect("etusivu.jsp");
         } else {
         request.setAttribute("virheViesti", "Kirjautuminen epäonnistui! Antamasi tunnus tai salasana on väärä.");
         request.setAttribute("kayttaja", kayttaja);
         naytaJSP("kirjautuminen.jsp", request, response);
         }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Kirjautuminen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Kirjautuminen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
