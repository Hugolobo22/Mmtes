package com.mmtes.Mmtes.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "compartilhamento_tarefa")
@Data
public class CompartilhamentoTarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_compartilhamento;

    @ManyToOne
    @JoinColumn(name = "idTarefa")
    private Tarefa tarefa;

    @ManyToOne
    @JoinColumn(name = "id_usuario_dest")
    private Usuario usuarioDestino;
}
