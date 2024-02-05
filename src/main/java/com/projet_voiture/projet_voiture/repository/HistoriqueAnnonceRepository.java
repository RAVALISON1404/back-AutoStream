package com.projet_voiture.projet_voiture.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.projet_voiture.projet_voiture.modele.HistoriqueAnnonce;

public interface HistoriqueAnnonceRepository extends MongoRepository<HistoriqueAnnonce, String> {
    
    public List<HistoriqueAnnonce> findByIdAnnonce(String idAnnonce);
}
