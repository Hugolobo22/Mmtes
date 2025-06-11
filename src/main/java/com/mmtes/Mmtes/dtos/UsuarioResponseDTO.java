package com.mmtes.Mmtes.dtos;

import java.time.LocalDateTime;

import com.mmtes.Mmtes.models.entities.Usuario;

public record UsuarioResponseDTO(
    Long id,
    String nome,
    String email,
    LocalDateTime dataCadastro
) {
    public UsuarioResponseDTO(Usuario usuario){
        this(usuario.getId_usuario(), usuario.getNome(), usuario.getEmail(), usuario.getDataCadastro());
    }
}
