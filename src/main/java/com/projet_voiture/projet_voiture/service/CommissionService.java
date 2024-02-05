package com.projet_voiture.projet_voiture.service;

import java.time.LocalDate;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.Commission;
import com.projet_voiture.projet_voiture.repository.CommissionRepository;

@Service
public class CommissionService {
    
    @Autowired
    private CommissionRepository commissionRepository;

    public Commission insertCommission(Commission commission)
    {
        if (commission.getDate() == null) {
            LocalDate currentDate = LocalDate.now();
            Date now = Date.valueOf(currentDate);
            commission.setDate(now);
        }
        return commissionRepository.save(commission);
    }

    public Commission getLastCommission()
    {
        return commissionRepository.getLastCommission();
    }

    public Commission updateCommission(Commission commission)
    {
        Commission commissionTemp = commissionRepository.findById(commission.getIdcommission()).get();
        commissionTemp.setValeur(commission.getValeur());

        commissionRepository.save(commissionTemp);

        return commissionTemp;
    }

}
