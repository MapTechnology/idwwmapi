package idw.model.rn.monitorizacao.injet;

import java.awt.Color;
import java.awt.Paint;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SQLQuery;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.DwConsolrelog;
import idw.model.pojos.DwConsolreoco;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.DwTRefugo;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.geraplano.dtos.DatasDTO;
import idw.model.rn.injet.FuncoesApoioInjet;
import idw.model.rn.injet.TurnoInjetRN;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParetoRefugosDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParetoRefugosDTO;
import idw.model.rn.web.injet.bi.BiWebInjetRN;
import idw.model.rn.web.injet.bi.BiWebInjetRN.FiltroAgrupamentoBI;
import idw.util.AritmeticaUtil;
import idw.util.Cor;
import idw.util.FormulasInjet;
import idw.util.GrafTendenciaUtils;
import idw.util.IntervaloGrafTendenciaRefugoParada;
import idw.webservices.dto.OcorrenciasEvtDTO;
import idw.webservices.dto.PeriodoDTO;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.rest.dto.monitorizacao.LegendaDataHoraDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiFiltroDTO;
import ms.util.ConversaoTipos;

public class GraficoParetoRefugoInjetRN extends AbstractRN<DAOGenericoInjet> {

	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";

	public static final Color COR_LEGENDA_VERDE = Color.green;
	public static final Color COR_LEGENDA_AMARELO = Color.yellow;
	public static final Color COR_LEGENDA_LARANJA = Color.orange;
	public static final Color COR_LEGENDA_VERMELHO = Color.red;
	
	class RegistroLidoRefugo {
		Date dthrRefugo;
		String cdInjetora;
		String cdInjEstendido;
		String cdIdentific;
		String cdMolde;
		String cdMolEstendido;
		String cdEstrutura;
		Date dthrIValCic;
		Date dthrIValEstru;
		String nrop;
		String nropExibicao;
		Date dthrIRealOP;
		String cdAcao;
		String dsAcao;
		String cdCausa;
		String dsCausa;
		String cdRefugo;
		String dsRefugo;
		String cdArea;
		String dsArea;
		BigDecimal qtRef = BigDecimal.ZERO;
		BigDecimal qtRefGr = BigDecimal.ZERO;
		Character idReduzido;
		String cdProduto;
		String dsProduto;
	}

	class RegistroLido {
		String cdRefugo;
		String dsRefugo;
		BigDecimal qtRef = BigDecimal.ZERO;
		BigDecimal qtRefGr = BigDecimal.ZERO;
		Date dthrMin;
		Date dthrMax;
		Date dthrIniRealMin;
	}

	private static final Comparator<GraficoParetoRefugosDTO> comparaIndiceRefugo = new Comparator<GraficoParetoRefugosDTO>() {
		@Override
		public int compare(GraficoParetoRefugosDTO o1, GraficoParetoRefugosDTO o2) {
			return o1.getIndiceRefugo().compareTo(o2.getIndiceRefugo()) * -1;
		}
	};

	public GraficoParetoRefugoInjetRN() {
		this(new DAOGenericoInjet());
	}

	public GraficoParetoRefugoInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	@SuppressWarnings("unchecked")
	public GraficosParetoRefugosDTO getGraficoParetoRefugoDTO(Byte tpId, Date dtInicial, Date dtFinal, BigDecimal idTurno, String cdPt,
			String cdCp, BigDecimal totalRefugado, String cdProduto) {

		int _dthrRefugo = 0;
		int _cdInjetora = _dthrRefugo + 1;
		int _cdInjEstendido = _cdInjetora + 1;
		int _cdIdentific = _cdInjEstendido + 1;
		int _cdMolde = _cdIdentific + 1;
		int _cdMolEstendido = _cdMolde + 1;
		int _cdEstrutura = _cdMolEstendido + 1;
		int _dthrIValCic = _cdEstrutura + 1;
		int _dthrIValEstru = _dthrIValCic + 1;
		int _nrop = _dthrIValEstru + 1;
		int _nropExibicao = _nrop + 1;
		int _dthrIRealOP = _nropExibicao + 1;
		int _cdAcao = _dthrIRealOP + 1;
		int _dsAcao = _cdAcao + 1;
		int _cdCausa = _dsAcao + 1;
		int _dsCausa = _cdCausa + 1;
		int _cdRefugo = _dsCausa + 1;
		int _dsRefugo = _cdRefugo + 1;
		int _cdArea = _dsRefugo + 1;
		int _dsArea = _cdArea + 1;
		int _qtRef = _dsArea + 1;
		int _qtRefGr = _qtRef + 1;
		int _idReduzido = _qtRefGr + 1;
		int _cdProduto = _idReduzido + 1;
		int _dsProduto = _cdProduto + 1;

		Date dthrMenorInicioRealOP = null;
		Date dthrIniPeriodo = null;
		Date dthrFimPeriodo = null;
		Date dthrAtual = null;

		Date menorDthrOcor = null;
		Date maiorDthrOcor = null;

		String cdTurno = "";
		if (idTurno != null && idTurno.longValue() > 0) {
			cdTurno = FuncoesApoioInjet.getStrZero(idTurno.longValue(), 6);
		}

		TurnoInjetRN rnT = new TurnoInjetRN(getDao());
		List<PeriodoDTO> listaPeriodos = rnT.getIntervalosPeriodo(dtInicial, dtFinal, cdTurno);

		dthrAtual = DataHoraRN.getDataHoraAtual();
		dthrIniPeriodo = listaPeriodos.get(0).getDtHrInicio();
		dthrFimPeriodo = listaPeriodos.get(listaPeriodos.size() - 1).getDtHrFim();

		if (DataHoraRN.after(dthrFimPeriodo, dthrAtual)) {
			dthrFimPeriodo = dthrAtual;
		}

		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.dthrirefugo, a.cdinjetora, i.cdinjestendido, i.cdidentific, ");
		strSQL = strSQL.concat("       a.cdmolde, m.cdmolestendido, a.cdestrutura, a.dthrivalcic, a.dthrivalestru, ");
		strSQL = strSQL.concat("       a.nrop, rot.nropexibicao, op.dthrireal, ");
		strSQL = strSQL.concat("       a.cdacoes, aco.dsacoes,  a.cdcausas, cau.dscausas, ");
		strSQL = strSQL.concat("       a.cdrefugo, r.dsrefugo, r.cdarea, ar.dsarea, ");
		strSQL = strSQL.concat("       a.qtrefugada, (a.qtrefugada * c.pbrutomedio) as qtrefugadagr, ");
		strSQL = strSQL.concat("       a.cdidentificacao, c.cdproduto, p.dsproduto ");
		strSQL = strSQL.concat("  FROM ijrearef a ");
		strSQL = strSQL.concat("  JOIN ijop op ON (op.nrop = a.nrop) ");
		strSQL = strSQL.concat("  JOIN ijtbref b ON (b.cdrefugo = a.cdrefugo) ");
		strSQL = strSQL.concat(
				"  JOIN ijmolpro c ON (c.cdmolde = a.cdmolde AND c.cdestrutura = a.cdestrutura AND c.dthrival = a.dthrivalestru AND c.cdidentificacao = a.cdidentificacao) ");
		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol m ON (m.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbref r ON (r.cdrefugo = a.cdrefugo) ");
		strSQL = strSQL.concat("  JOIN ijtbpro p ON (p.cdproduto = c.cdproduto) ");
		strSQL = strSQL.concat(
				"  JOIN ijoproteiro rot ON (rot.nrop = a.nrop AND rot.cdinjetora = a.cdinjetora AND rot.cdmolde = a.cdmolde AND rot.cdestrutura = a.cdestrutura) ");
		strSQL = strSQL.concat("  LEFT JOIN ijareres ar ON (ar.cdarea = r.cdarea) ");
		strSQL = strSQL.concat("  LEFT JOIN ijtbaco aco ON (aco.cdacoes = a.cdacoes) ");
		strSQL = strSQL.concat("  LEFT JOIN ijtbcau cau ON (cau.cdcausas = a.cdcausas) ");
		strSQL = strSQL.concat(" WHERE (a.lcancelado = 0  OR a.lcancelado IS NULL)");

		// máquina
		if (!cdPt.equals("") && !cdPt.equals(null)) {
			strSQL = strSQL.concat("   AND i.cdinjestendido = :cdinjetora ");
		}

		// op
		if (!cdCp.equals("") && !cdCp.equals(null)) {
			strSQL = strSQL.concat("   AND a.nrop = :nrop ");
		}

		if (cdTurno.equals("")) {
			strSQL = strSQL.concat(" AND a.dthrirefugo BETWEEN :dthrini AND :dthrfim ");
		}

		if (cdProduto != null && cdProduto != "") {
			strSQL = strSQL.concat("   AND c.cdproduto = :cdproduto ");
		}

		strSQL = strSQL.concat(" ORDER BY a.dthrirefugo");

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

		// máquina
		if (!cdPt.equals("") && !cdPt.equals(null)) {
			q.setString("cdinjetora", cdPt);
		}

		// op
		if (!cdCp.equals("") && !cdCp.equals(null)) {
			q.setString("nrop", cdCp);
		}

		// produto
		if (cdProduto != null && cdProduto != "") {
			q.setString("cdproduto", cdProduto);
		}

		if (cdTurno.equals("")) {
			Date dthrIni = listaPeriodos.get(0).getDtHrInicio();
			Date dthrFim = listaPeriodos.get(listaPeriodos.size() - 1).getDtHrFim();
			q.setTimestamp("dthrini", dthrIni)
					.setTimestamp("dthrfim", dthrFim);
		}

		List<GraficoParetoRefugosDTO> refugos = new ArrayList<GraficoParetoRefugosDTO>();
		HashMap<String, GraficoParetoRefugosDTO> mapRefugos = new HashMap<String, GraficoParetoRefugosDTO>();
		HashMap<String, List<OcorrenciasEvtDTO>> mapOcorrenciasPorRefugo = new HashMap<String, List<OcorrenciasEvtDTO>>();
		HashMap<String, BigDecimal> mapIndicePorRefugo = new HashMap<String, BigDecimal>();

		List<Object> lista = new ArrayList<Object>();
		lista = q.list();

		for (Object reg : lista) {
			RegistroLidoRefugo registro = new RegistroLidoRefugo();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.dthrRefugo = (Date) registroLido[_dthrRefugo];

			boolean isRegistroOK = true;
			if (!cdTurno.equals("")) {
				isRegistroOK = false;
				for (PeriodoDTO p : listaPeriodos) {
					if (DataHoraRN.existeIntersecaoDatas(p.getDtHrInicio(), p.getDtHrFim(), registro.dthrRefugo, registro.dthrRefugo)) {
						isRegistroOK = true;
						break;
					}
				}
			}

			if (isRegistroOK) {
				registro.cdInjetora = (String) registroLido[_cdInjetora];
				registro.cdInjEstendido = (String) registroLido[_cdInjEstendido];
				registro.cdIdentific = (String) registroLido[_cdIdentific];

				registro.cdMolde = (String) registroLido[_cdMolde];
				registro.cdMolEstendido = (String) registroLido[_cdMolEstendido];
				registro.cdEstrutura = (String) registroLido[_cdEstrutura];
				registro.dthrIValCic = (Date) registroLido[_dthrIValCic];
				registro.dthrIValEstru = (Date) registroLido[_dthrIValEstru];

				registro.nrop = (String) registroLido[_nrop];
				registro.nropExibicao = (String) registroLido[_nropExibicao];
				registro.dthrIRealOP = (Date) registroLido[_dthrIRealOP];

				registro.cdCausa = (registroLido[_cdCausa] == null ? "" : (String) registroLido[_cdCausa]);
				registro.dsCausa = (registroLido[_dsCausa] == null ? "" : (String) registroLido[_dsCausa]);
				registro.cdAcao = (registroLido[_cdAcao] == null ? "" : (String) registroLido[_cdAcao]);
				registro.dsAcao = (registroLido[_dsAcao] == null ? "" : (String) registroLido[_dsAcao]);

				registro.cdRefugo = (String) registroLido[_cdRefugo];
				registro.dsRefugo = (String) registroLido[_dsRefugo];
				registro.cdArea = (registroLido[_cdArea] == null ? "" : (String) registroLido[_cdArea]);
				registro.dsArea = (registroLido[_dsArea] == null ? "" : (String) registroLido[_dsArea]);

				registro.qtRef =
						ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtRef]));
				registro.qtRefGr = ConfiguracoesInjetRN
						.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtRefGr]));

				registro.cdProduto = (String) registroLido[_cdProduto];
				registro.dsProduto = (String) registroLido[_dsProduto];
				registro.idReduzido = (Character) registroLido[_idReduzido];

				GraficoParetoRefugosDTO refugoGraf = mapRefugos.get(registro.cdRefugo);

				// Se for um motivo de refugo que esta ocorrendo a primeira vez, entao criar um mapRefugo
				if (refugoGraf == null) {
					refugoGraf = new GraficoParetoRefugosDTO();

					refugoGraf.setIdTRefugo(ConversaoTipos.converteParaBigDecimal(registro.cdRefugo).longValue());
					refugoGraf.setCdRefugo(registro.cdRefugo);
					refugoGraf.setDsRefugo(registro.dsRefugo);

					refugoGraf.setQtdRefugada(registro.qtRef.doubleValue());
					refugoGraf.setQtdRefugadaKg(registro.qtRefGr.divide(new BigDecimal(1000), BigDecimal.ROUND_HALF_EVEN).doubleValue());
					refugoGraf
							.setQtdRefugadaTon(registro.qtRefGr.divide(new BigDecimal(1000000), BigDecimal.ROUND_HALF_EVEN).doubleValue());

					BigDecimal qtdRefMap = mapIndicePorRefugo.get(registro.cdRefugo);
					if (qtdRefMap == null) {
						qtdRefMap = registro.qtRef;
						mapIndicePorRefugo.put(registro.cdRefugo, qtdRefMap);
					}

					double indiceRefugo = FormulasInjet.calcularIndiceRefugo(registro.qtRef, totalRefugado).doubleValue();
					refugoGraf.setIndiceRefugo(indiceRefugo);

					// List<DwConsolrelog> listaOcorrencias = new ArrayList<DwConsolrelog>();
					DwConsolrelog reflog = getDwConsolrelog(registro);

					ProdutoDTO produtoDTO = null;
					for (ProdutoDTO dto : refugoGraf.getRefugosPorProduto()) {
						if (dto.getProduto().getCdProduto().equals(registro.cdProduto))
							produtoDTO = dto;
					}

					if (produtoDTO == null) {
						produtoDTO = new ProdutoDTO();
						produtoDTO.setProduto(reflog.getOmProduto());
						produtoDTO.setPcsProducaoRefugada(BigDecimal.ZERO);
						refugoGraf.getRefugosPorProduto().add(produtoDTO);
					}

					produtoDTO.setPcsProducaoRefugada(produtoDTO.getPcsProducaoRefugada().add(registro.qtRef));

					// PEGA MAIOR E MENOR DATA/HORA DE OCORR�NCIA DE REFUGO
					menorDthrOcor = getMenorDthrOcor(registro.dthrRefugo, menorDthrOcor);
					maiorDthrOcor = getMaiorDthrOcor(registro.dthrRefugo, maiorDthrOcor);

					List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorRefugo.get(registro.cdRefugo);
					if (listaOcoDTO == null) {
						listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
						OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
						ocoDTO.setIdEvt(ConversaoTipos.converteParaBigDecimal(registro.cdRefugo).longValue());
						ocoDTO.setDthrIni(registro.dthrRefugo);
						ocoDTO.setDthrFim(registro.dthrRefugo);
						ocoDTO.setQuantidade(registro.qtRef);

						int duracaoEvt = 0;
						ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
						ocoDTO.setMsDtHrIni(BigDecimal.ZERO);
						ocoDTO.setMsDtHrFim(BigDecimal.ZERO);

						listaOcoDTO.add(ocoDTO);
						mapOcorrenciasPorRefugo.put(registro.cdRefugo, listaOcoDTO);
					} else {
						OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
						ocoDTO.setIdEvt(ConversaoTipos.converteParaBigDecimal(registro.cdRefugo).longValue());
						ocoDTO.setDthrIni(registro.dthrRefugo);
						ocoDTO.setDthrFim(registro.dthrRefugo);
						ocoDTO.setQuantidade(registro.qtRef);

						int duracaoEvt = 0;

						ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
						ocoDTO.setMsDtHrIni(BigDecimal.ZERO);
						ocoDTO.setMsDtHrFim(BigDecimal.ZERO);

						listaOcoDTO.add(ocoDTO);
					}
					mapRefugos.put(registro.cdRefugo, refugoGraf);
					refugos.add(refugoGraf);

				} else {

					BigDecimal qtdref = new BigDecimal(mapRefugos.get(registro.cdRefugo).getQtdRefugada());
					qtdref = AritmeticaUtil.somar(qtdref, registro.qtRef);

					refugoGraf.setQtdRefugada(qtdref.doubleValue());

					BigDecimal qtdrefGr = new BigDecimal(mapRefugos.get(registro.cdRefugo).getQtdRefugadaKg() * 1000);
					qtdrefGr = AritmeticaUtil.somar(qtdrefGr, registro.qtRefGr);

					// producao refugada em kg e ton
					refugoGraf.setQtdRefugadaKg(qtdrefGr.divide(new BigDecimal(1000), BigDecimal.ROUND_HALF_EVEN).doubleValue());
					refugoGraf.setQtdRefugadaTon(qtdrefGr.divide(new BigDecimal(1000000), BigDecimal.ROUND_HALF_EVEN).doubleValue());

					BigDecimal qtdRefMap = mapIndicePorRefugo.get(registro.cdRefugo);
					if (qtdRefMap == null) {
						qtdRefMap = qtdref;
						mapIndicePorRefugo.put(registro.cdRefugo, qtdRefMap);
					}

					double indiceRefugo = FormulasInjet.calcularIndiceRefugo(qtdref, totalRefugado).doubleValue();
					refugoGraf.setIndiceRefugo(indiceRefugo);

					// List<DwConsolrelog> listaOcorrencias = new ArrayList<DwConsolrelog>();
					DwConsolrelog reflog = getDwConsolrelog(registro);

					ProdutoDTO produtoDTO = null;
					for (ProdutoDTO dto : refugoGraf.getRefugosPorProduto()) {
						if (dto.getProduto().getCdProduto().equals(registro.cdProduto)) {
							produtoDTO = dto;
						}
					}
					if (produtoDTO == null) {
						produtoDTO = new ProdutoDTO();
						produtoDTO.setProduto(reflog.getOmProduto());
						produtoDTO.setPcsProducaoRefugada(BigDecimal.ZERO);
						refugoGraf.getRefugosPorProduto().add(produtoDTO);
					}
					produtoDTO.setPcsProducaoRefugada(produtoDTO.getPcsProducaoRefugada().add(qtdref));

					List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorRefugo.get(registro.cdRefugo);
					if (listaOcoDTO != null) {
						OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
						ocoDTO.setIdEvt(ConversaoTipos.converteParaBigDecimal(registro.cdRefugo).longValue());
						ocoDTO.setDthrIni(registro.dthrRefugo);
						ocoDTO.setDthrFim(registro.dthrRefugo);

						int duracaoEvt = 0;
						ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
						ocoDTO.setMsDtHrIni(BigDecimal.ZERO);
						ocoDTO.setMsDtHrFim(BigDecimal.ZERO);

						listaOcoDTO.add(ocoDTO);
					}
				}

				if (dthrMenorInicioRealOP == null) {
					dthrMenorInicioRealOP = registro.dthrIRealOP;
				} else {
					if (DataHoraRN.after(dthrMenorInicioRealOP, registro.dthrIRealOP)) {
						dthrMenorInicioRealOP = registro.dthrIRealOP;
					}
				}
			}
		}

		GrafTendenciaUtils algoritmoGraf = null;

		// MONTA O GRAFICO - NESTE MOMENTO É DEFINIDO O INTERVALO DE CORES
		if (menorDthrOcor != null && maiorDthrOcor != null) {
			// algoritmoGraf = new GrafTendenciaUtils(menorDthrOcor, maiorDthrOcor);
			// algoritmoGraf = new GrafTendenciaUtils(menorDthrInicioParada, maiorDthrFimParada);
			if (DataHoraRN.after(dthrMenorInicioRealOP, dthrIniPeriodo)) {
				dthrIniPeriodo = dthrMenorInicioRealOP;
			}
			algoritmoGraf = new GrafTendenciaUtils(dthrIniPeriodo, dthrFimPeriodo);
		}

		GraficosParetoRefugosDTO retorno = new GraficosParetoRefugosDTO();
		retorno.setRefugos(refugos);
		DatasDTO datas =
				new DatasDTO();
		datas.setDtIAtendimento(DataHoraRN.getDataHoraAtual());
		datas.setDtFAtendimento(DataHoraRN.getDataHoraAtual());
		retorno.setCorAmarela(datas);
		retorno.setCorLaranja(datas);
		retorno.setCorVerde(datas);
		retorno.setCorVermelho(datas);

		if (totalRefugado.compareTo(BigDecimal.ZERO) >= 1) {
			//Defeito #6543 - Web: Paretto de refugos do web está exibindo cores diferente do paretto de refugos do injet
			mapOcorrenciasPorRefugo = getOcorrenciasPorFaixaPeriodoFichaPT(algoritmoGraf, dthrIniPeriodo, dthrFimPeriodo, cdTurno, cdPt, cdCp, cdProduto);	
			defineCoresLegendaEBarra(algoritmoGraf, retorno, mapRefugos, mapOcorrenciasPorRefugo);
		}

		
		Collections.sort(retorno.getRefugos(),
				new Comparator<GraficoParetoRefugosDTO>() {
					@Override
					public int compare(final GraficoParetoRefugosDTO o1,
							final GraficoParetoRefugosDTO o2) {
						final GraficoParetoRefugosDTO item1 = o1;
						final GraficoParetoRefugosDTO item2 = o2;

						return -(item1.getIndiceRefugo().compareTo(item2.getIndiceRefugo()));
					}
				});

		return retorno;
	}

	@SuppressWarnings("unchecked")
	public GraficosParetoRefugosDTO getGraficoParetoRefugoBiDTO(BiFiltroDTO filtroBIRefugo) {
		BigDecimal totalRefugado = BigDecimal.ZERO;
		BigDecimal totalRefugadoGr = BigDecimal.ZERO;

		int _cdrefugo = 0;
		int _dsrefugo = _cdrefugo + 1;
		int _qtrefUB = _dsrefugo + 1;
		int _qtrefGr = _qtrefUB + 1;
		int _dthrMin = _qtrefGr + 1;
		int _dthrMax = _dthrMin + 1;
		int _dthrIniRealMin = _dthrMax + 1;

		Date dthrIniPeriodo = null;
		Date dthrFimPeriodo = null;
		Date dthrAtual = null;

		Date menorDthrOcor = null;
		Date maiorDthrOcor = null;

		// se filtro for por ano e mes tem que converter para data
		BiWebInjetRN biRN = new BiWebInjetRN(getDao(), FORMATO_DATA, FORMATO_DATA_HORA);
		BiFiltroDTO filtroBI = biRN.cloneBiFiltroDTO(filtroBIRefugo);

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
		PeriodoDTO periodo = null;
		periodo = rnT.getIniFimPeriodo(filtroBI.getDtIniDt(), filtroBI.getDtFimDt(), filtroBI.getCdTurno());
		
		dthrAtual = DataHoraRN.getDataHoraAtual();
		dthrIniPeriodo = periodo.getDtHrInicio();
		dthrFimPeriodo = periodo.getDtHrFim();

		if (DataHoraRN.after(dthrFimPeriodo, dthrAtual)) {
			dthrFimPeriodo = dthrAtual;
		}

		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.cdrefugo, r.dsrefugo, ");
		strSQL = strSQL.concat("       SUM(a.qtrefugada / dc.divisorUB) as qtrefugada, ");
		strSQL = strSQL.concat("       SUM((a.qtrefugada / dc.divisorUB) * c.pbrutomedio) as qtrefugadagr, ");
		strSQL = strSQL.concat("       MIN(a.dthrirefugo) as dthrmin, ");
		strSQL = strSQL.concat("       MAX(a.dthrirefugo) as dthrmax, ");
		strSQL = strSQL.concat("       MIN(op.dthrireal) as dthrIniRealMin ");
		strSQL = strSQL.concat("  FROM ijrearef a ");
		strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");

		if (filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat("  JOIN ijcnsTurIniFim ht ON (ht.dtref BETWEEN :dtini AND :dtfim) ");
		} else {
			strSQL = strSQL.concat("  JOIN ijcnsTurIniFim ht ON (ht.dtref BETWEEN :dtini AND :dtfim AND ht.cdturno = :cdturno) ");
		}

		strSQL = strSQL.concat(
				"  JOIN ijoproteiro rot ON (rot.nrop = a.nrop AND rot.cdinjetora = a.cdinjetora AND rot.cdmolde = a.cdmolde AND rot.cdestrutura = a.cdestrutura) ");
		strSQL = strSQL.concat("  JOIN ijop op ON (op.nrop = a.nrop)  ");

		strSQL = strSQL.concat("  JOIN ijtbref r ON (r.cdrefugo = a.cdrefugo) ");
		strSQL = strSQL.concat(
				"  JOIN ijmolpro c ON (c.cdmolde = a.cdmolde AND c.cdestrutura = a.cdestrutura AND c.dthrival = a.dthrivalestru AND c.cdidentificacao = a.cdidentificacao) ");
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

		strSQL = strSQL.concat(" WHERE (a.lcancelado = 0  OR a.lcancelado IS NULL)");
		strSQL = strSQL.concat("   AND a.dthrirefugo BETWEEN  ht.dthrini AND ht.dthrfim ");

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

		strSQL = strSQL.concat(" GROUP BY a.cdrefugo, r.dsrefugo ");

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

		List<GraficoParetoRefugosDTO> refugos = new ArrayList<GraficoParetoRefugosDTO>();
		HashMap<String, GraficoParetoRefugosDTO> mapRefugos = new HashMap<String, GraficoParetoRefugosDTO>();
		HashMap<String, GraficoParetoRefugosDTO> mapRefugosGr = new HashMap<String, GraficoParetoRefugosDTO>();
		HashMap<String, List<OcorrenciasEvtDTO>> mapOcorrenciasPorRefugo = new HashMap<String, List<OcorrenciasEvtDTO>>();

		List<Object> lista = new ArrayList<Object>();
		lista = q.list();

		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdRefugo = (String) registroLido[_cdrefugo];
			registro.dsRefugo = (String) registroLido[_dsrefugo];
			registro.qtRef = ConversaoTipos.converterParaBigDecimal(registroLido[_qtrefUB]);
			registro.qtRefGr = ConversaoTipos.converterParaBigDecimal(registroLido[_qtrefGr]);
			registro.dthrMin = (Date) registroLido[_dthrMin];
			registro.dthrMax = (Date) registroLido[_dthrMax];
			registro.dthrIniRealMin = (Date) registroLido[_dthrIniRealMin];

			GraficoParetoRefugosDTO refugoGraf = new GraficoParetoRefugosDTO();
			totalRefugado = AritmeticaUtil.somar(totalRefugado, registro.qtRef);
			totalRefugadoGr = AritmeticaUtil.somar(totalRefugadoGr, registro.qtRefGr);

			refugoGraf = new GraficoParetoRefugosDTO();

			refugoGraf.setIdTRefugo(ConversaoTipos.converteParaBigDecimal(registro.cdRefugo).longValue());
			refugoGraf.setCdRefugo(registro.cdRefugo);
			refugoGraf.setDsRefugo(registro.dsRefugo);

			refugoGraf.setQtdRefugada(registro.qtRef.doubleValue());
			refugoGraf.setQtdRefugadaKg(registro.qtRefGr.divide(BiWebInjetRN.DIVISOR_KG, BigDecimal.ROUND_HALF_EVEN).doubleValue());
			refugoGraf.setQtdRefugadaTon(registro.qtRefGr.divide(BiWebInjetRN.DIVISOR_TON, BigDecimal.ROUND_HALF_EVEN).doubleValue());

			// PEGA MAIOR E MENOR DATA/HORA DE OCORR�NCIA DE REFUGO
			menorDthrOcor = getMenorDthrOcor(registro.dthrMin, menorDthrOcor);
			maiorDthrOcor = getMaiorDthrOcor(registro.dthrMax, maiorDthrOcor);

			refugos.add(refugoGraf);

			// maps utilizados na definicao das cores de cada barras/refugo
			mapRefugos.put(registro.cdRefugo, refugoGraf);
			mapRefugosGr.put(registro.cdRefugo, cloneGraficoParetoRefugosDTO(refugoGraf));

			List<OcorrenciasEvtDTO> listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
			OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
			ocoDTO.setIdEvt(ConversaoTipos.converteParaBigDecimal(registro.cdRefugo).longValue());
			ocoDTO.setDthrIni(registro.dthrMin);
			ocoDTO.setDthrFim(registro.dthrMax);
			ocoDTO.setQuantidade(registro.qtRef);

			int duracaoEvt = 0;
			ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
			ocoDTO.setMsDtHrIni(BigDecimal.ZERO);
			ocoDTO.setMsDtHrFim(BigDecimal.ZERO);

			listaOcoDTO.add(ocoDTO);
			mapOcorrenciasPorRefugo.put(registro.cdRefugo, listaOcoDTO);

		}

		// calcular indice de refugo (indice no pareto)
		Set<String> cdRefugos = mapRefugos.keySet();
		for (String keyRef : cdRefugos) {
			mapRefugos.get(keyRef).setIndiceRefugo(FormulasInjet.calcularIndiceRefugo(new BigDecimal(mapRefugos.get(keyRef).getQtdRefugada()), totalRefugado).doubleValue());
			mapRefugos.get(keyRef).setIndiceRefugo(ConversaoTipos.converteParaDouble(mapRefugos.get(keyRef).getIndiceRefugo(),2));			
			mapRefugos.get(keyRef).setIndiceRefugoGr(FormulasInjet.calcularIndiceRefugo(AritmeticaUtil.multiplicar(new BigDecimal(mapRefugos.get(keyRef).getQtdRefugadaKg()), new BigDecimal(1000)), totalRefugadoGr).doubleValue());
			mapRefugos.get(keyRef).setIndiceRefugoGr(ConversaoTipos.converteParaDouble(mapRefugos.get(keyRef).getIndiceRefugoGr(),2));	
			
			mapRefugosGr.get(keyRef).setIndiceRefugo(cloneGraficoParetoRefugosDTO(mapRefugos.get(keyRef)).getIndiceRefugoGr());
		}

		GrafTendenciaUtils algoritmoGraf = null;

		// MONTA O GRAFICO - NESTE MOMENTO É DEFINIDO O INTERVALO DE CORES
		if (menorDthrOcor != null && maiorDthrOcor != null) {
			algoritmoGraf = new GrafTendenciaUtils(dthrIniPeriodo, dthrFimPeriodo);
		}

		GraficosParetoRefugosDTO retorno = new GraficosParetoRefugosDTO();
		retorno.setRefugos(refugos);
		retorno.setRefugosGr(refugos);
		
		DatasDTO datas = new DatasDTO();
		datas.setDtIAtendimento(DataHoraRN.getDataHoraAtual());
		datas.setDtFAtendimento(DataHoraRN.getDataHoraAtual());
		retorno.setCorAmarela(datas);
		retorno.setCorLaranja(datas);
		retorno.setCorVerde(datas);
		retorno.setCorVermelho(datas);
		
		if (totalRefugado.compareTo(BigDecimal.ZERO) >= 1) {
			mapOcorrenciasPorRefugo = getOcorrenciasPorFaixaPeriodo(algoritmoGraf, filtroBI);			
			defineCoresLegendaEBarraBI(algoritmoGraf, retorno, mapRefugos, mapRefugosGr, mapOcorrenciasPorRefugo);
		}

		for (GraficoParetoRefugosDTO refugo : retorno.getRefugos()) {
			String cor = refugo.getCorBarra();
			refugo.setCorBarra(Cor.transformarColorParaCodigoHexadecimal(cor));
		}
		
		for (GraficoParetoRefugosDTO refugo : retorno.getRefugosGr()) {
			String cor = refugo.getCorBarra();
			refugo.setCorBarra(Cor.transformarColorParaCodigoHexadecimal(cor));
		}

		retorno.setLegendas(getLegendas(retorno));
		
		Collections.sort(retorno.getRefugos(), comparaIndiceRefugo);
		Collections.sort(retorno.getRefugosGr(), comparaIndiceRefugo);

		return retorno;
	}

	@SuppressWarnings("unchecked")
	private HashMap<String, List<OcorrenciasEvtDTO>> getOcorrenciasPorFaixaPeriodo(GrafTendenciaUtils algoritmoGraf, BiFiltroDTO filtroBI) {
		HashMap<String, List<OcorrenciasEvtDTO>> retorno = new HashMap<String, List<OcorrenciasEvtDTO>>();

		int _cdrefugo = 0;
		int _qtrefUB = _cdrefugo + 1;

		String strSQL = "";

		for (int i = GrafTendenciaUtils.SERIE_VERDE; i <= GrafTendenciaUtils.SERIE_LARANJA; i++) {
			strSQL = "";

			strSQL = strSQL.concat("SELECT a.cdrefugo, ");
			strSQL = strSQL.concat("       SUM(a.qtrefugada / dc.divisorUB) as qtrefugada ");
			strSQL = strSQL.concat("  FROM ijrearef a ");
			strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");

			if (filtroBI.getCdTurno().equals("")) {
				strSQL = strSQL.concat("  JOIN ijcnsTurIniFim ht ON (ht.dtref BETWEEN :dtini AND :dtfim) ");
			} else {
				strSQL = strSQL.concat("  JOIN ijcnsTurIniFim ht ON (ht.dtref BETWEEN :dtini AND :dtfim AND ht.cdturno = :cdturno) ");
			}

			strSQL = strSQL.concat(
					"  JOIN ijoproteiro rot ON (rot.nrop = a.nrop AND rot.cdinjetora = a.cdinjetora AND rot.cdmolde = a.cdmolde AND rot.cdestrutura = a.cdestrutura) ");
			strSQL = strSQL.concat("  JOIN ijop op ON (op.nrop = a.nrop)  ");

			strSQL = strSQL.concat("  JOIN ijtbref r ON (r.cdrefugo = a.cdrefugo) ");
			strSQL = strSQL.concat(
					"  JOIN ijmolpro c ON (c.cdmolde = a.cdmolde AND c.cdestrutura = a.cdestrutura AND c.dthrival = a.dthrivalestru AND c.cdidentificacao = a.cdidentificacao) ");
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

			strSQL = strSQL.concat(" WHERE (a.lcancelado = 0  OR a.lcancelado IS NULL)");
			strSQL = strSQL.concat("   AND a.dthrirefugo BETWEEN  ht.dthrini AND ht.dthrfim ");
			strSQL = strSQL.concat("   AND a.dthrirefugo BETWEEN  :dthrIniFaixa AND :dthrFimFaixa ");

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

			strSQL = strSQL.concat(" GROUP BY a.cdrefugo, r.dsrefugo ");

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

				registro.cdRefugo = (String) registroLido[_cdrefugo];
				registro.qtRef = ConversaoTipos.converterParaBigDecimal(registroLido[_qtrefUB]);


				List<OcorrenciasEvtDTO> listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
				OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
				ocoDTO.setIdEvt(ConversaoTipos.converteParaBigDecimal(registro.cdRefugo).longValue());
				ocoDTO.setDthrIni(algoritmoGraf.getIntervaloGrafTend().get(i).getIntervaloDtHrIni());
				ocoDTO.setDthrFim(algoritmoGraf.getIntervaloGrafTend().get(i).getIntervaloDtHrIni());
				ocoDTO.setQuantidade(registro.qtRef);

				int duracaoEvt = 0;
				ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
				ocoDTO.setMsDtHrIni(BigDecimal.ZERO);
				ocoDTO.setMsDtHrFim(BigDecimal.ZERO);
				
				listaOcoDTO = retorno.get(registro.cdRefugo);
				if (listaOcoDTO == null) {
					listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
				}
				
				listaOcoDTO.add(ocoDTO);
				
				
				retorno.put(registro.cdRefugo, listaOcoDTO);

			}
		}

		return retorno;
	}

	@SuppressWarnings("unchecked")
	private HashMap<String, List<OcorrenciasEvtDTO>> getOcorrenciasPorFaixaPeriodoFichaPT(GrafTendenciaUtils algoritmoGraf,
			Date dthrIniPeriodo, Date dthrFimPeriodo, String cdTurno,
			String cdPt, String cdCp, String cdProduto) {
		HashMap<String, List<OcorrenciasEvtDTO>> retorno = new HashMap<String, List<OcorrenciasEvtDTO>>();

		int _cdrefugo = 0;
		int _qtrefUB = _cdrefugo + 1;

		String strSQL = "";

		for (int i = GrafTendenciaUtils.SERIE_VERDE; i <= GrafTendenciaUtils.SERIE_LARANJA; i++) {
			strSQL = "";

			strSQL = strSQL.concat("SELECT a.cdrefugo, ");
			strSQL = strSQL.concat("       SUM(a.qtrefugada / dc.divisorUB) as qtrefugada ");
			strSQL = strSQL.concat("  FROM ijrearef a ");
			strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
			strSQL = strSQL.concat("  JOIN ijop op ON (op.nrop = a.nrop) ");
			strSQL = strSQL.concat("  JOIN ijtbref b ON (b.cdrefugo = a.cdrefugo) ");
			strSQL = strSQL.concat("  JOIN ijmolpro c ON (c.cdmolde = a.cdmolde AND c.cdestrutura = a.cdestrutura AND c.dthrival = a.dthrivalestru AND c.cdidentificacao = a.cdidentificacao) ");
			strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
			strSQL = strSQL.concat("  JOIN ijtbmol m ON (m.cdmolde = a.cdmolde) ");
			strSQL = strSQL.concat("  JOIN ijtbref r ON (r.cdrefugo = a.cdrefugo) ");
			strSQL = strSQL.concat("  JOIN ijtbpro p ON (p.cdproduto = c.cdproduto) ");
			strSQL = strSQL.concat("  JOIN ijoproteiro rot ON (rot.nrop = a.nrop AND rot.cdinjetora = a.cdinjetora AND rot.cdmolde = a.cdmolde AND rot.cdestrutura = a.cdestrutura) ");
			strSQL = strSQL.concat("  LEFT JOIN ijareres ar ON (ar.cdarea = r.cdarea) ");
			strSQL = strSQL.concat("  LEFT JOIN ijtbaco aco ON (aco.cdacoes = a.cdacoes) ");
			strSQL = strSQL.concat("  LEFT JOIN ijtbcau cau ON (cau.cdcausas = a.cdcausas) ");
			strSQL = strSQL.concat(" WHERE (a.lcancelado = 0  OR a.lcancelado IS NULL)");

			// máquina
			if (!cdPt.equals("") && !cdPt.equals(null)) {
				strSQL = strSQL.concat("   AND i.cdinjestendido = :cdinjetora ");
			}

			// op
			if (!cdCp.equals("") && !cdCp.equals(null)) {
				strSQL = strSQL.concat("   AND a.nrop = :nrop ");
			}

			if (cdTurno.equals("")) {
				strSQL = strSQL.concat(" AND a.dthrirefugo BETWEEN :dthrini AND :dthrfim ");
			}

			strSQL = strSQL.concat(" AND a.dthrirefugo BETWEEN :dthrIniFaixa AND :dthrFimFaixa ");
			
			if (cdProduto != null && cdProduto != "") {
				strSQL = strSQL.concat("   AND c.cdproduto = :cdproduto ");
			}

			strSQL = strSQL.concat(" GROUP BY a.cdrefugo");

			SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

			// máquina
			if (!cdPt.equals("") && !cdPt.equals(null)) {
				q.setString("cdinjetora", cdPt);
			}

			// op
			if (!cdCp.equals("") && !cdCp.equals(null)) {
				q.setString("nrop", cdCp);
			}

			// produto
			if (cdProduto != null && cdProduto != "") {
				q.setString("cdproduto", cdProduto);
			}

			if (cdTurno.equals("")) {
				q.setTimestamp("dthrini", dthrIniPeriodo)
				 .setTimestamp("dthrfim", dthrFimPeriodo);
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

				registro.cdRefugo = (String) registroLido[_cdrefugo];
				registro.qtRef = ConversaoTipos.converterParaBigDecimal(registroLido[_qtrefUB]);


				List<OcorrenciasEvtDTO> listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
				OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
				ocoDTO.setIdEvt(ConversaoTipos.converteParaBigDecimal(registro.cdRefugo).longValue());
				ocoDTO.setDthrIni(algoritmoGraf.getIntervaloGrafTend().get(i).getIntervaloDtHrIni());
				ocoDTO.setDthrFim(algoritmoGraf.getIntervaloGrafTend().get(i).getIntervaloDtHrIni());
				ocoDTO.setQuantidade(registro.qtRef);

				int duracaoEvt = 0;
				ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
				ocoDTO.setMsDtHrIni(BigDecimal.ZERO);
				ocoDTO.setMsDtHrFim(BigDecimal.ZERO);
				
				listaOcoDTO = retorno.get(registro.cdRefugo);
				if (listaOcoDTO == null) {
					listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
				}
				
				listaOcoDTO.add(ocoDTO);
				
				
				retorno.put(registro.cdRefugo, listaOcoDTO);

			}
		}

		return retorno;
	}


	private DwConsolrelog getDwConsolrelog(RegistroLidoRefugo refugo) {
		DwConsolrelog ref = new DwConsolrelog();

		ref.setDthrRefugo(refugo.dthrRefugo);
		ref.setIsCancelado(false);
		ref.setPcsAutoProducaorefugada(refugo.qtRef);

		DwTAcao acaoR = null;
		DwTCausa cauR = null;
		DwTArea areaR = null;
		DwTRefugo refR = new DwTRefugo();

		if (!refugo.cdArea.equals("")) {
			areaR = new DwTArea();
			areaR.setIdArea(ConversaoTipos.converteParaBigDecimal(refugo.cdArea).longValue());
			areaR.setCdArea(refugo.cdArea);
			areaR.setDsArea(refugo.dsArea);
		}

		if (!refugo.cdCausa.equals("")) {
			cauR = new DwTCausa();
			cauR.setIdTcausa(ConversaoTipos.converteParaBigDecimal(refugo.cdCausa).longValue());
			cauR.setCdTcausa(refugo.cdCausa);
			cauR.setDsTcausa(refugo.dsCausa);
		}

		if (!refugo.cdAcao.equals("")) {
			acaoR = new DwTAcao();
			acaoR.setIdTacao(ConversaoTipos.converteParaBigDecimal(refugo.cdAcao).longValue());
			acaoR.setCdTacao(refugo.cdAcao);
			acaoR.setDsTacao(refugo.dsAcao);
		}

		refR.setDwConsolrelogs(new HashSet<DwConsolrelog>());
		refR.setDwTArea(areaR);
		ref.setDwTRefugo(refR);
		ref.setDwTAcao(acaoR);
		ref.setDwTCausa(cauR);

		OmProduto pro = new OmProduto();
		pro.setCdProduto(refugo.cdProduto);
		pro.setDsProduto(refugo.dsProduto);
		ref.setOmProduto(pro);

		OmPt pt = new OmPt();
		pt.setCdPt(refugo.cdInjEstendido);
		pt.setDsPt(refugo.cdIdentific);
		ref.setOmPt(pt);

		ref.setDwConsolreocos(new HashSet<DwConsolreoco>());

		return ref;
	}

	private Date getMenorDthrOcor(Date dthr, Date menorDthr) {
		if (menorDthr == null) {
			return dthr;
		} else {
			if (DataHoraRN.before(dthr, menorDthr)) {
				return dthr;
			} else {
				return menorDthr;
			}
		}
	}

	private Date getMaiorDthrOcor(Date dthr, Date maiorDthr) {
		if (maiorDthr == null) {
			return dthr;
		} else {
			if (DataHoraRN.after(dthr, maiorDthr)) {
				return dthr;
			} else {
				return maiorDthr;
			}
		}
	}

	private void defineCoresLegendaEBarra(GrafTendenciaUtils algoritmoGraf, GraficosParetoRefugosDTO retorno, 
			HashMap<String, GraficoParetoRefugosDTO> mapRefugos, HashMap<String, List<OcorrenciasEvtDTO>> mapOcorrenciasPorRefugo) {

		if (algoritmoGraf != null && algoritmoGraf.getIntervaloGrafTend() != null
				&& algoritmoGraf.getIntervaloGrafTend().isEmpty() == false) {
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

		List<GraficoParetoRefugosDTO> listaRefugos = new ArrayList<GraficoParetoRefugosDTO>();

		Set<String> cdsRefugos = mapRefugos.keySet();
		for (String cdRefugo : cdsRefugos) {
			GraficoParetoRefugosDTO refugoGraf = mapRefugos.get(cdRefugo);
			List<OcorrenciasEvtDTO> listaOco = mapOcorrenciasPorRefugo.get(cdRefugo);
			Paint paint = algoritmoGraf.corBarraTendencia(refugoGraf.getIdTRefugo(), listaOco);
			Color cor = (Color) paint;
			refugoGraf.setCorBarra(String.valueOf(cor.getRGB()));
			listaRefugos.add(refugoGraf);
		}

		retorno.setRefugos(listaRefugos);

	}

	private void defineCoresLegendaEBarraBI(GrafTendenciaUtils algoritmoGraf, GraficosParetoRefugosDTO retorno, 
			HashMap<String, GraficoParetoRefugosDTO> mapRefugos,
			HashMap<String, GraficoParetoRefugosDTO> mapRefugosGr, 
			HashMap<String, List<OcorrenciasEvtDTO>> mapOcorrenciasPorRefugo) {

		if (algoritmoGraf != null && algoritmoGraf.getIntervaloGrafTend() != null
				&& algoritmoGraf.getIntervaloGrafTend().isEmpty() == false) {
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

		List<GraficoParetoRefugosDTO> listaRefugos = new ArrayList<GraficoParetoRefugosDTO>();
		List<GraficoParetoRefugosDTO> listaRefugosGr = new ArrayList<GraficoParetoRefugosDTO>();

		Set<String> cdsRefugos = mapRefugos.keySet();
		for (String cdRefugo : cdsRefugos) {
			GraficoParetoRefugosDTO refugoGraf = cloneGraficoParetoRefugosDTO(mapRefugos.get(cdRefugo));
			List<OcorrenciasEvtDTO> listaOco = mapOcorrenciasPorRefugo.get(cdRefugo);
			Paint paint = algoritmoGraf.corBarraTendencia(refugoGraf.getIdTRefugo(), listaOco);			
			Color cor = (Color) paint;
			refugoGraf.setCorBarra(String.valueOf(cor.getRGB()));
			listaRefugos.add(refugoGraf);

			GraficoParetoRefugosDTO refugoGrafGr = cloneGraficoParetoRefugosDTO(mapRefugos.get(cdRefugo));
			refugoGrafGr.setIndiceRefugo(refugoGrafGr.getIndiceRefugoGr());
			refugoGrafGr.setCorBarra(String.valueOf(cor.getRGB()));
			listaRefugosGr.add(refugoGrafGr);				
		}

		retorno.setRefugos(listaRefugos);
		retorno.setRefugosGr(listaRefugosGr);

	}	
	
	private GraficoParetoRefugosDTO cloneGraficoParetoRefugosDTO(GraficoParetoRefugosDTO origem) {
		GraficoParetoRefugosDTO destino = new GraficoParetoRefugosDTO();
		destino.setCdRefugo(origem.getCdRefugo());
		destino.setCorBarra(origem.getCorBarra());
		destino.setDsRefugo(origem.getDsRefugo());
		destino.setIdTRefugo(origem.getIdTRefugo());
		destino.setIndiceRefugo(origem.getIndiceRefugo());
		destino.setIndiceRefugoGr(origem.getIndiceRefugoGr());
		destino.setQtdRefugada(origem.getQtdRefugada());
		destino.setQtdRefugadaKg(origem.getQtdRefugadaKg());
		destino.setQtdRefugadaTon(origem.getQtdRefugadaTon());
		return destino;
	}
	
    private List<LegendaDataHoraDTO> getLegendas(GraficosParetoRefugosDTO datas) {
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
