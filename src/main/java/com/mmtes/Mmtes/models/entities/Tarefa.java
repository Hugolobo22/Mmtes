package com.mmtes.Mmtes.models.entities;

import jakarta.persistence.*;
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
    public Tarefa(TarefaCreateDTO body, Usuario usuario) {
        this.titulo = body.titulo();
        this.descricao = body.descricao();
        this.usuario = usuario;
        this.prioridade = body.prioridade();
        this.prazo = body.prazo();
        this.data_criacao = new Date();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarefa;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    private String titulo;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @OneToOne
    @JoinColumn(name = "idCategoria", nullable = false) 
    private Categoria categoria;

    private Date prazo;
    private Boolean concluida = false;
    private Date data_criacao = new Date();
    private Date data_conclusao;
}

