package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.OmCargo;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.OmCargoTemplate;
import idw.webservices.dto.OmCargoDTO;
import idw.webservices.dto.OmCargosDTO;
import idw.webservices.rest.idw.v2.dto.CargoDTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.ListaCargosDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;

/**
 *
 * @author milton
 *
 */
public class CargoRN extends AbstractRN<DAOGenerico> {

	public CargoRN() {
		this(null);
	}

	public CargoRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	/**
	 * Desativa todos os registros da tabela de cargos
	 * @param dataHoraDesativacao
	 * @param omUsr Usu�rio que desativou a cargo
	 */
	public void desativarCargos(Date dataHoraDesativacao, OmUsr omUsr){
		this.getDao().desativarMuitos(OmCargo.class, OmCargoTemplate._FIELD_NAME_CD, null, false, dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa registros da tabela de cargos
	 * @param listaCdCargoDevemFicarAtivos Lista de c�digos de devem ficar permanecer ativos
	 * @param dataHoraDesativacao
	 * @param omUsr Usu�rio que desativou a cargo
	 */
	public void desativarCargos(List<String> listaCdCargoDevemFicarAtivos, Date dataHoraDesativacao, OmUsr omUsr){
		this.getDao().desativarMuitos(OmCargo.class, OmCargoTemplate._FIELD_NAME_CD, listaCdCargoDevemFicarAtivos, true, dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa relacionado ao c�digo e tipo do posto de trabalho
	 * @param cdCargo
	 * @param date
	 * @param omUsr usu�rio que est� desativando
	 * @throws RegistroJaDesativadoException
	 * @throws RegistroDesconhecidoException
	 */
	public void desativarCargo(String cdCargo, Date date, OmUsr omUsr) throws RegistroDesconhecidoException, RegistroJaDesativadoException{
		this.getDao().desativar(OmCargo.class,cdCargo, OmCargoTemplate._FIELD_NAME_CD, null, date, omUsr);
	}

	/**
	 * Desativa {@code OmCargo} relacionado ao id da cargo
	 * @param idCargo
	 * @param dataHoraAtual
	 * @throws RegistroJaDesativadoException
	 */
	public void desativarCargo(long idCargo,  Date date, OmUsr omUsr) throws RegistroJaDesativadoException{
		this.getDao().desativar(OmCargo.class, idCargo, date, omUsr);
	}


	/**
	 * Pega {@code OmCargo} relacionado com o c�digo da cargo e que esteja ativo
	 * @param cdCargo
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public OmCargo getOmCargo(String cdCargo) throws RegistroDesconhecidoException{
		return this.getOmCargo(cdCargo, true);
	}

	/**
	 * Pega {@code OmCargo} �ltima revis�o relacionado com o c�digo da cargo
	 * @param cdCargo
	 * @param isFiltroAtivo se true, busca apenas o ativo
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public OmCargo getOmCargo(String cdCargo, boolean isFiltroAtivo) throws RegistroDesconhecidoException{
		return this.getDao().findByCd(OmCargo.class, cdCargo, OmCargoTemplate._FIELD_NAME_CD, null, isFiltroAtivo);
	}
	/**
	 * Pega {@code OmCargo} relacionado com o id
	 * @param idCargo
	 * @return
	 */
	public OmCargo getOmCargo(long idCargo){
		return this.getDao().findById(OmCargo.class, idCargo, false);
	}


	public void salvarDesativandoOriginal(OmCargo omCargoDB, OmCargo omCargo, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(omCargoDB, omCargo, dateOperacao, omUsrOperacao);
	}

	public void salvarDesativandoOriginal(OmCargo omCargo, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(omCargo, dateOperacao, omUsrOperacao);
	}

	@SuppressWarnings("unchecked")
	public OmCargosDTO getTodosOmCargosAtivos(){
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("select omcargo");
		q.append("from OmCargo omcargo");
		q.append("where omcargo.stAtivo = 1");
		q.append("order by omcargo.idCargo");
		List<OmCargo> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<OmCargoDTO> lista = new ArrayList<OmCargoDTO>();

		if (listaPesquisa != null) {
			for (OmCargo item : listaPesquisa) {
				OmCargoDTO OmCargoDTO = new OmCargoDTO();
				OmCargoDTO.setOmCargo(item.clone());
				lista.add(OmCargoDTO);
			}
		}

		OmCargosDTO listaRetorno = new OmCargosDTO();
		listaRetorno.setListaOmCargoDTO(lista);

		return listaRetorno;
	}
	
	@SuppressWarnings("unchecked")
	public OmCargosDTO getCargo(OmCargoDTO filtro){
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t ");
		q.append("from OmCargo t ");
		q.append("where 1=1 ");

		if(filtro.getOmCargo().getIdCargo() != 0){
			q.append("AND t.idCargo=:idCargo ");
		}else{
			if(filtro.getOmCargo().getCdCargo()!=null && !filtro.getOmCargo().getCdCargo().equals("")){
				q.append("AND t.cdCargo=:cdCargo ");
			}
			if(filtro.getOmCargo().getDsCargo()!=null &&
					!filtro.getOmCargo().getDsCargo().equals("")){
				q.append("AND t.dsCargo=:dsCargo ");
			}
			if((filtro.getOmCargo().getOmUsrByIdUsrstativo()!= null)
					&& (filtro.getOmCargo().getOmUsrByIdUsrstativo().getCdUsr() != null)
					&& (!filtro.getOmCargo().getOmUsrByIdUsrstativo().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.cdUsr=:cdUsrSt ");
			}
			if((filtro.getOmCargo().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getOmCargo().getOmUsrByIdUsrstativo().getDsNome() != null)
					&& (!filtro.getOmCargo().getOmUsrByIdUsrstativo().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.dsNome=:dsNomeSt ");
			}
			if((filtro.getOmCargo().getOmUsrByIdUsrrevisao()!= null)
					&& (filtro.getOmCargo().getOmUsrByIdUsrrevisao().getCdUsr() != null)
					&& (!filtro.getOmCargo().getOmUsrByIdUsrrevisao().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.cdUsr=:cdUsrRev ");
			}
			if((filtro.getOmCargo().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getOmCargo().getOmUsrByIdUsrrevisao().getDsNome() != null)
					&& (!filtro.getOmCargo().getOmUsrByIdUsrrevisao().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.dsNome=:dsNomeRev ");
			}
			if(filtro.getOmCargo().getDtRevisao() != null){
				q.append("AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ");
			}
			if(filtro.getOmCargo().getDtStativo() != null){
				q.append("AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF ");
			}
			if (filtro.getOmCargo().getRevisao()==null){
				q.append("AND t.revisao = (SELECT max(tr.revisao) as Revisao from OmCargo tr where tr.cdCargo = t.cdCargo ) ");
		    }else{
				q.append("AND t.revisao=:revisao ");
			}
			if (filtro.getOmCargo().getStAtivo() != null && filtro.getOmCargo().getStAtivo()<(byte)2){
				q.append("AND t.stAtivo=:stAtivo ");
			}
		}
		if(filtro.getOmCargo().getIdCargo()!=0){
			q.defineParametro("idCargo", filtro.getOmCargo().getIdCargo());
		}
		if(filtro.getOmCargo().getCdCargo() != null){
			q.defineParametro("cdCargo", filtro.getOmCargo().getCdCargo());
		}
		if(filtro.getOmCargo().getDsCargo()!=null){
			q.defineParametro("dsCargo", filtro.getOmCargo().getDsCargo());
		}
		if(filtro.getOmCargo().getDtRevisao()!=null){
			q.defineParametro("dtRevisao", filtro.getOmCargo().getDtRevisao());
			q.defineParametro("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getOmCargo().getDtRevisao()));
		}

		if(filtro.getOmCargo().getDtStativo()!=null){
			q.defineParametro("dtStativo", filtro.getOmCargo().getDtStativo());
			q.defineParametro("dtStativoF",DataHoraRN.getDataHora235959(filtro.getOmCargo().getDtStativo()));
		}

		q.defineParametro("revisao", filtro.getOmCargo().getRevisao());
		q.defineParametro("stAtivo", filtro.getOmCargo().getStAtivo());

		if (filtro.getOmCargo().getOmUsrByIdUsrrevisao() != null) {
			q.defineParametro("cdUsrRev", filtro.getOmCargo().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getOmCargo().getOmUsrByIdUsrrevisao().getDsNome());
		}

		if (filtro.getOmCargo().getOmUsrByIdUsrstativo() != null){
			q.defineParametro("cdUsrSt", filtro.getOmCargo().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getOmCargo().getOmUsrByIdUsrstativo().getDsNome());
		}

		List<OmCargo> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<OmCargoDTO> lista = new ArrayList<OmCargoDTO>();

		if (listaPesquisa != null) {
			for (OmCargo item : listaPesquisa) {
				OmCargoDTO OmCargoDTO = new OmCargoDTO();
				OmCargoDTO.setOmCargo(item.clone());
				lista.add(OmCargoDTO);
			}
		}

		OmCargosDTO listaRetorno = new OmCargosDTO();
		listaRetorno.setListaOmCargoDTO(lista);

		return listaRetorno;
	}
	
	public OmCargoDTO setOmCargo(OmCargoDTO itemDTO) {
		OmCargo itemOriginal = new OmCargo();
		itemOriginal = itemDTO.getOmCargo().clone();

		OmUsr omUser = new OmUsr();
		UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
		try {
			omUser = usuarioRN.getOmUsr(itemOriginal.getOmUsrByIdUsrrevisao().getCdUsr());
		} catch (RegistroDesconhecidoException e) {
			e.printStackTrace();
		}
		

		//20160928FVA:
		if (itemOriginal != null  && itemOriginal.getIdCargo() > 0 && itemOriginal.getStAtivo().equals((byte)0)) {
			itemDTO.setResultadoEvento(itemDTO.getERRO_REATIVACAO_INDISPONIVEL());
			return itemDTO;
		}
		
		salvarDesativandoOriginal(itemOriginal, new Date(), omUser);
		
		return itemDTO;
		
	}
	
	public OmCargosDTO removeOmCargo(OmCargosDTO itens){
		List<OmCargoDTO> listaRetorno = new ArrayList<OmCargoDTO>();

			for(OmCargoDTO item: itens.getListaOmCargoDTO()){
				OmUsr omUser = new OmUsr();
				UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
				try {
					omUser = usuarioRN.getOmUsr(item.getOmCargo().getOmUsrByIdUsrrevisao().getCdUsr());
				} catch (RegistroDesconhecidoException e) {
					e.printStackTrace();
				}
				try {
					desativarCargo(item.getOmCargo().getIdCargo(),new Date(), omUser);
				} catch (RegistroJaDesativadoException e) {
					e.printStackTrace();
				}
				listaRetorno.add(item);
			}

			OmCargosDTO itensRetorno = new OmCargosDTO();
			itensRetorno.setListaOmCargoDTO(listaRetorno);
			return itensRetorno;
		}
	
	
	@SuppressWarnings("unused")
	public ListaCargosDTO getCargosDTO(FiltroPesquisaDTO filtro) {
		ListaCargosDTO retorno = new ListaCargosDTO();
		retorno.setItems(new ArrayList<CargoDTO>());
		retorno.setMeta(new MetaDTO(filtro));
		
		MapQuery q = new MapQuery(this.getDaoSession());
		
		q.append("select t ");
		q.append("from OmCargo t ");
		q.append("where t.stAtivo = 1 ");
		
		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){
			q.append("AND (");
			q.append(" upper(t.cdCargo) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.dsCargo) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		}
		
		q.append("order by t.cdCargo");
		
		
		List<OmCargo> listaPesquisa = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
 		for (OmCargo registro : listaPesquisa) {
 			CargoDTO regDTO = new CargoDTO();
 			regDTO.setIdCargo(registro.getIdCargo());
 			regDTO.setCdCargo(registro.getCdCargo());
 			regDTO.setDsCargo(registro.getDsCargo());
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
	public CargoDTO getCargoByCd(String cdCargo) {
		CargoDTO retorno = new CargoDTO();
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select t ");
		q.append("from OmCargo t ");
		q.append("where t.stAtivo = 1 ");
		q.append("AND t.cdCargo = :cdCargo");
		q.append("order by t.cdCargo");
		
 		q.defineParametro("cdCargo", cdCargo);

 		List<OmCargo> lista = q.list();
 		
 		if (lista.size() == 1) {
 			
 			retorno.setIdCargo(lista.get(0).getIdCargo());
 			retorno.setCdCargo(lista.get(0).getCdCargo());
 			retorno.setDsCargo(lista.get(0).getDsCargo());
 			retorno.setStRegistro(lista.get(0).getStAtivo().intValue());
 			
 		}
		
		return retorno;
	}
	
	
}
