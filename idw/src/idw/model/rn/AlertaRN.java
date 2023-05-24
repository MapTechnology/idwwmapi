package idw.model.rn;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolal;
import idw.model.pojos.DwConsolallog;
import idw.model.pojos.DwConsolaloco;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwTAlerta;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.DwTAlertaTemplate;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.AlertaDTO;
import idw.webservices.dto.AlertasDTO;
import idw.webservices.dto.CamposEmUsoOmCfgDTO;
import idw.webservices.dto.FiltroRelatorioAlertaDTO;
import idw.webservices.dto.ResultadoDTO;
import idw.webservices.rest.idw.v2.dto.AlertaDTO2;
import idw.webservices.rest.idw.v2.dto.CausaDTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.ListaAlertasDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;

/**
 *
 * @author milton
 *
 */
@SuppressWarnings("unchecked")
public class AlertaRN extends AbstractRN<DAOGenerico> {

	public AlertaRN() {
		this(null);
	}

	public AlertaRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	/**
	 * Desativa todos os registros da tabela de alertas
	 * @param dataHoraDesativalerta
	 * @param omUsr Usu�rio que desativou a alerta
	 */
	public void desativarAlertas(Date dataHoraDesativalerta, OmUsr omUsr){
		this.getDao().desativarMuitos(DwTAlerta.class, DwTAlertaTemplate._FIELD_NAME_CD, null, false, dataHoraDesativalerta, omUsr);
	}

	/**
	 * Desativa registros da tabela de acoes
	 * @param listaCdAlertaDevemFicarAtivos Lista de c�digos de devem ficar permanecer ativos
	 * @param dataHoraDesativalerta
	 * @param omUsr Usu�rio que desativou a alerta
	 */
	public void desativarAlertas(List<String> listaCdAlertaDevemFicarAtivos, Date dataHoraDesativalerta, OmUsr omUsr){
		this.getDao().desativarMuitos(DwTAlerta.class, DwTAlertaTemplate._FIELD_NAME_CD, listaCdAlertaDevemFicarAtivos, true, dataHoraDesativalerta, omUsr);
	}

	/**
	 * Desativa relacionado ao c�digo e tipo do posto de trabalho
	 * @param cdAlerta
	 * @param omTppt
	 * @param date
	 * @param omUsr usu�rio que est� desativando
	 * @throws RegistroJaDesativadoException
	 * @throws RegistroDesconhecidoException
	 */
	public void desativarAlerta(String cdAlerta, OmTppt omTppt, Date date, OmUsr omUsr) throws RegistroDesconhecidoException, RegistroJaDesativadoException{
		this.getDao().desativar(DwTAlerta.class,cdAlerta, DwTAlertaTemplate._FIELD_NAME_CD, omTppt, date, omUsr);
	}

	/**
	 * Desativa {@code DwTAlerta} relacionado ao id da alerta
	 * @param idAlerta
	 * @param dataHoraAtual
	 * @throws RegistroJaDesativadoException
	 */
	public void desativarAlerta(long idAlerta,  Date date, OmUsr omUsr) throws RegistroJaDesativadoException{
		this.getDao().desativar(DwTAlerta.class, idAlerta, date, omUsr);
	}


	/**
	 * Pega {@code DwTAlerta} relacionado com o c�digo da alerta e que esteja ativo, relacionado com o {@code omTppt}
	 * @param cdAlerta
	 * @param omTppt
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwTAlerta getDwTAlerta(String cdAlerta, OmTppt omTppt) throws RegistroDesconhecidoException{
		return this.getDwTAlerta(cdAlerta, omTppt, true);
	}

	/**
	 * Pega {@code DwTAlerta} �ltima revis�o relacionado com o c�digo da alerta e relacionado com o {@code omTppt}
	 * @param cdAlerta
	 * @param omTppt
	 * @param isFiltroAtivo se true, filra pelo registro ativo
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwTAlerta getDwTAlerta(String cdAlerta, OmTppt omTppt, boolean isFiltroAtivo) throws RegistroDesconhecidoException{
		return this.getDao().findByCd(DwTAlerta.class, cdAlerta, DwTAlertaTemplate._FIELD_NAME_CD, omTppt, isFiltroAtivo);
	}
	/**
	 * Pega {@code DwTAlerta} relacionado com o id
	 * @param idAlerta
	 * @return
	 */
	public DwTAlerta getDwTAlerta(long idAlerta){
		return this.getDao().findById(DwTAlerta.class, idAlerta, false);
	}


	public void salvarDesativandoOriginal(DwTAlerta dwTAlertaDB, DwTAlerta dwTAlerta, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(dwTAlertaDB, dwTAlerta, dateOperacao, omUsrOperacao);
	}

	public DwTAlerta salvarDesativandoOriginal(DwTAlerta dwTAlerta, Date dateOperacao, OmUsr omUsrOperacao) {
		return this.getDao().salvarDesativandoOriginal(dwTAlerta, dateOperacao, omUsrOperacao);
	}

	
	public AlertasDTO getTAlertasDTO(Long idTppt)
	{
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t ");
		q.append("from DwTAlerta t ");
		q.append("where t.stAtivo=1 ");
		q.append("AND t.omTppt.idTppt=:idTppt ");
		q.defineParametro("idTppt", idTppt);
		
		List<DwTAlerta> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<AlertaDTO> lista = new ArrayList<AlertaDTO>();

		if (listaPesquisa != null) {
			for (DwTAlerta item : listaPesquisa) {
				AlertaDTO alertaDTO = new AlertaDTO();
				alertaDTO.setDwTAlerta(item.clone());
				lista.add(alertaDTO);
			}
		}
		AlertasDTO dtoRetorno = new AlertasDTO();
		dtoRetorno.setListaAlertasDTO(lista);
		return dtoRetorno;
		
	}
	
	public AlertasDTO getTAlertasDTO(AlertaDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "AlertaRN.getTAlertasDTO");
		log.info( idLog , 0, "AlertaRN.getTAlertasDTO filtro usado:" + filtro.toString());

		
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("SELECT t");
		q.append("FROM DwTAlerta t");
		q.append("WHERE 1 = 1");	

		if( filtro.getDwTAlerta() != null && filtro.getDwTAlerta().getIdTalerta() != 0){
			q.append("AND t.idTalerta = :idTalerta");
		}else{
			if(filtro.getDwTAlerta().getCdTalerta() != null && !filtro.getDwTAlerta().getCdTalerta().equals("")) {
				q.append("AND t.cdTalerta = :cdTalerta");
			}
			if(filtro.getDwTAlerta().getDsTalerta() != null && !filtro.getDwTAlerta().getDsTalerta().equals("")) {
				q.append("AND t.dsTalerta = :dsTalerta");
			}
			if (filtro.getDwTAlerta().getOmTppt() != null && !filtro.getDwTAlerta().getOmTppt().getCdTppt().equals("")) {
				q.append("AND t.omTppt.cdTppt = :cdTppt");
			}
			if (filtro.getDwTAlerta().getOmTppt() != null && !filtro.getDwTAlerta().getOmTppt().getDsTppt().equals("")) {
				q.append("AND t.omTppt.dsTppt = :dsTppt");
			}
			if((filtro.getDwTAlerta().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getDwTAlerta().getOmUsrByIdUsrstativo().getCdUsr() != null)
					&& (!filtro.getDwTAlerta().getOmUsrByIdUsrstativo().getCdUsr().equals(""))) {
				q.append("AND t.omUsrByIdUsrstativo.cdUsr = :cdUsrSt");
			}
			if((filtro.getDwTAlerta().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getDwTAlerta().getOmUsrByIdUsrstativo().getDsNome() != null)
					&& (!filtro.getDwTAlerta().getOmUsrByIdUsrstativo().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.dsNome = :dsNomeSt");
			}
			if((filtro.getDwTAlerta().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getDwTAlerta().getOmUsrByIdUsrrevisao().getCdUsr() != null)
					&& (!filtro.getDwTAlerta().getOmUsrByIdUsrrevisao().getCdUsr().equals(""))) {
				q.append("AND t.omUsrByIdUsrrevisao.cdUsr = :cdUsrRev");
			}
			if((filtro.getDwTAlerta().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getDwTAlerta().getOmUsrByIdUsrrevisao().getDsNome() != null)
					&& (!filtro.getDwTAlerta().getOmUsrByIdUsrrevisao().getDsNome().equals(""))) {
				q.append("AND t.omUsrByIdUsrrevisao.dsNome = :dsNomeRev ");
			}
			if(filtro.getDwTAlerta().getDtRevisao() != null) {
				q.append("AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF");
			}
			if(filtro.getDwTAlerta().getDtStativo() != null) {
				q.append("AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF");
			}
			if(filtro.getDwTAlerta().getIsAutomatico()) {
				q.append("AND t.isAutomatico = :isAutomatico");
			}
			if(filtro.getDwTAlerta().getIsTimeout()) {
				q.append("AND t.isTimeout = :isTimeout");
			}
			if (filtro.getDwTAlerta().getRevisao() != null) {
				q.append("AND t.revisao = :revisao");
			}
			if (filtro.getDwTAlerta().getStAtivo() != null && filtro.getDwTAlerta().getStAtivo() < (byte)2) {
				q.append("AND t.stAtivo = :stAtivo");
			}
		}

		q.defineParametro("idTalerta", filtro.getDwTAlerta().getIdTalerta());
		q.defineParametro("cdTalerta", filtro.getDwTAlerta().getCdTalerta());
		q.defineParametro("dsTalerta", filtro.getDwTAlerta().getDsTalerta());

		if(filtro.getDwTAlerta().getOmTppt() != null) {
			q.defineParametro("cdTppt", filtro.getDwTAlerta().getOmTppt().getCdTppt());
			q.defineParametro("dsTppt", filtro.getDwTAlerta().getOmTppt().getDsTppt());
		}

		if(filtro.getDwTAlerta().getDtRevisao() != null) {
			q.defineParametro("dtRevisao", filtro.getDwTAlerta().getDtRevisao());
			q.defineParametro("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getDwTAlerta().getDtRevisao()));
		}

		if(filtro.getDwTAlerta().getDtStativo() != null) {
			q.defineParametro("dtStativo", filtro.getDwTAlerta().getDtStativo());
			q.defineParametro("dtStativoF",DataHoraRN.getDataHora235959(filtro.getDwTAlerta().getDtStativo()));
		}

		q.defineParametro("revisao", filtro.getDwTAlerta().getRevisao());
		q.defineParametro("stAtivo", filtro.getDwTAlerta().getStAtivo());

		if (filtro.getDwTAlerta().getOmUsrByIdUsrrevisao() != null) {
			q.defineParametro("cdUsrRev", filtro.getDwTAlerta().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getDwTAlerta().getOmUsrByIdUsrrevisao().getDsNome());
		}

		if (filtro.getDwTAlerta().getOmUsrByIdUsrstativo() != null) {
			q.defineParametro("cdUsrSt", filtro.getDwTAlerta().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getDwTAlerta().getOmUsrByIdUsrstativo().getDsNome());
		}

		if(filtro.getDwTAlerta().getIsAutomatico() != null) {
			q.defineParametro("isAutomatico", filtro.getDwTAlerta().getIsAutomatico());
		}
		if(filtro.getDwTAlerta().getIsTimeout() != null) {
			q.defineParametro("isTimeout", filtro.getDwTAlerta().getIsTimeout());
		}

		List<DwTAlerta> listaPesquisa = null;
		try {
			listaPesquisa = q.query().list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<AlertaDTO> lista = new ArrayList<AlertaDTO>();

		if (listaPesquisa != null) {
			for (DwTAlerta item : listaPesquisa) {
				AlertaDTO alertaDTO = new AlertaDTO();
				alertaDTO.setDwTAlerta(item.clone());
				lista.add(alertaDTO);
			}
		}
		AlertasDTO dtoRetorno = new AlertasDTO();
		dtoRetorno.setListaAlertasDTO(lista);
		log.mostrarAvaliacaoCompleta();
		return dtoRetorno;
	}
	
	
	public AlertasDTO getAlertasDTO(FiltroRelatorioAlertaDTO filtro){
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "AlertaRN.getAlertasDTO");
		log.info( idLog , 0, "AlertaRN.getAlertasDTO filtro usado:" + filtro.toString());
		
		List<DwConsolid> listaDwConsolid;
		List<AlertaDTO> listaDwtalertaRetorno = new ArrayList<AlertaDTO>();
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.omPt ompt");
		q.append("JOIN consolid.dwConsols consol");
		q.append("LEFT JOIN consol.dwConsolals consolal");
		q.append("LEFT JOIN consolal.dwConsolalocos consolaloco");		
		q.append("LEFT JOIN ompt.omObjs omobj");
		q.append("LEFT JOIN consolid.dwFolha folha");
		q.append("LEFT JOIN folha.dwFolharaps folharap");
		q.append("LEFT JOIN folharap.dwFolharapcoms folharapcom");
		q.append("LEFT JOIN folharap.dwRap rap");
		q.append("WHERE consolid.tpId = :tpId");
	
		if (filtro.getPeriodoInicial() != null 
				&& filtro.getPeriodoFinal() != null ) {
			q.append("AND consolid.dtReferencia BETWEEN :dataincial and :datafinal");
		}
		
		if(filtro.getTurnoDTO()!=null){
		    q.append("AND consolid.dwTurno.idTurno = :idturno");			
		}else{
			q.append("AND consolid.dwTurno.idTurno != 1");
		}
		
	    if(filtro.getOmpt() != null){
			q.append("AND consolid.omPt.idPt = :idpt");
		}
		
		if(filtro.getOmgt() != null){
			q.append("AND omobj.omGtByIdGt.idGt = :idgt");
		}
		q.defineParametro("tpId", (byte) 1);
	
		if(filtro.getTurnoDTO()!=null){
			q.defineParametro("idturno",filtro.getTurnoDTO().getTurno().getIdTurno());
		}
		
		if(filtro.getOmpt() != null){
			q.defineParametro("idpt",filtro.getOmpt().getIdPt()); 
		}
	
		if(filtro.getOmgt() != null){
			q.defineParametro("idgt",filtro.getOmgt().getIdGt());
		}
		
		Date dtfim = DataHoraRN.getDataHora235959(filtro.getPeriodoFinal());
		if (filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null ) {			
			q.defineParametroTimestamp("datafinal", dtfim);
			q.defineParametroTimestamp("dataincial",filtro.getPeriodoInicial());
		}	
		
		listaDwConsolid = q.list();
		
		for(DwConsolid consolid : listaDwConsolid){
			for(DwConsol consol : consolid.getDwConsols()){
				for(DwConsolal consolal : consol.getDwConsolals()){
					for(DwConsolaloco consolaloco : consolal.getDwConsolalocos() ){
						
						Date fim = consolaloco.getDthrFalerta();
						if (fim == null)
							fim = DataHoraRN.getDataHoraAtual();
						
						AlertaDTO alertaDTO = new AlertaDTO();
						alertaDTO.setDwTAlerta(consolal.getDwTAlerta().clone(true));
						alertaDTO.setMaquina(consolid.getOmPt().clone(true));
						alertaDTO.setOrdemproducao(consolid.getPpCp().clone(true));
						alertaDTO.setDthrIalerta(consolaloco.getDthrIalerta());
						if(consolaloco.getDthrFalerta() != null){
							alertaDTO.setDthrFalerta(consolaloco.getDthrFalerta());
						}else{
							alertaDTO.setDthrFalerta(fim);
						}
						alertaDTO.setMsDthrialerta(consolaloco.getMsDthrialerta());
						alertaDTO.setMsDthrfalerta(consolaloco.getMsDthrfalerta());
						alertaDTO.setObservacao(consolaloco.getDwConsolallog().getObs());
						if(consolaloco.getDwConsolallog().getOmUsr() != null){
							alertaDTO.setUsuario(consolaloco.getDwConsolallog().getOmUsr().getDsNome());				
						}
						listaDwtalertaRetorno.add(alertaDTO);
					}
				}
			}				
		}
		AlertasDTO alertasDTO = new AlertasDTO();
		
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Comparator<AlertaDTO> comparator = new Comparator<AlertaDTO>() {
			@Override
			public int compare(AlertaDTO o1, AlertaDTO o2) {
				String str1 = o1.getMaquina() + sdf.format(o1.getDthrIalerta());
				String str2 = o2.getMaquina() + sdf.format(o2.getDthrIalerta());
				return str1.compareTo(str2);
			}
		};
		Collections.sort(listaDwtalertaRetorno, comparator);
		
		List<AlertaDTO> listaDwtalertaRetornoSemDuplicados = new ArrayList<AlertaDTO>();
		for(AlertaDTO dto: listaDwtalertaRetorno){
			boolean duplicado = false;
			for(AlertaDTO dtoRetorno : listaDwtalertaRetornoSemDuplicados){
				if(dtoRetorno.equals(dto)){
					duplicado = true;
					break;
				}
			}
			if(duplicado == false){
				listaDwtalertaRetornoSemDuplicados.add(dto);
			}
		}
		
		alertasDTO.setListaAlertasDTO(listaDwtalertaRetornoSemDuplicados);
		
		log.mostrarAvaliacaoCompleta();
		
		return alertasDTO;
	
	}
	
	public AlertaDTO setTAlertaDTO(AlertaDTO itemDTO) {
		itemDTO.setResultado(new ResultadoDTO());
		if (
				itemDTO.getDwTAlerta() == null || 
				itemDTO.getDwTAlerta().getCdTalerta() == null || 
				itemDTO.getDwTAlerta().getCdTalerta().equals("")  ) {
			itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().CODIGO_DESCONHECIDO);
			return itemDTO;
		}

		OmTppt omTppt = new OmTppt();
		DwTAlerta itemOriginal = new DwTAlerta();
		itemOriginal = itemDTO.getDwTAlerta().clone();
		
		
		//20160926FVA:
		if (itemOriginal != null && itemOriginal.getIdTalerta() > 0 && itemOriginal.getStAtivo().equals((byte)0)){
			ResultadoDTO resultadodto = new ResultadoDTO();
			resultadodto.setIdmensagem(resultadodto.getERRO_REATIVACAO_INDISPONIVEL());
			itemDTO.setResultado(resultadodto);
			return itemDTO;
		}

		

		TpptRN tpptRN = new TpptRN(this.getDao());
		omTppt = tpptRN.getOmTpptDTO(itemDTO.getDwTAlerta().getOmTppt());
		itemOriginal.setOmTppt(omTppt);
		
		// Pesquisar o registro
		DwTAlerta pojo = null;
		if (itemOriginal != null && itemOriginal.getIdTalerta() > 0) {
			pojo = getDwTAlerta(itemOriginal.getIdTalerta());
		}
		if (pojo != null && pojo.getStAtivo().equals((byte) 0) ) {
			itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().ERRO_EXCLUI_STATIVO_ZERO );
			return itemDTO;
		}
		if (pojo == null) {
			try {
				pojo = getDwTAlerta(itemOriginal.getCdTalerta(), omTppt);
				if (pojo != null) {
					itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().REGISTRO_JA_EXISTE);
					return itemDTO;
				}
			} catch (RegistroDesconhecidoException e) {
				pojo = null;
			}
		}

		itemDTO.setDwTAlerta(salvarDesativandoOriginal(itemOriginal, new Date(), itemDTO.getDwTAlerta().getOmUsrByIdUsrrevisao()).clone());
		return itemDTO;
	}
	
	public AlertasDTO removeTAlertasDTO(AlertasDTO itensDTO) {

		List<AlertaDTO> listaRetorno = new ArrayList<AlertaDTO>();
		AlertasDTO itensRetorno = new AlertasDTO();
		
		
		//17/03/2017 Alex: nao remover codigo em uso na configuracao geral.
		CamposEmUsoOmCfgDTO camposEmUsoOmCfgDTO = getCamposEmUsoOmCfg(itensDTO);
		itensRetorno.setCamposEmUsoOmCfg(camposEmUsoOmCfgDTO);
		if(camposEmUsoOmCfgDTO.getStatus() != camposEmUsoOmCfgDTO.getSTATUS_NENHUM_CAMPO_EM_USO()) {
			//se entrar nesse if eh pq existe algum codigo em uso
			return itensRetorno;
		}
		

		for(AlertaDTO item: itensDTO.getListaAlertasDTO()){
			OmUsr omUser = new OmUsr();
			UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
			try {
				omUser = usuarioRN.getOmUsr(item.getDwTAlerta().getOmUsrByIdUsrrevisao().getCdUsr());
			} catch (RegistroDesconhecidoException e) {
				e.printStackTrace();
			}
			try {
				desativarAlerta(item.getDwTAlerta().getIdTalerta(),new Date(), omUser);
				item.getDwTAlerta().setStAtivo((byte) 0);
			} catch (RegistroJaDesativadoException e) {
				e.printStackTrace();
			}
			listaRetorno.add(item);
		}

		
		itensRetorno.setListaAlertasDTO(listaRetorno);
		return itensRetorno;
	}
	
	private CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg(AlertasDTO itens) {
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		
		//campos
		DwTAlerta alertaAutomaticoEmUso = omcfg.getDwTAlerta();
		
		CamposEmUsoOmCfgDTO camposEmUsoOmCfg = new CamposEmUsoOmCfgDTO();
		boolean isTemCodigoEmUso = false;
		for(AlertaDTO item: itens.getListaAlertasDTO()) {
			camposEmUsoOmCfg.setCodigo(item.getDwTAlerta().getCdTalerta());
			
			if(alertaAutomaticoEmUso != null) {
				if(item.getDwTAlerta().getCdTalerta().equals(alertaAutomaticoEmUso.getCdTalerta())) {
					camposEmUsoOmCfg.setAlertaAutomaticoCIP(true);
					isTemCodigoEmUso = true;
				}
			}
			
		}
		
		if(isTemCodigoEmUso) {
			
			if(itens.getListaAlertasDTO() != null && itens.getListaAlertasDTO().size() > 1) {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_EXCLUSAO_ABORTADA());
			} else {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_TEM_CAMPO_EM_USO());
			}
			
		} else {
			camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_NENHUM_CAMPO_EM_USO());
		}
		
		return camposEmUsoOmCfg;
	}
	
	public DwTAlerta getDwTAlerta(String cdAlerta){
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select dwtalerta");
		q.append("from DwTAlerta dwtalerta");
		q.append("where dwtalerta.stAtivo = 1");
		q.append("and dwtalerta.cdTalerta = :cdalerta");
		q.setMaxResults(1);
		q.defineParametro("cdalerta", cdAlerta);
		return (DwTAlerta) q.uniqueResult();
	}

	public List<DwTAlerta> pesqusiarTodosDwTAlertaAtivos(){
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select dwtalerta");
		q.append("from DwTAlerta dwtalerta");
		q.append("where dwtalerta.stAtivo = 1");
		return q.list();
	}

	public List<DwConsolallog> getAlertasDTOAbertosByIdPt(Long idPt)
	{
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t ");
		q.append("from DwConsolallog t ");
		q.append("where t.dthrFalerta is null ");
		q.append("AND t.omPt.idPt=:idPt ");
		q.defineParametro("idPt", idPt);
		
		List<DwConsolallog> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<DwConsolallog> lista = new ArrayList<DwConsolallog>();

		if (listaPesquisa != null) {
			for (DwConsolallog item : listaPesquisa) {
				DwConsolallog alerta = new DwConsolallog();
				alerta = (item.clone());
				lista.add(alerta);
			}
		}
		return lista;
		
	}
	
	public DwConsolallog getUltimoAlertaAbertoApos(Long idPt, String cdAlerta, Date dthr)
	{
		DwConsolallog ultimoAlerta = null;
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t ");
		q.append("from DwConsolallog t ");
		q.append("where t.omPt.idPt=:idPt ");
		q.append("and t.dwTAlerta.cdTalerta = :cdAlerta ");
		q.append("and t.dthrIalerta >= :dthr ");
		q.append("order by t.dthrIalerta desc ");
		
		q.defineParametro("idPt", idPt);
		q.defineParametro("cdAlerta", cdAlerta);
		q.defineParametro("dthr", dthr);
		
		q.setMaxResults(1);
		
		try{
			ultimoAlerta = (DwConsolallog) q.uniqueResult();
		} catch (Exception e){
			e.printStackTrace();
		}

		return ultimoAlerta;
	}
	
	public List<DwConsolallog> getAlertasDTOAbertosByCdPt(String cdPt)
	{
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t ");
		q.append("from DwConsolallog t ");
		q.append("where t.dthrFalerta is null ");
		q.append("AND t.omPt.cdPt=:cdPt ");
 		q.append("ORDER BY t.dthrIalerta");
		q.defineParametro("cdPt", cdPt);
		
		List<DwConsolallog> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<DwConsolallog> lista = new ArrayList<DwConsolallog>();

		if (listaPesquisa != null) {
			for (DwConsolallog item : listaPesquisa) {
				DwConsolallog alerta = new DwConsolallog();
				alerta = (item.clone());
				lista.add(alerta);
			}
		}
		return lista;
		
	}

	
	@SuppressWarnings("unused")
	public ListaAlertasDTO getAlertasDTO(FiltroPesquisaDTO filtro) {
		ListaAlertasDTO retorno = new ListaAlertasDTO();
		retorno.setItems(new ArrayList<AlertaDTO2>());
		retorno.setMeta(new MetaDTO(filtro));
		
		MapQuery q = new MapQuery(this.getDaoSession());
		
		q.append("select t ");
		q.append("from DwTAlerta t ");
		q.append("where t.stAtivo = 1 ");
		q.append("and t.omTppt.cdTppt = 'CIC' ");
		
		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){
			q.append("AND (");
			q.append(" upper(t.cdTalerta) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.dsTalerta) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		}
		
		q.append("order by t.cdTalerta");
		
		// Lista do pojo
		List<DwTAlerta> listaPesquisa = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
		
 		for (DwTAlerta registro : listaPesquisa) {
 			
 			AlertaDTO2 regDTO = new AlertaDTO2();
 			
 			regDTO.setIdAlerta(registro.getIdTalerta());
 			regDTO.setCdAlerta(registro.getCdTalerta());
 			regDTO.setDsAlerta(registro.getDsTalerta());
 			regDTO.setTpPt(registro.getOmTppt().getCdTppt()); 			
 			regDTO.setTimeout(registro.getIsTimeout());
 			regDTO.setAutomatico(registro.getIsAutomatico());
 			regDTO.setStRegistro(registro.getStAtivo().intValue());
 			
			retorno.getItems().add(regDTO);
 		}
		
		
 		if (listaPesquisa.size() > 0) {
 			ResumoRetornoRegistrosRN resRN = new ResumoRetornoRegistrosRN(getDao());
 			retorno.setMeta(resRN.getMetaDTO(filtro, q, listaPesquisa.size()));
 			resRN = null;
 		}
		
		q = null;
		listaPesquisa = null;
		
		return retorno;
		
	}
	
	@SuppressWarnings("unused")
	public AlertaDTO2 getAlertaByCd(String cdAlerta) {
		AlertaDTO2 retorno = new AlertaDTO2();
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select t ");
		q.append("from DwTAlerta t ");
		q.append("where t.stAtivo = 1 ");
		q.append("and t.omTppt.cdTppt = 'CIC' ");
		q.append("and t.cdTalerta = :cdAlerta ");
		q.append("order by t.cdTalerta");
		
 		q.defineParametro("cdAlerta", cdAlerta);

 		// Lista do pojo
 		List<DwTAlerta> lista = q.list();
 		
 		if (lista.size() == 1) {
 			
 			retorno.setIdAlerta(lista.get(0).getIdTalerta());
 			retorno.setCdAlerta(lista.get(0).getCdTalerta());
 			retorno.setDsAlerta(lista.get(0).getDsTalerta());
 			retorno.setTpPt(lista.get(0).getOmTppt().getCdTppt());
 			retorno.setTimeout(lista.get(0).getIsTimeout());
 			retorno.setAutomatico(lista.get(0).getIsAutomatico());
 			retorno.setStRegistro(lista.get(0).getStAtivo().intValue());
 			
 		}
		
		return retorno;
	}

	
}
