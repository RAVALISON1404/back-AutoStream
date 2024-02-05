package com.projet_voiture.projet_voiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.HistoriqueValidation;
import com.projet_voiture.projet_voiture.repository.HistoriqueValidationRepository;

@Service
public class HistoriqueValidationService {
    
    @Autowired
    private HistoriqueValidationRepository historiqueValidationRepository;

    public HistoriqueValidation insertHistoriqueValidation(HistoriqueValidation historiqueValidation)
    {
        return historiqueValidationRepository.save(historiqueValidation);
    }

    public List<HistoriqueValidation> getAllHistoriqueValidation()
    {
        return historiqueValidationRepository.findAll();
    }
}
