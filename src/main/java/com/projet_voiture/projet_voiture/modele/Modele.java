package com.projet_voiture.projet_voiture.modele;

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
public class Modele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idmodele;
    String nommodele;
    double poids;
    double longueur;
    double largeur;
    double hauteur;
    double reservoire;
    @ManyToOne
    @JoinColumn(name = "idcarrosserie")
    Carrosserie carrosserie;
    @ManyToOne
    @JoinColumn(name = "idcategorie")
    Categorie categorie;
    @ManyToOne
    @JoinColumn(name = "idmarque")
    Marque marque;    
}
