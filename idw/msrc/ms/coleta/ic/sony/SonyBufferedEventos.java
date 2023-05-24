package ms.coleta.ic.sony;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import ms.coleta.dto.EventosColetados;
import ms.model.dto.EventoColetado;

/* Essa classe serve para guardar os eventos de determinado IC
 * gerenciando o acesso de forma sincronizada entre as thread
 */
public class SonyBufferedEventos {
	
	// Usado para permitir a obtenção dos eventos, 10 segundos após serem adicionados
	Timer timer;
	// Tempo ate podeObterEventos ser setado pra true
	// int seconds = 60;
	int seconds = 30;
	
	private boolean podeObterEventos = false;

	private EventosColetados eventos = new EventosColetados();
	
	private EventosColetados eventosVazios = new EventosColetados();
	
	public synchronized void addEventos(List<EventoColetado> lista) {
		podeObterEventos = false;
		//Ordenacao por data da lista de eventos
		List<EventoColetado> listaOrdenada;
		List<EventoColetado> listaAux = ordernaListaEventosColetados(lista);
		listaAux = trataDatasRepetidas(listaAux);
		listaOrdenada = ordernaListaEventosColetados(listaAux);
		
		// for (EventoColetado evento : lista) {
		for (EventoColetado evento : listaOrdenada) {
			eventos.addEventoColetado(evento);
		}
		
 		timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
		
	}
	
	/**
	 * Trata repeticoes de datas para eventos do mesmo tipo, sendo esses
	 * Alarme set ou Alarm clear
	 * @param lista
	 * @return
	 */
	private List<EventoColetado> trataDatasRepetidas(List<EventoColetado> lista) {
		List<EventoColetado> retorno = lista;
		for (int i = 0; i < lista.size(); i++) {
			int repeticoes = 0;
			EventoColetado o1 = retorno.get(i);
			for (int j = i + 1; j < lista.size(); j++) {
				EventoColetado o2 = retorno.get(j);
				int comparacao = o1.getDthrEvento().compareTo(o2.getDthrEvento());
				if (comparacao == 0 && o1.getTipoEvento() == o2.getTipoEvento() && (o1.getTipoEvento() == 10 || o1.getTipoEvento() == 11)) {
					repeticoes ++;
					o2.setDthrEvento(new Date(o2.getDthrEvento().getTime() + 10 * repeticoes));
					retorno.set(j, o2);
				}
			}
		}
		return retorno;
		
	}

	public synchronized EventosColetados obtenEventos() {
		if(podeObterEventos) {
			EventosColetados retorno = eventos;
			
			// Como os objetos EventoColetado podem ser provenientes de mais de um arquivo,
			// a lista deve ser ordenada por data para garantir a cronologia de eventos
			// retorno.setEventosColetados(ordernaListaEventosColetados(eventos.getEventosColetados()));
			retorno.setEventosColetados((eventos.getEventosColetados()));
			eventos = new EventosColetados();
			podeObterEventos = false;
			return retorno;
		}
		// else, return lista vazia
		return eventosVazios;
		
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
	
	class RemindTask extends TimerTask {
	// Metodo executado uma vez, N segundos após eventos serem inseridos
		public void run() {
	    	podeObterEventos = true;
	        timer.cancel(); //Terminate the timer thread
	    }
	} // Fim da classe RemindTask

} // Fim da classe
