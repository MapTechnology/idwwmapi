package idw.view.grafico;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class GraficoAreaParada extends GraficoAbstractPizzaView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultPieDataset datasetFatias = new DefaultPieDataset();
	//private List<Ijareres> ijareress = new ArrayList<Ijareres>();
	
	@Override
	protected PieDataset createFatias() {
//		datasetBarras.clear();
//		for (Ijareres ijareres : this.ijareress){
//			NumberFormat n = NumberFormat.getInstance(Locale.FRENCH);
//
//			String percentual = n.format(ijareres.obtemPercentualParada().doubleValue());
//
//			datasetFatias.setValue(ijareres.getDsarea()+ "(" + percentual + "%)", new Double(ijareres.obtemPercentualParada()));
//		}
		
		return datasetFatias;
	}

//	public List<Ijareres> getIjareress() {
//		return ijareress;
//	}

//	public void setIjareress(List<Ijareres> ijareress) {
//		this.ijareress = ijareress;
//	}

}
