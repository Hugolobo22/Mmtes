package com.mmtes.Mmtes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmtes.Mmtes.dtos.TarefaCreateDTO;
import com.mmtes.Mmtes.dtos.TarefaRequestDTO;
import com.mmtes.Mmtes.dtos.TarefaResponseDTO;
import com.mmtes.Mmtes.models.entities.Tarefa;
import com.mmtes.Mmtes.repository.TarefaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("tarefa")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    @GetMapping("mostrar/{idUsuario}")
    public ResponseEntity getTarefasByUsuario(@PathVariable Long idUsuario){
        List<Tarefa> tarefas = repository.findByUsuarioIdUsuario(idUsuario);
        List<TarefaResponseDTO> tarefaList = tarefas.stream().map(TarefaResponseDTO::new).toList();
        return ResponseEntity.ok(tarefaList);
    }

    @PostMapping("criar")
    public ResponseEntity createTarefa(@RequestBody @Valid TarefaCreateDTO body){
            Tarefa tarefa = new Tarefa(body);
            this.repository.save(tarefa);
            return ResponseEntity.ok().build();
        }

        @PutMapping("editar/{id}")
        public ResponseEntity<Void> updateTarefa(@PathVariable Long id, @RequestBody @Valid TarefaRequestDTO body) {
        Tarefa tarefa = repository.findById(id).orElse(null);

        if (tarefa == null) {
            return ResponseEntity.notFound().build();
        }

        tarefa.setTitulo(body.titulo());
        tarefa.setDescricao(body.descricao());
        tarefa.setPrioridade(body.prioridade());
        tarefa.setPrazo(body.prazo());

        repository.save(tarefa);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Void> deleteTarefa(@PathVariable Long id) {
        Tarefa tarefa = repository.findById(id).orElse(null);

        if (tarefa == null) {
            return ResponseEntity.notFound().build();
        }

        repository.delete(tarefa);
        return ResponseEntity.ok().build();
    }
}
