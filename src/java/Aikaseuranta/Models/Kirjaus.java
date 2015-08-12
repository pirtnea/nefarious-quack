package Aikaseuranta.Models;

import java.util.Date;

public class Kirjaus {
    
    private int id;
    private Date pvm;
    private int tunnit;
    private String tyotehtava;
    private String projektinNimi;
    private String kayttajatunnus;
    private String kuvaus;

    public Kirjaus() {
        
    }

    public Kirjaus(Date pvm, int tunnit, String tyotehtava, String projektinNimi, String kayttajatunnus) {
        this.pvm = pvm;
        this.tunnit = tunnit;
        this.tyotehtava = tyotehtava;
        this.projektinNimi = projektinNimi;
        this.kayttajatunnus = kayttajatunnus;
    }

    public Kirjaus(int id, Date pvm, int tunnit, String tyotehtava, String projektinNimi, String kayttajatunnus, String kuvaus) {
        this.id = id;
        this.pvm = pvm;
        this.tunnit = tunnit;
        this.tyotehtava = tyotehtava;
        this.projektinNimi = projektinNimi;
        this.kayttajatunnus = kayttajatunnus;
        this.kuvaus = kuvaus;
    }

    public int getId() {
        return id;
    }

    public Date getPvm() {
        return pvm;
    }

    public int getTunnit() {
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

    public String getKuvaus() {
        return kuvaus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPvm(Date pvm) {
        this.pvm = pvm;
    }

    public void setTunnit(int tunnit) {
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

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }  
}
