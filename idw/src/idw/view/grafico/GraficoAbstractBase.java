/*
 * Created on 07/04/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package idw.view.grafico;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;

/**
 * @author abarros
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class GraficoAbstractBase {
	private String tituloGrafico = "";
	private String tituloEixoX = "";
	private String tituloEixoY = "";
	private String tituloEixoY_Direito = "";
	private boolean mostraLegenda = false;
	private boolean mostraDicas = false;
	private boolean mostraUrl = false;
	private boolean mostraRange = false;
	private PlotOrientation orientacaoGrafico = PlotOrientation.VERTICAL;
	private Color corFundo = Color.WHITE;
	private int LarguraGraficoEmPixel = 400;
	private int AlturaGraficoEmPixel = 300;
	private boolean mostrarLabel = true;
	private double LimiteInferior = 0;
	private double LimiteSuperior = 0;
	private boolean coresEspecificasParaAsBarras = false;
	private Object[] coresBarras = null;
	private String tituloLimiteSuperior;
	private String tituloLimiteInferior;
	
	public String getTituloLimiteSuperior() {
		return tituloLimiteSuperior;
	}
	public void setTituloLimiteSuperior(String tituloLimiteSuperior) {
		this.tituloLimiteSuperior = tituloLimiteSuperior;
	}
	public String getTituloLimiteInferior() {
		return tituloLimiteInferior;
	}
	public void setTituloLimiteInferior(String tituloLimiteInferior) {
		this.tituloLimiteInferior = tituloLimiteInferior;
	}
	/**
	 * @return Returns the tituloEixoX.
	 */
	public String getTituloEixoX() {
		return tituloEixoX;
	}
	/**
	 * @param tituloEixoX The tituloEixoX to set.
	 */
	public void setTituloEixoX(String tituloEixoX) {
		this.tituloEixoX = tituloEixoX;
	}
	/**
	 * @return Returns the tituloEixoY.
	 */
	public String getTituloEixoY() {
		return tituloEixoY;
	}
	/**
	 * @param tituloEixoY The tituloEixoY to set.
	 */
	public void setTituloEixoY(String tituloEixoY) {
		this.tituloEixoY = tituloEixoY;
	}
	/**
	 * @return Returns the tituloEixoY_Direito.
	 */
	public String getTituloEixoY_Direito() {
		return tituloEixoY_Direito;
	}
	/**
	 * @param tituloEixoY_Direito The tituloEixoY_Direito to set.
	 */
	public void setTituloEixoY_Direito(String tituloEixoY_Direito) {
		this.tituloEixoY_Direito = tituloEixoY_Direito;
	}
	/**
	 * @return Returns the tituloGrafico.
	 */
	public String getTituloGrafico() {
		return tituloGrafico;
	}
	/**
	 * @param tituloGrafico The tituloGrafico to set.
	 */
	public void setTituloGrafico(String tituloGrafico) {
		this.tituloGrafico = tituloGrafico;
	}
	/**
	 * @return Returns the mostraDicas.
	 */
	public boolean isMostraDicas() {
		return mostraDicas;
	}
	/**
	 * @param mostraDicas The mostraDicas to set.
	 */
	public void setMostraDicas(boolean mostraDicas) {
		this.mostraDicas = mostraDicas;
	}
	/**
	 * @return Returns the mostraLegenda.
	 */
	public boolean isMostraLegenda() {
		return mostraLegenda;
	}
	/**
	 * @param mostraLegenda The mostraLegenda to set.
	 */
	public void setMostraLegenda(boolean mostraLegenda) {
		this.mostraLegenda = mostraLegenda;
	}
	/**
	 * @return Returns the mostraUrl.
	 */
	public boolean isMostraUrl() {
		return mostraUrl;
	}
	/**
	 * @param mostraUrl The mostraUrl to set.
	 */
	public void setMostraUrl(boolean mostraUrl) {
		this.mostraUrl = mostraUrl;
	}
	/**
	 * @return Returns the orientacaoGrafico.
	 */
	public PlotOrientation getOrientacaoGrafico() {
		return orientacaoGrafico;
	}
	/**
	 * @param orientacaoGrafico The orientacaoGrafico to set.
	 */
	public void setOrientacaoGrafico(PlotOrientation orientacaoGrafico) {
		this.orientacaoGrafico = orientacaoGrafico;
	}
	/**
	 * @return Returns the corFundo.
	 */
	public Color getCorFundo() {
		return corFundo;
	}
	/**
	 * @param corFundo The corFundo to set.
	 */
	public void setCorFundo(Color corFundo) {
		this.corFundo = corFundo;
	}
	/**
	 * @return Returns the alturaGraficoEmPixel.
	 */
	public int getAlturaGraficoEmPixel() {
		return AlturaGraficoEmPixel;
	}
	/**
	 * @param alturaGraficoEmPixel The alturaGraficoEmPixel to set.
	 */
	public void setAlturaGraficoEmPixel(int alturaGraficoEmPixel) {
		AlturaGraficoEmPixel = alturaGraficoEmPixel;
	}
	/**
	 * @return Returns the larguraGraficoEmPixel.
	 */
	public int getLarguraGraficoEmPixel() {
		return LarguraGraficoEmPixel;
	}
	/**
	 * @param larguraGraficoEmPixel The larguraGraficoEmPixel to set.
	 */
	public void setLarguraGraficoEmPixel(int larguraGraficoEmPixel) {
		LarguraGraficoEmPixel = larguraGraficoEmPixel;
	}
	/**
	 * @return Returns the mostrarLabel.
	 */
	public boolean isMostrarLabel() {
		return mostrarLabel;
	}
	/**
	 * @param mostrarLabel The mostrarLabel to set.
	 */
	public void setMostrarLabel(boolean mostrarLabel) {
		this.mostrarLabel = mostrarLabel;
	}
	/**
	 * @return Returns the limiteInferior.
	 */
	public double getLimiteInferior() {
		return LimiteInferior;
	}
	/**
	 * @param limiteInferior The limiteInferior to set.
	 */
	public void setLimiteInferior(double limiteInferior) {
		LimiteInferior = limiteInferior;
	}
	/**
	 * @return Returns the limiteSuperior.
	 */
	public double getLimiteSuperior() {
		return LimiteSuperior;
	}
	/**
	 * @param limiteSuperior The limiteSuperior to set.
	 */
	public void setLimiteSuperior(double limiteSuperior) {
		LimiteSuperior = limiteSuperior;
	}
	/**
	 * @return Returns the mostraRange.
	 */
	public boolean isMostraRange() {
		return mostraRange;
	}
	/**
	 * @param mostraRange The mostraRange to set.
	 */
	public void setMostraRange(boolean mostraRange) {
		this.mostraRange = mostraRange;
	}
	
	protected abstract JFreeChart createChart();
	
    public String mostraGraficoNaWeb(HttpSession session, PrintWriter outTexto) throws IOException{
    	String NomeArquivo = "";
    	String graphURL = "";
    	
    	JFreeChart chart = createChart();
    	
		//  Grava o arquivo com a imagem do gr�fico no diretorio temporario
		ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
		NomeArquivo = ServletUtilities.saveChartAsPNG(chart, 
				this.getLarguraGraficoEmPixel(), 
				this.getAlturaGraficoEmPixel(), info, session);


	
		
		// Grava o mapa do gr�fico no objeto PrintWriter
		// isto � necessario para habilitar o click na barra do grafico
		ChartUtilities.writeImageMap(outTexto, NomeArquivo, info, false);
		outTexto.flush();

		graphURL = "servlet/DisplayChart?filename=" + NomeArquivo;
		
		return graphURL;
    }
	public boolean isCoresEspecificasParaAsBarras() {
		return coresEspecificasParaAsBarras;
	}
	public void setCoresEspecificasParaAsBarras(boolean coresEspecificasParaAsBarras) {
		this.coresEspecificasParaAsBarras = coresEspecificasParaAsBarras;
	}
	public Object[] getCoresBarras() {
		return coresBarras;
	}
	public void setCoresBarras(Object[] coresBarras) {
		this.coresBarras = coresBarras;
	}
}
