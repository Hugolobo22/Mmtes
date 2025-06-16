package com.mmtes.Mmtes.dtos;

import java.util.Date;

import com.mmtes.Mmtes.models.entities.Prioridade;


public record TarefaCreateDTO(
    String titulo,
    String descricao,
    Long idUsuario,
    Prioridade prioridade,
    Date prazo, 
    Date data_criacao
) {}
