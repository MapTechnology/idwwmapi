package ms.coleta.protocolo;

import ms.coleta.dto.MensagemEnviada;
import ms.coleta.servico.ServicoFactory;

public class ProtocoloSaidaNovo  extends ProtocoloSaidaFactory{

	@Override
	public String parsePacoteDeTransferencia(MensagemEnviada mensagem) {
		try {
			String mensagemRecebidaString = mensagem.getMensagemRecebida().getMensagemRecebidaTcp();
			String mensagemASerTransmitida = "[resp]\nst=-1\n";
			
			if(!mensagem.isServicoFalhou()) {
				try{
					mensagemASerTransmitida = ServicoFactory.getInstancia().getProtocolo(mensagem.getMensagemRecebida().getServico()).montaMensagemASerEnviada(mensagem);
				}catch(Exception e) {
					e.printStackTrace();
					if(mensagem.getMensagemRecebida().getLog() != null)
						mensagem.getMensagemRecebida().getLog().info("Falha em montaMensagemASerEnviada(servico=" + mensagem.getMensagemRecebida().getServico() + ")");
				}
			}
			
			if(mensagemRecebidaString != null)
				mensagemASerTransmitida = mensagemRecebidaString + mensagemASerTransmitida;
			
			mensagemASerTransmitida = ((char)0x02) + String.format("%05d", mensagemASerTransmitida.length()) + mensagemASerTransmitida + ((char)0x03);
			
			return mensagemASerTransmitida;
		} catch(Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
}
