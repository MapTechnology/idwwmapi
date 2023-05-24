package ms.coleta.ic.inova.trataevento;

import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;

public class TrataEventoAbrirAlerta extends TrataEvento {

	public TrataEventoAbrirAlerta() {
	}
	
	@Override
	public EventoColetado trataEvento() {
		EventoColetado eventoColetado = new EventoColetado();
		
		eventoColetado.setTipoEvento(ServicoFactory._ABRIR_ALERTA_INOVA); // evento para o ms
		eventoColetado.setDthrEvento(dataEvento.getTime());
		eventoColetado.setExisteEvento(true);
		eventoColetado.setIcUpDTO(this.lcup);
		
		return(eventoColetado);
	}
	
}