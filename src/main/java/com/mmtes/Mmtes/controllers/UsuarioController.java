package com.mmtes.Mmtes.controllers;


import com.mmtes.Mmtes.dtos.UsuarioRequestDTO;
import com.mmtes.Mmtes.dtos.UsuarioResponseDTO;
import com.mmtes.Mmtes.models.entities.Usuario;
import com.mmtes.Mmtes.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @CrossOrigin(origins = "*", allowCredentials = "false")
    @PostMapping
    public void saveUsuario(@RequestBody UsuarioRequestDTO data){
        Usuario usuarioData = new Usuario(data);
        repository.save(usuarioData);
        return;
    }

    @CrossOrigin(origins = "*", allowCredentials = "false")
    @GetMapping
    public List<UsuarioResponseDTO> getAll(){

        List<UsuarioResponseDTO> usuariosList = repository.findAll().stream()
        .map(UsuarioResponseDTO::new).toList();
        return usuariosList;
    }
}
