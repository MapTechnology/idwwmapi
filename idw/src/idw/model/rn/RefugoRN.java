package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.DwConsolrelog;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTRefugo;
import idw.model.pojos.MsUp; 
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwTRefugoTemplate;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.CamposEmUsoOmCfgDTO;
import idw.webservices.dto.DwTRefugoDTO;
import idw.webservices.dto.DwTRefugosDTO;
import idw.webservices.dto.FiltroRelatorioRefugoDTO;
import idw.webservices.dto.PtDTO;
import idw.webservices.dto.ResultadoDTO; 
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.ListaRefugosDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;
import idw.webservices.rest.idw.v2.dto.RefugoCadDTO;
import injetws.webservices.dto.IwsRefugoDTO;
import ms.model.rn.UpRN;

/**
 *
 * @author milton
 *
 */
public class RefugoRN extends AbstractRN<DAOGenerico> {

	public RefugoRN() {
		this(null);
	}

	public RefugoRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	/**
	 * Desativa todos os registros da tabela de refugos
	 * @param dataHoraDesativacao
	 * @param omUsr Usu�rio que desativou a refugo
	 */
	public void desativarRefugos(Date dataHoraDesativacao, OmUsr omUsr){
		this.getDao().desativarMuitos(DwTRefugo.class, DwTRefugoTemplate._FIELD_NAME_CD, null, false, dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa registros da tabela de refugos
	 * @param listaCdRefugoDevemFicarAtivos Lista de c�digos de devem ficar permanecer ativos
	 * @param dataHoraDesativacao
	 * @param omUsr Usu�rio que desativou a refugo
	 */
	public void desativarRefugos(List<String> listaCdRefugoDevemFicarAtivos, Date dataHoraDesativacao, OmUsr omUsr){
		this.getDao().desativarMuitos(DwTRefugo.class, DwTRefugoTemplate._FIELD_NAME_CD, listaCdRefugoDevemFicarAtivos, true, dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa relacionado ao c�digo e tipo do posto de trabalho
	 * @param cdRefugo
	 * @param omTppt
	 * @param date
	 * @param omUsr usu�rio que est� desativando
	 * @throws RegistroJaDesativadoException
	 * @throws RegistroDesconhecidoException
	 */
	public void desativarRefugo(String cdRefugo, OmTppt omTppt, Date date, OmUsr omUsr) throws RegistroDesconhecidoException, RegistroJaDesativadoException{
		this.getDao().desativar(DwTRefugo.class,cdRefugo, DwTRefugoTemplate._FIELD_NAME_CD, omTppt, date, omUsr);
	}

	/**
	 * Desativa {@code DwTRefugo} relacionado ao id da refugo
	 * @param idRefugo
	 * @param dataHoraAtual
	 * @throws RegistroJaDesativadoException
	 */
	public void desativarRefugo(long idRefugo,  Date date, OmUsr omUsr) throws RegistroJaDesativadoException{
		this.getDao().desativar(DwTRefugo.class, idRefugo, date, omUsr);
	}


	/**
	 * Pega {@code DwTRefugo} relacionado com o c�digo da refugo e que esteja ativo, relacionado com o {@code omTppt}
	 * @param cdRefugo
	 * @param omTppt
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwTRefugo getDwTRefugo(String cdRefugo, OmTppt omTppt) throws RegistroDesconhecidoException{
		return this.getDwTRefugo(cdRefugo, omTppt, true);
	}

	public DwTRefugo getDwTRefugo(String cdRefugo) throws RegistroDesconhecidoException{
		DwTRefugo pojo =  new DwTRefugo();
		pojo.setCdTrefugo(cdRefugo);
		return this.getDao().findByCd(pojo, true);
	}

	/**
	 * Pega {@code DwTRefugo} �ltima revis�o relacionado com o c�digo da refugo e relacionado com o {@code omTppt}
	 * @param cdRefugo
	 * @param omTppt
	 * @param isFiltroAtivo se true busca apenas o ativo
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwTRefugo getDwTRefugo(String cdRefugo, OmTppt omTppt, boolean isFiltroAtivo) throws RegistroDesconhecidoException{
		return this.getDao().findByCd(DwTRefugo.class, cdRefugo, DwTRefugoTemplate._FIELD_NAME_CD, omTppt, isFiltroAtivo);
	}
	/**
	 * Pega {@code DwTRefugo} relacionado com o id
	 * @param idRefugo
	 * @return
	 */
	public DwTRefugo getDwTRefugo(long idRefugo){
		return this.getDao().findById(DwTRefugo.class, idRefugo, false);
	}


	public void salvarDesativandoOriginal(DwTRefugo dwTRefugoDB, DwTRefugo dwTRefugo, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(dwTRefugoDB, dwTRefugo, dateOperacao, omUsrOperacao);
	}

	public DwTRefugo salvarDesativandoOriginal(DwTRefugo dwTRefugo, Date dateOperacao, OmUsr omUsrOperacao) {
		return this.getDao().salvarDesativandoOriginal(dwTRefugo, dateOperacao, omUsrOperacao);
	}
	
	
	public DwTRefugosDTO getTRefugosDTO(FiltroRelatorioRefugoDTO filtro){
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RefugoRN.getTRefugosDTO");
		log.info( idLog , 0, "RefugoRN.getTRefugosDTO filtro usado:" + filtro.toString());
		
		 List<DwTRefugo> listaDwtrefugo;
		 
		 List<DwTRefugoDTO> listaDwtrefugoRetorno = new ArrayList<DwTRefugoDTO>();
		 MapQuery query = new MapQuery(getDao().getSession());
		 query.append("SELECT dwtrefugo ");
		 query.append("FROM DwTRefugo dwtrefugo");
		 query.append("left join dwtrefugo.omTppt omtppt");
		 query.append("left join dwtrefugo.dwTArea dwtarea");
		 if (filtro.getOmTpptRefugo()!= null) {
			 query.append("WHERE omtppt.idTppt = :idTppt"); 	
		 }else{
			 query.append("");
		 }
		 if (filtro.getOmTpptRefugo() != null && filtro.getSituacao() != null  && filtro.getSituacao() <(byte)2){
				query.append("AND dwtrefugo.stAtivo=:stAtivo");
		 }else if(filtro.getSituacao() != null  && filtro.getSituacao() <(byte)2){
			 query.append("WHERE dwtrefugo.stAtivo=:stAtivo");
		 }
		 if(filtro.isOrdenarRefugo() == true){//
			 query.append("ORDER BY dwtrefugo.cdTrefugo");
	     }else{
		   if(filtro.isOrdenarRefugo() == false){
			  query.append("ORDER BY dwtarea.cdArea, dwtrefugo.cdTrefugo");  
		   }
		 }
		 if (filtro.getOmTpptRefugo()!= null) {
		 query.defineParametro("idTppt", filtro.getOmTpptRefugo().getIdTppt());
		 }
		 if (filtro.getSituacao() != null){
			 query.defineParametro("stAtivo", filtro.getSituacao());
		 }
		 
		 listaDwtrefugo = query.list();
		
		 if(listaDwtrefugo != null){
			  for(DwTRefugo dwtrefugo : listaDwtrefugo){
				 
				  DwTRefugoDTO refugoDTO = new DwTRefugoDTO();
				  refugoDTO.setDwTRefugo(dwtrefugo.clone(true));
				  if ( dwtrefugo.getDwTArea() != null)
					  refugoDTO.getDwTRefugo().setDwTArea(dwtrefugo.getDwTArea().clone(false));
				  listaDwtrefugoRetorno.add(refugoDTO);
			  }	  
		  }
		  DwTRefugosDTO refugosDto = new DwTRefugosDTO();
		  refugosDto.setDwTRefugos(listaDwtrefugoRetorno);
		  
		  log.mostrarAvaliacaoCompleta();
		  
		  return refugosDto;

	}
		
	
	public DwTRefugosDTO getRefugosDTO(Long idTppt){
		
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t ");
		q.append("from DwTRefugo t ");
		q.append("where t.stAtivo=1 ");	
		q.append("AND t.omTppt.idTppt=:idTppt ");
		q.defineParametro("idTppt", idTppt);
		
		List<DwTRefugo> listaPesquisa = null;
		try{
			listaPesquisa = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<DwTRefugoDTO> lista = new ArrayList<DwTRefugoDTO>();

		if (listaPesquisa != null) {
			for (DwTRefugo item : listaPesquisa) {
				DwTRefugoDTO dwTRefugoDTO = new DwTRefugoDTO();
				dwTRefugoDTO.setDwTRefugo(item.clone());
				lista.add(dwTRefugoDTO);
			}
		}

		DwTRefugosDTO listaRetorno = new DwTRefugosDTO();
		listaRetorno.setDwTRefugos(lista);

		return listaRetorno;
		
	}
	
	public DwTRefugosDTO getTRefugo(DwTRefugoDTO filtro){
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RefugoRN.getTRefugo");
		log.info( idLog , 0, "RefugoRN.getTRefugo filtro usado:" + filtro.toString());
		
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t ");
		q.append("from DwTRefugo t ");
		q.append("where 1=1 ");	

		if(filtro.getDwTRefugo().getIdTrefugo() != null && filtro.getDwTRefugo().getIdTrefugo().equals(0l) == false){
			q.append("AND t.idTrefugo=:idTrefugo ");
		}else{
			if(filtro.getDwTRefugo().getCdTrefugo()!=null && !filtro.getDwTRefugo().getCdTrefugo().equals("")){
				q.append("AND t.cdTrefugo=:cdTrefugo ");
			}
			if(filtro.getDwTRefugo().getDsTrefugo()!=null &&
					!filtro.getDwTRefugo().getDsTrefugo().equals("")){
				q.append("AND t.dsTrefugo=:dsTrefugo ");
			}
			if (filtro.getDwTRefugo().getOmTppt() != null && filtro.getDwTRefugo().getOmTppt().getCdTppt() != null && !filtro.getDwTRefugo().getOmTppt().getCdTppt().equals("")){
				q.append("AND t.omTppt.cdTppt=:cdTppt ");
			}
			if (filtro.getDwTRefugo().getOmTppt() != null && filtro.getDwTRefugo().getOmTppt().getDsTppt() != null && !filtro.getDwTRefugo().getOmTppt().getDsTppt().equals("")){
				q.append("AND t.omTppt.dsTppt=:dsTppt ");
			}
			if((filtro.getDwTRefugo().getOmUsrByIdUsrstativo()!= null)
					&& (filtro.getDwTRefugo().getOmUsrByIdUsrstativo().getCdUsr() != null)
					&& (!filtro.getDwTRefugo().getOmUsrByIdUsrstativo().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.cdUsr=:cdUsrSt ");
			}
			if((filtro.getDwTRefugo().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getDwTRefugo().getOmUsrByIdUsrstativo().getDsNome() != null)
					&& (!filtro.getDwTRefugo().getOmUsrByIdUsrstativo().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.dsNome=:dsNomeSt ");
			}
			if((filtro.getDwTRefugo().getOmUsrByIdUsrrevisao()!= null)
					&& (filtro.getDwTRefugo().getOmUsrByIdUsrrevisao().getCdUsr() != null)
					&& (!filtro.getDwTRefugo().getOmUsrByIdUsrrevisao().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.cdUsr=:cdUsrRev ");
			}
			if((filtro.getDwTRefugo().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getDwTRefugo().getOmUsrByIdUsrrevisao().getDsNome() != null)
					&& (!filtro.getDwTRefugo().getOmUsrByIdUsrrevisao().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.dsNome=:dsNomeRev ");
			}
			if(filtro.getDwTRefugo().getDtRevisao() != null){
				q.append("AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ");
			}
			if(filtro.getDwTRefugo().getDtStativo() != null){
				q.append("AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF ");
			}
			if (filtro.getDwTRefugo().getRevisao()!=null){
				q.append("AND t.revisao=:revisao ");
			}
			if (filtro.getDwTRefugo().getStAtivo() != null && filtro.getDwTRefugo().getStAtivo()<(byte)2){
				q.append("AND t.stAtivo=:stAtivo ");
			}
			if(filtro.getDwTRefugo().getDwTArea() != null && filtro.getDwTRefugo().getDwTArea().getCdArea() != null && !filtro.getDwTRefugo().getDwTArea().getCdArea().equals("")){
				q.append("AND t.dwTArea.cdArea=:cdArea ");
			}
			if(filtro.getDwTRefugo().getDwTArea() != null && filtro.getDwTRefugo().getDwTArea().getDsArea() != null && !filtro.getDwTRefugo().getDwTArea().getDsArea().equals("")){
				q.append("AND t.dwTArea.dsArea=:dsArea ");
			}
			
			if(filtro.getDwTRefugo().getIsRequerAcao() == true){
				q.append("AND t.isRequerAcao=:isRequerAcao");
			}
			
			if(filtro.getDwTRefugo().getIsRequerCausa() == true){
				q.append("AND t.isRequerCausa=:isRequerCausa");
			}
			
		}

		q.defineParametro("isRequerCausa", filtro.getDwTRefugo().getIsRequerCausa());
		q.defineParametro("isRequerAcao", filtro.getDwTRefugo().getIsRequerAcao());
		q.defineParametro("idTrefugo", filtro.getDwTRefugo().getIdTrefugo());
		q.defineParametro("cdTrefugo", filtro.getDwTRefugo().getCdTrefugo());
		q.defineParametro("dsTrefugo", filtro.getDwTRefugo().getDsTrefugo());

		if(filtro.getDwTRefugo().getOmTppt()!= null){
			q.defineParametro("cdTppt", filtro.getDwTRefugo().getOmTppt().getCdTppt());
			q.defineParametro("dsTppt", filtro.getDwTRefugo().getOmTppt().getDsTppt());
		}

		if(filtro.getDwTRefugo().getDtRevisao()!=null){
			q.defineParametro("dtRevisao", filtro.getDwTRefugo().getDtRevisao());
			q.defineParametro("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getDwTRefugo().getDtRevisao()));
		}

		if(filtro.getDwTRefugo().getDtStativo()!=null){
			q.defineParametro("dtStativo", filtro.getDwTRefugo().getDtStativo());
			q.defineParametro("dtStativoF",DataHoraRN.getDataHora235959(filtro.getDwTRefugo().getDtStativo()));
		}

		q.defineParametro("revisao", filtro.getDwTRefugo().getRevisao());
		q.defineParametro("stAtivo", filtro.getDwTRefugo().getStAtivo());

		if (filtro.getDwTRefugo().getOmUsrByIdUsrrevisao() != null) {
			q.defineParametro("cdUsrRev", filtro.getDwTRefugo().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getDwTRefugo().getOmUsrByIdUsrrevisao().getDsNome());
		}

		if (filtro.getDwTRefugo().getOmUsrByIdUsrstativo() != null){
			q.defineParametro("cdUsrSt", filtro.getDwTRefugo().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getDwTRefugo().getOmUsrByIdUsrstativo().getDsNome());
		}
		if(filtro.getDwTRefugo().getDwTArea() != null){
			q.defineParametro("cdArea", filtro.getDwTRefugo().getDwTArea().getCdArea());
			q.defineParametro("dsArea", filtro.getDwTRefugo().getDwTArea().getDsArea());
		}
		

		List<DwTRefugo> listaPesquisa = null;
		try{
			listaPesquisa = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<DwTRefugoDTO> lista = new ArrayList<DwTRefugoDTO>();

		if (listaPesquisa != null) {
			for (DwTRefugo item : listaPesquisa) {
				DwTRefugoDTO dwTRefugoDTO = new DwTRefugoDTO();
				dwTRefugoDTO.setDwTRefugo(item.clone());
				lista.add(dwTRefugoDTO);
			}
		}

		DwTRefugosDTO listaRetorno = new DwTRefugosDTO();
		listaRetorno.setDwTRefugos(lista);
		
		log.mostrarAvaliacaoCompleta();

		return listaRetorno;
	}
	
	public DwTRefugoDTO setTRefugo(DwTRefugoDTO itemDTO) {
		itemDTO.setResultado(new ResultadoDTO());
		if (
				itemDTO.getDwTRefugo() == null || 
				itemDTO.getDwTRefugo().getCdTrefugo() == null || 
				itemDTO.getDwTRefugo().getCdTrefugo().equals("")  ) {
			itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().CODIGO_DESCONHECIDO);
			return itemDTO;
		}

		OmTppt omTppt = new OmTppt();
		DwTRefugo itemOriginal = new DwTRefugo();
		itemOriginal = itemDTO.getDwTRefugo().clone();
		
		
		//20160926FVA:
		if (itemOriginal != null && itemOriginal.getIdTrefugo()!=null &&  itemOriginal.getIdTrefugo() > 0 && itemOriginal.getStAtivo().equals((byte)0)){
			ResultadoDTO resultadodto = new ResultadoDTO();
			resultadodto.setIdmensagem(resultadodto.getERRO_REATIVACAO_INDISPONIVEL());
			itemDTO.setResultado(resultadodto);
			return itemDTO;
		}
		

		TpptRN tpptRN = new TpptRN(this.getDao());
		omTppt = tpptRN.getOmTpptDTO(itemDTO.getDwTRefugo().getOmTppt());
		itemOriginal.setOmTppt(omTppt);
		
		AreaRN areaRN = new AreaRN();
		areaRN.setDao(getDao());
		DwTArea dwtarea = null;
		try {
			if (itemDTO.getDwTRefugo().getDwTArea() != null && itemDTO.getDwTRefugo().getDwTArea().getCdArea() != null && itemDTO.getDwTRefugo().getDwTArea().getCdArea().equals("") == false)
				dwtarea = areaRN.getDwTArea(itemDTO.getDwTRefugo().getDwTArea().getCdArea(), true);
		} catch (RegistroDesconhecidoException e) {
			dwtarea = null;
		}
		itemOriginal.setDwTArea(dwtarea);
		
		// Pesquisar o registro
		DwTRefugo pojo = null;
		if (itemOriginal != null && itemOriginal.getIdTrefugo() != null && itemOriginal.getIdTrefugo() > 0) {
			pojo = getDwTRefugo(itemOriginal.getIdTrefugo());
		}
		if (pojo != null && pojo.getStAtivo().equals((byte) 0) ) {
			itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().ERRO_EXCLUI_STATIVO_ZERO );
			return itemDTO;
		}
		if (pojo == null) {
			try {
				pojo = getDwTRefugo(itemOriginal.getCdTrefugo(), omTppt);
				if (pojo != null) {
					itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().REGISTRO_JA_EXISTE);
					return itemDTO;
				}
			} catch (RegistroDesconhecidoException e) {
				pojo = null;
			}
		}

		
		DwTRefugo salvo = salvarDesativandoOriginal(itemOriginal, new Date(), itemDTO.getDwTRefugo().getOmUsrByIdUsrrevisao());
		DwTRefugo clone = salvo.clone();
		itemDTO.setDwTRefugo(clone);
		return itemDTO;
	}

	public DwTRefugosDTO removeTRefugo(DwTRefugosDTO itens){
		DwTRefugosDTO itensRetorno = new DwTRefugosDTO();
		List<DwTRefugoDTO> listaRetorno = new ArrayList<DwTRefugoDTO>();
		
		
		//17/03/2017 Alex: nao remover codigo em uso na configuracao geral.
		CamposEmUsoOmCfgDTO camposEmUsoOmCfgDTO = getCamposEmUsoOmCfg(itens);
		itensRetorno.setCamposEmUsoOmCfg(camposEmUsoOmCfgDTO);
		if(camposEmUsoOmCfgDTO.getStatus() != camposEmUsoOmCfgDTO.getSTATUS_NENHUM_CAMPO_EM_USO()) {
			//se entrar nesse if eh pq existe algum codigo em uso
			return itensRetorno;
		}
				

		for(DwTRefugoDTO item: itens.getDwTRefugos()){
			OmUsr omUser = new OmUsr();
			UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
			
			
			try {
				omUser = usuarioRN.getOmUsr(item.getDwTRefugo().getOmUsrByIdUsrrevisao().getCdUsr());
			} catch (RegistroDesconhecidoException e) {
				e.printStackTrace();
			}
			try {
				desativarRefugo(item.getDwTRefugo().getIdTrefugo(), new Date(), omUser);
				item.getDwTRefugo().setStAtivo((byte)0);
			} catch (RegistroJaDesativadoException e) {
				e.printStackTrace();
			}					
			
			listaRetorno.add(item);
		}
		
		itensRetorno.setDwTRefugos(listaRetorno);
		return itensRetorno;
	}
	
	private CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg(DwTRefugosDTO itens) {
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		
		//campos
		DwTRefugo refugoEmUso = omcfg.getDwTRefugo();
		
		CamposEmUsoOmCfgDTO camposEmUsoOmCfg = new CamposEmUsoOmCfgDTO();
		boolean isTemCodigoEmUso = false;
		for(DwTRefugoDTO item: itens.getDwTRefugos()) {
			camposEmUsoOmCfg.setCodigo(item.getDwTRefugo().getCdTrefugo());
			
			if(refugoEmUso != null) {
				if(item.getDwTRefugo().getCdTrefugo().equals(refugoEmUso.getCdTrefugo())) {
					camposEmUsoOmCfg.setRefugo(true);
					isTemCodigoEmUso = true;
				}
			}
			
		}
		
		if(isTemCodigoEmUso) {
			
			if(itens.getDwTRefugos() != null && itens.getDwTRefugos().size() > 1) {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_EXCLUSAO_ABORTADA());
			} else {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_TEM_CAMPO_EM_USO());
			}
			
		} else {
			camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_NENHUM_CAMPO_EM_USO());
		}
		
		return camposEmUsoOmCfg;
	}
	
	
	public DwTRefugo getDwTRefugoByMsUpCdRefugo(String cdMaquina, String cdRefugo) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select dwtrefugo");
		q.append("from DwTRefugo dwtrefugo");
		q.append("join dwtrefugo.omTppt omtppt");
		q.append("join omtppt.omPts ompt");
		q.append("where dwtrefugo.cdTrefugo = :cdrefugo");
		q.append("and dwtrefugo.stAtivo = 1");
		q.append("and ompt.stAtivo = 1");
		q.append("and ompt.cdPt = :cdpt");
		q.defineParametro("cdpt", cdMaquina);
		q.defineParametro("cdrefugo", cdRefugo);
		DwTRefugo dwtrefugo = (DwTRefugo) q.uniqueResult();
		return dwtrefugo;
	}
	
	public DwTRefugo getDwTRefugoPorCdAtivo(String cdTRefugo){
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT t");
		q.append("FROM DwTRefugo t");
		q.append("WHERE t.cdTrefugo = :cdTRefugo");
		q.append("AND t.stAtivo = :stAtivo");
		q.append("ORDER BY t.idTrefugo");
		q.defineParametro("cdTRefugo", cdTRefugo);
		q.defineParametro("stAtivo", (byte)1);
		q.setMaxResults(1);
		return (DwTRefugo)q.uniqueResult();
	}

	/* Esse metodo tem que retornar o ultimo refugo da op carregada em máquina
	 * 
	 */
	public IwsRefugoDTO getInfoUltimoRefugo(String idUp){
		IwsRefugoDTO retorno = new IwsRefugoDTO();
		
		UpRN urn = new UpRN();
		PTRN prn = new PTRN(getDao());
		
		urn.setDaoPdba(getDao());
		
		MsUp msup;
		try {
			msup = urn.pesquisarMsUpPorCdUpStAtivo(idUp);
		} catch (injetws.model.excessoes.RegistroDesconhecidoException e) {
			msup = urn.pesquisarMsUpPorIdUp(new BigDecimal(idUp));
			if (msup == null)
				return retorno;
		}

		OmPt ompt;
		try {
			ompt = prn.getOmPt(msup.getCdUp());
		} catch (RegistroDesconhecidoException e) {
			return retorno;
		}


		/* 190826F TRECHO 190826-A Trecho retirado pois estava obtendo aqui a ultima Op cadastrada sempre para o PT, sendo que isso estava sendo persistido no banco (OmPt.idcp). 
		 * Importante: para o caso de este trecho ter existido devido a algum problema com Op nula, este foi substituido pelo outro mais abaixo.
		 * 
				CpRN cprn = new CpRN(getDao());
				List<PpCp> ppcp = new ArrayList<PpCp>();
				ppcp = cprn.pesquisarPpCpByCdPt(ompt);
				if (ppcp != null) {
					for (PpCp o : ppcp)
					{
						ompt.setPpCp(o.clone(true));
						break;
					}
					//ompt.setPpCp(ppcp.get(0));
				}
		DwConsolrelog relog = getUltimoRefugo(ompt, ompt.getPpCp());	
		*/

		
		// Bloco 190826-B. Inicio. Substitui o bloco 190826-A.
		DwConsolrelog relog = null;
		if(ompt!=null){
			if (ompt.getPpCp()==null){ // contingência para o caso de não haver ppcp no result da consulta anterior (pt) - conforme conversa com Luiz sobre ocorrências em caso anterior a este.
				PtDTO ptdto = null;
				OmPt opt = new OmPt();
				opt.setIdPt(ompt.getIdPt());
				ptdto = prn.getOmPtPorIdOuCd(opt);
				if (ptdto!=null && ptdto.getPt()!=null && ptdto.getPt().getPpCp()!=null && ptdto.getPt().getPpCp().getIdCp()!=null){
					ompt.setPpCp(ptdto.getPt().getPpCp());
				}
			}
			if (ompt.getPpCp()!=null && ompt.getPpCp().getIdCp()!=null){
				relog = getUltimoRefugo(ompt, ompt.getPpCp());	
			}
		}
		//Bloco 190826-B. FIM.
		

		if (relog != null && (relog.getIsCancelado() == null || relog.getIsCancelado() == false) ) {
			retorno.setCdRefugo(relog.getDwTRefugo().getCdTrefugo());
			retorno.setDthrUltRefugo(relog.getDthrRefugo());
			retorno.setIdRefugo(relog.getDwTRefugo().getIdTrefugo().intValue());
		}
		return retorno;
	}
	
	/* Metodo usado para consultar o ultimo refugo que sera apresentado
	no CLP. Os refugos lancados pelo TM ou cancelados nao podem ser apresentados
	*/
	public DwConsolrelog getUltimoRefugo(OmPt omPt, PpCp ppCp) {
		MapQuery q = new MapQuery(this.getDaoSession());
		
		q.append("SELECT distinct dwConsolrelog ");
		q.append("FROM DwConsolrelog dwConsolrelog ");
		q.append("left join fetch dwConsolrelog.omPt omPt");
		q.append("left join fetch dwConsolrelog.dwTRefugo dwTRefugo");
		q.append("left join fetch dwConsolrelog.dwTAcao dwTAcao");
		q.append("left join fetch dwConsolrelog.dwTCausa dwTCausa");
		q.append("left join fetch dwConsolrelog.dwConsolreocos dwConsolreocos");
		q.append("left join fetch dwConsolreocos.dwConsolre dwConsolre");
		q.append("left join fetch dwConsolre.dwConsol dwConsol");
		q.append("left join fetch dwConsol.dwConsolid dwConsolid");
		q.append("left join fetch dwConsolid.ppCp ppCp");
		q.append("where omPt.idPt = :idPt ");
		//Luiz 2018-05-08 Tive de comentar os dois filtros abaixo: islancadotm iscancelado pois em alguns casos tais campos possuiam o valor null
		//q.append("and dwConsolrelog.isLancadotm <> :islancadotm");
		//q.append("and dwConsolrelog.isCancelado <> :iscancelado");
		q.append("and dwTRefugo.idTrefugo != :idTrefugo");
		q.append("and ppCp.idCp = :idCp");
		// Alessandre em 20-10-17 comentei a linha abaixo e substitui pela seguinte
		// pois qdo o apontamento manual de refugo via tm cria novo refugo tambem entra em dwconsolrelog
		// e se o coletor for reiniciado vai pegar ele
		//q.append("ORDER BY dwConsolrelog.idConsolrelog DESC");
		q.append("ORDER BY dwConsolrelog.dthrRefugo DESC");

		//q.defineParametro("islancadotm", true);
		//q.defineParametro("iscancelado", true);
		
		q.defineParametro("idPt", omPt.getIdPt());
		if (ppCp != null)
			q.defineParametro("idCp", ppCp.getIdCp());
		else
			return null;
	
		// Se nao existir um refugo padrao definido entao pegar todos setando o id como zero
		OmCfg omcfg = Util.getConfigGeral(this.getDaoSession());
		if (omcfg.getDwTRefugo() != null)
			q.defineParametro("idTrefugo", omcfg.getDwTRefugo().getIdTrefugo());
		else
			q.defineParametro("idTrefugo",  0l);

		q.setMaxResults(1);

		DwConsolrelog dwConsolrelog = (DwConsolrelog) q.query().uniqueResult();

		return dwConsolrelog;
	}

	
	@SuppressWarnings("unused")
	public ListaRefugosDTO getRefugosDTO(FiltroPesquisaDTO filtro) {
		ListaRefugosDTO retorno = new ListaRefugosDTO();
		retorno.setItems(new ArrayList<RefugoCadDTO>());
		retorno.setMeta(new MetaDTO(filtro));
		
		MapQuery q = new MapQuery(this.getDaoSession());
				
		q.append("select DISTINCT t ");
		q.append("FROM DwTRefugo t");
		//q.append("JOIN FETCH t.dwTArea ta");
		//q.append("JOIN FETCH t.omTppt tp");
		q.append("where t.stAtivo = 1 ");
		q.append(" and t.omTppt.cdTppt = 'CIC' ");
		
		
		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){
			q.append("AND (");
			q.append(" upper(t.cdTrefugo) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.dsTrefugo) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		}
		
		q.append("order by t.cdTrefugo");
		
		List<DwTRefugo> listaPesquisa = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
 		for (DwTRefugo registro : listaPesquisa) {
 			RefugoCadDTO regDTO = new RefugoCadDTO();
 			regDTO.setIdRefugo(registro.getIdTrefugo().intValue());
 			regDTO.setCdRefugo(registro.getCdTrefugo());
 			regDTO.setDsRefugo(registro.getDsTrefugo());
 			regDTO.setCdArea(registro.getDwTArea() == null ? "" : registro.getDwTArea().getCdArea());
 			regDTO.setRequerAcao(registro.getIsRequerAcao()  == null ? false : registro.getIsRequerAcao());
 			regDTO.setRequerCausa(registro.getIsRequerCausa() == null ? false : registro.getIsRequerCausa());
 			regDTO.setStRegistro(registro.getStAtivo().intValue());
 			regDTO.setRevisao(registro.getRevisao().intValue());
 			regDTO.setTpPt("CIC");
 			
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
	public RefugoCadDTO getRefugoByCd(String cdRefugo) {
		RefugoCadDTO retorno = new RefugoCadDTO();
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select DISTINCT t ");
		q.append("FROM DwTRefugo t");
		//q.append("JOIN FETCH t.dwTArea ta");
		//q.append("JOIN FETCH t.omTppt tp");
		q.append("where t.stAtivo = 1 ");
		q.append(" and t.omTppt.cdTppt = 'CIC' ");
		
		q.append("AND t.cdTrefugo = :cdRefugo");
		q.append("order by t.cdTrefugo");
		
 		q.defineParametro("cdRefugo", cdRefugo);

 		List<DwTRefugo> lista = q.list();
 		
 		if (lista.size() == 1) {
 			retorno.setIdRefugo(lista.get(0).getIdTrefugo().intValue());
 			retorno.setCdRefugo(lista.get(0).getCdTrefugo());
 			retorno.setDsRefugo(lista.get(0).getDsTrefugo());
 			retorno.setCdArea(lista.get(0).getDwTArea() == null ? "" : lista.get(0).getDwTArea().getCdArea());
 			retorno.setRequerAcao(lista.get(0).getIsRequerAcao() == null ? false : lista.get(0).getIsRequerAcao());
 			retorno.setRequerCausa(lista.get(0).getIsRequerCausa() == null ? false : lista.get(0).getIsRequerCausa());
 			retorno.setStRegistro(lista.get(0).getStAtivo().intValue());
 			retorno.setRevisao(lista.get(0).getRevisao().intValue());
 			retorno.setTpPt("CIC");
	
 		}
		
		return retorno;
	}

}
