package com.mmtes.Mmtes.dtos;

import java.time.LocalDateTime;

import com.mmtes.Mmtes.models.entities.Usuario;

public record UsuarioResponseDTO(Long id_usuario, String nome, String login, String password, LocalDateTime dataCadastro) {
    public UsuarioResponseDTO(Usuario usuario){
        this(usuario.getId_usuario(), usuario.getNome(), usuario.getLogin(), usuario.getPassword(), usuario.getDataCadastro());
    }
}
