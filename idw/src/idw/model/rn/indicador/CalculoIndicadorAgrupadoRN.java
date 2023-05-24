package idw.model.rn.indicador;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.template.DwRtTemplate;
import idw.model.pojos.template.OmIndTemplate;
import idw.model.pojos.template.OmIndTemplate.Tipo;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;

public final class CalculoIndicadorAgrupadoRN {

	
	public static Map<OmIndTemplate.Tipo, BigDecimal> calcularIndicadores(List<DwConsolid> listaDwConsolid, int numQtdItens){
		
		Map<OmIndTemplate.Tipo, BigDecimal> indicadores = inicializarMapTodosIndicadores();
		
		agruparIndicadores(listaDwConsolid, indicadores, numQtdItens);
		calcularIndicadoresAcumulados(indicadores);
			
		return indicadores;
	}
	
	
	private static void agruparIndicadores(List<DwConsolid> listaDwConsolid, Map<OmIndTemplate.Tipo, BigDecimal> indicadores, int numQtdItens){

		Map<String, BigDecimal> mapMaquinas = new HashMap<String, BigDecimal>();
		Map<String, BigDecimal> mapMaquinasSemPlanejamento = new HashMap<String, BigDecimal>();
		Map<String, BigDecimal> mapMaquinasParadasComPeso = new HashMap<String, BigDecimal>();
		Map<String, BigDecimal> mapMaquinasParadasSemPeso = new HashMap<String, BigDecimal>();
		
		
		for(DwConsolid dwConsolid: listaDwConsolid)
		{
			if (dwConsolid.getDwConsols().size() > 0) 
			{
				DwConsol dwConsol = dwConsolid.getDwConsols().iterator().next();
				
				somarIndicador(indicadores, Tipo.TEMPO_CICLO_PRODUTIVO, dwConsol.getSegAutoCicloprodutivo());
				somarIndicador(indicadores, Tipo.TEMPO_CICLO_IMPRODUTIVO, dwConsol.getSegAutoCicloimprodutivo());
				somarIndicador(indicadores, Tipo.TEMPO_PARADA_COM_PESO, dwConsol.getSegAutoTempoparadaCp());			
				somarIndicador(indicadores, Tipo.TEMPO_PARADA_COM_PESO_VAR_RITMO, dwConsol.getSegAutoTempoparadaCpVr());
				somarIndicador(indicadores, Tipo.TEMPO_PARADA_SEM_PESO_VAR_RITMO, dwConsol.getSegAutoTempoparadaSpVr());
				somarIndicador(indicadores, Tipo.PCS_REFUGADAS, dwConsol.getPcsProducaoRefugada());
				somarIndicador(indicadores, Tipo.PCS_PRODUCAO_BRUTA, dwConsol.getPcsProducaoBruta());
				somarIndicador(indicadores, Tipo.QT_CICLOS_PRODUTIVOS, dwConsol.getQtAutoCicloprodutivo());
				
				somarIndicador(indicadores, Tipo.QT_CICLOS_PREVISTOS, (dwConsol.getQtAutoCicloPrevisto() == null ? BigDecimal.ZERO: dwConsol.getQtAutoCicloPrevisto()));
				somarIndicador(indicadores, Tipo.TEMPO_TRABALHADAS, (dwConsol.getSegAutoTempotrabalhado() == null ? BigDecimal.ZERO : dwConsol.getSegAutoTempotrabalhado()) );
				BigDecimal tempoAtivo = BigDecimal.ZERO;
				BigDecimal tempoProdutivo = BigDecimal.ZERO;
				BigDecimal tempoTotal = BigDecimal.ZERO;
				BigDecimal tempoCicloMedio = BigDecimal.ZERO;
				
				try {
					// Alessandre: em 15-9-14 a captura do tempo ativo abaixo foi modificada para pegar o tempoAtivo  direto importado do Injet
					// Entretanto rever para o Insert etc se o tempo ativo nao for suficiente
					//tempoAtivo = FormulasInjet.calcularTempoAtivo(dwConsol.getSegAutoCicloprodutivo(), dwConsol.getSegAutoTempoparadaCp(), dwConsol.getSegAutoCicloimprodutivo(), dwConsol.getSegAutoTempoparadaCpVr(), dwConsol.getSegAutoTempoparadaSpVr());
					tempoAtivo = dwConsol.getSegAutoTempoativo();
				} catch (Exception e) {}
				
				try {
					tempoTotal = dwConsol.getSegAutoTempocalendario();
					// Alessandre: em 15-9-14 para o Injet comentei a linha abaixo e usar a de cima
					//tempoTotal = new BigDecimal(FormulasInjet.calcularTempoTotal(dwConsol.getSegAutoTempoparadaSp(), tempoAtivo));			
				} catch (Exception e) {}
				
				try {
					tempoProdutivo = dwConsol.getSegAutoTempoprodutivo();
				} catch (Exception e) {}
				
				
				try {
					tempoCicloMedio = FormulasInjet.calcularCicloMedio(dwConsol.getSegAutoCicloprodutivo(), dwConsol.getQtAutoCicloprodutivo());
				} catch (Exception e) {}
				
				
				somarIndicador(indicadores, Tipo.TEMPO_ATIVO, tempoAtivo);
				somarIndicador(indicadores, Tipo.TEMPO_TOTAL, tempoTotal);
				somarIndicador(indicadores, Tipo.TEMPO_CICLO_MEDIO, tempoCicloMedio);
				somarIndicador(indicadores, Tipo.TEMPO_REFUGADO, (dwConsol.getSegAutoTemporefugadas() == null ? BigDecimal.ZERO :  dwConsol.getSegAutoTemporefugadas()));
				somarIndicador(indicadores, Tipo.TEMPO_PRODUTIVO, tempoProdutivo);
		
			}
				
			//maps para controle da qtd de máquinas
			if (mapMaquinas.containsKey(dwConsolid.getOmPt().getCdPt()) == false)
			{
				mapMaquinas.put(dwConsolid.getOmPt().getCdPt(),  BigDecimal.ZERO);
				mapMaquinasParadasComPeso.put(dwConsolid.getOmPt().getCdPt(), BigDecimal.ZERO);
				mapMaquinasParadasSemPeso.put(dwConsolid.getOmPt().getCdPt(), BigDecimal.ZERO);
				mapMaquinasSemPlanejamento.put(dwConsolid.getOmPt().getCdPt(), BigDecimal.ZERO);
				
			}
			
			if (	(mapMaquinas.get(dwConsolid.getOmPt().getCdPt()).compareTo(new BigDecimal(dwConsolid.getIdConsolid())) < 0) ||
					(mapMaquinas.get(dwConsolid.getOmPt().getCdPt()).compareTo(BigDecimal.ZERO) == 0)
				)
			{
				mapMaquinas.put(dwConsolid.getOmPt().getCdPt(), new BigDecimal(dwConsolid.getIdConsolid()));
				mapMaquinasSemPlanejamento.put(dwConsolid.getOmPt().getCdPt(), dwConsolid.getDwRt().getIsSemplanejamento() == true ? BigDecimal.ONE: BigDecimal.ZERO);
				if (dwConsolid.getDwRt().getStFuncionamento() == DwRtTemplate.StFuncionamento.PARADA.getId())
				{
					mapMaquinasParadasComPeso.put(dwConsolid.getOmPt().getCdPt(), dwConsolid.getDwRt().getIsParadapeso() == true ? BigDecimal.ONE: BigDecimal.ZERO);
					mapMaquinasParadasSemPeso.put(dwConsolid.getOmPt().getCdPt(), dwConsolid.getDwRt().getIsParadapeso() == true ? BigDecimal.ZERO: BigDecimal.ONE);						
				}
				else
				{
					mapMaquinasParadasComPeso.put(dwConsolid.getOmPt().getCdPt(), BigDecimal.ZERO);
					mapMaquinasParadasSemPeso.put(dwConsolid.getOmPt().getCdPt(), BigDecimal.ZERO);					
				}
			}
		}
		

		// varrer maps de qtd para atualizar status e contar máquinas
		atualizarStatus(indicadores, Tipo.TOTAL_MAQUINAS, new BigDecimal(numQtdItens));
		
		for (String key : mapMaquinas.keySet())
		{
			if (mapMaquinasParadasComPeso.get(key).compareTo(BigDecimal.ONE) == 0)
			{
				somarIndicador(indicadores, Tipo.TOTAL_MAQ_PAR_COM_PESO, BigDecimal.ONE);
				atualizarStatus(indicadores, Tipo.STATUS_PARADA_COM_PESO, BigDecimal.ONE);
			}
			else
			{
				atualizarStatus(indicadores, Tipo.STATUS_PARADA_COM_PESO, BigDecimal.ZERO);
			}
			
			if (mapMaquinasParadasSemPeso.get(key).compareTo(BigDecimal.ONE) == 0)
			{
				somarIndicador(indicadores, Tipo.TOTAL_MAQ_PAR_SEM_PESO, BigDecimal.ONE);
				atualizarStatus(indicadores, Tipo.STATUS_PARADA_SEM_PESO, BigDecimal.ONE);
			}
			else
			{
				atualizarStatus(indicadores, Tipo.STATUS_PARADA_SEM_PESO, BigDecimal.ZERO);
			}	
			
			// cliente Termotecnica solicitou que maq sem planejamento fosse tratada como parada sem peso
			if ( 
					(mapMaquinasSemPlanejamento.get(key).compareTo(BigDecimal.ONE) == 0) && 
					(mapMaquinasParadasComPeso.get(key).compareTo(BigDecimal.ONE) != 0) && 
					(mapMaquinasParadasSemPeso.get(key).compareTo(BigDecimal.ONE) != 0)
			    )					
			{
				somarIndicador(indicadores, Tipo.TOTAL_MAQ_PAR_SEM_PESO, BigDecimal.ONE);
				atualizarStatus(indicadores, Tipo.STATUS_PARADA_SEM_PESO, BigDecimal.ONE);
			}
		}
		
	}
	
	private static void calcularIndicadoresAcumulados(Map<OmIndTemplate.Tipo, BigDecimal> indicadores){
		
		BigDecimal tempoCicloProdutivo = indicadores.get(Tipo.TEMPO_CICLO_PRODUTIVO);
		BigDecimal tempoParadaComPesoVariacaoRitmo = indicadores.get(Tipo.TEMPO_PARADA_COM_PESO_VAR_RITMO);
		BigDecimal tempoParadaSemPesoVariacaoRitmo = indicadores.get(Tipo.TEMPO_PARADA_SEM_PESO_VAR_RITMO);
		BigDecimal tempoRefugado = indicadores.get(Tipo.TEMPO_REFUGADO);
		BigDecimal tempoAtivo = indicadores.get(Tipo.TEMPO_ATIVO);
		BigDecimal tempoTotal = indicadores.get(Tipo.TEMPO_TOTAL);
		BigDecimal pcsProducaoBruta = indicadores.get(Tipo.PCS_PRODUCAO_BRUTA);
		BigDecimal pcsProducaoRefugada = indicadores.get(Tipo.PCS_REFUGADAS);
		BigDecimal tempoTrabalhadas = indicadores.get(Tipo.TEMPO_TRABALHADAS);
	
		
		BigDecimal indiceRefugo = new BigDecimal(FormulasInjet.calcularIndiceRefugo(pcsProducaoRefugada, pcsProducaoBruta));
		indicadores.put(Tipo.INDICE_REFUGO, indiceRefugo);
				
		BigDecimal tempoBoas = FormulasInjet.calcularTempoBoas(tempoCicloProdutivo, tempoRefugado, tempoParadaComPesoVariacaoRitmo, tempoParadaSemPesoVariacaoRitmo);
		indicadores.put(Tipo.TEMPO_BOAS, tempoBoas);

		// Alessandre: em 15-9-14 comentei o tempoProdutivo como calculado para utilizar o seg_auto_tempodisponivel gravado pela importacao
		// via injet
		BigDecimal tempoProdutivo = indicadores.get(Tipo.TEMPO_PRODUTIVO);
		
		indicadores.put(Tipo.TEMPO_PRODUTIVO, tempoProdutivo);
				
		BigDecimal oee = new BigDecimal(FormulasInjet.calcularOEE(tempoProdutivo, tempoAtivo));
		indicadores.put(Tipo.OEE, oee);

		BigDecimal oeeCapital = new BigDecimal(FormulasInjet.calcularOEECapital(tempoProdutivo, tempoTotal));
		indicadores.put(Tipo.OEE_CAPITAL, oeeCapital);		
		indicadores.put(Tipo.PRODUTIVIDADE, oeeCapital);
		
		BigDecimal qualidade = BigDecimal.ZERO;
		if (pcsProducaoBruta.doubleValue() != 0d)
		{
			// só calcula qualidade se teve produ��oo
			qualidade = new BigDecimal(100).subtract(indicadores.get(Tipo.INDICE_REFUGO));
		}
		indicadores.put(Tipo.QUALIDADE, qualidade);
		
		BigDecimal qtdCiclosPrevistos = (indicadores.get(Tipo.QT_CICLOS_PREVISTOS) == null ? BigDecimal.ZERO : indicadores.get(Tipo.QT_CICLOS_PREVISTOS));
		BigDecimal qtdCiclosProdutivos = (indicadores.get(Tipo.QT_CICLOS_PRODUTIVOS) == null ? BigDecimal.ZERO : indicadores.get(Tipo.QT_CICLOS_PRODUTIVOS));
		BigDecimal ritmoPerc = FormulasInjet.calcularRitmoPercentual(qtdCiclosProdutivos, qtdCiclosPrevistos);
		
		indicadores.put(Tipo.RITMO_PERC, ritmoPerc);
		
		// Marcos Sardinha: 2015-03-24
		BigDecimal disponibilidade = FormulasInjet.calcularIndiceDisponibilidade(tempoTrabalhadas, tempoAtivo);
		indicadores.put(Tipo.DISPONIBILIDADE, disponibilidade);
		
	}
	
	private static Map<OmIndTemplate.Tipo, BigDecimal> inicializarMapTodosIndicadores(){
		Map<OmIndTemplate.Tipo, BigDecimal> indicadores = new HashMap<OmIndTemplate.Tipo, BigDecimal>();
		
		for(OmIndTemplate.Tipo tipo: OmIndTemplate.Tipo.values()){
			indicadores.put(tipo, BigDecimal.ZERO);			
		}
		
		return indicadores;
		
	}
	
	private static void somarIndicador(Map<OmIndTemplate.Tipo, BigDecimal> indicadores, OmIndTemplate.Tipo tipo, BigDecimal valor){
		BigDecimal indicador = indicadores.get(tipo);
		indicador = AritmeticaUtil.somar(indicador, valor);
		indicadores.put(tipo, indicador);
	}

	private static void atualizarStatus(Map<OmIndTemplate.Tipo, BigDecimal> indicadores, OmIndTemplate.Tipo tipo, BigDecimal situacao){
		indicadores.put(tipo, situacao);
	}
	
}
