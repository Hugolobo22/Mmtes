package com.mmtes.Mmtes.dtos;

import com.mmtes.Mmtes.models.entities.Usuario;

import java.time.LocalDateTime;

public record UsuarioRequestDTO(String nome, String login, String password, LocalDateTime dataCadastro) {

    public UsuarioRequestDTO(Usuario usuario){
        this(usuario.getNome(), usuario.getLogin(), usuario.getPassword(),usuario.getDataCadastro());
    }
}
