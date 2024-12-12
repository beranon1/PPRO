package com.example.ppro_projekt.service;

import com.example.ppro_projekt.model.Cvik;
import com.example.ppro_projekt.repository.CvikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CvikServiceImpl implements CvikService {

    CvikRepository cvikRepository;
    @Autowired
    public CvikServiceImpl(CvikRepository cvikRepository) {
        this.cvikRepository = cvikRepository;
    }


    @Override
    public List<Cvik> getAllCviks() {
        return cvikRepository.findAll();
    }

    @Override
    public Cvik getCvikById(long id) {
       return cvikRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCvikById(long id) {
       Optional<Cvik> cvik = cvikRepository.findById(id);
       if (cvik.isPresent()) {
           cvikRepository.delete(cvik.get());
       }
    }

    @Override
    public void saveCvik(Cvik cvik) {
        cvikRepository.save(cvik);
    }


}
