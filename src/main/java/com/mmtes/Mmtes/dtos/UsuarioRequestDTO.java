package com.mmtes.Mmtes.dtos;

import com.mmtes.Mmtes.models.entities.Usuario;

import java.time.LocalDateTime;

public record UsuarioRequestDTO(String nome, String email, String senha, LocalDateTime dataCadastro) {

    public UsuarioRequestDTO(Usuario usuario){
        this(usuario.getNome(), usuario.getEmail(), usuario.getSenha(),usuario.getDataCadastro());
    }
}
