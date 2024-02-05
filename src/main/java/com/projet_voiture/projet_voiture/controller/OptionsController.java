package com.projet_voiture.projet_voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
 

import com.projet_voiture.projet_voiture.modele.Options;
import com.projet_voiture.projet_voiture.service.OptionsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/options")
public class OptionsController {
    @Autowired
    private OptionsService service;

     
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Options insert(@RequestBody Options Options) {
        return service.insert(Options);
    }

    @GetMapping
    public List<Options> findAll() {
        return service.findAll();
    }

    @GetMapping("/{OptionsId}")
    public Options findById(@PathVariable int OptionsId) {
        return service.findById(OptionsId);
    }

    @PutMapping
    public Options updateOptions(@RequestBody Options Options) {
        return service.updateOptions(Options);
    }

    @DeleteMapping("/{OptionsId}")
    public String deleteOptions(@PathVariable int OptionsId) {
        return service.deleteOptions(OptionsId);
    }
}
