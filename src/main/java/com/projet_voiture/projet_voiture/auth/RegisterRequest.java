package com.projet_voiture.projet_voiture.auth;

public class RegisterRequest {

  private String nomutilisateur;
  private String email;
  private String mdp;
  private String role;

  public String getNomutilisateur() {
    return nomutilisateur;
  }
  public void setNomutilisateur(String nomutilisateur) {
    this.nomutilisateur = nomutilisateur;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getMdp() {
    return mdp;
  }
  public void setMdp(String mdp) {
    this.mdp = mdp;
  }
  public String getRole() {
    return role;
  }
  public void setRole(String role) {
    this.role = role;
  }
}
