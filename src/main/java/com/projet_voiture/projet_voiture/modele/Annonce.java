package com.projet_voiture.projet_voiture.modele;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idannonce;
    String descri;
    double prix;
    LocalDateTime datepub;
    @ManyToOne
    @JoinColumn(name = "idvoiture")
    Voiture voiture ;
    String idutilisateur;    
}
