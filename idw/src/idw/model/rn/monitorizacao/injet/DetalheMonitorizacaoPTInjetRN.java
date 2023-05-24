package idw.model.rn.monitorizacao.injet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.Validate;
import org.hibernate.SQLQuery;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpalogtec;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwConsolre;
import idw.model.pojos.DwConsolrelog;
import idw.model.pojos.DwConsolreoco;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwRt;
import idw.model.pojos.DwRtcic;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.DwTJust;
import idw.model.pojos.DwTParada;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmAlgocor;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgind;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmInd;
import idw.model.pojos.OmIndpt;
import idw.model.pojos.OmIndtppt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.pojos.template.DwConsolpalogtecTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.detalhemonitorizacao.EnergiaConsumidaProducaoRN;
import idw.model.rn.detalhemonitorizacao.IndicadoresDoDetalheRN;
import idw.model.rn.injet.DiversosInjetRN;
import idw.model.rn.injet.FuncoesApoioInjet;
import idw.model.rn.injet.PlanejamentoInjetRN;
import idw.model.rn.injet.TurnoInjetDTO;
import idw.model.rn.injet.TurnoInjetRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.util.IdwLogger;
import idw.webservices.dto.CIPDTO;
import idw.webservices.dto.CapabilidadeProcessoDTO;
import idw.webservices.dto.CicloDTO;
import idw.webservices.dto.CiclosDTO;
import idw.webservices.dto.DetalhamentoProducaoDTO;
import idw.webservices.dto.DetalheMonitorizacaoPTInjetDTO;
import idw.webservices.dto.DetalheParadaDTO;
import idw.webservices.dto.DetalheProducaoDTO;
import idw.webservices.dto.DetalheRefugoDTO;
import idw.webservices.dto.DwFolhaDTO;
import idw.webservices.dto.DwFolhasDTO;
import idw.webservices.dto.FiltroCiclosDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.FiltroDetalheProducaoDTO;
import idw.webservices.dto.FiltroProducaoPtCpDTO;
import idw.webservices.dto.GraficoBIParetoDetCiclosOrdemMaquinaDTO;
import idw.webservices.dto.GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO;
import idw.webservices.dto.GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO;
import idw.webservices.dto.GraficoBIParetoDetCiclosOrdemProdutoDTO;
import idw.webservices.dto.GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO;
import idw.webservices.dto.GraficoBIParetoDetTodasDTO;
import idw.webservices.dto.IntervaloDTO;
import idw.webservices.dto.ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO;
import idw.webservices.dto.ListaGraficoBIParetoDetCiclosOrdemProdutoDTO;
import idw.webservices.dto.ListaGraficoBIParetoDetTodasDTO;
import idw.webservices.dto.OperadorDTO;
import idw.webservices.dto.PeriodoDTO;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.dto.ResumoParetoPerdasDetCiclosDTO;
import idw.webservices.dto.ResumoParetoPerdasDetTodasDTO;
import ms.util.ConversaoTipos;

public class DetalheMonitorizacaoPTInjetRN extends AbstractRN<DAOGenericoInjet> {
	public static final Byte PERIODO_CONSOLIDACAO_HORA = 0;
	public static final Byte PERIODO_CONSOLIDACAO_TURNO = 1;
	public static final Byte PERIODO_CONSOLIDACAO_MES = 2;
	public static final Byte PERIODO_CONSOLIDACAO_ACUMULADO = 3;
	public static final byte PERIODO_CONSOLIDACAO_OP = 4;

	public static final byte EXIBICAO_QTD_UNIDADE_BASICA = 1;
	public static final byte EXIBICAO_QTD_PESO_KG = 2;
	public static final byte EXIBICAO_QTD_PESO_TON = 3;

	public static final Byte ORDEM_UB = 1;
	public static final Byte ORDEM_PESO = 2;
	public static final Byte ORDEM_UM = 3;

	private DetalheMonitorizacaoPTInjetDTO retorno;
	private List<DwConsolid> listaDwconsolid;

	public DetalheMonitorizacaoPTInjetRN() {
		this(new DAOGenericoInjet());
	}

	public DetalheMonitorizacaoPTInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	public DetalheMonitorizacaoPTInjetDTO getDetalheMonitorizacaoPtInjetDTO(FiltroDetalhePTInjetDTO filtro) {
		IdwLogger log = new IdwLogger("getDetalheMonitorizacaoPtInjetDTO");

		log.iniciaAvaliacao("TEMPO TOTAL");

		MonitorizacaoInjetRN rnM = new MonitorizacaoInjetRN();
		List<OmInd> listaCfgInd = rnM.getCfgIndInjet(getDao());

		listaDwconsolid = pesquisarDwConsolids(log, filtro);

		// Marcos Sardinha: VFWEB - Injet
		// OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		OmCfg omcfg = new OmCfg();

		retorno = new DetalheMonitorizacaoPTInjetDTO();
		if (listaDwconsolid.isEmpty() == false) {
			// Ordena listas

			// Marcos Sardinha: VFWEB - Injet
			// ordenaListas(listaDwconsolid);

			DAOGenerico daoVF = new DAOGenerico();
			daoVF.iniciaSessao();

			IndicadoresDoDetalheRN iRN = new IndicadoresDoDetalheRN(daoVF, log, omcfg, listaDwconsolid,
					true /* isRecuperarListaProdutos */,
					true /* isRecuperarListaOperadores */,
					true /* isRecuperarListaAlertas */,
					true /* isRecuperarListaPerdas */,
					true /* isRecuperarListaResumoDatas */,
					true /* isRecuperarListaResumoTurnos */,
					retorno, filtro);

			log.iniciaAvaliacao("resumoIndicadores");
			iRN.setResumoIndicadores();
			log.mostrarAvaliacaoCompleta();

			log.iniciaAvaliacao("indicadoresAdicionais");
			iRN.setIndicadoresAdicionais();
			log.mostrarAvaliacaoCompleta();

			log.iniciaAvaliacao("listaOperadores");
			retorno.setListaOperadores(getListaOperadores(listaDwconsolid, filtro));
			log.mostrarAvaliacaoCompleta();

            log.iniciaAvaliacao("energiaconsumidaproducao");
            EnergiaConsumidaProducaoRN eneRN = new EnergiaConsumidaProducaoRN();
            retorno.setEnergiaConsumidaProducao(eneRN.getListaEnergiaConsumidaProducaoInjet(getDao(), daoVF, listaDwconsolid));
            log.mostrarAvaliacaoCompleta();			
			
			log.iniciaAvaliacao("inicializandoCIP");
			retorno.setListacips(getListaCips(listaDwconsolid));
			log.mostrarAvaliacaoCompleta();

			// Marcos Sardinha: VFWEB - Injet
			if (filtro.getOmPt() != null) {
				OmPt ompt = filtro.getOmPt();

				OmTppt omTppt = new OmTppt();

				OmAlgocor omAlgocor = new OmAlgocor();
				omAlgocor.setIdAlgocor(3); // cores tipo injet
				omAlgocor.setDsAlgocor("Cores tipo Injet");

				omTppt.setIdTppt(1l);
				omTppt.setCdTppt("CIC");
				omTppt.setOmAlgocor(omAlgocor);
				omTppt.setOmIndtppts(new HashSet<OmIndtppt>());

				ompt.setOmTppt(omTppt);
				ompt.setOmIndpts(new HashSet<OmIndpt>());

				for (OmInd ind : listaCfgInd) {
					OmIndpt indPt = new OmIndpt();
					OmCfgind cfgInd = ind.getOmCfginds().iterator().next();
					indPt.setOmInd(ind);
					indPt.setIndInferior(cfgInd.getIndInferior());
					indPt.setIndMeta(cfgInd.getIndMeta());
					indPt.setIndSuperior(cfgInd.getIndSuperior());

					ompt.getOmIndpts().add(indPt);
				}

				retorno.setIsForaMetaEficienciaUltCic(!iRN.isMaquinaDentroDaMetaEC(log, ompt, omcfg, retorno.getCiclosEficienciaCic()));

				retorno.setIsForaMetaIefiCiclos(!iRN.isMaquinaDentroDaMetaEI(log, ompt, omcfg, retorno.getEfiCiclos()));

				retorno.setIsForaMetaIefiRealizacao(!iRN.isMaquinaDentroDaMetaER(log, ompt, omcfg, retorno.getEfiRealizacao()));

				retorno.setIsForaMetaIndiceParadas(!iRN.isMaquinaDentroDaMetaIP(log, ompt, omcfg, retorno.getIndiceParadas()));

				retorno.setIsForaMetaIndiceRefugos(!iRN.isMaquinaDentroDaMetaIR(log, ompt, omcfg, retorno.getIndiceRefugos()));

			}

			daoVF.finalizaSessao();

			// Remover o dwconsolid que esta dentro de dwconsoid.dwconsol para
			// evitar o ws infinito
			Date dtHrMin = null;
			Date dtHrMax = null;
			Date dtHrTur = null;

			for (DwConsolid dwconsolid : listaDwconsolid) {

				// Encontrar o inicio e fim do turno
				dtHrTur = dwconsolid.getDtReferencia();
				if (dtHrMin == null) {
					dtHrMin = dtHrTur;
				} else {
					if (DataHoraRN.compareTo(dtHrMin, dtHrTur) > 0) {
						dtHrMin = dtHrTur;
					}
				}

				if (dtHrMax == null) {
					dtHrMax = dtHrTur;
				} else {
					if (DataHoraRN.compareTo(dtHrMax, dtHrTur) < 0) {
						dtHrMax = dtHrTur;
					}
				}
			}

			retorno.setDtRefMin(dtHrMin);
			retorno.setDtRefMax(dtHrMax);

		}

		// Obter a lista de ops no turno se NAO for o BI. Isso eh importante pq o detalhe da maquina permite escolher outra OP
		if (filtro.getTpId() != null && filtro.getTpId().equals(PERIODO_CONSOLIDACAO_TURNO) && filtro.getDtReferencia() != null) {
			log.iniciaAvaliacao("obtem ppcp");
			PlanejamentoInjetRN rn = new PlanejamentoInjetRN(getDao());
			List<PpCp> ops = rn.pesquisarPpCpByCdPtInjet(getDao(), filtro.getDtReferencia(), filtro.getDwTurno(), filtro.getOmPt());
			log.mostrarAvaliacaoCompleta();
			retorno.setOpsNoTurno(ops);
		}

		if (filtro.getTpId() != null && filtro.getTpId().equals(PERIODO_CONSOLIDACAO_HORA) && filtro.getDthrIhora() != null
				&& filtro.getDthrFhora() != null) {
			log.iniciaAvaliacao("obtem ppcp");
			PlanejamentoInjetRN rn = new PlanejamentoInjetRN(getDao());
			List<PpCp> ops = rn.pesquisarPpCpByCdPtInjet(getDao(), filtro.getDthrIhora(), filtro.getDthrFhora(), filtro.getOmPt());
			log.mostrarAvaliacaoCompleta();
			retorno.setOpsNoTurno(ops);
		}

		// calcular indicadores utilizados na ficha da máquina da op
		if (filtro.getTpId() == PERIODO_CONSOLIDACAO_OP) {
			Date dthrFimPrevisto = null;
			Date dthrFimPrevistoMax = null;
			Double qtCiclosAExec = null;
			Double restoDivisao = null;
			Date dthrAtual = DataHoraRN.getDataHoraAtual();

			Double qtPlanOP = 0d;
			Double qtPlanProduto = 0d;

			PlanejamentoInjetRN rn = new PlanejamentoInjetRN(getDao());
			List<PpCp> lista = rn.pesquisarPpCpByCdPtInjet(getDao(), null, filtro.getCdCp());

			for (PpCp ppcp : lista) {
				for (PpCpproduto produto : ppcp.getPpCpprodutos()) {
					qtPlanProduto = (produto.getPcsProducaoplanejada() != null ? produto.getPcsProducaoplanejada().doubleValue() : 0);
					qtPlanOP = qtPlanOP + qtPlanProduto;
				}
			}

			// índice de produ��oo
			if (retorno.getQtdPecasBoas() != null) {
				retorno.setIndiceProducao(FormulasInjet.calcularEficienciaRealizacao(new BigDecimal(retorno.getQtdPecasBoas()),
						new BigDecimal(qtPlanOP)).doubleValue());
			} else {
				retorno.setIndiceProducao(0d);
			}
			// gargalo
			if (retorno.getListaProdutos() != null) {
				for (ProdutoDTO produto : retorno.getListaProdutos()) {
					if (produto.getAproduzir().doubleValue() > 0d) {
						restoDivisao = produto.getAproduzir().doubleValue() % produto.getQtdAtiva().doubleValue();
						qtCiclosAExec = produto.getAproduzir().doubleValue() / produto.getQtdAtiva().doubleValue();

						if (!restoDivisao.equals(0d)) {
							qtCiclosAExec = qtCiclosAExec + 1;
						}

						// calcular fim previsto
						dthrFimPrevisto = DataHoraRN.adicionaSegundosNaData(dthrAtual, (int) (qtCiclosAExec * produto.getCicloPadrao()));

						if (dthrFimPrevistoMax == null) {
							dthrFimPrevistoMax = dthrFimPrevisto;
						} else {
							dthrFimPrevistoMax = (DataHoraRN.compareTo(dthrFimPrevistoMax, dthrFimPrevisto) < 0 ? dthrFimPrevistoMax
									: dthrFimPrevistoMax);
						}
					}
				}
			}

			if (dthrFimPrevistoMax == null || retorno.getDtFimPlanejado() == null) {
				retorno.setDtFimPrevisto(retorno.getDtFimPlanejado());
				retorno.setGargalo("00:00:00");

			} else {
				// calcula a diferença entre gargalo e final previsto
				Date dtHrFimPlan = DataHoraRN.stringToDate(retorno.getDtFimPlanejado(), "yyyy-MM-dd HH:mm:ss");
				int segGargalo = DataHoraRN.getQuantidadeSegundosNoPeriodo(dtHrFimPlan, dthrFimPrevistoMax);

				retorno.setDtFimPrevisto(DataHoraRN.dateToString(dthrFimPrevistoMax, "dd/MM/yyyy HH:mm:ss"));
				retorno.setGargalo(DataHoraRN.getSegundosFormatadosEmDiasHoras(new BigDecimal(segGargalo)));
			}

		}
		log.mostrarAvaliacaoCompleta();

		// Ajuste temporario do retorno
		if (retorno.getListaDwConsolId() != null) {
			for (DwConsolid id : retorno.getListaDwConsolId()) {
				for (DwConsol consol : id.getDwConsols()) {
					consol.setDwConsolid(null);
				}
			}
		}
		return retorno;

	}

	private String getConsultaComFiltroProduto(FiltroDetalhePTInjetDTO filtro) {
		String strSQL = "";

		strSQL = strSQL.concat(
				"SELECT a.idregistro, a.nrop, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalcic, a.dthrivalestru, c.ciclopadrao, c.fatorcontagemprod, d.qtcavativas, d.qtcavidades,");
		strSQL = strSQL.concat(
				"       (CASE WHEN a.qtinjnormal IS NULL or a.qtinjnormal = 0 THEN 0 ELSE ((a.tmpcicnormal + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END)) / a.qtinjnormal)  END) as ciclomedio, ");
		strSQL = strSQL.concat("       (b.prodbrutaOP) as prodbrutaOP, ");
		strSQL = strSQL.concat("       (b.prodrefOP) as prodrefOP,");
		strSQL = strSQL
				.concat("       ((a.qtinjnormal * d.qtcavativas * c.fatorcontagemprod) + (a.qtprodpkgcic * d.indcav)) as prodbruta, ");
		strSQL = strSQL.concat("       (cr.qtprodrefugadaUB) as prodref, ");
		strSQL = strSQL.concat("       (a.tmpcicnormal + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END)) as tmpcicnormal, ");
		strSQL = strSQL.concat("       (a.tmpcicfinparada + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctci END)) as tmpcicfinparada, ");
		strSQL = strSQL.concat("       (a.tmpparadas) as tmpparadasCP, ");
		strSQL = strSQL.concat("       (a.tmpparadassempeso) as tmpparadasSP, ");
		strSQL = strSQL.concat(
				"       (FLOOR((a.tmpcicnormal + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END))/ c.ciclopadrao) * d.qtcavativas * c.fatorcontagemprod) as prodprev, ");
		strSQL = strSQL.concat("       f.prodplanOP, ");
		strSQL = strSQL.concat(
				"       ( (a.tmpcicnormal + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END)) + (a.tmpcicfinparada + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctci END)) + (a.tmpparadas)) ) as tmphrsdisp, ");
		strSQL = strSQL.concat(
				"       ( (( (a.tmpcicnormal   + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END)) /m.qtcavidades) * (m.qtcavidades - m.qtcavativas)) ) as tmpcavidades, ");
		strSQL = strSQL.concat("       ((CASE WHEN cr.tmpprodrefugada IS NULL THEN 0 ELSE cr.tmpprodrefugada END)) as tmprefugo, ");
		strSQL = strSQL.concat(
				"       ( ((( (a.tmpcicnormal + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END)) / a.ciclopadrao) - a.qtinjnormal ) * a.ciclopadrao) ) as tmpritmo, ");
		strSQL = strSQL.concat("       tup.dthriparrefmonit, tup.dthrfparrefmonit, ");
		strSQL = strSQL.concat("       tibm.StUltInspQldBM, ");
		strSQL = strSQL.concat(
				"       cip.IdCtrlInicProc, cipt.CdMoldeSaida as CdMoldeSaidaCIP, cipt.CdEstruSaida as CdEstruSaidaCIP, cipt.CdMoldeEntrada as CdMoldeEntradaCIP, cipt.CdEstruEntrada as CdEstruEntradaCIP, ");
		strSQL = strSQL.concat("       cip.DtHrIniCtrlIniProc, cip.DtHrFimCtrlIniProc, ");
		strSQL = strSQL.concat("       ial.QtAlertasOperador, ");
		strSQL = strSQL.concat("       i.stfuncionamento, i.aguardandomolde, i.AlertaInspQld, i.maquinaemalerta, i.StUltInspQld, ");
		strSQL = strSQL.concat(
				" 	   ( ( (  (a.tmpcicnormal + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END)) / c.ciclopadrao) - a.qtinjnormal) * (d.qtcavativas * c.fatorcontagemprod)) as qtdritmo, ");
		strSQL = strSQL.concat(" 	   ( (a.qtinjnormal * (d.qtcavidades - d.qtcavativas)) * c.fatorcontagemprod) as qtdperdapcsciclo, ");
		strSQL = strSQL.concat(" 	   ( a.qtinjnormal * d.qtcavidades) as qtdpcsciclototal, ");
		strSQL = strSQL.concat(" 	   ( a.qtinjnormal * d.qtcavativas) as qtdpcscicloativas, ");
		strSQL = strSQL.concat(" 	   ( ( a.tmpparadas / c.ciclopadrao) * (d.qtcavativas * c.fatorcontagemprod) ) as qtdperdasparCP, ");
		strSQL = strSQL
				.concat(" 	   ( ( a.tmpparadassempeso / c.ciclopadrao) * (d.qtcavativas * c.fatorcontagemprod) ) as qtdperdasparSP, ");
		strSQL = strSQL.concat(
				" 	   a.qtinjnormal, a.qtinjfinpar, c.varmin, c.varmax, mtbf.tmpparMTBFMTTR, mtbf.qtdparMTBFMTTR, a.dtturno, a.cdturno, t.dsturno, mld.cdmolestendido, rot.nropexibicao, op.dthrireal, ");
		strSQL = strSQL.concat(" 	   i.cdinjestendido, i.cdidentific, ");
		strSQL = strSQL.concat(" 	   d.cdproduto, p.dsproduto ");
		strSQL = strSQL.concat("  FROM ijcnsturno a ");
		strSQL = strSQL.concat("  LEFT JOIN IJtbFRESH ct ON (1=1) ");
		strSQL = strSQL.concat("  LEFT JOIN (SELECT a.nrop, SUM(a.qtprodbrutaUB) as prodbrutaOP, SUM(a.qtprodrefugadaUB) as prodrefOP  ");
		strSQL = strSQL.concat("               FROM viewDadosCalcOEEOP a ");
		strSQL = strSQL.concat("              GROUP BY a.nrop) b ON (b.nrop = a.nrop)");
		strSQL = strSQL.concat(
				"  JOIN ijfictec c ON (c.cdinjetora = a.cdinjetora AND c.cdmolde = a.cdmolde AND c.cdestrutura = a.cdestrutura AND c.dthrivalcic = a.dthrivalcic)");
		strSQL = strSQL.concat(
				"  JOIN viewmolproindcav d ON (d.cdmolde = c.cdmolde AND d.cdestrutura = c.cdestrutura AND d.dthrival = c.dthrival AND d.cdidentificacao = c.cdidentificacao) ");
		strSQL = strSQL.concat("  JOIN ijtbpro p ON (p.cdproduto = d.cdproduto) ");
		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol mld ON (mld.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbtur t ON (t.cdturno = a.cdturno) ");
		strSQL = strSQL.concat("  JOIN ijop op ON (op.nrop = a.nrop) ");
		strSQL = strSQL.concat(
				"  JOIN ijoproteiro rot ON  (rot.nrop = a.nrop AND rot.cdinjetora = a.cdinjetora AND rot.cdmolde = a.cdmolde AND rot.cdestrutura = a.cdestrutura) ");
		strSQL = strSQL
				.concat("  JOIN (SELECT nrop, SUM(qtpecasproduzir) as prodplanOP FROM ijopprodutos GROUP BY nrop) f ON (f.nrop = a.nrop)");
		strSQL = strSQL.concat("  LEFT OUTER JOIN ijinjctrlultparmon tup ON (a.cdinjetora = tup.cdinjetora) ");
		strSQL = strSQL.concat("  LEFT OUTER JOIN ijtbinjqldctrl tibm ON (a.cdinjetora = tibm.cdinjetora)  ");
		strSQL = strSQL.concat(
				"  LEFT OUTER JOIN IJctrlINIPROC cip ON (cip.CdInjetora  = a.cdinjetora AND cip.NrOP = a.NrOP AND cip.DtHrFimCtrlIniProc IS NULL) ");
		strSQL = strSQL.concat("  LEFT OUTER JOIN IJctrlINIPROCTroca cipt ON (cip.IdCtrlInicProc  = cipt.IdCtrlInicProc) ");
		strSQL = strSQL.concat("  LEFT OUTER JOIN ijtbinjalerta ial ON (a.cdinjetora = ial.cdinjetora)");

		// dados do refugo
		strSQL = strSQL.concat("  LEFT OUTER JOIN ");
		strSQL = strSQL.concat(
				"  	 (SELECT r.dtturno, r.cdturno, r.cdinjetora, r.nrop, r.cdmolde, r.cdestrutura, r.dthrivalestru, r.dthrivalcic, m.cdproduto, ");
		strSQL = strSQL.concat(
				"  				SUM((r.qtpcsref * (CASE WHEN (cm.tmpcicnormal = 0 OR cm.qtinjnormal = 0)  THEN 0 ELSE (cm.tmpcicnormal / cm.qtinjnormal) END)) / (c.cavativas * d.fatorcontagemprod)) as tmppcsref, ");
		strSQL = strSQL.concat("  				SUM(r.qtpcsref) as qtpcsref ");
		strSQL = strSQL.concat("  		  FROM ijcnsturnodetref r, ijmolpro m, viewDadosCalcCicMedio cm, cavidades c, ijfictec d ");
		strSQL = strSQL.concat("  		 WHERE m.cdmolde = r.cdmolde ");
		strSQL = strSQL.concat("   		   AND m.cdestrutura = r.cdestrutura ");
		strSQL = strSQL.concat("  		   AND m.dthrival = r.dthrivalestru ");

		strSQL = strSQL.concat("  		   AND m.cdidentificacao = r.cdidentificacao ");
		strSQL = strSQL.concat("  		   AND cm.dtturno = r.dtturno ");
		strSQL = strSQL.concat("  	       AND cm.cdturno = r.cdturno ");
		strSQL = strSQL.concat("  		   AND cm.cdinjetora = r.cdinjetora ");
		strSQL = strSQL.concat("  		   AND cm.cdmolde = r.cdmolde ");
		strSQL = strSQL.concat("           AND cm.cdestrutura = r.cdestrutura ");
		strSQL = strSQL.concat("           AND cm.dthrivalcic = r.dthrivalcic ");

		strSQL = strSQL.concat("  		   AND r.CdMolde       = c.CdMolde ");
		strSQL = strSQL.concat("  		   AND r.CdEstrutura   = c.CdEstrutura ");
		strSQL = strSQL.concat("  		   AND r.DtHrIValEstru = c.DtHrIVal ");

		strSQL = strSQL.concat("  		   AND d.cdinjetora = r.cdinjetora ");
		strSQL = strSQL.concat("  		   AND d.cdmolde = r.cdmolde ");
		strSQL = strSQL.concat("  		   AND d.cdestrutura = r.cdestrutura ");
		strSQL = strSQL.concat("  		   AND d.dthrivalcic = r.dthrivalcic ");
		strSQL = strSQL.concat(
				" 	 GROUP BY r.dtturno, r.cdturno, r.cdinjetora, r.nrop, r.cdmolde, r.cdestrutura, r.dthrivalestru, r.dthrivalcic, m.cdproduto ");
		strSQL = strSQL.concat("  	 ) cr ON (      cr.dtturno = a.dtturno ");
		strSQL = strSQL.concat("  				AND cr.cdturno = a.cdturno ");
		strSQL = strSQL.concat("  				AND cr.cdinjetora = a.cdinjetora ");
		strSQL = strSQL.concat("  				AND cr.nrop = a.nrop ");
		strSQL = strSQL.concat("  				AND cr.cdmolde = a.cdmolde ");
		strSQL = strSQL.concat("  				AND cr.cdestrutura = a.cdestrutura ");
		strSQL = strSQL.concat("  				AND cr.dthrivalestru = a.dthrivalestru ");
		strSQL = strSQL.concat("  				AND cr.dthrivalcic = a.dthrivalcic ");
		strSQL = strSQL.concat("  				AND cr.cdproduto = d.cdproduto) ");

		strSQL = strSQL.concat(
				" LEFT JOIN (SELECT a.dtturno, a.cdturno, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, a.nrop, ");
		strSQL = strSQL.concat("                   SUM(a.tmpparadas + a.tmpparadassempeso) as tmpparMTBFMTTR, ");
		strSQL = strSQL.concat("                   COUNT(a.dtturno) as qtdparMTBFMTTR ");
		strSQL = strSQL.concat("             FROM IJREAPARCNSOCORTUR a ");
		strSQL = strSQL.concat("             JOIN ijtbinj d ON (d.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("             JOIN ijtbpar p ON (p.cdparada = a.cdparada and p.CalcMTBFMTTR = '1') ");
		strSQL = strSQL.concat(
				"       GROUP BY a.dtturno, a.cdturno, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, a.nrop ) ");
		strSQL = strSQL.concat("  mtbf ON (    mtbf.dtturno = a.dtturno ");
		strSQL = strSQL.concat("           AND mtbf.cdturno = a.cdturno ");
		strSQL = strSQL.concat("           AND mtbf.cdinjetora = a.cdinjetora ");
		strSQL = strSQL.concat("           AND mtbf.cdmolde = a.cdmolde ");
		strSQL = strSQL.concat("           AND mtbf.cdestrutura = a.cdestrutura ");
		strSQL = strSQL.concat("           AND mtbf.dthrivalestru = a.dthrivalestru ");
		strSQL = strSQL.concat("           AND mtbf.dthrivalcic = a.dthrivalcic ");
		strSQL = strSQL.concat("           AND mtbf.nrop = a.nrop) ");

		strSQL = strSQL.concat(" WHERE a.dtturno = a.dtturno ");

		if (filtro.getDtReferencia() != null || filtro.getDwTurno() != null) {
			strSQL = strSQL.concat("  AND a.dtturno = :dtref ");
			strSQL = strSQL.concat("  AND a.cdturno = :cdturno ");
		}

		if (filtro.getOmPt() != null) {
			strSQL = strSQL.concat(" AND i.cdinjestendido = :cdinjetora");
		}

		if (filtro.getCdCp() != null && filtro.getCdCp().equals("") == false && filtro.getFiltroOp() != null
				&& (filtro.getFiltroOp() == 0 || filtro.getFiltroOp() == 3)) {
			strSQL = strSQL.concat(" AND a.nrop = :nrop ");
		}

		strSQL = strSQL.concat(" AND d.cdproduto = :cdproduto ");

		return strSQL;
	}

	private String getConsultaSemFiltroProduto(FiltroDetalhePTInjetDTO filtro) {
		String strSQL = "";

		strSQL = strSQL.concat(
				"SELECT a.idregistro, a.nrop, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalcic, a.dthrivalestru, c.ciclopadrao, c.fatorcontagemprod, d.qtcavativas, d.qtcavidades,");
		strSQL = strSQL.concat(
				"       (CASE WHEN a.qtinjnormal IS NULL or a.qtinjnormal = 0 THEN 0 ELSE (a.tmpcicnormal  / a.qtinjnormal)  END) as ciclomedio, ");
		strSQL = strSQL.concat("       (b.prodbrutaOP) as prodbrutaOP, ");
		strSQL = strSQL.concat("       (b.prodrefOP) as prodrefOP,");
		strSQL = strSQL.concat("       (a.qtprodbrutaUB) as prodbruta, ");
		strSQL = strSQL.concat("       (a.qtprodrefugadaUB) as prodref, ");
		strSQL = strSQL.concat("       (a.tmpcicnormal) as tmpcicnormal, ");
		strSQL = strSQL.concat("       (a.tmpcicfinparada) as tmpcicfinparada, ");
		strSQL = strSQL.concat("       (a.tmpparadas) as tmpparadasCP, ");
		strSQL = strSQL.concat("       (a.tmpparadassempeso) as tmpparadasSP, ");
		strSQL = strSQL.concat("       (FLOOR(a.tmpcicnormal / c.ciclopadrao) * (CASE WHEN ct.campo23 = '¬¬ª¿±·¿½­' THEN d.qtcavidades ELSE d.qtcavativas END)  * c.fatorcontagemprod) as prodprev, ");
		strSQL = strSQL.concat("       f.prodplanOP, ");
		strSQL = strSQL.concat("       ((CASE WHEN a.tmpativo IS NULL THEN 0 ELSE a.tmpativo END)) as tmphrsdisp, ");
		strSQL = strSQL.concat("       (a.tmpcavidades) as tmpcavidades, ");
		strSQL = strSQL.concat("       ((CASE WHEN a.tmpprodrefugada IS NULL THEN 0 ELSE a.tmpprodrefugada END)) as tmprefugo, ");
		strSQL = strSQL.concat("       ( (((a.tmpcicnormal / a.ciclopadrao) - a.qtinjnormal ) * a.ciclopadrao) ) as tmpritmo, ");
		strSQL = strSQL.concat("       tup.dthriparrefmonit, tup.dthrfparrefmonit, ");
		strSQL = strSQL.concat("       tibm.StUltInspQldBM, ");
		strSQL = strSQL.concat(
				"       cip.IdCtrlInicProc, cipt.CdMoldeSaida as CdMoldeSaidaCIP, cipt.CdEstruSaida as CdEstruSaidaCIP, cipt.CdMoldeEntrada as CdMoldeEntradaCIP, cipt.CdEstruEntrada as CdEstruEntradaCIP, ");
		strSQL = strSQL.concat("       cip.DtHrIniCtrlIniProc, cip.DtHrFimCtrlIniProc, ");
		strSQL = strSQL.concat("       ial.QtAlertasOperador, ");
		strSQL = strSQL.concat("       i.stfuncionamento, i.aguardandomolde, i.AlertaInspQld, i.maquinaemalerta, i.StUltInspQld, ");
		strSQL = strSQL.concat(
				" 	   ( ( (a.tmpcicnormal / c.ciclopadrao) - a.qtinjnormal) * (d.qtcavativas * c.fatorcontagemprod)) as qtdritmo, ");
		strSQL = strSQL.concat(" 	   ( (a.qtinjnormal * (d.qtcavidades - d.qtcavativas)) * c.fatorcontagemprod) as qtdperdapcsciclo, ");
		strSQL = strSQL.concat(" 	   ( a.qtinjnormal * d.qtcavidades) as qtdpcsciclototal, ");
		strSQL = strSQL.concat(" 	   ( a.qtinjnormal * d.qtcavativas) as qtdpcscicloativas, ");
		strSQL = strSQL.concat(" 	   ( ( a.tmpparadas / c.ciclopadrao) * (d.qtcavativas * c.fatorcontagemprod) ) as qtdperdasparCP, ");
		strSQL = strSQL.concat(" 	   ( ( a.tmpparadas / c.ciclopadrao) * (d.qtcavativas * c.fatorcontagemprod) ) as qtdperdasparSP, ");
		strSQL = strSQL.concat(
				" 	   a.qtinjnormal, a.qtinjfinpar, c.varmin, c.varmax, mtbf.tmpparMTBFMTTR, mtbf.qtdparMTBFMTTR, a.dtturno, a.cdturno, t.dsturno, mld.cdmolestendido, rot.nropexibicao, op.dthrireal, ");
		strSQL = strSQL.concat(" 	   i.cdinjestendido, i.cdidentific ");
		strSQL = strSQL.concat("  FROM viewDadosCalcOEEOP a ");
		strSQL = strSQL.concat("  JOIN ijtbfresh ct ON (1=1) ");
		strSQL = strSQL.concat("  LEFT JOIN (SELECT a.nrop, SUM(a.qtprodbrutaUB) as prodbrutaOP, SUM(a.qtprodrefugadaUB) as prodrefOP  ");
		strSQL = strSQL.concat("               FROM viewDadosCalcOEEOP a ");
		strSQL = strSQL.concat("              GROUP BY a.nrop) b ON (b.nrop = a.nrop)");
		strSQL = strSQL.concat(
				"  JOIN ijfictec c ON (c.cdinjetora = a.cdinjetora AND c.cdmolde = a.cdmolde AND c.cdestrutura = a.cdestrutura AND c.dthrivalcic = a.dthrivalcic)");
		strSQL = strSQL.concat(
				"  JOIN cavidades2 d ON (d.cdmolde = c.cdmolde AND d.cdestrutura = c.cdestrutura AND d.dthrival = c.dthrivalestru) ");
		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol mld ON (mld.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbtur t ON (t.cdturno = a.cdturno) ");
		strSQL = strSQL.concat("  JOIN ijop op ON (op.nrop = a.nrop) ");
		strSQL = strSQL.concat(
				"  JOIN ijoproteiro rot ON  (rot.nrop = a.nrop AND rot.cdinjetora = a.cdinjetora AND rot.cdmolde = a.cdmolde AND rot.cdestrutura = a.cdestrutura) ");
		strSQL = strSQL
				.concat("  JOIN (SELECT nrop, SUM(qtpecasproduzir) as prodplanOP FROM ijopprodutos GROUP BY nrop) f ON (f.nrop = a.nrop)");
		strSQL = strSQL.concat("  LEFT OUTER JOIN ijinjctrlultparmon tup ON (a.cdinjetora = tup.cdinjetora) ");
		strSQL = strSQL.concat("  LEFT OUTER JOIN ijtbinjqldctrl tibm ON (a.cdinjetora = tibm.cdinjetora)  ");

		strSQL = strSQL.concat(
				" LEFT JOIN (SELECT a.dtturno, a.cdturno, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, a.nrop, ");
		strSQL = strSQL.concat("                   SUM(a.tmpparadas + a.tmpparadassempeso) as tmpparMTBFMTTR, ");
		strSQL = strSQL.concat("                   COUNT(a.dtturno) as qtdparMTBFMTTR ");
		strSQL = strSQL.concat("             FROM IJREAPARCNSOCORTUR a ");
		strSQL = strSQL.concat("             JOIN ijtbinj d ON (d.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("             JOIN ijtbpar p ON (p.cdparada = a.cdparada and p.CalcMTBFMTTR = '1') ");
		strSQL = strSQL.concat(
				"       GROUP BY a.dtturno, a.cdturno, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, a.nrop ) ");
		strSQL = strSQL.concat("  mtbf ON (    mtbf.dtturno = a.dtturno ");
		strSQL = strSQL.concat("           AND mtbf.cdturno = a.cdturno ");
		strSQL = strSQL.concat("           AND mtbf.cdinjetora = a.cdinjetora ");
		strSQL = strSQL.concat("           AND mtbf.cdmolde = a.cdmolde ");
		strSQL = strSQL.concat("           AND mtbf.cdestrutura = a.cdestrutura ");
		strSQL = strSQL.concat("           AND mtbf.dthrivalestru = a.dthrivalestru ");
		strSQL = strSQL.concat("           AND mtbf.dthrivalcic = a.dthrivalcic ");
		strSQL = strSQL.concat("           AND mtbf.nrop = a.nrop) ");

		strSQL = strSQL.concat(
				"  LEFT OUTER JOIN IJctrlINIPROC cip ON (cip.CdInjetora  = a.cdinjetora AND cip.NrOP = a.NrOP AND cip.DtHrFimCtrlIniProc IS NULL) ");
		strSQL = strSQL.concat("  LEFT OUTER JOIN IJctrlINIPROCTroca cipt ON (cip.IdCtrlInicProc  = cipt.IdCtrlInicProc) ");
		strSQL = strSQL.concat("  LEFT OUTER JOIN ijtbinjalerta ial ON (a.cdinjetora = ial.cdinjetora)");
		strSQL = strSQL.concat(" WHERE a.dtturno = a.dtturno ");

		if (filtro.getDtReferencia() != null || filtro.getDwTurno() != null) {
			strSQL = strSQL.concat("  AND a.dtturno = :dtref ");
			strSQL = strSQL.concat("  AND a.cdturno = :cdturno ");
		}

		if (filtro.getOmPt() != null) {
			strSQL = strSQL.concat(" AND i.cdinjestendido = :cdinjetora");
		}

		if (filtro.getCdCp() != null && filtro.getCdCp().equals("") == false && filtro.getFiltroOp() != null
				&& (filtro.getFiltroOp() == 0 || filtro.getFiltroOp() == 3)) {
			strSQL = strSQL.concat(" AND a.nrop = :nrop ");
		}

		return strSQL;
	}

	private String getConsultaComFiltroProdutoUT(FiltroDetalhePTInjetDTO filtro) {
		String strSQL = "";

		strSQL = strSQL.concat(
				"SELECT a.idregistro, a.nrop, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalcic, a.dthrivalestru, c.ciclopadrao, c.fatorcontagemprod, d.qtcavativas, d.qtcavidades,");
		strSQL = strSQL.concat(
				"       (CASE WHEN a.qtinjnormal IS NULL or a.qtinjnormal = 0 THEN 0 ELSE ((a.tmpcicnormal + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END)) / a.qtinjnormal)  END) as ciclomedio, ");
		strSQL = strSQL.concat("       (b.prodbrutaOP) as prodbrutaOP, ");
		strSQL = strSQL.concat("       (b.prodrefOP) as prodrefOP,");
		strSQL = strSQL
				.concat("       ((a.qtinjnormal * d.qtcavativas * c.fatorcontagemprod) + (a.qtprodpkgcic * d.indcav)) as prodbruta, ");
		strSQL = strSQL.concat("       (cr.qtprodrefugadaUB) as prodref, ");
		strSQL = strSQL.concat("       (a.tmpcicnormal + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END)) as tmpcicnormal, ");
		strSQL = strSQL.concat("       (a.tmpcicfinparada + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctci END)) as tmpcicfinparada, ");
		strSQL = strSQL.concat("       (a.tmpparadas) as tmpparadasCP, ");
		strSQL = strSQL.concat("       (a.tmpparadassempeso) as tmpparadasSP, ");
		strSQL = strSQL.concat(
				"       (FLOOR((a.tmpcicnormal + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END))/ c.ciclopadrao) * (CASE WHEN ct.campo23 = '¬¬ª¿±·¿½­' THEN d.qtcavidades ELSE d.qtcavativas END)  * c.fatorcontagemprod) as prodprev, ");
		strSQL = strSQL.concat("       f.prodplanOP, ");
		strSQL = strSQL.concat(
				"       ( (a.tmpcicnormal + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END)) + (a.tmpcicfinparada + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctci END)) + (a.tmpparadas)) ) as tmphrsdisp, ");
		strSQL = strSQL.concat(
				"       ( (( (a.tmpcicnormal   + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END)) /m.qtcavidades) * (m.qtcavidades - m.qtcavativas)) ) as tmpcavidades, ");
		strSQL = strSQL.concat("       ((CASE WHEN cr.tmpprodrefugada IS NULL THEN 0 ELSE cr.tmpprodrefugada END)) as tmprefugo, ");
		strSQL = strSQL.concat(
				"       ( ((( (a.tmpcicnormal + + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END)) / a.ciclopadrao) - a.qtinjnormal ) * a.ciclopadrao) ) as tmpritmo, ");
		strSQL = strSQL.concat("       tup.dthriparrefmonit, tup.dthrfparrefmonit, ");
		strSQL = strSQL.concat("       tibm.StUltInspQldBM, ");
		strSQL = strSQL.concat(
				"       cip.IdCtrlInicProc, cipt.CdMoldeSaida as CdMoldeSaidaCIP, cipt.CdEstruSaida as CdEstruSaidaCIP, cipt.CdMoldeEntrada as CdMoldeEntradaCIP, cipt.CdEstruEntrada as CdEstruEntradaCIP, ");
		strSQL = strSQL.concat("       cip.DtHrIniCtrlIniProc, cip.DtHrFimCtrlIniProc, ");
		strSQL = strSQL.concat("       ial.QtAlertasOperador, ");
		strSQL = strSQL.concat("       i.stfuncionamento, i.aguardandomolde, i.AlertaInspQld, i.maquinaemalerta, i.StUltInspQld, ");
		strSQL = strSQL.concat(
				" 	   ( ( (  (a.tmpcicnormal + + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END)) / c.ciclopadrao) - a.qtinjnormal) * (d.qtcavativas * c.fatorcontagemprod)) as qtdritmo, ");
		strSQL = strSQL.concat(" 	   ( (a.qtinjnormal * (d.qtcavidades - d.qtcavativas)) * c.fatorcontagemprod) as qtdperdapcsciclo, ");
		strSQL = strSQL.concat(" 	   ( a.qtinjnormal * d.qtcavidades) as qtdpcsciclototal, ");
		strSQL = strSQL.concat(" 	   ( a.qtinjnormal * d.qtcavativas) as qtdpcscicloativas, ");
		strSQL = strSQL.concat(" 	   ( ( a.tmpparadas / c.ciclopadrao) * (d.qtcavativas * c.fatorcontagemprod) ) as qtdperdasparCP, ");
		strSQL = strSQL
				.concat(" 	   ( ( a.tmpparadassempeso / c.ciclopadrao) * (d.qtcavativas * c.fatorcontagemprod) ) as qtdperdasparSP, ");
		strSQL = strSQL.concat(
				" 	   a.qtinjnormal, a.qtinjfinpar, c.varmin, c.varmax, mtbf.tmpparMTBFMTTR, mtbf.qtdparMTBFMTTR, a.dthriniintervalo, mld.cdmolestendido, rot.nropexibicao, op.dthrireal, ");
		strSQL = strSQL.concat(" 	   i.cdinjestendido, i.cdidentific, ");
		strSQL = strSQL.concat(" 	   d.cdproduto, p.dsproduto ");
		strSQL = strSQL.concat("  FROM ijcnsUT a ");
		strSQL = strSQL.concat("  LEFT JOIN IJtbFRESH ct ON (1=1) ");
		strSQL = strSQL.concat("  LEFT JOIN (SELECT a.nrop, SUM(a.qtprodbrutaUB) as prodbrutaOP, SUM(a.qtprodrefugadaUB) as prodrefOP  ");
		strSQL = strSQL.concat("               FROM viewDadosCalcOEEOP a ");
		strSQL = strSQL.concat("              GROUP BY a.nrop) b ON (b.nrop = a.nrop)");
		strSQL = strSQL.concat(
				"  JOIN ijfictec c ON (c.cdinjetora = a.cdinjetora AND c.cdmolde = a.cdmolde AND c.cdestrutura = a.cdestrutura AND c.dthrivalcic = a.dthrivalcic)");
		strSQL = strSQL.concat(
				"  JOIN viewmolproindcav d ON (d.cdmolde = c.cdmolde AND d.cdestrutura = c.cdestrutura AND d.dthrival = c.dthrival AND d.cdidentificacao = c.cdidentificacao) ");
		strSQL = strSQL.concat("  JOIN ijtbpro p ON (p.cdproduto = d.cdproduto) ");
		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol mld ON (mld.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijop op ON (op.nrop = a.nrop) ");
		strSQL = strSQL.concat(
				"  JOIN ijoproteiro rot ON  (rot.nrop = a.nrop AND rot.cdinjetora = a.cdinjetora AND rot.cdmolde = a.cdmolde AND rot.cdestrutura = a.cdestrutura) ");
		strSQL = strSQL
				.concat("  JOIN (SELECT nrop, SUM(qtpecasproduzir) as prodplanOP FROM ijopprodutos GROUP BY nrop) f ON (f.nrop = a.nrop)");
		strSQL = strSQL.concat("  LEFT OUTER JOIN ijinjctrlultparmon tup ON (a.cdinjetora = tup.cdinjetora) ");
		strSQL = strSQL.concat("  LEFT OUTER JOIN ijtbinjqldctrl tibm ON (a.cdinjetora = tibm.cdinjetora)  ");
		strSQL = strSQL.concat(
				"  LEFT OUTER JOIN IJctrlINIPROC cip ON (cip.CdInjetora  = a.cdinjetora AND cip.NrOP = a.NrOP AND cip.DtHrFimCtrlIniProc IS NULL) ");
		strSQL = strSQL.concat("  LEFT OUTER JOIN IJctrlINIPROCTroca cipt ON (cip.IdCtrlInicProc  = cipt.IdCtrlInicProc) ");
		strSQL = strSQL.concat("  LEFT OUTER JOIN ijtbinjalerta ial ON (a.cdinjetora = ial.cdinjetora)");

		// dados do refugo
		strSQL = strSQL.concat("  LEFT OUTER JOIN ");
		strSQL = strSQL.concat(
				"  	 (SELECT r.dthriniintervalo, r.cdinjetora, r.nrop, r.cdmolde, r.cdestrutura, r.dthrivalestru, r.dthrivalcic, m.cdproduto, ");
		strSQL = strSQL.concat(
				"  				SUM((r.qtpcsref * (CASE WHEN (cm.tmpcicnormal = 0 OR cm.qtinjnormal = 0)  THEN 0 ELSE (cm.tmpcicnormal / cm.qtinjnormal) END)) / (c.cavativas * d.fatorcontagemprod)) as tmppcsref, ");
		strSQL = strSQL.concat("  				SUM(r.qtpcsref) as qtpcsref ");
		strSQL = strSQL.concat("  		  FROM ijcnsUTdetref r, ijmolpro m, viewDadosCalcCicMedioUT cm, cavidades c, ijfictec d ");
		strSQL = strSQL.concat("  		 WHERE m.cdmolde = r.cdmolde ");
		strSQL = strSQL.concat("   		   AND m.cdestrutura = r.cdestrutura ");
		strSQL = strSQL.concat("  		   AND m.dthrival = r.dthrivalestru ");

		strSQL = strSQL.concat("  		   AND m.cdidentificacao = r.cdidentificacao ");
		strSQL = strSQL.concat("  		   AND cm.dthriniintervalo = r.dthriniintervalo ");
		strSQL = strSQL.concat("  		   AND cm.cdinjetora = r.cdinjetora ");
		strSQL = strSQL.concat("  		   AND cm.cdmolde = r.cdmolde ");
		strSQL = strSQL.concat("           AND cm.cdestrutura = r.cdestrutura ");
		strSQL = strSQL.concat("           AND cm.dthrivalcic = r.dthrivalcic ");

		strSQL = strSQL.concat("  		   AND r.CdMolde       = c.CdMolde ");
		strSQL = strSQL.concat("  		   AND r.CdEstrutura   = c.CdEstrutura ");
		strSQL = strSQL.concat("  		   AND r.DtHrIValEstru = c.DtHrIVal ");

		strSQL = strSQL.concat("  		   AND d.cdinjetora = r.cdinjetora ");
		strSQL = strSQL.concat("  		   AND d.cdmolde = r.cdmolde ");
		strSQL = strSQL.concat("  		   AND d.cdestrutura = r.cdestrutura ");
		strSQL = strSQL.concat("  		   AND d.dthrivalcic = r.dthrivalcic ");
		strSQL = strSQL.concat(
				" 	 GROUP BY r.dthriniintervalo, r.cdinjetora, r.nrop, r.cdmolde, r.cdestrutura, r.dthrivalestru, r.dthrivalcic, m.cdproduto ");
		strSQL = strSQL.concat("  	 ) cr ON (      cr.dthriniintervalo = a.dthriniintervalo ");
		strSQL = strSQL.concat("  				AND cr.cdinjetora = a.cdinjetora ");
		strSQL = strSQL.concat("  				AND cr.nrop = a.nrop ");
		strSQL = strSQL.concat("  				AND cr.cdmolde = a.cdmolde ");
		strSQL = strSQL.concat("  				AND cr.cdestrutura = a.cdestrutura ");
		strSQL = strSQL.concat("  				AND cr.dthrivalestru = a.dthrivalestru ");
		strSQL = strSQL.concat("  				AND cr.dthrivalcic = a.dthrivalcic ");
		strSQL = strSQL.concat("  				AND cr.cdproduto = d.cdproduto) ");

		strSQL = strSQL.concat(
				" LEFT JOIN (SELECT a.dthriniintervalo, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, a.nrop, ");
		strSQL = strSQL.concat("                   SUM(a.tmpparadas + a.tmpparadassempeso) as tmpparMTBFMTTR, ");
		strSQL = strSQL.concat("                   SUM(a.qtdparadas + a.qtdparadassempeso) as qtdparMTBFMTTR ");
		strSQL = strSQL.concat("             FROM IJREAPARCNSOCORUT a ");
		strSQL = strSQL.concat("             JOIN ijtbinj d ON (d.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("             JOIN ijtbpar p ON (p.cdparada = a.cdparada and p.CalcMTBFMTTR = '1') ");
		strSQL = strSQL.concat(
				"       GROUP BY a.dthriniintervalo, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, a.nrop ) ");
		strSQL = strSQL.concat("  mtbf ON (    mtbf.dthriniintervalo = a.dthriniintervalo ");
		strSQL = strSQL.concat("           AND mtbf.cdinjetora = a.cdinjetora ");
		strSQL = strSQL.concat("           AND mtbf.cdmolde = a.cdmolde ");
		strSQL = strSQL.concat("           AND mtbf.cdestrutura = a.cdestrutura ");
		strSQL = strSQL.concat("           AND mtbf.dthrivalestru = a.dthrivalestru ");
		strSQL = strSQL.concat("           AND mtbf.dthrivalcic = a.dthrivalcic ");
		strSQL = strSQL.concat("           AND mtbf.nrop = a.nrop) ");

		strSQL = strSQL.concat(" WHERE a.dthriniintervalo = a.dthriniintervalo ");

		if (filtro.getDthrIhora() != null || filtro.getDthrFhora() != null) {
			strSQL = strSQL.concat("  AND a.dthriniintervalo BETWEEN :dthrini AND :dthrfim ");
		}

		if (filtro.getOmPt() != null) {
			strSQL = strSQL.concat(" AND i.cdinjestendido = :cdinjetora");
		}

		if (filtro.getCdCp() != null && filtro.getCdCp().equals("") == false && filtro.getFiltroOp() != null
				&& (filtro.getFiltroOp() == 0 || filtro.getFiltroOp() == 3)) {
			strSQL = strSQL.concat(" AND a.nrop = :nrop ");
		}

		strSQL = strSQL.concat(" AND d.cdproduto = :cdproduto ");

		return strSQL;
	}

	private String getConsultaSemFiltroProdutoUT(FiltroDetalhePTInjetDTO filtro) {
		String strSQL = "";

		strSQL = strSQL.concat(
				"SELECT a.idregistro, a.nrop, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalcic, a.dthrivalestru, c.ciclopadrao, c.fatorcontagemprod, d.qtcavativas, d.qtcavidades,");
		strSQL = strSQL.concat(
				"       (CASE WHEN a.qtinjnormal IS NULL or a.qtinjnormal = 0 THEN 0 ELSE (a.tmpcicnormal  / a.qtinjnormal)  END) as ciclomedio, ");
		strSQL = strSQL.concat("       (b.prodbrutaOP) as prodbrutaOP, ");
		strSQL = strSQL.concat("       (b.prodrefOP) as prodrefOP,");
		strSQL = strSQL.concat("       (a.qtprodbrutaUB) as prodbruta, ");
		strSQL = strSQL.concat("       (a.qtprodrefugadaUB) as prodref, ");
		strSQL = strSQL.concat("       (a.tmpcicnormal) as tmpcicnormal, ");
		strSQL = strSQL.concat("       (a.tmpcicfinparada) as tmpcicfinparada, ");
		strSQL = strSQL.concat("       (a.tmpparadas) as tmpparadasCP, ");
		strSQL = strSQL.concat("       (a.tmpparadassempeso) as tmpparadasSP, ");
		strSQL = strSQL.concat("       (FLOOR(a.tmpcicnormal / c.ciclopadrao) * (CASE WHEN ct.campo23 = '¬¬ª¿±·¿½­' THEN d.qtcavidades ELSE d.qtcavativas END)  * c.fatorcontagemprod) as prodprev, ");
		strSQL = strSQL.concat("       f.prodplanOP, ");
		strSQL = strSQL.concat("       ((CASE WHEN a.tmpativo IS NULL THEN 0 ELSE a.tmpativo END)) as tmphrsdisp, ");
		strSQL = strSQL.concat("       (a.tmpcavidades) as tmpcavidades, ");
		strSQL = strSQL.concat("       ((CASE WHEN a.tmpprodrefugada IS NULL THEN 0 ELSE a.tmpprodrefugada END)) as tmprefugo, ");
		strSQL = strSQL.concat("       ( (((a.tmpcicnormal / a.ciclopadrao) - a.qtinjnormal ) * a.ciclopadrao) ) as tmpritmo, ");
		strSQL = strSQL.concat("       tup.dthriparrefmonit, tup.dthrfparrefmonit, ");
		strSQL = strSQL.concat("       tibm.StUltInspQldBM, ");
		strSQL = strSQL.concat(
				"       cip.IdCtrlInicProc, cipt.CdMoldeSaida as CdMoldeSaidaCIP, cipt.CdEstruSaida as CdEstruSaidaCIP, cipt.CdMoldeEntrada as CdMoldeEntradaCIP, cipt.CdEstruEntrada as CdEstruEntradaCIP, ");
		strSQL = strSQL.concat("       cip.DtHrIniCtrlIniProc, cip.DtHrFimCtrlIniProc, ");
		strSQL = strSQL.concat("       ial.QtAlertasOperador, ");
		strSQL = strSQL.concat("       i.stfuncionamento, i.aguardandomolde, i.AlertaInspQld, i.maquinaemalerta, i.StUltInspQld, ");
		strSQL = strSQL.concat(
				" 	   ( ( (a.tmpcicnormal / c.ciclopadrao) - a.qtinjnormal) * (d.qtcavativas * c.fatorcontagemprod)) as qtdritmo, ");
		strSQL = strSQL.concat(" 	   ( (a.qtinjnormal * (d.qtcavidades - d.qtcavativas)) * c.fatorcontagemprod) as qtdperdapcsciclo, ");
		strSQL = strSQL.concat(" 	   ( a.qtinjnormal * d.qtcavidades) as qtdpcsciclototal, ");
		strSQL = strSQL.concat(" 	   ( a.qtinjnormal * d.qtcavativas) as qtdpcscicloativas, ");
		strSQL = strSQL.concat(" 	   ( ( a.tmpparadas / c.ciclopadrao) * (d.qtcavativas * c.fatorcontagemprod) ) as qtdperdasparCP, ");
		strSQL = strSQL.concat(" 	   ( ( a.tmpparadas / c.ciclopadrao) * (d.qtcavativas * c.fatorcontagemprod) ) as qtdperdasparSP, ");
		strSQL = strSQL.concat(
				" 	   a.qtinjnormal, a.qtinjfinpar, c.varmin, c.varmax, mtbf.tmpparMTBFMTTR, mtbf.qtdparMTBFMTTR, a.dthriniintervalo, mld.cdmolestendido, rot.nropexibicao, op.dthrireal, ");
		strSQL = strSQL.concat(" 	   i.cdinjestendido, i.cdidentific ");
		strSQL = strSQL.concat("  FROM viewDadosCalcOEEOPUT a ");
		strSQL = strSQL.concat("  JOIN ijtbfresh ct ON (1=1) ");
		strSQL = strSQL.concat("  LEFT JOIN (SELECT a.nrop, SUM(a.qtprodbrutaUB) as prodbrutaOP, SUM(a.qtprodrefugadaUB) as prodrefOP  ");
		strSQL = strSQL.concat("               FROM viewDadosCalcOEEOP a ");
		strSQL = strSQL.concat("              GROUP BY a.nrop) b ON (b.nrop = a.nrop)");
		strSQL = strSQL.concat(
				"  JOIN ijfictec c ON (c.cdinjetora = a.cdinjetora AND c.cdmolde = a.cdmolde AND c.cdestrutura = a.cdestrutura AND c.dthrivalcic = a.dthrivalcic)");
		strSQL = strSQL.concat(
				"  JOIN cavidades2 d ON (d.cdmolde = c.cdmolde AND d.cdestrutura = c.cdestrutura AND d.dthrival = c.dthrivalestru) ");
		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol mld ON (mld.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijop op ON (op.nrop = a.nrop) ");
		strSQL = strSQL.concat(
				"  JOIN ijoproteiro rot ON  (rot.nrop = a.nrop AND rot.cdinjetora = a.cdinjetora AND rot.cdmolde = a.cdmolde AND rot.cdestrutura = a.cdestrutura) ");
		strSQL = strSQL
				.concat("  JOIN (SELECT nrop, SUM(qtpecasproduzir) as prodplanOP FROM ijopprodutos GROUP BY nrop) f ON (f.nrop = a.nrop)");
		strSQL = strSQL.concat("  LEFT OUTER JOIN ijinjctrlultparmon tup ON (a.cdinjetora = tup.cdinjetora) ");
		strSQL = strSQL.concat("  LEFT OUTER JOIN ijtbinjqldctrl tibm ON (a.cdinjetora = tibm.cdinjetora)  ");

		strSQL = strSQL.concat(
				" LEFT JOIN (SELECT a.dthriniintervalo, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, a.nrop, ");
		strSQL = strSQL.concat("                   SUM(a.tmpparadas + a.tmpparadassempeso) as tmpparMTBFMTTR, ");
		strSQL = strSQL.concat("                   COUNT(a.dthriniintervalo) as qtdparMTBFMTTR ");
		strSQL = strSQL.concat("             FROM IJREAPARCNSOCORUT a ");
		strSQL = strSQL.concat("             JOIN ijtbinj d ON (d.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("             JOIN ijtbpar p ON (p.cdparada = a.cdparada and p.CalcMTBFMTTR = '1') ");
		strSQL = strSQL.concat(
				"       GROUP BY a.dthriniintervalo, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, a.nrop ) ");
		strSQL = strSQL.concat("  mtbf ON (    mtbf.dthriniintervalo = a.dthriniintervalo ");
		strSQL = strSQL.concat("           AND mtbf.cdinjetora = a.cdinjetora ");
		strSQL = strSQL.concat("           AND mtbf.cdmolde = a.cdmolde ");
		strSQL = strSQL.concat("           AND mtbf.cdestrutura = a.cdestrutura ");
		strSQL = strSQL.concat("           AND mtbf.dthrivalestru = a.dthrivalestru ");
		strSQL = strSQL.concat("           AND mtbf.dthrivalcic = a.dthrivalcic ");
		strSQL = strSQL.concat("           AND mtbf.nrop = a.nrop) ");

		strSQL = strSQL.concat(
				"  LEFT OUTER JOIN IJctrlINIPROC cip ON (cip.CdInjetora  = a.cdinjetora AND cip.NrOP = a.NrOP AND cip.DtHrFimCtrlIniProc IS NULL) ");
		strSQL = strSQL.concat("  LEFT OUTER JOIN IJctrlINIPROCTroca cipt ON (cip.IdCtrlInicProc  = cipt.IdCtrlInicProc) ");
		strSQL = strSQL.concat("  LEFT OUTER JOIN ijtbinjalerta ial ON (a.cdinjetora = ial.cdinjetora)");

		strSQL = strSQL.concat(" WHERE a.dthriniintervalo = a.dthriniintervalo ");

		if (filtro.getDthrIhora() != null || filtro.getDthrFhora() != null) {
			strSQL = strSQL.concat("  AND a.dthriniintervalo BETWEEN :dthrini AND :dthrfim ");
		}

		if (filtro.getOmPt() != null) {
			strSQL = strSQL.concat(" AND i.cdinjestendido = :cdinjetora");
		}

		if (filtro.getCdCp() != null && filtro.getCdCp().equals("") == false && filtro.getFiltroOp() != null
				&& (filtro.getFiltroOp() == 0 || filtro.getFiltroOp() == 3)) {
			strSQL = strSQL.concat(" AND a.nrop = :nrop ");
		}

		return strSQL;
	}

	/*
	 * Metodo principal para pesquisar os DwConsolid necessarios para o detalhe
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	public List<DwConsolid> pesquisarDwConsolids(IdwLogger log, FiltroDetalhePTInjetDTO filtro) {
		List<DwConsolid> retorno = new ArrayList<DwConsolid>();
		String strSQL = "";

		int _idregistro = 0;
		int _nrOP = _idregistro + 1;
		int _cdinjetora = _nrOP + 1;
		int _cdMolde = _cdinjetora + 1;
		int _cdEstrutura = _cdMolde + 1;
		int _dthrIValCic = _cdEstrutura + 1;
		int _dthrIValEstru = _dthrIValCic + 1;
		int _cicloPadrao = _dthrIValEstru + 1;
		int _fatorContagemProd = _cicloPadrao + 1;
		int _pcsCicloAtivas = _fatorContagemProd + 1;
		int _pcsCicloTotais = _pcsCicloAtivas + 1;
		int _cicloMedio = _pcsCicloTotais + 1;
		int _qtdProdBrutaOP = _cicloMedio + 1;
		int _qtdProdRefOP = _qtdProdBrutaOP + 1;
		int _qtdProdBruta = _qtdProdRefOP + 1;
		int _qtdProdRef = _qtdProdBruta + 1;
		int _segCicloNormais = _qtdProdRef + 1;
		int _segCicloFinParada = _segCicloNormais + 1;
		int _segParadasCP = _segCicloFinParada + 1;
		int _segParadasSP = _segParadasCP + 1;
		int _qtdProdPrev = _segParadasSP + 1;
		int _qtdProdPlan = _qtdProdPrev + 1;
		int _segDisp = _qtdProdPlan + 1;
		int _segPcsCic = _segDisp + 1;
		int _segRefugo = _segPcsCic + 1;
		int _segRitmo = _segRefugo + 1;
		int _dthrIUltParRefMon = _segRitmo + 1;
		int _dthrFUltParRefMon = _dthrIUltParRefMon + 1;
		int _stUltInspQldBM = _dthrFUltParRefMon + 1;
		int _idCIP = _stUltInspQldBM + 1;
		int _cdMolSaidaCIP = _idCIP + 1;
		int _cdEstruSaidaCIP = _cdMolSaidaCIP + 1;
		int _cdMolEntradaCIP = _cdEstruSaidaCIP + 1;
		int _cdEstruEntradaCIP = _cdMolEntradaCIP + 1;
		int _dthrICIP = _cdEstruEntradaCIP + 1;
		int _dthrFCIP = _dthrICIP + 1;
		int _qtdAleOpe = _dthrFCIP + 1;
		int _stFuncionamento = _qtdAleOpe + 1;
		int _aguardandoMolde = _stFuncionamento + 1;
		int _emAleInspQld = _aguardandoMolde + 1;
		int _emAlerta = _emAleInspQld + 1;
		int _stUltInspQld = _emAlerta + 1;
		int _qtdPerdaRitmo = _stUltInspQld + 1;
		int _qtdPerdaPcsCic = _qtdPerdaRitmo + 1;
		int _qtdPcsCicAtiva = _qtdPerdaPcsCic + 1;
		int _qtdPcsCicTotal = _qtdPcsCicAtiva + 1;
		int _qtdPerdaParCP = _qtdPcsCicTotal + 1;
		int _qtdPerdaParSP = _qtdPerdaParCP + 1;
		int _qtdCiclosNormais = _qtdPerdaParSP + 1;
		int _qtdCiclosFinParada = _qtdCiclosNormais + 1;
		int _cicloPadraoMin = _qtdCiclosFinParada + 1;
		int _cicloPadraoMax = _cicloPadraoMin + 1;
		int _segTmpParMTBF = _cicloPadraoMax + 1;
		int _qtParMTBF = _segTmpParMTBF + 1;

		int _dthrIniIntervalo = _qtParMTBF + 1;
		int _dtTurno = _qtParMTBF + 1;

		int _cdTurno = _dtTurno + 1;
		int _dsTurno = _cdTurno + 1;

		int _cdMolEstendido = (filtro.getTpId().equals(PERIODO_CONSOLIDACAO_HORA) ? _dthrIniIntervalo : _dsTurno) + 1;

		int _nropExibicao = _cdMolEstendido + 1;
		int _dthrirealOP = _nropExibicao + 1;
		int _cdInjEstendido = _dthrirealOP + 1;
		int _cdIdentific = _cdInjEstendido + 1;
		int _cdProduto = _cdIdentific + 1;
		int _dsProduto = _cdProduto + 1;

		class RegistroLido {
			BigDecimal idregistro = BigDecimal.ZERO;
			String nrOP;
			String nrOPExibicao;
			Date dthrirealOP;
			String cdInjetora;
			String cdMolde;
			String cdMolEstendido;
			String cdEstrutura;
			Date dthrIValCic;
			Date dthrIValEstru;
			BigDecimal cicloPadrao = BigDecimal.ZERO;
			BigDecimal fatorContagemProd = BigDecimal.ZERO;
			BigDecimal pcsCicloAtivas = BigDecimal.ZERO;
			BigDecimal pcsCicloTotais = BigDecimal.ZERO;
			BigDecimal cicloMedio = BigDecimal.ZERO;
			BigDecimal qtdProdBrutaOP = BigDecimal.ZERO;;
			BigDecimal qtdProdRefOP = BigDecimal.ZERO;
			BigDecimal qtdProdBruta = BigDecimal.ZERO;
			BigDecimal qtdProdRef = BigDecimal.ZERO;
			BigDecimal segCicloNormais = BigDecimal.ZERO;
			BigDecimal segCicloFinParada = BigDecimal.ZERO;
			BigDecimal segParadasCP = BigDecimal.ZERO;
			BigDecimal segParadasSP = BigDecimal.ZERO;
			BigDecimal qtdProdPrev = BigDecimal.ZERO;
			BigDecimal qtdProdPlan = BigDecimal.ZERO;
			BigDecimal segDisp = BigDecimal.ZERO;
			BigDecimal segPcsCic = BigDecimal.ZERO;
			BigDecimal segRefugo = BigDecimal.ZERO;
			BigDecimal segRitmo = BigDecimal.ZERO;
			BigDecimal segTmpParMTBF = BigDecimal.ZERO;
			BigDecimal qtParMTBF = BigDecimal.ZERO;
			Date dthrIUltParRefMon;
			Date dthrFUltParRefMon;
			String stUltInspQldBM;
			String idCIP;
			String cdMolSaidaCIP;
			String cdEstruSaidaCIP;
			String cdMolEntradaCIP;
			String cdEstruEntradaCIP;
			Date dthrICIP;
			Date dthrFCIP;
			Integer qtdAleOpe;
			String stFuncionamento;
			Integer aguardandoMolde;
			String emAleInspQld;
			Integer emAlerta;
			String stUltInspQld;
			BigDecimal qtdPerdaRitmo = BigDecimal.ZERO;
			BigDecimal qtdPerdaPcsCic = BigDecimal.ZERO;
			BigDecimal qtdPcsCicAtiva = BigDecimal.ZERO;
			BigDecimal qtdPcsCicTotal = BigDecimal.ZERO;
			BigDecimal qtdPerdaParCP = BigDecimal.ZERO;
			BigDecimal qtdPerdaParSP = BigDecimal.ZERO;
			BigDecimal qtdCiclosNormais = BigDecimal.ZERO;
			BigDecimal qtdCiclosFinParada = BigDecimal.ZERO;
			BigDecimal cicloPadraoMin = BigDecimal.ZERO;
			BigDecimal cicloPadraoMax = BigDecimal.ZERO;
			Date dtTurno;
			String cdTurno;
			String dsTurno;
			String cdProduto;
			String dsProduto;
			String cdInjEstendido;
			String cdIdentific;
			Date dthrIniIntervalo;
			Date dthrFimIntervalo;
		}

		boolean isFiltroProduto = (filtro.getOmProduto() != null);
		boolean isFiltroDtRef = (filtro.getDtReferencia() != null && filtro.getTpId().equals(PERIODO_CONSOLIDACAO_HORA) == false);
		boolean isFiltroIntervalo = (filtro.getDthrIhora() != null && filtro.getDthrFhora() != null && filtro.getTpId().equals(PERIODO_CONSOLIDACAO_HORA) == true);
		boolean isFiltroCP = (filtro.getCdCp() != null && filtro.getCdCp().equals("") == false && filtro.getFiltroOp() != null
				&& (filtro.getFiltroOp() == 0 || filtro.getFiltroOp() == 3));
		boolean isFiltroPt = (filtro.getOmPt() != null);

		if (isFiltroProduto) {
			if (filtro.getTpId().equals(PERIODO_CONSOLIDACAO_HORA)) {
				strSQL = getConsultaComFiltroProdutoUT(filtro);
			} else {
				strSQL = getConsultaComFiltroProduto(filtro);
			}

		} else {
			if (filtro.getTpId().equals(PERIODO_CONSOLIDACAO_HORA)) {
				strSQL = getConsultaSemFiltroProdutoUT(filtro);
			} else {
				strSQL = getConsultaSemFiltroProduto(filtro);
			}
		}

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

		if (isFiltroProduto) {
			q.setString("cdproduto", filtro.getOmProduto().getCdProduto());
		}
		if (isFiltroDtRef) {
			q.setTimestamp("dtref", filtro.getDtReferencia())
					.setString("cdturno", FuncoesApoioInjet.getStrZero(filtro.getDwTurno().getIdTurno(), 6));
		}
		if (isFiltroIntervalo) {
			q.setTimestamp("dthrini", filtro.getDthrIhora())
					.setTimestamp("dthrfim", filtro.getDthrFhora());
		}

		if (isFiltroCP) {
			q.setString("nrop", filtro.getCdCp());
		}
		if (isFiltroPt) {
			q.setString("cdinjetora", filtro.getOmPt().getCdPt());
		}

		List<Object> lista = new ArrayList<Object>();
		lista = q.list();

		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.idregistro = ConversaoTipos.converterParaBigDecimal(registroLido[_idregistro]);

			if (filtro.getTpId().equals(PERIODO_CONSOLIDACAO_HORA)) {
				registro.dthrIniIntervalo = (Date) registroLido[_dthrIniIntervalo];
				registro.dthrIniIntervalo = DataHoraRN.adicionaSegundosNaData(registro.dthrIniIntervalo, 0);
				registro.dthrFimIntervalo = DataHoraRN.adicionaSegundosNaData(registro.dthrIniIntervalo, 3599);
			} else {
				registro.dtTurno = (Date) registroLido[_dtTurno];
				registro.cdTurno = (String) registroLido[_cdTurno];
				registro.dsTurno = (String) registroLido[_dsTurno];
			}

			registro.nrOP = (String) registroLido[_nrOP];
			registro.nrOPExibicao = (String) registroLido[_nropExibicao];
			registro.dthrirealOP = (Date) registroLido[_dthrirealOP];
			registro.cdInjetora = (String) registroLido[_cdinjetora];
			registro.cdInjEstendido = (String) registroLido[_cdInjEstendido];
			registro.cdIdentific = (String) registroLido[_cdIdentific];
			registro.cdMolde = (String) registroLido[_cdMolde];
			registro.cdMolEstendido = (String) registroLido[_cdMolEstendido];
			registro.cdEstrutura = (String) registroLido[_cdEstrutura];

			registro.dthrIValCic = (Date) registroLido[_dthrIValCic];
			registro.dthrIValEstru = (Date) registroLido[_dthrIValEstru];

			registro.cicloPadrao = ConversaoTipos
					.converterParaBigDecimal(registroLido[_cicloPadrao] != null ? registroLido[_cicloPadrao] : BigDecimal.ZERO);
			registro.fatorContagemProd = ConversaoTipos
					.converterParaBigDecimal(registroLido[_fatorContagemProd] != null ? registroLido[_fatorContagemProd] : BigDecimal.ZERO);
			registro.pcsCicloAtivas = ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos
					.converterParaBigDecimal(registroLido[_pcsCicloAtivas] != null ? registroLido[_pcsCicloAtivas] : BigDecimal.ZERO));
			registro.pcsCicloTotais = ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos
					.converterParaBigDecimal(registroLido[_pcsCicloTotais] != null ? registroLido[_pcsCicloTotais] : BigDecimal.ZERO));

			registro.cicloMedio =
					ConversaoTipos.converterParaBigDecimal(registroLido[_cicloMedio] != null ? registroLido[_cicloMedio] : BigDecimal.ZERO);
			registro.cicloPadraoMin = ConversaoTipos
					.converterParaBigDecimal(registroLido[_qtdCiclosNormais] != null ? registroLido[_cicloPadraoMin] : BigDecimal.ZERO);
			registro.cicloPadraoMax = ConversaoTipos
					.converterParaBigDecimal(registroLido[_qtdCiclosFinParada] != null ? registroLido[_cicloPadraoMax] : BigDecimal.ZERO);

			registro.qtdProdBrutaOP = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos
					.converterParaBigDecimal(registroLido[_qtdProdBrutaOP] != null ? registroLido[_qtdProdBrutaOP] : BigDecimal.ZERO));

			registro.qtdProdRefOP = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos
					.converterParaBigDecimal(registroLido[_qtdProdRefOP] != null ? registroLido[_qtdProdRefOP] : BigDecimal.ZERO));
			registro.qtdProdBruta = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos
					.converterParaBigDecimal(registroLido[_qtdProdBruta] != null ? registroLido[_qtdProdBruta] : BigDecimal.ZERO));
			registro.qtdProdRef =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos
							.converterParaBigDecimal(registroLido[_qtdProdRef] != null ? registroLido[_qtdProdRef] : BigDecimal.ZERO));
			registro.segCicloNormais = ConversaoTipos
					.converterParaBigDecimal(registroLido[_segCicloNormais] != null ? registroLido[_segCicloNormais] : BigDecimal.ZERO);
			registro.segCicloFinParada = ConversaoTipos
					.converterParaBigDecimal(registroLido[_segCicloFinParada] != null ? registroLido[_segCicloFinParada] : BigDecimal.ZERO);
			registro.segParadasCP = ConversaoTipos
					.converterParaBigDecimal(registroLido[_segParadasCP] != null ? registroLido[_segParadasCP] : BigDecimal.ZERO);
			registro.segParadasSP = ConversaoTipos
					.converterParaBigDecimal(registroLido[_segParadasSP] != null ? registroLido[_segParadasSP] : BigDecimal.ZERO);
			registro.qtdProdPrev = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos
					.converterParaBigDecimal(registroLido[_qtdProdPrev] != null ? registroLido[_qtdProdPrev] : BigDecimal.ZERO));
			registro.qtdProdPlan = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos
					.converterParaBigDecimal(registroLido[_qtdProdPlan] != null ? registroLido[_qtdProdPlan] : BigDecimal.ZERO));
			registro.segDisp =
					ConversaoTipos.converterParaBigDecimal(registroLido[_segDisp] != null ? registroLido[_segDisp] : BigDecimal.ZERO);
			registro.segPcsCic =
					ConversaoTipos.converterParaBigDecimal(registroLido[_segPcsCic] != null ? registroLido[_segPcsCic] : BigDecimal.ZERO);
			registro.segRefugo =
					ConversaoTipos.converterParaBigDecimal(registroLido[_segRefugo] != null ? registroLido[_segRefugo] : BigDecimal.ZERO);
			registro.segRitmo =
					ConversaoTipos.converterParaBigDecimal(registroLido[_segRitmo] != null ? registroLido[_segRitmo] : BigDecimal.ZERO);

			registro.dthrIUltParRefMon = (Date) registroLido[_dthrIUltParRefMon];
			registro.dthrFUltParRefMon = (Date) registroLido[_dthrFUltParRefMon];
			registro.dthrICIP = (Date) registroLido[_dthrICIP];
			registro.dthrFCIP = (Date) registroLido[_dthrFCIP];

			// problema com tipos entre oracle e sql
			registro.qtdAleOpe = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdAleOpe] == null ? 0 : registroLido[_qtdAleOpe]).intValue();
			registro.aguardandoMolde = ConversaoTipos.converterParaBigDecimal(registroLido[_aguardandoMolde]).intValue();
			registro.emAlerta = ConversaoTipos.converterParaBigDecimal(registroLido[_emAlerta]).intValue();

			registro.stUltInspQldBM = ((Character) (registroLido[_stUltInspQldBM] == null ? '0' : registroLido[_stUltInspQldBM])).toString();
			registro.idCIP = (String) registroLido[_idCIP];
			registro.cdMolSaidaCIP = (String) registroLido[_cdMolSaidaCIP];
			registro.cdEstruSaidaCIP = (String) registroLido[_cdEstruSaidaCIP];
			registro.cdMolEntradaCIP = (String) registroLido[_cdMolEntradaCIP];
			registro.cdEstruEntradaCIP = (String) registroLido[_cdEstruEntradaCIP];
			registro.stFuncionamento = (String) registroLido[_stFuncionamento];
			registro.emAleInspQld = (registroLido[_emAleInspQld] == null ? "0" : ((Character) registroLido[_emAleInspQld]).toString());
			registro.stUltInspQld = (registroLido[_stUltInspQld] == null ? "0" : ((Character) registroLido[_stUltInspQld]).toString());

			registro.qtdPerdaRitmo = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos
					.converterParaBigDecimal(registroLido[_qtdPerdaRitmo] != null ? registroLido[_qtdPerdaRitmo] : BigDecimal.ZERO));
			registro.qtdPerdaParCP = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos
					.converterParaBigDecimal(registroLido[_qtdPerdaParCP] != null ? registroLido[_qtdPerdaParCP] : BigDecimal.ZERO));
			registro.qtdPerdaParSP = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos
					.converterParaBigDecimal(registroLido[_qtdPerdaParSP] != null ? registroLido[_qtdPerdaParSP] : BigDecimal.ZERO));
			registro.qtdPerdaPcsCic = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos
					.converterParaBigDecimal(registroLido[_qtdPerdaPcsCic] != null ? registroLido[_qtdPerdaPcsCic] : BigDecimal.ZERO));

			
			registro.qtdPcsCicAtiva = ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos
					.converterParaBigDecimal(registroLido[_qtdPcsCicAtiva] != null ? registroLido[_qtdPcsCicAtiva] : BigDecimal.ZERO));
			registro.qtdPcsCicTotal = ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos
					.converterParaBigDecimal(registroLido[_qtdPcsCicTotal] != null ? registroLido[_qtdPcsCicTotal] : BigDecimal.ZERO));

			registro.qtdCiclosNormais = ConversaoTipos
					.converterParaBigDecimal(registroLido[_qtdCiclosNormais] != null ? registroLido[_qtdCiclosNormais] : BigDecimal.ZERO);
			registro.qtdCiclosFinParada = ConversaoTipos.converterParaBigDecimal(
					registroLido[_qtdCiclosFinParada] != null ? registroLido[_qtdCiclosFinParada] : BigDecimal.ZERO);

			if (registroLido[_segTmpParMTBF] != null) {
				registro.segTmpParMTBF = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParMTBF]);
				registro.qtParMTBF = ConversaoTipos.converterParaBigDecimal(registroLido[_qtParMTBF]);
			}

			if (isFiltroProduto) {
				registro.cdProduto = (String) registroLido[_cdProduto];
				registro.dsProduto = (String) registroLido[_dsProduto];
			}

			// preecher dwconsolid
			DwConsolid dwci = new DwConsolid();
			DwConsol dwc = new DwConsol();

			Date dthrITur = null;
			Date dthrFTur = null;

			dwci.setIdConsolid(registro.idregistro.longValue());

			try {
				if (filtro.getTpId().equals(PERIODO_CONSOLIDACAO_HORA)) {
					TurnoInjetDTO tur = FuncoesApoioInjet.encontraTurno(this.getDao(), registro.dthrIniIntervalo);
					registro.cdTurno = tur.getIjtbtur().getCdturno();
					registro.dsTurno = tur.getIjtbtur().getDsturno();
					registro.dtTurno = tur.getDtReferencia();
				}

				dthrITur = FuncoesApoioInjet.calcularInicioTurno(this.getDao(), registro.dtTurno, registro.cdTurno);
				dthrFTur = FuncoesApoioInjet.calcularFimTurno(this.getDao(), registro.dtTurno, registro.cdTurno);

			} catch (SemCalendarioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			dwci.setDthrIturno(dthrITur);
			dwci.setDthrFturno(dthrFTur);
			dwci.setDtReferencia(registro.dtTurno);
			dwci.setDthrIhora(registro.dthrIniIntervalo);
			dwci.setDthrFhora(registro.dthrFimIntervalo);
			// dwci.setTpId((byte) 1);
			dwci.setTpId(filtro.getTpId());
			dwci.setDwRt(new DwRt()); // se precisar tem que montar

			DwTurno dwTur = new DwTurno();
			dwTur.setIdTurno(ConversaoTipos.converteParaBigDecimal(registro.cdTurno).longValue());
			dwTur.setCdTurno(registro.cdTurno);
			dwTur.setDsTurno(registro.dsTurno);
			dwci.setDwTurno(dwTur);

			OmPt ompt = new OmPt();
			ompt.setCdPt(registro.cdInjEstendido);
			ompt.setDsPt(registro.cdIdentific);
			ompt.setDsCurta(registro.cdIdentific);
			dwci.setOmPt(ompt);

			PpCp cp = new PpCp();
			cp.setCdCp(registro.nrOP);
			cp.setDthrInicioreal(registro.dthrirealOP);
			cp.setPpCpprodutos(new HashSet<PpCpproduto>());

			PpCpproduto pro = new PpCpproduto();
			pro.setPcsProducaoplanejada(registro.qtdProdPlan);
			pro.setPcsProducaobruta(registro.qtdProdBrutaOP);
			pro.setPcsProducaorefugada(registro.qtdProdRefOP);
			cp.getPpCpprodutos().add(pro);
			dwci.setPpCp(cp);

			// folha
			DwFolha oFolha = new DwFolha();
			oFolha.setDwFolharaps(new HashSet<DwFolharap>());
			oFolha.setCdFolha(registro.cdMolEstendido + "/" + registro.cdEstrutura);
			oFolha.setDsFolha(oFolha.getCdFolha());
			oFolha.setQtFatorcontagem(registro.fatorContagemProd);
			oFolha.setSegCiclopadrao(registro.cicloPadrao);
			oFolha.setSegCiclominimo(registro.cicloPadraoMin);
			oFolha.setSegCiclotimeout(registro.cicloPadraoMax);
			oFolha.setDtRevisao(registro.dthrIValCic);

			DwFolharap ofRap = new DwFolharap();
			ofRap.setDwFolharapcoms(new HashSet<DwFolharapcom>());

			// produtos
			Set<DwConsolpr> listaProdutos = new HashSet<DwConsolpr>();
			if (filtro.getTpId().equals(PERIODO_CONSOLIDACAO_HORA)) {
				listaProdutos =
						getProdutosConsolidacaoUT(dwc, registro.dthrIniIntervalo, registro.cdInjetora, registro.nrOP, registro.cdMolde,
								registro.cdEstrutura, registro.dthrIValEstru, registro.dthrIValCic, registro.cdProduto);
			} else {
				listaProdutos =
						getProdutosConsolidacao(dwc, registro.dtTurno, registro.cdTurno, registro.cdInjetora, registro.nrOP,
								registro.cdMolde,
								registro.cdEstrutura, registro.dthrIValEstru, registro.dthrIValCic, registro.cdProduto);
			}

			if (!isFiltroProduto) {
	   			registro.qtdPerdaRitmo = BigDecimal.ZERO;						
				registro.qtdPerdaParCP = BigDecimal.ZERO;						
				registro.qtdPerdaParSP = BigDecimal.ZERO;						
			}
			
			for (DwConsolpr cpr : listaProdutos) {
				DwRap rap = new DwRap();
				rap.setCdRap(oFolha.getCdFolha());
				rap.setDsRap(rap.getCdRap());

				DwFolharapcom ofRapCom = new DwFolharapcom();
				ofRapCom.setQtAtiva(cpr.getPcsManuProducaorefugada());
				ofRapCom.setQtTotal(cpr.getPcsManuProducaobruta());
				ofRapCom.setOmProduto(cpr.getOmProduto());

				ofRap.setDwRap(rap);
				ofRap.getDwFolharapcoms().add(ofRapCom);

				// pog
				cpr.setPcsManuProducaobruta(null);
				cpr.setPcsManuProducaorefugada(null);
				
				if (!isFiltroProduto) {
					registro.qtdPerdaRitmo = AritmeticaUtil.somar(registro.qtdPerdaRitmo, ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(cpr.getPcsAutoPerdaciclo()));
					registro.qtdPerdaParCP = AritmeticaUtil.somar(registro.qtdPerdaParCP, ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(cpr.getPcsAutoPerdaparadaCp()));
					registro.qtdPerdaParSP = AritmeticaUtil.somar(registro.qtdPerdaParSP, ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(cpr.getPcsAutoPerdaparadaSp()));
				}				
			}
			
			oFolha.getDwFolharaps().add(ofRap);
			dwci.setDwFolha(oFolha);

			// consol - tempos
			dwc.setDwConsolprs(listaProdutos);
			dwc.setSegAutoBoas(registro.segCicloNormais.subtract(registro.segRefugo));
			dwc.setSegAutoCicloprodutivo(registro.segCicloNormais);
			dwc.setSegAutoCicloimprodutivo(registro.segCicloFinParada);
			dwc.setSegAutoCiclomedio(registro.cicloMedio);
			dwc.setSegAutoCiclopadrao(registro.cicloPadrao);
			dwc.setSegAutoPerdacav(registro.segPcsCic);
			dwc.setSegAutoPerdaciclo(registro.segRitmo);
			dwc.setSegAutoTempoparadaCp(registro.segParadasCP);
			dwc.setSegAutoTempoparadaSp(registro.segParadasSP);
			dwc.setSegAutoTemporefugadas(registro.segRefugo);
			dwc.setSegAutoTempoativo(registro.segCicloNormais.add(registro.segCicloFinParada).add(registro.segParadasCP));
			dwc.setSegAutoTempoprodutivo(
					registro.segCicloNormais.subtract(registro.segRefugo).subtract(registro.segPcsCic).subtract(registro.segRitmo));
			dwc.setSegAutoTempotrabalhado(registro.segCicloNormais.add(registro.segCicloFinParada));
			dwc.setSegAutoTempocalendario(DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodo(dthrITur, dthrFTur, 0));

			if (dwc.getSegAutoTempoprodutivo().doubleValue() < 0) {
				dwc.setSegAutoTempoprodutivo(BigDecimal.ZERO);
			}
			// consol - qtdes
			dwc.setPcsAutoPerdaciclo(registro.qtdPerdaRitmo);			
			dwc.setPcsAutoPerdacavidades(registro.qtdPerdaPcsCic);
			dwc.setPcsAutoCavAtivas(registro.qtdPcsCicAtiva);
			dwc.setPcsAutoCavTotal(registro.qtdPcsCicTotal);
			dwc.setPcsAutoPerdaparadaCp(registro.qtdPerdaParCP);
			dwc.setPcsAutoPerdaparadaSp(registro.qtdPerdaParSP);
			dwc.setPcsAutoProducaobruta(registro.qtdProdBruta);
			dwc.setPcsAutoProducaoprevista(registro.qtdProdPrev);
			dwc.setPcsAutoProducaorefugada(registro.qtdProdRef);

			dwc.setQtAutoCavativas(registro.pcsCicloAtivas);
			dwc.setQtAutoCavtotal(registro.pcsCicloTotais);

			dwc.setQtAutoCicloprodutivo(registro.qtdCiclosNormais);
			dwc.setQtAutoCicloimprodutivo(registro.qtdCiclosFinParada);

			dwc.setSegAutoTempoparadamtbf(registro.segTmpParMTBF);
			dwc.setQtAutoOcoparadamtbf(registro.qtParMTBF);
			
			dwc.setSegAutoRitmo(registro.segRitmo);
			
			// dwc.setQtAutoOcoparadaCp(BigDecimal.ZERO);
			// dwc.setQtAutoOcoparadaSp(BigDecimal.ZERO);

			DwCal cal = getAgendaAtualInjet();
			dwci.setDwCal(cal);

			dwc.setDwConsolid(dwci);
			dwci.setDwConsols(new HashSet<DwConsol>());
			dwci.getDwConsols().add(dwc);

			retorno.add(dwci);
		}
		return retorno;
	}

	
	@SuppressWarnings("unchecked")
	private DwCal getAgendaAtualInjet() {
		DwCal agenda = new DwCal();
		
		String strSQL = "SELECT cdagenda, dsagenda FROM IJHORAGE WHERE dtfvagenda is null ";
		List<Object> lista = new ArrayList<Object>();
		
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		lista = q.list();

		Object[] registroLido = null;
		Object registroLidoAux = (Object) lista.get(0);
		registroLido = (Object[]) registroLidoAux;
		
		agenda.setIdCal(ConversaoTipos.converterParaBigDecimal(registroLido[0]).longValue());
		agenda.setCdCal(FuncoesApoioInjet.getStrZero(agenda.getIdCal(), 6));
		agenda.setDsCal((String) registroLido[1]);
		agenda.setRevisao(agenda.getIdCal());
		
		
		return agenda;
	}
	
	@SuppressWarnings({ "unused", "unchecked" })
	private Set<DwConsolpr> getProdutosConsolidacao(DwConsol dwc, Date dtTurno, String cdTurno, String cdInjetora, String nrOP,
			String cdMolde, String cdEstrutura, Date dthrIValEstru, Date dthrIValCic, String cdProduto) {

		String strSQL = "";

		Set<DwConsolpr> listaProdutos = new HashSet<DwConsolpr>();

		byte _cdProduto = 0;
		byte _dsProduto = 1;
		byte _prodPlan = 2;
		byte _prodBruta = 3;
		byte _prodRef = 4;
		byte _prodPrev = 5;
		byte _prodPerdaRitmo = 6;
		byte _prodPerdaPcsCiclo = 7;
		byte _prodPerdaParCP = 8;
		byte _prodPerdaParSP = 9;
		byte _qtPcsCicAtivas = 10;
		byte _qtPcsCicTotais = 11;
		byte _gPesoBruto = 12;
		byte _gPesoLiquido = 13;
		byte _valorUnitario = 14;

		class RegistroLido {
			String cdProduto;
			String dsProduto;
			BigDecimal prodPlan = BigDecimal.ZERO;
			BigDecimal prodBruta = BigDecimal.ZERO;
			BigDecimal prodRef = BigDecimal.ZERO;
			BigDecimal prodPrev = BigDecimal.ZERO;
			BigDecimal prodPerdaRitmo = BigDecimal.ZERO;
			BigDecimal prodPerdaPcsCiclo = BigDecimal.ZERO;
			BigDecimal prodPerdaParCP = BigDecimal.ZERO;
			BigDecimal prodPerdaParSP = BigDecimal.ZERO;
			BigDecimal qtPcsCicAtivas = BigDecimal.ZERO;
			BigDecimal qtPcsCicTotais = BigDecimal.ZERO;
			BigDecimal gPesoBruto = BigDecimal.ZERO;
			BigDecimal gPesoLiquido = BigDecimal.ZERO;
			BigDecimal valorUnitario = BigDecimal.ZERO;
		}

		strSQL = strSQL.concat("SELECT e.cdproduto, e.dsproduto, ");
		strSQL = strSQL.concat("       g.qtpecasproduzir as prodplan, ");
		strSQL = strSQL.concat("       ((a.qtinjnormal * d.qtcavativas) + (a.qtprodpkgcic * d.indcav)) as prodbruta, ");
		strSQL = strSQL.concat("       (CASE WHEN f.qtpcsref IS NULL THEN 0 ELSE f.qtpcsref END) as prodrefugada, ");
		strSQL = strSQL.concat(
				"       (FLOOR((a.tmpcicnormal + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END))/ h.ciclopadrao) * (CASE WHEN ct.campo23 = '¬¬ª¿±·¿½­' THEN d.qtcavidades ELSE d.qtcavativas END)  * h.fatorcontagemprod) as prodprev, ");
		strSQL = strSQL.concat(
				"       ( ((((a.tmpcicnormal + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END)) / h.ciclopadrao) - a.qtinjnormal ) * (d.qtcavativas * h.fatorcontagemprod) ) ) as prodperdaritmo,  ");
		strSQL = strSQL.concat("       (a.qtinjnormal * ( (d.qtcavidades - d.qtcavativas) * h.fatorcontagemprod) ) AS prodperdapcscic, ");
		strSQL = strSQL.concat("       (FLOOR(a.tmpparadas / h.ciclopadrao) * d.qtcavativas * h.fatorcontagemprod) as prodperdaparCP, ");
		strSQL = strSQL
				.concat("       (FLOOR(a.TmpParadasSemPeso / h.ciclopadrao) * d.qtcavativas * h.fatorcontagemprod) as prodperdaparSP, ");
		
		strSQL = strSQL.concat("       d.qtcavativas, d.qtcavidades,  d.pbrutomedio, d.pliquidomedio, e.vlproduto ");
		strSQL = strSQL.concat("  FROM ijcnsturno a ");
		strSQL = strSQL.concat("  LEFT JOIN IJtbFRESH ct ON (1=1) ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL
				.concat("  JOIN ijmolpro c ON (c.cdmolde = a.cdmolde and c.cdestrutura = a.cdestrutura and c.dthrival = a.dthrivalestru) ");
		strSQL = strSQL.concat(
				"  JOIN viewmolproindcav d ON (d.cdmolde = c.cdmolde AND d.cdestrutura = c.cdestrutura AND d.dthrival = c.dthrival AND d.cdidentificacao = c.cdidentificacao) ");
		strSQL = strSQL.concat("  JOIN ijtbpro e ON (e.cdproduto = d.cdproduto) ");
		strSQL = strSQL.concat(
				"  JOIN ijopprodutos g ON (g.nrop = a.nrop AND g.cdmolde = a.cdmolde AND g.cdestrutura = a.cdestrutura AND g.cdproduto = c.cdproduto) ");
		strSQL = strSQL.concat(
				"  JOIN ijfictec h ON (h.cdinjetora = a.cdinjetora AND h.cdmolde = a.cdmolde AND h.cdestrutura = a.cdestrutura AND h.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL.concat("  LEFT JOIN ijcnsturnodetref f ON (f.dtturno = a.dtturno AND  ");
		strSQL = strSQL.concat("                                   f.cdturno = a.cdturno AND   ");
		strSQL = strSQL.concat("                                   f.cdinjetora = a.cdinjetora AND ");
		strSQL = strSQL.concat("                                   f.nrop = a.nrop AND  ");
		strSQL = strSQL.concat("                                   f.cdmolde = a.cdmolde AND  ");
		strSQL = strSQL.concat("                                   f.cdestrutura = a.cdestrutura AND ");
		strSQL = strSQL.concat("                                   f.dthrivalestru = a.dthrivalestru AND ");
		strSQL = strSQL.concat("                                   f.dthrivalcic = a.dthrivalcic AND ");
		strSQL = strSQL.concat("                                   f.cdidentificacao = c.cdidentificacao) ");
		strSQL = strSQL.concat(" WHERE a.dtturno = :dtturno ");
		strSQL = strSQL.concat("   AND a.cdturno = :cdturno ");
		strSQL = strSQL.concat("   AND a.cdinjetora = :cdinjetora ");
		strSQL = strSQL.concat("   AND a.nrop = :nrop ");
		strSQL = strSQL.concat("   AND a.cdmolde = :cdmolde ");
		strSQL = strSQL.concat("   AND a.cdestrutura = :cdestrutura ");
		strSQL = strSQL.concat("   AND a.dthrivalestru = :dthrivalestru ");
		strSQL = strSQL.concat("   AND a.dthrivalcic = :dthrivalcic ");

		if (cdProduto != null) {
			strSQL = strSQL.concat("   AND e.cdproduto = :cdproduto ");
		}

		List<Object> lista = new ArrayList<Object>();

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

		q.setTimestamp("dtturno", dtTurno)
				.setString("cdturno", cdTurno)
				.setString("cdinjetora", cdInjetora)
				.setString("nrop", nrOP)
				.setString("cdmolde", cdMolde)
				.setString("cdestrutura", cdEstrutura)
				.setTimestamp("dthrivalestru", dthrIValEstru)
				.setTimestamp("dthrivalcic", dthrIValCic);

		if (cdProduto != null) {
			q.setString("cdproduto", cdProduto);
		}

		lista = q.list();

		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdProduto = (String) registroLido[_cdProduto];
			registro.dsProduto = (String) registroLido[_dsProduto];
			registro.prodPlan = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPlan]));
			registro.prodBruta = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodBruta]));
			registro.prodRef = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodRef]));
			registro.prodPrev = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPrev]));
			registro.prodPerdaRitmo =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPerdaRitmo]));
			registro.prodPerdaPcsCiclo =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPerdaPcsCiclo]));
			registro.prodPerdaParCP =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPerdaParCP]));
			registro.prodPerdaParSP =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPerdaParSP]));
			registro.qtPcsCicAtivas =
					ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtPcsCicAtivas]));
			registro.qtPcsCicTotais =
					ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtPcsCicTotais]));
			registro.gPesoBruto = ConversaoTipos.converterParaBigDecimal(registroLido[_gPesoBruto]);
			registro.gPesoLiquido = ConversaoTipos.converterParaBigDecimal(registroLido[_gPesoLiquido]);
			registro.valorUnitario = ConversaoTipos.converterParaBigDecimal(registroLido[_valorUnitario]);
			
			DwConsolpr cpr = new DwConsolpr();

			OmProduto pro = new OmProduto();
			pro.setCdProduto(registro.cdProduto);
			pro.setDsProduto(registro.dsProduto);
			pro.setGPesoBruto(registro.gPesoBruto);
			pro.setGPesoLiquido(registro.gPesoLiquido);
			pro.setVlCustounit(registro.valorUnitario);
			
			cpr.setIdConsolpr(null);
			cpr.setOmProduto(pro);
			cpr.setPcsAutoProducaobruta(registro.prodBruta);
			cpr.setPcsAutoProducaorefugada(registro.prodRef);
			cpr.setPcsAutoProducaoprevista(registro.prodPrev);
			cpr.setPcsAutoPerdaciclo(registro.prodPerdaRitmo);
			cpr.setPcsAutoPerdacavidades(registro.prodPerdaPcsCiclo);
			cpr.setPcsAutoPerdaparadaCp(registro.prodPerdaParCP);
			cpr.setPcsAutoPerdaparadaSp(registro.prodPerdaParSP);
			// begin pog
			cpr.setPcsManuProducaobruta(registro.qtPcsCicTotais);
			cpr.setPcsManuProducaorefugada(registro.qtPcsCicAtivas);
			// end pog
			cpr.setDwConsol(dwc);

			listaProdutos.add(cpr);
		}

		return listaProdutos;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	private Set<DwConsolpr> getProdutosConsolidacaoUT(DwConsol dwc, Date dthrIniIntervalo, String cdInjetora, String nrOP,
			String cdMolde, String cdEstrutura, Date dthrIValEstru, Date dthrIValCic, String cdProduto) {

		String strSQL = "";

		Set<DwConsolpr> listaProdutos = new HashSet<DwConsolpr>();

		byte _cdProduto = 0;
		byte _dsProduto = 1;
		byte _prodPlan = 2;
		byte _prodBruta = 3;
		byte _prodRef = 4;
		byte _prodPrev = 5;
		byte _prodPerdaRitmo = 6;
		byte _prodPerdaPcsCiclo = 7;
		byte _prodPerdaParCP = 8;
		byte _prodPerdaParSP = 9;
		byte _qtPcsCicAtivas = 10;
		byte _qtPcsCicTotais = 11;
		byte _gPesoBruto = 12;
		byte _gPesoLiquido = 13;
		byte _valorUnitario = 14;
		
		
		class RegistroLido {
			String cdProduto;
			String dsProduto;
			BigDecimal prodPlan = BigDecimal.ZERO;
			BigDecimal prodBruta = BigDecimal.ZERO;
			BigDecimal prodRef = BigDecimal.ZERO;
			BigDecimal prodPrev = BigDecimal.ZERO;
			BigDecimal prodPerdaRitmo = BigDecimal.ZERO;
			BigDecimal prodPerdaPcsCiclo = BigDecimal.ZERO;
			BigDecimal prodPerdaParCP = BigDecimal.ZERO;
			BigDecimal prodPerdaParSP = BigDecimal.ZERO;
			BigDecimal qtPcsCicAtivas = BigDecimal.ZERO;
			BigDecimal qtPcsCicTotais = BigDecimal.ZERO;
			BigDecimal gPesoBruto = BigDecimal.ZERO;
			BigDecimal gPesoLiquido = BigDecimal.ZERO;
			BigDecimal valorUnitario = BigDecimal.ZERO;
		}

		strSQL = strSQL.concat("SELECT e.cdproduto, e.dsproduto, ");
		strSQL = strSQL.concat("       g.qtpecasproduzir as prodplan, ");
		strSQL = strSQL.concat("       ((a.qtinjnormal * d.qtcavativas) + (a.qtprodpkgcic * d.indcav)) as prodbruta, ");
		strSQL = strSQL.concat("       (CASE WHEN f.qtpcsref IS NULL THEN 0 ELSE f.qtpcsref END) as prodrefugada, ");
		strSQL = strSQL.concat(
				"       (FLOOR((a.tmpcicnormal + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END))/ h.ciclopadrao) * (CASE WHEN ct.campo23 = '¬¬ª¿±·¿½­' THEN d.qtcavidades ELSE d.qtcavativas END)  * h.fatorcontagemprod) as prodprev, ");
		strSQL = strSQL.concat(
				"       ( ((((a.tmpcicnormal + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END)) / h.ciclopadrao) - a.qtinjnormal ) * (d.qtcavativas * h.fatorcontagemprod) ) ) as prodperdaritmo,  ");
		strSQL = strSQL.concat("       (a.qtinjnormal * ( (d.qtcavidades - d.qtcavativas) * h.fatorcontagemprod) ) AS prodperdapcscic, ");
		strSQL = strSQL.concat("       (FLOOR(a.tmpparadas / h.ciclopadrao) * d.qtcavativas * h.fatorcontagemprod) as prodperdaparCP, ");
		strSQL = strSQL
				.concat("       (FLOOR(a.TmpParadasSemPeso / h.ciclopadrao) * d.qtcavativas * h.fatorcontagemprod) as prodperdaparSP, ");
		strSQL = strSQL.concat("       d.qtcavativas, d.qtcavidades,  d.pbrutomedio, d.pliquidomedio, e.vlproduto ");
		strSQL = strSQL.concat("  FROM ijcnsUT a ");
		strSQL = strSQL.concat("  LEFT JOIN IJtbFRESH ct ON (1=1) ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL
				.concat("  JOIN ijmolpro c ON (c.cdmolde = a.cdmolde and c.cdestrutura = a.cdestrutura and c.dthrival = a.dthrivalestru) ");
		strSQL = strSQL.concat(
				"  JOIN viewmolproindcav d ON (d.cdmolde = c.cdmolde AND d.cdestrutura = c.cdestrutura AND d.dthrival = c.dthrival AND d.cdidentificacao = c.cdidentificacao) ");
		strSQL = strSQL.concat("  JOIN ijtbpro e ON (e.cdproduto = d.cdproduto) ");
		strSQL = strSQL.concat(
				"  JOIN ijopprodutos g ON (g.nrop = a.nrop AND g.cdmolde = a.cdmolde AND g.cdestrutura = a.cdestrutura AND g.cdproduto = c.cdproduto) ");
		strSQL = strSQL.concat(
				"  JOIN ijfictec h ON (h.cdinjetora = a.cdinjetora AND h.cdmolde = a.cdmolde AND h.cdestrutura = a.cdestrutura AND h.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL.concat("  LEFT JOIN ijcnsUTdetref f ON (f.dthriniintervalo = a.dthriniintervalo AND  ");
		strSQL = strSQL.concat("                                   f.cdinjetora = a.cdinjetora AND ");
		strSQL = strSQL.concat("                                   f.nrop = a.nrop AND  ");
		strSQL = strSQL.concat("                                   f.cdmolde = a.cdmolde AND  ");
		strSQL = strSQL.concat("                                   f.cdestrutura = a.cdestrutura AND ");
		strSQL = strSQL.concat("                                   f.dthrivalestru = a.dthrivalestru AND ");
		strSQL = strSQL.concat("                                   f.dthrivalcic = a.dthrivalcic AND ");
		strSQL = strSQL.concat("                                   f.cdidentificacao = c.cdidentificacao) ");
		strSQL = strSQL.concat(" WHERE a.dthriniintervalo = :dthrini ");
		strSQL = strSQL.concat("   AND a.cdinjetora = :cdinjetora ");
		strSQL = strSQL.concat("   AND a.nrop = :nrop ");
		strSQL = strSQL.concat("   AND a.cdmolde = :cdmolde ");
		strSQL = strSQL.concat("   AND a.cdestrutura = :cdestrutura ");
		strSQL = strSQL.concat("   AND a.dthrivalestru = :dthrivalestru ");
		strSQL = strSQL.concat("   AND a.dthrivalcic = :dthrivalcic ");

		if (cdProduto != null) {
			strSQL = strSQL.concat("   AND e.cdproduto = :cdproduto ");
		}

		List<Object> lista = new ArrayList<Object>();

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

		q.setTimestamp("dthrini", dthrIniIntervalo)
				.setString("cdinjetora", cdInjetora)
				.setString("nrop", nrOP)
				.setString("cdmolde", cdMolde)
				.setString("cdestrutura", cdEstrutura)
				.setTimestamp("dthrivalestru", dthrIValEstru)
				.setTimestamp("dthrivalcic", dthrIValCic);

		if (cdProduto != null) {
			q.setString("cdproduto", cdProduto);
		}

		lista = q.list();

		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdProduto = (String) registroLido[_cdProduto];
			registro.dsProduto = (String) registroLido[_dsProduto];
			registro.prodPlan = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPlan]));
			registro.prodBruta = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodBruta]));
			registro.prodRef = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodRef]));
			registro.prodPrev = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPrev]));
			registro.prodPerdaRitmo =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPerdaRitmo]));
			registro.prodPerdaPcsCiclo =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPerdaPcsCiclo]));
			registro.prodPerdaParCP =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPerdaParCP]));
			registro.prodPerdaParSP =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPerdaParSP]));
			registro.qtPcsCicAtivas =
					ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtPcsCicAtivas]));
			registro.qtPcsCicTotais =
					ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtPcsCicTotais]));
			registro.gPesoBruto = ConversaoTipos.converterParaBigDecimal(registroLido[_gPesoBruto]);
			registro.gPesoLiquido = ConversaoTipos.converterParaBigDecimal(registroLido[_gPesoLiquido]);
			registro.valorUnitario = ConversaoTipos.converterParaBigDecimal(registroLido[_valorUnitario]);
			
			DwConsolpr cpr = new DwConsolpr();

			OmProduto pro = new OmProduto();
			pro.setCdProduto(registro.cdProduto);
			pro.setDsProduto(registro.dsProduto);
			pro.setGPesoBruto(registro.gPesoBruto);
			pro.setGPesoLiquido(registro.gPesoLiquido);
			pro.setVlCustounit(registro.valorUnitario);
			
			cpr.setIdConsolpr(null);
			cpr.setOmProduto(pro);
			cpr.setPcsAutoProducaobruta(registro.prodBruta);
			cpr.setPcsAutoProducaorefugada(registro.prodRef);
			cpr.setPcsAutoProducaoprevista(registro.prodPrev);
			cpr.setPcsAutoPerdaciclo(registro.prodPerdaRitmo);
			cpr.setPcsAutoPerdacavidades(registro.prodPerdaPcsCiclo);
			cpr.setPcsAutoPerdaparadaCp(registro.prodPerdaParCP);
			cpr.setPcsAutoPerdaparadaSp(registro.prodPerdaParSP);
			// begin pog
			cpr.setPcsManuProducaobruta(registro.qtPcsCicTotais);
			cpr.setPcsManuProducaorefugada(registro.qtPcsCicAtivas);
			// end pog
			cpr.setDwConsol(dwc);

			listaProdutos.add(cpr);
		}

		return listaProdutos;
	}

	/**
	 * Metodo que carrega as informacoes sobre Operadores Logados, a serem exibidas na tela de Detalhe Monitorizacao do PT INJET
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	private List<OperadorDTO> getListaOperadores(List<DwConsolid> listaDwconsolid, FiltroDetalhePTInjetDTO filtro) {
		List<OperadorDTO> retornoOperadores = new ArrayList<OperadorDTO>();

		byte _dthrLogin = 0;
		byte _cdInjetora = 1;
		byte _cdUsuario = 2;
		byte _dthrLogout = 3;
		byte _cdInjEstendido = 4;
		byte _nmAcesso = 5;
		byte _nmUsuario = 6;

		class RegistroLido {
			Date dthrLogin;
			String cdInjetora;
			String cdUsuario;
			Date dthrLogout;
			String cdInjEstendido;
			String nmAcesso;
			String nmUsuario;
		}

		Map<String, RegistroLido> mapLogins = new HashMap<String, RegistroLido>();
 		
		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.dthrlogin, a.cdinjetora, a.cdusuario, a.dthrlogout, c.cdinjestendido, b.nmacesso, b.nmusuario ");
		strSQL = strSQL.concat("  FROM ijlogope a ");
		strSQL = strSQL.concat("  JOIN ijtbusu b ON (b.cdusuario = a.cdusuario) ");
		strSQL = strSQL.concat("  JOIN ijtbinj c ON (c.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat(" WHERE c.cdinjestendido = :cdinjetora");
		strSQL = strSQL.concat("");

		// Defeito #5459 >> filtro de op deve ser considerado pra manter padrao do Injet
		
		strSQL = strSQL.concat(" AND (   (a.dthrlogout IS NULL) ");
		strSQL = strSQL.concat("      OR (a.dthrlogout BETWEEN :inicio AND :fim) ");
		strSQL = strSQL.concat("      OR (a.dthrlogin  BETWEEN :inicio AND :fim) ");
		strSQL = strSQL.concat("      OR (:inicio  BETWEEN a.dthrlogin AND a.dthrlogout) ");
		strSQL = strSQL.concat("     ) ");

		for (DwConsolid dwci : listaDwconsolid) {
			SQLQuery query = this.getDaoSession().createSQLQuery(strSQL);
			query.setString("cdinjetora", dwci.getOmPt().getCdPt())
					.setTimestamp("inicio", dwci.getDthrIturno())
					.setTimestamp("fim", dwci.getDthrFturno());
			
			List<Object> lista = new ArrayList<Object>();
			lista = query.list();

			for (Object reg : lista) {
				RegistroLido registro = new RegistroLido();

				Object[] registroLido = null;
				Object registroLidoAux = (Object) reg;
				registroLido = (Object[]) registroLidoAux;

				registro.dthrLogin = (Date) registroLido[_dthrLogin];
				registro.cdInjetora = (String) registroLido[_cdInjetora];
				registro.cdUsuario = (String) registroLido[_cdUsuario];
				registro.dthrLogout = (Date) registroLido[_dthrLogout];
				registro.cdInjEstendido = (String) registroLido[_cdInjEstendido];
				registro.nmAcesso = (String) registroLido[_nmAcesso];
				registro.nmUsuario = (String) registroLido[_nmUsuario];

				OperadorDTO operadorDTO = new OperadorDTO();
				operadorDTO.setMaquina(dwci.getOmPt());
				operadorDTO.setDthrFlogin(registro.dthrLogout);
				operadorDTO.setDthrIlogin(registro.dthrLogin);

				OmUsr usr = new OmUsr();
				usr.setIdUsr(ConversaoTipos.converterParaBigDecimal(registro.cdUsuario).longValue());
				usr.setCdUsr(registro.cdUsuario);
				usr.setDsNome(registro.nmUsuario);
				usr.setDsApelido(registro.nmAcesso);

				operadorDTO.setOmUsr(usr);

				String keyLogin = registro.cdInjEstendido + " " + DataHoraRN.dateToString(registro.dthrLogin, "dd/MM/yyyy HH:mm:ss");
				if (mapLogins.containsKey(keyLogin) == false) {
					retornoOperadores.add(operadorDTO);
					mapLogins.put(keyLogin, registro);
				}
			}
		}

		// ordena a lista com base no login
		Collections.sort(retornoOperadores, new Comparator<OperadorDTO>() {
			@Override
			public int compare(final OperadorDTO o1,final OperadorDTO o2) {
				final OperadorDTO item1 = o1;
				final OperadorDTO item2 = o2;
				return (item1.getDthrIlogin()).compareTo(item2.getDthrIlogin());
			}
		});
		
		
		return retornoOperadores;
	}

	// Retorna a lista de CIPs
	@SuppressWarnings({ "unused", "unchecked" })
	private List<CIPDTO> getListaCips(List<DwConsolid> ids) {
		List<CIPDTO> retorno = new ArrayList<>();

		byte _idCIP = 0;
		byte _dthrIniCIP = 1;
		byte _dthrFimCIP = 2;
		byte _dthrIniPar = 3;
		byte _dthrFimPar = 4;
		byte _cdTecIni = 5;
		byte _nmAcessoTecIni = 6;
		byte _nmTecIni = 7;
		byte _cdTecFim = 8;
		byte _nmAcessoTecFim = 9;
		byte _nmTecFim = 10;

		class RegistroLido {
			String idCIP;
			Date dthrIniCIP;
			Date dthrFimCIP;
			Date dthrIniPar;
			Date dthrFimPar;
			String cdTecIni;
			String nmAcessoTecIni;
			String nmTecIni;
			String cdTecFim;
			String nmAcessoTecFim;
			String nmTecFim;
		}

		String strSQL = "";
		strSQL = strSQL
				.concat("SELECT a.IdCtrlInicProc, a.DtHrIniCtrlIniProc, a.DtHrFimCtrlIniProc, a.DtHrIniParSaida, a.DtHrIniParEntrada, ");
		strSQL = strSQL.concat("       a.CdTecInicio, ui.nmacesso as nmacessoI, ui.nmusuario as nmusuI,  ");
		strSQL = strSQL.concat("       a.CdTecFinal, uf.nmacesso as nmacessoF, uf.nmusuario as nmusuF ");
		strSQL = strSQL.concat("  FROM IJctrlINIPROC a ");
		strSQL = strSQL.concat("  LEFT JOIN ijtbusu ui ON (ui.cdusuario = a.CdTecInicio) ");
		strSQL = strSQL.concat("  LEFT JOIN ijtbusu uf ON (uf.cdusuario = a.CdTecFinal) ");
		strSQL = strSQL.concat(" WHERE a.nrop = :nrop ");
		strSQL = strSQL.concat("   AND a.cdinjetora = :cdinjetora ");

		for (DwConsolid dwci : listaDwconsolid) {
			SQLQuery query = this.getDaoSession().createSQLQuery(strSQL);
			query.setString("nrop", dwci.getPpCp().getCdCp())
					.setString("cdinjetora", dwci.getOmPt().getCdPt());

			List<Object> lista = new ArrayList<Object>();
			lista = query.list();

			for (Object reg : lista) {
				RegistroLido registro = new RegistroLido();

				Object[] registroLido = null;
				Object registroLidoAux = (Object) reg;
				registroLido = (Object[]) registroLidoAux;

				registro.idCIP = (String) registroLido[_idCIP];
				registro.dthrIniCIP = (Date) registroLido[_dthrIniCIP];
				registro.dthrFimCIP = (Date) registroLido[_dthrFimCIP];
				registro.dthrIniPar = (Date) registroLido[_dthrIniPar];
				registro.dthrFimPar = (Date) registroLido[_dthrFimPar];

				if (registroLido[_cdTecIni] != null) {
					registro.cdTecIni = (String) registroLido[_cdTecIni];
					registro.nmAcessoTecIni = (String) registroLido[_nmAcessoTecFim];
					registro.nmTecIni = (String) registroLido[_nmTecIni];
				}

				if (registroLido[_cdTecFim] != null) {
					registro.cdTecFim = (String) registroLido[_cdTecFim];
					registro.nmAcessoTecFim = (String) registroLido[_nmAcessoTecFim];
					registro.nmTecFim = (String) registroLido[_nmTecFim];
				}

				CIPDTO cip = new CIPDTO();

				OmUsr usrIni = new OmUsr();
				OmUsr usrFim = new OmUsr();

				if (registro.cdTecIni != null) {
					usrIni.setIdUsr(ConversaoTipos.converterParaBigDecimal(registro.cdTecIni).longValue());
					usrIni.setCdUsr(registro.cdTecIni);
					usrIni.setDsNome(registro.nmTecIni);
					usrIni.setDsApelido(registro.nmAcessoTecIni);
				}

				if (registro.cdTecFim != null) {
					usrFim.setIdUsr(ConversaoTipos.converterParaBigDecimal(registro.cdTecFim).longValue());
					usrFim.setCdUsr(registro.cdTecFim);
					usrFim.setDsNome(registro.nmTecFim);
					usrFim.setDsApelido(registro.nmAcessoTecFim);
				}

				cip.setOmpt(dwci.getOmPt());
				cip.setPpcp(dwci.getPpCp());
				cip.setInicioCIP(registro.dthrIniCIP);
				cip.setFimCIP(registro.dthrFimCIP);
				cip.setInicioParada(registro.dthrIniPar);
				cip.setFimParada(registro.dthrFimPar);
				cip.setInicioUsuario(usrIni);
				cip.setFimUsuario(usrFim);

				retorno.add(cip);
			}
		}

		return retorno;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public CiclosDTO getUltimosCiclos(FiltroCiclosDTO filtroCiclosDTO) {
		Validate.notNull(filtroCiclosDTO, "FiltroCiclosDTO deve ser preenchido");
		Validate.notNull(filtroCiclosDTO.getOmPt(), "FiltroCiclosDTO.OmPt deve ser preenchido");

		int qtRegistrosLidos = 0;
		final int TOTAL_ULTIMOS_CICLOS = ConfiguracoesInjetRN.getQtdCiclosMonitorar().intValue();
		boolean recuperarTodos;

		Date dthrUltimaValCic = null;
		
		CiclosDTO ciclosDTO = new CiclosDTO();
		ciclosDTO.setListaCicloDTO(new ArrayList<CicloDTO>());

		if (filtroCiclosDTO.getPpCp() != null && filtroCiclosDTO.getPpCp().getCdCp() != null) {
			// PpCp ppCp = getDao().findById(PpCp.class, filtroCiclosDTO.getPpCp().getCdCp(), false);
			// filtroCiclosDTO.setPpCp(ppCp);
		}

		if (filtroCiclosDTO.getRecuperarTodosOsCiclos() == null) {
			recuperarTodos = false;
		} else {
			recuperarTodos = filtroCiclosDTO.getRecuperarTodosOsCiclos();
		}
		Date dtReferencia = null;
		DwTurno dwturno = null;
		if (filtroCiclosDTO.getAnaliseTurnoDTO() != null) {
			dtReferencia = filtroCiclosDTO.getAnaliseTurnoDTO().getDtReferencia();
			dwturno = filtroCiclosDTO.getAnaliseTurnoDTO().getDwTurno();
		}

		String strSQL = "";

		List<DwRtcic> listaDwRtcic = new ArrayList<DwRtcic>();

		int _nrop = 0;
		int _dthrIniCic = _nrop + 1;
		int _dthrFimCic = _dthrIniCic + 1;
		int _segTmpCicLido = _dthrFimCic + 1;
		int _segTmpCicPadrao = _segTmpCicLido + 1;
		int _cdInjetora = _segTmpCicPadrao + 1;
		int _cdInjEstendido = _cdInjetora + 1;
		int _cdIdentific = _cdInjEstendido + 1;
		int _cdMolde = _cdIdentific + 1;
		int _cdMolEstendido = _cdMolde + 1;
		int _cdEstrutura = _cdMolEstendido + 1;
		int _qtPcsPorCicAtivas = _cdEstrutura + 1;
		int _qtPcsPorCicTotais = _qtPcsPorCicAtivas + 1;
		int _fatorContagemProd = _qtPcsPorCicTotais + 1;
		int _segCicloPadraoVarMin = _fatorContagemProd + 1;
		int _segCicloPadraoVarMax = _segCicloPadraoVarMin + 1;
		int _dthrIValCic = _segCicloPadraoVarMax + 1;
		int _dthrIValEstru = _dthrIValCic + 1;

		class RegistroLido {
			String nrop;
			Date dthrIniCic;
			Date dthrFimCic;

			BigDecimal segTmpCicLido = BigDecimal.ZERO;
			BigDecimal segTmpCicPadrao = BigDecimal.ZERO;

			String cdInjetora;
			String cdInjEstendido;
			String cdIdentific;
			String cdMolde;
			String cdMolEstendido;
			String cdEstrutura;

			BigDecimal qtPcsPorCicAtivas = BigDecimal.ZERO;
			BigDecimal qtPcsPorCicTotais = BigDecimal.ZERO;
			BigDecimal fatorContagemProd = BigDecimal.ZERO;

			BigDecimal segCicloPadraoVarMin = BigDecimal.ZERO;
			BigDecimal segCicloPadraoVarMax = BigDecimal.ZERO;

			Date dthrIValCic;
			Date dthrIValEstru;
		}

		List<PeriodoDTO> listaPeriodos = null;
		if (!recuperarTodos) {
			if (dtReferencia != null) {
				TurnoInjetRN rnT = new TurnoInjetRN(getDao());
				if (dwturno == null) {
					listaPeriodos = rnT.getIntervalosPeriodo(dtReferencia, dtReferencia, null);
				} else {
					listaPeriodos = rnT.getIntervalosPeriodo(dtReferencia, dtReferencia, dwturno.getCdTurno());
				}
			}
		}

		strSQL = strSQL.concat("SELECT a.nrop, a.DtHrICiclo, a.DtHrFCiclo, a.TmpCicloLido, a.TmpCicPadrao, ");
		strSQL = strSQL.concat("       a.cdinjetora, i.cdinjestendido, i.cdidentific, ");
		strSQL = strSQL.concat("       a.cdmolde, m.cdmolestendido, a.cdestrutura, c.qtcavativas, c.qtcavidades, b.fatorContagemProd, ");
		strSQL = strSQL.concat("       b.VarMin, b.VarMax, a.DtHrIValCic, a.DtHrIValEstru ");
		strSQL = strSQL.concat("  FROM ijreacicop a ");
		strSQL = strSQL.concat(
				"  JOIN ijfictec b ON (b.cdinjetora = a.cdinjetora AND b.cdmolde = a.cdmolde AND b.cdestrutura = a.cdestrutura AND b.DtHrIValCic = a.DtHrIValCic ) ");
		strSQL = strSQL.concat(
				"  JOIN cavidades2 c ON (c.cdmolde = b.cdmolde AND c.cdestrutura = b.cdestrutura AND c.DtHrIVal = b.DtHrIValEstru ) ");
		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol m ON (m.cdmolde = b.cdmolde) ");
		strSQL = strSQL.concat(" WHERE a.nrop = a.nrop ");
		strSQL = strSQL.concat("   AND i.cdinjestendido = :cdinjetora ");

		if (filtroCiclosDTO.getPpCp() != null && !filtroCiclosDTO.getPpCp().getCd().equals("")) {
			strSQL = strSQL.concat("   AND a.nrop = :nrop ");
		}

		if (filtroCiclosDTO.getDwFolha() != null) {
			/*
			 * strSQL = strSQL.concat("   AND a.cdmolde = :cdmolde "); strSQL = strSQL.concat("   AND a.cdestrutura = :cdestrutura ");
			 * strSQL = strSQL.concat("   AND a.dthrivalestru = :dthrivalestru "); strSQL = strSQL.concat(
			 * "   AND a.dthrivalcic = :dthrivalcic ");
			 */
			// query.append("AND dwRtcic.dwFolha.cdFolha = :cfolha");
		}

		if (listaPeriodos != null) {
			strSQL = strSQL.concat("   AND ( (a.DtHrICiclo BETWEEN :dthrIni AND :dthrFim) OR ");
			strSQL = strSQL.concat("         (a.DtHrFCiclo BETWEEN :dthrIni AND :dthrFim) OR ");
			strSQL = strSQL.concat("         (:dthrIni BETWEEN a.DtHrICiclo AND a.DtHrFCiclo) ) ");
		}

		strSQL = strSQL.concat(" ORDER BY a.DtHrIValCic DESC, a.DtHrICiclo DESC");

		List<Object> lista = new ArrayList<Object>();

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		
		q.setString("cdinjetora", filtroCiclosDTO.getOmPt().getCdPt());
		if (filtroCiclosDTO.getPpCp() != null && !filtroCiclosDTO.getPpCp().getCd().equals("")) {
			q.setString("nrop", filtroCiclosDTO.getPpCp().getCdCp());
		}

		if (listaPeriodos != null) {
			Date dthrIni = listaPeriodos.get(0).getDtHrInicio();
			Date dthrFim = listaPeriodos.get(listaPeriodos.size() - 1).getDtHrFim();
			q.setTimestamp("dthrIni", dthrIni)
					.setTimestamp("dthrFim", dthrFim);
		}

		lista = q.list();

		if (lista.size() > 0) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) lista.get(0);
			registroLido = (Object[]) registroLidoAux;
			
			dthrUltimaValCic = (Date) registroLido[_dthrIValCic];
		}
		
		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.nrop = (String) registroLido[_nrop];
			registro.dthrIniCic = (Date) registroLido[_dthrIniCic];
			registro.dthrFimCic = (Date) registroLido[_dthrFimCic];
			registro.segTmpCicLido = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpCicLido]);
			registro.segTmpCicPadrao = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpCicPadrao]);

			registro.cdInjetora = (String) registroLido[_cdInjetora];
			registro.cdInjEstendido = (String) registroLido[_cdInjEstendido];
			registro.cdIdentific = (String) registroLido[_cdIdentific];

			registro.cdMolde = (String) registroLido[_cdMolde];
			registro.cdMolEstendido = (String) registroLido[_cdMolEstendido];
			registro.cdEstrutura = (String) registroLido[_cdEstrutura];
			registro.dthrIValCic = (Date) registroLido[_dthrIValCic];
			registro.dthrIValEstru = (Date) registroLido[_dthrIValEstru];

			registro.fatorContagemProd = ConversaoTipos.converterParaBigDecimal(registroLido[_fatorContagemProd]);
			registro.qtPcsPorCicAtivas =
					ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtPcsPorCicAtivas]));
			registro.qtPcsPorCicTotais =
					ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtPcsPorCicTotais]));

			registro.segCicloPadraoVarMin = ConversaoTipos.converterParaBigDecimal(registroLido[_segCicloPadraoVarMin]);
			registro.segCicloPadraoVarMax = ConversaoTipos.converterParaBigDecimal(registroLido[_segCicloPadraoVarMax]);
			
			
			//if (registro.dthrIValCic.compareTo(dthrUltimaValCic)==0){ 
				DwRtcic regCic = new DwRtcic();
	
				DwRt dwrt = new DwRt();
				DwConsolid dwci = new DwConsolid();
				DwFolha dwFolha = new DwFolha();
				dwFolha.setSegCiclominimo(registro.segCicloPadraoVarMin);
				dwFolha.setSegCiclotimeout(registro.segCicloPadraoVarMax);
				dwFolha.setSegCiclopadrao(registro.segTmpCicPadrao);
				dwFolha.setCdFolha(registro.cdMolEstendido + "/" + registro.cdEstrutura);
				dwFolha.setDsFolha(dwFolha.getCdFolha());
				dwFolha.setDtRevisao(registro.dthrIValCic);
	
				DwFolharap frap = new DwFolharap();
				DwRap dwRap = new DwRap();
				frap.setDwRap(dwRap);
				DwFolharapcom frapc = new DwFolharapcom();
				frapc.setOmProduto(new OmProduto());
				frapc.setIdredzproduto((byte) 1);
				frapc.setQtAtiva(registro.qtPcsPorCicAtivas);
				frapc.setQtTotal(registro.qtPcsPorCicTotais);
				frap.setDwFolharapcoms(new HashSet<DwFolharapcom>());
				frap.getDwFolharapcoms().add(frapc);
				dwFolha.setDwFolharaps(new HashSet<DwFolharap>());
				dwFolha.getDwFolharaps().add(frap);
				dwFolha.setQtFatorcontagem(registro.fatorContagemProd);
	
				dwci.setDwFolha(dwFolha);
	
				dwrt.setDwConsolids(new HashSet<DwConsolid>());
				dwrt.getDwConsolids().add(dwci);
	
				regCic.setDwRt(dwrt);
				regCic.setDthrIciclo(registro.dthrIniCic);
				regCic.setMsDthriciclo((byte) 0);
				regCic.setDthrFciclo(registro.dthrFimCic);
				regCic.setMsDthrfciclo((byte) 0);
				regCic.setSegDuracao(registro.segTmpCicLido);
				regCic.setIsRegulagem(false);
				regCic.setDwFolha(dwFolha); // dwci.getDwFolha());
				regCic.setPpCp(filtroCiclosDTO.getPpCp()); // dwci.getPpCp());
	
				if (!recuperarTodos) {
					boolean isCicloValido = false;
	
					if (listaPeriodos != null && dwturno == null) {
						isCicloValido = true;
					} else {
						// verifica se ciclo estah dentro do periodo
						for (PeriodoDTO p : listaPeriodos) {
							if (DataHoraRN.existeIntersecaoDatas(p.getDtHrInicio(), p.getDtHrFim(), regCic.getDthrIciclo(),
									regCic.getDthrFciclo())) {
								isCicloValido = true;
								break;
							}
						}
					}
	
					if (isCicloValido) {
						listaDwRtcic.add(regCic);
	
						qtRegistrosLidos = qtRegistrosLidos + 1;
						if (qtRegistrosLidos == TOTAL_ULTIMOS_CICLOS) {
							break;
						}
					}
				} else {
					listaDwRtcic.add(regCic);
				}
			//} else {
				// sai porque nao eh diferente da ultima validade
			//	break;
			//}
		}

		if (listaDwRtcic.size() > 0) {
			for (DwRtcic dwRtcic : listaDwRtcic) {
				CicloDTO cicloDTO = new CicloDTO();
				cicloDTO.setDwRtcic(dwRtcic);
				ciclosDTO.getListaCicloDTO().add(cicloDTO);
			}

			// Analisa dados dos ciclos
			analisarUltimosCiclos(ciclosDTO);

			// Guarda apenas os clones de DwRtCic
			for (CicloDTO cicloDTO : ciclosDTO.getListaCicloDTO()) {
				DwRtcic dwRtcic = cicloDTO.getDwRtcic().clone(false);
				dwRtcic.setDwFolha(cicloDTO.getDwRtcic().getDwFolha().clone(false));
				cicloDTO.setDwRtcic(dwRtcic);
			}

		} else {
			// TODO milton - buscar dados da op atual
			ciclosDTO.setCavAtivas(BigDecimal.ONE);
			ciclosDTO.setCicloPadrao(BigDecimal.ZERO);
			ciclosDTO.setMetaHora(BigDecimal.ONE);
			ciclosDTO.setCapabilidadeProcessoDTO(new CapabilidadeProcessoDTO());
		}

		return ciclosDTO;
	}

	private void analisarUltimosCiclos(CiclosDTO ciclosDTO) {
		// Objeto deve estar preenchido
		if (ciclosDTO == null || ciclosDTO.getListaCicloDTO() == null || ciclosDTO.getListaCicloDTO().isEmpty()) {
			return;
		}

		// Pega do Ãºltimo ciclos os dados referentes a ciclo padrÃ£o e cavidades
		DwRtcic ultimoCiclo = ciclosDTO.getListaCicloDTO().get(0).getDwRtcic();
		DwConsolid dwConsolid = ultimoCiclo.getDwRt().getDwConsolids().iterator().next();
		DwFolha dwFolha = dwConsolid.getDwFolha();

		ciclosDTO.setCavAtivas(dwFolha.totalQtAtiva().multiply(dwFolha.getQtFatorcontagem()));
		ciclosDTO.setCicloPadrao(dwFolha.getSegCiclopadrao());
		ciclosDTO.setSegCicloMinimo(dwFolha.getSegCiclominimo());
		ciclosDTO.setPercCicloMaximo(dwFolha.getSegCiclotimeout());

		
		BigDecimal pcsCicloCalcMeta = BigDecimal.ZERO;
		for (DwFolharap frap : dwFolha.getDwFolharaps()) {
			for (DwFolharapcom frapcom : frap.getDwFolharapcoms()) {
				if (ConfiguracoesInjetRN.getIsPcsPrevistaPelasCavTotais()) {
					pcsCicloCalcMeta = AritmeticaUtil.somar(pcsCicloCalcMeta, frapcom.getQtTotal());
				} else {
					pcsCicloCalcMeta = AritmeticaUtil.somar(pcsCicloCalcMeta, frapcom.getQtAtiva());
				}
			}
		}
		
		// Guarda meta hora
		pcsCicloCalcMeta = AritmeticaUtil.multiplicar(pcsCicloCalcMeta, dwFolha.getQtFatorcontagem());
		ciclosDTO.setMetaHora(new BigDecimal(FormulasInjet.calcularMetaHora(ciclosDTO.getCicloPadrao(), pcsCicloCalcMeta)));			
		
		
		double[] ciclos = new double[ciclosDTO.getListaCicloDTO().size()];
		for (int i = 0; i < ciclosDTO.getListaCicloDTO().size(); i++) {
			CicloDTO cicloDTO = ciclosDTO.getListaCicloDTO().get(i);
			double ciclo = cicloDTO.getDwRtcic().getSegDuracao().doubleValue();

			ciclos[i] = ciclo;

			BigDecimal cicloPadrao = cicloDTO.getDwRtcic().getDwFolha().getSegCiclopadrao();
			cicloDTO.setCicloPadrao(cicloPadrao);
			cicloDTO.setCavAtivas(ciclosDTO.getCavAtivas().intValue());
			ciclosDTO.setMetaHora(ciclosDTO.getMetaHora());

			cicloDTO.setEficienciaCiclo(new BigDecimal(FormulasInjet.calcularEficienciaCiclo(cicloPadrao, new BigDecimal(ciclo))));
		}

		/*
		 * Limites superior e inferior variando em 10% sobre o ciclo. Usando desta forma atÃ© o modelo ser atualizado TODO milton - quando
		 * modelo estiver com os campos ciclomincep e ciclomaxcep, usÃ¡-lo para referencia para lse e lie
		 */
		BigDecimal lse = ciclosDTO.getPercCicloMaximo(); // contem ciclo max em segundos (ijfictec)
		BigDecimal lie = ciclosDTO.getSegCicloMinimo(); // contem ciclo min em segundos (ijfictec)

		if (lse.compareTo(ciclosDTO.getCicloPadrao()) < 0)
			lse = ciclosDTO.getCicloPadrao();

		BigDecimal k = new BigDecimal(getNumeroDeIntervalo(ciclosDTO.getListaCicloDTO().size()));

		// Guarda dados sobre a capabilidade do processo

		CapabilidadeProcessoDTO capabilidadeProcessoDTO = FormulasInjet.calcularCapabilidadeProcesso(lse, lie, ciclos, k);
		if (capabilidadeProcessoDTO == null) {
			capabilidadeProcessoDTO = new CapabilidadeProcessoDTO();
			capabilidadeProcessoDTO.setLie(lie.doubleValue());
			capabilidadeProcessoDTO.setLse(lse.doubleValue());

		}
		ciclosDTO.setCapabilidadeProcessoDTO(capabilidadeProcessoDTO);
		calcularIntervaloFrequenciaCiclo(ciclosDTO, k.longValue());
	}

	private long getNumeroDeIntervalo(long numeroCiclos) {
		if (numeroCiclos < 50) {
			return 6;
		}

		if (numeroCiclos >= 50 && numeroCiclos <= 100) {
			return 8;
		}

		if (numeroCiclos > 100 && numeroCiclos <= 250) {
			return 10;
		}

		if (numeroCiclos > 250) {
			return 15;
		}

		return 0;
	}

	private void calcularIntervaloFrequenciaCiclo(CiclosDTO ciclosDTO, long k) {

		double cicloMenorDuracao = ciclosDTO.getListaCicloDTO().get(0).getDwRtcic().getSegDuracao().doubleValue();
		double cicloMaiorDuracao = ciclosDTO.getListaCicloDTO().get(0).getDwRtcic().getSegDuracao().doubleValue();

		// captura a maior e a menor duracao de ciclo
		for (CicloDTO ciclo : ciclosDTO.getListaCicloDTO()) {
			double duracaoCiclo = ciclo.getDwRtcic().getSegDuracao().doubleValue();

			if (duracaoCiclo < cicloMenorDuracao) {
				cicloMenorDuracao = duracaoCiclo;
			}

			if (duracaoCiclo > cicloMaiorDuracao) {
				cicloMaiorDuracao = duracaoCiclo;
			}
		}

		double amplitudeTotal = cicloMaiorDuracao - cicloMenorDuracao;

		double amplitudeClasse = amplitudeTotal / k;

		List<IntervaloDTO> listaIntervaloDTO = new ArrayList<>();
		double lseAnterior = 0;
		for (int i = 1; i <= k; i++) {
			double lie;
			double lse;
			if (i == 1) {
				lie = cicloMenorDuracao - (amplitudeClasse / 2);
			} else {
				lie = lseAnterior;
			}
			lse = lie + amplitudeClasse;
			double pontoMedio = (lie + lse) / 2;

			long frequencia = 0;
			for (CicloDTO ciclo : ciclosDTO.getListaCicloDTO()) {
				double duracaoCiclo = ciclo.getDwRtcic().getSegDuracao().doubleValue();
				if (duracaoCiclo >= lie && duracaoCiclo <= lse) {
					frequencia++;
				}
			}
			lseAnterior = lse;

			IntervaloDTO intervalo = new IntervaloDTO();
			intervalo.setNumero(i);
			intervalo.setLie(lie);
			intervalo.setLse(lse);
			intervalo.setPontoMedio(pontoMedio);
			intervalo.setFrequencia(frequencia);
			intervalo.setAmplitude(amplitudeTotal);
			intervalo.setAmplitudeClasse(amplitudeClasse);
			listaIntervaloDTO.add(intervalo);
		}

		ciclosDTO.setK(new BigDecimal(k));
		ciclosDTO.getCapabilidadeProcessoDTO().setMaximo(cicloMaiorDuracao);
		ciclosDTO.getCapabilidadeProcessoDTO().setMinimo(cicloMenorDuracao);
		ciclosDTO.setListaIntervaloDTO(listaIntervaloDTO);
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public DwFolhasDTO getDwFolhasPorCodInjet(String cdFolha, String cdPt) {
		DwFolhasDTO folhas = new DwFolhasDTO();
		folhas.setListaDwFolhaDTO(new ArrayList<DwFolhaDTO>());

		int posicaoBarra = cdFolha.indexOf("/");
		String cdMolEstendido = cdFolha.substring(0, posicaoBarra);
		String cdEstrutura = cdFolha.substring(posicaoBarra + 1);

		String strSQL = "";

		int _cdInjetora = 0;
		int _cdInjEstendido = _cdInjetora + 1;
		int _cdIdentific = _cdInjEstendido + 1;
		int _cdMolde = _cdIdentific + 1;
		int _cdMolEstendido = _cdMolde + 1;
		int _cdEstrutura = _cdMolEstendido + 1;
		int _dthrIValCic = _cdEstrutura + 1;
		int _segCicloPadrao = _dthrIValCic + 1;
		int _segCicloPadraoVarMin = _segCicloPadrao + 1;
		int _segCicloPadraoVarMax = _segCicloPadraoVarMin + 1;
		int _cdUsuario = _segCicloPadraoVarMax + 1;
		int _nmAcesso = _cdUsuario + 1;
		int _nmUsuario = _nmAcesso + 1;

		class RegistroLido {
			String cdInjetora;
			String cdInjEstendido;
			String cdIdentific;
			String cdMolde;
			String cdMolEstendido;
			String cdEstrutura;

			Date dthrIValCic;

			BigDecimal segCicloPadrao = BigDecimal.ZERO;
			BigDecimal segCicloPadraoVarMin = BigDecimal.ZERO;
			BigDecimal segCicloPadraoVarMax = BigDecimal.ZERO;

			String cdUsuario;
			String nmAcesso;
			String nmUsuario;
		}

		strSQL = strSQL.concat("SELECT a.cdinjetora, i.cdinjestendido, i.cdidentific,  ");
		strSQL = strSQL.concat("       a.cdmolde, m.cdmolestendido, a.cdestrutura, ");
		strSQL = strSQL.concat("       a.dthrivalcic, a.ciclopadrao, a.VarMin, a.VarMax, ");
		strSQL = strSQL.concat("       a.CdUsuResp, u.nmacesso, u.nmusuario ");
		strSQL = strSQL.concat("  FROM ijfictec a ");

		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol m ON (m.cdmolde = a.cdmolde) ");

		strSQL = strSQL.concat("  LEFT OUTER JOIN IJengLOGCICLOS b ON (a.cdinjetora  = b.cdinjetora  AND ");
		strSQL = strSQL.concat("                                       a.cdmolde     = b.cdmolde     AND ");
		strSQL = strSQL.concat("                                       a.cdestrutura = b.cdestrutura AND ");
		strSQL = strSQL.concat("                                       a.dthrivalcic = b.dthralteracao) ");
		
		strSQL = strSQL.concat("  LEFT JOIN ijtbusu u ON (u.cdusuario = b.cdusuario) ");
		
		
		strSQL = strSQL.concat(" WHERE i.cdinjestendido = :cdinjetora ");
		strSQL = strSQL.concat("   AND m.cdmolestendido = :cdmolde ");
		strSQL = strSQL.concat("   AND a.cdestrutura = :cdestrutura ");
		
		strSQL = strSQL.concat("   AND a.dthrivalcic <= (SELECT a.dthrivalcic ");
		strSQL = strSQL.concat("                           FROM ijFicTec a ");
		strSQL = strSQL.concat("                           JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("                           JOIN ijtbmol m ON (m.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("                          WHERE i.cdinjestendido = :cdinjetora ");
		strSQL = strSQL.concat("                            AND m.cdmolestendido = :cdmolde ");
		strSQL = strSQL.concat("                            AND a.cdestrutura = :cdestrutura");
		strSQL = strSQL.concat("                            AND a.dthrfvalcic IS NULL) ");
				   
		strSQL = strSQL.concat(" ORDER BY a.dthrivalcic DESC ");

		
		
		List<Object> lista = new ArrayList<Object>();

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

		q.setString("cdinjetora", cdPt)
				.setString("cdmolde", cdMolEstendido)
				.setString("cdestrutura", cdEstrutura);

		lista = q.list();

		Long revisao = (long) lista.size();
		
		for (Object reg : lista) {
			revisao = revisao - 1;
			
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdInjetora = (String) registroLido[_cdInjetora];
			registro.cdInjEstendido = (String) registroLido[_cdInjEstendido];
			registro.cdIdentific = (String) registroLido[_cdIdentific];
			registro.cdMolde = (String) registroLido[_cdMolde];
			registro.cdMolEstendido = (String) registroLido[_cdMolEstendido];
			registro.cdEstrutura = (String) registroLido[_cdEstrutura];

			registro.segCicloPadrao = ConversaoTipos.converterParaBigDecimal(registroLido[_segCicloPadrao]);
			registro.segCicloPadraoVarMin = ConversaoTipos.converterParaBigDecimal(registroLido[_segCicloPadraoVarMin]);
			registro.segCicloPadraoVarMax = ConversaoTipos.converterParaBigDecimal(registroLido[_segCicloPadraoVarMax]);

			registro.dthrIValCic = (Date) registroLido[_dthrIValCic];

			registro.cdUsuario = (registroLido[_cdUsuario] == null ? "-" : (String) registroLido[_cdUsuario]);
			registro.nmAcesso = (registroLido[_nmAcesso] == null ? "-" : (String) registroLido[_nmAcesso]);
			registro.nmUsuario = (registroLido[_nmUsuario] == null ? "-" : (String) registroLido[_nmUsuario]);

			DwFolhaDTO folha = new DwFolhaDTO();
			DwFolha dwFolha = new DwFolha();
			dwFolha.setSegCiclominimo(registro.segCicloPadraoVarMin);
			dwFolha.setSegCiclotimeout(registro.segCicloPadraoVarMax);
			dwFolha.setSegCiclopadrao(registro.segCicloPadrao);
			dwFolha.setCdFolha(registro.cdMolEstendido + "/" + registro.cdEstrutura);
			dwFolha.setDsFolha(dwFolha.getCdFolha());
			dwFolha.setDtRevisao(registro.dthrIValCic);
			dwFolha.setRevisao(revisao);
			OmUsr usr = new OmUsr();

			usr.setCdUsr(registro.cdUsuario);
			usr.setDsNome(registro.nmUsuario);
			usr.setDsApelido(registro.nmAcesso);

			dwFolha.setOmUsrByIdUsrrevisao(usr);

			DwFolharap frap = new DwFolharap();
			DwRap dwRap = new DwRap();
			frap.setDwRap(dwRap);
			DwFolharapcom frapc = new DwFolharapcom();
			frapc.setOmProduto(new OmProduto());
			frapc.setIdredzproduto((byte) 1);
			frap.setDwFolharapcoms(new HashSet<DwFolharapcom>());
			frap.getDwFolharapcoms().add(frapc);
			dwFolha.setDwFolharaps(new HashSet<DwFolharap>());
			dwFolha.getDwFolharaps().add(frap);

			folha.setDwFolha(dwFolha);

			folhas.getListaDwFolhaDTO().add(folha);
		}

		return folhas;
	}

	@SuppressWarnings("unchecked")
	public DwFolhasDTO getFolhasDoPt(String cdpt) throws RegistroDesconhecidoException {
		DwFolhasDTO retorno = new DwFolhasDTO();
		retorno.setListaDwFolhaDTO(new ArrayList<DwFolhaDTO>());

		int _cdMolEstendido = 0;
		int _cdEstrutura = 1;

		class RegistroLido {
			String cdMolEstendido;
			String cdEstrutura;
		}

		String strSQL = "";
		strSQL = strSQL.concat("SELECT DISTINCT m.cdmolestendido, a.cdestrutura ");
		strSQL = strSQL.concat("  FROM ijfictec a ");
		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol m ON (m.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat(" WHERE i.cdinjestendido = :cdpt ");
		strSQL = strSQL.concat(" ORDER BY m.cdmolestendido, a.cdestrutura");

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q.setString("cdpt", cdpt);

		List<Object> lista = new ArrayList<Object>();
		lista = q.list();

		if (q.list().size() == 0) {
			throw new RegistroDesconhecidoException();
		}

		long idFolha = 0;
		for (Object reg : lista) {
			idFolha = idFolha + 1;
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdMolEstendido = (String) registroLido[_cdMolEstendido];
			registro.cdEstrutura = (String) registroLido[_cdEstrutura];

			DwFolhaDTO folha = new DwFolhaDTO();
			DwFolha dwFolha = new DwFolha();
			dwFolha.setIdFolha(idFolha);
			dwFolha.setCdFolha(registro.cdMolEstendido + "/" + registro.cdEstrutura);
			folha.setDwFolha(dwFolha);

			retorno.getListaDwFolhaDTO().add(folha);
		}

		return retorno;
	}

	/**
	 * Pega os detalhes da produÃ§Ã£o, parada e refugos
	 * 
	 * @param filtro
	 *            <p>
	 *            filtro.getOmPt: filtra por um posto de trabalho
	 *            <p>
	 *            filtro.getDtReferencia: filtra pela data de referencia do turno
	 *            <p>
	 *            filtro.getDtReferenciaInicial e filtro.getDtReferenciaInicial: filtra pelo intervalo da data de referencia
	 *            <p>
	 *            filtro.getDwTurno: filtra para o turno
	 * @return
	 */
	public DetalhamentoProducaoDTO getDetalhamentoProducao(FiltroDetalheProducaoDTO filtro) {
		DetalhamentoProducaoDTO retorno = new DetalhamentoProducaoDTO();
		try {

			byte tpId = (filtro.getTpId() == null ? DwConsolidTemplate.TpId.TURNO.getValue() : filtro.getTpId());

			Date dthrIturno = null;
			Date dthrFturno = null;
			Date dthrIhora = null;
			Date dthrFHora = null;

			if (DwConsolidTemplate.TpId.HORA.getValue().equals(tpId)) {
				dthrIhora = filtro.getDthrinicio();
				dthrFHora = filtro.getDthrfim();

				// Pesquisa pelo intervalo do turno
			} else if (DwConsolidTemplate.TpId.TURNO.getValue().equals(tpId)) {
				dthrIturno = filtro.getDthrinicio();
				dthrFturno = filtro.getDthrfim();
			}

			DetalheMonitorizacaoGraficoAreaResponsavelnjetRN rnAR = new DetalheMonitorizacaoGraficoAreaResponsavelnjetRN(getDao());

			List<DwConsolid> listadwconsolid = null;
			if (filtro.getIddwConsolid() != 0) {
				// Marcos Sardinha 2017-07-04: Defeito #4061
				listadwconsolid = getDwConsolid(null, filtro.getIddwConsolid(), true, false, true, false, false, false);

			} else {
				listadwconsolid =
						rnAR.getDwConsolid(null, tpId, filtro.getOmpt(), filtro.getPpCp(), filtro.getDwTurno(), null, null, null, null,
								null, dthrIturno, dthrFturno, dthrIhora, dthrFHora, true, false, true, 0, null, false, false);
			}

			if (listadwconsolid != null) {
				preencherValoresDetalheProducao(retorno, listadwconsolid, filtro);
			} else {
				preenchervaloresdefaultdetalheproducao(retorno);
			}

		} catch (Exception e) {
			e.printStackTrace();
			retorno.setListaparadas(null);
			retorno.setListaproducao(null);
			retorno.setListarefugos(null);
			return retorno;
		}
		return retorno;
	}

	private void preenchervaloresdefaultdetalheproducao(DetalhamentoProducaoDTO retorno) {
		retorno.setListaparadas(new ArrayList<DetalheParadaDTO>());
		retorno.setListaproducao(new ArrayList<DetalheProducaoDTO>());
		retorno.setListarefugos(new ArrayList<DetalheRefugoDTO>());
		retorno.setTempodisponivel(0d);
		retorno.setHorastrabalhadas(0d);
		retorno.setHorasparadas(0d);
		retorno.setIndiceparadas(0d);
		retorno.setCicmedio(0d);
		retorno.setPerdascic(0d);
		retorno.setPerdasparadas(0d);
		retorno.setPerdasrefugos(0d);
		retorno.setTotalperdas(0d);
	}

	private void preencherValoresDetalheProducao(DetalhamentoProducaoDTO retorno, List<DwConsolid> listaDwConsolid,
			FiltroDetalheProducaoDTO filtro) {
		prepararRefugoDTO(retorno, listaDwConsolid);
		prepararProducaoDTO(retorno, listaDwConsolid, filtro);
		retorno.setListaparadas(prepararListaParadaDTO(filtro.getOmpt(), listaDwConsolid));
		pegarcamposdetalheproducaoDTO(retorno, listaDwConsolid, filtro);
	}

	private void prepararRefugoDTO(DetalhamentoProducaoDTO retorno, List<DwConsolid> listaDwConsolid) {
		GraficoRecorrenciaRefugoInjetRN grRefRN = new GraficoRecorrenciaRefugoInjetRN(getDao());

		retorno.setListarefugos(new ArrayList<DetalheRefugoDTO>());
		for (DwConsolid dwconsolid : listaDwConsolid) {

			if (dwconsolid.getDwConsols() != null) {
				for (DwConsol dwconsol : dwconsolid.getDwConsols()) {

					dwconsol.setDwConsolres(new HashSet<DwConsolre>());
					dwconsol.getDwConsolres().addAll(grRefRN.getDwconsolRes(dwconsolid, null));

					if (dwconsol.getDwConsolres() != null) {
						for (DwConsolre dwconsolre : dwconsol.getDwConsolres()) {
							if (dwconsolre.getDwConsolreocos() != null) {
								for (DwConsolreoco dwconsolreoco : dwconsolre.getDwConsolreocos()) {
									if (dwconsolreoco.getDwConsolrelog() != null
											&& (dwconsolreoco.getDwConsolrelog().getIsCancelado() == null
													|| dwconsolreoco.getDwConsolrelog().getIsCancelado() == false)) {
										DwConsolrelog dwconsolrelog = dwconsolreoco.getDwConsolrelog();

										DetalheRefugoDTO refugoDTO = new DetalheRefugoDTO();
										refugoDTO.setMaquina(dwconsolrelog.getOmPt() != null
												? dwconsolrelog.getOmPt().getCdPt() + " - " + dwconsolrelog.getOmPt().getDsCurta() : "");
										refugoDTO.setDsPt(dwconsolrelog.getOmPt().getDsPt());
										refugoDTO.setFerramenta(getMolde(dwconsolid));

										// Alex 03/05/2017: Fiz as alteracoes abaixo para evitar o null como no seguinte exemplo:
										// produto = "Prod03 - null"
										String produto = "";
										if (dwconsolrelog.getOmProduto() != null) {
											produto += dwconsolrelog.getOmProduto().getCdProduto();

											if (dwconsolrelog.getOmProduto().getDsCurta() != null) {
												produto += " - " + dwconsolrelog.getOmProduto().getDsCurta();
											}
										}
										refugoDTO.setProduto(produto);
										// ------

										refugoDTO.setRefugo(dwconsolre.getDwTRefugo() != null ? dwconsolre.getDwTRefugo().getCdTrefugo()
												+ " - " + dwconsolre.getDwTRefugo().getDsTrefugo() : "");
										Double qtde = dwconsolrelog.getPcsAutoProducaorefugada() != null ? dwconsolrelog
												.getPcsAutoProducaorefugada().doubleValue() : 0d;
										qtde += dwconsolrelog.getPcsManuProducaorefugada() != null ? dwconsolrelog
												.getPcsManuProducaorefugada().doubleValue() : 0d;
										refugoDTO.setQtde_refugo(qtde);
										Date dtOcorrencia = dwconsolrelog.getDthrRefugo();
										DataHoraRN.adicionaSegundosNaData(dtOcorrencia,
												dwconsolrelog.getMsDthrrefugo() != null ? dwconsolrelog.getMsDthrrefugo().intValue() : 0);
										refugoDTO.setDthrocorrencia(dtOcorrencia);

										if (dwconsolrelog.getDwTCausa().getCdTcausa() != null) {
											refugoDTO.setCausa(dwconsolrelog.getDwTCausa().getCdTcausa()
													+ " - " + dwconsolrelog.getDwTCausa().getDsTcausa());
										}

										if (dwconsolrelog.getDwTAcao().getCdTacao() != null) {
											refugoDTO.setAcao(dwconsolrelog.getDwTAcao().getCdTacao()
													+ " - " + dwconsolrelog.getDwTAcao().getDsTacao());
										}

										retorno.getListarefugos().add(refugoDTO);
									}
								}
							}
						}
					}
				}
			}

		}
	}

	/**
	 * Recupera detalhes de produÃ§Ã£o
	 * 
	 * @param retorno
	 * @param listaDwConsolid
	 * @param filtro
	 */
	private void prepararProducaoDTO(DetalhamentoProducaoDTO retorno, List<DwConsolid> listaDwConsolid, FiltroDetalheProducaoDTO filtro) {
		retorno.setListaproducao(new ArrayList<DetalheProducaoDTO>());
		for (DwConsolid dwconsolid : listaDwConsolid) {
			for (DwConsol dwc : dwconsolid.getDwConsols()) {
				for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {
					DetalheProducaoDTO producaoDTO = new DetalheProducaoDTO();
					producaoDTO = new DetalheProducaoDTO();

					if (dwconsolid.getOmPt().getDsCurta() != null) {
						producaoDTO.setMaquina(dwconsolid.getOmPt().getCdPt() + " - " + dwconsolid.getOmPt().getDsCurta());
					} else {
						producaoDTO.setMaquina(dwconsolid.getOmPt().getCdPt());
					}

					producaoDTO.setDsPt(dwconsolid.getOmPt().getDsPt());

					producaoDTO.setFerramenta(getMolde(dwconsolid));
					producaoDTO.setProduto(dwcpr.getOmProduto().getCdProduto());

					BigDecimal prodref = dwcpr.getPcsProducaoRefugada();
					BigDecimal prodbruta = dwcpr.getPcsProducaoBruta();
					

					BigDecimal segCicloPadrao = dwconsolid.getDwFolha().getSegCiclopadrao();
					
					//BigDecimal qtPcsCiclo = dwconsolid.getDwConsol().getQtAutoCavativas();
					//BigDecimal qtPcsCicloTotal = dwconsolid.getDwConsol().getQtAutoCavtotal();
					
					BigDecimal qtPcsCiclo = getPcsPorCicloAtivas(dwconsolid.getDwFolha(), dwcpr.getOmProduto());
					BigDecimal qtPcsCicloTotal = getPcsPorCicloTotais(dwconsolid.getDwFolha(), dwcpr.getOmProduto());
										
					
					BigDecimal fatorContagem = dwconsolid.getDwFolha().getQtFatorcontagem();

					BigDecimal tempoCiclosProdutivos = AritmeticaUtil.somar(
							dwc.getSegAutoCicloprodutivo() != null ? dwc.getSegAutoCicloprodutivo() : BigDecimal.ZERO,
							dwc.getSegManuCicloprodutivo() != null ? dwc.getSegManuCicloprodutivo() : BigDecimal.ZERO);

					BigDecimal qtCiclosProdutivos = AritmeticaUtil.somar(
							dwc.getQtAutoCicloprodutivo() != null ? dwc.getQtAutoCicloprodutivo() : BigDecimal.ZERO,
							dwc.getQtManuCicloprodutivo() != null ? dwc.getQtManuCicloprodutivo() : BigDecimal.ZERO);

					BigDecimal segRitmo = FormulasInjet.calcularRitmo(tempoCiclosProdutivos, qtCiclosProdutivos, segCicloPadrao,
							dwc.getSegAutoTempoparadaCpVr(), dwc.getSegAutoTempoparadaSpVr());
					BigDecimal segCicloMedio = FormulasInjet.calcularCicloMedio(tempoCiclosProdutivos, qtCiclosProdutivos);
					
					
					BigDecimal qtMetaInstantanea = FormulasInjet.calcularProducaoPrevista(
							dwc.getSegAutoTempoativo(),
							segCicloPadrao,
							qtPcsCiclo,
							fatorContagem,
							dwc.getDwConsolid().getOmPt().getIndOee());

					if (IdwFacade.IS_IDW_ATIVO == false) {
						qtMetaInstantanea = FormulasInjet.calcularProducaoPrevista(
								dwc.getSegAutoTempoativo(),
								segCicloPadrao,
								qtPcsCicloTotal,
								fatorContagem,
								dwc.getDwConsolid().getOmPt().getIndOee());
					}
					
					
					BigDecimal qtPerdasCiclo = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(FormulasInjet.calcularPcsPerdaciclo(segRitmo, segCicloPadrao, qtPcsCiclo));

					producaoDTO.setProd_prevista(ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(qtMetaInstantanea.doubleValue())).doubleValue());
					producaoDTO.setProd_realizada(prodbruta.doubleValue());
					producaoDTO.setProd_refugadas(prodref.doubleValue());
					producaoDTO.setProd_boas(producaoDTO.getProd_realizada() - producaoDTO.getProd_refugadas());
					producaoDTO.setPerdas_ciclo(qtPerdasCiclo.doubleValue());

					producaoDTO.setEficiencia_realizacao(FormulasInjet.calcularEficienciaRealizacao(producaoDTO.getProd_boas(),
							producaoDTO.getProd_prevista()));

					producaoDTO.setEficiencia_ciclo(FormulasInjet.calcularEficienciaCiclo(segCicloPadrao, segCicloMedio));

					producaoDTO.setCicloPadrao(segCicloPadrao.doubleValue());
					producaoDTO.setProducaoPorCiclo(qtPcsCiclo.doubleValue());

					// producaoDTO.setIdFolha(dwconsolid.getDwFolha().getIdFolha());
					producaoDTO.setDtRevisao(dwconsolid.getDwFolha().getDtRevisao());

					retorno.getListaproducao().add(producaoDTO);
				}
			}

		}
		
		//ordemar refugos da lista pela data da ocorrencia
		Collections.sort(retorno.getListarefugos(), new Comparator<DetalheRefugoDTO>() {
			@Override
			public int compare(final DetalheRefugoDTO o1,final DetalheRefugoDTO o2) {
				final DetalheRefugoDTO item1 = o1;
				final DetalheRefugoDTO item2 = o2;
				return (item1.getDthrocorrencia()).compareTo(item2.getDthrocorrencia());
			}
		});

	}

	/**
	 * Prepara lista com o detalhes das paradas que ocorreram dentro do perÃ­odo de {@code DwConsolid}
	 * 
	 * @param listaDwConsolid
	 * @return
	 */
	private List<DetalheParadaDTO> prepararListaParadaDTO(OmPt ompt, List<DwConsolid> listaDwConsolid) {

		// Marcos Sardinha: 2017-07-05 >> Defeito #4136
		Map<Long, OmPt> mapPts = new HashMap<Long, OmPt>();
		List<DetalheParadaDTO> retorno = new ArrayList<DetalheParadaDTO>();

		if (ompt == null) {
			for (DwConsolid dwci : listaDwConsolid) {
				OmPt ptLista = dwci.getOmPt().clone();
				if (mapPts.containsKey(ptLista.getIdPt()) == false) {
					mapPts.put(ptLista.getIdPt(), ptLista);
				}
			}

		} else {
			mapPts.put(ompt.getIdPt(), ompt);
		}

		Set<Long> idPts = mapPts.keySet();

		for (Long idPt : idPts) {
			ompt = mapPts.get(idPt);

			Set<DwConsolpalog> pas = new HashSet<DwConsolpalog>();
			if (listaDwConsolid != null) {
				for (DwConsolid dwconsolid : listaDwConsolid) {

					BigDecimal segCicloPadrao = dwconsolid.getDwFolha().getSegCiclopadrao();
					BigDecimal qtPcsCiclo = dwconsolid.getDwConsol().getQtAutoCavativas();
					BigDecimal fatorContagemProd = dwconsolid.getDwFolha().getQtFatorcontagem();

					if (dwconsolid.getDwConsols() != null) {

						for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
							if (dwconsol.getDwConsolpas() != null) {
								for (DwConsolpa dwconsolpa : dwconsol.getDwConsolpas()) {
									gerarParadaDTO(dwconsolid, dwconsolpa, segCicloPadrao, qtPcsCiclo, fatorContagemProd, pas, retorno);
								}
							}
						}
					}
				}
			}
			pas.clear();
		}
		
		//ordemar paradas da lista pela data da ocorrencia
		Collections.sort(retorno, new Comparator<DetalheParadaDTO>() {
			@Override
			public int compare(final DetalheParadaDTO o1,final DetalheParadaDTO o2) {
				final DetalheParadaDTO item1 = o1;
				final DetalheParadaDTO item2 = o2;
				return (item1.getInicio()).compareTo(item2.getInicio());
			}
		});
				
		return retorno;
	}

	private void pegarcamposdetalheproducaoDTO(DetalhamentoProducaoDTO retorno, List<DwConsolid> listaDwConsolid,
			FiltroDetalheProducaoDTO filtro) {

		retorno.setDthrinicio(filtro.getDthrinicio());
		retorno.setDthrfim(DataHoraRN.somaSegundos(filtro.getDthrfim(),1));
		retorno.setDuracaointervalo(DataHoraRN.getIntervaloFormatoHHMMSS(filtro.getDthrinicio(), DataHoraRN.somaSegundos(filtro.getDthrfim(),1)));

		retorno.setHorastrabalhadas(getTempoTrabalhadas(listaDwConsolid));

		retorno.setIndiceparadas(getIndiceParadas(listaDwConsolid, filtro));
		retorno.setCicpadraomedio(getCicPadraoMed(listaDwConsolid));
		retorno.setCicmedio(getCicMedio(listaDwConsolid));
		retorno.setPerdascic(getPerdasCiclos(listaDwConsolid));

		/*
		 * Marcos Sardinha: 2017-07-06 >> qdo tem parada aberta esta somando perdas e paradas duas vezes. Não sei se em algum momento
		 * funciona diferente. Pro detalhe da hora dos graficos nao funciona.
		 * 
		 * retorno.setTempodisponivel(getTempoDisponiveis(listaDwConsolid)); << nao ta somando parada com peso aberta no tempo disponivel
		 * retorno.setHorasparadas(getTempoParadas(listaDwConsolid, filtro)); retorno.setPerdasparadas(getPerdasParadas(listaDwConsolid,
		 * filtro));
		 * 
		 */

		retorno.setTempodisponivel(retorno.getHorastrabalhadas() + segTempoParadasComPesoBaseadoEmDetalheParadaDTO(retorno));
		
		if (IdwFacade.IS_IDW_ATIVO) {
			retorno.setHorasparadas(segTempoParadasBaseadoEmDetalheParadaDTO(retorno));
			retorno.setPerdasparadas(qtdPerdasParadasBaseadaEmDetalheParadaDTO(retorno));
		} else {
			retorno.setHorasparadas(segTempoParadasComPesoBaseadoEmDetalheParadaDTO(retorno));
			retorno.setPerdasparadas(ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(new BigDecimal(qtdPerdasParadasComPesoBaseadaEmDetalheParadaDTO(retorno))).doubleValue());			
		}
		retorno.setPerdasrefugos(getPerdasRefugo(listaDwConsolid));
		retorno.setUltimocicpadrao(getUltimoCicPadrao(listaDwConsolid));
		retorno.setTotalperdas(retorno.getPerdasparadas() + retorno.getPerdasrefugos() + retorno.getPerdascic());
	}

	/**
	 * 
	 * @param listadwconsolid
	 * @return
	 */
	private Double getTempoTrabalhadas(List<DwConsolid> listadwconsolid) {
		Double tempotrabalhado = 0d;

		for (DwConsolid dwconsolid : listadwconsolid) {
			if (dwconsolid.getDwConsols() != null) {
				for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
					tempotrabalhado += dwconsol.getSegAutoTempotrabalhado() != null ? dwconsol.getSegAutoTempotrabalhado().doubleValue()
							: 0d;
					tempotrabalhado += dwconsol.getSegManuTempotrabalhado() != null ? dwconsol.getSegManuTempotrabalhado().doubleValue()
							: 0d;
				}
			}
		}

		return tempotrabalhado.doubleValue();
	}

	private Double getIndiceParadas(List<DwConsolid> listadwconsolid, FiltroDetalheProducaoDTO filtro) {
		Double tempoparadacp = 0d;
		Double tempoativo = 0d;

		Double tempoParada = 0d;

		/*
		 * Aqui devemos obter qual a parada em aberto para o periodo analisado
		 */

		for (DwConsolid dwconsolid : listadwconsolid) {
			if (dwconsolid.getDwConsols() != null) {
				for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
					BigDecimal tempoParadaCP = dwconsol.getSegAutoTempoparadaCp();
					if (tempoParadaCP == null) {
						tempoParadaCP = BigDecimal.ZERO;
					}
					BigDecimal tempoAtivo = dwconsol.getSegAutoTempoativo();
					if (tempoAtivo == null) {
						tempoAtivo = BigDecimal.ZERO;
					}

					tempoparadacp += tempoParadaCP.doubleValue();
					tempoativo += tempoAtivo.doubleValue();
				}
			}
		}
		tempoparadacp += tempoParada;
		tempoativo += tempoParada;

		return FormulasInjet.calcularIndiceParada(BigDecimal.valueOf(tempoparadacp), BigDecimal.valueOf(tempoativo)).doubleValue();
	}

	private Double getCicPadraoMed(List<DwConsolid> listadwconsolid) {
		Double cicloPadrao = 0d;
		Double qtdeCiclos = 0d;

		for (DwConsolid dwconsolid : listadwconsolid) {
			if (dwconsolid.getDwConsols() != null) {
				for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
					qtdeCiclos += 1;
					cicloPadrao += dwconsol.getSegAutoCiclopadrao() != null ? dwconsol.getSegAutoCiclopadrao().longValue() : 0l;
					cicloPadrao += dwconsol.getSegManuCiclopadrao() != null ? dwconsol.getSegManuCiclopadrao().longValue() : 0l;
				}
			}
		}
		return cicloPadrao.doubleValue() / qtdeCiclos;
	}

	private Double getPerdasCiclos(List<DwConsolid> listadwconsolid) {
		Double perdaciclo = 0d;
		for (DwConsolid dwconsolid : listadwconsolid) {
			if (dwconsolid.getDwConsols() != null) {
				for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
					perdaciclo += dwconsol.getPcsAutoPerdaciclo() != null ? dwconsol.getPcsAutoPerdaciclo().doubleValue() : 0d;
					perdaciclo += dwconsol.getPcsManuPerdaciclo() != null ? dwconsol.getPcsManuPerdaciclo().doubleValue() : 0d;
				}
			}
		}

		return new BigDecimal(perdaciclo.doubleValue()).doubleValue();
	}

	private Double getCicMedio(List<DwConsolid> listaDwconsolid) {
		Float segCicloMedio = 0f;
		Float segTempoCiclosProdutivos = 0f;
		Float qtCicloProdutivos = 0f;

		for (DwConsolid dwci : listaDwconsolid) {
			for (DwConsol dwconsol : dwci.getDwConsols()) {
				// acumula tempos e qtd necessÃ¡rias para calcular o ciclo
				// mÃ©dio
				qtCicloProdutivos += dwconsol.getQtAutoCicloprodutivo() != null ? dwconsol.getQtAutoCicloprodutivo().floatValue() : 0f;
				qtCicloProdutivos += dwconsol.getQtManuCicloprodutivo() != null ? dwconsol.getQtManuCicloprodutivo().floatValue() : 0f;

				segTempoCiclosProdutivos += dwconsol.getSegAutoCicloprodutivo() != null ? dwconsol.getSegAutoCicloprodutivo().floatValue()
						: 0f;
				segTempoCiclosProdutivos += dwconsol.getSegManuCicloprodutivo() != null ? dwconsol.getSegManuCicloprodutivo().floatValue()
						: 0f;
			}
		}

		if (qtCicloProdutivos > 0) {
			segCicloMedio = FormulasInjet.calcularCicloMedio(new BigDecimal(segTempoCiclosProdutivos), new BigDecimal(qtCicloProdutivos))
					.floatValue();
		}

		return segCicloMedio.doubleValue();

	}

	private String getMolde(DwConsolid dwconsolid) {
		try {
			for (DwFolharap dwFolhaRap : dwconsolid.getDwFolha().getDwFolharaps()) {
				return dwFolhaRap.getDwRap().getCdRap();
			}
		} catch (Exception e) {
			return "";
		}
		return "";
	}

	private Double segTempoParadasComPesoBaseadoEmDetalheParadaDTO(DetalhamentoProducaoDTO detHora) {
		Double segTempoParadas = 0d;

		for (DetalheParadaDTO par : detHora.getListaparadas()) {
			if (par.getPerdas_paradas() > 0d && par.isComPeso()) {
				segTempoParadas += par.getDuracaoEmSegundos().doubleValue();
			}
		}

		return segTempoParadas;
	}

	private Double qtdPerdasParadasComPesoBaseadaEmDetalheParadaDTO(DetalhamentoProducaoDTO detHora) {
		Double qtdPerdasParadas = 0d;

		for (DetalheParadaDTO par : detHora.getListaparadas()) {
			if (par.getPerdas_paradas() > 0d && par.isComPeso()) {
				qtdPerdasParadas += par.getPerdas_paradas();
			}
		}

		return qtdPerdasParadas;
	}	
	private Double qtdPerdasParadasBaseadaEmDetalheParadaDTO(DetalhamentoProducaoDTO detHora) {
		Double qtdPerdasParadas = 0d;

		for (DetalheParadaDTO par : detHora.getListaparadas()) {
			qtdPerdasParadas += par.getPerdas_paradas();
		}

		return qtdPerdasParadas;
	}

	private Double segTempoParadasBaseadoEmDetalheParadaDTO(DetalhamentoProducaoDTO detHora) {
		Double segTempoParadas = 0d;

		for (DetalheParadaDTO par : detHora.getListaparadas()) {
			segTempoParadas += par.getDuracaoEmSegundos().doubleValue();
		}

		return segTempoParadas;
	}

	private void gerarParadaDTO(
			DwConsolid dwconsolid,
			DwConsolpa dwconsolpa,
			BigDecimal segCicloPadrao,
			BigDecimal qtPcsCiclo,
			BigDecimal fatorContagemProd,
			Set<DwConsolpalog> pas,
			List<DetalheParadaDTO> retorno) {

		if (dwconsolpa.getDwConsolpaocos() != null) {
			for (DwConsolpaoco dwconsolpaoco : dwconsolpa.getDwConsolpaocos()) {
				if (dwconsolpaoco.getDthrFparada() == null)
					continue;

				if (dwconsolpaoco.getDwConsolpalog() != null) {
					DwConsolpalog dwconsolpalog = dwconsolpaoco.getDwConsolpalog();
					if (pas.contains(dwconsolpalog) == true)
						continue;

					pas.add(dwconsolpalog);

					DetalheParadaDTO paradaDTO = new DetalheParadaDTO();

					retorno.add(paradaDTO);

					if (dwconsolid.getOmPt() != null) {
						if (dwconsolid.getOmPt().getDsCurta() != null) {
							paradaDTO.setMaquina(dwconsolid.getOmPt().getCdPt() + " - " + dwconsolid.getOmPt().getDsCurta());
						} else {
							paradaDTO.setMaquina(dwconsolid.getOmPt().getCdPt());
						}

						paradaDTO.setDsPt(dwconsolid.getOmPt().getDsPt());
					}

					// Alex 28/06/2017 #3952
					String folha = dwconsolid.getDwFolha().getCdFolha();
					if (folha == null) {
						folha = "";
					}
					paradaDTO.setFolha(folha);

					paradaDTO.setFerramenta(getMolde(dwconsolid));

					double segDuracaoParada = DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodo(
							dwconsolpaoco.getDthrIparada(), dwconsolpaoco.getDthrFparada()).doubleValue();

					if (dwconsolpa.getDwTParada() != null) {
						paradaDTO.setParada(dwconsolpa.getDwTParada().getCdTparada() + " - "
								+ (dwconsolpa.getDwTParada().getIsPesa() ? dwconsolpa.getDwTParada().getDsTparada()
										: dwconsolpa.getDwTParada().getDsTparada().toLowerCase()));

					} else {
						paradaDTO.setParada("");
					}

					paradaDTO.setComPeso(dwconsolpa.getDwTParada().getIsPesa());
					paradaDTO.setInicio(dwconsolpaoco.getDthrIparada());
					paradaDTO.setFim(dwconsolpaoco.getDthrFparada());

					paradaDTO.setDuracao(DataHoraRN.formatSegundosParaHHMMSS((int) segDuracaoParada));
					paradaDTO.setDuracaoEmSegundos((double) segDuracaoParada);

					paradaDTO.setArea_resp(dwconsolpa.getDwTParada() != null
							&& dwconsolpa.getDwTParada().getDwTArea() != null ? dwconsolpa.getDwTParada()
									.getDwTArea().clone(false) : null);

					paradaDTO.setCausa(dwconsolpaoco.getDwTCausa() != null && dwconsolpaoco.getDwTCausa().getCdTcausa() != null
							? dwconsolpaoco.getDwTCausa().getCdTcausa() + "-" + dwconsolpaoco.getDwTCausa().getDsTcausa() : "");
					paradaDTO.setAcao(dwconsolpaoco.getDwTAcao() != null && dwconsolpaoco.getDwTAcao().getCdTacao() != null
							? dwconsolpaoco.getDwTAcao().getCdTacao() + "-" + dwconsolpaoco.getDwTAcao().getDsTacao() : "");
					paradaDTO.setJustificativa(dwconsolpaoco.getDwTJust() != null && dwconsolpaoco.getDwTJust().getCdTjust() != null
							? dwconsolpaoco.getDwTJust().getCdTjust() + "-" + dwconsolpaoco.getDwTJust().getDsTjust() : "");

					if (dwconsolpa.getDwTParada().getIsPesa()) {
						paradaDTO.setPerdas_paradas(FormulasInjet.calcularPcsPerdaParada(
								new BigDecimal(segDuracaoParada), segCicloPadrao, qtPcsCiclo.multiply(fatorContagemProd))
								.setScale(0, RoundingMode.FLOOR).doubleValue());
						
						if (IdwFacade.IS_IDW_ATIVO == false) {
							paradaDTO.setPerdas_paradas(ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(new BigDecimal(paradaDTO.getPerdas_paradas())).doubleValue());
						}
					} else {
						paradaDTO.setPerdas_paradas(0d);
					}

					if (dwconsolpalog.getDwConsolpalogtecs() != null) {
						for (DwConsolpalogtec tecnico : dwconsolpalog.getDwConsolpalogtecs()) {
							if (tecnico.getTpUsuario().equals(DwConsolpalogtecTemplate._TpUsuario.TECRESP.getValue())) {
								paradaDTO.setTecnico_responsavel(tecnico.getOmUsr().getCdUsr() + " - " + tecnico.getOmUsr().getDsNome());
							} else if (tecnico.getTpUsuario().equals(DwConsolpalogtecTemplate._TpUsuario.TEC1.getValue())) {
								paradaDTO.setTecnico1(tecnico.getOmUsr().getCdUsr() + " - " + tecnico.getOmUsr().getDsNome());
							} else if (tecnico.getTpUsuario().equals(DwConsolpalogtecTemplate._TpUsuario.TEC2.getValue())) {
								paradaDTO.setTecnico2(tecnico.getOmUsr().getCdUsr() + " - " + tecnico.getOmUsr().getDsNome());
							}
						}
					}

				}
			}
		}

	}

	private Double getPerdasRefugo(List<DwConsolid> listaDwconsolid) {
		double prod_ref = 0d;
		for (DwConsolid dwconsolid : listaDwconsolid) {
			if (dwconsolid.getDwConsols() != null) {
				for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
					prod_ref += dwconsol.getPcsAutoProducaorefugada() != null ? dwconsol.getPcsAutoProducaorefugada().doubleValue() : 0d;
					prod_ref += dwconsol.getPcsManuProducaorefugada() != null ? dwconsol.getPcsManuProducaorefugada().doubleValue() : 0d;
				}
			}
		}
		return prod_ref;
	}

	private Double getUltimoCicPadrao(List<DwConsolid> listadwconsolid) {
		Double ultCicloPadrao = 0d;
		for (DwConsolid dwconsolid : listadwconsolid) {
			if (dwconsolid.getDwConsols() != null) {
				for (DwConsol dwconsol : dwconsolid.getDwConsols()) {
					ultCicloPadrao += dwconsol.getSegAutoCiclopadrao() != null ? dwconsol.getSegAutoCiclopadrao().longValue() : 0l;
					ultCicloPadrao += dwconsol.getSegManuCiclopadrao() != null ? dwconsol.getSegManuCiclopadrao().longValue() : 0l;
					break;
				}
			}

		}
		return ultCicloPadrao;
	}

	@SuppressWarnings("unchecked")
	public BigDecimal pegaEficienciaInstantanea(OmPt omPt, PpCp ppCp) {
		Float eficienciaInstantanea = 0f;

		class RegistroLido {
			BigDecimal segCicloLido = BigDecimal.ZERO;
			BigDecimal segCicloPadrao = BigDecimal.ZERO;
		}

		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.tmpciclolido, a.tmpcicpadrao ");
		strSQL = strSQL.concat("  FROM viewUltimoCicloOP a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat(" WHERE b.cdinjestendido = :cdmaquina ");
		strSQL = strSQL.concat("   AND a.nrop = :nrop ");

		List<Object> lista = new ArrayList<Object>();

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q.setString("cdmaquina", omPt.getCdPt());
		q.setString("nrop", ppCp.getCdCp());

		lista = q.list();

		if (lista != null && lista.size() > 0) {
			Object reg = lista.get(0);

			RegistroLido registro = new RegistroLido();
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.segCicloLido = ConversaoTipos.converterParaBigDecimal(registroLido[0]);
			registro.segCicloPadrao = ConversaoTipos.converterParaBigDecimal(registroLido[1]);

			eficienciaInstantanea = FormulasInjet.calcularEficienciaCiclo(registro.segCicloLido, registro.segCicloPadrao);
		}

		return new BigDecimal(eficienciaInstantanea);
	}

	@SuppressWarnings("unchecked")
	public BigDecimal pegaUltimoCiclo(OmPt omPt, PpCp ppCp) {
		BigDecimal retorno = BigDecimal.ZERO;

		class RegistroLido {
			BigDecimal segCicloLido = BigDecimal.ZERO;
		}

		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.tmpciclolido, a.tmpcicpadrao ");
		strSQL = strSQL.concat("  FROM viewUltimoCicloOP a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat(" WHERE b.cdinjestendido = :cdmaquina ");
		strSQL = strSQL.concat("   AND a.nrop = :nrop ");

		List<Object> lista = new ArrayList<Object>();

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q.setString("cdmaquina", omPt.getCdPt());
		q.setString("nrop", ppCp.getCdCp());

		lista = q.list();

		if (lista != null && lista.size() > 0) {
			Object reg = lista.get(0);

			RegistroLido registro = new RegistroLido();
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.segCicloLido = ConversaoTipos.converterParaBigDecimal(registroLido[0]);
			retorno = registro.segCicloLido;
		}

		return retorno;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	protected List<DwConsolid> getDwConsolid(IdwLogger log, Byte tpId, DwTurno dwTurno, DwTParada dwTParada, DwTArea dwtarea,
			Date dtReferencia, Date dtRefIni, Date dtRefFim, Date dthrIhora, Date dthrFhora,
			boolean isJoinParada, boolean isJoinCiclos, int limiteMaxResult, OmGt omGt,
			List<FiltroProducaoPtCpDTO> listaFiltroProducaoPtCp) {

		// monta filtro e string de consulta
		FiltroDetalhePTInjetDTO filtro = new FiltroDetalhePTInjetDTO();
		filtro.setTpId(tpId);
		filtro.setDwTurno(dwTurno);
		filtro.setDwTParada(dwTParada);
		filtro.setDwtarea(dwtarea);
		filtro.setDtReferencia(dtReferencia);
		filtro.setDtReferenciaInicial(dtRefIni);
		filtro.setDtReferenciaFinal(dtRefFim);
		filtro.setDthrIhora(dthrIhora);
		filtro.setDthrFhora(dthrFhora);
		filtro.setOmGt(omGt);
		String consulta = getStringConsultaConsolidacaoInjet(filtro, listaFiltroProducaoPtCp);

		class Consolidacoes {
			String nrop;
			String nropExibicao;

			String cdInjetora;
			String cdInjEstendido;
			String cdIdentificInj;

			Date dthrIValCic;
			BigDecimal cicloPadrao = BigDecimal.ZERO;
			BigDecimal cicloPadraoVarMin = BigDecimal.ZERO;
			BigDecimal cicloPadraoVarMax = BigDecimal.ZERO;
			BigDecimal fatorContagemProd = BigDecimal.ZERO;

			Date dthrIValEstru;
			String cdMolde;
			String cdMolEstendido;
			String cdEstrutura;
			BigDecimal qtPcsCicloAtivas = BigDecimal.ZERO;
			BigDecimal qtPcsCicloTotais = BigDecimal.ZERO;

			BigDecimal segCicloMedio = BigDecimal.ZERO;
			BigDecimal qtCicNormal = BigDecimal.ZERO;
			BigDecimal qtCicFinPar = BigDecimal.ZERO;

			BigDecimal segTmpCicNormal = BigDecimal.ZERO;
			BigDecimal segTmpCicFinPar = BigDecimal.ZERO;
			BigDecimal segTmpParCP = BigDecimal.ZERO;
			BigDecimal segTmpParSP = BigDecimal.ZERO;
			BigDecimal segTmpHrsDisp = BigDecimal.ZERO;
			BigDecimal segTmpPcsPorCic = BigDecimal.ZERO;
			BigDecimal segTmpRefugo = BigDecimal.ZERO;
			BigDecimal segTmpRitmo = BigDecimal.ZERO;

			BigDecimal pcsProdBruta = BigDecimal.ZERO;
			BigDecimal pcsProdRef = BigDecimal.ZERO;
			BigDecimal pcsProdPrev = BigDecimal.ZERO;
			BigDecimal pcsProdPlan = BigDecimal.ZERO;
			BigDecimal pcsPerdaRitmo = BigDecimal.ZERO;
			BigDecimal pcsPerdaPcsPorCic = BigDecimal.ZERO;
			BigDecimal pcsPerdaParCP = BigDecimal.ZERO;
			BigDecimal pcsPerdaParSP = BigDecimal.ZERO;

			BigDecimal pcsSumPcsCicAtivas = BigDecimal.ZERO;
			BigDecimal pcsSumPcsCicTotais = BigDecimal.ZERO;

			BigDecimal segTmpParMTBF = BigDecimal.ZERO;
			BigDecimal qtParMTBF = BigDecimal.ZERO;
		}

		class RegistroLido {
			BigDecimal idregistro = BigDecimal.ZERO;
			Date dtTurno;
			String cdTurno;
			String dsTurno;
			Date dthrIniHora;
			Date dthrFimHora;
			Consolidacoes consolidacao = new Consolidacoes();
		}

		int _idregistro = 0;
		int _dthrIniHora = _idregistro + 1;
		int _dthrFimHora = _dthrIniHora + 1;

		int _dtTurno = _idregistro + 1;
		int _cdTurno = _dtTurno + 1;
		int _dsTurno = _cdTurno + 1;

		int _nrop = (filtro.getTpId().equals(DetalheMonitorizacaoPTInjetRN.PERIODO_CONSOLIDACAO_HORA) ? _dthrFimHora : _dsTurno) + 1;

		int _nropExibicao = _nrop + 1;
		int _cdInjetora = _nropExibicao + 1;
		int _cdInjEstendido = _cdInjetora + 1;
		int _cdIdentificInj = _cdInjEstendido + 1;
		int _dthrIValCic = _cdIdentificInj + 1;
		int _cicloPadrao = _dthrIValCic + 1;
		int _cicloPadraoVarMin = _cicloPadrao + 1;
		int _cicloPadraoVarMax = _cicloPadraoVarMin + 1;
		int _fatorContagemProd = _cicloPadraoVarMax + 1;
		int _dthrIValEstru = _fatorContagemProd + 1;
		int _cdMolde = _dthrIValEstru + 1;
		int _cdMolEstendido = _cdMolde + 1;
		int _cdEstrutura = _cdMolEstendido + 1;
		int _pcsPorCicloAtivas = _cdEstrutura + 1;
		int _pcsPorCicloTotais = _pcsPorCicloAtivas + 1;
		int _qtCicNormal = _pcsPorCicloTotais + 1;
		int _qtCicFinPar = _qtCicNormal + 1;
		int _segCicloMedio = _qtCicFinPar + 1;

		int _pcsProdBruta = _segCicloMedio + 1;
		int _pcsProdRef = _pcsProdBruta + 1;

		int _segTmpCicNormal = _pcsProdRef + 1;
		int _segTmpCicFinPar = _segTmpCicNormal + 1;
		int _segTmpParadasCP = _segTmpCicFinPar + 1;
		int _segTmpParadasSP = _segTmpParadasCP + 1;
		int _pcsProdPrev = _segTmpParadasSP + 1;
		int _pcsProdPlan = _pcsProdPrev + 1;

		int _segTmpHrsDisp = _pcsProdPlan + 1;
		int _segTmpPcsPorCic = _segTmpHrsDisp + 1;
		int _segTmpRefugo = _segTmpPcsPorCic + 1;
		int _segTmpRitmo = _segTmpRefugo + 1;
		int _pcsPerdaRitmo = _segTmpRitmo + 1;
		int _pcsPerdaPcsPorCic = _pcsPerdaRitmo + 1;
		int _pcsSumPcsPorCicAtivas = _pcsPerdaPcsPorCic + 1;
		int _pcsSumPcsPorCicTotais = _pcsSumPcsPorCicAtivas + 1;
		int _pcsPerdaParCP = _pcsSumPcsPorCicTotais + 1;
		int _pcsPerdaParSP = _pcsPerdaParCP + 1;
		int _segTmpParMTBF = _pcsPerdaParSP + 1;
		int _qtParMTBF = _segTmpParMTBF + 1;

		SQLQuery q = this.getDaoSession().createSQLQuery(consulta);

		if (filtro.getTpId() == PERIODO_CONSOLIDACAO_HORA) {
			q.setTimestamp("dthrihr", filtro.getDthrIhora())
					.setTimestamp("dthrfhr", filtro.getDthrFhora());
		} else {
			if (filtro.getDtReferencia() != null) {
				q.setTimestamp("dtref", filtro.getDtReferencia());
			}

			if (filtro.getDwTurno() != null) {
				q.setString("cdturno", FuncoesApoioInjet.getStrZero(filtro.getDwTurno().getIdTurno(), 6));
			}
		}

		if (filtro.getOmPt() != null) {
			q.setString("cdinjetora", filtro.getOmPt().getCdPt());
		}

		if (filtro.getOmGt() != null) {
			q.setString("cdgalpao", filtro.getOmGt().getCdGt());
		}

		if (filtro.getCdCp() != null && filtro.getCdCp().equals("") == false && filtro.getFiltroOp() != null
				&& (filtro.getFiltroOp() == 0 || filtro.getFiltroOp() == 3)) {
			q.setString("nrop", filtro.getPpCp().getCdCp());
		}

		List<DwConsolid> listaretorno = new ArrayList<DwConsolid>();

		List<Object> lista = new ArrayList<Object>();
		lista = q.list();

		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.idregistro = ConversaoTipos.converterParaBigDecimal(registroLido[_idregistro]);

			if (filtro.getTpId().equals(DetalheMonitorizacaoPTInjetRN.PERIODO_CONSOLIDACAO_HORA)) {
				registro.dthrIniHora = (Date) registroLido[_dthrIniHora];
				registro.dthrFimHora = (Date) registroLido[_dthrFimHora];
			} else {
				registro.dtTurno = (Date) registroLido[_dtTurno];
				registro.cdTurno = (String) registroLido[_cdTurno];
				registro.dsTurno = (String) registroLido[_dsTurno];
			}

			registro.consolidacao.nrop = (String) registroLido[_nrop];
			registro.consolidacao.nropExibicao = (String) registroLido[_nropExibicao];

			registro.consolidacao.cdInjetora = (String) registroLido[_cdInjetora];
			registro.consolidacao.cdInjEstendido = (String) registroLido[_cdInjEstendido];
			registro.consolidacao.cdIdentificInj = (String) registroLido[_cdIdentificInj];

			registro.consolidacao.dthrIValCic = (Date) registroLido[_dthrIValCic];
			registro.consolidacao.cicloPadrao = ConversaoTipos.converterParaBigDecimal(registroLido[_cicloPadrao]);
			registro.consolidacao.cicloPadraoVarMin = ConversaoTipos.converterParaBigDecimal(registroLido[_cicloPadraoVarMin]);
			registro.consolidacao.cicloPadraoVarMax = ConversaoTipos.converterParaBigDecimal(registroLido[_cicloPadraoVarMax]);
			registro.consolidacao.fatorContagemProd = ConversaoTipos.converterParaBigDecimal(registroLido[_fatorContagemProd]);

			registro.consolidacao.dthrIValEstru = (Date) registroLido[_dthrIValEstru];
			registro.consolidacao.cdMolde = (String) registroLido[_cdMolde];
			registro.consolidacao.cdMolEstendido = (String) registroLido[_cdMolEstendido];
			registro.consolidacao.cdEstrutura = (String) registroLido[_cdEstrutura];
			registro.consolidacao.qtPcsCicloAtivas =
					ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPorCicloAtivas]));
			registro.consolidacao.qtPcsCicloTotais =
					ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPorCicloTotais]));

			registro.consolidacao.segCicloMedio = ConversaoTipos.converterParaBigDecimal(registroLido[_segCicloMedio]);
			registro.consolidacao.qtCicNormal = ConversaoTipos.converterParaBigDecimal(registroLido[_qtCicNormal]);
			registro.consolidacao.qtCicFinPar = ConversaoTipos.converterParaBigDecimal(registroLido[_qtCicFinPar]);

			registro.consolidacao.segTmpCicNormal = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpCicNormal]);
			registro.consolidacao.segTmpCicFinPar = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpCicFinPar]);
			registro.consolidacao.segTmpParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParadasCP]);
			registro.consolidacao.segTmpParSP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParadasSP]);
			registro.consolidacao.segTmpHrsDisp = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpHrsDisp]);
			registro.consolidacao.segTmpPcsPorCic = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpPcsPorCic]);
			registro.consolidacao.segTmpRefugo = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpRefugo]);
			registro.consolidacao.segTmpRitmo = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpRitmo]);

			registro.consolidacao.pcsProdBruta =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsProdBruta]));
			registro.consolidacao.pcsProdRef =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsProdRef]));
			registro.consolidacao.pcsProdPrev =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsProdPrev]));
			registro.consolidacao.pcsProdPlan =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsProdPlan]));
			registro.consolidacao.pcsPerdaRitmo =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaRitmo]));
			registro.consolidacao.pcsPerdaPcsPorCic =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaPcsPorCic]));
			registro.consolidacao.pcsPerdaParCP =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParCP]));
			registro.consolidacao.pcsPerdaParSP =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParSP]));

			registro.consolidacao.pcsSumPcsCicAtivas =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsSumPcsPorCicAtivas]));
			registro.consolidacao.pcsSumPcsCicTotais =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsSumPcsPorCicTotais]));

			if (registroLido[_segTmpParMTBF] != null) {
				registro.consolidacao.segTmpParMTBF = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParMTBF]);
				registro.consolidacao.qtParMTBF = ConversaoTipos.converterParaBigDecimal(registroLido[_qtParMTBF]);
			}

			// preecher dwconsolid
			DwConsolid dwci = new DwConsolid();
			DwConsol dwc = new DwConsol();

			Date dthrITur = null;
			Date dthrFTur = null;

			dwci.setTpId(filtro.getTpId());
			dwci.setDwRt(new DwRt()); // se precisar tem que montar

			if (filtro.getTpId().equals(DetalheMonitorizacaoPTInjetRN.PERIODO_CONSOLIDACAO_TURNO)) {
				try {
					dthrITur = FuncoesApoioInjet.calcularInicioTurno(this.getDao(), registro.dtTurno, registro.cdTurno);
					dthrFTur = FuncoesApoioInjet.calcularFimTurno(this.getDao(), registro.dtTurno, registro.cdTurno);
				} catch (SemCalendarioException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				dwci.setIdConsolid(registro.idregistro.longValue());

				dwci.setDthrIturno(dthrITur);
				dwci.setDthrFturno(dthrFTur);
				dwci.setDtReferencia(registro.dtTurno);

				DwTurno dwTur = new DwTurno();
				dwTur.setIdTurno(ConversaoTipos.converteParaBigDecimal(registro.cdTurno).longValue());
				dwTur.setCdTurno(registro.cdTurno);
				dwTur.setDsTurno(registro.dsTurno);
				dwci.setDwTurno(dwTur);

			} else {
				dwci.setDthrIhora(registro.dthrIniHora);
				dwci.setDthrFhora(registro.dthrFimHora);

				if (tpId == PERIODO_CONSOLIDACAO_HORA) {

					dwci.setIdConsolid(registro.idregistro.longValue());

					// atribuir turno
					DwTurno turno = new DwTurno();
					try {
						Date dtHrIHora = dwci.getDthrIhora();
						//TurnoInjetDTO turIJ = FuncoesApoioInjet.encontraTurno(getDao(), dwci.getDthrIhora());
						TurnoInjetDTO turIJ = FuncoesApoioInjet.encontraTurno(getDao(), dthrIhora);
						turno.setCdTurno(turIJ.getIjtbtur().getCdturno());
						turno.setDsTurno(turIJ.getIjtbtur().getDsturno());
						dwci.setDwTurno(turno);

					} catch (SemCalendarioException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

			OmPt ompt = new OmPt();
			ompt.setCdPt(registro.consolidacao.cdInjEstendido);
			ompt.setDsPt(registro.consolidacao.cdIdentificInj);
			ompt.setDsCurta(ompt.getDsPt());
			dwci.setOmPt(ompt);

			PpCp cp = new PpCp();
			cp.setCdCp(registro.consolidacao.nrop);
			//cp.setCdCp(filtro.getCdCp());
			// cp.setDthrInicioreal(registro.dthrirealOP);
			cp.setPpCpprodutos(new HashSet<PpCpproduto>());

			PpCpproduto pro = new PpCpproduto();
			pro.setPcsProducaoplanejada(registro.consolidacao.pcsProdPlan);
			// pro.setPcsProducaoplanejada(registro.consolidacao.pcsProdPlan);
			// pro.setPcsProducaobruta(registro.qtdProdBrutaOP);
			// pro.setPcsProducaorefugada(registro.qtdProdRefOP);
			cp.getPpCpprodutos().add(pro);
			dwci.setPpCp(cp);

			// folha
			DwFolha oFolha = new DwFolha();
			oFolha.setDwFolharaps(new HashSet<DwFolharap>());
			oFolha.setCdFolha(registro.consolidacao.cdMolEstendido + "/" + registro.consolidacao.cdEstrutura);
			oFolha.setDsFolha(oFolha.getCdFolha());
			oFolha.setQtFatorcontagem(registro.consolidacao.fatorContagemProd);
			oFolha.setSegCiclopadrao(registro.consolidacao.cicloPadrao);
			oFolha.setSegCiclominimo(registro.consolidacao.cicloPadraoVarMin);
			oFolha.setSegCiclotimeout(registro.consolidacao.cicloPadraoVarMax);
			oFolha.setDtRevisao(registro.consolidacao.dthrIValCic);

			DwFolharap ofRap = new DwFolharap();
			ofRap.setDwFolharapcoms(new HashSet<DwFolharapcom>());

			// recupera sempre a lsita de produtos por causa das oerdas abaixo que podem apresentar problema de arredondameneto
			registro.consolidacao.pcsPerdaRitmo = BigDecimal.ZERO;
			registro.consolidacao.pcsPerdaParCP = BigDecimal.ZERO;
			registro.consolidacao.pcsPerdaParSP = BigDecimal.ZERO;

			Set<DwConsolpr> listaProdutos = new HashSet<DwConsolpr>();
			listaProdutos =
					getProdutosConsolidacao(dwc, filtro.getTpId(), registro.dtTurno, registro.cdTurno, registro.dthrIniHora,
							registro.consolidacao.cdInjetora, registro.consolidacao.nrop, registro.consolidacao.cdMolde,
							registro.consolidacao.cdEstrutura, registro.consolidacao.dthrIValEstru, registro.consolidacao.dthrIValCic);
			for (DwConsolpr cpr : listaProdutos) {
				DwRap rap = new DwRap();
				rap.setCdRap(oFolha.getCdFolha());
				rap.setDsRap(rap.getCdRap());

				DwFolharapcom ofRapCom = new DwFolharapcom();
				ofRapCom.setQtAtiva(cpr.getPcsManuProducaorefugada());
				ofRapCom.setQtTotal(cpr.getPcsManuProducaobruta());
				ofRapCom.setOmProduto(cpr.getOmProduto());

				ofRap.setDwRap(rap);
				ofRap.getDwFolharapcoms().add(ofRapCom);

				cpr.setPcsManuProducaobruta(null);
				cpr.setPcsManuProducaorefugada(null);
				
				registro.consolidacao.pcsPerdaRitmo = AritmeticaUtil.somar(registro.consolidacao.pcsPerdaRitmo, ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(cpr.getPcsAutoPerdaciclo()));
				registro.consolidacao.pcsPerdaParCP = AritmeticaUtil.somar(registro.consolidacao.pcsPerdaParCP, ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(cpr.getPcsAutoPerdaparadaCp()));
				registro.consolidacao.pcsPerdaParSP = AritmeticaUtil.somar(registro.consolidacao.pcsPerdaParSP, ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(cpr.getPcsAutoPerdaparadaSp()));
			}
			
			/*
			if (isJoinProdutos) {
				
				registro.consolidacao.pcsPerdaRitmo = BigDecimal.ZERO;
				registro.consolidacao.pcsPerdaParCP = BigDecimal.ZERO;
				registro.consolidacao.pcsPerdaParSP = BigDecimal.ZERO;
				
				listaProdutos =
						getProdutosConsolidacao(dwc, filtro.getTpId(), registro.dtTurno, registro.cdTurno, registro.dthrIniHora,
								registro.consolidacao.cdInjetora, registro.consolidacao.nrop, registro.consolidacao.cdMolde,
								registro.consolidacao.cdEstrutura, registro.consolidacao.dthrIValEstru, registro.consolidacao.dthrIValCic);
				for (DwConsolpr cpr : listaProdutos) {
					DwRap rap = new DwRap();
					rap.setCdRap(oFolha.getCdFolha());
					rap.setDsRap(rap.getCdRap());

					DwFolharapcom ofRapCom = new DwFolharapcom();
					ofRapCom.setQtAtiva(cpr.getPcsManuProducaorefugada());
					ofRapCom.setQtTotal(cpr.getPcsManuProducaobruta());
					ofRapCom.setOmProduto(cpr.getOmProduto());

					ofRap.setDwRap(rap);
					ofRap.getDwFolharapcoms().add(ofRapCom);

					cpr.setPcsManuProducaobruta(null);
					cpr.setPcsManuProducaorefugada(null);
					
					registro.consolidacao.pcsPerdaRitmo = AritmeticaUtil.somar(registro.consolidacao.pcsPerdaRitmo, ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(cpr.getPcsAutoPerdaciclo()));
					registro.consolidacao.pcsPerdaParCP = AritmeticaUtil.somar(registro.consolidacao.pcsPerdaParCP, ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(cpr.getPcsAutoPerdaparadaCp()));
					registro.consolidacao.pcsPerdaParSP = AritmeticaUtil.somar(registro.consolidacao.pcsPerdaParSP, ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(cpr.getPcsAutoPerdaparadaSp()));
					
				}
			} else {
				DwRap rap = new DwRap();
				rap.setCdRap(oFolha.getCdFolha());
				rap.setDsRap(rap.getCdRap());

				DwFolharapcom ofRapCom = new DwFolharapcom();
				ofRapCom.setQtAtiva(registro.consolidacao.qtPcsCicloAtivas);
				ofRapCom.setQtTotal(registro.consolidacao.qtPcsCicloTotais);
				ofRapCom.setOmProduto(new OmProduto());

				ofRap.setDwRap(rap);
				ofRap.getDwFolharapcoms().add(ofRapCom);
			}
			*/
			
			oFolha.getDwFolharaps().add(ofRap);
			dwci.setDwFolha(oFolha);

			// consol - tempos
			dwc.setDwConsolprs(listaProdutos);
			dwc.setSegAutoBoas(registro.consolidacao.segTmpCicNormal.subtract(registro.consolidacao.segTmpRefugo));
			dwc.setSegAutoCicloprodutivo(registro.consolidacao.segTmpCicNormal);
			dwc.setSegAutoCicloimprodutivo(registro.consolidacao.segTmpCicFinPar);
			dwc.setSegAutoCiclomedio(registro.consolidacao.segCicloMedio);
			dwc.setSegAutoCiclopadrao(registro.consolidacao.cicloPadrao);
			dwc.setSegAutoPerdacav(registro.consolidacao.segTmpPcsPorCic);
			dwc.setSegAutoPerdaciclo(registro.consolidacao.segTmpRitmo);
			dwc.setSegAutoTempoparadaCp(registro.consolidacao.segTmpParCP);
			dwc.setSegAutoTempoparadaSp(registro.consolidacao.segTmpParSP);
			dwc.setSegAutoTemporefugadas(registro.consolidacao.segTmpRefugo);
			dwc.setSegAutoTempoativo(registro.consolidacao.segTmpCicNormal.add(registro.consolidacao.segTmpCicFinPar)
					.add(registro.consolidacao.segTmpParCP));
			dwc.setSegAutoTempoprodutivo(
					registro.consolidacao.segTmpCicNormal.subtract(registro.consolidacao.segTmpRefugo)
							.subtract(registro.consolidacao.segTmpPcsPorCic).subtract(registro.consolidacao.segTmpRitmo));
			dwc.setSegAutoTempotrabalhado(registro.consolidacao.segTmpCicNormal.add(registro.consolidacao.segTmpCicFinPar));

			if (filtro.getTpId().equals(DetalheMonitorizacaoPTInjetRN.PERIODO_CONSOLIDACAO_TURNO)) {
				dwc.setSegAutoTempocalendario(DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodo(dthrITur, dthrFTur, 0));
			} else {
				dwc.setSegAutoTempocalendario(
						DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodo(registro.dthrIniHora, registro.dthrFimHora, 0));
			}

			if (dwc.getSegAutoTempoprodutivo().doubleValue() < 0) {
				dwc.setSegAutoTempoprodutivo(BigDecimal.ZERO);
			}
			// consol - qtdes
			dwc.setPcsAutoPerdaciclo(registro.consolidacao.pcsPerdaRitmo);
			dwc.setPcsAutoPerdacavidades(registro.consolidacao.pcsPerdaPcsPorCic);
			dwc.setPcsAutoCavAtivas(registro.consolidacao.pcsSumPcsCicAtivas);
			dwc.setPcsAutoCavTotal(registro.consolidacao.pcsSumPcsCicTotais);
			dwc.setPcsAutoPerdaparadaCp(registro.consolidacao.pcsPerdaParCP);
			dwc.setPcsAutoPerdaparadaSp(registro.consolidacao.pcsPerdaParSP);
			dwc.setPcsAutoProducaobruta(registro.consolidacao.pcsProdBruta);
			dwc.setPcsAutoProducaoprevista(registro.consolidacao.pcsProdPrev);
			dwc.setPcsAutoProducaorefugada(registro.consolidacao.pcsProdRef);

			dwc.setQtAutoCavativas(registro.consolidacao.qtPcsCicloAtivas);
			dwc.setQtAutoCavtotal(registro.consolidacao.qtPcsCicloTotais);

			dwc.setQtAutoCicloprodutivo(registro.consolidacao.qtCicNormal);
			dwc.setQtAutoCicloimprodutivo(registro.consolidacao.qtCicFinPar);

			dwc.setSegAutoTempoparadamtbf(registro.consolidacao.segTmpParMTBF);
			dwc.setQtAutoOcoparadamtbf(registro.consolidacao.qtParMTBF);

			
			// dwc.setQtAutoOcoparadaCp(BigDecimal.ZERO);
			// dwc.setQtAutoOcoparadaSp(BigDecimal.ZERO);

			DwCal cal = getAgendaAtualInjet();
			dwci.setDwCal(cal);

			Set<DwRtcic> listaCiclos = new HashSet<DwRtcic>();
			if (isJoinCiclos) {
				Date dthrIni;
				Date dthrFim;

				if (filtro.getTpId().equals(DetalheMonitorizacaoPTInjetRN.PERIODO_CONSOLIDACAO_TURNO)) {
					dthrIni = dthrITur;
					dthrFim = dthrFTur;
				} else {
					dthrIni = registro.dthrIniHora;
					dthrFim = registro.dthrFimHora;
				}
				listaCiclos = getCiclosConsolidacao(dwci, dthrIni, dthrFim, registro.consolidacao.cdInjetora, registro.consolidacao.nrop,
						registro.consolidacao.cdMolde, registro.consolidacao.cdEstrutura, registro.consolidacao.dthrIValEstru,
						registro.consolidacao.dthrIValCic);
			}

			Set<DwConsolpa> listaParadas = new HashSet<DwConsolpa>();
			if (isJoinParada) {
				listaParadas = getParadasConsolidacao(dwc, filtro.getTpId(), registro.dtTurno, registro.cdTurno, registro.dthrIniHora,
						registro.consolidacao.cdInjetora, registro.consolidacao.nrop, registro.consolidacao.cdMolde,
						registro.consolidacao.cdEstrutura,
						registro.consolidacao.dthrIValEstru, registro.consolidacao.dthrIValCic, filtro.getDwtarea(), filtro.getDwTParada());
			}
			dwc.setDwConsolpas(listaParadas);

			dwci.getDwRt().setDwRtcics(listaCiclos);
			dwc.setDwConsolid(dwci);
			dwci.setDwConsols(new HashSet<DwConsol>());
			dwci.getDwConsols().add(dwc);

			listaretorno.add(dwci);

		}

		return listaretorno;

	}

	@SuppressWarnings("unchecked")
	protected List<DwConsolid> getDwConsolid(IdwLogger log, Long idConsolid,
			boolean isJoinParada, boolean isJoinCiclos, boolean isJoinProdutos,
			boolean isJoinPerdaMP, boolean isJoinCicloPadrao, boolean isJoinPcPorCiclo) {

		// monta filtro e string de consulta
		FiltroDetalhePTInjetDTO filtro = new FiltroDetalhePTInjetDTO();
		filtro.setIdDwConsolId(idConsolid);
		filtro.setTpId(PERIODO_CONSOLIDACAO_HORA);
		String consulta = getStringConsultaConsolidacaoInjetUT(idConsolid);

		class Consolidacoes {
			String nrop;
			String nropExibicao;

			String cdInjetora;
			String cdInjEstendido;
			String cdIdentificInj;

			Date dthrIValCic;
			BigDecimal cicloPadrao = BigDecimal.ZERO;
			BigDecimal cicloPadraoVarMin = BigDecimal.ZERO;
			BigDecimal cicloPadraoVarMax = BigDecimal.ZERO;
			BigDecimal fatorContagemProd = BigDecimal.ZERO;

			Date dthrIValEstru;
			String cdMolde;
			String cdMolEstendido;
			String cdEstrutura;
			BigDecimal qtPcsCicloAtivas = BigDecimal.ZERO;
			BigDecimal qtPcsCicloTotais = BigDecimal.ZERO;

			BigDecimal segCicloMedio = BigDecimal.ZERO;
			BigDecimal qtCicNormal = BigDecimal.ZERO;
			BigDecimal qtCicFinPar = BigDecimal.ZERO;

			BigDecimal segTmpCicNormal = BigDecimal.ZERO;
			BigDecimal segTmpCicFinPar = BigDecimal.ZERO;
			BigDecimal segTmpParCP = BigDecimal.ZERO;
			BigDecimal segTmpParSP = BigDecimal.ZERO;
			BigDecimal segTmpHrsDisp = BigDecimal.ZERO;
			BigDecimal segTmpPcsPorCic = BigDecimal.ZERO;
			BigDecimal segTmpRefugo = BigDecimal.ZERO;
			BigDecimal segTmpRitmo = BigDecimal.ZERO;

			BigDecimal pcsProdBruta = BigDecimal.ZERO;
			BigDecimal pcsProdRef = BigDecimal.ZERO;
			BigDecimal pcsProdPrev = BigDecimal.ZERO;
			BigDecimal pcsProdPlan = BigDecimal.ZERO;
			BigDecimal pcsPerdaRitmo = BigDecimal.ZERO;
			BigDecimal pcsPerdaPcsPorCic = BigDecimal.ZERO;
			BigDecimal pcsPerdaParCP = BigDecimal.ZERO;
			BigDecimal pcsPerdaParSP = BigDecimal.ZERO;

			BigDecimal pcsSumPcsCicAtivas = BigDecimal.ZERO;
			BigDecimal pcsSumPcsCicTotais = BigDecimal.ZERO;

			BigDecimal segTmpParMTBF = BigDecimal.ZERO;
			BigDecimal qtParMTBF = BigDecimal.ZERO;
		}

		class RegistroLido {
			BigDecimal idregistro = BigDecimal.ZERO;
			Date dtTurno;
			String cdTurno;
			String dsTurno;
			Date dthrIniHora;
			Date dthrFimHora;
			Consolidacoes consolidacao = new Consolidacoes();
		}

		int _idregistro = 0;
		int _dthrIniHora = _idregistro + 1;
		int _dthrFimHora = _dthrIniHora + 1;

		int _dtTurno = 0;
		int _cdTurno = _dtTurno + 1;
		int _dsTurno = _cdTurno + 1;

		int _nrop = (filtro.getTpId().equals(DetalheMonitorizacaoPTInjetRN.PERIODO_CONSOLIDACAO_HORA) ? _dthrFimHora : _dsTurno) + 1;

		int _nropExibicao = _nrop + 1;
		int _cdInjetora = _nropExibicao + 1;
		int _cdInjEstendido = _cdInjetora + 1;
		int _cdIdentificInj = _cdInjEstendido + 1;
		int _dthrIValCic = _cdIdentificInj + 1;
		int _cicloPadrao = _dthrIValCic + 1;
		int _cicloPadraoVarMin = _cicloPadrao + 1;
		int _cicloPadraoVarMax = _cicloPadraoVarMin + 1;
		int _fatorContagemProd = _cicloPadraoVarMax + 1;
		int _dthrIValEstru = _fatorContagemProd + 1;
		int _cdMolde = _dthrIValEstru + 1;
		int _cdMolEstendido = _cdMolde + 1;
		int _cdEstrutura = _cdMolEstendido + 1;
		int _pcsPorCicloAtivas = _cdEstrutura + 1;
		int _pcsPorCicloTotais = _pcsPorCicloAtivas + 1;
		int _qtCicNormal = _pcsPorCicloTotais + 1;
		int _qtCicFinPar = _qtCicNormal + 1;
		int _segCicloMedio = _qtCicFinPar + 1;

		int _pcsProdBruta = _segCicloMedio + 1;
		int _pcsProdRef = _pcsProdBruta + 1;

		int _segTmpCicNormal = _pcsProdRef + 1;
		int _segTmpCicFinPar = _segTmpCicNormal + 1;
		int _segTmpParadasCP = _segTmpCicFinPar + 1;
		int _segTmpParadasSP = _segTmpParadasCP + 1;
		int _pcsProdPrev = _segTmpParadasSP + 1;
		int _pcsProdPlan = _pcsProdPrev + 1;

		int _segTmpHrsDisp = _pcsProdPlan + 1;
		int _segTmpPcsPorCic = _segTmpHrsDisp + 1;
		int _segTmpRefugo = _segTmpPcsPorCic + 1;
		int _segTmpRitmo = _segTmpRefugo + 1;
		int _pcsPerdaRitmo = _segTmpRitmo + 1;
		int _pcsPerdaPcsPorCic = _pcsPerdaRitmo + 1;
		int _pcsSumPcsPorCicAtivas = _pcsPerdaPcsPorCic + 1;
		int _pcsSumPcsPorCicTotais = _pcsSumPcsPorCicAtivas + 1;
		int _pcsPerdaParCP = _pcsSumPcsPorCicTotais + 1;
		int _pcsPerdaParSP = _pcsPerdaParCP + 1;
		int _segTmpParMTBF = _pcsPerdaParSP + 1;
		int _qtParMTBF = _segTmpParMTBF + 1;

		SQLQuery q = this.getDaoSession().createSQLQuery(consulta);
		List<DwConsolid> listaretorno = new ArrayList<DwConsolid>();

		List<Object> lista = new ArrayList<Object>();
		lista = q.list();

		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.idregistro = ConversaoTipos.converterParaBigDecimal(registroLido[_idregistro]);

			if (filtro.getTpId().equals(DetalheMonitorizacaoPTInjetRN.PERIODO_CONSOLIDACAO_HORA)) {
				registro.dthrIniHora = (Date) registroLido[_dthrIniHora];
				registro.dthrFimHora = (Date) registroLido[_dthrFimHora];
			} else {
				registro.dtTurno = (Date) registroLido[_dtTurno];
				registro.cdTurno = (String) registroLido[_cdTurno];
				registro.dsTurno = (String) registroLido[_dsTurno];
			}

			registro.consolidacao.nrop = (String) registroLido[_nrop];
			registro.consolidacao.nropExibicao = (String) registroLido[_nropExibicao];

			registro.consolidacao.cdInjetora = (String) registroLido[_cdInjetora];
			registro.consolidacao.cdInjEstendido = (String) registroLido[_cdInjEstendido];
			registro.consolidacao.cdIdentificInj = (String) registroLido[_cdIdentificInj];

			registro.consolidacao.dthrIValCic = (Date) registroLido[_dthrIValCic];
			registro.consolidacao.cicloPadrao = ConversaoTipos.converterParaBigDecimal(registroLido[_cicloPadrao]);
			registro.consolidacao.cicloPadraoVarMin = ConversaoTipos.converterParaBigDecimal(registroLido[_cicloPadraoVarMin]);
			registro.consolidacao.cicloPadraoVarMax = ConversaoTipos.converterParaBigDecimal(registroLido[_cicloPadraoVarMax]);
			registro.consolidacao.fatorContagemProd = ConversaoTipos.converterParaBigDecimal(registroLido[_fatorContagemProd]);

			registro.consolidacao.dthrIValEstru = (Date) registroLido[_dthrIValEstru];
			registro.consolidacao.cdMolde = (String) registroLido[_cdMolde];
			registro.consolidacao.cdMolEstendido = (String) registroLido[_cdMolEstendido];
			registro.consolidacao.cdEstrutura = (String) registroLido[_cdEstrutura];
			registro.consolidacao.qtPcsCicloAtivas =
					ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPorCicloAtivas]));
			registro.consolidacao.qtPcsCicloTotais =
					ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPorCicloTotais]));

			registro.consolidacao.segCicloMedio = ConversaoTipos.converterParaBigDecimal(registroLido[_segCicloMedio]);
			registro.consolidacao.qtCicNormal = ConversaoTipos.converterParaBigDecimal(registroLido[_qtCicNormal]);
			registro.consolidacao.qtCicFinPar = ConversaoTipos.converterParaBigDecimal(registroLido[_qtCicFinPar]);

			registro.consolidacao.segTmpCicNormal = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpCicNormal]);
			registro.consolidacao.segTmpCicFinPar = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpCicFinPar]);
			registro.consolidacao.segTmpParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParadasCP]);
			registro.consolidacao.segTmpParSP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParadasSP]);
			registro.consolidacao.segTmpHrsDisp = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpHrsDisp]);
			registro.consolidacao.segTmpPcsPorCic = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpPcsPorCic]);
			registro.consolidacao.segTmpRefugo = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpRefugo]);
			registro.consolidacao.segTmpRitmo = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpRitmo]);

			registro.consolidacao.pcsProdBruta =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsProdBruta]));
			registro.consolidacao.pcsProdRef =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsProdRef]));
			registro.consolidacao.pcsProdPrev =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsProdPrev]));
			registro.consolidacao.pcsProdPlan =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsProdPlan]));
			registro.consolidacao.pcsPerdaRitmo =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaRitmo]));
			registro.consolidacao.pcsPerdaPcsPorCic =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaPcsPorCic]));
			registro.consolidacao.pcsPerdaParCP =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParCP]));
			registro.consolidacao.pcsPerdaParSP =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParSP]));

			registro.consolidacao.pcsSumPcsCicAtivas =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsSumPcsPorCicAtivas]));
			registro.consolidacao.pcsSumPcsCicTotais =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsSumPcsPorCicTotais]));

			if (registroLido[_segTmpParMTBF] != null) {
				registro.consolidacao.segTmpParMTBF = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParMTBF]);
				registro.consolidacao.qtParMTBF = ConversaoTipos.converterParaBigDecimal(registroLido[_qtParMTBF]);
			}

			// preecher dwconsolid
			DwConsolid dwci = new DwConsolid();
			DwConsol dwc = new DwConsol();

			Date dthrITur = null;
			Date dthrFTur = null;

			dwci.setTpId(filtro.getTpId());
			dwci.setDwRt(new DwRt()); // se precisar tem que montar

			if (filtro.getTpId().equals(DetalheMonitorizacaoPTInjetRN.PERIODO_CONSOLIDACAO_TURNO)) {
				try {
					dthrITur = FuncoesApoioInjet.calcularInicioTurno(this.getDao(), registro.dtTurno, registro.cdTurno);
					dthrFTur = FuncoesApoioInjet.calcularFimTurno(this.getDao(), registro.dtTurno, registro.cdTurno);
				} catch (SemCalendarioException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				dwci.setIdConsolid(registro.idregistro.longValue());

				dwci.setDthrIturno(dthrITur);
				dwci.setDthrFturno(dthrFTur);
				dwci.setDtReferencia(registro.dtTurno);

				DwTurno dwTur = new DwTurno();
				dwTur.setIdTurno(ConversaoTipos.converteParaBigDecimal(registro.cdTurno).longValue());
				dwTur.setCdTurno(registro.cdTurno);
				dwTur.setDsTurno(registro.dsTurno);
				dwci.setDwTurno(dwTur);

			} else {
				dwci.setDthrIhora(registro.dthrIniHora);
				dwci.setDthrFhora(registro.dthrFimHora);

				dwci.setIdConsolid(registro.idregistro.longValue());

				// atribuir turno
				DwTurno turno = new DwTurno();
				try {
					Date dtHrIHora = dwci.getDthrIhora();
					//TurnoInjetDTO turIJ = FuncoesApoioInjet.encontraTurno(getDao(), dwci.getDthrIhora());
					TurnoInjetDTO turIJ = FuncoesApoioInjet.encontraTurno(getDao(), dtHrIHora);
					turno.setCdTurno(turIJ.getIjtbtur().getCdturno());
					turno.setDsTurno(turIJ.getIjtbtur().getDsturno());
					dwci.setDwTurno(turno);

				} catch (SemCalendarioException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			OmPt ompt = new OmPt();
			ompt.setCdPt(registro.consolidacao.cdInjEstendido);
			ompt.setDsPt(registro.consolidacao.cdIdentificInj);
			ompt.setDsCurta(ompt.getDsPt());
			dwci.setOmPt(ompt);

			PpCp cp = new PpCp();
			cp.setCdCp(filtro.getCdCp());
			// cp.setDthrInicioreal(registro.dthrirealOP);
			cp.setPpCpprodutos(new HashSet<PpCpproduto>());

			PpCpproduto pro = new PpCpproduto();
			// pro.setPcsProducaoplanejada(registro.consolidacao.pcsProdPlan);
			// pro.setPcsProducaobruta(registro.qtdProdBrutaOP);
			// pro.setPcsProducaorefugada(registro.qtdProdRefOP);
			cp.getPpCpprodutos().add(pro);
			dwci.setPpCp(cp);

			// folha
			DwFolha oFolha = new DwFolha();
			oFolha.setDwFolharaps(new HashSet<DwFolharap>());
			oFolha.setCdFolha(registro.consolidacao.cdMolEstendido + "/" + registro.consolidacao.cdEstrutura);
			oFolha.setDsFolha(oFolha.getCdFolha());
			oFolha.setQtFatorcontagem(registro.consolidacao.fatorContagemProd);
			oFolha.setSegCiclopadrao(registro.consolidacao.cicloPadrao);
			oFolha.setSegCiclominimo(registro.consolidacao.cicloPadraoVarMin);
			oFolha.setSegCiclotimeout(registro.consolidacao.cicloPadraoVarMax);
			oFolha.setDtRevisao(registro.consolidacao.dthrIValCic);

			DwFolharap ofRap = new DwFolharap();
			ofRap.setDwFolharapcoms(new HashSet<DwFolharapcom>());

			Set<DwConsolpr> listaProdutos = new HashSet<DwConsolpr>();
			if (isJoinProdutos) {
				listaProdutos =
						getProdutosConsolidacao(dwc, filtro.getTpId(), registro.dtTurno, registro.cdTurno, registro.dthrIniHora,
								registro.consolidacao.cdInjetora, registro.consolidacao.nrop, registro.consolidacao.cdMolde,
								registro.consolidacao.cdEstrutura, registro.consolidacao.dthrIValEstru, registro.consolidacao.dthrIValCic);
				for (DwConsolpr cpr : listaProdutos) {
					DwRap rap = new DwRap();
					rap.setCdRap(oFolha.getCdFolha());
					rap.setDsRap(rap.getCdRap());

					DwFolharapcom ofRapCom = new DwFolharapcom();
					ofRapCom.setQtAtiva(cpr.getPcsManuProducaorefugada());
					ofRapCom.setQtTotal(cpr.getPcsManuProducaobruta());
					ofRapCom.setOmProduto(cpr.getOmProduto());

					ofRap.setDwRap(rap);
					ofRap.getDwFolharapcoms().add(ofRapCom);

					cpr.setPcsManuProducaobruta(null);
					cpr.setPcsManuProducaorefugada(null);
				}
			} else {
				DwRap rap = new DwRap();
				rap.setCdRap(oFolha.getCdFolha());
				rap.setDsRap(rap.getCdRap());

				DwFolharapcom ofRapCom = new DwFolharapcom();
				ofRapCom.setQtAtiva(registro.consolidacao.qtPcsCicloAtivas);
				ofRapCom.setQtTotal(registro.consolidacao.qtPcsCicloTotais);
				ofRapCom.setOmProduto(new OmProduto());

				ofRap.setDwRap(rap);
				ofRap.getDwFolharapcoms().add(ofRapCom);
			}

			oFolha.getDwFolharaps().add(ofRap);
			dwci.setDwFolha(oFolha);

			// consol - tempos
			dwc.setDwConsolprs(listaProdutos);
			dwc.setSegAutoBoas(registro.consolidacao.segTmpCicNormal.subtract(registro.consolidacao.segTmpRefugo));
			dwc.setSegAutoCicloprodutivo(registro.consolidacao.segTmpCicNormal);
			dwc.setSegAutoCicloimprodutivo(registro.consolidacao.segTmpCicFinPar);
			dwc.setSegAutoCiclomedio(registro.consolidacao.segCicloMedio);
			dwc.setSegAutoCiclopadrao(registro.consolidacao.cicloPadrao);
			dwc.setSegAutoPerdacav(registro.consolidacao.segTmpPcsPorCic);
			dwc.setSegAutoPerdaciclo(registro.consolidacao.segTmpRitmo);
			dwc.setSegAutoTempoparadaCp(registro.consolidacao.segTmpParCP);
			dwc.setSegAutoTempoparadaSp(registro.consolidacao.segTmpParSP);
			dwc.setSegAutoTemporefugadas(registro.consolidacao.segTmpRefugo);
			dwc.setSegAutoTempoativo(registro.consolidacao.segTmpCicNormal.add(registro.consolidacao.segTmpCicFinPar)
					.add(registro.consolidacao.segTmpParCP));
			dwc.setSegAutoTempoprodutivo(
					registro.consolidacao.segTmpCicNormal.subtract(registro.consolidacao.segTmpRefugo)
							.subtract(registro.consolidacao.segTmpPcsPorCic).subtract(registro.consolidacao.segTmpRitmo));
			dwc.setSegAutoTempotrabalhado(registro.consolidacao.segTmpCicNormal.add(registro.consolidacao.segTmpCicFinPar));

			if (filtro.getTpId().equals(DetalheMonitorizacaoPTInjetRN.PERIODO_CONSOLIDACAO_TURNO)) {
				dwc.setSegAutoTempocalendario(DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodo(dthrITur, dthrFTur, 0));
			} else {
				dwc.setSegAutoTempocalendario(
						DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodo(registro.dthrIniHora, registro.dthrFimHora, 0));
			}

			if (dwc.getSegAutoTempoprodutivo().doubleValue() < 0) {
				dwc.setSegAutoTempoprodutivo(BigDecimal.ZERO);
			}
			// consol - qtdes
			dwc.setPcsAutoPerdaciclo(registro.consolidacao.pcsPerdaRitmo);
			dwc.setPcsAutoPerdacavidades(registro.consolidacao.pcsPerdaPcsPorCic);
			dwc.setPcsAutoCavAtivas(registro.consolidacao.pcsSumPcsCicAtivas);
			dwc.setPcsAutoCavTotal(registro.consolidacao.pcsSumPcsCicTotais);
			dwc.setPcsAutoPerdaparadaCp(registro.consolidacao.pcsPerdaParCP);
			dwc.setPcsAutoPerdaparadaSp(registro.consolidacao.pcsPerdaParSP);
			dwc.setPcsAutoProducaobruta(registro.consolidacao.pcsProdBruta);
			dwc.setPcsAutoProducaoprevista(registro.consolidacao.pcsProdPrev);
			dwc.setPcsAutoProducaorefugada(registro.consolidacao.pcsProdRef);

			dwc.setQtAutoCavativas(registro.consolidacao.qtPcsCicloAtivas);
			dwc.setQtAutoCavtotal(registro.consolidacao.qtPcsCicloTotais);

			dwc.setQtAutoCicloprodutivo(registro.consolidacao.qtCicNormal);
			dwc.setQtAutoCicloimprodutivo(registro.consolidacao.qtCicFinPar);

			dwc.setSegAutoTempoparadamtbf(registro.consolidacao.segTmpParMTBF);
			dwc.setQtAutoOcoparadamtbf(registro.consolidacao.qtParMTBF);

			dwc.setSegAutoRitmo(registro.consolidacao.segTmpRitmo);
			
			// dwc.setQtAutoOcoparadaCp(BigDecimal.ZERO);
			// dwc.setQtAutoOcoparadaSp(BigDecimal.ZERO);

			DwCal cal = getAgendaAtualInjet();
			dwci.setDwCal(cal);

			Set<DwRtcic> listaCiclos = new HashSet<DwRtcic>();
			if (isJoinCiclos) {
				Date dthrIni;
				Date dthrFim;

				if (filtro.getTpId().equals(DetalheMonitorizacaoPTInjetRN.PERIODO_CONSOLIDACAO_TURNO)) {
					dthrIni = dthrITur;
					dthrFim = dthrFTur;
				} else {
					dthrIni = registro.dthrIniHora;
					dthrFim = registro.dthrFimHora;
				}
				listaCiclos = getCiclosConsolidacao(dwci, dthrIni, dthrFim, registro.consolidacao.cdInjetora, registro.consolidacao.nrop,
						registro.consolidacao.cdMolde, registro.consolidacao.cdEstrutura, registro.consolidacao.dthrIValEstru,
						registro.consolidacao.dthrIValCic);
			}

			Set<DwConsolpa> listaParadas = new HashSet<DwConsolpa>();
			if (isJoinParada) {
				listaParadas = getParadasConsolidacao(dwc, filtro.getTpId(), registro.dtTurno, registro.cdTurno, registro.dthrIniHora,
						registro.consolidacao.cdInjetora, registro.consolidacao.nrop, registro.consolidacao.cdMolde,
						registro.consolidacao.cdEstrutura,
						registro.consolidacao.dthrIValEstru, registro.consolidacao.dthrIValCic, filtro.getDwtarea(), filtro.getDwTParada());
			}
			dwc.setDwConsolpas(listaParadas);

			dwci.getDwRt().setDwRtcics(listaCiclos);
			dwc.setDwConsolid(dwci);
			dwci.setDwConsols(new HashSet<DwConsol>());
			dwci.getDwConsols().add(dwc);

			listaretorno.add(dwci);

		}

		return listaretorno;

	}

	protected List<DwConsolid> getDwConsolid(IdwLogger log, Byte tpId, OmPt omPt, PpCp ppCp, DwTurno dwTurno, DwTParada dwTParada,
			DwTArea dwtarea, Date dtReferencia, Date dtRefIni, Date dtRefFim, Date dthrIturno, Date dthrFturno, Date dthrIhora,
			Date dthrFhora, boolean isJoinParada, boolean isJoinCiclos, boolean isJoinProdutos, int limiteMaxResult, OmGt omGt,
			boolean isJoinCicloPadrao, boolean isJoinPcPorCiclo) {

		List<FiltroProducaoPtCpDTO> listaFiltroProducaoPtCp = new ArrayList<FiltroProducaoPtCpDTO>();

		if (omPt != null || ppCp != null) {
			FiltroProducaoPtCpDTO filtro = new FiltroProducaoPtCpDTO();
			filtro.setOmPt(omPt);
			filtro.setPpCp(ppCp);
			listaFiltroProducaoPtCp.add(filtro);
		}

		return getDwConsolid(log, tpId, dwTurno, dwTParada, dwtarea, dtReferencia, dtRefIni, dtRefFim, dthrIhora,
				dthrFhora, isJoinParada, isJoinCiclos, 0, omGt, listaFiltroProducaoPtCp);

	}

	@SuppressWarnings({ "unused", "unchecked" })
	private Set<DwConsolpr> getProdutosConsolidacao(DwConsol dwc, Byte tpId, Date dtTurno, String cdTurno, Date dtHrIniHora,
			String cdInjetora, String nrOP,
			String cdMolde, String cdEstrutura, Date dthrIValEstru, Date dthrIValCic) {
		String strSQL = "";

		Set<DwConsolpr> listaProdutos = new HashSet<DwConsolpr>();

		byte _cdProduto = 0;
		byte _dsProduto = 1;
		byte _prodPlan = 2;
		byte _prodBruta = 3;
		byte _prodRef = 4;
		byte _prodPrev = 5;
		byte _prodPerdaRitmo = 6;
		byte _prodPerdaPcsCiclo = 7;
		byte _prodPerdaParCP = 8;
		byte _prodPerdaParSP = 9;
		byte _qtPcsCicAtivas = 10;
		byte _qtPcsCicTotais = 11;
		byte _gPesoBruto = 12;
		byte _gPesoLiquido = 13;
		byte _valorUnitario = 14;

		class RegistroLido {
			String cdProduto;
			String dsProduto;
			BigDecimal prodPlan = BigDecimal.ZERO;
			BigDecimal prodBruta = BigDecimal.ZERO;
			BigDecimal prodRef = BigDecimal.ZERO;
			BigDecimal prodPrev = BigDecimal.ZERO;
			BigDecimal prodPerdaRitmo = BigDecimal.ZERO;
			BigDecimal prodPerdaPcsCiclo = BigDecimal.ZERO;
			BigDecimal prodPerdaParCP = BigDecimal.ZERO;
			BigDecimal prodPerdaParSP = BigDecimal.ZERO;
			BigDecimal qtPcsCicAtivas = BigDecimal.ZERO;
			BigDecimal qtPcsCicTotais = BigDecimal.ZERO;
			BigDecimal gPesoBruto = BigDecimal.ZERO;
			BigDecimal gPesoLiquido = BigDecimal.ZERO;
			BigDecimal valorUnitario = BigDecimal.ZERO;
		}

		strSQL = strSQL.concat("SELECT e.cdproduto, e.dsproduto, ");
		strSQL = strSQL.concat("       g.qtpecasproduzir as prodplan, ");
		strSQL = strSQL.concat("       ((a.qtinjnormal * d.qtcavativas) + (a.qtprodpkgcic * d.indcav)) as prodbruta, ");
		strSQL = strSQL.concat("       (CASE WHEN f.qtpcsref IS NULL THEN 0 ELSE f.qtpcsref END) as prodrefugada, ");
		strSQL = strSQL.concat(
				"       (FLOOR((a.tmpcicnormal + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END))/ h.ciclopadrao) * d.qtcavativas * h.fatorcontagemprod) as prodprev, ");
		strSQL = strSQL.concat(
				"       ( ((((a.tmpcicnormal + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END)) / h.ciclopadrao) - a.qtinjnormal ) * (d.qtcavativas * h.fatorcontagemprod) ) ) as prodperdaritmo,  ");
		strSQL = strSQL.concat("       (a.qtinjnormal * ( (d.qtcavidades - d.qtcavativas) * h.fatorcontagemprod) ) AS prodperdapcscic, ");
		strSQL = strSQL.concat("       (FLOOR(a.tmpparadas / h.ciclopadrao) * d.qtcavativas * h.fatorcontagemprod) as prodperdaparCP, ");
		strSQL = strSQL
				.concat("       (FLOOR(a.TmpParadasSemPeso / h.ciclopadrao) * d.qtcavativas * h.fatorcontagemprod) as prodperdaparSP, ");
		strSQL = strSQL.concat("       d.qtcavativas, d.qtcavidades,  d.pbrutomedio, d.pliquidomedio, e.vlproduto ");

		if (tpId == PERIODO_CONSOLIDACAO_HORA) {
			strSQL = strSQL.concat("  FROM ijcnsUT a ");
		} else {
			strSQL = strSQL.concat("  FROM ijcnsturno a ");
		}

		strSQL = strSQL.concat("  LEFT JOIN IJtbFRESH ct ON (1=1) ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL
				.concat("  JOIN ijmolpro c ON (c.cdmolde = a.cdmolde and c.cdestrutura = a.cdestrutura and c.dthrival = a.dthrivalestru) ");
		strSQL = strSQL.concat(
				"  JOIN viewmolproindcav d ON (d.cdmolde = c.cdmolde AND d.cdestrutura = c.cdestrutura AND d.dthrival = c.dthrival AND d.cdidentificacao = c.cdidentificacao) ");
		strSQL = strSQL.concat("  JOIN ijtbpro e ON (e.cdproduto = d.cdproduto) ");
		strSQL = strSQL.concat(
				"  JOIN ijopprodutos g ON (g.nrop = a.nrop AND g.cdmolde = a.cdmolde AND g.cdestrutura = a.cdestrutura AND g.cdproduto = c.cdproduto) ");
		strSQL = strSQL.concat(
				"  JOIN ijfictec h ON (h.cdinjetora = a.cdinjetora AND h.cdmolde = a.cdmolde AND h.cdestrutura = a.cdestrutura AND h.dthrivalcic = a.dthrivalcic) ");

		if (tpId == PERIODO_CONSOLIDACAO_HORA) {
			strSQL = strSQL.concat("  LEFT JOIN ijcnsUTdetref f ON (f.dthriniintervalo = a.dthriniintervalo AND  ");

		} else {
			strSQL = strSQL.concat("  LEFT JOIN ijcnsturnodetref f ON (f.dtturno = a.dtturno AND  ");
			strSQL = strSQL.concat("                                   f.cdturno = a.cdturno AND   ");
		}

		strSQL = strSQL.concat("                                   f.cdinjetora = a.cdinjetora AND ");
		strSQL = strSQL.concat("                                   f.nrop = a.nrop AND  ");
		strSQL = strSQL.concat("                                   f.cdmolde = a.cdmolde AND  ");
		strSQL = strSQL.concat("                                   f.cdestrutura = a.cdestrutura AND ");
		strSQL = strSQL.concat("                                   f.dthrivalestru = a.dthrivalestru AND ");
		strSQL = strSQL.concat("                                   f.dthrivalcic = a.dthrivalcic AND ");
		strSQL = strSQL.concat("                                   f.cdidentificacao = c.cdidentificacao) ");

		if (tpId == PERIODO_CONSOLIDACAO_HORA) {
			strSQL = strSQL.concat(" WHERE a.dthriniintervalo = :dthrihora ");
		} else {
			strSQL = strSQL.concat(" WHERE a.dtturno = :dtturno ");
			strSQL = strSQL.concat("   AND a.cdturno = :cdturno ");
		}

		strSQL = strSQL.concat("   AND a.cdinjetora = :cdinjetora ");
		strSQL = strSQL.concat("   AND a.nrop = :nrop ");
		strSQL = strSQL.concat("   AND a.cdmolde = :cdmolde ");
		strSQL = strSQL.concat("   AND a.cdestrutura = :cdestrutura ");
		strSQL = strSQL.concat("   AND a.dthrivalestru = :dthrivalestru ");
		strSQL = strSQL.concat("   AND a.dthrivalcic = :dthrivalcic ");

		List<Object> lista = new ArrayList<Object>();

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

		if (tpId == PERIODO_CONSOLIDACAO_HORA) {
			q.setTimestamp("dthrihora", dtHrIniHora);

		} else {
			q.setTimestamp("dtturno", dtTurno)
					.setString("cdturno", cdTurno);
		}

		q.setString("cdinjetora", cdInjetora)
				.setString("nrop", nrOP)
				.setString("cdmolde", cdMolde)
				.setString("cdestrutura", cdEstrutura)
				.setTimestamp("dthrivalestru", dthrIValEstru)
				.setTimestamp("dthrivalcic", dthrIValCic);

		lista = q.list();

		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdProduto = (String) registroLido[_cdProduto];
			registro.dsProduto = (String) registroLido[_dsProduto];
			
			registro.prodPlan = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPlan]));
			registro.prodBruta = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodBruta]));
			registro.prodRef = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodRef]));
			registro.prodPrev = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPrev]));
			registro.prodPerdaRitmo =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPerdaRitmo]));
			registro.prodPerdaPcsCiclo =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPerdaPcsCiclo]));
			registro.prodPerdaParCP =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPerdaParCP]));
			registro.prodPerdaParSP =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPerdaParSP]));
			registro.qtPcsCicAtivas =
					ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtPcsCicAtivas]));
			registro.qtPcsCicTotais =
					ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtPcsCicTotais]));
			
			registro.gPesoBruto = ConversaoTipos.converterParaBigDecimal(registroLido[_gPesoBruto]);
			registro.gPesoLiquido = ConversaoTipos.converterParaBigDecimal(registroLido[_gPesoLiquido]);
			registro.valorUnitario = ConversaoTipos.converterParaBigDecimal(registroLido[_valorUnitario]);

			DwConsolpr cpr = new DwConsolpr();

			OmProduto pro = new OmProduto();
			pro.setCdProduto(registro.cdProduto);
			pro.setDsProduto(registro.dsProduto);
			pro.setGPesoBruto(registro.gPesoBruto);
			pro.setGPesoLiquido(registro.gPesoLiquido);
			pro.setVlCustounit(registro.valorUnitario);
			
			cpr.setIdConsolpr(null);
			cpr.setOmProduto(pro);
			cpr.setPcsAutoProducaobruta(registro.prodBruta);
			cpr.setPcsAutoProducaorefugada(registro.prodRef);
			cpr.setPcsAutoProducaoprevista(registro.prodPrev);
			cpr.setPcsAutoPerdaciclo(registro.prodPerdaRitmo);
			cpr.setPcsAutoPerdacavidades(registro.prodPerdaPcsCiclo);
			cpr.setPcsAutoPerdaparadaCp(registro.prodPerdaParCP);
			cpr.setPcsAutoPerdaparadaSp(registro.prodPerdaParSP);
			// begin pog
			cpr.setPcsManuProducaobruta(registro.qtPcsCicTotais);
			cpr.setPcsManuProducaorefugada(registro.qtPcsCicAtivas);
			// end pog
			cpr.setDwConsol(dwc);

			listaProdutos.add(cpr);
		}

		return listaProdutos;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	private Set<DwRtcic> getCiclosConsolidacao(DwConsolid dwci, Date dthrIni, Date dthrFim, String cdInjetora, String nrOP,
			String cdMolde, String cdEstrutura, Date dthrIValEstru, Date dthrIValCic) {
		String strSQL = "";

		Set<DwRtcic> listaCiclos = new HashSet<DwRtcic>();

		byte _nrop = 0;
		byte _dthrIniCic = 1;
		byte _dthrFimCic = 2;
		byte _segTmpCicLido = 3;
		byte _segTmpCicPadrao = 4;
		byte _cdInjetora = 5;
		byte _cdMolde = 6;
		byte _cdEstrutura = 7;
		byte _dthrIValCic = 8;
		byte _dthrIValEstru = 9;

		class RegistroLido {
			String nrop;
			Date dthrIniCic;
			Date dthrFimCic;
			BigDecimal segTmpCicLido = BigDecimal.ZERO;
			BigDecimal segTmpCicPadrao = BigDecimal.ZERO;
			String cdInjetora;
			String cdMolde;
			String cdEstrutura;
			Date dthrIValCic;
			Date dthrIValEstru;
		}

		strSQL = strSQL.concat(
				"SELECT a.nrop, a.DtHrICiclo, a.DtHrFCiclo, a.TmpCicloLido, a.TmpCicPadrao, a.cdinjetora, a.cdmolde, a.cdestrutura, a.DtHrIValEstru, a.DtHrIValCic ");
		strSQL = strSQL.concat("  FROM ijreacicop a ");
		strSQL = strSQL.concat(" WHERE a.nrop = a.nrop ");
		strSQL = strSQL.concat("   AND ( (a.DtHrICiclo BETWEEN :dthrIni AND :dthrFim) OR ");
		strSQL = strSQL.concat("         (a.DtHrFCiclo BETWEEN :dthrIni AND :dthrFim) OR ");
		strSQL = strSQL.concat("         (:dthrIni BETWEEN a.DtHrICiclo AND a.DtHrFCiclo) ) ");
		strSQL = strSQL.concat("   AND a.cdinjetora = :cdinjetora ");
		strSQL = strSQL.concat("   AND a.nrop = :nrop ");
		strSQL = strSQL.concat("   AND a.cdmolde = :cdmolde ");
		strSQL = strSQL.concat("   AND a.cdestrutura = :cdestrutura ");
		strSQL = strSQL.concat("   AND a.dthrivalestru = :dthrivalestru ");
		strSQL = strSQL.concat("   AND a.dthrivalcic = :dthrivalcic ");

		List<Object> lista = new ArrayList<Object>();

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

		q.setTimestamp("dthrIni", dthrIni)
				.setTimestamp("dthrFim", dthrFim)
				.setString("cdinjetora", cdInjetora)
				.setString("nrop", nrOP)
				.setString("cdmolde", cdMolde)
				.setString("cdestrutura", cdEstrutura)
				.setTimestamp("dthrivalestru", dthrIValEstru)
				.setTimestamp("dthrivalcic", dthrIValCic);

		lista = q.list();

		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.nrop = (String) registroLido[_nrop];
			registro.dthrIniCic = (Date) registroLido[_dthrIniCic];
			registro.dthrFimCic = (Date) registroLido[_dthrFimCic];
			registro.segTmpCicLido = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpCicLido]);
			registro.segTmpCicPadrao = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpCicPadrao]);
			registro.cdInjetora = (String) registroLido[_cdInjetora];
			registro.cdMolde = (String) registroLido[_cdMolde];
			registro.cdEstrutura = (String) registroLido[_cdEstrutura];
			registro.dthrIValCic = (Date) registroLido[_dthrIValCic];
			registro.dthrIValEstru = (Date) registroLido[_dthrIValEstru];

			DwRtcic regCic = new DwRtcic();
			regCic.setDwRt(dwci.getDwRt());
			regCic.setDthrIciclo(registro.dthrIniCic);
			regCic.setMsDthriciclo((byte) 0);
			regCic.setDthrFciclo(registro.dthrFimCic);
			regCic.setMsDthrfciclo((byte) 0);
			regCic.setSegDuracao(registro.segTmpCicLido);
			regCic.setIsRegulagem(false);
			regCic.setDwFolha(dwci.getDwFolha());
			regCic.setPpCp(dwci.getPpCp());

			listaCiclos.add(regCic);
		}

		return listaCiclos;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	private Set<DwConsolpa> getParadasConsolidacao(DwConsol dwc, Byte tpId, Date dtTurno, String cdTurno, Date dtHrIniHora,
			String cdInjetora, String nrOP,
			String cdMolde, String cdEstrutura, Date dthrIValEstru, Date dthrIValCic, DwTArea dwtarea, DwTParada dwtparada) {

		DiversosInjetRN ijRN = new DiversosInjetRN(getDao());

		String strSQL = "";

		Set<DwConsolpa> listaParadas = new HashSet<DwConsolpa>();

		int _dtTurno = 0;
		int _cdTurno = 1;
		int _dthrIniHora = 0;

		int _dthrIniPar = (tpId == PERIODO_CONSOLIDACAO_HORA ? _dthrIniHora : _cdTurno) + 1;
		int _dthrFimPar = _dthrIniPar + 1;
		int _nrop = _dthrFimPar + 1;
		int _nropExibicao = _nrop + 1;
		int _cdInjetora = _nropExibicao + 1;
		int _cdInjEstendido = _cdInjetora + 1;
		int _cdMolde = _cdInjEstendido + 1;
		int _cdMolEstendido = _cdMolde + 1;
		int _cdEstrutura = _cdMolEstendido + 1;
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
		int _cdCausa = _pcsPerdaParSP + 1;
		int _dsCausa = _cdCausa + 1;
		int _cdAcao = _dsCausa + 1;
		int _dsAcao = _cdAcao + 1;
		int _cdJust = _dsAcao + 1;
		int _dsJust = _cdJust + 1;
		int _cdTec1 = _dsJust + 1;
		int _nmAcessoTec1 = _cdTec1 + 1;
		int _nmTec1 = _nmAcessoTec1 + 1;
		int _cdTec2 = _nmTec1 + 1;
		int _nmAcessoTec2 = _cdTec2 + 1;
		int _nmTec2 = _nmAcessoTec2 + 1;
		int _cdTecR = _nmTec2 + 1;
		int _nmAcessoTecR = _cdTecR + 1;
		int _nmTecR = _nmAcessoTecR + 1;

		class RegistroLido {
			Date dtTurno;
			String cdTurno;
			Date dthrIniHora;
			Date dthrIniPar;
			Date dthrFimPar;
			String nrop;
			String nropExibicao;
			String cdInjetora;
			String cdInjEstendido;
			String cdMolde;
			String cdMolEstendido;
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
			String cdCausa;
			String dsCausa;
			String cdAcao;
			String dsAcao;
			String cdJust;
			String dsJust;
			String cdTec1;
			String nmAcessoTec1;
			String nmTec1;
			String cdTec2;
			String nmAcessoTec2;
			String nmTec2;
			String cdTecR;
			String nmAcessoTecR;
			String nmTecR;
		}

		if (tpId == PERIODO_CONSOLIDACAO_HORA) {
			strSQL = strSQL.concat("SELECT a.dthriniintervalo, ");
		} else {
			strSQL = strSQL.concat("SELECT a.dtturno, a.cdturno, ");
		}

		strSQL = strSQL.concat("a.dthripar, a.dthrfpar, ");
		strSQL = strSQL.concat("a.nrop, r.nropexibicao, ");
		strSQL = strSQL.concat("i.cdinjetora, i.cdinjestendido, ");
		strSQL = strSQL.concat("m.cdmolde, m.cdmolestendido, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, ");
		strSQL = strSQL.concat("b.cdparada, b.dsparada, c.cdarea, c.dsarea, ");
		strSQL = strSQL.concat("a.tmpparadas, a.tmpparadassempeso, ");
		strSQL = strSQL.concat("( ( a.tmpparadas / ft.ciclopadrao) * (c2.qtcavativas * ft.fatorcontagemprod) ) as qtdperdasparCP,  ");
		strSQL = strSQL.concat("( ( a.tmpparadassempeso / ft.ciclopadrao) * (c2.qtcavativas * ft.fatorcontagemprod) ) as qtdperdasparSP, ");
		strSQL = strSQL.concat("cau.cdcausas, cau.dscausas, aco.cdacoes, aco.dsacoes, jup.cdjustparada, jup.dsjustparada, ");
		strSQL = strSQL.concat("u1.cdusuario as cdusutec1, u1.nmacesso as nmacessotec1, u1.nmusuario as nmusutec1, ");
		strSQL = strSQL.concat("u2.cdusuario as cdusutec2, u2.nmacesso as nmacessotec2, u2.nmusuario as nmusutec2, ");
		strSQL = strSQL.concat("ur.cdusuario as cdusutecr, ur.nmacesso as nmacessotecr, ur.nmusuario as nmusutecr ");

		if (tpId == PERIODO_CONSOLIDACAO_HORA) {
			strSQL = strSQL.concat("  FROM ijreaparcnsocorUT a ");
		} else {
			strSQL = strSQL.concat("  FROM ijreaparcnsocorTUR a ");
		}

		strSQL = strSQL.concat(" JOIN ijoproteiro r ON (r.nrop = a.nrop) ");
		strSQL = strSQL.concat(" JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat(" JOIN ijtbmol m ON (m.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat(" JOIN ijtbpar b ON (b.cdparada = a.cdparada) ");
		strSQL = strSQL.concat(" JOIN ijareres c ON (c.cdarea = b.cdarea) ");
		strSQL = strSQL.concat(
				" JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL.concat(
				" JOIN cavidades2 c2 ON (c2.cdmolde = a.cdmolde AND c2.cdestrutura = a.cdestrutura AND c2.dthrival = a.dthrivalestru) ");
		strSQL = strSQL.concat(" LEFT JOIN ijtbcau cau ON (cau.cdcausas = a.cdcausas) ");
		strSQL = strSQL.concat(" LEFT JOIN ijtbaco aco ON (aco.cdacoes = a.cdacoes) ");
		strSQL = strSQL.concat(" LEFT JOIN ijtbjup jup ON (jup.cdjustparada = a.cdjustparada) ");
		strSQL = strSQL.concat(" LEFT JOIN ijtbusu u1 ON (u1.cdusuario = a.drtecnico1) ");
		strSQL = strSQL.concat(" LEFT JOIN ijtbusu u2 ON (u2.cdusuario = a.drttecnico2) ");
		strSQL = strSQL.concat(" LEFT JOIN ijtbusu ur ON (ur.cdusuario = a.drtresponsa) ");

		if (tpId == PERIODO_CONSOLIDACAO_HORA) {
			strSQL = strSQL.concat(" WHERE a.dthriniintervalo = :dthrihora ");

		} else {
			strSQL = strSQL.concat(" WHERE a.dtturno = :dtturno ");
			strSQL = strSQL.concat("   AND a.cdturno = :cdturno ");
		}

		strSQL = strSQL.concat("   AND a.cdinjetora = :cdinjetora ");
		strSQL = strSQL.concat("   AND a.nrop = :nrop ");
		strSQL = strSQL.concat("   AND a.cdmolde = :cdmolde ");
		strSQL = strSQL.concat("   AND a.cdestrutura = :cdestrutura ");
		strSQL = strSQL.concat("   AND a.dthrivalestru = :dthrivalestru ");
		strSQL = strSQL.concat("   AND a.dthrivalcic = :dthrivalcic ");

		if (dwtparada != null) {
			strSQL = strSQL.concat("   AND b.cdparada = :cdparada ");
		}

		if (dwtarea != null) {
			strSQL = strSQL.concat("   AND c.cdarea = :cdarea ");
		}

		List<Object> lista = new ArrayList<Object>();

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

		if (tpId == PERIODO_CONSOLIDACAO_HORA) {
			q.setTimestamp("dthrihora", dtHrIniHora);
		} else {
			q.setTimestamp("dtturno", dtTurno)
					.setString("cdturno", cdTurno);
		}

		if (dwtparada != null) {
			q.setString("cdparada", dwtparada.getCdTparada());
		}

		if (dwtarea != null) {
			q.setString("cdarea", dwtarea.getCdArea());
		}

		q.setString("cdinjetora", cdInjetora)
				.setString("nrop", nrOP)
				.setString("cdmolde", cdMolde)
				.setString("cdestrutura", cdEstrutura)
				.setTimestamp("dthrivalestru", dthrIValEstru)
				.setTimestamp("dthrivalcic", dthrIValCic);

		lista = q.list();

		Map<String, DwConsolpa> mapPa = new HashMap<String, DwConsolpa>();

		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			if (tpId == PERIODO_CONSOLIDACAO_HORA) {
				registro.dthrIniHora = (Date) registroLido[_dthrIniHora];
			} else {
				registro.dtTurno = (Date) registroLido[_dtTurno];
				registro.cdTurno = (String) registroLido[_cdTurno];
			}
			registro.dthrIniPar = (Date) registroLido[_dthrIniPar];
			registro.dthrFimPar = (Date) registroLido[_dthrFimPar];
			registro.nrop = (String) registroLido[_nrop];
			registro.nropExibicao = (String) registroLido[_nropExibicao];
			registro.cdInjetora = (String) registroLido[_cdInjetora];
			registro.cdInjEstendido = (String) registroLido[_cdInjEstendido];
			registro.cdMolde = (String) registroLido[_cdMolde];
			registro.cdMolEstendido = (String) registroLido[_cdMolEstendido];
			registro.cdEstrutura = (String) registroLido[_cdEstrutura];
			registro.dthrIValEstru = (Date) registroLido[_dthrIValEstru];
			registro.dthrIValCic = (Date) registroLido[_dthrIValCic];

			registro.cdParada = (String) registroLido[_cdParada];
			registro.dsParada = (String) registroLido[_dsParada];
			registro.cdArea = (String) registroLido[_cdArea];
			registro.dsArea = (String) registroLido[_dsArea];

			registro.cdCausa = (String) registroLido[_cdCausa];
			registro.dsCausa = (String) registroLido[_dsCausa];
			registro.cdAcao = (String) registroLido[_cdAcao];
			registro.dsAcao = (String) registroLido[_dsAcao];
			registro.cdJust = (String) registroLido[_cdJust];
			registro.dsJust = (String) registroLido[_dsJust];

			if (registroLido[_cdTec1] != null) {
				registro.cdTec1 = (String) registroLido[_cdTec1];
				registro.nmAcessoTec1 = (String) registroLido[_nmAcessoTec1];
				registro.nmTec1 = (String) registroLido[_nmTec1];
			}

			if (registroLido[_cdTec2] != null) {
				registro.cdTec2 = (String) registroLido[_cdTec2];
				registro.nmAcessoTec2 = (String) registroLido[_nmAcessoTec2];
				registro.nmTec2 = (String) registroLido[_nmTec2];
			}

			if (registroLido[_cdTecR] != null) {
				registro.cdTecR = (String) registroLido[_cdTecR];
				registro.nmAcessoTecR = (String) registroLido[_nmAcessoTecR];
				registro.nmTecR = (String) registroLido[_nmAcessoTecR];
			}

			registro.segTmpParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParCP]);
			registro.segTmpParSP = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParSP]);
			registro.pcsPerdaParCP =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParCP]));
			registro.pcsPerdaParSP =
					ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsPerdaParSP]));

			DwTArea area = new DwTArea();
			area.setCdArea(registro.cdArea);
			area.setDsArea(registro.dsArea);

			DwTParada par = new DwTParada();
			par.setCdTparada(registro.cdParada);
			par.setDsTparada(registro.dsParada);
			par.setIsPesa(registro.segTmpParCP.doubleValue() > 0);
			par.setDwTArea(area);

			DwTCausa causa = null;
			DwTAcao acao = null;
			DwTJust just = null;

			DwConsolpaoco paOco = new DwConsolpaoco();
			if (registro.cdCausa != null) {
				causa = new DwTCausa();
				causa.setCdTcausa(registro.cdCausa);
				causa.setDsTcausa(registro.dsCausa);
				paOco.setDwTCausa(causa);
			}

			if (registro.cdAcao != null) {
				acao = new DwTAcao();
				acao.setCdTacao(registro.cdAcao);
				acao.setDsTacao(registro.dsAcao);
				paOco.setDwTAcao(acao);
			}

			if (registro.cdJust != null) {
				just = new DwTJust();
				just.setCdTjust(registro.cdJust);
				just.setDsTjust(registro.dsJust);
				paOco.setDwTJust(just);
			}

			paOco.setDthrIparada(registro.dthrIniPar);
			paOco.setDthrFparada(registro.dthrFimPar);
			paOco.setPcsAutoPerdaparadaCp(registro.pcsPerdaParCP);
			paOco.setPcsAutoPerdaparadaSp(registro.pcsPerdaParSP);

			DwConsolpalog paLog = new DwConsolpalog();
			paLog.setDwTParada(par);
			paLog.setDwTCausa(causa);
			paLog.setDwTAcao(acao);
			paLog.setDwTJust(just);
			paLog.setDthrIparada(registro.dthrIniPar);
			paLog.setDthrFparada(registro.dthrFimPar);
			paLog.setDwConsolpalogtecs(new HashSet<DwConsolpalogtec>());
			paLog.setDwConsolpaocos(new HashSet<DwConsolpaoco>());
			paLog.setSegAutoTempoparadaCp(registro.segTmpParCP);
			paLog.setSegAutoTempoparadaSp(registro.segTmpParSP);

			if (registro.cdTec1 != null) {
				OmUsr usr = new OmUsr();
				usr.setCdUsr(registro.cdTec1);
				usr.setDsNome(registro.nmTec1);
				usr.setDsApelido(registro.nmAcessoTec1);

				DwConsolpalogtec paTec = new DwConsolpalogtec();
				
				paTec.setOmUsr(usr);
				paTec.setTpUsuario(DwConsolpalogtecTemplate._TpUsuario.TEC1.getValue());
				paLog.getDwConsolpalogtecs().add(paTec);
			}

			if (registro.cdTec2 != null) {
				OmUsr usr = new OmUsr();
				usr.setCdUsr(registro.cdTec2);
				usr.setDsNome(registro.nmTec2);
				usr.setDsApelido(registro.nmAcessoTec2);

				DwConsolpalogtec paTec = new DwConsolpalogtec();
				paTec.setTpUsuario(DwConsolpalogtecTemplate._TpUsuario.TEC2.getValue());
				paTec.setOmUsr(usr);

				paLog.getDwConsolpalogtecs().add(paTec);
			}

			if (registro.cdTecR != null) {
				OmUsr usr = new OmUsr();
				usr.setCdUsr(registro.cdTecR);
				usr.setDsNome(registro.nmTecR);
				usr.setDsApelido(registro.nmAcessoTecR);

				DwConsolpalogtec paTec = new DwConsolpalogtec();
				paTec.setTpUsuario(DwConsolpalogtecTemplate._TpUsuario.TECRESP.getValue());
				paTec.setOmUsr(usr);

				paLog.getDwConsolpalogtecs().add(paTec);
			}
			paOco.setDwConsolpalog(paLog);

			String keyPa = "";
			if (tpId == PERIODO_CONSOLIDACAO_HORA) {
				keyPa = registro.dthrIniHora.toString();
			} else {
				keyPa = registro.dtTurno.toString() + registro.cdTurno;
			}
			keyPa = keyPa.concat(registro.cdInjetora);
			keyPa = keyPa.concat(registro.cdMolde);
			keyPa = keyPa.concat(registro.cdEstrutura);
			keyPa = keyPa.concat(registro.dthrIValEstru.toString());
			keyPa = keyPa.concat(registro.dthrIValCic.toString());
			keyPa = keyPa.concat(registro.cdParada);

			if (mapPa.containsKey(keyPa)) {
				DwConsolpa regPa = new DwConsolpa();
				regPa = mapPa.get(keyPa);
				mapPa.remove(keyPa);

				regPa.getDwConsolpaocos().add(paOco);
				regPa.setPcsAutoPerdaparadaCp(regPa.getPcsAutoPerdaparadaCp().add(registro.pcsPerdaParCP));
				regPa.setPcsAutoPerdaparadaSp(regPa.getPcsAutoPerdaparadaSp().add(registro.pcsPerdaParSP));
				regPa.setQtAutoOcoparadaCp(
						regPa.getQtAutoOcoparadaCp().add(registro.segTmpParCP.doubleValue() != 0d ? BigDecimal.ONE : BigDecimal.ZERO));
				regPa.setQtAutoOcoparadaSp(
						regPa.getQtAutoOcoparadaSp().add(registro.segTmpParSP.doubleValue() != 0d ? BigDecimal.ONE : BigDecimal.ZERO));
				regPa.setSegAutoTempoparadaCp(regPa.getSegAutoTempoparadaCp().add(registro.segTmpParCP));
				regPa.setSegAutoTempoparadaSp(regPa.getSegAutoTempoparadaSp().add(registro.segTmpParSP));

				mapPa.put(keyPa, regPa);

			} else {
				DwConsolpa regPa = new DwConsolpa();
				regPa.setDwConsolpaocos(new HashSet<DwConsolpaoco>());
				regPa.getDwConsolpaocos().add(paOco);
				regPa.setDwTParada(par);
				regPa.setDwConsol(dwc);
				regPa.setPcsAutoPerdaparadaCp(registro.pcsPerdaParCP);
				regPa.setPcsAutoPerdaparadaSp(registro.pcsPerdaParSP);
				regPa.setQtAutoOcoparadaCp(registro.segTmpParCP.doubleValue() != 0d ? BigDecimal.ONE : BigDecimal.ZERO);
				regPa.setQtAutoOcoparadaSp(registro.segTmpParSP.doubleValue() != 0d ? BigDecimal.ONE : BigDecimal.ZERO);
				regPa.setSegAutoTempoparadaCp(registro.segTmpParCP);
				regPa.setSegAutoTempoparadaSp(registro.segTmpParSP);
				mapPa.put(keyPa, regPa);
			}

		}

		listaParadas.addAll(mapPa.values());

		return listaParadas;
	}

	private String getStringConsultaConsolidacaoInjet(FiltroDetalhePTInjetDTO filtro, List<FiltroProducaoPtCpDTO> listaFiltroProducaoPtCp) {
		String strSQL = "";

		if (filtro.getTpId() == PERIODO_CONSOLIDACAO_HORA) {
			strSQL = strSQL.concat("SELECT a.idregistro, a.dthriniintervalo, a.dthrfimintervalo, ");
		} else {
			strSQL = strSQL.concat("SELECT a.idregistro, a.dtturno, a.cdturno, t.dsturno, ");
		}
		// op
		strSQL = strSQL.concat("a.nrop, rot.nropexibicao, ");

		// info de maq
		strSQL = strSQL.concat("a.cdinjetora, i.cdinjestendido, i.cdidentific, ");

		// fic tec
		strSQL = strSQL.concat("a.dthrivalcic, c.ciclopadrao, c.varmin, c.varmax, c.fatorcontagemprod, ");

		// mol x pro
		strSQL = strSQL.concat("a.dthrivalestru, a.cdmolde, mld.cdmolestendido, a.cdestrutura, d.qtcavativas, d.qtcavidades, ");

		// consolidacoes
		strSQL = strSQL.concat("a.qtinjnormal, a.qtinjfinpar, ");
		strSQL = strSQL.concat(
				"(CASE WHEN a.qtinjnormal IS NULL or a.qtinjnormal = 0 THEN 0 ELSE (a.tmpcicnormal  / a.qtinjnormal) END) as ciclomedio, ");
		strSQL = strSQL.concat("(a.qtprodbrutaUB) as prodbruta, ");
		strSQL = strSQL.concat("(a.qtprodrefugadaUB) as prodref, ");
		strSQL = strSQL.concat("(a.tmpcicnormal) as tmpcicnormal, ");
		strSQL = strSQL.concat("(a.tmpcicfinparada) as tmpcicfinparada, ");
		strSQL = strSQL.concat("(a.tmpparadas) as tmpparadasCP, ");
		strSQL = strSQL.concat("(a.tmpparadassempeso) as tmpparadasSP, ");
		strSQL = strSQL.concat(
				"(FLOOR((CASE WHEN a.tmpativo IS NULL THEN 0 ELSE a.tmpativo END)/ c.ciclopadrao) * (CASE WHEN ct.campo23 = '¬¬ª¿±·¿½­' THEN d.qtcavidades ELSE d.qtcavativas END)  * c.fatorcontagemprod) as prodprev, ");
		strSQL = strSQL.concat("f.prodplanOP, ");
		strSQL = strSQL.concat("((CASE WHEN a.tmpativo IS NULL THEN 0 ELSE a.tmpativo END)) as tmphrsdisp, ");
		strSQL = strSQL.concat("(a.tmpcavidades) as tmpcavidades, ");
		strSQL = strSQL.concat("((CASE WHEN a.tmpprodrefugada IS NULL THEN 0 ELSE a.tmpprodrefugada END)) as tmprefugo, ");
		strSQL = strSQL.concat("( (((a.tmpcicnormal / a.ciclopadrao) - a.qtinjnormal ) * a.ciclopadrao) ) as tmpritmo, ");
		strSQL = strSQL
				.concat("( ( (a.tmpcicnormal / c.ciclopadrao) - a.qtinjnormal) * (d.qtcavativas * c.fatorcontagemprod)) as qtdritmo, ");
		strSQL = strSQL.concat("( (a.qtinjnormal * (d.qtcavidades - d.qtcavativas)) * c.fatorcontagemprod) as qtdperdapcsciclo, ");
		strSQL = strSQL.concat("( a.qtinjnormal * d.qtcavidades) as qtdpcsciclototal, ");
		strSQL = strSQL.concat("( a.qtinjnormal * d.qtcavativas) as qtdpcscicloativas, ");
		strSQL = strSQL.concat("( ( a.tmpparadas / c.ciclopadrao) * (d.qtcavativas * c.fatorcontagemprod) ) as qtdperdasparCP, ");
		strSQL = strSQL.concat("( ( a.tmpparadassempeso / c.ciclopadrao) * (d.qtcavativas * c.fatorcontagemprod) ) as qtdperdasparSP, ");

		// dados para calc de mtbf/mttf
		strSQL = strSQL.concat(" mtbf.tmpparMTBFMTTR, mtbf.qtdparMTBFMTTR ");

		if (filtro.getTpId() == PERIODO_CONSOLIDACAO_HORA) {
			strSQL = strSQL.concat("  FROM viewDadosCalcOEEOPut a ");
		} else {
			strSQL = strSQL.concat("  FROM viewDadosCalcOEEOP a ");
		}

		strSQL = strSQL.concat("  JOIN ijtbfresh ct ON (1=1) ");
		
		// filtro de galpao
		if (filtro.getOmGt() != null) {
			strSQL = strSQL.concat("  JOIN ijgalobj glp ON (glp.cdinjetora = a.cdinjetora AND glp.cdgalpao = :cdgalpao) ");
		}

		// fic tec: ciclo padrao, fator contagem
		strSQL = strSQL.concat(
				"  JOIN ijfictec c ON (c.cdinjetora = a.cdinjetora AND c.cdmolde = a.cdmolde AND c.cdestrutura = a.cdestrutura AND c.dthrivalcic = a.dthrivalcic)");

		// molde x produto: pcs por ciclo
		strSQL = strSQL.concat(
				"  JOIN cavidades2 d ON (d.cdmolde = c.cdmolde AND d.cdestrutura = c.cdestrutura AND d.dthrival = c.dthrivalestru) ");

		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol mld ON (mld.cdmolde = a.cdmolde) ");

		if (filtro.getTpId() == PERIODO_CONSOLIDACAO_TURNO) {
			strSQL = strSQL.concat("  JOIN ijtbtur t ON (t.cdturno = a.cdturno) ");
		}

		strSQL = strSQL.concat("  JOIN ijop op ON (op.nrop = a.nrop) ");
		strSQL = strSQL.concat(
				"  JOIN ijoproteiro rot ON  (rot.nrop = a.nrop AND rot.cdinjetora = a.cdinjetora AND rot.cdmolde = a.cdmolde AND rot.cdestrutura = a.cdestrutura) ");
		strSQL = strSQL
				.concat("  JOIN (SELECT nrop, SUM(qtpecasproduzir) as prodplanOP FROM ijopprodutos GROUP BY nrop) f ON (f.nrop = a.nrop)");

		// dados para calc de mtbf/mttf
		if (filtro.getTpId() == PERIODO_CONSOLIDACAO_HORA) {
			strSQL = strSQL.concat(
					" LEFT JOIN (SELECT a.dthriniintervalo, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, a.nrop, ");
			strSQL = strSQL.concat("                   SUM(a.tmpparadas + a.tmpparadassempeso) as tmpparMTBFMTTR, ");
			strSQL = strSQL.concat("                   COUNT(a.dthriniintervalo) as qtdparMTBFMTTR ");
			strSQL = strSQL.concat("             FROM IJREAPARCNSOCORUT a ");
			strSQL = strSQL.concat("             JOIN ijtbinj d ON (d.cdinjetora = a.cdinjetora) ");
			strSQL = strSQL.concat("             JOIN ijtbpar p ON (p.cdparada = a.cdparada and p.CalcMTBFMTTR = '1') ");
			strSQL = strSQL.concat(
					"       GROUP BY a.dthriniintervalo, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, a.nrop ) ");
			strSQL = strSQL.concat("  mtbf ON (    mtbf.dthriniintervalo = a.dthriniintervalo ");
		} else {
			strSQL = strSQL.concat(
					" LEFT JOIN (SELECT a.dtturno, a.cdturno, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, a.nrop, ");
			strSQL = strSQL.concat("                   SUM(a.tmpparadas + a.tmpparadassempeso) as tmpparMTBFMTTR, ");
			strSQL = strSQL.concat("                   COUNT(a.dtturno) as qtdparMTBFMTTR ");			
			strSQL = strSQL.concat("             FROM IJREAPARCNSOCORTUR a ");
			strSQL = strSQL.concat("             JOIN ijtbinj d ON (d.cdinjetora = a.cdinjetora) ");
			strSQL = strSQL.concat("             JOIN ijtbpar p ON (p.cdparada = a.cdparada and p.CalcMTBFMTTR = '1') ");
			strSQL = strSQL.concat(
					"       GROUP BY a.dtturno, a.cdturno, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, a.nrop ) ");
			strSQL = strSQL.concat("  mtbf ON (    mtbf.dtturno = a.dtturno ");
			strSQL = strSQL.concat("           AND mtbf.cdturno = a.cdturno ");
		}

		strSQL = strSQL.concat("           AND mtbf.cdinjetora = a.cdinjetora ");
		strSQL = strSQL.concat("           AND mtbf.cdmolde = a.cdmolde ");
		strSQL = strSQL.concat("           AND mtbf.cdestrutura = a.cdestrutura ");
		strSQL = strSQL.concat("           AND mtbf.dthrivalestru = a.dthrivalestru ");
		strSQL = strSQL.concat("           AND mtbf.dthrivalcic = a.dthrivalcic ");
		strSQL = strSQL.concat("           AND mtbf.nrop = a.nrop) ");

		if (filtro.getTpId() == PERIODO_CONSOLIDACAO_HORA) {
			strSQL = strSQL.concat(" WHERE a.dthriniintervalo BETWEEN :dthrihr AND :dthrfhr ");

		} else {
			strSQL = strSQL.concat(" WHERE a.dtturno = a.dtturno ");

			if (filtro.getDtReferencia() != null) {
				strSQL = strSQL.concat("  AND a.dtturno = :dtref ");
			}

			if (filtro.getDwTurno() != null) {
				strSQL = strSQL.concat("  AND a.cdturno = :cdturno ");
			}
		}

		if (filtro.getOmPt() != null) {
			strSQL = strSQL.concat(" AND i.cdinjestendido = :cdinjetora");
		}

		if (filtro.getCdCp() != null && filtro.getCdCp().equals("") == false && filtro.getFiltroOp() != null
				&& (filtro.getFiltroOp() == 0 || filtro.getFiltroOp() == 3)) {
			strSQL = strSQL.concat(" AND a.nrop = :nrop ");
		}

		String strSQL_pt_cp = "";
		if (listaFiltroProducaoPtCp.size() > 0) {
			for (FiltroProducaoPtCpDTO itemLista : listaFiltroProducaoPtCp) {
				if (strSQL_pt_cp.equals("")) {
					strSQL_pt_cp = strSQL_pt_cp.concat(" AND  ( ");
				} else {
					strSQL_pt_cp = strSQL_pt_cp.concat(" OR ");
				}

				if (itemLista.getPpCp() != null) {
					strSQL_pt_cp = strSQL_pt_cp.concat(" (a.nrop = '" + itemLista.getPpCp().getCdCp() + "' AND i.cdinjestendido = '"
							+ itemLista.getOmPt().getCdPt() + "')");
				} else {
					strSQL_pt_cp = strSQL_pt_cp.concat(" (i.cdinjestendido = '" + itemLista.getOmPt().getCdPt() + "')");
				}

			}

			strSQL_pt_cp = strSQL_pt_cp.concat(" ) ");
		}

		strSQL = strSQL.concat(" " + strSQL_pt_cp);
		strSQL = strSQL.concat(" ORDER BY a.idregistro ");
		
		return strSQL;
	}

	private String getStringConsultaConsolidacaoInjetUT(Long idregistro) {
		String strSQL = "";

		strSQL = strSQL.concat("SELECT a.idregistro, a.dthriniintervalo, a.dthrfimintervalo, ");

		// op
		strSQL = strSQL.concat("a.nrop, rot.nropexibicao, ");

		// info de maq
		strSQL = strSQL.concat("a.cdinjetora, i.cdinjestendido, i.cdidentific, ");

		// fic tec
		strSQL = strSQL.concat("a.dthrivalcic, c.ciclopadrao, c.varmin, c.varmax, c.fatorcontagemprod, ");

		// mol x pro
		strSQL = strSQL.concat("a.dthrivalestru, a.cdmolde, mld.cdmolestendido, a.cdestrutura, d.qtcavativas, d.qtcavidades, ");

		// consolidacoes
		strSQL = strSQL.concat("a.qtinjnormal, a.qtinjfinpar, ");
		strSQL = strSQL.concat(
				"(CASE WHEN a.qtinjnormal IS NULL or a.qtinjnormal = 0 THEN 0 ELSE (a.tmpcicnormal  / a.qtinjnormal) END) as ciclomedio, ");
		strSQL = strSQL.concat("(a.qtprodbrutaUB) as prodbruta, ");
		strSQL = strSQL.concat("(a.qtprodrefugadaUB) as prodref, ");
		strSQL = strSQL.concat("(a.tmpcicnormal) as tmpcicnormal, ");
		strSQL = strSQL.concat("(a.tmpcicfinparada) as tmpcicfinparada, ");
		strSQL = strSQL.concat("(a.tmpparadas) as tmpparadasCP, ");
		strSQL = strSQL.concat("(a.tmpparadassempeso) as tmpparadasSP, ");
		strSQL = strSQL.concat("(FLOOR(a.tmpcicnormal / c.ciclopadrao) * (CASE WHEN ct.campo23 = '¬¬ª¿±·¿½­' THEN d.qtcavidades ELSE d.qtcavativas END)  * c.fatorcontagemprod) as prodprev, ");
		strSQL = strSQL.concat("f.prodplanOP, ");
		strSQL = strSQL.concat("((CASE WHEN a.tmpativo IS NULL THEN 0 ELSE a.tmpativo END)) as tmphrsdisp, ");
		strSQL = strSQL.concat("(a.tmpcavidades) as tmpcavidades, ");
		strSQL = strSQL.concat("((CASE WHEN a.tmpprodrefugada IS NULL THEN 0 ELSE a.tmpprodrefugada END)) as tmprefugo, ");
		strSQL = strSQL.concat("( (((a.tmpcicnormal / a.ciclopadrao) - a.qtinjnormal ) * a.ciclopadrao) ) as tmpritmo, ");
		strSQL = strSQL
				.concat("( ( (a.tmpcicnormal / c.ciclopadrao) - a.qtinjnormal) * (d.qtcavativas * c.fatorcontagemprod)) as qtdritmo, ");
		strSQL = strSQL.concat("( (a.qtinjnormal * (d.qtcavidades - d.qtcavativas)) * c.fatorcontagemprod) as qtdperdapcsciclo, ");
		strSQL = strSQL.concat("( a.qtinjnormal * d.qtcavidades) as qtdpcsciclototal, ");
		strSQL = strSQL.concat("( a.qtinjnormal * d.qtcavativas) as qtdpcscicloativas, ");
		strSQL = strSQL.concat("( ( a.tmpparadas / c.ciclopadrao) * (d.qtcavativas * c.fatorcontagemprod) ) as qtdperdasparCP, ");
		strSQL = strSQL.concat("( ( a.tmpparadassempeso / c.ciclopadrao) * (d.qtcavativas * c.fatorcontagemprod) ) as qtdperdasparSP, ");

		// dados para calc de mtbf/mttf
		strSQL = strSQL.concat(" mtbf.tmpparMTBFMTTR, mtbf.qtdparMTBFMTTR ");

		strSQL = strSQL.concat("  FROM viewDadosCalcOEEOPut a ");

		strSQL = strSQL.concat("  JOIN ijtbfresh ct ON (1=1) ");
		
		// fic tec: ciclo padrao, fator contagem
		strSQL = strSQL.concat(
				"  JOIN ijfictec c ON (c.cdinjetora = a.cdinjetora AND c.cdmolde = a.cdmolde AND c.cdestrutura = a.cdestrutura AND c.dthrivalcic = a.dthrivalcic)");

		// molde x produto: pcs por ciclo
		strSQL = strSQL.concat(
				"  JOIN cavidades2 d ON (d.cdmolde = c.cdmolde AND d.cdestrutura = c.cdestrutura AND d.dthrival = c.dthrivalestru) ");

		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol mld ON (mld.cdmolde = a.cdmolde) ");

		strSQL = strSQL.concat("  JOIN ijop op ON (op.nrop = a.nrop) ");
		strSQL = strSQL.concat(
				"  JOIN ijoproteiro rot ON  (rot.nrop = a.nrop AND rot.cdinjetora = a.cdinjetora AND rot.cdmolde = a.cdmolde AND rot.cdestrutura = a.cdestrutura) ");
		strSQL = strSQL
				.concat("  JOIN (SELECT nrop, SUM(qtpecasproduzir) as prodplanOP FROM ijopprodutos GROUP BY nrop) f ON (f.nrop = a.nrop)");

		// dados para calc de mtbf/mttf
		strSQL = strSQL.concat(
				" LEFT JOIN (SELECT a.dthriniintervalo, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, a.nrop, ");
		strSQL = strSQL.concat("                   SUM(a.tmpparadas + a.tmpparadassempeso) as tmpparMTBFMTTR, ");
		strSQL = strSQL.concat("                   COUNT(a.dthriniintervalo) as qtdparMTBFMTTR ");
		strSQL = strSQL.concat("             FROM IJREAPARCNSOCORUT a ");
		strSQL = strSQL.concat("             JOIN ijtbinj d ON (d.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("             JOIN ijtbpar p ON (p.cdparada = a.cdparada and p.CalcMTBFMTTR = '1') ");
		strSQL = strSQL.concat(
				"       GROUP BY a.dthriniintervalo, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, a.nrop ) ");
		strSQL = strSQL.concat("  mtbf ON (    mtbf.dthriniintervalo = a.dthriniintervalo ");

		strSQL = strSQL.concat("           AND mtbf.cdinjetora = a.cdinjetora ");
		strSQL = strSQL.concat("           AND mtbf.cdmolde = a.cdmolde ");
		strSQL = strSQL.concat("           AND mtbf.cdestrutura = a.cdestrutura ");
		strSQL = strSQL.concat("           AND mtbf.dthrivalestru = a.dthrivalestru ");
		strSQL = strSQL.concat("           AND mtbf.dthrivalcic = a.dthrivalcic ");
		strSQL = strSQL.concat("           AND mtbf.nrop = a.nrop) ");

		strSQL = strSQL.concat(" WHERE a.idregistro = " + idregistro);

		strSQL = strSQL.concat(" ORDER BY a.idregistro ");
		
		return strSQL;
	}

	/*
	 * Método que retorna o detalhamento de perdas/ganhos por ciclo - ordena��oo de máquinas, molde e produtos com maiores perdas
	 */

	public ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO getDetalhamentoGraficoPerdasBICiclosOrdemMaquina(
			DetalheMonitorizacaoPTInjetDTO indicadores, String cdMaquina, String cdProduto, Boolean isConsiderarPerda,
			Boolean isConsiderarGanho) {

		ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO detalhamento = new ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO();
		detalhamento.setResumoIndicadores(new ResumoParetoPerdasDetCiclosDTO());

		GraficoBIParetoDetCiclosOrdemMaquinaDTO itemMaquina = new GraficoBIParetoDetCiclosOrdemMaquinaDTO();
		GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO itemFerramenta = new GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO();
		GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO itemProduto =
				new GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO();

		BigDecimal segCicloPadrao = BigDecimal.ZERO;
		BigDecimal qtPcsCiclo = BigDecimal.ZERO;

		BigDecimal segCiclosProdutivos = BigDecimal.ZERO;
		BigDecimal segTempoCiclosProdutivosSemParadasVariacaoRitmo = BigDecimal.ZERO;
		BigDecimal segTempoparadaCpVr = BigDecimal.ZERO;
		BigDecimal segTempoparadaSpVr = BigDecimal.ZERO;

		BigDecimal qtCiclosProdutivos = BigDecimal.ZERO;
		BigDecimal segRitmo = BigDecimal.ZERO;
		BigDecimal qtPerdasCiclo = BigDecimal.ZERO;
		BigDecimal segCicloMedio = BigDecimal.ZERO;

		BigDecimal qtPerdasCicloKg = BigDecimal.ZERO;
		BigDecimal qtPerdasCicloTon = BigDecimal.ZERO;
		BigDecimal qtPerdasCicloUM = BigDecimal.ZERO;
		BigDecimal pesoBruto = BigDecimal.ZERO;
		BigDecimal valorUnitario = BigDecimal.ZERO;

		boolean isMaquinaNaLista = false;
		boolean isFerramentaNaLista = false;
		boolean isProdutoNaLista = false;

		detalhamento.setListaMaquinas(new ArrayList<GraficoBIParetoDetCiclosOrdemMaquinaDTO>());

		for (DwConsolid dwci : indicadores.getListaDwConsolId()) {
			segCicloPadrao = dwci.getDwConsol().getSegAutoCiclopadrao();

			// sem filtro de máquina ou com filtro e máquina selecionada igual
			// ao filtro
			if ((cdMaquina.equals("")) || (cdMaquina.equals(dwci.getOmPt().getCdPt()))) {
				// máquina
				itemMaquina = new GraficoBIParetoDetCiclosOrdemMaquinaDTO();
				itemMaquina.setCdMaquina(dwci.getOmPt().getCdPt());
				itemMaquina.setDsMaquina(dwci.getOmPt().getDsPt());
				itemMaquina.setFerramentas(new ArrayList<GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO>());
				itemMaquina.setQtdEmUB(0d);
				itemMaquina.setQtdEmUM(0d);
				itemMaquina.setQtdEmKg(0d);
				itemMaquina.setQtdEmTon(0d);
				itemMaquina.setSegCiclosProdutivos(0d);

				for (DwConsol dwc : dwci.getDwConsols()) {
					segCicloPadrao = dwc.getSegAutoCiclopadrao();

					// ciclos produtivos sem parada de varia��oo de ritmo
					segTempoparadaCpVr = dwc.getSegAutoTempoparadaCpVr();
					segTempoparadaCpVr = AritmeticaUtil.somar(segTempoparadaCpVr, dwc.getSegManuTempoparadaCpVr());

					segTempoparadaSpVr = dwc.getSegAutoTempoparadaSpVr();
					segTempoparadaSpVr = AritmeticaUtil.somar(segTempoparadaSpVr, dwc.getSegManuTempoparadaSpVr());

					segCiclosProdutivos = AritmeticaUtil.somar(dwc.getSegAutoCicloprodutivo() != null ? dwc.getSegAutoCicloprodutivo()
							: BigDecimal.ZERO, dwc.getSegManuCicloprodutivo() != null ? dwc.getSegManuCicloprodutivo() : BigDecimal.ZERO);

					segTempoCiclosProdutivosSemParadasVariacaoRitmo = segCiclosProdutivos.subtract(segTempoparadaCpVr).subtract(
							segTempoparadaSpVr);

					qtCiclosProdutivos = AritmeticaUtil.somar(dwc.getQtAutoCicloprodutivo() != null ? dwc.getQtAutoCicloprodutivo()
							: BigDecimal.ZERO, dwc.getQtManuCicloprodutivo() != null ? dwc.getQtManuCicloprodutivo() : BigDecimal.ZERO);

					segRitmo = (dwc.getSegAutoRitmo() != null ? dwc.getSegAutoRitmo() : BigDecimal.ZERO);
					segCicloMedio = FormulasInjet.calcularCicloMedio(segCiclosProdutivos, qtCiclosProdutivos);
					segCiclosProdutivos = segTempoCiclosProdutivosSemParadasVariacaoRitmo;

					// ferramenta
					itemFerramenta = new GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO();
					itemFerramenta.setCdFerramenta(dwci.getDwFolha().getCdFolha());
					itemFerramenta.setDsFerramenta(dwci.getDwFolha().getDsFolha());
					itemFerramenta.setProdutos(new ArrayList<GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO>());
					itemFerramenta.setCicloPadrao(segCicloPadrao.doubleValue());
					itemFerramenta.setQtdCiclosExecutados(qtCiclosProdutivos.doubleValue());
					itemFerramenta.setSegCiclosProdutivos(segCiclosProdutivos.doubleValue());
					itemFerramenta.setCicloMedio(segCicloMedio.doubleValue());
					itemFerramenta.setQtdEmUB(0d);
					itemFerramenta.setQtdEmUM(0d);
					itemFerramenta.setQtdEmKg(0d);
					itemFerramenta.setQtdEmTon(0d);

					for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {

						// sem filtro de produto ou com filtro e máquina
						// selecionada igual ao filtro
						if ((cdProduto.equals("")) || (cdProduto.equals(dwcpr.getOmProduto().getCdProduto()))) {
							// pcs por ciclo
							qtPcsCiclo = getPcsPorCicloAtivas(dwci.getDwFolha(), dwcpr.getOmProduto());
							qtPerdasCiclo = FormulasInjet.calcularPcsPerdaciclo(segRitmo, segCicloPadrao, qtPcsCiclo);

							// perdas em kg e ton
							if (dwcpr.getOmProduto().getGPesoBruto() != null) {
								pesoBruto = dwcpr.getOmProduto().getGPesoBruto();

								// perdas em kg
								qtPerdasCicloKg = qtPerdasCiclo.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));

								// perdas em toneladas
								qtPerdasCicloTon = qtPerdasCiclo.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000000));
							} else {
								qtPerdasCicloKg = BigDecimal.ZERO;
								qtPerdasCicloTon = BigDecimal.ZERO;
							}

							// perdas em unidade monetária
							if (dwcpr.getOmProduto().getVlCustounit() != null) {
								valorUnitario = dwcpr.getOmProduto().getVlCustounit();
							} else {
								valorUnitario = BigDecimal.ZERO;
							}

							// valor
							qtPerdasCicloUM = qtPerdasCiclo.multiply(valorUnitario);

							// produto
							itemProduto = new GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO();
							itemProduto.setCdProduto(dwcpr.getOmProduto().getCdProduto());
							itemProduto.setDsProduto(dwcpr.getOmProduto().getDsProduto());
							itemProduto.setQtdEmUB(qtPerdasCiclo.doubleValue());
							itemProduto.setQtdEmUM(qtPerdasCicloUM.doubleValue());
							itemProduto.setQtdEmKg(qtPerdasCicloKg.doubleValue());
							itemProduto.setQtdEmTon(qtPerdasCicloTon.doubleValue());

							// procura
							isMaquinaNaLista = false;
							for (GraficoBIParetoDetCiclosOrdemMaquinaDTO maquina : detalhamento.getListaMaquinas()) {
								// máq está na lista?
								if (maquina.getCdMaquina().equals(itemMaquina.getCdMaquina())) {
									isMaquinaNaLista = true;

									// ferramenta está na lista?
									isFerramentaNaLista = false;
									for (GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO ferramenta : maquina.getFerramentas()) {
										if ((ferramenta.getCdFerramenta().compareTo(itemFerramenta.getCdFerramenta()) == 0)
												&& (ferramenta.getCicloPadrao().compareTo(itemFerramenta.getCicloPadrao()) == 0)) {
											isFerramentaNaLista = true;

											// acumula tempos e ciclo recalcula
											// ciclo médio
											
											/*
											ferramenta.setSegCiclosProdutivos(ferramenta.getSegCiclosProdutivos()
													+ itemFerramenta.getSegCiclosProdutivos());
											ferramenta.setQtdCiclosExecutados(ferramenta.getQtdCiclosExecutados()
													+ itemFerramenta.getQtdCiclosExecutados());
											ferramenta.setCicloMedio(FormulasInjet.calcularCicloMedio(
													new BigDecimal(ferramenta.getSegCiclosProdutivos()),
													new BigDecimal(ferramenta.getQtdCiclosExecutados())).doubleValue());

											 */
											
											
											// produto na lista?
											isProdutoNaLista = false;

											for (GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO produto : ferramenta
													.getProdutos()) {
												if (produto.getCdProduto().equals(itemProduto.getCdProduto())) {
													isProdutoNaLista = true;

													// acumula perdas
													produto.setQtdEmKg(produto.getQtdEmKg() + itemProduto.getQtdEmKg());
													produto.setQtdEmTon(produto.getQtdEmTon() + itemProduto.getQtdEmTon());
													produto.setQtdEmUM(produto.getQtdEmUM() + itemProduto.getQtdEmUM());
													produto.setQtdEmUB(produto.getQtdEmUB() + itemProduto.getQtdEmUB());

													break;
												}
											}

											if (!isProdutoNaLista) {
												ferramenta.getProdutos().add(itemProduto);
											}
										}
									}

									if (!isFerramentaNaLista) {
										itemFerramenta.getProdutos().add(itemProduto);
										maquina.getFerramentas().add(itemFerramenta);
									}
								}
							}

							if (!isMaquinaNaLista) {
								// adiciona máq
								itemFerramenta.getProdutos().add(itemProduto);
								itemMaquina.getFerramentas().add(itemFerramenta);
								detalhamento.getListaMaquinas().add(itemMaquina);
							}
						}
					}
				}
			}
		}

		// Totalizar por produto independente de ferramenta, ciclo, et. Total será atribuído posteriormente no atibuto ResumoIndicadores
		Map<String, ResumoParetoPerdasDetCiclosDTO> mapTotalMaquina = new HashMap<String, ResumoParetoPerdasDetCiclosDTO>();

		// remover itens com tempo de ciclo produtivo zerado
		Double totalFerramenta = 0d;
		Double totalMaquina = 0d;
		Double segCicloPadraoMedio = 0d;
		Double segCicloMedioMedio = 0d;
		Integer qtdOcorr = 0;

		ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO listaAux = new ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO();
		listaAux.setListaMaquinas(new ArrayList<GraficoBIParetoDetCiclosOrdemMaquinaDTO>());
		listaAux.setResumoIndicadores(new ResumoParetoPerdasDetCiclosDTO());

		for (GraficoBIParetoDetCiclosOrdemMaquinaDTO maquina : detalhamento.getListaMaquinas()) {
			totalMaquina = 0d;
			GraficoBIParetoDetCiclosOrdemMaquinaDTO maqAux = new GraficoBIParetoDetCiclosOrdemMaquinaDTO();
			maqAux.setFerramentas(new ArrayList<GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO>());
			maqAux.setCdMaquina(maquina.getCdMaquina());
			maqAux.setDsMaquina(maquina.getDsMaquina());
			maqAux.setQtdEmUB(0d);
			maqAux.setQtdEmUM(0d);
			maqAux.setQtdEmKg(0d);
			maqAux.setQtdEmTon(0d);

			for (GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO ferramenta : maquina.getFerramentas()) {
				totalFerramenta = 0d;
				GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO ferrAux = new GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO();
				ferrAux.setProdutos(new ArrayList<GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO>());
				ferrAux.setCdFerramenta(ferramenta.getCdFerramenta());
				ferrAux.setDsFerramenta(ferramenta.getDsFerramenta());
				ferrAux.setCicloMedio(ferramenta.getCicloMedio());
				ferrAux.setCicloPadrao(ferramenta.getCicloPadrao());
				ferrAux.setQtdCiclosExecutados(ferramenta.getQtdCiclosExecutados());
				ferrAux.setSegCiclosProdutivos(ferramenta.getSegCiclosProdutivos());

				if (ferramenta.getSegCiclosProdutivos() == 0d) {
					// ignorar a ferramenta

				} else {
					for (GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO produto : ferramenta.getProdutos()) {
						totalFerramenta = totalFerramenta + produto.getQtdEmUB();
						totalMaquina = totalMaquina + totalFerramenta;
						ferrAux.getProdutos().add(produto);

						maqAux.setQtdEmUB(maqAux.getQtdEmUB() + produto.getQtdEmUB());
						maqAux.setQtdEmUM(maqAux.getQtdEmUM() + produto.getQtdEmUM());
						maqAux.setQtdEmKg(maqAux.getQtdEmKg() + produto.getQtdEmKg());
						maqAux.setQtdEmTon(maqAux.getQtdEmTon() + produto.getQtdEmTon());

						ResumoParetoPerdasDetCiclosDTO resumoTotalMaquina = new ResumoParetoPerdasDetCiclosDTO();

						if (isConsiderarPerda && produto.getQtdEmUB() != 0d) {
							if (isConsiderarPerda && produto.getQtdEmUB() > 0d) {
								resumoTotalMaquina.setPerdaUB(produto.getQtdEmUB());
								resumoTotalMaquina.setPerdaUM(produto.getQtdEmUM());
								resumoTotalMaquina.setPerdaKg(produto.getQtdEmKg());
								resumoTotalMaquina.setPerdaTon(produto.getQtdEmTon());
							}

							if (isConsiderarGanho && produto.getQtdEmUB() < 0d) {
								resumoTotalMaquina.setGanhoUB(produto.getQtdEmUB());
								resumoTotalMaquina.setGanhoUM(produto.getQtdEmUM());
								resumoTotalMaquina.setGanhoKg(produto.getQtdEmKg());
								resumoTotalMaquina.setGanhoTon(produto.getQtdEmTon());
							}

							resumoTotalMaquina.setSaldoUB(resumoTotalMaquina.getPerdaUB() + resumoTotalMaquina.getGanhoUB());
							resumoTotalMaquina.setSaldoUM(resumoTotalMaquina.getPerdaUM() + resumoTotalMaquina.getGanhoUM());
							resumoTotalMaquina.setSaldoKg(resumoTotalMaquina.getPerdaKg() + resumoTotalMaquina.getGanhoKg());
							resumoTotalMaquina.setSaldoTon(resumoTotalMaquina.getPerdaTon() + resumoTotalMaquina.getGanhoTon());

							if (!mapTotalMaquina.containsKey(maqAux.getCdMaquina())) {
								mapTotalMaquina.put(maqAux.getCdMaquina(), resumoTotalMaquina);
							} else {
								ResumoParetoPerdasDetCiclosDTO itemMapTotal = new ResumoParetoPerdasDetCiclosDTO();
								itemMapTotal = mapTotalMaquina.get(maqAux.getCdMaquina());

								itemMapTotal.setPerdaUB(itemMapTotal.getPerdaUB() + resumoTotalMaquina.getPerdaUB());
								itemMapTotal.setPerdaUM(itemMapTotal.getPerdaUM() + resumoTotalMaquina.getPerdaUM());
								itemMapTotal.setPerdaKg(itemMapTotal.getPerdaKg() + resumoTotalMaquina.getPerdaKg());
								itemMapTotal.setPerdaTon(itemMapTotal.getPerdaTon() + resumoTotalMaquina.getPerdaTon());

								itemMapTotal.setGanhoUB(itemMapTotal.getGanhoUB() + resumoTotalMaquina.getGanhoUB());
								itemMapTotal.setGanhoUM(itemMapTotal.getGanhoUM() + resumoTotalMaquina.getGanhoUM());
								itemMapTotal.setGanhoKg(itemMapTotal.getGanhoKg() + resumoTotalMaquina.getGanhoKg());
								itemMapTotal.setGanhoTon(itemMapTotal.getGanhoTon() + resumoTotalMaquina.getGanhoTon());

								itemMapTotal.setSaldoUB(itemMapTotal.getPerdaUB() + itemMapTotal.getGanhoUB());
								itemMapTotal.setSaldoUM(itemMapTotal.getPerdaUM() + itemMapTotal.getGanhoUM());
								itemMapTotal.setSaldoKg(itemMapTotal.getPerdaKg() + itemMapTotal.getGanhoKg());
								itemMapTotal.setSaldoTon(itemMapTotal.getPerdaTon() + itemMapTotal.getGanhoTon());

								mapTotalMaquina.put(maqAux.getCdMaquina(), itemMapTotal);
							}
						}

					}

					if (totalFerramenta == 0d || ferrAux.getProdutos().size() == 0) {
						// ignorar a ferramenta
					} else {
						qtdOcorr = qtdOcorr + 1;
						segCicloPadraoMedio = segCicloPadraoMedio + ferramenta.getCicloPadrao();
						segCicloMedioMedio = segCicloMedioMedio + ferramenta.getCicloMedio();
						maqAux.getFerramentas().add(ferrAux);
					}
				}
			}

			if (totalMaquina == 0d || maqAux.getFerramentas().size() == 0) {
				// ignorar a maquina
			} else {
				listaAux.getListaMaquinas().add(maqAux);

				// resumo indicadores
				if (isConsiderarPerda && maqAux.getQtdEmUB() > 0) {
					listaAux.getResumoIndicadores().setPerdaUB(listaAux.getResumoIndicadores().getPerdaUB() + maqAux.getQtdEmUB());
					listaAux.getResumoIndicadores().setPerdaUM(listaAux.getResumoIndicadores().getPerdaUM() + maqAux.getQtdEmUM());
					listaAux.getResumoIndicadores().setPerdaKg(listaAux.getResumoIndicadores().getPerdaKg() + maqAux.getQtdEmKg());
					listaAux.getResumoIndicadores().setPerdaTon(listaAux.getResumoIndicadores().getPerdaTon() + maqAux.getQtdEmTon());
				}

				if (isConsiderarGanho && maqAux.getQtdEmUB() < 0) {
					listaAux.getResumoIndicadores().setGanhoUB(listaAux.getResumoIndicadores().getGanhoUB() + (maqAux.getQtdEmUB() * -1));
					listaAux.getResumoIndicadores().setGanhoUM(listaAux.getResumoIndicadores().getPerdaUM() + (maqAux.getQtdEmUM() * -1));
					listaAux.getResumoIndicadores().setGanhoKg(listaAux.getResumoIndicadores().getPerdaKg() + (maqAux.getQtdEmKg() * -1));
					listaAux.getResumoIndicadores()
							.setGanhoTon(listaAux.getResumoIndicadores().getPerdaTon() + (maqAux.getQtdEmTon() * -1));
				}

				listaAux.getResumoIndicadores()
						.setSaldoUB(listaAux.getResumoIndicadores().getPerdaUB() + listaAux.getResumoIndicadores().getGanhoUB());
				listaAux.getResumoIndicadores()
						.setSaldoUM(listaAux.getResumoIndicadores().getPerdaUM() + listaAux.getResumoIndicadores().getGanhoUM());
				listaAux.getResumoIndicadores()
						.setSaldoKg(listaAux.getResumoIndicadores().getPerdaKg() + listaAux.getResumoIndicadores().getGanhoKg());
				listaAux.getResumoIndicadores()
						.setSaldoTon(listaAux.getResumoIndicadores().getPerdaTon() + listaAux.getResumoIndicadores().getGanhoTon());
			}

		}

		// resumo indicadores - ciclo padrao, medio e efic cic
		if (qtdOcorr > 0) {
			segCicloMedioMedio = AritmeticaUtil.dividir(new BigDecimal(segCicloMedioMedio), new BigDecimal(qtdOcorr)).doubleValue();
			segCicloPadraoMedio = AritmeticaUtil.dividir(new BigDecimal(segCicloPadraoMedio), new BigDecimal(qtdOcorr)).doubleValue();

			if (!cdMaquina.equals("")) {
				listaAux.setResumoIndicadores(mapTotalMaquina.get(cdMaquina));
			}

			listaAux.getResumoIndicadores().setCicloMedio(segCicloMedioMedio);
			listaAux.getResumoIndicadores().setCicloPadrao(segCicloPadraoMedio);
			listaAux.getResumoIndicadores()
					.setEfiCic(FormulasInjet.calcularEficienciaCiclo(new BigDecimal(listaAux.getResumoIndicadores().getCicloPadrao()),
							new BigDecimal(listaAux.getResumoIndicadores().getCicloMedio())).doubleValue());
		}

		detalhamento = new ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO();
		detalhamento = listaAux;

		// totalizar qtds e tempo produtivo
		for (GraficoBIParetoDetCiclosOrdemMaquinaDTO maquina : detalhamento.getListaMaquinas()) {
			maquina.setSegCiclosProdutivos(0d);
			maquina.setQtdEmUB(0d);
			maquina.setQtdEmUM(0d);
			maquina.setQtdEmKg(0d);
			maquina.setQtdEmTon(0d);

			for (GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO ferramenta : maquina.getFerramentas()) {
				ferramenta.setQtdEmUB(0d);
				ferramenta.setQtdEmUM(0d);
				ferramenta.setQtdEmKg(0d);
				ferramenta.setQtdEmTon(0d);

				for (GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO produto : ferramenta.getProdutos()) {
					ferramenta.setQtdEmUB(ferramenta.getQtdEmUB() + produto.getQtdEmUB());
					ferramenta.setQtdEmUM(ferramenta.getQtdEmUM() + produto.getQtdEmUM());
					ferramenta.setQtdEmKg(ferramenta.getQtdEmKg() + produto.getQtdEmKg());
					ferramenta.setQtdEmTon(ferramenta.getQtdEmTon() + produto.getQtdEmTon());
				}

				maquina.setSegCiclosProdutivos(maquina.getSegCiclosProdutivos() + ferramenta.getSegCiclosProdutivos());
				maquina.setQtdEmUB(maquina.getQtdEmUB() + ferramenta.getQtdEmUB());
				maquina.setQtdEmUM(maquina.getQtdEmUM() + ferramenta.getQtdEmUM());
				maquina.setQtdEmKg(maquina.getQtdEmKg() + ferramenta.getQtdEmKg());
				maquina.setQtdEmTon(maquina.getQtdEmTon() + ferramenta.getQtdEmTon());
			}
		}

		// ordenar ferramentas de cada máquina
		for (GraficoBIParetoDetCiclosOrdemMaquinaDTO maquina : detalhamento.getListaMaquinas()) {

			Collections.sort(maquina.getFerramentas(), new Comparator<GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO>() {
				@Override
				public int compare(final GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO o1,
						final GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO o2) {
					final GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO item1 = o1;
					final GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO item2 = o2;
					return (item1.getQtdEmUB()).compareTo(item2.getQtdEmUB()) * -1;
				}
			});

			// ordernar produtos de cada ferramenta
			for (GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO ferramenta : maquina.getFerramentas()) {
				Collections.sort(ferramenta.getProdutos(), new Comparator<GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO>() {
					@Override
					public int compare(final GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO o1,
							final GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO o2) {
						final GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO item1 = o1;
						final GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO item2 = o2;
						return (item1.getQtdEmUB()).compareTo(item2.getQtdEmUB()) * -1;
					}
				});
			}

		}

		// ordenar lista de máquinas
		Collections.sort(detalhamento.getListaMaquinas(), new Comparator<GraficoBIParetoDetCiclosOrdemMaquinaDTO>() {
			@Override
			public int compare(final GraficoBIParetoDetCiclosOrdemMaquinaDTO o1, final GraficoBIParetoDetCiclosOrdemMaquinaDTO o2) {
				final GraficoBIParetoDetCiclosOrdemMaquinaDTO item1 = o1;
				final GraficoBIParetoDetCiclosOrdemMaquinaDTO item2 = o2;
				return (item1.getQtdEmUB()).compareTo(item2.getQtdEmUB()) * -1;
			}
		});

		return detalhamento;
	}

	private GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO cloneGraficoBIParetoDetCiclosOrdemProdutoFicTecDTO(GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO origem) {
		GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO retorno = new GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO();
		
	    retorno.setCdMaquina(origem.getCdMaquina());
	    retorno.setDsMasquina(origem.getDsMasquina());
	    retorno.setCdFerramenta(origem.getCdFerramenta());
	    retorno.setDsFerramenta(origem.getDsFerramenta());
	    retorno.setCicloPadrao(origem.getCicloPadrao());
	    retorno.setCicloMedio(origem.getCicloMedio());
	    retorno.setQtdCiclosExecutados(origem.getQtdCiclosExecutados());
	    retorno.setSegCiclosProdutivos(origem.getSegCiclosProdutivos());
	    retorno.setQtdEmUB(origem.getQtdEmUB());
	    retorno.setQtdEmKg(origem.getQtdEmKg());
	    retorno.setQtdEmTon(origem.getQtdEmTon());
	    retorno.setQtdEmUM(origem.getQtdEmUM());
		
		return retorno;
	}
	
	/*
	 * Método que retorna o detalhamento de perdas/ganhos por ciclo - ordena��oo de máquina, molde e produtos com maiores perdas
	 */

	public ListaGraficoBIParetoDetCiclosOrdemProdutoDTO getDetalhamentoGraficoPerdasBICiclosOrdemProduto(
			DetalheMonitorizacaoPTInjetDTO indicadores, Byte ordemQtd, String cdMaquina, String cdProduto, Boolean isConsiderarPerda,
			Boolean isConsiderarGanho) {

		ListaGraficoBIParetoDetCiclosOrdemProdutoDTO detalhamento = new ListaGraficoBIParetoDetCiclosOrdemProdutoDTO();
		detalhamento.setResumoIndicadores(new ResumoParetoPerdasDetCiclosDTO());
		GraficoBIParetoDetCiclosOrdemProdutoDTO itemProduto = new GraficoBIParetoDetCiclosOrdemProdutoDTO();
		GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO itemFicTecComum = new GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO();

		BigDecimal segCicloPadrao = BigDecimal.ZERO;
		BigDecimal qtPcsCiclo = BigDecimal.ZERO;

		BigDecimal segCiclosProdutivos = BigDecimal.ZERO;
		BigDecimal segTempoCiclosProdutivosSemParadasVariacaoRitmo = BigDecimal.ZERO;
		BigDecimal segTempoparadaCpVr = BigDecimal.ZERO;
		BigDecimal segTempoparadaSpVr = BigDecimal.ZERO;

		BigDecimal qtCiclosProdutivos = BigDecimal.ZERO;
		BigDecimal segRitmo = BigDecimal.ZERO;
		BigDecimal qtPerdasCiclo = BigDecimal.ZERO;
		BigDecimal segCicloMedio = BigDecimal.ZERO;

		BigDecimal qtPerdasCicloKg = BigDecimal.ZERO;
		BigDecimal qtPerdasCicloTon = BigDecimal.ZERO;
		BigDecimal qtPerdasCicloUM = BigDecimal.ZERO;
		BigDecimal pesoBruto = BigDecimal.ZERO;

		boolean isFicTecNaLista = false;
		boolean isProdutoNaLista = false;

		detalhamento.setListaProdutos(new ArrayList<GraficoBIParetoDetCiclosOrdemProdutoDTO>());

		
		for (DwConsolid dwci : indicadores.getListaDwConsolId()) {
			segCicloPadrao = dwci.getDwConsol().getSegAutoCiclopadrao();

			// sem filtro de máquina ou com filtro e máquina selecionada igual
			// ao filtro
			if ((cdMaquina.equals("")) || (cdMaquina.equals(dwci.getOmPt().getCdPt()))) {
				for (DwConsol dwc : dwci.getDwConsols()) {
					segCicloPadrao = dwc.getSegAutoCiclopadrao();

					// ciclos produtivos sem parada de varia��oo de ritmo
					segTempoparadaCpVr = dwc.getSegAutoTempoparadaCpVr();
					segTempoparadaCpVr = AritmeticaUtil.somar(segTempoparadaCpVr, dwc.getSegManuTempoparadaCpVr());

					segTempoparadaSpVr = dwc.getSegAutoTempoparadaSpVr();
					segTempoparadaSpVr = AritmeticaUtil.somar(segTempoparadaSpVr, dwc.getSegManuTempoparadaSpVr());

					qtCiclosProdutivos = AritmeticaUtil.somar(dwc.getQtAutoCicloprodutivo() != null ? dwc.getQtAutoCicloprodutivo()
							: BigDecimal.ZERO, dwc.getQtManuCicloprodutivo() != null ? dwc.getQtManuCicloprodutivo() : BigDecimal.ZERO);

					segCiclosProdutivos = AritmeticaUtil.somar(dwc.getSegAutoCicloprodutivo() != null ? dwc.getSegAutoCicloprodutivo()
							: BigDecimal.ZERO, dwc.getSegManuCicloprodutivo() != null ? dwc.getSegManuCicloprodutivo() : BigDecimal.ZERO);

					segTempoCiclosProdutivosSemParadasVariacaoRitmo = segCiclosProdutivos.subtract(segTempoparadaCpVr).subtract(
							segTempoparadaSpVr);

					segRitmo = (dwc.getSegAutoRitmo() != null ? dwc.getSegAutoRitmo() : BigDecimal.ZERO);
					segCicloMedio = FormulasInjet.calcularCicloMedio(segCiclosProdutivos, qtCiclosProdutivos);
					segCiclosProdutivos = segTempoCiclosProdutivosSemParadasVariacaoRitmo;

					// ficha técnica
					itemFicTecComum = new GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO();
					itemFicTecComum.setCdMaquina(dwci.getOmPt().getCdPt());
					itemFicTecComum.setDsMasquina(dwci.getOmPt().getDsPt());
					itemFicTecComum.setCdFerramenta(dwci.getDwFolha().getCdFolha());
					itemFicTecComum.setDsFerramenta(dwci.getDwFolha().getDsFolha());
					itemFicTecComum.setCicloPadrao(segCicloPadrao.doubleValue());
					itemFicTecComum.setQtdCiclosExecutados(qtCiclosProdutivos.doubleValue());
					itemFicTecComum.setSegCiclosProdutivos(segCiclosProdutivos.doubleValue());
					itemFicTecComum.setCicloMedio(segCicloMedio.doubleValue());
					itemFicTecComum.setQtdEmUB(0d);
					itemFicTecComum.setQtdEmUM(0d);
					itemFicTecComum.setQtdEmKg(0d);
					itemFicTecComum.setQtdEmTon(0d);

					for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {

						// sem filtro de produto ou com filtro e máquina
						// selecionada igual ao filtro
						if ((cdProduto.equals("")) || (cdProduto.equals(dwcpr.getOmProduto().getCdProduto()))) {
							// pcs por ciclo
							qtPcsCiclo = getPcsPorCicloAtivas(dwci.getDwFolha(), dwcpr.getOmProduto());
							qtPerdasCiclo = FormulasInjet.calcularPcsPerdaciclo(segRitmo, segCicloPadrao, qtPcsCiclo);

							// perdas em kg e ton
							if (dwcpr.getOmProduto().getGPesoBruto() != null) {
								pesoBruto = dwcpr.getOmProduto().getGPesoBruto();

								// perdas em kg
								qtPerdasCicloKg = qtPerdasCiclo.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));

								// perdas em toneladas
								qtPerdasCicloTon = qtPerdasCiclo.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000000));
							} else {
								qtPerdasCicloKg = BigDecimal.ZERO;
								qtPerdasCicloTon = BigDecimal.ZERO;
							}

							// perdas em unidade monetária
							if (dwcpr.getOmProduto().getVlCustounit() != null) {
								qtPerdasCicloUM = qtPerdasCiclo.multiply(dwcpr.getOmProduto().getVlCustounit());
							} else {
								qtPerdasCicloUM = BigDecimal.ZERO;
							}

							// produto
							itemProduto = new GraficoBIParetoDetCiclosOrdemProdutoDTO();
							itemProduto.setCdProduto(dwcpr.getOmProduto().getCdProduto());
							itemProduto.setDsProduto(dwcpr.getOmProduto().getDsProduto());
							itemProduto.setFictec(new ArrayList<GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO>());
							itemProduto.setQtdEmUB(0d);
							itemProduto.setQtdEmUM(0d);
							itemProduto.setQtdEmKg(0d);
							itemProduto.setQtdEmTon(0d);
							itemProduto.setQtdCiclosExecutados(0d);
							itemProduto.setSegCiclosProdutivos(0d);

							// complemento das informações da ficha técnica
							GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO itemFicTec = cloneGraficoBIParetoDetCiclosOrdemProdutoFicTecDTO(itemFicTecComum);							
							itemFicTec.setQtdEmUB(qtPerdasCiclo.doubleValue());
							itemFicTec.setQtdEmUM(qtPerdasCicloUM.doubleValue());
							itemFicTec.setQtdEmKg(qtPerdasCicloKg.doubleValue());
							itemFicTec.setQtdEmTon(qtPerdasCicloTon.doubleValue());

							// procura
							isProdutoNaLista = false;
							for (GraficoBIParetoDetCiclosOrdemProdutoDTO produto : detalhamento.getListaProdutos()) {
								// produto está na lista?
								if (produto.getCdProduto().equals(itemProduto.getCdProduto())) {
									isProdutoNaLista = true;

									// ficha técnica está na lista?
									isFicTecNaLista = false;
									for (GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO fichatecnica : produto.getFictec()) {

										if ((fichatecnica.getCdMaquina().compareTo(itemFicTec.getCdMaquina()) == 0)
												&& (fichatecnica.getCdFerramenta().compareTo(itemFicTec.getCdFerramenta()) == 0)
												&& (fichatecnica.getCicloPadrao().compareTo(itemFicTec.getCicloPadrao()) == 0)) {
											isFicTecNaLista = true;

											// acumula tempos e ciclo recalcula
											// ciclo médio
											fichatecnica.setSegCiclosProdutivos(fichatecnica.getSegCiclosProdutivos()
													+ itemFicTec.getSegCiclosProdutivos());
											fichatecnica.setQtdCiclosExecutados(fichatecnica.getQtdCiclosExecutados()
													+ itemFicTec.getQtdCiclosExecutados());
											fichatecnica.setCicloMedio(FormulasInjet.calcularCicloMedio(
													new BigDecimal(fichatecnica.getSegCiclosProdutivos()),
													new BigDecimal(fichatecnica.getQtdCiclosExecutados())).doubleValue());
											fichatecnica.setQtdEmKg(fichatecnica.getQtdEmKg() + itemFicTec.getQtdEmKg());
											fichatecnica.setQtdEmTon(fichatecnica.getQtdEmTon() + itemFicTec.getQtdEmTon());
											fichatecnica.setQtdEmUM(fichatecnica.getQtdEmUM() + itemFicTec.getQtdEmUM());
											fichatecnica.setQtdEmUB(fichatecnica.getQtdEmUB() + itemFicTec.getQtdEmUB());

											break;
										}

									}

									if (!isFicTecNaLista) {
										// adiciona fictec
										produto.getFictec().add(itemFicTec);
									}
								}
							}

							if (!isProdutoNaLista) {
								// adiciona produto
								itemProduto.getFictec().add(itemFicTec);
								detalhamento.getListaProdutos().add(itemProduto);
							}
						}
					}
				}
			}
		}

		// Totalizar por produto independente de ferramenta, ciclo, et. Total será atribuído posteriormente no atibuto ResumoIndicadores
		Map<String, ResumoParetoPerdasDetCiclosDTO> mapTotalProduto = new HashMap<String, ResumoParetoPerdasDetCiclosDTO>();

		// remover itens com tempo de ciclo produtivo zerado
		Double totalProduto = 0d;
		Double totalFicTec = 0d;
		Double segCicloPadraoMedio = 0d;
		Double segCicloMedioMedio = 0d;
		Integer qtdOcorr = 0;

		ListaGraficoBIParetoDetCiclosOrdemProdutoDTO listaAux = new ListaGraficoBIParetoDetCiclosOrdemProdutoDTO();
		listaAux.setListaProdutos(new ArrayList<GraficoBIParetoDetCiclosOrdemProdutoDTO>());
		listaAux.setResumoIndicadores(new ResumoParetoPerdasDetCiclosDTO());

		for (GraficoBIParetoDetCiclosOrdemProdutoDTO produto : detalhamento.getListaProdutos()) {
			totalProduto = 0d;
			GraficoBIParetoDetCiclosOrdemProdutoDTO prodAux = new GraficoBIParetoDetCiclosOrdemProdutoDTO();
			prodAux.setCdProduto(produto.getCdProduto());
			prodAux.setDsProduto(produto.getDsProduto());
			prodAux.setFictec(new ArrayList<GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO>());
			prodAux.setQtdEmKg(0d);
			prodAux.setQtdEmTon(0d);
			prodAux.setQtdEmUB(0d);
			prodAux.setQtdEmUM(0d);
			prodAux.setSegCiclosProdutivos(0d);
			prodAux.setQtdCiclosExecutados(0d);

			for (GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO ficTec : produto.getFictec()) {
				totalFicTec = 0d;
				GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO ficTecAux = new GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO();
				ficTecAux.setCdFerramenta(ficTec.getCdFerramenta());
				ficTecAux.setDsFerramenta(ficTec.getDsFerramenta());
				ficTecAux.setCicloPadrao(ficTec.getCicloPadrao());
				ficTecAux.setCicloMedio(ficTec.getCicloMedio());
				ficTecAux.setCdMaquina(ficTec.getCdMaquina());
				ficTecAux.setDsMasquina(ficTec.getDsMasquina());
				ficTecAux.setQtdCiclosExecutados(ficTec.getQtdCiclosExecutados());
				ficTecAux.setQtdEmKg(ficTec.getQtdEmKg());
				ficTecAux.setQtdEmTon(ficTec.getQtdEmTon());
				ficTecAux.setQtdEmUB(ficTec.getQtdEmUB());
				ficTecAux.setQtdEmUM(ficTec.getQtdEmUM());
				ficTecAux.setSegCiclosProdutivos(ficTec.getSegCiclosProdutivos());

				prodAux.setQtdEmKg(prodAux.getQtdEmKg() + ficTecAux.getQtdEmKg());
				prodAux.setQtdEmTon(prodAux.getQtdEmTon() + ficTecAux.getQtdEmTon());
				prodAux.setQtdEmUB(prodAux.getQtdEmUB() + ficTecAux.getQtdEmUB());
				prodAux.setQtdEmUM(prodAux.getQtdEmUM() + ficTecAux.getQtdEmUM());

				qtdOcorr = qtdOcorr + 1;
				segCicloPadraoMedio = segCicloPadraoMedio + ficTec.getCicloPadrao();
				segCicloMedioMedio = segCicloMedioMedio + ficTec.getCicloMedio();

				if (ficTec.getSegCiclosProdutivos() != 0d) {
					totalFicTec = totalFicTec + ficTec.getQtdEmUB();
					totalProduto = totalProduto + ficTec.getQtdEmUB();
					prodAux.getFictec().add(ficTecAux);

					ResumoParetoPerdasDetCiclosDTO resumoTotalProduto = new ResumoParetoPerdasDetCiclosDTO();

					if (isConsiderarPerda && ficTec.getQtdEmUB() != 0d) {
						if (isConsiderarPerda && ficTec.getQtdEmUB() > 0d) {
							resumoTotalProduto.setPerdaUB(ficTec.getQtdEmUB());
							resumoTotalProduto.setPerdaUM(ficTec.getQtdEmUM());
							resumoTotalProduto.setPerdaKg(ficTec.getQtdEmKg());
							resumoTotalProduto.setPerdaTon(ficTec.getQtdEmTon());
						}

						if (isConsiderarGanho && ficTec.getQtdEmUB() < 0d) {
							resumoTotalProduto.setGanhoUB(ficTec.getQtdEmUB());
							resumoTotalProduto.setGanhoUM(ficTec.getQtdEmUM());
							resumoTotalProduto.setGanhoKg(ficTec.getQtdEmKg());
							resumoTotalProduto.setGanhoTon(ficTec.getQtdEmTon());
						}

						resumoTotalProduto.setSaldoUB(resumoTotalProduto.getPerdaUB() + resumoTotalProduto.getGanhoUB());
						resumoTotalProduto.setSaldoUM(resumoTotalProduto.getPerdaUM() + resumoTotalProduto.getGanhoUM());
						resumoTotalProduto.setSaldoKg(resumoTotalProduto.getPerdaKg() + resumoTotalProduto.getGanhoKg());
						resumoTotalProduto.setSaldoTon(resumoTotalProduto.getPerdaTon() + resumoTotalProduto.getGanhoTon());

						if (!mapTotalProduto.containsKey(prodAux.getCdProduto())) {
							mapTotalProduto.put(prodAux.getCdProduto(), resumoTotalProduto);
						} else {
							ResumoParetoPerdasDetCiclosDTO itemMapTotal = new ResumoParetoPerdasDetCiclosDTO();
							itemMapTotal = mapTotalProduto.get(prodAux.getCdProduto());

							itemMapTotal.setPerdaUB(itemMapTotal.getPerdaUB() + resumoTotalProduto.getPerdaUB());
							itemMapTotal.setPerdaUM(itemMapTotal.getPerdaUM() + resumoTotalProduto.getPerdaUM());
							itemMapTotal.setPerdaKg(itemMapTotal.getPerdaKg() + resumoTotalProduto.getPerdaKg());
							itemMapTotal.setPerdaTon(itemMapTotal.getPerdaTon() + resumoTotalProduto.getPerdaTon());

							itemMapTotal.setGanhoUB(itemMapTotal.getGanhoUB() + resumoTotalProduto.getGanhoUB());
							itemMapTotal.setGanhoUM(itemMapTotal.getGanhoUM() + resumoTotalProduto.getGanhoUM());
							itemMapTotal.setGanhoKg(itemMapTotal.getGanhoKg() + resumoTotalProduto.getGanhoKg());
							itemMapTotal.setGanhoTon(itemMapTotal.getGanhoTon() + resumoTotalProduto.getGanhoTon());

							itemMapTotal.setSaldoUB(itemMapTotal.getPerdaUB() + itemMapTotal.getGanhoUB());
							itemMapTotal.setSaldoUM(itemMapTotal.getPerdaUM() + itemMapTotal.getGanhoUM());
							itemMapTotal.setSaldoKg(itemMapTotal.getPerdaKg() + itemMapTotal.getGanhoKg());
							itemMapTotal.setSaldoTon(itemMapTotal.getPerdaTon() + itemMapTotal.getGanhoTon());

							mapTotalProduto.put(prodAux.getCdProduto(), itemMapTotal);
						}
					}
				}
			}

			if (totalProduto == 0d || prodAux.getFictec().size() == 0) {
				// ignorar a maquina
			} else {
				listaAux.getListaProdutos().add(prodAux);

				if (isConsiderarPerda && prodAux.getQtdEmUB() > 0) {
					listaAux.getResumoIndicadores().setPerdaUB(listaAux.getResumoIndicadores().getPerdaUB() + prodAux.getQtdEmUB());
					listaAux.getResumoIndicadores().setPerdaUM(listaAux.getResumoIndicadores().getPerdaUM() + prodAux.getQtdEmUM());
					listaAux.getResumoIndicadores().setPerdaKg(listaAux.getResumoIndicadores().getPerdaKg() + prodAux.getQtdEmKg());
					listaAux.getResumoIndicadores().setPerdaTon(listaAux.getResumoIndicadores().getPerdaTon() + prodAux.getQtdEmTon());
				}

				if (isConsiderarGanho && prodAux.getQtdEmUB() < 0) {
					listaAux.getResumoIndicadores().setGanhoUB(listaAux.getResumoIndicadores().getGanhoUB() + (prodAux.getQtdEmUB() * -1));
					listaAux.getResumoIndicadores().setGanhoUM(listaAux.getResumoIndicadores().getPerdaUM() + prodAux.getQtdEmUM());
					listaAux.getResumoIndicadores().setGanhoKg(listaAux.getResumoIndicadores().getPerdaKg() + (prodAux.getQtdEmKg() * -1));
					listaAux.getResumoIndicadores()
							.setGanhoTon(listaAux.getResumoIndicadores().getPerdaTon() + (prodAux.getQtdEmTon() * -1));
				}

				listaAux.getResumoIndicadores()
						.setSaldoUB(listaAux.getResumoIndicadores().getPerdaUB() + listaAux.getResumoIndicadores().getGanhoUB());
				listaAux.getResumoIndicadores()
						.setSaldoUM(listaAux.getResumoIndicadores().getPerdaUM() + listaAux.getResumoIndicadores().getGanhoUM());
				listaAux.getResumoIndicadores()
						.setSaldoKg(listaAux.getResumoIndicadores().getPerdaKg() + listaAux.getResumoIndicadores().getGanhoKg());
				listaAux.getResumoIndicadores()
						.setSaldoTon(listaAux.getResumoIndicadores().getPerdaTon() + listaAux.getResumoIndicadores().getGanhoTon());

			}
		}

		// resumo indicadores - ciclo padrao, medio e efic cic
		if (qtdOcorr > 0) {
			segCicloMedioMedio = AritmeticaUtil.dividir(new BigDecimal(segCicloMedioMedio), new BigDecimal(qtdOcorr)).doubleValue();
			segCicloPadraoMedio = AritmeticaUtil.dividir(new BigDecimal(segCicloPadraoMedio), new BigDecimal(qtdOcorr)).doubleValue();

			if (!cdProduto.equals("")) {
				listaAux.setResumoIndicadores(mapTotalProduto.get(cdProduto));
			}

			listaAux.getResumoIndicadores().setCicloMedio(segCicloMedioMedio);
			listaAux.getResumoIndicadores().setCicloPadrao(segCicloPadraoMedio);
			listaAux.getResumoIndicadores()
					.setEfiCic(FormulasInjet.calcularEficienciaCiclo(new BigDecimal(listaAux.getResumoIndicadores().getCicloPadrao()),
							new BigDecimal(listaAux.getResumoIndicadores().getCicloMedio())).doubleValue());

		}

		detalhamento = new ListaGraficoBIParetoDetCiclosOrdemProdutoDTO();
		detalhamento = listaAux;

		// totalizar qtds e tempo produtivo
		for (GraficoBIParetoDetCiclosOrdemProdutoDTO produto : detalhamento.getListaProdutos()) {
			produto.setQtdEmUB(0d);
			produto.setQtdEmUM(0d);
			produto.setQtdEmKg(0d);
			produto.setQtdEmTon(0d);

			for (GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO fictec : produto.getFictec()) {
				produto.setQtdEmUB(produto.getQtdEmUB() + fictec.getQtdEmUB());
				produto.setQtdEmUM(produto.getQtdEmUM() + fictec.getQtdEmUM());
				produto.setQtdEmKg(produto.getQtdEmKg() + fictec.getQtdEmKg());
				produto.setQtdEmTon(produto.getQtdEmTon() + fictec.getQtdEmTon());
				produto.setQtdCiclosExecutados(produto.getQtdCiclosExecutados() + fictec.getQtdCiclosExecutados());
				produto.setSegCiclosProdutivos(produto.getSegCiclosProdutivos() + fictec.getSegCiclosProdutivos());
			}
		}

		// ordenar fictecs do produto
		for (GraficoBIParetoDetCiclosOrdemProdutoDTO produto : detalhamento.getListaProdutos()) {

			if (ordemQtd.equals(ORDEM_UB)) {
				Collections.sort(produto.getFictec(), new Comparator<GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO>() {
					@Override
					public int compare(final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO o1,
							final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO o2) {
						final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO item1 = o1;
						final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO item2 = o2;
						return (item1.getQtdEmUB()).compareTo(item2.getQtdEmUB()) * -1;
					}
				});
			}

			if (ordemQtd.equals(ORDEM_PESO)) {
				Collections.sort(produto.getFictec(), new Comparator<GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO>() {
					@Override
					public int compare(final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO o1,
							final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO o2) {
						final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO item1 = o1;
						final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO item2 = o2;
						return (item1.getQtdEmKg()).compareTo(item2.getQtdEmKg()) * -1;
					}
				});
			}

			if (ordemQtd.equals(ORDEM_UM)) {
				Collections.sort(produto.getFictec(), new Comparator<GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO>() {
					@Override
					public int compare(final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO o1,
							final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO o2) {
						final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO item1 = o1;
						final GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO item2 = o2;
						return (item1.getQtdEmUM()).compareTo(item2.getQtdEmUM()) * -1;
					}
				});
			}

		}

		// ordenar lista de produtos
		if (ordemQtd.equals(ORDEM_UB)) {
			Collections.sort(detalhamento.getListaProdutos(), new Comparator<GraficoBIParetoDetCiclosOrdemProdutoDTO>() {
				@Override
				public int compare(final GraficoBIParetoDetCiclosOrdemProdutoDTO o1, final GraficoBIParetoDetCiclosOrdemProdutoDTO o2) {
					final GraficoBIParetoDetCiclosOrdemProdutoDTO item1 = o1;
					final GraficoBIParetoDetCiclosOrdemProdutoDTO item2 = o2;
					return (item1.getQtdEmUB()).compareTo(item2.getQtdEmUB()) * -1;
				}
			});

		}

		if (ordemQtd.equals(ORDEM_PESO)) {
			Collections.sort(detalhamento.getListaProdutos(), new Comparator<GraficoBIParetoDetCiclosOrdemProdutoDTO>() {
				@Override
				public int compare(final GraficoBIParetoDetCiclosOrdemProdutoDTO o1, final GraficoBIParetoDetCiclosOrdemProdutoDTO o2) {
					final GraficoBIParetoDetCiclosOrdemProdutoDTO item1 = o1;
					final GraficoBIParetoDetCiclosOrdemProdutoDTO item2 = o2;
					return (item1.getQtdEmKg()).compareTo(item2.getQtdEmKg()) * -1;
				}
			});

		}

		if (ordemQtd.equals(ORDEM_UM)) {
			Collections.sort(detalhamento.getListaProdutos(), new Comparator<GraficoBIParetoDetCiclosOrdemProdutoDTO>() {
				@Override
				public int compare(final GraficoBIParetoDetCiclosOrdemProdutoDTO o1, final GraficoBIParetoDetCiclosOrdemProdutoDTO o2) {
					final GraficoBIParetoDetCiclosOrdemProdutoDTO item1 = o1;
					final GraficoBIParetoDetCiclosOrdemProdutoDTO item2 = o2;
					return (item1.getQtdEmUM()).compareTo(item2.getQtdEmUM()) * -1;
				}
			});

		}

		return detalhamento;
	}

	/*
	 * Método que retorna o detalhamento de perdas/ganhos de todas as perdas
	 */

	public ListaGraficoBIParetoDetTodasDTO getDetalhamentoGraficoPerdasBITodasOrdemProduto(DetalheMonitorizacaoPTInjetDTO indicadores,
			Byte ordemQtd, String cdMaquina, String cdProduto, Boolean isConsiderarPerda, Boolean isConsiderarGanho) {
		final Byte ORDEM_UB = 1;
		final Byte ORDEM_PESO = 2;
		final Byte ORDEM_UM = 3;

		ListaGraficoBIParetoDetTodasDTO detalhamento = new ListaGraficoBIParetoDetTodasDTO();
		detalhamento.setResumoIndicadores(new ResumoParetoPerdasDetTodasDTO());
		GraficoBIParetoDetTodasDTO itemProduto = new GraficoBIParetoDetTodasDTO();

		BigDecimal segCicloPadrao = BigDecimal.ZERO;
		BigDecimal qtPcsCiclo = BigDecimal.ZERO;
		BigDecimal qtPcsCicloTotal = BigDecimal.ZERO;

		BigDecimal fatorContagem = BigDecimal.ONE;

		BigDecimal segCiclosProdutivos = BigDecimal.ZERO;
		BigDecimal segTempoCiclosProdutivosSemParadasVariacaoRitmo = BigDecimal.ZERO;
		BigDecimal segTempoparadaCpVr = BigDecimal.ZERO;
		BigDecimal segTempoparadaSpVr = BigDecimal.ZERO;

		BigDecimal segTempoAtivoAuto = BigDecimal.ZERO;
		BigDecimal segTempoAtivoManual = BigDecimal.ZERO;
		BigDecimal segTempoAtivo = BigDecimal.ZERO;

		BigDecimal qtCiclosProdutivos = BigDecimal.ZERO;
		BigDecimal segRitmo = BigDecimal.ZERO;

		BigDecimal qtPerdasCiclo = BigDecimal.ZERO;
		BigDecimal qtPerdasCicloKg = BigDecimal.ZERO;
		BigDecimal qtPerdasCicloTon = BigDecimal.ZERO;
		BigDecimal qtPerdasCicloUM = BigDecimal.ZERO;

		BigDecimal pesoBruto = BigDecimal.ZERO;
		BigDecimal valorUnitario = BigDecimal.ZERO;

		BigDecimal segTempoParCP = BigDecimal.ZERO;
		BigDecimal qtPerdasPar = BigDecimal.ZERO;
		BigDecimal qtPerdasParKg = BigDecimal.ZERO;
		BigDecimal qtPerdasParTon = BigDecimal.ZERO;
		BigDecimal qtPerdasParUM = BigDecimal.ZERO;

		BigDecimal qtPerdasPCI = BigDecimal.ZERO;
		BigDecimal qtPerdasPCIKg = BigDecimal.ZERO;
		BigDecimal qtPerdasPCITon = BigDecimal.ZERO;
		BigDecimal qtPerdasPCIUM = BigDecimal.ZERO;

		BigDecimal qtPrevista = BigDecimal.ZERO;
		BigDecimal qtPrevistaKg = BigDecimal.ZERO;
		BigDecimal qtPrevistaTon = BigDecimal.ZERO;

		BigDecimal qtBruta = BigDecimal.ZERO;
		BigDecimal qtRef = BigDecimal.ZERO;
		BigDecimal qtRefKg = BigDecimal.ZERO;
		BigDecimal qtRefTon = BigDecimal.ZERO;
		BigDecimal qtRefUM = BigDecimal.ZERO;

		BigDecimal qtBoas = BigDecimal.ZERO;
		BigDecimal qtBoasKg = BigDecimal.ZERO;
		BigDecimal qtBoasTon = BigDecimal.ZERO;

		BigDecimal efiRea = BigDecimal.ZERO;

		boolean isProdutoNaLista = false;

		detalhamento.setListaProdutos(new ArrayList<GraficoBIParetoDetTodasDTO>());

		for (DwConsolid dwci : indicadores.getListaDwConsolId()) {
			segCicloPadrao = dwci.getDwConsol().getSegAutoCiclopadrao();

			// sem filtro de máquina ou com filtro e máquina selecionada igual
			// ao filtro
			if ((cdMaquina.equals("")) || (cdMaquina.equals(dwci.getOmPt().getCdPt()))) {
				for (DwConsol dwc : dwci.getDwConsols()) {
					segCicloPadrao = dwc.getSegAutoCiclopadrao();

					// ciclos produtivos sem parada de varia��oo de ritmo
					segTempoparadaCpVr = dwc.getSegAutoTempoparadaCpVr();
					segTempoparadaCpVr = AritmeticaUtil.somar(segTempoparadaCpVr, dwc.getSegManuTempoparadaCpVr());

					segTempoparadaSpVr = dwc.getSegAutoTempoparadaSpVr();
					segTempoparadaSpVr = AritmeticaUtil.somar(segTempoparadaSpVr, dwc.getSegManuTempoparadaSpVr());

					segCiclosProdutivos = AritmeticaUtil.somar(dwc.getSegAutoCicloprodutivo() != null ? dwc.getSegAutoCicloprodutivo()
							: BigDecimal.ZERO, dwc.getSegManuCicloprodutivo() != null ? dwc.getSegManuCicloprodutivo() : BigDecimal.ZERO);

					segTempoCiclosProdutivosSemParadasVariacaoRitmo = segCiclosProdutivos.subtract(segTempoparadaCpVr).subtract(
							segTempoparadaSpVr);

					qtCiclosProdutivos = AritmeticaUtil.somar(dwc.getQtAutoCicloprodutivo() != null ? dwc.getQtAutoCicloprodutivo()
							: BigDecimal.ZERO, dwc.getQtManuCicloprodutivo() != null ? dwc.getQtManuCicloprodutivo() : BigDecimal.ZERO);

					segRitmo = (dwc.getSegAutoRitmo() != null ? dwc.getSegAutoRitmo() : BigDecimal.ZERO);

					segCiclosProdutivos = segTempoCiclosProdutivosSemParadasVariacaoRitmo;

					// temnpo ativo
					segTempoAtivoAuto = FormulasInjet.calcularTempoAtivo(dwc.getSegAutoCicloprodutivo(), dwc.getSegAutoTempoparadaCp(),
							dwc.getSegAutoCicloimprodutivo(), dwc.getSegAutoTempoparadaCpVr(), dwc.getSegAutoTempoparadaSpVr());

					segTempoAtivoManual = FormulasInjet.calcularTempoAtivo(dwc.getSegManuCicloprodutivo(), dwc.getSegManuTempoparadaCp(),
							dwc.getSegManuCicloimprodutivo(), dwc.getSegManuTempoparadaCpVr(), dwc.getSegManuTempoparadaSpVr());

					segTempoAtivo = AritmeticaUtil.somar(segTempoAtivoAuto, segTempoAtivoManual);

					// lista de paradas
					segTempoParCP = BigDecimal.ZERO;
					segTempoParCP = AritmeticaUtil.somar(dwc.getSegAutoTempoparadaCp() != null ? dwc.getSegAutoTempoparadaCp()
							: BigDecimal.ZERO, dwc.getSegManuTempoparadaCp() != null ? dwc.getSegManuTempoparadaCp() : BigDecimal.ZERO);

					for (DwConsolpr dwcpr : dwc.getDwConsolprs()) {
						// sem filtro de produto ou com filtro e máquina
						// selecionada igual ao filtro
						if ((cdProduto.equals("")) || (cdProduto.equals(dwcpr.getOmProduto().getCdProduto()))) {

							// pcs por ciclo ativas
							qtPcsCiclo = getPcsPorCicloAtivas(dwci.getDwFolha(), dwcpr.getOmProduto());

							fatorContagem = dwci.getDwFolha().getQtFatorcontagem();

							// pcs por ciclo totais
							qtPcsCicloTotal = getPcsPorCicloTotais(dwci.getDwFolha(), dwcpr.getOmProduto());

							// peso
							if (dwcpr.getOmProduto().getGPesoBruto() != null) {
								pesoBruto = dwcpr.getOmProduto().getGPesoBruto();
							} else {
								pesoBruto = BigDecimal.ZERO;
							}

							// custo
							if (dwcpr.getOmProduto().getVlCustounit() != null) {
								valorUnitario = dwcpr.getOmProduto().getVlCustounit();
							} else {
								valorUnitario = BigDecimal.ZERO;
							}

							// perdas ciclo
							qtPerdasCiclo = new BigDecimal(FormulasInjet.calcularPcsPerdaciclo(segRitmo, segCicloPadrao, qtPcsCiclo).doubleValue());

							// perdas em kg
							qtPerdasCicloKg = qtPerdasCiclo.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));

							// perdas em toneladas
							qtPerdasCicloTon = qtPerdasCiclo.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000000));

							// perdas em unidade monetária
							qtPerdasCicloUM = qtPerdasCiclo.multiply(valorUnitario);

							// perdas por parada
							qtPerdasPar = FormulasInjet.calcularPcsPerdaParada(segTempoParCP, segCicloPadrao, qtPcsCiclo);

							// perdas por parada em kg
							qtPerdasParKg = qtPerdasPar.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));

							// perdas por parada em toneladas
							qtPerdasParTon = qtPerdasPar.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000000));

							// valor
							qtPerdasParUM = qtPerdasPar.multiply(valorUnitario);

							// perdas por pcs/ciclo inativas
							qtPerdasPCI = FormulasInjet.calcularPerdaCavidade(qtCiclosProdutivos, qtPcsCicloTotal, qtPcsCiclo);

							// perdas por pcs/ciclo inativas em kg
							qtPerdasParKg = qtPerdasPCI.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));

							// perdas por pcs/ciclo inativas em toneladas
							qtPerdasParTon = qtPerdasPCI.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000000));

							// valor
							qtPerdasPCIUM = qtPerdasPCI.multiply(valorUnitario);

							// produ��oo bruta, refugada e boa
							qtBruta = AritmeticaUtil.somar(
									dwcpr.getPcsAutoProducaobruta() != null ? dwcpr.getPcsAutoProducaobruta()
											: BigDecimal.ZERO,
									dwcpr.getPcsManuProducaobruta() != null ? dwcpr.getPcsManuProducaobruta()
											: BigDecimal.ZERO);

							qtRef = AritmeticaUtil.somar(
									dwcpr.getPcsAutoProducaorefugada() != null ? dwcpr.getPcsAutoProducaorefugada()
											: BigDecimal.ZERO,
									dwcpr.getPcsManuProducaorefugada() != null ? dwcpr.getPcsManuProducaorefugada()
											: BigDecimal.ZERO);

							qtBoas = AritmeticaUtil.diminuir(qtBruta, qtRef);

							// em peso
							qtRefKg = qtRef.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));
							qtRefTon = qtRef.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));
							// valor
							qtRefUM = qtRef.multiply(valorUnitario);

							// qtd prevista
							qtPrevista = FormulasInjet.calcularProducaoPrevista(
									segTempoAtivo,
									segCicloPadrao,
									qtPcsCiclo,
									fatorContagem,
									dwci.getOmPt().getIndOee());

							// produ��oo boa e prevista em peso
							qtBoasKg = qtBoas.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));
							qtBoasTon = qtBoas.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000000));
							qtPrevistaKg = qtPrevista.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000));
							qtPrevistaTon = qtPrevista.multiply(new BigDecimal(pesoBruto.doubleValue() / 1000000));

							// efi realizacao
							efiRea = new BigDecimal(FormulasInjet.calcularEficienciaRealizacao(qtBoas, qtPrevista));

							// produto
							itemProduto = new GraficoBIParetoDetTodasDTO();
							itemProduto.setCdProduto(dwcpr.getOmProduto().getCdProduto());
							itemProduto.setDsProduto(dwcpr.getOmProduto().getDsProduto());

							itemProduto.setQtdPerdaEmUB(FormulasInjet.calcularTotalPerdas(qtPerdasCiclo.doubleValue(),
									qtPerdasPar.doubleValue(), qtRef.doubleValue(), qtPerdasPCI.doubleValue()).doubleValue());
							// itemProduto.setQtdPerdaEmUB(TOTAL_PERDAS_CICLO + TOTAL_PERDAS_REFUGO + TOTAL_PERDAS_PARADA +
							// TOTAL_PERDAS_PCI);

							itemProduto.setQtdPerdaEmUM(FormulasInjet.calcularTotalPerdas(qtPerdasCicloUM.doubleValue(),
									qtPerdasParUM.doubleValue(), qtRefUM.doubleValue(), qtPerdasPCIUM.doubleValue()).doubleValue());

							itemProduto.setQtdPerdaEmKg(FormulasInjet.calcularTotalPerdas(qtPerdasCicloKg.doubleValue(),
									qtPerdasParKg.doubleValue(), qtRefKg.doubleValue(), qtPerdasPCIKg.doubleValue()).doubleValue());

							itemProduto.setQtdPerdaEmTon(FormulasInjet.calcularTotalPerdas(qtPerdasCicloTon.doubleValue(),
									qtPerdasParTon.doubleValue(), qtRefTon.doubleValue(), qtPerdasPCITon.doubleValue()).doubleValue());

							itemProduto.setQtdBoas(qtBoas.doubleValue());
							itemProduto.setQtdBoasKg(qtBoasKg.doubleValue());
							itemProduto.setQtdBoasTon(qtBoasTon.doubleValue());

							itemProduto.setQtdPrevista(qtPrevista.doubleValue());
							itemProduto.setQtdPrevistaKg(qtPrevistaKg.doubleValue());
							itemProduto.setQtdPrevistaTon(qtPrevistaTon.doubleValue());

							itemProduto.setEfiRea(efiRea.doubleValue());

							// procura
							isProdutoNaLista = false;
							for (GraficoBIParetoDetTodasDTO produto : detalhamento.getListaProdutos()) {
								// produto está na lista?
								if (produto.getCdProduto().equals(itemProduto.getCdProduto())) {
									isProdutoNaLista = true;

									// acumula
									produto.setQtdPerdaEmUB(produto.getQtdPerdaEmUB() + itemProduto.getQtdPerdaEmUB());
									produto.setQtdPerdaEmUM(produto.getQtdPerdaEmUM() + itemProduto.getQtdPerdaEmUM());
									produto.setQtdPerdaEmKg(produto.getQtdPerdaEmKg() + itemProduto.getQtdPerdaEmKg());
									produto.setQtdPerdaEmTon(produto.getQtdPerdaEmTon() + itemProduto.getQtdPerdaEmTon());

									produto.setQtdBoas(produto.getQtdBoas() + itemProduto.getQtdBoas());
									produto.setQtdBoasKg(produto.getQtdBoasKg() + itemProduto.getQtdBoasKg());
									produto.setQtdBoasTon(produto.getQtdBoasTon() + itemProduto.getQtdBoasTon());

									produto.setQtdPrevista(produto.getQtdPrevista() + itemProduto.getQtdPrevista());
									produto.setQtdPrevistaKg(produto.getQtdPrevistaKg() + itemProduto.getQtdPrevistaKg());
									produto.setQtdPrevistaTon(produto.getQtdPrevistaTon() + itemProduto.getQtdPrevistaTon());

									efiRea = new BigDecimal(FormulasInjet.calcularEficienciaRealizacao(
											new BigDecimal(produto.getQtdBoas()), new BigDecimal(produto.getQtdPrevista())));

									produto.setEfiRea(efiRea.doubleValue());

									break;
								}
							}

							if (!isProdutoNaLista) {
								// adiciona produto
								detalhamento.getListaProdutos().add(itemProduto);
							}
						}
					}
				}
			}
		}

		// eliminar itens com perda zerada
		ListaGraficoBIParetoDetTodasDTO listaAux = new ListaGraficoBIParetoDetTodasDTO();
		listaAux.setResumoIndicadores(new ResumoParetoPerdasDetTodasDTO());
		listaAux.setListaProdutos(new ArrayList<GraficoBIParetoDetTodasDTO>());

		for (GraficoBIParetoDetTodasDTO produto : detalhamento.getListaProdutos()) {
			// arrendondar
			BigDecimal qtdPerda = new BigDecimal(produto.getQtdPerdaEmUB()).setScale(0, RoundingMode.FLOOR);
			produto.setQtdPerdaEmUB(qtdPerda.doubleValue());
			
			if ((produto.getQtdPerdaEmUB() != 0d)) {
				listaAux.getListaProdutos().add(produto);

				// resumo indicadores
				if (isConsiderarPerda && produto.getQtdPerdaEmUB() > 0) {
					listaAux.getResumoIndicadores().setPerdaUB(listaAux.getResumoIndicadores().getPerdaUB() + produto.getQtdPerdaEmUB());
					listaAux.getResumoIndicadores().setPerdaUM(listaAux.getResumoIndicadores().getPerdaUM() + produto.getQtdPerdaEmUM());
					listaAux.getResumoIndicadores().setPerdaKg(listaAux.getResumoIndicadores().getPerdaKg() + produto.getQtdPerdaEmKg());
					listaAux.getResumoIndicadores().setPerdaTon(listaAux.getResumoIndicadores().getPerdaTon() + produto.getQtdPerdaEmTon());
				}

				if (isConsiderarGanho && produto.getQtdPerdaEmUB() < 0) {
					listaAux.getResumoIndicadores()
							.setGanhoUB(listaAux.getResumoIndicadores().getGanhoUB() + (produto.getQtdPerdaEmUB() * -1));
					listaAux.getResumoIndicadores().setGanhoUM(listaAux.getResumoIndicadores().getPerdaUM() + produto.getQtdPerdaEmUM());
					listaAux.getResumoIndicadores()
							.setGanhoKg(listaAux.getResumoIndicadores().getPerdaKg() + (produto.getQtdPerdaEmKg() * -1));
					listaAux.getResumoIndicadores()
							.setGanhoTon(listaAux.getResumoIndicadores().getPerdaTon() + (produto.getQtdPerdaEmTon() * -1));
				}

				listaAux.getResumoIndicadores()
						.setSaldoUB(listaAux.getResumoIndicadores().getPerdaUB() + listaAux.getResumoIndicadores().getGanhoUB());
				listaAux.getResumoIndicadores()
						.setSaldoUM(listaAux.getResumoIndicadores().getPerdaUM() + listaAux.getResumoIndicadores().getGanhoUM());
				listaAux.getResumoIndicadores()
						.setSaldoKg(listaAux.getResumoIndicadores().getPerdaKg() + listaAux.getResumoIndicadores().getGanhoKg());
				listaAux.getResumoIndicadores()
						.setSaldoTon(listaAux.getResumoIndicadores().getPerdaTon() + listaAux.getResumoIndicadores().getGanhoTon());
			}
		}

		detalhamento = new ListaGraficoBIParetoDetTodasDTO();
		detalhamento = listaAux;

		// ordenar lista de produtos
		if (ordemQtd.equals(ORDEM_UB)) {
			Collections.sort(detalhamento.getListaProdutos(), new Comparator<GraficoBIParetoDetTodasDTO>() {
				@Override
				public int compare(final GraficoBIParetoDetTodasDTO o1, final GraficoBIParetoDetTodasDTO o2) {
					final GraficoBIParetoDetTodasDTO item1 = o1;
					final GraficoBIParetoDetTodasDTO item2 = o2;
					return (item1.getQtdPerdaEmUB()).compareTo(item2.getQtdPerdaEmUB()) * -1;
				}
			});

		}

		if (ordemQtd.equals(ORDEM_PESO)) {
			Collections.sort(detalhamento.getListaProdutos(), new Comparator<GraficoBIParetoDetTodasDTO>() {
				@Override
				public int compare(final GraficoBIParetoDetTodasDTO o1, final GraficoBIParetoDetTodasDTO o2) {
					final GraficoBIParetoDetTodasDTO item1 = o1;
					final GraficoBIParetoDetTodasDTO item2 = o2;
					return (item1.getQtdPerdaEmKg()).compareTo(item2.getQtdPerdaEmKg()) * -1;
				}
			});

		}

		if (ordemQtd.equals(ORDEM_UM)) {
			Collections.sort(detalhamento.getListaProdutos(), new Comparator<GraficoBIParetoDetTodasDTO>() {
				@Override
				public int compare(final GraficoBIParetoDetTodasDTO o1, final GraficoBIParetoDetTodasDTO o2) {
					final GraficoBIParetoDetTodasDTO item1 = o1;
					final GraficoBIParetoDetTodasDTO item2 = o2;
					return (item1.getQtdPerdaEmUM()).compareTo(item2.getQtdPerdaEmUM()) * -1;
				}
			});

		}

		return detalhamento;
	}

	public BigDecimal getPcsPorCicloAtivas(DwFolha dwFolha, OmProduto produto) {
		BigDecimal retorno = BigDecimal.ZERO;

		for (DwFolharap fr : dwFolha.getDwFolharaps()) {
			for (DwFolharapcom rc : fr.getDwFolharapcoms()) {
				if (rc.getOmProduto().getCdProduto().equals(produto.getCdProduto())) {
					retorno = rc.getQtAtiva();
					return retorno;
				}
			}
		}
		return retorno;
	}

	public BigDecimal getPcsPorCicloTotais(DwFolha dwFolha, OmProduto produto) {
		BigDecimal retorno = BigDecimal.ZERO;

		for (DwFolharap fr : dwFolha.getDwFolharaps()) {
			for (DwFolharapcom rc : fr.getDwFolharapcoms()) {
				if (rc.getOmProduto().getCdProduto().equals(produto.getCdProduto())) {
					retorno = rc.getQtTotal();
					return retorno;
				}
			}
		}

		return retorno;
	}
}
