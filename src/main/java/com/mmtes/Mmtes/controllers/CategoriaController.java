package com.mmtes.Mmtes.controllers;

import com.mmtes.Mmtes.dtos.CategoriaDTO;
import com.mmtes.Mmtes.models.entities.Categoria;
import com.mmtes.Mmtes.services.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping
    public CategoriaDTO criar(@RequestBody CategoriaDTO dto) {
        Categoria c = new Categoria();
        c.setIdUsuario(dto.idUsuario());
        c.setNome(dto.nome());
        return toDTO(service.criar(c));
    }

    @GetMapping
    public List<CategoriaDTO> listar() {
        return service.listarTodas().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<CategoriaDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).map(this::toDTO);
    }

    @PutMapping("/{id}")
    public Optional<CategoriaDTO> atualizar(@PathVariable Long id, @RequestBody CategoriaDTO dto) {
        Categoria c = new Categoria();
        c.setIdUsuario(dto.idUsuario());
        c.setNome(dto.nome());
        return service.atualizar(id, c).map(this::toDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    private CategoriaDTO toDTO(Categoria c) {
        return new CategoriaDTO(c.getIdCategoria(), c.getIdUsuario(), c.getNome());
    }
}
