package com.mmtes.Mmtes.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmtes.Mmtes.dtos.CategoriaCreateDTO;
import com.mmtes.Mmtes.dtos.CategoriaResponseDTO;
import com.mmtes.Mmtes.dtos.TarefaResponseDTO;
import com.mmtes.Mmtes.models.entities.Categoria;
import com.mmtes.Mmtes.models.entities.Tarefa;
import com.mmtes.Mmtes.models.entities.Usuario;
import com.mmtes.Mmtes.repository.UsuarioRepository;

import jakarta.validation.Valid;

import com.mmtes.Mmtes.repository.CategoriaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping ("categoria")
public class CategoriaController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/mostrar")
    public ResponseEntity getCategoriaByUsuarioAutenticado() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        Usuario usuario = usuarioRepository.findByLogin(login);
        if (usuario == null) {
            return ResponseEntity.status(401).build();
        }

        List<Categoria> categorias = categoriaRepository.findByUsuarioIdUsuario(usuario.getIdUsuario());
        List<CategoriaResponseDTO> categoriaList = categorias.stream().map(CategoriaResponseDTO::new).toList();
        return ResponseEntity.ok(categoriaList);
    }
    
    @PostMapping("/criar")
    public ResponseEntity createCategoria(@RequestBody @Valid CategoriaCreateDTO body){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        Usuario usuario = usuarioRepository.findByLogin(login);
        if (usuario == null) {
            return ResponseEntity.status(401).build();
        }

        Categoria categoria = new Categoria(body, usuario);
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }
}