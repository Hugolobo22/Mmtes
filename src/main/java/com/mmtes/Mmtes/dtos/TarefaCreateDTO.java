package com.mmtes.Mmtes.dtos;

import java.util.Date;

public record TarefaCreateDTO(
    Long idUsuario,
    String titulo,
    String descricao,
    String prioridade,
    Date prazo
) {}
