package com.mmtes.Mmtes.controllers;

import com.mmtes.Mmtes.dtos.CompartilhamentoTarefaDTO;
import com.mmtes.Mmtes.models.entities.CompartilhamentoTarefa;
import com.mmtes.Mmtes.services.CompartilhamentoTarefaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/compartilhamentos")
public class CompartilhamentoTarefaController {

    @Autowired
    private CompartilhamentoTarefaService service;

    @PostMapping
    public CompartilhamentoTarefaDTO criar(@RequestBody CompartilhamentoTarefaDTO dto) {
        CompartilhamentoTarefa c = new CompartilhamentoTarefa();
        c.setTarefaId(dto.idTarefa());
        c.setUsuarioDestId(dto.idUsuarioDest());
        c.setPermissao(dto.permissao());
        return toDTO(service.criar(c));
    }

    @GetMapping
    public List<CompartilhamentoTarefaDTO> listar() {
        return service.listarTodos().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<CompartilhamentoTarefaDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).map(this::toDTO);
    }

    @PutMapping("/{id}")
    public Optional<CompartilhamentoTarefaDTO> atualizar(@PathVariable Long id, @RequestBody CompartilhamentoTarefaDTO dto) {
        CompartilhamentoTarefa c = new CompartilhamentoTarefa();
        c.setTarefaId(dto.idTarefa());
        c.setUsuarioDestId(dto.idUsuarioDest());
        c.setPermissao(dto.permissao());
        return service.atualizar(id, c).map(this::toDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    private CompartilhamentoTarefaDTO toDTO(CompartilhamentoTarefa c) {
        return new CompartilhamentoTarefaDTO(c.getId(), c.getTarefaId(), c.getUsuarioDestId(), c.getPermissao());
    }
}
