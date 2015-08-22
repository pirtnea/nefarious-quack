package Aikaseuranta.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        String sql = "INSERT INTO tehtava (tehtavan_nimi, kuvaus) VALUES (?,?) RETURNING id";
        Connection yhteys = Yhteys.muodostaYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, tyotehtava.getNimi());
        kysely.setString(2, tyotehtava.getKuvaus());
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
    
    public List<Tyotehtava> listaaTyotehtavat() throws SQLException {
        String sql = "SELECT * FROM tehtava ORDER BY tehtavan_nimi";
        Connection yhteys = Yhteys.muodostaYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        ResultSet rs = kysely.executeQuery();
        
        ArrayList<Tyotehtava> lista = new ArrayList<Tyotehtava>();
        
        if (rs.next()) {
            int tunnus = rs.getInt("id");
            String tehtavanNimi = rs.getString("tehtavan_nimi");
            String tehtavanKuvaus = rs.getString("kuvaus");
            Tyotehtava tehtava = new Tyotehtava(tunnus, tehtavanNimi, tehtavanKuvaus);
            lista.add(tehtava);
        }
        
        try {
            Yhteys.suljeYhteydet(rs, kysely, yhteys);
        } catch (Exception e) {
            
        }
        
        return lista;   
        
    }
    
    public List<String> listaaProjektinTyotehtavat(String projektinNimi) throws SQLException {
        String sql = "SELECT tehtavan_nimi FROM tehtava WHERE projektin_nimi=?";
        Connection yhteys = Yhteys.muodostaYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, projektinNimi);
        ResultSet rs = kysely.executeQuery();

        ArrayList<String> lista = new ArrayList<String>();
        
        if (rs.next()) {
            String tehtava = rs.getString("tehtavan_nimi");
            lista.add(tehtava);
        }
        
        try {
            Yhteys.suljeYhteydet(rs, kysely, yhteys);
        } catch (Exception e) {
            
        }
        
        return lista;
    
    }
}
