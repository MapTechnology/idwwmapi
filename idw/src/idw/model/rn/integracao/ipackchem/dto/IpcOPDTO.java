package idw.model.rn.integracao.ipackchem.dto;

import java.util.Date;

public class IpcOPDTO {
	private String nrOPERP;
	private String cdProduto;
	private Double qtdPlan;
	private Integer prioridade;
	private Date dthrTermino;	
	private String operacao;
	
	public String getNrOPERP() {
		return nrOPERP;
	}
	public void setNrOPERP(String nrOPERP) {
		this.nrOPERP = nrOPERP;
	}
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public Double getQtdPlan() {
		return qtdPlan;
	}
	public void setQtdPlan(Double qtdPlan) {
		this.qtdPlan = qtdPlan;
	}
	public Integer getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}
	public Date getDthrTermino() {
		return dthrTermino;
	}
	public void setDthrTermino(Date dthrTermino) {
		this.dthrTermino = dthrTermino;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}	
}
