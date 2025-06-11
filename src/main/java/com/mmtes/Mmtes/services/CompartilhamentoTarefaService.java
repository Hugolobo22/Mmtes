package com.mmtes.Mmtes.services;

import com.mmtes.Mmtes.models.entities.CompartilhamentoTarefa;
import com.mmtes.Mmtes.repositories.CompartilhamentoTarefaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompartilhamentoTarefaService {

    @Autowired
    private CompartilhamentoTarefaRepository repository;

    public CompartilhamentoTarefa criar(CompartilhamentoTarefa compartilhamento) {
        return repository.save(compartilhamento);
    }

    public List<CompartilhamentoTarefa> listarTodos() {
        return repository.findAll();
    }

    public Optional<CompartilhamentoTarefa> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<CompartilhamentoTarefa> atualizar(Long id, CompartilhamentoTarefa atualizado) {
        return repository.findById(id).map(comp -> {
            comp.setTarefa(atualizado.getTarefa());
            comp.setUsuarioDestino(atualizado.getUsuarioDestino());
            comp.setPermissao(atualizado.getPermissao());
            return repository.save(comp);
        });
    }

    public boolean deletar(Long id) {
        return repository.findById(id).map(c -> {
            repository.delete(c);
            return true;
        }).orElse(false);
    }
}
