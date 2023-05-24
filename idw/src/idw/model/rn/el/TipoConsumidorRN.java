package idw.model.rn.el;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.TeTipoConsumidorDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.OmUsr;
import idw.model.pojos.TeTipoConsumidor;
import idw.model.pojos.template.TeTipoConsumidorTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.UsuarioRN;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasDTO;
import idw.webservices.dto.TeTipoConsumidorDTO;
import idw.webservices.dto.TeTipoConsumidoresDTO;

public class TipoConsumidorRN extends AbstractRN<DAOGenerico> {

	public TipoConsumidorRN() {
		this(null);
	}

	public TipoConsumidorRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	/**
	 * Desativa todos os registros da tabela de TipoConsumidores
	 * @param dataHoraDesativacao
	 * @param omUsr Usu�rio que desativou a Concessionaria
	 */
	public void desativarTipoConsumidores(Date dataHoraDesativacao, OmUsr omUsr){
		this.getDao().desativarMuitos(TeTipoConsumidor.class, TeTipoConsumidorTemplate._FIELD_NAME_CD, null, false, dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa registros da tabela de TipoConsumidores
	 * @param listaCdTipoConsumidorDevemFicarAtivos Lista de c�digos de devem ficar permanecer ativos
	 * @param dataHoraDesativacao
	 * @param omUsr Usu�rio que desativou a TipoConsumidor
	 */
	public void desativarTipoConsumidores(List<String> listaCdTipoConsumidorDevemFicarAtivos, Date dataHoraDesativacao, OmUsr omUsr){
		this.getDao().desativarMuitos(TeTipoConsumidor.class, TeTipoConsumidorTemplate._FIELD_NAME_CD, listaCdTipoConsumidorDevemFicarAtivos, true, dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa relacionado ao c�digo e tipo do posto de trabalho
	 * @param cdTipoConsumidor
	 * @param date
	 * @param omUsr usu�rio que est� desativando
	 * @throws RegistroJaDesativadoException
	 * @throws RegistroDesconhecidoException
	 */
	public void desativarTipoConsumidor(String cdTipoConsumidor, Date date, OmUsr omUsr) throws RegistroDesconhecidoException, RegistroJaDesativadoException{
		this.getDao().desativar(TeTipoConsumidor.class,cdTipoConsumidor, TeTipoConsumidorTemplate._FIELD_NAME_CD, null, date, omUsr);
	}

	/**
	 * Desativa {@code TeTipoConsumidor} relacionado ao id da TipoConsumidor
	 * @param idTipoConsumidor
	 * @param dataHoraAtual
	 * @throws RegistroJaDesativadoException
	 */
	public void desativarTipoConsumidor(long idTipoConsumidor,  Date date, OmUsr omUsr) throws RegistroJaDesativadoException{
		this.getDao().desativar(TeTipoConsumidor.class, idTipoConsumidor, date, omUsr);
	}


	/**
	 * Pega {@code TeTipoConsumidor} relacionado com o c�digo da TipoConsumidor e que esteja ativo
	 * @param cdTipoConsumidor
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public TeTipoConsumidor getTeTipoConsumidor(String cdTipoConsumidor) throws RegistroDesconhecidoException{
		return this.getTeTipoConsumidor(cdTipoConsumidor, true);
	}

	/**
	 * Pega {@code TeTipoConsumidor} �ltima revis�o relacionado com o c�digo da TipoConsumidor
	 * @param cdTipoConsumidor
	 * @param isFiltroAtivo se true, busca apenas o ativo
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public TeTipoConsumidor getTeTipoConsumidor(String cdTipoConsumidor, boolean isFiltroAtivo) throws RegistroDesconhecidoException{
		return this.getDao().findByCd(TeTipoConsumidor.class, cdTipoConsumidor, TeTipoConsumidorTemplate._FIELD_NAME_CD, null, isFiltroAtivo);
	}
	/**
	 * Pega {@code TeTipoConsumidor} relacionado com o id
	 * @param idTipoConsumidor
	 * @return
	 */
	public TeTipoConsumidor getTeTipoConsumidor(long idTipoConsumidor){
		return this.getDao().findById(TeTipoConsumidor.class, idTipoConsumidor, false);
	}


	public void salvarDesativandoOriginal(TeTipoConsumidor teTipoConsumidorDB, TeTipoConsumidor teTipoConsumidor, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(teTipoConsumidorDB, teTipoConsumidor, dateOperacao, omUsrOperacao);
	}

	public void salvarDesativandoOriginal(TeTipoConsumidor teTipoConsumidor, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(teTipoConsumidor, dateOperacao, omUsrOperacao);
	}

	@SuppressWarnings("unchecked")
	public TeTipoConsumidoresDTO getTodosTeTipoConsumidoresAtivos(){
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("select teTipoConsumidor");
		q.append("from TeTipoConsumidor teTipoConsumidor");
		q.append("where teTipoConsumidor.stAtivo = 1");
		q.append("order by teTipoConsumidor.idTipoConsumidor");
		List<TeTipoConsumidor> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<TeTipoConsumidorDTO> lista = new ArrayList<TeTipoConsumidorDTO>();

		if (listaPesquisa != null) {
			for (TeTipoConsumidor item : listaPesquisa) {
				TeTipoConsumidorDTO TeTipoConsumidorDTO = new TeTipoConsumidorDTO();
				TeTipoConsumidorDTO.setTeTipoConsumidor(item.clone());
				lista.add(TeTipoConsumidorDTO);
			}
		}

		TeTipoConsumidoresDTO listaRetorno = new TeTipoConsumidoresDTO();
		listaRetorno.setListaTeTipoConsumidorDTO(lista);

		return listaRetorno;
	}
	
	@SuppressWarnings("unchecked")
	public TeTipoConsumidoresDTO getTeTipoConsumidor(TeTipoConsumidorDTO filtro){
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t ");
		q.append("from TeTipoConsumidor t ");
		q.append("where 1=1 ");

		if(filtro.getTeTipoConsumidor().getIdTipoConsumidor() != 0){
			q.append("AND t.idTipoConsumidor=:idTipoConsumidor ");
		}else{
			if(filtro.getTeTipoConsumidor().getCdTipoConsumidor()!=null && !filtro.getTeTipoConsumidor().getCdTipoConsumidor().equals("")){
				q.append("AND t.cdTipoConsumidor=:cdTipoConsumidor ");
			}
			if(filtro.getTeTipoConsumidor().getDsTipoConsumidor()!=null &&
					!filtro.getTeTipoConsumidor().getDsTipoConsumidor().equals("")){
				q.append("AND t.dsTipoConsumidor=:dsTipoConsumidor ");
			}
			if((filtro.getTeTipoConsumidor().getOmUsrByIdUsrstativo()!= null)
					&& (filtro.getTeTipoConsumidor().getOmUsrByIdUsrstativo().getCdUsr() != null)
					&& (!filtro.getTeTipoConsumidor().getOmUsrByIdUsrstativo().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.cdUsr=:cdUsrSt ");
			}
			if((filtro.getTeTipoConsumidor().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getTeTipoConsumidor().getOmUsrByIdUsrstativo().getDsNome() != null)
					&& (!filtro.getTeTipoConsumidor().getOmUsrByIdUsrstativo().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.dsNome=:dsNomeSt ");
			}
			if((filtro.getTeTipoConsumidor().getOmUsrByIdUsrrevisao()!= null)
					&& (filtro.getTeTipoConsumidor().getOmUsrByIdUsrrevisao().getCdUsr() != null)
					&& (!filtro.getTeTipoConsumidor().getOmUsrByIdUsrrevisao().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.cdUsr=:cdUsrRev ");
			}
			if((filtro.getTeTipoConsumidor().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getTeTipoConsumidor().getOmUsrByIdUsrrevisao().getDsNome() != null)
					&& (!filtro.getTeTipoConsumidor().getOmUsrByIdUsrrevisao().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.dsNome=:dsNomeRev ");
			}
			if(filtro.getTeTipoConsumidor().getDtRevisao() != null){
				q.append("AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ");
			}
			if(filtro.getTeTipoConsumidor().getDtStativo() != null){
				q.append("AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF ");
			}
			if (filtro.getTeTipoConsumidor().getRevisao()==null){
				q.append("AND t.revisao = (SELECT max(tr.revisao) as Revisao from TeTipoConsumidor tr where tr.cdTipoConsumidor = t.cdTipoConsumidor ) ");
		    }else{
				q.append("AND t.revisao=:revisao ");
			}
			if (filtro.getTeTipoConsumidor().getStAtivo() != null && filtro.getTeTipoConsumidor().getStAtivo()<(byte)2){
				q.append("AND t.stAtivo=:stAtivo ");
			}
		}
		if(filtro.getTeTipoConsumidor().getIdTipoConsumidor()!=0){
			q.defineParametro("idTipoConsumidor", filtro.getTeTipoConsumidor().getIdTipoConsumidor());
		}
		if(filtro.getTeTipoConsumidor().getCdTipoConsumidor() != null){
			q.defineParametro("cdTipoConsumidor", filtro.getTeTipoConsumidor().getCdTipoConsumidor());
		}
		if(filtro.getTeTipoConsumidor().getDsTipoConsumidor()!=null){
			q.defineParametro("dsTipoConsumidor", filtro.getTeTipoConsumidor().getDsTipoConsumidor());
		}
		if(filtro.getTeTipoConsumidor().getDtRevisao()!=null){
			q.defineParametro("dtRevisao", filtro.getTeTipoConsumidor().getDtRevisao());
			q.defineParametro("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getTeTipoConsumidor().getDtRevisao()));
		}

		if(filtro.getTeTipoConsumidor().getDtStativo()!=null){
			q.defineParametro("dtStativo", filtro.getTeTipoConsumidor().getDtStativo());
			q.defineParametro("dtStativoF",DataHoraRN.getDataHora235959(filtro.getTeTipoConsumidor().getDtStativo()));
		}

		q.defineParametro("revisao", filtro.getTeTipoConsumidor().getRevisao());
		q.defineParametro("stAtivo", filtro.getTeTipoConsumidor().getStAtivo());

		if (filtro.getTeTipoConsumidor().getOmUsrByIdUsrrevisao() != null) {
			q.defineParametro("cdUsrRev", filtro.getTeTipoConsumidor().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getTeTipoConsumidor().getOmUsrByIdUsrrevisao().getDsNome());
		}

		if (filtro.getTeTipoConsumidor().getOmUsrByIdUsrstativo() != null){
			q.defineParametro("cdUsrSt", filtro.getTeTipoConsumidor().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getTeTipoConsumidor().getOmUsrByIdUsrstativo().getDsNome());
		}

		List<TeTipoConsumidor> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<TeTipoConsumidorDTO> lista = new ArrayList<TeTipoConsumidorDTO>();

		if (listaPesquisa != null) {
			for (TeTipoConsumidor item : listaPesquisa) {
				TeTipoConsumidorDTO TeTipoConsumidorDTO = new TeTipoConsumidorDTO();
				TeTipoConsumidorDTO.setTeTipoConsumidor(item.clone());
				lista.add(TeTipoConsumidorDTO);
			}
		}

		TeTipoConsumidoresDTO listaRetorno = new TeTipoConsumidoresDTO();
		listaRetorno.setListaTeTipoConsumidorDTO(lista);

		return listaRetorno;
	}
	
	public TeTipoConsumidorDTO setTeTipoConsumidor(TeTipoConsumidorDTO itemDTO) {
		
		TeTipoConsumidorDTO retorno = new TeTipoConsumidorDTO();
		retorno.setResultadoEvento(retorno.getEVENTO_BEM_SUCEDIDO());
		
		if(itemDTO.getTeTipoConsumidor().getCdTipoConsumidor().equals("")) {
			retorno.setResultadoEvento(itemDTO.getERRO_CDCONSUMIDOR_INVALIDO());
			return retorno;
		}
		
		TeTipoConsumidorDAO dao = new TeTipoConsumidorDAO(getDaoSession());		
		TeTipoConsumidor itemOriginal = dao.getTeTipoConsumidorPorId(itemDTO.getTeTipoConsumidor().getIdTipoConsumidor());
		TeTipoConsumidor itemAlteracao = null;
		boolean isInclusao = false;
		
		if(itemOriginal == null) {
			itemOriginal = itemDTO.getTeTipoConsumidor().clone();
			itemOriginal.setRevisao(1l);
			itemOriginal.setDtRevisao(new Date());
			itemOriginal.setStAtivo((byte)1);
			itemOriginal.setDtStativo(new Date());			
			isInclusao = true;
			TeTipoConsumidor consumidorAux = dao.getTeTipoConsumidorPorCdAtivo(itemOriginal.getCdTipoConsumidor());
			if(consumidorAux != null) {
				retorno.setResultadoEvento(itemDTO.getERRO_CONSUMIDOR_JA_EXISTE());
				return retorno;
			}
			
		} else {
			itemAlteracao = new TeTipoConsumidor();
			itemAlteracao.copy(itemOriginal, true);
			itemAlteracao.setIdTipoConsumidor(0l);		
			itemAlteracao.setStAtivo((byte)0);
			itemOriginal.copy(itemDTO.getTeTipoConsumidor(), false);		
			itemOriginal.setDtRevisao(DataHoraRN.getDataHoraAtual());
			itemOriginal.setDtStativo(DataHoraRN.getDataHoraAtual());
			itemOriginal.setStAtivo((byte) 1);
		}
		
		if(isInclusao == false) {
			itemOriginal.setRevisao(itemAlteracao.getRevisao() + 1);
		}
		
		try {
			OmUsr usrStAtivo = (OmUsr) getDao().findById(OmUsr.class,itemDTO.getTeTipoConsumidor().getOmUsrByIdUsrstativo().getIdUsr() , false);
			itemOriginal.setOmUsrByIdUsrstativo(usrStAtivo);
		} catch (Exception e) {
			retorno.setResultadoEvento(retorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
			e.printStackTrace();
		}
		try {
			OmUsr usrRevisao = (OmUsr) getDao().findById(OmUsr.class, itemDTO.getTeTipoConsumidor().getOmUsrByIdUsrrevisao().getIdUsr() , false);
			itemOriginal.setOmUsrByIdUsrrevisao(usrRevisao);
		} catch (Exception e) {
			retorno.setResultadoEvento(retorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
			e.printStackTrace();
		}
		
		if (retorno.getResultadoEvento() == retorno.getEVENTO_BEM_SUCEDIDO()){
			try{
				itemOriginal = (TeTipoConsumidor) getDao().makePersistent(itemOriginal);
				if (itemAlteracao != null){
					itemAlteracao = (TeTipoConsumidor) getDao().makePersistent(itemAlteracao);
				}
			} catch (Exception e){
				retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
				e.printStackTrace();
			}			
			retorno.setTeTipoConsumidor((TeTipoConsumidor)itemOriginal.clone());
		}
		return retorno;

	}
	
	public TeTipoConsumidoresDTO removeTeTipoConsumidor(TeTipoConsumidoresDTO itens){
		List<TeTipoConsumidorDTO> listaRetorno = new ArrayList<TeTipoConsumidorDTO>();

			for(TeTipoConsumidorDTO item: itens.getListaTeTipoConsumidorDTO()){
				OmUsr omUser = new OmUsr();
				UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
				try {
					omUser = usuarioRN.getOmUsr(item.getTeTipoConsumidor().getOmUsrByIdUsrrevisao().getCdUsr());
				} catch (RegistroDesconhecidoException e) {
					e.printStackTrace();
				}
				try {
					desativarTipoConsumidor(item.getTeTipoConsumidor().getIdTipoConsumidor(),new Date(), omUser);
				} catch (RegistroJaDesativadoException e) {
					e.printStackTrace();
				}
				listaRetorno.add(item);
			}

			TeTipoConsumidoresDTO itensRetorno = new TeTipoConsumidoresDTO();
			itensRetorno.setListaTeTipoConsumidorDTO(listaRetorno);
			return itensRetorno;
	}

	public PesquisasDTO pesquisaTeTipoConsumidor(PesquisaDTO filtro) {
		
		TeTipoConsumidorDAO dao = new TeTipoConsumidorDAO(getDaoSession());
		List<TeTipoConsumidor> lista = null;
		
		try {
			lista = dao.pesquisaTeTipoConsumidorPorCdOuDsAtivo(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();
		if (lista != null) {
			for (TeTipoConsumidor item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdTipoConsumidor());
				itemDTO.setDescricao(item.getDsTipoConsumidor());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}

}