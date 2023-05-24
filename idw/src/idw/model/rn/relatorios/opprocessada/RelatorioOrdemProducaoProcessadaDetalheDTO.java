package idw.model.rn.relatorios.opprocessada;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import idw.model.pojos.OmPt;
import idw.webservices.dto.UsuarioCODTO;

public class RelatorioOrdemProducaoProcessadaDetalheDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String posto;
	private String op;

	private Date dtInicial;
	private Date dtFinal;
	private String periodo; 

	private Double segCicloPadrao = 0d;
	private Double segCicloMedio = 0d;
	private Double eficienciaCiclo = 0d;
	private Double producaoSaldoOP = 0d;
	
	private Double tempoAtivo = 0d;
	private Double tempoTrabalhado = 0d;
	
	private Double tempoCicloPadrao = 0d;
	private Double qtCicloPadrao = 0d;
	private Double tempoCiclosProdutivos;
	private Double qtdCiclosProdutivos;	

	private List<RelatorioOrdemProducaoProcessadaProdutoDTO> produtos = new ArrayList<>();
	private List<RelatorioOrdemProducaoProcessadaParadaDTO> paradas = new ArrayList<>();
	private List<UsuarioCODTO> operadores = new ArrayList<>();
	
	
	@Transient
	private transient List<OmPt> ptsComParadaEmAberto = new ArrayList<>();
	
	public RelatorioOrdemProducaoProcessadaDetalheDTO() {
		super();
	}

	public String getPosto() {
		return posto;
	}

	public void setPosto(String posto) {
		this.posto = posto;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	

	public Double getSegCicloPadrao() {
		return segCicloPadrao;
	}

	public void setSegCicloPadrao(Double segCicloPadrao) {
		this.segCicloPadrao = segCicloPadrao;
	}

	public Double getSegCicloMedio() {
		return segCicloMedio;
	}

	public void setSegCicloMedio(Double segCicloMedio) {
		this.segCicloMedio = segCicloMedio;
	}

	public Double getEficienciaCiclo() {
		return eficienciaCiclo;
	}

	public void setEficienciaCiclo(Double eficienciaCiclo) {
		this.eficienciaCiclo = eficienciaCiclo;
	}

	public Double getProducaoSaldoOP() {
		return producaoSaldoOP;
	}

	public void setProducaoSaldoOP(Double producaoSaldoOP) {
		this.producaoSaldoOP = producaoSaldoOP;
	}

	public List<RelatorioOrdemProducaoProcessadaProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<RelatorioOrdemProducaoProcessadaProdutoDTO> produtos) {
		this.produtos = produtos;
	}

	public List<RelatorioOrdemProducaoProcessadaParadaDTO> getParadas() {
		return paradas;
	}

	public void setParadas(List<RelatorioOrdemProducaoProcessadaParadaDTO> paradas) {
		this.paradas = paradas;
	}

	public List<UsuarioCODTO> getOperadores() {
		return operadores;
	}

	public void setOperadores(List<UsuarioCODTO> operadores) {
		this.operadores = operadores;
	}

	public Double getTempoAtivo() {
		return tempoAtivo;
	}

	public void setTempoAtivo(Double tempoAtivo) {
		this.tempoAtivo = tempoAtivo;
	}

	public Double getTempoTrabalhado() {
		return tempoTrabalhado;
	}

	public void setTempoTrabalhado(Double tempoTrabalhado) {
		this.tempoTrabalhado = tempoTrabalhado;
	}

	public List<OmPt> getPtsComParadaEmAberto() {
		return ptsComParadaEmAberto;
	}

	public void setPtsComParadaEmAberto(List<OmPt> ptsComParadaEmAberto) {
		this.ptsComParadaEmAberto = ptsComParadaEmAberto;
	}

	public Double getTempoCiclosProdutivos() {
		return tempoCiclosProdutivos;
	}

	public void setTempoCiclosProdutivos(Double tempoCiclosProdutivos) {
		this.tempoCiclosProdutivos = tempoCiclosProdutivos;
	}

	public Double getQtdCiclosProdutivos() {
		return qtdCiclosProdutivos;
	}

	public void setQtdCiclosProdutivos(Double qtdCiclosProdutivos) {
		this.qtdCiclosProdutivos = qtdCiclosProdutivos;
	}

	public Double getTempoCicloPadrao() {
		return tempoCicloPadrao;
	}

	public void setTempoCicloPadrao(Double tempoCicloPadrao) {
		this.tempoCicloPadrao = tempoCicloPadrao;
	}

	public Double getQtCicloPadrao() {
		return qtCicloPadrao;
	}

	public void setQtCicloPadrao(Double qtCicloPadrao) {
		this.qtCicloPadrao = qtCicloPadrao;
	}

	public Date getDtInicial() {
		return dtInicial;
	}

	public void setDtInicial(Date dtInicial) {
		this.dtInicial = dtInicial;
	}

	public Date getDtFinal() {
		return dtFinal;
	}

	public void setDtFinal(Date dtFinal) {
		this.dtFinal = dtFinal;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	
}
