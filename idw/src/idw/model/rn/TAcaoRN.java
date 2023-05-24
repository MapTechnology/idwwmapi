package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasDTO;
import idw.webservices.dto.TAcaoDTO;
import idw.webservices.dto.TAcoesDTO;
import idw.webservices.rest.idw.v2.dto.AcaoDTO2;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.ListaAcoesDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;

@SuppressWarnings("unchecked")
public class TAcaoRN extends DAOGenerico{

	public TAcoesDTO getTAcoesDTO(TAcaoDTO filtro){

		String hql="";
		hql += "select t ";
		hql += "from DwTAcao t ";		
		hql += "where 1=1 ";

		if (filtro.getAcao().getIdTacao()!=0){
			hql += "AND t.idTacao=::idTacao: ";
		}else{
			if (filtro.getAcao().getCdTacao() != null && !filtro.getAcao().getCdTacao().equals("")){
				hql += "AND t.cdTacao='::cdTacao:' ";
			}
			if (filtro.getAcao().getDsTacao() != null && !filtro.getAcao().getDsTacao().equals("")){
				hql += "AND t.dsTacao='::dsTacao:' ";
			}
			if (filtro.getAcao().getDtRevisao()!=null){
				hql += "AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ";
			}
			if (filtro.getAcao().getOmTppt() != null && !filtro.getAcao().getOmTppt().getCdTppt().equals("")){
				hql += "AND t.omTppt.cdTppt='::cdTppt:' ";
			}
			if (filtro.getAcao().getOmTppt() != null && !filtro.getAcao().getOmTppt().getDsTppt().equals("")){
				hql += "AND t.omTppt.dsTppt='::dsTppt:' ";
			}
			if (filtro.getAcao().getOmUsrByIdUsrrevisao() != null && !filtro.getAcao().getOmUsrByIdUsrrevisao().getCdUsr().equals("")){
				hql += "AND t.omUsrByIdUsrrevisao.cdUsr='::cdUsrRev:' ";
			}
			if (filtro.getAcao().getOmUsrByIdUsrrevisao() != null && !filtro.getAcao().getOmUsrByIdUsrrevisao().getDsNome().equals("")){
				hql += "AND t.omUsrByIdUsrrevisao.dsNome='::dsNomeRev:' ";
			}
			if (filtro.getAcao().getOmUsrByIdUsrstativo() != null && !filtro.getAcao().getOmUsrByIdUsrstativo().getCdUsr().equals("")){
				hql += "AND t.omUsrByIdUsrstativo.cdUsr='::cdUsrSt:' ";
			}
			if (filtro.getAcao().getOmUsrByIdUsrstativo() != null && !filtro.getAcao().getOmUsrByIdUsrstativo().getDsNome().equals("")){
				hql += "AND t.omUsrByIdUsrstativo.dsNome='::dsNomeSt:' ";
			}
			if (filtro.getAcao().getDtStativo()!=null){
				hql += "AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF ";
			}
			if (filtro.getAcao().getRevisao()==null){
				hql += "AND t.revisao = (SELECT max(tr.revisao) as Revisao from DwTAcao tr where tr.cdTacao = t.cdTacao ) ";
			}else{
				hql += "AND t.revisao=::revisao: ";
			}
			if (filtro.getAcao().getStAtivo() != null && filtro.getAcao().getStAtivo()<(byte)2){
				hql += "AND t.stAtivo=::stAtivo: ";
			}
		}

		hql = hql.replaceAll("::idTacao:", String.valueOf(filtro.getAcao().getIdTacao()));		
		hql = hql.replaceAll("::cdTacao:", filtro.getAcao().getCdTacao());
		hql = hql.replaceAll("::dsTacao:", filtro.getAcao().getDsTacao());
		if (filtro.getAcao().getOmTppt() != null){
			hql = hql.replaceAll("::cdTppt:", filtro.getAcao().getOmTppt().getCdTppt());
			hql = hql.replaceAll("::dsTppt:", filtro.getAcao().getOmTppt().getDsTppt());
		}
		if (filtro.getAcao().getOmUsrByIdUsrrevisao()!=null){
			hql = hql.replaceAll("::cdUsrRev:", filtro.getAcao().getOmUsrByIdUsrrevisao().getCdUsr());
			hql = hql.replaceAll("::dsNomeRev:", filtro.getAcao().getOmUsrByIdUsrrevisao().getDsNome());
		}
		if (filtro.getAcao().getOmUsrByIdUsrstativo()!=null){
			hql = hql.replaceAll("::cdUsrSt:", filtro.getAcao().getOmUsrByIdUsrstativo().getCdUsr());
			hql = hql.replaceAll("::dsNomeSt:", filtro.getAcao().getOmUsrByIdUsrstativo().getDsNome());
		}
		hql = hql.replaceAll("::revisao:", String.valueOf(filtro.getAcao().getRevisao()));
		hql = hql.replaceAll("::stAtivo:", String.valueOf(filtro.getAcao().getStAtivo()));

		Query q = getSession().createQuery(hql);

		try {			
			q.setDate("dtRevisao", filtro.getAcao().getDtRevisao());
			q.setDate("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getAcao().getDtRevisao()));
		} catch (Exception e) {
			
		}		
		try {
			q.setDate("dtStativo", filtro.getAcao().getDtStativo());
			q.setDate("dtStativoF",DataHoraRN.getDataHora235959(filtro.getAcao().getDtStativo()));
		} catch (Exception e) {
			
		}

		List<DwTAcao> listaPesquisa = null;
		try{
			listaPesquisa = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<TAcaoDTO> lista = new ArrayList<TAcaoDTO>();

		if (listaPesquisa != null){
			for (DwTAcao item : listaPesquisa) {
				TAcaoDTO itemDTO = new TAcaoDTO();								
				itemDTO.setAcao((DwTAcao)item.clone());
				
				itemDTO.setResultadoEvento(0);
				lista.add(itemDTO);
			}
		}

		TAcoesDTO dtoRetorno = new TAcoesDTO();
		dtoRetorno.setAcoes(lista);
		return dtoRetorno;
	}

	public TAcaoDTO setTAcaoDTO(TAcaoDTO itemDTO){
		TAcaoDTO dtoRetorno = new TAcaoDTO();
		dtoRetorno.setResultadoEvento(dtoRetorno.getEVENTO_BEM_SUCEDIDO());

		if (itemDTO.getAcao().getCdTacao().trim().equals("")){
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_CDACAO_INVALIDO());
			return dtoRetorno;
		}

		boolean isInclusao = false;

		String hql = "";

		hql = "from DwTAcao t where t.idTacao = ::idTacao ";
		hql = hql.replaceAll("::idTacao", String.valueOf(itemDTO.getAcao().getIdTacao()));

		Query q = getSession().createQuery(hql);

		DwTAcao itemOriginal = (DwTAcao) q.uniqueResult();

		//20160926FVA:
		if (itemOriginal != null  && itemOriginal.getId()!=null && itemOriginal.getIdTacao() > 0 && itemOriginal.getStAtivo().equals((byte)0)) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_REATIVACAO_INDISPONIVEL());
			return dtoRetorno;
		}

		
		DwTAcao itemAlteracao = null;

		if (itemOriginal == null){			
			itemOriginal = (DwTAcao)itemDTO.getAcao().clone();
			itemOriginal.setRevisao(1l);
			itemOriginal.setDtRevisao(new Date());
			itemOriginal.setStAtivo((byte)1);
			itemOriginal.setDtStativo(new Date());			
			isInclusao = true;
			
			// Verifica se o codigo + revisao ja existe no banco, se exitir retornar ao cliente a excessao
			hql = "";

			hql += "from DwTAcao t ";
			hql += "join t.omTppt omtppt ";
			hql += "where t.cdTacao = '::cdTacao' and t.stAtivo = 1 and omtppt.cdTppt = '::cdtppt' and omtppt.stAtivo = 1 ";			

			hql = hql.replaceAll("::cdTacao", itemOriginal.getCdTacao());
			hql = hql.replaceAll("::cdtppt", String.valueOf(itemDTO.getAcao().getOmTppt().getCdTppt()));
			
			q = getSession().createQuery(hql);

			if (q.list().size() > 0){
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_ACAO_JA_EXISTE());
				return dtoRetorno;
			}
		}else{
			itemAlteracao = new DwTAcao();
			itemAlteracao.copy(itemOriginal, true);
			itemAlteracao.setIdTacao(0l);			
			itemAlteracao.setStAtivo((byte)0);
			itemOriginal.copy(itemDTO.getAcao(), false);			
			itemOriginal.setDtRevisao(new Date());
		}
		
		// Somente apos pesquisar se a nova revisao ja existe é que o pojo original deve ter a revisao somada, se for antes,
		// a pesquisa acima ira trazer o pojo somado
		if (isInclusao == false){
			itemOriginal.setRevisao(itemOriginal.getRevisao()+1);
		}				

		try {
			hql = "from OmTppt t where t.cdTppt = '::cdTppt' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idTppt ";
			hql = hql.replaceAll("::cdTppt", itemDTO.getAcao().getOmTppt().getCdTppt());

			q = getSession().createQuery(hql);

			OmTppt omTppt = (OmTppt) q.list().get(0);

			itemOriginal.setOmTppt(omTppt);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_TIPOPOSTO_DESCONHECIDO());
			e.printStackTrace();
			return dtoRetorno;	
		}
		
		try {
			hql = "from OmUsr t where t.cdUsr = '::cdUsr' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idUsr ";

			hql = hql.replaceAll("::cdUsr", itemDTO.getAcao().getOmUsrByIdUsrrevisao().getCdUsr());

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
			hql = hql.replaceAll("::cdUsr", itemDTO.getAcao().getOmUsrByIdUsrstativo().getCdUsr());

			q = getSession().createQuery(hql);

			OmUsr omUsrStAtivo = (OmUsr) q.list().get(0);

			itemOriginal.setOmUsrByIdUsrstativo(omUsrStAtivo);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
			e.printStackTrace();
		}

		if (dtoRetorno.getResultadoEvento() == dtoRetorno.getEVENTO_BEM_SUCEDIDO()){
			try{
				itemOriginal = (DwTAcao) makePersistent(itemOriginal);
				if (itemAlteracao != null){
					makePersistent(itemAlteracao);
				}
			} catch (Exception e){
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
				e.printStackTrace();
			}

			dtoRetorno.setAcao((DwTAcao)itemOriginal.clone());
			
		}

		return dtoRetorno;
	}	

	public TAcoesDTO removeTAcoesDTO(TAcoesDTO itensDTO){

		List<TAcaoDTO> listaRetorno = new ArrayList<TAcaoDTO>();
		for (TAcaoDTO item : itensDTO.getAcoes()){
			TAcaoDTO itemRetorno = new TAcaoDTO();
			String hql = "";

			hql = "from DwTAcao t where t.idTacao = ::idTacao";
			hql = hql.replaceAll("::idTacao", String.valueOf(item.getAcao().getIdTacao()));

			Query q = getSession().createQuery(hql);

			DwTAcao itemOriginal = (DwTAcao) q.uniqueResult();

			if (itemOriginal == null){			
				itemRetorno.setResultadoEvento(itemRetorno.getERRO_CDACAO_INVALIDO());
				itemRetorno.setAcao(item.getAcao());				
			}else if (itemOriginal.getStAtivo()==0){			
				itemRetorno.setResultadoEvento(itemRetorno.getERRO_CDACAO_INVALIDO());
				itemRetorno.setAcao((DwTAcao)itemOriginal.clone());				
			}else{
				itemOriginal.setStAtivo((byte)0);
				itemOriginal.setDtStativo(new Date());				

				try{
					itemOriginal = (DwTAcao) makePersistent(itemOriginal);			
				} catch (Exception e){
					e.printStackTrace();
				}				

				itemRetorno.setAcao((DwTAcao)itemOriginal.clone());
				
				itemRetorno.setResultadoEvento(0);
			}									

			listaRetorno.add(itemRetorno);
		}

		TAcoesDTO itensRetorno = new TAcoesDTO();
		itensRetorno.setAcoes(listaRetorno);
		return itensRetorno;
	}

	public TAcaoDTO ativaTAcaoDTO(TAcaoDTO itemDTO){
		TAcaoDTO itemRetorno = new TAcaoDTO();
		String hql = "";

		// Verifica se a revisao que está sendo reativada é a maior para o codigo
		hql = "";

		hql += "from DwTAcao t ";
		hql += "where t.cdTacao = '::cdTacao' ";
		hql += "and t.revisao > ::revisao ";

		hql = hql.replaceAll("::cdTacao", itemDTO.getAcao().getCdTacao());
		hql = hql.replaceAll("::revisao", String.valueOf((itemDTO.getAcao().getRevisao())));
		Query qRev = getSession().createQuery(hql);

		if (qRev.list().size() > 0){
			itemRetorno.setResultadoEvento(itemRetorno.getERRO_REATIVACAO_INDISPONIVEL());
			return itemRetorno;
		}

		hql = "from DwTAcao t where t.idTacao = ::idTacao";
		hql = hql.replaceAll("::idTacao", String.valueOf(itemDTO.getAcao().getIdTacao()));

		Query q = getSession().createQuery(hql);

		DwTAcao itemOriginal = (DwTAcao) q.uniqueResult();

		if (itemOriginal == null){			
			itemRetorno.setResultadoEvento(itemRetorno.getERRO_CDACAO_INVALIDO());
			itemRetorno.setAcao(itemDTO.getAcao());
			return itemRetorno;
		}else if (itemOriginal.getStAtivo()==1){			
			itemRetorno.setResultadoEvento(itemRetorno.getERRO_CDACAO_INVALIDO());
			itemRetorno.setAcao((DwTAcao)itemOriginal.clone());				
		}else{
			itemOriginal.setStAtivo((byte)1);
			itemOriginal.setDtStativo(new Date());			
		}					

		try{
			itemOriginal = (DwTAcao) makePersistent(itemOriginal);			
		} catch (Exception e){
			e.printStackTrace();
		}				

		itemRetorno.setAcao((DwTAcao)itemOriginal.clone());

		
		return itemRetorno;
	}
	
	public PesquisasDTO pesquisaDwTAcao(PesquisaDTO filtro){
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select a");
		q.append("from DwTAcao a");
		q.append("WHERE a.stAtivo = :stAtivo");
		
		if (filtro.getCodigo() != null && filtro.getCodigo().equals("") == false && filtro.getDescricao() != null && filtro.getDescricao().equals("") == false) {
			q.append("AND a.cdTacao = :cd OR a.dsTacao = :ds");
		} else if (filtro.getCodigo().equals("") == false) {
			q.append("AND a.cdTacao like :cd");
		} else if (filtro.getDescricao().equals("") == false) {
			q.append("AND a.dsTacao = :ds");
		}
		if (filtro.getRegistro() instanceof OmTppt) {
			q.append("and a.omTppt.idTppt = :idtppt");
			q.defineParametro("idtppt", ((OmTppt) filtro.getRegistro()).getIdTppt());
		}
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cd", filtro.getCodigo() + "%");
		q.defineParametro("ds", filtro.getDescricao());

		List<DwTAcao> listaAcoes = q.list();
		
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();
		for (DwTAcao acao : listaAcoes) {
			PesquisaDTO itemDTO = new PesquisaDTO();
			itemDTO.setCodigo(acao.getCdTacao());
			itemDTO.setDescricao(acao.getDsTacao());
			itemDTO.setRegistro(acao.clone());
			listaDTO.add(itemDTO);
		}
		PesquisasDTO retorno = new PesquisasDTO();
		retorno.setPesquisa(listaDTO);
		return retorno;
	}

	
	
	
	@SuppressWarnings("unused")
	public ListaAcoesDTO getAcoesDTO(FiltroPesquisaDTO filtro){
		ListaAcoesDTO retorno = new ListaAcoesDTO();
		retorno.setItems(new ArrayList<AcaoDTO2>());
		retorno.setMeta(new MetaDTO(filtro));
		
		MapQuery q = new MapQuery(getDao().getSession());
		
		q.append("select t ");
		q.append("from DwTAcao t ");
		q.append("where t.stAtivo = 1 ");
		q.append("and t.omTppt.cdTppt = 'CIC' "); 
		
		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){
			q.append("AND (");
			q.append(" upper(t.cdTacao) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.dsTacao) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		}
		
		q.append("order by t.idTacao");
		
		// Lista do pojo
		List<DwTAcao> listaPesquisa = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
		
 		for (DwTAcao registro : listaPesquisa) {
 			
 			AcaoDTO2 regDTO = new AcaoDTO2();
 			
 			regDTO.setIdAcao(registro.getIdTacao());
 			regDTO.setCdAcao(registro.getCdTacao());
 			regDTO.setDsAcao(registro.getDsTacao());
 			regDTO.setTpPt(registro.getOmTppt().getCdTppt());
 			regDTO.setStRegistro(registro.getStAtivo().intValue());
 			regDTO.setRevisao(registro.getRevisao());
 			
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
	public AcaoDTO2 getAcaoByCd(String cdAcao) {
		AcaoDTO2 retorno = new AcaoDTO2();
		
		MapQuery q = new MapQuery(getDao().getSession());
		
		q.append("select t ");
		q.append("from DwTAcao t ");
		q.append("where t.stAtivo = 1 ");
		q.append("and t.omTppt.cdTppt = 'CIC' ");
		q.append("and t.cdTacao = :cdAcao ");
		q.append("order by t.cdTacao");
		
 		q.defineParametro("cdAcao", cdAcao);

 		// Lista do pojo
 		List<DwTAcao> lista = q.list();
 		
 		if (lista.size() == 1) {
 			
 			retorno.setIdAcao(lista.get(0).getIdTacao());
 			retorno.setCdAcao(lista.get(0).getCdTacao());
 			retorno.setDsAcao(lista.get(0).getDsTacao());
 			retorno.setTpPt(lista.get(0).getOmTppt().getCdTppt());
 			retorno.setStRegistro(lista.get(0).getStAtivo().intValue());
 			retorno.setRevisao(lista.get(0).getRevisao());
 			
 		}
		
		return retorno;
	}

	@SuppressWarnings("unused")
	public DwTAcao getDwTAcaoByCd(String cdAcao) {
		DwTAcao retorno = new DwTAcao();
		
		MapQuery q = new MapQuery(getDao().getSession());
		
		q.append("select t ");
		q.append("from DwTAcao t ");
		q.append("where t.stAtivo = 1 ");
		q.append("and t.omTppt.cdTppt = 'CIC' ");
		q.append("and t.cdTacao = :cdAcao ");
		q.append("order by t.cdTacao");
		
 		q.defineParametro("cdAcao", cdAcao);

 		// Lista do pojo
 		List<DwTAcao> lista = q.list();
 		
 		if (lista.size() == 1) {
 			
 			retorno.setIdTacao(lista.get(0).getIdTacao());
 			retorno.setCdTacao(lista.get(0).getCdTacao());
 			retorno.setDsTacao(lista.get(0).getDsTacao());
 			retorno.setOmTppt(lista.get(0).getOmTppt());
 			retorno.setStAtivo(lista.get(0).getStAtivo());
 			retorno.setRevisao(lista.get(0).getRevisao());
 			
 		}
		
		return retorno;
	}
	
	
}

