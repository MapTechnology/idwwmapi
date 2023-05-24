package idw.model.rn.injet.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TaxaUtilizacaoMesInjetDTO implements Serializable{

	private Double percentualCrescimento;
	private Integer mes;
	private Integer ano;
	
	public Double getPercentualCrescimento() {
		return percentualCrescimento;
	}
	public void setPercentualCrescimento(Double percentualCrescimento) {
		this.percentualCrescimento = percentualCrescimento;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getAno() {
		return ano;
	}
	public String getAnoFormatado() {
		return ano.toString().substring(2);
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	
}
