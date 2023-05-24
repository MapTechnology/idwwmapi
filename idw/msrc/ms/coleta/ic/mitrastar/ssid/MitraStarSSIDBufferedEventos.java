package ms.coleta.ic.mitrastar.ssid;

import ms.coleta.dto.EventosColetados;
import ms.model.dto.EventoColetado;

/**
 *  Essa classe serve para guardar os eventos de determinado IC
 * gerenciando o acesso de forma sincronizada entre as thread
 */
public class MitraStarSSIDBufferedEventos {

	private EventosColetados eventos = new EventosColetados();

	public synchronized EventosColetados obtemEventosELimpa() {
		EventosColetados retorno = eventos;
		eventos = new EventosColetados();
		return retorno;
	}

	public synchronized void addEvento(EventoColetado evento) {
		eventos.addEventoColetado(evento);
	}


	public synchronized EventoColetado obtemUltimoEvento() {
		EventoColetado retorno = null;
		if (eventos.isExisteEvento()) {
			retorno = eventos.getEventosColetados().get(eventos.getEventosColetados().size()-1);
		}
		return retorno;
	}
}
