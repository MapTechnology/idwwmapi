package ms.coleta.ic.juki;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import ms.coleta.dto.EventosColetados;
import ms.model.dto.EventoColetado;

public class JukiBufferedEventos {

	private EventosColetados eventos = new EventosColetados();

	// Usado para permitir a obtenção dos eventos, 10 segundos após serem adicionados
	Timer timer;
	// Tempo ate podeObterEventos ser setado pra true
	// int seconds = 60;
	// int seconds = 30;
	int seconds = 3;

	private boolean podeObterEventos = false;

	private EventosColetados eventosVazios = new EventosColetados();

	public synchronized void addEventos(List<EventoColetado> lista) {
		podeObterEventos = false;
		// Ordenacao por data da lista de eventos
		// List<EventoColetado> listaOrdenada;
		// listaOrdenada = ordernaListaEventosColetados(lista);
		// 2018-02-01: Remocao da ordenacao. Uma no obtemEventos()
		// e o suficiente
		List<EventoColetado> listaOrdenada = lista;

		// for (EventoColetado evento : lista) {
		for (EventoColetado evento : listaOrdenada) {
			eventos.addEventoColetado(evento);
		}
		timer = new Timer();
		timer.schedule(new RemindTask(), seconds * 1000);
	}
	
	public synchronized EventosColetados obtemEventos() {
		if (podeObterEventos) {
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
			timer.cancel(); // Terminate the timer thread
		}
	} // Fim da classe RemindTask

} // Fim da classe
