# Assistente Financeiro Inteligente

> **Status do projeto:** 🚧 Em desenvolvimento

Sistema pessoal de gestão e análise financeira com inteligência artificial, desenvolvido para centralizar informações financeiras, analisar padrões de consumo e auxiliar na tomada de decisões relacionadas ao dinheiro.

O projeto tem como objetivo construir um assistente financeiro capaz de interpretar dados bancários, acompanhar receitas e despesas, identificar comportamentos de consumo e ajudar no planejamento de metas financeiras.

**Atenção:** este projeto ainda está em desenvolvimento. As funcionalidades descritas neste documento representam objetivos e planejamento, não necessariamente recursos já implementados ou disponíveis.

---

## 🎯 Objetivo

Desenvolver um assistente financeiro pessoal que utilize inteligência artificial para transformar dados financeiros em informações úteis e recomendações práticas.

A proposta é ir além de um simples controle de gastos: o sistema deverá compreender o histórico financeiro, identificar padrões e auxiliar no planejamento do patrimônio.

### Funcionalidades planejadas

- [ ] Centralização de informações financeiras.
- [ ] Integração bancária por meio do Open Finance.
- [ ] Importação e organização de transações.
- [ ] Classificação de receitas e despesas.
- [ ] Análise de padrões de consumo.
- [ ] Identificação de gastos recorrentes e possíveis desperdícios.
- [ ] Identificação de possíveis compras impulsivas.
- [ ] Recomendações personalizadas para redução de despesas.
- [ ] Planejamento de economia e investimentos.
- [ ] Acompanhamento de metas financeiras.
- [ ] Histórico de análises e recomendações.
- [ ] Assistente conversacional com inteligência artificial.

---

## 🛠️ Tecnologias

As tecnologias previstas para o desenvolvimento incluem:

| Tecnologia | Finalidade |
|---|---|
| Java | Linguagem principal do backend |
| Spring Boot | Desenvolvimento da aplicação e APIs |
| Spring Security | Autenticação e autorização |
| PostgreSQL | Banco de dados relacional |
| JSON | Estruturação e comunicação de dados |
| Gemini API | Integração com inteligência artificial |
| Open Finance | Obtenção autorizada de dados financeiros |

A arquitetura poderá ser adaptada conforme a evolução do projeto.

---

## 🏗️ Arquitetura planejada

A aplicação será organizada em camadas, separando responsabilidades para facilitar manutenção, segurança e evolução.

```text
                    FRONTEND
                       |
                       v
                SPRING BOOT API
                       |
          +------------+------------+
          |            |            |
          v            v            v
       SECURITY     SERVICES      AI SERVICE
          |            |            |
          |            v            v
          |        PROCESSAMENTO   GEMINI API
          |        FINANCEIRO
          |            |
          +------------+
                       |
                       v
                  POSTGRESQL
                       |
                       v
                  OPEN FINANCE
```

*Representação conceitual da arquitetura desejada. A implementação poderá sofrer alterações.*

---

## 🤖 Inteligência artificial

A inteligência artificial será utilizada como camada de interpretação e análise dos dados financeiros.

O objetivo é permitir que o usuário converse com o assistente em linguagem natural e obtenha respostas contextualizadas sobre sua situação financeira.

### Exemplos de funcionalidades desejadas

- "Quanto gastei com alimentação neste mês?"
- "Onde estou gastando mais dinheiro?"
- "Quais despesas posso reduzir?"
- "Quanto consigo guardar mensalmente?"
- "Estou mantendo uma boa evolução patrimonial?"
- "Quanto tempo levaria para atingir minha meta financeira?"

A IA deverá trabalhar com informações previamente selecionadas pelo backend, sem acesso direto ao banco de dados ou a credenciais financeiras.

Os cálculos e validações financeiras serão realizados pela aplicação, evitando depender exclusivamente das respostas geradas pelo modelo.

---

## 🔐 Segurança e privacidade

Como o sistema poderá processar informações financeiras pessoais, segurança será um dos principais requisitos do projeto.

### Medidas previstas

- [ ] Autenticação segura.
- [ ] Autenticação multifator (MFA).
- [ ] Controle de acesso baseado em permissões.
- [ ] Criptografia de informações sensíveis.
- [ ] Proteção de credenciais e tokens bancários.
- [ ] Banco de dados sem exposição pública.
- [ ] Controle de sessões e dispositivos.
- [ ] Registro de eventos e auditoria.
- [ ] Backups criptografados.
- [ ] Proteção contra ataques comuns a aplicações web.
- [ ] Monitoramento de eventos suspeitos.
- [ ] Testes de segurança antes da utilização com dados bancários reais.

**Princípio de segurança:** nenhum sistema pode ser considerado inviolável. O projeto deverá adotar camadas de proteção para reduzir riscos, limitar danos e permitir recuperação em caso de incidentes.

---

## 👥 Controle de usuários

O sistema será desenvolvido considerando mais de uma conta de acesso, mas mantendo um único proprietário das informações financeiras.

A estrutura inicialmente planejada contempla:

- **Administrador:** proprietário dos dados financeiros, responsável pelas integrações bancárias e configurações administrativas.
- **Usuário autorizado:** poderá acessar o assistente, consultar informações financeiras e interagir com a inteligência artificial, respeitando as permissões definidas pelo administrador.

As permissões deverão ser verificadas no backend, nunca exclusivamente na interface.

---

## 🏦 Integração com Open Finance

Uma das funcionalidades futuras será a integração com o Open Finance para obter informações bancárias mediante autorização do titular.

A integração deverá permitir, conforme a disponibilidade do provedor e das instituições:

- Consulta de contas bancárias.
- Importação de transações.
- Consulta de saldos.
- Identificação de receitas e despesas.
- Atualização periódica das informações.

O acesso dependerá de consentimento válido e das condições oferecidas pelo provedor de integração. A disponibilidade de dados históricos poderá variar.

---

## 📊 Inteligência financeira

Além de organizar informações, o sistema deverá desenvolver mecanismos para interpretar o comportamento financeiro ao longo do tempo.

Entre os objetivos estão:

- Identificar categorias com maior concentração de despesas.
- Comparar períodos financeiros.
- Detectar alterações relevantes nos hábitos de consumo.
- Identificar despesas recorrentes.
- Avaliar a capacidade de economia.
- Projetar evolução patrimonial.
- Sugerir estratégias para alcançar objetivos financeiros.

As recomendações deverão considerar o histórico, as metas e o contexto financeiro registrado no sistema.

---

## 🗄️ Banco de dados

O PostgreSQL será utilizado como banco de dados principal.

A modelagem deverá contemplar entidades como:

- Usuários e permissões.
- Contas financeiras.
- Cartões.
- Transações.
- Categorias.
- Receitas e despesas.
- Metas financeiras.
- Dívidas.
- Investimentos.
- Conexões bancárias.
- Perfil financeiro.
- Análises realizadas pela IA.
- Recomendações.
- Feedback do usuário.
- Logs de auditoria e eventos de segurança.

A estrutura definitiva será estabelecida durante a implementação.

---

## 🗺️ Roadmap

O desenvolvimento será realizado gradualmente, priorizando a estrutura e a segurança antes da utilização de dados financeiros reais.

- [ ] **Fase 1 — Estrutura inicial:** organização do projeto, arquitetura e modelagem do banco de dados.
- [ ] **Fase 2 — Autenticação:** implementação de usuários, permissões e segurança.
- [ ] **Fase 3 — Banco de dados:** implementação das entidades e relacionamentos.
- [ ] **Fase 4 — Infraestrutura:** preparação do ambiente de hospedagem.
- [ ] **Fase 5 — Controle de acesso:** implementação dos diferentes níveis de usuários.
- [ ] **Fase 6 — Open Finance:** integração com provedor autorizado.
- [ ] **Fase 7 — Dados financeiros:** importação, organização e processamento do histórico.
- [ ] **Fase 8 — Inteligência artificial:** integração com Gemini API e memória persistente.
- [ ] **Fase 9 — Análise comportamental:** identificação de padrões e oportunidades de economia.
- [ ] **Fase 10 — Planejamento financeiro:** metas, projeções e acompanhamento patrimonial.
- [ ] **Fase 11 — Auditoria e testes:** validação funcional, testes de segurança e recuperação.

---

## 📌 Situação atual

O projeto encontra-se em fase de desenvolvimento e estruturação.

As tecnologias, funcionalidades e arquitetura descritas neste README representam o direcionamento atual do projeto. Recursos poderão ser adicionados, modificados ou removidos durante a implementação.

Ainda não deve ser considerado um sistema financeiro pronto para produção.

---

## 📄 Licença

Licença ainda não definida.

---

**Projeto pessoal — Assistente Financeiro Inteligente**

*Desenvolvido com Java, Spring Boot, PostgreSQL e inteligência artificial.*
