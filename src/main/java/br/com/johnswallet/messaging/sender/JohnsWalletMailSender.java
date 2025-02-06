package br.com.johnswallet.messaging.sender;

import br.com.johnswallet.messaging.dto.MensagemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class JohnsWalletMailSender extends DefaultSender {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void send(MensagemDTO dto) {
        if (!isEnabled()) {
            throw new RuntimeException("Nao habilidato");
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreplay@johnswallet.com");
        message.setTo(dto.destinatario().email());
        message.setSubject(dto.mensagem().tipo());
        message.setText(dto.mensagem().conteudo());
        mailSender.send(message);
    }

    @Override
    public boolean isEnabled() {
        return Boolean.parseBoolean(environment.getProperty("wallet.tipos-cobranca.email"));
    }

}
