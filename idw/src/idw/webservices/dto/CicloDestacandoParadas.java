package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.rn.DataHoraRN;

public class CicloDestacandoParadas implements Serializable	{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date dthrIciclo;
	private Date dthrFciclo;
	private String cdFolha;
	private Double segDuracao;
	private Double segTempoparada;
	private Double segCicloPadrao;
	private Double segDuracaoSemParada;
	private Double segTempoAtivoParcial;
	private Boolean isCicloComConflito;
	private Boolean isCicloForaturno;

	
	private List<DetalheParadaDTO> paradas = new ArrayList<>();
	
	public Date getDthrIciclo() {
		return dthrIciclo;
	}
	public void setDthrIciclo(Date dthrIciclo) {
		this.dthrIciclo = dthrIciclo;
	}
	public Date getDthrFciclo() {
		return dthrFciclo;
	}
	public void setDthrFciclo(Date dthrFciclo) {
		this.dthrFciclo = dthrFciclo;
	}
	public Double getSegDuracao() {
		return segDuracao;
	}
	public void setSegDuracao(Double segDuracao) {
		this.segDuracao = segDuracao;
	}
	public Double getSegTempoparada() {
		return segTempoparada;
	}
	public void setSegTempoparada(Double segTempoparada) {
		this.segTempoparada = segTempoparada;
	}
	public Double getSegCicloPadrao() {
		return segCicloPadrao;
	}
	public void setSegCicloPadrao(Double segCicloPadrao) {
		this.segCicloPadrao = segCicloPadrao;
	}
	public Double getSegDuracaoSemParada() {
		return segDuracaoSemParada;
	}
	public void setSegDuracaoSemParada(Double segDuracaoSemParada) {
		this.segDuracaoSemParada = segDuracaoSemParada;
	}
	public Double getSegTempoAtivoParcial() {
		return segTempoAtivoParcial;
	}
	public void setSegTempoAtivoParcial(Double segTempoAtivoParcial) {
		this.segTempoAtivoParcial = segTempoAtivoParcial;
	}
	public Boolean getIsCicloComConflito() {
		return isCicloComConflito;
	}
	public void setIsCicloComConflito(Boolean isCicloComConflito) {
		this.isCicloComConflito = isCicloComConflito;
	}
	public List<DetalheParadaDTO> getParadas() {
		return paradas;
	}
	public void setParadas(List<DetalheParadaDTO> paradas) {
		this.paradas = paradas;
	}
	public Boolean getIsCicloForaturno() {
		return isCicloForaturno;
	}
	public void setIsCicloForaturno(Boolean isCicloForaturno) {
		this.isCicloForaturno = isCicloForaturno;
	}

	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder();
		retorno.append("DuracaoCiclo=");
		retorno.append(getSegDuracao());
		retorno.append(" Inicio ciclo=");
		retorno.append(DataHoraRN.dateToStringYYYYMMDDHHMMSS(getDthrIciclo()));
		retorno.append(" Fim ciclo=");
		retorno.append(DataHoraRN.dateToStringYYYYMMDDHHMMSS(getDthrFciclo()));
		retorno.append(" DuracaoCiclo=");
		retorno.append(getSegDuracaoSemParada());
		
		for (DetalheParadaDTO oco : getParadas()) {
			retorno.append("\n");
			retorno.append(" DuracaoParada=");
			retorno.append(oco.getDuracao());
			retorno.append(" Inicio parada=");
			retorno.append(DataHoraRN.dateToStringYYYYMMDDHHMMSS(oco.getInicio()));
			retorno.append(" Fim parada=");
			retorno.append(DataHoraRN.dateToStringYYYYMMDDHHMMSS(oco.getFim()));
		}
		
		return retorno.toString();
	}
	public String getCdFolha() {
		return cdFolha;
	}
	public void setCdFolha(String cdFolha) {
		this.cdFolha = cdFolha;
	}
}
