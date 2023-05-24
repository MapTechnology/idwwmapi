package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.List;

public class DetalhamentoDefeitoComponenteDTO {

	private List<DetalhamentoDefeitoComponenteDTO> listaResultadoPesquisa;	
	
	private String cdComponente;
	private String dsPosicaoMecanica;
	private String cdComponentePosMecanica;
	private BigDecimal quantidade;
	
	public List<DetalhamentoDefeitoComponenteDTO> getListaResultadoPesquisa() {
		return listaResultadoPesquisa;
	}
	public void setListaResultadoPesquisa(List<DetalhamentoDefeitoComponenteDTO> listaResultadoPesquisa) {
		this.listaResultadoPesquisa = listaResultadoPesquisa;
	}
	public String getCdComponente() {
		return cdComponente;
	}
	public void setCdComponente(String cdComponente) {
		this.cdComponente = cdComponente;
	}
	public String getDsPosicaoMecanica() {
		return dsPosicaoMecanica;
	}
	public void setDsPosicaoMecanica(String dsPosicaoMecanica) {
		this.dsPosicaoMecanica = dsPosicaoMecanica;
	}
	public String getCdComponentePosMecanica() {
		return cdComponentePosMecanica;
	}
	public void setCdComponentePosMecanica(String cdComponentePosMecanica) {
		this.cdComponentePosMecanica = cdComponentePosMecanica;
	}
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	
}
