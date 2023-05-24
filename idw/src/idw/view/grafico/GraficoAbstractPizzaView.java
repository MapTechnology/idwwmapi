/*
 * Created on 07/04/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package idw.view.grafico;

import java.io.Serializable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;


/**
 * @author abarros
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
@SuppressWarnings("serial")
public abstract class GraficoAbstractPizzaView extends GraficoBase  implements Serializable{

	
    protected abstract PieDataset createFatias();

    @Override
	protected JFreeChart createChart() {
		JFreeChart chart = ChartFactory.createPieChart3D(
				this.getTituloGrafico(), // chart title
				this.createFatias(), // data
				this.isMostraLegenda(), // include legend
				this.isMostraDicas(), // tooltips?
				this.isMostraUrl() // URLs?
		);

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(this.getCorFundo());

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        plot.setNoDataMessage("Sem informações");

        return chart;
    }
}
