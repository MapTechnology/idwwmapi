package idw.model.rn.geraplano.dtos;

import java.util.Date;

import idw.model.rn.DataHoraRN;

public class IndisponibilidadeDTO {
	private Date inicio;
	private Date fim;
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	@Override
	public String toString(){
		return DataHoraRN.dateToStringYYYYMMDDHHMMSS(inicio) + " ate " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(fim);
	}
	
}
