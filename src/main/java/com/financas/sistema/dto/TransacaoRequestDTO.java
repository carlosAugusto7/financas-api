package com.financas.sistema.dto;

import java.math.BigDecimal;

public record TransacaoRequestDTO(
    String descricao,
    BigDecimal valor,
    String bancoOrigem
) {}