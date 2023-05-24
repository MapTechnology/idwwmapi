package idw.model.rn.injet.dto;


import java.io.Serializable;

import idw.util.FormulasInjet;

@SuppressWarnings("serial")
public class CrescimentoMaqInjetDTO implements Serializable{
	private String identificacaoMaquina;
	private Double percentualCrescimento;
	private Integer crescimento;
	private Double taxaUtilizacaoMesAtual;
	private Double taxaUtilizacaoMesAnterior;
	
	public String getIdentificacaoMaquina() {
		return identificacaoMaquina;
	}
	public void setIdentificacaoMaquina(String identificacaoMaquina) {
		this.identificacaoMaquina = identificacaoMaquina;
	}
	public Double getPercentualCrescimento() {
		return percentualCrescimento;
	}
	public void setPercentualCrescimento(Double percentualCrescimento) {
		this.percentualCrescimento = percentualCrescimento;
	}
	public Integer getCrescimento() {
		return crescimento;
	}
	public void setCrescimento(Integer crescimento) {
		this.crescimento = crescimento;
	}
	public Double getTaxaUtilizacaoMesAtual() {
		return taxaUtilizacaoMesAtual;
	}
	public void setTaxaUtilizacaoMesAtual(Double taxaUtilizacaoMesAtual) {
		this.taxaUtilizacaoMesAtual = taxaUtilizacaoMesAtual;
	}
	public Double getTaxaUtilizacaoMesAnterior() {
		return taxaUtilizacaoMesAnterior;
	}
	public void setTaxaUtilizacaoMesAnterior(Double taxaUtilizacaoMesAnterior) {
		this.taxaUtilizacaoMesAnterior = taxaUtilizacaoMesAnterior;
	}
	
	public String getPercentualCrescimentoString() {
		try {
			return FormulasInjet.formatarCasaDecimalDoFloat(percentualCrescimento.floatValue()).toString();
		} catch (Exception e) {
			return "0";
		}
		
	}
}
