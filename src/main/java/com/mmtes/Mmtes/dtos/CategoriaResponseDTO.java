package com.mmtes.Mmtes.dtos;

import com.mmtes.Mmtes.models.entities.Categoria;

public record CategoriaResponseDTO(long idCategoria, String nome, String descricao) {
    public CategoriaResponseDTO(Categoria categoria){
        this(categoria.getIdCategoria(), categoria.getNome(), categoria.getDescricao());
    }
}
