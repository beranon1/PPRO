package com.example.ppro_projekt.repository;

import com.example.ppro_projekt.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByColor(String color);
    List<Car> findByTankVolumeBetween(double min, double max);
}
