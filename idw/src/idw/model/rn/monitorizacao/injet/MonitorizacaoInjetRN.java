package idw.model.rn.monitorizacao.injet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmImgDAO;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolal;
import idw.model.pojos.DwConsolallog;
import idw.model.pojos.DwConsolaloco;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwRt;
import idw.model.pojos.DwTAlerta;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmAlgocor;
import idw.model.pojos.OmCfgind;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmImg;
import idw.model.pojos.OmInd;
import idw.model.pojos.OmIndpt;
import idw.model.pojos.OmIndtppt;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.injet.Ijdetgrafico;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.DiversosInjetRN;
import idw.model.rn.injet.FuncoesApoioInjet;
import idw.util.AritmeticaUtil;
import idw.util.IdwLogger;
import idw.webservices.dto.ObjDTO;
import idw.webservices.dto.ObjsDTO;
import idw.webservices.rest.dto.monitorizacao.injet.ProjecaoPCIDTO;
import ms.util.ConversaoTipos;

public class MonitorizacaoInjetRN extends AbstractRN<DAOGenericoInjet> {
	public static final String SIGLA_MAQ_INJETORA = "INJ";
	public static final String SIGLA_MAQ_CUSINAGEM = "CU";
	public static final String SIGLA_MAQ_CUSINAGEM_KENNAMETAL = "CUK";
	public static final String SIGLA_MAQ_PRENSA = "PRENSA";
	public static final String SIGLA_MAQ_NAVIO = "NAV";
	public static final String SIGLA_MAQ_ROBOT = "ROBOT";
	public static final String SIGLA_MAQ_LINHA = "LINHA";
	public static final String SIGLA_MAQ_TORNO = "TORNO";
	public static final String SIGLA_MAQ_FURADEIRA = "FURADEIRA";
	public static final String SIGLA_MAQ_ENVASADORA = "ENVASADORA";
	public static final String SIGLA_MAQ_EMBALADORA = "EMBALADORA";
	public static final String SIGLA_MAQ_SOPRADORA = "SOPRADORA";
	public static final String SIGLA_MAQ_ROTULADORA = "ROTULADORA";
	public static final String SIGLA_MAQ_SLITTER = "SLITTER";
	public static final String SIGLA_MAQ_LINER = "LINER";
	public static final String SIGLA_MAQ_TOP = "TOP";
	public static final String SIGLA_MAQ_GALVANOPLASTIA = "GALVA";

	
	public MonitorizacaoInjetRN() {
		super(new DAOGenericoInjet());
	}
	
	public MonitorizacaoInjetRN(DAOGenericoInjet dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenericoInjet();
		}
		this.setDao(dao);
	}
	
	/**
	 * Recupera os objetos espec�ficos do Grupo de trabalho
	 * 
	 * @param idGt
	 *            Id do grupo de trabalho
	 * @return
	 */
	public ObjsDTO getObjsDTO(IdwLogger log, long idGt, Long idPt, boolean clonaResultado) {
		ObjDTO objDTO = new ObjDTO();
		objDTO.setObj(new OmObj());
		objDTO.getObj().setOmGtByIdGt(new OmGt());
		objDTO.getObj().getOmGtByIdGt().setIdGt(idGt);
		objDTO.getObj().setOmPt(new OmPt());
		objDTO.getObj().getOmPt().setIdPt(idPt);

		return this.getObjsDTO(log, objDTO, clonaResultado);
	}
	
	/**
	 * Recupera os objetos conforme o filtro
	 * 
	 * @param filtro
	 *            <p>
	 *            <code>filtro.getObj().getOmGtByIdGt().getIdGt()</code> pega
	 *            objetos relacionados IdGt indicado
	 *            <p>
	 *            <code>filtro.getObj().getOmGtByIdGtfilho().getIdGt()</code>
	 *            pega objetos relacionados IdGt filho indicado
	 *            <p>
	 *            <code>filtro.getObj().getOmPt().getIdGt()</code> pega objetos
	 *            relacionados IdPt indicado
	 *            <p>
	 *            pega todos os objetos, caso nenhum filtro foi passado
	 * @param clonaResultado
	 *            <p>
	 *            itens da lista devem ser clonados
	 * @return lista de OmObj
	 */
	@SuppressWarnings({"unused", "unchecked"})
	public ObjsDTO getObjsDTO(IdwLogger log, ObjDTO filtro, boolean clonaResultado) {
		byte _cdGalpao = 0;
		byte _cdInjetora = 1;
		byte _coorRelObjx = 2;
		byte _corrRelObjy = 3;
		byte _cdInjEstendido = 4;
		byte _tpIcone = 5;
		
		class RegistroLido {
			String cdGalpao;
			String cdInjetora;
			String cdInjEstendido;
			BigDecimal coorRelObjx = BigDecimal.ZERO;
			BigDecimal coorRelObjy = BigDecimal.ZERO;
			String tpIcone;
		}
		
		
		List<OmInd> listaCfgInd = getCfgIndInjet(getDao());
		
		
		boolean filtroGt = false;
		boolean filtroPt = false;
		
		String strSQL = "";
		
		strSQL = strSQL.concat("SELECT a.cdgalpao, a.cdinjetora, a.coorelobjx, a.coorelobjy, b.cdinjestendido, b.TpIcone ");
		strSQL = strSQL.concat("  FROM ijgalobj a, ijtbinj b ");
		strSQL = strSQL.concat(" WHERE a.cdinjetora = b.cdinjetora "); 
		strSQL = strSQL.concat("   AND a.CdPosto IS NULL ");
		
		
		if (filtro.getObj() != null && 
			filtro.getObj().getOmGtByIdGt() != null &&
			filtro.getObj().getOmGtByIdGt().getIdGt() != null &&
			filtro.getObj().getOmGtByIdGt().getIdGt().equals(0l) == false) {

			filtro.getObj().getOmGtByIdGt().setCdGt(FuncoesApoioInjet.getStrZero(filtro.getObj().getOmGtByIdGt().getIdGt(),6));

			strSQL = strSQL.concat(" AND a.cdgalpao = :cdgalpao ");
			
			filtroGt = true;
		}
		
		if (filtro.getObj() != null && 
			filtro.getObj().getOmPt() != null && 
			filtro.getObj().getOmPt().getIdPt() != null && 
			filtro.getObj().getOmPt().getIdPt() != 0) {
			
			strSQL = strSQL.concat(" AND b.cdinjestendido = :cdinjetora ");
			
			filtroPt = true;
		}
		
		strSQL = strSQL.concat(" ORDER BY a.coorelobjy, a.coorelobjx ");
		
		List<ObjDTO> listaObj = new ArrayList<ObjDTO>();		
		List<Object> lista = new ArrayList<Object>();	
		
		if (filtroGt && filtroPt) {
			lista = this.getDaoSession().createSQLQuery(strSQL)
					.setString("cdgalpao", filtro.getObj().getOmGtByIdGt().getCdGt())
					.setString("cdinjetora", filtro.getObj().getOmPt().getCdPt()).list();
		} else {
			if (filtroGt) {
				lista = this.getDaoSession().createSQLQuery(strSQL)
						.setString("cdgalpao", filtro.getObj().getOmGtByIdGt().getCdGt()).list();
			} else {
				lista = this.getDaoSession().createSQLQuery(strSQL)
						.setString("cdinjetora", filtro.getObj().getOmPt().getCdPt()).list();				
			}			
		}
		
		
		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();
			
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			registro.cdGalpao = (String) registroLido[_cdGalpao];
			registro.cdInjetora = (String) registroLido[_cdInjetora];
			registro.cdInjEstendido = (String) registroLido[_cdInjEstendido];
			registro.coorRelObjx =  ConversaoTipos.converterParaBigDecimal(registroLido[_cdGalpao]);
			registro.coorRelObjy = ConversaoTipos.converterParaBigDecimal(registroLido[_cdGalpao]);
			registro.tpIcone  = (String) registroLido[_tpIcone];
			
			ObjDTO obj = new ObjDTO();
			OmObj omObj = new OmObj();
			
			
			if (registro.cdInjetora.substring(0, 1).equals("|")) {
				omObj.setIdObj(ConversaoTipos.converteParaBigDecimal(registro.cdInjetora.substring(1, 5)).longValue());
			} else {
				omObj.setIdObj(ConversaoTipos.converteParaBigDecimal(ConversaoTipos.converteStringParaSequenciaNumericaUniCode(registro.cdInjetora)).longValue());	
			}
			
			
			omObj.setX(registro.coorRelObjx);
			omObj.setY(registro.coorRelObjy);
			omObj.setTpObj((byte) 0); // maquina ???
			
			OmPt omPt = new OmPt();
			omPt.setIdPt(omObj.getIdObj());
			omPt.setCdPt(registro.cdInjEstendido);
			omPt.setDsPt(registro.cdInjEstendido);
			omPt.setDsCurta(registro.cdInjEstendido);
			
			OmTppt omTppt = new OmTppt();
			OmAlgocor omAlgocor = new OmAlgocor();
			omAlgocor.setIdAlgocor(3); // cores tipo injet
			omAlgocor.setDsAlgocor("Cores tipo Injet");

			// maquinas ciclicas
			omTppt.setIdTppt(1l);
			omTppt.setCdTppt("CIC"); 
			omTppt.setOmAlgocor(omAlgocor);
			omTppt.setOmIndtppts(new HashSet<OmIndtppt>());
			
			omPt.setOmTppt(omTppt);
			omPt.setOmIndpts(new HashSet<OmIndpt>());
			
			for (OmInd ind : listaCfgInd){
				OmIndpt indPt = new OmIndpt();
				OmCfgind cfgInd = ind.getOmCfginds().iterator().next();
				
				indPt.setOmInd(ind);
				indPt.setIndInferior(cfgInd.getIndInferior());
				indPt.setIndMeta(cfgInd.getIndMeta());
				indPt.setIndSuperior(cfgInd.getIndSuperior());

				omPt.getOmIndpts().add(indPt);
			}			
			
			
			DAOGenerico daoVF = new DAOGenerico();
			daoVF.iniciaSessao();
			OmImgDAO imgDAO = new OmImgDAO(daoVF.getSession());
			OmImg omImg = imgDAO.getOmImgPorCdAtivo(getIdImgInjetToVF(registro.tpIcone));
			daoVF.finalizaSessao();
			omObj.setOmPt(omPt);			
			omObj.setOmImg(omImg);			
			omObj.setOmGtByIdGt(filtro.getObj().getOmGtByIdGt());
			
			obj.setObj(omObj);		
			listaObj.add(obj);
		}
		

		ObjsDTO Objs = new ObjsDTO();
		Objs.setObjs(listaObj);
		
		return Objs;
	}

	private String getIdImgInjetToVF(String tpIconeInjet) {
		String retorno = "28"; 

		if (tpIconeInjet.equals(SIGLA_MAQ_EMBALADORA)) {
			retorno = "25";
		}		
		if (tpIconeInjet.equals(SIGLA_MAQ_ENVASADORA)) {
			retorno = "26";
		}
		if (tpIconeInjet.equals(SIGLA_MAQ_FURADEIRA)) {
			retorno = "27";
		}		
		if (tpIconeInjet.equals(SIGLA_MAQ_INJETORA)) {
			retorno = "28";
		}	
		if (tpIconeInjet.equals(SIGLA_MAQ_LINHA)) {
			retorno = "29";
		}		
		if (tpIconeInjet.equals(SIGLA_MAQ_PRENSA)) {
			retorno = "30";
		}
		if (tpIconeInjet.equals(SIGLA_MAQ_ROBOT)) {
			retorno = "31";
		}
		if (tpIconeInjet.equals(SIGLA_MAQ_ROTULADORA)) {
			retorno = "32";
		}		
		if (tpIconeInjet.equals(SIGLA_MAQ_SOPRADORA)) {
			retorno = "33";
		}
		
		if (tpIconeInjet.equals(SIGLA_MAQ_GALVANOPLASTIA)) {
			retorno = "225";
		}
		if (tpIconeInjet.equals(SIGLA_MAQ_LINER)) {
			retorno = "226";
		}				
		if (tpIconeInjet.equals(SIGLA_MAQ_NAVIO)) {
			retorno = "227";
		}		
		if (tpIconeInjet.equals(SIGLA_MAQ_SLITTER)) {
			retorno = "228";
		}
		if (tpIconeInjet.equals(SIGLA_MAQ_TORNO)) {
			retorno = "229";
		}
		if (tpIconeInjet.equals(SIGLA_MAQ_CUSINAGEM) || tpIconeInjet.equals(SIGLA_MAQ_CUSINAGEM_KENNAMETAL)) {
			retorno = "230";
		}
		if (tpIconeInjet.equals(SIGLA_MAQ_TOP)) {
			retorno = "231";
		}
		
		return retorno;
	}
	
	
	@SuppressWarnings({"unused", "unchecked"})
	// Obtem a lista de Consolmolog do gt ou pt que estao em aberto
	public List<DwConsolmolog> getOperadoresLogadosInjet(OmGt omGt, OmPt omPt) {
		
		byte _dthrLogin = 0;
		byte _dthrLogout = 1;
		byte _cdUsuario = 2;
		byte _nmAcesso = 3;
		byte _nmUsuario = 4;
		byte _cdinjetora = 5;
		byte _cdinjestendido = 6;
		byte _cdidentific = 7;
		
		
		class RegistroLido {
			Date dthrLogin;
			Date dtHrLogout;
			String cdUsuario;
			String nmAcesso;
			String nmUsuario;
			String cdInjetora;
			String cdInjEstendido;
			String cdIdentific;
		}
		
		List<DwConsolmolog> dwConsolmologs = new ArrayList<DwConsolmolog>();
		
		
		MapQuery q = new MapQuery(this.getDaoSession());

		String strSQL = "";		
		strSQL = strSQL.concat("SELECT a.dthrlogin, a.dthrlogout, a.cdusuario,");
		strSQL = strSQL.concat("       d.nmacesso, d.nmusuario,  ");
		strSQL = strSQL.concat("       a.cdinjetora, b.cdinjestendido, b.cdidentific ");
		strSQL = strSQL.concat("  FROM ijlogope a");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora)");
		strSQL = strSQL.concat("  JOIN ijtbusu d ON (d.cdusuario = a.cdusuario) ");
		
		if (omGt != null) {
			strSQL = strSQL.concat(" JOIN ijgalobj c ON (c.cdinjetora = a.cdinjetora)");
		}
		
		strSQL = strSQL.concat(" WHERE a.dthrlogout IS NULL ");
		
		
		if (omPt != null) {
			strSQL = strSQL.concat(" AND b.cdinjestendido = '" + omPt.getCdPt() + "'");
		} else if (omGt != null) {
			strSQL = strSQL.concat(" AND c.cdgalpao = '" + omGt.getCdGt() + "'" );
		}

		strSQL = strSQL.concat(" ORDER BY a.dthrlogin");
		List<Object> lista = this.getDaoSession().createSQLQuery(strSQL).list();
		for (Object reg : lista) {		
			RegistroLido regLido = new RegistroLido();			
			
			Object[] registro = null;
			Object registroAux = (Object) reg;
			registro = (Object[]) registroAux;
			
			regLido.dthrLogin = (Date) registro[_dthrLogin];
			regLido.dtHrLogout = registro[_dthrLogout] != null ? (Date) registro[_dthrLogout] : null;
			regLido.cdUsuario = (String) registro[_cdUsuario];
			regLido.nmAcesso = (String) registro[_nmAcesso];
			regLido.nmUsuario = (String) registro[_nmUsuario];
			regLido.cdInjetora = (String) registro[_cdinjetora];
			regLido.cdInjEstendido = (String) registro[_cdinjestendido];
			regLido.cdIdentific = (String) registro[_cdidentific];

			OmUsr omUsr = new OmUsr();
			omUsr.setCdUsr(regLido.cdUsuario);
			omUsr.setDsNome(regLido.nmUsuario);
			omUsr.setDsApelido(regLido.nmAcesso);
			
			DwConsolmolog moLog = new DwConsolmolog();
			moLog.setDthrIlogin(regLido.dthrLogin);
			moLog.setDthrFlogin(regLido.dtHrLogout);
			moLog.setOmGt(omGt);
			moLog.setOmPt(omPt);
			moLog.setOmUsr(omUsr);
			
			dwConsolmologs.add(moLog);
		}

		return dwConsolmologs;

	}

	@SuppressWarnings({"unused", "unchecked"})
	public List<DwConsolid> getDwConsolidPorDt(OmPt omPt, PpCp ppCp, DwRt dwRt, Date dtReferencia, DwTurno dwTurno) {
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
		int _cdMolEntradaCIP = _cdEstruSaidaCIP + 1 ;
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
		int _qtdCiclosNormais = _qtdPerdaParSP  + 1;
		int _qtdCiclosFinParada = _qtdCiclosNormais + 1;
		int _cicloPadraoMin = _qtdCiclosFinParada + 1;
		int _cicloPadraoMax = _cicloPadraoMin + 1;
		int _dtTurno = _cicloPadraoMax + 1;
		int _cdTurno = _dtTurno + 1;
		int _segTmpParMTBF = _cdTurno + 1;
		int _qtParMTBF = _segTmpParMTBF + 1;    	
		
		class RegistroLido {
			BigDecimal idregistro = BigDecimal.ZERO;
			String nrOP;
			String cdInjetora;
			String cdMolde;
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
    		BigDecimal segTmpParMTBF = BigDecimal.ZERO;
    		BigDecimal qtParMTBF = BigDecimal.ZERO;    				
		}
		
		
		strSQL = strSQL.concat("SELECT a.idregistro, a.nrop, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalcic, a.dthrivalestru, c.ciclopadrao, c.fatorcontagemprod, d.qtcavativas, d.qtcavidades,");
		
		strSQL = strSQL.concat("       (CASE WHEN a.qtinjnormal IS NULL or a.qtinjnormal = 0 THEN 0 ELSE (a.tmpcicnormal  / a.qtinjnormal)  END) as ciclomedio, ");
		strSQL = strSQL.concat("       (b.prodbrutaOP) as prodbrutaOP, ");
		strSQL = strSQL.concat("       (b.prodrefOP) as prodrefOP,");
		strSQL = strSQL.concat("       (a.qtprodbrutaUB) as prodbruta, ");
		strSQL = strSQL.concat("       (a.qtprodrefugadaUB) as prodref, ");
		strSQL = strSQL.concat("       (a.tmpcicnormal) as tmpcicnormal, ");
		strSQL = strSQL.concat("       (a.tmpcicfinparada) as tmpcicfinparada, ");
		strSQL = strSQL.concat("       (a.tmpparadas) as tmpparadasCP, ");
		strSQL = strSQL.concat("       (a.tmpparadassempeso) as tmpparadasSP, ");
		strSQL = strSQL.concat("       (FLOOR(a.tmpcicnormal / c.ciclopadrao) *  (CASE WHEN ct.campo23 = '¬¬ª¿±·¿½­' THEN d.qtcavidades ELSE d.qtcavativas END) * c.fatorcontagemprod) as prodprev, ");
		strSQL = strSQL.concat("       f.prodplanOP, ");
		strSQL = strSQL.concat("       ((CASE WHEN a.tmpativo IS NULL THEN 0 ELSE a.tmpativo END)) as tmphrsdisp, ");
		strSQL = strSQL.concat("       (a.tmpcavidades) as tmpcavidades, ");
		strSQL = strSQL.concat("       ((CASE WHEN a.tmpprodrefugada IS NULL THEN 0 ELSE a.tmpprodrefugada END)) as tmprefugo, ");
		strSQL = strSQL.concat("       ( (((a.tmpcicnormal / a.ciclopadrao) - a.qtinjnormal ) * a.ciclopadrao) ) as tmpritmo, ");
		strSQL = strSQL.concat("       tup.dthriparrefmonit, tup.dthrfparrefmonit, ");
		strSQL = strSQL.concat("       tibm.StUltInspQldBM, ");
		strSQL = strSQL.concat("       cip.IdCtrlInicProc, cipt.CdMoldeSaida as CdMoldeSaidaCIP, cipt.CdEstruSaida as CdEstruSaidaCIP, cipt.CdMoldeEntrada as CdMoldeEntradaCIP, cipt.CdEstruEntrada as CdEstruEntradaCIP, ");
		strSQL = strSQL.concat("       cip.DtHrIniCtrlIniProc, cip.DtHrFimCtrlIniProc, ");
		strSQL = strSQL.concat("       ial.QtAlertasOperador, ");
		strSQL = strSQL.concat("       i.stfuncionamento, i.aguardandomolde, i.AlertaInspQld, i.maquinaemalerta, i.StUltInspQld, ");
		strSQL = strSQL.concat(" 	   ( ( (a.tmpcicnormal / c.ciclopadrao) - a.qtinjnormal) * (d.qtcavativas * c.fatorcontagemprod)) as qtdritmo, ");
		strSQL = strSQL.concat(" 	   ( (a.qtinjnormal * (d.qtcavidades - d.qtcavativas)) * c.fatorcontagemprod) as qtdperdapcsciclo, ");
		
		strSQL = strSQL.concat(" 	   ( a.qtinjnormal * d.qtcavidades) as qtdpcsciclototal, ");
		strSQL = strSQL.concat(" 	   ( a.qtinjnormal * d.qtcavativas) as qtdpcscicloativas, ");
		
		strSQL = strSQL.concat(" 	   ( ( a.tmpparadas / c.ciclopadrao) * (d.qtcavativas * c.fatorcontagemprod) ) as qtdperdasparCP, ");
		strSQL = strSQL.concat(" 	   ( ( a.tmpparadas / c.ciclopadrao) * (d.qtcavativas * c.fatorcontagemprod) ) as qtdperdasparSP, ");
		strSQL = strSQL.concat(" 	   a.qtinjnormal, a.qtinjfinpar, c.varmin, c.varmax, a.dtturno, a.cdturno, ");
		strSQL = strSQL.concat("       mtbf.tmpparMTBFMTTR, mtbf.qtdparMTBFMTTR ");
		strSQL = strSQL.concat("  FROM viewDadosCalcOEEOP a ");
		strSQL = strSQL.concat("  JOIN ijtbfresh ct ON (1=1) ");

		strSQL = strSQL.concat(" LEFT JOIN (SELECT a.dtturno, a.cdturno, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, a.nrop, ");
		strSQL = strSQL.concat("                   SUM(a.tmpparadas + a.tmpparadassempeso) as tmpparMTBFMTTR, ");
		strSQL = strSQL.concat("                   SUM(a.qtdparadas + a.qtdparadas) as qtdparMTBFMTTR ");
		strSQL = strSQL.concat("             FROM ijreaparcnsTUR a ");
		strSQL = strSQL.concat("             JOIN ijtbinj d ON (d.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("             JOIN ijtbpar p ON (p.cdparada = a.cdparada and p.CalcMTBFMTTR = '1') ");
		strSQL = strSQL.concat("       GROUP BY a.dtturno, a.cdturno, a.cdinjetora, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, a.nrop ) ");
		strSQL = strSQL.concat("  mtbf ON (    mtbf.dtturno = a.dtturno ");
		strSQL = strSQL.concat("           AND mtbf.cdturno = a.cdturno ");	
		strSQL = strSQL.concat("           AND mtbf.cdinjetora = a.cdinjetora ");
		strSQL = strSQL.concat("           AND mtbf.cdmolde = a.cdmolde ");
		strSQL = strSQL.concat("           AND mtbf.cdestrutura = a.cdestrutura ");
		strSQL = strSQL.concat("           AND mtbf.dthrivalestru = a.dthrivalestru ");
		strSQL = strSQL.concat("           AND mtbf.dthrivalcic = a.dthrivalcic ");
		strSQL = strSQL.concat("           AND mtbf.nrop = a.nrop) ");
		
		strSQL = strSQL.concat("  LEFT JOIN (SELECT a.nrop, SUM(a.qtprodbrutaUB) as prodbrutaOP, SUM(a.qtprodrefugadaUB) as prodrefOP  ");
		strSQL = strSQL.concat("               FROM viewDadosCalcOEEOP a ");
		strSQL = strSQL.concat("              GROUP BY a.nrop) b ON (b.nrop = a.nrop)");
		strSQL = strSQL.concat("  JOIN ijfictec c ON (c.cdinjetora = a.cdinjetora AND c.cdmolde = a.cdmolde AND c.cdestrutura = a.cdestrutura AND c.dthrivalcic = a.dthrivalcic)");
		strSQL = strSQL.concat("  JOIN cavidades2 d ON (d.cdmolde = c.cdmolde AND d.cdestrutura = c.cdestrutura AND d.dthrival = c.dthrivalestru) ");
		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN (SELECT nrop, SUM(qtpecasproduzir) as prodplanOP FROM ijopprodutos GROUP BY nrop) f ON (f.nrop = a.nrop)");
		strSQL = strSQL.concat("  LEFT OUTER JOIN ijinjctrlultparmon tup ON (a.cdinjetora = tup.cdinjetora) ");
		strSQL = strSQL.concat("  LEFT OUTER JOIN ijtbinjqldctrl tibm ON (a.cdinjetora = tibm.cdinjetora)  ");
		strSQL = strSQL.concat("  LEFT OUTER JOIN IJctrlINIPROC cip ON (cip.CdInjetora  = a.cdinjetora AND cip.NrOP = a.NrOP AND cip.DtHrFimCtrlIniProc IS NULL) ");
		strSQL = strSQL.concat("  LEFT OUTER JOIN IJctrlINIPROCTroca cipt ON (cip.IdCtrlInicProc  = cipt.IdCtrlInicProc) ");
		strSQL = strSQL.concat("  LEFT OUTER JOIN ijtbinjalerta ial ON (a.cdinjetora = ial.cdinjetora)");
		
		if (dtReferencia != null || dwTurno != null) {
			strSQL = strSQL.concat(" WHERE a.dtturno = :dtref ");
			strSQL = strSQL.concat("  AND a.cdturno = :cdturno ");
			strSQL = strSQL.concat("  AND ");
		} else {
			strSQL = strSQL.concat(" WHERE ");
		}
		
		strSQL = strSQL.concat(" i.cdinjestendido = :cdinjetora");
		
		
		if (ppCp != null) {
			strSQL = strSQL.concat(" AND a.nrop = :nrop ");
		}
		
		List<Object> lista = new ArrayList<Object>();		
		if (dtReferencia != null || dwTurno != null) {			
			if (ppCp != null && ppCp.getCdCp() != null) {			
				lista = this.getDaoSession().createSQLQuery(strSQL)
						.setString("cdinjetora", omPt.getCdPt())
						.setString("nrop", ppCp.getCdCp())				
						.setTimestamp("dtref", dtReferencia)
						.setString("cdturno", dwTurno.getCdTurno()).list();
			} else {
				lista = this.getDaoSession().createSQLQuery(strSQL)
						.setString("cdinjetora", omPt.getCdPt())
						.setTimestamp("dtref", dtReferencia)
						.setString("cdturno", dwTurno.getCdTurno()).list();				
			}
			
		} else {
			lista = this.getDaoSession().createSQLQuery(strSQL)
					.setString("cdinjetora", omPt.getCdPt())
					.setString("nrop", ppCp.getCdCp()).list();
		}
		
		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();
			
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			registro.idregistro = ConversaoTipos.converterParaBigDecimal(registroLido[_idregistro]);
			registro.dtTurno = (Date) registroLido[_dtTurno];
			registro.cdTurno = (String) registroLido[_cdTurno];
			
			registro.nrOP = (String) registroLido[_nrOP]; 
			registro.cdInjetora = (String) registroLido[_cdinjetora];
			registro.cdMolde = (String) registroLido[_cdMolde];
			registro.cdEstrutura = (String) registroLido[_cdEstrutura];
			
			registro.dthrIValCic = (Date) registroLido[_dthrIValCic];
			registro.dthrIValEstru = (Date) registroLido[_dthrIValEstru];
			
			registro.cicloPadrao = ConversaoTipos.converterParaBigDecimal(registroLido[_cicloPadrao] != null ? registroLido[_cicloPadrao] : BigDecimal.ZERO);
			registro.fatorContagemProd = ConversaoTipos.converterParaBigDecimal(registroLido[_fatorContagemProd] != null ? registroLido[_fatorContagemProd] : BigDecimal.ZERO);
			registro.pcsCicloAtivas = ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsCicloAtivas] != null ? registroLido[_pcsCicloAtivas] : BigDecimal.ZERO));
			registro.pcsCicloTotais = ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_pcsCicloTotais] != null ? registroLido[_pcsCicloTotais] : BigDecimal.ZERO));
			
			registro.cicloMedio = ConversaoTipos.converterParaBigDecimal(registroLido[_cicloMedio] != null ? registroLido[_cicloMedio] : BigDecimal.ZERO);
			registro.cicloPadraoMin = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdCiclosNormais] != null ? registroLido[_cicloPadraoMin] : BigDecimal.ZERO);
			registro.cicloPadraoMax = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdCiclosFinParada] != null ? registroLido[_cicloPadraoMax] : BigDecimal.ZERO);

			registro.qtdProdBrutaOP = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtdProdBrutaOP] != null ? registroLido[_qtdProdBrutaOP] : BigDecimal.ZERO));
			registro.qtdProdRefOP = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtdProdRefOP] != null ? registroLido[_qtdProdRefOP] : BigDecimal.ZERO));
			registro.qtdProdBruta = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtdProdBruta] != null ? registroLido[_qtdProdBruta] : BigDecimal.ZERO));
			registro.qtdProdRef = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtdProdRef] != null ? registroLido[_qtdProdRef] : BigDecimal.ZERO));

			registro.segCicloNormais = ConversaoTipos.converterParaBigDecimal(registroLido[_segCicloNormais] != null ? registroLido[_segCicloNormais] : BigDecimal.ZERO);
			registro.segCicloFinParada = ConversaoTipos.converterParaBigDecimal(registroLido[_segCicloFinParada] != null ? registroLido[_segCicloFinParada] : BigDecimal.ZERO);
			registro.segParadasCP = ConversaoTipos.converterParaBigDecimal(registroLido[_segParadasCP] != null ? registroLido[_segParadasCP] : BigDecimal.ZERO);
			registro.segParadasSP = ConversaoTipos.converterParaBigDecimal(registroLido[_segParadasSP] != null ? registroLido[_segParadasSP] : BigDecimal.ZERO);
			
			registro.qtdProdPrev = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtdProdPrev] != null ? registroLido[_qtdProdPrev] : BigDecimal.ZERO));
			registro.qtdProdPlan = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtdProdPlan] != null ? registroLido[_qtdProdPlan] : BigDecimal.ZERO));
			
			registro.segDisp = ConversaoTipos.converterParaBigDecimal(registroLido[_segDisp] != null ? registroLido[_segDisp] : BigDecimal.ZERO);
			registro.segPcsCic = ConversaoTipos.converterParaBigDecimal(registroLido[_segPcsCic] != null ? registroLido[_segPcsCic] : BigDecimal.ZERO);
			registro.segRefugo = ConversaoTipos.converterParaBigDecimal(registroLido[_segRefugo] != null ? registroLido[_segRefugo] : BigDecimal.ZERO);
			registro.segRitmo = ConversaoTipos.converterParaBigDecimal(registroLido[_segRitmo] != null ? registroLido[_segRitmo] : BigDecimal.ZERO);

			registro.dthrIUltParRefMon = (Date) registroLido[_dthrIUltParRefMon];
			registro.dthrFUltParRefMon = (Date) registroLido[_dthrFUltParRefMon];
			registro.dthrICIP = (Date) registroLido[_dthrICIP];
			registro.dthrFCIP = (Date) registroLido[_dthrFCIP];
			
			//difereca de tipos entre bancos injet oracle e sql server forcou conversao
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
			registro.emAleInspQld = (registroLido[_emAleInspQld] == null ? "0" : (Character) registroLido[_emAleInspQld]).toString();
			registro.stUltInspQld = (registroLido[_emAleInspQld] == null ? "0" : (Character) registroLido[_stUltInspQld]).toString();

			registro.qtdPerdaRitmo = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtdPerdaRitmo] != null ? registroLido[_qtdPerdaRitmo] : BigDecimal.ZERO));
			registro.qtdPerdaPcsCic = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtdPerdaPcsCic] != null ? registroLido[_qtdPerdaPcsCic] : BigDecimal.ZERO));
			registro.qtdPcsCicAtiva = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtdPcsCicAtiva] != null ? registroLido[_qtdPcsCicAtiva] : BigDecimal.ZERO));
			registro.qtdPcsCicTotal = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtdPcsCicTotal] != null ? registroLido[_qtdPcsCicTotal] : BigDecimal.ZERO));
			registro.qtdPerdaParCP = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtdPerdaParCP] != null ? registroLido[_qtdPerdaParCP] : BigDecimal.ZERO).setScale(0, RoundingMode.FLOOR));
			registro.qtdPerdaParSP = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtdPerdaParSP] != null ? registroLido[_qtdPerdaParSP] : BigDecimal.ZERO).setScale(0, RoundingMode.FLOOR));

			registro.qtdCiclosNormais = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdCiclosNormais] != null ? registroLido[_qtdCiclosNormais] : BigDecimal.ZERO);
			registro.qtdCiclosFinParada = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdCiclosFinParada] != null ? registroLido[_qtdCiclosFinParada] : BigDecimal.ZERO);
			
			if (registroLido[_segTmpParMTBF] != null) {
				registro.segTmpParMTBF = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpParMTBF]);
				registro.qtParMTBF = ConversaoTipos.converterParaBigDecimal(registroLido[_qtParMTBF]);
			}
			
			
			// preecher dwconsolid
			DwConsolid dwci = new DwConsolid();
			DwConsol dwc = new DwConsol();
			
			dwci.setIdConsolid(registro.idregistro.longValue());
							
			Date dthrITur = null;
			Date dthrFTur = null;
			
			try {
				dthrITur = FuncoesApoioInjet.calcularInicioTurno(this.getDao(), registro.dtTurno, registro.cdTurno);
				dthrFTur = FuncoesApoioInjet.calcularFimTurno(this.getDao(), registro.dtTurno, registro.cdTurno);				
			} catch (SemCalendarioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			dwci.setDthrIturno(dthrITur);
			dwci.setDthrFturno(dthrFTur);
			dwci.setDtReferencia(dtReferencia);
			dwci.setTpId((byte) 1);
			dwci.setDwRt(dwRt);
			if (dwTurno == null) {
				DwTurno dwTur = new DwTurno();
				dwTur.setIdTurno(ConversaoTipos.converteParaBigDecimal(registro.cdTurno).longValue());
				dwTur.setCdTurno(registro.cdTurno);
				dwTur.setDsTurno(registro.cdTurno);
				dwci.setDwTurno(dwTur);
			} else {
				dwci.setDwTurno(dwTurno);
			}
			
			dwci.setOmPt(omPt);
			
			if (ppCp == null) {
				PpCp cp = new PpCp();
				dwci.setPpCp(cp);				
			} else {
				dwci.setPpCp(ppCp);
			}
			
			// folha
			DwFolha oFolha = new DwFolha();
			oFolha.setDwFolharaps(new HashSet<DwFolharap>());
			oFolha.setCdFolha(registro.cdMolde + "/" + registro.cdEstrutura);
			oFolha.setDsFolha(oFolha.getCdFolha());
			oFolha.setQtFatorcontagem(registro.fatorContagemProd);
			oFolha.setSegCiclopadrao(registro.cicloPadrao);
			oFolha.setSegCiclominimo(registro.cicloPadraoMin);
			oFolha.setSegCiclotimeout(registro.cicloPadraoMax);
			oFolha.setDtRevisao(registro.dthrIValCic);
			
			DwFolharap ofRap = new DwFolharap();
			ofRap.setDwFolharapcoms(new HashSet<DwFolharapcom>());
			
			//produtos
			Set<DwConsolpr> listaProdutos = getProdutosConsolidacao(dwc, registro.dtTurno, registro.cdTurno, registro.cdInjetora, registro.nrOP, registro.cdMolde, registro.cdEstrutura, registro.dthrIValEstru, registro.dthrIValCic);
			for (DwConsolpr cpr : listaProdutos)
			{
				DwFolharapcom ofRapCom = new DwFolharapcom();
				ofRapCom.setQtAtiva(cpr.getPcsManuProducaorefugada());
				ofRapCom.setQtTotal(cpr.getPcsManuProducaobruta());
				ofRapCom.setOmProduto(cpr.getOmProduto());
				
				ofRap.getDwFolharapcoms().add(ofRapCom);
				
				cpr.setPcsManuProducaobruta(null);
				cpr.setPcsManuProducaorefugada(null);
			}
			oFolha.getDwFolharaps().add(ofRap);
			dwci.setDwFolha(oFolha);
			
			
			//consol - tempos
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
			dwc.setSegAutoTempoprodutivo(registro.segCicloNormais.subtract(registro.segRefugo).subtract(registro.segPcsCic).subtract(registro.segRitmo));
			dwc.setSegAutoTempotrabalhado(registro.segCicloNormais.add(registro.segCicloFinParada));
			dwc.setSegAutoTempocalendario(DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodo(dthrITur, dthrFTur, 0));
			
			if (dwc.getSegAutoTempoprodutivo().doubleValue() < 0) {
				dwc.setSegAutoTempoprodutivo(BigDecimal.ZERO);
			}
			//consol - qtdes
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
						
			//dwc.setQtAutoOcoparadaCp(BigDecimal.ZERO);
			//dwc.setQtAutoOcoparadaSp(BigDecimal.ZERO);
			
			DwCal cal = new DwCal();
			cal.setIdCal(1);
			cal.setDsCal("CALENDARIO INJET");
			dwci.setDwCal(cal);

			dwc.setDwConsolid(dwci);
			dwci.setDwConsols(new HashSet<DwConsol>());
			dwci.getDwConsols().add(dwc);

			retorno.add(dwci);
		}

		return retorno;
	}
	
	public List<OmInd> getCfgIndInjet(DAOGenericoInjet dao) {
		List<OmInd> listaCfgInd = new ArrayList<OmInd>();	
		
		final Long ER = 1l;		// Eficiência de realização
		final Long EC = 2l;		// Eficiência de ciclo
		final Long IR = 3l;		// Índice de refugo
		final Long IP = 4l;		// Índice de parada
		final Long OEE = 5l;	// Produtividade (OEE)
		final Long CM = 6l;		// Ciclo médio
		final Long IPD = 7l;	// Índice de perda
		final Long IPP = 8l;	// Índice de perdas por produto
		final Long IPCA = 9l;	// Índice de pcs/ciclo ativas
		final Long IPCI = 10l;	// Índice de pcs/ciclo inativas
		final Long EI = 11l; 	// Eficiência instantânea

		boolean isMelhorAcima  = false;
		
		// Obtem lingua default
		DiversosInjetRN divrn = new DiversosInjetRN(dao);
		divrn.setDaoSession(dao.getSession());
		String cdLingua = "";
		try {
			cdLingua = divrn.getCdLingua();
		} catch (StringIndexOutOfBoundsException e) {
			cdLingua = "000000";
		}		

		OmInd indEI = new OmInd();
		indEI.setOmCfginds(new HashSet<OmCfgind>());
		
		MapQuery query = new MapQuery(dao.getSession());
		query.append("SELECT a");
		query.append("FROM Ijdetgrafico a");
		query.append("WHERE a.id.cdlingua = '" + cdLingua + "'");		
		query.append("AND a.id.grafico IN ('PRODUCAO', 'CICLOS', 'REFUGOS', 'PARADAS', 'IND_OEE', 'CICLOMEDIO', 'PERDAS', 'CAVATIVAS', 'CAVINATIVAS', 'PERDAPRODUTO')");
		query.append("AND a.id.serie = 2");
		query.append("ORDER BY a.id.grafico, a.id.serie");
		List<Ijdetgrafico> lista = query.list();
		
		for (Ijdetgrafico registro : lista) {
			Long idRegistro = 0l;
			
			if (registro.getId().getGrafico().equals("PRODUCAO")) {
				idRegistro = ER;
			}
			if (registro.getId().getGrafico().equals("CICLOS")) {
				idRegistro = EC;
			}
			if (registro.getId().getGrafico().equals("REFUGOS")) {
				idRegistro = IR;
			}
			if (registro.getId().getGrafico().equals("PARADAS")) {
				idRegistro = IP;
			}
			if (registro.getId().getGrafico().equals("IND_OEE")) {
				idRegistro = OEE;
			}
			if (registro.getId().getGrafico().equals("CICLOMEDIO")) {
				idRegistro = CM;
			}

			if (registro.getId().getGrafico().equals("PERDAS")) {
				idRegistro = IPD;
			}

			if (registro.getId().getGrafico().equals("CAVATIVAS")) {
				idRegistro = IPCA;
			}

			if (registro.getId().getGrafico().equals("CAVINATIVAS")) {
				idRegistro = IPCI;
			}

			if (registro.getId().getGrafico().equals("PERDAPRODUTO")) {
				idRegistro = IPP;
			}
			
			OmInd ind = new OmInd();
			ind.setOmCfginds(new HashSet<OmCfgind>());
			
			switch (idRegistro.intValue()) {
				case 1: 			
					ind.setIdInd(ER);
					ind.setCdInd("ER");
					ind.setDsInd("Eficiência de realização");
					ind.setDsCurta("ER");
					ind.setMelhorAcimaMeta(true);
					isMelhorAcima = true;
					break;
					
				case 2: 				
					ind.setIdInd(EC);
					ind.setCdInd("EC");
					ind.setDsInd("Eficiência de ciclo");
					ind.setDsCurta("EC");		
					ind.setMelhorAcimaMeta(true);
					isMelhorAcima = true;
					
					// eficiciencia instantanea = eficiencia de ciclo
					indEI.setIdInd(EI);
					indEI.setCdInd("EI");
					indEI.setDsInd("Eficiência instantânea");
					indEI.setDsCurta("EC");		
					indEI.setMelhorAcimaMeta(true);
					isMelhorAcima = true;
					
					OmCfgind cfgInd = new OmCfgind();			
					cfgInd.setIndSuperior(registro.getIntfinal());
					cfgInd.setIndInferior(registro.getIntinicial());					
					cfgInd.setIndMeta(getMetaGrafico(dao, registro.getId().getCdlingua(), registro.getId().getGrafico(), indEI.isMelhorAcimaMeta()));
					indEI.getOmCfginds().add(cfgInd);
					
					break;
					
				case 3:				
					ind.setIdInd(IR);
					ind.setCdInd("IR");
					ind.setDsInd("Índice de refugo");
					ind.setDsCurta("IR");		
					ind.setMelhorAcimaMeta(false);
					isMelhorAcima = false;
					break;
					
				case 4: 				
					ind.setIdInd(IP);
					ind.setCdInd("IP");
					ind.setDsInd("Índice de parada");
					ind.setDsCurta("IP");		
					ind.setMelhorAcimaMeta(false);
					isMelhorAcima = false;
					break;
					
				case 5: 				
					ind.setIdInd(OEE);
					ind.setCdInd("OEE");
					ind.setDsInd("Eficiência de realização");
					ind.setDsCurta("OEE");		
					ind.setMelhorAcimaMeta(true);
					isMelhorAcima = true;
					break;
					
				case 6: 				
					ind.setIdInd(CM);
					ind.setCdInd("CM");
					ind.setDsInd("Ciclo médio");
					ind.setDsCurta("CM");	
					ind.setMelhorAcimaMeta(true);
					isMelhorAcima = true;
					break;
					
				case 7: 				
					ind.setIdInd(IPD);
					ind.setCdInd("IPD");
					ind.setDsInd("Índice de perdas");
					ind.setDsCurta("IPD");		
					ind.setMelhorAcimaMeta(false);
					isMelhorAcima = false;
					break;
					
				case 8: 				
					ind.setIdInd(IPP);
					ind.setCdInd("IPP");
					ind.setDsInd("Índice de perdas por produto");
					ind.setDsCurta("IPP");
					ind.isMelhorAcimaMeta();
					ind.setMelhorAcimaMeta(false);
					isMelhorAcima = false;
					break;										

				case 9: 				
					ind.setIdInd(IPCA);
					ind.setCdInd("IPCA");
					ind.setDsInd("Pçs/Ciclo ativas");
					ind.setDsCurta("IPCA");		
					ind.setMelhorAcimaMeta(true);
					isMelhorAcima = true;
					break;

				case 10: 				
					ind.setIdInd(IPCI);
					ind.setCdInd("IPCI");
					ind.setDsInd("Pçs/Ciclo inativas");
					ind.setDsCurta("IPCI");
					ind.setMelhorAcimaMeta(false);
					isMelhorAcima = false;
					break;
					
			}
			
			OmCfgind cfgInd = new OmCfgind();			
			cfgInd.setIndSuperior(registro.getIntfinal());
			cfgInd.setIndInferior(registro.getIntinicial());					
			cfgInd.setIndMeta(getMetaGrafico(dao, registro.getId().getCdlingua(), registro.getId().getGrafico(), isMelhorAcima));			
			ind.getOmCfginds().add(cfgInd);
				
			listaCfgInd.add(ind);			
		}

		listaCfgInd.add(indEI);
		
		return listaCfgInd;
	}

	private BigDecimal getMetaGrafico(DAOGenericoInjet dao, String cdLingua, String grafico, boolean isMelhorAcima) {
		MapQuery query = new MapQuery(dao.getSession());
		query.append("SELECT a");
		query.append("FROM Ijdetgrafico a");
		query.append("WHERE a.id.cdlingua = '" + cdLingua + "'");		
		query.append("AND a.id.grafico = '" + grafico + "'");
		query.append("AND a.id.serie = 2");		
		Ijdetgrafico detGraf = (Ijdetgrafico) query.uniqueResult();
		
		return (isMelhorAcima ? detGraf.getIntfinal() : detGraf.getIntinicial());
	}
	
	
	@SuppressWarnings({"unused", "unchecked"})
	private Set<DwConsolpr> getProdutosConsolidacao(DwConsol dwc, Date dtTurno, String cdTurno, String cdInjetora, String nrOP, String cdMolde, String cdEstrutura, Date dthrIValEstru, Date dthrIValCic) {
		String strSQL = "";	
		
		Set<DwConsolpr>  listaProdutos = new HashSet<DwConsolpr>();
		
		int _cdProduto = 0;
		int  _dsProduto = _cdProduto + 1;
		int _valorUnitario = _dsProduto + 1;
		int _prodPlan = _valorUnitario + 1;
		int _prodBruta = _prodPlan + 1;
		int _prodRef = _prodBruta + 1;
		int _prodPrev = _prodRef + 1;
		int _prodPerdaRitmo = _prodPrev + 1;
		int _prodPerdaPcsCiclo = _prodPerdaRitmo + 1;
		int _prodPerdaParCP = _prodPerdaPcsCiclo + 1;
		int _prodPerdaParSP = _prodPerdaParCP + 1;
		int _qtPcsCicAtivas = _prodPerdaParSP + 1;
		int _qtPcsCicTotais = _qtPcsCicAtivas + 1;
		int _gPesoBruto = _qtPcsCicTotais + 1;
		int _gPesoLiquido = _gPesoBruto + 1;
		
		class RegistroLido{
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

		strSQL = strSQL.concat("SELECT e.cdproduto, e.dsproduto, e.vlproduto, ");
		strSQL = strSQL.concat("       g.qtpecasproduzir as prodplan, ");
		strSQL = strSQL.concat("       ((a.qtinjnormal * d.qtcavativas) + (a.qtprodpkgcic * d.indcav)) as prodbruta, ");
		strSQL = strSQL.concat("       (CASE WHEN f.qtpcsref IS NULL THEN 0 ELSE f.qtpcsref END) as prodrefugada, ");
		strSQL = strSQL.concat("       (FLOOR((a.tmpcicnormal + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END))/ h.ciclopadrao) * d.qtcavativas * h.fatorcontagemprod) as prodprev, ");
		strSQL = strSQL.concat("       ( ((((a.tmpcicnormal + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END)) / h.ciclopadrao) - a.qtinjnormal ) * ( (CASE WHEN ct.campo23 = '¬¬ª¿±·¿½­' THEN d.qtcavidades ELSE d.qtcavativas END) * h.fatorcontagemprod) ) ) as prodperdaritmo,  ");
		strSQL = strSQL.concat("       (a.qtinjnormal * ( (d.qtcavidades - d.qtcavativas) * h.fatorcontagemprod) ) AS prodperdapcscic, ");
		strSQL = strSQL.concat("       (FLOOR(a.tmpparadas / h.ciclopadrao) * d.qtcavativas * h.fatorcontagemprod) as prodperdaparCP, ");
		strSQL = strSQL.concat("       (FLOOR(a.TmpParadasSemPeso / h.ciclopadrao) * d.qtcavativas * h.fatorcontagemprod) as prodperdaparSP, ");
		strSQL = strSQL.concat("       d.qtcavativas, d.qtcavidades,  d.pbrutomedio, d.pliquidomedio ");
		strSQL = strSQL.concat("  FROM ijcnsturno a ");
		strSQL = strSQL.concat("  LEFT JOIN IJtbFRESH ct ON (1=1) ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijmolpro c ON (c.cdmolde = a.cdmolde and c.cdestrutura = a.cdestrutura and c.dthrival = a.dthrivalestru) ");
		strSQL = strSQL.concat("  JOIN viewmolproindcav d ON (d.cdmolde = c.cdmolde AND d.cdestrutura = c.cdestrutura AND d.dthrival = c.dthrival AND d.cdidentificacao = c.cdidentificacao) ");
		strSQL = strSQL.concat("  JOIN ijtbpro e ON (e.cdproduto = d.cdproduto) ");
		strSQL = strSQL.concat("  JOIN ijopprodutos g ON (g.nrop = a.nrop AND g.cdmolde = a.cdmolde AND g.cdestrutura = a.cdestrutura AND g.cdproduto = c.cdproduto) ");
		strSQL = strSQL.concat("  JOIN ijfictec h ON (h.cdinjetora = a.cdinjetora AND h.cdmolde = a.cdmolde AND h.cdestrutura = a.cdestrutura AND h.dthrivalcic = a.dthrivalcic) ");
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

		
		List<Object> lista = new ArrayList<Object>();		
		lista = this.getDaoSession().createSQLQuery(strSQL)
				.setTimestamp("dtturno", dtTurno)
				.setString("cdturno", cdTurno)
				.setString("cdinjetora", cdInjetora)
				.setString("nrop", nrOP)		
				.setString("cdmolde", cdMolde)
				.setString("cdestrutura", cdEstrutura)
				.setTimestamp("dthrivalestru", dthrIValEstru)
				.setTimestamp("dthrivalcic", dthrIValCic).list();

		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();
			
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			registro.cdProduto = (String) registroLido[_cdProduto];
			registro.dsProduto = (String) registroLido[_dsProduto];
			
			registro.valorUnitario = ConversaoTipos.converterParaBigDecimal(registroLido[_valorUnitario]);
			
			registro.prodPlan = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPlan]));
			registro.prodBruta = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodBruta]));
			registro.prodRef = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodRef]));
			registro.prodPrev = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPrev]));
			registro.prodPerdaRitmo = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPerdaRitmo]));
			registro.prodPerdaPcsCiclo  = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPerdaPcsCiclo]));
			registro.prodPerdaParCP = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPerdaParCP]));
			registro.prodPerdaParSP = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_prodPerdaParSP]));
			
			registro.qtPcsCicAtivas = ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtPcsCicAtivas]));
			registro.qtPcsCicTotais = ConfiguracoesInjetRN.converterCavidadesUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtPcsCicTotais]));
			
			registro.gPesoBruto = ConversaoTipos.converterParaBigDecimal(registroLido[_gPesoBruto]);
			registro.gPesoLiquido = ConversaoTipos.converterParaBigDecimal(registroLido[_gPesoLiquido]);
			
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

	@SuppressWarnings({"unused", "unchecked"})
	public Set<DwConsolal> getAlertas(Date dtTurno, String cdTurno, String cdInjetora, String nrOP) {
		Set<DwConsolal> listaalertas = new HashSet<DwConsolal>();

		String strSQL = "";	
		
		Set<DwConsolpr>  listaProdutos = new HashSet<DwConsolpr>();
		
		int _dthrIniAlerta = 0;
		int _dthrFimAlerta = _dthrIniAlerta + 1; 
		int _geracaoAutomatica = _dthrFimAlerta + 1;
		int _observacao = _geracaoAutomatica + 1;
		int _cdAlerta = _observacao + 1;
		int _dsAlerta = _cdAlerta + 1;
		int _cdUsuario = _dsAlerta + 1;
		int _nmUsuario = _cdUsuario + 1;
		
		class RegistroLido{
			Date dthrIniAlerta;
			Date dthrFimAlerta; 
			int geracaoAutomatica;
			String observacao;
			String cdAlerta;
			String dsAlerta;
			String cdUsuario;
			String nmUsuario;		
		}

		
		Date dthrITur = null;
		Date dthrFTur = null;
		
		try {
			dthrITur = FuncoesApoioInjet.calcularInicioTurno(this.getDao(), dtTurno, cdTurno);
			dthrFTur = FuncoesApoioInjet.calcularFimTurno(this.getDao(), dtTurno, cdTurno);				
		} catch (SemCalendarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		strSQL = strSQL.concat("SELECT a.dthrialerta, a.dthrfalerta, a.lgeradoautomatico, a.Observacao, ");
		strSQL = strSQL.concat("       a.cdalerta, c.dsalerta, a.CdUsuario, u.nmusuario ");
		strSQL = strSQL.concat("  FROM ijalertas a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbale c ON (c.cdalerta = a.cdalerta) ");
		strSQL = strSQL.concat("  LEFT JOIN ijtbusu u ON (u.cdusuario = a.CdUsuario) ");
		
		strSQL = strSQL.concat(" WHERE (   (a.dthrialerta BETWEEN :dthrIniTur AND :dthrFimTur) ");
		strSQL = strSQL.concat("        OR (a.dthrfalerta BETWEEN :dthrIniTur AND :dthrFimTur) ");
		strSQL = strSQL.concat(" 		OR (:dthrIniTur BETWEEN a.dthrialerta AND a.dthrfalerta) ");
		strSQL = strSQL.concat(" 		OR (a.dthrialerta < :dthrIniTur AND a.dthrfalerta IS NULL)  )");
		
		strSQL = strSQL.concat("   AND b.cdinjestendido = :cdinjetora ");
		strSQL = strSQL.concat("   AND a.nrop = :nrop ");
		
		strSQL = strSQL.concat(" ORDER BY a.dthrialerta ");
		
		
		List<Object> lista = new ArrayList<Object>();		
		lista = this.getDaoSession().createSQLQuery(strSQL)
				.setTimestamp("dthrIniTur", dthrITur)
				.setTimestamp("dthrFimTur", dthrFTur)
				.setString("cdinjetora", cdInjetora)
				.setString("nrop", nrOP).list();

		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();
			
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			registro.dthrIniAlerta = (Date) registroLido[_dthrIniAlerta];
			if (registroLido[_dthrFimAlerta] != null) {
				registro.dthrFimAlerta = (Date) registroLido[_dthrFimAlerta];
			}			
			registro.geracaoAutomatica = ConversaoTipos.converterParaBigDecimal(registroLido[_geracaoAutomatica]).intValue();
			
			if (registroLido[_observacao] != null) {
				registro.observacao = (String) registroLido[_observacao];
			}
			
			registro.cdAlerta = (String) registroLido[_cdAlerta];
			registro.dsAlerta = (String) registroLido[_dsAlerta];
			
			if (registroLido[_cdUsuario] != null) {
				registro.cdUsuario = (String) registroLido[_cdUsuario];
				registro.nmUsuario = (String) registroLido[_nmUsuario];
			}

			DwTAlerta  al = new DwTAlerta();
			al.setCdTalerta(registro.cdAlerta);
			al.setDsTalerta(registro.dsAlerta);			
			

			DwConsolal dwal = new DwConsolal();		
			dwal.setDwConsolalocos(new HashSet<DwConsolaloco>());
			
			BigDecimal duracaoAlerta = BigDecimal.ZERO;
			if (registro.dthrFimAlerta == null) {
				Date dthrFim = DataHoraRN.getDataHoraAtual();
				if (DataHoraRN.before(dthrFTur, dthrFim)) {
					dthrFim = dthrFTur;
				}
				
				duracaoAlerta = DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodo(registro.dthrIniAlerta, dthrFim, 3);
			} else {
				duracaoAlerta = DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodo(registro.dthrIniAlerta, registro.dthrFimAlerta, 0);
			}
			
			dwal.setSegAutoTempoalerta(duracaoAlerta);
			dwal.setSegManuTempoalerta(BigDecimal.ZERO);


			DwConsolaloco oco = new DwConsolaloco();
			oco.setDthrIalerta(registro.dthrIniAlerta);
			oco.setDthrFalerta(registro.dthrFimAlerta);
			oco.setMsDthrialerta((byte) 0);
			oco.setMsDthrfalerta((byte) 0);
			
			DwConsolallog log = new DwConsolallog();
			log.setDthrIalerta(registro.dthrIniAlerta);
			log.setDthrFalerta(registro.dthrFimAlerta);
			log.setMsDthrialerta(0);
			log.setMsDthrfalerta(0);
			log.setSegAutoTempoalerta(duracaoAlerta);
			log.setSegManuTempoalerta(BigDecimal.ZERO);
			log.setDwTAlerta(al);
			log.setObs(registro.observacao);
			
			OmUsr usu = null;
			if (registro.cdUsuario != null) {
				usu = new OmUsr();
				usu.setCdUsr(registro.cdUsuario);
				usu.setDsNome(registro.nmUsuario);
			}
			log.setOmUsr(usu);
			
			OmPt pt = new OmPt();
			pt.setCdPt(cdInjetora);			
			log.setOmPt(pt);

			oco.setDwConsolallog(log);
			
			dwal.setDwTAlerta(al);
			dwal.getDwConsolalocos().add(oco);
			
			
			
			listaalertas.add(dwal);		
		}
		
		return listaalertas;
	}

	@SuppressWarnings("unchecked")
	public ProjecaoPCIDTO getProjecaoPCI(Map<String, String> mapOPs) {
		ProjecaoPCIDTO retorno = new ProjecaoPCIDTO();

		int _nOP = 0;
		int _cdProduto = _nOP + 1; 
		int _cdMolde = _cdProduto + 1;
		int _cdEstrutura = _cdMolde + 1;
		int _prodPlan = _cdEstrutura + 1;
		int _fatorContagem = _prodPlan + 1;
		int _cicloPadrao = _fatorContagem + 1;
		int _pcsCicloAtivas = _cicloPadrao + 1;
		int _pcsCicloTotais = _pcsCicloAtivas + 1;
		int _prodBruta = _pcsCicloTotais + 1;
		int _prodRefugada = _prodBruta + 1;
		
		class RegistroLido{
			String nOP;
			String cdProduto; 
			String cdMolde;
			String cdEstrutura;
			BigDecimal prodPlan = BigDecimal.ZERO;
			BigDecimal fatorContagem = BigDecimal.ZERO;
			BigDecimal cicloPadrao = BigDecimal.ZERO;
			BigDecimal pcsCicloAtivas = BigDecimal.ZERO;
			BigDecimal pcsCicloTotais = BigDecimal.ZERO;
			BigDecimal prodBruta = BigDecimal.ZERO;
			BigDecimal prodRefugada = BigDecimal.ZERO;
			BigDecimal prodLiquida = BigDecimal.ZERO;			
		}

		
		Set<String> ops = mapOPs.keySet();
		for(String op : ops) {
			String strSQL = "";			
			strSQL = strSQL.concat("SELECT a.nrop, a.cdproduto, a.cdmolde, a.cdestrutura, a.qtpecasproduzir, c.fatorcontagemprod, c.ciclopadrao, d.qtcavativas, d.qtcavidades, ");
			strSQL = strSQL.concat("       (pb.qtprodbruta) as qtprodbruta, ");
			strSQL = strSQL.concat("       (CASE WHEN cr.qtpcsref  IS NULL THEN 0 ELSE cr.qtpcsref  END) as qtprodrefugada ");
			strSQL = strSQL.concat("  FROM ijopprodutos a ");

			strSQL = strSQL.concat("  JOIN ijop b ON (b.nrop = a.nrop) ");
			strSQL = strSQL.concat("  JOIN ijfictec c ON (c.cdinjetora = b.cdinjetora AND c.cdmolde = b.cdmolde AND c.cdestrutura = b.cdestrutura AND c.dthrfvalcic IS NULL) ");
			strSQL = strSQL.concat("  JOIN ijmolpro d ON (d.cdmolde = c.cdmolde AND d.cdestrutura = c.cdestrutura AND d.cdproduto = a.cdproduto AND d.dthrival = c.dthrivalestru) ");
			
			strSQL = strSQL.concat("  JOIN (SELECT r.nrop, m.cdproduto, ");
			strSQL = strSQL.concat("               SUM((r.qtinjnormal * m.qtcavativas * ift.fatorcontagemprod) + (r.qtprodpkgcic * m.indcav)) as qtprodbruta  ");
			strSQL = strSQL.concat("          FROM ijcnsturno r, viewmolproindcav m, IJFicTec ift ");
			strSQL = strSQL.concat("         WHERE m.cdmolde = r.cdmolde ");
			strSQL = strSQL.concat("           AND m.cdestrutura = r.cdestrutura ");
			strSQL = strSQL.concat("           AND m.dthrival = r.dthrivalestru ");
			strSQL = strSQL.concat("           AND r.cdinjetora = ift.cdinjetora ");
			strSQL = strSQL.concat("           AND r.cdmolde = ift.cdmolde ");
			strSQL = strSQL.concat("           AND r.cdestrutura = ift.cdestrutura ");
			strSQL = strSQL.concat("           AND r.dthrivalcic = ift.dthrivalcic ");
			strSQL = strSQL.concat("           AND r.dthrivalestru = ift.dthrivalestru ");
			strSQL = strSQL.concat("           AND r.nrop IN (:nrop) ");		
			strSQL = strSQL.concat("        GROUP BY r.nrop, m.cdproduto ");
			strSQL = strSQL.concat("      ) pb ON (pb.nrop = a.nrop AND pb.cdproduto = a.cdproduto) ");
			
			strSQL = strSQL.concat(" LEFT OUTER JOIN ( ");
			strSQL = strSQL.concat("      SELECT r.nrop, m.cdproduto, ");
			strSQL = strSQL.concat("             SUM(r.qtpcsref) as qtpcsref ");
			strSQL = strSQL.concat("        FROM ijcnsturnodetref r, ijmolpro m ");
			strSQL = strSQL.concat("       WHERE m.cdmolde = r.cdmolde ");
			strSQL = strSQL.concat("         AND m.cdestrutura = r.cdestrutura ");
			strSQL = strSQL.concat("         AND m.dthrival = r.dthrivalestru ");
			strSQL = strSQL.concat("         AND m.cdidentificacao = r.cdidentificacao ");
			strSQL = strSQL.concat("         AND r.nrop IN (:nrop)");
			strSQL = strSQL.concat("       GROUP BY r.nrop, m.cdproduto ");
			strSQL = strSQL.concat("     ) cr ON (cr.nrop = pb.nrop and cr.cdproduto = pb.cdproduto) ");
			
			strSQL = strSQL.concat(" WHERE a.nrop IN (:nrop) ");
			
			List<Object> lista = new ArrayList<Object>();		
			lista = this.getDaoSession().createSQLQuery(strSQL).setString("nrop", op).list();

			Integer qtdCicMax = 0;
			
			for (Object reg : lista) {
				RegistroLido registro = new RegistroLido();
				
				Object[] registroLido = null;
				Object registroLidoAux = (Object) reg;
				registroLido = (Object[]) registroLidoAux;
				
				registro.nOP = (String) registroLido[_nOP];
				registro.cdProduto = (String) registroLido[_cdProduto];
				registro.cdMolde = (String) registroLido[_cdMolde];
				registro.cdEstrutura = (String) registroLido[_cdEstrutura];
				registro.fatorContagem = ConversaoTipos.converterParaBigDecimal(registroLido[_fatorContagem]);
				registro.cicloPadrao = ConversaoTipos.converterParaBigDecimal(registroLido[_cicloPadrao]);
				registro.pcsCicloAtivas = ConversaoTipos.converterParaBigDecimal(registroLido[_pcsCicloAtivas]);
				registro.pcsCicloTotais = ConversaoTipos.converterParaBigDecimal(registroLido[_pcsCicloTotais]);
				registro.prodPlan = ConversaoTipos.converterParaBigDecimal(registroLido[_prodPlan]);
				registro.prodBruta = ConversaoTipos.converterParaBigDecimal(registroLido[_prodBruta]);
				registro.prodRefugada = ConversaoTipos.converterParaBigDecimal(registroLido[_prodRefugada]);
				registro.prodLiquida = registro.prodBruta.subtract(registro.prodRefugada);
				
				BigDecimal saldoProduzir = registro.prodPlan.subtract(registro.prodLiquida);
				if (saldoProduzir.intValue() > 0) {
					Integer qtdCiclos = AritmeticaUtil.multiplicar(AritmeticaUtil.dividir(saldoProduzir, registro.pcsCicloAtivas), registro.fatorContagem).intValue();
					if (qtdCiclos > qtdCicMax) {
						qtdCicMax = qtdCiclos;
					}				
				}
				
				if (qtdCicMax > 0) {
					//numProjPCIHrs = ((numQtdInj * numCicloPadrao) / numCavidades) * (numCavidades - numCavAtivas)
					BigDecimal cavInativas = AritmeticaUtil.diminuir(registro.pcsCicloTotais, registro.pcsCicloAtivas);
					BigDecimal pci = AritmeticaUtil.multiplicar(new BigDecimal(qtdCicMax), registro.cicloPadrao);
					pci = AritmeticaUtil.dividir(pci, registro.pcsCicloTotais);
					pci = AritmeticaUtil.multiplicar(pci, cavInativas);
					retorno.setQtdCiclosExec(retorno.getQtdCiclosExec().add(new BigDecimal(qtdCicMax)));
					retorno.setSegProjPCI(retorno.getSegProjPCI().add(pci));
				}
			}
			
		}
		
		
		return retorno;
	}
}

