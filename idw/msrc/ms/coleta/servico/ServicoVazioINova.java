package ms.coleta.servico;

import idw.model.pojos.MsEvt;
import idw.util.IdwLogger;

import java.util.Calendar;
import java.util.Map;

import org.hibernate.Session;

import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;

public class ServicoVazioINova implements IServico, IProtocoloNovo {
	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();
		
		log.info("Servico VAZIO INOVA - INI");
		
		// passando a data do evento para calendar
		Calendar dataEvento = Calendar.getInstance();
		dataEvento.setTime(mensagem.getEventoColetado().getDthrEvento());
		
		// montando parametro de retorno
		ParametroDTO parametro = new ParametroDTO();
		
		parametro.setTipoEvento(mensagem.getEventoColetado().getTipoEvento());
		parametro.setDataHoraEvento(dataEvento);
		
		mensagem.getIc().setParametro(parametro);
		
		log.info("Servico VAZIO INOVA - FIM");
		
		return null;
	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		// TODO Auto-generated method stub
		return null;
	}
}
