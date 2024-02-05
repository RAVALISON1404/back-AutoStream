package com.projet_voiture.projet_voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet_voiture.projet_voiture.modele.Favori;
import java.util.List;

@Repository
public interface FavoriRepository extends JpaRepository<Favori, Integer>{

    List<Favori> findByIdutilisateur(String idutilisateur);

    void deleteByIdutilisateurAndAnnonceIdannonce(String idutilisateur, int idannonce);

}
