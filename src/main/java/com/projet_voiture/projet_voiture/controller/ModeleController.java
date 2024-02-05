package com.projet_voiture.projet_voiture.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 

import com.projet_voiture.projet_voiture.modele.Marque;
import com.projet_voiture.projet_voiture.modele.Modele;
import com.projet_voiture.projet_voiture.service.ModeleService;

@RequestMapping("/modele")
@RestController
public class ModeleController {
    @Autowired
    private ModeleService service;

    @GetMapping
    public List<Modele> list() {
        return service.list();
    }

    @GetMapping("/m/{marque}")
    public List<Modele> findByMarque(@PathVariable Marque marque) {
        return service.findByMarque(marque);
    }

    @GetMapping("/{id}")
    public Optional<Modele> findById(@PathVariable("id") int id) {
        return service.findById(id);
    }

     
    @PostMapping
    public ResponseEntity<Modele> insert(@RequestBody Modele Modele) {
        try {
            Modele inserted = service.insert(Modele);
            return new ResponseEntity<>(inserted, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modele> update(@PathVariable("id") int id, @RequestBody Modele Modele) {
        Optional<Modele> to_update = service.findById(id);
        if (to_update.isPresent()) {
            Modele updated = to_update.get();
            updated.setNommodele(Modele.getNommodele());
            updated.setPoids(Modele.getPoids());
            updated.setLongueur(Modele.getLongueur());
            updated.setLargeur(Modele.getLargeur());
            updated.setHauteur(Modele.getHauteur());
            updated.setReservoire(Modele.getReservoire());
            updated.setCarrosserie(Modele.getCarrosserie());
            updated.setCategorie(Modele.getCategorie());
            updated.setMarque(Modele.getMarque());
            return new ResponseEntity<Modele>(
                    service.insert(updated),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") int id) {
        try {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
