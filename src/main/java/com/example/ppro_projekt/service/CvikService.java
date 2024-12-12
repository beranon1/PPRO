package com.example.ppro_projekt.service;

import com.example.ppro_projekt.model.Cvik;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CvikService {

    List<Cvik> getAllCviks();
    Cvik getCvikById(long id);
    void deleteCvikById(long id);
    void saveCvik(Cvik cvik);

}
