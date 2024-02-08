package com.projet_voiture.projet_voiture.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.projet_voiture.projet_voiture.modele.Message;

public interface MessageRepository extends MongoRepository<Message, String>{
    
    List<Message> findAllByIdsendInAndIdreceiveInOrderByDateheureAsc(List<String> senders, List<String> receivers);

    List<Message> findByIdsend(String idsend);

    List<Message> findByIdreceive(String idreceive);
}