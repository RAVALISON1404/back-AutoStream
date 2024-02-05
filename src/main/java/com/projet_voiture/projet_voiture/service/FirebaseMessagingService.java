// Source code is decompiled from a .class file using FernFlower decompiler.
package com.projet_voiture.projet_voiture.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.projet_voiture.projet_voiture.util.NotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirebaseMessagingService {
    @Autowired
    private FirebaseMessaging firebaseMessaging;

    public FirebaseMessagingService() {
    }

    public String sendNotificationByToken(NotificationMessage notificationMessage) {
        Notification notification = Notification.builder().setTitle(notificationMessage.getTitle())
                .setBody(notificationMessage.getBody()).setImage(notificationMessage.getImage()).build();
        Message message = Message.builder().setToken(notificationMessage.getRecipientToken())
                .setNotification(notification).putAllData(notificationMessage.getData()).build();

        try {
            this.firebaseMessaging.send(message);
            return "Success Sending Notification";
        } catch (FirebaseMessagingException var5) {
            var5.printStackTrace();
            System.out.println(var5.getMessage());
            return "Error Sending Notification";
        }
    }
}
