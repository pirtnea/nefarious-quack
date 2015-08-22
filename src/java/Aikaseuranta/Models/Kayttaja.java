package Aikaseuranta.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        String sql = "SELECT kayttajatunnus, salasana FROM kayttaja WHERE kayttajatunnus = ? AND salasana = ?";
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
            Yhteys.suljeYhteydet(rs, kysely, yhteys);
        } catch (Exception e) {
            
        }

        //Käyttäjä palautetaan vasta täällä, kun resurssit on suljettu onnistuneesti.
        return kirjautunut;
    }
    
    public List<Kayttaja> listaaKayttajat() throws SQLException {
        String sql = "SELECT * FROM kayttaja ORDER BY kayttajatunnus";
        Connection yhteys = Yhteys.muodostaYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        ResultSet rs = kysely.executeQuery();
        
        ArrayList<Kayttaja> lista = new ArrayList<Kayttaja>();
        
        if (rs.next()) {
            int tunnus = rs.getInt("id");
            String enimi = rs.getString("etunimi");
            String snimi = rs.getString("sukunimi");
            String knimi = rs.getString("kayttajatunnus");
            String ssana = rs.getString("salasana");
            String kayttajanRooli = rs.getString("rooli");
            Kayttaja kayttaja = new Kayttaja(tunnus, enimi, snimi, knimi, ssana, kayttajanRooli);
            lista.add(kayttaja);
        }
        
        try {
            Yhteys.suljeYhteydet(rs, kysely, yhteys);
        } catch (Exception e) {
            
        }
        
        return lista;   
        
    }
    
    public List<String> listaaProjektinTyotekijat(String projektinNimi) throws SQLException {
        String sql = "SELECT kayttajatunnus FROM kayttajan_projektit WHERE projektin_nimi=?";
        Connection yhteys = Yhteys.muodostaYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, projektinNimi);
        ResultSet rs = kysely.executeQuery();
        
        ArrayList<String> lista = new ArrayList<String>();
        
        if (rs.next()) {
            String kayttaja = rs.getString("kayttajatunnus");
            lista.add(kayttaja);
        }
        
        try {
            Yhteys.suljeYhteydet(rs, kysely, yhteys);
        } catch (Exception e) {
            
        }
        
        return lista;
    
    }
}
