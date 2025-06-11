package com.mmtes.Mmtes.dtos;

public record CompartilhamentoTarefaDTO(
    Long id,
    Long idTarefa,
    Long idUsuarioDest,
    String permissao
) {}
