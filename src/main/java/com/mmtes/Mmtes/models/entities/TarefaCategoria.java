package com.mmtes.Mmtes.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tarefa_categoria")
@IdClass(TarefaCategoriaId.class)
@Data
@NoArgsConstructor
public class TarefaCategoria {

    @Id
    @ManyToOne
    @JoinColumn(name = "idTarefa")
    private Tarefa tarefa;

    @Id
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
}
