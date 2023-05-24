package idw.view.grafico;

import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.data.xy.XYDataset;



public class XYMeuToolTipGenerator  extends StandardXYToolTipGenerator{
	/**
	 * 
	 */
	private static final long serialVersionUID = 321385263178766866L;
	private String[] textotooltips;
	public XYMeuToolTipGenerator(String[] textos){
		this.textotooltips = textos;
	}

	@Override
	public String generateToolTip(XYDataset dataset, int series, int item) {
        return this.textotooltips[item];
	}
 

}
