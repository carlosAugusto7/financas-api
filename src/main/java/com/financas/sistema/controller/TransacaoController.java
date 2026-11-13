package com.financas.sistema.controller;

import com.financas.sistema.domain.model.Transacao;
import com.financas.sistema.dto.RespostaIaDTO;
import com.financas.sistema.dto.TransacaoRequestDTO;
import com.financas.sistema.service.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Transacao> criarTransacao(@RequestBody TransacaoRequestDTO dto) {
        Transacao novaTransacao = transacaoService.registrarNovaTransacao(
                dto.descricao(),
                dto.valor(),
                dto.bancoOrigem()
        );
        return ResponseEntity.ok(novaTransacao);
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> listarTodas() {
        return ResponseEntity.ok(transacaoService.listarTodas());
    }

    @GetMapping("/pendentes")
    public ResponseEntity<List<Transacao>> listarPendentes() {
        return ResponseEntity.ok(transacaoService.listarPendentes());
    }

    @PostMapping("/{id}/responder")
    public ResponseEntity<Transacao> responderPergunta(
            @PathVariable Long id,
            @RequestBody RespostaIaDTO dto) {
        Transacao transacaoAtualizada = transacaoService.responderPerguntaIa(id, dto.usuarioId(), dto.resposta());
        return ResponseEntity.ok(transacaoAtualizada);
    }
}