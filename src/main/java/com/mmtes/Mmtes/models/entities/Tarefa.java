package com.mmtes.Mmtes.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "tarefa")
@Data
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tarefa;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    private String titulo;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    private Date prazo;
    private Boolean concluida = false;
    private Date data_criacao;
    private Date data_conclusao;
}

