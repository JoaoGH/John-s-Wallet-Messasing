package br.com.johnswallet.messaging.sender;

import br.com.johnswallet.messaging.dto.MensagemDTO;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SMSSender {

    @Value("${twilio.account-sid}")
    private String ACCOUNT_SID;

    @Value("${twilio.auth-token}")
    private String AUTH_TOKEN;

    @Value("${twilio.number}")
    private String NUMBER;

    public void sendSms(MensagemDTO dto) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new PhoneNumber(dto.destinatario().telefone()),
                        new PhoneNumber(NUMBER),
                        dto.mensagem().conteudo())
                .create();

        message.getSid();
    }
}
