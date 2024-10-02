package com.example.ppro_projekt.model;

public class Car {
    private int id = -1;
    private String spz;
    private String color;
    private float tankVolume;
    private int numberOfSeats;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}