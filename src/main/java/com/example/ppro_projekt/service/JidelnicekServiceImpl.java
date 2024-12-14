package com.example.ppro_projekt.service;

import com.example.ppro_projekt.model.Jidelnicek;
import com.example.ppro_projekt.model.Plan;
import com.example.ppro_projekt.repository.JidelnicekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JidelnicekServiceImpl implements JidelnicekService {

    JidelnicekRepository jidelnicekRepository;

    @Autowired
    public JidelnicekServiceImpl(JidelnicekRepository jidelnicekRepository) {
        this.jidelnicekRepository = jidelnicekRepository;
    }

    @Override
    public List<Jidelnicek> getAllJidelniceks() {
        return jidelnicekRepository.findAll();
    }

    @Override
    public Jidelnicek getJidelnicekById(long id) {
        return jidelnicekRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteJidelnicekById(long id) {
        Optional<Jidelnicek> jidelnicek = jidelnicekRepository.findById(id);
        if (jidelnicek.isPresent()) {
            jidelnicekRepository.delete(jidelnicek.get());
        }
    }

    @Override
    public void saveJidelnicek(Jidelnicek jidelnicek) {
        jidelnicekRepository.save(jidelnicek);
    }
}
