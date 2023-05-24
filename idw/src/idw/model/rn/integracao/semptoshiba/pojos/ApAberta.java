package idw.model.rn.integracao.semptoshiba.pojos;

import java.util.Date;

public class ApAberta {
	private final String codFab;
	private final String numAp;
	private final String codModelo;
	private final Integer qtdPlanejada;
	private final Integer qtdProducaoBruta;
	private final String status;
	private final Date dtReferencia;
	private final boolean isDat;
	private final boolean isLiberado;
	public ApAberta(String codFab, String numAp, String codModelo,
			Integer qtdPlanejada, Integer qtdProducaoBruta,
			String status, Date dtReferencia, boolean isDat, boolean isLiberado) {
		super();
		this.codFab = codFab;
		this.numAp = numAp;
		this.codModelo = codModelo;
		this.qtdPlanejada = qtdPlanejada;
		this.qtdProducaoBruta = qtdProducaoBruta;
		this.status = status;
		this.dtReferencia = dtReferencia;
		this.isDat = isDat;
		this.isLiberado = isLiberado;
	}
	
	public String getCodFab() {
		return codFab;
	}
	
	public String getNumAp() {
		return numAp;
	}
	
	public String getCodModelo() {
		return codModelo;
	}
	
	public Integer getQtdPlanejada() {
		return qtdPlanejada;
	}
	
	public Integer getQtdProducaoBruta() {
		return qtdProducaoBruta;
	}
	
	public String getStatus() {
		return status;
	}
	
	public Date getDtReferencia() {
		return dtReferencia;
	}
	
	public boolean getIsDat() {
		return isDat;
	}
	
	public boolean getIsLiberado(){
		return isLiberado;
	}
	
	public Integer getSaldoProduzir(){
		
		return qtdPlanejada - qtdProducaoBruta;
		
	}

}
