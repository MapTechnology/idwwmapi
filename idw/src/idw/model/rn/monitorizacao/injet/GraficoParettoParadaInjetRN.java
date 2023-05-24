package idw.model.rn.monitorizacao.injet;

import java.awt.Color;
import java.awt.Paint;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.hibernate.SQLQuery;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.DwTJust;
import idw.model.pojos.DwTParada;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.geraplano.dtos.DatasDTO;
import idw.model.rn.injet.FuncoesApoioInjet;
import idw.model.rn.injet.TurnoInjetRN;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParetoParadaAreaRespDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoParadaDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParettoParadaDTO;
import idw.model.rn.web.injet.bi.BiWebInjetRN;
import idw.model.rn.web.injet.bi.BiWebInjetRN.FiltroAgrupamentoBI;
import idw.util.AritmeticaUtil;
import idw.util.Cor;
import idw.util.FormulasInjet;
import idw.util.GrafTendenciaUtils;
import idw.util.IntervaloGrafTendenciaRefugoParada;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.OcorrenciasEvtDTO;
import idw.webservices.dto.PeriodoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoPizzaDTO;
import idw.webservices.rest.dto.monitorizacao.LegendaDataHoraDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiFiltroDTO;
import ms.util.ConversaoTipos;

public class GraficoParettoParadaInjetRN extends AbstractRN<DAOGenericoInjet> {

	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";
			
	public static final Color COR_LEGENDA_VERDE = Color.green;
	public static final Color COR_LEGENDA_AMARELO = Color.yellow;
	public static final Color COR_LEGENDA_LARANJA = Color.orange;
	public static final Color COR_LEGENDA_VERMELHO = Color.red;
	
	private static final Comparator<GraficoParettoParadaDTO> comparaIndiceParada = new Comparator<GraficoParettoParadaDTO>() {
		@Override
		public int compare(GraficoParettoParadaDTO o1, GraficoParettoParadaDTO o2) {
			return o1.getIndiceParada().compareTo(o2.getIndiceParada()) * -1;
		}
	};

	private static final Comparator<GraficoParetoParadaAreaRespDTO> comparaIndiceParadaArea =
			new Comparator<GraficoParetoParadaAreaRespDTO>() {
				@Override
				public int compare(GraficoParetoParadaAreaRespDTO o1, GraficoParetoParadaAreaRespDTO o2) {
					return o1.getIndiceArea().compareTo(o2.getIndiceArea()) * -1;
				}
			};

	public GraficoParettoParadaInjetRN() {
		this(new DAOGenericoInjet());
	}

	public GraficoParettoParadaInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public GraficosParettoParadaDTO getGraficoParettoParadaDTO(Date dtReferencia, BigDecimal idTurno, String cdPt, Boolean isComPeso,
			Boolean isSemPeso, BigDecimal totalParadasComPeso, String cdAreaResp, Boolean isConsiderarOP, String cdCp) {

		Double qtdPerdasParada = 0d;
		Double qtdPerdasParadaPARADA = 0d;
		Double qtdPerdasParadaTOTAL = 0d;
		int duracaoOcorrenciaParada = 0;

		BigDecimal totalParadaSemPeso = BigDecimal.ZERO;
		BigDecimal totalParadaSoma = BigDecimal.ZERO;
		Date menorDthrInicioParada = null;
		Date maiorDthrFimParada = null;
		HashMap<String, GraficoParettoParadaDTO> mapParadas = new HashMap<String, GraficoParettoParadaDTO>();
		HashMap<String, List<OcorrenciasEvtDTO>> mapOcorrenciasPorParada = new HashMap<String, List<OcorrenciasEvtDTO>>();

		int _dthrIniPar = 0;
		int _dthrFimPar = _dthrIniPar + 1;
		int _isComPeso = _dthrFimPar + 1;
		int _cdParada = _isComPeso + 1;
		int _dsParada = _cdParada + 1;
		int _cdArea = _dsParada + 1;
		int _dsArea = _cdArea + 1;
		int _dthrIRealOP = _dsArea + 1;
		int _segTmpParCP = _dthrIRealOP + 1;
		int _segTmpParSP = _segTmpParCP + 1;
		int _pcsPerdaParCP = _segTmpParSP + 1;
		int _pcsPerdaParSP = _pcsPerdaParCP + 1;

		Date dthrMenorInicioRealOP = null;
		Date dthrIniPeriodo = null;
		Date dthrFimPeriodo = null;
		Date dthrAtual = null;

		try {
			dthrAtual = DataHoraRN.getDataHoraAtual();
			dthrIniPeriodo =
					FuncoesApoioInjet.calcularInicioTurno(getDao(), dtReferencia, FuncoesApoioInjet.getStrZero(idTurno.longValue(), 6));
			dthrFimPeriodo =
					FuncoesApoioInjet.calcularFimTurno(getDao(), dtReferencia, FuncoesApoioInjet.getStrZero(idTurno.longValue(), 6));

			if (DataHoraRN.after(dthrFimPeriodo, dthrAtual)) {
				dthrFimPeriodo = dthrAtual;
			}

		} catch (SemCalendarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		class RegistroLido {
			Date dthrIniPar;
			Date dthrFimPar;
			boolean isComPeso;
			String cdParada;
			String dsParada;
			String cdArea;
			String dsArea;
			Date dthrIRealOP;
			BigDecimal segTmpParCP = BigDecimal.ZERO;
			BigDecimal segTmpParSP = BigDecimal.ZERO;
			BigDecimal pcsPerdaParCP = BigDecimal.ZERO;
			BigDecimal pcsPerdaParSP = BigDecimal.ZERO;
		}

		String strSQL = "";
		strSQL = strSQL
				.concat("SELECT a.dthripar, a.dthrfpar, a.paradacompeso, a.cdparada, p.dsparada, p.cdarea, ar.dsarea, op.dthrireal, ");
		strSQL = strSQL.concat("       a.tmpparadas, a.tmpparadassempeso, ");
		strSQL = strSQL.concat("       ( ( a.tmpparadas / ft.ciclopadrao) * (c2.qtcavativas * ft.fatorcontagemprod) ) as qtdperdasparCP, ");
		strSQL = strSQL
				.concat("       ( ( a.tmpparadassempeso / ft.ciclopadrao) * (c2.qtcavativas * ft.fatorcontagemprod) ) as qtdperdasparSP ");
		strSQL = strSQL.concat("  FROM ijreaparcnsocorTUR a ");
		strSQL = strSQL.concat("  JOIN ijop op ON (op.nrop = a.nrop) ");
		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol m ON (m.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbpar p ON (p.cdparada = a.cdparada) ");
		strSQL = strSQL.concat("  JOIN ijareres ar ON (ar.cdarea = p.cdarea)  ");
		strSQL = strSQL.concat(
				"  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL.concat(
				"  JOIN cavidades2 c2 ON (c2.cdmolde = ft.cdmolde AND c2.cdestrutura = ft.cdestrutura AND c2.dthrival = ft.dthrivalestru) ");
		strSQL = strSQL.concat("  WHERE a.dtturno = :dtturno ");
		strSQL = strSQL.concat("    AND a.cdturno = :cdturno ");
		strSQL = strSQL.concat("    AND i.cdinjestendido = :cdinjetora ");

		if (isComPeso == true && isSemPeso == false) {
			strSQL = strSQL.concat("    AND a.paradacompeso = '1' ");
		}

		if (isComPeso == false && isSemPeso == true) {
			strSQL = strSQL.concat("    AND a.paradacompeso = '0' ");
		}

		if (!cdAreaResp.equals("")) {
			strSQL = strSQL.concat("    AND ar.cdarea = :cdarearesp ");
		}

		if (isConsiderarOP) {
			strSQL = strSQL.concat("    AND a.nrop = :nrop ");
		}

		List<Object> lista = new ArrayList<Object>();

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q.setTimestamp("dtturno", dtReferencia)
				.setString("cdturno", FuncoesApoioInjet.getStrZero(idTurno.longValue(), 6))
				.setString("cdinjetora", cdPt);

		if (!cdAreaResp.equals("")) {
			q.setString("cdarearesp", cdAreaResp);
		}

		if (isConsiderarOP) {
			q.setString("nrop", cdCp);
		}

		lista = q.list();

		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.dthrIniPar = (Date) registroLido[_dthrIniPar];
			registro.dthrFimPar = (Date) registroLido[_dthrFimPar];
			registro.cdParada = (String) registroLido[_cdParada];
			registro.dsParada = (String) registroLido[_dsParada];
			registro.cdArea = (String) registroLido[_cdArea];
			registro.dsArea = (String) registroLido[_dsArea];
			registro.dthrIRealOP = (Date) registroLido[_dthrIRealOP];
			registro.segTmpParCP = (registroLido[_segTmpParCP] == null ? BigDecimal.ZERO
					: ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParCP]));
			registro.segTmpParSP = (registroLido[_segTmpParSP] == null ? BigDecimal.ZERO
					: ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParSP]));
			registro.pcsPerdaParCP =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet((registroLido[_pcsPerdaParCP] == null ? BigDecimal.ZERO
							: ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParCP])).setScale(0, RoundingMode.FLOOR));
			registro.pcsPerdaParSP =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet((registroLido[_pcsPerdaParSP] == null ? BigDecimal.ZERO
							: ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParSP])).setScale(0, RoundingMode.FLOOR));
			registro.isComPeso = (registro.segTmpParCP.doubleValue() > 0);

			if (isComPeso && registro.segTmpParCP.longValue() > 0) {
				totalParadasComPeso = AritmeticaUtil.somar(totalParadasComPeso, registro.segTmpParCP);
			}

			if (isSemPeso && registro.segTmpParSP.longValue() > 0) {
				totalParadaSemPeso = AritmeticaUtil.somar(totalParadaSemPeso, registro.segTmpParSP);
			}

			if (registro.segTmpParCP.longValue() > 0) {
				totalParadaSoma = AritmeticaUtil.somar(totalParadaSoma, registro.segTmpParCP);
			}

			if (registro.segTmpParSP.longValue() > 0) {
				totalParadaSoma = AritmeticaUtil.somar(totalParadaSoma, registro.segTmpParSP);
			}

			duracaoOcorrenciaParada = (registro.isComPeso == true ? registro.segTmpParCP.intValue() : registro.segTmpParSP.intValue());
			qtdPerdasParada = (registro.isComPeso == true ? registro.pcsPerdaParCP.doubleValue() : registro.pcsPerdaParSP.doubleValue());
			qtdPerdasParadaTOTAL = qtdPerdasParadaTOTAL + qtdPerdasParada;

			GraficoParettoParadaDTO paradaGraf = mapParadas.get(registro.cdParada);

			if (paradaGraf == null) {
				paradaGraf = new GraficoParettoParadaDTO();

				paradaGraf.setIdTParada(0l);
				paradaGraf.setCdParada(registro.cdParada);

				if (registro.segTmpParCP.doubleValue() > 0) {
					paradaGraf.setDsParada(registro.dsParada.toUpperCase());
				} else {
					paradaGraf.setDsParada(registro.dsParada.toUpperCase().toLowerCase());
				}

				BigDecimal tempoParadas = BigDecimal.ZERO;

				if (registro.segTmpParCP.doubleValue() > 0) {
					tempoParadas = registro.segTmpParCP;
				}

				if (registro.segTmpParSP.doubleValue() > 0) {
					tempoParadas = registro.segTmpParSP;
				}

				paradaGraf.setIsPesa(registro.isComPeso);
				paradaGraf.setTempo(tempoParadas.doubleValue());
				paradaGraf.setQtdPerdasParada(qtdPerdasParada);

				////////////// OCORRENCIAS //////////////////

				// PEGA MAIOR DATA E MENOR DATA DE TODAS AS OCORRENCIAS DE PARADAS DA CONSULTA
				menorDthrInicioParada = getMenorDthrInicioParada(registro.dthrIniPar, menorDthrInicioParada);

				Date dthrf = registro.dthrFimPar;
				if (DataHoraRN.after(dthrf, DataHoraRN.getDataHoraAtual())) {
					dthrf = DataHoraRN.getDataHoraAtual();
				}
				maiorDthrFimParada = getMaiorDthrFimParada(dthrf, maiorDthrFimParada);

				List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorParada.get(registro.cdParada);

				OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
				ocoDTO.setIdEvt(0l);
				ocoDTO.setDsritmo(registro.cdParada);
				ocoDTO.setDthrIni(registro.dthrIniPar);
				ocoDTO.setDthrFim(registro.dthrFimPar);

				int duracaoEvt = duracaoOcorrenciaParada;

				ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
				ocoDTO.setMsDtHrIni(BigDecimal.ZERO);
				ocoDTO.setMsDtHrFim(BigDecimal.ZERO);

				if (listaOcoDTO == null) {
					listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
					listaOcoDTO.add(ocoDTO);
					mapOcorrenciasPorParada.put(registro.cdParada, listaOcoDTO);

				} else {
					listaOcoDTO.add(ocoDTO);
				}

				mapParadas.put(registro.cdParada, paradaGraf);

			} else {
				BigDecimal tempoParadas = BigDecimal.ZERO;

				if (registro.segTmpParCP.doubleValue() > 0) {
					tempoParadas = registro.segTmpParCP;
				}

				if (registro.segTmpParSP.doubleValue() > 0) {
					tempoParadas = tempoParadas.add(registro.segTmpParSP);
					totalParadaSemPeso = totalParadaSemPeso.add(registro.segTmpParSP);
				}

				// ARMAZENA O TEMPO PARADAS DE ACORDO COM CD PARADA
				BigDecimal tempoParadaDeUmMotivo = new BigDecimal(paradaGraf.getTempo()).add(tempoParadas);
				qtdPerdasParadaPARADA = paradaGraf.getQtdPerdasParada() + qtdPerdasParada;

				////////////// OCORRENCIAS //////////////////

				// PEGA MAIOR DATA E MENOR DATA DE TODAS AS OCORRENCIAS DE PARADAS DA CONSULTA
				menorDthrInicioParada = getMenorDthrInicioParada(registro.dthrIniPar, menorDthrInicioParada);
				maiorDthrFimParada = getMaiorDthrFimParada(registro.dthrFimPar, maiorDthrFimParada);

				List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorParada.get(registro.cdParada);
				if (listaOcoDTO != null) {
					OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
					ocoDTO.setIdEvt(0l);
					ocoDTO.setDsritmo(registro.cdParada);
					ocoDTO.setDthrIni(registro.dthrIniPar);
					ocoDTO.setDthrFim(registro.dthrFimPar);

					int duracaoEvt = duracaoOcorrenciaParada;

					ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
					ocoDTO.setMsDtHrIni(BigDecimal.ZERO);
					ocoDTO.setMsDtHrFim(BigDecimal.ZERO);

					listaOcoDTO.add(ocoDTO);
				}
				paradaGraf.setTempo(tempoParadaDeUmMotivo.doubleValue());
				paradaGraf.setQtdPerdasParada(qtdPerdasParadaPARADA);
			}

			if (dthrMenorInicioRealOP == null) {
				dthrMenorInicioRealOP = registro.dthrIRealOP;
			} else {
				if (DataHoraRN.after(dthrMenorInicioRealOP, registro.dthrIRealOP)) {
					dthrMenorInicioRealOP = registro.dthrIRealOP;
				}
			}

		}

		// Ainda falta calcular o índice de paradas baseado na quantidade de perdas por parada (o total geral de perdas nesta condi��oo é
		// calculado nesta rotina, n�o vem como parâmero
		Set<String> cdsParadas = mapParadas.keySet();
		for (String cdParada : cdsParadas) {
			GraficoParettoParadaDTO paradaGraf = mapParadas.get(cdParada);

			String tempoParadasF = DataHoraRN
					.formatMilisegundosParaHHMMSSmmm(new BigDecimal(paradaGraf.getTempo()).multiply(new BigDecimal(1000)).longValue());
			paradaGraf.setTempoFormatado(tempoParadasF);
			paradaGraf.setIndiceParada(
					FormulasInjet.calcularIndiceParada(new BigDecimal(paradaGraf.getTempo()), totalParadaSoma).doubleValue());
			paradaGraf.setIndiceParadaQtdPerdasPar(FormulasInjet.calcularIndiceParada(new BigDecimal(paradaGraf.getQtdPerdasParada()),
					new BigDecimal(qtdPerdasParadaTOTAL)).doubleValue());
		}

		GrafTendenciaUtils algoritmoGraf = null;

		// MONTA O GRAFICO - NESTE MOMENTO É DEFINIDO O INTERVALO DE CORES
		if (menorDthrInicioParada != null && maiorDthrFimParada != null) {
			// algoritmoGraf = new GrafTendenciaUtils(menorDthrInicioParada, maiorDthrFimParada);
			if (DataHoraRN.after(dthrMenorInicioRealOP, dthrIniPeriodo)) {
				dthrIniPeriodo = dthrMenorInicioRealOP;
			}
			algoritmoGraf = new GrafTendenciaUtils(dthrIniPeriodo, dthrFimPeriodo);
		}

		
		GraficosParettoParadaDTO retorno = new GraficosParettoParadaDTO();
		if (algoritmoGraf != null) {
			mapOcorrenciasPorParada = getOcorrenciasPorFaixaPeriodoFichaPt(algoritmoGraf, dtReferencia, FuncoesApoioInjet.getStrZero(idTurno.longValue(), 6), isComPeso, isSemPeso, isConsiderarOP, cdCp, cdPt, cdAreaResp);	
			defineCoresLegendaEBarra(algoritmoGraf, retorno, mapParadas, mapOcorrenciasPorParada);
		}
		

		return retorno;

	}

	private void defineCoresLegendaEBarra(GrafTendenciaUtils algoritmoGraf, GraficosParettoParadaDTO retorno,
			HashMap<String, GraficoParettoParadaDTO> mapParadas, HashMap<String, List<OcorrenciasEvtDTO>> mapOcorrenciasPorParada) {

		if (algoritmoGraf.getIntervaloGrafTend() != null && !algoritmoGraf.getIntervaloGrafTend().isEmpty()) {
			for (IntervaloGrafTendenciaRefugoParada intervalo : algoritmoGraf.getIntervaloGrafTend()) {
				if (intervalo.getCorIntervalo().equals(Color.YELLOW)) {
					DatasDTO datasAmarelo = new DatasDTO();
					datasAmarelo.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
					datasAmarelo.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
					retorno.setCorAmarela(datasAmarelo);
				}
				if (intervalo.getCorIntervalo().equals(Color.ORANGE)) {
					DatasDTO datasLaranja = new DatasDTO();
					datasLaranja.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
					datasLaranja.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
					retorno.setCorLaranja(datasLaranja);
				}
				if (intervalo.getCorIntervalo().equals(Color.GREEN)) {
					DatasDTO datasVerde = new DatasDTO();
					datasVerde.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
					datasVerde.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
					retorno.setCorVerde(datasVerde);
				}
				if (intervalo.getCorIntervalo().equals(Color.RED)) {
					DatasDTO datasVermelho = new DatasDTO();
					datasVermelho.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
					datasVermelho.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
					retorno.setCorVermelho(datasVermelho);
				}
			}
		}

		List<GraficoParettoParadaDTO> listaParadas = new ArrayList<GraficoParettoParadaDTO>();

		Set<String> cdsParadas = mapParadas.keySet();
		for (String cdParada : cdsParadas) {
			GraficoParettoParadaDTO paradaGraf = mapParadas.get(cdParada);
			List<OcorrenciasEvtDTO> listaOco = mapOcorrenciasPorParada.get(cdParada);
			if (listaOco != null && listaOco.size() > 0) {
				Paint paint = algoritmoGraf.corBarraTendencia(paradaGraf.getCdParada(), listaOco);
				Color cor = (Color) paint;
				paradaGraf.setCorBarra(String.valueOf(cor.getRGB()));
				listaParadas.add(paradaGraf);
			}
		}

		retorno.setParadas(listaParadas);

	}

	private Date getMenorDthrInicioParada(Date dthrInicioParada, Date menorDthrInicioParada) {
		if (menorDthrInicioParada == null) {
			return dthrInicioParada;
		} else {
			if (DataHoraRN.before(dthrInicioParada, menorDthrInicioParada)) {
				return dthrInicioParada;
			} else {
				return menorDthrInicioParada;
			}
		}
	}

	private Date getMaiorDthrFimParada(Date dthrFimParada, Date maiorDthrFimParada) {
		if (maiorDthrFimParada == null) {
			return dthrFimParada;
		} else {
			if (dthrFimParada != null && DataHoraRN.after(dthrFimParada, maiorDthrFimParada)) {
				return dthrFimParada;
			} else {
				return maiorDthrFimParada;
			}
		}
	}

	public GraficosParettoParadaDTO getGraficoParettoParadaBIDTO(FiltroDetalhePTInjetDTO filtro, Boolean isComPeso, Boolean isSemPeso,
			BigDecimal totalParadas) {
		Double qtdPerdasParadaTOTAL = 0d;

		int _dthrIniHora = 0;
		int _dtTurno = 0;
		int _cdTurno = _dtTurno + 1;
		int _nrOP = (filtro.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue()) ? _dthrIniHora : _cdTurno) + 1;
		int _cdMaquina = _nrOP + 1;
		int _cdMolde = _cdMaquina + 1;
		int _cdEstrutura = _cdMolde + 1;
		int _dthrIValEstru = _cdEstrutura + 1;
		int _dthrIValCic = _dthrIValEstru + 1;
		int _cdParada = _dthrIValCic + 1;
		int _dsParada = _cdParada + 1;
		int _cdArea = _dsParada + 1;
		int _dsArea = _cdArea + 1;
		int _segTmpParCP = _dsArea + 1;
		int _segTmpParSP = _segTmpParCP + 1;
		int _pcsPerdaParCP = _segTmpParSP + 1;
		int _pcsPerdaParSP = _pcsPerdaParCP + 1;

		class RegistroLido {
			Date dthrIniHora;
			Date dtTurno;
			String cdTurno;
			String nrOP;
			String cdMaquina;
			String cdMolde;
			String cdEstrutura;
			Date dthrIValEstru;
			Date dthrIValCic;
			String cdParada;
			String dsParada;
			String cdArea;
			String dsArea;
			BigDecimal segTmpParCP = BigDecimal.ZERO;
			BigDecimal segTmpParSP = BigDecimal.ZERO;
			BigDecimal pcsPerdaParCP = BigDecimal.ZERO;
			BigDecimal pcsPerdaParSP = BigDecimal.ZERO;
		}

		Date dthrIniPeriodo = null;
		Date dthrFimPeriodo = null;
		Date dthrAtual = null;

		try {
			dthrAtual = DataHoraRN.getDataHoraAtual();

			if (filtro.getTpId().equals(DetalheMonitorizacaoPTInjetRN.PERIODO_CONSOLIDACAO_HORA)) {
				dthrIniPeriodo = filtro.getDthrIhora();
				dthrFimPeriodo = filtro.getDthrFhora();

			} else {
				if (filtro.getDtReferenciaInicial() != null && filtro.getDtReferenciaFinal() != null) {
					if (filtro.getDwTurno() == null) {
						List<PeriodoDTO> listaPeriodos = null;
						TurnoInjetRN rnT = new TurnoInjetRN(getDao());

						listaPeriodos = rnT.getIntervalosPeriodo(filtro.getDtReferenciaInicial(), filtro.getDtReferenciaInicial(), null);
						dthrIniPeriodo = listaPeriodos.get(0).getDtHrInicio();
						dthrFimPeriodo = listaPeriodos.get(listaPeriodos.size() - 1).getDtHrFim();

					} else {
						dthrIniPeriodo = FuncoesApoioInjet.calcularInicioTurno(getDao(), filtro.getDtReferenciaInicial(),
								FuncoesApoioInjet.getStrZero(filtro.getDwTurno().getIdTurno(), 6));
						dthrFimPeriodo = FuncoesApoioInjet.calcularFimTurno(getDao(), filtro.getDtReferenciaFinal(),
								FuncoesApoioInjet.getStrZero(filtro.getDwTurno().getIdTurno(), 6));
					}

				} else {
					if (filtro.getDtReferencia() != null) {
						List<PeriodoDTO> listaPeriodos = null;
						TurnoInjetRN rnT = new TurnoInjetRN(getDao());

						listaPeriodos = rnT.getIntervalosPeriodo(filtro.getDtReferencia(), filtro.getDtReferencia(), null);
						dthrIniPeriodo = listaPeriodos.get(0).getDtHrInicio();
						dthrFimPeriodo = listaPeriodos.get(listaPeriodos.size() - 1).getDtHrFim();

					} else {
						dthrIniPeriodo = FuncoesApoioInjet.calcularInicioTurno(getDao(), filtro.getDtReferencia(),
								FuncoesApoioInjet.getStrZero(filtro.getDwTurno().getIdTurno(), 6));
						dthrFimPeriodo = FuncoesApoioInjet.calcularFimTurno(getDao(), filtro.getDtReferencia(),
								FuncoesApoioInjet.getStrZero(filtro.getDwTurno().getIdTurno(), 6));
					}
				}

			}

			if (DataHoraRN.after(dthrFimPeriodo, dthrAtual)) {
				dthrFimPeriodo = dthrAtual;
			}

		} catch (SemCalendarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Date menorDthrInicioParada = null;
		Date maiorDthrFimParada = null;

		HashMap<String, GraficoParettoParadaDTO> mapParadas = new HashMap<String, GraficoParettoParadaDTO>();
		HashMap<String, List<OcorrenciasEvtDTO>> mapOcorrenciasPorParada = new HashMap<String, List<OcorrenciasEvtDTO>>();
		HashMap<String, BigDecimal> mapIndicePorParada = new HashMap<String, BigDecimal>();

		List<Object> listaParadasFechadas = consultaParadasFechadas(filtro, isComPeso, isSemPeso);

		totalParadas = BigDecimal.ZERO;
		for (Object reg : listaParadasFechadas) {
			Object[] registro = (Object[]) reg;
			BigDecimal segAutoTempoparadaCp = (BigDecimal) registro[_segTmpParCP];
			BigDecimal segAutoTempoparadaSp = (BigDecimal) registro[_segTmpParSP];

			if (segAutoTempoparadaCp != null)
				totalParadas = totalParadas.add(segAutoTempoparadaCp);

			if (segAutoTempoparadaSp != null)
				totalParadas = totalParadas.add(segAutoTempoparadaSp);

		}

		for (Object reg : listaParadasFechadas) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			if (filtro.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue())) {
				registro.dthrIniHora = (Date) registroLido[_dthrIniHora];
			} else {
				registro.dtTurno = (Date) registroLido[_dtTurno];
				registro.cdTurno = (String) registroLido[_cdTurno];
			}

			registro.cdMaquina = (String) registroLido[_cdMaquina];
			registro.cdMolde = (String) registroLido[_cdMolde];
			registro.cdEstrutura = (String) registroLido[_cdEstrutura];
			registro.dthrIValEstru = (Date) registroLido[_dthrIValEstru];
			registro.dthrIValCic = (Date) registroLido[_dthrIValCic];
			registro.nrOP = (String) registroLido[_nrOP];
			registro.cdParada = (String) registroLido[_cdParada];
			registro.dsParada = (String) registroLido[_dsParada];
			registro.cdArea = (String) registroLido[_cdArea];
			registro.dsArea = (String) registroLido[_dsArea];

			registro.segTmpParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParCP]);
			registro.segTmpParSP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParSP]);
			registro.pcsPerdaParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParCP]).setScale(0, RoundingMode.FLOOR);
			registro.pcsPerdaParSP = ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParSP]).setScale(0, RoundingMode.FLOOR);

			if (!(filtro.getIsParadasComPeso() == null && filtro.getIsParadasSemPeso() == null)) {
				if (filtro.getIsParadasComPeso() == true && filtro.getIsParadasSemPeso() == false) {
					registro.segTmpParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParCP]);
					registro.pcsPerdaParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParCP]);
					registro.segTmpParSP = BigDecimal.ZERO;
					registro.segTmpParSP = BigDecimal.ZERO;
				}

				if (filtro.getIsParadasSemPeso() == true && filtro.getIsParadasComPeso() == false) {
					registro.segTmpParCP = BigDecimal.ZERO;
					registro.pcsPerdaParCP = BigDecimal.ZERO;
					registro.segTmpParSP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParSP]);
					registro.pcsPerdaParSP = ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParSP]);

				}
			}

			Long idConsolpa = 0l;
			String cdParada = registro.cdParada;
			String dsParada = registro.dsParada;
			Long idTparada =
					ConversaoTipos.converteParaBigDecimal(ConversaoTipos.converteStringParaSequenciaNumericaUniCode(cdParada)).longValue();

			String cdArea = registro.cdArea;
			String dsArea = registro.dsArea;
			Long idTarea =
					ConversaoTipos.converteParaBigDecimal(ConversaoTipos.converteStringParaSequenciaNumericaUniCode(cdArea)).longValue();

			Boolean isPesa = (registro.segTmpParCP.doubleValue() > 0d);
			BigDecimal segAutoTempoparadaCp = registro.segTmpParCP;
			BigDecimal segAutoTempoparadaSp = registro.segTmpParSP;
			BigDecimal pcsAutoPerdaparadaCp = registro.pcsPerdaParCP;
			BigDecimal pcsAutoPerdaparadaSp = registro.pcsPerdaParSP;

			if (pcsAutoPerdaparadaCp == null) {
				pcsAutoPerdaparadaCp = BigDecimal.ZERO;
			}

			if (pcsAutoPerdaparadaSp == null) {
				pcsAutoPerdaparadaSp = BigDecimal.ZERO;
			}

			GraficoParettoParadaDTO paradaGraf = mapParadas.get(cdParada);

			if (paradaGraf == null) {
				// parada
				paradaGraf = new GraficoParettoParadaDTO();
				paradaGraf.setIdTParada(idTparada);
				paradaGraf.setCdParada(cdParada);
				paradaGraf.setIdTArea(idTarea);
				paradaGraf.setCdArea(cdArea);
				paradaGraf.setDsArea(dsArea);

				if (isPesa) {
					paradaGraf.setDsParada(dsParada.toUpperCase());
				} else {
					paradaGraf.setDsParada(dsParada.toLowerCase());
				}

				BigDecimal tempoParadas = BigDecimal.ZERO;

				if (segAutoTempoparadaCp != null)
					tempoParadas = segAutoTempoparadaCp;

				if (segAutoTempoparadaSp != null) {
					if (tempoParadas.doubleValue() == 0)
						tempoParadas = segAutoTempoparadaSp;
					else
						tempoParadas = tempoParadas.add(segAutoTempoparadaSp);
				}
				if (tempoParadas.doubleValue() <= 0) {
					continue;
				}

				// ARMAZENA O TEMPO PARADAS DE ACORDO COM CD PARADA
				BigDecimal tempoPar = mapIndicePorParada.get(cdParada);
				if (tempoPar == null) {
					tempoPar = tempoParadas;
					mapIndicePorParada.put(cdParada, tempoPar);
				}

				double indiceParada = FormulasInjet.calcularIndiceParada(tempoParadas, totalParadas);

				paradaGraf.setIndiceParada(indiceParada);

				String tempoParadasF = DataHoraRN.formatMilisegundosParaHHMMSSmmm(tempoParadas.multiply(new BigDecimal(1000)).longValue());
				paradaGraf.setTempoFormatado(tempoParadasF);
				paradaGraf.setTempo(tempoParadas.doubleValue());
				paradaGraf.setQtdPerdasParada(pcsAutoPerdaparadaCp.doubleValue());

				List<DwConsolpaoco> listaOcorrencias =
						getDwConsolpas(filtro.getTpId(),
								registro.dthrIniHora, registro.dtTurno, registro.cdTurno,
								registro.nrOP, registro.cdMaquina, registro.cdMolde, registro.cdEstrutura,
								registro.dthrIValEstru, registro.dthrIValCic,
								registro.cdParada, filtro.getIsParadasComPeso(), filtro.getIsParadasSemPeso());

				qtdPerdasParadaTOTAL = qtdPerdasParadaTOTAL + pcsAutoPerdaparadaCp.doubleValue();

				// SARDINHA: varre lista de ocorrencias e calcula as perdas por parada (necessário na ficha da máquina padr�o Injet)
				for (DwConsolpaoco ocorrencia : listaOcorrencias) {

					// PEGA MAIOR DATA E MENOR DATA DE TODAS AS OCORRENCIAS DE PARADAS DA CONSULTA
					menorDthrInicioParada = getMenorDthrInicioParada(ocorrencia.getDthrIparada(), menorDthrInicioParada);
					Date dtf = ocorrencia.getDthrFparada();
					if (dtf == null)
						dtf = ocorrencia.getDwConsolpa().getDwConsol().getDwConsolid().getDthrFturno();
					if (DataHoraRN.after(dtf, DataHoraRN.getDataHoraAtual()))
						dtf = DataHoraRN.getDataHoraAtual();
					maiorDthrFimParada = getMaiorDthrFimParada(dtf, maiorDthrFimParada);

					List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorParada.get(cdParada);
					if (listaOcoDTO == null) {
						listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
						OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
						ocoDTO.setIdEvt(idTparada); // verificar
						ocoDTO.setDthrIni(ocorrencia.getDthrIparada());
						ocoDTO.setDthrFim(ocorrencia.getDthrFparada());

						int duracaoEvt = DataHoraRN
								.getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());
						ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
						ocoDTO.setMsDtHrIni(ocorrencia.getMsDthriparada());
						ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrfparada());

						listaOcoDTO.add(ocoDTO);
						mapOcorrenciasPorParada.put(cdParada, listaOcoDTO);

					} else {
						OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
						ocoDTO.setIdEvt(idTparada); // veririficar
						ocoDTO.setDthrIni(ocorrencia.getDthrIparada());
						ocoDTO.setDthrFim(ocorrencia.getDthrFparada());

						int duracaoEvt = DataHoraRN
								.getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());

						ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
						ocoDTO.setMsDtHrIni(ocorrencia.getMsDthriparada());
						ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrfparada());

						listaOcoDTO.add(ocoDTO);
						mapOcorrenciasPorParada.put(cdParada, listaOcoDTO);
					}
				}
				mapParadas.put(cdParada, paradaGraf);

			} else {
				qtdPerdasParadaTOTAL = qtdPerdasParadaTOTAL + pcsAutoPerdaparadaCp.doubleValue();

				BigDecimal tempoParadas = BigDecimal.ZERO;

				if (segAutoTempoparadaCp != null)
					tempoParadas = segAutoTempoparadaCp;

				if (segAutoTempoparadaSp != null) {
					if (tempoParadas.doubleValue() == 0)
						tempoParadas = segAutoTempoparadaSp;
					else
						tempoParadas = tempoParadas.add(segAutoTempoparadaSp);
				}

				if (tempoParadas.doubleValue() <= 0) {
					continue;
				}

				// ARMAZENA O TEMPO PARADAS DE ACORDO COM CD PARADA
				BigDecimal tempoPar = mapIndicePorParada.get(cdParada);
				if (tempoPar != null) {
					tempoPar = tempoPar.add(tempoParadas);
					mapIndicePorParada.put(cdParada, tempoPar);
				} else {
					tempoPar = tempoParadas;
				}

				double indiceParada = FormulasInjet.calcularIndiceParada(tempoPar, totalParadas);
				mapParadas.get(cdParada).setIndiceParada(indiceParada);

				String tempoParadasF = DataHoraRN.formatSegundosParaHHMMSS(tempoPar.intValue());
				mapParadas.get(cdParada).setTempoFormatado(tempoParadasF);
				mapParadas.get(cdParada).setTempo(tempoPar.doubleValue());
				mapParadas.get(cdParada)
						.setQtdPerdasParada(mapParadas.get(cdParada).getQtdPerdasParada() + pcsAutoPerdaparadaCp.doubleValue());

				List<DwConsolpaoco> listaOcorrencias =
						getDwConsolpas(filtro.getTpId(),
								registro.dthrIniHora, registro.dtTurno, registro.cdTurno,
								registro.nrOP, registro.cdMaquina, registro.cdMolde, registro.cdEstrutura,
								registro.dthrIValEstru, registro.dthrIValCic,
								registro.cdParada, filtro.getIsParadasComPeso(), filtro.getIsParadasSemPeso());

				for (DwConsolpaoco ocorrencia : listaOcorrencias) {
					// PEGA MAIOR DATA E MENOR DATA DE TODAS AS OCORRENCIAS DE PARADAS DA CONSULTA
					menorDthrInicioParada = getMenorDthrInicioParada(ocorrencia.getDthrIparada(), menorDthrInicioParada);
					maiorDthrFimParada = getMaiorDthrFimParada(ocorrencia.getDthrFparada(), maiorDthrFimParada);

					List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorParada.get(cdParada);
					if (listaOcoDTO != null) {
						OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
						ocoDTO.setIdEvt(idTparada);
						ocoDTO.setDthrIni(ocorrencia.getDthrIparada());
						ocoDTO.setDthrFim(ocorrencia.getDthrFparada());

						int duracaoEvt = DataHoraRN
								.getQuantidadeSegundosNoPeriodo(ocorrencia.getDthrIparada(), ocorrencia.getDthrFparada());

						ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
						ocoDTO.setMsDtHrIni(ocorrencia.getMsDthriparada());
						ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrfparada());

						listaOcoDTO.add(ocoDTO);
					}
				}
			}

		}

		// Ainda falta calcular o índice de paradas baseado na quantidade de perdas por parada (o total geral de perdas nesta condi��oo é
		// calculado nesta rotina, nao vem como parâmetro

		// Areas resp
		GraficoParetoParadaAreaRespDTO areaGraf = new GraficoParetoParadaAreaRespDTO();
		HashMap<String, GraficoParetoParadaAreaRespDTO> mapAreaResp = new HashMap<String, GraficoParetoParadaAreaRespDTO>();

		Set<String> cdsParadas = mapParadas.keySet();
		BigDecimal totalPerdaParada = BigDecimal.ZERO;
		for (String cdParada : cdsParadas) {
			GraficoParettoParadaDTO paradaGraf = mapParadas.get(cdParada);
			totalPerdaParada = totalPerdaParada.add(new BigDecimal(paradaGraf.getQtdPerdasParada()));

			// Areas resp -- identificar e acumular
			areaGraf = mapAreaResp.get(paradaGraf.getCdArea());

			if (areaGraf == null) {
				areaGraf = new GraficoParetoParadaAreaRespDTO();
				areaGraf.setAreaResp(new DwTArea());

				// Marcos Sardinha: 2017-01-31 - tratamento para parada sem area (problema verificado na Sony)
				DwTArea areaResp = new DwTArea();
				if (paradaGraf.getIdTArea() != null) {
					areaResp.setIdArea(paradaGraf.getIdTArea());
					areaResp.setCdArea(paradaGraf.getCdArea());
					areaResp.setDsArea(paradaGraf.getDsArea());

					areaGraf.setAreaResp(areaResp);
					areaGraf.setTempoParada(paradaGraf.getTempo());
					areaGraf.setQtdPerdasParada(paradaGraf.getQtdPerdasParada());
					areaGraf.getParadas().add(paradaGraf);

					mapAreaResp.put(paradaGraf.getCdArea(), areaGraf);
				}
			} else {
				// acumula
				areaGraf.setTempoParada(areaGraf.getTempoParada() + paradaGraf.getTempo());
				areaGraf.setQtdPerdasParada(areaGraf.getQtdPerdasParada() + paradaGraf.getQtdPerdasParada());
				areaGraf.getParadas().add(paradaGraf);

				mapAreaResp.put(areaGraf.getAreaResp().getCdArea(), areaGraf);
			}

		}

		for (String cdParada : cdsParadas) {
			GraficoParettoParadaDTO paradaGraf = mapParadas.get(cdParada);
			paradaGraf.setIndiceParadaQtdPerdasPar(FormulasInjet.calcularIndiceParada(new BigDecimal(paradaGraf.getQtdPerdasParada()),
					totalPerdaParada).doubleValue());
		}

		// Area resp - calcular ind parada por area
		Set<String> cdsAreas = mapAreaResp.keySet();
		for (String cdArea : cdsAreas) {
			GraficoParetoParadaAreaRespDTO areaParGraf = mapAreaResp.get(cdArea);
			areaParGraf.setIndiceArea((FormulasInjet.calcularIndiceParada(new BigDecimal(areaParGraf.getQtdPerdasParada()),
					totalPerdaParada).doubleValue()));
		}

		GrafTendenciaUtils algoritmoGraf = null;

		// MONTA O GRAFICO - NESTE MOMENTO É DEFINIDO O INTERVALO DE CORES
		if (menorDthrInicioParada != null && maiorDthrFimParada != null) {
			// algoritmoGraf = new GrafTendenciaUtils(menorDthrInicioParada, maiorDthrFimParada);
			algoritmoGraf = new GrafTendenciaUtils(dthrIniPeriodo, dthrFimPeriodo);
		}

		GraficosParettoParadaDTO retorno = new GraficosParettoParadaDTO();
		if (algoritmoGraf != null) {
			defineCoresLegendaEBarra(algoritmoGraf, retorno, mapParadas, mapOcorrenciasPorParada);
		}

		// area resp - atribuir a retorno
		retorno.setAreas(new ArrayList<GraficoParetoParadaAreaRespDTO>());
		for (String cdArea : cdsAreas) {
			GraficoParetoParadaAreaRespDTO areaParGraf = mapAreaResp.get(cdArea);
			retorno.getAreas().add(areaParGraf);
		}

		return retorno;

	}

	@SuppressWarnings("unchecked")
	public GraficosParettoParadaDTO getGraficoParettoParadaBIDTO(BiFiltroDTO filtroBIParada, Boolean isComPeso, String cdAreaResp) {
		BigDecimal totalParadas = BigDecimal.ZERO;
		BigDecimal qtdPerdas = BigDecimal.ZERO;

		int _cdParada = 0;
		int _dsParada = _cdParada + 1;

		int _segTmpParCP = _dsParada + 1;
		int _pcsPerdaParCP = _segTmpParCP + 1;

		int _segTmpParSP = _pcsPerdaParCP + 1;
		int _pcsPerdaParSP = _segTmpParSP + 1;

		int _dthrMin = _pcsPerdaParSP + 1;
		int _dthrMax = _dthrMin + 1;
		int _dthrIniRealMin = _dthrMax + 1;

		class RegistroLido {
			String cdParada;
			String dsParada;
			BigDecimal segTmpParCP = BigDecimal.ZERO;
			BigDecimal pcsPerdaParCP = BigDecimal.ZERO;
			BigDecimal segTmpParSP = BigDecimal.ZERO;
			BigDecimal pcsPerdaParSP = BigDecimal.ZERO;
			Date dthrMin;
			Date dthrMax;
			Date dthrIniRealMin;
		}

		Date dthrMenorInicioRealOP = null;
		Date dthrIniPeriodo = null;
		Date dthrFimPeriodo = null;
		Date dthrAtual = null;

		Date menorDthrOcor = null;
		Date maiorDthrOcor = null;

		// se filtro for por ano e mes tem que converter para data
		BiWebInjetRN biRN = new BiWebInjetRN(getDao(), FORMATO_DATA, FORMATO_DATA_HORA);
		BiFiltroDTO filtroBI = biRN.cloneBiFiltroDTO(filtroBIParada);

		if (filtroBI.getAgrupamentoBI() == FiltroAgrupamentoBI.BI_TOTAL_ANO_MES.getValor()) {
			// altera agrupamento
			filtroBI.setAgrupamentoBI(FiltroAgrupamentoBI.BI_TOTAL_DATA.getValor());

			// atribui periodo
			filtroBI.setDtIni(DataHoraRN.dateToStringYYYYMMDDHHMMSS(DataHoraRN.getInicioMes(ConversaoTipos.converteParaInt(filtroBI.getAnoIni()),
					ConversaoTipos.converteParaInt(filtroBI.getMesIni()))));
			filtroBI.setDtFim(DataHoraRN.dateToStringYYYYMMDDHHMMSS(DataHoraRN.getFimMes(ConversaoTipos.converteParaInt(filtroBI.getAnoFim()),
					ConversaoTipos.converteParaInt(filtroBI.getMesFim()))));

			// zera ano/mes
			filtroBI.setAnoIni("");
			filtroBI.setMesIni("");
			filtroBI.setAnoFim("");
			filtroBI.setMesFim("");
		}

		TurnoInjetRN rnT = new TurnoInjetRN(getDao());
		PeriodoDTO periodo = rnT.getIniFimPeriodo(filtroBI.getDtIniDt(), filtroBI.getDtFimDt(), filtroBI.getCdTurno());

		dthrAtual = DataHoraRN.getDataHoraAtual();
		dthrIniPeriodo = periodo.getDtHrInicio();
		dthrFimPeriodo = periodo.getDtHrFim();

		if (DataHoraRN.after(dthrFimPeriodo, dthrAtual)) {
			dthrFimPeriodo = dthrAtual;
		}

		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.cdparada, p.dsparada, ");
		strSQL = strSQL.concat("       SUM(a.tmpparadas) as tmpParCP, ");
		strSQL = strSQL.concat(
				"       SUM( ( ( a.tmpparadas / ft.ciclopadrao) * (c.qtcavativas * ft.fatorcontagemprod) ) / dc.divisorUB) as qtdperdasparCP, ");
		strSQL = strSQL.concat("       SUM(a.tmpparadassempeso) as tmpParSP, ");
		strSQL = strSQL.concat(
				"       SUM( ( ( a.tmpparadassempeso / ft.ciclopadrao) * (c.qtcavativas * ft.fatorcontagemprod) ) / dc.divisorUB) as qtdperdasparSP, ");
		strSQL = strSQL.concat("       MIN(a.dthripar) as dthrmin, ");
		strSQL = strSQL.concat("       MAX(a.dthrfpar) as dthrmax, ");
		strSQL = strSQL.concat("       MIN(op.dthrireal) as dthrIniRealMin ");
		strSQL = strSQL.concat("  FROM ijreaparcnsocorTUR a ");
		strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
		strSQL = strSQL.concat(
				"  JOIN ijoproteiro rot ON (rot.nrop = a.nrop AND rot.cdinjetora = a.cdinjetora AND rot.cdmolde = a.cdmolde AND rot.cdestrutura = a.cdestrutura) ");
		strSQL = strSQL.concat("  JOIN ijop op ON (op.nrop = a.nrop)  ");
		strSQL = strSQL.concat("  JOIN ijtbpar p ON (p.cdparada = a.cdparada) ");
		strSQL = strSQL.concat(
				"  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL.concat(
				"  JOIN ijmolpro c ON (c.cdmolde = ft.cdmolde AND a.cdestrutura = ft.cdestrutura AND c.dthrival = ft.dthrivalestru) ");
		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol m ON (m.cdmolde = a.cdmolde) ");

		// area resp
		if (!cdAreaResp.equals("")) {
			strSQL = strSQL.concat("  JOIN ijareres ar ON (ar.cdarea = p.cdarea)  ");
		}

		// tabelas relacionadas a grupo de maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");
		} else {
			if (!filtroBI.getCdClasseMaquina().equals("")) {
				strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = maq.cdinjetora) ");
			}
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");
		}

		strSQL = strSQL.concat(" WHERE a.dtturno  BETWEEN :dtini AND :dtfim ");


		// turno
		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cdturno = :cdturno ");
		}
		
		if (!cdAreaResp.equals("")) {
			strSQL = strSQL.concat("  AND ar.cdarea = :cdarea ");
		}

		// máquina
		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND i.cdinjestendido = :cdpt ");
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");
			} else {
				strSQL = strSQL.concat("  AND h.classe = :cdclasse ");
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND m.cdmolestendido = :cdrap ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");
		}

		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat("   AND c.cdproduto = :cdproduto ");
		}

		strSQL = strSQL.concat(" GROUP BY a.cdparada, p.dsparada ");

		if (isComPeso) {
			// desconsidera parada sem peso
			strSQL = strSQL.concat(" HAVING SUM(a.tmpparadas) > 0 ");
		} else {
			// desconsidera parada com peso
			strSQL = strSQL.concat(" HAVING SUM(a.tmpparadassempeso) > 0 ");
		}

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

		// filtros

		// area resp
		if (!cdAreaResp.equals("")) {
			q.setString("cdarea", cdAreaResp);
		}

		// máquina
		if (!filtroBI.getCdPt().equals("")) {
			q.setString("cdpt", filtroBI.getCdPt());
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				q.setString("cdgt", filtroBI.getCdGt());
			} else {
				q.setString("cdclasse", filtroBI.getCdClasseMaquina());
			}
		}

		// produto
		if (!filtroBI.getCdProduto().equals("")) {
			q.setString("cdproduto", filtroBI.getCdProduto());
		}

		// periodo
		q.setTimestamp("dthrini", filtroBI.getDtIniDt());
		q.setTimestamp("dthrfim", filtroBI.getDtFimDt());

		// turno
		if (!filtroBI.getCdTurno().equals("")) {
			q.setString("cdturno", filtroBI.getCdTurno());
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			q.setString("cdrap", filtroBI.getCdRap());
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			q.setString("cdgrprap", filtroBI.getCdGrpRap());
		}

		List<GraficoParettoParadaDTO> paradas = new ArrayList<GraficoParettoParadaDTO>();
		HashMap<String, GraficoParettoParadaDTO> mapParadas = new HashMap<String, GraficoParettoParadaDTO>();
		HashMap<String, List<OcorrenciasEvtDTO>> mapOcorrenciasPorParada = new HashMap<String, List<OcorrenciasEvtDTO>>();

		List<Object> lista = new ArrayList<Object>();
		lista = q.list();

		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdParada = (String) registroLido[_cdParada];
			registro.dsParada = (String) registroLido[_dsParada];

			registro.segTmpParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParCP]);
			registro.pcsPerdaParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParCP]).setScale(0, RoundingMode.FLOOR);

			registro.segTmpParSP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParSP]);
			registro.pcsPerdaParSP = ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParSP]).setScale(0, RoundingMode.FLOOR);

			registro.dthrMin = (Date) registroLido[_dthrMin];
			registro.dthrMax = (Date) registroLido[_dthrMax];
			registro.dthrIniRealMin = (Date) registroLido[_dthrIniRealMin];

			GraficoParettoParadaDTO paradaGraf = new GraficoParettoParadaDTO();

			paradaGraf = new GraficoParettoParadaDTO();
			paradaGraf.setIdTParada(0L);
			paradaGraf.setCdParada(registro.cdParada);

			if (isComPeso) {
				paradaGraf.setDsParada(registro.dsParada.toUpperCase());
				paradaGraf.setTempo(registro.segTmpParCP.doubleValue());
				paradaGraf.setQtdPerdasParada(registro.pcsPerdaParCP.doubleValue());
			} else {
				paradaGraf.setDsParada(registro.dsParada.toLowerCase());
				paradaGraf.setTempo(registro.segTmpParSP.doubleValue());
				paradaGraf.setQtdPerdasParada(registro.pcsPerdaParSP.doubleValue());
			}

			totalParadas = AritmeticaUtil.somar(totalParadas, new BigDecimal(paradaGraf.getTempo()));
			qtdPerdas = AritmeticaUtil.somar(qtdPerdas, new BigDecimal(paradaGraf.getQtdPerdasParada()));

			paradaGraf.setTempoFormatado(DataHoraRN
					.formatMilisegundosParaHHMMSSmmm((new BigDecimal(paradaGraf.getTempo())).multiply(new BigDecimal(1000)).longValue()));

			menorDthrOcor = getMenorDthrInicioParada(registro.dthrMin, menorDthrOcor);
			maiorDthrOcor = getMenorDthrInicioParada(registro.dthrMax, maiorDthrOcor);

			paradas.add(paradaGraf);

			if (dthrMenorInicioRealOP == null) {
				dthrMenorInicioRealOP = registro.dthrIniRealMin;
			} else {
				if (DataHoraRN.after(dthrMenorInicioRealOP, registro.dthrIniRealMin)) {
					dthrMenorInicioRealOP = registro.dthrIniRealMin;
				}
			}

			// maps utilizados na definicao das cores de cada barras/parada
			mapParadas.put(registro.cdParada, paradaGraf);

			List<OcorrenciasEvtDTO> listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
			listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
			OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
			ocoDTO.setIdEvt(0L);
			ocoDTO.setDthrIni(registro.dthrMin);
			ocoDTO.setDthrFim(registro.dthrMax);

			int duracaoEvt = paradaGraf.getTempo().intValue();
			ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
			ocoDTO.setMsDtHrIni(BigDecimal.ZERO);
			ocoDTO.setMsDtHrFim(BigDecimal.ZERO);

			listaOcoDTO.add(ocoDTO);
			mapOcorrenciasPorParada.put(registro.cdParada, listaOcoDTO);
		}

		Set<String> cdParadas = mapParadas.keySet();
		for (String keyPar : cdParadas) {
			mapParadas.get(keyPar).setIndiceParada(FormulasInjet.calcularIndiceParada(new BigDecimal(mapParadas.get(keyPar).getTempo()), totalParadas));
			mapParadas.get(keyPar).setIndiceParadaQtdPerdasPar(FormulasInjet.calcularIndiceParada(new BigDecimal(mapParadas.get(keyPar).getQtdPerdasParada()), qtdPerdas));
			mapParadas.get(keyPar).setIndiceParada(ConversaoTipos.converteParaDouble(mapParadas.get(keyPar).getIndiceParada(),2));
			mapParadas.get(keyPar).setIndiceParadaQtdPerdasPar(ConversaoTipos.converteParaDouble(mapParadas.get(keyPar).getIndiceParadaQtdPerdasPar(),2));			
		}

		GrafTendenciaUtils algoritmoGraf = null;

		// MONTA O GRAFICO - NESTE MOMENTO É DEFINIDO O INTERVALO DE CORES
		if (menorDthrOcor != null && maiorDthrOcor != null) {
			algoritmoGraf = new GrafTendenciaUtils(dthrIniPeriodo, dthrFimPeriodo);
		}

		GraficosParettoParadaDTO retorno = new GraficosParettoParadaDTO();
		if (algoritmoGraf != null) {
			mapOcorrenciasPorParada = getOcorrenciasPorFaixaPeriodo(algoritmoGraf, filtroBI, isComPeso, cdAreaResp);	
			defineCoresLegendaEBarra(algoritmoGraf, retorno, mapParadas, mapOcorrenciasPorParada);
		}

		for (GraficoParettoParadaDTO parada : retorno.getParadas()) {
			parada.setCorBarra(Cor.transformarColorParaCodigoHexadecimal(parada.getCorBarra()));
		}

		Collections.sort(retorno.getParadas(), comparaIndiceParada);

		retorno.setLegendas(getLegendas(retorno));
		
		return retorno;
	}

	@SuppressWarnings("unchecked")
	private HashMap<String, List<OcorrenciasEvtDTO>> getOcorrenciasPorFaixaPeriodo(GrafTendenciaUtils algoritmoGraf, BiFiltroDTO filtroBI,
			Boolean isComPeso, String cdAreaResp) {
		HashMap<String, List<OcorrenciasEvtDTO>> retorno = new HashMap<String, List<OcorrenciasEvtDTO>>();

		int _cdParada = 0;
		int _segTmpParCP = _cdParada + 1;
		int _segTmpParSP = _segTmpParCP + 1;

		class RegistroLido {
			String cdParada;
			BigDecimal segTmpParCP = BigDecimal.ZERO;
			BigDecimal segTmpParSP = BigDecimal.ZERO;
		}

		String strSQL = "";
		for (int i = GrafTendenciaUtils.SERIE_VERDE; i <= GrafTendenciaUtils.SERIE_LARANJA; i++) {
			strSQL = "";

			strSQL = strSQL.concat("SELECT a.cdparada, ");
			strSQL = strSQL.concat("       SUM(a.tmpparadas) as tmpParCP, ");
			strSQL = strSQL.concat("       SUM(a.tmpparadassempeso) as tmpParSP ");
			strSQL = strSQL.concat("  FROM ijreaparcnsocorTUR a ");
			strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
			strSQL = strSQL.concat(
					"  JOIN ijoproteiro rot ON (rot.nrop = a.nrop AND rot.cdinjetora = a.cdinjetora AND rot.cdmolde = a.cdmolde AND rot.cdestrutura = a.cdestrutura) ");
			strSQL = strSQL.concat("  JOIN ijop op ON (op.nrop = a.nrop)  ");
			strSQL = strSQL.concat("  JOIN ijtbpar p ON (p.cdparada = a.cdparada) ");
			strSQL = strSQL.concat(
					"  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic) ");
			strSQL = strSQL.concat(
					"  JOIN ijmolpro c ON (c.cdmolde = ft.cdmolde AND a.cdestrutura = ft.cdestrutura AND c.dthrival = ft.dthrivalestru) ");
			strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
			strSQL = strSQL.concat("  JOIN ijtbmol m ON (m.cdmolde = a.cdmolde) ");

			// area resp
			if (!cdAreaResp.equals("")) {
				strSQL = strSQL.concat("  JOIN ijareres ar ON (ar.cdarea = p.cdarea)  ");
			}

			// tabelas relacionadas a grupo de maquina
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");
			} else {
				if (!filtroBI.getCdClasseMaquina().equals("")) {
					strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = maq.cdinjetora) ");
				}
			}

			// tabela relacionado a grupo de ferramenta
			if (!filtroBI.getCdGrpRap().equals("")) {
				strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");
			}

			strSQL = strSQL.concat(" WHERE a.dtturno  BETWEEN :dtini AND :dtfim ");
			strSQL = strSQL.concat("   AND a.dthripar BETWEEN :dthrIniFaixa AND :dthrFimFaixa ");
			if (!filtroBI.getCdTurno().equals("")) {
				strSQL = strSQL.concat("   AND a.cdturno = :cdturno ");
			}

			
			if (!cdAreaResp.equals("")) {
				strSQL = strSQL.concat("  AND ar.cdarea = :cdarea ");
			}

			// máquina
			if (!filtroBI.getCdPt().equals("")) {
				strSQL = strSQL.concat("  AND i.cdinjestendido = :cdpt ");
			} else {
				if (!filtroBI.getCdGt().equals("")) {
					strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");
				} else {
					strSQL = strSQL.concat("  AND h.classe = :cdclasse ");
				}
			}

			// tabela relacionados a ferramenta
			if (!filtroBI.getCdRap().equals("")) {
				strSQL = strSQL.concat("  AND m.cdmolestendido = :cdrap ");
			}

			// tabela relacionado a grupo de ferramenta
			if (!filtroBI.getCdGrpRap().equals("")) {
				strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");
			}

			if (!filtroBI.getCdProduto().equals("")) {
				strSQL = strSQL.concat("   AND c.cdproduto = :cdproduto ");
			}

			strSQL = strSQL.concat(" GROUP BY a.cdparada, p.dsparada ");

			if (isComPeso) {
				// desconsidera parada sem peso
				strSQL = strSQL.concat(" HAVING SUM(a.tmpparadas) > 0 ");
			} else {
				// desconsidera parada com peso
				strSQL = strSQL.concat(" HAVING SUM(a.tmpparadassempeso) > 0 ");
			}

			SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

			// filtros

			// area resp
			if (!cdAreaResp.equals("")) {
				q.setString("cdarea", cdAreaResp);
			}

			// máquina
			if (!filtroBI.getCdPt().equals("")) {
				q.setString("cdpt", filtroBI.getCdPt());
			} else {
				if (!filtroBI.getCdGt().equals("")) {
					q.setString("cdgt", filtroBI.getCdGt());
				} else {
					q.setString("cdclasse", filtroBI.getCdClasseMaquina());
				}
			}

			// produto
			if (!filtroBI.getCdProduto().equals("")) {
				q.setString("cdproduto", filtroBI.getCdProduto());
			}

			// periodo
			q.setTimestamp("dthrini", filtroBI.getDtIniDt());
			q.setTimestamp("dthrfim", filtroBI.getDtFimDt());

			// turno
			if (!filtroBI.getCdTurno().equals("")) {
				q.setString("cdturno", filtroBI.getCdTurno());
			}

			// tabela relacionados a ferramenta
			if (!filtroBI.getCdRap().equals("")) {
				q.setString("cdrap", filtroBI.getCdRap());
			}

			// tabela relacionado a grupo de ferramenta
			if (!filtroBI.getCdGrpRap().equals("")) {
				q.setString("cdgrprap", filtroBI.getCdGrpRap());
			}

			// faixa de datas
			q.setTimestamp("dthrIniFaixa", algoritmoGraf.getIntervaloGrafTend().get(i).getIntervaloDtHrIni());
			q.setTimestamp("dthrFimFaixa", algoritmoGraf.getIntervaloGrafTend().get(i).getIntervaloDtHrFim());


			List<Object> lista = new ArrayList<Object>();
			lista = q.list();

			for (Object reg : lista) {
				RegistroLido registro = new RegistroLido();

				Object[] registroLido = null;
				Object registroLidoAux = (Object) reg;
				registroLido = (Object[]) registroLidoAux;

				registro.cdParada = (String) registroLido[_cdParada];
				registro.segTmpParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParCP]);
				registro.segTmpParSP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParSP]);


				List<OcorrenciasEvtDTO> listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
				OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
				ocoDTO.setDsritmo(registro.cdParada);
				ocoDTO.setDthrIni(algoritmoGraf.getIntervaloGrafTend().get(i).getIntervaloDtHrIni());
				ocoDTO.setDthrFim(algoritmoGraf.getIntervaloGrafTend().get(i).getIntervaloDtHrIni());
				ocoDTO.setDuracaoEvt(isComPeso ? registro.segTmpParCP  : registro.segTmpParSP);
				ocoDTO.setMsDtHrIni(BigDecimal.ZERO);
				ocoDTO.setMsDtHrFim(BigDecimal.ZERO);
				
				listaOcoDTO = retorno.get(registro.cdParada);
				if (listaOcoDTO == null) {
					listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
				}
				
				listaOcoDTO.add(ocoDTO);
				
				
				retorno.put(registro.cdParada, listaOcoDTO);				
			}
		}

		return retorno;
	}


	@SuppressWarnings("unchecked")
	private HashMap<String, List<OcorrenciasEvtDTO>> getOcorrenciasPorFaixaPeriodoFichaPt(GrafTendenciaUtils algoritmoGraf, 
			Date dtReferencia, String cdTurno, Boolean isComPeso, Boolean isSemPeso, Boolean isConsiderarOP, String cdCp, String cdPt,  String cdAreaResp) {
		HashMap<String, List<OcorrenciasEvtDTO>> retorno = new HashMap<String, List<OcorrenciasEvtDTO>>();

		int _cdParada = 0;
		int _segTmpParCP = _cdParada + 1;
		int _segTmpParSP = _segTmpParCP + 1;
		int _segTmpPar = _segTmpParSP + 1;

		class RegistroLido {
			String cdParada;
			BigDecimal segTmpParCP = BigDecimal.ZERO;
			BigDecimal segTmpParSP = BigDecimal.ZERO;
			BigDecimal segTmpPar = BigDecimal.ZERO;
		}

		String strSQL = "";
		for (int i = GrafTendenciaUtils.SERIE_VERDE; i <= GrafTendenciaUtils.SERIE_LARANJA; i++) {
			strSQL = "";

			strSQL = strSQL.concat("SELECT a.cdparada, ");
			strSQL = strSQL.concat("       SUM(a.tmpparadas) as tmpParCP, ");
			strSQL = strSQL.concat("       SUM(a.tmpparadassempeso) as tmpParSP, ");
			strSQL = strSQL.concat("       SUM(a.tmpparadas + a.tmpparadassempeso) as tmpPar ");
			strSQL = strSQL.concat("  FROM ijreaparcnsocorTUR a ");
			strSQL = strSQL.concat("  JOIN ijop op ON (op.nrop = a.nrop) ");
			strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
			strSQL = strSQL.concat("  JOIN ijtbmol m ON (m.cdmolde = a.cdmolde) ");
			strSQL = strSQL.concat("  JOIN ijtbpar p ON (p.cdparada = a.cdparada) ");
			strSQL = strSQL.concat("  JOIN ijareres ar ON (ar.cdarea = p.cdarea)  ");
			strSQL = strSQL.concat("  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic) ");
			strSQL = strSQL.concat("  JOIN cavidades2 c2 ON (c2.cdmolde = ft.cdmolde AND c2.cdestrutura = ft.cdestrutura AND c2.dthrival = ft.dthrivalestru) ");
			strSQL = strSQL.concat("  WHERE a.dtturno = :dtturno ");
			strSQL = strSQL.concat("    AND a.cdturno = :cdturno ");
			strSQL = strSQL.concat("    AND a.dthrfpar BETWEEN :dthrIniFaixa AND :dthrFimFaixa ");
			strSQL = strSQL.concat("    AND i.cdinjestendido = :cdinjetora ");

			if (isComPeso == true && isSemPeso == false) {
				strSQL = strSQL.concat("    AND a.paradacompeso = '1' ");
			}

			if (isComPeso == false && isSemPeso == true) {
				strSQL = strSQL.concat("    AND a.paradacompeso = '0' ");
			}

			if (!cdAreaResp.equals("")) {
				strSQL = strSQL.concat("    AND ar.cdarea = :cdarearesp ");
			}

			if (isConsiderarOP) {
				strSQL = strSQL.concat("    AND a.nrop = :nrop ");
			}

			strSQL = strSQL.concat(" GROUP BY a.cdparada, p.dsparada ");

			
			if (isComPeso == true && isSemPeso == false) {
				strSQL = strSQL.concat(" HAVING SUM(a.tmpparadas) > 0 ");
			}

			if (isComPeso == false && isSemPeso == true) {
				strSQL = strSQL.concat(" HAVING SUM(a.tmpparadassempeso) > 0 ");
			}
						
			SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
/*			
			q.setTimestamp("dtturno", dtReferencia)
			 .setString("cdinjetora", cdPt);
*/
			q.setTimestamp("dtturno", dtReferencia)
			.setString("cdturno", cdTurno)
			.setString("cdinjetora", cdPt);

			
			if (!cdAreaResp.equals("")) {
				q.setString("cdarearesp", cdAreaResp);
			}

			if (isConsiderarOP) {
				q.setString("nrop", cdCp);
			}

			Date dtHrIni = algoritmoGraf.getIntervaloGrafTend().get(i).getIntervaloDtHrIni();
			Date dtHrFim = algoritmoGraf.getIntervaloGrafTend().get(i).getIntervaloDtHrFim();
			
			// regra Injet pra serie amarela: >= ini < fim
			if (i == GrafTendenciaUtils.SERIE_AMARELA) {
				dtHrIni = DataHoraRN.somaSegundos(dtHrIni, -1);
				dtHrFim = DataHoraRN.somaSegundos(dtHrFim, -1);
			}
			
			if (i == GrafTendenciaUtils.SERIE_LARANJA) {
				dtHrIni = DataHoraRN.somaSegundos(dtHrIni, -1);
			}

			
			q.setTimestamp("dthrIniFaixa", dtHrIni);
			q.setTimestamp("dthrFimFaixa", dtHrFim);


			List<Object> lista = new ArrayList<Object>();
			lista = q.list();

			for (Object reg : lista) {
				RegistroLido registro = new RegistroLido();

				Object[] registroLido = null;
				Object registroLidoAux = (Object) reg;
				registroLido = (Object[]) registroLidoAux;

				registro.cdParada = (String) registroLido[_cdParada];
				registro.segTmpParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParCP]);
				registro.segTmpParSP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParSP]);
				registro.segTmpPar = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpPar]);


				List<OcorrenciasEvtDTO> listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
				OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
				ocoDTO.setDsritmo(registro.cdParada);
				ocoDTO.setDthrIni(algoritmoGraf.getIntervaloGrafTend().get(i).getIntervaloDtHrIni());
				ocoDTO.setDthrFim(algoritmoGraf.getIntervaloGrafTend().get(i).getIntervaloDtHrFim());
				
				ocoDTO.setDuracaoEvt(registro.segTmpPar);
				
				if (isComPeso == true && isSemPeso == false) {
					ocoDTO.setDuracaoEvt(registro.segTmpParCP);
				}

				if (isComPeso == false && isSemPeso == true) {
					ocoDTO.setDuracaoEvt(registro.segTmpParSP);
				}

				
				ocoDTO.setMsDtHrIni(BigDecimal.ZERO);
				ocoDTO.setMsDtHrFim(BigDecimal.ZERO);
				
				listaOcoDTO = retorno.get(registro.cdParada);
				if (listaOcoDTO == null) {
					listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
				}
				
				listaOcoDTO.add(ocoDTO);
				
				
				retorno.put(registro.cdParada, listaOcoDTO);				
			}
		}

		return retorno;
	}

	
	@SuppressWarnings("unchecked")
	public List<GraficoPizzaDTO> getGraficoParettoParadaAreaRespBIDTO(BiFiltroDTO filtroBIParada, Boolean isComPeso) {
		BigDecimal totalParadas = BigDecimal.ZERO;

		List<GraficoParetoParadaAreaRespDTO> retornoAreaResp = new ArrayList<GraficoParetoParadaAreaRespDTO>();

		Double qtdPerdasParadaTOTAL = 0d;

		int _cdArea = 0;
		int _dsArea = _cdArea + 1;

		int _segTmpParCP = _dsArea + 1;
		int _pcsPerdaParCP = _segTmpParCP + 1;

		int _segTmpParSP = _pcsPerdaParCP + 1;
		int _pcsPerdaParSP = _segTmpParSP + 1;

		// se filtro for por ano e mes tem que converter para data
		BiWebInjetRN biRN = new BiWebInjetRN(getDao(), FORMATO_DATA, FORMATO_DATA_HORA);
		BiFiltroDTO filtroBI = biRN.cloneBiFiltroDTO(filtroBIParada);

		if (filtroBI.getAgrupamentoBI() == FiltroAgrupamentoBI.BI_TOTAL_ANO_MES.getValor()) {
			// altera agrupamento
			filtroBI.setAgrupamentoBI(FiltroAgrupamentoBI.BI_TOTAL_DATA.getValor());

			// atribui periodo
			filtroBI.setDtIni(DataHoraRN.dateToStringYYYYMMDDHHMMSS(DataHoraRN.getInicioMes(ConversaoTipos.converteParaInt(filtroBI.getAnoIni()),
					ConversaoTipos.converteParaInt(filtroBI.getMesIni()))));
			filtroBI.setDtFim(DataHoraRN.dateToStringYYYYMMDDHHMMSS(DataHoraRN.getFimMes(ConversaoTipos.converteParaInt(filtroBI.getAnoFim()),
					ConversaoTipos.converteParaInt(filtroBI.getMesFim()))));

			// zera ano/mes
			filtroBI.setAnoIni("");
			filtroBI.setMesIni("");
			filtroBI.setAnoFim("");
			filtroBI.setMesFim("");
		}

		class RegistroLido {
			String cdArea;
			String dsArea;
			BigDecimal segTmpParCP = BigDecimal.ZERO;
			BigDecimal pcsPerdaParCP = BigDecimal.ZERO;
			BigDecimal segTmpParSP = BigDecimal.ZERO;
			BigDecimal pcsPerdaParSP = BigDecimal.ZERO;
		}

		String strSQL = "";
		strSQL = strSQL.concat("SELECT ar.cdarea, ar.dsarea, ");
		strSQL = strSQL.concat("       SUM(a.tmpparadas) as tmpParCP, ");
		strSQL = strSQL.concat(
				"       SUM( ( ( a.tmpparadas / ft.ciclopadrao) * (c.qtcavativas * ft.fatorcontagemprod) ) / dc.divisorUB) as qtdperdasparCP, ");
		strSQL = strSQL.concat(
				"       SUM( ( ( ( a.tmpparadas / ft.ciclopadrao) * (c.qtcavativas * ft.fatorcontagemprod) ) / dc.divisorUB) * c.pbrutomedio) as qtdperdasparCPGr, ");
		strSQL = strSQL.concat("       SUM(a.tmpparadassempeso) as tmpParSP, ");
		strSQL = strSQL.concat(
				"       SUM( ( ( a.tmpparadassempeso / ft.ciclopadrao) * (c.qtcavativas * ft.fatorcontagemprod) ) / dc.divisorUB) as qtdperdasparSP, ");
		strSQL = strSQL.concat(
				"       SUM( ( ( ( a.tmpparadassempeso / ft.ciclopadrao) * (c.qtcavativas * ft.fatorcontagemprod) ) / dc.divisorUB) * c.pbrutomedio) as qtdperdasparSPGr ");
		strSQL = strSQL.concat("  FROM ijreaparcnsocorTUR a ");
		strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
		strSQL = strSQL.concat("  JOIN ijtbpar p ON (p.cdparada = a.cdparada) ");
		strSQL = strSQL.concat("  JOIN ijareres ar ON (ar.cdarea = p.cdarea) ");
		strSQL = strSQL.concat(
				"  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL.concat(
				"  JOIN ijmolpro c ON (c.cdmolde = ft.cdmolde AND a.cdestrutura = ft.cdestrutura AND c.dthrival = ft.dthrivalestru) ");
		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol m ON (m.cdmolde = a.cdmolde) ");

		// tabelas relacionadas a grupo de maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");
		} else {
			if (!filtroBI.getCdClasseMaquina().equals("")) {
				strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = maq.cdinjetora) ");
			}
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");
		}

		strSQL = strSQL.concat(" WHERE a.dtturno  BETWEEN :dtini AND :dtfim ");
		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat("   AND a.cdturno = :cdturno ");
		}

		// máquina
		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND i.cdinjestendido = :cdpt ");
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");
			} else {
				strSQL = strSQL.concat("  AND h.classe = :cdclasse ");
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND m.cdmolestendido = :cdrap ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");
		}

		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat("   AND c.cdproduto = :cdproduto ");
		}

		strSQL = strSQL.concat(" GROUP BY ar.cdarea, ar.dsarea ");

		if (isComPeso) {
			// desconsidera parada sem peso
			strSQL = strSQL.concat(" HAVING SUM(a.tmpparadas) > 0 ");
		} else {
			// desconsidera parada com peso
			strSQL = strSQL.concat(" HAVING SUM(a.tmpparadassempeso) > 0 ");
		}

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

		// filtros

		// máquina
		if (!filtroBI.getCdPt().equals("")) {
			q.setString("cdpt", filtroBI.getCdPt());
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				q.setString("cdgt", filtroBI.getCdGt());
			} else {
				q.setString("cdclasse", filtroBI.getCdClasseMaquina());
			}
		}

		// produto
		if (!filtroBI.getCdProduto().equals("")) {
			q.setString("cdproduto", filtroBI.getCdProduto());
		}

		// periodo
		q.setTimestamp("dtini", filtroBI.getDtIniDt());
		q.setTimestamp("dtfim", filtroBI.getDtFimDt());
		
		// turno
		if (!filtroBI.getCdTurno().equals("")) {
			q.setString("cdturno", filtroBI.getCdTurno());
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			q.setString("cdrap", filtroBI.getCdRap());
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			q.setString("cdgrprap", filtroBI.getCdGrpRap());
		}

		List<Object> lista = new ArrayList<Object>();
		lista = q.list();

		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdArea = (String) registroLido[_cdArea];
			registro.dsArea = (String) registroLido[_dsArea];

			registro.segTmpParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParCP]);
			registro.pcsPerdaParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParCP]).setScale(0, RoundingMode.FLOOR);

			registro.segTmpParSP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParSP]);
			registro.pcsPerdaParSP = ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParSP]).setScale(0, RoundingMode.FLOOR);

			GraficoParetoParadaAreaRespDTO paradaGraf = new GraficoParetoParadaAreaRespDTO();
			DwTArea areaResp = new DwTArea();
			areaResp.setId(0L);
			areaResp.setCdArea(registro.cdArea);
			areaResp.setDsArea(registro.dsArea);

			paradaGraf.setAreaResp(areaResp);

			if (isComPeso) {
				paradaGraf.setTempoParada(registro.segTmpParCP.doubleValue());
				paradaGraf.setQtdPerdasParada(registro.pcsPerdaParCP.doubleValue());
				qtdPerdasParadaTOTAL = qtdPerdasParadaTOTAL + paradaGraf.getQtdPerdasParada();
			} else {
				paradaGraf.setTempoParada(registro.segTmpParSP.doubleValue());
				paradaGraf.setQtdPerdasParada(registro.pcsPerdaParSP.doubleValue());
			}

			totalParadas = AritmeticaUtil.somar(totalParadas, new BigDecimal(paradaGraf.getTempoParada()));

			retornoAreaResp.add(paradaGraf);

		}

		if (retornoAreaResp.size() > 0) {
			for (GraficoParetoParadaAreaRespDTO area : retornoAreaResp) {
				area.setIndiceArea(FormulasInjet.calcularIndiceParada(new BigDecimal(area.getTempoParada()), totalParadas));

				Collections.sort(area.getParadas(), comparaIndiceParada);
			}
		}

		Collections.sort(retornoAreaResp, comparaIndiceParadaArea);

		// copia para GraficoPizzaDTO
        int quantidadeDeCores = retornoAreaResp.size();
        int posicao = 0;
        
        List<Color> cores = Cor.getListaDeCores(quantidadeDeCores);
        
		List<GraficoPizzaDTO> retorno = new ArrayList<>();
		for (GraficoParetoParadaAreaRespDTO item : retornoAreaResp) {
			Color cor = cores.get(posicao);
        	posicao++;
        	
			GraficoPizzaDTO areaResp = new GraficoPizzaDTO();
			areaResp.setCodigo(item.getAreaResp().getCdArea());
			areaResp.setDescricao(item.getAreaResp().getDsArea());
			areaResp.setCor(Cor.transformarParaCodigoHexadecimal(cor));
			areaResp.setIndice(ConversaoTipos.converteParaString(item.getIndiceArea(),2));
			areaResp.setValor(DataHoraRN.formatSegundosParaHHMMSSmmm(item.getTempoParada()));
			retorno.add(areaResp);
		}
		
		
		return retorno;
	}

	@SuppressWarnings("unchecked")
	private List<Object> consultaParadasFechadas(FiltroDetalhePTInjetDTO filtro, Boolean isComPeso, Boolean isSemPeso) {
		String strSQL = "";
		if (filtro.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue())) {
			strSQL = strSQL.concat(
					"SELECT DISTINCT a.dthriniintervalo, a.nrop, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, ");
		} else {
			strSQL = strSQL.concat(
					"SELECT DISTINCT a.dtturno, a.cdturno, a.nrop, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, ");
		}

		strSQL = strSQL.concat("       a.cdparada, p.dsparada, p.cdarea, ar.dsarea, ");
		strSQL = strSQL.concat("       a.tmpparadas, a.tmpparadassempeso, ");
		strSQL = strSQL.concat("       ( ( a.tmpparadas / ft.ciclopadrao) * (c2.qtcavativas * ft.fatorcontagemprod) ) as qtdperdasparCP, ");
		strSQL = strSQL
				.concat("       ( ( a.tmpparadassempeso / ft.ciclopadrao) * (c2.qtcavativas * ft.fatorcontagemprod) ) as qtdperdasparSP ");

		if (filtro.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue())) {
			strSQL = strSQL.concat("  FROM ijreaparcnsUT a ");
		} else {
			strSQL = strSQL.concat("  FROM ijreaparcnsTUR a ");
		}

		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol m ON (m.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbpar p ON (p.cdparada = a.cdparada) ");
		strSQL = strSQL.concat("  JOIN ijareres ar ON (ar.cdarea = p.cdarea)  ");
		strSQL = strSQL.concat(
				"  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL.concat(
				"  JOIN cavidades2 c2 ON (c2.cdmolde = ft.cdmolde AND c2.cdestrutura = ft.cdestrutura AND c2.dthrival = ft.dthrivalestru) ");

		// filtro de grupo de molde
		if (filtro.getCdGrupoFerramenta() != null) {
			strSQL = strSQL.concat(" JOIN ijgrpdetmol gmol ON (gmol.cdmolde = a.cdmolde) ");
		}

		// filtro de produto pai (estrutrura de produto) ou produto
		if ((filtro.getCdProdutoPai() != null) || (filtro.getOmProduto() != null && filtro.getOmProduto().getCdProduto() != null
				&& filtro.getOmProduto().getCdProduto().equals("") == false)) {
			strSQL = strSQL.concat(
					" JOIN ijmolpro mp ON (mp.cdmolde = a.cdmolde AND mp.cdestrutura = a.cdestrutura AND mp.dthrival = a.dthrivalestru) ");
		}

		// filtro de produto pai (estrutrura de produto)
		if (filtro.getCdProdutoPai() != null) {
			strSQL = strSQL.concat(" JOIN ijestruprod ep ON (ep.cdprodutoseq = mp.cdproduto) ");
		}

		// qdo houver filtro de grupo de máquina
		if (filtro.getOmGt() != null && filtro.getOmPt() == null) {
			strSQL = strSQL.concat(" JOIN ijgrpdetinj ginj ON (ginj.cdinjetora = a.cdinjetora) ");
		}

		// qdo houver filgro de classe ABC máquina
		if (filtro.getTpClasseABCpt() != null) {
			strSQL = strSQL.concat(" JOIN ijtbinjclassABC abcM ON (abcM.cdinjetora = a.cdinjetora) ");
		}

		// qdo houver filtro de id de ijcnsUT / ijcnsturno
		if (filtro.getIdDwConsolId() != 0) {
			if (filtro.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue())) {
				strSQL = strSQL.concat(" JOIN ijcnsut cns ON (     cns.dthriniintervalo = a.dthriniintervalo ");
				strSQL = strSQL.concat("                       AND cns.cdinjetora = a.cdinjetora ");
				strSQL = strSQL.concat("                       AND cns.nrop = a.nrop ");
				strSQL = strSQL.concat("                       AND cns.cdmolde = a.cdmolde ");
				strSQL = strSQL.concat("                       AND cns.cdestrutura = a.cdestrutura ");
				strSQL = strSQL.concat("                       AND cns.dthrivalestru = a.dthrivalestru ");
				strSQL = strSQL.concat("                       AND cns.dthrivalcic = a.dthrivalcic) ");
			} else {
				strSQL = strSQL.concat(" JOIN ijcnsturno cns ON (    cns.dtturno = a.dtturno ");
				strSQL = strSQL.concat("                         AND cns.cdturno = a.cdturno ");
				strSQL = strSQL.concat("                         AND cns.cdinjetora = a.cdinjetora ");
				strSQL = strSQL.concat("                         AND cns.nrop = a.nrop ");
				strSQL = strSQL.concat("                         AND cns.cdmolde = a.cdmolde ");
				strSQL = strSQL.concat("                         AND cns.cdestrutura = a.cdestrutura ");
				strSQL = strSQL.concat("                         AND cns.dthrivalestru = a.dthrivalestru ");
				strSQL = strSQL.concat("                         AND cns.dthrivalcic = a.dthrivalcic) ");
			}
		}

		strSQL = strSQL.concat("  WHERE 1 = 1 ");

		// filtro de máquina
		if (filtro.getOmPt() != null) {
			strSQL = strSQL.concat("    AND i.cdinjestendido = :cdinjetora ");
		}

		// periodo e turno
		if (filtro.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue())) {
			strSQL = strSQL.concat("    AND a.dthriniintervalo BETWEEN :dthi AND :dthf ");
		} else {

			if (filtro.getDtReferencia() != null && filtro.getAnoInicial() == null) {
				strSQL = strSQL.concat("    AND a.dtturno = :dtturno ");
			}

			if (filtro.getDtReferenciaInicial() != null && filtro.getDtReferenciaFinal() != null) {
				strSQL = strSQL.concat("    AND a.dtturno BETWEEN :dti AND :dtf ");
			}
			if (filtro.getDwTurno() != null) {
				strSQL = strSQL.concat("    AND a.cdturno = :cdturno ");
			}
		}

		// parada com peso
		if (isComPeso == true && isSemPeso == false) {
			strSQL = strSQL.concat("    AND a.tmpparadas <> 0 ");
		}

		// parada sem peso
		if (isComPeso == false && isSemPeso == true) {
			strSQL = strSQL.concat("    AND a.tmpparadassempeso <> 0 ");
		}

		// qdo houver filtro de grupo de máquina
		if (filtro.getOmGt() != null && filtro.getOmPt() == null) {
			strSQL = strSQL.concat("  AND ginj.cdgrpinj = :cdgrpmaq ");
		}

		// qdo houver grupo de ferramenta
		if (filtro.getCdGrupoFerramenta() != null) {
			strSQL = strSQL.concat("  AND gmol.cdgrpmol = :cdgrpmol ");
		}

		// qdo houver fltro de ferramenta
		if (filtro.getDwRap() != null) {
			strSQL = strSQL.concat("  AND m.cdmolestendido = :cdmolde ");
		}

		// qdo houver filtro de produto-pai (estrutura produto)
		if (filtro.getCdProdutoPai() != null) {
			strSQL = strSQL.concat("  AND ep.cdproduto = :cdprodutopai ");
		}

		// qdo houver filtro de produto
		if (filtro.getOmProduto() != null && filtro.getOmProduto().getCdProduto() != null
				&& filtro.getOmProduto().getCdProduto().equals("") == false) {
			strSQL = strSQL.concat("  AND mp.cdproduto = :cdproduto ");
		}

		// qdo for somente a última op do turno (produtos fabricados no turno)
		if (filtro.getFiltroOp() != null && filtro.getFiltroOp() == 0 && filtro.getCdCp() == null) {
			strSQL = strSQL.concat("  AND a.nrop = i.opatual ");
		} else {
			if ((filtro.getCdCp() != null &&
					filtro.getCdCp().equals("") == false &&
					filtro.getFiltroOp() != null) &&
					(filtro.getFiltroOp() == 4 || (filtro.getFiltroOp() == 0 || filtro.getFiltroOp() == 3))) {
				strSQL = strSQL.concat("  AND a.nrop = :nrop ");
			}

		}

		// qdo houver filtro de classe ABC máquina
		if (filtro.getTpClasseABCpt() != null) {
			strSQL = strSQL.concat("  AND abcM.classe = :tpabcpt ");
		}

		// qdo houver filtro de área resp
		if (filtro.getDwtarea() != null && !filtro.getDwtarea().getCdArea().equals("") && !filtro.getDwtarea().getCdArea().equals(null)) {
			strSQL = strSQL.concat("  AND ar.cdarea = :cdarearesp ");
		}

		// qdo houver filtro de id de ijcnsUT / ijcnsturno
		if (filtro.getIdDwConsolId() != 0) {
			strSQL = strSQL.concat("  AND cns.idregistro = :idregistro ");
		}

		List<Object> listaParadasFechadas = new ArrayList<Object>();
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

		// definicao de parametros

		// filtro de máquina
		if (filtro.getOmPt() != null) {
			q.setString("cdinjetora", filtro.getOmPt().getCdPt());
		}

		// periodo e turno
		if (filtro.getTpId().equals(DwConsolidTemplate.TpId.HORA.getValue())) {
			q.setTimestamp("dthi", filtro.getDthrIhora());
			q.setTimestamp("dthf", filtro.getDthrFhora());
		} else {

			if (filtro.getDtReferencia() != null && filtro.getAnoInicial() == null) {
				q.setTimestamp("dtturno", filtro.getDtReferencia());
			}

			if (filtro.getDtReferenciaInicial() != null && filtro.getDtReferenciaFinal() != null) {
				q.setTimestamp("dti", filtro.getDtReferenciaInicial());
				q.setTimestamp("dtf", filtro.getDtReferenciaFinal());
			}
			if (filtro.getDwTurno() != null) {
				q.setString("cdturno", FuncoesApoioInjet.getStrZero(filtro.getDwTurno().getIdTurno(), 6));
			}
		}

		// qdo houver filtro de grupo de máquina
		if (filtro.getOmGt() != null && filtro.getOmPt() == null) {
			q.setString("cdgrpmaq", FuncoesApoioInjet.getStrZero(filtro.getOmGt().getIdGt(), 6));
		}

		// qdo houver grupo de ferramenta
		if (filtro.getCdGrupoFerramenta() != null) {
			q.setString("cdgrpmol", filtro.getCdGrupoFerramenta());
		}

		// qdo houver fltro de ferramenta
		if (filtro.getDwRap() != null) {
			q.setString("cdmolde", filtro.getDwRap().getCdRap());
		}

		// qdo houver filtro de produto-pai (estrutura produto)
		if (filtro.getCdProdutoPai() != null) {
			q.setString("cdprodutopai", filtro.getCdProdutoPai());
		}

		// qdo houver filtro de produto
		if (filtro.getOmProduto() != null && filtro.getOmProduto().getCdProduto() != null
				&& filtro.getOmProduto().getCdProduto().equals("") == false) {
			q.setString("cdproduto", filtro.getOmProduto().getCdProduto());
		}

		// qdo for somente a última op do turno (produtos fabricados no turno)
		if (filtro.getFiltroOp() != null && filtro.getFiltroOp() == 0 && filtro.getCdCp() == null) {
		} else {
			if ((filtro.getCdCp() != null &&
					filtro.getCdCp().equals("") == false &&
					filtro.getFiltroOp() != null) &&
					(filtro.getFiltroOp() == 4 || (filtro.getFiltroOp() == 0 || filtro.getFiltroOp() == 3))) {
				q.setString("nrop", filtro.getCdCp());
			}

		}

		// qdo houver filtro de classe ABC máquina
		if (filtro.getTpClasseABCpt() != null) {
			q.setString("tpabcpt",
					(filtro.getTpClasseABCpt().equals((byte) 0) ? "A" : filtro.getTpClasseABCpt().equals((byte) 1) ? "B" : "C"));
		}

		// qdo houver filtro de área resp
		if (filtro.getDwtarea() != null && !filtro.getDwtarea().getCdArea().equals("") && !filtro.getDwtarea().getCdArea().equals(null)) {
			q.setString("cdarearesp", filtro.getDwtarea().getCdArea());
		}

		if (filtro.getIdDwConsolId() != 0) {
			q.setLong("idregistro", filtro.getIdDwConsolId());
		}

		/*
		 * q.defineParametro("tpclasseproduto", filtro.getTpClasseABCproduto());
		 * 
		 * if (filtro.getAnoInicial() != null && filtro.getMesInicial() != null && filtro.getAnoFinal() != null && filtro.getMesFinal() !=
		 * null) { q.defineParametro("ami", (filtro.getAnoInicial() * 1000) + filtro.getMesInicial()); q.defineParametro("amf",
		 * (filtro.getAnoFinal() * 1000) + filtro.getMesFinal()); }
		 */

		listaParadasFechadas = q.list();

		return listaParadasFechadas;
	}

	@SuppressWarnings("unchecked")
	private List<DwConsolpaoco> getDwConsolpas(Byte tpId,
			Date dtHrIniHora, Date dtTurno, String cdTurno,
			String nrOP, String cdMaquina, String cdMolde, String cdEstrutura,
			Date dthrIValEstru, Date dtdhrIValCic,
			String cdParada, Boolean isComPeso, Boolean isSemPeso) {

		List<DwConsolpaoco> retorno = new ArrayList<DwConsolpaoco>();

		int _dthrIniPar = 0;
		int _dthrFimPar = _dthrIniPar + 1;
		int _isComPeso = _dthrFimPar + 1;
		int _cdParada = _isComPeso + 1;
		int _dsParada = _cdParada + 1;
		int _cdArea = _dsParada + 1;
		int _dsArea = _cdArea + 1;
		int _segTmpParCP = _dsArea + 1;
		int _segTmpParSP = _segTmpParCP + 1;
		int _pcsPerdaParCP = _segTmpParSP + 1;
		int _pcsPerdaParSP = _pcsPerdaParCP + 1;

		class RegistroLido {
			Date dthrIniPar;
			Date dthrFimPar;
			boolean isComPeso;
			String cdParada;
			String dsParada;
			String cdArea;
			String dsArea;
			BigDecimal segTmpParCP = BigDecimal.ZERO;
			BigDecimal segTmpParSP = BigDecimal.ZERO;
			BigDecimal pcsPerdaParCP = BigDecimal.ZERO;
			BigDecimal pcsPerdaParSP = BigDecimal.ZERO;
		}

		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.dthripar, a.dthrfpar, a.paradacompeso, a.cdparada, p.dsparada, p.cdarea, ar.dsarea, ");
		strSQL = strSQL.concat("       a.tmpparadas, a.tmpparadassempeso, ");
		strSQL = strSQL.concat("       ( ( a.tmpparadas / ft.ciclopadrao) * (c2.qtcavativas * ft.fatorcontagemprod) ) as qtdperdasparCP, ");
		strSQL = strSQL
				.concat("       ( ( a.tmpparadassempeso / ft.ciclopadrao) * (c2.qtcavativas * ft.fatorcontagemprod) ) as qtdperdasparSP ");

		if (tpId.equals(DwConsolidTemplate.TpId.HORA.getValue())) {
			strSQL = strSQL.concat("  FROM ijreaparcnsocorUT a ");
		} else {
			strSQL = strSQL.concat("  FROM ijreaparcnsocorTUR a ");
		}

		strSQL = strSQL.concat("  JOIN ijtbpar p ON (p.cdparada = a.cdparada) ");
		strSQL = strSQL.concat("  JOIN ijareres ar ON (ar.cdarea = p.cdarea)  ");
		strSQL = strSQL.concat(
				"  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL.concat(
				"  JOIN cavidades2 c2 ON (c2.cdmolde = ft.cdmolde AND c2.cdestrutura = ft.cdestrutura AND c2.dthrival = ft.dthrivalestru) ");

		if (tpId.equals(DwConsolidTemplate.TpId.HORA.getValue())) {
			strSQL = strSQL.concat("  WHERE a.dthriniintervalo = :dthrini ");
		} else {
			strSQL = strSQL.concat("  WHERE a.dtturno = :dtturno ");
			strSQL = strSQL.concat("    AND a.cdturno = :cdturno ");
		}

		strSQL = strSQL.concat("    AND a.cdinjetora = :cdinjetora ");
		strSQL = strSQL.concat("    AND a.cdmolde = :cdmolde ");
		strSQL = strSQL.concat("    AND a.cdestrutura = :cdestrutura ");
		strSQL = strSQL.concat("    AND a.dthrivalestru = :dthrivalestru ");
		strSQL = strSQL.concat("    AND a.dthrivalcic = :dthrivalcic ");
		strSQL = strSQL.concat("    AND a.nrop = :nrop ");
		strSQL = strSQL.concat("    AND a.cdparada = :cdparada ");

		List<Object> lista = new ArrayList<Object>();
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

		// definicao de parametros
		q.setString("cdinjetora", cdMaquina);
		q.setString("cdmolde", cdMolde);
		q.setString("cdestrutura", cdEstrutura);
		q.setTimestamp("dthrivalestru", dthrIValEstru);
		q.setTimestamp("dthrivalcic", dtdhrIValCic);
		q.setString("nrop", nrOP);
		q.setString("cdparada", cdParada);

		// periodo e turno
		if (tpId.equals(DwConsolidTemplate.TpId.HORA.getValue())) {
			q.setTimestamp("dthrini", dtHrIniHora);
		} else {
			q.setTimestamp("dtturno", dtTurno);
			q.setString("cdturno", cdTurno);
		}

		lista = q.list();

		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.dthrIniPar = (Date) registroLido[_dthrIniPar];
			registro.dthrFimPar = (Date) registroLido[_dthrFimPar];
			registro.cdParada = (String) registroLido[_cdParada];
			registro.dsParada = (String) registroLido[_dsParada];
			registro.cdArea = (String) registroLido[_cdArea];
			registro.dsArea = (String) registroLido[_dsArea];
			registro.segTmpParCP = (registroLido[_segTmpParCP] == null ? BigDecimal.ZERO
					: ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParCP]));
			registro.segTmpParSP = (registroLido[_segTmpParSP] == null ? BigDecimal.ZERO
					: ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParSP]));
			registro.pcsPerdaParCP =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet((registroLido[_pcsPerdaParCP] == null ? BigDecimal.ZERO
							: ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParCP])).setScale(0, RoundingMode.FLOOR));
			registro.pcsPerdaParSP =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet((registroLido[_pcsPerdaParSP] == null ? BigDecimal.ZERO
							: ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParSP])).setScale(0, RoundingMode.FLOOR));
			registro.isComPeso = (registro.segTmpParCP.doubleValue() > 0);

			DwConsolpaoco paoco = new DwConsolpaoco();
			paoco.setDthrIparada(registro.dthrIniPar);
			paoco.setDthrFparada(registro.dthrFimPar);

			DwTArea area = new DwTArea();
			area.setCdArea(registro.cdArea);
			area.setIdArea(ConversaoTipos.converteParaInt(area.getCdArea()));
			area.setDsArea(registro.dsArea);

			DwTCausa causa = new DwTCausa();
			DwTAcao acao = new DwTAcao();
			DwTJust just = new DwTJust();

			DwTParada par = new DwTParada();
			par.setCdTparada(registro.cdParada);

			par.setIdTparada(ConversaoTipos
					.converterParaBigDecimal(ConversaoTipos.converteStringParaSequenciaNumericaUniCode(par.getCdTparada())).longValue());
			par.setDsTparada(registro.dsParada);
			par.setDwTArea(area);

			retorno.add(paoco);
		}

		return retorno;
	}
	
    private List<LegendaDataHoraDTO> getLegendas(GraficosParettoParadaDTO datas) {
    	List<LegendaDataHoraDTO> legendas = new ArrayList<LegendaDataHoraDTO>();
    	
    	if(datas.getCorVerde() != null) {
    		LegendaDataHoraDTO legendaVerde = getLegenda(datas.getCorVerde());
        	legendaVerde.setLegendaCor(Cor.transformarParaCodigoHexadecimal(COR_LEGENDA_VERDE));
        	legendas.add(legendaVerde);
    	}
    	
    	if(datas.getCorAmarela() != null) {
    		LegendaDataHoraDTO legendaAmarelo = getLegenda(datas.getCorAmarela());
        	legendaAmarelo.setLegendaCor(Cor.transformarParaCodigoHexadecimal(COR_LEGENDA_AMARELO));
        	legendas.add(legendaAmarelo);
    	}
    	
    	if(datas.getCorLaranja() != null) {
    		LegendaDataHoraDTO legendaLaranja = getLegenda(datas.getCorLaranja());
        	legendaLaranja.setLegendaCor(Cor.transformarParaCodigoHexadecimal(COR_LEGENDA_LARANJA));
        	legendas.add(legendaLaranja);
    	}
    	
    	if(datas.getCorVermelho() != null) {
    		LegendaDataHoraDTO legendaVermelho = getLegenda(datas.getCorVermelho());
        	legendaVermelho.setLegendaCor(Cor.transformarParaCodigoHexadecimal(COR_LEGENDA_VERMELHO));
        	legendas.add(legendaVermelho);
    	}
    	
    	return legendas;
    }
    private LegendaDataHoraDTO getLegenda(DatasDTO data) {
    	LegendaDataHoraDTO legendaDTO = new LegendaDataHoraDTO();
    	legendaDTO.setDataHoraInicio(DataHoraRN.dateToString(data.getDtIAtendimento(), FORMATO_DATA_HORA));
    	legendaDTO.setDataHoraFim(DataHoraRN.dateToString(data.getDtFAtendimento(), FORMATO_DATA_HORA));
    	return legendaDTO;
    } 	

}
