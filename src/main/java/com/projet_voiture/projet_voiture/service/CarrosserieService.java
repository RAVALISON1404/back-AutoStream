package com.projet_voiture.projet_voiture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.Carrosserie;
import com.projet_voiture.projet_voiture.repository.CarrosserieRepository;

@Service
public class CarrosserieService {
    @Autowired
    private CarrosserieRepository repository;

    public List<Carrosserie> list() {
        return repository.findAll();
    }

    public Carrosserie insert(Carrosserie Carrosserie) {
        return repository.save(Carrosserie);
    }

    public Optional<Carrosserie> findById(int idCarrosserie) {
        return repository.findById(idCarrosserie);
    }

    public void deleteById(int idCarrosserie) {
        repository.deleteById(idCarrosserie);
    }
}
