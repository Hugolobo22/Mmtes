package com.mmtes.Mmtes.models.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

import com.mmtes.Mmtes.dtos.TarefaCreateDTO;
import com.mmtes.Mmtes.dtos.TarefaRequestDTO;

@Entity
@Table(name = "tarefa")
@Data
@AllArgsConstructor
public class Tarefa {

    public Tarefa(TarefaRequestDTO body) {}
    public Tarefa(TarefaCreateDTO body) {}
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tarefa;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    private String titulo;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    private Date prazo;
    private Boolean concluida = false;
    private Date data_criacao = new Date();
    private Date data_conclusao;
}

