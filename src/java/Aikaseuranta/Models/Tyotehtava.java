package Aikaseuranta.Models;

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
}
