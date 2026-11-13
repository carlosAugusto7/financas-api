package com.financas.sistema.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.math.BigDecimal;
import java.util.Map;
import java.util.List;

@Service
public class GeminiService {

    private final RestClient restClient;
    
    @Value("${gemini.api.key}")
    private String apiKey;

    public GeminiService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("https://generativelanguage.googleapis.com/v1beta")
                .build();
    }

    public String analisarTransacao(String descricao, BigDecimal valor) {
        String prompt = String.format("""
            Você é um assistente financeiro pessoal. Analise a seguinte transação bancária:
            Descrição: "%s" | Valor: R$ %s
            
            Retorne APENAS um JSON no formato:
            {
              "categoria": "Comida|Restaurante|Transporte|Lazer|Supermercado|Outros",
              "requerPerguntanecessidade": true ou false,
              "perguntaSugerida": "Frase direta perguntando se foi uma compra por necessidade ou vontade própria"
            }
            """, descricao, valor.toString());

        Map<String, Object> requestBody = Map.of(
            "contents", List.of(
                Map.of("parts", List.of(Map.of("text", prompt)))
            )
        );

        return restClient.post()
                .uri("/models/gemini-1.5-flash:generateContent?key=" + apiKey)
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestBody)
                .retrieve()
                .body(String.class);
    }
}