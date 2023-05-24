package idw.webservices.dto;

import java.util.Date;

public class DetalheRecorrenciaParadaDTO {
	private Date dtHrIniPar;
	private Date dtHrFimPar;
	private Double duracao;
	private String cdTurno;
	private String dsTurno;
	private String cdPt;
	private String dsPt;
	private String cdFolha;
	private String dsFolha;
	private String cdProduto;
	private String dsProduto;
	
	public Date getDtHrIniPar() {
		return dtHrIniPar;
	}
	public void setDtHrIniPar(Date dtHrIniPar) {
		this.dtHrIniPar = dtHrIniPar;
	}
	public Date getDtHrFimPar() {
		return dtHrFimPar;
	}
	public void setDtHrFimPar(Date dtHrFimPar) {
		this.dtHrFimPar = dtHrFimPar;
	}
	public Double getDuracao() {
		return duracao;
	}
	public void setDuracao(Double duracao) {
		this.duracao = duracao;
	}
	public String getCdTurno() {
		return cdTurno;
	}
	public void setCdTurno(String cdTurno) {
		this.cdTurno = cdTurno;
	}
	public String getDsTurno() {
		return dsTurno;
	}
	public void setDsTurno(String dsTurno) {
		this.dsTurno = dsTurno;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getDsPt() {
		return dsPt;
	}
	public void setDsPt(String dsPt) {
		this.dsPt = dsPt;
	}
	public String getCdFolha() {
		return cdFolha;
	}
	public void setCdFolha(String cdFolha) {
		this.cdFolha = cdFolha;
	}
	public String getDsFolha() {
		return dsFolha;
	}
	public void setDsFolha(String dsFolha) {
		this.dsFolha = dsFolha;
	}
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public String getDsProduto() {
		return dsProduto;
	}
	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}

}
