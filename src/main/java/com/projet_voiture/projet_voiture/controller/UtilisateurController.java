package com.projet_voiture.projet_voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.projet_voiture.projet_voiture.auth.AuthenticationRequest;
import com.projet_voiture.projet_voiture.auth.RegisterRequest;
import com.projet_voiture.projet_voiture.modele.InscriptionParMois;
import com.projet_voiture.projet_voiture.modele.Utilisateur;
import com.projet_voiture.projet_voiture.service.UtilisateurService;
import com.projet_voiture.projet_voiture.services.AuthenticationService;
import com.projet_voiture.projet_voiture.tools.Util;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class UtilisateurController {
    @Autowired
    private AuthenticationService authservice;

    @GetMapping("/hello")
    public String register() {
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(
            @RequestBody RegisterRequest request) {
        Map<String, Object> response = Util.getDefaultResponse();
        request.setRole("0");
        response.put("response", authservice.register(request));
        return new ResponseEntity<Map<String, Object>>(
                response,
                HttpStatusCode.valueOf(200));
    }

    @PostMapping("/auth")
    public ResponseEntity<Map<String, Object>> auth(@RequestBody AuthenticationRequest request) {
        Map<String, Object> response = Util.getDefaultResponse();
        response.put("response", authservice.authenticate(request));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatusCode.valueOf(200));
    }

    @Autowired
    private UtilisateurService service;

    @GetMapping("/{UtilisateurId}")
    public Utilisateur findById(@PathVariable String UtilisateurId) {
        return service.findById(UtilisateurId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/nbInscriptMois")
    public List<InscriptionParMois> getInscritParMois()
    {
        return service.getAllInscriptParMois();
    }
}
