package idw.webservices.dto;

import java.util.List;

public class RelatorioCavInativasDTO {

	private String maquina;
	private String molde;
	private String qtdCavs;
	private String qtdCavsAtivas;
	private String indicePerdas;
	private List<RelatorioCavInativasDTO> itens;
	
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getMolde() {
		return molde;
	}
	public void setMolde(String molde) {
		this.molde = molde;
	}
	public String getQtdCavs() {
		return qtdCavs;
	}
	public void setQtdCavs(String qtdCavs) {
		this.qtdCavs = qtdCavs;
	}
	public String getQtdCavsAtivas() {
		return qtdCavsAtivas;
	}
	public void setQtdCavsAtivas(String qtdCavsAtivas) {
		this.qtdCavsAtivas = qtdCavsAtivas;
	}
	public String getIndicePerdas() {
		return indicePerdas;
	}
	public void setIndicePerdas(String indicePerdas) {
		this.indicePerdas = indicePerdas;
	}
	public List<RelatorioCavInativasDTO> getItens() {
		return itens;
	}
	public void setItens(List<RelatorioCavInativasDTO> itens) {
		this.itens = itens;
	}	
	
}