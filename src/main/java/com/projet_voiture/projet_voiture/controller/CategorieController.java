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
 

import com.projet_voiture.projet_voiture.modele.Categorie;
import com.projet_voiture.projet_voiture.service.CategorieService;

@RequestMapping("/categorie")
@RestController
public class CategorieController {
    @Autowired
    private CategorieService service;

    @GetMapping
    public List<Categorie> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Optional<Categorie> findById(@PathVariable("id") int id) {
        return service.findById(id);
    }
    
     
@PostMapping
    public ResponseEntity<Categorie> insert( @RequestBody Categorie Categorie ) {
        try {
            Categorie inserted = service.insert(Categorie);
            return new ResponseEntity<>(inserted, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categorie> update( @PathVariable("id") int id, @RequestBody Categorie Categorie ) {
        Optional<Categorie> to_update = service.findById(id);
        if (to_update.isPresent()) {
            Categorie updated = to_update.get();
            updated.setNomcategorie( Categorie.getNomcategorie() );            
            return new ResponseEntity<Categorie>(
                service.insert(updated),
                HttpStatus.OK
            );
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
