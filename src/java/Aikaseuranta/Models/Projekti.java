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
    
    public List<Projekti> listaaProjektit() throws SQLException {
        String sql = "SELECT * FROM projekti ORDER BY projektin_nimi";
        Connection yhteys = Yhteys.muodostaYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        ResultSet rs = kysely.executeQuery();
        
        ArrayList<Projekti> lista = new ArrayList<Projekti>();
        
        if (rs.next()) {
            int id = rs.getInt("id");
            String projektinNimi = rs.getString("projektin_nimi");
            Date pvm = rs.getDate("pvm");
            Projekti projekti = new Projekti(id, projektinNimi, pvm);
            lista.add(projekti);
        }
        
        try {
            Yhteys.suljeYhteydet(rs, kysely, yhteys);
        } catch (Exception e) {
            
        }
        
        return lista;        
        
    }
    
    
}
