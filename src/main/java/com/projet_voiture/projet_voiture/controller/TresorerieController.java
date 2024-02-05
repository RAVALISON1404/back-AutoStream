package com.projet_voiture.projet_voiture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import com.projet_voiture.projet_voiture.modele.VGainParMois;
import com.projet_voiture.projet_voiture.service.TresorerieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tresorerie")
public class TresorerieController {
    
    @Autowired
    private TresorerieService tresorerieService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getGainParMois")
    public List<VGainParMois> getGainParMois()
    {
        // try {
        //     return ResponseEntity.ok().body(tresorerieService.getGainParMois());
        // } catch (Exception e) {
        //     return ResponseEntity.notFound().build();
        // }
        return tresorerieService.getGainParMois();
    }
}
