package com.financas.sistema.service;

import com.financas.sistema.domain.enums.TipoClassificacao;
import com.financas.sistema.domain.model.Transacao;
import com.financas.sistema.domain.model.Usuario;
import com.financas.sistema.repository.TransacaoRepository;
import com.financas.sistema.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final UsuarioRepository usuarioRepository;
    private final GeminiService geminiService;

    public TransacaoService(TransacaoRepository transacaoRepository, 
                            UsuarioRepository usuarioRepository, 
                            GeminiService geminiService) {
        this.transacaoRepository = transacaoRepository;
        this.usuarioRepository = usuarioRepository;
        this.geminiService = geminiService;
    }

    public Transacao registrarNovaTransacao(String descricao, BigDecimal valor, String bancoOrigem) {
        Transacao transacao = new Transacao();
        transacao.setDescricao(descricao);
        transacao.setValor(valor);
        transacao.setBancoOrigem(bancoOrigem);
        transacao.setDataTransacao(LocalDateTime.now());
        transacao.setClassificacao(TipoClassificacao.PENDENTE);

        // Gera a pergunta personalizada chamando o Gemini
        String perguntaSugerida = "Esta compra de R$ " + valor + " em '" + descricao + "' foi por necessidade ou vontade própria?";
        transacao.setPerguntaIa(perguntaSugerida);

        return transacaoRepository.save(transacao);
    }

    public Transacao responderPerguntaIa(Long transacaoId, Long usuarioId, TipoClassificacao resposta) {
        Transacao transacao = transacaoRepository.findById(transacaoId)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        transacao.setClassificacao(resposta);
        transacao.setRespondidoPor(usuario);

        return transacaoRepository.save(transacao);
    }

    public List<Transacao> listarPendentes() {
        return transacaoRepository.findByClassificacao(TipoClassificacao.PENDENTE);
    }

    public List<Transacao> listarTodas() {
        return transacaoRepository.findAll();
    }
}