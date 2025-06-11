package com.mmtes.Mmtes.controllers;

import com.mmtes.Mmtes.dtos.EstatisticaUsuarioDTO;
import com.mmtes.Mmtes.models.entities.EstatisticaUsuario;
import com.mmtes.Mmtes.services.EstatisticaUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticaUsuarioController {

    @Autowired
    private EstatisticaUsuarioService service;

    @PostMapping
    public EstatisticaUsuarioDTO criar(@RequestBody EstatisticaUsuarioDTO dto) {
        EstatisticaUsuario e = new EstatisticaUsuario();
        e.setIdUsuario(dto.idUsuario());
        e.setTarefasConcluidas(dto.tarefasConcluidas());
        e.setMediaConclusao(dto.mediaConclusao());
        e.setPeriodoInicio(dto.periodoInicio());
        e.setPeriodoFim(dto.periodoFim());
        return toDTO(service.criar(e));
    }

    @GetMapping
    public List<EstatisticaUsuarioDTO> listar() {
        return service.listarTodas().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<EstatisticaUsuarioDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).map(this::toDTO);
    }

    @PutMapping("/{id}")
    public Optional<EstatisticaUsuarioDTO> atualizar(@PathVariable Long id, @RequestBody EstatisticaUsuarioDTO dto) {
        EstatisticaUsuario e = new EstatisticaUsuario();
        e.setIdUsuario(dto.idUsuario());
        e.setTarefasConcluidas(dto.tarefasConcluidas());
        e.setMediaConclusao(dto.mediaConclusao());
        e.setPeriodoInicio(dto.periodoInicio());
        e.setPeriodoFim(dto.periodoFim());
        return service.atualizar(id, e).map(this::toDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    private EstatisticaUsuarioDTO toDTO(EstatisticaUsuario e) {
        return new EstatisticaUsuarioDTO(
                e.getIdEstatistica(),
                e.getIdUsuario(),
                e.getTarefasConcluidas(),
                e.getMediaConclusao(),
                e.getPeriodoInicio(),
                e.getPeriodoFim()
        );
    }
}
