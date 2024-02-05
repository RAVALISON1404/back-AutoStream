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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idfavori;
    @ManyToOne
    @JoinColumn(name = "idannonce")
    Annonce annonce ;
    String idutilisateur;
}
