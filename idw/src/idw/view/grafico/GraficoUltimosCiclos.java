package idw.view.grafico;

import java.awt.Paint;
import java.util.ArrayList;
import java.util.List;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import injetws.webservices.dto.IwsCicloDTO;

public class GraficoUltimosCiclos extends GraficoAbstractBarraView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultCategoryDataset datasetBarras = new DefaultCategoryDataset();
	private List<IwsCicloDTO> ciclos = new ArrayList<IwsCicloDTO>();

	@Override
	protected CategoryDataset createBarras() {

//		GradientPaint gp0 = new GradientPaint(
//				0.0f, 0.0f, Color.yellow,
//				0.0f, 0.0f, new Color(0, 0, 64)
//		);
//
//		GradientPaint gp1 = new GradientPaint(
//				0.0f, 0.0f, Color.green,
//				0.0f, 0.0f, new Color(0, 64, 0)
//		);
//
//		GradientPaint gp2 = new GradientPaint(
//				0.0f, 0.0f, Color.red,
//				0.0f, 0.0f, new Color(64, 0, 0)
//		);

		List<Paint> coresBarras = new ArrayList<Paint>();

		try{
//			int contador = 1;
//			for (CicloDTO ciclo : this.ciclos){
//				datasetBarras.addValue(ciclo.getEficienciaCiclo(), "%", String.valueOf(contador++));
//
//				if (ciclo.getEficienciaCiclo() > 50) { 
//					coresBarras.add(gp2); 
//				} else if (ciclo.getEficienciaCiclo() >= 10 && ciclo.getEficienciaCiclo() <= 50){ 
//					coresBarras.add(gp0);  
//				} else coresBarras.add(gp1); 
//			}

			this.setCoresBarras(coresBarras.toArray());

			this.setCoresEspecificasParaAsBarras(true);
		} catch (Exception e){
			e.printStackTrace();
		}
		return datasetBarras;
	}

//	public List<CicloDTO> getCiclos() {
//		return ciclos;
//	}
//
//	public void setCiclos(List<CicloDTO> ciclos) {
//		this.ciclos = ciclos;
//	}

	@Override
	protected CategoryDataset createLinhas() {
		// TODO Auto-generated method stub
		return null;
	}
}
