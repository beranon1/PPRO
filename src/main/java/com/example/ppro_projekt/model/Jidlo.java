package com.example.ppro_projekt.model;

import jakarta.persistence.*;

@Entity
@Table(name="jidlos")
public class Jidlo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nazev;
    private int mnozstvi;
    private int bilkoviny;
    private int sachardy;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    public Jidlo(long id, String nazev, int mnozstvi, int bilkoviny, int sachardy) {
        this.id = id;
        this.nazev = nazev;
        this.mnozstvi = mnozstvi;
        this.bilkoviny = bilkoviny;
        this.sachardy = sachardy;
    }

    public Jidlo() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public int getMnozstvi() {
        return mnozstvi;
    }

    public void setMnozstvi(int mnozstvi) {
        this.mnozstvi = mnozstvi;
    }

    public int getBilkoviny() {
        return bilkoviny;
    }

    public void setBilkoviny(int bilkoviny) {
        this.bilkoviny = bilkoviny;
    }

    public int getSachardy() {
        return sachardy;
    }

    public void setSachardy(int sachardy) {
        this.sachardy = sachardy;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
