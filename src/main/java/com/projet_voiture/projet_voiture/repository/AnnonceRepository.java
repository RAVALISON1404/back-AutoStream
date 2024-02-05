package com.projet_voiture.projet_voiture.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projet_voiture.projet_voiture.modele.Annonce;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Integer>{

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
