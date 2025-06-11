package com.mmtes.Mmtes.services;

import com.mmtes.Mmtes.dtos.UsuarioDTO;
import com.mmtes.Mmtes.models.entities.Usuario;
import com.mmtes.Mmtes.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Criar novo usuário
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Buscar todos os usuários
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll().stream().map(UsuarioDTO::new).toList();
    }

    // Buscar por ID
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Atualizar usuário
    public Optional<Usuario> atualizarUsuario(Long id, Usuario dadosAtualizados) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNome(dadosAtualizados.getNome());
            usuario.setEmail(dadosAtualizados.getEmail());
            usuario.setSenha(dadosAtualizados.getSenha());
            return usuarioRepository.save(usuario);
        });
    }

    // Deletar usuário
    public boolean deletarUsuario(Long id) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuarioRepository.delete(usuario);
            return true;
        }).orElse(false);
    }

    // Buscar por e-mail (exemplo de método adicional útil)
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findAll().stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }
}
