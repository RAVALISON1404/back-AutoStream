package com.projet_voiture.projet_voiture.modele;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "historiquevalidation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoriqueValidation {    
    @Id
    String idhistoriquevalidation;
    int idvalidation;
    int etat;
    LocalDateTime datemodif;
    int idannonce;
}
