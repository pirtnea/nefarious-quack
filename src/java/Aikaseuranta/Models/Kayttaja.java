package Aikaseuranta.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Kayttaja {

    private int id;
    private String etunimi;
    private String sukunimi;
    private String kayttajatunnus;
    private String salasana;
    private String rooli;

    public Kayttaja() {

    }

    public Kayttaja(String kayttajatunnus, String salasana) {
        this.kayttajatunnus = kayttajatunnus;
        this.salasana = salasana;
    }

    public Kayttaja(int id, String etunimi, String sukunimi, String kayttajatunnus, String salasana, String rooli) {
        this.id = id;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.kayttajatunnus = kayttajatunnus;
        this.salasana = salasana;
        this.rooli = rooli;
    }

    public int getId() {
        return id;
    }

    public String getEtunimi() {
        return etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public String getKayttajatunnus() {
        return kayttajatunnus;
    }

    public String getSalasana() {
        return salasana;
    }

    public String getRooli() {
        return rooli;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public void setKayttajatunnus(String kayttajatunnus) {
        this.kayttajatunnus = kayttajatunnus;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }

    public void setRooli(String rooli) {
        this.rooli = rooli;
    }

    //materiaalin valmis metodi testaukseen
    public static Kayttaja etsiKayttajatunnuksilla(String kayttaja, String salasana) throws SQLException {
        System.out.println(kayttaja);
        System.out.println(salasana);
        String sql = "SELECT kayttajatunnus, salasana from kayttaja where kayttajatunnus = ? AND salasana = ?";
        Connection yhteys = Yhteys.muodostaYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, kayttaja);
        kysely.setString(2, salasana);
        ResultSet rs = kysely.executeQuery();

        //Alustetaan muuttuja, joka sisältää löydetyn käyttäjän
        Kayttaja kirjautunut = null;

        //next-metodia on kutsuttava aina, kun käsitellään 
        //vasta kannasta saatuja ResultSet-olioita.
        //ResultSet on oletuksena ensimmäistä edeltävällä -1:llä rivillä.
        //Kun sitä kutsuu ensimmäisen kerran siirtyy se ensimmäiselle riville 0.
        //Samalla metodi myös palauttaa tiedon siitä onko seuraavaa riviä olemassa.
        if (rs.next()) {
            //Kutsutaan sopivat tiedot vastaanottavaa konstruktoria 
            //ja asetetaan palautettava olio:
            kirjautunut = new Kayttaja();
            kirjautunut.setKayttajatunnus(rs.getString("kayttajatunnus"));
            kirjautunut.setSalasana(rs.getString("salasana"));
        }

        //Jos kysely ei tuottanut tuloksia käyttäjä on nyt vielä null.
        //Suljetaan kaikki resurssit:        
        try {
            rs.close();
        } catch (Exception e) {

        }

        try {
            kysely.close();
        } catch (Exception e) {

        }

        try {
            yhteys.close();
        } catch (Exception e) {

        }

        //Käyttäjä palautetaan vasta täällä, kun resurssit on suljettu onnistuneesti.
        return kirjautunut;
    }
}
