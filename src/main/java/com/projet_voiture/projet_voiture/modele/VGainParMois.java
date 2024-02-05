package com.projet_voiture.projet_voiture.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity()
@Table(name = "V_gain_par_mois")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VGainParMois {
    
    @Id
    int id;
    int annee;
    int mois;
    double prix;
}
