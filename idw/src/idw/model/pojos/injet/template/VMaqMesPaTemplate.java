package idw.model.pojos.injet.template;

import java.math.BigDecimal;

import idw.model.pojos.injet.VMaqDataPa;


public abstract class VMaqMesPaTemplate {

	public abstract String getDsTurno();
	public abstract String getDsMaquina();
	public abstract String getDsparada();
	public abstract BigDecimal getSegTempoparada();
	public abstract String getParadaPesa();

	public abstract void setDsTurno(String dsTurno);
	public abstract void setDsMaquina(String dsMaquina);
	public abstract void setDsparada(String dsparada);
	public abstract void setSegTempoparada(BigDecimal segTempoparada);
	public abstract void setParadaPesa(String paradaPesa);

	public void addVMaqDataPa(VMaqDataPa vmaqdatapa){
		setDsMaquina(vmaqdatapa.getDsMaquina());
		setDsTurno(vmaqdatapa.getDsTurno());
		setDsparada(vmaqdatapa.getDsparada());
		setParadaPesa(vmaqdatapa.getParadaPesa());

		setSegTempoparada(getSegTempoparada().add(vmaqdatapa.getSegTempoparada()));
	}
}
