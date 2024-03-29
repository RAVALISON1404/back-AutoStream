package com.projet_voiture.projet_voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projet_voiture.projet_voiture.modele.NombreVoitureVenduParMois;
import com.projet_voiture.projet_voiture.modele.Validation;

import java.util.List;
import java.util.Optional;

@Repository
public interface ValidationRepository extends JpaRepository<Validation, Integer> {

    @Query("SELECT new com.projet_voiture.projet_voiture.modele.NombreVoitureVenduParMois(YEAR(v.datemodif), MONTH(v.datemodif), COUNT(v)) FROM Validation v GROUP BY YEAR(v.datemodif), MONTH(v.datemodif)")
    List<NombreVoitureVenduParMois> getNombreValidationsParAnneeEtMois();

    List<Validation> findByEtat(int etat);

    Optional<Validation> findByAnnonceIdannonce(int idannonce);

    List<Validation> findByEtatNot(int etat);

    @Query("SELECT v FROM Validation v WHERE v.etat != 2 AND v.annonce.idutilisateur = :idUtilisateur")
    List<Validation> findValidationsByAnnonceIdUtilisateur(String idUtilisateur);

    // @Query(value = "{}", fields = "{ 'idannonce' : 1 }")
    // List<String> findAllValidationIds();
    // List<Integer> findAllByAnnonceId();
}