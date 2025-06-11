package com.mmtes.Mmtes.dtos;

import java.util.Date;

public record EstatisticaUsuarioDTO(
    Long id,
    Long idUsuario,
    int tarefasConcluidas,
    double mediaConclusao,
    Date periodoInicio,
    Date periodoFim
) {}
