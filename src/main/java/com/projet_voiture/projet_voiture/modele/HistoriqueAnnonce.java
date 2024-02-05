package com.projet_voiture.projet_voiture.modele;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "historique_annonce")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoriqueAnnonce {
    
    @Id
    private String id;
    private String idAnnonce;
    private String descri;
    private Double prix;
    private LocalDateTime datepub;
    private String idVoiture;
    private String idUtilisateur;
}
