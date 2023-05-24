package idw.relatorio.analiseproducaoeficiencia;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;

import idw.model.pojos.DwFolha;
import idw.model.pojos.OmPt;
import idw.model.rn.DataHoraRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;

final class TrataIndicadores {
	private final Cache cache;

	TrataIndicadores(Cache cache) {
		this.cache = cache;
	}

	void acumulaRelatorioProduto(AnaliseProducaoEficienciaHoraAHoraDTO relProd, String cdProduto,
			AnaliseProducaoEficienciaHoraAHoraDetalheDTO hrDetalheResumo, DwFolha dwFolha, BigDecimal cavidadesAtivas,
			BigDecimal cavidadesTotais) {

		relProd.setTotalProducaoBruta(relProd.getTotalProducaoBruta() + hrDetalheResumo.getProducaoBruta());
		relProd.setTotalProducaoLiquida(relProd.getTotalProducaoLiquida() + hrDetalheResumo.getProducaoLiquida());
		relProd.setTotalProducaoRefugada(relProd.getTotalProducaoRefugada() + hrDetalheResumo.getProducaoRefugada());
		relProd.setTotalProducaoPrevista(relProd.getTotalProducaoPrevista() + hrDetalheResumo.getProducaoPrevista());
		relProd.setTotalTempoAtivo(relProd.getTotalTempoAtivo() + hrDetalheResumo.getTempoAtivo());
		relProd.setTotalTempoAtivoFormatado(DataHoraRN.formatSegundosParaHHMMSS(relProd.getTotalTempoAtivo().intValue()));
		relProd.setTotalTempoParadaCP(relProd.getTotalTempoParadaCP() + hrDetalheResumo.getTempoTotalParadasCP());
		relProd.setTotalTempoParadaCPFormatado(
				DataHoraRN.formatSegundosParaHHMMSS(relProd.getTotalTempoParadaCP().intValue()));

		acumulaRelatorioProdutoCavidades(relProd, cdProduto, dwFolha, cavidadesAtivas, cavidadesTotais);

	}

	private void acumulaRelatorioProdutoCavidades(AnaliseProducaoEficienciaHoraAHoraDTO relProd, String cdProduto, DwFolha dwFolha,
			BigDecimal cavidadesAtivas, BigDecimal cavidadesTotais) {

		if (cache.addFolha(cdProduto, dwFolha)) {
			relProd.setTotalCavidadesAtivas(relProd.getTotalCavidadesAtivas() + cavidadesAtivas.doubleValue());
			relProd.setTotalCavidadesTotais(relProd.getTotalCavidadesTotais() + cavidadesTotais.doubleValue());
		}
	}

	void setIndicadoresTodosDetalhesDaHora(final AnaliseProducaoEficienciaHoraAHoraDetalheDTO horaDetalheResumo,
			List<AnaliseProducaoEficienciaHoraAHoraDetalheDTO> horaDetalhes) {
		for (AnaliseProducaoEficienciaHoraAHoraDetalheDTO horaDetalhe : horaDetalhes) {
			horaDetalhe.setIndicadores(horaDetalheResumo);
		}
	}

	void setIndicadores(
			Double multiplicador, 
			ProducaoHora prodHr, 
			BigDecimal cavidadesAtivas, 
			BigDecimal cavidadesTotais,
			final AnaliseProducaoEficienciaHoraAHoraDetalheDTO dto,
			BigDecimal fatorContagem,
			OmPt ompt) {
		
		final BigDecimal pcsProducaoLiquida = AritmeticaUtil.multiplicar(prodHr.getPcsProducaoLiquida(), multiplicador);
		final BigDecimal pcsProducaoBruta = AritmeticaUtil.multiplicar(prodHr.getPcsProducaoBruta(), multiplicador);
		final BigDecimal pcsProducaoRefugada = AritmeticaUtil.multiplicar(prodHr.getPcsProducaoRefugada(), multiplicador);
		final BigDecimal totalTempoParadaComPeso = ObjectUtils.defaultIfNull(prodHr.getSegAutoTempoparadaCp(), BigDecimal.ZERO);
		final String totalTempoParadasComPesoFormatado = DataHoraRN.formatSegundosParaHHMMSS(totalTempoParadaComPeso.intValue());
		final BigDecimal totalTempoAtivoNoPeriodo = ObjectUtils.defaultIfNull(prodHr.getSegAutoTempoAtivo(), BigDecimal.ZERO);
		final String totalTempoAtivoNoPeriodoFormatado = DataHoraRN.formatSegundosParaHHMMSS(totalTempoAtivoNoPeriodo.intValue());
		final BigDecimal totalProducaoPrevistaPeriodoPorProduto = AritmeticaUtil.multiplicar(FormulasInjet.calcularProducaoPrevista(totalTempoAtivoNoPeriodo, prodHr.getSegAutoCicloPadrao(), cavidadesAtivas, fatorContagem, ompt.getIndOee()), multiplicador);
		final BigDecimal indiceEficienciaRealizacao = new BigDecimal(FormulasInjet.calcularEficienciaRealizacao(pcsProducaoLiquida, totalProducaoPrevistaPeriodoPorProduto));
		final BigDecimal indiceRefugo = new BigDecimal(FormulasInjet.calcularIndiceRefugo(pcsProducaoRefugada, pcsProducaoBruta));
		final BigDecimal indiceMAtivas = new BigDecimal(FormulasInjet.calcularIndiceCavidades(cavidadesAtivas, cavidadesTotais));
		final BigDecimal segAutoCiclomedio = FormulasInjet.calcularCicloMedio(prodHr.getSegAutoCicloprodutivo(), prodHr.getQtAutoCicloprodutivo());
		final BigDecimal segAutoCiclopadrao = ObjectUtils.defaultIfNull(prodHr.getSegAutoCicloPadrao(), BigDecimal.ZERO);
		final double metaHoraSM = (FormulasInjet.calcularMetaHora(prodHr.getSegAutoCicloPadrao(), cavidadesAtivas.longValue(), ompt.getIndOee()));
		final double metaHora = AritmeticaUtil.multiplicar((long)metaHoraSM, multiplicador);

		dto.setTempoTotalParadasCP(totalTempoParadaComPeso.doubleValue());
		dto.setTempoTotalParadasCPFormatado(totalTempoParadasComPesoFormatado);
		dto.setTempoAtivo(totalTempoAtivoNoPeriodo.doubleValue());
		dto.setTempoAtivoFormatado(totalTempoAtivoNoPeriodoFormatado);
		dto.setIndiceParada(FormulasInjet.calcularIndiceParada(totalTempoParadaComPeso, totalTempoAtivoNoPeriodo).floatValue());
		dto.setIndiceEficienciaRealizacao(indiceEficienciaRealizacao.floatValue());
		dto.setIndiceRefugo(indiceRefugo.floatValue());
		dto.setIndiceMAtivas(indiceMAtivas.doubleValue());
		dto.setProducaoBruta(pcsProducaoBruta.doubleValue());
		dto.setProducaoLiquida(pcsProducaoLiquida.doubleValue());
		dto.setProducaoPrevista(totalProducaoPrevistaPeriodoPorProduto.doubleValue());
		dto.setProducaoRefugada(pcsProducaoRefugada.doubleValue());
		dto.setMetaHora(metaHora);
		dto.setCicloMedio(segAutoCiclomedio.doubleValue());
		dto.setCicloPadrao(segAutoCiclopadrao.doubleValue());
	}

	void calculaIndicadoresProduto(AnaliseProducaoEficienciaHoraAHoraDTO relProd) {
		relProd.setTotalIndiceEficienciaRealizacao(FormulasInjet.calcularEficienciaRealizacao(
				new BigDecimal(relProd.getTotalProducaoLiquida()), new BigDecimal(relProd.getTotalProducaoPrevista())).floatValue());
		relProd.setTotalIndiceMAtivas(FormulasInjet.calcularIndiceCavidades(
				new BigDecimal(relProd.getTotalCavidadesAtivas()), new BigDecimal(relProd.getTotalCavidadesTotais())));
		relProd.setTotalIndiceParadas(FormulasInjet.calcularIndiceParada(new BigDecimal(relProd.getTotalTempoParadaCP()),
				new BigDecimal(relProd.getTotalTempoAtivo())).floatValue());
		relProd.setTotalIndiceRefugo(FormulasInjet.calcularIndiceRefugo(
				new BigDecimal(relProd.getTotalProducaoRefugada()), new BigDecimal(relProd.getTotalProducaoBruta())));
	}
}
