/*
 * Created on 07/04/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package idw.view.grafico;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.EmptyBlock;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;

/**
 * @author abarros
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class GraficoAbstractBarraLinhaView extends GraficoBase{

	
    protected abstract CategoryDataset createBarras();

    protected abstract CategoryDataset createLinhas();
    
    @Override
	protected JFreeChart createChart() {
        // create the chart...
        JFreeChart chart = ChartFactory.createBarChart3D(
            this.getTituloGrafico()	,        // chart title
            this.getTituloEixoX(),               // domain axis label
            this.getTituloEixoY(),                  // range axis label
            this.createBarras(),         // data
            this.getOrientacaoGrafico(),
            this.isMostraLegenda(),                    // include legend
            this.isMostraDicas(),                     // tooltips?
            this.isMostraUrl()                     // URL generator?  Not required...
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(this.getCorFundo());

        // get a reference to the plot for further customisation...
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(0xEE, 0xEE, 0xFF));
        plot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);

        CategoryDataset dataset2 = createLinhas();
        plot.setDataset(1, dataset2);
        plot.mapDatasetToRangeAxis(1, 1);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
        final ValueAxis axis2 = new NumberAxis(this.getTituloEixoY_Direito());
        plot.setRangeAxis(1, axis2);

        // Abaixo habilita a apresentação dos labels das barras
	    CategoryItemRenderer renderer = (CategoryItemRenderer) plot.getRenderer();
	    renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	    renderer.setBaseItemLabelsVisible(this.isMostrarLabel());
        
        LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
        renderer2.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        plot.setRenderer(1, renderer2);
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
	    renderer2.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	    renderer2.setBaseItemLabelsVisible(this.isMostrarLabel());
        
        LegendTitle legend1 = new LegendTitle(plot.getRenderer(0));
        legend1.setMargin(new RectangleInsets(2, 2, 2, 2));
//        legend1.setBorder(new BlockBorder());
        
        LegendTitle legend2 = new LegendTitle(plot.getRenderer(1));
        legend2.setMargin(new RectangleInsets(2, 2, 2, 2));
//        legend2.setBorder(new BlockBorder());
        
        BlockContainer container = new BlockContainer(new BorderArrangement());
        container.add(legend1, RectangleEdge.LEFT);
        container.add(legend2, RectangleEdge.RIGHT);
        container.add(new EmptyBlock(2000, 0));
        CompositeTitle legends = new CompositeTitle(container);
        legends.setPosition(RectangleEdge.BOTTOM);
        chart.addSubtitle(legends);

        // OPTIONAL CUSTOMISATION COMPLETED.
        return chart;
    }
}
