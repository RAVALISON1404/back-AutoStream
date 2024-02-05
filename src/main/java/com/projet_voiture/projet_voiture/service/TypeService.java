package com.projet_voiture.projet_voiture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.Type;
import com.projet_voiture.projet_voiture.repository.TypeRepository;

@Service
public class TypeService {
    @Autowired
    private TypeRepository repository;

    public List<Type> list() {
        return repository.findAll();
    }

    public Type insert(Type Type) {
        return repository.save(Type);
    }

    public Optional<Type> findById(int idType) {
        return repository.findById(idType);
    }

    public void deleteById(int idType) {
        repository.deleteById(idType);
    }

}
