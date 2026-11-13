package com.financas.sistema.domain.model;

import com.financas.sistema.domain.enums.TipoClassificacao;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_transacoes")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDateTime dataTransacao;

    private String categoria;

    private String bancoOrigem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoClassificacao classificacao;

    @Column(length = 500)
    private String perguntaIa;

    @ManyToOne
    @JoinColumn(name = "usuario_resposta_id")
    private Usuario respondidoPor;
}