package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwTJustDAO;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.DwTJust;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.DwTJustTemplate;
import idw.util.IdwLogger;
import idw.webservices.dto.DwTJustDTO;
import idw.webservices.dto.DwTJustsDTO;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasDTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.JustificativaDTO;
import idw.webservices.rest.idw.v2.dto.ListaJustificativasDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;

@SuppressWarnings("unchecked")
public class JustificativaRN extends AbstractRN<DAOGenerico> {

	public JustificativaRN() {
		this(null);
	}

	public JustificativaRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	/**
	 * Desativa todos os registros da tabela de justificativas
	 * @param dataHoraDesativacao
	 * @param omUsr Usuário que desativou a justificativa
	 */
	public void desativarJustificativas(Date dataHoraDesativacao, OmUsr omUsr){
		this.getDao().desativarMuitos(DwTJust.class, DwTJustTemplate._FIELD_NAME_CD, null, false, dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa registros da tabela de justificativas
	 * @param listaCdJustDevemFicarAtivos Lista de códigos de devem ficar permanecer ativos
	 * @param dataHoraDesativacao
	 * @param omUsr Usuário que desativou a justificativa
	 */
	public void desativarJustificativas(List<String> listaCdJustDevemFicarAtivos, Date dataHoraDesativacao, OmUsr omUsr){
		this.getDao().desativarMuitos(DwTJust.class, DwTJustTemplate._FIELD_NAME_CD, listaCdJustDevemFicarAtivos, true, dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa relacionado ao código e tipo do posto de trabalho
	 * @param cdJust
	 * @param omTppt
	 * @param date
	 * @param omUsr usuário que está desativando
	 * @throws RegistroJaDesativadoException
	 * @throws RegistroDesconhecidoException
	 */
	public void desativarJustificativa(String cdJust, OmTppt omTppt, Date date, OmUsr omUsr) throws RegistroDesconhecidoException, RegistroJaDesativadoException{
		this.getDao().desativar(DwTJust.class,cdJust, DwTJustTemplate._FIELD_NAME_CD, omTppt, date, omUsr);
	}

	/**
	 * Desativa {@code DwTJust} relacionado ao id da justificativa
	 * @param idJust
	 * @param dataHoraAtual
	 * @throws RegistroJaDesativadoException
	 */
	public void desativarJustificativa(long idJust,  Date date, OmUsr omUsr) throws RegistroJaDesativadoException{
		this.getDao().desativar(DwTJust.class, idJust, date, omUsr);
	}

	/**
	 * Pega {@code DwTJust} relacionado com o código da justificativa e que esteja ativo, relacionado com o {@code omTppt}
	 * @param cdJust
	 * @param omTppt
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwTJust getDwTJust(String cdJust, OmTppt omTppt) throws RegistroDesconhecidoException{
		return this.getDwTJust(cdJust, omTppt, true);
	}

	/**
	 * Pega {@code DwTJust} última revis�o relacionado com o código da justificativa e relacionado com o {@code omTppt}
	 * @param cdJust
	 * @param omTppt
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwTJust getDwTJust(String cdJust, OmTppt omTppt, boolean isFiltroAtivo) throws RegistroDesconhecidoException{
		return this.getDao().findByCd(DwTJust.class, cdJust, DwTJustTemplate._FIELD_NAME_CD, omTppt, isFiltroAtivo);
	}

	/**
	 * Pega {@code DwTJust} relacionado com o id
	 * @param idJust
	 * @return
	 */
	public DwTJust getDwTJust(long idJust){
		return this.getDao().findById(DwTJust.class, idJust, false);
	}

	public DwTJust salvarDesativandoOriginal(DwTJust dwTJustDB, DwTJust dwTJust, Date date, OmUsr omUsr){
		return this.getDao().salvarDesativandoOriginal(dwTJustDB, dwTJust, date, omUsr);
	}

	public DwTJust salvarDesativandoOriginal(DwTJust dwTJust, Date date, OmUsr omUsr){
		return this.getDao().salvarDesativandoOriginal(dwTJust, date, omUsr);
	}
	
	public DwTJustsDTO getTJustificativa(DwTJustDTO filtro){
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "JustificativaRN.getTJustificativa");
		log.info( idLog , 0, "JustificativaRN.getTJustificativa filtro usado:" + filtro.toString());
		
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t ");
		q.append("from DwTJust t ");
		q.append("where 1=1 ");	

		if(filtro.getDwTJust() != null && filtro.getDwTJust().getIdTjust() != null && filtro.getDwTJust().getIdTjust().equals(0l) == false){
			q.append("AND t.idTjust=:idTjust ");
		}else{
			if(filtro.getDwTJust() != null && filtro.getDwTJust().getCdTjust()!=null && !filtro.getDwTJust().getCdTjust().equals("")){
				q.append("AND t.cdTjust=:cdTjust ");
			}
			if(filtro.getDwTJust().getDsTjust()!=null &&
					!filtro.getDwTJust().getDsTjust().equals("")){
				q.append("AND t.dsTjust=:dsTjust ");
			}
			if (filtro.getDwTJust().getOmTppt() != null && !filtro.getDwTJust().getOmTppt().getCdTppt().equals("")){
				q.append("AND t.omTppt.cdTppt=:cdTppt ");
			}
			if (filtro.getDwTJust().getOmTppt() != null && !filtro.getDwTJust().getOmTppt().getDsTppt().equals("")){
				q.append("AND t.omTppt.dsTppt=:dsTppt ");
			}
			if((filtro.getDwTJust().getOmUsrByIdUsrstativo()!= null)
					&& (filtro.getDwTJust().getOmUsrByIdUsrstativo().getCdUsr() != null)
					&& (!filtro.getDwTJust().getOmUsrByIdUsrstativo().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.cdUsr=:cdUsrSt ");
			}
			if((filtro.getDwTJust().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getDwTJust().getOmUsrByIdUsrstativo().getDsNome() != null)
					&& (!filtro.getDwTJust().getOmUsrByIdUsrstativo().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.dsNome=:dsNomeSt ");
			}
			if((filtro.getDwTJust().getOmUsrByIdUsrrevisao()!= null)
					&& (filtro.getDwTJust().getOmUsrByIdUsrrevisao().getCdUsr() != null)
					&& (!filtro.getDwTJust().getOmUsrByIdUsrrevisao().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.cdUsr=:cdUsrRev ");
			}
			if((filtro.getDwTJust().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getDwTJust().getOmUsrByIdUsrrevisao().getDsNome() != null)
					&& (!filtro.getDwTJust().getOmUsrByIdUsrrevisao().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.dsNome=:dsNomeRev ");
			}
			if(filtro.getDwTJust().getDtRevisao() != null){
				q.append("AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ");
			}
			if(filtro.getDwTJust().getDtStativo() != null){
				q.append("AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF ");
			}
			if (filtro.getDwTJust().getRevisao()==null){
				q.append("AND t.revisao = (SELECT max(tr.revisao) as Revisao from DwTJust tr where tr.cdTjust = t.cdTjust ) ");
			}else{
				q.append("AND t.revisao=:revisao ");
			}
			if (filtro.getDwTJust().getStAtivo() != null && filtro.getDwTJust().getStAtivo()<(byte)2){
				q.append("AND t.stAtivo=:stAtivo ");
			}
		}

		q.defineParametro("idTjust", filtro.getDwTJust().getIdTjust());
		q.defineParametro("cdTjust", filtro.getDwTJust().getCdTjust());
		q.defineParametro("dsTjust", filtro.getDwTJust().getDsTjust());

		if(filtro.getDwTJust().getOmTppt()!= null){
			q.defineParametro("cdTppt", filtro.getDwTJust().getOmTppt().getCdTppt());
			q.defineParametro("dsTppt", filtro.getDwTJust().getOmTppt().getDsTppt());
		}

		if(filtro.getDwTJust().getDtRevisao()!=null){
			q.defineParametro("dtRevisao", filtro.getDwTJust().getDtRevisao());
			q.defineParametro("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getDwTJust().getDtRevisao()));
		}

		if(filtro.getDwTJust().getDtStativo()!=null){
			q.defineParametro("dtStativo", filtro.getDwTJust().getDtStativo());
			q.defineParametro("dtStativoF",DataHoraRN.getDataHora235959(filtro.getDwTJust().getDtStativo()));
		}

		q.defineParametro("revisao", filtro.getDwTJust().getRevisao());
		q.defineParametro("stAtivo", filtro.getDwTJust().getStAtivo());

		if (filtro.getDwTJust().getOmUsrByIdUsrrevisao() != null) {
			q.defineParametro("cdUsrRev", filtro.getDwTJust().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getDwTJust().getOmUsrByIdUsrrevisao().getDsNome());
		}

		if (filtro.getDwTJust().getOmUsrByIdUsrstativo() != null){
			q.defineParametro("cdUsrSt", filtro.getDwTJust().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getDwTJust().getOmUsrByIdUsrstativo().getDsNome());
		}

		List<DwTJust> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<DwTJustDTO> lista = new ArrayList<DwTJustDTO>();

		if (listaPesquisa != null) {
			for (DwTJust item : listaPesquisa) {
				DwTJustDTO dwTJustDTO = new DwTJustDTO();
				dwTJustDTO.setDwTJust(item.clone());
				lista.add(dwTJustDTO);
			}
		}

		DwTJustsDTO listaRetorno = new DwTJustsDTO();
		listaRetorno.setListaJustsDTO(lista);

		log.mostrarAvaliacaoCompleta();
		
		return listaRetorno;
	}

	
	public DwTJustsDTO getTJustificativa(Long idTppt) {
		
		MapQuery q = new MapQuery(this.getDao().getSession());
		
		q.append("select t ");
		q.append("from DwTJust t ");
		q.append("where t.stAtivo=1 ");	
		q.append("AND t.omTppt.idTppt=:idTppt ");
		q.defineParametro("idTppt", idTppt);
	
		List<DwTJust> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<DwTJustDTO> lista = new ArrayList<DwTJustDTO>();

		if (listaPesquisa != null) {
			for (DwTJust item : listaPesquisa) {
				DwTJustDTO dwTJustDTO = new DwTJustDTO();
				dwTJustDTO.setDwTJust(item.clone());
				lista.add(dwTJustDTO);
			}
		}

		DwTJustsDTO listaRetorno = new DwTJustsDTO();
		listaRetorno.setListaJustsDTO(lista);

		return listaRetorno;
	}

	
	public DwTJustDTO setTJustificativa(DwTJustDTO itemDTO) {
		OmTppt omTppt = new OmTppt();
		DwTJust itemOriginal = new DwTJust();
		itemOriginal = itemDTO.getDwTJust().clone();

		TpptRN tpptRN = new TpptRN(this.getDao());
		omTppt = tpptRN.getOmTpptDTO(itemDTO.getDwTJust().getOmTppt());
		itemOriginal.setOmTppt(omTppt);
		

		//20160928FVA:
		if (itemOriginal != null && itemOriginal.getId()!=null && itemOriginal.getIdTjust() > 0 && itemOriginal.getStAtivo().equals((byte)0)) {
			itemDTO.setResultadoEvento(itemDTO.getERRO_REATIVACAO_INDISPONIVEL());
			return itemDTO;
		}
		
		
		
		itemDTO.setDwTJust(salvarDesativandoOriginal(itemOriginal, new Date(), itemDTO.getDwTJust().getOmUsrByIdUsrrevisao()).clone());
		return itemDTO;
	}

	public DwTJustsDTO removeTJustificativa(DwTJustsDTO itens){
		List<DwTJustDTO> listaRetorno = new ArrayList<DwTJustDTO>();

		for(DwTJustDTO item: itens.getListaJustsDTO()){
			OmUsr omUser = new OmUsr();
			UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
			try {
				omUser = usuarioRN.getOmUsr(item.getDwTJust().getOmUsrByIdUsrrevisao().getCdUsr());
			} catch (RegistroDesconhecidoException e) {
				e.printStackTrace();
			}
			try {
				desativarJustificativa(item.getDwTJust().getIdTjust(),new Date(), omUser);
			} catch (RegistroJaDesativadoException e) {
				e.printStackTrace();
			}
			listaRetorno.add(item);
		}

		DwTJustsDTO itensRetorno = new DwTJustsDTO();
		itensRetorno.setListaJustsDTO(listaRetorno);
		return itensRetorno;
	}
	
	public DwTJust getDwTJust(String cd) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select dwtjust");
		q.append("from DwTJust dwtjust");
		q.append("where dwtjust.stAtivo = 1");
		q.append("and dwtjust.cdTjust = :cdtjust");
		q.append("order by dwtjust.idTjust desc");
		
		q.setMaxResults(1);
		q.defineParametro("cdtjust", cd);
		
		return (DwTJust) q.uniqueResult();
	}
	public List<DwTJust> getDwTJusts(String cd) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select dwtjust");
		q.append("from DwTJust dwtjust");
		q.append("where dwtjust.stAtivo = 1");
		q.append("and dwtjust.cdTjust = :cdtjust");
		q.append("order by dwtjust.idTjust desc");
		
		q.defineParametro("cdtjust", cd);
		
		return q.list();
	}
	
	public PesquisasDTO pesquisaDwTJust(PesquisaDTO filtro){
		DwTJustDAO justDAO = new DwTJustDAO(getDaoSession());
		String cdtppt = "";
		if (filtro.getRegistro() != null && filtro.getRegistro() instanceof OmTppt) {
			OmTppt omtppt = (OmTppt) filtro.getRegistro();
			cdtppt = omtppt.getCdTppt();
		}
		List<DwTJust> listaJust = justDAO.getDwTJust(filtro.getCodigo(), filtro.getDescricao(), cdtppt);
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();
		for (DwTJust just : listaJust) {
			PesquisaDTO itemDTO = new PesquisaDTO();
			itemDTO.setCodigo(just.getCdTjust());
			itemDTO.setDescricao(just.getDsTjust());
			itemDTO.setRegistro(just.clone());
			listaDTO.add(itemDTO);
		}
		PesquisasDTO retorno = new PesquisasDTO();
		retorno.setPesquisa(listaDTO);
		return retorno;
	}

	
	@SuppressWarnings("unused")
	public ListaJustificativasDTO getJustificativasDTO(FiltroPesquisaDTO filtro) {
		ListaJustificativasDTO retorno = new ListaJustificativasDTO();
		retorno.setItems(new ArrayList<JustificativaDTO>());
		retorno.setMeta(new MetaDTO(filtro));
		
		MapQuery q = new MapQuery(getDao().getSession());
		
		q.append("select t ");
		q.append("from DwTJust t ");
		q.append("where t.stAtivo = 1 ");
		q.append("and t.omTppt.cdTppt = 'CIC' "); 
		
		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){
			q.append("AND (");
			q.append(" upper(t.cdTjust) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.dsTjust) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		}
		
		q.append("order by t.cdTjust");
		
		// Lista do pojo
		List<DwTJust> listaPesquisa = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
		
 		for (DwTJust registro : listaPesquisa) {
 			
 			JustificativaDTO regDTO = new JustificativaDTO();
 			
 			regDTO.setIdJustificativa(registro.getIdTjust());
 			regDTO.setCdJustificativa(registro.getCdTjust());
 			regDTO.setDsJustificativa(registro.getDsTjust());
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
	public JustificativaDTO getJustificativaByCd(String cdJustificativa) {
		JustificativaDTO retorno = new JustificativaDTO();
		
		MapQuery q = new MapQuery(getDao().getSession());
		
		q.append("select t ");
		q.append("from DwTJust t ");
		q.append("where t.stAtivo = 1 ");
		q.append("and t.omTppt.cdTppt = 'CIC' ");
		q.append("and t.cdTjust = :cdJustificativa ");
		q.append("order by t.cdTjust");
		
 		q.defineParametro("cdJustificativa", cdJustificativa);

 		// Lista do pojo
 		List<DwTJust> lista = q.list();
 		
 		if (lista.size() == 1) {
 			
 			retorno.setIdJustificativa(lista.get(0).getIdTjust());
 			retorno.setCdJustificativa(lista.get(0).getCdTjust());
 			retorno.setDsJustificativa(lista.get(0).getDsTjust());
 			retorno.setTpPt(lista.get(0).getOmTppt().getCdTppt());
 			retorno.setStRegistro(lista.get(0).getStAtivo().intValue());
 			
 		}
		
		return retorno;
	}
	
}
