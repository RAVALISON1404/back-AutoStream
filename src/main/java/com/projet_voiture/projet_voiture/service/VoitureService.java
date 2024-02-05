package com.projet_voiture.projet_voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.Voiture;
import com.projet_voiture.projet_voiture.repository.VoitureRepository;

import java.util.Date;
import java.util.List;

@Service
public class VoitureService {
    @Autowired
    private VoitureRepository repository;

    public Voiture insert(Voiture Voiture) {
        return repository.save(Voiture);
    }

    public List<Voiture> findAll() {
        return repository.findAll();
    }

    public Voiture findById(int VoitureId){
        return repository.findById(VoitureId).get();
    }

    public Voiture updateVoiture(Voiture VoitureRequest){
        Voiture existingVoiture = repository.findById(VoitureRequest.getIdvoiture()).get();
        existingVoiture.setNbplace(VoitureRequest.getNbplace());
        existingVoiture.setNbporte(VoitureRequest.getNbporte());
        existingVoiture.setKilometrage(VoitureRequest.getKilometrage());
        existingVoiture.setCylindre(VoitureRequest.getCylindre());
        existingVoiture.setPuissance(VoitureRequest.getPuissance());
        existingVoiture.setFumeur(VoitureRequest.getFumeur());
        existingVoiture.setDrivetype(VoitureRequest.getDrivetype());
        existingVoiture.setDatesortie(VoitureRequest.getDatesortie());
        existingVoiture.setConduite(VoitureRequest.getConduite());
        existingVoiture.setModele(VoitureRequest.getModele());
        existingVoiture.setTransmission(VoitureRequest.getTransmission());
        existingVoiture.setEnergie(VoitureRequest.getEnergie());
        return repository.save(existingVoiture);
    }

    public String deleteVoiture(int VoitureId){
        repository.deleteById(VoitureId);
        return VoitureId+" Voiture deleted from dashboard ";
    }

    public List<Voiture> getVoituresByModeleId(int idModele) {
        return repository.findByModeleIdmodele(idModele);
    }

    public List<Voiture> getVoitureByIdModeleIn(List<Integer> idModele) {
        return repository.findByModeleIdmodeleIn(idModele);
    }

    public List<Voiture> findByDatesortieBetween(Date dateDebut, Date dateFin) {
        return repository.findByDatesortieBetween(dateDebut, dateFin);
    }
}
