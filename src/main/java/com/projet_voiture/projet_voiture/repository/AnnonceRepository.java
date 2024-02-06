package com.projet_voiture.projet_voiture.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projet_voiture.projet_voiture.modele.Annonce;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Integer>{

    @Query("SELECT a FROM Annonce a NATURAL JOIN Validation val WHERE val.etat = 1 ORDER BY a.datepub DESC")
    List<Annonce> findAllByOrderByDatepubDesc();

    @Query("SELECT a FROM Annonce a NATURAL JOIN Validation val WHERE val.etat = 1 ORDER BY a.datepub ASC")
    List<Annonce> findAllByOrderByDatepubAsc();

    @Query("SELECT a FROM Annonce a NATURAL JOIN Validation val WHERE val.etat = 1 and a.prix >= :minPrice AND a.prix <= :maxPrice ORDER BY a.prix ASC")
    List<Annonce> findByPrixGreaterThanEqualAndPrixLessThanEqualOrderByPrixAsc(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);

    // @Query("SELECT a FROM Annonce a NATURAL JOIN Voiture v NATURAL JOIN Validation val WHERE val.etat = 1 ORDER BY v.datesortie DESC")
    // List<Annonce> findAnnoncesWithVoitureOrderByVoitureDatesortieDesc();

    // @Query("SELECT a FROM Annonce a NATURAL JOIN Voiture v NATURAL JOIN Validation val WHERE val.etat = 1 ORDER BY v.datesortie ASC")
    // List<Annonce> findAnnoncesWithVoitureOrderByVoitureDatesortieAsc();

    // @Query("SELECT a FROM Annonce a NATURAL JOIN Validation val WHERE val.etat = 1 and a IN (SELECT f.annonce FROM Favori f) GROUP BY a ORDER BY COUNT(f) DESC")
    // @Query("SELECT a FROM Annonce a INNER JOIN a.validations val WHERE val.etat =  1 AND EXISTS (SELECT f.annonce FROM Favori f) GROUP BY a ORDER BY COUNT(f) DESC")
    // List<Annonce> findFeaturedAnnoncesOrderByFavoriCountDesc();

    // @Query("SELECT a FROM Annonce a INNER JOIN Voiture v ON a.voiture.id = v.id ORDER BY v.datesortie DESC")
    // List<Annonce> findAnnoncesByVoitureDatesortieDesc();

    List<Annonce> findAllByIdannonceIn(List<Integer> allValidationIds);

    public List<Annonce> findByIdannonceIn(List<Integer> idAnnonces);

    List<Annonce> findByIdutilisateurAndIdannonceIn(String idutilisateur, List<Integer> allValidationIds);

    @Query("{ 'prix' : { $gte : ?0, $lte : ?1 } }")
    Page<Annonce> findByPrixBetween(double prixMin, double prixMax, PageRequest pageRequest);

    Page<Annonce> findByVoitureIdvoitureIn(List<Integer> idVoitures, PageRequest pageRequest);

    // @Query("{'descri': {$regex: ?0, $options: 'i'}}")
    // Page<Annonce> findByKeyword(String keyword, PageRequest pageRequest);
    Page<Annonce> findByDescriContainingIgnoreCase(String keyword, PageRequest pageRequest);
}
