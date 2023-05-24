package idw.view.grafico;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class GraficoPerdas extends GraficoAbstractPizzaView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultPieDataset datasetFatias = new DefaultPieDataset();
	
	private BigDecimal perdasParadas;
	private BigDecimal perdasCiclos;
	private BigDecimal perdasCavidades;
	private BigDecimal perdasRefugos;
	
	@Override
	protected PieDataset createFatias() {
//		datasetBarras.clear();
		NumberFormat n = NumberFormat.getInstance(Locale.FRENCH);

		String percentual1 = n.format(perdasParadas.doubleValue());
		String percentual2 = n.format(perdasCiclos.doubleValue());
		String percentual3 = n.format(perdasCavidades.doubleValue());
		String percentual4 = n.format(perdasRefugos.doubleValue());

		datasetFatias.setValue("Paradas" + "(" + percentual1 + "%)", perdasParadas.doubleValue());
		datasetFatias.setValue("Ciclos" + "(" + percentual2 + "%)", perdasCiclos.doubleValue());
		datasetFatias.setValue("Cavidades" + "(" + percentual3 + "%)", perdasCavidades.doubleValue());
		datasetFatias.setValue("Refugos" + "(" + percentual4 + "%)", perdasRefugos.doubleValue());

		return datasetFatias;
	}

	public DefaultPieDataset getDatasetFatias() {
		return datasetFatias;
	}

	public void setDatasetFatias(DefaultPieDataset datasetFatias) {
		this.datasetFatias = datasetFatias;
	}

	public BigDecimal getPerdasParadas() {
		return perdasParadas;
	}

	public void setPerdasParadas(BigDecimal perdasParadas) {
		this.perdasParadas = perdasParadas;
	}

	public BigDecimal getPerdasCiclos() {
		return perdasCiclos;
	}

	public void setPerdasCiclos(BigDecimal perdasCiclos) {
		this.perdasCiclos = perdasCiclos;
	}

	public BigDecimal getPerdasCavidades() {
		return perdasCavidades;
	}

	public void setPerdasCavidades(BigDecimal perdasCavidades) {
		this.perdasCavidades = perdasCavidades;
	}

	public BigDecimal getPerdasRefugos() {
		return perdasRefugos;
	}

	public void setPerdasRefugos(BigDecimal perdasRefugos) {
		this.perdasRefugos = perdasRefugos;
	}

}
