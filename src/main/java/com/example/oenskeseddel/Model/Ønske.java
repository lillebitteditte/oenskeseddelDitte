package com.example.oenskeseddel.Model;

public class Ønske {

    private String navn;
    private String beskrivelse;
    private String linke;

    public Ønske(String navn, String beskrivelse, String linke) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.linke = linke;
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

    public String getLinke() {
        return linke;
    }

    public void setLinke(String linke) {
        this.linke = linke;
    }

}
