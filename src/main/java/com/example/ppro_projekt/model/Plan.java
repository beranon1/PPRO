package com.example.ppro_projekt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;


@Entity
@Table(name = "plans")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;

    @NotBlank(message = "Název musí být vyplněn")
    @Size(min = 3, message = "Nazev must be at least 5 characters long")
    private String nazev;
    
    private String popis;

    private String zamereni;

    private int dobaTrvani;

    @OneToMany(mappedBy = "plan")
    private List<Cvik> cviks;

    @OneToMany(mappedBy = "plan")
    private List<Jidelnicek> jidelniceks;

    public void setId(long id) {
        this.id = id;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public void setZamereni(String zamereni) {
        this.zamereni = zamereni;
    }

    public long getId() {
        return id;
    }

    public String getNazev() {
        return nazev;
    }

    public String getPopis() {
        return popis;
    }

    public String getZamereni() {
        return zamereni;
    }

    public List<Cvik> getCviks() {
        return cviks;
    }

    public void setCviks(List<Cvik> cviks) {
        this.cviks = cviks;
    }

    public int getDobaTrvani() {
        return dobaTrvani;
    }

    public void setDobaTrvani(int dobaTrvani) {
        this.dobaTrvani = dobaTrvani;
    }

    public List<Jidelnicek> getJidelniceks() {
        return jidelniceks;
    }

    public void setJidelniceks(List<Jidelnicek> jidelniceks) {
        this.jidelniceks = jidelniceks;
    }
}
