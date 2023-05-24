package ms.coleta.protocolo;

import java.util.Map;

import ms.coleta.dto.MensagemEnviada;
import ms.model.dto.EventoColetado;

public interface IProtocoloNovo {
	void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs);
	String montaMensagemASerEnviada(MensagemEnviada mensagem);
}
