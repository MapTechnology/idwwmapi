package idw.model.rn.injet.dto;


import java.io.Serializable;
import java.util.Date;

import idw.model.pojos.injet.Ijalertas;
import idw.model.rn.DataHoraRN;

@SuppressWarnings("serial")
public class AlertaInjetDTO implements Serializable{

	private Date dthriAlerta;
	private Date dthrfAlerta;
	private String cdAlerta = "";
	private String dsAlerta = "";
	private Float duracao = 0f;
	
	public AlertaInjetDTO() {
		super();
	}
	
	public Date getDthriAlerta() {
		return dthriAlerta;
	}
	public void setDthriAlerta(Date dthriAlerta) {
		this.dthriAlerta = dthriAlerta;
	}
	public Date getDthrfAlerta() {
		return dthrfAlerta;
	}
	public void setDthrfAlerta(Date dthrfAlerta) {
		this.dthrfAlerta = dthrfAlerta;
	}
	public String getCdAlerta() {
		return cdAlerta;
	}
	public void setCdAlerta(String cdAlerta) {
		this.cdAlerta = cdAlerta;
	}
	public String getDsAlerta() {
		return dsAlerta;
	}
	public void setDsAlerta(String dsAlerta) {
		this.dsAlerta = dsAlerta;
	}
	public Float getDuracao() {
		return duracao;
	}
	public void setDuracao(Float duracao) {
		this.duracao = duracao;
	}
	public void copyIjalertas(Ijalertas ijalerta){
		this.cdAlerta = ijalerta.getId().getCdalerta();
		this.dsAlerta = ijalerta.getIjtbale().getDsalerta();
		this.dthriAlerta = ijalerta.getId().getDthrialerta();
		this.dthrfAlerta = ijalerta.getDthrfalerta();
		Date dtfinal = this.dthrfAlerta;
		if (dtfinal == null)
			dtfinal = DataHoraRN.getDataHoraAtual();
		this.duracao = (float) DataHoraRN.getQuantidadeSegundosNoPeriodo(this.dthriAlerta, dtfinal);
	}
}
