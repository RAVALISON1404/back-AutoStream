package com.projet_voiture.projet_voiture;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;

@SpringBootApplication
public class ProjetVoitureApplication {

	@Bean
	FirebaseMessaging firebaseMessaging() throws IOException{
		GoogleCredentials googleCredentials =  GoogleCredentials.fromStream( new ClassPathResource("stockage-photo-b8c98-firebase-adminsdk-lj5rn-a27f5ad515.json").getInputStream() );
		FirebaseOptions firebaseOptions = FirebaseOptions.builder().setCredentials(googleCredentials).build();
		FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions, "my-app");
		return FirebaseMessaging.getInstance(app);
	}

	
	public static void main(String[] args) {	
		// atlas
		// String public_key = "zpctafhv";
		// String private_key = "8c5820e1-89d3-42af-8b91-9f57ec9aeb44";
		SpringApplication.run(ProjetVoitureApplication.class, args);
	}

}
