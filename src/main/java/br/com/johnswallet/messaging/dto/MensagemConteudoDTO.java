package br.com.johnswallet.messaging.dto;

public record MensagemConteudoDTO(
        String tipo,
        String conteudo,
        String imagemUrl
) {
}
