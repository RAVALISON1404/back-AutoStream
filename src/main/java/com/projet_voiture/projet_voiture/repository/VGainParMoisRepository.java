package com.projet_voiture.projet_voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet_voiture.projet_voiture.modele.VGainParMois;

@Repository
public interface VGainParMoisRepository extends JpaRepository<VGainParMois, Integer> {
    
}
