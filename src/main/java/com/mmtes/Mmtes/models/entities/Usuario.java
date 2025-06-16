package com.mmtes.Mmtes.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mmtes.Mmtes.dtos.UsuarioRequestDTO;

@Table(name = "usuario")
@Entity (name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_usuario")
public class Usuario implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();
    public LocalDateTime getDataCadastro(){
        return dataCadastro;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UsuarioRole role;

    public Usuario(String login, String password, UsuarioRole role){
      this.login = login;
      this.password = password;
      this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UsuarioRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
    
    @Override
    public String getUsername() {
      return null;
    }

    @Override
    public String getPassword() {
            return null;
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

