package ms.model.dto;

import java.util.List;
import java.util.concurrent.Semaphore;

import ms.coleta.dto.EventosColetados;

public class MsBufferEventosIcUpDTO {
	private IcUpDTO icupdto=null;
	private final Semaphore evtAvailable = new Semaphore(1);
	private EventosColetados eventoscoletados = new EventosColetados();

	public IcUpDTO getIcUpdto() {
		return icupdto;
	}

	public void setIcUpdto(IcUpDTO icupdto) {
		this.icupdto = icupdto;
	}
	
	protected void getEvtSemaphore() {
		try {
			evtAvailable.acquire();
		} catch (InterruptedException e) {}
	}

	protected void releaseEvtSemaphore() {
		evtAvailable.release();
	}

	public List<EventoColetado> cropEventosColetados() {
		getEvtSemaphore();
		List<EventoColetado> retorno = this.eventoscoletados.cropEventosColetados();
		releaseEvtSemaphore();
		return retorno;
	}

	public void addEventosColetados(List<EventoColetado> eventoscoletados) {
		getEvtSemaphore();
		this.eventoscoletados.addEventosColetados(eventoscoletados);
		releaseEvtSemaphore();
	}
	
	public void addEventoColetado(EventoColetado eventocoletado) {
		getEvtSemaphore();
		this.eventoscoletados.addEventoColetado(eventocoletado);
		releaseEvtSemaphore();
	}
}
