package com.mmtes.Mmtes.dtos;

import java.util.Date;

public record TarefaDTO(
    Long id,
    Long idUsuario,
    String titulo,
    String descricao,
    String prioridade,
    Date prazo,
    Boolean concluida,
    Date dataCriacao,
    Date dataConclusao
) {}
