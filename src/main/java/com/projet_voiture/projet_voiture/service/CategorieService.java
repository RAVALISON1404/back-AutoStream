package com.projet_voiture.projet_voiture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.Categorie;
import com.projet_voiture.projet_voiture.repository.CategorieRepository;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository repository;

    public List<Categorie> list() {
        return repository.findAll();
    }

    public Categorie insert(Categorie Categorie) {
        return repository.save(Categorie);
    }

    public Optional<Categorie> findById(int idCategorie) {
        return repository.findById(idCategorie);
    }

    public void deleteById(int idCategorie) {
        repository.deleteById(idCategorie);
    }
}
