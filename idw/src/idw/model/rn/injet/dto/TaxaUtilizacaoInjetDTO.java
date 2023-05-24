package idw.model.rn.injet.dto;

import java.io.Serializable;
import java.util.List;

import idw.webservices.dto.GraficoDTO;

@SuppressWarnings("serial")
public class TaxaUtilizacaoInjetDTO implements Serializable{
	private List<TaxaUtilizacaoMesInjetDTO> taxas;
	private GraficoDTO grafico;
	private Double valorMedio;
	
	public List<TaxaUtilizacaoMesInjetDTO> getTaxas() {
		return taxas;
	}
	public void setTaxas(List<TaxaUtilizacaoMesInjetDTO> taxas) {
		this.taxas = taxas;
	}
	public GraficoDTO getGrafico() {
		return grafico;
	}
	public void setGrafico(GraficoDTO grafico) {
		this.grafico = grafico;
	}
	public Double getValorMedio() {
		return valorMedio;
	}
	public void setValorMedio(Double valorMedio) {
		this.valorMedio = valorMedio;
	}
	
	

}
