package com.mmtes.Mmtes.dtos;

import java.util.Date;

public record NotificacaoDTO(
    Long id,
    Long idTarefa,
    Long idUsuario,
    Date dataHoraEnvio,
    Boolean enviada
) {}
