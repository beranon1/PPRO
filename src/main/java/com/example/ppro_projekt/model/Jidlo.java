package com.example.ppro_projekt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="jidlos")
public class Jidlo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Název musí být vyplněn")
    @Size(min = 1, max = 50)
    private String nazev;

    private int mnozstvi;

    private int bilkoviny;

    private int sachardy;

    @ManyToOne
    @JoinColumn(name = "jidelnicek_id")
    private Jidelnicek jidelnicek;

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

    public Jidelnicek getJidelnicek() {
        return jidelnicek;
    }

    public void setJidelnicek(Jidelnicek jidelnicek) {
        this.jidelnicek = jidelnicek;
    }
}
