package idw.model.rn;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.TeLeiDAO;
import idw.model.pojos.TeLei;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasDTO;
import idw.webservices.dto.TeLeiVigenteDTO;
import idw.webservices.dto.TeLeisVigentesDTO;

public class LeiVigenteRN extends AbstractRN<DAOGenerico> {

	public LeiVigenteRN() {
		super(new DAOGenerico());
	}

	public LeiVigenteRN(DAOGenerico dao) {
		super(dao);
	}

	@SuppressWarnings("unchecked")
	public TeLeisVigentesDTO  getTeLeisVigentesDTO(TeLeiVigenteDTO filtro) throws Exception{
		MapQuery q = new MapQuery(this.getDaoSession());


		q.append("select t ");
		q.append("from TeLei t");
		q.append("where 1=1");

		if (filtro.getTeLei().getIdLei()!=0) {
			q.append("AND t.idLei=:idLei");
		} else {
			if (filtro.getTeLei().getCdLei() !=null && 
					!filtro.getTeLei().getCdLei().equals("")) {
				q.append("AND t.cdLei=:cdLei");
			}
			if (filtro.getTeLei().getDsLei()!=null && 
					!filtro.getTeLei().getDsLei().equals("")) {
				q.append("AND t.dsLei=:dsLei");
			}
			if (filtro.getTeLei().getDtIvigencia()!=null) {
				q.append("AND t.dtIvigencia>=:dtIVigencia");
			}
			if (filtro.getTeLei().getDtFvigencia()!=null){
				q.append("AND t.dtFvigencia<=:dtFVigencia" );
			}
		}
		if (filtro.getTeLei().getIdLei()!=0) {
			q.defineParametro("idLei", filtro.getTeLei().getIdLei());
		}
		if (filtro.getTeLei().getCdLei() !=null) {
			q.defineParametro("cdLei", filtro.getTeLei().getCdLei());
		}
		if (filtro.getTeLei().getDsLei()!=null) {
			q.defineParametro("dsLei", filtro.getTeLei().getDsLei());
		}
		if (filtro.getTeLei().getDtIvigencia()!=null ) {
			q.defineParametro("dtIVigencia", DataHoraRN.getDataSemHora(filtro.getTeLei().getDtIvigencia()));
		}
		if (filtro.getTeLei().getDtFvigencia()!=null) {
			q.defineParametro("dtFVigencia", DataHoraRN.getDataSemHora(filtro.getTeLei().getDtFvigencia()));
		}

		List<TeLei> listaPesquisa = null;
		try {
			listaPesquisa = q.query().list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<TeLeiVigenteDTO> lista = new ArrayList<TeLeiVigenteDTO>();
		
		if (listaPesquisa !=null ) {
			for (TeLei item : listaPesquisa) {
				TeLeiVigenteDTO TeLeiVigenteDTO = new TeLeiVigenteDTO();
				TeLeiVigenteDTO.setTeLei(item.clone());
				lista.add(TeLeiVigenteDTO);
			}
		}
		
		TeLeisVigentesDTO listaRetorno = new TeLeisVigentesDTO();
		listaRetorno.setListaTeLeiVigenteDTO(lista);
		
		return listaRetorno;
		
	}

	public TeLeiVigenteDTO setTeLeiVigenteDTO(TeLeiVigenteDTO itemDTO){
		TeLeiVigenteDTO dtoRetorno = new TeLeiVigenteDTO();
		dtoRetorno.setResultadoEvento(dtoRetorno.getEVENTO_BEM_SUCEDIDO());

		if(itemDTO.getTeLei().getCdLei().trim().equals("")) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_CDLEI_INVALIDO());
		return dtoRetorno;
		}

		boolean isInclusao = false;

		String hql = "";

		hql = "from TeLei t where t.idLei = ::idLei ";
		hql = hql.replaceAll("::idLei", String.valueOf(itemDTO.getTeLei().getIdLei()));

		Query q = getDaoSession().createQuery(hql);

		TeLei itemOriginal = (TeLei) q.uniqueResult();

		//TeLei itemAlteracao = null;

		if (itemOriginal == null){			
			itemOriginal = (TeLei)itemDTO.getTeLei().clone();
			isInclusao = true;
			
			// Verifica se o codigo se exitir retornar ao cliente a excessao
			hql = "";

			hql += "from TeLei t ";
			hql += "where t.cdLei = '::cdLei'";			

			hql = hql.replaceAll("::cdLei", itemOriginal.getCdLei());
			
			q = getDaoSession().createQuery(hql);

			if (q.list().size() > 0){
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_LEI_JA_EXISTE());
				return dtoRetorno;
			}
		}else{
			//itemAlteracao = new TeLei();
			//itemAlteracao.copy(itemOriginal, true);
			//itemAlteracao.setIdLei(0l);			
			itemOriginal.copy(itemDTO.getTeLei(), false);			
		}							

		if (dtoRetorno.getResultadoEvento() == dtoRetorno.getEVENTO_BEM_SUCEDIDO()){
			try{
				itemOriginal = (TeLei) this.getDao().makePersistent(itemOriginal);
				/*if (itemAlteracao != null){
					this.getDao().makePersistent(itemAlteracao);
				}*/
			} catch (Exception e){
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
				e.printStackTrace();
			}

			dtoRetorno.setTeLei((TeLei)itemOriginal.clone());
			
		}

		return dtoRetorno;
	}	

	public PesquisasDTO pesquisaTeLei(PesquisaDTO filtro) {
		TeLeiDAO dao = new TeLeiDAO(getDaoSession());
		List<TeLei> lista = null;
		try {
			lista = dao.pesquisaTeLeiPorCdOuDsAtivo(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();
		if (lista != null) {
			for (TeLei item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdLei());
				itemDTO.setDescricao(item.getDsLei());
				itemDTO.setRegistro(item.clone(false));
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;	
	}
	
}