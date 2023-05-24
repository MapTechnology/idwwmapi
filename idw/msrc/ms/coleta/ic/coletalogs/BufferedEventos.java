package ms.coleta.ic.coletalogs;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ms.coleta.dto.EventosColetados;
import ms.model.dto.EventoColetado;

public class BufferedEventos {
	
	private EventosColetados eventos = new EventosColetados();

	public synchronized void addEventos(List<EventoColetado> lista) {
		for (EventoColetado evento : lista) {
			eventos.addEventoColetado(evento);	
		}
		// Reordena a lista resultante de eventos
		List<EventoColetado> listaOrdenada = ordernaListaEventosColetados(eventos.getEventosColetados());
		eventos.setEventosColetados(listaOrdenada);
	}
	
	private List<EventoColetado> ordernaListaEventosColetados(List<EventoColetado> eventos) {
		List<EventoColetado> retorno = eventos;
		// Ordenacao
		Collections.sort(retorno, new Comparator<EventoColetado>() {
			@Override
			public int compare(EventoColetado o1, EventoColetado o2) {
				int comparacao = o1.getDthrEvento().compareTo(o2.getDthrEvento());
				return comparacao;
			}
		});
		return retorno;
	}
	
	public synchronized EventosColetados obtemEventos() {
		EventosColetados retorno = new EventosColetados();
		retorno.setEventosColetados(eventos.getEventosColetados());
		eventos = new EventosColetados();
		return retorno;
	}
	
	public synchronized EventosColetados getEventos(){
		return eventos;
	}
	

}
