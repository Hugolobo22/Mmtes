package com.mmtes.Mmtes.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarefaCategoriaId implements Serializable {
    private Long tarefa;
    private Long categoria;
}
