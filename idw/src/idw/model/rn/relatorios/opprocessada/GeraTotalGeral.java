package idw.model.rn.relatorios.opprocessada;

import java.math.BigDecimal;

import idw.model.rn.DataHoraRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;

public class GeraTotalGeral {
	
	public void geraTotalGeral(ListaRelatorioOPProcessadaDTO retorno) {
		
		BigDecimal totalGeralProducaoBruta = BigDecimal.ZERO;
		BigDecimal totalGeralProducaoRefugada = BigDecimal.ZERO;
		BigDecimal totalGeralProducaoLiquida = BigDecimal.ZERO;
		BigDecimal totalGeralProducaoBrutaMaisProducaoEmRegulagem = BigDecimal.ZERO;
		BigDecimal totalGeralProducaoRefugadaMaisProducaoEmRegulagemGeral = BigDecimal.ZERO;
		
		Double totalGeralTempoAtivo = 0d, totalGeralTempoParadaCP = 0d, totalGeralTempoParadaSP =0d, totalGeralTempoTrabalhado = 0d;
		
		for (RelatorioOrdemProducaoProcessadaDTO dto : retorno.getAgrupamento().values()) {
			totalGeralProducaoBruta = AritmeticaUtil.somar(totalGeralProducaoBruta, dto.getTotalProducaoBruta());
			totalGeralProducaoRefugada = AritmeticaUtil.somar(totalGeralProducaoRefugada, dto.getTotalProducaoRefugada());
			totalGeralProducaoLiquida = AritmeticaUtil.somar(totalGeralProducaoLiquida, dto.getTotalProducaoLiquida());
			
			totalGeralProducaoBrutaMaisProducaoEmRegulagem = AritmeticaUtil.somar(totalGeralProducaoBrutaMaisProducaoEmRegulagem, dto.getTotalProducaoBrutaMaisProducaoEmRegulagem());
			totalGeralProducaoRefugadaMaisProducaoEmRegulagemGeral = AritmeticaUtil.somar(totalGeralProducaoRefugadaMaisProducaoEmRegulagemGeral, dto.getTotalProducaoRefugadaMaisProducaoEmRegulagem());
			
			totalGeralTempoAtivo += dto.getTotalTempoAtivo();
			totalGeralTempoTrabalhado += dto.getTotalTempoTrabalhado();
			
			totalGeralTempoParadaCP += dto.getTotalTempoParadaCP();
			totalGeralTempoParadaSP += dto.getTotalTempoParadaSP();
		}
		
		retorno.setTotalGeralProducaoBruta(totalGeralProducaoBruta);
		retorno.setTotalGeralProducaoRefugada(totalGeralProducaoRefugada);
		retorno.setTotalGeralProducaoLiquida(totalGeralProducaoLiquida);
		retorno.setTotalGeralIndiceRefugo(FormulasInjet.calcularIndiceRefugo(totalGeralProducaoRefugada, totalGeralProducaoBruta).doubleValue());

		retorno.setTotalGeralProducaoBrutaMaisProducaoEmRegulagem(totalGeralProducaoBrutaMaisProducaoEmRegulagem);
		retorno.setTotalGeralProducaoRefugadaMaisProducaoEmRegulagem(totalGeralProducaoRefugadaMaisProducaoEmRegulagemGeral);
		retorno.setTotalGeralIndiceRefugoMaisProducaoEmRegulagem(FormulasInjet.calcularIndiceRefugo(
				totalGeralProducaoRefugadaMaisProducaoEmRegulagemGeral, 
				totalGeralProducaoBrutaMaisProducaoEmRegulagem.add(totalGeralProducaoBruta)).doubleValue());

		retorno.setTotalGeralTempoAtivo(totalGeralTempoAtivo);
		retorno.setTotalGeralTempoParadaCP(totalGeralTempoParadaCP);
		retorno.setTotalGeralTempoParadaSP(totalGeralTempoParadaSP);
		retorno.setTotalGeralTempoTrabalhado(totalGeralTempoTrabalhado);

		retorno.setTotalGeralTempoTrabalhadoFormatado(DataHoraRN.formatSegundosParaHHMMSSmmm(retorno.getTotalGeralTempoTrabalhado().doubleValue()));
		retorno.setTotalGeralTempoAtivoFormatado(DataHoraRN.formatSegundosParaHHMMSSmmm(retorno.getTotalGeralTempoAtivo().doubleValue()));
		retorno.setTotalGeralTempoParadaCPFormatado(DataHoraRN.formatSegundosParaHHMMSSmmm(retorno.getTotalGeralTempoParadaCP().doubleValue()));
		retorno.setTotalGeralTempoParadaSPFormatado(DataHoraRN.formatSegundosParaHHMMSSmmm(retorno.getTotalGeralTempoParadaSP().doubleValue()));

	}

}
