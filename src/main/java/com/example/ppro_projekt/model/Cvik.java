package com.example.ppro_projekt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="cviks")
public class Cvik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Název musí být vyplněn")
    @Size(min = 1, max = 50)
    private String nazev;

    @NotBlank
    private String popis;

    @NotBlank
    private String zamereni;


    private int pocetOpakovani;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    public Cvik(String nazev, String popis, String zamereni, int pocetOpakovani) {
        this.nazev = nazev;
        this.popis = popis;
        this.zamereni = zamereni;
        this.pocetOpakovani = pocetOpakovani;
    }

    public Cvik(){

    }

    public String getNazev(){
        return nazev;
    }
    public void setNazev(String nazev){
        this.nazev = nazev;
    }

    public String getPopis(){
        return popis;
    }

    public String getZamereni() {
        return zamereni;
    }

    public int getPocetOpakovani() {
        return pocetOpakovani;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public void setZamereni(String zamereni) {
        this.zamereni = zamereni;
    }

    public void setPocetOpakovani(int pocetOpakovani) {
        this.pocetOpakovani = pocetOpakovani;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Plan getPlan() {
        return plan;
    }
}
