package idw.model.rn.injet.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import idw.model.pojos.injet.Ijtbtur;
import idw.util.FormulasInjet;

@SuppressWarnings("serial")
public class AnalisePeriodoInjetDTO implements Serializable{

	private List<IndicadoresPorDataInjetDTO> indicadoresPorData = new ArrayList<IndicadoresPorDataInjetDTO>();
	private List<IndicadoresPorTurnoInjetDTO> indicadoresPorTurno = new ArrayList<IndicadoresPorTurnoInjetDTO>();
	private List<MaquinaInjetDTO> indicadoresPorMaquina = new ArrayList<MaquinaInjetDTO>();
	private RodapeAnalisePeriodoInjetDTO rodape;

	public Float getEficienciaCicloPonderada(){
		Float retorno = 0f;
		// Monta um vetor com DadosParaECPonderada de todas as maquinas do vetor indicadoresPorMaquina
		List<DadosParaECPonderadaInjetDTO> dadosEC = new ArrayList<DadosParaECPonderadaInjetDTO>();
		for (MaquinaInjetDTO maquina : indicadoresPorMaquina){
			for (DadosParaECPonderadaInjetDTO dadosECMaquina : maquina.getDadosECPonderada()){
				boolean isMoldeEstruturaJaExiste = false;
				for (DadosParaECPonderadaInjetDTO dados : dadosEC){
					if (dados.equals(dadosECMaquina)){
						isMoldeEstruturaJaExiste = true;
						dados.addCicloPadrao(dadosECMaquina.getCicloPadrao());
						dados.setQtCicloPadrao(dados.getQtCicloPadrao() + dadosECMaquina.getQtCicloPadrao());
						dados.addQtInjNormal(dadosECMaquina.getQtInjNormal());
						dados.addTempoAtivo(dadosECMaquina.getTempoAtivo());
						dados.addTmpCicNormal(dadosECMaquina.getTmpCicNormal());
					}
				}
				if (isMoldeEstruturaJaExiste == false){
					dadosEC.add(dadosECMaquina);
				}
			}
		}

		// Ordena o vetor por molde, estrutura e maquina
		Collections.sort(dadosEC, new Comparator<Object>(){
			public int compare(Object o1, Object o2) {
				int retorno = 0;

				DadosParaECPonderadaInjetDTO dadosUm = (DadosParaECPonderadaInjetDTO) o1;
				DadosParaECPonderadaInjetDTO dadosDois = (DadosParaECPonderadaInjetDTO) o2;

				if (!dadosUm.getCdMolde().equals(dadosDois.getCdMolde())){
					retorno = dadosUm.getCdMolde().compareToIgnoreCase(dadosDois.getCdMolde());
				}else{
					if (!dadosUm.getCdEstrutra().equals(dadosDois.getCdEstrutra())){
						retorno = dadosUm.getCdEstrutra().compareToIgnoreCase(dadosDois.getCdEstrutra());
					} else {
						retorno = dadosUm.getCdMaquina().compareToIgnoreCase(dadosDois.getCdMaquina());
					}
				}

				return retorno;
			}
		});

		// calculos finais da eficiencia de ciclo ponderada
		DadosParaECPonderadaInjetDTO dadoAnterior = null;
		Float somaTempoAtivo = 0f;
		Float somaEficienciaCicloVezesTempoAtivo = 0f;
		Float somaTempoAtivoVezesSomaEficienciaCicloVezesTempoAtivo = 0f;
		Integer qtdeMoldes = 1;
		boolean isMoldePendenteDeFechamento = false;

		for (DadosParaECPonderadaInjetDTO dadoCorrente : dadosEC){
			isMoldePendenteDeFechamento = true;

			if (dadoAnterior == null)
				dadoAnterior = dadoCorrente;

			Float cicloMedio = dadoCorrente.getCicloMedio().floatValue();
			Float cicloPadraoMedio = dadoCorrente.getCicloPadrao().floatValue() / dadoCorrente.getQtCicloPadrao();
			Float eficienciaCiclo = FormulasInjet.calcularEficienciaCiclo(new BigDecimal(cicloPadraoMedio), new BigDecimal(cicloMedio));
			Float eficienciaCicloVezesTempoAtivo = eficienciaCiclo * dadoCorrente.getTempoAtivo().floatValue();

			if (dadoCorrente.getCdMolde().equals(dadoAnterior.getCdMolde()) &&
					dadoCorrente.getCdEstrutra().equals(dadoAnterior.getCdEstrutra())){

				somaTempoAtivo += dadoCorrente.getTempoAtivo().floatValue();
				somaEficienciaCicloVezesTempoAtivo += eficienciaCicloVezesTempoAtivo;

			} else {
				Float tempoAtivoVezesSomaEficienciaCicloVezesTempoAtivo = 0f;
				
				if (somaTempoAtivo > 0)
					tempoAtivoVezesSomaEficienciaCicloVezesTempoAtivo = somaEficienciaCicloVezesTempoAtivo / somaTempoAtivo;

				somaTempoAtivoVezesSomaEficienciaCicloVezesTempoAtivo += tempoAtivoVezesSomaEficienciaCicloVezesTempoAtivo;
				somaTempoAtivo = dadoCorrente.getTempoAtivo().floatValue();
				somaEficienciaCicloVezesTempoAtivo = eficienciaCicloVezesTempoAtivo;
				dadoAnterior = dadoCorrente;
				qtdeMoldes++;
			}
		}

		if (isMoldePendenteDeFechamento == true){
			Float tempoAtivoVezesSomaEficienciaCicloVezesTempoAtivo = 0f;
			
			if (somaTempoAtivo > 0)
				tempoAtivoVezesSomaEficienciaCicloVezesTempoAtivo = somaEficienciaCicloVezesTempoAtivo / somaTempoAtivo;

			somaTempoAtivoVezesSomaEficienciaCicloVezesTempoAtivo += tempoAtivoVezesSomaEficienciaCicloVezesTempoAtivo;
		}

		retorno = FormulasInjet.calcularEficienciaCicloPonderada(qtdeMoldes, new BigDecimal(somaTempoAtivoVezesSomaEficienciaCicloVezesTempoAtivo));
		return retorno;
	}
	/**
	 * @return the rodape
	 */
	public RodapeAnalisePeriodoInjetDTO getRodape() {
		return rodape;
	}

	/**
	 * @param rodape the rodape to set
	 */
	public void setRodape(RodapeAnalisePeriodoInjetDTO rodape) {
		this.rodape = rodape;
	}

	/**
	 * @return the indicadoresPorData
	 */
	public List<IndicadoresPorDataInjetDTO> getIndicadoresPorData() {
		return indicadoresPorData;
	}

	/**
	 * @param indicadoresPorData the indicadoresPorData to set
	 */
	public void setIndicadoresPorData(List<IndicadoresPorDataInjetDTO> indicadoresPorData) {
		this.indicadoresPorData = indicadoresPorData;
	}
	public void addIndicadoresPorData(IndicadoresPorDataInjetDTO indicadoresPorData) {
		this.indicadoresPorData.add(indicadoresPorData);
	}

	public void addIndicadoresPorMaquina(MaquinaInjetDTO pMaquina) {
		boolean isMaquinaCadastrada = false;
		// Procura se a maquina ja esta no cadastro. Se estiver, somar os valores
		for (MaquinaInjetDTO maquina : this.indicadoresPorMaquina){
			if (maquina.equals(pMaquina)){
				isMaquinaCadastrada = true;
				maquina.addMaquinaDTO(pMaquina);
			}
		}
		if (isMaquinaCadastrada == false)
			this.indicadoresPorMaquina.add(pMaquina);
	}

	/**
	 * @return the indicadoresPorMaquina
	 */
	public List<MaquinaInjetDTO> getIndicadoresPorMaquina() {
		return indicadoresPorMaquina;
	}

	/**
	 * @param indicadoresPorMaquina the indicadoresPorMaquina to set
	 */
	public void setIndicadoresPorMaquina(List<MaquinaInjetDTO> indicadoresPorMaquina) {
		this.indicadoresPorMaquina = indicadoresPorMaquina;
	}

	/**
	 * @return the indicadoresPorTurno
	 */
	public List<IndicadoresPorTurnoInjetDTO> getIndicadoresPorTurno() {
		return indicadoresPorTurno;
	}

	/**
	 * @param indicadoresPorTurno the indicadoresPorTurno to set
	 */
	public void setIndicadoresPorTurno(
			List<IndicadoresPorTurnoInjetDTO> indicadoresPorTurno) {
		this.indicadoresPorTurno = indicadoresPorTurno;
	}

	public void addIndicadoresPorTurno(Ijtbtur ijtbtur, MaquinaInjetDTO maquina) {
		boolean isTurnoCadastrado = false;
		IndicadoresPorTurnoInjetDTO indicadorCadastrado = new IndicadoresPorTurnoInjetDTO();
		// Procura se o turno ja foi anteriormente incluido
		for (IndicadoresPorTurnoInjetDTO indicador : this.indicadoresPorTurno){
			if (ijtbtur.getCdturno().equals(indicador.getCdTurno())){
				isTurnoCadastrado = true;
				indicadorCadastrado = indicador;
			}
		}
		indicadorCadastrado.addMaquinaTotalDTO(maquina.getMaquinaTotalDTO());

		if (isTurnoCadastrado == false){
			indicadorCadastrado.setCdTurno(ijtbtur.getCdturno());
			indicadorCadastrado.setDsTurno(ijtbtur.getDsturno());
			this.indicadoresPorTurno.add(indicadorCadastrado);
		}

	}
}
