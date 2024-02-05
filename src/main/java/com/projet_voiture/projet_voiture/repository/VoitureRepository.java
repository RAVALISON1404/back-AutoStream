package com.projet_voiture.projet_voiture.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet_voiture.projet_voiture.modele.Voiture;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Integer>{
    
    List<Voiture> findByModeleIdmodele(int idModele);

    List<Voiture> findByModeleIdmodeleIn(List<Integer> listIdModele);

    List<Voiture> findByDatesortieBetween(Date dateDebut, Date dateFin);
}
