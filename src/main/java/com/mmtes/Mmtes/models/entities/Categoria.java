package com.mmtes.Mmtes.models.entities;

import com.mmtes.Mmtes.dtos.CategoriaCreateDTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "categoria")
@Data
@AllArgsConstructor
public class Categoria {

    @Id
    @Column(name = "id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    private String nome;

    private String descricao;

    public Categoria(CategoriaCreateDTO body, Usuario usuario) {
        this.nome = body.nome();
        this.descricao = body.descricao();
        this.usuario = usuario;
    }
}