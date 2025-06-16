package com.mmtes.Mmtes.dtos;

import java.util.Date;

import com.mmtes.Mmtes.models.entities.Prioridade;
import com.mmtes.Mmtes.models.entities.Tarefa;

public record TarefaResponseDTO(Long id_tarefa, String titulo, String descricao, Prioridade prioridade, Date prazo, Boolean concluida, Date data_criacao, Date data_conclusao) {

    public TarefaResponseDTO(Tarefa tarefa){
        this(tarefa.getId_tarefa(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getPrioridade(), tarefa.getPrazo(), tarefa.getConcluida(), tarefa.getData_criacao(), tarefa.getData_conclusao());
    }
}
