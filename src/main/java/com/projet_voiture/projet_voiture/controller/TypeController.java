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
 

import com.projet_voiture.projet_voiture.modele.Type;
import com.projet_voiture.projet_voiture.service.TypeService;

@RequestMapping("/type")
@RestController
public class TypeController {
    @Autowired
    private TypeService service;

    @GetMapping
    public List<Type> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Optional<Type> findById(@PathVariable("id") int id) {
        return service.findById(id);
    }

     
    @PostMapping
    public ResponseEntity<Type> insert(@RequestBody Type Type) {
        try {
            Type inserted = service.insert(Type);
            return new ResponseEntity<>(inserted, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Type> update(@PathVariable("id") int id, @RequestBody Type Type) {
        Optional<Type> to_update = service.findById(id);
        if (to_update.isPresent()) {
            Type updated = to_update.get();
            updated.setNomtype(Type.getNomtype());
            return new ResponseEntity<Type>(
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
