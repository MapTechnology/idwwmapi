/*
 * Created on 07/04/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package idw.view.grafico;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.EmptyBlock;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RectangleEdge;


/**
 * @author abarros
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
@SuppressWarnings("serial")
public abstract class GraficoAbstractParettoView extends GraficoAbstractBarraView{

	
    @Override
	protected abstract CategoryDataset createBarras();

    @Override
	protected JFreeChart createChart() {
        // create the chart...
        JFreeChart chart = ChartFactory.createBarChart3D(
            this.getTituloGrafico()	,        // chart title
            this.getTituloEixoX(),               // domain axis label
            this.getTituloEixoY(),                  // range axis label
            this.createBarras(),         // data
            PlotOrientation.VERTICAL ,
            this.isMostraLegenda(),                    // include legend
            this.isMostraDicas(),                     // tooltips?
            this.isMostraUrl()                     // URL generator?  Not required...
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(this.getCorFundo());

        // get a reference to the plot for further customisation...
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(this.getCorFundo());

        // Abaixo habilita a apresentação dos labels das barras
	    CategoryItemRenderer renderer = null;
	    if (this.isCoresEspecificasParaAsBarras())
	    	renderer = new CoresDasBarras3DRenderer(this.getCoresBarras());
	    else
	    	renderer = (CategoryItemRenderer) plot.getRenderer();

	    renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	    renderer.setBaseItemLabelsVisible(this.isMostrarLabel());
        
//        LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
//        renderer2.setToolTipGenerator(new StandardCategoryToolTipGenerator());
//        plot.setRenderer(1, renderer2);
//        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
//	    renderer2.setLabelGenerator(new StandardCategoryLabelGenerator());
//	    renderer2.setItemLabelsVisible(this.isMostrarLabel());
        
	    plot.setRenderer(renderer);
//        LegendTitle legend1 = new LegendTitle(plot.getRenderer(0));
//        legend1.setMargin(new RectangleInsets(2, 2, 2, 2));
//        legend1.setBorder(new BlockBorder());

//        LegendTitle legend2 = new LegendTitle(plot.getRenderer(1));
//        legend2.setMargin(new RectangleInsets(2, 2, 2, 2));
//        legend2.setBorder(new BlockBorder());
        
        BlockContainer container = new BlockContainer(new BorderArrangement());
//        container.add(legend1, RectangleEdge.LEFT);
//        container.add(legend2, RectangleEdge.RIGHT);
        container.add(new EmptyBlock(2000, 0));
        CompositeTitle legends = new CompositeTitle(container);
        legends.setPosition(RectangleEdge.BOTTOM);
        chart.addSubtitle(legends);

        // OPTIONAL CUSTOMISATION COMPLETED.
        return chart;
    }

}
