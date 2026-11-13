package com.financas.sistema.dto;

import com.financas.sistema.domain.enums.TipoClassificacao;

public record RespostaIaDTO(
    Long usuarioId,
    TipoClassificacao resposta
) {}