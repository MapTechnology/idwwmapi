package ms.coleta.dto;

import java.util.List;

public class IndicadoresColetaGraficoInjetDTO {

	private Double OEE;
	private Double Meta;
	private Double producaoLiquida;
	private Double cicloPadrao;
	private Double cicloMedio;
	private Double efiCiclo;
	private String nrOP;
	private List<ItemGraficoOEEHoraHoraInjetDTO> listaHoras;
	
	public Double getOEE() {
		return OEE;
	}
	public void setOEE(Double oEE) {
		OEE = oEE;
	}
	public Double getMeta() {
		return Meta;
	}
	public void setMeta(Double meta) {
		Meta = meta;
	}
	public Double getProducaoLiquida() {
		return producaoLiquida;
	}
	public void setProducaoLiquida(Double producaoLiquida) {
		this.producaoLiquida = producaoLiquida;
	}
	public Double getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(Double cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public Double getCicloMedio() {
		return cicloMedio;
	}
	public void setCicloMedio(Double cicloMedio) {
		this.cicloMedio = cicloMedio;
	}
	public String getNrOP() {
		return nrOP;
	}
	public void setNrOP(String nrOP) {
		this.nrOP = nrOP;
	}
	public List<ItemGraficoOEEHoraHoraInjetDTO> getListaHoras() {
		return listaHoras;
	}
	public void setListaHoras(List<ItemGraficoOEEHoraHoraInjetDTO> listaHoras) {
		this.listaHoras = listaHoras;
	}
	public Double getEfiCiclo() {
		return efiCiclo;
	}
	public void setEfiCiclo(Double efiCiclo) {
		this.efiCiclo = efiCiclo;
	}
	
	
	
}
