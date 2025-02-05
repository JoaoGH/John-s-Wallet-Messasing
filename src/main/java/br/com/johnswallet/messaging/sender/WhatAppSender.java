package br.com.johnswallet.messaging.sender;

import br.com.johnswallet.messaging.dto.MensagemDTO;
import org.springframework.stereotype.Component;

@Component
public class WhatAppSender extends DefaultSender {

    @Override
    public void send(MensagemDTO dto) {
        if (!isEnabled()) {
            throw new RuntimeException("Nao habilidato");
        }
    }

    @Override
    public boolean isEnabled() {
        return Boolean.parseBoolean(environment.getProperty("wallet.tipos-cobranca.whatsapp"));
    }

}
