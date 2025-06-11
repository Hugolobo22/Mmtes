package com.mmtes.Mmtes.dtos;

import com.mmtes.Mmtes.models.entities.Prioridade;
import com.mmtes.Mmtes.models.entities.Tarefa;

import java.time.LocalDateTime;


public record TarefaRequestDTO(
        Long idUsuario,
        String titulo,
        String descricao,
        Prioridade prioridade,
        LocalDateTime prazo,
        Boolean concluida,
        LocalDateTime dataCriacao,
        LocalDateTime dataConclusao
) {
    TarefaRequestDTO(Tarefa tarefa){
        this(tarefa.getUsuario().getId_usuario(), tarefa.getTitulo(),
                tarefa.getDescricao(), tarefa.getPrioridade().name(), tarefa.getPrazo(),
                tarefa.getConcluida(), tarefa.getData_criacao(), tarefa.getData_conclusao());
    }
}

