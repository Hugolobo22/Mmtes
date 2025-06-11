package com.mmtes.Mmtes.services;

import com.mmtes.Mmtes.models.entities.TarefaCategoria;
import com.mmtes.Mmtes.models.entities.TarefaCategoriaId;
import com.mmtes.Mmtes.repositories.TarefaCategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaCategoriaService {

    @Autowired
    private TarefaCategoriaRepository repository;

    public TarefaCategoria criar(TarefaCategoria tarefaCategoria) {
        return repository.save(tarefaCategoria);
    }

    public List<TarefaCategoria> listarTodos() {
        return repository.findAll();
    }

    public Optional<TarefaCategoria> buscarPorId(TarefaCategoriaId id) {
        return repository.findById(id);
    }

    public boolean deletarPorId(TarefaCategoriaId id) {
        return repository.findById(id).map(tc -> {
            repository.delete(tc);
            return true;
        }).orElse(false);
    }
}
