package idw.model.rn.web.injet.monitorizacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import idw.model.dao.DAOGenerico;
import idw.model.dao.OmGtDAO;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.OmGt;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.pojos.template.OmObjTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.FuncoesApoioInjet;
import idw.model.rn.injet.TurnoInjetDTO;
import idw.model.rn.injet.TurnoInjetRN;
import idw.model.rn.monitorizacao.injet.MonitorizacaoInjetRN;
import idw.model.rn.monitorizacao.injet.MonitorizacaoVisaoMaquinaInjetRN;
import idw.model.rn.monitorizacao.web.imagem.MonitorizacaoIcone;
import idw.model.rn.monitorizacao.web.imagem.MonitorizacaoIconeFactory;
import idw.webservices.dto.GtRtDTO;
import idw.webservices.dto.GtRtMonitorizacaoDTO;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;
import idw.webservices.dto.PeriodoDTO;
import idw.webservices.rest.dto.GtDTO;
import idw.webservices.rest.dto.TurnoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalhePostoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.MonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.OperadorDTO;
import idw.webservices.rest.dto.monitorizacao.PtIconeDTO;
import idw.webservices.rest.dto.monitorizacao.PtIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.PtMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.PtParadaResumoDTO;
import idw.webservices.rest.injet.GtResource;
import ms.util.ConversaoTipos;

public class MonitorizacaoInjetWebRN extends MonitorizacaoInjetRN {
	
	public static final double TAMANHO_PIXEL_MAXIMO_LINHA = 50;
	
	private Map<Integer, Double> mapLinha = new HashMap<Integer, Double>();
	private Map<Integer, List<ObjRtMonitorizacaoDTO>> mapLinhaObj = new HashMap<Integer, List<ObjRtMonitorizacaoDTO>>();
	
	private MonitorizacaoIconeFactory iconeFactory = new MonitorizacaoIconeFactory();
	
	private final String formatoData;
	private final String formatoDataHora;
	
	private MonitorizacaoVisaoMaquinaInjetRN monitorizacaoVisaoMaquinaRN;
	private TurnoInjetRN turnoInjetRN;
	
	public MonitorizacaoInjetWebRN(String formatoData, String formatoDataHora) {
		super();
		this.formatoData = formatoData;
		this.formatoDataHora = formatoDataHora;
	}

	public MonitorizacaoInjetWebRN(DAOGenericoInjet dao, String formatoData, String formatoDataHora) {
		super(dao);
		this.formatoData = formatoData;
		this.formatoDataHora = formatoDataHora;
		monitorizacaoVisaoMaquinaRN = new MonitorizacaoVisaoMaquinaInjetRN(getDao());
		//turnoRN = new TurnoRN(getDao());
		turnoInjetRN = new TurnoInjetRN(dao);
	}
	
	public MonitorizacaoDTO getMonitorizacao(FiltroMonitorizacaoDTO filtroMonitorizacao) {
		OmGtDAO omGtDAO = new OmGtDAO(getDaoSession());
		OmGt omGt = omGtDAO.getOmGtPorCdAtivoOrderByIdInjet(getDao(), filtroMonitorizacao.getCdGt());
		
		DAOGenerico daoVF = new DAOGenerico();
		daoVF.iniciaSessao();
		GtRtMonitorizacaoDTO dto = 
				monitorizacaoVisaoMaquinaRN.getTelaMonitorizacaoMaquina(daoVF,
						getFiltroGt(filtroMonitorizacao, omGt), 
						DwConsolidTemplate.TpId.TURNO);
						
		MonitorizacaoDTO monitorizacaoDTO = new MonitorizacaoDTO();
		
		//filtrando. Pegando apenas icone do tipo posto
		List<ObjRtMonitorizacaoDTO> ptsObj = new ArrayList<ObjRtMonitorizacaoDTO>();
		
		for(ObjRtMonitorizacaoDTO obj : dto.getObjsRtMonitorizacaoDTO().getObjsRtMonitorizacao()) {			
			if(obj.getTipoObj() == OmObjTemplate.TpObj.TIPO_OBJ_PT.getValue()) {
				ptsObj.add(obj);
			}			
		}
		
		List<PtMonitorizacaoDTO> pts = getPostosOrdenados(ptsObj);
				
		if(omGt != null) {
			GtDTO omGtDTO = GtResource.converterGtPojoParaDTO(omGt);
			monitorizacaoDTO.setGt(omGtDTO);
		}
		monitorizacaoDTO.setPts(pts);
		
		filtroMonitorizacao.setListaFiltroPosto(getListaFiltroPosto(filtroMonitorizacao, pts));
		monitorizacaoDTO.setFiltro(filtroMonitorizacao);
		
		daoVF.finalizaSessao();
		
		return monitorizacaoDTO;
	}
	
	private List<FiltroDetalhePostoDTO> getListaFiltroPosto(FiltroMonitorizacaoDTO filtroMonitorizacao, List<PtMonitorizacaoDTO> postos) {
		List<FiltroDetalhePostoDTO> filtros = new ArrayList<FiltroDetalhePostoDTO>();
		
		for(PtMonitorizacaoDTO posto : postos) {
			FiltroDetalhePostoDTO filtro = new FiltroDetalhePostoDTO();
			
			filtro.setCdCp(posto.getFiltroCdCp());
			filtro.setCdPosto(posto.getCdPt());
			filtro.setDtReferencia(filtroMonitorizacao.getDtReferencia());
			filtro.setFiltroOp(filtroMonitorizacao.getFiltroOp());
			filtro.setIdTurno(filtroMonitorizacao.getIdTurno());
			filtro.setTpId(DwConsolidTemplate.TpId.TURNO.getValue());
			filtro.setTipoPosto(posto.getTipoPosto());
			
			filtros.add(filtro);
		}
		
		return filtros;
	}
			
	private List<PtMonitorizacaoDTO> getPostosOrdenados(List<ObjRtMonitorizacaoDTO> objs) {
		this.mapLinha = new HashMap<Integer, Double>();
		this.mapLinhaObj = new HashMap<Integer, List<ObjRtMonitorizacaoDTO>>();
		
		gerarLinhasVirtuais(objs);
		return getPostosFormatadosENumerados();
	}
	
	private void gerarLinhasVirtuais(List<ObjRtMonitorizacaoDTO> objs) {
		int linhaCount = 1;
		
		for(ObjRtMonitorizacaoDTO obj : objs) {
			
			boolean salvo = false;
			for(Integer linha : mapLinha.keySet()) {
				double min = mapLinha.get(linha);
				double max = min + TAMANHO_PIXEL_MAXIMO_LINHA;
				if(obj.getX() >= min && obj.getX() <= max) {
					add(linha, obj);
					salvo = true;
					break;
				}
			}
			
			if(!salvo) {
				mapLinha.put(linhaCount, obj.getX());
				add(linhaCount, obj);
				linhaCount++;
			}
		}
	}
	
	private void add(Integer linha, ObjRtMonitorizacaoDTO obj) {
		if(mapLinhaObj.get(linha) == null) {
			mapLinhaObj.put(linha, new ArrayList<ObjRtMonitorizacaoDTO>());
		}
		mapLinhaObj.get(linha).add(obj);
	}
		
	private List<PtMonitorizacaoDTO> getPostosFormatadosENumerados() {
		List<PtMonitorizacaoDTO> postos = new ArrayList<PtMonitorizacaoDTO>();
		
		int ordem = 1;
		SortedSet<Integer> keys = new TreeSet<Integer>(mapLinhaObj.keySet());
		for(Integer chave : keys) {
			
			List<ObjRtMonitorizacaoDTO> lista = mapLinhaObj.get(chave);
			for(ObjRtMonitorizacaoDTO obj : lista) {
				PtMonitorizacaoDTO posto = getPtDTO(obj);
				posto.setOrdem(ordem);
				postos.add(posto);
				ordem += 1;
			}			
		}
		
		return postos;
	}
		
	private GtRtDTO getFiltroGt(FiltroMonitorizacaoDTO filtroMonitorizacao, OmGt omGt) {
		GtRtDTO filtro = new GtRtDTO();
		filtro.setDtReferencia(DataHoraRN.stringToDate(filtroMonitorizacao.getDtReferencia(), formatoData));
		filtro.setDwTurno(turnoInjetRN.getDwTurnoPorIdInjet(filtroMonitorizacao.getIdTurno()));
		filtro.setFiltroOP(filtroMonitorizacao.getFiltroOp());		
		
		filtro.setGtDTO(new idw.webservices.dto.GtDTO());
		filtro.getGtDTO().setGt(omGt);
		
		filtro.setIdPt(null);
		filtro.setIsTurnoAtual(filtroMonitorizacao.isTurnoAtual());
		return filtro;
	}
	
	private PtMonitorizacaoDTO getPtDTO(ObjRtMonitorizacaoDTO obj) {
		
		/*
		int i=0;
		if(obj.getCdPt().equals("INJ_off_5526")){
			i=1;
		}
		*/
		
		
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
		ptDTO.setFiltroCdCp( obj.getCdCp() == null ? "" : obj.getCdCp() );
		ptDTO.setOpSelecionada(obj.getUltimaOp());
		ptDTO.setIcone(iconeDTO);
		ptDTO.setIndicadores(indicadoresDTO);
		
		ptDTO.setOperadores(new ArrayList<OperadorDTO>());
		for(DwConsolmolog log : obj.getDwConsolmologs()) {
			OperadorDTO operadorDTO = new OperadorDTO();
			operadorDTO.setCdUsr(log.getOmUsr().getCd());
			operadorDTO.setLogin(log.getOmUsr().getLogin());
			operadorDTO.setDsApelido(log.getOmUsr().getDsApelido());
			operadorDTO.setDsNome(log.getOmUsr().getDsNome());
			ptDTO.getOperadores().add(operadorDTO);
		}	
		
		PtParadaResumoDTO paradaResumo = new PtParadaResumoDTO();
		if (obj!= null && obj.getUltimaParada() != null)
			paradaResumo.setUltimaParada(obj.getUltimaParada());
		if (obj!= null && obj.getDuracaoParada() != null)
			paradaResumo.setTempoParada(obj.getDuracaoParada());
		// paradaResumo.setDataInicio(obj.getIniParada());
		// paradaResumo.setIndiceParada(obj.getIndiceParadas());
		ptDTO.setParadaResumo(paradaResumo);
		
		return ptDTO;
	}
	
	private String converteParaString(Double valor) {
		if(valor == null) {
			return "0.00";
		}
		return ConversaoTipos.converteParaString(valor, 2);
	}
	
	private String converterParaString(Date data) {
		return DataHoraRN.dateToStringDDMMYYYY(data);
	}
	
	public TurnoDTO getTurnoAtual() throws SemCalendarioException {
		TurnoInjetDTO turnoInjet = FuncoesApoioInjet.encontraTurnoAtual(getDao());
		TurnoDTO turnoAtualDTO = new TurnoDTO();
		turnoAtualDTO.setIdTurno(ConversaoTipos.converteParaBigDecimal(turnoInjet.getIjtbtur().getCdturno()).longValue());
		turnoAtualDTO.setCdTurno(turnoInjet.getIjtbtur().getCdturno());
		turnoAtualDTO.setDsTurno(turnoInjet.getIjtbtur().getDsturno());
		turnoAtualDTO.setDtReferencia(converterParaString(turnoInjet.getDtReferencia()));
		return turnoAtualDTO;
	}
	
	public TurnoDTO getTurnoAtualColetas() throws SemCalendarioException {
		TurnoInjetDTO turnoInjet = FuncoesApoioInjet.encontraTurnoAtualColetas(getDao());
		TurnoDTO turnoAtualDTO = new TurnoDTO();
		turnoAtualDTO.setIdTurno(ConversaoTipos.converteParaBigDecimal(turnoInjet.getIjtbtur().getCdturno()).longValue());
		turnoAtualDTO.setCdTurno(turnoInjet.getIjtbtur().getCdturno());
		turnoAtualDTO.setDsTurno(turnoInjet.getIjtbtur().getDsturno());
		turnoAtualDTO.setDtReferencia(converterParaString(turnoInjet.getDtReferencia()));
		return turnoAtualDTO;
	}	
	
}
