package idw.model.rn.web.vf.monitorizacao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList; 
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmGtDAO;
import idw.model.dao.OmImgDAO;
import idw.model.dao.OmPtDAO;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwConsolallog;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolrelog;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgind;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmImg;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.pojos.template.OmObjTemplate;
import idw.model.rn.AlertaRN; 
import idw.model.rn.DataHoraRN;
import idw.model.rn.GTRN;
import idw.model.rn.IhmMobileRN; 
import idw.model.rn.TurnoRN;
import idw.model.rn.monitorizacao.MonitorizacaoRN;
import idw.model.rn.monitorizacao.MonitorizacaoVisaoMaquinaRN;
import idw.model.rn.monitorizacao.web.imagem.MonitorizacaoIcone;
import idw.model.rn.monitorizacao.web.imagem.MonitorizacaoIconeFactory;
import idw.util.AritmeticaUtil;
import idw.util.Cor;
import idw.util.FormulasInjet;
import idw.util.Util;
import idw.webservices.dto.GtRtDTO;
import idw.webservices.dto.GtRtMonitorizacaoDTO;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;
import idw.webservices.dto.TurnoAtualDTO;
import idw.webservices.dto.TurnosDTO;
import idw.webservices.rest.GtResource;
import idw.webservices.rest.dto.GtDTO;
import idw.webservices.rest.dto.TurnoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroAnaliseGargaloDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalhePostoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroPtCpDTO;
import idw.webservices.rest.dto.monitorizacao.GtMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.MonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.OperadorDTO;
import idw.webservices.rest.dto.monitorizacao.PtIconeDTO;
import idw.webservices.rest.dto.monitorizacao.PtIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.PtMonitorizacaoDTO;
import idw.webservices.rest.idw.v2.MonitNIDWResource;
import idw.webservices.rest.idw.v2.dto.AlertaOcorDTO;
import idw.webservices.rest.idw.v2.dto.LoginOcorDTO;
import idw.webservices.rest.idw.v2.dto.MaquinaIHMDTO;
import idw.webservices.rest.idw.v2.dto.MetaIndicadorDTO2;
import idw.webservices.rest.idw.v2.dto.ParadaOcorDTO;
import idw.webservices.rest.idw.v2.dto.PtMonitDTO;
import idw.webservices.rest.idw.v2.dto.RefugoOcorDTO;
import idw.webservices.rest.idw.v2.dto.TurnoDTO2;
import idw.webservices.rest.idw.v2.dto.UsrDTO;
import idw.webservices.rest.idw.v2.dto.PtMonitDTO.StCorFundoPt;
import idw.webservices.rest.idw.v2.dto.PtMonitDTO.TipoPostoNIDW;
import ms.util.ConversaoTipos;

public class MonitorizacaoWebRN extends MonitorizacaoRN {

	public static final double TAMANHO_PIXEL_MAXIMO_LINHA = 50;

	private Map<Integer, Double> mapLinha = new HashMap<Integer, Double>();
	private Map<Integer, List<ObjRtMonitorizacaoDTO>> mapLinhaObj = new HashMap<Integer, List<ObjRtMonitorizacaoDTO>>();

	private MonitorizacaoIconeFactory iconeFactory = new MonitorizacaoIconeFactory();

	private final String formatoData;
	private final String formatoDataHora;

	private MonitorizacaoVisaoMaquinaRN monitorizacaoVisaoMaquinaRN;
	private TurnoRN turnoRN;
	private GTRN gtRN;

	public MonitorizacaoWebRN(DAOGenerico dao) {
		super(dao);
		this.formatoData = MonitNIDWResource.FORMATO_DATA;
		this.formatoDataHora = MonitNIDWResource.FORMATO_DATA_HORA;
	}
	
	public MonitorizacaoWebRN(String formatoData, String formatoDataHora) {
		super();
		this.formatoData = formatoData;
		this.formatoDataHora = formatoDataHora;
	}

	public MonitorizacaoWebRN(DAOGenerico dao, String formatoData, String formatoDataHora) {
		super(dao);
		this.formatoData = formatoData;
		this.formatoDataHora = formatoDataHora;
		monitorizacaoVisaoMaquinaRN = new MonitorizacaoVisaoMaquinaRN(getDao());
		turnoRN = new TurnoRN(getDao());
		gtRN = new GTRN();
		gtRN.setDao(getDao());
	}

	public MonitorizacaoDTO getMonitorizacao(FiltroMonitorizacaoDTO filtroMonitorizacao) {

		OmGtDAO omGtDAO = new OmGtDAO(getDaoSession());
		OmGt omGt = omGtDAO.getOmGtPorCdAtivoOrderById(filtroMonitorizacao.getCdGt());

		GtRtMonitorizacaoDTO dto =
				monitorizacaoVisaoMaquinaRN.getTelaMonitorizacaoMaquina(
						getFiltroGt(filtroMonitorizacao, omGt),
						DwConsolidTemplate.TpId.TURNO);

		MonitorizacaoDTO monitorizacaoDTO = new MonitorizacaoDTO();

		//MADS: NIDW
		monitorizacaoDTO.setInfoPts(new ArrayList<PtMonitDTO>());

		
		List<ObjRtMonitorizacaoDTO> gtsObj = new ArrayList<ObjRtMonitorizacaoDTO>();
		List<ObjRtMonitorizacaoDTO> ptsObj = new ArrayList<ObjRtMonitorizacaoDTO>();

		for (ObjRtMonitorizacaoDTO obj : dto.getObjsRtMonitorizacaoDTO().getObjsRtMonitorizacao()) {
			if (obj.getTipoObj() == OmObjTemplate.TpObj.TIPO_OBJ_GT.getValue()) {
				gtsObj.add(obj);
			}

			if (obj.getTipoObj() == OmObjTemplate.TpObj.TIPO_OBJ_PT.getValue()) {
				ptsObj.add(obj);
				
				//MADS: NIDW
				monitorizacaoDTO.getInfoPts().add(ObjRtMonitorizacaoDTOtoPtMonitDTO(obj));				
			}
		}

		List<PtMonitorizacaoDTO> pts = getPostosOrdenados(ptsObj);

		List<FiltroDetalhePostoDTO> listaFiltroPostos = getListaFiltroPosto(filtroMonitorizacao, pts);
		List<FiltroPtCpDTO> listaFiltroPtCp = getListaFiltroPtCp(dto.getObjsRtMonitorizacaoDTO().getObjsRtMonitorizacao());
		List<Long> listaFiltroIdGt = getListaIdGts(dto.getObjsRtMonitorizacaoDTO().getObjsRtMonitorizacao());

		List<GtMonitorizacaoDTO> gts = getGts(gtsObj, filtroMonitorizacao);

		if (omGt != null) {
			GtDTO omGtDTO = GtResource.converterGtPojoParaDTO(omGt);
			monitorizacaoDTO.setGt(omGtDTO);
		}

		monitorizacaoDTO.setGts(gts);
		monitorizacaoDTO.setPts(pts);

		filtroMonitorizacao.setListaFiltroPosto(listaFiltroPostos);
		filtroMonitorizacao.setListaFiltroIdGt(listaFiltroIdGt);
		monitorizacaoDTO.setFiltro(filtroMonitorizacao);
		monitorizacaoDTO.setFiltroAnaliseGargalo(getFiltroAnaliseGargalo(filtroMonitorizacao, listaFiltroPostos, listaFiltroPtCp));

		omGtDAO = null;// 20190104
		omGt = null;// 20190104
		dto = null;// 20190104
		gtsObj = null;// 20190104
		ptsObj = null;// 20190104


		
		
		return monitorizacaoDTO;
	}

	
	private PtMonitDTO ObjRtMonitorizacaoDTOtoPtMonitDTO(ObjRtMonitorizacaoDTO obj) {
		PtMonitDTO infoPt = new PtMonitDTO();
		
		infoPt.setOperadores(new ArrayList<UsrDTO>());
		infoPt.setProduto("");
		
		infoPt.setCdPt(obj.getCdPt());
		infoPt.setDsPt(obj.getDsCurta());
		
		infoPt.setX(obj.getX().intValue());
		infoPt.setY(obj.getY().intValue());
		infoPt.setIdImg(OmImgToIdPtNIDW(obj.getOmobj().getOmImg()));
		
		if (! obj.isOffline()) {
			infoPt.setCdCp(obj.getCdCp());
			infoPt.setCdFolha(obj.getCdFolha());
			infoPt.setCdRap(obj.getUltimoMolde() == null ? "" : obj.getUltimoMolde());
			
			infoPt.setEfiRea(ConversaoTipos.converterParaBigDecimal(obj.getEfiRealizacao()).setScale(2, RoundingMode.HALF_UP));
			infoPt.setEfiCic(ConversaoTipos.converterParaBigDecimal(obj.getEfiCiclos()).setScale(2, RoundingMode.HALF_UP));
			infoPt.setEfiInst(ConversaoTipos.converterParaBigDecimal(obj.getEfiInstantanea()).setScale(2, RoundingMode.HALF_UP));
			infoPt.setIndPar(ConversaoTipos.converterParaBigDecimal(obj.getIndiceParadas()).setScale(2, RoundingMode.HALF_UP));
			infoPt.setIndRef(ConversaoTipos.converterParaBigDecimal(obj.getIndiceRefugos()).setScale(2, RoundingMode.HALF_UP));
			infoPt.setIndPCI(ConversaoTipos.converterParaBigDecimal(obj.getIndiceCavAtivas()).setScale(2, RoundingMode.HALF_UP));
			infoPt.setIndProd(ConversaoTipos.converterParaBigDecimal(obj.getIndiceProducao()).setScale(2, RoundingMode.HALF_UP));
			infoPt.setIndOEE(ConversaoTipos.converterParaBigDecimal(obj.getProdutividadeOEE()).setScale(2, RoundingMode.HALF_UP));			
		}

		
		// define cor do pt
		if (obj.isOffline()) {
			infoPt.setStFuncionamentoPt(PtMonitDTO.StFuncionamentoPt.OFF_LINE.getValor()); 
			infoPt.setCorHexaIconePt(PtMonitDTO.COR_ST_FUNC_PT_OFF); 			

		} else {
			if (obj.isParada()) {
				infoPt.setStFuncionamentoPt(PtMonitDTO.StFuncionamentoPt.PARADA.getValor()); 
				infoPt.setCorHexaIconePt(PtMonitDTO.COR_ST_FUNC_PT_PARADA); 			
				
			} else {
				if (obj.isDentroDaMeta()) {
					infoPt.setStFuncionamentoPt(PtMonitDTO.StFuncionamentoPt.TRABALHANDO_NA_META.getValor()); 
					infoPt.setCorHexaIconePt(PtMonitDTO.COR_ST_FUNC_PT_NA_META); 								
				} else {
					infoPt.setStFuncionamentoPt(PtMonitDTO.StFuncionamentoPt.TRABALHANDO_FORA_DA_META.getValor()); 
					infoPt.setCorHexaIconePt(PtMonitDTO.COR_ST_FUNC_PT_FORA_META); 			
				}				
			}
		}
		
		infoPt.setPtEmAlerta(obj.isComAlerta());
		infoPt.setPtSemPlano(!obj.isTemPlanejamento());
		infoPt.setPtComOPXXConcluida(obj.isOpConcluida90PorCento());
		infoPt.setPtComOPConcluida(obj.isOpConcluida());
		infoPt.setPtComIndRefAcimaCfg(obj.isIndiceRefugo3porCento());
		infoPt.setPtComParNaoInf(obj.isParadaNaoInformada());
		infoPt.setPtComParSemPeso(!obj.isParadaSemPesoEfic());
		infoPt.setPtComCIP(obj.isCIP());
		
		infoPt.setIconePisca(false);
		infoPt.setCorHexaBorda("");
		
		
		//Define cor de fundo, se necessário
		infoPt.setIdStCorFundoIcone(PtMonitDTO.StCorFundoPt.SEM_FUNDO.getValor()); 
		infoPt.setCorHexaFundoIcone(PtMonitDTO.COR_FUNDO_SEM_COR); 
		
		if (infoPt.getPtComOPXXConcluida()) {
			infoPt.setIdStCorFundoIcone(PtMonitDTO.StCorFundoPt.OP_XXX_CONCLUIDA.getValor());
			infoPt.setCorHexaFundoIcone(PtMonitDTO.COR_FUNDO_OP_XXX_CONCLUIDA);
		}
		

		if (infoPt.getPtComOPConcluida()) {
			infoPt.setIdStCorFundoIcone(PtMonitDTO.StCorFundoPt.OP_CONCLUIDA.getValor());
			infoPt.setCorHexaFundoIcone(PtMonitDTO.COR_FUNDO_OP_CONCLUIDA);
		}
		
		if (infoPt.getPtEmAlerta()) {
			infoPt.setIdStCorFundoIcone(PtMonitDTO.StCorFundoPt.EM_ALERTA.getValor());
			infoPt.setCorHexaFundoIcone(PtMonitDTO.COR_FUNDO_EM_ALERTA);
		}
		
		if (infoPt.getPtComIndRefAcimaCfg()) {
			infoPt.setIdStCorFundoIcone(PtMonitDTO.StCorFundoPt.IND_REF_ACIMA_XXX.getValor());
			infoPt.setCorHexaFundoIcone(PtMonitDTO.COR_FUNDO_IND_REF_ACIMA_XXX);
		}
		
		if (infoPt.getPtComOPConcluida()) {
			infoPt.setIdStCorFundoIcone(PtMonitDTO.StCorFundoPt.OP_CONCLUIDA.getValor());
			infoPt.setCorHexaFundoIcone(PtMonitDTO.COR_FUNDO_OP_CONCLUIDA);
		}
		
		if (infoPt.getStFuncionamentoPt() == PtMonitDTO.StFuncionamentoPt.PARADA.getValor()) {
			if (infoPt.getPtComParNaoInf()) {
				infoPt.setIdStCorFundoIcone(PtMonitDTO.StCorFundoPt.COM_PAR_NAO_INF.getValor());
				infoPt.setCorHexaFundoIcone(PtMonitDTO.COR_FUNDO_PAR_NAO_INF);
			
			} else if (infoPt.getPtComParSemPeso()) {
				if (! infoPt.getPtComIndRefAcimaCfg()) {
					infoPt.setIdStCorFundoIcone(PtMonitDTO.StCorFundoPt.COM_PAR_SEM_PESO.getValor());
					infoPt.setCorHexaFundoIcone(PtMonitDTO.COR_FUNDO_PAR_SEM_PESO);					
				}
			}
			
			if(! infoPt.getPtComParSemPeso()) {
				infoPt.setIconePisca(true);
				infoPt.setCorHexaBorda(PtMonitDTO.COR_BORDA_PAR_COM_PESO);
			}
		}
		
		if (infoPt.getPtComCIP()) {
			infoPt.setIdStCorFundoIcone(PtMonitDTO.StCorFundoPt.EM_CIP.getValor());
			infoPt.setCorHexaFundoIcone(PtMonitDTO.COR_FUNDO_EM_CIP);
		}
		
		if (infoPt.getPtSemPlano()) {
			infoPt.setIdStCorFundoIcone(PtMonitDTO.StCorFundoPt.SEM_PLANEJAMENTO.getValor());
			infoPt.setCorHexaFundoIcone(PtMonitDTO.COR_FUNDO_SEM_PLANO);

			// forcar ícone de parada com status offline
			infoPt.setStFuncionamentoPt(PtMonitDTO.StFuncionamentoPt.OFF_LINE.getValor()); 
			infoPt.setCorHexaIconePt(PtMonitDTO.COR_ST_FUNC_PT_PARADA); 	
			
			// zerar indicadores na marra
			infoPt.setEfiRea(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
			infoPt.setEfiCic(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
			infoPt.setEfiInst(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
			infoPt.setIndPar(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
			infoPt.setIndRef(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
			infoPt.setIndPCI(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
			infoPt.setIndProd(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
			infoPt.setIndOEE(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));	
			
			
		}
				
		
		infoPt.setPtComParManutencao(obj.isParadaManutencao());
		infoPt.setPtComConsolEmAtraso(obj.isConsolidacaoPendente());
		infoPt.setPtComOperadorLogado(obj.isTemOperador());
		infoPt.setPtComPerdaSinc(obj.isPerdaSinc() || obj.isPerdaSincronismo());
		infoPt.setPtComAlertaVidaUtil(obj.isAlertaVidaUtil());
		infoPt.setPtComManutPrev(obj.isManutencaoPrev());

		if (obj.getCdProduto() != null) {
			infoPt.setProduto(obj.getCdProduto());			
		}
		
		if (obj.getDwConsolmologs() != null && obj.getDwConsolmologs().size() > 0) {
			for (DwConsolmolog moLog : obj.getDwConsolmologs()) {
				UsrDTO usr = new UsrDTO();
				usr.setLogin(moLog.getOmUsr().getLogin());
				usr.setDsUsr(moLog.getOmUsr().getDsNome());
				
				infoPt.getOperadores().add(usr);			
			}
		}
		
		
		if (! obj.isOffline()) {
			// monit por tabela
			//infoPt.setProdPrevUltOP(ConversaoTipos.converterParaBigDecimal(obj.prev).setScale(2, RoundingMode.HALF_UP));
			infoPt.setProdSaldoUltOP(ConversaoTipos.converterParaBigDecimal(obj.getUltimaOpSaldoAProduzir()).setScale(2, RoundingMode.HALF_UP));
			infoPt.setProdPlanUltOP(ConversaoTipos.converterParaBigDecimal(obj.getUltimaOpProducaoPlanejada()).setScale(2, RoundingMode.HALF_UP)); 
			
			
			infoPt.setMetaInstantanea(ConversaoTipos.converterParaBigDecimal(obj.getMetaInstatanea()).setScale(2, RoundingMode.HALF_UP));
			infoPt.setProdBruta(ConversaoTipos.converterParaBigDecimal(obj.getProducaoBruta()).setScale(2, RoundingMode.HALF_UP));
			infoPt.setProdRef(ConversaoTipos.converterParaBigDecimal(obj.getProducaoRefugada()).setScale(2, RoundingMode.HALF_UP));
			infoPt.setProdLiq(ConversaoTipos.converterParaBigDecimal(obj.getProducaoLiquida()).setScale(2, RoundingMode.HALF_UP));
			infoPt.setProdSaldo(ConversaoTipos.converterParaBigDecimal(AritmeticaUtil.diminuir(infoPt.getMetaInstantanea(), infoPt.getProdLiq())).setScale(2, RoundingMode.HALF_UP));
	 		
			// monit tabela - paradas
			if (obj.getIniParada() != null) {
				infoPt.setDtHrIniUltPar(DataHoraRN.dateToStringYYYYDDMMHHMMSS(obj.getIniParada()));
				if (obj.getFimParada() != null) {
					infoPt.setDtHrFimUlPar(DataHoraRN.dateToStringYYYYDDMMHHMMSS(obj.getFimParada()));
					infoPt.setDuracaoUltPar(DataHoraRN.formatSegundosParaHHMMSS(DataHoraRN.getQuantidadeSegundosNoPeriodo(obj.getIniParada(), obj.getFimParada())));				
				}
				infoPt.setParada(obj.getUltimaParada());
				infoPt.setAreaResp(obj.getAreaResponsavel());
			}
			
			infoPt.setTempoParadas(DataHoraRN.formatSegundosParaHHMMSS(ConversaoTipos.converterParaBigDecimal(obj.getSegTempoParadaCP())));
			infoPt.setTempoDisp(DataHoraRN.formatSegundosParaHHMMSS(ConversaoTipos.converterParaBigDecimal(obj.getSegTempoAtivo())));
			
			infoPt.setCicloPadrao(ConversaoTipos.converterParaBigDecimal(obj.getSegCicloPadrao()).setScale(2, RoundingMode.HALF_UP));
			infoPt.setCicloMedio(ConversaoTipos.converterParaBigDecimal(obj.getSegCicloMedio()).setScale(2, RoundingMode.HALF_UP));
			infoPt.setUltimoCicloLido(ConversaoTipos.converterParaBigDecimal(obj.getSegUltimoCiclo()).setScale(2, RoundingMode.HALF_UP));		
		}
		
	 
		
		return infoPt;
	}
	
	
	private FiltroAnaliseGargaloDTO getFiltroAnaliseGargalo(
			FiltroMonitorizacaoDTO filtroMonitorizacao,
			List<FiltroDetalhePostoDTO> listaFiltroPostos,
			List<FiltroPtCpDTO> listaFiltroPtCp) {
		FiltroAnaliseGargaloDTO filtroDetalhe = new FiltroAnaliseGargaloDTO();
		filtroDetalhe.setDtReferencia(filtroMonitorizacao.getDtReferencia());
		filtroDetalhe.setIdTurno(filtroMonitorizacao.getIdTurno());
		filtroDetalhe.setFiltroOp(filtroMonitorizacao.getFiltroOp());
		filtroDetalhe.setCdGt(filtroMonitorizacao.getCdGt());
		filtroDetalhe.setListaFiltroPostos(listaFiltroPostos);
		filtroDetalhe.setListaFiltroPtCp(listaFiltroPtCp);
		return filtroDetalhe;
	}

	private List<FiltroDetalhePostoDTO> getListaFiltroPosto(FiltroMonitorizacaoDTO filtroMonitorizacao, List<PtMonitorizacaoDTO> postos) {
		List<FiltroDetalhePostoDTO> filtros = new ArrayList<FiltroDetalhePostoDTO>();

		for (PtMonitorizacaoDTO posto : postos) {
			FiltroDetalhePostoDTO filtro = new FiltroDetalhePostoDTO();

			filtro.setCdCp(posto.getFiltroCdCp());
			filtro.setCdPosto(posto.getCdPt());
			filtro.setDtReferencia(filtroMonitorizacao.getDtReferencia());
			filtro.setFiltroOp(filtroMonitorizacao.getFiltroOp());
			filtro.setIdTurno(filtroMonitorizacao.getIdTurno());
			filtro.setTpId(DwConsolidTemplate.TpId.TURNO.getValue());
			filtro.setTipoPosto(posto.getTipoPosto());
			filtro.setCdTipoPosto(posto.getCdTipoPosto());

			filtros.add(filtro);
		}

		return filtros;
	}

	private GtRtDTO getFiltroGt(FiltroMonitorizacaoDTO filtroMonitorizacao, OmGt omGt) {
		GtRtDTO filtro = new GtRtDTO();
		filtro.setDtReferencia(DataHoraRN.stringToDate(filtroMonitorizacao.getDtReferencia(), formatoData));
		filtro.setDwTurno(turnoRN.getDwTurnoPorId(filtroMonitorizacao.getIdTurno()));
		filtro.setFiltroOP(filtroMonitorizacao.getFiltroOp());

		filtro.setGtDTO(new idw.webservices.dto.GtDTO());
		filtro.getGtDTO().setGt(omGt);

		filtro.setIdPt(null);
		filtro.setIsTurnoAtual(filtroMonitorizacao.isTurnoAtual());
		return filtro;
	}

	public List<TurnoDTO> getTurnos() {
		TurnoRN turnoRN = new TurnoRN(getDao());
		TurnosDTO turnosDTO = turnoRN.getTurnos();
		List<TurnoDTO> retorno = new ArrayList<TurnoDTO>();
		for (idw.webservices.dto.TurnoDTO turnoDTO : turnosDTO.getTurnos()) {
			TurnoDTO turno = new TurnoDTO();
			turno.setIdTurno(turnoDTO.getTurno().getIdTurno());
			turno.setCdTurno(turnoDTO.getTurno().getCdTurno());
			turno.setDsTurno(turnoDTO.getTurno().getDsTurno());
			retorno.add(turno);
		}
		return retorno;
	}

	public TurnoDTO getTurnoAtual(String cdGt) throws SemCalendarioException {
		OmGtDAO omGtDAO = new OmGtDAO(getDaoSession());
		OmGt omGt = omGtDAO.getOmGtPorCdAtivoOrderById(cdGt);

		TurnoRN turnoRN = new TurnoRN(getDao());
		TurnoAtualDTO turno = turnoRN.getTurnoAtualGtDTO(omGt, new Date(), true);

		TurnoDTO turnoAtualDTO = new TurnoDTO();
		turnoAtualDTO.setIdTurno(turno.getDwturno().getIdTurno());
		turnoAtualDTO.setCdTurno(turno.getDwturno().getCdTurno());
		turnoAtualDTO.setDsTurno(turno.getDwturno().getDsTurno());
		turnoAtualDTO.setDtReferencia(converterParaString(turno.getDtReferencia()));
		turnoAtualDTO.setDtRefYMD(DataHoraRN.toStringYYYYMMDD(turno.getDtReferencia()));
		turnoAtualDTO.setDtRefTimestamp(turno.getDtReferencia().getTime());

		return turnoAtualDTO;
	}

	public TurnoDTO getTurnoAtualPt(String cdPt) throws SemCalendarioException {
		OmPtDAO omptDao = new OmPtDAO(getDaoSession());
		OmPt omPt = omptDao.getOmPtPorCdAtivoOrderById(cdPt);

		TurnoRN turnoRN = new TurnoRN(getDao());
		TurnoAtualDTO turno = turnoRN.getTurnoAtualDTOSemClone(omPt, new Date());

		TurnoDTO turnoAtualDTO = new TurnoDTO();
		turnoAtualDTO.setIdTurno(turno.getDwturno().getIdTurno());
		turnoAtualDTO.setCdTurno(turno.getDwturno().getCdTurno());
		turnoAtualDTO.setDsTurno(turno.getDwturno().getDsTurno());
		turnoAtualDTO.setDtReferencia(converterParaString(turno.getDtReferencia()));
		turnoAtualDTO.setDtRefYMD(DataHoraRN.toStringYYYYMMDD(turno.getDtReferencia()));
		turnoAtualDTO.setDtRefTimestamp(turno.getDtReferencia().getTime());

		return turnoAtualDTO;
	}
	
	private PtMonitorizacaoDTO getPtDTO(ObjRtMonitorizacaoDTO obj) {

		MonitorizacaoIcone monitorizacaoIcone = iconeFactory.getMonitorizacaoIcone(obj);
		PtIconeDTO iconeDTO = monitorizacaoIcone.getIcone(obj);

		PtIndicadorDTO indicadoresDTO = new PtIndicadorDTO();
		indicadoresDTO.setEficienciaRealizacao(converteParaString(obj.getEfiRealizacao()));
		indicadoresDTO.setEficienciaCiclo(converteParaString(obj.getEfiCiclos()));
		indicadoresDTO.setIndiceRefugo(converteParaString(obj.getIndiceRefugos()));
		indicadoresDTO.setIndiceParada(converteParaString(obj.getIndiceParadas()));
		indicadoresDTO.setEficienciaInstantanea(converteParaString(obj.getEfiInstantanea()));
		indicadoresDTO.setIndiceProducao(converteParaString(obj.getIndiceProducao()));
		indicadoresDTO.setIndiceCavidadesAtivas(converteParaString(obj.getIndiceCavAtivas()));
		indicadoresDTO.setIndiceProdutividadeOEE(converteParaString(obj.getProdutividadeOEE()));

		PtMonitorizacaoDTO ptDTO = new PtMonitorizacaoDTO();
		ptDTO.setCdPt(obj.getCdPt());
		ptDTO.setDsPt(obj.getDsPt());
		ptDTO.setDsView(obj.getDsCurta());
		ptDTO.setTipoPosto(obj.getTipoPT());
		ptDTO.setData(converterParaString(obj.getDtReferencia()));
		ptDTO.setTurno(obj.getDsTurno());
		ptDTO.setIdTurno(obj.getIdTurno());
		ptDTO.setCdProduto(obj.getCdProduto());
		ptDTO.setDsProduto(obj.getDsProduto());
		ptDTO.setFiltroCdCp(obj.getCdCp() == null ? "" : obj.getCdCp());
		ptDTO.setOpSelecionada(obj.getUltimaOp());
		ptDTO.setIcone(iconeDTO);
		ptDTO.setIndicadores(indicadoresDTO);
		ptDTO.setCdTipoPosto(obj.getCdTipoPT());

		ptDTO.setOperadores(new ArrayList<OperadorDTO>());
		for (DwConsolmolog log : obj.getDwConsolmologs()) {
			OperadorDTO operadorDTO = new OperadorDTO();
			operadorDTO.setCdUsr(log.getOmUsr().getCd());
			operadorDTO.setLogin(log.getOmUsr().getLogin());
			operadorDTO.setDsApelido(log.getOmUsr().getDsApelido());
			operadorDTO.setDsNome(log.getOmUsr().getDsNome());
			ptDTO.getOperadores().add(operadorDTO);
		}

		return ptDTO;
	}

	private String converteParaString(Double valor) {
		if (valor == null) {
			return "0.00";
		}
		return ConversaoTipos.converteParaString(valor, 2);
	}

	private String converterParaString(Date data) {
		return DataHoraRN.dateToStringDDMMYYYY(data);
	}

	private List<GtMonitorizacaoDTO> getGts(List<ObjRtMonitorizacaoDTO> objs, FiltroMonitorizacaoDTO filtroMonitorizacao) {
		List<GtMonitorizacaoDTO> gts = new ArrayList<GtMonitorizacaoDTO>();

		for (ObjRtMonitorizacaoDTO obj : objs) {

			FiltroMonitorizacaoDTO filtroDetalhe = filtroMonitorizacao.getCopia();
			filtroDetalhe.setCdGt(obj.getCdGt());

			OmGt gtBanco = gtRN.getOmGtPorIdOuCd(null, obj.getCdGt());
			String icone = "";
			if (gtBanco != null && gtBanco.getOmImg() != null) {
				icone = gtBanco.getOmImg().getUrlImg();
			}

			GtMonitorizacaoDTO gt = new GtMonitorizacaoDTO();
			gt.setCdGt(obj.getCdGt());
			gt.setDsGt(obj.getDsGt());
			gt.setDsGtView(obj.getDsGt());
			gt.setCaminhoIcone(icone);
			if (obj.getCorGt() != null) {
				gt.setCorFundo(Cor.transformarParaCodigoHexadecimal(obj.getCorGt().getRgb()));
			}
			gt.setIndiceOEE(ConversaoTipos.converteParaString(obj.getIndOEE(), 2));
			gt.setIndiceOEEMeta(ConversaoTipos.converteParaString(obj.getIndOEEMeta(), 2));
			if (obj.getQtdePostos() == null) {
				gt.setQuantidadePostos(0);
			} else {
				gt.setQuantidadePostos(obj.getQtdePostos());
			}
			gt.setFiltroDetalhe(filtroDetalhe);

			gts.add(gt);
		}

		return gts;
	}

	private List<FiltroPtCpDTO> getListaFiltroPtCp(List<ObjRtMonitorizacaoDTO> objs) {
		List<FiltroPtCpDTO> listaFiltroPtCp = new ArrayList<FiltroPtCpDTO>();

		for (ObjRtMonitorizacaoDTO obj : objs) {

			if (obj.getTipoObj() == OmObjTemplate.TpObj.TIPO_OBJ_PT.getValue()) {

				FiltroPtCpDTO filtro = new FiltroPtCpDTO();
				filtro.setIdPt(obj.getIdPt());

				if (obj.isTemPlanejamento() && obj.getIdCp() != null) {

					// 20200909
					if (obj != null && obj.getIdCp() != null) {
						filtro.setIdCp(obj.getIdCp());
					} else {
						filtro.setIdCp(0);
					}
					if (obj != null && obj.getCdCp() != null) {
						filtro.setCdCp(obj.getCdCp());
					} else {
						filtro.setCdCp("");
					}

					// 20200909...OFF
					// filtro.setIdCp(obj.getIdCp());
					// filtro.setCdCp(obj.getCdCp());
				}

				listaFiltroPtCp.add(filtro);
			}

		}

		return listaFiltroPtCp;
	}

	private List<Long> getListaIdGts(List<ObjRtMonitorizacaoDTO> objs) {
		List<Long> listaCdGts = new ArrayList<Long>();

		for (ObjRtMonitorizacaoDTO obj : objs) {

			if (obj.getTipoObj() == OmObjTemplate.TpObj.TIPO_OBJ_GT.getValue()) {
				listaCdGts.add(obj.getIdGt());
			}

		}

		return listaCdGts;
	}

	private List<PtMonitorizacaoDTO> getPostosOrdenados(List<ObjRtMonitorizacaoDTO> objs) {
		this.mapLinha = new HashMap<Integer, Double>();
		this.mapLinhaObj = new HashMap<Integer, List<ObjRtMonitorizacaoDTO>>();

		ordenarXCrescente(objs);
		gerarLinhasVirtuais(objs);
		ordernarYCrescentePorLinha();
		return getPostosFormatadosENumerados();
	}

	private void ordenarXCrescente(List<ObjRtMonitorizacaoDTO> objs) {
		Collections.sort(objs, new Comparator<ObjRtMonitorizacaoDTO>() {
			@Override
			public int compare(ObjRtMonitorizacaoDTO o1, ObjRtMonitorizacaoDTO o2) {
				return o1.getX().compareTo(o2.getX());
			}
		});
	}

	private void gerarLinhasVirtuais(List<ObjRtMonitorizacaoDTO> objs) {
		int linhaCount = 1;

		for (ObjRtMonitorizacaoDTO obj : objs) {

			boolean salvo = false;
			for (Integer linha : mapLinha.keySet()) {
				double min = mapLinha.get(linha);
				double max = min + TAMANHO_PIXEL_MAXIMO_LINHA;
				if (obj.getX() >= min && obj.getX() <= max) {
					add(linha, obj);
					salvo = true;
					break;
				}
			}

			if (!salvo) {
				mapLinha.put(linhaCount, obj.getX());
				add(linhaCount, obj);
				linhaCount++;
			}
		}
	}

	private void add(Integer linha, ObjRtMonitorizacaoDTO obj) {
		if (mapLinhaObj.get(linha) == null) {
			mapLinhaObj.put(linha, new ArrayList<ObjRtMonitorizacaoDTO>());
		}
		mapLinhaObj.get(linha).add(obj);
	}

	private void ordernarYCrescentePorLinha() {
		SortedSet<Integer> keys = new TreeSet<Integer>(mapLinhaObj.keySet());
		for (Integer chave : keys) {
			List<ObjRtMonitorizacaoDTO> listaFinal = mapLinhaObj.get(chave);

			Collections.sort(listaFinal, new Comparator<ObjRtMonitorizacaoDTO>() {
				@Override
				public int compare(ObjRtMonitorizacaoDTO o1, ObjRtMonitorizacaoDTO o2) {
					return o1.getY().compareTo(o2.getY());
				}
			});
		}
	}

	private List<PtMonitorizacaoDTO> getPostosFormatadosENumerados() {
		List<PtMonitorizacaoDTO> postos = new ArrayList<PtMonitorizacaoDTO>();

		int ordem = 1;
		SortedSet<Integer> keys = new TreeSet<Integer>(mapLinhaObj.keySet());
		for (Integer chave : keys) {

			List<ObjRtMonitorizacaoDTO> lista = mapLinhaObj.get(chave);
			for (ObjRtMonitorizacaoDTO obj : lista) {
				PtMonitorizacaoDTO posto = getPtDTO(obj);
				posto.setOrdem(ordem);
				postos.add(posto);
				ordem += 1;
			}

		}

		return postos;
	}

	private FiltroDetalhePostoDTO getFiltro(ObjRtMonitorizacaoDTO obj) {
		FiltroDetalhePostoDTO filtro = new FiltroDetalhePostoDTO();
		filtro.setFiltroOp(0);
		filtro.setCdCp(obj.getCdCp());
		filtro.setDtReferencia(DataHoraRN.dateToString(obj.getDtReferencia(), formatoData));
		filtro.setIdTurno(obj.getIdTurno());
		filtro.setCdPosto(obj.getCdPt());
		filtro.setTpId((byte) 1);
		return filtro;
	}

	@SuppressWarnings("unchecked")
	public List<MaquinaIHMDTO> getListaPtsIHM(String ihm) {
		List<MaquinaIHMDTO> retorno = new ArrayList<MaquinaIHMDTO>();

		List<Object> lista = new ArrayList<Object>();
		String strSQL = "";

		strSQL = strSQL.concat("SELECT pt.id_pt, pt.cd_pt");
		strSQL = strSQL.concat("  FROM ms_upihm ui ");
		strSQL = strSQL.concat("  JOIN ms_ihm ihm ON (ihm.id_ihm = ui.id_ihm) ");
		strSQL = strSQL.concat("  JOIN ms_up up ON (up.id_up = ui.id_up) ");
		strSQL = strSQL.concat("  JOIN om_pt pt ON (pt.cd_pt = up.cd_up) ");
		strSQL = strSQL.concat(" WHERE ihm.cd_ihm = :ihm");
		strSQL = strSQL.concat("   AND pt.st_ativo = 1 ");
		strSQL = strSQL.concat("   AND up.st_ativo = 1 ");
		strSQL = strSQL.concat("   AND pt.tp_sessao IN (0, 1, 2)");
		
		strSQL = strSQL.concat(" ORDER BY pt.cd_pt");

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q.setParameter("ihm", ihm);
		lista = q.list();

		for (Object reg : lista) {
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			MaquinaIHMDTO pt = new MaquinaIHMDTO();
			pt.setCdPt((String) registroLido[1]);
			retorno.add(pt);
		}

		lista = null;
		q = null;

		return retorno;
	}

	// indicadores da op associado ao pt
	@SuppressWarnings("unchecked")
	public MaquinaIHMDTO getIndicadoresPt(String cdPt) throws HibernateException, ParseException { 
		int _idrt = 0;
		int _idcp = _idrt + 1;
		int _nrdoc = _idcp + 1;
		int _stfuncionamento = _nrdoc + 1;
		int _offline = _stfuncionamento + 1;
		int _semplanejamento = _offline + 1;
		int _cp = _semplanejamento + 1;
		int _dthriniplan = _cp + 1;
		int _dthrinireal = _dthriniplan + 1;
		int _dthrfimplan = _dthrinireal + 1;
		int _prodplan = _dthrfimplan + 1;
		int _prodbruta = _prodplan + 1;
		int _prodref = _prodbruta + 1;

		int _fp_produto = 0;
		int _fp_prodplan = _fp_produto + 1;
		int _fp_prodbruta = _fp_prodplan + 1;
		int _fp_prodref = _fp_prodbruta + 1;
		int _fp_ciclopadrao = _fp_prodref + 1;
		int _fp_fatorcontagem = _fp_ciclopadrao + 1;
		int _fp_tampacoteciclo = _fp_fatorcontagem + 1;
		int _fp_pcscicaloc = _fp_tampacoteciclo + 1;
		int _fp_pcscictotal = _fp_pcscicaloc + 1;

		int _ind_idconsolid = 0;
		int _ind_ciclopadrao = _ind_idconsolid + 1;
		int _ind_pcscicaloc = _ind_ciclopadrao + 1;
		int _ind_pcscictot = _ind_pcscicaloc + 1;
		int _ind_qtdcicprodutivo = _ind_pcscictot + 1;
		int _ind_prodbruta = _ind_qtdcicprodutivo + 1;
		int _ind_prodref = _ind_prodbruta + 1;
		int _ind_segcicloprodutivo = _ind_prodref + 1;
		int _ind_segcicloimprodutivo = _ind_segcicloprodutivo + 1;
		int _ind_segrefugos = _ind_segcicloimprodutivo + 1;
		int _ind_segparcp = _ind_segrefugos + 1;
		int _ind_segparsp = _ind_segparcp + 1;
		int _ind_segparcpvar = _ind_segparsp + 1;
		int _ind_segparspvar = _ind_segparcpvar + 1;

		
		class StatusMaquina {
			Long idRt;
			Long idCp;
			String nrDoc;
			int stFuncionamento;
			Byte offLine;
			Byte semPlanejamento;
			String cdCp;
			Date dtHrIniPlan;
			Date dthrFimPlan;
			Date dthrIniReal; 
			BigDecimal prodPlan;
			BigDecimal prodBruta;
			BigDecimal prodRef; 
		}
		
		class ProdutoOP {
			Long idProduto;
			
			BigDecimal prodPlan = BigDecimal.ZERO;
			BigDecimal prodBruta = BigDecimal.ZERO;
			BigDecimal prodRef = BigDecimal.ZERO;
			BigDecimal prodLiq = BigDecimal.ZERO;
			BigDecimal saldoProduzir = BigDecimal.ZERO;
						
			BigDecimal cicloPadrao = BigDecimal.ONE;
			BigDecimal fatorContagem = BigDecimal.ONE;
			BigDecimal tamPacoteCiclo = BigDecimal.ONE;
			BigDecimal pcsCicAloc = BigDecimal.ONE;
			BigDecimal pcsCicTot = BigDecimal.ONE;
		}
		
		class Indicadores {
			BigDecimal cicloPadrao = BigDecimal.ZERO;
			BigDecimal pcsCicAloc = BigDecimal.ZERO;
			BigDecimal pcsCicTot = BigDecimal.ZERO;
			BigDecimal qtdCicProd = BigDecimal.ZERO;
			BigDecimal prodBruta = BigDecimal.ZERO;
			BigDecimal prodRef = BigDecimal.ZERO;
			BigDecimal segCicProd = BigDecimal.ZERO;
			BigDecimal segCicImprod = BigDecimal.ZERO;
			BigDecimal segRefugo = BigDecimal.ZERO;
			BigDecimal segParCP = BigDecimal.ZERO;
			BigDecimal segParSP = BigDecimal.ZERO;
			BigDecimal segParCPVR = BigDecimal.ZERO;
			BigDecimal segParSPVR = BigDecimal.ZERO;
			BigDecimal oee = BigDecimal.ZERO;
			BigDecimal disp = BigDecimal.ZERO;
			BigDecimal qld = BigDecimal.ZERO;
			BigDecimal ritmo = BigDecimal.ZERO;
			// propriedades auxiliares
			BigDecimal segTrabalhado = BigDecimal.ZERO;
			BigDecimal segProdutivo = BigDecimal.ZERO;
			BigDecimal segDisponivel = BigDecimal.ZERO;
			BigDecimal segBoas = BigDecimal.ZERO;
			BigDecimal segRitmo = BigDecimal.ZERO;	
			BigDecimal segPCI = BigDecimal.ZERO;	
		}
		
		// 
		MaquinaIHMDTO retorno = new MaquinaIHMDTO();
		retorno.setCdPt(cdPt);
		retorno.setHabilitaBotaoConsultas(false);
		retorno.setHabilitaBotaoEntradaOP(false);
		retorno.setHabilitaBotaoSaidaOP(false);
		retorno.setHabilitaFuncaoAlerta(false);
		retorno.setHabilitaFuncaoLoginOper(false);
		retorno.setHabilitaFuncaoParada(false);
		retorno.setHabilitaFuncaoRefugo(false);
		
		
		StatusMaquina statusMaq = new StatusMaquina();
		ProdutoOP produtoOP = new ProdutoOP();
		List<ProdutoOP> produtosOP = new ArrayList<ProdutoOP>();
		Indicadores indicador = new Indicadores();
		Indicadores indicadorTotal = new Indicadores();
		
		// pega as metas
		// metas definidas em omcfg (considera meta geral)
		OmCfg omCfg = Util.getConfigGeral(this.getDaoSession());
		MetaIndicadorDTO2 metaQld = null;
		MetaIndicadorDTO2 metaOEE = null;
		MetaIndicadorDTO2 metaDisp = null;
		MetaIndicadorDTO2 metaRitmo = null;

		// metas
		if (omCfg != null) {
			for (OmCfgind omCfgInd : omCfg.getOmCfginds()) {
				// qualidade
				if (omCfgInd.getOmInd().getIdInd() == 9) {
					metaQld = new MetaIndicadorDTO2();
					metaQld.setLimInf(omCfgInd.getIndInferior().setScale(2, RoundingMode.HALF_UP));
					metaQld.setLimSup(omCfgInd.getIndSuperior().setScale(2, RoundingMode.HALF_UP));
					metaQld.setLimMeta(omCfgInd.getIndMeta().setScale(2, RoundingMode.HALF_UP));
					metaQld.setMetaMaisAltaMelhor(true);
				}

				// ritmo
				if (omCfgInd.getOmInd().getIdInd() == 8) {
					metaRitmo = new MetaIndicadorDTO2();
					metaRitmo.setLimInf(omCfgInd.getIndInferior().setScale(2, RoundingMode.HALF_UP));
					metaRitmo.setLimSup(omCfgInd.getIndSuperior().setScale(2, RoundingMode.HALF_UP));
					metaRitmo.setLimMeta(omCfgInd.getIndMeta().setScale(2, RoundingMode.HALF_UP));
					metaRitmo.setMetaMaisAltaMelhor(true);
				}

				// ooe (tb será usado pra disponbilidade)
				if (omCfgInd.getOmInd().getIdInd() == 5) {
					metaOEE = new MetaIndicadorDTO2();
					metaOEE.setLimInf(omCfgInd.getIndInferior().setScale(2, RoundingMode.HALF_UP));
					metaOEE.setLimSup(omCfgInd.getIndSuperior().setScale(2, RoundingMode.HALF_UP));
					metaOEE.setLimMeta(omCfgInd.getIndMeta().setScale(2, RoundingMode.HALF_UP));
					metaOEE.setMetaMaisAltaMelhor(true);

					metaDisp = new MetaIndicadorDTO2();
					metaDisp.setLimInf(omCfgInd.getIndInferior().setScale(2, RoundingMode.HALF_UP));
					metaDisp.setLimSup(omCfgInd.getIndSuperior().setScale(2, RoundingMode.HALF_UP));
					metaDisp.setLimMeta(omCfgInd.getIndMeta().setScale(2, RoundingMode.HALF_UP));
					metaDisp.setMetaMaisAltaMelhor(true);
				}
			}
		}

		retorno.setMetaDisp(metaDisp);
		retorno.setMetaOEE(metaOEE);
		retorno.setMetaQld(metaQld);
		retorno.setMetaRitmo(metaRitmo);

		List<Object> lista = new ArrayList<Object>();
		String strSQL = "";
		SQLQuery q = null;
		
 
				
		strSQL = "";
		strSQL = strSQL.concat("SELECT rt.id_rt, cp.id_cp, cpp.nr_doc, (CASE WHEN rt.st_funcionamento IS NULL THEN 0 ELSE rt.st_funcionamento END) as st_funcionamento, rt.is_offline, rt.is_semplanejamento, ");
		strSQL = strSQL.concat("       cp.cd_cp, cp.dthr_inicio, cp.dthr_inicioreal, cp.dthr_final, cpp.prodPlanCP, cpp.prodBrutaCP, cpp.prodRefCP ");
		strSQL = strSQL.concat("  FROM om_pt pt "); 
		strSQL = strSQL.concat("  JOIN dw_consolpt cpt ON (cpt.id_pt = pt.id_pt)  ");
		strSQL = strSQL.concat("  JOIN dw_consolid cid ON (cid.id_consolid = cpt.id_consolid_turno AND cid.tp_id = 1) ");
		strSQL = strSQL.concat("  JOIN dw_rt rt ON (rt.id_rt = cid.id_rt) ");
		strSQL = strSQL.concat("  JOIN pp_cp cp ON (cp.id_cp = rt.id_cp) ");
		strSQL = strSQL.concat("  JOIN (SELECT pp.id_cp, pp.nr_doc, ");
		strSQL = strSQL.concat("			   SUM(CASE WHEN pp.pcs_producaoPlanejada IS NULL THEN 0 ELSE pp.pcs_producaoPlanejada END) as prodPlanCP, ");
		strSQL = strSQL.concat("		       SUM(CASE WHEN pp.pcs_producaoBruta IS NULL THEN 0 ELSE pp.pcs_producaoBruta END) as prodBrutaCP, ");
		strSQL = strSQL.concat("		       SUM(CASE WHEN pp.pcs_producaorefugada IS NULL THEN 0 ELSE pp.pcs_producaorefugada END) as prodRefCP ");
		strSQL = strSQL.concat("	      FROM pp_cpproduto pp ");;
		strSQL = strSQL.concat("	     GROUP BY pp.id_cp, pp.nr_doc)cpp ON (cpp.id_cp = cp.id_cp) ");
		strSQL = strSQL.concat(" WHERE pt.cd_pt = :cdPt ");
		
		q = this.getDaoSession().createSQLQuery(strSQL);
		q.setParameter("cdPt", cdPt);
		q.setMaxResults(1);
		Object regQueryObj = q.uniqueResult();
			
		retorno.setCdPt(cdPt);
			
		if (regQueryObj != null) {
			
			Object[] registroLido = null;
			Object registroLidoAux = (Object) regQueryObj;
			registroLido = (Object[]) registroLidoAux;
			
			statusMaq = new StatusMaquina();
			
			statusMaq.idRt = ConversaoTipos.converterParaBigDecimal(registroLido[_idrt]).longValue();
			statusMaq.idCp = ConversaoTipos.converterParaBigDecimal(registroLido[_idcp]).longValue();
			statusMaq.cdCp = (String) registroLido[_cp];
			statusMaq.nrDoc = (String) registroLido[_nrdoc];
			
			statusMaq.stFuncionamento = ConversaoTipos.converterParaBigDecimal(registroLido[_stfuncionamento]).intValue();
			
			if (registroLido[_offline] != null) {
				if (registroLido[_offline] instanceof Boolean) {
					statusMaq.offLine = ((boolean)registroLido[_offline] ? (byte) 1 : (byte) 0);	
				} else {
					statusMaq.offLine = ConversaoTipos.converterParaBigDecimal(registroLido[_offline]).byteValue();						
				}
			} else {
				statusMaq.offLine = (byte) 0;
			}

			if (registroLido[_semplanejamento] != null) {
				if (registroLido[_semplanejamento] instanceof Boolean) {
					statusMaq.semPlanejamento = ((boolean)registroLido[_semplanejamento] ? (byte) 1 : (byte) 0);
				} else {
					statusMaq.semPlanejamento = ConversaoTipos.converterParaBigDecimal(registroLido[_semplanejamento]).byteValue();							
				}
			} else {
				statusMaq.offLine = (byte) 0;
			}
			
			
			if (statusMaq.semPlanejamento == (byte) 1 || statusMaq.offLine == (byte) 1) {
				retorno.setOee(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
				retorno.setDisp(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
				retorno.setRitmo(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
				retorno.setQld(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
				
				retorno.setHabilitaFuncaoParada(false);		
				retorno.setHabilitaFuncaoRefugo(false);
				retorno.setHabilitaFuncaoAlerta(false);		;
				retorno.setHabilitaFuncaoLoginOper(false);
				retorno.setHabilitaBotaoEntradaOP(true);
				retorno.setHabilitaBotaoSaidaOP(false);
				retorno.setHabilitaBotaoConsultas(false);
				
				retorno.setDthrIniPlan(""); 
				retorno.setDthrFimPlan("");
				retorno.setDthrIniReal("");
				retorno.setDthrFimPrev("");
				
				retorno.setProdPlan(BigDecimal.ZERO);
				retorno.setProdLiq(BigDecimal.ZERO);
				retorno.setProdFaltante(BigDecimal.ZERO);
			} else {
				statusMaq.dtHrIniPlan = (Date) registroLido[_dthriniplan];
				if (registroLido[_dthrfimplan] != null) {
					statusMaq.dthrFimPlan = (Date) registroLido[_dthrfimplan];
				}
				if (registroLido[_dthrinireal] != null) {
					statusMaq.dthrIniReal = (Date) registroLido[_dthrinireal];
				}
				
				statusMaq.prodPlan = ConversaoTipos.converterParaBigDecimal(registroLido[_prodplan]);
				statusMaq.prodBruta = ConversaoTipos.converterParaBigDecimal(registroLido[_prodbruta]);
				statusMaq.prodRef = ConversaoTipos.converterParaBigDecimal(registroLido[_prodref]);
				
				
				//retorno.setCdCp(statusMaq.cdCp);
				retorno.setCdCp(statusMaq.nrDoc);
				retorno.setProdPlan(statusMaq.prodPlan.setScale(0, RoundingMode.HALF_UP));
				retorno.setProdLiq(AritmeticaUtil.diminuir(statusMaq.prodBruta, statusMaq.prodRef).setScale(0, RoundingMode.HALF_UP));
				retorno.setProdFaltante(AritmeticaUtil.diminuir(retorno.getProdPlan(), retorno.getProdLiq()).setScale(0, RoundingMode.HALF_UP));
				
				
				// pra cálculo do final previsto (com base na qtd faltante)
				strSQL = "";
				strSQL = strSQL.concat("SELECT pp.id_produto, ");
				
				strSQL = strSQL.concat("       pp.pcs_producaoplanejada, ");
				strSQL = strSQL.concat("       (CASE WHEN pp.pcs_producaoBruta IS NULL THEN 0 ELSE pp.pcs_producaoPlanejada END) as prodbruta, ");
				strSQL = strSQL.concat("       (CASE WHEN pp.pcs_producaorefugada IS NULL THEN 0 ELSE pp.pcs_producaorefugada END) as prodref, ");

				strSQL = strSQL.concat("       (CASE WHEN dwfc.seg_ciclopadrao IS NULL OR dwfc.seg_ciclopadrao = 0 ");
				strSQL = strSQL.concat("	     	 THEN (CASE WHEN dwf.seg_ciclopadrao IS NULL OR dwf.seg_ciclopadrao = 0 ");
				strSQL = strSQL.concat("				   THEN 1 ");
				strSQL = strSQL.concat("				   ELSE dwf.seg_ciclopadrao END)  ");
				strSQL = strSQL.concat("		     ELSE dwfc.seg_ciclopadrao END) as folha_ciclopadrao,  ");

				strSQL = strSQL.concat("      (CASE WHEN dwfc.qt_fatorcontagem IS NULL THEN 1 ELSE dwfc.qt_fatorcontagem END) as fatorcontagem,  ");

				strSQL = strSQL.concat("      (CASE WHEN dwfc.qt_pacoteciclo IS NULL THEN 1 ELSE dwfc.qt_pacoteciclo END) as dwfc_pacoteciclo, ");

				strSQL = strSQL.concat("      (CASE WHEN dwfrc.qt_ativa IS NULL OR dwfrc.qt_ativa = 0 ");
				strSQL = strSQL.concat("		    THEN (CASE WHEN dwfi.qt_ativa IS NULL OR dwfi.qt_ativa = 0 ");
				strSQL = strSQL.concat("			  		   THEN 1 ");
				strSQL = strSQL.concat("			 		   ELSE dwfi.qt_ativa END) ");
				strSQL = strSQL.concat("		    ELSE dwfrc.qt_ativa END) as qtPcsCicAloc, ");

				strSQL = strSQL.concat("      (CASE WHEN dwfrc.qt_total IS NULL OR dwfrc.qt_total = 0 ");
				strSQL = strSQL.concat("		    THEN (CASE WHEN dwfi.qt_ativa IS NULL OR dwfi.qt_ativa = 0 ");
				strSQL = strSQL.concat("				       THEN 1 ");
				strSQL = strSQL.concat("				       ELSE dwfi.qt_ativa END) ");
				strSQL = strSQL.concat("		    ELSE dwfrc.qt_total END) as qtPcsCicTotal   ");

				strSQL = strSQL.concat("  FROM pp_cp cp ");
				strSQL = strSQL.concat("  JOIN pp_cpproduto pp ON (pp.id_cp = cp.id_cp) ");
				strSQL = strSQL.concat("  JOIN dw_folha dwf ON (dwf.id_folha = cp.id_folha) ");
				strSQL = strSQL.concat("  LEFT JOIN dw_folhacic dwfc ON (dwfc.id_folha = dwf.id_folha AND dwfc.id_pt = cp.id_pt) ");
				strSQL = strSQL.concat("  LEFT JOIN dw_folhaiac dwfi ON (dwfi.id_folha = dwf.id_folha AND dwfi.id_produto = pp.id_produto) ");
				strSQL = strSQL.concat("  LEFT JOIN dw_folharap dwfr ON (dwfr.id_folha = dwf.id_folha) ");
				strSQL = strSQL.concat("  LEFT JOIN dw_folharapcom dwfrc ON (dwfrc.id_folharap = dwfr.id_folharap AND dwfrc.id_produto = pp.id_produto) ");
				strSQL = strSQL.concat("  LEFT JOIN dw_rap rap ON (rap.id_rap = dwfr.id_rap) ");
				strSQL = strSQL.concat(" WHERE cp.id_cp = :idcp ");

				q = this.getDaoSession().createSQLQuery(strSQL);
				q.setParameter("idcp", statusMaq.idCp); 
				lista = q.list();		
				
				Date dthrFimPrev = null;
				Date dtHrCalc = null;
				Date dthrAtual = DataHoraRN.getDataHoraAtual();
				
				for (Object reg : lista) {
					registroLido = null; 
					registroLidoAux = (Object) reg; 
					registroLido = (Object[]) registroLidoAux;
					
					produtoOP = new ProdutoOP();
					produtoOP.idProduto =  ConversaoTipos.converterParaBigDecimal(registroLido[_fp_produto]).longValue();
					
					produtoOP.prodPlan =  ConversaoTipos.converterParaBigDecimal(registroLido[_fp_prodplan]);
					produtoOP.prodBruta =  ConversaoTipos.converterParaBigDecimal(registroLido[_fp_prodbruta]);
					produtoOP.prodRef =  ConversaoTipos.converterParaBigDecimal(registroLido[_fp_prodref]);
					
					produtoOP.cicloPadrao =  ConversaoTipos.converterParaBigDecimal(registroLido[_fp_ciclopadrao]);
					produtoOP.fatorContagem =  ConversaoTipos.converterParaBigDecimal(registroLido[_fp_fatorcontagem]);
					produtoOP.tamPacoteCiclo =  ConversaoTipos.converterParaBigDecimal(registroLido[_fp_tampacoteciclo]);
					produtoOP.pcsCicAloc =  ConversaoTipos.converterParaBigDecimal(registroLido[_fp_pcscicaloc]);
					produtoOP.pcsCicTot =  ConversaoTipos.converterParaBigDecimal(registroLido[_fp_pcscictotal]);		
					
					
					// estima fim previsto para itens com saldo a produzir
					produtoOP.prodLiq = AritmeticaUtil.diminuir(produtoOP.prodBruta, produtoOP.prodRef);
					produtoOP.saldoProduzir = AritmeticaUtil.diminuir(produtoOP.prodPlan, produtoOP.prodLiq);
					
					if (produtoOP.saldoProduzir.doubleValue() > 0) {
						// identifica o tempo necessario pra finalizar op
						BigDecimal fatorDivisao = AritmeticaUtil.multiplicar(produtoOP.fatorContagem, produtoOP.pcsCicAloc);
						BigDecimal qtdCicNec = AritmeticaUtil.dividir(produtoOP.saldoProduzir, fatorDivisao);
						BigDecimal tempoNec = AritmeticaUtil.multiplicar(qtdCicNec, produtoOP.cicloPadrao);
						
						// Considerar agenda de turnos??? talvez em futuras implementacoes
						dtHrCalc = DataHoraRN.somaSegundos(dthrAtual, tempoNec.intValue());				
						if (dthrFimPrev == null) {
							dthrFimPrev = dtHrCalc;
						} else {
							if (DataHoraRN.after(dthrFimPrev, dtHrCalc)) {
								dthrFimPrev = dtHrCalc;
							}
						}					
					}				
					
					produtosOP.add(produtoOP);
				}	 
							 
				
				// datas
				retorno.setDthrIniPlan(DataHoraRN.dateToStringYYYYMMDDHHMMSS(statusMaq.dtHrIniPlan)); 
				
				if (statusMaq.dthrFimPlan != null) {
					retorno.setDthrFimPlan(DataHoraRN.dateToStringYYYYMMDDHHMMSS(statusMaq.dthrFimPlan)); 
				} else {
					retorno.setDthrFimPlan("");
				}
				
				if (statusMaq.dthrIniReal != null) {
					retorno.setDthrIniReal(DataHoraRN.dateToStringYYYYMMDDHHMMSS(statusMaq.dthrIniReal)); 
				} else {
					retorno.setDthrIniReal("");
				}
				
				
				if (dthrFimPrev != null) {
					retorno.setDthrFimPrev(DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthrFimPrev)); 
				} else {
					retorno.setDthrFimPrev("");
				}
				
				
				// cálculo dos indicadores			
				strSQL = "";
				strSQL = strSQL.concat("SELECT cid.id_consolid, cns.seg_auto_ciclopadrao, cns.qt_auto_cavativas, cns.qt_auto_cavtotal, ");
				strSQL = strSQL.concat("       ((CASE WHEN cns.qt_auto_cicloprodutivo IS NULL THEN 0 ELSE cns.qt_auto_cicloprodutivo END) + (CASE WHEN cns.qt_manu_cicloprodutivo IS NULL THEN 0 ELSE cns.qt_manu_cicloprodutivo END)) as qtdcicprodutivo,  ");
				strSQL = strSQL.concat("       ((CASE WHEN cns.pcs_auto_producaobruta IS NULL THEN 0 ELSE cns.pcs_auto_producaobruta END) + (CASE WHEN cns.pcs_manu_producaobruta IS NULL THEN 0 ELSE cns.pcs_manu_producaobruta END)) as qtdprodbruta, ");
				strSQL = strSQL.concat("       ((CASE WHEN cns.pcs_auto_producaorefugada IS NULL THEN 0 ELSE cns.pcs_auto_producaorefugada END) + (CASE WHEN cns.pcs_manu_producaorefugada IS NULL THEN 0 ELSE cns.pcs_manu_producaorefugada END)) as qtdref, ");
				strSQL = strSQL.concat("       ((CASE WHEN cns.seg_auto_cicloprodutivo IS NULL THEN 0 ELSE cns.seg_auto_cicloprodutivo END) + (CASE WHEN cns.seg_manu_cicloprodutivo IS NULL THEN 0 ELSE cns.seg_manu_cicloprodutivo END)) as tempocicprodutivo, ");
				strSQL = strSQL.concat("       ((CASE WHEN cns.seg_auto_cicloimprodutivo IS NULL THEN 0 ELSE cns.seg_auto_cicloimprodutivo END) + (CASE WHEN cns.seg_manu_cicloimprodutivo IS NULL THEN 0 ELSE cns.seg_manu_cicloimprodutivo END)) as tempocicimprodutivo, ");
				strSQL = strSQL.concat("       ((CASE WHEN cns.seg_auto_temporefugadas IS NULL THEN 0 ELSE cns.seg_auto_temporefugadas END) + (CASE WHEN cns.seg_manu_temporefugadas IS NULL THEN 0 ELSE cns.seg_manu_temporefugadas END)) as temporefugadas,  ");
				strSQL = strSQL.concat("       ((CASE WHEN cns.seg_auto_tempoparada_cp IS NULL THEN 0 ELSE cns.seg_auto_tempoparada_cp END) + (CASE WHEN cns.seg_manu_tempoparada_cp IS NULL THEN 0 ELSE cns.seg_manu_tempoparada_cp END)) as tempoparcp,  ");
				strSQL = strSQL.concat("       ((CASE WHEN cns.seg_auto_tempoparada_sp IS NULL THEN 0 ELSE cns.seg_auto_tempoparada_sp END) + (CASE WHEN cns.seg_manu_tempoparada_sp IS NULL THEN 0 ELSE cns.seg_manu_tempoparada_sp END)) as tempoparsp,  ");
				strSQL = strSQL.concat("       ((CASE WHEN cns.seg_auto_tempoparada_cp_vr IS NULL THEN 0 ELSE cns.seg_auto_tempoparada_cp_vr END) + (CASE WHEN cns.seg_manu_tempoparada_cp_vr IS NULL THEN 0 ELSE cns.seg_manu_tempoparada_cp_vr END)) as tempoparcpvr,  ");
				strSQL = strSQL.concat("       ((CASE WHEN cns.seg_auto_tempoparada_sp_vr IS NULL THEN 0 ELSE cns.seg_auto_tempoparada_sp_vr END) + (CASE WHEN cns.seg_manu_tempoparada_sp_vr IS NULL THEN 0 ELSE cns.seg_manu_tempoparada_sp_vr END)) as tempoparspvr ");
				strSQL = strSQL.concat("  FROM dw_consolid cid ");
				strSQL = strSQL.concat("  JOIN dw_consol cns ON (cns.id_consolid = cid.id_consolid) "); 
				strSQL = strSQL.concat(" WHERE cid.tp_id = 1  ");
				strSQL = strSQL.concat("   AND cid.id_rt = :idrt "); 
				strSQL = strSQL.concat(" ORDER BY cid.id_consolid");
				
				q = this.getDaoSession().createSQLQuery(strSQL);
				q.setParameter("idrt", statusMaq.idRt);  
				lista = q.list();		
				
				for (Object reg : lista) {
					registroLido = null; 
					registroLidoAux = (Object) reg; 
					registroLido = (Object[])	registroLidoAux;
					
					indicador = new Indicadores();
					indicador.cicloPadrao = ConversaoTipos.converterParaBigDecimal(registroLido[_ind_ciclopadrao]);
					indicador.pcsCicAloc = ConversaoTipos.converterParaBigDecimal(registroLido[_ind_pcscicaloc]);
					indicador.pcsCicTot = ConversaoTipos.converterParaBigDecimal(registroLido[_ind_pcscictot]);
					
					indicador.qtdCicProd = ConversaoTipos.converterParaBigDecimal(registroLido[_ind_qtdcicprodutivo]);
					indicador.prodBruta = ConversaoTipos.converterParaBigDecimal(registroLido[_ind_prodbruta]);
					indicador.prodRef = ConversaoTipos.converterParaBigDecimal(registroLido[_ind_prodref]);
					indicador.segCicProd = ConversaoTipos.converterParaBigDecimal(registroLido[_ind_segcicloprodutivo]);
					indicador.segCicImprod = ConversaoTipos.converterParaBigDecimal(registroLido[_ind_segcicloimprodutivo]);
					indicador.segRefugo = ConversaoTipos.converterParaBigDecimal(registroLido[_ind_segrefugos]);
					indicador.segParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_ind_segparcp]);
					indicador.segParSP = ConversaoTipos.converterParaBigDecimal(registroLido[_ind_segparsp]);
					indicador.segParCPVR = ConversaoTipos.converterParaBigDecimal(registroLido[_ind_segparcpvar]);
					indicador.segParSPVR = ConversaoTipos.converterParaBigDecimal(registroLido[_ind_segparspvar]);
					indicador.segRitmo = FormulasInjet.calcularRitmo(indicador.segCicProd, indicador.qtdCicProd, indicador.cicloPadrao, indicador.segParCPVR, indicador.segParSPVR);
					indicador.segPCI = FormulasInjet.calcularCavidadesInativaSeg(indicador.pcsCicAloc, indicador.pcsCicTot, indicador.segCicProd);
					
					indicadorTotal.qtdCicProd = AritmeticaUtil.somar(indicadorTotal.qtdCicProd, indicador.qtdCicProd);
					indicadorTotal.prodBruta = AritmeticaUtil.somar(indicadorTotal.prodBruta, indicador.prodBruta);
					indicadorTotal.prodRef = AritmeticaUtil.somar(indicadorTotal.prodRef, indicador.prodRef);
					indicadorTotal.segCicProd = AritmeticaUtil.somar(indicadorTotal.segCicProd, indicador.segCicProd);
					indicadorTotal.segCicImprod = AritmeticaUtil.somar(indicadorTotal.segCicImprod, indicador.segCicImprod);
					indicadorTotal.segRefugo = AritmeticaUtil.somar(indicadorTotal.segRefugo, indicador.segRefugo);
					indicadorTotal.segParCP = AritmeticaUtil.somar(indicadorTotal.segParCP, indicador.segParCP);
					indicadorTotal.segParSP = AritmeticaUtil.somar(indicadorTotal.segParSP, indicador.segParSP);
					indicadorTotal.segParCPVR = AritmeticaUtil.somar(indicadorTotal.segParCPVR, indicador.segParCPVR);
					indicadorTotal.segParSPVR = AritmeticaUtil.somar(indicadorTotal.segParSPVR, indicador.segParSPVR);
					indicadorTotal.segRitmo = AritmeticaUtil.somar(indicadorTotal.segRitmo, indicador.segRitmo);
					indicadorTotal.segPCI = AritmeticaUtil.somar(indicadorTotal.segPCI, indicador.segPCI);
					
				}	
				
				// calcula indicadores com base em valores acumulados em indicadorTotal
				indicadorTotal.segBoas = FormulasInjet.calcularTempoBoas(indicadorTotal.segCicProd, indicadorTotal.segRefugo, indicadorTotal.segParCPVR, indicadorTotal.segParSPVR);
				indicadorTotal.segProdutivo = FormulasInjet.calcularTempoprodutivas(indicadorTotal.segBoas, indicadorTotal.segPCI, indicadorTotal.segRitmo);
				indicadorTotal.segDisponivel = FormulasInjet.calcularTempoAtivo(indicadorTotal.segCicProd, indicadorTotal.segParCP, indicadorTotal.segCicImprod, indicadorTotal.segParCPVR, indicadorTotal.segParSPVR);
				indicadorTotal.segTrabalhado = FormulasInjet.calcularTempoTrabalhado(indicadorTotal.segDisponivel, indicadorTotal.segParCP);
				
				indicadorTotal.oee = new BigDecimal(FormulasInjet.calcularOEE(indicadorTotal.segProdutivo, indicadorTotal.segDisponivel));
				indicadorTotal.disp = FormulasInjet.calcularIndiceDisponibilidade(indicadorTotal.segTrabalhado, indicadorTotal.segDisponivel);
				indicadorTotal.ritmo = FormulasInjet.calcularRitmoPercentual(indicadorTotal.segCicProd, indicadorTotal.segTrabalhado);
				indicadorTotal.qld = new BigDecimal(FormulasInjet.calcularIndiceQualidadePeloRefugo(FormulasInjet.calcularIndiceRefugo(indicadorTotal.prodRef, indicadorTotal.prodBruta)));
				
				
				retorno.setOee(indicadorTotal.oee.setScale(2, RoundingMode.HALF_UP));
				retorno.setDisp(indicadorTotal.disp.setScale(2, RoundingMode.HALF_UP));
				retorno.setRitmo(indicadorTotal.ritmo.setScale(2, RoundingMode.HALF_UP));
				retorno.setQld(indicadorTotal.qld.setScale(2, RoundingMode.HALF_UP));
				
				if (indicadorTotal.segParCP.doubleValue() > 0d || indicadorTotal.segParCPVR.doubleValue() > 0d || indicadorTotal.segParSP.doubleValue() > 0d || indicadorTotal.segParSPVR.doubleValue() > 0d) {
					retorno.setHabilitaFuncaoParada(true);
				}
				
				if (indicador.prodBruta.doubleValue() > 0) {
					retorno.setHabilitaFuncaoRefugo(true);
				}
				
				if (statusMaq.semPlanejamento == 0) {
					retorno.setHabilitaBotaoEntradaOP(false);
					retorno.setHabilitaBotaoSaidaOP(true);
					retorno.setHabilitaFuncaoLoginOper(true);
					retorno.setHabilitaBotaoConsultas(true);
					retorno.setHabilitaFuncaoAlerta(true);
				} else {
					retorno.setHabilitaBotaoEntradaOP(true);
					retorno.setHabilitaBotaoSaidaOP(false);
					retorno.setHabilitaFuncaoLoginOper(false);
					retorno.setHabilitaBotaoConsultas(false);
					retorno.setHabilitaFuncaoAlerta(false);				
				} 

			}
			
			

		} else {
			retorno.setOee(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
			retorno.setDisp(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
			retorno.setRitmo(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
			retorno.setQld(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
			
			retorno.setHabilitaFuncaoParada(false);
			retorno.setHabilitaFuncaoRefugo(false);
			retorno.setHabilitaFuncaoAlerta(false);		;
			retorno.setHabilitaFuncaoLoginOper(false);
			retorno.setHabilitaBotaoEntradaOP(true);
			retorno.setHabilitaBotaoSaidaOP(false);
			retorno.setHabilitaBotaoConsultas(false);
			
			retorno.setDthrIniPlan(""); 
			retorno.setDthrFimPlan("");
			retorno.setDthrIniReal("");
			retorno.setDthrFimPrev("");
			
			retorno.setProdPlan(BigDecimal.ZERO);
			retorno.setProdLiq(BigDecimal.ZERO);
			retorno.setProdFaltante(BigDecimal.ZERO);
		}

		statusMaq = null;
		produtoOP = null;
		produtosOP = null;
		indicador = null;
		indicadorTotal = null;
	
		lista = null;
		q = null;

		return retorno;
	}


	// indicadores da op associado ao pt
	@SuppressWarnings("unchecked")
	public List<MaquinaIHMDTO> getIndicadoresPtsIHM(String cdIHM) throws HibernateException, ParseException { 
		List<MaquinaIHMDTO> retorno = new ArrayList<MaquinaIHMDTO>();
		
		
		int _cdpt = 0;
		int _cdcp = _cdpt + 1;
		int _nrdoc = _cdcp + 1;
		int _stfuncionamento = _nrdoc + 1;
		int _offline = _stfuncionamento + 1;
		int _semplanejamento = _offline + 1; 
		int _segcicprod = _semplanejamento + 1;
		int _segcicimprod = _segcicprod + 1;
		int _segrefugo = _segcicimprod +1;
		int _segritmo = _segrefugo + 1;
		int _segpci = _segritmo + 1;
		int _segparcp = _segpci + 1;
		int _segparsp = _segparcp + 1;
		int _segparcpvr = _segparsp + 1;
		int _segparspvr = _segparcpvr + 1;
		int _prodbruta = _segparspvr + 1;
		int _prodref = _prodbruta + 1;
		
		
		class Indicadores {
			String cdPt;
			String cdCp;
			String nrDoc;
			int stFuncionamento;
			boolean offLine;
			boolean semPlanejamento;
			
			BigDecimal qtdCicProd = BigDecimal.ZERO;
			BigDecimal prodBruta = BigDecimal.ZERO;
			BigDecimal prodRef = BigDecimal.ZERO;

			BigDecimal segCicProd = BigDecimal.ZERO;
			BigDecimal segCicImprod = BigDecimal.ZERO;
			BigDecimal segRefugo = BigDecimal.ZERO;
			BigDecimal segParCP = BigDecimal.ZERO;
			BigDecimal segParSP = BigDecimal.ZERO;
			BigDecimal segParCPVR = BigDecimal.ZERO;
			BigDecimal segParSPVR = BigDecimal.ZERO;
			BigDecimal segBoas = BigDecimal.ZERO;
			BigDecimal segRitmo = BigDecimal.ZERO;	
			BigDecimal segPCI = BigDecimal.ZERO;	

			BigDecimal segTrabalhado = BigDecimal.ZERO;
			BigDecimal segProdutivo = BigDecimal.ZERO;
			BigDecimal segDisponivel = BigDecimal.ZERO;

			BigDecimal oee = BigDecimal.ZERO;
		}
		
 
 
		
		// pega as metas
		// metas definidas em omcfg (considera meta geral)
		OmCfg omCfg = Util.getConfigGeral(this.getDaoSession()); 
		MetaIndicadorDTO2 metaOEE = null; 

		// metas
		if (omCfg != null) {
			for (OmCfgind omCfgInd : omCfg.getOmCfginds()) {
				// ooe (tb será usado pra disponbilidade)
				if (omCfgInd.getOmInd().getIdInd() == 5) {
					metaOEE = new MetaIndicadorDTO2();
					metaOEE.setLimInf(omCfgInd.getIndInferior().setScale(2, RoundingMode.HALF_UP));
					metaOEE.setLimSup(omCfgInd.getIndSuperior().setScale(2, RoundingMode.HALF_UP));
					metaOEE.setLimMeta(omCfgInd.getIndMeta().setScale(2, RoundingMode.HALF_UP)); 
				}
			}
		} 
 
		MaquinaIHMDTO pt = new MaquinaIHMDTO();
		
		List<Object> lista = new ArrayList<Object>();
		String strSQL = ""; 
		strSQL = strSQL.concat("SELECT pt.cd_pt, cp.cd_cp, cpp.nr_doc, rt.st_funcionamento, rt.is_offline, rt.is_semplanejamento,");
		
		strSQL = strSQL.concat("       SUM((CASE WHEN cns.seg_auto_cicloprodutivo IS NULL THEN 0 ELSE cns.seg_auto_cicloprodutivo END) + (CASE WHEN cns.seg_manu_cicloprodutivo IS NULL THEN 0 ELSE cns.seg_manu_cicloprodutivo END)) as tempocicprodutivo, ");
		strSQL = strSQL.concat("       SUM((CASE WHEN cns.seg_auto_cicloimprodutivo IS NULL THEN 0 ELSE cns.seg_auto_cicloimprodutivo END) + (CASE WHEN cns.seg_manu_cicloimprodutivo IS NULL THEN 0 ELSE cns.seg_manu_cicloimprodutivo END)) as tempocicimprodutivo, ");
		   
		strSQL = strSQL.concat("       SUM((CASE WHEN cns.seg_auto_temporefugadas IS NULL THEN 0 ELSE cns.seg_auto_temporefugadas END) + (CASE WHEN cns.seg_manu_temporefugadas IS NULL THEN 0 ELSE cns.seg_manu_temporefugadas END)) as temporefugadas,  ");
		strSQL = strSQL.concat("       SUM((CASE WHEN cns.seg_auto_ritmo IS NULL THEN 0 ELSE cns.seg_auto_ritmo END) + (CASE WHEN cns.seg_manu_ritmo IS NULL THEN 0 ELSE cns.seg_manu_ritmo END)) as temporritmo, ");   
		strSQL = strSQL.concat("       SUM((CASE WHEN cns.seg_auto_perdacav IS NULL THEN 0 ELSE cns.seg_auto_perdacav END) + (CASE WHEN cns.seg_manu_perdacav IS NULL THEN 0 ELSE cns.seg_manu_perdacav END)) as tempopci, ");
		   
		strSQL = strSQL.concat("       SUM((CASE WHEN cns.seg_auto_tempoparada_cp IS NULL THEN 0 ELSE cns.seg_auto_tempoparada_cp END) + (CASE WHEN cns.seg_manu_tempoparada_cp IS NULL THEN 0 ELSE cns.seg_manu_tempoparada_cp END)) as tempoparcp, ");
		strSQL = strSQL.concat("       SUM((CASE WHEN cns.seg_auto_tempoparada_sp IS NULL THEN 0 ELSE cns.seg_auto_tempoparada_sp END) + (CASE WHEN cns.seg_manu_tempoparada_sp IS NULL THEN 0 ELSE cns.seg_manu_tempoparada_sp END)) as tempoparsp, ");
		strSQL = strSQL.concat("       SUM((CASE WHEN cns.seg_auto_tempoparada_cp_vr IS NULL THEN 0 ELSE cns.seg_auto_tempoparada_cp_vr END) + (CASE WHEN cns.seg_manu_tempoparada_cp_vr IS NULL THEN 0 ELSE cns.seg_manu_tempoparada_cp_vr END)) as tempoparcpvr, ");  
		strSQL = strSQL.concat("       SUM((CASE WHEN cns.seg_auto_tempoparada_sp_vr IS NULL THEN 0 ELSE cns.seg_auto_tempoparada_sp_vr END) + (CASE WHEN cns.seg_manu_tempoparada_sp_vr IS NULL THEN 0 ELSE cns.seg_manu_tempoparada_sp_vr END)) as tempoparspvr, ");

		strSQL = strSQL.concat("       SUM((CASE WHEN cns.pcs_auto_producaobruta IS NULL THEN 0 ELSE cns.pcs_auto_producaobruta END) + (CASE WHEN cns.pcs_manu_producaobruta IS NULL THEN 0 ELSE cns.pcs_manu_producaobruta END)) as qtdprodbruta, "); 
		strSQL = strSQL.concat("       SUM((CASE WHEN cns.pcs_auto_producaorefugada IS NULL THEN 0 ELSE cns.pcs_auto_producaorefugada END) + (CASE WHEN cns.pcs_manu_producaorefugada IS NULL THEN 0 ELSE cns.pcs_manu_producaorefugada END)) as qtdref ");

		strSQL = strSQL.concat("  FROM ms_upihm ui ");
		strSQL = strSQL.concat("  JOIN ms_ihm ihm ON (ihm.id_ihm = ui.id_ihm) ");
		strSQL = strSQL.concat("  JOIN ms_up up ON (up.id_up = ui.id_up AND up.st_ativo = 1)  ");
		strSQL = strSQL.concat("  JOIN om_pt pt ON (pt.cd_pt = up.cd_up AND pt.st_ativo = 1 AND pt.id_tppt = 1) ");
		strSQL = strSQL.concat("  LEFT JOIN dw_consolpt cpt ON (cpt.id_pt = pt.id_pt) "); 
		strSQL = strSQL.concat("  LEFT JOIN dw_consolid cid ON (cid.id_consolid = cpt.id_consolid_turno AND cid.tp_id = 1) ");
		strSQL = strSQL.concat("  LEFT JOIN dw_consol cns ON (cns.id_consolid = cid.id_consolid) ");
		strSQL = strSQL.concat("  LEFT JOIN dw_rt rt ON (rt.id_rt = cid.id_rt) ");
		strSQL = strSQL.concat("  LEFT JOIN pp_cp cp ON (cp.id_cp = pt.id_cp) ");
		strSQL = strSQL.concat("  LEFT JOIN pp_cpproduto cpp ON (cpp.id_cp = pt.id_cp) ");

		strSQL = strSQL.concat(" WHERE ihm.cd_ihm = :ihm "); 
		strSQL = strSQL.concat("   AND pt.tp_sessao IN (0, 1, 2)");
		strSQL = strSQL.concat(" GROUP BY pt.cd_pt, cp.cd_cp, cpp.nr_doc, rt.st_funcionamento, rt.is_offline, rt.is_semplanejamento ");
	 
		
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q.setParameter("ihm", cdIHM); 
		
		lista = q.list();		
		
		for (Object reg : lista) {
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			Indicadores indicador = new Indicadores();
			
			indicador.cdPt = (String) registroLido[_cdpt];		
			indicador.cdCp = "";
		


			
			if (registroLido[_semplanejamento] != null) {
				if (registroLido[_semplanejamento] instanceof Boolean) {
					indicador.semPlanejamento = (boolean) registroLido[_semplanejamento];
				} else {
					indicador.semPlanejamento = ConversaoTipos.converterParaBigDecimal(registroLido[_semplanejamento]).intValue() ==  0 ? false : true;		
				}
				
			} else {
				indicador.semPlanejamento = false;
			}
			
			if (indicador.semPlanejamento == false) {
				if (registroLido[_cdcp] != null) {
					//indicador.cdCp = (String) registroLido[_cdcp]; 					
					indicador.cdCp = (String) registroLido[_nrdoc]; 					
				}
			}
			
			
			if (registroLido[_offline] != null) {
				if (registroLido[_semplanejamento] instanceof Boolean) {
					indicador.offLine = (boolean) registroLido[_offline];					
				} else {
					indicador.offLine = ConversaoTipos.converterParaBigDecimal(registroLido[_offline]).intValue() ==  1 ? true : false;	
				} 
			} else {
				indicador.offLine = false;
			}

 

			if (registroLido[_stfuncionamento] != null) {
				indicador.stFuncionamento = ConversaoTipos.converterParaBigDecimal(registroLido[_stfuncionamento]).intValue();
			} else {
				indicador.stFuncionamento = 0;
			}
			
					
			if (indicador.semPlanejamento || indicador.offLine)  {
				indicador.segCicProd = BigDecimal.ZERO;
				indicador.segCicImprod = BigDecimal.ZERO;
				
				indicador.segRefugo = BigDecimal.ZERO;
				indicador.segRitmo = BigDecimal.ZERO;
				indicador.segPCI = BigDecimal.ZERO;
				
				indicador.segParCP = BigDecimal.ZERO;
				indicador.segParSP = BigDecimal.ZERO;
				indicador.segParCPVR = BigDecimal.ZERO;
				indicador.segParSPVR = BigDecimal.ZERO;
				
				indicador.prodBruta = BigDecimal.ZERO;
				indicador.prodRef = BigDecimal.ZERO;
			} else {
				indicador.segCicProd = ConversaoTipos.converterParaBigDecimal(registroLido[_segcicprod]);
				indicador.segCicImprod = ConversaoTipos.converterParaBigDecimal(registroLido[_segcicimprod]);
				
				indicador.segRefugo = ConversaoTipos.converterParaBigDecimal(registroLido[_segrefugo]);
				indicador.segRitmo = ConversaoTipos.converterParaBigDecimal(registroLido[_segritmo]);
				indicador.segPCI = ConversaoTipos.converterParaBigDecimal(registroLido[_segpci]);
				
				indicador.segParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_segparcp]);
				indicador.segParSP = ConversaoTipos.converterParaBigDecimal(registroLido[_segparsp]);
				indicador.segParCPVR = ConversaoTipos.converterParaBigDecimal(registroLido[_segparcpvr]);
				indicador.segParSPVR = ConversaoTipos.converterParaBigDecimal(registroLido[_segparspvr]);
				
				indicador.prodBruta = ConversaoTipos.converterParaBigDecimal(registroLido[_prodbruta]);
				indicador.prodRef = ConversaoTipos.converterParaBigDecimal(registroLido[_prodref]);				
			}

			
			// calcula indicadores com base em valores acumulados em indicadorTotal
			indicador.segBoas = FormulasInjet.calcularTempoBoas(indicador.segCicProd, indicador.segRefugo, indicador.segParCPVR, indicador.segParSPVR);
			indicador.segProdutivo = FormulasInjet.calcularTempoprodutivas(indicador.segBoas, indicador.segPCI, indicador.segRitmo);
			indicador.segDisponivel = FormulasInjet.calcularTempoAtivo(indicador.segCicProd, indicador.segParCP, indicador.segCicImprod, indicador.segParCPVR, indicador.segParSPVR);
			indicador.segTrabalhado = FormulasInjet.calcularTempoTrabalhado(indicador.segDisponivel, indicador.segParCP);
			
			indicador.oee = new BigDecimal(FormulasInjet.calcularOEE(indicador.segProdutivo, indicador.segDisponivel));  
			
			pt = new MaquinaIHMDTO();
			pt.setCdPt(indicador.cdPt);
			pt.setCdCp(indicador.cdCp);
			pt.setOee(indicador.oee.setScale(2, RoundingMode.HALF_UP));
			pt.setMetaOEE(metaOEE);
			pt.setStFuncionamento(indicador.stFuncionamento);
			pt.setOffLine(indicador.offLine ? 1 : 0);
			pt.setSemPlanejamento(indicador.semPlanejamento ? 1 : 0);
			
			retorno.add(pt);
		}	 
		q = null;
		lista = null; 
		 
	 	
		return retorno;
	}

	
	// indicadores da op associado ao pt 
	public MaquinaIHMDTO getConsultaIndicadoresOP(String cdPt) { 
		MaquinaIHMDTO retorno = new MaquinaIHMDTO();
		
		int _cp = 0;
		int _prodbruta = _cp + 1;
		int _prodref = _prodbruta + 1;
		int _prodplan = _prodref + 1;
		int _prodprev = _prodplan + 1; 
 		
 		String strSQL = "";
		SQLQuery q = null;
		
		retorno.setCdPt(cdPt);
		strSQL = "";
		strSQL = strSQL.concat("SELECT cp.cd_cp, pp.prodBrutaCP, pp.prodRefCP, pp.prodPlanCP, ");
		strSQL = strSQL.concat("       SUM((CASE WHEN cns.pcs_auto_producaoprevista IS NULL THEN 0 ELSE cns.pcs_auto_producaoprevista END) +  ");
		strSQL = strSQL.concat("           (CASE WHEN cns.pcs_manu_producaoprevista IS NULL THEN 0 ELSE cns.pcs_manu_producaoprevista END)) as prodprev "); 
		strSQL = strSQL.concat("  FROM dw_consolid cid "); 
		strSQL = strSQL.concat("  JOIN dw_consol cns ON (cns.id_consolid = cid.id_consolid) ");
		strSQL = strSQL.concat("  JOIN om_pt pt ON (pt.id_pt = cid.id_pt AND pt.id_cp = cid.id_cp) ");
		strSQL = strSQL.concat("  JOIN pp_cp cp ON (cp.id_cp = pt.id_cp) ");
		strSQL = strSQL.concat("  JOIN  (SELECT pp.id_cp,  ");
		strSQL = strSQL.concat("			 	SUM(CASE WHEN pp.pcs_producaoPlanejada IS NULL THEN 0 ELSE pp.pcs_producaoPlanejada END) as prodPlanCP, "); 
		strSQL = strSQL.concat("			 	SUM(CASE WHEN pp.pcs_producaoBruta IS NULL THEN 0 ELSE pp.pcs_producaoBruta END) as prodBrutaCP, "); 
		strSQL = strSQL.concat("			 	SUM(CASE WHEN pp.pcs_producaorefugada IS NULL THEN 0 ELSE pp.pcs_producaorefugada END) as prodRefCP ");
		strSQL = strSQL.concat("		   FROM pp_cpproduto pp ");
		strSQL = strSQL.concat("		   JOIN om_pt pt ON (pt.id_cp = pp.id_cp) "); 
		strSQL = strSQL.concat("		  WHERE pt.cd_pt = :cdpt ");
		strSQL = strSQL.concat("		    AND pt.st_ativo = 1 ");
		strSQL = strSQL.concat("		  GROUP BY pp.id_cp) pp ON (pp.id_cp = cp.id_cp) ");
		strSQL = strSQL.concat(" WHERE pt.cd_pt = :cdpt ");
		strSQL = strSQL.concat("   AND pt.st_ativo = 1 ");
		strSQL = strSQL.concat("   AND cid.tp_id = 1 ");
		strSQL = strSQL.concat(" GROUP BY cp.cd_cp, pp.prodBrutaCP, pp.prodRefCP, pp.prodPlanCP ");
 
		q = this.getDaoSession().createSQLQuery(strSQL);
		q.setParameter("cdpt", cdPt);
		q.setMaxResults(1);
		Object reg = q.uniqueResult(); 
		
		if (reg != null) {			
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			retorno.setCdCp((String) registroLido[_cp]); ;
			retorno.setProdBruta(ConversaoTipos.converterParaBigDecimal(registroLido[_prodbruta]));
			retorno.setProdRef(ConversaoTipos.converterParaBigDecimal(registroLido[_prodref]));
			retorno.setProdPlan(ConversaoTipos.converterParaBigDecimal(registroLido[_prodplan]));
			retorno.setProdPrev(ConversaoTipos.converterParaBigDecimal(registroLido[_prodprev]));
			retorno.setProdLiq(AritmeticaUtil.diminuir(retorno.getProdBruta(), retorno.getProdRef()));
			retorno.setProdFaltante(AritmeticaUtil.diminuir(retorno.getProdPlan(), retorno.getProdLiq()));
 			retorno.setIndRef(ConversaoTipos.converterParaBigDecimal(FormulasInjet.calcularIndiceRefugo(retorno.getProdRef(), retorno.getProdBruta())));
 			retorno.setEfiRea(ConversaoTipos.converterParaBigDecimal(FormulasInjet.calcularEficienciaRealizacao(retorno.getProdLiq(), retorno.getProdPrev())));
			
			retorno.setProdBruta(retorno.getProdBruta().setScale(0, RoundingMode.HALF_UP)); 
			retorno.setProdRef(retorno.getProdRef().setScale(0, RoundingMode.HALF_UP)); 
			retorno.setProdPlan(retorno.getProdPlan().setScale(0, RoundingMode.HALF_UP)); 
			retorno.setProdPrev(retorno.getProdPrev().setScale(0, RoundingMode.HALF_UP)); 
			retorno.setProdLiq(retorno.getProdLiq().setScale(0, RoundingMode.HALF_UP)); 
			retorno.setProdFaltante(retorno.getProdFaltante().setScale(0, RoundingMode.HALF_UP)); 
			retorno.setIndRef(retorno.getIndRef().setScale(2, RoundingMode.HALF_UP)); 
			retorno.setEfiRea(retorno.getEfiRea().setScale(2, RoundingMode.HALF_UP)); 			
		} else {
			retorno.setCdCp(""); ;
			retorno.setProdBruta(BigDecimal.ZERO);
			retorno.setProdRef(BigDecimal.ZERO);
			retorno.setProdPlan(BigDecimal.ZERO);
			retorno.setProdPrev(BigDecimal.ZERO);
			retorno.setProdLiq(BigDecimal.ZERO);
			retorno.setProdFaltante(BigDecimal.ZERO);
 			retorno.setIndRef(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
 			retorno.setEfiRea(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
		}
		
		q = null;

		return retorno;
	}



	// indicadores da hora atual associado ao pt 
	@SuppressWarnings("deprecation")
	public MaquinaIHMDTO getConsultaIndicadoresHora(String cdPt) { 
		MaquinaIHMDTO retorno = new MaquinaIHMDTO();
		
		int _inihora = 0;
		int _prodprev = _inihora + 1; 
		int _prodbruta = _prodprev + 1;
		int _prodref = _prodbruta + 1;
		
 		String strSQL = "";
		SQLQuery q = null;
		
		retorno.setCdPt(cdPt);
		strSQL = "";
		strSQL = strSQL.concat("SELECT cid.dthr_ihora,  ");
		strSQL = strSQL.concat("       SUM((CASE WHEN cns.pcs_auto_producaoprevista IS NULL THEN 0 ELSE cns.pcs_auto_producaoprevista END) + (CASE WHEN cns.pcs_manu_producaoprevista IS NULL THEN 0 ELSE cns.pcs_manu_producaoprevista END))as prodprev, ");
		strSQL = strSQL.concat("       SUM((CASE WHEN cns.pcs_auto_producaobruta IS NULL THEN 0 ELSE cns.pcs_auto_producaobruta END) + (CASE WHEN cns.pcs_manu_producaobruta IS NULL THEN 0 ELSE cns.pcs_manu_producaobruta END)) as qtdprodbruta, "); 
		strSQL = strSQL.concat("       SUM((CASE WHEN cns.pcs_auto_producaorefugada IS NULL THEN 0 ELSE cns.pcs_auto_producaorefugada END) + (CASE WHEN cns.pcs_manu_producaorefugada IS NULL THEN 0 ELSE cns.pcs_manu_producaorefugada END)) as qtdref ");
		strSQL = strSQL.concat("  FROM om_pt pt ");
		strSQL = strSQL.concat("  JOIN dw_consolpt cpt ON (cpt.id_pt = pt.id_pt) ");
		strSQL = strSQL.concat("  JOIN dw_consolid cid ON (cid.id_consolid = cpt.id_consolid_hora AND cid.tp_id = 0) ");
		strSQL = strSQL.concat("  JOIN dw_consol cns ON (cns.id_consolid = cid.id_consolid)   ");
		strSQL = strSQL.concat(" WHERE pt.cd_pt = :cdpt ");
		strSQL = strSQL.concat("   AND pt.st_ativo = 1 "); 
		strSQL = strSQL.concat(" GROUP BY cid.dthr_ihora");
 
		q = this.getDaoSession().createSQLQuery(strSQL);
		q.setParameter("cdpt", cdPt); 
		q.setMaxResults(1);
		Object reg = q.uniqueResult(); 
		
		if (reg != null) {			
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			retorno.setProdBruta(ConversaoTipos.converterParaBigDecimal(registroLido[_prodbruta]));
			retorno.setProdRef(ConversaoTipos.converterParaBigDecimal(registroLido[_prodref]));
			retorno.setProdPrev(ConversaoTipos.converterParaBigDecimal(registroLido[_prodprev]));
			retorno.setProdLiq(AritmeticaUtil.diminuir(retorno.getProdBruta(), retorno.getProdRef()));
			retorno.setEfiRea(ConversaoTipos.converterParaBigDecimal(FormulasInjet.calcularEficienciaRealizacao(retorno.getProdLiq(), retorno.getProdPrev())));
			
			retorno.setProdBruta(retorno.getProdBruta().setScale(0, RoundingMode.HALF_UP)); 
			retorno.setProdRef(retorno.getProdRef().setScale(0, RoundingMode.HALF_UP)); 
			retorno.setProdPrev(retorno.getProdPrev().setScale(0, RoundingMode.HALF_UP)); 
			retorno.setProdLiq(retorno.getProdLiq().setScale(0, RoundingMode.HALF_UP)); 
			retorno.setEfiRea(retorno.getEfiRea().setScale(2, RoundingMode.HALF_UP));  		
		} else {			
			retorno.setProdBruta(BigDecimal.ZERO); 
			retorno.setProdRef(BigDecimal.ZERO); 
			retorno.setProdPrev(BigDecimal.ZERO); 
			retorno.setProdLiq(BigDecimal.ZERO); 
			retorno.setEfiRea(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
		}
		
 
		q = null;

		return retorno;
	}


	// indicadores do turno atual
	public MaquinaIHMDTO getConsultaIndicadoresTurnoAtual(String cdPt) throws ParseException { 
		MaquinaIHMDTO retorno = new MaquinaIHMDTO();
 
	 	TurnoDTO turnoAtual = getUltimoTurnoPt(cdPt);		
		retorno = getConsultaIndicadoresTurno(DataHoraRN.stringToDate(turnoAtual.getDtRefYMD(), "yyyy-MM-dd"), ((Long) turnoAtual.getIdTurno()).intValue(), cdPt);
		
		return retorno;
	}
	
	
	private TurnoDTO getUltimoTurnoPt(String cdPt) {
		TurnoDTO turno = null;
		
		int _dtref = 0;
		int _idtur = _dtref + 1; 
		int _idcal = _idtur + 1;
		
 		
 		String strSQL = "";
		SQLQuery q = null;
		
		strSQL = "";
		strSQL = strSQL.concat("SELECT cid.dt_referencia, cid.id_turno, cid.id_cal ");
		strSQL = strSQL.concat("  FROM om_pt pt ");
		strSQL = strSQL.concat("  JOIN dw_consolpt cpt ON (cpt.id_pt = pt.id_pt) ");
		strSQL = strSQL.concat("  JOIN dw_consolid cid ON (cid.id_consolid = cpt.id_consolid_turno AND cid.tp_id = 1)  ");
		strSQL = strSQL.concat(" WHERE pt.cd_pt = :cdpt ");
		strSQL = strSQL.concat("   AND pt.st_ativo = 1 "); 
 
		q = this.getDaoSession().createSQLQuery(strSQL);
		q.setParameter("cdpt", cdPt); 
		
		q.setMaxResults(1);
		Object reg = q.uniqueResult(); 
		
		if (reg != null) {			
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			Date dtTur = (Date) registroLido[_dtref];
			turno = new TurnoDTO();
			turno.setDtReferencia (converterParaString(dtTur));
			turno.setDtRefYMD(DataHoraRN.toStringYYYYMMDD(dtTur));
			turno.setDtRefTimestamp(dtTur.getTime());		
			turno.setIdTurno(ConversaoTipos.converterParaBigDecimal(registroLido[_idtur]).longValue());
			turno.setIdCal(ConversaoTipos.converterParaBigDecimal(registroLido[_idcal]).longValue());
		} else {
			turno = null;
		}
		
		return turno;
	}
	
	// indicadores do turno anterior
	public MaquinaIHMDTO getConsultaIndicadoresTurnoAnterior(String cdPt) throws ParseException, SemCalendarioException { 
		MaquinaIHMDTO retorno = new MaquinaIHMDTO();
		
		OmPtDAO omptDao = new OmPtDAO(getDaoSession());
		OmPt omPt = omptDao.getOmPtPorCdAtivoOrderById(cdPt);
		
		TurnoDTO turno = getUltimoTurnoPt(cdPt);
		
		TurnoRN turnoRN = new TurnoRN(getDao());	 
		TurnoAtualDTO turnoDTO = turnoRN.getTurnoAtualDTOPassandoIdPtEDtTurnoEIdTurno(omPt, DataHoraRN.toDateFrom("yyyy-MM-dd", turno.getDtRefYMD()), turno.getIdTurno());
				
		TurnoAtualDTO turnoAnterior = turnoRN.getTurnoAnteriorDTOPassandoIdPtEDtTurnoEIdTurno(
						omPt, 
						DataHoraRN.toDateFrom("dd/MM/yyyy", turno.getDtReferencia()),  
						turno.getIdTurno(), 
						turnoDTO);

		retorno = getConsultaIndicadoresTurno(turnoAnterior.getDtReferencia(), ((Long) turnoAnterior.getIdTurno()).intValue(), cdPt);
		
		turnoRN = null;
		return retorno;
	}
	
	
	// indicadores da data/turno associado ao pt 
	public MaquinaIHMDTO getConsultaIndicadoresTurno(Date dtRef, int idTurno, String cdPt) { 
		MaquinaIHMDTO retorno = new MaquinaIHMDTO();
		
		int _dtref = 0;
		int _idtur = _dtref + 1;
		int _prodprev = _idtur + 1; 
		int _prodbruta = _prodprev + 1;
		int _prodref = _prodbruta + 1;
		int _tempoparcp = _prodref + 1;
		int _tempoparsp = _tempoparcp + 1;
		
 		
 		String strSQL = "";
		SQLQuery q = null;
		
		retorno.setCdPt(cdPt);
		strSQL = "";
		strSQL = strSQL.concat("SELECT cid.dt_referencia, cid.id_turno, ");
		strSQL = strSQL.concat("       SUM((CASE WHEN cns.pcs_auto_producaoprevista IS NULL THEN 0 ELSE cns.pcs_auto_producaoprevista END) + (CASE WHEN cns.pcs_manu_producaoprevista IS NULL THEN 0 ELSE cns.pcs_manu_producaoprevista END))as prodprev, ");
		strSQL = strSQL.concat("       SUM((CASE WHEN cns.pcs_auto_producaobruta IS NULL THEN 0 ELSE cns.pcs_auto_producaobruta END) + (CASE WHEN cns.pcs_manu_producaobruta IS NULL THEN 0 ELSE cns.pcs_manu_producaobruta END)) as qtdprodbruta, "); 
		strSQL = strSQL.concat("       SUM((CASE WHEN cns.pcs_auto_producaorefugada IS NULL THEN 0 ELSE cns.pcs_auto_producaorefugada END) + (CASE WHEN cns.pcs_manu_producaorefugada IS NULL THEN 0 ELSE cns.pcs_manu_producaorefugada END)) as qtdref, ");
		strSQL = strSQL.concat("       SUM((CASE WHEN cns.seg_auto_tempoparada_cp IS NULL THEN 0 ELSE cns.seg_auto_tempoparada_cp END) + (CASE WHEN cns.seg_manu_tempoparada_cp IS NULL THEN 0 ELSE cns.seg_manu_tempoparada_cp END)) as tempoparcp, ");
		strSQL = strSQL.concat("       SUM((CASE WHEN cns.seg_auto_tempoparada_sp IS NULL THEN 0 ELSE cns.seg_auto_tempoparada_sp END) + (CASE WHEN cns.seg_manu_tempoparada_sp IS NULL THEN 0 ELSE cns.seg_manu_tempoparada_sp END)) as tempoparsp ");
		strSQL = strSQL.concat("  FROM dw_consolid cid ");
		strSQL = strSQL.concat("  JOIN dw_consol cns ON (cns.id_consolid = cid.id_consolid) ");
		strSQL = strSQL.concat("  JOIN om_pt pt ON (pt.id_pt = cid.id_pt AND pt.id_cp = cid.id_cp) ");
		strSQL = strSQL.concat(" WHERE pt.cd_pt = :cdpt ");
		strSQL = strSQL.concat("   AND pt.st_ativo = 1 ");
		strSQL = strSQL.concat("   AND cid.tp_id = 1 ");
		strSQL = strSQL.concat("   AND cid.dt_referencia = :dtturno "); 
		strSQL = strSQL.concat("   AND cid.id_turno = :idturno ");
		strSQL = strSQL.concat(" GROUP BY cid.dt_referencia, cid.id_turno ");
 
		q = this.getDaoSession().createSQLQuery(strSQL);
		q.setParameter("cdpt", cdPt);
		q.setTimestamp("dtturno", dtRef);
		q.setParameter("idturno", idTurno);
		
		q.setMaxResults(1);
		Object reg = q.uniqueResult(); 
		
		if (reg != null) {			
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			retorno.setProdBruta(ConversaoTipos.converterParaBigDecimal(registroLido[_prodbruta]));
			retorno.setProdRef(ConversaoTipos.converterParaBigDecimal(registroLido[_prodref]));
			retorno.setProdPrev(ConversaoTipos.converterParaBigDecimal(registroLido[_prodprev]));
			retorno.setProdLiq(AritmeticaUtil.diminuir(retorno.getProdBruta(), retorno.getProdRef()));
			retorno.setEfiRea(ConversaoTipos.converterParaBigDecimal(FormulasInjet.calcularEficienciaRealizacao(retorno.getProdLiq(), retorno.getProdPrev())));
 			retorno.setIndRef(ConversaoTipos.converterParaBigDecimal(FormulasInjet.calcularIndiceRefugo(retorno.getProdRef(), retorno.getProdBruta())));
 			retorno.setTempoParCP(ConversaoTipos.converterParaBigDecimal(registroLido[_tempoparcp]));
 			retorno.setTempoParSP(ConversaoTipos.converterParaBigDecimal(registroLido[_tempoparsp]));
 			retorno.setTempoPar(AritmeticaUtil.somar(retorno.getTempoParCP(), retorno.getTempoParSP()));
 			
			retorno.setTempoParCP(null);
			retorno.setTempoParSP(null);
			
			retorno.setProdBruta(retorno.getProdBruta().setScale(0, RoundingMode.HALF_UP)); 
			retorno.setProdRef(retorno.getProdRef().setScale(0, RoundingMode.HALF_UP)); 
			retorno.setProdLiq(retorno.getProdLiq().setScale(0, RoundingMode.HALF_UP)); 
			retorno.setProdPrev(retorno.getProdPrev().setScale(0, RoundingMode.HALF_UP)); 
			retorno.setEfiRea(retorno.getEfiRea().setScale(2, RoundingMode.HALF_UP));  		
			retorno.setIndRef(retorno.getIndRef().setScale(2, RoundingMode.HALF_UP));  		
			retorno.setTempoPar(retorno.getTempoPar().setScale(0, RoundingMode.HALF_UP)); 
			retorno.setTempoParFormatado(DataHoraRN.formatSegundosParaHHMMSS(retorno.getTempoPar()));
		} else {
			retorno.setProdBruta(BigDecimal.ZERO);
			retorno.setProdRef(BigDecimal.ZERO);
			retorno.setProdPrev(BigDecimal.ZERO);
			retorno.setProdLiq(BigDecimal.ZERO);
			retorno.setEfiRea(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
 			retorno.setIndRef(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
 			retorno.setTempoParCP(BigDecimal.ZERO);
 			retorno.setTempoParSP(BigDecimal.ZERO);
 			retorno.setTempoPar(BigDecimal.ZERO);  
			retorno.setTempoParFormatado("");
		}
		
 
		q = null;

		return retorno;
	}


	public List<AlertaOcorDTO> getAlertasAbertos(String cdPt) { 
		List<AlertaOcorDTO> retorno = new ArrayList<AlertaOcorDTO>();
				
		AlertaRN aRN = new AlertaRN(getDao());
		List<DwConsolallog> lista = aRN.getAlertasDTOAbertosByCdPt(cdPt);
		for (DwConsolallog oco : lista) {
			AlertaOcorDTO alerta = new AlertaOcorDTO();
			alerta.setCdAlerta(oco.getDwTAlerta().getCdTalerta());
			alerta.setDsAlerta(oco.getDwTAlerta().getDsTalerta()); 
			alerta.setDtHrIniAlertaMs(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(oco.getDthrIalerta())); 
			
			retorno.add(alerta);
		}
		
		aRN = null;
		
		return retorno;
	}

	public List<LoginOcorDTO> getLoginsAbertos(String cdPt) { 
		Date dthrAtu = DataHoraRN.getDataHoraAtual();
		Integer duracao = 0;
		
		List<LoginOcorDTO> retorno = new ArrayList<LoginOcorDTO>();
		OmPtDAO ptDao = new OmPtDAO(getDaoSession());
		OmPt pt = ptDao.getOmPtAtivoComUltimaRevisao(cdPt);
		
		List<DwConsolmolog> lista = getOperadoresLogados(null, pt);
		for (DwConsolmolog oco : lista) {
			duracao = DataHoraRN.getQuantidadeSegundosNoPeriodoTrantandoNulo(oco.getDthrIlogin(), dthrAtu);
			
			LoginOcorDTO reg = new LoginOcorDTO();
			reg.setCdUsr(oco.getOmUsr().getCdUsr());
			reg.setNmUsr(oco.getOmUsr().getDsNome()); 
			reg.setDthrLoginMs(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(oco.getDthrIlogin())); 
			reg.setTempoLogado(duracao.longValue());
			reg.setTempoLogadoHMS(DataHoraRN.formatSegundosParaHHMMSS(duracao));
			retorno.add(reg);
		}
		
		ptDao = null;
		pt = null;
		
		return retorno;
	}

	public RefugoOcorDTO getUltimoRefugo(String cdPt) { 		
		RefugoOcorDTO retorno = new RefugoOcorDTO();
		
		OmPtDAO ptDao = new OmPtDAO(getDaoSession());
		IhmMobileRN rnIHM = new IhmMobileRN(getDao());
		
		OmPt pt = ptDao.getOmPtAtivoComUltimaRevisao(cdPt); 
		
		DwConsolrelog ocor = rnIHM.getUltimoRefugoPt(pt);
		if (ocor != null) {
			retorno.setCdRefugo(ocor.getDwTRefugo().getCdTrefugo());
			retorno.setDsRefugo(ocor.getDwTRefugo().getDsTrefugo());
			retorno.setCdProduto(ocor.getOmProduto().getCdProduto());
			retorno.setDsProduto(ocor.getOmProduto().getDsProduto());
			retorno.setQtdRef(ocor.getPcsProducaorefugada().intValue()); 
			retorno.setDthrRefugoMs(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(ocor.getDthrRefugo()));
			
		} else {
			retorno.setCdRefugo("");
			retorno.setDsRefugo("");
			retorno.setCdProduto("");
			retorno.setDsProduto("");
			retorno.setQtdRef(0); 
			retorno.setDthrRefugoMs("");
		}
		
		rnIHM = null; 
		ptDao = null;
		pt = null; 
		
		return retorno;
	}
	
	public ParadaOcorDTO getUltimaParada(String cdPt) { 		
		ParadaOcorDTO retorno = new ParadaOcorDTO();
		
		OmPtDAO ptDao = new OmPtDAO(getDaoSession());
		IhmMobileRN rnIHM = new IhmMobileRN(getDao());
		
		OmPt pt = ptDao.getOmPtAtivoComUltimaRevisao(cdPt); 
		
		DwConsolpalog ocor = rnIHM.getUltimaParadaPt(pt);
		if (ocor != null) {
			Date dthrIni = ocor.getDthrIparada();
			Date dthrFim = ocor.getDthrFparada();
			Integer duracaoPar = 0;

			
			retorno.setCdParada(ocor.getDwTParada().getCdTparada());
			retorno.setDsParada(ocor.getDwTParada().getDsTparada());
			retorno.setCdCp(ocor.getPpCp().getCdCp());
			
			try {
				retorno.setCdFerramenta(ocor.getPpCp().getDwFolha().getDwFolharaps().iterator().next().getDwRap().getCdRap());				
			} catch (Exception e) {
				retorno.setCdFerramenta("-");
			}
			
			retorno.setDtHrIniParMs(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(ocor.getDthrIparada()));
		
			if (dthrFim == null) {
				dthrFim = DataHoraRN.getDataHoraAtual(); 
				retorno.setDtHrFimParMs("");
				retorno.setParadaAberta(true);
			} else {
				retorno.setDtHrFimParMs(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dthrFim));	
				retorno.setParadaAberta(false);
			}
			
			duracaoPar = DataHoraRN.getQuantidadeSegundosNoPeriodo(dthrIni, dthrFim);			
			retorno.setDuracaoPar(duracaoPar);
			retorno.setDuracaoParHMS(DataHoraRN.formatSegundosParaHHMMSS(duracaoPar));
			
		} else {
			retorno.setCdParada("");
			retorno.setDsParada("");
			retorno.setCdCp("");
			retorno.setCdFerramenta("");
			retorno.setDtHrIniParMs("");
			retorno.setDtHrFimParMs("");
			retorno.setParadaAberta(false);
			retorno.setDuracaoPar(0);
			retorno.setDuracaoParHMS("");
		}
		
		rnIHM = null; 
		ptDao = null;
		pt = null; 
		
		return retorno;
	}
	
	
	public int OmImgToIdPtNIDW(OmImg img) {
		int retorno = TipoPostoNIDW.SEM_USO.getValor();
		
		if (img.getDsImg().toUpperCase().equals("EMBALADORA")) {
			retorno = TipoPostoNIDW.EMBALADORA.getValor();
			
		} else if (img.getDsImg().toUpperCase().equals("ENVASADORA")) {
			retorno = TipoPostoNIDW.ENVASADORA.getValor();
			
		} else if (img.getDsImg().toUpperCase().equals("FURADEIRA")) {
			retorno = TipoPostoNIDW.FURADEIRA.getValor();
			
		} else if (img.getDsImg().toUpperCase().equals("GALVA_48X48")) {
			retorno = TipoPostoNIDW.GALVANOPLASTIA.getValor();
			
		} else if (img.getDsImg().toUpperCase().contains("INJETORA")) {
			retorno = TipoPostoNIDW.INJETORA.getValor();
			
		} else if (img.getDsImg().toUpperCase().equals("LINER_48X48")) {
			retorno = TipoPostoNIDW.LINER.getValor();
			
		} else if (img.getDsImg().toUpperCase().equals("LINHA")) {
			retorno = TipoPostoNIDW.LINHA.getValor();
			
		} else if (img.getDsImg().toUpperCase().equals("NAVIO_48X48")) {
			retorno = TipoPostoNIDW.NAVIO.getValor();
			
		} else if (img.getDsImg().toUpperCase().equals("PRENSA")) {
			retorno = TipoPostoNIDW.PRENSA.getValor();
			
		} else if (img.getDsImg().toUpperCase().equals("ROB??") || img.getDsImg().toUpperCase().equals("ROBÔ")) {
			retorno = TipoPostoNIDW.ROBO.getValor();
			
		} else if (img.getDsImg().toUpperCase().equals("ROTULADORA")) {
			retorno = TipoPostoNIDW.ROTULADORA.getValor();
			
		} else if (img.getDsImg().toUpperCase().equals("SLITTER_48X48")) {
			retorno = TipoPostoNIDW.SLITTER.getValor();
			
		} else if (img.getDsImg().toUpperCase().equals("SOPRADORA")) {
			retorno = TipoPostoNIDW.SOPRADORA.getValor();
			
		} else if (img.getDsImg().toUpperCase().equals("TOP_48X48")) {
			retorno = TipoPostoNIDW.TOP.getValor();
			
		} else if (img.getDsImg().toUpperCase().equals("TORNO_48X48")) {
			retorno = TipoPostoNIDW.TORNO.getValor();
			
		} else if (img.getDsImg().toUpperCase().equals("USI_48X48")) {
			retorno = TipoPostoNIDW.USINAGEM.getValor();
			
		} else if (img.getDsImg().toUpperCase().contains("FORNO_HELLER")) {
			retorno = TipoPostoNIDW.FORNO.getValor();
			
		} else {
			retorno = TipoPostoNIDW.SMD.getValor();
		} 		
		
		return retorno;
	}
}
