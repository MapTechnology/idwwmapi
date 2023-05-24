package ms.coleta.ic.inova.trataevento;

import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;

public class TrataEventoIniciarCip extends TrataEvento {

	public TrataEventoIniciarCip() {
	}
	
	@Override
	public EventoColetado trataEvento() {
		EventoColetado eventoColetado = new EventoColetado();
		
		eventoColetado.setTipoEvento(ServicoFactory._INICIAR_CIP_INOVA); // evento para o ms
		eventoColetado.setDthrEvento(dataEvento.getTime());
		eventoColetado.setExisteEvento(true);
		eventoColetado.setIcUpDTO(this.lcup);
		
		return(eventoColetado);
	}
	
}