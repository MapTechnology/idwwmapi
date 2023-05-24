package ms.model.dto;

import java.io.Serializable;
import java.util.Calendar;

@SuppressWarnings("serial")
public class EventoRealDTO implements Serializable{
	public static int EVENTO_CICLO = 0;
	public static int EVENTO_PARADA = 1;

	private Integer tipoEvento;
	private Calendar dthrEvento;

	public Calendar getDthrEvento() {
		return dthrEvento;
	}
	public void setDthrEvento(Calendar dthrEvento) {
		this.dthrEvento = dthrEvento;
	}
	public Integer getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(Integer tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
}
