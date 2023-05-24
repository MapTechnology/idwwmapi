package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class RelIndTesteFinalDTO implements Serializable {
	
	private Double piorIndice;
	private Double melhorIndice;
	private Date inicioMelhorIndice;
	private Date fimMelhorIndice;
	private Date inicioPiorIndice;
	private Date fimPiorIndice;
	private List<SerieTaxaFalhaDTO> taxas;
	private List<SerieParettoDTO> parettos;
	private List<String> plataformasSelecionadas = new ArrayList<String>();
	
	public List<String> getPlataformasSelecionadas() {
		return plataformasSelecionadas;
	}
	public void setPlataformasSelecionadas(List<String> plataformasSelecionadas) {
		this.plataformasSelecionadas = plataformasSelecionadas;
	}
	public Double getPiorIndice() {
		return piorIndice;
	}
	public void setPiorIndice(Double piorIndice) {
		this.piorIndice = piorIndice;
	}
	public Double getMelhorIndice() {
		return melhorIndice;
	}
	public void setMelhorIndice(Double melhorIndice) {
		this.melhorIndice = melhorIndice;
	}
	public Date getInicioMelhorIndice() {
		return inicioMelhorIndice;
	}
	public void setInicioMelhorIndice(Date inicioMelhorIndice) {
		this.inicioMelhorIndice = inicioMelhorIndice;
	}
	public Date getFimMelhorIndice() {
		return fimMelhorIndice;
	}
	public void setFimMelhorIndice(Date fimMelhorIndice) {
		this.fimMelhorIndice = fimMelhorIndice;
	}
	public Date getInicioPiorIndice() {
		return inicioPiorIndice;
	}
	public void setInicioPiorIndice(Date inicioPiorIndice) {
		this.inicioPiorIndice = inicioPiorIndice;
	}
	public Date getFimPiorIndice() {
		return fimPiorIndice;
	}
	public void setFimPiorIndice(Date fimPiorIndice) {
		this.fimPiorIndice = fimPiorIndice;
	}
	public List<SerieTaxaFalhaDTO> getTaxas() {
		return taxas;
	}
	public void setTaxas(List<SerieTaxaFalhaDTO> taxas) {
		this.taxas = taxas;
	}
	public List<SerieParettoDTO> getParettos() {
		return parettos;
	}
	public void setParettos(List<SerieParettoDTO> parettos) {
		this.parettos = parettos;
	}	
	public GraficoDTO getGraficoTaxas(){
		GraficoDTO grafico = new GraficoDTO();		
		grafico.setSeriesDTO(new ArrayList<SerieDTO>());
		if (this.taxas == null)
			return grafico;
		SerieDTO serie1 = new SerieDTO();
		serie1.setElementos(new ArrayList<ElementoDTO>());
		for (SerieTaxaFalhaDTO taxa : this.taxas){
			ElementoDTO elemento = new ElementoDTO();
			elemento.setDescricao(taxa.getDescricao());
			elemento.setValor(taxa.getIndiceFalha());
			serie1.getElementos().add(elemento);
		}
		serie1.setDescricao("Taxa de Falha");
		grafico.getSeriesDTO().add(serie1);
		
		return grafico;
	}
	public GraficoDTO getGraficoParettos(){
		GraficoDTO grafico = new GraficoDTO();		
		grafico.setSeriesDTO(new ArrayList<SerieDTO>());
		
		SerieDTO serie1 = new SerieDTO();
		serie1.setElementos(new ArrayList<ElementoDTO>());
		for (SerieParettoDTO paretto : this.parettos){
			ElementoDTO elemento = new ElementoDTO();
			elemento.setDescricao(paretto.getElemento());
			elemento.setValor(paretto.getQtdeApontamento());
			serie1.getElementos().add(elemento);
		}
		grafico.getSeriesDTO().add(serie1);
		
		return grafico;
	}
	
}
