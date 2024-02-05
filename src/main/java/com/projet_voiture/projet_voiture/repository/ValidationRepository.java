package com.projet_voiture.projet_voiture.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet_voiture.projet_voiture.modele.Validation;

import java.util.List;
import java.util.Optional;

@Repository
public interface  ValidationRepository extends JpaRepository<Validation,Integer>  {
    List<Validation> findByEtat(int etat);

    Optional<Validation> findByAnnonceIdannonce(int idannonce);

    List<Validation> findByEtatNot(int etat);

    // @Query(value = "{}", fields = "{ 'idannonce' : 1 }")
    // List<String> findAllValidationIds();
    // List<Integer> findAllByAnnonceId();
}