package com.projet_voiture.projet_voiture.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.projet_voiture.projet_voiture.modele.Message;
// import org.springframework.data.mongodb.repository.Query;

public interface MessageRepository extends MongoRepository<Message, String>{
    
    List<Message> findAllByIdsendInAndIdreceiveInOrderByDateheureAsc(List<String> senders, List<String> receivers);
}