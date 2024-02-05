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
 

import com.projet_voiture.projet_voiture.modele.Continent;
import com.projet_voiture.projet_voiture.service.ContinentService;

@RequestMapping("/continent")
@RestController
public class ContinentController {
    @Autowired
    private ContinentService service;

    @GetMapping
    public List<Continent> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Optional<Continent> findById(@PathVariable("id") int id) {
        return service.findById(id);
    }

     
    @PostMapping
    public ResponseEntity<Continent> insert(@RequestBody Continent Continent) {
        try {
            Continent inserted = service.insert(Continent);
            return new ResponseEntity<>(inserted, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Continent> update(@PathVariable("id") int id, @RequestBody Continent Continent) {
        Optional<Continent> to_update = service.findById(id);
        if (to_update.isPresent()) {
            Continent updated = to_update.get();
            updated.setNomcontinent(Continent.getNomcontinent());
            return new ResponseEntity<Continent>(
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
