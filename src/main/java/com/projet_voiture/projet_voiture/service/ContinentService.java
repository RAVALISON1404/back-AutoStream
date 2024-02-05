package com.projet_voiture.projet_voiture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.Continent;
import com.projet_voiture.projet_voiture.repository.ContinentRepository;

@Service
public class ContinentService {
    @Autowired
    private ContinentRepository repository;

    public List<Continent> list() {
        return repository.findAll();
    }

    public Continent insert(Continent Continent) {
        return repository.save(Continent);
    }

    public Optional<Continent> findById(int idContinent) {
        return repository.findById(idContinent);
    }

    public void deleteById(int idContinent) {
        repository.deleteById(idContinent);
    }
}
