package Aikaseuranta.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tyotehtava {
    
    private int id;
    private String nimi;
    private String kuvaus;

    public Tyotehtava() {
        
    }

    public Tyotehtava(String nimi, String kuvaus) {
        this.nimi = nimi;
        this.kuvaus = kuvaus;
    }

    public Tyotehtava(int id, String nimi, String kuvaus) {
        this.id = id;
        this.nimi = nimi;
        this.kuvaus = kuvaus;
    }

    public int getId() {
        return id;
    }

    public String getNimi() {
        return nimi;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }
    
    public void lisaaTyotehtava(Tyotehtava tyotehtava) throws SQLException {
        String sql = "INSERT INTO tehtava (tehtavan_nimi, kuvaus) VALUES (?, ?) RETURNING id";
        Connection yhteys = Yhteys.muodostaYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, tyotehtava.getNimi());
        kysely.setString(1, tyotehtava.getKuvaus());
        kysely.executeUpdate();
        kysely.close();
        yhteys.close();
    }
    
    public void poistaTyotehtava(String tyotehtava, String projekti) throws SQLException {
        String sql = "DELETE FROM tehtava WHERE tehtavan_nimi=? AND projektin_nimi=?";
        Connection yhteys = Yhteys.muodostaYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, tyotehtava);
        kysely.setString(2, projekti);
        kysely.executeUpdate();
        kysely.close();
        yhteys.close();
    }
}
