package com.projet_voiture.projet_voiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.HistoriqueAnnonce;
import com.projet_voiture.projet_voiture.repository.HistoriqueAnnonceRepository;

@Service
public class HistoriqueAnnonceService {
    
    @Autowired
    private HistoriqueAnnonceRepository historiqueAnnonceRepository;

    public HistoriqueAnnonce insertHistoriqueAnnonce(HistoriqueAnnonce historiqueAnnonce)
    {
        return historiqueAnnonceRepository.save(historiqueAnnonce);
    }

    public List<HistoriqueAnnonce> getAllHistoAnnonceByIdAnnonce(String idAnnonce)
    {
        return historiqueAnnonceRepository.findByIdAnnonce(idAnnonce);
    }
}
