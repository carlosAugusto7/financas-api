package com.financas.sistema.repository;

import com.financas.sistema.domain.model.Transacao;
import com.financas.sistema.domain.enums.TipoClassificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByClassificacao(TipoClassificacao classificacao);
}