package idw.model.rn.el;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.TeConcessionariaDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.OmUsr;
import idw.model.pojos.TeConcessionaria;
import idw.model.pojos.template.TeConcessionariaTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.UsuarioRN;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasDTO;
import idw.webservices.dto.TeConcessionariaDTO;
import idw.webservices.dto.TeConcessionariasDTO;

public class ConcessionariaRN extends AbstractRN<DAOGenerico> {

	public ConcessionariaRN() {
		this(null);
	}

	public ConcessionariaRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	/**
	 * Desativa todos os registros da tabela de Concessionarias
	 * @param dataHoraDesativacao
	 * @param omUsr Usu�rio que desativou a Concessionaria
	 */
	public void desativarConcessionarias(Date dataHoraDesativacao, OmUsr omUsr){
		this.getDao().desativarMuitos(TeConcessionaria.class, TeConcessionariaTemplate._FIELD_NAME_CD, null, false, dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa registros da tabela de Concessionarias
	 * @param listaCdConcessionariaDevemFicarAtivos Lista de c�digos de devem ficar permanecer ativos
	 * @param dataHoraDesativacao
	 * @param omUsr Usu�rio que desativou a Concessionaria
	 */
	public void desativarConcessionarias(List<String> listaCdConcessionariaDevemFicarAtivos, Date dataHoraDesativacao, OmUsr omUsr){
		this.getDao().desativarMuitos(TeConcessionaria.class, TeConcessionariaTemplate._FIELD_NAME_CD, listaCdConcessionariaDevemFicarAtivos, true, dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa relacionado ao c�digo e tipo do posto de trabalho
	 * @param cdConcessionaria
	 * @param date
	 * @param omUsr usu�rio que est� desativando
	 * @throws RegistroJaDesativadoException
	 * @throws RegistroDesconhecidoException
	 */
	public void desativarConcessionaria(String cdConcessionaria, Date date, OmUsr omUsr) throws RegistroDesconhecidoException, RegistroJaDesativadoException{
		this.getDao().desativar(TeConcessionaria.class,cdConcessionaria, TeConcessionariaTemplate._FIELD_NAME_CD, null, date, omUsr);
	}

	/**
	 * Desativa {@code TeConcessionaria} relacionado ao id da Concessionaria
	 * @param idConcessionaria
	 * @param dataHoraAtual
	 * @throws RegistroJaDesativadoException
	 */
	public void desativarConcessionaria(long idConcessionaria,  Date date, OmUsr omUsr) throws RegistroJaDesativadoException{
		this.getDao().desativar(TeConcessionaria.class, idConcessionaria, date, omUsr);
	}


	/**
	 * Pega {@code TeConcessionaria} relacionado com o c�digo da Concessionaria e que esteja ativo
	 * @param cdConcessionaria
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public TeConcessionaria getTeConcessionaria(String cdConcessionaria) throws RegistroDesconhecidoException{
		return this.getTeConcessionaria(cdConcessionaria, true);
	}

	/**
	 * Pega {@code TeConcessionaria} �ltima revis�o relacionado com o c�digo da Concessionaria
	 * @param cdConcessionaria
	 * @param isFiltroAtivo se true, busca apenas o ativo
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public TeConcessionaria getTeConcessionaria(String cdConcessionaria, boolean isFiltroAtivo) throws RegistroDesconhecidoException{
		return this.getDao().findByCd(TeConcessionaria.class, cdConcessionaria, TeConcessionariaTemplate._FIELD_NAME_CD, null, isFiltroAtivo);
	}
	/**
	 * Pega {@code TeConcessionaria} relacionado com o id
	 * @param idConcessionaria
	 * @return
	 */
	public TeConcessionaria getTeConcessionaria(long idConcessionaria){
		return this.getDao().findById(TeConcessionaria.class, idConcessionaria, false);
	}


	public void salvarDesativandoOriginal(TeConcessionaria teConcessionariaDB, TeConcessionaria teConcessionaria, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(teConcessionariaDB, teConcessionaria, dateOperacao, omUsrOperacao);
	}

	public void salvarDesativandoOriginal(TeConcessionaria teConcessionaria, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(teConcessionaria, dateOperacao, omUsrOperacao);
	}

	@SuppressWarnings("unchecked")
	public TeConcessionariasDTO getTodosTeConcessionariasAtivos(){
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("select teConcessionaria");
		q.append("from TeConcessionaria teConcessionaria");
		q.append("where teConcessionaria.stAtivo = 1");
		q.append("order by teConcessionaria.idConcessionaria");
		List<TeConcessionaria> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<TeConcessionariaDTO> lista = new ArrayList<TeConcessionariaDTO>();

		if (listaPesquisa != null) {
			for (TeConcessionaria item : listaPesquisa) {
				TeConcessionariaDTO TeConcessionariaDTO = new TeConcessionariaDTO();
				TeConcessionariaDTO.setTeConcessionaria(item.clone());
				lista.add(TeConcessionariaDTO);
			}
		}

		TeConcessionariasDTO listaRetorno = new TeConcessionariasDTO();
		listaRetorno.setListaTeConcessionariaDTO(lista);

		return listaRetorno;
	}
	
	@SuppressWarnings("unchecked")
	public TeConcessionariasDTO getConcessionaria(TeConcessionariaDTO filtro){
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t ");
		q.append("from TeConcessionaria t ");
		q.append("where 1=1 ");

		if(filtro.getTeConcessionaria().getIdConcessionaria() != 0){
			q.append("AND t.idConcessionaria=:idConcessionaria ");
		}else{
			if(filtro.getTeConcessionaria().getCdConcessionaria()!=null && !filtro.getTeConcessionaria().getCdConcessionaria().equals("")){
				q.append("AND t.cdConcessionaria=:cdConcessionaria ");
			}
			if(filtro.getTeConcessionaria().getDsConcessionaria()!=null &&
					!filtro.getTeConcessionaria().getDsConcessionaria().equals("")){
				q.append("AND t.dsConcessionaria=:dsConcessionaria ");
			}
			if((filtro.getTeConcessionaria().getOmUsrByIdUsrstativo()!= null)
					&& (filtro.getTeConcessionaria().getOmUsrByIdUsrstativo().getCdUsr() != null)
					&& (!filtro.getTeConcessionaria().getOmUsrByIdUsrstativo().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.cdUsr=:cdUsrSt ");
			}
			if((filtro.getTeConcessionaria().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getTeConcessionaria().getOmUsrByIdUsrstativo().getDsNome() != null)
					&& (!filtro.getTeConcessionaria().getOmUsrByIdUsrstativo().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.dsNome=:dsNomeSt ");
			}
			if((filtro.getTeConcessionaria().getOmUsrByIdUsrrevisao()!= null)
					&& (filtro.getTeConcessionaria().getOmUsrByIdUsrrevisao().getCdUsr() != null)
					&& (!filtro.getTeConcessionaria().getOmUsrByIdUsrrevisao().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.cdUsr=:cdUsrRev ");
			}
			if((filtro.getTeConcessionaria().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getTeConcessionaria().getOmUsrByIdUsrrevisao().getDsNome() != null)
					&& (!filtro.getTeConcessionaria().getOmUsrByIdUsrrevisao().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.dsNome=:dsNomeRev ");
			}
			if(filtro.getTeConcessionaria().getDtRevisao() != null){
				q.append("AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ");
			}
			if(filtro.getTeConcessionaria().getDtStativo() != null){
				q.append("AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF ");
			}
			if (filtro.getTeConcessionaria().getRevisao()==null){
				q.append("AND t.revisao = (SELECT max(tr.revisao) as Revisao from TeConcessionaria tr where tr.cdConcessionaria = t.cdConcessionaria ) ");
		    }else{
				q.append("AND t.revisao=:revisao ");
			}
			if (filtro.getTeConcessionaria().getStAtivo() != null && filtro.getTeConcessionaria().getStAtivo()<(byte)2){
				q.append("AND t.stAtivo=:stAtivo ");
			}
		}
		if(filtro.getTeConcessionaria().getIdConcessionaria()!=0){
			q.defineParametro("idConcessionaria", filtro.getTeConcessionaria().getIdConcessionaria());
		}
		if(filtro.getTeConcessionaria().getCdConcessionaria() != null){
			q.defineParametro("cdConcessionaria", filtro.getTeConcessionaria().getCdConcessionaria());
		}
		if(filtro.getTeConcessionaria().getDsConcessionaria()!=null){
			q.defineParametro("dsConcessionaria", filtro.getTeConcessionaria().getDsConcessionaria());
		}
		if(filtro.getTeConcessionaria().getDtRevisao()!=null){
			q.defineParametro("dtRevisao", filtro.getTeConcessionaria().getDtRevisao());
			q.defineParametro("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getTeConcessionaria().getDtRevisao()));
		}

		if(filtro.getTeConcessionaria().getDtStativo()!=null){
			q.defineParametro("dtStativo", filtro.getTeConcessionaria().getDtStativo());
			q.defineParametro("dtStativoF",DataHoraRN.getDataHora235959(filtro.getTeConcessionaria().getDtStativo()));
		}

		q.defineParametro("revisao", filtro.getTeConcessionaria().getRevisao());
		q.defineParametro("stAtivo", filtro.getTeConcessionaria().getStAtivo());

		if (filtro.getTeConcessionaria().getOmUsrByIdUsrrevisao() != null) {
			q.defineParametro("cdUsrRev", filtro.getTeConcessionaria().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getTeConcessionaria().getOmUsrByIdUsrrevisao().getDsNome());
		}

		if (filtro.getTeConcessionaria().getOmUsrByIdUsrstativo() != null){
			q.defineParametro("cdUsrSt", filtro.getTeConcessionaria().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getTeConcessionaria().getOmUsrByIdUsrstativo().getDsNome());
		}

		List<TeConcessionaria> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<TeConcessionariaDTO> lista = new ArrayList<TeConcessionariaDTO>();

		if (listaPesquisa != null) {
			for (TeConcessionaria item : listaPesquisa) {
				TeConcessionariaDTO TeConcessionariaDTO = new TeConcessionariaDTO();
				TeConcessionariaDTO.setTeConcessionaria(item.clone());
				lista.add(TeConcessionariaDTO);
			}
		}

		TeConcessionariasDTO listaRetorno = new TeConcessionariasDTO();
		listaRetorno.setListaTeConcessionariaDTO(lista);

		return listaRetorno;
	}
	
	public TeConcessionariaDTO setTeConcessionaria(TeConcessionariaDTO itemDTO) {
		TeConcessionaria itemOriginal = new TeConcessionaria();
		itemOriginal = itemDTO.getTeConcessionaria().clone();

		OmUsr omUser = new OmUsr();
		UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
		try {
			omUser = usuarioRN.getOmUsr(itemOriginal.getOmUsrByIdUsrrevisao().getCdUsr());
		} catch (RegistroDesconhecidoException e) {
			e.printStackTrace();
		}
		salvarDesativandoOriginal(itemOriginal, new Date(), omUser);
		return itemDTO;
	}
	
	public TeConcessionariasDTO removeTeConcessionaria(TeConcessionariasDTO itens){
		List<TeConcessionariaDTO> listaRetorno = new ArrayList<TeConcessionariaDTO>();

			for(TeConcessionariaDTO item: itens.getListaTeConcessionariaDTO()){
				OmUsr omUser = new OmUsr();
				UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
				try {
					omUser = usuarioRN.getOmUsr(item.getTeConcessionaria().getOmUsrByIdUsrrevisao().getCdUsr());
				} catch (RegistroDesconhecidoException e) {
					e.printStackTrace();
				}
				try {
					desativarConcessionaria(item.getTeConcessionaria().getIdConcessionaria(),new Date(), omUser);
				} catch (RegistroJaDesativadoException e) {
					e.printStackTrace();
				}
				listaRetorno.add(item);
			}

			TeConcessionariasDTO itensRetorno = new TeConcessionariasDTO();
			itensRetorno.setListaTeConcessionariaDTO(listaRetorno);
			return itensRetorno;
		}
	
	public PesquisasDTO pesquisaTeConcessionaria(PesquisaDTO filtro) {

		TeConcessionariaDAO dao = new TeConcessionariaDAO(getDaoSession());
		List<TeConcessionaria> lista = null;
		try {
			lista = dao.getTeConcessionariaPorCdOuDsAtivo(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (TeConcessionaria item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdConcessionaria());
				itemDTO.setDescricao(item.getDsConcessionaria());
				itemDTO.setRegistro(item.clone(false));
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}
	
}
