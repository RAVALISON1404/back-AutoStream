package com.projet_voiture.projet_voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import com.projet_voiture.projet_voiture.modele.Favori;
import com.projet_voiture.projet_voiture.modele.Utilisateur;
import com.projet_voiture.projet_voiture.repository.UtilisateurRepository;
import com.projet_voiture.projet_voiture.service.FavoriService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.projet_voiture.projet_voiture.tools.JwtUtil;

@RestController
@RequestMapping("/favori")
public class FavoriController {
    @Autowired
    private FavoriService service;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    private UtilisateurRepository repository;

    @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
    @GetMapping()
    public List<Favori> getListeFavoris() {
        String login = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());

        Optional<Utilisateur> utilisateurOptional = repository.findByEmail(login);
        Utilisateur utilisateur = new Utilisateur();
        if (utilisateurOptional.isPresent()) {
            utilisateur = utilisateurOptional.get();
            return service.getFavorisByIdutilisateur(utilisateur.getIdutilisateur());
        }
        return null;
    }
     
    @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Favori insert(@RequestBody Favori Favori) {
        String login = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());

        Optional<Utilisateur> utilisateurOptional = repository.findByEmail(login);
        Utilisateur utilisateur = new Utilisateur();
        if (utilisateurOptional.isPresent()) {

            utilisateur = utilisateurOptional.get();
            Favori.setIdutilisateur(utilisateur.getIdutilisateur());
            return service.insert(Favori);
        }
        return null;
    }

    @Transactional
    @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
    @DeleteMapping("/{Idannonce}")
    public String deleteFavori(@PathVariable int Idannonce) {
        
        String login = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());

        Optional<Utilisateur> utilisateurOptional = repository.findByEmail(login);
        Utilisateur utilisateur = new Utilisateur();
        if (utilisateurOptional.isPresent()) {

            utilisateur = utilisateurOptional.get();
            
            return service.deleteFavori(utilisateur.getIdutilisateur(), Idannonce);
        }
        return null;
    }

}