package br.com.johnswallet.messaging.sender;

import br.com.johnswallet.messaging.dto.MensagemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public abstract class DefaultSender {

    @Autowired
    protected Environment environment;


    public abstract void send(MensagemDTO dto);

    public abstract boolean isEnabled();

}
