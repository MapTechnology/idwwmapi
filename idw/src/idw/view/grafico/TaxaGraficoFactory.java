package idw.view.grafico;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.util.ArrayList;
import java.util.List;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import idw.webservices.dto.ElementoDTO;
import idw.webservices.dto.FiltroGraficoDTO;
import idw.webservices.dto.GraficoDTO;
import idw.webservices.dto.SerieDTO;


@SuppressWarnings("serial")
public class TaxaGraficoFactory extends GraficosCfwswebFactory{

	FiltroGraficoDTO filtro = null;
	
	public TaxaGraficoFactory(){
		this.setTituloGrafico("Taxa de falha no teste final");
		this.setTituloEixoY("% produtos com falha");
		this.setTituloEixoX("");
		this.setMostraLegenda(false);		
		
	}

	@Override
	protected CategoryDataset createBarras() {
		
		GradientPaint gp0 = new GradientPaint(
				0.0f, 0.0f, Color.blue,
				0.0f, 0.0f, Color.blue
		);
		
		GraficoDTO grafico = filtro.getGrafico();

		DefaultCategoryDataset result = new DefaultCategoryDataset();
		
		List<Paint> coresBarras = new ArrayList<Paint>();
		
		for (SerieDTO serie : grafico.getSeriesDTO()){
			for (ElementoDTO elemento : serie.getElementos()){
				result.addValue( elemento.getValor(), serie.getDescricao(), elemento.getDescricao());
				coresBarras.add(gp0);  
			}
		}
		
		this.setCoresBarras(coresBarras.toArray());
		
		this.setCoresEspecificasParaAsBarras(true);

		return result;

	}
	
	@Override
	protected CategoryDataset createLinhas() {
		
		GraficoDTO grafico = filtro.getGrafico();

		DefaultCategoryDataset result = new DefaultCategoryDataset();
		
		
		for (SerieDTO serie : grafico.getSeriesDTO()){
			for (ElementoDTO elemento : serie.getElementos()){
				result.addValue( elemento.getValor(), serie.getDescricao(), elemento.getDescricao());
			}
		}

		return result;

	}
	
	@Override
	public void setFiltroGraficoDTO(FiltroGraficoDTO filtro) {
		this.filtro = filtro;
	}
}
