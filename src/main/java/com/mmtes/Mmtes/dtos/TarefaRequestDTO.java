package com.mmtes.Mmtes.dtos;

import java.util.Date;

import com.mmtes.Mmtes.models.entities.Prioridade;

import jakarta.validation.constraints.NotBlank;

public record TarefaRequestDTO(
    @NotBlank String titulo,
    @NotBlank String descricao, 
    @NotBlank Prioridade prioridade,
    @NotBlank Date prazo, 
    Date data_criacao
    ){
}
