package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.DwOperacao;
import idw.model.pojos.OmTppt;

public class OperacaoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cdFase;
	private Integer idGrupo;
	private Long idOperacao;
	private String cdOperacao;
	private OmTppt omtppt;
	private BigDecimal segTempoOperacao = BigDecimal.ZERO;
	
	private List<DwOperacao> operacoes = new ArrayList<>(); // No caso é um vetor porque tera todas as operacoes da fase que tenham o mesmo grupo de operacoes
															// entretanto o atributo OperacaoDTO.segTempoOperacao terá a soma de todas elas
	private List<DwOperacao> predecessoras = new ArrayList<>();
	
	public OperacaoDTO() {
		super();
	}
	
	public OperacaoDTO(DwOperacao valor) {
		super();
		
		setIdGrupo(valor.getGrupooperacoes());
		setIdOperacao(valor.getIdOperacao());
		setCdOperacao(valor.getCdOperacao());
		setOmtppt(valor.getOmTppt());
		
		addSegTempoOperacao(valor.getSegCiclopadrao());

		getOperacoes().add(valor);

	}
	
	public Integer getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}
	public Long getIdOperacao() {
		return idOperacao;
	}
	public void setIdOperacao(Long idOperacao) {
		this.idOperacao = idOperacao;
	}
	public String getCdOperacao() {
		return cdOperacao;
	}
	public void setCdOperacao(String cdOperacao) {
		this.cdOperacao = cdOperacao;
	}
	public BigDecimal getSegTempoOperacao() {
		return segTempoOperacao;
	}
	public void setSegTempoOperacao(BigDecimal segTempoOperacao) {
		this.segTempoOperacao = segTempoOperacao;
	}
	public List<DwOperacao> getOperacoes() {
		return operacoes;
	}
	public void setOperacoes(List<DwOperacao> operacoes) {
		this.operacoes = operacoes;
	}
	public List<DwOperacao> getPredecessoras() {
		return predecessoras;
	}
	public void setPredecessoras(List<DwOperacao> predecessoras) {
		this.predecessoras = predecessoras;
	}
	
	public void addSegTempoOperacao(BigDecimal valor) {
		this.segTempoOperacao = this.segTempoOperacao.add(valor);
	}

	public void addOperacaoDTOFilho(OperacaoDTO valor) {
		// Adicionar o tempo da operacao do grupo ao item principal
		BigDecimal somaTempoOperacao = getSegTempoOperacao();
		for (DwOperacao dwoperacao : valor.getOperacoes()) {
			somaTempoOperacao = somaTempoOperacao.add(dwoperacao.getSegCiclopadrao());
		}
		setSegTempoOperacao(somaTempoOperacao);
		getOperacoes().addAll(valor.getOperacoes());
	}

	public OmTppt getOmtppt() {
		return omtppt;
	}

	public void setOmtppt(OmTppt omtppt) {
		this.omtppt = omtppt;
	}

	public String getCdFase() {
		return cdFase;
	}

	public void setCdFase(String cdFase) {
		this.cdFase = cdFase;
	}
	
	
}
