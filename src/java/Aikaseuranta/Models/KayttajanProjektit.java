package Aikaseuranta.Models;

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
}
