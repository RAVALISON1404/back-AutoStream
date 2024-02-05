package com.projet_voiture.projet_voiture.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InscriptionParMois {
    
    private int anneeInscription;
    private int moisInscription;
    private Integer nombreInscriptions;
}
