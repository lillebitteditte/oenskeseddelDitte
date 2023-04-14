package com.example.oenskeseddel.Model;

public class Ønske {

    private String navn;
    private String beskrivelse;
    private String link;
    private int bruger_id;

    public Ønske(String navn, String beskrivelse, String link, int bruger_id) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.link = link;
        this.bruger_id = bruger_id;
    }

    public Ønske(String navn, String beskrivelse, String link) {

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

    public int getBruger_id() {
        return bruger_id;
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

    public void setBruger_id(int bruger_id) {
        this.bruger_id = bruger_id;
    }

}
