package injetws.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class IwsColetaDiscretaOperacaoDTO  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	String idRegOperacao;
	String idRegConexaoInjet;
	String cdOperacao;
	String dsOperacao;
	BigDecimal tpOperacao;
	BigDecimal tpFuncOperacao;
	String SiglaUM;
	
	public String getIdRegOperacao() {
		return idRegOperacao;
	}
	public void setIdRegOperacao(String idRegOperacao) {
		this.idRegOperacao = idRegOperacao;
	}
	public String getIdRegConexaoInjet() {
		return idRegConexaoInjet;
	}
	public void setIdRegConexaoInjet(String idRegConexaoInjet) {
		this.idRegConexaoInjet = idRegConexaoInjet;
	}
	public String getCdOperacao() {
		return cdOperacao;
	}
	public void setCdOperacao(String cdOperacao) {
		this.cdOperacao = cdOperacao;
	}
	public String getDsOperacao() {
		return dsOperacao;
	}
	public void setDsOperacao(String dsOperacao) {
		this.dsOperacao = dsOperacao;
	}
	public BigDecimal getTpOperacao() {
		return tpOperacao;
	}
	public void setTpOperacao(BigDecimal tpOperacao) {
		this.tpOperacao = tpOperacao;
	}
	public BigDecimal getTpFuncOperacao() {
		return tpFuncOperacao;
	}
	public void setTpFuncOperacao(BigDecimal tpFuncOperacao) {
		this.tpFuncOperacao = tpFuncOperacao;
	}
	public String getSiglaUM() {
		return SiglaUM;
	}
	public void setSiglaUM(String siglaUM) {
		SiglaUM = siglaUM;
	}

	
}
