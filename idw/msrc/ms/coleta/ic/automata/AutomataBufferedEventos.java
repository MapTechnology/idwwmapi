package ms.coleta.ic.automata;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import ms.coleta.dto.EventosColetados;
import ms.model.dto.EventoColetado;

/* Essa classe serve para guardar os eventos de determinado IC
 * gerenciando o acesso de forma sincronizada entre as thread
 */
public class AutomataBufferedEventos {
	
	// Usado para permitir a obtenção dos eventos, X segundos após serem adicionados
	Timer timer;
	
	// Tempo ate podeObterEventos ser setado pra true
	int seconds = 1000;
	
	private boolean podeObterEventos = false;
	private EventosColetados eventos = new EventosColetados();
	private EventosColetados eventosVazios = new EventosColetados();
	
	public synchronized void addEventos(List<EventoColetado> lista) {
		podeObterEventos = false;
		for (EventoColetado evento : lista) {
			eventos.addEventoColetado(evento);
		}
		
		timer = new Timer();
        timer.schedule(new RemindTask(), seconds);		
	}
	
	public synchronized EventosColetados obtemEventos() {
		if(podeObterEventos) {
			EventosColetados retorno = eventos;
			
			// Como os objetos EventoColetado podem ser provenientes de mais de um arquivo,
			// a lista deve ser ordenada por data para garantir a cronologia de eventos
			retorno.setEventosColetados(ordernaListaEventosColetados(eventos.getEventosColetados()));
			retorno.setEventosColetados((eventos.getEventosColetados()));
			eventos = new EventosColetados();
			return retorno;
		}
		
		return eventosVazios;
	}
	
	private List<EventoColetado> ordernaListaEventosColetados(List<EventoColetado> eventos) {
		List<EventoColetado> retorno = eventos;
		// Ordenacao
		Collections.sort(retorno, new Comparator<EventoColetado>() {
			@Override
			public int compare(EventoColetado o1, EventoColetado o2) {
				return o1.getDthrEvento().compareTo(o2.getDthrEvento());
			}
		});
		
		return retorno;
	}
	
	class RemindTask extends TimerTask {
		
		// Metodo executado uma vez, N segundos após eventos serem inseridos
		public void run() {
	    	podeObterEventos = true;
	        timer.cancel(); //Terminate the timer thread
	    }
	}
}
