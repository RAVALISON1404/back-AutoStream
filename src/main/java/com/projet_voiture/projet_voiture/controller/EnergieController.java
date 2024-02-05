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
 

import com.projet_voiture.projet_voiture.modele.Energie;
import com.projet_voiture.projet_voiture.service.EnergieService;

@RequestMapping("/energie")
@RestController
public class EnergieController {
    @Autowired
    private EnergieService service;

    @GetMapping
    public List<Energie> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Optional<Energie> findById(@PathVariable("id") int id) {
        return service.findById(id);
    }

     
    @PostMapping
    public ResponseEntity<Energie> insert(@RequestBody Energie Energie) {
        try {
            Energie inserted = service.insert(Energie);
            return new ResponseEntity<>(inserted, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Energie> update(@PathVariable("id") int id, @RequestBody Energie Energie) {
        Optional<Energie> to_update = service.findById(id);
        if (to_update.isPresent()) {
            Energie updated = to_update.get();
            updated.setNomenergie(Energie.getNomenergie());
            return new ResponseEntity<Energie>(
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
