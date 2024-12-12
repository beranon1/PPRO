package com.example.ppro_projekt.repository;

import com.example.ppro_projekt.model.Cvik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvikRepository extends JpaRepository<Cvik, Long> {
    List<Cvik> findByPopis(String popis);
    List<Cvik> findByZamereni(String zamereni);
}
