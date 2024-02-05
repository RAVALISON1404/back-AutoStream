package com.projet_voiture.projet_voiture.modele;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.projet_voiture.projet_voiture.tools.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "utilisateur")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur implements UserDetails {
    @Id
    String idutilisateur;
    String nomutilisateur;
    String email;
    String mdp;
    @Enumerated(EnumType.STRING)
    Role role;
    LocalDate dateinscription;

    @Override
    public String toString() {
        return "Utilisateur [login=" + email + ", motdepasse=" + mdp + "]";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return getMdp();
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
