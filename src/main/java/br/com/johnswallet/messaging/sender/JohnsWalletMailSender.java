package br.com.johnswallet.messaging.sender;

import br.com.johnswallet.messaging.dto.MensagemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class JohnsWalletMailSender {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(MensagemDTO dto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreplay@johnswallet.com");
        message.setTo(dto.destinatario().email());
        message.setSubject(dto.mensagem().tipo());
        message.setText(dto.mensagem().conteudo());
        mailSender.send(message);
    }

}
