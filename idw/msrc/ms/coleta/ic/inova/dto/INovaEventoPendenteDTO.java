package ms.coleta.ic.inova.dto;

import java.util.Calendar;

public class INovaEventoPendenteDTO {
	
	public static final int _EVENTOPENDENTE_FIM_CICLO = 0;
	public static final int _EVENTOPENDENTE_INICIO_CICLO = 1;
	public static final int _EVENTOPENDENTE_FIM_PARADA = 2;
	public static final int _EVENTOPENDENTE_INICIO_PARADA = 3;
	
	private int evento;
	private Calendar dthrevento;
	private String idup;
	private String oinfo = "";
	private int qtbatidas;
	private boolean paradaauto;
	private boolean paradpersist;
	
	
	public int getEvento() {
		return evento;
	}
	public void setEvento(int evento) {
		this.evento = evento;
	}
	public Calendar getDthrevento() {
		return dthrevento;
	}
	public void setDthrevento(Calendar dthrevento) {
		this.dthrevento = dthrevento;
	}
	public String getIdup() {
		return idup;
	}
	public void setIdup(String idup) {
		this.idup = idup;
	}
	public String getOinfo() {
		return oinfo;
	}
	public void setOinfo(String oinfo) {
		this.oinfo = oinfo;
	}
	public int getQtbatidas() {
		return qtbatidas;
	}
	public void setQtbatidas(int qtbatidas) {
		this.qtbatidas = qtbatidas;
	}
	public boolean isParadaauto() {
		return paradaauto;
	}
	public void setParadaauto(boolean paradaauto) {
		this.paradaauto = paradaauto;
	}
	public boolean isParadpersist() {
		return paradpersist;
	}
	public void setParadpersist(boolean paradpersist) {
		this.paradpersist = paradpersist;
	}
	
	
}
