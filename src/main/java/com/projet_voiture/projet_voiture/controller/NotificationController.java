package com.projet_voiture.projet_voiture.controller;

import com.projet_voiture.projet_voiture.service.FirebaseMessagingService;
import com.projet_voiture.projet_voiture.util.NotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/notification"})
public class NotificationController {
   @Autowired
   FirebaseMessagingService firebaseMessagingService;

   public NotificationController() {
   }

   @PostMapping
   public String sendNotificationByToken(@RequestBody NotificationMessage notificationMessage) {
      return this.firebaseMessagingService.sendNotificationByToken(notificationMessage);
   }
}