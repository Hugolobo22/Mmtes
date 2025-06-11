package com.mmtes.Mmtes.controllers;

import com.mmtes.Mmtes.dtos.NotificacaoDTO;
import com.mmtes.Mmtes.models.entities.Notificacao;
import com.mmtes.Mmtes.services.NotificacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoService service;

    @PostMapping
    public NotificacaoDTO criar(@RequestBody NotificacaoDTO dto) {
        Notificacao n = new Notificacao();
        n.setTarefaId(dto.idTarefa());
        n.setUsuarioId(dto.idUsuario());
        n.setDataHoraEnvio(dto.dataHoraEnvio() != null ? dto.dataHoraEnvio() : new Date());
        n.setEnviada(dto.enviada());
        return toDTO(service.criar(n));
    }

    @GetMapping
    public List<NotificacaoDTO> listar() {
        return service.listarTodas().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<NotificacaoDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).map(this::toDTO);
    }

    @PutMapping("/{id}")
    public Optional<NotificacaoDTO> atualizar(@PathVariable Long id, @RequestBody NotificacaoDTO dto) {
        Notificacao n = new Notificacao();
        n.setTarefaId(dto.idTarefa());
        n.setUsuarioId(dto.idUsuario());
        n.setDataHoraEnvio(dto.dataHoraEnvio());
        n.setEnviada(dto.enviada());
        return service.atualizar(id, n).map(this::toDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    private NotificacaoDTO toDTO(Notificacao n) {
        return new NotificacaoDTO(
                n.getIdNotificacao(),
                n.getTarefaId(),
                n.getUsuarioId(),
                n.getDataHoraEnvio(),
                n.getEnviada()
        );
    }
}
