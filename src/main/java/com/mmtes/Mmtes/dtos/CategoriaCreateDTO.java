package com.mmtes.Mmtes.dtos;

import jakarta.validation.constraints.NotBlank;

public record CategoriaCreateDTO(
    @NotBlank String nome,
    @NotBlank String descricao,
    @NotBlank Long idUsuario
){}