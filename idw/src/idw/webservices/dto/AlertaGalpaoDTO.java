package idw.webservices.dto;

import java.util.Date;

public class AlertaGalpaoDTO {
	
	String cdGalpao;
	String cdInjetora;
	String cdAlerta;
	String dsAlerta;
	Date dthrialerta;
	String tempoAlerta;
	
	
	public String getCdGalpao() {
		return cdGalpao;
	}
	public void setCdGalpao(String cdGalpao) {
		this.cdGalpao = cdGalpao;
	}
	public String getCdInjetora() {
		return cdInjetora;
	}
	public void setCdInjetora(String cdInjetora) {
		this.cdInjetora = cdInjetora;
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
	public Date getDthriAlerta() {
		return dthrialerta;
	}
	public void setDthriAlerta(Date dthrialerta) {
		this.dthrialerta = dthrialerta;
	}
	public String getTempoParado() {
		return tempoAlerta;
	}
	public void setTempoParado(String tempoParado) {
		this.tempoAlerta = tempoParado;
	}
	
	
	

}
