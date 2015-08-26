package Aikaseuranta.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KayttajanProjektit {

    private String kayttajatunnus;
    private String projektinNimi;

    public KayttajanProjektit() {

    }

    public KayttajanProjektit(String kayttajatunnus, String projektinNimi) {
        this.kayttajatunnus = kayttajatunnus;
        this.projektinNimi = projektinNimi;
    }

    public String getKayttajatunnus() {
        return kayttajatunnus;
    }

    public String getProjektinNimi() {
        return projektinNimi;
    }

    public void setKayttajatunnus(String kayttajatunnus) {
        this.kayttajatunnus = kayttajatunnus;
    }

    public void setProjektinNimi(String projektinNimi) {
        this.projektinNimi = projektinNimi;
    }

    public List<String> listaaKayttajanProjektit(String kayttajatunnus) throws SQLException {
        String sql = "SELECT projektin_nimi FROM kayttajan_projektit WHERE kayttajatunnus=?";
        Connection yhteys = Yhteys.muodostaYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, kayttajatunnus);
        ResultSet rs = kysely.executeQuery();

        ArrayList<String> lista = new ArrayList<String>();

        if (rs.next()) {
            String projektin_nimi = rs.getString("projektin_nimi");
            lista.add(projektin_nimi);
            //System.out.println(projektin_nimi+"bööööööööööööööööööööööööööööö");
            Yhteys.suljeYhteydet(rs, kysely, yhteys);
            return lista;
        }

        try {
            Yhteys.suljeYhteydet(rs, kysely, yhteys);
        } catch (Exception e) {

        }

        return null;
    
    }
}
