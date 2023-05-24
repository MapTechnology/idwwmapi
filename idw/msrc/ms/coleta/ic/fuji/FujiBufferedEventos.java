package ms.coleta.ic.fuji;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import ms.coleta.dto.EventosColetados;
import ms.model.dto.EventoColetado;

public class FujiBufferedEventos {

	// Usado para permitir a obtenção dos eventos, 10 segundos após serem adicionados
		private Timer timer;
		// Tempo ate podeObterEventos ser setado pra true
		// int seconds = 60;
		// private int seconds = 30;
		private int seconds = 5;
		
		private boolean podeObterEventos = false;

		private EventosColetados eventos = new EventosColetados();
		private EventosColetados eventosVazios = new EventosColetados();
		
		public synchronized void addEventos(List<EventoColetado> lista) {
			// podeObterEventos = false;
			podeObterEventos = true;
			for (EventoColetado evento : lista) {
				eventos.addEventoColetado(evento);	
			}
			// Reordena a lista resultante de eventos
			List<EventoColetado> listaOrdenada = ordernaListaEventosColetados(eventos.getEventosColetados());
			eventos.setEventosColetados(listaOrdenada);
			
			// O uso do timer tambem gera threads mortas, seu uso deve ser evitado
			// Segundo: https://stackoverflow.com/a/12016166/5398850 pode-se utilizar ScheduledThreadPoolExecutor 
//	 		timer = new Timer();
//	        timer.schedule(new RemindTask(), seconds*1000);
		}
		
		public synchronized EventosColetados obtenEventos() {
			if(podeObterEventos) {
				EventosColetados retorno = new EventosColetados();
				retorno.setEventosColetados(eventos.getEventosColetados());
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
		        timer = null;
		    }
		} // Fim da classe RemindTask

	} // Fim da classe
