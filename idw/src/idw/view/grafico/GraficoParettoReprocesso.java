package idw.view.grafico;

import java.awt.Color;
import java.awt.Paint;
import java.util.ArrayList;
import java.util.List;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import idw.webservices.dto.SerieParettoDTO;


public class GraficoParettoReprocesso extends GraficoAbstractParettoView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultCategoryDataset datasetBarras = new DefaultCategoryDataset();
	private List<SerieParettoDTO> parettos = new ArrayList<SerieParettoDTO>();

	public GraficoParettoReprocesso(){
		this.setTituloGrafico("Paretto do Reprocesso");
		this.setTituloEixoY("Qtde de Apontamentos");
		this.setTituloEixoX("");
		this.setMostraLegenda(false);		
		
	}
	
	@Override
	protected CategoryDataset createBarras() {
//		datasetBarras.clear();

		if (this.parettos == null){
			return datasetBarras;
		}
		List<Paint> coresBarras = new ArrayList<Paint>();

		try{
			for (SerieParettoDTO paretto : this.parettos){
				datasetBarras.addValue(paretto.getQtdeApontamento(), "%", paretto.getElemento());

				coresBarras.add(Color.blue); 
			}

			this.setCoresBarras(coresBarras.toArray());

			this.setCoresEspecificasParaAsBarras(true);
		} catch (Exception e){
			e.printStackTrace();
		}
		return datasetBarras;
	}

	public List<SerieParettoDTO> getParettos() {
		return parettos;
	}

	public void setParettos(List<SerieParettoDTO> parettos) {
		this.parettos = parettos;
	}

	@Override
	protected CategoryDataset createLinhas() {
		// TODO Auto-generated method stub
		return null;
	}
}
