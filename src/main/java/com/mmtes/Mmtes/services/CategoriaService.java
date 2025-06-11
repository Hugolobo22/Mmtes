package com.mmtes.Mmtes.services;

import com.mmtes.Mmtes.models.entities.Categoria;
import com.mmtes.Mmtes.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria criarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Optional<Categoria> atualizarCategoria(Long id, Categoria novaCategoria) {
        return categoriaRepository.findById(id).map(categoria -> {
            categoria.setNome(novaCategoria.getNome());
            return categoriaRepository.save(categoria);
        });
    }

    public boolean deletarCategoria(Long id) {
        return categoriaRepository.findById(id).map(categoria -> {
            categoriaRepository.delete(categoria);
            return true;
        }).orElse(false);
    }
}
