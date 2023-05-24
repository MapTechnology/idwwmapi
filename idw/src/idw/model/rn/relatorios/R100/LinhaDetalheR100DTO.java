package idw.model.rn.relatorios.R100;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LinhaDetalheR100DTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String linha;
	private Date dtReferencia;
	private String dsTurno;
	private BigDecimal producaoPrevista;
	private BigDecimal producaoBruta;
	private BigDecimal producaoLiquida;
	private BigDecimal producaoPerdida;
	private Double er;
	private List<String> modelosDoPeriodo = new ArrayList<String>();
	private List<ParadasR100DTO> paradas = new ArrayList<ParadasR100DTO>();
	private List<CiclosR100DTO> ciclos = new ArrayList<CiclosR100DTO>();
	
	private Double totalParada = 0d;
	private String totalParadaFormatada;
	
	public LinhaDetalheR100DTO(){
		super();
	}
	

	
	public String getLinha() {
		return linha;
	}



	public void setLinha(String linha) {
		this.linha = linha;
	}



	public Date getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public String getDsTurno() {
		return dsTurno;
	}



	public void setDsTurno(String dsTurno) {
		this.dsTurno = dsTurno;
	}



	public BigDecimal getProducaoPrevista() {
		return producaoPrevista;
	}
	public void setProducaoPrevista(BigDecimal producaoPrevista) {
		this.producaoPrevista = producaoPrevista;
	}
	public BigDecimal getProducaoBruta() {
		return producaoBruta;
	}
	public void setProducaoBruta(BigDecimal producaoBruta) {
		this.producaoBruta = producaoBruta;
	}
	public BigDecimal getProducaoLiquida() {
		return producaoLiquida;
	}
	public void setProducaoLiquida(BigDecimal producaoLiquida) {
		this.producaoLiquida = producaoLiquida;
	}
	public Double getEr() {
		return er;
	}
	public void setEr(Double er) {
		this.er = er;
	}



	public List<ParadasR100DTO> getParadas() {
		return paradas;
	}



	public void setParadas(List<ParadasR100DTO> paradas) {
		this.paradas = paradas;
	}



	public BigDecimal getProducaoPerdida() {
		return producaoPerdida;
	}



	public void setProducaoPerdida(BigDecimal producaoPerdida) {
		this.producaoPerdida = producaoPerdida;
	}



	public List<CiclosR100DTO> getCiclos() {
		return ciclos;
	}



	public void setCiclos(List<CiclosR100DTO> ciclos) {
		this.ciclos = ciclos;
	}



	public Double getTotalParada() {
		return totalParada;
	}



	public void setTotalParada(Double totalParada) {
		this.totalParada = totalParada;
	}



	public String getTotalParadaFormatada() {
		return totalParadaFormatada;
	}



	public void setTotalParadaFormatada(String totalParadaFormatada) {
		this.totalParadaFormatada = totalParadaFormatada;
	}
	public List<String> getModelosDoPeriodo() {
		return modelosDoPeriodo;
	}



	public void setModelosDoPeriodo(List<String> modelosDoPeriodo) {
		this.modelosDoPeriodo = modelosDoPeriodo;
	}
	
	
}
