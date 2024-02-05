package com.projet_voiture.projet_voiture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.Energie;
import com.projet_voiture.projet_voiture.repository.EnergieRepository;

@Service
public class EnergieService {
    @Autowired
    private EnergieRepository repository;

    public List<Energie> list() {
        return repository.findAll();
    }

    public Energie insert(Energie Energie) {
        return repository.save(Energie);
    }

    public Optional<Energie> findById(int idEnergie) {
        return repository.findById(idEnergie);
    }

    public void deleteById(int idEnergie) {
        repository.deleteById(idEnergie);
    }
}
