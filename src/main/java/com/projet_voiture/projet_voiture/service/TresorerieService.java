package com.projet_voiture.projet_voiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.Tresorerie;
import com.projet_voiture.projet_voiture.modele.VGainParMois;
import com.projet_voiture.projet_voiture.repository.TresorerieRepository;
import com.projet_voiture.projet_voiture.repository.VGainParMoisRepository;

@Service
public class TresorerieService {
    
    @Autowired
    private TresorerieRepository tresorerieRepository;

    @Autowired
    private VGainParMoisRepository vGainParMoisRepository;

    public void insertTresorerie(Tresorerie tresorerie)
    {
        tresorerieRepository.save(tresorerie);
    }

    public List<Tresorerie> listTresorerie()
    {
        return tresorerieRepository.findAll();
    }

    public List<VGainParMois> getGainParMois()
    {
        return vGainParMoisRepository.findAll();
    }
}
