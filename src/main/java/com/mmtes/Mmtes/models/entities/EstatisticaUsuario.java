package com.mmtes.Mmtes.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "estatistica_usuario")
@Data
public class EstatisticaUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estatistica;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private Integer tarefas_concluidas;
    private Double media_conclusao;
    private Date periodo_inicio;
    private Date periodo_fim;
}
