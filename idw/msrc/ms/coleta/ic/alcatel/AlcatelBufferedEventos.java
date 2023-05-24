package ms.coleta.ic.alcatel;

import ms.coleta.dto.EventosColetados;
import ms.model.dto.EventoColetado;

/* Essa classe serve para guardar os eventos de determinado IC
 * gerenciando o acesso de forma sincronizada entre as thread
 */
public class AlcatelBufferedEventos {

	private EventosColetados eventos = new EventosColetados();
	
	public synchronized void addEvento(EventoColetado evento) {
		eventos.addEventoColetado(evento);
	}
	
	public synchronized EventosColetados obtenEventos() {
		EventosColetados retorno = eventos;
		eventos = new EventosColetados();
		return retorno;
	}
}
