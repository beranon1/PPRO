package com.example.ppro_projekt.service;

import com.example.ppro_projekt.model.Jidlo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JidloService {

    List<Jidlo> getAllJidlos();
    Jidlo getJidloById(long id);
    void deleteJidloById(long id);
    void saveJidlo(Jidlo jidlo);
}
