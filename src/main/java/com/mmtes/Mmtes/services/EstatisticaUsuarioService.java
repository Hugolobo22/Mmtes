package com.mmtes.Mmtes.services;

import com.mmtes.Mmtes.models.entities.EstatisticaUsuario;
import com.mmtes.Mmtes.repositories.EstatisticaUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstatisticaUsuarioService {

    @Autowired
    private EstatisticaUsuarioRepository repository;

    public EstatisticaUsuario criar(EstatisticaUsuario estatistica) {
        return repository.save(estatistica);
    }

    public List<EstatisticaUsuario> listarTodas() {
        return repository.findAll();
    }

    public Optional<EstatisticaUsuario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<EstatisticaUsuario> atualizar(Long id, EstatisticaUsuario nova) {
        return repository.findById(id).map(e -> {
            e.setTarefas_concluidas(nova.getTarefas_concluidas());
            e.setMedia_conclusao(nova.getMedia_conclusao());
            e.setPeriodo_inicio(nova.getPeriodo_inicio());
            e.setPeriodo_fim(nova.getPeriodo_fim());
            return repository.save(e);
        });
    }

    public boolean deletar(Long id) {
        return repository.findById(id).map(e -> {
            repository.delete(e);
            return true;
        }).orElse(false);
    }
}
