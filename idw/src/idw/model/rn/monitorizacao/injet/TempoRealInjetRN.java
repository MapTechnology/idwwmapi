package idw.model.rn.monitorizacao.injet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;

import idw.model.dao.DAOGenerico;
import idw.model.dao.OmPtDAO;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwRt;
import idw.model.pojos.DwTParada;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmCfgind;
import idw.model.pojos.OmInd;
import idw.model.pojos.OmIndpt;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.pojos.template.DwRtTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.FuncoesApoioInjet;
import idw.model.rn.injet.PlanejamentoInjetRN;
import idw.model.rn.injet.TurnoInjetDTO;
import idw.model.rn.injet.TurnoInjetRN;
import idw.model.rn.injet.dto.RefugoInjetDTO;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.rest.dto.monitorizacao.injet.FiltroTempoRealMaquinaSulbrasDTO;
import idw.webservices.rest.dto.monitorizacao.injet.RtFolhaDTO;
import idw.webservices.rest.dto.monitorizacao.injet.TempoRealIHMWebDTO;
import idw.webservices.rest.dto.monitorizacao.injet.TempoRealMaquinaSulbrasDTO;
import idw.webservices.rest.dto.monitorizacao.injet.TempoRealSulbrasLoginDTO;
import idw.webservices.rest.dto.monitorizacao.injet.TempoRealSulbrasRefugoDTO;
import ms.util.ConversaoTipos;

public class TempoRealInjetRN extends AbstractRN<DAOGenericoInjet> {

	private static final int TOTAL_OPERADORES_COM_LOGIN_ABERTO_LISTA = 6;
	private static final int TOTAL_REFUGOS_LISTA = 4;
	private static final String COR_HEXA_PRETO = "#000000";
	private static final String COR_HEXA_AMARELO = "#ffeb3b";
	private static final String COR_HEXA_VERMELHO = "#F44336";
	private static final String COR_HEXA_VERDE = "#4caf50";
	private static final Long IR = 3l; // Índice de refugo
	private static final Long OEE = 5l; // OEE
	private static final Long RITMO = 2l; // Efic ciclo
	private static final Integer INTERVALO_EM_SEGUNDOS_TOTAL_REFUGOS_SMARTTV_SULBRAS = 30 * 60;

	public enum StFuncionamento {
		MAQUINA_PARADA(0), MAQUINA_TRABALHANDO(1), MAQUINA_SEM_CONEXAO(2);
		private final int value;

		StFuncionamento(int value) {
			this.value = value;
		}

		public boolean equals(Integer stCp) {
			return stCp != null && stCp.equals(value);
		}

		public int getValue() {
			return this.value;
		}
	}

	public TempoRealInjetRN() {
		super(new DAOGenericoInjet());
	}

	public TempoRealInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	/**
	 * Pega DwRt
	 * 
	 * @param dtReferencia
	 * @param idTurno
	 * @param idPt
	 * @param ppCp
	 * @param dwFolha
	 * @return
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	public RtFolhaDTO getDwRt(boolean isTurnoAtual, Date dtReferencia, Long idTurno, String cdPt, String nrOP) {
		int _nrop = 0;
		int _nropexibicao = _nrop + 1;
		int _cdmaquina = _nropexibicao + 1;
		int _cdmaqestendido = _cdmaquina + 1;
		int _cdidentific = _cdmaqestendido + 1;
		int _cdmolde = _cdidentific + 1;
		int _cdmolestendido = _cdmolde + 1;
		int _cdestrutura = _cdmolestendido + 1;
		int _dthrivalcic = _cdestrutura + 1;
		int _dthrivalestru = _dthrivalcic + 1;
		int _qtdalemanutprevmaq = _dthrivalestru + 1;
		int _qtdalemanutprevmol = _qtdalemanutprevmaq + 1;
		int _qtdoperlogados = _qtdalemanutprevmol + 1;
		int _idCIP = _qtdoperlogados + 1;
		int _stfuncionamento = _idCIP + 1;
		int _cdparada = _stfuncionamento + 1;
		int _paradacompeso = _cdparada + 1;
		int _maquinaemalerta = _paradacompeso + 1;
		int _aguardandomolde = _maquinaemalerta + 1;
		int _comparadamanutencao = _aguardandomolde + 1;
		int _comconsolidacaoematraso = _comparadamanutencao + 1;
		int _qtdprodplanop = _comconsolidacaoematraso + 1;
		int _qtdprodbruta = _qtdprodplanop + 1;
		int _qtdprodrefugada = _qtdprodbruta + 1;
		int _tempoultimociclo = _qtdprodrefugada + 1;
		int _fatorcontagemprod = _tempoultimociclo + 1;
		int _pcscicloativas = _fatorcontagemprod + 1;
		int _pcsciclototais = _pcscicloativas + 1;

		MonitorizacaoInjetRN rnM = new MonitorizacaoInjetRN();
		List<OmInd> listaCfgInd = rnM.getCfgIndInjet(getDao());

		class RegistroLido {
			String nrOP;
			String nrOPExibicao;
			String cdMaquina;
			String cdMaqEstendido;
			String cdIdentific;
			String cdMolde;
			String cdMolEstendido;
			String cdEstrutura;
			Date dtHrIValCic;
			Date dtHrIValEstru;
			Integer qtdAleManutPrevMaq;
			Integer qtdAleManutPrevMol;
			Integer qtdOperadoresLogados;
			String idCtrlIniProc;
			String stFuncionamento;
			String cdParada;
			Integer paradaComPeso;
			Integer maquinaEmAlerta;
			Integer aguardandoMolde;
			Character comParadaManutencao;
			Character comConsolidacaoEmAtraso;
			BigDecimal qtdProdPlan = BigDecimal.ZERO;
			BigDecimal qtdProdLiquidaOP = BigDecimal.ZERO;
			BigDecimal qtdProdBruta = BigDecimal.ZERO;
			BigDecimal qtdProdRefugada = BigDecimal.ZERO;
			BigDecimal segTempoUltimoCiclo = BigDecimal.ZERO;
			BigDecimal fatorContagemProd = BigDecimal.ZERO;
			BigDecimal qtdPcsCicloAtivas = BigDecimal.ZERO;
			BigDecimal qtdPcsCicloTotais = BigDecimal.ZERO;
			String stFuncionamentoOriginal;
		}

		String cdTurno = FuncoesApoioInjet.getCodigoPadraoInjet(idTurno.toString());
		Date dthrIniTur = null;
		Date dthrFimTur = null;
		DwTurno turnoVF = null;
		try {
			dthrIniTur = FuncoesApoioInjet.calcularInicioTurno(this.getDao(), dtReferencia, cdTurno);
			dthrFimTur = FuncoesApoioInjet.calcularFimTurno(this.getDao(), dtReferencia, cdTurno);

			TurnoInjetRN rnT = new TurnoInjetRN(getDao());
			turnoVF = rnT.getDwTurnoPorIdInjet(idTurno);

		} catch (SemCalendarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String strSQL = "";
		strSQL = strSQL.concat("SELECT b.nrop, b2.nropexibicao, b.cdinjetora, i.cdinjestendido, i.cdidentific,");
		strSQL = strSQL.concat("       b.cdmolde, m.cdmolestendido, b.cdestrutura, c.dthrivalcic, d.dthrivalestru,");
		strSQL = strSQL.concat("       e.Qtd as qtdaleManutPrevMaq, f.Qtd as qtdaleManutPrevMol, g.Qtd as qtdoperlog,");
		strSQL = strSQL.concat("       cip.IdCtrlInicProc, i.stfuncionamento, i.cdparada, ");
		strSQL = strSQL.concat(
				"       (CASE WHEN (rp.tempoparada IS NULL AND tp.saidademolde = 1) OR (rp.tempoparada = 1) THEN 1 ELSE 0 END) as ispesa, ");
		strSQL = strSQL.concat("       i.maquinaemalerta, i.aguardandomolde, ");
		strSQL = strSQL.concat("       ijs.stmanut, ijs.stdelayconsol, ");
		strSQL = strSQL.concat("       h.prodplanOP, v.qtprodbrutaUB as prodbruta, v.qtprodrefugadaUB as prodref, ");
		strSQL = strSQL.concat("       uc.tmpciclolido as tmpultimociclo, d.fatorcontagemprod, c2.qtcavativas, c2.qtcavidades ");
		strSQL = strSQL.concat("  FROM IJentsaiOPMAQ a ");
		strSQL = strSQL.concat("  JOIN ijop b ON (b.nrop = a.nrop AND b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijoproteiro b2 ON (b2.nrop = b.nrop) ");
		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol m ON (m.cdmolde = b.cdmolde) ");
		strSQL = strSQL
				.concat("  JOIN (SELECT nrop, SUM(qtpecasproduzir) as prodplanOP FROM ijopprodutos GROUP BY nrop) h ON (h.nrop = a.nrop) ");
		strSQL = strSQL.concat(
				"  JOIN (SELECT a.cdinjetora, a.cdmolde, a.cdestrutura, a.nrop, a.dtturno, a.cdturno,  max(a.dthrivalcic) as dthrivalcic ");
		strSQL = strSQL.concat("          FROM ijcnsturno a ");
		strSQL = strSQL.concat("          JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("         WHERE b.cdinjestendido = :cdmaquina ");
		strSQL = strSQL.concat("           AND a.dtturno = :dtturno ");
		strSQL = strSQL.concat("           AND a.cdturno = :cdturno ");

		if (!nrOP.equals("")) {
			strSQL = strSQL.concat("           AND nrop = :nrop ");
		}

		strSQL = strSQL.concat(
				"         GROUP BY a.cdinjetora, a.cdmolde, a.cdestrutura, a.nrop, a.dtturno, a.cdturno) c ON (c.cdinjetora = b.cdinjetora AND c.cdmolde = b.cdmolde AND c.cdestrutura = b.cdestrutura AND c.nrop = b.nrop)");
		strSQL = strSQL.concat(
				"  JOIN viewDadosCalcOEEOP v ON (v.cdinjetora = c.cdinjetora AND v.cdmolde = c.cdmolde AND v.cdestrutura = c.cdestrutura AND v.nrop = c.nrop AND v.cdinjetora = c.cdinjetora AND v.dtturno = c.dtturno AND v.cdturno = c.cdturno)");
		strSQL = strSQL.concat(
				"  JOIN ijfictec d ON (d.cdinjetora = c.cdinjetora AND d.cdmolde = c.cdmolde AND d.cdestrutura = c.cdestrutura AND d.dthrivalcic = c.dthrivalcic) ");
		strSQL = strSQL.concat(
				"  JOIN cavidades2 c2 ON (c2.cdmolde = d.cdmolde AND c2.cdestrutura = d.cdestrutura AND c2.dthrival = d.dthrivalestru) ");

		strSQL = strSQL.concat(
				"  LEFT JOIN (SELECT idrecurso, COUNT(*) as Qtd FROM ijalemanutprev WHERE TpRecurso = '01' AND StFimAleMP = '0' GROUP BY IdRecurso) e ON (e.IdRecurso = b.cdinjetora) ");
		strSQL = strSQL.concat(
				"  LEFT JOIN (SELECT idrecurso, COUNT(*) as Qtd FROM ijalemanutprev WHERE TpRecurso = '02' AND StFimAleMP = '0' GROUP BY IdRecurso) f ON (e.IdRecurso = b.cdmolde) ");
		strSQL = strSQL.concat(
				"  LEFT JOIN (SELECT cdinjetora, COUNT(*) as Qtd FROM IJlogOPE WHERE dthrlogout IS NULL GROUP BY cdinjetora) g ON (g.cdinjetora = b.cdinjetora) ");
		strSQL = strSQL.concat(
				"  LEFT JOIN IJctrlINIPROC cip ON (cip.CdInjetora  = b.cdinjetora AND cip.NrOP = b.NrOP AND cip.DtHrFimCtrlIniProc IS NULL) ");
		strSQL = strSQL.concat("  LEFT JOIN viewUltimoCicloOP uc ON (uc.nrop = b.nrop) ");
		strSQL = strSQL.concat("  LEFT JOIN ijreapar rp ON (rp.dthriparada = i.dthriparada AND rp.cdinjetora = i.cdinjetora) ");
		strSQL = strSQL.concat("  LEFT JOIN ijtbpar tp ON (tp.cdparada = i.cdparada) ");
		strSQL = strSQL.concat("  LEFT JOIN ijtbinjstatus ijs ON (ijs.cdinjetora = i.cdinjetora) ");
		strSQL = strSQL.concat(" WHERE i.cdinjestendido = :cdmaquina ");
		strSQL = strSQL.concat("   AND (");
		strSQL = strSQL.concat("           (a.DtHrEntrada BETWEEN :dthrini AND :dthrfim)   ");
		strSQL = strSQL.concat("        OR (a.DtHrSaida   BETWEEN :dthrini AND :dthrfim) ");
		strSQL = strSQL.concat("        OR (:dthrini      BETWEEN a.DtHrEntrada AND a.DtHrSaida) ");
		strSQL = strSQL.concat("        OR (:dthrini >= a.DtHrEntrada AND a.DtHrSaida IS NULL) ");
		strSQL = strSQL.concat("       )");
		strSQL = strSQL.concat(" ORDER BY a.DtHrEntrada DESC");

		Object[] registroLido = null;
		List<Object> listaReg = null;

		if (nrOP.equals("")) {
			listaReg = this.getDaoSession().createSQLQuery(strSQL)
					.setString("cdmaquina", cdPt)
					.setString("cdturno", cdTurno)
					.setTimestamp("dtturno", dtReferencia)
					.setTimestamp("dthrini", dthrIniTur)
					.setTimestamp("dthrfim", dthrFimTur)
					.list();
		} else {
			listaReg = this.getDaoSession().createSQLQuery(strSQL)
					.setString("cdmaquina", cdPt)
					.setString("cdturno", cdTurno)
					.setString("nrop", nrOP)
					.setTimestamp("dtturno", dtReferencia)
					.setTimestamp("dthrini", dthrIniTur)
					.setTimestamp("dthrfim", dthrFimTur)
					.list();
		}

		Object reg = null;

		if (listaReg.size() > 0) {
			reg = listaReg.get(0);
		}

		Object registroAux = (Object) reg;
		registroLido = (Object[]) registroAux;

		RtFolhaDTO retorno = new RtFolhaDTO();

		RegistroLido registro = new RegistroLido();
		if (registroAux == null) {
			int _sd_cdMaquina = 0;
			int _sd_cdMaqEstendido = _sd_cdMaquina + 1;
			int _sd_idMaquina = _sd_cdMaqEstendido + 1;
			int _sd_stFuncionamento = _sd_idMaquina + 1;
			int _sd_aguardandoMolde = _sd_stFuncionamento + 1;
			int _sd_opAtual = _sd_aguardandoMolde + 1;
			int _sd_cdMolde = _sd_opAtual + 1;
			int _sd_cdEstrutura = _sd_cdMolde + 1;
			int _sd_pcsCicTotais = _sd_cdEstrutura + 1;
			int _sd_pcsCicAtivas = _sd_pcsCicTotais + 1;

			// simular aguradando molde se for o caso
			strSQL = "";
			strSQL = strSQL.concat(
					"SELECT a.cdinjetora, a.cdinjestendido, a.cdidentific, a.stfuncionamento, a.aguardandomolde, a.opatual, a.cdmoldeatual, a.cdestruturaatual, c2.qtcavtotais, c2.qtcavativas ");
			strSQL = strSQL.concat("  FROM ijtbinj a ");
			strSQL = strSQL
					.concat("  LEFT JOIN (SELECT cdmolde, cdestrutura, SUM(qtcavidades) as qtcavtotais, SUM(qtcavativas) as qtcavativas  ");
			strSQL = strSQL.concat("               FROM ijmolpro mp ");
			strSQL = strSQL.concat("              WHERE dthrfval IS NULL ");
			strSQL = strSQL.concat(
					"              GROUP by cdmolde, cdestrutura) c2 ON (c2.cdmolde = a.cdmoldeatual AND c2.cdestrutura = a.cdestruturaatual) ");
			strSQL = strSQL.concat(" WHERE a.cdinjestendido = '" + cdPt + "'");

			Object[] registroSemDados = null;
			List<Object> listaRegSemDados = this.getDaoSession().createSQLQuery(strSQL).list();

			Object regSemDados = listaRegSemDados.get(0);
			registroAux = (Object) regSemDados;
			registroLido = (Object[]) registroAux;

			registro.cdMaquina = (String) registroLido[_sd_cdMaquina];
			registro.cdMaqEstendido = (String) registroLido[_sd_cdMaqEstendido];
			registro.cdIdentific = (String) registroLido[_sd_idMaquina];

			if (registroLido[_sd_opAtual] != null) {
				registro.nrOP = (String) registroLido[_sd_opAtual];
				registro.qtdProdLiquidaOP = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(getProducaoLiquidaOP(registro.nrOP));
				registro.qtdProdPlan = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(getProducaoPlanejadaOP(registro.nrOP));

				if (registroLido[_sd_pcsCicTotais] != null) {
					registro.cdMolde = (String) registroLido[_sd_cdMolde];
					registro.cdEstrutura = (String) registroLido[_sd_cdEstrutura];
					registro.qtdPcsCicloAtivas = ConfiguracoesInjetRN
							.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_sd_pcsCicAtivas]));
					registro.qtdPcsCicloTotais = ConfiguracoesInjetRN
							.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_sd_pcsCicTotais]));
				}
			}

			registro.comConsolidacaoEmAtraso = 0;
			registro.comParadaManutencao = 0;
			registro.cdParada = "";
			registro.paradaComPeso = 0;
			registro.maquinaEmAlerta = 0;
			registro.stFuncionamentoOriginal = (String) registroLido[_sd_stFuncionamento];

			if (isTurnoAtual) {
				registro.stFuncionamento = (String) registroLido[_sd_stFuncionamento];
				registro.aguardandoMolde = ConversaoTipos.converterParaBigDecimal(registroLido[_sd_aguardandoMolde]).intValue();
				registro.paradaComPeso = 1;
				if (registro.stFuncionamento.equals("2")) {
					// sem conexao
					registro.aguardandoMolde = 0;
					registro.paradaComPeso = 0;
				}

			} else {
				String stFuncionamento = getStFuncionamento(cdPt, registro.nrOP, dtReferencia, cdTurno);
				registro.stFuncionamento = stFuncionamento;
				registro.aguardandoMolde = 0;
			}

			// rt
			DwRt oDwRt = new DwRt();

			OmPt omPt = (new OmPtDAO(getDaoSession())).getOmPtAtivoComUltimaRevisaoInjet(getDao(), cdPt);
			omPt.setIsConsolpendente((registro.comConsolidacaoEmAtraso.toString().equals("1")));

			oDwRt.setOmPt(omPt);
			oDwRt.setIsOffline((registro.stFuncionamento.equals("2")));
			oDwRt.setIsGargalodinamico(false);
			oDwRt.setIsGargaloteorico(false);
			oDwRt.setIsAlerta((registro.maquinaEmAlerta == 1));
			oDwRt.setIsSemplanejamento((registro.aguardandoMolde == 1));

			oDwRt.setDtReferencia(dtReferencia);
			oDwRt.setDwTurno(turnoVF);
			oDwRt.setIsOperador(false);
			oDwRt.setDthrHeartbeat(new Date());
			oDwRt.setStFuncionamento(ConversaoTipos.converterParaByte(registro.stFuncionamento));
			oDwRt.setIsParadapeso((registro.paradaComPeso == 1));
			oDwRt.setIsManutencaopre(false);
			oDwRt.setIsCip(false);
			oDwRt.setPcsProducaoplanejadaOp(registro.qtdProdPlan);
			oDwRt.setPcsProducaoliquidaOp(registro.qtdProdLiquidaOP);
			oDwRt.setSegUltimociclo(BigDecimal.ZERO);

			oDwRt.setIsManutencaopre(false);
			oDwRt.setIsVidautilmolde(false);

			// folha
			DwFolha oFolha = new DwFolha();

			if (registro.qtdPcsCicloTotais.doubleValue() > 0d) {
				oFolha.setDwFolharaps(new HashSet<DwFolharap>());
				oFolha.setCdFolha(registro.cdMolde + "/" + registro.cdEstrutura);
				oFolha.setDsFolha(oFolha.getCdFolha());
				oFolha.setQtFatorcontagem(BigDecimal.ONE); // nao eh relevante pro contexto (a ficha nao serah montada)

				DwFolharap ofRap = new DwFolharap();
				ofRap.setDwFolharapcoms(new HashSet<DwFolharapcom>());
				DwFolharapcom ofRapCom = new DwFolharapcom();
				ofRapCom.setQtAtiva(registro.qtdPcsCicloAtivas);
				ofRapCom.setQtTotal(registro.qtdPcsCicloTotais);

				ofRap.getDwFolharapcoms().add(ofRapCom);
				oFolha.getDwFolharaps().add(ofRap);
			}

			// retorno
			retorno.setFolha(oFolha);
			retorno.setRt(oDwRt);

		} else {
			registro.nrOP = (String) registroLido[_nrop];
			registro.nrOPExibicao = (String) registroLido[_nropexibicao];
			registro.cdMaquina = (String) registroLido[_cdmaquina];
			registro.cdMaqEstendido = (String) registroLido[_cdmaqestendido];
			registro.cdIdentific = (String) registroLido[_cdidentific];
			registro.cdMolde = (String) registroLido[_cdmolde];
			registro.cdMolEstendido = (String) registroLido[_cdmolestendido];
			registro.cdEstrutura = (String) registroLido[_cdestrutura];
			registro.dtHrIValCic = (Date) registroLido[_dthrivalcic];
			registro.dtHrIValEstru = (Date) registroLido[_dthrivalestru];

			registro.idCtrlIniProc = (registroLido[_idCIP] != null ? (String) registroLido[_idCIP] : null);

			registro.comConsolidacaoEmAtraso = 0;
			registro.comParadaManutencao = 0;
			registro.cdParada = "";
			registro.stFuncionamentoOriginal = (String) registroLido[_stfuncionamento];

			if (isTurnoAtual) {
				registro.stFuncionamento = (String) registroLido[_stfuncionamento];
				registro.paradaComPeso = ConversaoTipos.converterParaBigDecimal(registroLido[_paradacompeso]).intValue();
				registro.maquinaEmAlerta = ConversaoTipos.converterParaBigDecimal(registroLido[_maquinaemalerta]).intValue();
				registro.aguardandoMolde = ConversaoTipos.converterParaBigDecimal(registroLido[_aguardandomolde]).intValue();

				if (registroLido[_comconsolidacaoematraso] != null) {
					registro.comConsolidacaoEmAtraso = (Character) registroLido[_comconsolidacaoematraso];
				}

				if (registroLido[_comparadamanutencao] != null) {
					registro.comParadaManutencao = (Character) registroLido[_comparadamanutencao];
				}

				if (registroLido[_cdparada] != null) {
					registro.cdParada = (String) registroLido[_cdparada];
				}

			} else {
				String stFuncionamento = getStFuncionamento(cdPt, registro.nrOP, dtReferencia, cdTurno);
				registro.stFuncionamento = stFuncionamento;
				registro.paradaComPeso = 0;
				registro.aguardandoMolde = 0;

				if (registro.stFuncionamento.equals(ConversaoTipos.converterParaString(DwRtTemplate.StFuncionamento.PARADA.getId()))) {
					registro.paradaComPeso = getParadaComPeso(cdPt, registro.nrOP, dtReferencia, cdTurno);
				}

				registro.maquinaEmAlerta = 0;
			}

			// teste pra sem molde (igual ao injet) >> Defeito #6525
			if (ConversaoTipos.converterParaBigDecimal(registroLido[_aguardandomolde]).intValue() == 1
					&& (registro.stFuncionamentoOriginal.equals("0") || registro.stFuncionamentoOriginal.equals("1"))) {
				registro.aguardandoMolde = 1;
			}

			// correcao teste viqua
			registro.qtdAleManutPrevMaq = (registroLido[_qtdalemanutprevmaq] != null
					? ConversaoTipos.converterParaBigDecimal(registroLido[_qtdalemanutprevmaq]).intValue() : 0);
			registro.qtdAleManutPrevMol = (registroLido[_qtdalemanutprevmol] != null
					? ConversaoTipos.converterParaBigDecimal(registroLido[_qtdalemanutprevmol]).intValue() : 0);

			// diferenca de tipos entre bancos injet oracle e sql forcou conversao para bigdecimal
			registro.qtdOperadoresLogados = (registroLido[_qtdoperlogados] != null
					? ConversaoTipos.converterParaBigDecimal(registroLido[_qtdoperlogados]).intValue() : 0);

			registro.qtdProdPlan = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos
					.converterParaBigDecimal(registroLido[_qtdprodplanop] != null ? registroLido[_qtdprodplanop] : BigDecimal.ZERO));

			registro.qtdProdLiquidaOP = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(getProducaoLiquidaOP(registro.nrOP));
			registro.qtdProdBruta = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos
					.converterParaBigDecimal(registroLido[_qtdprodbruta] != null ? registroLido[_qtdprodbruta] : BigDecimal.ZERO));
			registro.qtdProdRefugada = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos
					.converterParaBigDecimal(registroLido[_qtdprodrefugada] != null ? registroLido[_qtdprodrefugada] : BigDecimal.ZERO));

			registro.segTempoUltimoCiclo = ConversaoTipos
					.converterParaBigDecimal(registroLido[_tempoultimociclo] != null ? registroLido[_tempoultimociclo] : BigDecimal.ZERO);
			registro.fatorContagemProd = ConversaoTipos.converterParaBigDecimal(registroLido[_fatorcontagemprod]);

			registro.qtdPcsCicloAtivas = ConfiguracoesInjetRN
					.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcscicloativas]));
			registro.qtdPcsCicloTotais = ConfiguracoesInjetRN
					.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsciclototais]));

			// rt
			DwRt oDwRt = new DwRt();

			OmPt omPt = (new OmPtDAO(getDaoSession())).getOmPtAtivoComUltimaRevisaoInjet(getDao(), cdPt);
			omPt.setIsConsolpendente((registro.comConsolidacaoEmAtraso.toString().equals("1")));
			omPt.setOmIndpts(new HashSet<OmIndpt>());

			PpCp ppCp = (new PlanejamentoInjetRN()).pesquisarPpCpByCdPtInjet(getDao(), omPt, registro.nrOP).get(0);

			oDwRt.setOmPt(omPt);
			oDwRt.setPpCp(ppCp);

			if (isTurnoAtual) {
				oDwRt.setIsOffline((registro.stFuncionamento.equals("2")));
			} else {
				oDwRt.setIsOffline(false);
			}
			oDwRt.setIsGargalodinamico(false);
			oDwRt.setIsGargaloteorico(false);
			oDwRt.setIsAlerta((registro.maquinaEmAlerta == 1));
			oDwRt.setIsSemplanejamento((registro.aguardandoMolde == 1));

			oDwRt.setDtReferencia(dtReferencia);
			oDwRt.setDwTurno(turnoVF);
			oDwRt.setIsOperador(registro.qtdOperadoresLogados > 0);
			oDwRt.setDthrHeartbeat(new Date());
			oDwRt.setStFuncionamento(ConversaoTipos.converterParaByte(registro.stFuncionamento));
			oDwRt.setIsParadapeso((registro.paradaComPeso == 1));
			oDwRt.setIsManutencaopre((registro.qtdAleManutPrevMaq > 0) || (registro.qtdAleManutPrevMol > 0));
			oDwRt.setIsCip(!(registro.idCtrlIniProc == null));
			oDwRt.setPcsProducaoplanejadaOp(registro.qtdProdPlan);
			oDwRt.setPcsProducaoliquidaOp(registro.qtdProdLiquidaOP);
			oDwRt.setSegUltimociclo(registro.segTempoUltimoCiclo);

			if (isTurnoAtual) {
				oDwRt.setIsManutencaopre(isManutPrevMaq(registro.cdMaquina) || isManutPrevMol(registro.cdMolde));
				oDwRt.setIsVidautilmolde(isAlertaVidaUtilMolde(registro.cdMolde));

				if (registro.stFuncionamento.equals(ConversaoTipos.converterParaString(DwRtTemplate.StFuncionamento.PARADA.getId()))) {
					DwTParada par = new DwTParada();
					par.setCdTparada(registro.cdParada);
					par.setIsPesa(oDwRt.getIsParadapeso());

					if (registro.comParadaManutencao.toString().equals("1")) {
						par.setIsMtbf(true);
					}

					DwConsolpalog palog = new DwConsolpalog();
					palog.setDwTParada(par);
					oDwRt.setDwConsolpalog(palog);
				}

			} else {
				oDwRt.setIsManutencaopre(false);
				oDwRt.setIsVidautilmolde(false);
			}

			// folha
			DwFolha oFolha = new DwFolha();
			oFolha.setDwFolharaps(new HashSet<DwFolharap>());
			oFolha.setCdFolha(registro.cdMolde + "/" + registro.cdEstrutura);
			oFolha.setDsFolha(oFolha.getCdFolha());
			oFolha.setQtFatorcontagem(registro.fatorContagemProd);

			DwFolharap ofRap = new DwFolharap();
			ofRap.setDwFolharapcoms(new HashSet<DwFolharapcom>());
			DwFolharapcom ofRapCom = new DwFolharapcom();
			ofRapCom.setQtAtiva(registro.qtdPcsCicloAtivas);
			ofRapCom.setQtTotal(registro.qtdPcsCicloTotais);

			ofRap.getDwFolharapcoms().add(ofRapCom);
			oFolha.getDwFolharaps().add(ofRap);

			// retorno
			retorno.setFolha(oFolha);
			retorno.setRt(oDwRt);
		}

		for (OmInd ind : listaCfgInd) {
			OmIndpt indPt = new OmIndpt();
			OmCfgind cfgInd = ind.getOmCfginds().iterator().next();
			indPt.setOmInd(ind);
			indPt.setIndInferior(cfgInd.getIndInferior());
			indPt.setIndMeta(cfgInd.getIndMeta());
			indPt.setIndSuperior(cfgInd.getIndSuperior());

			retorno.getRt().getOmPt().getOmIndpts().add(indPt);
		}

		return retorno;
	}

	@SuppressWarnings("unchecked")
	public BigDecimal getProducaoLiquidaOP(String nrOP) {
		BigDecimal producaoLiquida = BigDecimal.ZERO;
		String strSQL;

		// producao liquida da op
		strSQL = "";
		strSQL = strSQL.concat("SELECT (qtprodbrutaUB - qtprodrefugadaUB) as prodliquidaop  ");
		strSQL = strSQL.concat("  FROM viewProducaoOP ");
		strSQL = strSQL.concat(" WHERE nrop = '" + nrOP + "'");

		List<Object> listaProdOP = this.getDaoSession().createSQLQuery(strSQL).list();

		// problemas teste VIQUA - base injet inconsistente
		if (listaProdOP.size() > 0) {
			Object regProdOP = listaProdOP.get(0);

			if (regProdOP != null) {
				producaoLiquida = ConversaoTipos.converterParaBigDecimal(regProdOP);
			}
		}

		return producaoLiquida;
	}

	@SuppressWarnings("unchecked")
	public BigDecimal getProducaoPlanejadaOP(String nrOP) {
		BigDecimal producaoPlanejada = BigDecimal.ZERO;
		String strSQL;

		// producao planejada
		strSQL = "";
		strSQL = strSQL.concat("SELECT SUM(qtpecasproduzir) as qtpecasproduzir ");
		strSQL = strSQL.concat("  FROM ijopprodutos ");
		strSQL = strSQL.concat(" WHERE nrop = '" + nrOP + "'");

		List<Object> listaProdOP = this.getDaoSession().createSQLQuery(strSQL).list();

		Object regProdOP = listaProdOP.get(0);

		if (regProdOP != null) {
			producaoPlanejada = ConversaoTipos.converterParaBigDecimal(regProdOP);
		}

		return producaoPlanejada;
	}

	public BigDecimal getUltimoCiclo(boolean isTurnoAtual, List<DwConsolid> ids, FiltroDetalhePTInjetDTO filtro) {
		BigDecimal retorno = BigDecimal.ZERO;

		if (filtro.getTpId() != null) {
			if (filtro.getTpId().equals(DwConsolidTemplate.TpId.ACUMULADO.getValue())
					|| filtro.getTpId().equals(DwConsolidTemplate.TpId.OP.getValue())) {
				retorno = getUltimoCicloOP(filtro.getCdCp());
			} else if (filtro.getTpId().equals(DwConsolidTemplate.TpId.TURNO.getValue())) {
				RtFolhaDTO rtf = getDwRt(isTurnoAtual, filtro.getDtReferencia(), filtro.getDwTurno().getIdTurno(),
						filtro.getOmPt().getCdPt(), filtro.getCdCp());
				retorno = rtf.getRt().getSegUltimociclo();
			}
		}

		return retorno;
	}

	@SuppressWarnings("unchecked")
	private BigDecimal getUltimoCicloOP(String nrOP) {
		BigDecimal retorno = BigDecimal.ZERO;

		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.TmpCicloLido ");
		strSQL = strSQL.concat("  FROM viewUltimoCicloOP a ");
		strSQL = strSQL.concat(" WHERE a.nrop = :nrop ");

		List<Object> listaReg = this.getDaoSession().createSQLQuery(strSQL)
				.setString("nrop", nrOP)
				.list();

		Object reg = null;
		Object[] registroLido = null;

		if (listaReg.size() > 0) {
			reg = listaReg.get(0);
		}

		Object registroAux = (Object) reg;
		registroLido = (Object[]) registroAux;

		if (registroAux != null) {
			retorno = ConversaoTipos.converterParaBigDecimal(registroLido[0] != null ? registroLido[0] : BigDecimal.ZERO);
		}

		return retorno;

	}

	@SuppressWarnings("unchecked")
	public boolean isCipExtrapolado(String cdPt) {
		boolean retorno = false;

		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.QtAleParCIP ");
		strSQL = strSQL.concat("  FROM IJtbINJALERTA a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat(" WHERE b.cdinjestendido = '" + cdPt + "'");

		List<Object> listaReg = this.getDaoSession().createSQLQuery(strSQL).list();

		Object reg = null;
		if (listaReg.size() > 0) {
			reg = listaReg.get(0);

			Object registroAux = (Object) reg;
			BigDecimal qtdAleCIP = ConversaoTipos.converterParaBigDecimal(registroAux);
			retorno = (qtdAleCIP.intValue() > 0);
		}

		return retorno;
	}

	@SuppressWarnings("unchecked")
	public String getStFuncionamento(String cdPt, String nrOP, Date dtTurno, String cdTurno) {
		String retorno = "2"; // sem conexao / sem dados

		Date dthrFimPar = null;
		Date dthrFimCic = null;

		String strSQL = "";

		if (nrOP == null) {
			nrOP = "";
		}

		// fim da ultima parada do periodo
		strSQL = strSQL.concat("SELECT MAX(a.dthrfpar) as dthrfpar ");
		strSQL = strSQL.concat("  FROM ijreaparcnsocorTUR a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat(" WHERE b.cdinjestendido = :cdmaquina ");
		if (!nrOP.equals("")) {
			strSQL = strSQL.concat(" AND a.nrop = :nrop ");
		}
		strSQL = strSQL.concat("   AND a.dtturno = :dtturno ");
		strSQL = strSQL.concat("   AND a.cdturno = :cdturno ");

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

		q.setString("cdmaquina", cdPt)
				.setTimestamp("dtturno", dtTurno)
				.setString("cdturno", cdTurno);

		if (!nrOP.equals("")) {
			q.setString("nrop", nrOP);
		}

		List<Object> listaReg = q.list();

		Object reg = null;
		if (listaReg.size() > 0) {
			reg = listaReg.get(0);

			Object registroAux = (Object) reg;
			dthrFimPar = (Date) registroAux;
		}

		// fim do ultiumo ciclo do periodo
		Date dthrITur = null;
		Date dthrFTur = null;

		try {
			dthrITur = FuncoesApoioInjet.calcularInicioTurno(this.getDao(), dtTurno, cdTurno);
			dthrFTur = FuncoesApoioInjet.calcularFimTurno(this.getDao(), dtTurno, cdTurno);
		} catch (SemCalendarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// vefifica se houve producoa no turno
		strSQL = "";
		strSQL = strSQL.concat("SELECT (a.QTINJNORMAL + a.QTINJFINPARADA + a.QTINJNAPARADA) as qtdinj ");
		strSQL = strSQL.concat("  FROM ijcnsturno a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat(" WHERE b.cdinjestendido = :cdmaquina ");
		if (!nrOP.equals("")) {
			strSQL = strSQL.concat(" AND a.nrop = :nrop ");
		}
		strSQL = strSQL.concat("   AND a.dtturno = :dtturno ");
		strSQL = strSQL.concat("   AND a.cdturno = :cdturno ");

		q = this.getDaoSession().createSQLQuery(strSQL);

		q.setString("cdmaquina", cdPt)
				.setTimestamp("dtturno", dtTurno)
				.setString("cdturno", cdTurno);

		if (!nrOP.equals("")) {
			q.setString("nrop", nrOP);
		}

		listaReg = q.list();
		reg = null;
		if (listaReg.size() > 0) {
			reg = listaReg.get(0);

			Object registroAux = (Object) reg;
			BigDecimal qtdCiclos = ConversaoTipos.converterParaBigDecimal(registroAux);

			if (qtdCiclos.doubleValue() > 0) {
				dthrFimCic = dthrFTur;
			}
		}

		if (dthrFimPar != null && dthrFimCic != null) {
			if (DataHoraRN.after(dthrFimPar, dthrFimCic) || DataHoraRN.equal(dthrFimPar, dthrFimCic)) {
				retorno = ConversaoTipos.converterParaString(DwRtTemplate.StFuncionamento.PARADA.getId());
			} else {
				retorno = ConversaoTipos.converterParaString(DwRtTemplate.StFuncionamento.PRODUZINDO.getId());
			}
		} else {
			if (dthrFimPar != null) {
				retorno = ConversaoTipos.converterParaString(DwRtTemplate.StFuncionamento.PARADA.getId());

			} else {
				if (dthrFimCic != null) {
					retorno = ConversaoTipos.converterParaString(DwRtTemplate.StFuncionamento.PRODUZINDO.getId());
				} else {
					// Defeito #6525 - Web: na tela de monitoramento web os ícones das máquinas ficam nas cores diferentes do injet
					// maquina com parada aberta, sem dados em ijcnsturno no periodo avaliado (bug da base, mas no injet mostra como parada)
					int _dthrIniPar = 0;
					int _dthrFimPar = 1;

					// verifica se tem parada aberta
					strSQL = "";
					strSQL = strSQL.concat("SELECT a.DtHrIParada, a.DtHrFParada ");
					strSQL = strSQL.concat("   FROM IJreaPAR a ");
					strSQL = strSQL.concat(" WHERE a.CdInjetora  = :cdmaquina ");
					strSQL = strSQL.concat("   AND(   (a.DtHrIParada BETWEEN :dthrITur AND :dthrFTur) ");
					strSQL = strSQL.concat("       OR (a.DtHrFParada BETWEEN :dthrITur AND :dthrFTur) ");
					strSQL = strSQL.concat("       OR (:dthrITur BETWEEN a.DtHrIParada AND a.DtHrFParada) ");
					strSQL = strSQL.concat("       OR (a.DtHrFParada IS NULL and a.DtHrIParada <= :dthrITur)  ) ");
					strSQL = strSQL.concat(" ORDER BY a.DtHrIParada DESC");

					q = this.getDaoSession().createSQLQuery(strSQL);

					q.setString("cdmaquina", cdPt)
							.setTimestamp("dthrITur", dthrITur)
							.setTimestamp("dthrFTur", dthrFTur)
							.setMaxResults(1);

					listaReg = q.list();
					reg = null;
					if (listaReg.size() > 0) {
						reg = listaReg.get(0);
						Object[] registroLido = null;
						Object registroLidoAux = (Object) reg;
						registroLido = (Object[]) registroLidoAux;

						if (registroLido[_dthrIniPar] != null) {
							retorno = ConversaoTipos.converterParaString(DwRtTemplate.StFuncionamento.PARADA.getId());
						}

					}
				}
			}
		}

		return retorno;
	}

	@SuppressWarnings("unchecked")
	public Integer getParadaComPeso(String cdPt, String nrOP, Date dtTurno, String cdTurno) {
		Integer retorno = 0;
		String pesa = "0";

		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.ParadaComPeso ");
		strSQL = strSQL.concat("  FROM ijreaparcnsocorTUR a ");
		strSQL = strSQL.concat("  JOIN ( ");
		strSQL = strSQL.concat("         SELECT a.cdinjetora,  MAX(a.dthripar) as dthripar ");
		strSQL = strSQL.concat("           FROM ijreaparcnsocorTUR a ");
		strSQL = strSQL.concat("           JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("          WHERE b.cdinjestendido = :cdmaquina ");
		strSQL = strSQL.concat("            AND a.dtturno = :dtturno ");
		strSQL = strSQL.concat("            AND a.cdturno = :cdturno ");
		if (!nrOP.equals("")) {
			strSQL = strSQL.concat("       AND a.nrop = :nrop ");
		}
		strSQL = strSQL.concat("        GROUP BY a.cdinjetora) b ON (b.cdinjetora = a.cdinjetora AND b.dthripar = a.dthripar) ");

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

		q.setString("cdmaquina", cdPt)
				.setTimestamp("dtturno", dtTurno)
				.setString("cdturno", cdTurno);

		if (!nrOP.equals("")) {
			q.setString("nrop", nrOP);
		}

		List<Object> listaReg = q.list();

		Object reg = null;
		if (listaReg.size() > 0) {
			reg = listaReg.get(0);

			Object registroAux = (Object) reg;
			pesa = ((Character) registroAux).toString();
		}

		retorno = ConversaoTipos.converteParaInt(pesa);

		return retorno;
	}

	@SuppressWarnings("unchecked")
	private boolean isManutPrevMaq(String cdMaqPKey) {
		boolean retorno = false;

		String strSQL = "";
		strSQL = strSQL.concat("SELECT COUNT(*) as Qtd ");
		strSQL = strSQL.concat("  FROM ijalemanutprev a ");
		strSQL = strSQL.concat(" WHERE a.IdRecurso = '" + cdMaqPKey + "' ");
		strSQL = strSQL.concat("   AND a.TpRecurso = '01' ");
		strSQL = strSQL.concat("   AND a.StFimAleMP = '0' ");

		List<Object> listaReg = this.getDaoSession().createSQLQuery(strSQL).list();

		Object reg = null;
		if (listaReg.size() > 0) {
			reg = listaReg.get(0);

			Object registroAux = (Object) reg;
			if (registroAux != null) {
				Integer qtd = ConversaoTipos.converterParaBigDecimal(registroAux).intValue();
				retorno = (qtd > 0);
			}
		}

		return retorno;
	}

	@SuppressWarnings("unchecked")
	private boolean isManutPrevMol(String cdMolPKey) {
		boolean retorno = false;

		String strSQL = "";
		strSQL = strSQL.concat("SELECT COUNT(*) as Qtd ");
		strSQL = strSQL.concat("  FROM ijalemanutprev a ");
		strSQL = strSQL.concat(" WHERE a.IdRecurso = '" + cdMolPKey + "' ");
		strSQL = strSQL.concat("   AND a.TpRecurso = '02' ");
		strSQL = strSQL.concat("   AND a.StFimAleMP = '0' ");

		List<Object> listaReg = this.getDaoSession().createSQLQuery(strSQL).list();

		Object reg = null;
		if (listaReg.size() > 0) {
			reg = listaReg.get(0);

			Object registroAux = (Object) reg;
			if (registroAux != null) {
				Integer qtd = ConversaoTipos.converterParaBigDecimal(registroAux).intValue();
				retorno = (qtd > 0);
			}

			if (retorno == false) {
				strSQL = "";
				strSQL = strSQL.concat("SELECT COUNT(*) as Qtd ");
				strSQL = strSQL.concat("  FROM ijalemanutprev a, ijmolproagrup b ");
				strSQL = strSQL.concat(" WHERE a.IdRecurso = b.cdmoldeagrup ");
				strSQL = strSQL.concat("   AND a.TpRecurso = '02' ");
				strSQL = strSQL.concat("   AND a.StFimAleMP = '0' ");
				strSQL = strSQL.concat("   AND b.cdmolde = '" + cdMolPKey + "' ");

				listaReg = this.getDaoSession().createSQLQuery(strSQL).list();
				reg = null;
				if (listaReg.size() > 0) {
					reg = listaReg.get(0);

					registroAux = (Object) reg;
					if (registroAux != null) {
						Integer qtd = ConversaoTipos.converterParaBigDecimal(registroAux).intValue();
						retorno = (qtd > 0);
					}
				}
			}
		}

		return retorno;
	}

	@SuppressWarnings("unchecked")
	public boolean isAlertaVidaUtilMolde(String cdMolPKey) {
		boolean retorno = false;

		int _qtTotCicExec = 0;
		int _vidaUtil = _qtTotCicExec + 1;
		int _percVidaUtil = _vidaUtil + 1;

		BigDecimal qtCiclosParaAlerta = BigDecimal.ZERO;

		class RegistroLido {
			BigDecimal qtTotCicExec = BigDecimal.ZERO;
			BigDecimal vidaUtil = BigDecimal.ZERO;
			BigDecimal percVidaUtil = BigDecimal.ZERO;
		}

		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.QtTotCicExec, a.VidaUtil, (a.PercAleVidaUtil / 100) as PercAleVidaUtil ");
		strSQL = strSQL.concat("  FROM IjTbMol a ");
		strSQL = strSQL.concat(" WHERE a.CdMolde = '" + cdMolPKey + "' ");

		Object[] registroLido = null;
		List<Object> lista = this.getDaoSession().createSQLQuery(strSQL).list();

		Object reg = lista.get(0);
		Object registroAux = (Object) reg;
		registroLido = (Object[]) registroAux;

		RegistroLido registro = new RegistroLido();
		registro.qtTotCicExec = ConversaoTipos.converterParaBigDecimal(registroLido[_qtTotCicExec]);
		registro.vidaUtil = ConversaoTipos.converterParaBigDecimal(registroLido[_vidaUtil]);
		registro.percVidaUtil = ConversaoTipos.converterParaBigDecimal(registroLido[_percVidaUtil]);

		if (registro.vidaUtil.intValue() > 0) {
			qtCiclosParaAlerta = AritmeticaUtil.multiplicar(registro.vidaUtil, registro.percVidaUtil);

			if (registro.qtTotCicExec.doubleValue() >= qtCiclosParaAlerta.doubleValue()) {
				retorno = true;
			} else {
				strSQL = "";
				strSQL = strSQL.concat("SELECT a.QtTotCicExec, a.VidaUtil, a.PercAleVidaUtil ");
				strSQL = strSQL.concat("  FROM IjTbMol a, ijmolproagrup b ");
				strSQL = strSQL.concat(" WHERE b.CdMolde = '" + cdMolPKey + "' ");
				strSQL = strSQL.concat("   AND b.cdmoldeagrup = a.cdmolde ");
				lista = this.getDaoSession().createSQLQuery(strSQL).list();

				for (Object regAux : lista) {
					registro = new RegistroLido();
					registroLido = null;
					Object registroLidoAux = (Object) regAux;
					registroLido = (Object[]) registroLidoAux;

					registro.qtTotCicExec = ConversaoTipos.converterParaBigDecimal(registroLido[_qtTotCicExec]);
					registro.vidaUtil = ConversaoTipos.converterParaBigDecimal(registroLido[_vidaUtil]);
					registro.percVidaUtil = ConversaoTipos.converterParaBigDecimal(registroLido[_percVidaUtil]);

					if (registro.vidaUtil.intValue() > 0) {
						qtCiclosParaAlerta = AritmeticaUtil.multiplicar(registro.vidaUtil, registro.percVidaUtil);

						if (registro.qtTotCicExec.doubleValue() >= qtCiclosParaAlerta.doubleValue()) {
							retorno = true;
							break;
						}
					}
				}

			}
		}

		return retorno;
	}

	@SuppressWarnings("unchecked")
	public TempoRealMaquinaSulbrasDTO getTempoRealMaquinaSulbras(FiltroTempoRealMaquinaSulbrasDTO filtro) {
		TempoRealMaquinaSulbrasDTO retorno = new TempoRealMaquinaSulbrasDTO();
		retorno.setCdMaquina("");
		retorno.setNrOPExibicao("");
		retorno.setQtdProducaoPlanejada("");
		retorno.setQtdProducaoLiquida("");
		retorno.setMtbf("");
		retorno.setMttr("");
		retorno.setOee("");
		retorno.setIndRef("");
		retorno.setTipoRodape("");
		retorno.setDsRodape("");
		retorno.setDtHrRodape("");
		retorno.setCorIndRef(COR_HEXA_PRETO);
		retorno.setCorOEE(COR_HEXA_PRETO);
		retorno.setQtdProducaoRefugada("");
		retorno.setListaRefugos(new ArrayList<TempoRealSulbrasRefugoDTO>());
		retorno.setListaOperadores(new ArrayList<TempoRealSulbrasLoginDTO>());

		String idIHM = filtro.getIdIHM();
		String cdPt = filtro.getCdPt();

		String strSQL = "";

		if (!cdPt.equals("") && !cdPt.equals(null)) {
			if (!idIHM.equals("")) {
				idIHM = "";
			}

			strSQL = strSQL.concat("SELECT a.cdinjestendido, a.cdinjetora ");
			strSQL = strSQL.concat("  FROM ijtbinj a ");
			strSQL = strSQL.concat(" WHERE a.cdinjestendido = '" + cdPt + "'");
			strSQL = strSQL.concat(" ORDER BY a.cdinjestendido ");

			SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

			List<Object> listaReg = q.list();
			Object[] registroLido = null;

			Object reg = null;
			if (listaReg.size() > 0) {
				reg = listaReg.get(0);

				Object registroAux = (Object) reg;
				registroLido = (Object[]) registroAux;
				cdPt = (String) registroLido[1];
			}
		}

		MonitorizacaoInjetRN rnM = new MonitorizacaoInjetRN();
		List<OmInd> listaCfgInd = rnM.getCfgIndInjet(getDao());

		// identifica se utiliza idihm ou cdpt
		if (!idIHM.trim().equals("")) {
			// recupera cdpt a partir do idihm
			strSQL = "";
			strSQL = strSQL.concat("SELECT b.cdinjestendido, a.cdinjetora ");
			strSQL = strSQL.concat("  FROM IJTBINJIDIHM a ");
			strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
			strSQL = strSQL.concat(" WHERE a.idihm LIKE '%" + idIHM + "%'");
			strSQL = strSQL.concat(" ORDER BY b.cdinjestendido ");

			SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

			List<Object> listaReg = q.list();
			Object[] registroLido = null;

			Object reg = null;
			if (listaReg.size() > 0) {
				reg = listaReg.get(0);

				Object registroAux = (Object) reg;
				registroLido = (Object[]) registroAux;
				cdPt = (String) registroLido[1];
			}
		}

		if (!cdPt.trim().equals("")) {
			// recupera codigo da maquina que deve ser exibido na interface
			strSQL = "";
			strSQL = strSQL.concat("SELECT a.cdinjestendido, b.nropexibicao, ");
			strSQL = strSQL.concat("       AVG(pp.qtpecasproduzir / dc.divisorUB) as producaoplanejada ");
			strSQL = strSQL.concat("  FROM ijtbinj a ");
			strSQL = strSQL.concat(
					"  LEFT JOIN ijoproteiro b ON (b.nrop = a.opatual AND b.cdinjetora = a.cdinjetora AND b.cdmolde = a.CdMoldeAtual AND b.cdestrutura = a.CdEstruturaAtual) ");
			strSQL = strSQL.concat("  LEFT JOIN ijopprodutos pp ON (pp.nrop = a.opatual) ");
			strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
			strSQL = strSQL.concat(" WHERE a.cdinjetora = :cdpt ");
			strSQL = strSQL.concat(" GROUP BY a.cdinjestendido, b.nropexibicao");
			SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
			q.setString("cdpt", cdPt);

			List<Object> listaReg = q.list();
			Object[] registroLido = null;
			Object reg = null;
			reg = listaReg.get(0);
			Object registroAux = (Object) reg;

			registroAux = (Object) reg;
			registroLido = (Object[]) registroAux;

			// maquina, op, producao planejada
			String cdMaqEstendido = (String) registroLido[0];
			String nrOPExibicao = (registroLido[1] == null ? "" : (String) registroLido[1]);
			BigDecimal producaoPlanejada =
					(registroLido[1] == null ? BigDecimal.ZERO : ConversaoTipos.converterParaBigDecimal(registroLido[2]));
			retorno.setCdMaquina(cdMaqEstendido.trim());
			retorno.setNrOPExibicao(nrOPExibicao.trim());
			retorno.setQtdProducaoPlanejada(ConversaoTipos.converteParaString(producaoPlanejada, 0));
			retorno.setQtdProducaoLiquida(ConversaoTipos.converteParaString(BigDecimal.ZERO, 0));

			/*
			 * calculo de mtbf e mttr dos ultimos 180 dias
			 * 
			 */

			// data de referencia aual
			TurnoInjetDTO turnoInjet = new TurnoInjetDTO();
			try {
				turnoInjet = FuncoesApoioInjet.encontraTurno(this.getDao(), DataHoraRN.getDataHoraAtual());
			} catch (SemCalendarioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int QTD_DIAS_ANALISE_MBTF_MTTR = -180;
			BigDecimal tempoDisponivel = BigDecimal.ZERO;
			BigDecimal tempoParMTBF = BigDecimal.ZERO;
			BigDecimal qtdParMTBF = BigDecimal.ZERO;
			BigDecimal mtbf = BigDecimal.ZERO;
			BigDecimal mttr = BigDecimal.ZERO;
			Date dtHrFim180 = turnoInjet.getDtReferencia();
			Date dtHrIni180 = DataHoraRN.adicionaDiasDaData(dtHrFim180, QTD_DIAS_ANALISE_MBTF_MTTR);

			// tempo ativo dos ultimos 180 dias
			strSQL = "";
			strSQL = strSQL.concat("SELECT SUM(a.tmpativo + a.tmpCTT) as tempodisponivel ");
			strSQL = strSQL.concat("  FROM viewDadosCalcOEEOP a ");
			strSQL = strSQL.concat(" WHERE a.cdinjetora = :cdpt ");
			strSQL = strSQL.concat("   AND a.dtturno BETWEEN :dthrini AND :dthrfim");

			q = this.getDaoSession().createSQLQuery(strSQL);
			q.setString("cdpt", cdPt)
					.setTimestamp("dthrini", dtHrIni180)
					.setTimestamp("dthrfim", dtHrFim180);

			listaReg = q.list();
			registroLido = null;

			reg = null;
			reg = listaReg.get(0);

			registroAux = (Object) reg;
			// registroLido = (Object[]) registroAux;
			tempoDisponivel = (registroAux == null ? BigDecimal.ZERO : (ConversaoTipos.converterParaBigDecimal(registroAux)));

			// tempo e qtd de parada mtbf/mttr dos ultimos 180 dias
			strSQL = "";
			strSQL = strSQL.concat("SELECT SUM(a.tmpparadas + a.tmpparadassempeso) as tempoparadas, ");
			strSQL = strSQL.concat("       COUNT(a.qtdparadas + a.qtdparadassempeso) as qtdocorrpar ");
			strSQL = strSQL.concat("  FROM ijreaparcnsTUR a ");
			strSQL = strSQL.concat("  JOIN ijtbpar p ON (p.cdparada = a.cdparada AND p.CalcMTBFMTTR = '1') ");
			strSQL = strSQL.concat(" WHERE a.cdinjetora = :cdpt ");
			strSQL = strSQL.concat("   AND a.dtturno BETWEEN :dthrini AND :dthrfim");

			q = this.getDaoSession().createSQLQuery(strSQL);
			q.setString("cdpt", cdPt)
					.setTimestamp("dthrini", dtHrIni180)
					.setTimestamp("dthrfim", dtHrFim180);

			listaReg = q.list();
			reg = listaReg.get(0);

			registroAux = (Object) reg;
			registroLido = (Object[]) registroAux;
			tempoParMTBF = (registroLido[0] == null ? BigDecimal.ZERO : (ConversaoTipos.converterParaBigDecimal(registroLido[0])));
			qtdParMTBF = (registroLido[1] == null ? BigDecimal.ZERO : (ConversaoTipos.converterParaBigDecimal(registroLido[1])));

			// mtbf e mttr em minutos
			mtbf = new BigDecimal(FormulasInjet.calcularMTBF(tempoDisponivel, qtdParMTBF.intValue()));
			mttr = new BigDecimal(FormulasInjet.calcularMTTR(tempoParMTBF, qtdParMTBF.intValue()));

			// informacoes do tempo real
			int _cdmaquina = 0;
			int _cdmaqestendido = _cdmaquina + 1;
			int _nrop = _cdmaqestendido + 1;
			int _nropexibicao = _nrop + 1;

			int _dthriparada = _nropexibicao + 1;
			int _dthrfparada = _dthriparada + 1;
			int _cdparada = _dthrfparada + 1;
			int _dsparada = _cdparada + 1;

			int _dthrialerta = _dsparada + 1;
			int _cdalerta = _dthrialerta + 1;
			int _dsalerta = _cdalerta + 1;

			int _producaoplanejada = _dsalerta + 1;
			int _producaobruta = _producaoplanejada + 1;
			int _producaorefugada = _producaobruta + 1;
			int _producaoliquida = _producaorefugada + 1;
			int _indref = _producaoliquida + 1;
			int _oee = _indref + 1;

			class RegistroLido {
				String cdMaqEstendido;
				String nrOPExibicao;

				Date dthrIniPar;
				String cdParada;
				String dsParada;

				Date dthrIniAle;
				String cdAlerta;
				String dsAerta;

				BigDecimal qtdProdPlan = BigDecimal.ZERO;
				BigDecimal qtdProdLiquida = BigDecimal.ZERO;
				BigDecimal qtdProdRefugada = BigDecimal.ZERO;
				BigDecimal indRef = BigDecimal.ZERO;
				BigDecimal OEE = BigDecimal.ZERO;
			}

			strSQL = "";
			strSQL = strSQL.concat("SELECT 	t.cdinjetora, t.cdinjestendido, t.nrop, c.nropexibicao, ");
			strSQL = strSQL.concat(" 	   	b.dthriparada, b.dthrfparada, p.cdparada, p.dsparada, ");
			strSQL = strSQL.concat("       	al.dthrialerta, al.cdalerta, al.dsalerta,");
			strSQL = strSQL.concat("       	t.producaoplanejada, ");
			strSQL = strSQL.concat("       	(t.producaobruta / dc.divisorUB) as producaobruta, ");
			strSQL = strSQL.concat("       	(t.producaorefugada / dc.divisorUB) as producaorefugada, ");
			strSQL = strSQL.concat("       	(t.producaoliquida / dc.divisorUB) as producaoliquida, ");
			strSQL = strSQL.concat(
					"       	(CASE WHEN (t.producaobruta = 0) THEN 0 ELSE (t.producaorefugada / t.producaobruta) * 100 END) as indref, ");
			strSQL = strSQL.concat(
					"       	(CASE WHEN (t.tempoprodutivo < 0 OR t.tempodisponivel = 0) THEN 0 ELSE (t.tempoprodutivo / t.tempodisponivel) * 100 END) as OEE ");
			strSQL = strSQL.concat("  FROM 	( ");
			strSQL = strSQL.concat("        	SELECT 	a.cdinjetora, ij.cdinjestendido, a.nrop, ");
			strSQL = strSQL.concat("					SUM(a.tmpativo + a.tmpCTT + a.tmpparadassempeso) as tempototal, ");
			strSQL = strSQL.concat("					SUM(a.tmpcicnormal + a.tmpcicfinparada + a.tmpCTT) as tempotrabalhado, ");
			strSQL = strSQL.concat("					SUM(a.tmpativo + a.tmpCTT) as tempodisponivel, ");
			strSQL = strSQL.concat("					SUM(a.tmpparadas + a.tmpparadassempeso) as tempopartotal, ");
			strSQL = strSQL.concat("					SUM(a.tmpcicnormal + a.tmpCTT) as tempoproducaonormal, ");
			strSQL = strSQL.concat("					SUM(a.tmpcicnormal - a.tmpprodrefugada) as tempoprodliquida, ");
			strSQL = strSQL.concat("					SUM(a.tmpprodrefugada) as tempoprodrefugada, ");
			strSQL = strSQL.concat("					SUM(a.tmpparadas) as tempoparcp, ");
			strSQL = strSQL.concat("					SUM(a.tmpcavidades) as tempopci, ");
			strSQL = strSQL.concat("					SUM(a.tmpcicnormal) as tempocicloprodutivo, ");
			strSQL = strSQL.concat("					SUM(a.tmpcicfinparada) as tempocicloimprodutivo, ");
			strSQL = strSQL.concat(
					"					SUM( ( (a.tmpcicnormal / a.ciclopadrao) - (a.qtinjnormal)) * a.ciclopadrao) as temporitmo, ");
			strSQL = strSQL.concat(
					"					SUM(a.tmpcicnormal - a.tmpprodrefugada - a.tmpcavidades - (((a.tmpcicnormal / a.ciclopadrao) - (a.qtinjnormal)) * a.ciclopadrao)) as tempoprodutivo, ");
			strSQL = strSQL.concat("					SUM(a.tmpCTT) as tempocorrecaotrab, ");
			strSQL = strSQL.concat("					SUM(a.qtprodbrutaUB) as producaobruta, ");
			strSQL = strSQL.concat("					SUM((a.qtprodbrutaUB - a.qtprodrefugadaUB)) as producaoliquida, ");
			strSQL = strSQL.concat("					SUM(a.qtprodrefugadaUB) as producaorefugada, ");
			strSQL = strSQL.concat(
					"					SUM( ( (a.tmpcicnormal / a.ciclopadrao) - (a.qtinjnormal)) * c2.qtcavativas) as perdaritmo, ");
			strSQL = strSQL.concat("					AVG(pp.qtpecasproduzir / dc.divisorUB) as producaoplanejada ");
			strSQL = strSQL.concat("			FROM ijtbinj ij ");
			strSQL = strSQL.concat(
					"			JOIN viewDadosCalcOEEOP a ON (a.nrop = ij.opatual AND a.cdinjetora = ij.cdinjetora AND a.cdmolde = ij.CdMoldeAtual AND a.cdestrutura = ij.CdEstruturaAtual) ");
			strSQL = strSQL.concat(
					"			JOIN cavidades2 c2 ON (c2.cdmolde = a.cdmolde AND c2.cdestrutura = a.cdestrutura AND c2.dthrival = a.dthrivalestru) ");
			strSQL = strSQL.concat("			JOIN ijopprodutos pp ON (pp.nrop = ij.opatual) ");
			strSQL = strSQL.concat("			JOIN viewDivisorContagem dc ON (1=1) ");
			strSQL = strSQL.concat("		   WHERE ij.cdinjetora = :cdpt ");
			strSQL = strSQL.concat("		   GROUP BY a.cdinjetora, ij.cdinjestendido, a.nrop ");
			strSQL = strSQL.concat("		) t ");
			strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
			strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = t.cdinjetora) ");
			strSQL = strSQL.concat("  JOIN ijoproteiro c ON (c.nrop = t.nrop AND c.cdinjetora = t.cdinjetora) ");
			strSQL = strSQL.concat("  LEFT JOIN ijtbpar p ON (p.cdparada = b.cdparada) ");
			strSQL = strSQL.concat("  LEFT JOIN (SELECT al.cdinjetora, al.cdalerta, ta.dsalerta, al.dthrialerta ");
			strSQL = strSQL.concat("   			   FROM ijalertas al ");
			strSQL = strSQL.concat("              JOIN ijtbale ta ON (ta.cdalerta = al.cdalerta) ");
			strSQL = strSQL.concat("              WHERE al.dthrialerta = (SELECT MAX(dthrialerta) ");
			strSQL = strSQL.concat("                                        FROM ijalertas ");
			strSQL = strSQL.concat("                                       WHERE cdinjetora = al.cdinjetora ");
			strSQL = strSQL.concat("                                         AND dthrfalerta IS NULL) ");
			strSQL = strSQL.concat("               ) al ON (al.cdinjetora = t.cdinjetora) ");

			registroLido = null;
			listaReg = null;

			listaReg = this.getDaoSession().createSQLQuery(strSQL)
					.setString("cdpt", cdPt)
					.list();

			reg = null;

			if (listaReg.size() > 0) {
				reg = listaReg.get(0);

				registroAux = (Object) reg;
				registroLido = (Object[]) registroAux;

				RegistroLido registro = new RegistroLido();
				registroLido = (Object[]) registroAux;

				// dados
				registro.cdMaqEstendido = (String) registroLido[_cdmaqestendido];
				registro.nrOPExibicao = (String) registroLido[_nropexibicao];
				registro.qtdProdLiquida = ConversaoTipos.converterParaBigDecimal(registroLido[_producaoliquida]);
				registro.qtdProdPlan = ConversaoTipos.converterParaBigDecimal(registroLido[_producaoplanejada]);
				registro.indRef = ConversaoTipos.converterParaBigDecimal(registroLido[_indref]);
				registro.OEE = ConversaoTipos.converterParaBigDecimal(registroLido[_oee]);
				registro.cdParada = "";
				registro.dsParada = "";
				registro.cdAlerta = "";
				registro.dsAerta = "";

				if (registroLido[_dthriparada] != null && registroLido[_dthrfparada] == null) {
					registro.cdParada = (String) registroLido[_cdparada];
					registro.dsParada = (String) registroLido[_dsparada];
					registro.dthrIniPar = (Date) registroLido[_dthriparada];
				}

				if (registroLido[_dthrialerta] != null) {
					registro.cdAlerta = (String) registroLido[_cdalerta];
					registro.dsAerta = (String) registroLido[_dsalerta];
					registro.dthrIniAle = (Date) registroLido[_dthrialerta];
				}

				retorno.setCdMaquina(registro.cdMaqEstendido);
				retorno.setNrOPExibicao(registro.nrOPExibicao);
				retorno.setQtdProducaoPlanejada(ConversaoTipos.converteParaString(registro.qtdProdPlan, 0));
				retorno.setQtdProducaoLiquida(ConversaoTipos.converteParaString(registro.qtdProdLiquida, 0));
				retorno.setOee(ConversaoTipos.converteParaString(registro.OEE, 2));
				retorno.setIndRef(ConversaoTipos.converteParaString(registro.indRef, 2));
				retorno.setMtbf(ConversaoTipos.converteParaString(mtbf, 2));
				retorno.setMttr(ConversaoTipos.converteParaString(mttr, 2));

				if (!registro.cdParada.equals("")) {
					retorno.setTipoRodape("PARADA");
					retorno.setDsRodape(registro.cdParada + " - " + registro.dsParada);
					retorno.setDtHrRodape(DataHoraRN.dateToStringDDMMYYYYHHMMSS(registro.dthrIniPar));
				}

				if (!registro.cdAlerta.equals("")) {
					retorno.setTipoRodape("ALERTA");
					retorno.setDsRodape(registro.cdAlerta + " - " + registro.dsAerta);
					retorno.setDtHrRodape(DataHoraRN.dateToStringDDMMYYYYHHMMSS(registro.dthrIniAle));
				}

				// cores dos indicadores oee e refugo
				OmCfgind cfgIndRef = new OmCfgind();
				OmCfgind cfgIndOEE = new OmCfgind();

				for (OmInd ind : listaCfgInd) {
					OmCfgind cfgInd = ind.getOmCfginds().iterator().next();

					if (ind.getIdInd() == IR) {
						cfgIndRef = cfgInd;
					}

					if (ind.getIdInd() == OEE) {
						cfgIndOEE = cfgInd;
					}
				}

				if (registro.indRef.doubleValue() < cfgIndRef.getIndInferior().doubleValue()) {
					retorno.setCorIndRef(COR_HEXA_VERDE);
				} else {
					if (registro.indRef.doubleValue() > cfgIndRef.getIndSuperior().doubleValue()) {
						retorno.setCorIndRef(COR_HEXA_VERMELHO);
					} else {
						retorno.setCorIndRef(COR_HEXA_AMARELO);
					}
				}

				if (registro.OEE.doubleValue() < cfgIndOEE.getIndInferior().doubleValue()) {
					retorno.setCorOEE(COR_HEXA_VERMELHO);
				} else {
					if (registro.OEE.doubleValue() > cfgIndOEE.getIndSuperior().doubleValue()) {
						retorno.setCorOEE(COR_HEXA_VERDE);
					} else {
						retorno.setCorOEE(COR_HEXA_AMARELO);
					}
				}

				// recuperar login mais antigo aberto para a maquina
				strSQL = "";
				strSQL = strSQL.concat("SELECT c.cdusuario, c.nmusuario, a.dthrlogin ");
				strSQL = strSQL.concat("  FROM ijlogope a ");
				strSQL = strSQL.concat("  JOIN ijtbusu c ON (c.cdusuario = a.cdusuario) ");
				strSQL = strSQL.concat(" WHERE a.cdinjetora = :cdpt ");
				strSQL = strSQL.concat("   AND a.dthrlogout IS NULL ");
				strSQL = strSQL.concat(" ORDER BY a.dthrlogin ");
				q = this.getDaoSession().createSQLQuery(strSQL);
				q.setString("cdpt", cdPt);
				q.setMaxResults(TOTAL_OPERADORES_COM_LOGIN_ABERTO_LISTA);
				listaReg = q.list();
				reg = null;

				for (Object regLogin : listaReg) {
					registroAux = (Object) regLogin;
					registroLido = (Object[]) registroAux;

					TempoRealSulbrasLoginDTO loginAberto = new TempoRealSulbrasLoginDTO();
					loginAberto.setCdOperador((String) registroLido[0]);
					loginAberto.setNmOperador((String) registroLido[1]);
					loginAberto.setDtHrLoginOperador(DataHoraRN.dateToStringDDMMYYYYHHMMSS((Date) registroLido[2]));
					retorno.getListaOperadores().add(loginAberto);
				}

				// recuperar producao refugada nos ultimos 30 minutos

				// >>> encontra o intervalo
				Date dtHrAtual = DataHoraRN.getDataHoraAtual();
				Date dtHrIni = DataHoraRN.setHoraNaData(dtHrAtual, 0, 0, 0);
				Date dtHrFim = dtHrIni;

				while (true) {
					dtHrFim = DataHoraRN.adicionaSegundosNaData(dtHrIni, INTERVALO_EM_SEGUNDOS_TOTAL_REFUGOS_SMARTTV_SULBRAS - 1);

					if (DataHoraRN.between(dtHrAtual, dtHrIni, dtHrFim)) {
						break;
					} else {
						dtHrIni = DataHoraRN.adicionaSegundosNaData(dtHrIni, INTERVALO_EM_SEGUNDOS_TOTAL_REFUGOS_SMARTTV_SULBRAS);
					}
				}

				// >>> recupera os refugos
				// recuperar login mais antigo aberto para a maquina

				BigDecimal totalRefugado = BigDecimal.ZERO;

				strSQL = "";
				strSQL = strSQL.concat("SELECT SUM(a.qtrefugada / dc.divisorUB) as qtrefugada ");
				strSQL = strSQL.concat("  FROM ijrearef a ");
				strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.opatual = a.nrop) ");
				strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
				strSQL = strSQL.concat(" WHERE a.dthrirefugo BETWEEN :dthrini AND :dthrfim ");
				strSQL = strSQL.concat("   AND a.cdinjetora = :cdpt ");
				strSQL = strSQL.concat("   AND a.Acumulado  <> 1 ");
				strSQL = strSQL.concat("   AND a.lCancelado <> 1 ");

				q = this.getDaoSession().createSQLQuery(strSQL);
				q.setString("cdpt", cdPt)
						.setTimestamp("dthrini", dtHrIni)
						.setTimestamp("dthrfim", dtHrFim);

				listaReg = q.list();
				reg = null;

				if (listaReg.size() > 0) {
					if (listaReg.get(0) != null) {
						totalRefugado = ConversaoTipos.converterParaBigDecimal(listaReg.get(0));
					}
				}

				retorno.setQtdProducaoRefugada(ConversaoTipos.converteParaString(totalRefugado, 0));

				// maiores refugos (havendo mais de 4 na lista, consolidar em OUTROS)
				strSQL = "";
				strSQL = strSQL.concat("SELECT a.cdrefugo, b.dsrefugo, SUM(a.qtrefugada / dc.divisorUB) as qtdrefugada");
				strSQL = strSQL.concat("  FROM ijrearef a ");
				strSQL = strSQL.concat("  JOIN ijtbref b ON (b.cdrefugo = a.cdrefugo) ");
				strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora AND i.opatual = a.nrop) ");
				strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
				strSQL = strSQL.concat(" WHERE a.dthrirefugo BETWEEN :dthrini AND :dthrfim ");
				strSQL = strSQL.concat("   AND a.cdinjetora = :cdpt ");
				strSQL = strSQL.concat("   AND a.Acumulado  <> 1 ");
				strSQL = strSQL.concat("   AND a.lCancelado <> 1 ");
				strSQL = strSQL.concat(" GROUP BY a.cdrefugo, b.dsrefugo ");
				strSQL = strSQL.concat(" ORDER BY 3 desc ");

				q = this.getDaoSession().createSQLQuery(strSQL);
				q.setString("cdpt", cdPt)
						.setTimestamp("dthrini", dtHrIni)
						.setTimestamp("dthrfim", dtHrFim);

				listaReg = q.list();
				int iCountQtdRef = 0;
				RefugoInjetDTO refugoAcumulado = new RefugoInjetDTO();

				for (Object regRef : listaReg) {
					iCountQtdRef++;

					registroAux = (Object) regRef;
					registroLido = (Object[]) registroAux;

					String cdRefugo = "";
					String dsRefugo = "";
					BigDecimal qtdRefugada = BigDecimal.ZERO;

					cdRefugo = (String) registroLido[0];
					dsRefugo = (String) registroLido[1];
					qtdRefugada = ConversaoTipos.converterParaBigDecimal(registroLido[2]);

					if ((iCountQtdRef < TOTAL_REFUGOS_LISTA)
							|| (iCountQtdRef == TOTAL_REFUGOS_LISTA && listaReg.size() == TOTAL_REFUGOS_LISTA)) {
						TempoRealSulbrasRefugoDTO refugo = new TempoRealSulbrasRefugoDTO();
						refugo.setCdRefugo(cdRefugo);
						refugo.setDsRefugo(dsRefugo);
						refugo.setQtdRefugada(ConversaoTipos.converteParaStringComFormat(qtdRefugada.doubleValue(), 0));

						retorno.getListaRefugos().add(refugo);
					} else {
						// acumula refugo
						refugoAcumulado.setCdRefugo("OUTROS");
						refugoAcumulado.setDsRefugo("OUTROS");
						refugoAcumulado.setProducaoRefugada(AritmeticaUtil.somar(refugoAcumulado.getProducaoRefugada(), qtdRefugada));
					}
				}

				if (listaReg.size() > TOTAL_REFUGOS_LISTA) {
					TempoRealSulbrasRefugoDTO refugo = new TempoRealSulbrasRefugoDTO();
					refugo.setCdRefugo(refugoAcumulado.getCdRefugo());
					refugo.setDsRefugo(refugoAcumulado.getDsRefugo());
					refugo.setQtdRefugada(
							ConversaoTipos.converteParaStringComFormat(refugoAcumulado.getProducaoRefugada().doubleValue(), 0));
					retorno.getListaRefugos().add(refugo);
				}
			}
		}

		if (retorno.getNrOPExibicao().equals("")) {
			retorno.setQtdProducaoPlanejada("");
			retorno.setQtdProducaoLiquida("");
		}

		return retorno;
	}

	@SuppressWarnings("unchecked")
	public TempoRealIHMWebDTO getTempoRealIHMWeb(FiltroTempoRealMaquinaSulbrasDTO filtro) {
		int _dtRef = 0;
		int _cdTurno = _dtRef + 1;

		class RegistroTurnoAtual {
			Date dtRef;
			String cdTurno;
		}

		int _nrop = 0;
		int _dtHrIniPlan = _nrop + 1;
		int _dtHrFimPlan = _dtHrIniPlan + 1;
		int _dtHrIniReal = _dtHrFimPlan + 1;
		int _cdProduto = _dtHrIniReal + 1;
		int _prodPlan = _cdProduto + 1;
		int _prodLiquida = _prodPlan + 1;
		int _saldo = _prodLiquida + 1;
		int _tempoNecPlan = _saldo + 1;
		int _tempoNecPrev = _tempoNecPlan + 1;

		int _nrop2 = 0;
		int _dtHrIniPlan2 = _nrop2;
		int _dtHrFimPlan2 = _dtHrIniPlan2 + 1;
		int _dtHrIniReal2 = _dtHrFimPlan2 + 1;
		int _cdProduto2 = _dtHrIniReal2 + 1;
		int _prodPlan2 = _cdProduto2 + 1;
		int _tempoNecPlan2 = _prodPlan2 + 1;

		class RegistroPeriodosOP {
			String nrOP;
			Date dtHrIniPlan;
			Date dtHrFimPlan;
			Date dtHrIniReal;
			String cdProduto;
			BigDecimal prodPlan;
			BigDecimal prodLiquida;
			BigDecimal saldo;
			BigDecimal tempoNecPlan;
			BigDecimal tempoNecPrev;
		}

		int _stfuncionamento = 0;
		int _qualidade = _stfuncionamento + 1;
		int _disponibilidade = _qualidade + 1;
		int _ritmo = _disponibilidade + 1;
		int _eficic = _ritmo + 1;
		int _oee = _eficic + 1;

		class RegistroIndicadores {
			String stfuncionamento = ConversaoTipos.converteParaString(StFuncionamento.MAQUINA_SEM_CONEXAO.getValue());
			BigDecimal qualidade = BigDecimal.ZERO;
			BigDecimal disponibilidade = BigDecimal.ZERO;
			BigDecimal ritmo = BigDecimal.ZERO;
			BigDecimal eficic = BigDecimal.ZERO;
			BigDecimal oee = BigDecimal.ZERO;
		}

		boolean isMaquinaComOP = true;

		String strSQL = "";
		SQLQuery q = null;
		List<Object> listaReg = null;

		TempoRealIHMWebDTO retorno = new TempoRealIHMWebDTO();
		retorno.setCdMaquina(filtro.getCdPt());
		retorno.setDtHrIniPlan("");
		retorno.setDtHrFimPlan("");
		retorno.setDtHrIniReal("");
		retorno.setDtHrFimPrev("");
		retorno.setOee("");
		retorno.setMetaOEELimInf("");
		retorno.setMetaOEELimSup("");
		retorno.setDisponibilidade("");
		retorno.setMetaDisponibilidadeLimInf("");
		retorno.setMetaDisponibilidadeLimSup("");
		retorno.setRitmo("");
		retorno.setMetaRitmoLimInf("");
		retorno.setMetaRitmoLimSup("");
		retorno.setQualidade("");
		retorno.setMetaQualidadeLimInf("");
		retorno.setMetaQualidadeLimInf("");
		retorno.setStFuncionamento(ConversaoTipos.converteParaString(StFuncionamento.MAQUINA_SEM_CONEXAO.getValue()));
		retorno.setNrOP("");

		// recupera ultimo turno consolidado
		strSQL = "";
		strSQL = strSQL.concat("SELECT dtref, cdturno, dthrini ");
		strSQL = strSQL.concat("  FROM ijcnsTurIniFim a ");
		strSQL = strSQL.concat(" ORDER BY a.dthrini DESC");
		q = this.getDaoSession().createSQLQuery(strSQL);
		q.setMaxResults(1);

		listaReg = q.list();
		Object[] registroLido = null;
		Object reg = null;
		reg = listaReg.get(0);
		Object registroAux = (Object) reg;
		registroAux = (Object) reg;
		registroLido = (Object[]) registroAux;

		RegistroTurnoAtual regTur = new RegistroTurnoAtual();
		regTur.dtRef = (Date) registroLido[_dtRef];
		regTur.cdTurno = (String) registroLido[_cdTurno];

		// periodos OP: inicio planejado, inicio real, tempo nec para produzir (utilizado no cálculo do final planjeado)
		RegistroPeriodosOP regPeriodos = new RegistroPeriodosOP();

		strSQL = "";
		strSQL = strSQL.concat("SELECT a.nrop, a.dthriprevista, a.dthrfprevista, a.dthrireal, e.cdproduto, b.prodplan, b.prodliquida, (b.prodplan - b.prodliquida) as saldo, ");
		strSQL = strSQL.concat("       ( (b.prodplan / (e.qtcavidades * d.fatorcontagemprod)) * d.ciclopadrao  ) as temponecplan, ");
		strSQL = strSQL.concat("       ( ((b.prodplan - b.prodliquida) / (e.qtcavidades * d.fatorcontagemprod)) * d.ciclopadrao  ) as temponecprev ");
		strSQL = strSQL.concat("  FROM ijop a ");
		strSQL = strSQL.concat("  JOIN ijtbinj c ON (c.opatual = a.nrop) ");
		strSQL = strSQL.concat("  JOIN ijfictec d ON (d.cdinjetora = a.cdinjetora AND d.cdmolde = a.cdmolde AND d.cdestrutura = a.cdestrutura AND d.dthrfvalcic IS NULL) ");
		strSQL = strSQL.concat("  JOIN ijmolpro e ON (e.cdmolde = d.cdmolde AND e.cdestrutura = d.cdestrutura AND e.dthrival = d.dthrivalestru) ");
		strSQL = strSQL.concat("  JOIN ( ");
		strSQL = strSQL.concat("        SELECT a.nrop, a.cdproduto, SUM(a.prodbruta - a.prodrefugada) as prodliquida, AVG(o.qtpecasproduzir) as prodplan ");
		strSQL = strSQL.concat("          FROM viewBIDtRefProdutos a ");
		strSQL = strSQL.concat("          JOIN ijopprodutos o ON (o.nrop = a.nrop and o.cdproduto = a.cdproduto) ");
		strSQL = strSQL.concat("          JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora AND b.opatual = a.nrop) ");
		strSQL = strSQL.concat("         WHERE a.cdinjestendido = :cdpt");
		strSQL = strSQL.concat("         GROUP BY a.nrop, a.cdproduto) b ON (b.nrop = a.nrop AND b.cdproduto = e.cdproduto) ");
		strSQL = strSQL.concat(" WHERE c.cdinjestendido  = :cdpt");
		strSQL = strSQL.concat(" ORDER BY 9 DESC");
		q = this.getDaoSession().createSQLQuery(strSQL);
		q.setString("cdpt", filtro.getCdPt());
		q.setMaxResults(1);

		listaReg = q.list();

		if (listaReg.size() == 0) {
			// sem producao ou maq sem op
			strSQL = "";
			strSQL = strSQL.concat("SELECT a.nrop, a.dthriprevista, a.dthrfprevista,  a.dthrireal, e.cdproduto, b.qtpecasproduzir as prodplan, ");
			strSQL = strSQL.concat("       ( (b.qtpecasproduzir / (e.qtcavidades * d.fatorcontagemprod)) * d.ciclopadrao  ) as temponecplan ");
			strSQL = strSQL.concat("  FROM ijop a ");
			strSQL = strSQL.concat("  JOIN ijopprodutos b ON (b.nrop = a.nrop) ");
			strSQL = strSQL.concat("  JOIN ijtbinj c ON (c.opatual = a.nrop) ");
			strSQL = strSQL.concat("  JOIN ijfictec d ON (d.cdinjetora = a.cdinjetora AND d.cdmolde = a.cdmolde AND d.cdestrutura = a.cdestrutura AND d.dthrfvalcic IS NULL) ");
			strSQL = strSQL.concat("  JOIN ijmolpro e ON (e.cdmolde = d.cdmolde AND e.cdestrutura = d.cdestrutura AND e.dthrival = d.dthrivalestru) ");
			strSQL = strSQL.concat(" WHERE c.cdinjestendido  = :cdpt");
			strSQL = strSQL.concat(" ORDER BY 6 DESC");
			q = this.getDaoSession().createSQLQuery(strSQL);
			q.setString("cdpt", filtro.getCdPt());
			q.setMaxResults(1);

			if (listaReg.size() == 0) {
				isMaquinaComOP = false;
			} else {
				registroLido = null;
				reg = null;
				reg = listaReg.get(0);
				registroAux = (Object) reg;
				registroAux = (Object) reg;
				registroLido = (Object[]) registroAux;

				regPeriodos.nrOP = (String) registroLido[_nrop2];
				regPeriodos.dtHrIniPlan = (Date) registroLido[_dtHrIniPlan2];
				if (registroLido[_dtHrFimPlan2] != null) {
					regPeriodos.dtHrFimPlan = (Date) registroLido[_dtHrFimPlan2];
				}
				regPeriodos.dtHrIniReal = (Date) registroLido[_dtHrIniReal2];
				regPeriodos.cdProduto = (String) registroLido[_cdProduto2];
				regPeriodos.prodPlan = ConversaoTipos.converterParaBigDecimal(registroLido[_prodPlan2]);
				regPeriodos.tempoNecPlan = ConversaoTipos.converterParaBigDecimal(registroLido[_tempoNecPlan2]);
				regPeriodos.prodLiquida = BigDecimal.ZERO;
				regPeriodos.saldo = regPeriodos.prodPlan;
				regPeriodos.tempoNecPrev = regPeriodos.tempoNecPlan;
			}

		} else {
			registroLido = null;
			reg = null;
			reg = listaReg.get(0);
			registroAux = (Object) reg;
			registroAux = (Object) reg;
			registroLido = (Object[]) registroAux;

			regPeriodos.nrOP = (String) registroLido[_nrop];
			regPeriodos.dtHrIniPlan = (Date) registroLido[_dtHrIniPlan];
			if (registroLido[_dtHrFimPlan] != null) {
				regPeriodos.dtHrFimPlan = (Date) registroLido[_dtHrFimPlan];
			}
			regPeriodos.dtHrIniReal = (Date) registroLido[_dtHrIniReal];
			regPeriodos.cdProduto = (String) registroLido[_cdProduto];
			regPeriodos.prodPlan = ConversaoTipos.converterParaBigDecimal(registroLido[_prodPlan]);
			regPeriodos.prodLiquida = ConversaoTipos.converterParaBigDecimal(registroLido[_prodLiquida]);
			regPeriodos.saldo = ConversaoTipos.converterParaBigDecimal(registroLido[_saldo]);
			regPeriodos.tempoNecPlan = ConversaoTipos.converterParaBigDecimal(registroLido[_tempoNecPlan]);
			regPeriodos.tempoNecPrev = ConversaoTipos.converterParaBigDecimal(registroLido[_tempoNecPrev]);
		}

		if (isMaquinaComOP) {
			retorno.setNrOP(regPeriodos.nrOP);
			// calcular final previsto
			
			if (filtro.getIdIHM().equals("idihmweb3")) {								
				Date dthrFimPrev = null;
				Date dtHrFimPlan = null;
				
				dthrFimPrev = DataHoraRN.somaSegundos(DataHoraRN.getDataHoraAtual(), regPeriodos.tempoNecPrev.intValue());
				if (DataHoraRN.before(dthrFimPrev, DataHoraRN.getDataHoraAtual())) {
					dthrFimPrev = DataHoraRN.getDataHoraAtual();
				}
				
				if (regPeriodos.dtHrFimPlan ==  null) {
					dtHrFimPlan = DataHoraRN.somaSegundos(regPeriodos.dtHrIniPlan, regPeriodos.tempoNecPlan.intValue());
				} else {
					dtHrFimPlan = regPeriodos.dtHrFimPlan; 
				}

				retorno.setDtHrIniPlan(DataHoraRN.dateToStringDDMMYYYYHHMMSS(regPeriodos.dtHrIniPlan));
				retorno.setDtHrFimPlan(DataHoraRN.dateToStringDDMMYYYYHHMMSS(dtHrFimPlan));
				retorno.setDtHrIniReal(DataHoraRN.dateToStringDDMMYYYYHHMMSS(regPeriodos.dtHrIniReal));
				retorno.setDtHrFimPrev(DataHoraRN.dateToStringDDMMYYYYHHMMSS(dthrFimPrev));
			} else {
				Date dthrFimPrev = DataHoraRN.somaSegundos(DataHoraRN.getDataHoraAtual(), regPeriodos.tempoNecPrev.intValue());
				Date dtHrFimPlan = null;
				
				if (regPeriodos.dtHrFimPlan ==  null) {
					dtHrFimPlan = DataHoraRN.somaSegundos(regPeriodos.dtHrIniPlan, regPeriodos.tempoNecPlan.intValue());
				} else {
					dtHrFimPlan = regPeriodos.dtHrFimPlan; 
				}

				retorno.setDtHrIniPlan(DataHoraRN.dateToStringDDMMYYYYHHMMSS(regPeriodos.dtHrIniPlan));
				retorno.setDtHrFimPlan(DataHoraRN.dateToStringDDMMYYYYHHMMSS(dtHrFimPlan));
				retorno.setDtHrIniReal(DataHoraRN.dateToStringDDMMYYYYHHMMSS(regPeriodos.dtHrIniReal));
				retorno.setDtHrFimPrev(DataHoraRN.dateToStringDDMMYYYYHHMMSS(dthrFimPrev));				
			}
		}

		MonitorizacaoInjetRN rnM = new MonitorizacaoInjetRN();
		List<OmInd> listaCfgInd = rnM.getCfgIndInjet(getDao());

		for (OmInd ind : listaCfgInd) {
			OmCfgind cfgInd = ind.getOmCfginds().iterator().next();

			if (ind.getIdInd() == OEE) {
				retorno.setMetaOEELimInf(ConversaoTipos.converteParaString(cfgInd.getIndInferior(), 2));
				retorno.setMetaOEELimSup(ConversaoTipos.converteParaString(cfgInd.getIndSuperior(), 2));
				// nao existe meta para disp no injet - usar do oee
				retorno.setMetaDisponibilidadeLimInf(ConversaoTipos.converteParaString(cfgInd.getIndInferior(), 2));
				retorno.setMetaDisponibilidadeLimSup(ConversaoTipos.converteParaString(cfgInd.getIndSuperior(), 2));
			}

			if (ind.getIdInd() == IR) {
				retorno.setMetaQualidadeLimInf(ConversaoTipos.converteParaString(new BigDecimal(100).subtract(cfgInd.getIndSuperior()), 2));
				retorno.setMetaQualidadeLimSup(ConversaoTipos.converteParaString(new BigDecimal(100).subtract(cfgInd.getIndInferior()), 2));
			}

			if (ind.getIdInd() == RITMO) {
				retorno.setMetaRitmoLimInf(ConversaoTipos.converteParaString(cfgInd.getIndInferior(), 2));
				retorno.setMetaRitmoLimSup(ConversaoTipos.converteParaString(cfgInd.getIndSuperior(), 2));
			}
		}

		// indicadores
		strSQL = "";
		strSQL = strSQL.concat("SELECT a.stfuncionamento, ");
		strSQL = strSQL.concat("       (100 - (CASE WHEN a.prodbruta = 0 THEN 0 ELSE (a.prodrefugada / a.prodbruta) * 100 END)) as qualidade, ");
		strSQL = strSQL.concat("       (CASE WHEN a.tmpativo = 0 THEN 0 ELSE (a.tmptrabalhado / a.tmpativo) * 100 END) as disponbilidade, ");
		strSQL = strSQL.concat("       (CASE WHEN a.prodprev = 0 THEN 0 ELSE (a.prodliquida / a.prodprev) * 100 END) as ritmo, ");
		strSQL = strSQL.concat("       (CASE WHEN a.qtdciclosnormais = 0 OR a.tmpcicnormal = 0 THEN 0 ELSE (a.ciclopadrao / (a.tmpcicnormal / a.qtdciclosnormais)) * 100 END) as eficic, ");
		strSQL = strSQL.concat("       (CASE WHEN a.tmpprodutivas < 0 OR a.tmpativo = 0 THEN 0 ELSE (a.tmpprodutivas / a.tmpativo) * 100 END) as oee ");
		strSQL = strSQL.concat("  FROM (");
		strSQL = strSQL.concat("         SELECT c.stfuncionamento, ");
		strSQL = strSQL.concat("                AVG(d.ciclopadrao) as ciclopadrao,");
		strSQL = strSQL.concat("                SUM(b.tmpativo) as tmpativo, ");
		strSQL = strSQL.concat("                SUM(b.tmpcicnormal - a.tmppcsref - a.tmpcavidades - b.tmpritmo) as tmpprodutivas, ");
		strSQL = strSQL.concat("                SUM(a.prodrefugada) as prodrefugada, ");
		strSQL = strSQL.concat("                SUM(a.prodbruta) as prodbruta, ");
		strSQL = strSQL.concat("                SUM(a.prodbruta - a.prodrefugada) as prodliquida, ");
		strSQL = strSQL.concat("                SUM(a.prodprev) as prodprev, ");
		strSQL = strSQL.concat("                SUM(b.tmpativo - b.tmpparadasCP) as tmptrabalhado, ");
		strSQL = strSQL.concat("                SUM(b.tmpcicnormal) as tmpcicnormal, ");
		strSQL = strSQL.concat("                SUM(b.qtdciclosnormais) as qtdciclosnormais ");
		strSQL = strSQL.concat("           FROM viewBIDtRefQtds a ");
		strSQL = strSQL.concat("           JOIN viewBIDtRefTempos b ON (    b.dtturno = a.dtturno ");
		strSQL = strSQL.concat("                                        AND b.cdturno = a.cdturno ");
		strSQL = strSQL.concat("                                        AND b.cdinjetora = a.cdinjetora ");
		strSQL = strSQL.concat("                                        AND b.nrop = a.nrop ");
		strSQL = strSQL.concat("                                        AND b.cdmolde = a.cdmolde ");
		strSQL = strSQL.concat("                                        AND b.cdestrutura = a.cdestrutura ");
		strSQL = strSQL.concat("                                        AND b.dthrivalestru = a.dthrivalestru ");
		strSQL = strSQL.concat("                                        AND b.dthrivalcic = a.dthrivalcic )");
		strSQL = strSQL.concat("          JOIN ijtbinj c ON (c.cdinjetora = a.cdinjetora AND c.opatual = a.nrop) ");
		strSQL = strSQL.concat("          JOIN ijfictec d ON (d.cdinjetora = a.cdinjetora AND d.cdmolde = a.cdmolde AND d.cdestrutura = a.cdestrutura AND d.dthrfvalcic IS NuLL)");
		strSQL = strSQL.concat("         WHERE a.dtturno = :dtturno ");
		strSQL = strSQL.concat("           AND a.cdturno = :cdturno ");
		strSQL = strSQL.concat("           AND a.cdinjestendido = :cdpt ");
		strSQL = strSQL.concat("         GROUP BY c.stfuncionamento");
		strSQL = strSQL.concat("    ) a ");

		q = this.getDaoSession().createSQLQuery(strSQL);
		q.setString("cdpt", filtro.getCdPt())
				.setString("cdturno", regTur.cdTurno)
				.setDate("dtturno", regTur.dtRef);

		q.setMaxResults(1);

		listaReg = q.list();

		if (listaReg.size() > 0) {
			registroLido = null;
			reg = null;
			reg = listaReg.get(0);
			registroAux = (Object) reg;
			registroAux = (Object) reg;
			registroLido = (Object[]) registroAux;

			RegistroIndicadores regInd = new RegistroIndicadores();
			regInd.stfuncionamento = (String) registroLido[_stfuncionamento];
			regInd.oee = ConversaoTipos.converterParaBigDecimal(registroLido[_oee]);
			regInd.disponibilidade = ConversaoTipos.converterParaBigDecimal(registroLido[_disponibilidade]);
			regInd.qualidade = ConversaoTipos.converterParaBigDecimal(registroLido[_qualidade]);
			regInd.ritmo = ConversaoTipos.converterParaBigDecimal(registroLido[_ritmo]);
			regInd.eficic = ConversaoTipos.converterParaBigDecimal(registroLido[_eficic]);

			retorno.setStFuncionamento(regInd.stfuncionamento);
			retorno.setOee(ConversaoTipos.converteParaString(regInd.oee, 2));
			retorno.setDisponibilidade(ConversaoTipos.converteParaString(regInd.disponibilidade, 2));
			retorno.setQualidade(ConversaoTipos.converteParaString(regInd.qualidade, 2));
			
			if (filtro.getIdIHM().equals("idihmweb3")) {
				retorno.setRitmo(ConversaoTipos.converteParaString(regInd.eficic, 2));
			} else {
				retorno.setRitmo(ConversaoTipos.converteParaString(regInd.ritmo, 2));
			}
		}

		return retorno;
	}

	/*
	@SuppressWarnings("unchecked")
	public MaquinasTempoRealIHMWebDTO getTempoRealIHMWeb3(String urlIP, DAOGenerico daoVF) {
		MaquinasTempoRealIHMWebDTO retorno = new MaquinasTempoRealIHMWebDTO();
		retorno.setMaquinas(new ArrayList<TempoRealIHMWebDTO>());

		int _dtRef = 0;
		int _cdTurno = _dtRef + 1;

		int _cdmaquina = 0;
		int _nrop = _cdmaquina + 1;
		int _stfuncionamento = _nrop + 1;
		int _qualidade = _stfuncionamento + 1;
		int _disponibilidade = _qualidade + 1;
		int _oee = _disponibilidade + 1;
		int _ciclomedio = _oee + 1;
		int _ciclopadrao = _ciclomedio + 1;
		int _dthrIniPrev = _ciclopadrao + 1;
		int _dthrIniReal = _dthrIniPrev + 1;

		int _plannCdMaquina = 0;
		int _plannTempoNecPlan = _plannCdMaquina + 1;
		int _plannTempoNecPrev = _plannTempoNecPlan + 1;

		BigDecimal metaOEEInf = BigDecimal.ZERO;
		BigDecimal metaOEESup = BigDecimal.ZERO;
		BigDecimal metaQldInf = BigDecimal.ZERO;
		BigDecimal metaQldSup = BigDecimal.ZERO;
		BigDecimal metaRitmoInf = BigDecimal.ZERO;
		BigDecimal metaRitmoSup = BigDecimal.ZERO;

		// recuperar lista de maquinas
		String strSQL = "";
		SQLQuery qUPs = null;

		strSQL = "";
		strSQL = strSQL.concat("SELECT c.cd_up ");
		strSQL = strSQL.concat("  FROM ms_ihm a ");
		strSQL = strSQL.concat("  JOIN ms_upihm b ON (b.id_ihm = a.id_ihm) ");
		strSQL = strSQL.concat("  JOIN ms_up c ON (c.id_up = b.id_up) ");
		strSQL = strSQL.concat(" WHERE a.url_ip = :ip ");
		strSQL = strSQL.concat("   AND c.st_ativo = 1 ");
		qUPs = daoVF.getDao().getSession().createSQLQuery(strSQL);
		qUPs.setString("ip", urlIP);
		List<String> listaUPs = qUPs.list();

		class RegistroIndicadores {
			String cdMaquina = "";
			String nrOP = "";
			Integer stFuncionamento = 0;
			BigDecimal qualidade = BigDecimal.ZERO;
			BigDecimal disponibilidade = BigDecimal.ZERO;
			BigDecimal ritmo = BigDecimal.ZERO;
			BigDecimal oee = BigDecimal.ZERO;
			BigDecimal ciclomedio = BigDecimal.ZERO;
			BigDecimal ciclopadrao = BigDecimal.ZERO;
			Date dthrIniPlan;
			Date dthrIniReal;
		}

		class RegistroPeriodosOP {
			String cdMaquina;
			BigDecimal tempoNecPlan;
			BigDecimal tempoNecPrev;
		}

		class RegistroTurnoAtual {
			Date dtRef;
			String cdTurno;
		}

		strSQL = "";
		SQLQuery q = null;
		List<Object> listaReg = null;

		// recupera ultimo turno consolidado
		strSQL = "";
		strSQL = strSQL.concat("SELECT dtref, cdturno, dthrini ");
		strSQL = strSQL.concat("  FROM ijcnsTurIniFim a ");
		strSQL = strSQL.concat(" ORDER BY a.dthrini DESC");
		q = this.getDaoSession().createSQLQuery(strSQL);
		q.setMaxResults(1);

		listaReg = q.list();
		Object[] registroLido = null;
		Object reg = null;
		reg = listaReg.get(0);
		Object registroAux = (Object) reg;
		registroAux = (Object) reg;
		registroLido = (Object[]) registroAux;

		RegistroTurnoAtual regTur = new RegistroTurnoAtual();
		regTur.dtRef = (Date) registroLido[_dtRef];
		regTur.cdTurno = (String) registroLido[_cdTurno];

		MonitorizacaoInjetRN rnM = new MonitorizacaoInjetRN();
		List<OmInd> listaCfgInd = rnM.getCfgIndInjet(getDao());

		for (OmInd ind : listaCfgInd) {
			OmCfgind cfgInd = ind.getOmCfginds().iterator().next();

			if (ind.getIdInd() == OEE) {
				metaOEEInf = cfgInd.getIndInferior();
				metaOEESup = cfgInd.getIndSuperior();
			}

			if (ind.getIdInd() == IR) {
				metaQldInf = new BigDecimal(100).subtract(cfgInd.getIndSuperior());
				metaQldSup = new BigDecimal(100).subtract(cfgInd.getIndInferior());
			}

			if (ind.getIdInd() == RITMO) {
				metaRitmoInf = cfgInd.getIndInferior();
				metaRitmoSup = cfgInd.getIndSuperior();
			}
		}

		// periodos OP: inicio planejado, inicio real, tempo nec para produzir (utilizado no cálculo do final planejado)
		Map<String, RegistroPeriodosOP> mapPeriodos = new HashMap<String, RegistroPeriodosOP>();

		strSQL = "";
		strSQL = strSQL.concat("SELECT r.cdinjestendido, MAX(r.temponecplan) as temponecplan, MAX(r.temponecprev) as temponecprev");
		strSQL = strSQL.concat("  FROM ( ");
		strSQL = strSQL.concat(
				"		SELECT c.cdinjestendido, a.dthriprevista, a.dthrireal, e.cdproduto, b.prodplan, b.prodliquida, (b.prodplan - b.prodliquida) as saldo, ");
		strSQL = strSQL
				.concat("       			( (b.prodplan / (e.qtcavidades * d.fatorcontagemprod)) * d.ciclopadrao  ) as temponecplan, ");
		strSQL = strSQL.concat(
				"       			( ((b.prodplan - b.prodliquida) / (e.qtcavidades * d.fatorcontagemprod)) * d.ciclopadrao  ) as temponecprev ");
		strSQL = strSQL.concat("  		  FROM ijop a ");
		strSQL = strSQL.concat("  		  JOIN ijtbinj c ON (c.opatual = a.nrop) ");
		strSQL = strSQL.concat(
				"  		  JOIN ijfictec d ON (d.cdinjetora = a.cdinjetora AND d.cdmolde = a.cdmolde AND d.cdestrutura = a.cdestrutura AND d.dthrfvalcic IS NULL) ");
		strSQL = strSQL.concat(
				"  		  JOIN ijmolpro e ON (e.cdmolde = d.cdmolde AND e.cdestrutura = d.cdestrutura AND e.dthrival = d.dthrivalestru) ");
		strSQL = strSQL.concat("  		  JOIN ( ");
		strSQL = strSQL.concat(
				"        		SELECT a.nrop, a.cdproduto, SUM(a.prodbruta - a.prodrefugada) as prodliquida, AVG(o.qtpecasproduzir) as prodplan ");
		strSQL = strSQL.concat("          		  FROM viewBIDtRefProdutos a ");
		strSQL = strSQL.concat("          		  JOIN ijopprodutos o ON (o.nrop = a.nrop and o.cdproduto = a.cdproduto) ");
		strSQL = strSQL.concat("          		  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora AND b.opatual = a.nrop) ");
		strSQL = strSQL.concat("         		 WHERE a.cdinjestendido IN (:listamaquinas)");
		strSQL = strSQL.concat("         		 GROUP BY a.nrop, a.cdproduto) b ON (b.nrop = a.nrop AND b.cdproduto = e.cdproduto) ");
		strSQL = strSQL.concat(" 	     WHERE c.cdinjestendido IN (:listamaquinas)");
		strSQL = strSQL.concat("      ) r ");
		strSQL = strSQL.concat(" GROUP BY r.cdinjestendido, r.dthrireal, r.dthriprevista ");
		q = this.getDaoSession().createSQLQuery(strSQL);
		q.setParameterList("listamaquinas", listaUPs);

		listaReg = q.list();
		for (Object regP : listaReg) {
			registroLido = null;
			Object registroLidoAux = (Object) regP;
			registroLido = (Object[]) registroLidoAux;

			RegistroPeriodosOP regPeriodos = new RegistroPeriodosOP();
			regPeriodos.cdMaquina = (String) registroLido[_plannCdMaquina];
			regPeriodos.tempoNecPlan = ConversaoTipos.converterParaBigDecimal(registroLido[_plannTempoNecPlan]);
			regPeriodos.tempoNecPrev = ConversaoTipos.converterParaBigDecimal(registroLido[_plannTempoNecPrev]);

			mapPeriodos.put(regPeriodos.cdMaquina, regPeriodos);
		}

		// recupera lista com tudo (pode estar com op mas ainda nao consolidacao)
		strSQL = "";
		strSQL = strSQL.concat("SELECT r.cdinjestendido, MAX(r.temponecplan) as temponecplan ");
		strSQL = strSQL.concat("  FROM ( ");
		strSQL = strSQL
				.concat("        SELECT c.cdinjestendido, a.dthriprevista, a.dthrireal, e.cdproduto, b.qtpecasproduzir as prodplan, ");
		strSQL = strSQL
				.concat("               ( (b.qtpecasproduzir / (e.qtcavidades * d.fatorcontagemprod)) * d.ciclopadrao  ) as temponecplan ");
		strSQL = strSQL.concat("          FROM ijop a ");
		strSQL = strSQL.concat("          JOIN ijopprodutos b ON (b.nrop = a.nrop) ");
		strSQL = strSQL.concat("          JOIN ijtbinj c ON (c.opatual = a.nrop) ");
		strSQL = strSQL.concat(
				"          JOIN ijfictec d ON (d.cdinjetora = a.cdinjetora AND d.cdmolde = a.cdmolde AND d.cdestrutura = a.cdestrutura AND d.dthrfvalcic IS NULL) ");
		strSQL = strSQL.concat(
				"          JOIN ijmolpro e ON (e.cdmolde = d.cdmolde AND e.cdestrutura = d.cdestrutura AND e.dthrival = d.dthrivalestru AND e.cdproduto = b.cdproduto) ");
		strSQL = strSQL.concat("         WHERE c.cdinjestendido IN (:listamaquinas)");
		strSQL = strSQL.concat("      ) r ");
		strSQL = strSQL.concat(" GROUP BY r.cdinjestendido");
		q = this.getDaoSession().createSQLQuery(strSQL);
		q.setParameterList("listamaquinas", listaUPs);

		listaReg = q.list();
		for (Object regP : listaReg) {
			registroLido = null;
			Object registroLidoAux = (Object) regP;
			registroLido = (Object[]) registroLidoAux;

			RegistroPeriodosOP regPeriodos = new RegistroPeriodosOP();
			regPeriodos.cdMaquina = (String) registroLido[_plannCdMaquina];
			regPeriodos.tempoNecPlan = ConversaoTipos.converterParaBigDecimal(registroLido[_plannTempoNecPlan]);
			regPeriodos.tempoNecPrev = regPeriodos.tempoNecPlan;

			if (!mapPeriodos.containsKey(regPeriodos.cdMaquina)) {
				mapPeriodos.put(regPeriodos.cdMaquina, regPeriodos);
			}
		}

		// indicadores
		strSQL = "";
		strSQL = strSQL.concat(
				"SELECT i.cdinjestendido, a.nropexibicao, i.stfuncionamento, a.qualidade, a.disponbilidade, a.oee, a.ciclomedio, ft.ciclopadrao, op.dthriprevista, op.dthrireal ");
		strSQL = strSQL.concat("  FROM ijtbinj i ");
		strSQL = strSQL.concat("  LEFT JOIN ijop op ON (op.nrop = i.opatual) ");
		strSQL = strSQL.concat(
				"  LEFT JOIN ijfictec ft ON (ft.cdinjetora = i.cdinjetora AND ft.cdmolde = i.CdMoldeAtual AND ft.cdestrutura = i.CdEstruturaAtual AND ft.dthrfvalcic IS NULL) ");
		strSQL = strSQL.concat("  LEFT JOIN (SELECT a.cdinjestendido, a.nropexibicao, ");
		strSQL = strSQL.concat(
				"                    (100 - (CASE WHEN a.prodbruta = 0 THEN 0 ELSE (a.prodrefugada / a.prodbruta) * 100 END)) as qualidade,  ");
		strSQL = strSQL.concat(
				"                    (CASE WHEN a.tmpativo = 0 THEN 0 ELSE (a.tmptrabalhado / a.tmpativo) * 100 END) as disponbilidade, ");
		strSQL = strSQL.concat(
				"                    (CASE WHEN a.qtdciclosnormais = 0 THEN 0 ELSE (a.tmpcicnormal / a.qtdciclosnormais) END) as ciclomedio, ");
		strSQL = strSQL.concat(
				"                    (CASE WHEN a.tmpprodutivas < 0 OR a.tmpativo = 0 THEN 0 ELSE (a.tmpprodutivas / a.tmpativo) * 100 END) as oee ");
		strSQL = strSQL.concat("               FROM ( ");
		strSQL = strSQL.concat("                      SELECT a.cdinjestendido, d.nropexibicao, ");
		strSQL = strSQL.concat("                             SUM(b.tmpativo) as tmpativo, ");
		strSQL = strSQL
				.concat("                             SUM(b.tmpcicnormal - a.tmppcsref - a.tmpcavidades - b.tmpritmo) as tmpprodutivas, ");
		strSQL = strSQL.concat("                             SUM(a.prodrefugada) as prodrefugada,  ");
		strSQL = strSQL.concat("                             SUM(a.prodbruta) as prodbruta, ");
		strSQL = strSQL.concat("                             SUM(a.prodbruta - a.prodrefugada) as prodliquida, ");
		strSQL = strSQL.concat("                             SUM(a.prodprev) as prodprev, ");
		strSQL = strSQL.concat("                             SUM(b.tmpativo - b.tmpparadasCP) as tmptrabalhado, ");
		strSQL = strSQL.concat("                             SUM(b.qtdciclosnormais) as qtdciclosnormais, ");
		strSQL = strSQL.concat("                             SUM(b.tmpcicnormal) as tmpcicnormal ");
		strSQL = strSQL.concat("                        FROM viewBIDtRefQtds a ");
		strSQL = strSQL.concat("                        JOIN viewBIDtRefTempos b ON (    b.dtturno = a.dtturno ");
		strSQL = strSQL.concat("                                                     AND b.cdturno = a.cdturno   ");
		strSQL = strSQL.concat("                                                     AND b.cdinjetora = a.cdinjetora  ");
		strSQL = strSQL.concat("                                                     AND b.nrop = a.nrop ");
		strSQL = strSQL.concat("                                                     AND b.cdmolde = a.cdmolde ");
		strSQL = strSQL.concat("                                                     AND b.cdestrutura = a.cdestrutura ");
		strSQL = strSQL.concat("                                                     AND b.dthrivalestru = a.dthrivalestru ");
		strSQL = strSQL.concat("                                                     AND b.dthrivalcic = a.dthrivalcic )");
		strSQL = strSQL.concat("                        JOIN ijtbinj c ON (c.cdinjetora = a.cdinjetora AND c.opatual = a.nrop) ");
		strSQL = strSQL.concat("                        JOIN ijoproteiro d ON (d.nrop = c.opatual) ");
		strSQL = strSQL.concat("                       WHERE a.dtturno = :dtturno ");
		strSQL = strSQL.concat("                         AND a.cdturno = :cdturno ");
		strSQL = strSQL.concat("                         AND a.cdinjestendido IN (:listamaquinas)");
		strSQL = strSQL.concat("                       GROUP BY a.cdinjestendido, d.nropexibicao ");
		strSQL = strSQL.concat("                     ) a ");
		strSQL = strSQL.concat("              ) a ON (a.cdinjestendido = i.cdinjestendido)");
		strSQL = strSQL.concat(" WHERE i.cdinjestendido IN (:listamaquinas)");

		q = this.getDaoSession().createSQLQuery(strSQL);

		q.setParameterList("listamaquinas", listaUPs)
				.setString("cdturno", regTur.cdTurno)
				.setDate("dtturno", regTur.dtRef);

		listaReg = q.list();

		for (Object regI : listaReg) {
			registroLido = null;
			Object registroLidoAux = (Object) regI;
			registroLido = (Object[]) registroLidoAux;

			RegistroIndicadores regInd = new RegistroIndicadores();
			regInd.cdMaquina = (String) registroLido[_cdmaquina];

			TempoRealIHMWebDTO maquinaTReal = new TempoRealIHMWebDTO();
			maquinaTReal.setCdMaquina(regInd.cdMaquina);
			maquinaTReal.setNrOP("");
			maquinaTReal.setStFuncionamento(StFuncionamento.MAQUINA_SEM_CONEXAO.toString());
			maquinaTReal.setMetaOEELimInf(ConversaoTipos.converteParaString(metaOEEInf, 2));
			maquinaTReal.setMetaOEELimSup(ConversaoTipos.converteParaString(metaOEESup, 2));
			maquinaTReal.setMetaDisponibilidadeLimInf(ConversaoTipos.converteParaString(metaOEEInf, 2));
			maquinaTReal.setMetaDisponibilidadeLimSup(ConversaoTipos.converteParaString(metaOEESup, 2));
			maquinaTReal.setMetaQualidadeLimInf(ConversaoTipos.converteParaString(metaQldInf, 2));
			maquinaTReal.setMetaQualidadeLimSup(ConversaoTipos.converteParaString(metaQldSup, 2));
			maquinaTReal.setMetaRitmoLimInf(ConversaoTipos.converteParaString(metaRitmoInf, 2));
			maquinaTReal.setMetaRitmoLimSup(ConversaoTipos.converteParaString(metaRitmoSup, 2));

			maquinaTReal.setDtHrIniPlan("");
			maquinaTReal.setDtHrFimPlan("");
			maquinaTReal.setDtHrIniReal("");
			maquinaTReal.setDtHrFimPrev("");

			maquinaTReal.setOee("");
			maquinaTReal.setDisponibilidade("");
			maquinaTReal.setRitmo("");
			maquinaTReal.setQualidade("");

			if (registroLido[_stfuncionamento] != null) {
				regInd.stFuncionamento = ConversaoTipos.converterParaBigDecimal(registroLido[_stfuncionamento]).intValue();
				maquinaTReal.setStFuncionamento(regInd.stFuncionamento.toString());
			}

			if (registroLido[_nrop] != null) {
				regInd.dthrIniPlan = (Date) registroLido[_dthrIniPrev];
				regInd.dthrIniReal = (Date) registroLido[_dthrIniReal];

				if (mapPeriodos.containsKey(maquinaTReal.getCdMaquina())) {
					// calcular final previsto
					RegistroPeriodosOP regPeriodos = mapPeriodos.get(maquinaTReal.getCdMaquina());
					Date dthrFimPrev = DataHoraRN.somaSegundos(DataHoraRN.getDataHoraAtual(), regPeriodos.tempoNecPrev.intValue());
					Date dtHrFimPlan = DataHoraRN.somaSegundos(regInd.dthrIniPlan, regPeriodos.tempoNecPlan.intValue());

					maquinaTReal.setDtHrIniPlan(DataHoraRN.dateToStringDDMMYYYYHHMMSS(regInd.dthrIniPlan));
					maquinaTReal.setDtHrFimPlan(DataHoraRN.dateToStringDDMMYYYYHHMMSS(dtHrFimPlan));
					maquinaTReal.setDtHrIniReal(DataHoraRN.dateToStringDDMMYYYYHHMMSS(regInd.dthrIniReal));
					maquinaTReal.setDtHrFimPrev(DataHoraRN.dateToStringDDMMYYYYHHMMSS(dthrFimPrev));

				}

				regInd.nrOP = (String) registroLido[_nrop];
				regInd.qualidade = ConversaoTipos.converterParaBigDecimal(registroLido[_qualidade]);
				regInd.disponibilidade = ConversaoTipos.converterParaBigDecimal(registroLido[_disponibilidade]);
				regInd.oee = ConversaoTipos.converterParaBigDecimal(registroLido[_oee]);
				regInd.ciclopadrao = ConversaoTipos.converterParaBigDecimal(registroLido[_ciclopadrao]);
				regInd.ciclomedio = ConversaoTipos.converterParaBigDecimal(registroLido[_ciclomedio]);
				regInd.ritmo =
						AritmeticaUtil.multiplicar(AritmeticaUtil.dividir(regInd.ciclopadrao, regInd.ciclomedio), new BigDecimal(100));

				maquinaTReal.setOee(ConversaoTipos.converteParaString(regInd.oee, 2));
				maquinaTReal.setDisponibilidade(ConversaoTipos.converteParaString(regInd.disponibilidade, 2));
				maquinaTReal.setQualidade(ConversaoTipos.converteParaString(regInd.qualidade, 2));
				maquinaTReal.setRitmo(ConversaoTipos.converteParaString(regInd.ritmo, 2));
			}

			retorno.getMaquinas().add(maquinaTReal);
		}

		return retorno;
	}
	*/
}
