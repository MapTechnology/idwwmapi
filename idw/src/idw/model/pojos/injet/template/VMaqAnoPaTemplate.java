package idw.model.pojos.injet.template;

import java.math.BigDecimal;

import idw.model.pojos.injet.VMaqMesPa;


public abstract class VMaqAnoPaTemplate {

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

	public void addVMaqMesPa(VMaqMesPa vmaqmespa){
		setDsMaquina(vmaqmespa.getDsMaquina());
		setDsTurno(vmaqmespa.getDsTurno());
		setDsparada(vmaqmespa.getDsparada());
		setParadaPesa(vmaqmespa.getParadaPesa());

		setSegTempoparada(getSegTempoparada().add(vmaqmespa.getSegTempoparada()));
	}
}
