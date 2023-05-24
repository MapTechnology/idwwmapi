package ms.coleta.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ms.model.dto.EventoColetado;

public class EventosColetados {
	private List<EventoColetado> eventosColetados = new ArrayList<EventoColetado>();
	private boolean eventostratados=true;
	
	private BigDecimal ultimoID = BigDecimal.ZERO;

	public EventosColetados(){
		
	}
	
	public void clearEventos(){
		eventosColetados.clear();
	}
	
	public EventosColetados(EventosColetados evts){
		for (EventoColetado ev : evts.getEventosColetados()){
			this.addEventoColetado(ev);
		}
	}
	public void addEventoColetado(EventoColetado evento) {
		this.eventosColetados.add(evento);
	}
	
	public void setEventosColetados(List<EventoColetado> eventos) {
		this.eventosColetados=eventos;
		eventostratados=false;
	}
	
	public void addEventosColetados(List<EventoColetado> eventos) {
		this.eventosColetados.addAll(eventos);
		eventostratados=false;
	}

	public List<EventoColetado> getEventosColetados() {
		return this.eventosColetados;
	}	
	
	public List<EventoColetado> cropEventosColetados() {
		List<EventoColetado> retorno = new ArrayList<EventoColetado>();
		retorno.addAll(this.eventosColetados);
		this.eventosColetados.clear();
		this.eventosColetados=null;
		this.eventosColetados = new ArrayList<EventoColetado>();
		eventostratados=true;
		return retorno;		
	}

	public boolean isExisteEvento() {
		return this.eventosColetados.size() > 0;
	}
	
	public boolean getPodeTratar(){
		return !eventostratados;		
	}
	
	public boolean getPodeSetar(){
		return eventostratados;		
	}

	public BigDecimal getUltimoID() {
		return ultimoID;
	}

	public void setUltimoID(BigDecimal ultimoID) {
		this.ultimoID = ultimoID;
	}

	
	
}
