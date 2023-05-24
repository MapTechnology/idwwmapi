package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwTCausaDAO;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.DwTCausaTemplate;
import idw.util.IdwLogger;
import idw.webservices.dto.DwTCausaDTO;
import idw.webservices.dto.DwTCausasDTO;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasDTO;
import idw.webservices.dto.ResultadoDTO;
import idw.webservices.rest.idw.v2.dto.CausaDTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.ListaCausasDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;

@SuppressWarnings("unchecked")
public class CausaRN extends AbstractRN<DAOGenerico> {

	public CausaRN() {
		this(null);
	}

	public CausaRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	/**
	 * Desativa todos os registros da tabela de causas
	 * @param dataHoraDesativacao
	 * @param omUsr Usuário que desativou a causa
	 */
	public void desativarCausas(Date dataHoraDesativacao, OmUsr omUsr){
		this.getDao().desativarMuitos(DwTCausa.class, DwTCausaTemplate._FIELD_NAME_CD, null, false, dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa registros da tabela de causas
	 * @param listaCdCausaDevemFicarAtivos Lista de códigos de devem ficar permanecer ativos
	 * @param dataHoraDesativacao
	 * @param omUsr Usuário que desativou a causa
	 */
	public void desativarCausas(List<String> listaCdCausaDevemFicarAtivos, Date dataHoraDesativacao, OmUsr omUsr){
		this.getDao().desativarMuitos(DwTCausa.class, DwTCausaTemplate._FIELD_NAME_CD, listaCdCausaDevemFicarAtivos, true, dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa relacionado ao código e tipo do posto de trabalho
	 * @param cdCausa
	 * @param omTppt
	 * @param date
	 * @param omUsr usuário que está desativando
	 * @throws RegistroJaDesativadoException
	 * @throws RegistroDesconhecidoException
	 */
	public void desativarCausa(String cdCausa, OmTppt omTppt, Date date, OmUsr omUsr) throws RegistroDesconhecidoException, RegistroJaDesativadoException{
		this.getDao().desativar(DwTCausa.class,cdCausa, DwTCausaTemplate._FIELD_NAME_CD, omTppt, date, omUsr);
	}

	/**
	 * Desativa {@code DwTCausa} relacionado ao id da causa
	 * @param idCausa
	 * @param dataHoraAtual
	 * @throws RegistroJaDesativadoException
	 */
	public void desativarCausa(long idCausa,  Date date, OmUsr omUsr) throws RegistroJaDesativadoException{
		this.getDao().desativar(DwTCausa.class, idCausa, date, omUsr);
	}


	/**
	 * Pega {@code DwTCausa} relacionado com o código da causa e que esteja ativo, relacionado com o {@code omTppt}
	 * @param cdCausa
	 * @param omTppt
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwTCausa getDwTCausa(String cdCausa, OmTppt omTppt) throws RegistroDesconhecidoException{
		return this.getDwTCausa(cdCausa, omTppt, true);
	}

	/**
	 * Pega {@code DwTCausa} última revis�o com o código da causa
	 * @param cdCausa
	 * @param omTppt
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwTCausa getDwTCausa(String cdCausa, OmTppt omTppt, boolean isFiltroAtivo) throws RegistroDesconhecidoException{
		return this.getDao().findByCd(DwTCausa.class, cdCausa, DwTCausaTemplate._FIELD_NAME_CD, omTppt, isFiltroAtivo);
	}

	/**
	 * Pega {@code DwTCausa} relacionado com o id
	 * @param idCausa
	 * @return
	 */
	public DwTCausa getDwTCausa(long idCausa){
		return this.getDao().findById(DwTCausa.class, idCausa, false);
	}


	public void salvarDesativandoOriginal(DwTCausa dwTCausaDB, DwTCausa dwTCausa, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(dwTCausaDB, dwTCausa, dateOperacao, omUsrOperacao);
	}

	public DwTCausa salvarDesativandoOriginal(DwTCausa dwTCausa, Date dateOperacao, OmUsr omUsrOperacao) {
		return this.getDao().salvarDesativandoOriginal(dwTCausa, dateOperacao, omUsrOperacao);
	}
	
	public DwTCausasDTO getTCausa(Long idTppt){
		
		MapQuery q = new MapQuery(this.getDao().getSession());
		
		q.append("select t ");
		q.append("from DwTCausa t ");
		q.append("where t.stAtivo=1 ");	
		q.append("AND t.omTppt.idTppt=:idTppt ");
		q.defineParametro("idTppt", idTppt);
	
		List<DwTCausa> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<DwTCausaDTO> lista = new ArrayList<DwTCausaDTO>();

		if (listaPesquisa != null) {
			for (DwTCausa item : listaPesquisa) {
				DwTCausaDTO dwTCausaDTO = new DwTCausaDTO();
				dwTCausaDTO.setDwTCausa(item.clone());
				lista.add(dwTCausaDTO);
			}
		}

		DwTCausasDTO listaRetorno = new DwTCausasDTO();
		listaRetorno.setListaCausasDTO(lista);

		return listaRetorno;
		
	}
	
	public DwTCausasDTO getTCausa(DwTCausaDTO filtro){
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "CausaRN.getTCausa");
		log.info( idLog , 0, "CausaRN.getTCausa filtro usado:" + filtro.toString());
		
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t ");
		q.append("from DwTCausa t ");
		q.append("where 1=1 ");	

		if(filtro.getDwTCausa().getIdTcausa()!=0){
			q.append("AND t.idTcausa=:idTcausa ");
		}else{
			if(filtro.getDwTCausa().getCdTcausa()!=null && !filtro.getDwTCausa().getCdTcausa().equals("")){
				q.append("AND t.cdTcausa=:cdTcausa ");
			}
			if(filtro.getDwTCausa().getDsTcausa()!=null &&
					!filtro.getDwTCausa().getDsTcausa().equals("")){
				q.append("AND t.dsTcausa=:dsTcausa ");
			}
			if (filtro.getDwTCausa().getOmTppt() != null && !filtro.getDwTCausa().getOmTppt().getCdTppt().equals("")){
				q.append("AND t.omTppt.cdTppt=:cdTppt ");
			}
			if (filtro.getDwTCausa().getOmTppt() != null && !filtro.getDwTCausa().getOmTppt().getDsTppt().equals("")){
				q.append("AND t.omTppt.dsTppt=:dsTppt ");
			}
			if((filtro.getDwTCausa().getOmUsrByIdUsrstativo()!= null)
					&& (filtro.getDwTCausa().getOmUsrByIdUsrstativo().getCdUsr() != null)
					&& (!filtro.getDwTCausa().getOmUsrByIdUsrstativo().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.cdUsr=:cdUsrSt ");
			}
			if((filtro.getDwTCausa().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getDwTCausa().getOmUsrByIdUsrstativo().getDsNome() != null)
					&& (!filtro.getDwTCausa().getOmUsrByIdUsrstativo().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.dsNome=:dsNomeSt ");
			}
			if((filtro.getDwTCausa().getOmUsrByIdUsrrevisao()!= null)
					&& (filtro.getDwTCausa().getOmUsrByIdUsrrevisao().getCdUsr() != null)
					&& (!filtro.getDwTCausa().getOmUsrByIdUsrrevisao().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.cdUsr=:cdUsrRev ");
			}
			if((filtro.getDwTCausa().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getDwTCausa().getOmUsrByIdUsrrevisao().getDsNome() != null)
					&& (!filtro.getDwTCausa().getOmUsrByIdUsrrevisao().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.dsNome=:dsNomeRev ");
			}
			if(filtro.getDwTCausa().getDtRevisao() != null){
				q.append("AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ");
			}
			if(filtro.getDwTCausa().getDtStativo() != null){
				q.append("AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF ");
			}
			if (filtro.getDwTCausa().getRevisao()==null){
				q.append("AND t.revisao = (SELECT max(tr.revisao) as Revisao from DwTCausa tr where tr.cdTcausa = t.cdTcausa ) ");
			}else{
				q.append("AND t.revisao=:revisao ");
			}
			if (filtro.getDwTCausa().getStAtivo() != null && filtro.getDwTCausa().getStAtivo()<(byte)2){
				q.append("AND t.stAtivo=:stAtivo ");
			}
		}

		q.defineParametro("idTcausa", filtro.getDwTCausa().getIdTcausa());
		q.defineParametro("cdTcausa", filtro.getDwTCausa().getCdTcausa());
		q.defineParametro("dsTcausa", filtro.getDwTCausa().getDsTcausa());

		if(filtro.getDwTCausa().getOmTppt()!= null){
			q.defineParametro("cdTppt", filtro.getDwTCausa().getOmTppt().getCdTppt());
			q.defineParametro("dsTppt", filtro.getDwTCausa().getOmTppt().getDsTppt());
		}

		if(filtro.getDwTCausa().getDtRevisao()!=null){
			q.defineParametro("dtRevisao", filtro.getDwTCausa().getDtRevisao());
			q.defineParametro("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getDwTCausa().getDtRevisao()));
		}

		if(filtro.getDwTCausa().getDtStativo()!=null){
			q.defineParametro("dtStativo", filtro.getDwTCausa().getDtStativo());
			q.defineParametro("dtStativoF",DataHoraRN.getDataHora235959(filtro.getDwTCausa().getDtStativo()));
		}

		q.defineParametro("revisao", filtro.getDwTCausa().getRevisao());
		q.defineParametro("stAtivo", filtro.getDwTCausa().getStAtivo());

		if (filtro.getDwTCausa().getOmUsrByIdUsrrevisao() != null) {
			q.defineParametro("cdUsrRev", filtro.getDwTCausa().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getDwTCausa().getOmUsrByIdUsrrevisao().getDsNome());
		}

		if (filtro.getDwTCausa().getOmUsrByIdUsrstativo() != null){
			q.defineParametro("cdUsrSt", filtro.getDwTCausa().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getDwTCausa().getOmUsrByIdUsrstativo().getDsNome());
		}

		List<DwTCausa> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<DwTCausaDTO> lista = new ArrayList<DwTCausaDTO>();

		if (listaPesquisa != null) {
			for (DwTCausa item : listaPesquisa) {
				DwTCausaDTO dwTCausaDTO = new DwTCausaDTO();
				dwTCausaDTO.setDwTCausa(item.clone());
				lista.add(dwTCausaDTO);
			}
		}

		DwTCausasDTO listaRetorno = new DwTCausasDTO();
		listaRetorno.setListaCausasDTO(lista);

		log.mostrarAvaliacaoCompleta();
		
		return listaRetorno;
	}
	
	public DwTCausaDTO setTCausa(DwTCausaDTO itemDTO) {
		itemDTO.setResultado(new ResultadoDTO());
		if (
				itemDTO.getDwTCausa() == null || 
				itemDTO.getDwTCausa().getCdTcausa() == null || 
				itemDTO.getDwTCausa().getCdTcausa().equals("")  ) {
			itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().CODIGO_DESCONHECIDO);
			return itemDTO;
		}

		OmTppt omTppt = new OmTppt();
		DwTCausa itemOriginal = new DwTCausa();
		itemOriginal = itemDTO.getDwTCausa().clone();
		
		//20160926FVA:
		if (itemOriginal != null && itemOriginal.getIdTcausa() > 0 && itemOriginal.getStAtivo().equals((byte)0)){
			ResultadoDTO resultadodto = new ResultadoDTO();
			resultadodto.setIdmensagem(resultadodto.getERRO_REATIVACAO_INDISPONIVEL());
			itemDTO.setResultado(resultadodto);
			return itemDTO;
		}
		

		TpptRN tpptRN = new TpptRN(this.getDao());
		omTppt = tpptRN.getOmTpptDTO(itemDTO.getDwTCausa().getOmTppt());
		itemOriginal.setOmTppt(omTppt);
		// Pesquisar o registro
		DwTCausa pojo = null;
		if (itemOriginal.getIdTcausa() > 0) {
			pojo = getDwTCausa(itemOriginal.getIdTcausa());
		}
		if (pojo != null && pojo.getStAtivo().equals((byte) 0) ) {
			itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().ERRO_EXCLUI_STATIVO_ZERO );
			return itemDTO;
		}
		if (pojo == null) {
			try {
				pojo = getDwTCausa(itemOriginal.getCdTcausa(), omTppt);
				if (pojo != null) {
					itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().REGISTRO_JA_EXISTE);
					return itemDTO;
				}
			} catch (RegistroDesconhecidoException e) {
				pojo = null;
			}
		}
		
		itemDTO.setDwTCausa(salvarDesativandoOriginal(itemOriginal, new Date(), itemDTO.getDwTCausa().getOmUsrByIdUsrrevisao()).clone());
		return itemDTO;
	}

	public DwTCausasDTO removeTCausa(DwTCausasDTO itens){
		List<DwTCausaDTO> listaRetorno = new ArrayList<DwTCausaDTO>();

		for(DwTCausaDTO item: itens.getListaCausasDTO()){
			OmUsr omUser = new OmUsr();
			UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
			try {
				omUser = usuarioRN.getOmUsr(item.getDwTCausa().getOmUsrByIdUsrrevisao().getCdUsr());
			} catch (RegistroDesconhecidoException e) {
				e.printStackTrace();
			}
			try {
				desativarCausa(item.getDwTCausa().getIdTcausa(),new Date(), omUser);
				item.getDwTCausa().setStAtivo((byte) 0);
			} catch (RegistroJaDesativadoException e) {
				e.printStackTrace();
			}
			listaRetorno.add(item);
		}

		DwTCausasDTO itensRetorno = new DwTCausasDTO();
		itensRetorno.setListaCausasDTO(listaRetorno);
		return itensRetorno;
	}

	public DwTCausa getDwTCausa(String cd) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select dwtcausa");
		q.append("from DwTCausa dwtcausa");
		q.append("where dwtcausa.stAtivo = 1");
		q.append("and dwtcausa.cdTcausa = :cdtcausa");
		q.append("order by dwtcausa.idTcausa desc");
		
		q.setMaxResults(1);
		
		q.defineParametro("cdtcausa", cd);
		
		return (DwTCausa) q.uniqueResult();
	}

	public List<DwTCausa> getDwTCausas(String cd) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select dwtcausa");
		q.append("from DwTCausa dwtcausa");
		q.append("where dwtcausa.stAtivo = 1");
		q.append("and dwtcausa.cdTcausa = :cdtcausa");
		q.append("order by dwtcausa.idTcausa desc");
		
		q.defineParametro("cdtcausa", cd);
		
		return q.list();
	}
	
	public PesquisasDTO pesquisaDwTCausa(PesquisaDTO filtro){
		DwTCausaDAO causaDAO = new DwTCausaDAO(getDaoSession());
		String cdtppt = "";
		if (filtro.getRegistro() != null && filtro.getRegistro() instanceof OmTppt) {
			OmTppt omtppt = (OmTppt) filtro.getRegistro();
			cdtppt = omtppt.getCdTppt();
		}
		List<DwTCausa> listaCausas = causaDAO.getCausaAtivas(filtro.getCodigo(), filtro.getDescricao(), cdtppt);
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();
		for (DwTCausa causa : listaCausas) {
			PesquisaDTO itemDTO = new PesquisaDTO();
			itemDTO.setCodigo(causa.getCdTcausa());
			itemDTO.setDescricao(causa.getDsTcausa());
			itemDTO.setRegistro(causa.clone());
			listaDTO.add(itemDTO);
		}
		PesquisasDTO retorno = new PesquisasDTO();
		retorno.setPesquisa(listaDTO);
		return retorno;
	}


	@SuppressWarnings("unused")
	public ListaCausasDTO getCausasDTO(FiltroPesquisaDTO filtro) {
		ListaCausasDTO retorno = new ListaCausasDTO();
		retorno.setItems(new ArrayList<CausaDTO>());
		retorno.setMeta(new MetaDTO(filtro));
		
		MapQuery q = new MapQuery(this.getDaoSession());
		
		q.append("select t ");
		q.append("from DwTCausa t ");
		q.append("where t.stAtivo = 1 ");
		q.append("and t.omTppt.cdTppt = 'CIC' "); 
		
		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){
			q.append("AND (");
			q.append(" upper(t.cdTcausa) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.dsTcausa) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		}
		
		q.append("order by t.cdTcausa");
		
		// Lista do pojo
		List<DwTCausa> listaPesquisa = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
		
 		for (DwTCausa registro : listaPesquisa) {
 			
 			CausaDTO regDTO = new CausaDTO();
 			
 			regDTO.setIdCausa(registro.getIdTcausa());
 			regDTO.setCdCausa(registro.getCdTcausa());
 			regDTO.setDsCausa(registro.getDsTcausa());
 			regDTO.setTpPt(registro.getOmTppt().getCdTppt());
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
	public CausaDTO getCausaByCd(String cdCausa) {
		CausaDTO retorno = new CausaDTO();
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select t ");
		q.append("from DwTCausa t ");
		q.append("where t.stAtivo = 1 ");
		q.append("and t.omTppt.cdTppt = 'CIC' ");
		q.append("and t.cdTcausa = :cdCausa ");
		q.append("order by t.cdTcausa");
		
 		q.defineParametro("cdCausa", cdCausa);

 		// Lista do pojo
 		List<DwTCausa> lista = q.list();
 		
 		if (lista.size() == 1) {
 			
 			retorno.setIdCausa(lista.get(0).getIdTcausa());
 			retorno.setCdCausa(lista.get(0).getCdTcausa());
 			retorno.setDsCausa(lista.get(0).getDsTcausa());
 			retorno.setTpPt(lista.get(0).getOmTppt().getCdTppt());
 			retorno.setStRegistro(lista.get(0).getStAtivo().intValue());
 			
 		}
		
		return retorno;
	}
	
}
