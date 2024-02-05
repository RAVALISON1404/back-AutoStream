package com.projet_voiture.projet_voiture.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NombreVoitureVenduParMois {
    
    private int anneeValidation;
    private int moisValidation;
    private int nombreValidations;

}
