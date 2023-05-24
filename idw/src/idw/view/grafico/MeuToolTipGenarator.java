package idw.view.grafico;

import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.data.category.CategoryDataset;


public class MeuToolTipGenarator extends StandardCategoryToolTipGenerator{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2921399013794288268L;
	private String[] textotooltips;
	public MeuToolTipGenarator(String[] textos){
		this.textotooltips = textos;
	}

	@Override
	public String generateToolTip(CategoryDataset dataset, int series, int item) { 
        return this.textotooltips[item];
	}
}
