package ms.coleta.ic.inova.trataevento;

import java.util.Calendar;

import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class TrataEventoFaltaMemoria extends TrataEvento {

	public TrataEventoFaltaMemoria() {
	}
	
	@Override
	public EventoColetado trataEvento() {
		EventoColetado eventoColetado = new EventoColetado();
		
		eventoColetado.setTipoEvento(ServicoFactory._FALTA_MEMORIA_INOVA); // evento para o ms
		eventoColetado.setDthrEvento(dataEvento.getTime());
		eventoColetado.setExisteEvento(true);
		eventoColetado.setIcUpDTO(this.lcup);
		
		return(eventoColetado);
	}
	
}