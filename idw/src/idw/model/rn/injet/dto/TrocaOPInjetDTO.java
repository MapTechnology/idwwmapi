package idw.model.rn.injet.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import idw.model.pojos.injet.Ijtbinj;

@SuppressWarnings("serial")
public class TrocaOPInjetDTO implements Serializable{
	private Ijtbinj ijtbinj;
	private String cdMaquina;
	public String getCdMaquina() {
		return cdMaquina;
	}
	public void setCdMaquina(String cdMaquina) {
		this.cdMaquina = cdMaquina;
	}
	private String nropSaindo;
	private String nropEntrando;
	private BigDecimal tempoRealSetup;
	private BigDecimal tempoPlanejadoSetup;

	public BigDecimal getTempoRealSetup() {
		if (tempoRealSetup == null)
			tempoRealSetup = new BigDecimal(0);
		return tempoRealSetup;
	}
	public void setTempoRealSetup(BigDecimal tempoRealSetup) {
		this.tempoRealSetup = tempoRealSetup;
	}
	public BigDecimal getTempoPlanejadoSetup() {
		if (tempoPlanejadoSetup == null)
			tempoPlanejadoSetup = new BigDecimal(0);
		return tempoPlanejadoSetup;
	}
	public void setTempoPlanejadoSetup(BigDecimal tempoPlanejadoSetup) {
		this.tempoPlanejadoSetup = tempoPlanejadoSetup;
	}
	public String getNropSaindo() {
		return nropSaindo;
	}
	public void setNropSaindo(String nropSaindo) {
		this.nropSaindo = nropSaindo;
	}
	public String getNropEntrando() {
		return nropEntrando;
	}
	public void setNropEntrando(String nropEntrando) {
		this.nropEntrando = nropEntrando;
	}
	public Ijtbinj getIjtbinj() {
		return ijtbinj;
	}
	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}
}
