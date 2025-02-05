package br.com.johnswallet.messaging.rocketmq;

import br.com.johnswallet.messaging.dto.MensagemDTO;
import br.com.johnswallet.messaging.sender.JohnsWalletMailSender;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    private JohnsWalletMailSender mailSender;

    private static final String TOPIC = "johns-wallet";

    @RabbitListener(queues = TOPIC)
    public void onMessage(MensagemDTO message) {

        if (message.metodoEnvio().contains("EMAIL")) {
            mailSender.sendEmail(message);
        }

        if (message.metodoEnvio().contains("WHATSAPP")) {
            System.out.println("enviar WHATSAPP");
        }

        if (message.metodoEnvio().contains("SMS")) {
            System.out.println("enviar SMS");
        }

    }
}
