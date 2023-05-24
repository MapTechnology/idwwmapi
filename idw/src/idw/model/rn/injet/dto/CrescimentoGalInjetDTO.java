package idw.model.rn.injet.dto;


import java.io.Serializable;
import java.util.List;

import idw.util.FormulasInjet;

@SuppressWarnings("serial")
public class CrescimentoGalInjetDTO implements Serializable {
	private String identificacaoGalpao;
	private String descricaoGalpao;
	public String getDescricaoGalpao() {
		return descricaoGalpao;
	}
	public void setDescricaoGalpao(String descricaoGalpao) {
		this.descricaoGalpao = descricaoGalpao;
	}
	private Double percentualCrescimento;
	private Integer crescimento;
	private Double taxaUtilizacaoMesAtual;
	private Double taxaUtilizacaoMesAnterior;
	private List<CrescimentoMaqInjetDTO> maquinas;
	
	public String getIdentificacaoGalpao() {
		return identificacaoGalpao;
	}
	public void setIdentificacaoGalpao(String identificacaoGalpao) {
		this.identificacaoGalpao = identificacaoGalpao;
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
	public String getTaxaUtilizacaoMesAtualString() {
		try {
			return FormulasInjet.formatarCasaDecimalDoFloat(taxaUtilizacaoMesAtual.floatValue() * 100).toString();
		} catch (Exception e) {
			return "0";
		}
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
	public List<CrescimentoMaqInjetDTO> getMaquinas() {
		return maquinas;
	}
	public void setMaquinas(List<CrescimentoMaqInjetDTO> maquinas) {
		this.maquinas = maquinas;
	}
	
	public String getPercentualCrescimentoString() {
		try {
			return FormulasInjet.formatarCasaDecimalDoFloat(percentualCrescimento.floatValue()).toString();
		} catch (Exception e) {
			return "0";
		}
		
	}
}
