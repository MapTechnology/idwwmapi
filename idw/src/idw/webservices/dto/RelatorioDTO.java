package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class RelatorioDTO implements Serializable {

	private Date data;
	private TurnosDTO qtdTurnos;
	private TurnosDTO qtdTurnoReal;
	private List<BigDecimal> horasPlanej = new ArrayList<BigDecimal>(); 
	private List<BigDecimal> horasReal = new ArrayList<BigDecimal>();
	
	public List<BigDecimal> getHorasPlanej() {
		return horasPlanej;
	}
	public void setHorasPlanej(List<BigDecimal> horasPlanej) {
		this.horasPlanej = horasPlanej;
	}
	public List<BigDecimal> getHorasReal() {
		return horasReal;
	}
	public void setHorasReal(List<BigDecimal> horasReal) {
		this.horasReal = horasReal;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public TurnosDTO getQtdTurnos() {
		return qtdTurnos;
	}
	public void setQtdTurnos(TurnosDTO qtdTurnos) {
		this.qtdTurnos = qtdTurnos;
	}
	public TurnosDTO getQtdTurnoReal() {
		return qtdTurnoReal;
	}
	public void setQtdTurnoReal(TurnosDTO qtdTurnoReal) {
		this.qtdTurnoReal = qtdTurnoReal;
	}
	
}
