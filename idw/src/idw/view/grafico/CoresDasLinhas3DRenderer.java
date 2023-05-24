package idw.view.grafico;

import java.awt.Paint;

import org.jfree.chart.renderer.category.LineAndShapeRenderer;

public class CoresDasLinhas3DRenderer extends LineAndShapeRenderer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object[] cores;

	public CoresDasLinhas3DRenderer(Object[] cores) {
            this.cores = cores;
       }
	
    @Override
	public Paint getItemPaint(int row, int column){ 
    	return (cores.length-1 < column ? (Paint) cores[0] : (Paint) cores[column] );
    }

    @Override
    public boolean equals(Object o){
    	return super.equals(o);
    }
    
    @Override
    public int hashCode(){
    	return super.hashCode();
    }
}
