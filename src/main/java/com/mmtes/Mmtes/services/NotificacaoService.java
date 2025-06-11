package com.mmtes.Mmtes.services;

import com.mmtes.Mmtes.models.entities.Notificacao;
import com.mmtes.Mmtes.repositories.NotificacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository repository;

    public Notificacao criar(Notificacao notificacao) {
        return repository.save(notificacao);
    }

    public List<Notificacao> listarTodas() {
        return repository.findAll();
    }

    public Optional<Notificacao> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Notificacao> atualizar(Long id, Notificacao nova) {
        return repository.findById(id).map(n -> {
            n.setUsuario(nova.getUsuario());
            n.setTarefa(nova.getTarefa());
            n.setData_hora_envio(nova.getData_hora_envio());
            n.setEnviada(nova.getEnviada());
            return repository.save(n);
        });
    }

    public boolean deletar(Long id) {
        return repository.findById(id).map(n -> {
            repository.delete(n);
            return true;
        }).orElse(false);
    }
}
