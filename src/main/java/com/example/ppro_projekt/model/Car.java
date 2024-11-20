package com.example.ppro_projekt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 7, max = 7)
    private String spz;

    @NotBlank
    private String color;

    @Min(value = 30)
    @Max(value = 100)
    private float tankVolume;

    @Min(value = 2)
    @Max(value = 10)
    private int numberOfSeats;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    public Car(String spz, String color, float tankVolume, int numberOfSeats) {
        this.spz = spz;
        this.color = color;
        this.tankVolume = tankVolume;
        this.numberOfSeats = numberOfSeats;
    }

    public Car (){

    }

    public String getSpz(){
        return spz;
    }
    public void setSpz(String spz){
        this.spz = spz;
    }

    public String getColor(){
        return color;
    }

    public float getTankVolume() {
        return tankVolume;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTankVolume(float tankVolume) {
        this.tankVolume = tankVolume;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Driver getDriver() {
        return driver;
    }
}
