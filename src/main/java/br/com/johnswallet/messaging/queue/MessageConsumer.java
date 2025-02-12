package br.com.johnswallet.messaging.queue;

import br.com.johnswallet.messaging.dto.MensagemDTO;
import br.com.johnswallet.messaging.sender.JohnsWalletMailSender;
import br.com.johnswallet.messaging.sender.SMSSender;
import br.com.johnswallet.messaging.sender.WhatAppSender;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    private JohnsWalletMailSender mailSender;

    @Autowired
    private SMSSender smsSender;

    @Autowired
    private WhatAppSender whatAppSender;

    private static final String TOPIC = "johns-wallet";

    @RabbitListener(queues = TOPIC)
    public void onMessage(MensagemDTO message) {

        if (message.metodoEnvio().contains("EMAIL") && mailSender.isEnabled()) {
            mailSender.send(message);
        }

        if (message.metodoEnvio().contains("WHATSAPP") && whatAppSender.isEnabled()) {
            System.out.println("enviar WHATSAPP");
        }

        if (message.metodoEnvio().contains("SMS") && smsSender.isEnabled()) {
            smsSender.send(message);
        }

    }
}
