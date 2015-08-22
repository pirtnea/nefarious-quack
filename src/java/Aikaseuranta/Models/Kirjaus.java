package Aikaseuranta.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Kirjaus {
    
    private int id;
    private Date pvm;
    private double tunnit;
    private String tyotehtava;
    private String projektinNimi;
    private String kayttajatunnus;

    public Kirjaus() {
        
    }

    public Kirjaus(Date pvm, double tunnit, String tyotehtava, String projektinNimi, String kayttajatunnus) {
        this.pvm = pvm;
        this.tunnit = tunnit;
        this.tyotehtava = tyotehtava;
        this.projektinNimi = projektinNimi;
        this.kayttajatunnus = kayttajatunnus;
    }

    public Kirjaus(int id, Date pvm, double tunnit, String tyotehtava, String projektinNimi, String kayttajatunnus) {
        this.id = id;
        this.pvm = pvm;
        this.tunnit = tunnit;
        this.tyotehtava = tyotehtava;
        this.projektinNimi = projektinNimi;
        this.kayttajatunnus = kayttajatunnus;
    }

    public int getId() {
        return id;
    }

    public Date getPvm() {
        return pvm;
    }

    public double getTunnit() {
        return tunnit;
    }

    public String getTyotehtava() {
        return tyotehtava;
    }

    public String getProjektinNimi() {
        return projektinNimi;
    }

    public String getKayttajatunnus() {
        return kayttajatunnus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPvm(Date pvm) {
        this.pvm = pvm;
    }

    public void setTunnit(double tunnit) {
        this.tunnit = tunnit;
    }

    public void setTyotehtava(String tyotehtava) {
        this.tyotehtava = tyotehtava;
    }

    public void setProjektinNimi(String projektinNimi) {
        this.projektinNimi = projektinNimi;
    }

    public void setKayttajatunnus(String kayttajatunnus) {
        this.kayttajatunnus = kayttajatunnus;
    }
    
    public void lisaaKirjaus(Kirjaus kirjaus) throws SQLException {
        String sql = "INSERT INTO VALUES (?,?,?,?,?) RETURNING id";
        Connection yhteys = Yhteys.muodostaYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setDate(1, (java.sql.Date) kirjaus.getPvm());
        kysely.setDouble(2, kirjaus.getTunnit());
        kysely.setString(3, kirjaus.getTyotehtava());
        kysely.setString(4, kirjaus.getProjektinNimi());
        kysely.setString(5, kirjaus.getKayttajatunnus());
        kysely.executeUpdate();
        kysely.close();
        yhteys.close();
    }
}
