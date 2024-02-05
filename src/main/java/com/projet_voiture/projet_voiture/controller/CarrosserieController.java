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

 
import com.projet_voiture.projet_voiture.modele.Carrosserie;
import com.projet_voiture.projet_voiture.service.CarrosserieService;

@RequestMapping("/carrosserie")
@RestController
public class CarrosserieController {
    @Autowired
    private CarrosserieService service;

    @GetMapping
    public List<Carrosserie> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Optional<Carrosserie> findById(@PathVariable("id") int id) {
        return service.findById(id);
    }

     
    @PostMapping
    public ResponseEntity<Carrosserie> insert(@RequestBody Carrosserie Carrosserie) {
        try {
            Carrosserie inserted = service.insert(Carrosserie);
            return new ResponseEntity<>(inserted, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrosserie> update(@PathVariable("id") int id, @RequestBody Carrosserie Carrosserie) {
        Optional<Carrosserie> to_update = service.findById(id);
        if (to_update.isPresent()) {
            Carrosserie updated = to_update.get();
            updated.setNomcarrosserie(Carrosserie.getNomcarrosserie());
            return new ResponseEntity<Carrosserie>(
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
