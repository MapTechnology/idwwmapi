package idw.model.rn.injet.dto;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class CicloInjetDTO implements Serializable{
	private Date dthriciclo;
	private Date dthrfciclo;
	private Float duracao;
	private Float ciclopadrao;
	private Float eficienciaCiclo;
	public Date getDthriciclo() {
		return dthriciclo;
	}
	public void setDthriciclo(Date dthriciclo) {
		this.dthriciclo = dthriciclo;
	}
	public Date getDthrfciclo() {
		return dthrfciclo;
	}
	public void setDthrfciclo(Date dthrfciclo) {
		this.dthrfciclo = dthrfciclo;
	}
	public Float getDuracao() {
		return duracao;
	}
	public void setDuracao(Float duracao) {
		this.duracao = duracao;
	}
	public Float getCiclopadrao() {
		return ciclopadrao;
	}
	public void setCiclopadrao(Float ciclopadrao) {
		this.ciclopadrao = ciclopadrao;
	}
	public Float getEficienciaCiclo() {
		return eficienciaCiclo;
	}
	public void setEficienciaCiclo(Float eficienciaCiclo) {
		this.eficienciaCiclo = eficienciaCiclo;
	}
}
