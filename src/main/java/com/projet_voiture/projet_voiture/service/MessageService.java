package com.projet_voiture.projet_voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.Message;
import com.projet_voiture.projet_voiture.repository.MessageRepository;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;

    public Message insert(Message Message) {
        Message.setIdmessage(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(Message);
    }

    public List<Message> findAll() {
        return repository.findAll();
    }

    public List<String> getIdreceives(String iduser) {
        List<Message> messages = repository.findByIdsend(iduser);
        List<String> idreceives = messages.stream().map(Message::getIdreceive).collect(Collectors.toList());
        return new ArrayList<>(new LinkedHashSet<>(idreceives));
    }

    public List<String> getIdsends(String iduser) {
        List<Message> messages = repository.findByIdreceive(iduser);
        List<String> idsends = messages.stream().map(Message::getIdsend).collect(Collectors.toList());
        return new ArrayList<>(new LinkedHashSet<>(idsends));
    }

    public List<String> getTexted(String iduser) {
        List<String> mergedList = new ArrayList<>();
        mergedList.addAll(getIdsends(iduser));
        mergedList.addAll(getIdreceives(iduser));

        Set<String> setWithNoDuplicates = new LinkedHashSet<>(mergedList);

        List<String> finalList = new ArrayList<>(setWithNoDuplicates);
        return finalList;
    }

    public Message findById(String MessageId) {
        return repository.findById(MessageId).get();
    }

    public String deleteMessage(String MessageId) {
        repository.deleteById(MessageId);
        return MessageId + " Message deleted from dashboard ";
    }

    public Set<Message> findByIdSendAndIdReceive(String user1Id, String user2Id) {
        List<String> users = List.of(user1Id, user2Id);

        List<Message> messagesList = repository.findAllByIdsendInAndIdreceiveInOrderByDateheureAsc(users, users);

        Set<Message> messagesSet = new LinkedHashSet<>(messagesList);

        return messagesSet;
    }
}
