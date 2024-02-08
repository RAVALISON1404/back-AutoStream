package com.projet_voiture.projet_voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet_voiture.projet_voiture.modele.Annonce;
import com.projet_voiture.projet_voiture.modele.HistoriqueValidation;
import com.projet_voiture.projet_voiture.modele.Tresorerie;
import com.projet_voiture.projet_voiture.modele.Validation;
import com.projet_voiture.projet_voiture.modele.Voiture;
import com.projet_voiture.projet_voiture.modele.Modele;
import com.projet_voiture.projet_voiture.repository.AnnonceRepository;
import com.projet_voiture.projet_voiture.repository.ValidationRepository;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnonceService {
    @Autowired
    private AnnonceRepository repository;
    @Autowired
    private ValidationService validationService;
    @Autowired
    private ValidationRepository validationRepository;
    @Autowired
    private CommissionService commissionService;
    @Autowired
    private TresorerieService tresorerieService;
    @Autowired
    private HistoriqueValidationService historiqueValidationService;
    @Autowired
    private VoitureService voitureService;
    @Autowired
    private ModeleService modeleService;

    public Annonce insert(Annonce Annonce) {
        return repository.save(Annonce);
    }

    public List<Annonce> getAnnoncesRecentes() {
        return repository.findAllByOrderByDatepubDesc();
    }

    public List<Annonce> getAnnoncesAnciennes() {
        return repository.findAllByOrderByDatepubAsc();
    }

    public List<Annonce> getAnnoncesEntrePrix(double min, double max) {
        return repository.findByPrixGreaterThanEqualAndPrixLessThanEqualOrderByPrixAsc(min, max);
    }

    @Transactional
    public Validation updateValidation(Validation ValidationRequest){
        Validation existingValidation = validationRepository.findByAnnonceIdannonce(ValidationRequest.getAnnonce().getIdannonce()).get();

        HistoriqueValidation historiqueValidation = new HistoriqueValidation();
        historiqueValidation.setIdvalidation(existingValidation.getIdvalidation());
        historiqueValidation.setIdannonce(existingValidation.getAnnonce().getIdannonce());
        historiqueValidation.setEtat(ValidationRequest.getEtat());
        historiqueValidation.setDatemodif(LocalDateTime.now());

        historiqueValidationService.insertHistoriqueValidation(historiqueValidation);

        existingValidation.setEtat(ValidationRequest.getEtat());
        existingValidation.setAnnonce(ValidationRequest.getAnnonce());
        existingValidation.setDatemodif(LocalDateTime.now());
        

        if(existingValidation.getEtat() == 3) {
            double pourcentage = commissionService.getLastCommission().getValeur();
            double prixVoiture = repository.findById(existingValidation.getAnnonce().getIdannonce()).get().getPrix();

            double gainSite = prixVoiture *(pourcentage/100);

            Tresorerie tresorerie = new Tresorerie();
            tresorerie.setIdannonce(existingValidation.getAnnonce().getIdannonce());
            tresorerie.setEntre(gainSite);
            tresorerie.setSortie(0);
            LocalDateTime currentDate = LocalDateTime.now();
            Instant instant = currentDate.toInstant(ZoneOffset.UTC);
            tresorerie.setDatemouvement(Timestamp.from(instant));

            tresorerieService.insertTresorerie(tresorerie);
        }
        return validationRepository.save(existingValidation);
    }

    public List<Annonce> getUnvalidatedAnnonces() {
        return repository.findAllByIdannonceIn(validationService.getAllValidationIds());
    }

    public List<Annonce> getHistorique(String idutilisateur) {
        return repository.findByIdutilisateurAndIdannonceIn(idutilisateur, validationService.getHistoriqueValidation());
    }

    public Annonce findById(int AnnonceId){
        return repository.findById(AnnonceId).get();
    }

    public Page<Annonce> searchByPrixBetween(double prixMin, double prixMax, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "prix"));
        return repository.findByPrixBetween(prixMin, prixMax, pageRequest);
    }


    public Page<Annonce> getAnnoncesByIdModele(int idModele, int page, int size) {
        List<Voiture> voitures = voitureService.getVoituresByModeleId(idModele);
        List<Integer> idVoitures = voitures.stream().map(Voiture::getIdvoiture).collect(Collectors.toList());
        PageRequest pageRequest = PageRequest.of(page, size);
        return repository.findByVoitureIdvoitureIn( idVoitures, pageRequest);
    }

    public Page<Annonce> getAnnonceByIdCategorie(int idCategorie, int page, int size) {
        List<Modele> getModeles = modeleService.findByIdCategorie(idCategorie);
        List<Integer> listIdModele = getModeles.stream().map(Modele::getIdmodele).collect(Collectors.toList());
        List<Voiture> getVoitures = voitureService.getVoitureByIdModeleIn(listIdModele);
        List<Integer> idVoitures = getVoitures.stream().map(Voiture::getIdvoiture).collect(Collectors.toList());
        PageRequest pageRequest = PageRequest.of(page, size);
        return repository.findByVoitureIdvoitureIn(idVoitures, pageRequest);
    }

    public Page<Annonce> getAnnonceByIdMarque(int idMarque, int page, int size) {
        List<Modele> getModeles = modeleService.findByIdMarque(idMarque);
        List<Integer> listIdModele = getModeles.stream().map(Modele::getIdmodele).collect(Collectors.toList());
        List<Voiture> getVoitures = voitureService.getVoitureByIdModeleIn(listIdModele);
        List<Integer> idVoitures = getVoitures.stream().map(Voiture::getIdvoiture).collect(Collectors.toList());
        PageRequest pageRequest = PageRequest.of(page, size);
        return repository.findByVoitureIdvoitureIn(idVoitures, pageRequest);
    }

    public Page<Annonce> getAnnoncesByDateSortie(String dateDebut, String dateFin, int page, int size) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat.parse(dateDebut);
        Date date2 = dateFormat.parse(dateFin);

        List<Voiture> voitures = voitureService.findByDatesortieBetween(date1, date2);
        List<Integer> idVoitures = voitures.stream().map(Voiture::getIdvoiture).collect(Collectors.toList());
        PageRequest pageRequest = PageRequest.of(page, size);
        return repository.findByVoitureIdvoitureIn(idVoitures, pageRequest);
    }

    public Page<Annonce> getAnnoncesByKeyWord(String motCle, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return repository.findByDescriContainingIgnoreCase(motCle, pageRequest);
    }
}
