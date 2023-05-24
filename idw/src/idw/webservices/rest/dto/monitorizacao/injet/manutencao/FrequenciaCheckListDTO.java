package idw.webservices.rest.dto.monitorizacao.injet.manutencao;

import java.math.BigDecimal;

public class FrequenciaCheckListDTO {
	private String cdCheckList;
	private int tipoFrequencia; // 1 - tempo; 2 - ciclos executados
	private BigDecimal valorFrequencia;
	private int stAtivo;
	
	public String getCdCheckList() {
		return cdCheckList;
	}
	public void setCdCheckList(String cdCheckList) {
		this.cdCheckList = cdCheckList;
	}
	public BigDecimal getValorFrequencia() {
		return valorFrequencia;
	}
	public void setValorFrequencia(BigDecimal valorFrequencia) {
		this.valorFrequencia = valorFrequencia;
	}
	public int getStAtivo() {
		return stAtivo;
	}
	public void setStAtivo(int stAtivo) {
		this.stAtivo = stAtivo;
	}
	public int getTipoFrequencia() {
		return tipoFrequencia;
	}
	public void setTipoFrequencia(int tipoFrequencia) {
		this.tipoFrequencia = tipoFrequencia;
	}
	
	
}
