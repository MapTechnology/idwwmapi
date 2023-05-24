package ms.coleta.dto;

import java.util.Date;
import java.util.List;

public class SessaoCalendarioDTO {
	private List<Date> viradasDeTurno;
	private long idCal;
	
	public List<Date> getViradasDeTurno() {
		return viradasDeTurno;
	}
	public void setViradasDeTurno(List<Date> viradasDeTurno) {
		this.viradasDeTurno = viradasDeTurno;
	}
	public long getIdCal() {
		return idCal;
	}
	public void setIdCal(long idCal) {
		this.idCal = idCal;
	}
}
