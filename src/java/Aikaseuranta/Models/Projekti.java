package Aikaseuranta.Models;

import java.util.Date;

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
}
