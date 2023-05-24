package ms.coleta.ic.inova.trataevento;

import java.util.Calendar;

import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class TrataEventoAposEnviarDncParaColetor extends TrataEvento {

	public TrataEventoAposEnviarDncParaColetor() {
	}
	
	@Override
	public EventoColetado trataEvento() {
		EventoColetado eventoColetado = new EventoColetado();
		
		eventoColetado.setTipoEvento(ServicoFactory._APOS_ENVIAR_DNC_PARA_COLETOR_INOVA); // evento para o ms
		eventoColetado.setDthrEvento(dataEvento.getTime());
		eventoColetado.setExisteEvento(true);
		eventoColetado.setIcUpDTO(this.lcup);
		
		return(eventoColetado);
	}
	
}