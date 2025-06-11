package com.mmtes.Mmtes.controllers;

import com.mmtes.Mmtes.dtos.UsuarioCreateDTO;
import com.mmtes.Mmtes.dtos.UsuarioDTO;
import com.mmtes.Mmtes.models.entities.Usuario;
import com.mmtes.Mmtes.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public UsuarioDTO criar(@RequestBody UsuarioCreateDTO dto) {
        Usuario novo = new Usuario();
        novo.setNome(dto.nome());
        novo.setEmail(dto.email());
        novo.setSenha(dto.senha());
        return toDTO(service.criarUsuario(novo));
    }

    @GetMapping
    public List<UsuarioDTO> listar() {
        return service.listarUsuarios()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<UsuarioDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).map(this::toDTO);
    }

    @PutMapping("/{id}")
    public Optional<UsuarioDTO> atualizar(@PathVariable Long id, @RequestBody UsuarioCreateDTO dto) {
        Usuario u = new Usuario();
        u.setNome(dto.nome());
        u.setEmail(dto.email());
        u.setSenha(dto.senha());
        return service.atualizarUsuario(id, u).map(this::toDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletarUsuario(id);
    }

    private UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId_usuario(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getDataCadastro()
        );
    }
}
