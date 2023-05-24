package ms.coleta.servico;

import java.util.Calendar;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.dto.ParametroDTO;
import ms.excessao.ServicoFalhouException;

public class ServicoEntradaOpConfirmada implements IServico {
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