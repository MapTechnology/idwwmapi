package ms.coleta.protocolo;

import ms.coleta.dto.MensagemEnviada;
import ms.coleta.tcp.ServidorTcp.TipoProtocoloTCP;

public abstract class ProtocoloSaidaFactory {

	public abstract String parsePacoteDeTransferencia(MensagemEnviada mensagem);
	
	public static ProtocoloSaidaFactory getInstancia(MensagemEnviada mensagemEnviada) {
		// Esse metodo deve decidir qual protocoloSaida chamar.
		// A decisao deve ser feita verificando o tipo do IHM no cadastro. Para o IHM inova usar o novo protocolo, para os demais o ProtocoloEntrada antigo
		ProtocoloSaidaFactory retorno;
		
		if (mensagemEnviada.getMensagemRecebida().getTipoProtocoloMensagem() == TipoProtocoloTCP.PROTOCOLO_NOVO) {
			retorno = new ProtocoloSaidaNovo();
		} else {
			retorno = new ProtocoloSaida();
		}
		
		return retorno;
	}

}
