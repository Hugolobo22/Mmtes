package com.mmtes.Mmtes.services;

import com.mmtes.Mmtes.models.entities.Tarefa;
import com.mmtes.Mmtes.repositories.TarefaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa criarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    public Optional<Tarefa> atualizarTarefa(Long id, Tarefa novaTarefa) {
        return tarefaRepository.findById(id).map(tarefa -> {
            tarefa.setTitulo(novaTarefa.getTitulo());
            tarefa.setDescricao(novaTarefa.getDescricao());
            tarefa.setPrioridade(novaTarefa.getPrioridade());
            tarefa.setPrazo(novaTarefa.getPrazo());
            tarefa.setConcluida(novaTarefa.getConcluida());
            tarefa.setData_conclusao(novaTarefa.getData_conclusao());
            return tarefaRepository.save(tarefa);
        });
    }

    public boolean deletarTarefa(Long id) {
        return tarefaRepository.findById(id).map(tarefa -> {
            tarefaRepository.delete(tarefa);
            return true;
        }).orElse(false);
    }
}
