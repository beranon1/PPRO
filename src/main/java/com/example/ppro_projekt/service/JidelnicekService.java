package com.example.ppro_projekt.service;

import com.example.ppro_projekt.model.Jidelnicek;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JidelnicekService {
    List<Jidelnicek> getAllJidelniceks();
    Jidelnicek getJidelnicekById(long id);
    void deleteJidelnicekById(long id);
    void saveJidelnicek(Jidelnicek jidlo);

}
