package com.projet_voiture.projet_voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.projet_voiture.projet_voiture.modele.Validation;
import com.projet_voiture.projet_voiture.modele.NombreVoitureVenduParMois;
import com.projet_voiture.projet_voiture.repository.ValidationRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ValidationService {
    @Autowired
    private ValidationRepository repository;   

    @Autowired
    private MongoTemplate mongoTemplate;


    public Optional<Validation> findByIdannonce(int idannonce) {
        return repository.findByAnnonceIdannonce(idannonce);
    }

    public List<Integer> getAllValidationIds() {
        return repository.findByEtat(0).stream().map(v -> v.getAnnonce().getIdannonce()).collect(Collectors.toList());
    }

    public List<Validation> getHistoriqueValidation(String idutilisateur) {
        return repository.findValidationsByAnnonceIdUtilisateur(idutilisateur);
    }

    // public List<Integer> getHistoriqueValidation() {
    //     return repository.findByEtatNot(2).stream().map(v -> v.getAnnonce().getIdannonce()).collect(Collectors.toList());
    // }

    public List<Validation> findByEtat(int etat){
        return repository.findByEtat(etat);
    }

    public Validation insert(Validation Validation) {
        return repository.save(Validation);
    }

    public List<NombreVoitureVenduParMois> getNombreVenteParMois() {
        return repository.getNombreValidationsParAnneeEtMois();
    }
}
