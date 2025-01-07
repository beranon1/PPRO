package com.example.ppro_projekt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "jidelniceks")
public class Jidelnicek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;

    @NotBlank(message = "Název musí být vyplněn")
    @Size(min = 1, max = 50)
    private String nazev;

    private String zamereni;

    private String obdobi;

    @OneToMany(mappedBy = "jidelnicek")
    private List<Jidlo> jidlos;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;


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

    public String getZamereni() {
        return zamereni;
    }

    public void setZamereni(String zamereni) {
        this.zamereni = zamereni;
    }

    public String getObdobi() {
        return obdobi;
    }

    public void setObdobi(String obdobi) {
        this.obdobi = obdobi;
    }

    public List<Jidlo> getJidlos() {
        return jidlos;
    }

    public void setJidlos(List<Jidlo> jidlos) {
        this.jidlos = jidlos;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
