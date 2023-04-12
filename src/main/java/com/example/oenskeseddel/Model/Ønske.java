package com.example.oenskeseddel.Model;

public class Ønske {

    private String navn;
    private String beskrivelse;
    private String link;

    public Ønske(String navn, String beskrivelse, String link) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.link = link;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
