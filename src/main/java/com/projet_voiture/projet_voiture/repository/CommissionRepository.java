package com.projet_voiture.projet_voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projet_voiture.projet_voiture.modele.Commission;

@Repository
public interface CommissionRepository extends JpaRepository<Commission, Integer> {
    
    @Query(
        value = "SELECT * FROM commission ORDER BY date DESC LIMIT 1",
        nativeQuery = true
    )
    public Commission getLastCommission();
}
