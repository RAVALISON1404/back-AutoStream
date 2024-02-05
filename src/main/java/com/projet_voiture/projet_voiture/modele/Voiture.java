package com.projet_voiture.projet_voiture.modele;

import java.util.Date;

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
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idvoiture;
    int nbplace;
    int nbporte;
    double kilometrage;
    double cylindre;
    double puissance;
    int fumeur;
    Date datesortie;
    @ManyToOne
    @JoinColumn(name = "idconduite")
    Conduite conduite;
    @ManyToOne
    @JoinColumn(name = "idmodele")
    Modele modele;
    @ManyToOne
    @JoinColumn(name = "iddrivetype")
    Drivetype drivetype ;
    @ManyToOne
    @JoinColumn(name = "idtransmission")
    Transmission transmission;
    @ManyToOne
    @JoinColumn(name = "idenergie")
    Energie energie;
    int[] idoptions;
    String[] photos;
}
