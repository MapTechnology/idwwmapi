package ms.coleta.servico;

import idw.model.pojos.MsEvt;

import java.util.Calendar;

import ms.coleta.dto.MensagemRecebida;
import ms.coleta.dto.ParametroDTO;
import ms.excessao.ServicoFalhouException;

import org.hibernate.Session;

public class ServicoFimParadaInova implements IServico {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		// passando a data do evento para calendar
		Calendar dataEvento = Calendar.getInstance();
		dataEvento.setTime(mensagem.getEventoColetado().getDthrEvento());
		
		
		// montando parametro de retorno
		ParametroDTO parametro = new ParametroDTO();
	
		parametro.setTipoEvento(mensagem.getEventoColetado().getTipoEvento());
		parametro.setDataHoraEvento(dataEvento);
		
		mensagem.getIc().setParametro(parametro);
	
	return null;
}
}