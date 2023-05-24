package ms.coleta.protocolo;

import ms.coleta.dto.MensagemRecebida;
import ms.coleta.tcp.ServidorTcp.TipoProtocoloTCP;
import ms.model.dto.EventoColetado;

public abstract class ProtocoloEntradaFactory {

	public abstract EventoColetado criarEventoColetado();
	
	// A up deve ser uniforme para qualquer protocolo de entrada
	public abstract String getCdUp(String clientSentence);
	
	public static ProtocoloEntradaFactory getInstancia(MensagemRecebida mensagem) {
		// Esse metodo deve decidir qual protocoloEntrada chamar.
		// A decisao deve ser feita verificando o tipo do IHM no cadastro. Para o IHM inova usar o novo protocolo, para os demais o ProtocoloEntrada antigo
		ProtocoloEntradaFactory retorno;
		
		if (mensagem.getTipoProtocoloMensagem() == TipoProtocoloTCP.PROTOCOLO_NOVO) {
			retorno = new ProtocoloEntradaNovo(mensagem);
		} else {
			retorno = new ProtocoloEntrada(mensagem);
		}
		
		return retorno;
	}

}
