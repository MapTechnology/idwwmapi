/*
 * Created on 07/04/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package idw.view.grafico;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.EmptyBlock;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;


/**
 * @author abarros
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
@SuppressWarnings("serial")
public abstract class GraficoAbstractBarraView extends GraficoBase  implements Serializable{

	
    protected abstract CategoryDataset createBarras();
    
    protected abstract CategoryDataset createLinhas();

    @Override
	protected JFreeChart createChart() {
        // create the chart...
        JFreeChart chart = ChartFactory.createLineChart(
            this.getTituloGrafico()	,        // chart title
            this.getTituloEixoX(),               // domain axis label
            this.getTituloEixoY(),                  // range axis label
            this.createLinhas(),         // data
            this.getOrientacaoGrafico(),
            this.isMostraLegenda(),                    // include legend
            this.isMostraDicas(),                     // tooltips?
            this.isMostraUrl()                     // URL generator?  Not required...
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(this.getCorFundo());
        
        // get a reference to the plot for further customisation...
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        //plot.setBackgroundPaint(new Color(0xEE, 0xEE, 0xFF));
        plot.setBackgroundPaint(this.getCorFundo());
        plot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);     
        
//        CategoryDataset dataset2 = createLinhas();
//        plot.setDataset(1, dataset2);       
        
        
          
        //plot.mapDatasetToRangeAxis(1, 1);
        
        // Abaixo habilita a apresentação dos labels das barras
	    CategoryItemRenderer renderer = null;
	    if (this.isCoresEspecificasParaAsBarras())
	    	renderer = new CoresDasLinhas3DRenderer(this.getCoresBarras());
	    else
	    	renderer = (CategoryItemRenderer) plot.getRenderer();
	    
	    renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	    renderer.setBaseItemLabelsVisible(this.isMostrarLabel());	    
	    plot.setRenderer(0, renderer);
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
	    
	    plot.setBackgroundPaint(this.getCorFundo());
	    
	    if (this.getLimiteSuperior() > 0){
	    	NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
	    	rangeAxis.setRange(0d, this.getLimiteSuperior() + 2d);
	    }
	    
	    Marker marker = new ValueMarker(this.getLimiteSuperior());
        marker.setOutlinePaint(Color.red);
        marker.setPaint(Color.red);
        marker.setStroke(new BasicStroke(2.0f));
        plot.addRangeMarker(marker, Layer.FOREGROUND);
        
        Marker markerInferior = new ValueMarker(this.getLimiteInferior());
        markerInferior.setOutlinePaint(Color.blue);
        markerInferior.setPaint(Color.blue);
        markerInferior.setStroke(new BasicStroke(2.0f));
        plot.addRangeMarker(markerInferior, Layer.FOREGROUND); 
        
        LegendTitle legend1 = new LegendTitle(plot.getRenderer(0));
        legend1.setMargin(new RectangleInsets(2, 2, 2, 2));
        legend1.setBackgroundPaint(this.getCorFundo());
        
        LegendTitle legend2 = new LegendTitle(plot.getRenderer(0));
        legend1.setMargin(new RectangleInsets(2, 2, 2, 2));
        legend1.setBackgroundPaint(this.getCorFundo());  
        
        LegendTitle legend3 = new LegendTitle(plot.getRenderer(0));
        legend1.setMargin(new RectangleInsets(2, 2, 2, 2));
        legend1.setBackgroundPaint(this.getCorFundo());  
        
//        legend1.setBorder(new BlockBorder());       
            
        
        
        
		if (this.isMostraRange()){
			IntervalMarker target = new IntervalMarker(this.getLimiteInferior(), this.getLimiteSuperior());
			target.setLabelFont(new Font("SansSerif", Font.ITALIC, 11));
			target.setLabelAnchor(RectangleAnchor.LEFT);
			target.setLabelTextAnchor(TextAnchor.CENTER_LEFT);
			target.setPaint(Color.black);
			plot.addRangeMarker(target, Layer.BACKGROUND);
		}
        
		if (this.isMostraLegenda() == true){
	        BlockContainer container = new BlockContainer(new BorderArrangement());
	        container.add(legend1, RectangleEdge.TOP);
	        container.add(legend2, RectangleEdge.LEFT);
	        container.add(legend3, RectangleEdge.BOTTOM);
	        container.add(new EmptyBlock(0, 0));
	        CompositeTitle legends = new CompositeTitle(container);
	        legends.setPosition(RectangleEdge.RIGHT);
	        chart.addSubtitle(legends);
		}
		

        // OPTIONAL CUSTOMISATION COMPLETED.
        return chart;
    }
}