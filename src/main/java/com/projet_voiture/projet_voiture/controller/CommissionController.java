package com.projet_voiture.projet_voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import com.projet_voiture.projet_voiture.modele.Commission;
import com.projet_voiture.projet_voiture.service.CommissionService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/commission")
public class CommissionController {
    @Autowired
    private CommissionService commissionService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Commission> insert(@RequestBody Commission commission) {
        try {
            return ResponseEntity.ok().body(commissionService.insertCommission(commission));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        
    }

    @GetMapping
    public ResponseEntity<Commission> getCommission()
    {
        try {
            return ResponseEntity.ok().body(commissionService.getLastCommission());
        } catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
        
    }

    // @PutMapping
    // public ResponseEntity<Commission> updateValidation(@RequestBody Commission commission) {
        
    //     try {
    //         return ResponseEntity.ok().body(commissionService.updateCommission(commission));
    //     } catch (Exception e) {
    //         return ResponseEntity.notFound().build();
    //     }
        
    // }

}
