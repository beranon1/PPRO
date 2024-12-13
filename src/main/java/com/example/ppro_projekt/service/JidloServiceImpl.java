package com.example.ppro_projekt.service;

import com.example.ppro_projekt.model.Cvik;
import com.example.ppro_projekt.model.Jidlo;
import com.example.ppro_projekt.repository.JidloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JidloServiceImpl implements JidloService {

    JidloRepository jidloRepository;
    @Autowired
    public JidloServiceImpl(JidloRepository jidloRepository) {
        this.jidloRepository = jidloRepository;
    }

    @Override
    public List<Jidlo> getAllJidlos() {
        return jidloRepository.findAll();
    }

    @Override
    public Jidlo getJidloById(long id) {
        return jidloRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteJidloById(long id) {
        Optional<Jidlo> jidlo = jidloRepository.findById(id);
        if (jidlo.isPresent()) {
            jidloRepository.delete(jidlo.get());
        }
    }

    @Override
    public void saveJidlo(Jidlo jidlo) {
    jidloRepository.save(jidlo);
    }
}
