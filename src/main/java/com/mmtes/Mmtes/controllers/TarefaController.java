package com.mmtes.Mmtes.controllers;

import com.mmtes.Mmtes.dtos.TarefaRequestDTO;
import com.mmtes.Mmtes.dtos.TarefaResponseDTO;
import com.mmtes.Mmtes.models.entities.Tarefa;
import com.mmtes.Mmtes.services.TarefaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @PostMapping
    public TarefaResponseDTO criar(@RequestBody TarefaRequestDTO dto) {
        Tarefa tarefa = new Tarefa();
        tarefa.setUsuario(dto.idUsuario());
        tarefa.setTitulo(dto.titulo());
        tarefa.setDescricao(dto.descricao());
        tarefa.setPrioridade(dto.prioridade());
        tarefa.setPrazo(dto.prazo());
        tarefa.setConcluida(false);
        return toDTO(service.criarTarefa(tarefa));
    }

    @GetMapping
    public List<TarefaResponseDTO> listar() {
        return service.listarTodas().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<TarefaResponseDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).map(this::toDTO);
    }

    @PutMapping("/{id}")
    public Optional<TarefaResponseDTO> atualizar(@PathVariable Long id, @RequestBody TarefaRequestCreateDTO dto) {
        Tarefa t = new Tarefa();
        t.setIdUsuario(dto.idUsuario());
        t.setTitulo(dto.titulo());
        t.setDescricao(dto.descricao());
        t.setPrioridade(dto.prioridade());
        t.setPrazo(dto.prazo());
        return service.atualizar(id, t).map(this::toDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    private TarefaDTO toDTO(Tarefa t) {
        return new TarefaDTO(
                t.getIdTarefa(),
                t.getIdUsuario(),
                t.getTitulo(),
                t.getDescricao(),
                t.getPrioridade(),
                t.getPrazo(),
                t.getConcluida(),
                t.getDataCriacao(),
                t.getDataConclusao()
        );
    }
}
