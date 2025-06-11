package com.mmtes.Mmtes.dtos;

import java.time.LocalDateTime;

import com.mmtes.Mmtes.models.entities.Usuario;

public record UsuarioResponseDTO(
    Long id,
    String nome,
    String email,
    LocalDateTime dataCadastro
) {
    public UsuarioResponseDTO(Usuario usuarioDTO){
        this(usuarioDTO.getId_usuario(), usuarioDTO.getNome(), usuarioDTO.getEmail(), usuarioDTO.getDataCadastro());
    }
}
