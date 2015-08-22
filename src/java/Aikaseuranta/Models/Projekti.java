package Aikaseuranta.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Projekti {
    
    private int id;
    private String nimi;
    private Date pvm;
    
    public Projekti() {
        
    }
    
    public Projekti(String nimi, Date pvm) {
        this.nimi = nimi;
        this.pvm = pvm;
    }
    
    public Projekti(int id, String nimi, Date pvm) {
        this.id = id;
        this.nimi = nimi;
        this.pvm = pvm;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNimi() {
        return nimi;
    }
    
    public Date getPvm() {
        return pvm;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    public void setPvm(Date pvm) {
        this.pvm = pvm;
    }
    
    public Projekti getProjekti(String projektinNimi) throws SQLException {
        String sql = "SELECT * FROM projekti WHERE projektin_nimi=?";
        Connection yhteys = Yhteys.muodostaYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, projektinNimi);
        ResultSet rs = kysely.executeQuery();
        
        Projekti projekti = null;
        
        if (rs.next()) {
            int tunnus = rs.getInt("id");
            String projektin_nimi = rs.getString("projektin_nimi");
            Date paivamaara = rs.getDate("pvm");
            projekti = new Projekti(tunnus, projektinNimi, paivamaara);            
        }
        
        try {
            Yhteys.suljeYhteydet(rs, kysely, yhteys);
        } catch (Exception e) {
            
        }
        
        return projekti;

    }
    
    public List<Projekti> listaaProjektit() throws SQLException {
        String sql = "SELECT * FROM projekti ORDER BY projektin_nimi";
        Connection yhteys = Yhteys.muodostaYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        ResultSet rs = kysely.executeQuery();
        
        ArrayList<Projekti> lista = new ArrayList<Projekti>();
        
        if (rs.next()) {
            int tunnus = rs.getInt("id");
            String projektinNimi = rs.getString("projektin_nimi");
            Date paivamaara = rs.getDate("pvm");
            Projekti projekti = new Projekti(tunnus, projektinNimi, paivamaara);
            lista.add(projekti);
        }
        
        try {
            Yhteys.suljeYhteydet(rs, kysely, yhteys);
        } catch (Exception e) {
            
        }
        
        return lista;        
        
    }
    
    public void lisaaTyontekijaProjektiin(String projektinNimi, String kayttajatunnus) throws SQLException {
        String sql = "INSERT INTO kayttajan_projektit VALUES (?,?)";
        Connection yhteys = Yhteys.muodostaYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, projektinNimi);
        kysely.setString(2, kayttajatunnus);
        kysely.executeUpdate();
        kysely.close();
        yhteys.close();
    }
    
    public void poistaTyontekijaProjektista(String projektinNimi, String kayttajatunnus) throws SQLException {
        String sql = "DELETE FROM kayttajan_projektit WHERE projektin_nimi=? AND kayttajatunnus=?";
        Connection yhteys = Yhteys.muodostaYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, projektinNimi);
        kysely.setString(2, kayttajatunnus);
        kysely.executeUpdate();
        kysely.close();
        yhteys.close();
    }
}


