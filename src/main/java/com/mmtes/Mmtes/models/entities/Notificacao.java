package com.mmtes.Mmtes.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "notificacao")
@Data
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_notificacao;

    @ManyToOne
    @JoinColumn(name = "id_tarefa")
    private Tarefa tarefa;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private Date data_hora_envio;
    private Boolean enviada;
}
