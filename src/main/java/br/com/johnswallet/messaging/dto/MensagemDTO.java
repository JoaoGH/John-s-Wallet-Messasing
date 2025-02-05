package br.com.johnswallet.messaging.dto;

import java.util.List;

public record MensagemDTO(
        String id,
        DestinatarioDTO destinatario,
        MensagemConteudoDTO mensagem,
        List<String> metodoEnvio,
        MetadadosDTO metadados) {
}
