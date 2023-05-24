package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficoPerdasMp")
public class GraficoPerdasMpDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<PerdasProdutoDTO> perdasMateriaPrima;
	private List<PerdasFerramentaDTO> perdasFerramenta;
	private List<LegendaDataHoraDTO> legendasMateriaPrima;
	private List<LegendaDataHoraDTO> legendasFerramenta;
	private List<ChaveValorDTO> graficoDropRate;
	private List<ChaveValorDTO> graficoCustoPorPerda;
	private List<PerdasProdutoDTO> perdasMateriaPrimaOP;
	private List<PerdasProdutoDTO> perdasMateriaPrimaAlim;

	public List<PerdasProdutoDTO> getPerdasMateriaPrimaOP() {
		return perdasMateriaPrimaOP;
	}
	public void setPerdasMateriaPrimaOP(List<PerdasProdutoDTO> perdasMateriaPrimaOP) {
		this.perdasMateriaPrimaOP = perdasMateriaPrimaOP;
	}
	public List<PerdasProdutoDTO> getPerdasMateriaPrimaAlim() {
		return perdasMateriaPrimaAlim;
	}
	public void setPerdasMateriaPrimaAlim(List<PerdasProdutoDTO> perdasMateriaPrimaAlim) {
		this.perdasMateriaPrimaAlim = perdasMateriaPrimaAlim;
	}
	public List<PerdasProdutoDTO> getPerdasMateriaPrima() {
		return perdasMateriaPrima;
	}
	public void setPerdasMateriaPrima(List<PerdasProdutoDTO> perdasMateriaPrima) {
		this.perdasMateriaPrima = perdasMateriaPrima;
	}
	public List<PerdasFerramentaDTO> getPerdasFerramenta() {
		return perdasFerramenta;
	}
	public void setPerdasFerramenta(List<PerdasFerramentaDTO> perdasFerramenta) {
		this.perdasFerramenta = perdasFerramenta;
	}
	public List<LegendaDataHoraDTO> getLegendasMateriaPrima() {
		return legendasMateriaPrima;
	}
	public void setLegendasMateriaPrima(
			List<LegendaDataHoraDTO> legendasMateriaPrima) {
		this.legendasMateriaPrima = legendasMateriaPrima;
	}
	public List<LegendaDataHoraDTO> getLegendasFerramenta() {
		return legendasFerramenta;
	}
	public void setLegendasFerramenta(List<LegendaDataHoraDTO> legendasFerramenta) {
		this.legendasFerramenta = legendasFerramenta;
	}
	public List<ChaveValorDTO> getGraficoDropRate() {
		return graficoDropRate;
	}
	public void setGraficoDropRate(List<ChaveValorDTO> graficoDropRate) {
		this.graficoDropRate = graficoDropRate;
	}
	public List<ChaveValorDTO> getGraficoCustoPorPerda() {
		return graficoCustoPorPerda;
	}
	public void setGraficoCustoPorPerda(List<ChaveValorDTO> graficoCustoPorPerda) {
		this.graficoCustoPorPerda = graficoCustoPorPerda;
	}
	
	
}
