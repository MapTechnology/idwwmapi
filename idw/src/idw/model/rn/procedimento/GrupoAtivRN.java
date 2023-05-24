package idw.model.rn.procedimento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwGrpativDAO;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.DwGrpativ;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.DwGrpativTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.UsuarioRN;
import idw.webservices.dto.DwGrpativDTO;
import idw.webservices.dto.DwGrpativDTOs;

public class GrupoAtivRN  extends AbstractRN<DAOGenerico>{

	public GrupoAtivRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public GrupoAtivRN() {
		this(null);
	}
	
	@SuppressWarnings("unchecked")
	public DwGrpativDTOs getTodosDwGrpativAtivos(){
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("select dwgrpativ");
		q.append("from DwGrpativ dwgrpativ");
		q.append("where dwgrpativ.stAtivo = 1");
		q.append("order by dwgrpativ.idGrpativ");
		List<DwGrpativ> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<DwGrpativDTO> lista = new ArrayList<DwGrpativDTO>();

		if (listaPesquisa != null) {
			for (DwGrpativ item : listaPesquisa) {
				DwGrpativDTO DwGrpativDTO = new DwGrpativDTO();
				DwGrpativDTO.setDwGrpativ(item.clone());
				lista.add(DwGrpativDTO);
			}
		}

		DwGrpativDTOs listaRetorno = new DwGrpativDTOs();
		listaRetorno.setListaDwGrpativDTO(lista);

		return listaRetorno;
	}
	
	@SuppressWarnings("unchecked")
	public DwGrpativDTOs getDwGrpativ(DwGrpativDTO filtro){
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t ");
		q.append("from DwGrpativ t ");
		q.append("where 1=1 ");

		if(filtro.getDwGrpativ().getIdGrpativ() != 0){
			q.append("AND t.idGrpativ=:idGrpativ ");
		}else{
			if(filtro.getDwGrpativ().getCdGrpativ()!=null && !filtro.getDwGrpativ().getCdGrpativ().equals("")){
				q.append("AND t.cdGrpativ=:cdGrpativ ");
			}
			if(filtro.getDwGrpativ().getDsGrpativ()!=null &&
					!filtro.getDwGrpativ().getDsGrpativ().equals("")){
				q.append("AND t.dsGrpativ=:dsGrpativ ");
			}
			if((filtro.getDwGrpativ().getOmUsrByIdUsrstativo()!= null)
					&& (filtro.getDwGrpativ().getOmUsrByIdUsrstativo().getCdUsr() != null)
					&& (!filtro.getDwGrpativ().getOmUsrByIdUsrstativo().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.cdUsr=:cdUsrSt ");
			}
			if((filtro.getDwGrpativ().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getDwGrpativ().getOmUsrByIdUsrstativo().getDsNome() != null)
					&& (!filtro.getDwGrpativ().getOmUsrByIdUsrstativo().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.dsNome=:dsNomeSt ");
			}
			if((filtro.getDwGrpativ().getOmUsrByIdUsrrevisao()!= null)
					&& (filtro.getDwGrpativ().getOmUsrByIdUsrrevisao().getCdUsr() != null)
					&& (!filtro.getDwGrpativ().getOmUsrByIdUsrrevisao().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.cdUsr=:cdUsrRev ");
			}
			if((filtro.getDwGrpativ().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getDwGrpativ().getOmUsrByIdUsrrevisao().getDsNome() != null)
					&& (!filtro.getDwGrpativ().getOmUsrByIdUsrrevisao().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.dsNome=:dsNomeRev ");
			}
			if(filtro.getDwGrpativ().getDtRevisao() != null){
				q.append("AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ");
			}
			if(filtro.getDwGrpativ().getDtStativo() != null){
				q.append("AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF ");
			}
			if (filtro.getDwGrpativ().getRevisao()==null){
				q.append("AND t.revisao = (SELECT max(tr.revisao) as Revisao from DwGrpativ tr where tr.cdGrpativ = t.cdGrpativ ) ");
		    }else{
				q.append("AND t.revisao=:revisao ");
			}
			if (filtro.getDwGrpativ().getStAtivo() != null && filtro.getDwGrpativ().getStAtivo()<(byte)2){
				q.append("AND t.stAtivo=:stAtivo ");
			}
		}
		if(filtro.getDwGrpativ().getIdGrpativ()!=0){
			q.defineParametro("idGrpativ", filtro.getDwGrpativ().getIdGrpativ());
		}
		if(filtro.getDwGrpativ().getCdGrpativ() != null){
			q.defineParametro("cdGrpativ", filtro.getDwGrpativ().getCdGrpativ());
		}
		if(filtro.getDwGrpativ().getDsGrpativ()!=null){
			q.defineParametro("dsGrpativ", filtro.getDwGrpativ().getDsGrpativ());
		}
		if(filtro.getDwGrpativ().getDtRevisao()!=null){
			q.defineParametro("dtRevisao", filtro.getDwGrpativ().getDtRevisao());
			q.defineParametro("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getDwGrpativ().getDtRevisao()));
		}

		if(filtro.getDwGrpativ().getDtStativo()!=null){
			q.defineParametro("dtStativo", filtro.getDwGrpativ().getDtStativo());
			q.defineParametro("dtStativoF",DataHoraRN.getDataHora235959(filtro.getDwGrpativ().getDtStativo()));
		}

		q.defineParametro("revisao", filtro.getDwGrpativ().getRevisao());
		q.defineParametro("stAtivo", filtro.getDwGrpativ().getStAtivo());

		if (filtro.getDwGrpativ().getOmUsrByIdUsrrevisao() != null) {
			q.defineParametro("cdUsrRev", filtro.getDwGrpativ().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getDwGrpativ().getOmUsrByIdUsrrevisao().getDsNome());
		}

		if (filtro.getDwGrpativ().getOmUsrByIdUsrstativo() != null){
			q.defineParametro("cdUsrSt", filtro.getDwGrpativ().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getDwGrpativ().getOmUsrByIdUsrstativo().getDsNome());
		}

		List<DwGrpativ> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<DwGrpativDTO> lista = new ArrayList<DwGrpativDTO>();

		if (listaPesquisa != null) {
			for (DwGrpativ item : listaPesquisa) {
				DwGrpativDTO DwGrpativDTO = new DwGrpativDTO();
				DwGrpativDTO.setDwGrpativ(item.clone());
				lista.add(DwGrpativDTO);
			}
		}

		DwGrpativDTOs listaRetorno = new DwGrpativDTOs();
		listaRetorno.setListaDwGrpativDTO(lista);

		return listaRetorno;
	}
	
	public DwGrpativDTO setDwGrpativ(DwGrpativDTO itemDTO) {
		
		DwGrpativDAO dao = new DwGrpativDAO(getDaoSession());
		DwGrpativDTO retorno = new DwGrpativDTO();
		retorno.setResultadoEvento(retorno.getEVENTO_BEM_SUCEDIDO());
		
		DwGrpativ itemOriginal = dao.getDwGrpativPorId(itemDTO.getDwGrpativ().getIdGrpativ());
		DwGrpativ itemAlteracao = null;
		
		if(itemOriginal == null){
			itemOriginal = itemDTO.getDwGrpativ().clone();
			DwGrpativ aux = dao.getDwGrpativPorCdAtivo(itemOriginal.getCdGrpativ());
			if(aux != null){
				retorno.setResultadoEvento(retorno.getERRO_CD_JA_CADASTRADO());
				return retorno;
			}
			itemOriginal.setRevisao(1l);
			itemOriginal.setDtRevisao(new Date());
			itemOriginal.setStAtivo((byte)1);
			itemOriginal.setDtStativo(new Date());
		} else {
			itemAlteracao = itemOriginal.clone();
			itemAlteracao.setIdGrpativ(0);
			itemAlteracao.setStAtivo((byte)0);
			itemOriginal.copy(itemDTO.getDwGrpativ(), true);
			itemOriginal.setRevisao(itemOriginal.getRevisao() + 1);
			itemOriginal.setDtRevisao(DataHoraRN.getDataHoraAtual());
			itemOriginal.setDtStativo(DataHoraRN.getDataHoraAtual());
		}
		
		if (retorno.getResultadoEvento() == retorno.getEVENTO_BEM_SUCEDIDO()){
			try{
				itemOriginal = this.getDao().makePersistent(itemOriginal);
				if (itemAlteracao != null){
					itemAlteracao = this.getDao().makePersistent(itemAlteracao);
				}
			} catch (Exception e){	
				e.printStackTrace();
				retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
				return retorno;
			}
		}
		retorno.setDwGrpativ(itemOriginal.clone());
		return retorno;
	}
	
	public void salvarDesativandoOriginal(DwGrpativ dwGrpativDB, DwGrpativ dwGrpativ, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(dwGrpativDB, dwGrpativ, dateOperacao, omUsrOperacao);
	}

	public void salvarDesativandoOriginal(DwGrpativ dwGrpativ, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(dwGrpativ, dateOperacao, omUsrOperacao);
	}
	
	public DwGrpativDTOs removeDwGrpativ(DwGrpativDTOs itens){
		List<DwGrpativDTO> listaRetorno = new ArrayList<DwGrpativDTO>();

			for(DwGrpativDTO item: itens.getListaDwGrpativDTO()){
				OmUsr omUser = new OmUsr();
				UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
				try {
					omUser = usuarioRN.getOmUsr(item.getDwGrpativ().getOmUsrByIdUsrrevisao().getCdUsr());
				} catch (RegistroDesconhecidoException e) {
					e.printStackTrace();
				}
				try {
					desativarDwGrpativ(item.getDwGrpativ().getIdGrpativ(),new Date(), omUser);
				} catch (RegistroJaDesativadoException e) {
					e.printStackTrace();
				}
				listaRetorno.add(item);
			}

			DwGrpativDTOs itensRetorno = new DwGrpativDTOs();
			itensRetorno.setListaDwGrpativDTO(listaRetorno);
			return itensRetorno;
	}

	/**
	 * Desativa relacionado ao código
	 * @param cdDwGrpativ
	 * @param date
	 * @param omUsr usuário que está desativando
	 * @throws RegistroJaDesativadoException
	 * @throws RegistroDesconhecidoException
	 */
	public void desativarDwGrpativ(String cdDwGrpativ, Date date, OmUsr omUsr) throws RegistroDesconhecidoException, RegistroJaDesativadoException{
		this.getDao().desativar(DwGrpativ.class,cdDwGrpativ, DwGrpativTemplate._FIELD_NAME_CD, null, date, omUsr);
	}

	/**
	 * Desativa {@code DwGrpativ} relacionado ao id do grupo de atividades
	 * @param idDwGrpativ
	 * @param dataHoraAtual
	 * @throws RegistroJaDesativadoException
	 */
	public void desativarDwGrpativ(long idDwGrpativ,  Date date, OmUsr omUsr) throws RegistroJaDesativadoException{
		this.getDao().desativar(DwGrpativ.class, idDwGrpativ, date, omUsr);
	}
}
