package br.com.johnswallet.messaging.dto;

import java.time.LocalDateTime;

public record MetadadosDTO(
        LocalDateTime dataCriacao,
        String vencimento
) {
}
