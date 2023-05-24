package idw.model.rn.detalhemonitorizacao;

import java.math.BigDecimal;

import idw.model.pojos.DwConsol;
import idw.util.FormulasInjet;

public final class IndicadoresDeTempoRN {

	private DwConsol dwconsol;
	private BigDecimal tempoProducaoLiquida;
	private BigDecimal tempoRitmo;
	private BigDecimal tempoAtivo;
	private BigDecimal tempoTrabalhado;
	private BigDecimal producaoBruta = BigDecimal.ZERO;
	private BigDecimal tempoCiclosProdutivos;
	private BigDecimal qtdCiclosProdutivos;
	private BigDecimal tempoCicloPadrao;
	
	
	public IndicadoresDeTempoRN(DwConsol dwconsol) {
		super();
		this.dwconsol = dwconsol;
		if (dwconsol != null)
			calcularIndicadores();
	}
	
	private void calcularIndicadores() {
		// Recalcula tempo boas
		// Recalcula tempo boas. Obtem os dados corretos, caso tenha sido
		// consolidado errado no passado
		Double tempoBoasAutoItem = FormulasInjet.calcularTempoBoas(
				dwconsol.getSegAutoCicloprodutivo(), 
				dwconsol.getSegAutoTemporefugadas(),
				dwconsol.getSegAutoTempoparadaCpVr(), 
				dwconsol.getSegAutoTempoparadaSpVr()).doubleValue();
		
		Double tempoBoasManuItem = FormulasInjet.calcularTempoBoas(
				dwconsol.getSegManuCicloprodutivo(), 
				dwconsol.getSegManuTemporefugadas(),
				dwconsol.getSegManuTempoparadaCpVr(), 
				dwconsol.getSegManuTempoparadaSpVr()).doubleValue();
		
		//Marcos Sardinha: 2017-06-24 >> tem que considerar o tempo sempre (nao pode descartar se nao houver producao)
		/*
		if (dwconsol.getPcsProducaoBruta() == null || dwconsol.getPcsProducaoBruta().doubleValue() == 0d) {
			tempoBoasAutoItem = 0d;
			tempoBoasManuItem = 0d;
		}
		*/
		
		Double tempoboas = tempoBoasAutoItem + tempoBoasManuItem;
		if (tempoboas < 0)
			tempoboas = 0d;

		// Recalcula tempo trabalhado ritmo. Obtem os dados corretos, caso tenha
		// sido consolidado errado no passado
		//
		Double tempoRitmoAutoItem = FormulasInjet.calcularRitmo(
				dwconsol.getSegAutoCicloprodutivo(),
				dwconsol.getQtAutoCicloprodutivo(), 
				dwconsol.getSegAutoCiclopadrao(),
				dwconsol.getSegAutoTempoparadaCpVr(), 
				dwconsol.getSegAutoTempoparadaSpVr()).doubleValue();

		Double tempoRitmoManuItem = FormulasInjet.calcularRitmo(
				dwconsol.getSegManuCicloprodutivo(),
				dwconsol.getQtManuCicloprodutivo(), 
				dwconsol.getSegAutoCiclopadrao(),
				dwconsol.getSegManuTempoparadaCpVr(), 
				dwconsol.getSegManuTempoparadaSpVr()).doubleValue();

		Double temporitmo = 0d;
		
		//Marcos Sardinha: 2017-06-24 >> tem que considerar o tempo sempre (nao pode descartar se nao houver producao)
		/*
		if (dwconsol.getPcsProducaoBruta() != null && dwconsol.getPcsProducaoBruta().compareTo(BigDecimal.ZERO) > 0) {
			temporitmo += tempoRitmoAutoItem + tempoRitmoManuItem;
		}
		*/
		temporitmo += tempoRitmoAutoItem + tempoRitmoManuItem;
		
		Long prodbruta = 0l;
		if (dwconsol.getPcsProducaoBruta() != null)
			prodbruta = dwconsol.getPcsProducaoBruta().longValue();
		
		producaoBruta = producaoBruta.add(new BigDecimal(prodbruta));
		
		/* Calculo do tempo ativo */
		Double tempoAtivoAutoItem = FormulasInjet.calcularTempoAtivo(
				dwconsol.getSegAutoCicloprodutivo(),
				dwconsol.getSegAutoTempoparadaCp(),
				dwconsol.getSegAutoCicloimprodutivo(),
				dwconsol.getSegAutoTempoparadaCpVr(),
				dwconsol.getSegAutoTempoparadaSpVr()).doubleValue();
		// Tempo manual
		Double tempoAtivoManuItem = FormulasInjet.calcularTempoAtivo(
				dwconsol.getSegManuCicloprodutivo(),
				dwconsol.getSegManuTempoparadaCp(),
				dwconsol.getSegManuCicloimprodutivo(),
				dwconsol.getSegManuTempoparadaCpVr(),
				dwconsol.getSegManuTempoparadaSpVr()).doubleValue();
		
		
		/* Calculo do tempo trabalhado */
		Double tempoTrabalhadoAutoItem = FormulasInjet.calcularTempoTrabalhado(new BigDecimal(tempoAtivoAutoItem), dwconsol.getSegAutoTempoparadaCp()).doubleValue();
		Double tempoTrabalhadoManuItem = FormulasInjet.calcularTempoTrabalhado(new BigDecimal(tempoAtivoManuItem), dwconsol.getSegManuTempoparadaCp()).doubleValue();
		
		//Marcos Sardinha: 2017-06-24 >> tem que considerar o tempo sempre (nao pode descartar se nao houver producao)
		/*
		if (dwconsol.getPcsProducaoBruta() == null || dwconsol.getPcsProducaoBruta().doubleValue() == 0d) {
			tempoTrabalhadoAutoItem = 0d;
			tempoTrabalhadoManuItem = 0d;
		}
		*/
		
		if (tempoTrabalhadoAutoItem < 0)
			tempoTrabalhadoAutoItem = 0d;
		if (tempoTrabalhadoManuItem < 0)
			tempoTrabalhadoManuItem = 0d;


		tempoTrabalhado = new BigDecimal(tempoTrabalhadoAutoItem + tempoTrabalhadoManuItem);
		tempoAtivo = new BigDecimal(tempoAtivoAutoItem + tempoAtivoManuItem);
		tempoProducaoLiquida = new BigDecimal(tempoboas);
		tempoRitmo = new BigDecimal(temporitmo);
		
		//ciclos produtivos
		Double tempoCiclosProdutivosAutoItem = (dwconsol.getSegAutoCicloprodutivo() == null ?  0d : dwconsol.getSegAutoCicloprodutivo().doubleValue());
		Double tempoCiclosProdutivosManuItem = (dwconsol.getSegManuCicloprodutivo() == null ?  0d : dwconsol.getSegManuCicloprodutivo().doubleValue());
		Double qtdCiclosProdutivosAutoItem = (dwconsol.getQtAutoCicloprodutivo() == null ?  0d : dwconsol.getQtAutoCicloprodutivo().doubleValue());
		Double qtdCiclosProdutivosManuItem = (dwconsol.getQtManuCicloprodutivo() == null ?  0d : dwconsol.getQtManuCicloprodutivo().doubleValue());
		Double segCicloPadrao = (dwconsol.getSegAutoCiclopadrao() == null ?  0d : dwconsol.getSegAutoCiclopadrao().doubleValue());
		
		tempoCiclosProdutivos =  new BigDecimal(tempoCiclosProdutivosAutoItem + tempoCiclosProdutivosManuItem);
		qtdCiclosProdutivos =  new BigDecimal(qtdCiclosProdutivosAutoItem + qtdCiclosProdutivosManuItem);
		tempoCicloPadrao =  new BigDecimal(segCicloPadrao);
	}

	/* O tempo produtivo varia conforme o periodo analisa. Por exemplo, considerando a soma de dwconsol.tempoprodutivo
	 * vai dar diferente do que recalcular o tempo para os varios dwconsol. isso pq o ciclo medio sera diferente nos periodos
	 */
	public BigDecimal getSegTempoProdutivo(BigDecimal producaBruta, BigDecimal somaTempoProducaoLiquida, BigDecimal somaTempoRitmo) {
		// Recalcular o tempo produtivas
		Double tempoProdutivoAutoItem = FormulasInjet.calcularTempoprodutivas(
				somaTempoProducaoLiquida, 
				BigDecimal.ZERO, 
				somaTempoRitmo).doubleValue();

		Double tempoprodutivas = tempoProdutivoAutoItem;
		
		//Marcos Sardinha: 2017-06-24 >> tempo produtivas igual a zero qdo menor que zero (pode ocorrer por causa do ritmo)
		//if (producaBruta == null || producaBruta.intValue() <= 0) {
		if (tempoprodutivas.intValue() <= 0) {
			tempoprodutivas = 0d;
		} 

		return new BigDecimal(tempoprodutivas);
	}

	public BigDecimal getTempoProducaoLiquida() {
		return tempoProducaoLiquida;
	}

	public BigDecimal getTempoRitmo() {
		return tempoRitmo;
	}

	public BigDecimal getTempoAtivo() {
		return tempoAtivo;
	}
	
	public BigDecimal getTempoTrabalhado() {
		return tempoTrabalhado;
	}

	public BigDecimal getQtdCiclosProdutivos() {
		return qtdCiclosProdutivos;
	}

	public BigDecimal getTempoCiclosProdutivos() {
		return tempoCiclosProdutivos;
	}

	public BigDecimal getTempoCicloPadrao() {
		return tempoCicloPadrao;
	}

	public void setTempoCicloPadrao(BigDecimal tempoCicloPadrao) {
		this.tempoCicloPadrao = tempoCicloPadrao;
	}
}
