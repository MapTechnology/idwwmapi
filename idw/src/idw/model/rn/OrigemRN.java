package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwTOrigemDAO;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.DwTOrigem;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.DwTOrigemTemplate;
import idw.util.IdwLogger;
import idw.webservices.dto.DwTOrigemDTO;
import idw.webservices.dto.DwTOrigensDTO;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasDTO;
import idw.webservices.dto.ResultadoDTO;

@SuppressWarnings("unchecked")
public class OrigemRN extends AbstractRN<DAOGenerico> {

	public OrigemRN() {
		this(null);
	}

	public OrigemRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	/**
	 * Desativa todos os registros da tabela de origens
	 * @param dataHoraDesativacao
	 * @param omUsr Usuário que desativou a origem
	 */
	public void desativarOrigens(Date dataHoraDesativacao, OmUsr omUsr){
		this.getDao().desativarMuitos(DwTOrigem.class, DwTOrigemTemplate._FIELD_NAME_CD, null, false, dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa registros da tabela de origens
	 * @param listaCdOrigemDevemFicarAtivos Lista de códigos de devem ficar permanecer ativos
	 * @param dataHoraDesativacao
	 * @param omUsr Usuário que desativou a origem
	 */
	public void desativarOrigens(List<String> listaCdOrigemDevemFicarAtivos, Date dataHoraDesativacao, OmUsr omUsr){
		this.getDao().desativarMuitos(DwTOrigem.class, DwTOrigemTemplate._FIELD_NAME_CD, listaCdOrigemDevemFicarAtivos, true, dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa relacionado ao código e tipo do posto de trabalho
	 * @param cdOrigem
	 * @param omTppt
	 * @param date
	 * @param omUsr usuário que está desativando
	 * @throws RegistroJaDesativadoException
	 * @throws RegistroDesconhecidoException
	 */
	public void desativarOrigem(String cdOrigem, OmTppt omTppt, Date date, OmUsr omUsr) throws RegistroDesconhecidoException, RegistroJaDesativadoException{
		this.getDao().desativar(DwTOrigem.class,cdOrigem, DwTOrigemTemplate._FIELD_NAME_CD, omTppt, date, omUsr);
	}

	/**
	 * Desativa {@code DwTOrigem} relacionado ao id da origem
	 * @param idOrigem
	 * @param dataHoraAtual
	 * @throws RegistroJaDesativadoException
	 */
	public void desativarOrigem(long idOrigem,  Date date, OmUsr omUsr) throws RegistroJaDesativadoException{
		this.getDao().desativar(DwTOrigem.class, idOrigem, date, omUsr);
	}

	/**
	 * Pega {@code DwTOrigem} relacionado com o código da origem e que esteja ativo, relacionado com o {@code omTppt}
	 * @param cdOrigem
	 * @param omTppt
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwTOrigem getDwTOrigem(String cdOrigem, OmTppt omTppt) throws RegistroDesconhecidoException{
		return this.getDwTOrigem(cdOrigem, omTppt, true);
	}

	/**
	 * Pega {@code DwTOrigem} última revisão com o código da origem
	 * @param cdOrigem
	 * @param omTppt
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwTOrigem getDwTOrigem(String cdOrigem, OmTppt omTppt, boolean isFiltroAtivo) throws RegistroDesconhecidoException{
		return this.getDao().findByCd(DwTOrigem.class, cdOrigem, DwTOrigemTemplate._FIELD_NAME_CD, omTppt, isFiltroAtivo);
	}

	/**
	 * Pega {@code DwTOrigem} relacionado com o id
	 * @param idOrigem
	 * @return
	 */
	public DwTOrigem getDwTOrigem(long idOrigem){
		return this.getDao().findById(DwTOrigem.class, idOrigem, false);
	}


	public void salvarDesativandoOriginal(DwTOrigem dwTOrigemDB, DwTOrigem dwTOrigem, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(dwTOrigemDB, dwTOrigem, dateOperacao, omUsrOperacao);
	}

	public DwTOrigem salvarDesativandoOriginal(DwTOrigem dwTOrigem, Date dateOperacao, OmUsr omUsrOperacao) {
		return this.getDao().salvarDesativandoOriginal(dwTOrigem, dateOperacao, omUsrOperacao);
	}
	
	public DwTOrigensDTO getTOrigem(Long idTppt){
		
		MapQuery q = new MapQuery(this.getDao().getSession());
		
		q.append("select t ");
		q.append("from DwTOrigem t ");
		q.append("where t.stAtivo=1 ");	
		q.append("AND t.omTppt.idTppt=:idTppt ");
		q.defineParametro("idTppt", idTppt);
	
		List<DwTOrigem> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<DwTOrigemDTO> lista = new ArrayList<DwTOrigemDTO>();

		if (listaPesquisa != null) {
			for (DwTOrigem item : listaPesquisa) {
				DwTOrigemDTO dwTOrigemDTO = new DwTOrigemDTO();
				dwTOrigemDTO.setDwTOrigem(item.clone());
				lista.add(dwTOrigemDTO);
			}
		}

		DwTOrigensDTO listaRetorno = new DwTOrigensDTO();
		listaRetorno.setListaOrigensDTO(lista);

		return listaRetorno;
		
	}
	
	public DwTOrigensDTO getTOrigem(DwTOrigemDTO filtro){
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "OrigemRN.getTOrigem");
		log.info( idLog , 0, "OrigemRN.getTOrigem filtro usado:" + filtro.toString());
		
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t ");
		q.append("from DwTOrigem t ");
		q.append("where 1=1 ");	

		if(filtro.getDwTOrigem().getIdOrigem()!=0){
			q.append("AND t.idOrigem=:idOrigem ");
		}else{
			
			if(filtro.getDwTOrigem().getCdOrigem()!=null && !filtro.getDwTOrigem().getCdOrigem().equals("")){
				q.append("AND t.cdOrigem=:cdOrigem ");
			}
			
			if(filtro.getDwTOrigem().getDsOrigem()!=null && !filtro.getDwTOrigem().getDsOrigem().equals("")){
				q.append("AND t.dsOrigem=:dsOrigem ");
			}
			
			if (filtro.getDwTOrigem().getOmTppt() != null && !filtro.getDwTOrigem().getOmTppt().getCdTppt().equals("")){
				q.append("AND t.omTppt.cdTppt=:cdTppt ");
			}
			if (filtro.getDwTOrigem().getOmTppt() != null && !filtro.getDwTOrigem().getOmTppt().getDsTppt().equals("")){
				q.append("AND t.omTppt.dsTppt=:dsTppt ");
			}
			if((filtro.getDwTOrigem().getOmUsrByIdUsrstativo()!= null) && 
			   (filtro.getDwTOrigem().getOmUsrByIdUsrstativo().getCdUsr() != null) &&
			   (!filtro.getDwTOrigem().getOmUsrByIdUsrstativo().getCdUsr().equals(""))) {
				
				q.append("AND t.omUsrByIdUsrstativo.cdUsr=:cdUsrSt ");
			
			}
			
			if((filtro.getDwTOrigem().getOmUsrByIdUsrstativo() != null) &&
               (filtro.getDwTOrigem().getOmUsrByIdUsrstativo().getDsNome() != null) &&
               (!filtro.getDwTOrigem().getOmUsrByIdUsrstativo().getDsNome().equals(""))) {
				
				q.append("AND t.omUsrByIdUsrstativo.dsNome=:dsNomeSt ");
			
			}
			
			if((filtro.getDwTOrigem().getOmUsrByIdUsrrevisao()!= null) &&
               (filtro.getDwTOrigem().getOmUsrByIdUsrrevisao().getCdUsr() != null) &&
               (!filtro.getDwTOrigem().getOmUsrByIdUsrrevisao().getCdUsr().equals(""))) {
				
				q.append("AND t.omUsrByIdUsrrevisao.cdUsr=:cdUsrRev ");
				
			}
			
			if((filtro.getDwTOrigem().getOmUsrByIdUsrrevisao() != null) &&
               (filtro.getDwTOrigem().getOmUsrByIdUsrrevisao().getDsNome() != null) &&
               (!filtro.getDwTOrigem().getOmUsrByIdUsrrevisao().getDsNome().equals(""))) {
				
				q.append("AND t.omUsrByIdUsrrevisao.dsNome=:dsNomeRev ");
				
			}
			
			if(filtro.getDwTOrigem().getDtRevisao() != null) {
				q.append("AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ");
			}
			
			if(filtro.getDwTOrigem().getDtStativo() != null) {
				q.append("AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF ");
			}
			
			if (filtro.getDwTOrigem().getRevisao()==null) {
				q.append("AND t.revisao = (SELECT max(tr.revisao) as Revisao from DwTOrigem tr where tr.cdOrigem = t.cdOrigem ) ");
			}else{
				q.append("AND t.revisao=:revisao ");
			}
			
			if (filtro.getDwTOrigem().getStAtivo() != null && filtro.getDwTOrigem().getStAtivo() < (byte)2) {
				q.append("AND t.stAtivo=:stAtivo ");
			}
		
		}

		q.defineParametro("idOrigem", filtro.getDwTOrigem().getIdOrigem());
		q.defineParametro("cdOrigem", filtro.getDwTOrigem().getCdOrigem());
		q.defineParametro("dsOrigem", filtro.getDwTOrigem().getDsOrigem());

		if(filtro.getDwTOrigem().getOmTppt()!= null){
			q.defineParametro("cdTppt", filtro.getDwTOrigem().getOmTppt().getCdTppt());
			q.defineParametro("dsTppt", filtro.getDwTOrigem().getOmTppt().getDsTppt());
		}

		if(filtro.getDwTOrigem().getDtRevisao()!=null){
			q.defineParametro("dtRevisao", filtro.getDwTOrigem().getDtRevisao());
			q.defineParametro("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getDwTOrigem().getDtRevisao()));
		}

		if(filtro.getDwTOrigem().getDtStativo()!=null){
			q.defineParametro("dtStativo", filtro.getDwTOrigem().getDtStativo());
			q.defineParametro("dtStativoF",DataHoraRN.getDataHora235959(filtro.getDwTOrigem().getDtStativo()));
		}

		q.defineParametro("revisao", filtro.getDwTOrigem().getRevisao());
		q.defineParametro("stAtivo", filtro.getDwTOrigem().getStAtivo());

		if (filtro.getDwTOrigem().getOmUsrByIdUsrrevisao() != null) {
			q.defineParametro("cdUsrRev", filtro.getDwTOrigem().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getDwTOrigem().getOmUsrByIdUsrrevisao().getDsNome());
		}

		if (filtro.getDwTOrigem().getOmUsrByIdUsrstativo() != null){
			q.defineParametro("cdUsrSt", filtro.getDwTOrigem().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getDwTOrigem().getOmUsrByIdUsrstativo().getDsNome());
		}

		List<DwTOrigem> listaPesquisa = null;
		
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<DwTOrigemDTO> lista = new ArrayList<DwTOrigemDTO>();

		if (listaPesquisa != null) {
			
			for (DwTOrigem item : listaPesquisa) {
				DwTOrigemDTO dwTOrigemDTO = new DwTOrigemDTO();
				dwTOrigemDTO.setDwTOrigem(item.clone());
				lista.add(dwTOrigemDTO);
			}
		
		}

		DwTOrigensDTO listaRetorno = new DwTOrigensDTO();
		
		listaRetorno.setListaOrigensDTO(lista);

		log.mostrarAvaliacaoCompleta();
		
		return listaRetorno;
	
	}
	
	public DwTOrigemDTO setTOrigem(DwTOrigemDTO itemDTO) {
		
		itemDTO.setResultado(new ResultadoDTO());
		
		if (itemDTO.getDwTOrigem() == null || 
			itemDTO.getDwTOrigem().getCdOrigem() == null || 
			itemDTO.getDwTOrigem().getCdOrigem().equals("")) {
			itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().CODIGO_DESCONHECIDO);
			return itemDTO;
		}

		OmTppt omTppt = new OmTppt();
		
		DwTOrigem itemOriginal = new DwTOrigem();
		
		itemOriginal = itemDTO.getDwTOrigem().clone();
		
		//20160926FVA:
		if (itemOriginal != null && itemOriginal.getIdOrigem() > 0 && itemOriginal.getStAtivo().equals((byte)0)){
			ResultadoDTO resultadodto = new ResultadoDTO();
			resultadodto.setIdmensagem(resultadodto.getERRO_REATIVACAO_INDISPONIVEL());
			itemDTO.setResultado(resultadodto);
			return itemDTO;
		}
		

		TpptRN tpptRN = new TpptRN(this.getDao());
		
		omTppt = tpptRN.getOmTpptDTO(itemDTO.getDwTOrigem().getOmTppt());
		
		itemOriginal.setOmTppt(omTppt);
		
		// Pesquisar o registro
		DwTOrigem pojo = null;
		
		if (itemOriginal.getIdOrigem() > 0) {
			pojo = getDwTOrigem(itemOriginal.getIdOrigem());
		}
		
		if (pojo != null && pojo.getStAtivo().equals((byte) 0) ) {
			itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().ERRO_EXCLUI_STATIVO_ZERO );
			return itemDTO;
		}
		
		if (pojo == null) {
			
			try {
				
				pojo = getDwTOrigem(itemOriginal.getCdOrigem(), omTppt);
				
				if (pojo != null) {
					itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().REGISTRO_JA_EXISTE);
					return itemDTO;
				}
			
			}catch (RegistroDesconhecidoException e) {
				pojo = null;
			}
		
		}
		
		itemDTO.setDwTOrigem(salvarDesativandoOriginal(itemOriginal, new Date(), itemDTO.getDwTOrigem().getOmUsrByIdUsrrevisao()).clone());
		
		return itemDTO;
	
	}

	public DwTOrigensDTO removeTOrigem(DwTOrigensDTO itens){
		
		List<DwTOrigemDTO> listaRetorno = new ArrayList<DwTOrigemDTO>();

		for(DwTOrigemDTO item: itens.getListaOrigensDTO()){
			
			OmUsr omUser = new OmUsr();
			
			UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
			
			try {
				omUser = usuarioRN.getOmUsr(item.getDwTOrigem().getOmUsrByIdUsrrevisao().getCdUsr());
			} catch (RegistroDesconhecidoException e) {
				e.printStackTrace();
			}
			
			try {
				desativarOrigem(item.getDwTOrigem().getIdOrigem(),new Date(), omUser);
				item.getDwTOrigem().setStAtivo((byte) 0);
			} catch (RegistroJaDesativadoException e) {
				e.printStackTrace();
			}
			
			listaRetorno.add(item);
		
		}

		DwTOrigensDTO itensRetorno = new DwTOrigensDTO();
		
		itensRetorno.setListaOrigensDTO(listaRetorno);
		
		return itensRetorno;
	
	}

	public DwTOrigem getDwTOrigem(String cd) {
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select dwtorigem");
		q.append("from DwTOrigem dwtorigem");
		q.append("where dwtorigem.stAtivo = 1");
		q.append("and dwtorigem.cdOrigem = :cdorigem");
		q.append("order by dwtorigem.idOrigem desc");
		
		q.setMaxResults(1);
		
		q.defineParametro("cdorigem", cd);
		
		return (DwTOrigem) q.uniqueResult();
	
	}

	public List<DwTOrigem> getDwTOrigens(String cd) {
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select dwtorigem");
		q.append("from DwTOrigem dwtorigem");
		q.append("where dwtorigem.stAtivo = 1");
		q.append("and dwtorigem.cdOrigem = :cdorigem");
		q.append("order by dwtorigem.idOrigem desc");
		
		q.defineParametro("cdorigem", cd);
		
		return q.list();
	
	}
	
	public PesquisasDTO pesquisaDwTOrigem(PesquisaDTO filtro){
		
		DwTOrigemDAO origemDAO = new DwTOrigemDAO(getDaoSession());
		
		String cdtppt = "";
		
		if (filtro.getRegistro() != null && filtro.getRegistro() instanceof OmTppt) {
			OmTppt omtppt = (OmTppt) filtro.getRegistro();
			cdtppt = omtppt.getCdTppt();
		}
		
		List<DwTOrigem> listaOrigens = origemDAO.getOrigemAtivas(filtro.getCodigo(), filtro.getDescricao(), cdtppt);
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();
		
		for (DwTOrigem origem : listaOrigens) {
			PesquisaDTO itemDTO = new PesquisaDTO();
			itemDTO.setCodigo(origem.getCdOrigem());
			itemDTO.setDescricao(origem.getDsOrigem());
			itemDTO.setRegistro(origem.clone());
			listaDTO.add(itemDTO);
		}
		
		PesquisasDTO retorno = new PesquisasDTO();
		
		retorno.setPesquisa(listaDTO);
		
		return retorno;
	
	}
	
}