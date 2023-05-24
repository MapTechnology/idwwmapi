package idw.model.rn.injet.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.FuncoesApoioInjet;
import idw.util.FormulasInjet;

@SuppressWarnings("serial")
public class MaquinaTotalInjetDTO implements Serializable{

	protected BigDecimal tempoAtivoSegundos = new BigDecimal(0);
	protected BigDecimal tempoParadaSegundos = new BigDecimal(0);
	protected BigDecimal tempoParadaEmAbertoSegundos = new BigDecimal(0);
	protected BigDecimal tempoParadaSemPesoSegundos = new BigDecimal(0);
	protected BigDecimal tempoCicloProdutivoSegundos = new BigDecimal(0);
	protected BigDecimal tempoCicloImprodutivoSegundos = new BigDecimal(0);
	protected BigDecimal tempoTrabalhadoSegundos = new BigDecimal(0);
	protected BigDecimal tempoRefugoSegundos = new BigDecimal(0);
	protected BigDecimal tempoRitmoSegundos = new BigDecimal(0);
	protected BigDecimal tempoProdutivasSegundos = new BigDecimal(0);
	protected BigDecimal tempoDisponiveisSegundos = new BigDecimal(0);
	protected BigDecimal tempoPerdaCavidadeSegundos = new BigDecimal(0);
	protected BigDecimal tempoPerdaCicloSegundos = new BigDecimal(0);

	protected BigDecimal tempoPrevistoCicloSegundos = new BigDecimal(0);
	
	protected BigDecimal pci = new BigDecimal(0);

	protected BigDecimal perdaParadaCusto = new BigDecimal(0);
	protected BigDecimal perdaParadaSemPesoCusto = new BigDecimal(0);
	protected BigDecimal producaoRefugadaCusto = new BigDecimal(0);
	protected BigDecimal perdaCicloCusto = new BigDecimal(0);
	
	protected BigDecimal perdaParadasUnidade = new BigDecimal(0);
	protected BigDecimal perdaParadasSemPesoUnidade = new BigDecimal(0);
	protected BigDecimal perdaCicloUnidade = new BigDecimal(0);

	protected BigDecimal perdaParadasKg = new BigDecimal(0);
	protected BigDecimal perdaParadasSemPesoKg = new BigDecimal(0);
	protected BigDecimal perdaCicloKg = new BigDecimal(0);

	protected BigDecimal perdaCavidadeUnidade = new BigDecimal(0);
	protected BigDecimal perdaCavidadeKg = new BigDecimal(0);
	protected BigDecimal perdaCavidadeCusto = new BigDecimal(0);
	
	protected BigDecimal producaoPrevistaUnidade = new BigDecimal(0);
	protected BigDecimal producaoBrutaUnidade = new BigDecimal(0);
	protected BigDecimal producaoLiquidaUnidade = new BigDecimal(0);
	protected BigDecimal producaoRefugadaUnidade = new BigDecimal(0);

	protected BigDecimal producaoPrevistaKg = new BigDecimal(0);
	protected BigDecimal producaoBrutaKg = new BigDecimal(0);
	protected BigDecimal producaoLiquidaKg = new BigDecimal(0);
	protected BigDecimal producaoRefugadaKg = new BigDecimal(0);

	
	protected BigDecimal producaoPrevistaHoraria = new BigDecimal(0);
	
	protected Float indiceParada = 0f;
	protected Float indiceRefugo = 0f;
	protected Float indiceCavidadeAtiva = 0f;
	protected Float eficienciaRealizacao = 0f;
	protected Float eficienciaCiclo = 0f;
	protected Float eficienciaUltimoCiclo = 0f;
	protected Float indicePerda = 0f;
	protected Float eficienciaCicloPonderada = 0f;
	protected Float utilizacao = 0f;

	protected BigDecimal cicloMedio = new BigDecimal(0);
	protected BigDecimal cicloPadrao = new BigDecimal(0);
	protected BigDecimal qtInjNormal = new BigDecimal(0);
	protected BigDecimal ultimoCiclo = new BigDecimal(0);
	protected Integer qtOcorrenciaParadasMTBFMTTR = 0;
	protected BigDecimal tempoCorrecaoCTT = new BigDecimal(0);
	protected BigDecimal tempoParadasMTTR = new BigDecimal(0);
	
	protected Integer qtCicloPadraoDiferentes = 0;
	
	protected BigDecimal qtCiclosPrevistos = new BigDecimal(0);
	

	private List<EficienciaCicloInjetDTO> eficienciaCicloDTOs = new ArrayList<EficienciaCicloInjetDTO>();
	
	public void addEficienciaCicloDTO(EficienciaCicloInjetDTO eficienciaCicloDTO){
		boolean isExiste = false;
		for (EficienciaCicloInjetDTO eficiencia : eficienciaCicloDTOs){
			if (eficiencia.equals(eficienciaCicloDTO)){
				isExiste = true;
				eficiencia.addTmpcicnormal(eficienciaCicloDTO.getTmpcicnormal());
				eficiencia.addQtinjnormal(eficienciaCicloDTO.getQtinjnormal());
			}
		}
		if (isExiste == false){
			EficienciaCicloInjetDTO novo = new EficienciaCicloInjetDTO(
					eficienciaCicloDTO.getCdInjetora(),
					eficienciaCicloDTO.getCdMolde(),
					eficienciaCicloDTO.getCdEstrutura(),
					eficienciaCicloDTO.getDthrvalcic());
			
			novo.setCicloPadrao(eficienciaCicloDTO.getCicloPadrao());
			novo.setQtinjnormal(eficienciaCicloDTO.getQtinjnormal());
			novo.setTmpcicnormal(eficienciaCicloDTO.getTmpcicnormal());
			
			eficienciaCicloDTOs.add(novo);
		}
	}
	/**
	 * @return the tempoAtivoSegundos
	 */
	public BigDecimal getTempoAtivoSegundos() {
		return tempoAtivoSegundos;
	}
	public Float getTempoAtivoHorasFormatado() {
		return FormulasInjet.formatarCasaDecimalDoFloat(getTempoAtivoSegundos().floatValue() / 3600f);
	}
	/**
	 * @param tempoAtivoSegundos the tempoAtivoSegundos to set
	 */
	public void setTempoAtivoSegundos(BigDecimal tempoAtivoSegundos) {
		this.tempoAtivoSegundos = tempoAtivoSegundos;
	}
	/**
	 * @return the tempoParadaSeundos
	 */
	public BigDecimal getTempoParadaSegundos() {
		return tempoParadaSegundos;
	}
	/**
	 * @param tempoParadaSeundos the tempoParadaSeundos to set
	 */
	public void setTempoParadaSegundos(BigDecimal tempoParadaSeundos) {
		this.tempoParadaSegundos = tempoParadaSeundos;
	}
	/**
	 * @return the tempoNaoDisponiveisSegundos
	 */
	public BigDecimal getTempoNaoDisponiveisSegundos() {
		return tempoParadaSemPesoSegundos;
	}
	/**
	 * @return the tempoCicloProdutivoSegundos
	 */
	public BigDecimal getTempoCicloProdutivoSegundos() {
		return tempoCicloProdutivoSegundos;
	}
	/**
	 * @param tempoCicloProdutivoSegundos the tempoCicloProdutivoSegundos to set
	 */
	public void setTempoCicloProdutivoSegundos(BigDecimal tempoCicloProdutivoSegundos) {
		this.tempoCicloProdutivoSegundos = tempoCicloProdutivoSegundos;
	}
	/**
	 * @return the tempoCicloImprodutivoSegundos
	 */
	public BigDecimal getTempoCicloImprodutivoSegundos() {
		return tempoCicloImprodutivoSegundos;
	}
	/**
	 * @param tempoCicloImprodutivoSegundos the tempoCicloImprodutivoSegundos to set
	 */
	public void setTempoCicloImprodutivoSegundos(
			BigDecimal tempoCicloImprodutivoSegundos) {
		this.tempoCicloImprodutivoSegundos = tempoCicloImprodutivoSegundos;
	}
	/**
	 * @return the tempoCavidadeIsoladasSegundos
	 */
//	public BigDecimal getTempoCavidadeIsoladasSegundos() {
//		return tempoCavidadeIsoladasSegundos;
//	}
	/**
	 * @param tempoCavidadeIsoladasSegundos the tempoCavidadeIsoladasSegundos to set
	 */
//	public void setTempoCavidadeIsoladasSegundos(
//			BigDecimal tempoCavidadeIsoladasSegundos) {
//		this.tempoCavidadeIsoladasSegundos = tempoCavidadeIsoladasSegundos;
//	}
	/**
	 * @return the tempoTrabalhadoSegundos
	 */
	public BigDecimal getTempoTrabalhadoSegundos() {
		return tempoTrabalhadoSegundos;
	}
	/**
	 * @param tempoTrabalhadoSegundos the tempoTrabalhadoSegundos to set
	 */
	public void setTempoTrabalhadoSegundos(BigDecimal tempoTrabalhadoSegundos) {
		this.tempoTrabalhadoSegundos = tempoTrabalhadoSegundos;
	}
	/**
	 * @return the tempoRefugoSegundos
	 */
	public BigDecimal getTempoRefugoSegundos() {
		return tempoRefugoSegundos;
	}
	public Float getTempoRefugoHorasFormatado() {
		return FormulasInjet.formatarCasaDecimalDoFloat(getTempoRefugoSegundos().floatValue() / 3600f);
	}
	/**
	 * @param tempoRefugoSegundos the tempoRefugoSegundos to set
	 */
	public void setTempoRefugoSegundos(BigDecimal tempoRefugoSegundos) {
		this.tempoRefugoSegundos = tempoRefugoSegundos;
	}
	/**
	 * @return the tempoRitmoSegundos
	 */
	public BigDecimal getTempoRitmoSegundos() {
		return tempoRitmoSegundos;
	}
	/**
	 * @param tempoRitmoSegundos the tempoRitmoSegundos to set
	 */
	public void setTempoRitmoSegundos(BigDecimal tempoRitmoSegundos) {
		this.tempoRitmoSegundos = tempoRitmoSegundos;
	}
	/**
	 * @return the tempoBoasSegundos
	 */
	public BigDecimal getTempoBoasSegundos() {
		return tempoCicloProdutivoSegundos.subtract(tempoRefugoSegundos);
	}

	public Float getTempoBoasHorasFormatado() {
		return FormulasInjet.formatarCasaDecimalDoFloat(getTempoBoasSegundos().floatValue() / 3600f);
	}

	/**
	 * @return the tempoProdutivasSegundos
	 */
	public BigDecimal getTempoProdutivasSegundos() {
		return tempoProdutivasSegundos;
	}

	public Float getTempoProdutivasHorasFormatado() {
		return FormulasInjet.formatarCasaDecimalDoFloat(
				tempoProdutivasSegundos.floatValue() / 3600f);
	}

	/**
	 * @param tempoProdutivasSegundos the tempoProdutivasSegundos to set
	 */
	public void setTempoProdutivasSegundos(BigDecimal tempoProdutivasSegundos) {
		this.tempoProdutivasSegundos = tempoProdutivasSegundos;
	}
	/**
	 * @return the tempoDisponiveisSegundos
	 */
	public BigDecimal getTempoDisponiveisSegundos() {
		return tempoDisponiveisSegundos;
	}

	public BigDecimal getTempoDisponiveisHoras() {
		return tempoDisponiveisSegundos.divide(new BigDecimal(3600), BigDecimal.ROUND_HALF_EVEN);
	}


	public Float getTempoDisponiveisHorasFormatado() {
		return FormulasInjet.formatarCasaDecimalDoFloat(tempoDisponiveisSegundos.divide(new BigDecimal(3600), BigDecimal.ROUND_HALF_EVEN).floatValue());
	}


	/**
	 * @param tempoDisponiveisSegundos the tempoDisponiveisSegundos to set
	 */
	public void setTempoDisponiveisSegundos(BigDecimal tempoDisponiveisSegundos) {
		this.tempoDisponiveisSegundos = tempoDisponiveisSegundos;
	}
	/**
	 * @return the tempoTotalSegundos
	 */
	public BigDecimal getTempoTotalSegundos() {
		return tempoDisponiveisSegundos.add(tempoParadaSemPesoSegundos);
	}
	public BigDecimal getTempoTotalHoras() {
		return getTempoTotalSegundos().divide(new BigDecimal(3600), BigDecimal.ROUND_HALF_EVEN);
	}
	public Float getTempoTotalHorasFormatado() {
		return FormulasInjet.formatarCasaDecimalDoFloat(getTempoTotalSegundos().divide(new BigDecimal(3600), BigDecimal.ROUND_HALF_EVEN).floatValue());
	}
	/**
	 * @return the pci
	 */
	public BigDecimal getPci() {
		return pci;
	}
	/**
	 * @param pci the pci to set
	 */
	public void setPci(BigDecimal pci) {
		this.pci = pci;
	}
	/**
	 * @return the perdaParadasUnidade
	 */
	public BigDecimal getPerdaParadasUnidade() {
		return new BigDecimal(perdaParadasUnidade.intValue());
	}
	/**
	 * @param perdaParadasUnidade the perdaParadasUnidade to set
	 */
	public void setPerdaParadasUnidade(BigDecimal perdaParadasUnidade) {
		this.perdaParadasUnidade = perdaParadasUnidade;
	}
	/**
	 * @return the perdaCicloUnidade
	 */
	public BigDecimal getPerdaCicloUnidade() {
		return perdaCicloUnidade.divide(new BigDecimal(1), 14, BigDecimal.ROUND_HALF_EVEN);
	}
	/**
	 * @param perdaCicloUnidade the perdaCicloUnidade to set
	 */
	public void setPerdaCicloUnidade(BigDecimal perdaCicloUnidade) {
		this.perdaCicloUnidade = perdaCicloUnidade;
	}
	/**
	 * @return the perdaTotalUnidade
	 */
	public BigDecimal getPerdaTotalUnidade() {
		return getPerdaCicloUnidade().
		add(getPerdaParadasUnidade()).
		add(getProducaoRefugadaUnidade()).
		add(getPerdaCavidadeUnidade());
	}
	
	public BigDecimal getPerdaTotalTempoSegundos(){
		return getTempoPerdaCavidadeSegundos().
		add(getTempoPerdaCicloSegundos()).
		add(getTempoRefugoSegundos()).
		add(getTempoParadaSegundos());
	}
	
	public Float getPerdaTotalTempoHorasFormatado(){
		return FormulasInjet.formatarCasaDecimalDoFloat(getPerdaTotalTempoSegundos().floatValue() / 3600f);
	}
	public Float getPerdaTotalTempoHoras(){
		return (getPerdaTotalTempoSegundos().floatValue() / 3600f);
	}
	/**
	 * @return the perdaParadasKq
	 */
	public BigDecimal getPerdaParadasKq() {
		return perdaParadasKg;
	}
	/**
	 * @param perdaParadasKq the perdaParadasKq to set
	 */
	public void setPerdaParadasKq(BigDecimal perdaParadasKq) {
		this.perdaParadasKg = perdaParadasKq;
	}
	/**
	 * @return the perdaCicloKq
	 */
	public BigDecimal getPerdaCicloKg() {
		return perdaCicloKg;
	}
	/**
	 * @param perdaCicloKq the perdaCicloKq to set
	 */
	public void setPerdaCicloKq(BigDecimal perdaCicloKq) {
		this.perdaCicloKg = perdaCicloKq;
	}
	/**
	 * @return the perdaTotalKq
	 */
	public BigDecimal getPerdaTotalKg() {
		return perdaCicloKg.add(perdaParadasKg).add(producaoRefugadaKg).add(perdaCicloKg);
	}
	
	public BigDecimal getPerdaTotalCusto(){
		return perdaCicloCusto.add(perdaParadaCusto).add(producaoRefugadaCusto).add(perdaCicloCusto);
	}
	/**
	 * @return the producaoPrevistaUnidade
	 */
	public BigDecimal getProducaoPrevistaUnidade() {
		return new BigDecimal(producaoPrevistaUnidade.intValue());
	}
	/**
	 * @param producaoPrevistaUnidade the producaoPrevistaUnidade to set
	 */
	public void setProducaoPrevistaUnidade(BigDecimal producaoPrevistaUnidade) {
		this.producaoPrevistaUnidade = producaoPrevistaUnidade;
	}
	/**
	 * @return the producaoBrutaUnidade
	 */
	public BigDecimal getProducaoBrutaUnidade() {
		return producaoBrutaUnidade;
	}
	/**
	 * @param producaoBrutaUnidade the producaoBrutaUnidade to set
	 */
	public void setProducaoBrutaUnidade(BigDecimal producaoBrutaUnidade) {
		this.producaoBrutaUnidade = producaoBrutaUnidade;
	}
	/**
	 * @return the producaoLiquidaUnidade
	 */
	public BigDecimal getProducaoLiquidaUnidade() {
		return producaoLiquidaUnidade;
	}
	public BigDecimal getProducaoLiquidaDuzia() {
		return getProducaoLiquidaUnidade().divide(new BigDecimal(12), 2, BigDecimal.ROUND_HALF_EVEN);
	}

	/**
	 * @param producaoLiquidaUnidade the producaoLiquidaUnidade to set
	 */
	public void setProducaoLiquidaUnidade(BigDecimal producaoLiquidaUnidade) {
		this.producaoLiquidaUnidade = producaoLiquidaUnidade;
	}
	/**
	 * @return the producaoRefugadaUnidade
	 */
	public BigDecimal getProducaoRefugadaUnidade() {
		return producaoRefugadaUnidade;
	}
	/**
	 * @param producaoRefugadaUnidade the producaoRefugadaUnidade to set
	 */
	public void setProducaoRefugadaUnidade(BigDecimal producaoRefugadaUnidade) {
		this.producaoRefugadaUnidade = producaoRefugadaUnidade;
	}
	/**
	 * @return the producaoPrevistaKg
	 */
	public BigDecimal getProducaoPrevistaKg() {
		return producaoPrevistaKg;
	}
	/**
	 * @param producaoPrevistaKg the producaoPrevistaKg to set
	 */
	public void setProducaoPrevistaKg(BigDecimal producaoPrevistaKg) {
		this.producaoPrevistaKg = producaoPrevistaKg;
	}
	/**
	 * @return the producaoBrutaKg
	 */
	public BigDecimal getProducaoBrutaKg() {
		return producaoBrutaKg;
	}
	/**
	 * @param producaoBrutaKg the producaoBrutaKg to set
	 */
	public void setProducaoBrutaKg(BigDecimal producaoBrutaKg) {
		this.producaoBrutaKg = producaoBrutaKg;
	}
	/**
	 * @return the producaoLiquidaKg
	 */
	public BigDecimal getProducaoLiquidaKg() {
		return producaoLiquidaKg;
	}
	/**
	 * @param producaoLiquidaKg the producaoLiquidaKg to set
	 */
	public void setProducaoLiquidaKg(BigDecimal producaoLiquidaKg) {
		this.producaoLiquidaKg = producaoLiquidaKg;
	}
	/**
	 * @return the producaoRefugadaKg
	 */
	public BigDecimal getProducaoRefugadaKg() {
		return producaoRefugadaKg;
	}
	/**
	 * @param producaoRefugadaKg the producaoRefugadaKg to set
	 */
	public void setProducaoRefugadaKg(BigDecimal producaoRefugadaKg) {
		this.producaoRefugadaKg = producaoRefugadaKg;
	}
	/**
	 * @return the indiceParada
	 */
	public Float getIndiceParada() {
		return FormulasInjet.calcularIndiceParada(this.tempoParadaSegundos, this.tempoAtivoSegundos).floatValue();
	}
	/**
	 * @param indiceParada the indiceParada to set
	 */
	public void setIndiceParada(Float indiceParada) {
		this.indiceParada = indiceParada;
	}
	/**
	 * @return the indiceRefugo
	 */
	public Float getIndiceRefugo() {
		return FormulasInjet.calcularIndiceRefugo(producaoRefugadaUnidade, producaoBrutaUnidade);
	}
	/**
	 * @param indiceRefugo the indiceRefugo to set
	 */
	public void setIndiceRefugo(Float indiceRefugo) {
		this.indiceRefugo = indiceRefugo;
	}
	/**
	 * @return the indiceCavidadeAtiva
	 */
	public Float getIndiceCavidadeAtiva() {
		return indiceCavidadeAtiva;
	}
	/**
	 * @param indiceCavidadeAtiva the indiceCavidadeAtiva to set
	 */
	public void setIndiceCavidadeAtiva(Float indiceCavidadeAtiva) {
		this.indiceCavidadeAtiva = indiceCavidadeAtiva;
	}
	/**
	 * @return the eficienciaRealizacao
	 */
	public Float getEficienciaRealizacao() {
		return FormulasInjet.calcularEficienciaRealizacao(getProducaoLiquidaUnidade(), getProducaoPrevistaUnidade()).floatValue();
	}
	/**
	 * @param eficienciaRealizacao the eficienciaRealizacao to set
	 */
	public void setEficienciaRealizacao(Float eficienciaRealizacao) {
		this.eficienciaRealizacao = eficienciaRealizacao;
	}
	/**
	 * @return the eficienciaCiclo
	 */
	public Float getEficienciaCiclo() {
		return FormulasInjet.calcularEficienciaCiclo(getCicloPadrao(), getCicloMedio());
	}
	/**
	 * @param eficienciaCiclo the eficienciaCiclo to set
	 */
	public void setEficienciaCiclo(Float eficienciaCiclo) {
		this.eficienciaCiclo = eficienciaCiclo;
	}
	/**
	 * @return the indicePerda
	 */
	public Float getIndicePerda() {
		Float retorno = FormulasInjet.calcularIndicePerda(getPerdaTotalUnidade(), getProducaoPrevistaUnidade());
		if (retorno < 0)
			retorno = 0f;
		return retorno;
	}
	/**
	 * @param indicePerda the indicePerda to set
	 */
	public void setIndicePerda(Float indicePerda) {
		this.indicePerda = indicePerda;
	}
	/**
	 * @return the eficienciaCicloPonderada
	 */
	public Float getEficienciaCicloPonderada() {
		return eficienciaCicloPonderada;
	}
	/**
	 * @param eficienciaCicloPonderada the eficienciaCicloPonderada to set
	 */
	public void setEficienciaCicloPonderada(Float eficienciaCicloPonderada) {
		this.eficienciaCicloPonderada = eficienciaCicloPonderada;
	}
	/**
	 * @return the utilizacao
	 */
	public Float getUtilizacao() {
		Float retorno;
		try {
			retorno =  FormulasInjet.formatarCasaDecimalDoFloat(utilizacao);
		} catch (NumberFormatException e){
			retorno = 0f;
		}
		return retorno;
	}
	/**
	 * @param utilizacao the utilizacao to set
	 */
	public void setUtilizacao(Float utilizacao) {
		this.utilizacao = utilizacao;
	}
	/**
	 * @return the eficiencia
	 */
	public Float getEficienciaFormatada() {
		return FormulasInjet.formatarCasaDecimalDoFloat(FormulasInjet.calcularEficiencia(tempoProdutivasSegundos, tempoTrabalhadoSegundos));
	}
	/**
	 * @return the oee
	 */
	public Float getOee() {
		return FormulasInjet.calcularOEE(tempoProdutivasSegundos, tempoDisponiveisSegundos);
	}
	public Float getMTBF() {
		return FormulasInjet.calcularMTBF(tempoAtivoSegundos, qtOcorrenciaParadasMTBFMTTR);
	}
	public Float getMTTR() {
		return FormulasInjet.calcularMTTR(tempoParadasMTTR, qtOcorrenciaParadasMTBFMTTR);
	}
	/**
	 * @return the oeeCapital
	 */
	public Float getOeeCapital() {
		return FormulasInjet.calcularOEECapital(tempoProdutivasSegundos, getTempoTotalSegundos());
	}
	/**
	 * @return the perdaParadasSemPesoKg
	 */
	public BigDecimal getPerdaParadasSemPesoKg() {
		return perdaParadasSemPesoKg;
	}
	/**
	 * @param perdaParadasSemPesoKg the perdaParadasSemPesoKg to set
	 */
	public void setPerdaParadasSemPesoKg(BigDecimal perdaParadasSemPesoKg) {
		this.perdaParadasSemPesoKg = perdaParadasSemPesoKg;
	}
	/**
	 * @return the perdaParadasSemPesoUnidade
	 */
	public BigDecimal getPerdaParadasSemPesoUnidade() {
		return new BigDecimal(perdaParadasSemPesoUnidade.intValue());
	}
	/**
	 * @param perdaParadasSemPesoUnidade the perdaParadasSemPesoUnidade to set
	 */
	public void setPerdaParadasSemPesoUnidade(BigDecimal perdaParadasSemPesoUnidade) {
		this.perdaParadasSemPesoUnidade = perdaParadasSemPesoUnidade;
	}
	/**
	 * @return the perdaParadaCusto
	 */
	public BigDecimal getPerdaParadaCusto() {
		return perdaParadaCusto;
	}
	/**
	 * @param perdaParadaCusto the perdaParadaCusto to set
	 */
	public void setPerdaParadaCusto(BigDecimal perdaParadaCusto) {
		this.perdaParadaCusto = perdaParadaCusto;
	}
	/**
	 * @return the perdaParadaSemPesoCusto
	 */
	public BigDecimal getPerdaParadaSemPesoCusto() {
		return perdaParadaSemPesoCusto;
	}
	/**
	 * @param perdaParadaSemPesoCusto the perdaParadaSemPesoCusto to set
	 */
	public void setPerdaParadaSemPesoCusto(BigDecimal perdaParadaSemPesoCusto) {
		this.perdaParadaSemPesoCusto = perdaParadaSemPesoCusto;
	}
	/**
	 * @return the producaoRefugadaCusto
	 */
	public BigDecimal getProducaoRefugadaCusto() {
		return producaoRefugadaCusto;
	}
	/**
	 * @param producaoRefugadaCusto the producaoRefugadaCusto to set
	 */
	public void setProducaoRefugadaCusto(BigDecimal producaoRefugadaCusto) {
		this.producaoRefugadaCusto = producaoRefugadaCusto;
	}
	/**
	 * @return the perdaCicloCusto
	 */
	public BigDecimal getPerdaCicloCusto() {
		return perdaCicloCusto;
	}
	/**
	 * @param perdaCicloCusto the perdaCicloCusto to set
	 */
	public void setPerdaCicloCusto(BigDecimal perdaCicloCusto) {
		this.perdaCicloCusto = perdaCicloCusto;
	}
	/**
	 * @return the tempoPerdaCavidadeSegundos
	 */
	public BigDecimal getTempoPerdaCavidadeSegundos() {
		return tempoPerdaCavidadeSegundos;
	}
	/**
	 * @param tempoPerdaCavidadeSegundos the tempoPerdaCavidadeSegundos to set
	 */
	public void setTempoPerdaCavidadeSegundos(BigDecimal tempoPerdaCavidadeSegundos) {
		this.tempoPerdaCavidadeSegundos = tempoPerdaCavidadeSegundos;
	}
	/**
	 * @return the perdaCavidadeUnidade
	 */
	public BigDecimal getPerdaCavidadeUnidade() {
		return new BigDecimal(perdaCavidadeUnidade.intValue());
	}
	/**
	 * @param perdaCavidadeUnidade the perdaCavidadeUnidade to set
	 */
	public void setPerdaCavidadeUnidade(BigDecimal perdaCavidadeUnidade) {
		this.perdaCavidadeUnidade = perdaCavidadeUnidade;
	}
	/**
	 * @return the perdaCavidadeKg
	 */
	public BigDecimal getPerdaCavidadeKg() {
		return perdaCavidadeKg;
	}
	/**
	 * @param perdaCavidadeKg the perdaCavidadeKg to set
	 */
	public void setPerdaCavidadeKg(BigDecimal perdaCavidadeKg) {
		this.perdaCavidadeKg = perdaCavidadeKg;
	}
	/**
	 * @return the perdaCavidadeCusto
	 */
	public BigDecimal getPerdaCavidadeCusto() {
		return perdaCavidadeCusto;
	}
	/**
	 * @param perdaCavidadeCusto the perdaCavidadeCusto to set
	 */
	public void setPerdaCavidadeCusto(BigDecimal perdaCavidadeCusto) {
		this.perdaCavidadeCusto = perdaCavidadeCusto;
	}
	/**
	 * @return the tempoParadaSemPesoSegundos
	 */
	public BigDecimal getTempoParadaSemPesoSegundos() {
		return tempoParadaSemPesoSegundos;
	}
	/**
	 * @param tempoParadaSemPesoSegundos the tempoParadaSemPesoSegundos to set
	 */
	public void setTempoParadaSemPesoSegundos(BigDecimal tempoParadaSemPesoSegundos) {
		this.tempoParadaSemPesoSegundos = tempoParadaSemPesoSegundos;
	}
	/**
	 * @return the tempoAtivoFormatado
	 */
	public String getTempoAtivoFormatado() {
		return DataHoraRN.getSegundosFormatadosEmDiasHoras(tempoAtivoSegundos);
	}

	public String getTempoTotalFormatado() {
		return DataHoraRN.getSegundosFormatadosEmDiasHoras(getTempoTotalSegundos());
	}

	/**
	 * @return the tempoParadaFormatado
	 */
	public String getTempoParadaFormatado() {
		return DataHoraRN.getSegundosFormatadosEmDiasHoras(tempoParadaSegundos);
	}
	/**
	 * @return the tempoParadaSemPesoFormatado
	 */
	public String getTempoParadaSemPesoFormatado() {
		return DataHoraRN.getSegundosFormatadosEmDiasHoras(tempoParadaSemPesoSegundos);
	}
	/**
	 * @return the tempoCicloProdutivoFormatado
	 */
	public String getTempoCicloProdutivoFormatado() {
		return DataHoraRN.getSegundosFormatadosEmDiasHoras(tempoCicloProdutivoSegundos);
	}
	public Float getTempoCicloProdutivoHorasFormatado() {
		return FormulasInjet.formatarCasaDecimalDoFloat(getTempoCicloProdutivoSegundos().divide(new BigDecimal(3600), BigDecimal.ROUND_HALF_EVEN).floatValue());
	}
	
	public Float getTempoCicloProdutivoComCTTHorasFormatado() {
		Float retorno = 0f;
		retorno = getTempoCicloProdutivoSegundos().floatValue();
		retorno += getTempoCorrecaoCTT().floatValue();
		
		return FormulasInjet.formatarCasaDecimalDoFloat(new BigDecimal(retorno).divide(new BigDecimal(3600), BigDecimal.ROUND_HALF_EVEN).floatValue());
	}

	/**
	 * @return the tempoCicloImprodutivoFormatado
	 */
	public String getTempoCicloImprodutivoFormatado() {
		return DataHoraRN.getSegundosFormatadosEmDiasHoras(tempoCicloImprodutivoSegundos);
	}

	public BigDecimal getTempoCicloImprodutivoHorasFormatado() {
		return tempoCicloImprodutivoSegundos.divide(new BigDecimal(3600), 5, BigDecimal.ROUND_HALF_EVEN);
	}
/**
	 * @return the tempoCavidadeIsoladasFormatado
	 */
//	public String getTempoCavidadeIsoladasFormatado() {
//		return DataHoraRN.getSegundosFormatadosEmDiasHoras(tempoCavidadeIsoladasSegundos);
//	}
	/**
	 * @return the tempoTrabalhadoFormatado
	 */
	public String getTempoTrabalhadoFormatado() {
		return DataHoraRN.getSegundosFormatadosEmDiasHoras(tempoTrabalhadoSegundos);
	}
	
	public Float getTempoTrabalhadoHorasFormatado(){
		return FormulasInjet.formatarCasaDecimalDoFloat(tempoTrabalhadoSegundos.floatValue() / 3600f);
	}
	public Float getTempoTrabalhadoHoras(){
		return (tempoTrabalhadoSegundos.floatValue() / 3600f);
	}
	/**
	 * @return the tempoRefugoFormatado
	 */
	public String getTempoRefugoFormatado() {
		return DataHoraRN.getSegundosFormatadosEmDiasHoras(tempoRefugoSegundos);
	}
	/**
	 * @return the tempoRitmoFormatado
	 */
	public String getTempoRitmoFormatado() {
		return DataHoraRN.getSegundosFormatadosEmDiasHoras(tempoRitmoSegundos);
	}
	
	public Float getTempoRitmoHoras() {
		return tempoRitmoSegundos.floatValue() / 3600f;
	}

	public Float getTempoRitmoHorasFormatado() {
		return FormulasInjet.formatarCasaDecimalDoFloat(getTempoRitmoSegundos().floatValue() / 3600f);
	}

	public Float getTempoRitmoECavidadesHorasFormatado() {
		return FormulasInjet.formatarCasaDecimalDoFloat( (getTempoRitmoSegundos().floatValue() +
				getTempoPerdaCavidadeSegundos().floatValue() ) / 3600f);
	}

	public Float getTempoParadaComPesoHorasFormatado() {
		return FormulasInjet.formatarCasaDecimalDoFloat(getTempoParadaSegundos().floatValue() / 3600f);
	}

	public Float getTempoParadaSemPesoHorasFormatado() {
		return FormulasInjet.formatarCasaDecimalDoFloat(getTempoParadaSemPesoSegundos().floatValue() / 3600f);
	}

	/**
	 * @return the tempoProdutivasFormatado
	 */
	public String getTempoProdutivasFormatado() {
		return DataHoraRN.getSegundosFormatadosEmDiasHoras(tempoProdutivasSegundos);
	}
	/**
	 * @return the tempoDisponiveisFormatado
	 */
	public String getTempoDisponiveisFormatado() {
		return DataHoraRN.getSegundosFormatadosEmDiasHoras(tempoDisponiveisSegundos);
	}
	/**
	 * @return the tempoPerdaCavidadeFormatado
	 */
	public String getTempoPerdaCavidadeFormatado() {
		return DataHoraRN.getSegundosFormatadosEmDiasHoras(tempoPerdaCavidadeSegundos);
	}
	public Float getTempoPerdaCavidadeHorasFormatado() {
		return FormulasInjet.formatarCasaDecimalDoFloat(getTempoPerdaCavidadeSegundos().divide(new BigDecimal(3600), BigDecimal.ROUND_HALF_EVEN).floatValue());
	}
	/**
	 * @return the perdaParadasTn
	 */
	public BigDecimal getPerdaParadasTn() {
		return FuncoesApoioInjet.converteKgParaTn(perdaParadasKg);
	}

	
	public BigDecimal getPerdaParadasSemPesoTn() {
		return FuncoesApoioInjet.converteKgParaTn(perdaParadasSemPesoKg);
	}

	/**
	 * @return the perdaCicloTn
	 */
	public BigDecimal getPerdaCicloTn() {
		return FuncoesApoioInjet.converteKgParaTn(perdaCicloKg);
	}
	/**
	 * @return the perdaCavidadeTn
	 */
	public BigDecimal getPerdaCavidadeTn() {
		return FuncoesApoioInjet.converteKgParaTn(perdaCavidadeKg);
	}
	/**
	 * @return the producaoPrevistaTn
	 */
	public BigDecimal getProducaoPrevistaTn() {
		return FuncoesApoioInjet.converteKgParaTn(producaoPrevistaKg);
	}
	/**
	 * @return the producaoBrutaTn
	 */
	public BigDecimal getProducaoBrutaTn() {
		return FuncoesApoioInjet.converteKgParaTn(producaoBrutaKg);
	}
	/**
	 * @return the producaoLiquidaTn
	 */
	public BigDecimal getProducaoLiquidaTn() {
		return FuncoesApoioInjet.converteKgParaTn(producaoLiquidaKg);
	}
	/**
	 * @return the producaoRefugadaTn
	 */
	public BigDecimal getProducaoRefugadaTn() {
		return FuncoesApoioInjet.converteKgParaTn(producaoRefugadaKg);
	}

	public BigDecimal getPerdaTotalTn() {
		return FuncoesApoioInjet.converteKgParaTn(getPerdaTotalUnidade());
	}
	
	public Float getIndicePerdaParadaSemPeso(){
		return FormulasInjet.calcularIndicePerda(perdaParadasSemPesoUnidade, getProducaoPrevistaUnidade());
	}
	public Float getIndicePerdaParada(){
		return FormulasInjet.calcularIndicePerda(perdaParadasUnidade, getProducaoPrevistaUnidade());
	}
	public Float getIndicePerdaCiclo(){
		return FormulasInjet.calcularIndicePerda(perdaCicloUnidade, producaoPrevistaUnidade);
	}
	public Float getIndicePerdaRefugo(){
		return FormulasInjet.calcularIndicePerda(producaoRefugadaUnidade, getProducaoPrevistaUnidade());
	}
	
	public void calcularFormulasNecessarias(){
		
	}
	/**
	 * @return the cicloMedio
	 */
	public BigDecimal getCicloMedio() {
		Float somaEc = 0f;
		
		BigDecimal retorno = new BigDecimal(0);
		
		int contadorLinhas = 0;
		
		for (EficienciaCicloInjetDTO ec : eficienciaCicloDTOs){
			Float ecDaLinha;
			
			ecDaLinha = FormulasInjet.calcularCicloMedio(ec.getTmpcicnormal(), ec.getQtinjnormal()).floatValue();
			
			somaEc += ecDaLinha;
			
			contadorLinhas++;
		}
		if (contadorLinhas > 0){
			contadorLinhas = 1; // Para nao dividir mais o valor
			retorno = new BigDecimal(FormulasInjet.dividir(
					somaEc,
					(float) contadorLinhas) );
		}
		
		return retorno;
	}
	
	public Float getCicloMedioFormatado() {
		return FormulasInjet.formatarCasaDecimalDoFloat(getCicloMedio().floatValue());
	}

	public Float getUltimoCicloFormatado() {
		return FormulasInjet.formatarCasaDecimalDoFloat(getUltimoCiclo().floatValue());
	}
	/**
	 * @param cicloMedio the cicloMedio to set
	 */
	public void setCicloMedio(BigDecimal cicloMedio) {
		this.cicloMedio = cicloMedio;
	}
	/**
	 * @return the cicloPadrao
	 */
	public BigDecimal getCicloPadrao() {
		Float somaCicloPadrao = 0f;
		int contadorLinhas = 0;
		BigDecimal retorno = new BigDecimal(0);
		
		for (EficienciaCicloInjetDTO ec : eficienciaCicloDTOs){
			somaCicloPadrao += ec.getCicloPadrao().floatValue();
			contadorLinhas++;
		}
		if (contadorLinhas > 0){
			contadorLinhas = 1; // para bloquear a divisao pelo contadorLinha
			retorno = new BigDecimal(FormulasInjet.dividir(somaCicloPadrao, (float) contadorLinhas));
		}
		return retorno;
	}
	/**
	 * @param cicloPadrao the cicloPadrao to set
	 */
	public void setCicloPadrao(BigDecimal cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public BigDecimal getCicloPadraoIndenpendenteCicloMedio(){
		return this.cicloPadrao;
	}
	/**
	 * @return the qtInjNormal
	 */
	public BigDecimal getQtInjNormal() {
		if (qtInjNormal == null)
			return BigDecimal.ZERO;
		
		return qtInjNormal;
	}
	/**
	 * @param qtInjNormal the qtInjNormal to set
	 */
	public void setQtInjNormal(BigDecimal qtInjNormal) {
		this.qtInjNormal = qtInjNormal;
	}
	/**
	 * @return the qtCicloPadraoDiferentes
	 */
	public Integer getQtCicloPadraoDiferentes() {
		return qtCicloPadraoDiferentes;
	}
	/**
	 * @param qtCicloPadraoDiferentes the qtCicloPadraoDiferentes to set
	 */
	public void setQtCicloPadraoDiferentes(Integer qtCicloPadraoDiferentes) {
		this.qtCicloPadraoDiferentes = qtCicloPadraoDiferentes;
	}
	
	public void addMaquinaTotalDTO(MaquinaTotalInjetDTO maquinaTotalDTO){
		this.tempoAtivoSegundos = this.tempoAtivoSegundos.add(maquinaTotalDTO.tempoAtivoSegundos);
		this.tempoParadaSegundos = this.tempoParadaSegundos.add(maquinaTotalDTO.tempoParadaSegundos);
		this.tempoParadaSemPesoSegundos = this.tempoParadaSemPesoSegundos.add(maquinaTotalDTO.tempoParadaSemPesoSegundos);
		this.tempoCicloProdutivoSegundos = this.tempoCicloProdutivoSegundos.add(maquinaTotalDTO.tempoCicloProdutivoSegundos);
		this.tempoCicloImprodutivoSegundos = this.tempoCicloImprodutivoSegundos.add(maquinaTotalDTO.tempoCicloImprodutivoSegundos);
//		this.tempoCavidadeIsoladasSegundos = this.tempoCavidadeIsoladasSegundos.add(maquinaTotalDTO.tempoCavidadeIsoladasSegundos);
		this.tempoTrabalhadoSegundos = this.tempoTrabalhadoSegundos.add(maquinaTotalDTO.tempoTrabalhadoSegundos);
		this.tempoRefugoSegundos = this.tempoRefugoSegundos.add(maquinaTotalDTO.tempoRefugoSegundos);
		this.tempoRitmoSegundos = this.tempoRitmoSegundos.add(maquinaTotalDTO.tempoRitmoSegundos);
		this.tempoProdutivasSegundos = this.tempoProdutivasSegundos.add(maquinaTotalDTO.tempoProdutivasSegundos);
		this.tempoDisponiveisSegundos = this.tempoDisponiveisSegundos.add(maquinaTotalDTO.tempoDisponiveisSegundos);
		
		if (maquinaTotalDTO.tempoPerdaCavidadeSegundos != null)
			this.tempoPerdaCavidadeSegundos = this.tempoPerdaCavidadeSegundos.add(maquinaTotalDTO.tempoPerdaCavidadeSegundos);
		
		this.tempoPerdaCicloSegundos = this.tempoPerdaCicloSegundos.add(maquinaTotalDTO.tempoPerdaCicloSegundos);

		this.pci = this.pci.add(maquinaTotalDTO.pci);

		this.perdaParadaCusto = this.perdaParadaCusto.add(maquinaTotalDTO.perdaParadaCusto);
		this.perdaParadaSemPesoCusto = this.perdaParadaSemPesoCusto.add(maquinaTotalDTO.perdaParadaSemPesoCusto);
		this.producaoRefugadaCusto = this.producaoRefugadaCusto.add(maquinaTotalDTO.producaoRefugadaCusto);
		this.perdaCicloCusto = this.perdaCicloCusto.add(maquinaTotalDTO.perdaCicloCusto);
		
		this.perdaParadasUnidade = this.perdaParadasUnidade.add(maquinaTotalDTO.perdaParadasUnidade);
		this.perdaParadasSemPesoUnidade = this.perdaParadasSemPesoUnidade.add(maquinaTotalDTO.perdaParadasSemPesoUnidade);
		if (maquinaTotalDTO.perdaCicloUnidade != null)
			this.perdaCicloUnidade = this.perdaCicloUnidade.add(maquinaTotalDTO.perdaCicloUnidade);

		this.perdaParadasKg = this.perdaParadasKg.add(maquinaTotalDTO.perdaParadasKg);
		this.perdaParadasSemPesoKg = this.perdaParadasSemPesoKg.add(maquinaTotalDTO.perdaParadasSemPesoKg);
		this.perdaCicloKg = this.perdaCicloKg.add(maquinaTotalDTO.perdaCicloKg);

		this.perdaCavidadeUnidade = this.perdaCavidadeUnidade.add(maquinaTotalDTO.perdaCavidadeUnidade);
		this.perdaCavidadeKg = this.perdaCavidadeKg.add(maquinaTotalDTO.perdaCavidadeKg);
		this.perdaCavidadeCusto = this.perdaCavidadeCusto.add(maquinaTotalDTO.perdaCavidadeCusto);
		
		this.producaoPrevistaUnidade = this.producaoPrevistaUnidade.add(maquinaTotalDTO.producaoPrevistaUnidade);
		this.producaoBrutaUnidade = this.producaoBrutaUnidade.add(maquinaTotalDTO.producaoBrutaUnidade);
		this.producaoLiquidaUnidade = this.producaoLiquidaUnidade.add(maquinaTotalDTO.producaoLiquidaUnidade);
		this.producaoRefugadaUnidade = this.producaoRefugadaUnidade.add(maquinaTotalDTO.producaoRefugadaUnidade);

		this.producaoPrevistaKg = this.producaoPrevistaKg.add(maquinaTotalDTO.producaoPrevistaKg);
		this.producaoBrutaKg = this.producaoBrutaKg.add(maquinaTotalDTO.producaoBrutaKg);
		this.producaoLiquidaKg = this.producaoLiquidaKg.add(maquinaTotalDTO.producaoLiquidaKg);
		this.producaoRefugadaKg = this.producaoRefugadaKg.add(maquinaTotalDTO.producaoRefugadaKg);
		this.cicloMedio = this.cicloMedio.add(maquinaTotalDTO.cicloMedio);
		this.cicloPadrao = this.cicloPadrao.add(maquinaTotalDTO.cicloPadrao);
		this.qtInjNormal = this.qtInjNormal.add(maquinaTotalDTO.qtInjNormal);
		this.qtCicloPadraoDiferentes += maquinaTotalDTO.qtCicloPadraoDiferentes;
		if (maquinaTotalDTO.getTempoCorrecaoCTT() != null)
			this.tempoCorrecaoCTT = this.tempoCorrecaoCTT.add(maquinaTotalDTO.getTempoCorrecaoCTT());
		
		// Adciona dados para a Eficiencia de ciclo
		for (EficienciaCicloInjetDTO ec : maquinaTotalDTO.getEficienciaCicloDTOs()){
			EficienciaCicloInjetDTO ecNova = new EficienciaCicloInjetDTO(ec.getCdInjetora(), ec.getCdMolde(), ec.getCdEstrutura(), ec.getDthrvalcic());
			ecNova.setCicloPadrao(ec.getCicloPadrao());
			ecNova.setQtinjnormal(ec.getQtinjnormal());
			ecNova.setTmpcicnormal(ec.getTmpcicnormal());
			this.addEficienciaCicloDTO(ecNova);
		}
	}
	
	public Float getIndiceTempoCicloProdutivo(){
		Float retorno = 0f;

		if (getTempoTotalSegundos().intValue() > 0){
			retorno = (getTempoDisponiveisSegundos().divide(getTempoTotalSegundos(), BigDecimal.ROUND_HALF_EVEN)).floatValue();
			retorno *= 100f;
		}
		return FormulasInjet.formatarCasaDecimalDoFloat(retorno);
	}

	public Float getIndiceTempoProducaoBruta(){
		Float retorno = 0f;

		if (getTempoTotalSegundos().intValue() > 0){
			retorno = (getTempoTrabalhadoSegundos().divide(getTempoTotalSegundos(),BigDecimal.ROUND_HALF_EVEN)).floatValue();
			retorno *= 100f;
		}
		return FormulasInjet.formatarCasaDecimalDoFloat(retorno);
	}

	public Float getIndiceTempoProducaoLiquida(){
		Float retorno = 0f;

		if (getTempoTotalSegundos().intValue() > 0){
			retorno = (getTempoBoasSegundos().divide(getTempoTotalSegundos(), BigDecimal.ROUND_HALF_EVEN)).floatValue();
			retorno *= 100f;
		}
		return FormulasInjet.formatarCasaDecimalDoFloat(retorno);
	}

	public Float getIndiceTempoRefugo(){
		Float retorno = 0f;

		if (getTempoTrabalhadoSegundos().intValue() > 0){
			retorno = (getTempoRefugoSegundos().divide(getTempoTrabalhadoSegundos(), BigDecimal.ROUND_HALF_EVEN)).floatValue();
			retorno *= 100f;
		}
		return FormulasInjet.formatarCasaDecimalDoFloat(retorno);
	}
	/**
	 * @return the tempoPrevistoCicloSegundos
	 */
	public BigDecimal getTempoPrevistoCicloSegundos() {
		return tempoPrevistoCicloSegundos;
	}

	public Float getTempoPrevistoCicloHorasFormatado() {
		return FormulasInjet.formatarCasaDecimalDoFloat(tempoPrevistoCicloSegundos.floatValue());
	}

	/**
	 * @param tempoPrevistoCicloSegundos the tempoPrevistoCicloSegundos to set
	 */
	public void setTempoPrevistoCicloSegundos(BigDecimal tempoPrevistoCicloSegundos) {
		this.tempoPrevistoCicloSegundos = tempoPrevistoCicloSegundos;
	}
	/**
	 * @return the producaoPrevistaHoraria
	 */
	public BigDecimal getProducaoPrevistaHoraria() {
		return producaoPrevistaHoraria;
	}
	/**
	 * @param producaoPrevistaHoraria the producaoPrevistaHoraria to set
	 */
	public void setProducaoPrevistaHoraria(BigDecimal producaoPrevistaHoraria) {
		this.producaoPrevistaHoraria = producaoPrevistaHoraria;
	}
	/**
	 * @return the tempoPerdaCicloSegundos
	 */
	public BigDecimal getTempoPerdaCicloSegundos() {
		return tempoPerdaCicloSegundos;
	}
	public Float getTempoPerdaCicloHorasFormatado() {
		return FormulasInjet.formatarCasaDecimalDoFloat(tempoPerdaCicloSegundos.floatValue()/3600f);
	}
	/**
	 * @param tempoPerdaCicloSegundos the tempoPerdaCicloSegundos to set
	 */
	public void setTempoPerdaCicloSegundos(BigDecimal tempoPerdaCicloSegundos) {
		this.tempoPerdaCicloSegundos = tempoPerdaCicloSegundos;
	}
	/**
	 * @return the eficienciaCicloDTOs
	 */
	public List<EficienciaCicloInjetDTO> getEficienciaCicloDTOs() {
		return eficienciaCicloDTOs;
	}
	/**
	 * @param eficienciaCicloDTOs the eficienciaCicloDTOs to set
	 */
	public void setEficienciaCicloDTOs(List<EficienciaCicloInjetDTO> eficienciaCicloDTOs) {
		this.eficienciaCicloDTOs = eficienciaCicloDTOs;
	}
	public BigDecimal getTempoCorrecaoCTT() {
		return tempoCorrecaoCTT;
	}
	public Float getTempoCorrecaoCTTHorasFormatado() {
		return FormulasInjet.formatarCasaDecimalDoFloat(getTempoCorrecaoCTT().floatValue() / 3600f);
	}
	public void setTempoCorrecaoCTT(BigDecimal tempoCorrecaoCTT) {
		this.tempoCorrecaoCTT = tempoCorrecaoCTT;
	}
	public Float getEficienciaUltimoCiclo() {
		return FormulasInjet.calcularEficienciaCiclo(getCicloPadrao(), getUltimoCiclo());
	}
	public void setEficienciaUltimoCiclo(Float eficienciaUltimoCiclo) {
		this.eficienciaUltimoCiclo = eficienciaUltimoCiclo;
	}
	public BigDecimal getUltimoCiclo() {
		return ultimoCiclo;
	}
	public void setUltimoCiclo(BigDecimal ultimoCiclo) {
		this.ultimoCiclo = ultimoCiclo;
	}
	public BigDecimal getTempoParadaEmAbertoSegundos() {
		return tempoParadaEmAbertoSegundos;
	}
	public void setTempoParadaEmAbertoSegundos(
			BigDecimal tempoParadaEmAbertoSegundos) {
		this.tempoParadaEmAbertoSegundos = tempoParadaEmAbertoSegundos;
	}
	public BigDecimal getSaldoAProduzirUnidadesConsiderandoProducaoPrevista(){
		return getProducaoPrevistaUnidade().subtract(getProducaoLiquidaUnidade());
	}
	public Integer getQtOcorrenciaParadasMTBFMTTR() {
		return qtOcorrenciaParadasMTBFMTTR;
	}
	public void setQtOcorrenciaParadasMTBFMTTR(Integer qtOcorrenciaParadas) {
		this.qtOcorrenciaParadasMTBFMTTR = qtOcorrenciaParadas;
	}
	public BigDecimal getTempoParadasMTTR() {
		return tempoParadasMTTR;
	}
	public void setTempoParadasMTTR(BigDecimal tempoParadasMTTR) {
		this.tempoParadasMTTR = tempoParadasMTTR;
	}
	public BigDecimal getQtCiclosPrevistos() {
		return qtCiclosPrevistos;
	}
	public void setQtCiclosPrevistos(BigDecimal qtCiclosPrevistos) {
		this.qtCiclosPrevistos = qtCiclosPrevistos;
	}	
}
