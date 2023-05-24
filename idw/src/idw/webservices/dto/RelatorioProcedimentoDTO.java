package idw.webservices.dto;

import java.util.Date;
import java.util.List;

public class RelatorioProcedimentoDTO {
	
	private String pt;
	private String gt;
	private String op;
	private String turno;
	private String produto;
	private String procedimento;
	private String gpAtividade;
	private Integer ordemGpAtividade;
	private String atividade;
	private Integer ordemAtividade;
	private int duracaoPlan;
	private Date dtIReal;
	private Date dtFReal;
	private long duracaoReal;
	private String operador;
	private String stAtividade;
	private String obs;
	private String operadoresParticipantes;
	
	private List<RelatorioProcedimentoDTO> itens;	
	
	public String getPt() {
		return pt;
	}
	public void setPt(String pt) {
		this.pt = pt;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getProcedimento() {
		return procedimento;
	}
	public void setProcedimento(String procedimento) {
		this.procedimento = procedimento;
	}
	public String getGpAtividade() {
		return gpAtividade;
	}
	public void setGpAtividade(String gpAtividade) {
		this.gpAtividade = gpAtividade;
	}
	public Integer getOrdemGpAtividade() {
		return ordemGpAtividade;
	}
	public void setOrdemGpAtividade(Integer ordemGpAtividade) {
		this.ordemGpAtividade = ordemGpAtividade;
	}
	public String getAtividade() {
		return atividade;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}	
	public Integer getOrdemAtividade() {
		return ordemAtividade;
	}
	public void setOrdemAtividade(Integer ordemAtividade) {
		this.ordemAtividade = ordemAtividade;
	}
	public int getDuracaoPlan() {
		return duracaoPlan;
	}
	public void setDuracaoPlan(int duracaoPlan) {
		this.duracaoPlan = duracaoPlan;
	}
	
	public Date getDtIReal() {
		return dtIReal;
	}
	public void setDtIReal(Date dtIReal) {
		this.dtIReal = dtIReal;
	}
	public Date getDtFReal() {
		return dtFReal;
	}
	public void setDtFReal(Date dtFReal) {
		this.dtFReal = dtFReal;
	}
	public long getDuracaoReal() {
		return duracaoReal;
	}
	public void setDuracaoReal(long duracaoReal) {
		this.duracaoReal = duracaoReal;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public String getStAtividade() {
		return stAtividade;
	}
	public void setStAtividade(String stAtividade) {
		this.stAtividade = stAtividade;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public List<RelatorioProcedimentoDTO> getItens() {
		return itens;
	}
	public void setItens(List<RelatorioProcedimentoDTO> itens) {
		this.itens = itens;
	}
	public String getOperadoresParticipantes() {
		return operadoresParticipantes;
	}
	public void setOperadoresParticipantes(String operadoresParticipantes) {
		this.operadoresParticipantes = operadoresParticipantes;
	}
	public String getGt() {
		return gt;
	}
	public void setGt(String gt) {
		this.gt = gt;
	}
}
