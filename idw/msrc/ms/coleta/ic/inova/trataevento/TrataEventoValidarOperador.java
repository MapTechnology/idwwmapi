package ms.coleta.ic.inova.trataevento;

import java.util.Calendar;

import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class TrataEventoValidarOperador extends TrataEvento {

	public TrataEventoValidarOperador() {
	}
	
	@Override
	public EventoColetado trataEvento() {
		EventoColetado eventoColetado = new EventoColetado();
		
		eventoColetado.setTipoEvento(ServicoFactory._VALIDAR_OPERADOR_INOVA); // evento para o ms
		eventoColetado.setDthrEvento(dataEvento.getTime());
		eventoColetado.setExisteEvento(true);
		eventoColetado.setIcUpDTO(this.lcup);
		
		return(eventoColetado);
	}
	
}