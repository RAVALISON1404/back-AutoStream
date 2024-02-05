package com.projet_voiture.projet_voiture.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.projet_voiture.projet_voiture.modele.HistoriqueValidation;

public interface HistoriqueValidationRepository extends MongoRepository<HistoriqueValidation, String> {
    
}
