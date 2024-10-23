package com.example.ppro_projekt.model;

import jakarta.validation.constraints.*;

public class Driver {

    private int id = -1;

    @NotBlank(message = "Name is required")
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 90, message = "Age must not exceed 90")
    private int age;

    @Min(value = 10000, message = "Salary must be at least 10 000")
    @Max(value = 80000, message = "Salary must not exceed 80 000")
    private int salary;


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }
}
