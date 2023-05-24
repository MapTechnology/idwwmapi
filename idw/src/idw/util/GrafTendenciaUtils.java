package idw.util;

import java.awt.Color;
import java.awt.Paint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.sun.xml.xsom.impl.scd.Iterators.Map;

import idw.model.IdwFacade;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.OcorrenciasEvtDTO;

public class GrafTendenciaUtils {

	public static final Paint COR_INTERVALO_VERDE = Color.green;
	public static final Paint COR_INTERVALO_AMARELO = Color.yellow;
	public static final Paint COR_INTERVALO_LARANJA = Color.orange;
	public static final Paint COR_INTERVALO_VERMELHO = Color.red;

	private static final Double PERC_INTERVALO_VERMELHO_LARANJA_INICIAL = 70d;
	private static final Double PERC_INTERVALO_AMARELO_INICIAL = 30d;
	private static final Double PERC_INTERVALO_AMARELO_FINAL = 70d;
	private static final Double PERC_INTERVALO_VERDE_FINAL = 30d;

	private Date dtHrIniIntervalo;
	private Date dtHrFimIntervalo;
	private int duracaoIntervalo = 0;

	public static final int SERIE_VERDE = 0;
	public static final int SERIE_AMARELA = 1;
	public static final int SERIE_LARANJA = 2;
	public static final int SERIE_VERMELHA = 3;

	private List<IntervaloGrafTendenciaRefugoParada> intervaloGrafTend = new ArrayList<IntervaloGrafTendenciaRefugoParada>();

	public GrafTendenciaUtils(Date dthrIniPeriodo, Date dthrFimPeriodo) {
		IntervaloGrafTendenciaRefugoParada intervalo = null;

		// intervalo 1 - cor verde
		intervalo = new IntervaloGrafTendenciaRefugoParada();
		intervalo.setSerie(SERIE_VERDE);
		intervalo.setCorIntervalo(COR_INTERVALO_VERDE);
		intervalo.setPercIntFinal(PERC_INTERVALO_VERDE_FINAL);
		intervalo.setOperadorFinal("<");
		intervaloGrafTend.add(intervalo);

		// intervalo 2 - cor amarela
		intervalo = new IntervaloGrafTendenciaRefugoParada();
		intervalo.setSerie(SERIE_AMARELA);
		intervalo.setCorIntervalo(COR_INTERVALO_AMARELO);
		intervalo.setPercIntInicial(PERC_INTERVALO_AMARELO_INICIAL);
		intervalo.setPercIntFinal(PERC_INTERVALO_AMARELO_FINAL);
		intervalo.setOperadorInicial(">=");
		intervalo.setOperadorFinal("<");
		intervaloGrafTend.add(intervalo);

		// intervalo 3 - laranja (tendencia de queda)
		intervalo = new IntervaloGrafTendenciaRefugoParada();
		intervalo.setSerie(SERIE_LARANJA);
		intervalo.setCorIntervalo(COR_INTERVALO_LARANJA);
		intervalo.setPercIntInicial(PERC_INTERVALO_VERMELHO_LARANJA_INICIAL);
		intervalo.setOperadorInicial(">=");
		intervaloGrafTend.add(intervalo);

		// intervalo 4 - vermelho (tendencia de alta)
		intervalo = new IntervaloGrafTendenciaRefugoParada();
		intervalo.setSerie(SERIE_VERMELHA);
		intervalo.setCorIntervalo(COR_INTERVALO_VERMELHO);
		intervalo.setPercIntInicial(PERC_INTERVALO_VERMELHO_LARANJA_INICIAL);
		intervalo.setOperadorInicial(">=");
		intervaloGrafTend.add(intervalo);

		// encontra intervalos - laranja e vermelho (tendencia de queda e
		// tendencia de alta)
		intervaloTempoCorBarraTendencia(dthrIniPeriodo, dthrFimPeriodo, PERC_INTERVALO_VERMELHO_LARANJA_INICIAL);
		intervaloGrafTend.get(SERIE_LARANJA).setIntervaloDtHrIni(dtHrIniIntervalo);
		intervaloGrafTend.get(SERIE_LARANJA).setIntervaloDtHrFim(dtHrFimIntervalo);
		intervaloGrafTend.get(SERIE_VERMELHA).setIntervaloDtHrIni(dtHrIniIntervalo);
		intervaloGrafTend.get(SERIE_VERMELHA).setIntervaloDtHrFim(dtHrFimIntervalo);

		duracaoIntervalo = DataHoraRN.getQuantidadeSegundosNoPeriodo(
				intervaloGrafTend.get(SERIE_LARANJA).getIntervaloDtHrIni(),
				intervaloGrafTend.get(SERIE_LARANJA).getIntervaloDtHrFim());
		intervaloGrafTend.get(SERIE_LARANJA).setDuracaoIntervalo(duracaoIntervalo);

		duracaoIntervalo = DataHoraRN.getQuantidadeSegundosNoPeriodo(
				intervaloGrafTend.get(SERIE_VERMELHA).getIntervaloDtHrIni(),
				intervaloGrafTend.get(SERIE_VERMELHA).getIntervaloDtHrFim());
		intervaloGrafTend.get(SERIE_VERMELHA).setDuracaoIntervalo(duracaoIntervalo);

		// encontra intervalo amarelo
		intervaloTempoCorBarraTendencia(dthrIniPeriodo, dthrFimPeriodo, PERC_INTERVALO_AMARELO_INICIAL);
		intervaloGrafTend.get(SERIE_AMARELA).setIntervaloDtHrIni(dtHrIniIntervalo);
		intervaloGrafTend.get(SERIE_AMARELA).setIntervaloDtHrFim(dtHrFimIntervalo);

		if (DataHoraRN.compareTo(intervaloGrafTend.get(SERIE_AMARELA).getIntervaloDtHrFim(),
				intervaloGrafTend.get(SERIE_VERMELHA).getIntervaloDtHrFim()) == 0) {
			intervaloGrafTend.get(SERIE_AMARELA).setIntervaloDtHrFim(intervaloGrafTend.get(SERIE_VERMELHA).getIntervaloDtHrIni());
		}
		duracaoIntervalo = DataHoraRN.getQuantidadeSegundosNoPeriodo(
				intervaloGrafTend.get(SERIE_AMARELA).getIntervaloDtHrIni(),
				intervaloGrafTend.get(SERIE_AMARELA).getIntervaloDtHrFim());
		intervaloGrafTend.get(SERIE_AMARELA).setDuracaoIntervalo(duracaoIntervalo);

		// encontra intervalo verde
		intervaloTempoCorBarraTendencia(dthrIniPeriodo, dthrFimPeriodo, 0d);
		intervaloGrafTend.get(SERIE_VERDE)
				.setIntervaloDtHrIni(dtHrIniIntervalo);
		intervaloGrafTend.get(SERIE_VERDE)
				.setIntervaloDtHrFim(dtHrFimIntervalo);

		if (DataHoraRN.compareTo(intervaloGrafTend.get(SERIE_VERDE).getIntervaloDtHrFim(),
				intervaloGrafTend.get(SERIE_VERMELHA).getIntervaloDtHrFim()) == 0) {
			intervaloGrafTend.get(SERIE_VERDE).setIntervaloDtHrFim(intervaloGrafTend.get(SERIE_AMARELA).getIntervaloDtHrIni());
		}
		duracaoIntervalo = DataHoraRN.getQuantidadeSegundosNoPeriodo(
				intervaloGrafTend.get(SERIE_VERDE).getIntervaloDtHrIni(),
				intervaloGrafTend.get(SERIE_VERDE).getIntervaloDtHrFim());
		intervaloGrafTend.get(SERIE_VERDE).setDuracaoIntervalo(duracaoIntervalo);

		if (IdwFacade.IS_IDW_ATIVO == false) {
			intervaloGrafTend.get(SERIE_AMARELA)
					.setIntervaloDtHrIni(DataHoraRN.adicionaSegundosNaData(intervaloGrafTend.get(SERIE_AMARELA).getIntervaloDtHrIni(), 1));
			intervaloGrafTend.get(SERIE_LARANJA)
					.setIntervaloDtHrIni(DataHoraRN.adicionaSegundosNaData(intervaloGrafTend.get(SERIE_LARANJA).getIntervaloDtHrIni(), 1));
			intervaloGrafTend.get(SERIE_VERMELHA)
					.setIntervaloDtHrIni(DataHoraRN.adicionaSegundosNaData(intervaloGrafTend.get(SERIE_VERMELHA).getIntervaloDtHrIni(), 1));
		}

	}

	private void intervaloTempoCorBarraTendencia(Date dtHrInicio, Date dtHrFim, Double percentual) {
		int totalSegundos = 0;
		int segundosSomar = 0;

		/*
		 * Cálculo feito em cima do 'tempo corrido' N�o precisa somar 1 segundo no total porque esse segundo já entra na soma (DateAdd)
		 */
		totalSegundos = DataHoraRN.getQuantidadeSegundosNoPeriodo(dtHrInicio, dtHrFim);
		segundosSomar = (int) (totalSegundos * percentual) / 100;
		dtHrIniIntervalo = DataHoraRN.adicionaSegundosNaData(dtHrInicio, segundosSomar);
		dtHrFimIntervalo = dtHrFim;

		/*
		 * É necessário somar 1 segundo para o caso de O FIM DA PARADA SER MAIOR QUE O INTERVALO CONSIDERADO, pois nesse caso o fim é
		 * preenchido com o fim do intervalo mais 1 segundo.
		 */
		dtHrFimIntervalo = DataHoraRN.adicionaSegundosNaData(dtHrFimIntervalo, 1);
	}

	public Paint corBarraTendencia(Long idEvt, List<OcorrenciasEvtDTO> listaOcorr) {
		Paint retorno = COR_INTERVALO_VERDE;

		Long segOcorVermelho = 0l;
		Double proporcaoIntervaloVermelho = 0d;

		Long segOcorAmarelo = 0l;
		Double proporcaoIntervaloAmarelo = 0d;

		boolean ocorreuEmZonaVermelha = false;
		boolean ocorreuEmZonaAmarela = false;

		int compareDtIni, compareDtFim;

		// verifica se evento ocorreu em VERMELHO
		ocorreuEmZonaVermelha = false;

		if (IdwFacade.IS_IDW_ATIVO == true) {
			for (OcorrenciasEvtDTO ocorr : listaOcorr) {
				if (idEvt.longValue() == ocorr.getIdEvt().longValue()) {
					// ocorrencias em vermelho (>= e <=)
					Date fim = ocorr.getDthrFim();
					if (fim == null)
						fim = ocorr.getDthrIni();
					compareDtIni = DataHoraRN.compareTo(fim, getIntervaloGrafTend().get(SERIE_VERMELHA).getIntervaloDtHrIni());
					compareDtFim = DataHoraRN.compareTo(fim, getIntervaloGrafTend().get(SERIE_VERMELHA).getIntervaloDtHrFim());
					// data/hora entre o período (maior ou igual) e (menor ou igual)
					if ((compareDtIni > 0 || compareDtIni == 0) && (compareDtFim < 0 || compareDtFim == 0)) {
						ocorreuEmZonaVermelha = true;
					}
				}
			}

			if (ocorreuEmZonaVermelha) {
				for (OcorrenciasEvtDTO ocorr : listaOcorr) {
					if (idEvt.longValue() == ocorr.getIdEvt().longValue()) {
						// ocorrencias em vermelho (>= e <=)
						Date fim = ocorr.getDthrFim();
						if (fim == null)
							fim = ocorr.getDthrIni();
						compareDtIni = DataHoraRN.compareTo(fim, getIntervaloGrafTend().get(SERIE_VERMELHA).getIntervaloDtHrIni());
						compareDtFim = DataHoraRN.compareTo(fim, getIntervaloGrafTend().get(SERIE_VERMELHA).getIntervaloDtHrFim());
						// data/hora entre o período (maior ou igual) e (menor ou
						// igual)
						if ((compareDtIni > 0 || compareDtIni == 0) && (compareDtFim < 0 || compareDtFim == 0)) {
							segOcorVermelho = segOcorVermelho + ocorr.getDuracaoEvt().longValue();
						}

						// ocorrencias em amarelo (>= e <)
						compareDtIni = DataHoraRN.compareTo(fim, getIntervaloGrafTend().get(SERIE_AMARELA).getIntervaloDtHrIni());
						compareDtFim = DataHoraRN.compareTo(fim, getIntervaloGrafTend().get(SERIE_AMARELA).getIntervaloDtHrFim());
						// data/hora entre o período (maior ou igual) e (menor ou
						// igual)
						if ((compareDtIni > 0 || compareDtIni == 0) && (compareDtFim < 0)) {
							segOcorAmarelo = segOcorAmarelo + ocorr.getDuracaoEvt().longValue();
						}
					}
				}

				// proporções de tempo
				proporcaoIntervaloVermelho =
						segOcorVermelho.doubleValue() / getIntervaloGrafTend().get(SERIE_VERMELHA).getDuracaoIntervalo();

				if (getIntervaloGrafTend().get(SERIE_AMARELA).getDuracaoIntervalo() > 0) {
					proporcaoIntervaloAmarelo =
							segOcorAmarelo.doubleValue() / getIntervaloGrafTend().get(SERIE_AMARELA).getDuracaoIntervalo();
				}

				if (proporcaoIntervaloVermelho < proporcaoIntervaloAmarelo) {
					retorno = COR_INTERVALO_LARANJA;
				} else {
					retorno = COR_INTERVALO_VERMELHO;
				}

			} else {
				// verifica se evento ocorreu em AMARELO
				ocorreuEmZonaAmarela = false;
				for (OcorrenciasEvtDTO ocorr : listaOcorr) {
					if (idEvt.longValue() == ocorr.getIdEvt().longValue()) {
						// ocorrencias em amarelo (>= e <)
						Date fim = ocorr.getDthrFim();
						if (fim == null)
							fim = ocorr.getDthrIni();
						compareDtIni = DataHoraRN.compareTo(fim, getIntervaloGrafTend().get(SERIE_AMARELA).getIntervaloDtHrIni());
						compareDtFim = DataHoraRN.compareTo(fim, getIntervaloGrafTend().get(SERIE_AMARELA).getIntervaloDtHrFim());
						// data/hora entre o período (maior ou igual) e (menor ou
						// igual)
						if ((compareDtIni > 0 || compareDtIni == 0) && (compareDtFim < 0)) {
							ocorreuEmZonaAmarela = true;
							break;
						}
					}
				}

				if (ocorreuEmZonaAmarela) {
					retorno = COR_INTERVALO_AMARELO; // troquei de laranja para amarelo
				} else {
					retorno = COR_INTERVALO_VERDE;
				}
			}
		} else {
			BigDecimal qtdZonaVermelha = BigDecimal.ZERO;
			BigDecimal qtdZonaAmarela = BigDecimal.ZERO;
			
			ocorreuEmZonaVermelha = false;
			ocorreuEmZonaAmarela = false;
			
			for (OcorrenciasEvtDTO ocorrT : listaOcorr) {
				if (idEvt.longValue() == ocorrT.getIdEvt().longValue()) {
					compareDtIni = DataHoraRN.compareTo(ocorrT.getDthrIni(), getIntervaloGrafTend().get(SERIE_VERMELHA).getIntervaloDtHrIni());
					if (compareDtIni == 0) {
						ocorreuEmZonaVermelha = true;
						qtdZonaVermelha = ocorrT.getQuantidade();
						break;
					}
				}
			}
			
			for (OcorrenciasEvtDTO ocorrT : listaOcorr) {
				if (idEvt.longValue() == ocorrT.getIdEvt().longValue()) {
					compareDtIni = DataHoraRN.compareTo(ocorrT.getDthrIni(), getIntervaloGrafTend().get(SERIE_AMARELA).getIntervaloDtHrIni());
					if (compareDtIni == 0) {
						ocorreuEmZonaAmarela = true;
						qtdZonaAmarela = ocorrT.getQuantidade();
						break;
					}
				}
			}

			if (ocorreuEmZonaVermelha) {
				if (ocorreuEmZonaAmarela) {
					if (qtdZonaVermelha.doubleValue() >= qtdZonaAmarela.doubleValue()) {
						retorno = COR_INTERVALO_VERMELHO;
					} else {
						retorno = COR_INTERVALO_LARANJA;
					}
				} else {
					retorno = COR_INTERVALO_VERMELHO;
				}
				
			} else {
				if (ocorreuEmZonaAmarela) {
					retorno = COR_INTERVALO_AMARELO; 
				} else {
					retorno = COR_INTERVALO_VERDE; 
				}
			}

		}

		return retorno;
	}

	/**
	 * @return the intervaloGrafTend
	 */
	public List<IntervaloGrafTendenciaRefugoParada> getIntervaloGrafTend() {
		return intervaloGrafTend;
	}

	// Marcos Sardinha: VFWEB - Injet
	public Paint corBarraTendencia(String cdEvt, List<OcorrenciasEvtDTO> listaOcorr) {
		Paint retorno = COR_INTERVALO_VERDE;

		Long segOcorVermelho = 0l;
		Double proporcaoIntervaloVermelho = 0d;

		Long segOcorAmarelo = 0l;
		Double proporcaoIntervaloAmarelo = 0d;

		boolean ocorreuEmZonaVermelha = false;
		boolean ocorreuEmZonaAmarela = false;

		int compareDtIni, compareDtFim;

		// verifica se evento ocorreu em VERMELHO
		ocorreuEmZonaVermelha = false;
		for (OcorrenciasEvtDTO ocorr : listaOcorr) {
			if (cdEvt.equals(ocorr.getDsritmo())) {
				// ocorrencias em vermelho (>= e <=)
				Date fim = ocorr.getDthrFim();
				if (fim == null)
					fim = ocorr.getDthrIni();
				compareDtIni = DataHoraRN.compareTo(fim, getIntervaloGrafTend().get(SERIE_VERMELHA).getIntervaloDtHrIni());
				compareDtFim = DataHoraRN.compareTo(fim, getIntervaloGrafTend().get(SERIE_VERMELHA).getIntervaloDtHrFim());
				// data/hora entre o período (maior ou igual) e (menor ou igual)
				if ((compareDtIni > 0 || compareDtIni == 0) && (compareDtFim < 0 || compareDtFim == 0)) {
					ocorreuEmZonaVermelha = true;
					break;
				}
			}
		}

		if (ocorreuEmZonaVermelha) {
			for (OcorrenciasEvtDTO ocorr : listaOcorr) {
				if (cdEvt.equals(ocorr.getDsritmo())) {
					// ocorrencias em vermelho (>= e <=)
					Date fim = ocorr.getDthrFim();
					if (fim == null)
						fim = ocorr.getDthrIni();
					compareDtIni = DataHoraRN.compareTo(fim, getIntervaloGrafTend().get(SERIE_VERMELHA).getIntervaloDtHrIni());
					compareDtFim = DataHoraRN.compareTo(fim, getIntervaloGrafTend().get(SERIE_VERMELHA).getIntervaloDtHrFim());
					// data/hora entre o período (maior ou igual) e (menor ou
					// igual)
					if ((compareDtIni > 0 || compareDtIni == 0) && (compareDtFim < 0 || compareDtFim == 0)) {
						segOcorVermelho = segOcorVermelho + ocorr.getDuracaoEvt().longValue();
					}

					// ocorrencias em amarelo (>= e <)
					compareDtIni = DataHoraRN.compareTo(fim, getIntervaloGrafTend().get(SERIE_AMARELA).getIntervaloDtHrIni());
					compareDtFim = DataHoraRN.compareTo(fim, getIntervaloGrafTend().get(SERIE_AMARELA).getIntervaloDtHrFim());
					// data/hora entre o período (maior ou igual) e (menor ou
					// igual)
					if ((compareDtIni > 0 || compareDtIni == 0) && (compareDtFim < 0)) {
						segOcorAmarelo = segOcorAmarelo + ocorr.getDuracaoEvt().longValue();
					}
				}
			}

			// proporções de tempo
			proporcaoIntervaloVermelho = segOcorVermelho.doubleValue() / getIntervaloGrafTend().get(SERIE_VERMELHA).getDuracaoIntervalo();

			if (getIntervaloGrafTend().get(SERIE_AMARELA).getDuracaoIntervalo() > 0) {
				proporcaoIntervaloAmarelo = segOcorAmarelo.doubleValue() / getIntervaloGrafTend().get(SERIE_AMARELA).getDuracaoIntervalo();
			}

			if (proporcaoIntervaloVermelho < proporcaoIntervaloAmarelo) {
				retorno = COR_INTERVALO_LARANJA;
			} else {
				retorno = COR_INTERVALO_VERMELHO;
			}

		} else {
			// verifica se evento ocorreu em AMARELO
			ocorreuEmZonaAmarela = false;
			for (OcorrenciasEvtDTO ocorr : listaOcorr) {
				if (cdEvt.equals(ocorr.getDsritmo())) {
					// ocorrencias em amarelo (>= e <)
					Date fim = ocorr.getDthrFim();
					if (fim == null)
						fim = ocorr.getDthrIni();
					compareDtIni = DataHoraRN.compareTo(fim, getIntervaloGrafTend().get(SERIE_AMARELA).getIntervaloDtHrIni());
					compareDtFim = DataHoraRN.compareTo(fim, getIntervaloGrafTend().get(SERIE_AMARELA).getIntervaloDtHrFim());
					if ((compareDtIni > 0 || compareDtIni == 0) && (compareDtFim < 0 || compareDtFim == 0)) {
						ocorreuEmZonaAmarela = true;
						break;
					}
				}
			}

			if (ocorreuEmZonaAmarela) {
				retorno = COR_INTERVALO_AMARELO; // troquei de laranja para amarelo
			} else {
				retorno = COR_INTERVALO_VERDE;
			}
		}
		return retorno;
	}

}
