package com.mmtes.Mmtes.dtos;

import java.util.Date;

import com.mmtes.Mmtes.models.entities.Prioridade;

import jakarta.validation.constraints.NotBlank;

public record TarefaCreateDTO(
    @NotBlank String titulo,
    @NotBlank String descricao,
    @NotBlank Long id_usuario,
    @NotBlank Prioridade prioridade,
    @NotBlank Date prazo, 
    Date data_criacao
    ){
}
