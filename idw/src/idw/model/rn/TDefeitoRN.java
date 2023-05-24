package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwTDefeito;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasDTO;
import idw.webservices.dto.TDefeitoDTO;
import idw.webservices.dto.TDefeitosDTO;

@SuppressWarnings("unchecked")
public class TDefeitoRN extends DAOGenerico {

	public TDefeitosDTO getTDefeitosDTO(TDefeitoDTO filtro) {

		String hql = "";
		hql += "select t ";
		hql += "from DwTDefeito t ";
		hql += "where 1=1 ";

		if (filtro.getDefeito().getIdTdefeito() != 0) {
			hql += "AND t.idTdefeito=::idTdefeito: ";
		} else {
			if (filtro.getDefeito().getCdTdefeito() != null && !filtro.getDefeito().getCdTdefeito().equals("")) {
				hql += "AND t.cdTdefeito='::cdTdefeito:' ";
			}
			if (filtro.getDefeito().getDsTdefeito() != null && !filtro.getDefeito().getDsTdefeito().equals("")) {
				hql += "AND t.dsTdefeito='::dsTdefeito:' ";
			}
			if (filtro.getDefeito().getDtRevisao() != null) {
				hql += "AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ";
			}
			if (filtro.getDefeito().getOmTppt() != null && !filtro.getDefeito().getOmTppt().getCdTppt().equals("")) {
				hql += "AND t.omTppt.cdTppt='::cdTppt:' ";
			}
			if (filtro.getDefeito().getOmUsrByIdUsrrevisao() != null && !filtro.getDefeito().getOmUsrByIdUsrrevisao().getCdUsr().equals("")) {
				hql += "AND t.omUsrByIdUsrrevisao.cdUsr='::cdUsrRev:' ";
			}
			if (filtro.getDefeito().getOmUsrByIdUsrrevisao() != null && !filtro.getDefeito().getOmUsrByIdUsrrevisao().getDsNome().equals("")) {
				hql += "AND t.omUsrByIdUsrrevisao.dsNome='::dsNomeRev:' ";
			}
			if (filtro.getDefeito().getOmUsrByIdUsrstativo() != null && !filtro.getDefeito().getOmUsrByIdUsrstativo().getCdUsr().equals("")) {
				hql += "AND t.omUsrByIdUsrstativo.cdUsr='::cdUsrSt:' ";
			}
			if (filtro.getDefeito().getOmUsrByIdUsrstativo() != null && !filtro.getDefeito().getOmUsrByIdUsrstativo().getDsNome().equals("")) {
				hql += "AND t.omUsrByIdUsrstativo.dsNome='::dsNomeSt:' ";
			}
			if (filtro.getDefeito().getDtStativo() != null) {
				hql += "AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF ";
			}
			if (filtro.getDefeito().getRevisao() != null) {
				hql += "AND t.revisao=::revisao: ";
			}
			if (filtro.getDefeito().getStAtivo() != null && filtro.getDefeito().getStAtivo() < (byte) 2) {
				hql += "AND t.stAtivo=::stAtivo: ";
			}
		}

		hql = hql.replaceAll("::idTdefeito:", String.valueOf(filtro.getDefeito().getIdTdefeito()));
		hql = hql.replaceAll("::cdTdefeito:", filtro.getDefeito().getCdTdefeito());
		hql = hql.replaceAll("::dsTdefeito:", filtro.getDefeito().getDsTdefeito());
		if (filtro.getDefeito().getOmTppt() != null) {
			hql = hql.replaceAll("::cdTppt:", filtro.getDefeito().getOmTppt().getCdTppt());
			hql = hql.replaceAll("::dsTppt:", filtro.getDefeito().getOmTppt().getDsTppt());
		}
		if (filtro.getDefeito().getOmUsrByIdUsrrevisao() != null) {
			hql = hql.replaceAll("::cdUsrRev:", filtro.getDefeito().getOmUsrByIdUsrrevisao().getCdUsr());
			hql = hql.replaceAll("::dsNomeRev:", filtro.getDefeito().getOmUsrByIdUsrrevisao().getDsNome());
		}
		if (filtro.getDefeito().getOmUsrByIdUsrstativo() != null) {
			hql = hql.replaceAll("::cdUsrSt:", filtro.getDefeito().getOmUsrByIdUsrstativo().getCdUsr());
			hql = hql.replaceAll("::dsNomeSt:", filtro.getDefeito().getOmUsrByIdUsrstativo().getDsNome());
		}
		hql = hql.replaceAll("::revisao:", String.valueOf(filtro.getDefeito().getRevisao()));
		hql = hql.replaceAll("::stAtivo:", String.valueOf(filtro.getDefeito().getStAtivo()));

		Query q = getSession().createQuery(hql);

		try {
			q.setTimestamp("dtRevisao", filtro.getDefeito().getDtRevisao());
			q.setTimestamp("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getDefeito().getDtRevisao()));
		} catch (Exception e) {

		}
		try {
			q.setTimestamp("dtStativo", filtro.getDefeito().getDtStativo());
			q.setTimestamp("dtStativoF",DataHoraRN.getDataHora235959(filtro.getDefeito().getDtStativo()));
		} catch (Exception e) {

		}

		List<DwTDefeito> listaPesquisa = null;
		try {
			listaPesquisa = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<TDefeitoDTO> lista = new ArrayList<TDefeitoDTO>();

		if (listaPesquisa != null) {
			for (DwTDefeito item : listaPesquisa) {
				TDefeitoDTO itemDTO = new TDefeitoDTO();
				itemDTO.setDefeito((DwTDefeito) item.clone());

				itemDTO.setResultadoEvento(0);
				lista.add(itemDTO);
			}
		}

		TDefeitosDTO dtoRetorno = new TDefeitosDTO();
		dtoRetorno.setDefeitos(lista);
		return dtoRetorno;
	}

	public TDefeitoDTO setTDefeitoDTO(TDefeitoDTO itemDTO) {
		TDefeitoDTO dtoRetorno = new TDefeitoDTO();
		dtoRetorno.setResultadoEvento(dtoRetorno.getEVENTO_BEM_SUCEDIDO());

		if (itemDTO.getDefeito() == null || itemDTO.getDefeito().getCdTdefeito() == null || itemDTO.getDefeito().getCdTdefeito().trim().equals("")) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_CDDEFEITO_INVALIDO());
			return dtoRetorno;
		}

		boolean isInclusao = false;

		String hql = "";

		hql = "from DwTDefeito t where t.idTdefeito = ::idTdefeito ";
		hql = hql.replaceAll("::idTdefeito", String.valueOf(itemDTO
				.getDefeito().getIdTdefeito()));

		Query q = getSession().createQuery(hql);

		DwTDefeito itemOriginal = (DwTDefeito) q.uniqueResult();

		//20160926FVA:
		if (itemOriginal != null && itemOriginal.getIdTdefeito() > 0 && itemOriginal.getStAtivo().equals((byte)0)) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_REATIVACAO_INDISPONIVEL());
			return dtoRetorno;
		}


		DwTDefeito itemAlteracao = null;

		if (itemOriginal == null) {
			itemOriginal = (DwTDefeito) itemDTO.getDefeito().clone();
			itemOriginal.setRevisao(1l);
			itemOriginal.setDtRevisao(new Date());
			itemOriginal.setStAtivo((byte) 1);
			itemOriginal.setDtStativo(new Date());
			isInclusao = true;

			// Verifica se o codigo + revisao ja existe no banco, se exitir
			// retornar ao cliente a excessao
			hql = "";

			hql += "from DwTDefeito t ";
			hql += "join t.omTppt omtppt ";
			hql += "where t.cdTdefeito = '::cdTdefeito' and t.stAtivo = 1 and omtppt.cdTppt = '::cdtppt' ";
			hql += "and omtppt.stAtivo = 1 ";

			hql = hql.replaceAll("::cdTdefeito", itemOriginal.getCdTdefeito());
			hql = hql.replaceAll("::cdtppt", String.valueOf(itemDTO.getDefeito().getOmTppt().getCdTppt()));
			
			q = getSession().createQuery(hql);

			if (q.list().size() > 0) {
				dtoRetorno.setResultadoEvento(dtoRetorno
						.getERRO_DEFEITO_JA_EXISTE());
				return dtoRetorno;
			}
		} else {
			itemAlteracao = new DwTDefeito();
			itemAlteracao.copy(itemOriginal, true);
			itemAlteracao.setIdTdefeito(0l);
			itemAlteracao.setStAtivo((byte) 0);
			itemOriginal.copy(itemDTO.getDefeito(), false);
			itemOriginal.setDtRevisao(new Date());
		}

		// Somente apos pesquisar se a nova revisao ja existe � que o pojo
		// original deve ter a revisao somada, se for antes,
		// a pesquisa acima ira trazer o pojo somado
		if (isInclusao == false) {
			itemOriginal.setRevisao(itemOriginal.getRevisao() + 1);
		}

		try {
			hql = "from OmTppt t where t.cdTppt = '::cdTppt' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idTppt ";
			hql = hql.replaceAll("::cdTppt", itemDTO.getDefeito().getOmTppt().getCdTppt());

			q = getSession().createQuery(hql);

			OmTppt omTppt = (OmTppt) q.list().get(0);

			itemOriginal.setOmTppt(omTppt);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno
					.getERRO_TIPOPOSTO_DESCONHECIDO());
			e.printStackTrace();
			return dtoRetorno;
		}

		// Verifica se o id_produto existe
		if (itemDTO.getDefeito().getOmProduto() != null
				&& !itemDTO.getDefeito().getOmProduto().getCdProduto().equals(
						"")) {
			try {
				hql = "from OmProduto t where t.cdProduto = '::cdProduto' ";
				hql += "and t.stAtivo = 1 ";
				hql += "order by t.idProduto ";

				hql = hql.replaceAll("::cdProduto", String.valueOf(itemDTO
						.getDefeito().getOmProduto().getCdProduto()));

				q = getSession().createQuery(hql);

				OmProduto item = (OmProduto) q.list().get(0);

				itemOriginal.setOmProduto(item);

			} catch (Exception e) {
				dtoRetorno.setResultadoEvento(dtoRetorno
						.getERRO_COMPONENTE_DESCONHECIDO());
				return dtoRetorno;
			}
		} else {
			itemOriginal.setOmProduto(null);
		}

		try {
			hql = "from OmUsr t where t.cdUsr = '::cdUsr' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idUsr ";

			hql = hql.replaceAll("::cdUsr", itemDTO.getDefeito()
					.getOmUsrByIdUsrrevisao().getCdUsr());

			q = getSession().createQuery(hql);

			OmUsr omUsrRevisao = (OmUsr) q.list().get(0);

			itemOriginal.setOmUsrByIdUsrrevisao(omUsrRevisao);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno
					.getERRO_USUARIO_REVISAO_DESCONHECIDO());
			e.printStackTrace();
		}

		try {
			hql = "from OmUsr t where t.cdUsr = '::cdUsr' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idUsr ";
			hql = hql.replaceAll("::cdUsr", itemDTO.getDefeito()
					.getOmUsrByIdUsrstativo().getCdUsr());

			q = getSession().createQuery(hql);

			OmUsr omUsrStAtivo = (OmUsr) q.list().get(0);

			itemOriginal.setOmUsrByIdUsrstativo(omUsrStAtivo);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno
					.getERRO_USUARIO_STATUS_DESCONHECIDO());
			e.printStackTrace();
		}

		if (dtoRetorno.getResultadoEvento() == dtoRetorno
				.getEVENTO_BEM_SUCEDIDO()) {
			try {
				itemOriginal = (DwTDefeito) makePersistent(itemOriginal);
				if (itemAlteracao != null) {
					makePersistent(itemAlteracao);
				}
			} catch (Exception e) {
				dtoRetorno
						.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
				e.printStackTrace();
			}

			dtoRetorno.setDefeito((DwTDefeito) itemOriginal.clone());

		}

		return dtoRetorno;
	}

	public TDefeitosDTO removeTDefeitosDTO(TDefeitosDTO itensDTO) {

		List<TDefeitoDTO> listaRetorno = new ArrayList<TDefeitoDTO>();
		for (TDefeitoDTO item : itensDTO.getDefeitos()) {
			TDefeitoDTO itemRetorno = new TDefeitoDTO();
			String hql = "";

			hql = "from DwTDefeito t where t.idTdefeito = ::idTdefeito";
			hql = hql.replaceAll("::idTdefeito", String.valueOf(item
					.getDefeito().getIdTdefeito()));

			Query q = getSession().createQuery(hql);

			DwTDefeito itemOriginal = (DwTDefeito) q.uniqueResult();

			if (itemOriginal == null) {
				itemRetorno.setResultadoEvento(itemRetorno
						.getERRO_CDDEFEITO_INVALIDO());
				itemRetorno.setDefeito(item.getDefeito());
			} else if (itemOriginal.getStAtivo() == 0) {
				itemRetorno.setResultadoEvento(itemRetorno
						.getERRO_CDDEFEITO_INVALIDO());
				itemRetorno.setDefeito((DwTDefeito) itemOriginal.clone());
			} else {
				itemOriginal.setStAtivo((byte) 0);
				itemOriginal.setDtStativo(new Date());

				try {
					itemOriginal = (DwTDefeito) makePersistent(itemOriginal);
				} catch (Exception e) {
					e.printStackTrace();
				}

				itemRetorno.setDefeito((DwTDefeito) itemOriginal.clone());

				itemRetorno.setResultadoEvento(0);
			}

			listaRetorno.add(itemRetorno);
		}

		TDefeitosDTO itensRetorno = new TDefeitosDTO();
		itensRetorno.setDefeitos(listaRetorno);
		return itensRetorno;
	}

	public TDefeitoDTO ativaTDefeitoDTO(TDefeitoDTO itemDTO) {
		TDefeitoDTO itemRetorno = new TDefeitoDTO();
		String hql = "";

		// Verifica se a revisao que est� sendo reativada � a maior para o
		// codigo
		hql = "";

		hql += "from DwTDefeito t ";
		hql += "where t.cdTdefeito = '::cdTdefeito' ";
		hql += "and t.revisao > ::revisao ";

		hql = hql.replaceAll("::cdTdefeito", itemDTO.getDefeito()
				.getCdTdefeito());
		hql = hql.replaceAll("::revisao", String.valueOf((itemDTO.getDefeito()
				.getRevisao())));
		Query qRev = getSession().createQuery(hql);

		if (qRev.list().size() > 0) {
			itemRetorno.setResultadoEvento(itemRetorno
					.getERRO_REATIVACAO_INDISPONIVEL());
			return itemRetorno;
		}

		hql = "from DwTDefeito t where t.idTdefeito = ::idTdefeito";
		hql = hql.replaceAll("::idTdefeito", String.valueOf(itemDTO
				.getDefeito().getIdTdefeito()));

		Query q = getSession().createQuery(hql);

		DwTDefeito itemOriginal = (DwTDefeito) q.uniqueResult();

		if (itemOriginal == null) {
			itemRetorno.setResultadoEvento(itemRetorno
					.getERRO_CDDEFEITO_INVALIDO());
			itemRetorno.setDefeito(itemDTO.getDefeito());
			return itemRetorno;
		} else if (itemOriginal.getStAtivo() == 1) {
			itemRetorno.setResultadoEvento(itemRetorno
					.getERRO_CDDEFEITO_INVALIDO());
			itemRetorno.setDefeito((DwTDefeito) itemOriginal.clone());
		} else {
			itemOriginal.setStAtivo((byte) 1);
			itemOriginal.setDtStativo(new Date());
		}

		try {
			itemOriginal = (DwTDefeito) makePersistent(itemOriginal);
		} catch (Exception e) {
			e.printStackTrace();
		}

		itemRetorno.setDefeito((DwTDefeito) itemOriginal.clone());

		return itemRetorno;
	}
	public PesquisasDTO pesquisaDwTDefeito(PesquisaDTO filtro){
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select a");
		q.append("from DwTDefeito a");
		q.append("WHERE a.stAtivo = :stAtivo");
		
		if (filtro.getCodigo() != null && filtro.getCodigo().equals("") == false && filtro.getDescricao() != null && filtro.getDescricao().equals("") == false) {
			q.append("AND a.cdTdefeito = :cd OR a.dsTdefeito = :ds");
		} else if (filtro.getCodigo().equals("") == false) {
			q.append("AND a.cdTdefeito = :cd");
		} else if (filtro.getDescricao().equals("") == false) {
			q.append("AND a.dsTdefeito = :ds");
		}
		if (filtro.getRegistro() instanceof OmTppt) {
			q.append("and a.omTppt.idTppt = :idtppt");
			q.defineParametro("idtppt", ((OmTppt) filtro.getRegistro()).getIdTppt());
		}
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cd", filtro.getCodigo());
		q.defineParametro("ds", filtro.getDescricao());
		
		List<DwTDefeito> listaDefeitos = q.list();
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();
		for (DwTDefeito defeito : listaDefeitos) {
			PesquisaDTO itemDTO = new PesquisaDTO();
			itemDTO.setCodigo(defeito.getCdTdefeito());
			itemDTO.setDescricao(defeito.getDsTdefeito());
			itemDTO.setRegistro(defeito.clone());
			listaDTO.add(itemDTO);
		}
		PesquisasDTO retorno = new PesquisasDTO();
		retorno.setPesquisa(listaDTO);
		return retorno;
	}
}
