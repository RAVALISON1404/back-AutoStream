package com.projet_voiture.projet_voiture.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;

import com.projet_voiture.projet_voiture.modele.Message;
import com.projet_voiture.projet_voiture.modele.Utilisateur;
import com.projet_voiture.projet_voiture.repository.UtilisateurRepository;
import com.projet_voiture.projet_voiture.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService service;
    @Autowired
    private UtilisateurRepository repository;
     
    @PostMapping
    @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public Message insert(@RequestBody Message message) {
        if(message.getDateheure() == null) {
            message.setDateheure(LocalDateTime.now());
        }
        String login = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());

        Optional<Utilisateur> utilisateurOptional = repository.findByEmail(login);
        Utilisateur utilisateur = new Utilisateur();
        if (utilisateurOptional.isPresent()) {

            utilisateur = utilisateurOptional.get();

            message.setIdsend(utilisateur.getIdutilisateur());
            message.setDateheure(LocalDateTime.now());
            return service.insert(message);
        }

        return null;
    }

    // @GetMapping
    // public List<Message> findAll() {
    //     return service.findAll();
    // }
    // @GetMapping("/{MessageId}")
    // public Message findById(@PathVariable String MessageId) {
    //     return service.findById(MessageId);
    // }
    // @DeleteMapping("/{MessageId}")
    // public String deleteMessage(@PathVariable String MessageId) {
    //     return service.deleteMessage(MessageId);
    // }

    @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
    @GetMapping("/messages")
    public Set<Message> getMessagesBetweenUsers(@RequestParam String idReceive) {
        String login = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());

        Optional<Utilisateur> utilisateurOptional = repository.findByEmail(login);
        Utilisateur utilisateur = new Utilisateur();
        if (utilisateurOptional.isPresent()) {

            utilisateur = utilisateurOptional.get();
            return service.findByIdSendAndIdReceive(utilisateur.getIdutilisateur(), idReceive);
        }
        return null;
    }
}
