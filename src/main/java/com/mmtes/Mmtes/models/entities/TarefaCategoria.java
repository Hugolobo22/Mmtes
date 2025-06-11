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
    @JoinColumn(name = "id_tarefa")
    private Tarefa tarefa;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}
