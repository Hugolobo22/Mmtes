package com.mmtes.Mmtes.dtos;

import com.mmtes.Mmtes.models.entities.Tarefa;

import java.util.Date;

public record TarefaResponseDTO(
    Long id,
    Long idUsuario,
    String titulo,
    String descricao,
    String prioridade,
    Date prazo,
    Boolean concluida,
    Date dataCriacao,
    Date dataConclusao
) {
    TarefaResponseDTO(Tarefa tarefa){
        this(tarefa.getId_tarefa(), tarefa.getUsuario().getId_usuario(), tarefa.getTitulo(),
                tarefa.getDescricao(), tarefa.getPrioridade().name(), tarefa.getPrazo(),
                tarefa.getConcluida(), tarefa.getData_criacao(), tarefa.getData_conclusao());
    }
}
