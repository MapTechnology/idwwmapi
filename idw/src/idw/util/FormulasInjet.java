package idw.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import idw.model.IdwFacade;
import idw.webservices.dto.CapabilidadeProcessoDTO;

public class FormulasInjet {

	public static Float formatarCasaDecimalDoFloat(Float valor){
		DecimalFormat df  = new DecimalFormat("####.##");
		String retorno = df.format(valor);
		retorno = retorno.replaceAll(",", ".");
		return Float.parseFloat(retorno);
	}

	public static Float formatarCasaDecimalDoFloat(Float valor, Integer casasDecimais){
		String formatacaoDecimais = "####." + StringUtils.rightPad("", casasDecimais, "#");
		DecimalFormat df  = new DecimalFormat(formatacaoDecimais);
		String retorno = df.format(valor);
		retorno = retorno.replaceAll(",", ".");
		return Float.parseFloat(retorno);
	}
	
	public static Double calcularIndiceParada(BigDecimal tempoParadasComPeso, BigDecimal tempoAtivo){
		Double retorno = 0d;

		if (tempoParadasComPeso == null || tempoAtivo == null){
			return retorno;
		}

		if (tempoAtivo.doubleValue() > 0){
			retorno = tempoParadasComPeso.doubleValue();
			retorno = retorno / tempoAtivo.doubleValue();
			retorno = retorno * 100;
		}
		return retorno;
	}
		//Consolidados Kg e toneladas.
		public static double calcularDadosPeso(Double valor, String tipoPeso){

		Double calculo = 0.0D;

		if(tipoPeso.equals("pliquido") && valor != 0.0){
			calculo = (valor / 1000);
		}else if(tipoPeso.equals("pbruto") && valor != 0.0){
			calculo = (valor / 1000000);
		}
		if (tipoPeso.equals("kg") && valor != 0.0){
			calculo = (valor / 1000);
		}else if (tipoPeso.equals("ton") && valor != 0.0){
			calculo = (valor /1000000);
		}else{
			calculo = valor;
		}
		return calculo;
	}
	public static Float calcularIndiceProducaoDaOP(BigDecimal producaoLiquidaOP, BigDecimal producaoPlanejadaOP){
		Float retorno = 0f;
		if (producaoLiquidaOP != null && producaoPlanejadaOP != null && producaoPlanejadaOP.floatValue() > 0){
			retorno = producaoLiquidaOP.floatValue();
			retorno = retorno / producaoPlanejadaOP.floatValue();
			retorno = retorno * 100;
		}
		return formatarCasaDecimalDoFloat(retorno);
	}

	public static Float calcularIndiceRefugo(BigDecimal producaoRefugada, BigDecimal producaoBruta){
		return calcularIndiceRefugo((producaoRefugada != null ? producaoRefugada.longValue(): null),(producaoBruta != null ? producaoBruta.longValue(): null));
	}
	public static Float calcularIndiceRefugo(Double producaoRefugada, Double producaoBruta){
		return calcularIndiceRefugo((producaoRefugada != null ? producaoRefugada.longValue(): null),(producaoBruta != null ? producaoBruta.longValue(): null));
	}

	public static Float calcularIndiceQualidadePeloRefugo(Float indiceRefugo){
		return 100 - indiceRefugo;
	}

	// Marcos Sardinha: 2015-03-24
	public static BigDecimal calcularIndiceQualidade(BigDecimal tempoBoas, BigDecimal tempoCicloProdutivo){
		tempoBoas = ObjectUtils.defaultIfNull(tempoBoas, BigDecimal.ZERO);
		tempoCicloProdutivo = ObjectUtils.defaultIfNull(tempoCicloProdutivo, BigDecimal.ZERO);
		if(CompareUtils.equals(tempoBoas, BigDecimal.ZERO)|| CompareUtils.equals(tempoCicloProdutivo, BigDecimal.ZERO)){
			return BigDecimal.ZERO;
		}else{
			return tempoBoas.divide(tempoCicloProdutivo, MathContext.DECIMAL32).multiply(new BigDecimal(100));
		}
	}

	// Marcos Sardinha: 2015-03-24
	public static BigDecimal calcularIndiceDisponibilidade(BigDecimal tempoTrabalhadas, BigDecimal tempoDisponivel){
		tempoTrabalhadas = ObjectUtils.defaultIfNull(tempoTrabalhadas, BigDecimal.ZERO);
		tempoDisponivel = ObjectUtils.defaultIfNull(tempoDisponivel, BigDecimal.ZERO);
		if(CompareUtils.equals(tempoTrabalhadas, BigDecimal.ZERO)|| CompareUtils.equals(tempoDisponivel, BigDecimal.ZERO)){
			return BigDecimal.ZERO;
		}else{
			return tempoTrabalhadas.divide(tempoDisponivel, MathContext.DECIMAL32).multiply(new BigDecimal(100));
		}
	}


	public static Float calcularIndiceRefugo(Long producaoRefugada, Long producaoBruta){
		Float retorno = 0f;

		if(producaoRefugada == null || producaoBruta == null){
			return retorno;
		}

		if (producaoBruta.floatValue() > 0){
			retorno = producaoRefugada.floatValue();
			retorno = retorno / producaoBruta.floatValue();
			retorno = retorno * 100;
		}
		return formatarCasaDecimalDoFloat(retorno);
	}

	public static Double calcularEficienciaRealizacao(BigDecimal producaoLiquida, BigDecimal producaoPrevista){
		return calcularEficienciaRealizacao((producaoLiquida != null ? producaoLiquida.doubleValue(): null),
				(producaoPrevista != null ? producaoPrevista.doubleValue(): null));
	}

	public static Double calcularEficienciaRealizacao(Double producaoLiquida, Double producaoPrevista){
		Double retorno = 0d;

		if (producaoLiquida == null || producaoPrevista == null){
			return retorno;
		}

		if (producaoPrevista > 0d){
			retorno = producaoLiquida;
			retorno = retorno / producaoPrevista;
			retorno = retorno * 100;
		}

		return retorno;
	}

	/**
	 * Calculo da efici�ncia instant�nea, que corresponde ao calculo de efici�ncia do �ltimo ciclo
	 * @param cicloPadrao
	 * @param ultimoCiclo
	 * @see FormulasInjet#calcularEficienciaCiclo(BigDecimal, BigDecimal)
	 * @return
	 */
	public static Float calcularEficienciaInstantanea(BigDecimal cicloPadrao, BigDecimal ultimoCiclo){
		return calcularEficienciaCiclo(cicloPadrao, ultimoCiclo);
	}

	public static Float calcularEficienciaCiclo(BigDecimal cicloPadrao, BigDecimal ciclo){
		Float retorno = 0f;

		if (cicloPadrao == null || ciclo == null) {
			return retorno;
		}

		if (ciclo.floatValue() > 0 && cicloPadrao.floatValue() > 0){
			retorno = cicloPadrao.floatValue();
			retorno = retorno / ciclo.floatValue();
			retorno = retorno * 100;
		}
		return formatarCasaDecimalDoFloat(retorno);
	}

	public static Float calcularIndicePerda(Long perdaCiclo, Long perdaParada,
			Long producaoRefugada, Long perdaCavidades,
			Long producaoPrevista){

		Float retorno = calcularTotalPerdas(perdaCiclo, perdaParada, producaoRefugada, perdaCavidades);
		if (producaoPrevista.floatValue() > 0){
			retorno = retorno / producaoPrevista.floatValue();
			retorno = retorno * 100;
		} else {
			retorno = 0f;
		}
		return formatarCasaDecimalDoFloat(retorno);

	}

	public static Float calcularIndicePerda(Double perdaCiclo, Double perdaParada,
			Double producaoRefugada, Double perdaCavidades,
			Double producaoPrevista){

		Float retorno = new Float(calcularTotalPerdas(perdaCiclo, perdaParada, producaoRefugada, perdaCavidades));
		if (producaoPrevista.floatValue() > 0){
			retorno = retorno / producaoPrevista.floatValue();
			retorno = retorno * 100;
		} else {
			retorno = 0f;
		}
		return formatarCasaDecimalDoFloat(retorno);

	}


	/**
	 * Meta hora = 3600 / ciclo padr�o * cavidades ativas
	 * @param cicloPadrao
	 * @param cavAtivas
	 * @return
	 */
	public static Float calcularMetaHora(BigDecimal cicloPadrao, Long cavAtivas, BigDecimal indiceCapacidade){
		Float retorno = 0f;
		if(cicloPadrao != null && !cicloPadrao.equals(0f) && cavAtivas != null && !cavAtivas.equals(0L)){
			retorno = 3600 / cicloPadrao.floatValue() * cavAtivas;
			if (indiceCapacidade != null && indiceCapacidade.compareTo(BigDecimal.ZERO) > 0)
				retorno = retorno * (indiceCapacidade.divide(new BigDecimal(100))).floatValue();
		}
		return formatarCasaDecimalDoFloat(retorno);
	}

	public static Float calcularMetaHora(BigDecimal cicloPadrao, BigDecimal cavAtivas){
		BigDecimal retorno = BigDecimal.ZERO;
		if(cicloPadrao != null && !cicloPadrao.equals(BigDecimal.ZERO) && cavAtivas != null && !cavAtivas.equals(BigDecimal.ZERO)){
			retorno = AritmeticaUtil.dividir(new BigDecimal(3600), cicloPadrao);
			retorno = AritmeticaUtil.multiplicar(retorno, cavAtivas);
		}
		return formatarCasaDecimalDoFloat(retorno.floatValue());
	}
	
	public static Float calcularTotalPerdas(Long perdaCiclo, Long perdaParada,
			Long producaoRefugada, Long perdaCavidades){


		perdaCiclo = perdaCiclo != null ? perdaCiclo : 0l;
		perdaParada = perdaParada != null ? perdaParada : 0l;
		producaoRefugada = producaoRefugada != null ? producaoRefugada : 0l;
		perdaCavidades = perdaCavidades != null ? perdaCavidades : 0l;

		Float retorno = perdaCiclo.floatValue();
		retorno += perdaParada.floatValue();
		retorno += producaoRefugada.floatValue();
		retorno += perdaCavidades.floatValue();

		return formatarCasaDecimalDoFloat(retorno);

	}

	public static Double calcularTotalPerdas(Double  perdaCiclo, Double perdaParada,
			Double producaoRefugada, Double perdaCavidades){

		perdaCiclo = perdaCiclo != null ? perdaCiclo : 0d;
		perdaParada = perdaParada != null ? perdaParada : 0d;
		producaoRefugada = producaoRefugada != null ? producaoRefugada : 0d;
		perdaCavidades = perdaCavidades != null ? perdaCavidades : 0d;

		Double retorno = perdaCiclo;
		retorno += perdaParada;
		retorno += producaoRefugada;
		retorno += perdaCavidades;

		return retorno;
	}

	public static Float calcularIndicePerda(BigDecimal perda, BigDecimal producaoPrevista){
		return calcularIndicePerda((perda != null ? perda.longValue(): null), (producaoPrevista != null ? producaoPrevista.longValue(): null));
	}

	public static Float calcularIndice(BigDecimal qtd, BigDecimal total, Integer casasDecimais){
		Float retorno = 0f;

		if(qtd == null || total == null){
			return retorno;
		}

		if (total.floatValue() > 0){
			retorno = qtd.floatValue();
			retorno = retorno / total.floatValue();
			retorno = retorno * 100;
		}

		return formatarCasaDecimalDoFloat(retorno, casasDecimais);
	}

	public static Float calcularIndicePerda(Long perda, Long producaoPrevista){
		Float retorno = 0f;

		if(perda == null || producaoPrevista == null){
			return retorno;
		}

		if (producaoPrevista.floatValue() > 0){
			retorno = perda.floatValue();
			retorno = retorno / producaoPrevista.floatValue();
			retorno = retorno * 100;
		}

		return formatarCasaDecimalDoFloat(retorno);

	}

	public static Float calcularOEE(BigDecimal tempoProdutivo, BigDecimal tempoAtivo){

		if (tempoProdutivo == null || tempoAtivo == null){
			return 0f;
		}
		Float retorno = tempoProdutivo.floatValue();

		if(tempoProdutivo == null || tempoAtivo == null){
			return retorno;
		}
		if (tempoAtivo.floatValue() > 0){
			retorno = retorno / tempoAtivo.floatValue();
			retorno *= 100f;
		} else {
			retorno = 0f;
		}

		return formatarCasaDecimalDoFloat(retorno);

	}

	public static Float calcularProdutividade(BigDecimal tempoProdutivo, BigDecimal tempoTotal){
		return calcularOEECapital(tempoProdutivo, tempoTotal);
	}


	public static Float calcularOEECapital(BigDecimal tempoProdutivo, BigDecimal tempoTotal){

		if (tempoProdutivo == null || tempoTotal == null){
			return 0f;
		}

		Float retorno = tempoProdutivo.floatValue();

		if (tempoTotal.floatValue() > 0){
			retorno = retorno / tempoTotal.floatValue();
			retorno *= 100f;
		} else {
			retorno = 0f;
		}

		return formatarCasaDecimalDoFloat(retorno);

	}

	public static Float calcularEficiencia(BigDecimal tempoProdutivo, BigDecimal tempoTrabalhado){
		Float retorno = tempoProdutivo.floatValue();

		if(tempoProdutivo == null || tempoTrabalhado == null){
			return retorno;
		}

		if (tempoTrabalhado.floatValue() > 0){
			retorno = retorno / tempoTrabalhado.floatValue();
			retorno *= 100f;
		} else {
			retorno = 0f;
		}

		return formatarCasaDecimalDoFloat(retorno);

	}

	public static BigDecimal calcularCicloMedio(BigDecimal tmpCicNormal, BigDecimal qtCicloProdutivo){
		BigDecimal retorno = tmpCicNormal;

		if (tmpCicNormal == null || qtCicloProdutivo == null){
			return BigDecimal.ZERO;
		}


		if (tmpCicNormal.floatValue() > 0 && qtCicloProdutivo.floatValue() > 0) {
			retorno = retorno.divide(qtCicloProdutivo, MathContext.DECIMAL32);
		} else {
			retorno = BigDecimal.ZERO;
		}

		return retorno;

	}

	public static BigDecimal calcularPercentualDisponibilidade(BigDecimal tmpCicNormal, BigDecimal qtInjNormal){
		BigDecimal retorno = tmpCicNormal;

		if (tmpCicNormal == null || qtInjNormal == null){
			return BigDecimal.ZERO;
		}

		if (qtInjNormal.floatValue() > 0) {
			retorno = retorno.divide(qtInjNormal, MathContext.DECIMAL32);
		} else {
			retorno = BigDecimal.ZERO;
		}

		return retorno;

	}

	public static Float dividir(Float valor, Float divisor){
		Float retorno = valor;

		if (divisor.floatValue() > 0) {
			retorno = retorno / divisor;
		} else {
			retorno = 0f;
		}

		return formatarCasaDecimalDoFloat(retorno);

	}

	public static Float calcularMTBF(BigDecimal tempoAtivo, Integer qtOcorrenciaParadas){
		Float retorno = 0f;

		if (tempoAtivo == null || qtOcorrenciaParadas == null){
			return retorno;
		}

		if (qtOcorrenciaParadas > 0){
			retorno = tempoAtivo.floatValue() / 60; // encontra tempo em minutors
			retorno = retorno / qtOcorrenciaParadas;
		}
		return formatarCasaDecimalDoFloat(retorno);
	}
	public static Float calcularMTTR(BigDecimal tempoParadas, Integer qtOcorrenciaParadas){
		Float retorno = 0f;
		if (tempoParadas == null || qtOcorrenciaParadas == null){
			return retorno;
		}
		if (qtOcorrenciaParadas > 0){
			retorno = tempoParadas.floatValue() / 60; // encontra tempo em minutors
			retorno = retorno / qtOcorrenciaParadas;
		}
		return formatarCasaDecimalDoFloat(retorno);
	}

	/**
	 * Tempo total = tempo ativo + tempo n�o ativo (mesmo que tempo parada sem peso)
	 * @param tempoNaoAtivo
	 * @param tempoAtivo
	 * @return
	 */
	public static Float calcularTempoTotal(BigDecimal tempoNaoAtivo, BigDecimal tempoAtivo){

		tempoNaoAtivo = ObjectUtils.defaultIfNull(tempoNaoAtivo, BigDecimal.ZERO);
		tempoAtivo = ObjectUtils.defaultIfNull(tempoAtivo, BigDecimal.ZERO);

		Float retorno = tempoAtivo.floatValue() + tempoNaoAtivo.floatValue();

		return formatarCasaDecimalDoFloat(retorno);
	}

	public static Float calcularUtilizacao(BigDecimal tempotrabalhadas, BigDecimal tempoAtivo ){
		Float retorno = 0f;
		BigDecimal p100 = new BigDecimal(100);

		if (tempotrabalhadas == null || tempoAtivo == null){
			return retorno;
		}
		else
		{
			try{
				retorno = tempotrabalhadas.divide(tempoAtivo, MathContext.DECIMAL32).multiply(p100).floatValue();
			}catch(ArithmeticException e){
				retorno = 0f;
			}
		}
		return formatarCasaDecimalDoFloat(retorno);
	}

	/**
	 *  Horas boas: tempo ciclo produtivo - tempo refugo - tempo parada com peso de varia��o ritmo - tempo parada sem peso de varia��o ritmo
	 */
	public static BigDecimal calcularTempoBoas(BigDecimal segCicloProdutivo, BigDecimal segTemporefugado, BigDecimal segTempoParadaComPesoVariacaoRitmo,  BigDecimal segTempoParadaSemPesoVariacaoRitmo) {
		// Alessandre em 11-11-15 removi essa variacao de ritmo
		//segCicloProdutivo = calcularTempoCicloProdutivoSemParadaVariacaoRitmo(segCicloProdutivo, segTempoParadaComPesoVariacaoRitmo, segTempoParadaSemPesoVariacaoRitmo);

		BigDecimal retorno = AritmeticaUtil.diminuir(segCicloProdutivo, segTemporefugado);

		return retorno;
	}

	/**
	 * Ritmo:  [ ((Tempo dos ciclos normais - tempo parada com peso vari��o ritmo - tempo parada sem peso varia��o ritmo) / Ciclo padr�o) - Qtde de ciclos normais ] * Ciclo padr�o
	 * @param segCicloprodutivo
	 * @param qtCicloprodutivo
	 * @param cicloPadrao
	 * @return
	 */
	public static BigDecimal calcularRitmo(BigDecimal segCicloprodutivo, BigDecimal qtCicloprodutivo, BigDecimal cicloPadrao, BigDecimal segTempoParadaComPesoVariacaoRitmo,  BigDecimal segTempoParadaSemPesoVariacaoRitmo) {

		Validate.notNull(cicloPadrao, "calcularRitmo. cicloPadrao nao pode ser nulo");
		//Validate.validState(cicloPadrao.compareTo(BigDecimal.ZERO) > 0, "ciclo padrao deve ser maior que zero");
		if (cicloPadrao != null && cicloPadrao.doubleValue() <= 0d)
			return BigDecimal.ZERO;

		segCicloprodutivo = ObjectUtils.defaultIfNull(segCicloprodutivo, BigDecimal.ZERO);
		qtCicloprodutivo = ObjectUtils.defaultIfNull(qtCicloprodutivo, BigDecimal.ZERO);

		//segCicloprodutivo = calcularTempoCicloProdutivoSemParadaVariacaoRitmo(segCicloprodutivo, segTempoParadaComPesoVariacaoRitmo, segTempoParadaSemPesoVariacaoRitmo);

		return segCicloprodutivo.divide(cicloPadrao, MathContext.DECIMAL32).subtract(qtCicloprodutivo).multiply(cicloPadrao).setScale(4, BigDecimal.ROUND_HALF_UP);
	}

	/*
	 *  Marcos Sardinha: 2015-03-24 - fun��oo antiga
	 *
	public static BigDecimal calcularRitmoPercentual(BigDecimal ritmo, BigDecimal tempoTotal){
		ritmo = ObjectUtils.defaultIfNull(ritmo, BigDecimal.ZERO);
		tempoTotal = ObjectUtils.defaultIfNull(tempoTotal, BigDecimal.ZERO);
		if(CompareUtils.equals(ritmo, BigDecimal.ZERO)|| CompareUtils.equals(tempoTotal, BigDecimal.ZERO)){
			return BigDecimal.ZERO;
		}else{
			return ritmo.divide(tempoTotal, MathContext.DECIMAL32).multiply(new BigDecimal(100));
		}
	}
	*/

	// Marcos Sardinha: 2015-03-24 - nova fun��oo
	public static BigDecimal calcularRitmoPercentual(BigDecimal tempoCicloProdutivo, BigDecimal tempoTrabalhadas){
		tempoCicloProdutivo = ObjectUtils.defaultIfNull(tempoCicloProdutivo, BigDecimal.ZERO);
		tempoTrabalhadas = ObjectUtils.defaultIfNull(tempoTrabalhadas, BigDecimal.ZERO);
		if(CompareUtils.equals(tempoCicloProdutivo, BigDecimal.ZERO)|| CompareUtils.equals(tempoTrabalhadas, BigDecimal.ZERO)){
			return BigDecimal.ZERO;
		}else{
			return tempoCicloProdutivo.divide(tempoTrabalhadas, MathContext.DECIMAL32).multiply(new BigDecimal(100));
		}
	}


	/**
	 * Perda por cavidade: cavidades totais - cavidades ativas
	 * @param cavTotal
	 * @param cavAtiva
	 * @return
	 */
	public static BigDecimal calcularPerdaCavidade(BigDecimal cavTotal, BigDecimal cavAtiva) {

		cavTotal = ObjectUtils.defaultIfNull(cavTotal, BigDecimal.ZERO);
		cavAtiva = ObjectUtils.defaultIfNull(cavAtiva, BigDecimal.ZERO);
		Validate.validState(cavTotal.compareTo(cavAtiva) >= 0, "Perda Cavidade Cavidade Total deve ser maior que cavidades ativas");

		return cavTotal.subtract(cavAtiva);
	}


	/**
	 * Perda por cavidade: [ (qtd de ciclos executados) * (cavidades totais - cavidades ativas)]
	 * @param qtdCiclosExec
	 * @param cavTotal
	 * @param cavAtiva
	 * @return
	 */
	public static BigDecimal calcularPerdaCavidade(BigDecimal qtdCiclosExec, BigDecimal cavTotal, BigDecimal cavAtiva) {

		cavTotal = ObjectUtils.defaultIfNull(cavTotal, BigDecimal.ZERO);
		cavAtiva = ObjectUtils.defaultIfNull(cavAtiva, BigDecimal.ZERO);
		Validate.validState(cavTotal.compareTo(cavAtiva) >= 0, "Perda Cavidade 2 Cavidade Total deve ser maior que cavidades ativas");

		return qtdCiclosExec.multiply(cavTotal.subtract(cavAtiva));
	}

	/**
	 *  Cavidades inativas em segundos - (Cavidades totais - Cavidades ativas) * (Tempo dos ciclos normais / Cavidades totais)
	 * @param cavTotal
	 * @param cavAtiva
	 * @param segCicloprodutivo
	 * @return
	 */
	public static BigDecimal calcularCavidadesInativaSeg(BigDecimal cavTotal, BigDecimal cavAtiva, BigDecimal segCicloprodutivo) {

		cavTotal = ObjectUtils.defaultIfNull(cavTotal, BigDecimal.ONE);
		cavAtiva = ObjectUtils.defaultIfNull(cavAtiva, BigDecimal.ONE);

		if (cavTotal.intValue() < cavAtiva.intValue())
			cavTotal = cavAtiva;

		Validate.validState(cavTotal.compareTo(cavAtiva) >= 0, "Cavidade Inativa Cavidade Total deve ser maior que cavidades ativas " + cavAtiva + "/" + cavTotal);
		segCicloprodutivo = ObjectUtils.defaultIfNull(segCicloprodutivo, BigDecimal.ZERO);
		BigDecimal perdaCavidade = FormulasInjet.calcularPerdaCavidade(cavTotal, cavAtiva);

		try{
			return perdaCavidade.multiply(segCicloprodutivo).divide(cavTotal, MathContext.DECIMAL32);
		}catch(Exception e){
			return BigDecimal.ZERO;
		}

	}

	/**
	 *  Tempo ativo (tempo dispon�vel) : [Tempo dos ciclos normais] + [Tempo das paradas com peso] + [Tempos dos ciclos finalizados por parada] - [Parada de varia��o de ritmo com peso] - [Parada de varia��o de ritmo sem peso]
	 * @param segCicloprodutivo
	 * @param segTempoParadaComPeso
	 * @param segCicloimprodutivo
	 * @return
	 */
	public static BigDecimal calcularTempoAtivo(BigDecimal segCicloprodutivo, BigDecimal segTempoParadaComPeso,
			BigDecimal segCicloimprodutivo,
			BigDecimal segTempoParadaComPesoVariacaoRitmo,
			BigDecimal segTempoParadaSemPesoVariacaoRitmo) {

		/* Alessandre em 10-11-15 acredito que o cicloprodutivo ja eh salvo sem as paradas por variacao de
		 * ritmo, por isso comentei o trecho abaixo
		segCicloprodutivo = calcularTempoCicloProdutivoSemParadaVariacaoRitmo(segCicloprodutivo,
				segTempoParadaComPesoVariacaoRitmo,
				segTempoParadaSemPesoVariacaoRitmo);
		 */
		segCicloprodutivo = ObjectUtils.defaultIfNull(segCicloprodutivo, BigDecimal.ZERO);
		segTempoParadaComPeso = ObjectUtils.defaultIfNull(segTempoParadaComPeso, BigDecimal.ZERO);
		segCicloimprodutivo = ObjectUtils.defaultIfNull(segCicloimprodutivo, BigDecimal.ZERO);
		BigDecimal retorno = segCicloprodutivo.add(segTempoParadaComPeso).add(segCicloimprodutivo);

		if (retorno.compareTo(BigDecimal.ZERO) < 0)
			retorno = BigDecimal.ZERO;

		return retorno;

	}

	/**
	 * Tempo produtivo: Horas boas - Cavidades inativas em segundos - Ritmo (se resultado for negativo, considerar ZERO)
	 * @param segBoas
	 * @param segPerdacav
	 * @param segRitmo
	 * @return
	 */
	public static BigDecimal calcularTempoprodutivas(BigDecimal segBoas, BigDecimal segPerdacav, BigDecimal segRitmo) {
		BigDecimal retorno = segBoas;
		Boolean isRitmoNegativoNasProdutivas = IdwFacade.getInstancia().getIsRitmosempreNasHrsprod();
		
		if(segPerdacav != null ){
			retorno = retorno.subtract(segPerdacav);
		}
		
		if (IdwFacade.IS_IDW_ATIVO) {
			if (isRitmoNegativoNasProdutivas && segRitmo != null) {
				retorno = retorno.subtract(segRitmo);
			} else {
				// Alessandre em 04-05-15 alterei para remover o ritmo negativo da conta
				if(segRitmo != null && segRitmo.compareTo(BigDecimal.ZERO) > 0){
					retorno = retorno.subtract(segRitmo);
				}				
			}
			
		} else {
			retorno = retorno.subtract(segRitmo);
		}
//		BigDecimal retorno = segBoas.subtract(segPerdacav).subtract(segRitmo);
		
		if (isRitmoNegativoNasProdutivas) {
			return retorno;
		} else {
			return (retorno.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO: retorno) ;	
		}
		
	}

	/**
	 *  Tempo trabalhado: Horas dispon�veis - Horas das paradas com peso
	 * @param segTempoativo
	 * @param segTempoparadaCp
	 * @param segTempoparadaCpVarRitmo
	 * @param segTempoparadaSpVarRitmo
	 * @return
	 */
	public static BigDecimal calcularTempoTrabalhado(
			BigDecimal segTempoativo, BigDecimal segTempoparadaCp) {

		segTempoativo = ObjectUtils.defaultIfNull(segTempoativo, BigDecimal.ZERO);
		segTempoparadaCp = ObjectUtils.defaultIfNull(segTempoparadaCp, BigDecimal.ZERO);

		return segTempoativo.subtract(segTempoparadaCp);

	}

	/**
	 *  Produ��o prevista: (Horas Dispon�veis / Ciclo Padr�o) * Cavidades Ativas
	 * @param segAutoTempoativo
	 * @param cicloPadrao
	 * @param cavAtiva
	 * @return
	 */
	public static BigDecimal calcularProducaoPrevista(
			BigDecimal segAutoTempoativo, BigDecimal cicloPadrao,
			BigDecimal cavAtiva, BigDecimal fatorContagem, BigDecimal indiceOee) {

		try{
			if (IdwFacade.IS_IDW_ATIVO == true) {
				BigDecimal retorno = segAutoTempoativo.divide(cicloPadrao, MathContext.DECIMAL32).multiply(cavAtiva).multiply(fatorContagem);
				
				// No IDW devemos considerar o indice de capacidade do posto, principalmente em postos com pessoas que tem fadiga
				if (indiceOee != null && indiceOee.compareTo(BigDecimal.ZERO)> 0 )
					retorno = retorno.multiply(indiceOee.divide(new BigDecimal(100)));
				
				return retorno;
			} else {
				// injet pega soh o inteiro dos ciclos previstos - testes viqua
				BigDecimal ciclosPrevistos = new BigDecimal(segAutoTempoativo.divide(cicloPadrao, MathContext.DECIMAL32).intValue());
				return ciclosPrevistos.multiply(cavAtiva).multiply(fatorContagem);
			}
		}catch(Exception e){
			e.printStackTrace();
			return BigDecimal.ZERO;
		}
	}

	/**
	 *  Perda ciclo por pe�as, � o mesmo que ritmo por pe�as:
	 *  <br>  [ (Tempo dos ciclos normais / Ciclo padr�o) - Qtde de ciclos normais ] * ciclo padr�o
	 *  <br>     ou
	 *  <br>  ritmo por segundos / ciclo padr�o * cavidades ativas
	 * @param segRitmo
	 * @param cicloPadrao
	 * @param cavAtiva
	 * @return
	 */
	public static BigDecimal calcularPcsPerdaciclo(BigDecimal segRitmo, BigDecimal cicloPadrao, BigDecimal cavAtiva) {
		Validate.notNull(cicloPadrao, "calcularPcsPerdaciclo. Ciclo padrao nao pode ser nulo");
		Validate.validState(cicloPadrao.compareTo(BigDecimal.ZERO) == 1, "Ciclo padrao nao pode ser zero");
		return segRitmo.divide(cicloPadrao, MathContext.DECIMAL32).multiply(cavAtiva);
	}

	/**
	 * Tempo de refugo em segundos
	 * <br>(Quantidade refugada * Ciclo M�dio) / Cavidades ativas
	 * @return
	 * @deprecated Modificado o calculo do tempo de refugo
	 */
	@Deprecated
	public static BigDecimal calcularTempoRefugo(BigDecimal qtdRefugada, BigDecimal cicloMedio, BigDecimal cavAtivas){
		qtdRefugada = ObjectUtils.defaultIfNull(qtdRefugada, BigDecimal.ZERO);
		cicloMedio = ObjectUtils.defaultIfNull(cicloMedio, BigDecimal.ZERO);
		if( cavAtivas != null && cavAtivas.signum() > 0){
			return qtdRefugada.multiply(cicloMedio).divide(cavAtivas, MathContext.DECIMAL32);
		}else{
			return BigDecimal.ZERO;
		}

	}

	/*
	 * Esse metodo ira calcular o tempo de refugo se baseando no tempo dos ciclos e no indice de refugo.
	 * Ou seja, o tempo de refugo ser� o percentual refugado do tempo gasto ciclando.
	 */
	public static BigDecimal calcularTempoRefugoComBaseNoCiclo(BigDecimal producaoBruta, BigDecimal producaoRefugada, BigDecimal tempoCiclos) {
		Float ir = calcularIndiceRefugo(producaoRefugada, producaoBruta) / 100;
		// Ailton - 24-05-17: Validacao adicionada para evitar Null Pointers Exceptions detectados na Coleta Sony
		// if (ir == 0f || tempoCiclos.equals(BigDecimal.ZERO))
		if (ir == 0f || tempoCiclos == null || tempoCiclos.equals(BigDecimal.ZERO))
			return BigDecimal.ZERO;

		return tempoCiclos.multiply(new BigDecimal(ir)).setScale(4, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * Calcular CP
	 * <br> CP = (lse - lie) / (k * variancia)
	 * @param lse limite superior
	 * @param lie limite inferior
	 * @param k numero de intervalos ou classes
	 * @param variancia
	 * @return cp
	 */
	public static BigDecimal calcularCp(BigDecimal lse, BigDecimal lie, BigDecimal k, BigDecimal variancia) {
		Validate.notNull(lse, "calcularCp.Limite superior nao pode ser nulo");
		Validate.notNull(lie, "calcularCp.Limite inferior nao pode ser nulo");
		Validate.notNull(k, "calcularCp.Intervalo nao pode ser nulo");
		Validate.notNull(variancia, "calcularCp.Variancia nao pode ser nulo");
		BigDecimal dividendo = lse.subtract(lie);
		BigDecimal divisor = k.multiply(variancia);
		if(divisor.equals(BigDecimal.ZERO)){
			return BigDecimal.ZERO;
		}
		return dividendo.divide(divisor, MathContext.DECIMAL32);
    }

	/**
	 * Calcular CPK
	 * <p> cps = (lse - media) / ((k/2) x variancia)
	 * <br> cpi = (media - lie) / ((k/2) x variancia)
	 *
	 * @param lse limite superior
	 * @param lie limite inferior
	 * @param media
	 * @param k numero de intervalos ou classes
	 * @param variancia
     * @return CPK = o menor entre CPI e CPS
	 */
    public static BigDecimal calcularCpk(BigDecimal lse, BigDecimal lie, BigDecimal media, BigDecimal k, BigDecimal variancia) {
    	Validate.notNull(lse, "Limite superior nao pode ser nulo");
		Validate.notNull(lie, "Limite inferior nao pode ser nulo");
		Validate.notNull(k, "Intervalo nao pode ser nulo");
		Validate.notNull(variancia, "Variancia nao pode ser nulo");

        BigDecimal cps = calcularCps(lse, media, k, variancia);
        BigDecimal cpi = calcularCpi(lie, media, k, variancia);

        return calcularCpk(cps, cpi);

    }

    /**
     * Calcular cpk
     * <p>Capabilidade (Cpk): � o �ndice que leva em conta a centraliza��o do processo e � definido como o m�nimo entre CPS e CPI
     * @param cps
     * @param cpi
     * @return
     * @see #calcularCps(BigDecimal, BigDecimal, BigDecimal)
     * @see #calcularCpi(BigDecimal, BigDecimal, BigDecimal)
     */
    public static BigDecimal calcularCpk(BigDecimal cps, BigDecimal cpi){
    	Validate.notNull(cps, "cps n�o pode ser nulo");
    	Validate.notNull(cpi, "cpi n�o pode ser nulo");
    	return cps.compareTo(cpi) == -1  ? cps : cpi;
    }

    /**
     * Calcular Media
     * <br>media = (lse + lie) / 2
     *
     * @param lse limite superior
     * @param lie limite inferior
     * @return media
     */
    public static BigDecimal calcularMedia(BigDecimal lse, BigDecimal lie) {
		Validate.notNull(lse, "Limite superior nao pode ser nulo");
		Validate.notNull(lie, "Limite inferior nao pode ser nulo");
        return lse.add(lie).divide(new BigDecimal(2), MathContext.DECIMAL32);
    }

    /**
     * Calcular Cpi
     * <br>cpi = (media - lie) / ((k/2) x variancia)
     *
	 * @param lie limite inferior
	 * @param media
	 * @param k numero de intervalos ou classes
	 * @param variancia
     * @return cpi
     */
    public static BigDecimal calcularCpi(BigDecimal lie, BigDecimal media, BigDecimal k, BigDecimal variancia) {
		Validate.notNull(lie, "Limite inferior nao pode ser nulo");
		Validate.notNull(media, "Media nao pode ser nulo");
		Validate.notNull(k, "Intervalo nao pode ser nulo");
		Validate.notNull(variancia, "Variancia nao pode ser nulo");

		BigDecimal dividendo = media.subtract(lie);
		BigDecimal divisor = k.divide(new BigDecimal(2), MathContext.DECIMAL32).multiply(variancia, MathContext.DECIMAL32);
		if(divisor.equals(BigDecimal.ZERO)){
			return BigDecimal.ZERO;
		}
		if (IdwFacade.IS_IDW_ATIVO) {
			return dividendo.divide(divisor, MathContext.DECIMAL32);
		} else {
			return dividendo.divide(divisor, MathContext.DECIMAL32).abs();
		}
    }

    /**
     * Calcular Cps
     * <br>cps = (lse - media) / ((k/2) x variancia)
     *
     * @param lse limite superior
	 * @param media
	 * @param k numero de intervalos ou classes
	 * @param variancia
     * @return cps
     */
    public static BigDecimal calcularCps(BigDecimal lse, BigDecimal media, BigDecimal k, BigDecimal variancia) {
    	Validate.notNull(lse, "Limite superior nao pode ser nulo");
		Validate.notNull(media, "Media nao pode ser nulo");
		Validate.notNull(k, "Intervalo nao pode ser nulo");
		Validate.notNull(variancia, "Variancia nao pode ser nulo");

		BigDecimal dividendo = lse.subtract(media);
		BigDecimal divisor = k.divide(new BigDecimal(2), MathContext.DECIMAL32).multiply(variancia, MathContext.DECIMAL32);
		if(divisor.equals(BigDecimal.ZERO)){
			return BigDecimal.ZERO;
		}
		
		if (IdwFacade.IS_IDW_ATIVO) {
			return dividendo.divide(divisor, MathContext.DECIMAL32);
		} else {
			return dividendo.divide(divisor, MathContext.DECIMAL32).abs();
		}
    }

    /**
     * Calcula o desvio padr�o
     * <p>Em estat�stica, o desvio padr�o � um valor que quantifica a dispers�o dos dados em torno da m�dia.
     * <br>Basicamente � a m�dia quadr�tica das diferen�as entre o valor de cada dado e a m�dia.
     * <br>O desvio padr�o, dentre as medidas de dispers�o, � o mais utilizado pois seu valor est� na mesma unidade de medida dos dados e ent�o pode descrever mais claramente a quantidade de dispers�o na distribui��o da frequ�ncia.
     * @param valores
     * @return
     */
    public static double calcularDesvioPadrao(double[] valores){
    	// Retorna o desvio padr�o
    	return getSummaryStatistics(valores).getStandardDeviation();
    }

    /**
     * Monta SummaryStatistics
     * @param valores
     * @return
     */
    public static SummaryStatistics getSummaryStatistics(double[] valores){
    	SummaryStatistics stat = new SummaryStatistics();
    	for(int i = 0; i < valores.length; i++ ){
    		stat.addValue(valores[i]);
    	}
    	return stat;
    }

    /**
     * Calcula dados relacionados a capabilidade do processo
     * @param lse
     * @param lie
     * @param valores
     * @param k numero de intervalos ou classes
     * @return
     */
    public static CapabilidadeProcessoDTO calcularCapabilidadeProcesso(BigDecimal lse, BigDecimal lie, double[] valores, BigDecimal k){
    	CapabilidadeProcessoDTO capabilidadeProcessoDTO = new CapabilidadeProcessoDTO();

    	SummaryStatistics stat = FormulasInjet.getSummaryStatistics(valores);
    	BigDecimal desvioPadrao = new BigDecimal(stat.getStandardDeviation());
    	BigDecimal variancia = new BigDecimal(stat.getVariance());
    	BigDecimal media = new BigDecimal(stat.getMean());
    	long n = stat.getN();
    	capabilidadeProcessoDTO.setDesvioPadrao(desvioPadrao.doubleValue());
    	capabilidadeProcessoDTO.setVariancia(variancia.doubleValue());
    	capabilidadeProcessoDTO.setMedia(media.doubleValue());
    	capabilidadeProcessoDTO.setN(n);
    	capabilidadeProcessoDTO.setLie(lie.doubleValue());
    	capabilidadeProcessoDTO.setLse(lse.doubleValue());
    	
    	if (desvioPadrao.doubleValue() == 0d) {
        	capabilidadeProcessoDTO.setCp(0d);
        	capabilidadeProcessoDTO.setCpi(0d);
        	capabilidadeProcessoDTO.setCps(0d);
        	capabilidadeProcessoDTO.setCpk(0d);    		    		
    	} else {
        	capabilidadeProcessoDTO.setCp(FormulasInjet.calcularCp(lse, lie, k, variancia).doubleValue());
        	capabilidadeProcessoDTO.setCpi(FormulasInjet.calcularCpi(lie, media, k, variancia).doubleValue());
        	capabilidadeProcessoDTO.setCps(FormulasInjet.calcularCps(lse, media, k, variancia).doubleValue());
        	capabilidadeProcessoDTO.setCpk(FormulasInjet.calcularCpk(lse, lie, media, k, variancia).doubleValue());    		
    	}

    	return capabilidadeProcessoDTO;
    }

	/**
	 *  Perda parada por pe�as:
	 *    [ (Tempo das paradas / Ciclo padr�o) ] * cavidades ativas
	 * @param segTempoParada
	 * @param cicloPadrao
	 * @param cavAtiva
	 * @return
	 */
	public static BigDecimal calcularPcsPerdaParada(BigDecimal segTempoParada, BigDecimal cicloPadrao, BigDecimal cavAtiva) {
		if (segTempoParada != null) {
			Validate.notNull(cicloPadrao, "Ciclo padrao nao pode ser nulo");
			Validate.validState(cicloPadrao.compareTo(BigDecimal.ZERO) == 1, "Ciclo padrao nao pode ser zero");
			return segTempoParada.divide(cicloPadrao, MathContext.DECIMAL32).multiply(cavAtiva);
		} else {
			return BigDecimal.ZERO;
		}
	}


	/**
	 * �ndice  de pe�as por ciclo ativas: (pcs por ciclo ativas / pcs por ciclo totais) * 100
	 * @param pcsCicTotal
	 * @param pcsCicAtiva
	 * @return
	 */
	public static BigDecimal calcularIndicePcsPorCicloAtivas(BigDecimal pcsCicTotal, BigDecimal pcsCicAtiva) {

		pcsCicTotal = ObjectUtils.defaultIfNull(pcsCicTotal, BigDecimal.ZERO);
		pcsCicAtiva = ObjectUtils.defaultIfNull(pcsCicAtiva, BigDecimal.ZERO);
		Validate.validState(pcsCicTotal.compareTo(pcsCicAtiva) >= 0, "calcularIndicePcsPorCicloAtivas Cavidade Total (" + pcsCicTotal + ") deve ser maior que cavidades ativas (" + pcsCicAtiva + ")");

		// Verifica se algum dos valores eh zero
		if((pcsCicTotal.signum() == 0) || (pcsCicAtiva.signum() == 0)  ){
			return BigDecimal.ZERO;
		}else {
			Double ativa = pcsCicAtiva.doubleValue();
			Double tot = pcsCicTotal.doubleValue();
			Double icav = (ativa / tot) * 100;
			return new BigDecimal(icav);
		}

	}

	/**
	 * ITO: (tempoPeriodo - tempoParadasProgramadas - tempoParadasNaoProgramadas)
	 *  / (tempoPeriodo - tempoParadasProgramadas) * 100
	 * @param tempoPeriodo
	 * @param tempoParadasCp
	 * @param tempoParadasSp
	 * @return
	 */
	public static BigDecimal calcularITO(BigDecimal tempoPeriodo, BigDecimal tempoParadasCp,
			BigDecimal tempoParadasSp){

		tempoPeriodo = ObjectUtils.defaultIfNull(tempoPeriodo, BigDecimal.ZERO);
		tempoParadasCp = ObjectUtils.defaultIfNull(tempoParadasCp, BigDecimal.ZERO);
		tempoParadasSp = ObjectUtils.defaultIfNull(tempoParadasSp, BigDecimal.ZERO);

		BigDecimal parte1 = (tempoPeriodo.subtract(tempoParadasCp)).subtract(tempoParadasSp).subtract(tempoParadasCp);
		BigDecimal parte2 = (tempoPeriodo.subtract(tempoParadasSp));

		if(parte1.compareTo(BigDecimal.ONE) == -1 || parte2.compareTo(BigDecimal.ONE) == -1) {
			return BigDecimal.ZERO;
		}

		return parte1.divide(parte2, MathContext.DECIMAL32).multiply(new BigDecimal(100));

	}

	/**
	 * IDO: (qtdCicExecutados * CicloPadr�o) /
	 * (tempoPeriodo - tempoParadasProgramadas - tempoParadasNaoProgramadas) * 100
	 * @param qtdCicExecutados
	 * @param cicloPadrao
	 * @param tempoPeriodo
	 * @param tempoParadasProgramadas
	 * @param tempoParadasNaoProgramadas
	 * @return
	 */
	public static BigDecimal calcularIDO(BigDecimal qtdCicExecutados, BigDecimal cicloPadrao, BigDecimal tempoPeriodo,
			BigDecimal tempoParadasProgramadas, BigDecimal tempoParadasNaoProgramadas){

		qtdCicExecutados = ObjectUtils.defaultIfNull(qtdCicExecutados, BigDecimal.ZERO);
		cicloPadrao = ObjectUtils.defaultIfNull(cicloPadrao, BigDecimal.ZERO);
		tempoPeriodo = ObjectUtils.defaultIfNull(tempoPeriodo, BigDecimal.ZERO);
		tempoParadasProgramadas = ObjectUtils.defaultIfNull(tempoParadasProgramadas, BigDecimal.ZERO);
		tempoParadasNaoProgramadas = ObjectUtils.defaultIfNull(tempoParadasNaoProgramadas, BigDecimal.ZERO);

		if(qtdCicExecutados.compareTo(BigDecimal.ONE) == -1 || cicloPadrao.compareTo(BigDecimal.ONE) == -1) {
			return BigDecimal.ZERO;
		}
		BigDecimal parte2 = ((tempoPeriodo.subtract(tempoParadasProgramadas)).subtract(tempoParadasNaoProgramadas));
		if(parte2.compareTo(BigDecimal.ONE) == -1){
			return BigDecimal.ZERO;
		}

		BigDecimal retorno = qtdCicExecutados.multiply(cicloPadrao);
		retorno = retorno.divide(parte2, MathContext.DECIMAL32).multiply(new BigDecimal(100));

		return retorno;
	}

	/**
	 * IPA: (producaoBruta - producaoLiquida) / producaoBruta * 100
	 * @param producaoBruta
	 * @param producaoLiquida
	 * @return
	 */
	public static BigDecimal calcularIPA(BigDecimal producaoBruta, BigDecimal producaoLiquida){

		producaoBruta = ObjectUtils.defaultIfNull(producaoBruta, BigDecimal.ZERO);
		producaoLiquida = ObjectUtils.defaultIfNull(producaoLiquida, BigDecimal.ZERO);

		if(producaoBruta.compareTo(BigDecimal.ZERO) == 1 && producaoLiquida.compareTo(BigDecimal.ZERO) == 1){
			return producaoBruta.subtract(producaoLiquida).divide(producaoBruta, MathContext.DECIMAL32).multiply(new BigDecimal(100));
		}else{
			return BigDecimal.ZERO;
		}

	}

	public static BigDecimal calcularProducaoLiquida(BigDecimal producaoBruta, BigDecimal producaoRefugada){
		return AritmeticaUtil.diminuir(producaoBruta, producaoRefugada);
	}

	/**
	 * OEE: (ITO * IDO * IPA) / 100
	 * @param ITO
	 * @param IDO
	 * @param IPA
	 * @return
	 */
	public static BigDecimal calcularOEE(BigDecimal ITO, BigDecimal IDO, BigDecimal IPA){

		ITO = ObjectUtils.defaultIfNull(ITO, BigDecimal.ZERO);
		IDO = ObjectUtils.defaultIfNull(IDO, BigDecimal.ZERO);
		IPA = ObjectUtils.defaultIfNull(IPA, BigDecimal.ZERO);
		if(ITO.compareTo(BigDecimal.ONE) == -1 || IDO.compareTo(BigDecimal.ONE) == -1 || IPA.compareTo(BigDecimal.ONE) == -1){
			return BigDecimal.ZERO;
		}
		BigDecimal retorno = ((ITO.multiply(IDO)).multiply(IPA)).divide(new BigDecimal(100), MathContext.DECIMAL32);

		return retorno;
	}

	public static Double calcularIndiceMP (BigDecimal quantidadePerda, BigDecimal quantidadeUsadaPorProduto, BigDecimal producaoBruta){
		Double retorno = 0d;

		if(producaoBruta == null || quantidadePerda == null || quantidadeUsadaPorProduto == null){
			return retorno;
		}

		if (producaoBruta.doubleValue() > 0){
			retorno = quantidadePerda.doubleValue();
			retorno = retorno / (producaoBruta.multiply(quantidadeUsadaPorProduto).floatValue());
			retorno = retorno * 100;
		}

		DecimalFormat df  = new DecimalFormat("####.##");
		String indiceMP = df.format(retorno);
		indiceMP = indiceMP.replaceAll(",", ".");
		retorno = Double.parseDouble(indiceMP);

		return retorno;
	}

	public static BigDecimal calcularTempoCicloProdutivoSemParadaVariacaoRitmo(
			BigDecimal segTempoCicloProdutivo,
			BigDecimal segTempoparadaCpVarRitmo,
			BigDecimal segTempoparadaSpVarRitmo){

		segTempoCicloProdutivo = ObjectUtils.defaultIfNull(segTempoCicloProdutivo, BigDecimal.ZERO);
		segTempoparadaCpVarRitmo = ObjectUtils.defaultIfNull(segTempoparadaCpVarRitmo, BigDecimal.ZERO);
		segTempoparadaSpVarRitmo = ObjectUtils.defaultIfNull(segTempoparadaSpVarRitmo, BigDecimal.ZERO);

		return segTempoCicloProdutivo.subtract(segTempoparadaCpVarRitmo).subtract(segTempoparadaSpVarRitmo);
	}

	public static Float calcularIndicePerda(BigDecimal perdaCiclo, BigDecimal perdaParada,
			BigDecimal producaoRefugada, BigDecimal perdaCavidades,
			BigDecimal producaoPrevista){

		Float retorno = perdaCiclo.floatValue();

		retorno += perdaParada.floatValue();
		retorno += producaoRefugada.floatValue();
		retorno += perdaCavidades.floatValue();

		if (producaoPrevista.floatValue() > 0){
			retorno = retorno / producaoPrevista.floatValue();
			retorno = retorno * 100;
		} else {
			retorno = 0f;
		}
		return formatarCasaDecimalDoFloat(retorno);

	}
	public static Float calcularEficienciaCicloPonderada(Integer qtdeMoldes, BigDecimal somaHG){
		Float retorno = somaHG.floatValue();

		if (qtdeMoldes > 0)
			retorno = retorno / qtdeMoldes;
		else
			retorno = 0f;

		return formatarCasaDecimalDoFloat(retorno);

	}


	/**
	 * IPA: (cavidadesAtivas) / totalCavidades * 100
	 * @param cavidadesAtivas
	 * @param totalCavidades
	 * @return
	 */

	public static Float calcularIndiceCavidades(BigDecimal cavidadesAtivas, BigDecimal totalCavidades){
		Float retorno = 0f;

		if (cavidadesAtivas == null || totalCavidades == null || cavidadesAtivas.compareTo(BigDecimal.ZERO) == 0){
			return retorno;
		}


			retorno = cavidadesAtivas.floatValue();
			retorno = retorno / totalCavidades.floatValue();
			retorno = retorno * 100;

		return formatarCasaDecimalDoFloat(retorno);
	}
	public static void main(String[] args) {
		BigDecimal produzido = new BigDecimal(147);
		BigDecimal def = new BigDecimal(60);
		
		System.out.println(calcularIndiceDefeito(produzido, def, 2));
	}
	public static BigDecimal calcularIndiceDefeito(BigDecimal produzido, BigDecimal defeitos, int casasDecimais) {
		return calcularIndiceDefeito(produzido, defeitos, casasDecimais, RoundingMode.HALF_UP);
	}
	public static BigDecimal calcularIndiceDefeito(BigDecimal produzido, BigDecimal defeitos, int casasDecimais, RoundingMode roundingMode) {
		produzido = ObjectUtils.defaultIfNull(produzido, BigDecimal.ZERO);
		defeitos = ObjectUtils.defaultIfNull(defeitos, BigDecimal.ZERO);
		if (defeitos.equals(BigDecimal.ZERO)) {
			return BigDecimal.ZERO;
		} else if (produzido.equals(BigDecimal.ZERO)) {
			return new BigDecimal(100);
		} else {
			return AritmeticaUtil.calcularPorcentagem(defeitos, produzido); //dividir(defeitos, produzido, casasDecimais, roundingMode).multiply(new BigDecimal(100));
		}
	}

	/**
	 *  Tempo produtivo: tempo dos ciclos normais - tempo pcs refugadas -  tempo pcs/ciclo inativas - ritmo. Se tempo produtivo < 0, entao valor final = 0 
	 * @param segTempoCiclosNormais
	 * @param segTempoProducaoRefugada
	 * @param segTempoPcsCicloInativas
	 * @param segTempoRitmo
	 * @return
	 */
	public static BigDecimal calcularTempoProdutivas(
			BigDecimal segTempoCiclosNormais, BigDecimal segTempoProducaoRefugada, BigDecimal segTempoPcsCicloInativas, BigDecimal segTempoRitmo) {
		BigDecimal tmpProdutivas = BigDecimal.ZERO;
		
		tmpProdutivas = AritmeticaUtil.somar(tmpProdutivas, segTempoCiclosNormais);
		tmpProdutivas = AritmeticaUtil.diminuir(tmpProdutivas, segTempoProducaoRefugada);
		tmpProdutivas = AritmeticaUtil.diminuir(tmpProdutivas, segTempoPcsCicloInativas);
		tmpProdutivas = AritmeticaUtil.diminuir(tmpProdutivas, segTempoRitmo);
		if (tmpProdutivas.doubleValue() < 0) {
			tmpProdutivas = BigDecimal.ZERO;
		}
		
		return tmpProdutivas;
	}	
}
