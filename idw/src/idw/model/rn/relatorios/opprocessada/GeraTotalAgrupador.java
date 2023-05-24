package idw.model.rn.relatorios.opprocessada;

import java.math.BigDecimal;

import idw.model.rn.DataHoraRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;

public class GeraTotalAgrupador {

	public void geraTotalAgrupador(ListaRelatorioOPProcessadaDTO retorno) {
		
		for (RelatorioOrdemProducaoProcessadaDTO dto : retorno.getAgrupamento().values()) {
			
			BigDecimal totalProducaoBruta = BigDecimal.ZERO;
			BigDecimal totalProducaoLiquida = BigDecimal.ZERO;
			BigDecimal totalProducaoRefugada = BigDecimal.ZERO;
			BigDecimal totalProducaoBrutaMaisProducaoEmRegulagem = BigDecimal.ZERO; 
			BigDecimal totalProducaoRefugadaMaisProducaoEmRegulagem = BigDecimal.ZERO;
			
			
			Double totalTempoTrabalhado = 0d, totalTempoAtivo = 0d, totalTempoParadaCP = 0d, totalTempoParadaSP = 0d;
			
			for (RelatorioOrdemProducaoProcessadaDetalheDTO detalhe : dto.getDetalhes().values()) {
				
				for (RelatorioOrdemProducaoProcessadaProdutoDTO produto : detalhe.getProdutos()) {
					
					totalProducaoBruta = AritmeticaUtil.somar(totalProducaoBruta, produto.getProducaoBruta());
					totalProducaoLiquida = AritmeticaUtil.somar(totalProducaoLiquida, produto.getProducaoLiquida());
					totalProducaoRefugada = AritmeticaUtil.somar(totalProducaoRefugada, produto.getProducaoRefugada());
					
					totalProducaoBrutaMaisProducaoEmRegulagem = AritmeticaUtil.somar(totalProducaoBrutaMaisProducaoEmRegulagem, produto.getProducaoBrutaEmRegulagem());
					totalProducaoRefugadaMaisProducaoEmRegulagem = AritmeticaUtil.somar(totalProducaoRefugadaMaisProducaoEmRegulagem, produto.getProducaoRefugadaMaiProducaoEmRegulagem());
				}
				
				
				for (RelatorioOrdemProducaoProcessadaParadaDTO parada : detalhe.getParadas()) {
					if (parada.isPesa())
						totalTempoParadaCP += parada.getTempoParada();
					else
						totalTempoParadaSP += parada.getTempoParada();
				}
				
				
				totalTempoAtivo += detalhe.getTempoAtivo();
				totalTempoTrabalhado += detalhe.getTempoTrabalhado();
				
				
				// Limpando referencias das paradas em aberto, visto que nao eh necessario para retornar ao ciente
				detalhe.setPtsComParadaEmAberto(null);
				
			}
			
			dto.setTotalProducaoBruta(totalProducaoBruta);
			dto.setTotalProducaoLiquida(totalProducaoLiquida);
			dto.setTotalProducaoRefugada(totalProducaoRefugada);
			dto.setTotalIndiceRefugo(FormulasInjet.calcularIndiceRefugo(totalProducaoRefugada, totalProducaoBruta).doubleValue());

			dto.setTotalProducaoBrutaMaisProducaoEmRegulagem(totalProducaoBrutaMaisProducaoEmRegulagem);
			dto.setTotalProducaoRefugadaMaisProducaoEmRegulagem(totalProducaoRefugadaMaisProducaoEmRegulagem);
			dto.setTotalIndiceRefugoMaisProducaoEmRegulagem(FormulasInjet.calcularIndiceRefugo(
					totalProducaoRefugadaMaisProducaoEmRegulagem, 
					totalProducaoBrutaMaisProducaoEmRegulagem.add(totalProducaoBruta)).doubleValue());
						
			dto.setTotalTempoTrabalhado(totalTempoTrabalhado);
			dto.setTotalTempoAtivo(totalTempoAtivo);

			dto.setTotalTempoParadaCP(totalTempoParadaCP);
			dto.setTotalTempoParadaSP(totalTempoParadaSP);

			dto.setTotalTempoTrabalhadoFormatado(DataHoraRN.formatSegundosParaHHMMSSmmm(dto.getTotalTempoTrabalhado().doubleValue()));
			dto.setTotalTempoAtivoFormatado(DataHoraRN.formatSegundosParaHHMMSSmmm(dto.getTotalTempoAtivo().doubleValue()));
			dto.setTotalTempoParadaCPFormatado(DataHoraRN.formatSegundosParaHHMMSSmmm(dto.getTotalTempoParadaCP().doubleValue()));
			dto.setTotalTempoParadaSPFormatado(DataHoraRN.formatSegundosParaHHMMSSmmm(dto.getTotalTempoParadaSP().doubleValue()));
		}
		
	}
}
