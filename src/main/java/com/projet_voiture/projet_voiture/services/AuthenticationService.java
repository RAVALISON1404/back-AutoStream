package com.projet_voiture.projet_voiture.services;

import com.projet_voiture.projet_voiture.auth.AuthenticationRequest;
import com.projet_voiture.projet_voiture.auth.AuthenticationResponse;
import com.projet_voiture.projet_voiture.auth.RegisterRequest;
import com.projet_voiture.projet_voiture.modele.Utilisateur;
import com.projet_voiture.projet_voiture.repository.UtilisateurRepository;
import com.projet_voiture.projet_voiture.tools.JwtUtil;
import com.projet_voiture.projet_voiture.tools.Role;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

  @Autowired
  private UtilisateurRepository utilisateurRepository;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtUtil jwtUtil;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public AuthenticationResponse register(RegisterRequest request) {
    var user = new Utilisateur();
    user.setNomutilisateur(request.getNomutilisateur());
    System.out.println(user.getNomutilisateur());
    user.setEmail(request.getEmail());
    user.setMdp(passwordEncoder.encode(request.getMdp()));
    user.setDateinscription(LocalDate.now());
    String role = request.getRole();
    if(role.compareToIgnoreCase("1") == 0){
      user.setRole(Role.ROLE_ADMIN);
    }else{
      user.setRole(Role.ROLE_USER);
    }
    utilisateurRepository.save(user);
    var jwtToken = jwtUtil.generateToken(user);
    return new AuthenticationResponse(jwtToken);
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    System.out.println(utilisateurRepository.findByEmail(request.getEmail()));
    System.out.println(request.getEmail());
    System.out.println(request.getMdp());
    authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        request.getEmail(),
        request.getMdp()
      )
    );
    var user = utilisateurRepository
      .findByEmail(request.getEmail())
      .orElseThrow();
    var token = jwtUtil.generateToken(user);

    AuthenticationResponse response = new AuthenticationResponse(token);
    return response;
  }
}
