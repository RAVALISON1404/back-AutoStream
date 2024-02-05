package com.projet_voiture.projet_voiture.modele;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commission {
    
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    int idcommission;
    double valeur;
    Date date;
}
