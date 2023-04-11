package com.example.oenskeseddel.Model;

public class Bruger {
    private int bruger_id;
    private String fornavn;
    private String efternavn;

    public Bruger(int bruger_id, String fornavn, String efternavn) {
        this.bruger_id = bruger_id;
        this.fornavn = fornavn;
        this.efternavn = efternavn;

    }

    public int getBruger_id() {
        return bruger_id;
    }

    public void setBruger_id(int bruger_id) {
        this.bruger_id = bruger_id;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }
}
