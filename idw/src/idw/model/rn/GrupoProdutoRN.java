package idw.model.rn;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.SemSessaoHibernateException;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmUsr;
import idw.webservices.dto.GrupoProdutoDTO;
import idw.webservices.dto.GruposProdutoDTO;


@SuppressWarnings("unchecked")
public class GrupoProdutoRN extends DAOGenerico{

	public GruposProdutoDTO getGruposProdutoDTO(GrupoProdutoDTO filtro){

		String hql="";
		hql += "select t ";
		hql += "from OmProgrp t ";		
		hql += "where 1=1 ";

		if (filtro.getGrupoProduto().getIdProgrp()!=0){
			hql += "AND t.idProgrp=::idProgrp: ";
		}else{
			if (filtro.getGrupoProduto().getCdProgrp() != null && !filtro.getGrupoProduto().getCdProgrp().equals("")){
				hql += "AND t.cdProgrp='::cdProgrp:' ";
			}
			if (filtro.getGrupoProduto().getDsProgrp() != null && !filtro.getGrupoProduto().getDsProgrp().equals("")){
				hql += "AND t.dsProgrp='::dsProgrp:' ";
			}
			if (filtro.getGrupoProduto().getDtRevisao()!=null){
				hql += "AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ";
			}
			if (filtro.getGrupoProduto().getOmUsrByIdUsrrevisao() != null && !filtro.getGrupoProduto().getOmUsrByIdUsrrevisao().getCdUsr().equals("")){
				hql += "AND t.omUsrByIdUsrrevisao.cdUsr='::cdUsrRev:' ";
			}
			if (filtro.getGrupoProduto().getOmUsrByIdUsrrevisao() != null && !filtro.getGrupoProduto().getOmUsrByIdUsrrevisao().getDsNome().equals("")){
				hql += "AND t.omUsrByIdUsrrevisao.dsNome='::dsNomeRev:' ";
			}
			if (filtro.getGrupoProduto().getOmUsrByIdUsrstativo() != null && !filtro.getGrupoProduto().getOmUsrByIdUsrstativo().getCdUsr().equals("")){
				hql += "AND t.omUsrByIdUsrstativo.cdUsr='::cdUsrSt:' ";
			}
			if (filtro.getGrupoProduto().getOmUsrByIdUsrstativo() != null && !filtro.getGrupoProduto().getOmUsrByIdUsrstativo().getDsNome().equals("")){
				hql += "AND t.omUsrByIdUsrstativo.dsNome='::dsNomeSt:' ";
			}
			if (filtro.getGrupoProduto().getDtStativo()!=null){
				hql += "AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF ";
			}
			if (filtro.getGrupoProduto().getRevisao()==null){
				hql += "AND t.revisao = (SELECT max(tr.revisao) as Revisao from OmProgrp tr where tr.cdProgrp = t.cdProgrp ) ";
			}else{
				hql += "AND t.revisao=::revisao: ";
			}
			if (filtro.getGrupoProduto().getStAtivo() != null && filtro.getGrupoProduto().getStAtivo()<(byte)2){
				hql += "AND t.stAtivo=::stAtivo: ";
			}
		}

		hql = hql.replaceAll("::idProgrp:", String.valueOf(filtro.getGrupoProduto().getIdProgrp()));		
		hql = hql.replaceAll("::cdProgrp:", filtro.getGrupoProduto().getCdProgrp());
		hql = hql.replaceAll("::dsProgrp:", filtro.getGrupoProduto().getDsProgrp());
		if (filtro.getGrupoProduto().getOmUsrByIdUsrrevisao()!=null){
			hql = hql.replaceAll("::cdUsrRev:", filtro.getGrupoProduto().getOmUsrByIdUsrrevisao().getCdUsr());
			hql = hql.replaceAll("::dsNomeRev:", filtro.getGrupoProduto().getOmUsrByIdUsrrevisao().getDsNome());
		}
		if (filtro.getGrupoProduto().getOmUsrByIdUsrstativo()!=null){
			hql = hql.replaceAll("::cdUsrSt:", filtro.getGrupoProduto().getOmUsrByIdUsrstativo().getCdUsr());
			hql = hql.replaceAll("::dsNomeSt:", filtro.getGrupoProduto().getOmUsrByIdUsrstativo().getDsNome());
		}
		hql = hql.replaceAll("::revisao:", String.valueOf(filtro.getGrupoProduto().getRevisao()));
		hql = hql.replaceAll("::stAtivo:", String.valueOf(filtro.getGrupoProduto().getStAtivo()));

		Query q = getSession().createQuery(hql);

		try {
//			q.setDate("dtRevisao", filtro.getGrupoProduto().getDtRevisao());
			q.setTimestamp("dtRevisao", filtro.getGrupoProduto().getDtRevisao());
			q.setTimestamp("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getGrupoProduto().getDtRevisao()));
		} catch (Exception e) {
			
		}		
		try {
//			q.setDate("dtStativo", filtro.getGrupoProduto().getDtStativo());
			q.setTimestamp("dtStativo", filtro.getGrupoProduto().getDtStativo());
			q.setTimestamp("dtStativoF",DataHoraRN.getDataHora235959(filtro.getGrupoProduto().getDtStativo()));
		} catch (Exception e) {
			
		}

		List<OmProgrp> listaPesquisa = null;
		try{
			listaPesquisa = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<GrupoProdutoDTO> lista = new ArrayList<GrupoProdutoDTO>();

		if (listaPesquisa != null){
			for (OmProgrp item : listaPesquisa) {
				GrupoProdutoDTO itemDTO = new GrupoProdutoDTO();								
				itemDTO.setGrupoProduto((OmProgrp)item.clone());
				
				itemDTO.setResultadoEvento(0);
				lista.add(itemDTO);
			}
		}

		GruposProdutoDTO dtoRetorno = new GruposProdutoDTO();
		dtoRetorno.setGruposProduto(lista);
		return dtoRetorno;
	}

	public GrupoProdutoDTO setGrupoProdutoDTO(GrupoProdutoDTO itemDTO){
		GrupoProdutoDTO dtoRetorno = new GrupoProdutoDTO();
		dtoRetorno.setResultadoEvento(dtoRetorno.getEVENTO_BEM_SUCEDIDO());

		if (itemDTO.getGrupoProduto().getCdProgrp().trim().equals("")){
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_CDGRUPOPRODUTO_INVALIDO());
			return dtoRetorno;
		}

		boolean isInclusao = false;

		String hql = "";

		hql = "from OmProgrp t where t.idProgrp = ::idProgrp ";
		hql = hql.replaceAll("::idProgrp", String.valueOf(itemDTO.getGrupoProduto().getIdProgrp()));

		Query q = getSession().createQuery(hql);

		OmProgrp itemOriginal = (OmProgrp) q.uniqueResult();

		OmProgrp itemAlteracao = null;

		if (itemOriginal == null){			
			itemOriginal = (OmProgrp)itemDTO.getGrupoProduto().clone();
			itemOriginal.setRevisao(1l);
			itemOriginal.setDtRevisao(new Date());
			itemOriginal.setStAtivo((byte)1);
			itemOriginal.setDtStativo(new Date());			
			isInclusao = true;
			
			// Verifica se o codigo + revisao ja existe no banco, se exitir retornar ao cliente a excessao
			hql = "";

			hql += "from OmProgrp t ";
			hql += "where t.cdProgrp = '::cdProgrp' ";			

			hql = hql.replaceAll("::cdProgrp", itemOriginal.getCdProgrp());			
			q = getSession().createQuery(hql);

			if (q.list().size() > 0){
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_GRUPOPRODUTO_JA_EXISTE());
				return dtoRetorno;
			}
		}else{
			itemAlteracao = new OmProgrp();
			itemAlteracao.copy(itemOriginal, true);
			itemAlteracao.setIdProgrp(0l);			
			itemAlteracao.setStAtivo((byte)0);
			itemOriginal.copy(itemDTO.getGrupoProduto(), false);			
			itemOriginal.setDtRevisao(new Date());
		}			

		// Somente apos pesquisar se a nova revisao ja existe � que o pojo original deve ter a revisao somada, se for antes,
		// a pesquisa acima ira trazer o pojo somado
		if (isInclusao == false){			
			itemOriginal.setRevisao(itemOriginal.getRevisao()+1);			
		}				

		try {
			hql = "from OmUsr t where t.cdUsr = '::cdUsr' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idUsr ";

			hql = hql.replaceAll("::cdUsr", itemDTO.getGrupoProduto().getOmUsrByIdUsrrevisao().getCdUsr());

			q = getSession().createQuery(hql);

			OmUsr omUsrRevisao = (OmUsr) q.list().get(0);

			itemOriginal.setOmUsrByIdUsrrevisao(omUsrRevisao);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
			e.printStackTrace();
		}

		try {
			hql = "from OmUsr t where t.cdUsr = '::cdUsr' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idUsr ";
			hql = hql.replaceAll("::cdUsr", itemDTO.getGrupoProduto().getOmUsrByIdUsrstativo().getCdUsr());

			q = getSession().createQuery(hql);

			OmUsr omUsrStAtivo = (OmUsr) q.list().get(0);

			itemOriginal.setOmUsrByIdUsrstativo(omUsrStAtivo);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
			e.printStackTrace();
		}

		if (dtoRetorno.getResultadoEvento() == dtoRetorno.getEVENTO_BEM_SUCEDIDO()){
			try{
				itemOriginal = (OmProgrp) makePersistent(itemOriginal);
				if (itemAlteracao != null){
					makePersistent(itemAlteracao);
				}
			} catch (Exception e){
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
				e.printStackTrace();
			}

			dtoRetorno.setGrupoProduto((OmProgrp)itemOriginal.clone());
			
		}

		return dtoRetorno;
	}	

	public GruposProdutoDTO removeGruposProdutoDTO(GruposProdutoDTO itensDTO){

		List<GrupoProdutoDTO> listaRetorno = new ArrayList<GrupoProdutoDTO>();
		for (GrupoProdutoDTO item : itensDTO.getGruposProduto()){
			GrupoProdutoDTO itemRetorno = new GrupoProdutoDTO();
			String hql = "";

			hql = "from OmProgrp t where t.idProgrp = ::idProgrp";
			hql = hql.replaceAll("::idProgrp", String.valueOf(item.getGrupoProduto().getIdProgrp()));

			Query q = getSession().createQuery(hql);

			OmProgrp itemOriginal = (OmProgrp) q.uniqueResult();

			if (itemOriginal == null){			
				itemRetorno.setResultadoEvento(itemRetorno.getERRO_CDGRUPOPRODUTO_INVALIDO());
				itemRetorno.setGrupoProduto(item.getGrupoProduto());				
			}else if (itemOriginal.getStAtivo()==0){			
				itemRetorno.setResultadoEvento(itemRetorno.getERRO_CDGRUPOPRODUTO_INVALIDO());
				itemRetorno.setGrupoProduto((OmProgrp)itemOriginal.clone());				
			}else{
				itemOriginal.setStAtivo((byte)0);
				itemOriginal.setDtStativo(new Date());				

				try{
					itemOriginal = (OmProgrp) makePersistent(itemOriginal);			
				} catch (Exception e){
					e.printStackTrace();
				}				

				itemRetorno.setGrupoProduto((OmProgrp)itemOriginal.clone());
				
				itemRetorno.setResultadoEvento(0);
			}									

			listaRetorno.add(itemRetorno);
		}

		GruposProdutoDTO itensRetorno = new GruposProdutoDTO();
		itensRetorno.setGruposProduto(listaRetorno);
		return itensRetorno;
	}

	public GrupoProdutoDTO ativaGrupoProdutoDTO(GrupoProdutoDTO itemDTO){
		GrupoProdutoDTO itemRetorno = new GrupoProdutoDTO();
		String hql = "";

		// Verifica se a revisao que est� sendo reativada � a maior para o codigo
		hql = "";

		hql += "from OmProgrp t ";
		hql += "where t.cdProgrp = '::cdProgrp' ";
		hql += "and t.revisao > ::revisao ";

		hql = hql.replaceAll("::cdProgrp", itemDTO.getGrupoProduto().getCdProgrp());
		hql = hql.replaceAll("::revisao", String.valueOf((itemDTO.getGrupoProduto().getRevisao())));
		Query qRev = getSession().createQuery(hql);

		if (qRev.list().size() > 0){
			itemRetorno.setResultadoEvento(itemRetorno.getERRO_REATIVACAO_INDISPONIVEL());
			return itemRetorno;
		}

		hql = "from OmProgrp t where t.idProgrp = ::idProgrp";
		hql = hql.replaceAll("::idProgrp", String.valueOf(itemDTO.getGrupoProduto().getIdProgrp()));

		Query q = getSession().createQuery(hql);

		OmProgrp itemOriginal = (OmProgrp) q.uniqueResult();

		if (itemOriginal == null){			
			itemRetorno.setResultadoEvento(itemRetorno.getERRO_CDGRUPOPRODUTO_INVALIDO());
			itemRetorno.setGrupoProduto(itemDTO.getGrupoProduto());
			return itemRetorno;
		}else if (itemOriginal.getStAtivo()==1){			
			itemRetorno.setResultadoEvento(itemRetorno.getERRO_CDGRUPOPRODUTO_INVALIDO());
			itemRetorno.setGrupoProduto((OmProgrp)itemOriginal.clone());				
		}else{
			itemOriginal.setStAtivo((byte)1);
			itemOriginal.setDtStativo(new Date());			
		}					

		try{
			itemOriginal = (OmProgrp) makePersistent(itemOriginal);			
		} catch (Exception e){
			e.printStackTrace();
		}				

		itemRetorno.setGrupoProduto((OmProgrp)itemOriginal.clone());

		
		return itemRetorno;
	}		
	
	public OmProgrp pesquisarOmProgrpByCdStAtivo(String cd){
		MapQuery q = null;
		try {
			if (getSession() != null)
				q = new MapQuery(getSession());
			else
				q = new MapQuery(getSessionStateless());
		} catch (SemSessaoHibernateException e) {
			q = new MapQuery(getSessionStateless());
		}
		
		q.append("select omprogrp");
		q.append("from OmProgrp omprogrp");
		q.append("where omprogrp.cdProgrp = :cd");
		q.append("and omprogrp.stAtivo = 1");
		
		q.defineParametro("cd", cd);
		q.setMaxResults(1);
		
		return (OmProgrp) q.uniqueResult();
	}
	public OmProgrp pesquisarOmProgrpById(Long id){
		MapQuery q = null;
		try {
			if (getSession() != null)
				q = new MapQuery(getSession());
			else
				q = new MapQuery(getSessionStateless());
				
		} catch (SemSessaoHibernateException e) {
			q = new MapQuery(getSessionStateless());
		}
		
		q.append("select omprogrp");
		q.append("from OmProgrp omprogrp");
		q.append("where omprogrp.idProgrp = :id");
		
		q.defineParametro("id", id);
		
		return (OmProgrp) q.uniqueResult();
	}
}

