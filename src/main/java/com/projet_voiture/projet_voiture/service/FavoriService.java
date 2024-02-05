package com.projet_voiture.projet_voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.Annonce;
import com.projet_voiture.projet_voiture.repository.AnnonceRepository;
import com.projet_voiture.projet_voiture.modele.Favori;
import com.projet_voiture.projet_voiture.repository.FavoriRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriService {
    @Autowired
    private FavoriRepository repository;

    @Autowired
    private AnnonceRepository annonceRepository;

    public List<Favori> getFavorisByIdutilisateur(String idutilisateur) {
        return repository.findByIdutilisateur(idutilisateur);
    }

    public Favori insert(Favori Favori) {
        return repository.save(Favori);
    }

    public String deleteFavori(String idutilisateur, int idannonce){
        repository.deleteByIdutilisateurAndAnnonceIdannonce(idutilisateur, idannonce);
        return idannonce+" Favori deleted from dashboard ";
    }

    public List<Annonce> getAnnonceFavoriByIdUtilisateur(String idUtilisateur)
    {
        List<Favori> favoris = repository.findByIdutilisateur(idUtilisateur);
        // List<Integer> idAnnonces = favoris.stream().map(Favori::getIdannonce).collect(Collectors.toList());
        List<Integer> idAnnonces = favoris.stream().map(f -> f.getAnnonce().getIdannonce()).collect(Collectors.toList());

        return annonceRepository.findByIdannonceIn(idAnnonces);
    }
}
