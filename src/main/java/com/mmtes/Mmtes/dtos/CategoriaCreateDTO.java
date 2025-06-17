package com.mmtes.Mmtes.dtos;

import jakarta.validation.constraints.NotBlank;

public record CategoriaCreateDTO(
    String nome,
    String descricao,
    Long idUsuario
){}