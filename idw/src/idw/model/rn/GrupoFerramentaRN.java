package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwGrupoFerramentaDAO;
import idw.model.dao.DwRapGrupoDAO;
import idw.model.dao.MapQuery;
import idw.model.dao.OmUsrDAO;
import idw.model.pojos.DwGfEmail;
import idw.model.pojos.DwGfTpos;
import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwRapGrupo;
import idw.model.pojos.DwTurno;
import idw.model.pojos.MmTpos;
import idw.model.pojos.OmCargo;
import idw.model.pojos.OmUsr;
import idw.model.rn.tipoos.TipoOSRN;
import idw.webservices.dto.DwRapDTO;
import idw.webservices.dto.DwRapListDTO;
import idw.webservices.dto.GrupoFerramentaDTO;
import idw.webservices.dto.GruposFerramentaDTO;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasDTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.GrupoFerramentasDTO2;
import idw.webservices.rest.idw.v2.dto.ListaGrupoFerramentasDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;

public class GrupoFerramentaRN extends AbstractRN<DAOGenerico> {

	public GrupoFerramentaRN() {
		this(null);
	}
	
	public GrupoFerramentaRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public PesquisasDTO pesquisaDwGrupoFerramenta(PesquisaDTO pesquisa) {
		DwGrupoFerramentaDAO dao = new DwGrupoFerramentaDAO(getDaoSession());
		List<DwGrupoFerramenta> listaGpFerramenta = dao.pesquisaDwGrupoFerramenta(pesquisa.getCodigo(), pesquisa.getDescricao());
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();
		if (listaGpFerramenta != null) {
			for(DwGrupoFerramenta item : listaGpFerramenta) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdGrupoFerramenta());
				itemDTO.setDescricao(item.getDsGrupoFerramenta());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}

	public DwRapListDTO getRapsDoGrupoRap(DwGrupoFerramenta grupo) {
		DwRapGrupoDAO dao = new DwRapGrupoDAO(getDaoSession());
		List<DwRap> lista = dao.getRapsDoGrupoRap(grupo);
		DwRapListDTO retorno = new DwRapListDTO();
		retorno.setDwRapDTO(new ArrayList<DwRapDTO>());
		for(DwRap rap : lista) {
			DwRapDTO dto = new DwRapDTO();
			dto.setDwRap(rap.clone(false));
			retorno.getDwRapDTO().add(dto);
		}
		return retorno;
	}
	
	public GruposFerramentaDTO getDwGrupoFerramenta(GrupoFerramentaDTO filtro) {
		GruposFerramentaDTO retorno = new GruposFerramentaDTO();
		retorno.setListaGruposFerramenta(new ArrayList<GrupoFerramentaDTO>());
		DwGrupoFerramentaDAO dao = new DwGrupoFerramentaDAO(getDaoSession());
		List<DwGrupoFerramenta> listaGpsFerramenta  = dao.getDwGrupoFerramenta(filtro.getDwGrupoFerramenta());
		for(DwGrupoFerramenta gpFerramenta : listaGpsFerramenta) {
			GrupoFerramentaDTO dto = new GrupoFerramentaDTO();
			dto.setDwGrupoFerramenta(gpFerramenta.clone());
			
			// Se a lista tiver apenas 1 registro, entao retorna os filhos
			if (listaGpsFerramenta.size() == 1 && gpFerramenta.getDwRapGrupos().isEmpty() == false) {
				for (DwRapGrupo rapgrupo : gpFerramenta.getDwRapGrupos()) {
					dto.getDwGrupoFerramenta().getDwRapGrupos().add(rapgrupo.clone());
				}
			}
			
			// Se for apenas um e tiver tipo os retornar
			if (listaGpsFerramenta.size() == 1 && gpFerramenta.getDwGfTposes().isEmpty() == false) {
				for (DwGfTpos tpos : gpFerramenta.getDwGfTposes()) {
					dto.getDwGrupoFerramenta().getDwGfTposes().add(tpos.clone(false));
				}
			}
			
			retorno.getListaGruposFerramenta().add(dto);
		}
		return retorno;
	}
	
	
	/* Inclui ou altera um grupo de ferramenta
	 * 
	 */
	public GrupoFerramentaDTO setDwGrupoFerramenta(GrupoFerramentaDTO dto) {
		GrupoFerramentaDTO retorno = new GrupoFerramentaDTO();
		retorno.setResultadoEvento(retorno.getEVENTO_BEM_SUCEDIDO());
		
		if(dto.getDwGrupoFerramenta().getCdGrupoFerramenta() != null && dto.getDwGrupoFerramenta().getCdGrupoFerramenta().equals("")) {
			retorno.setResultadoEvento(retorno.getERRO_CD_INVALIDO());
			return retorno;
		}
		
		
		//20160926FVA:
		if (dto != null && 
				dto.getDwGrupoFerramenta()!=null && 
				dto.getDwGrupoFerramenta().getIdGrupoFerramenta()!=null && 
				dto.getDwGrupoFerramenta().getIdGrupoFerramenta() > 0 && 
				( dto.getDwGrupoFerramenta().getStAtivo()==null || dto.getDwGrupoFerramenta().getStAtivo().equals((byte)0) ) ) {
			retorno.setResultadoEvento(retorno.getERRO_REATIVACAO_INDISPONIVEL());
			return retorno;
		}
		
		
		DwGrupoFerramentaDAO dao = new DwGrupoFerramentaDAO(getDaoSession());
		boolean isInclusao = false;
		DwGrupoFerramenta grupoFerramentaOriginal = null;		
		DwGrupoFerramenta grupoFerramentaAlteracao = null;
		
		if (dto.getDwGrupoFerramenta().getIdGrupoFerramenta() != null) {
			grupoFerramentaOriginal = dao.getDwGrupoFerramentaPorId(dto.getDwGrupoFerramenta().getIdGrupoFerramenta());
		}
		
		if (grupoFerramentaOriginal == null) {
			DwGrupoFerramenta gpAux = dao.getDwGrupoFerramentatPorCdAtivoOrderById(dto.getDwGrupoFerramenta().getCdGrupoFerramenta());
			if (gpAux != null) {
				retorno.setResultadoEvento(retorno.getERRO_GP_FERRAMENTA_JA_EXISTE());
				return retorno;
			}
			grupoFerramentaOriginal = dto.getDwGrupoFerramenta().clone();
			grupoFerramentaOriginal.setIdGrupoFerramenta(null);
			grupoFerramentaOriginal.setRevisao(1l);
			grupoFerramentaOriginal.setDtRevisao(new Date());
			grupoFerramentaOriginal.setStAtivo((byte) 1);
			grupoFerramentaOriginal.setDtStativo(new Date());
			isInclusao = true;
		} else {
			grupoFerramentaAlteracao = grupoFerramentaOriginal.clone();
			grupoFerramentaAlteracao.setIdGrupoFerramenta(null);
			grupoFerramentaAlteracao.setStAtivo((byte) 0);
			grupoFerramentaAlteracao.setDwRapGrupos(null);
			grupoFerramentaOriginal.setCdGrupoFerramenta(dto.getDwGrupoFerramenta().getCdGrupoFerramenta());
			grupoFerramentaOriginal.setDsGrupoFerramenta(dto.getDwGrupoFerramenta().getDsGrupoFerramenta());
			grupoFerramentaOriginal.setRevisao(dto.getDwGrupoFerramenta().getRevisao());
			grupoFerramentaOriginal.setStAtivo(dto.getDwGrupoFerramenta().getStAtivo());
			grupoFerramentaOriginal.setDtStativo(DataHoraRN.getDataHoraAtual());
			grupoFerramentaOriginal.setDtRevisao(DataHoraRN.getDataHoraAtual());
		}
		
		if(isInclusao == false) {
			grupoFerramentaOriginal.setRevisao(grupoFerramentaOriginal.getRevisao() + 1);
		}
		
		OmUsrDAO usrDAO = new OmUsrDAO(getDaoSession());
		if (dto.getDwGrupoFerramenta().getOmUsrByIdUsrstativo() == null) {
			dto.getDwGrupoFerramenta().setOmUsrByIdUsrstativo(dto.getDwGrupoFerramenta().getOmUsrByIdUsrrevisao());
		}
		
		try {
			OmUsr omUsrStAtivo = usrDAO.getOmUsrPorCdAtivoOrderById(dto.getDwGrupoFerramenta().getOmUsrByIdUsrstativo().getCdUsr());
			grupoFerramentaOriginal.setOmUsrByIdUsrstativo(omUsrStAtivo);
			if (omUsrStAtivo == null) {
				retorno.setResultadoEvento(retorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
				return retorno;
			}
		} catch (Exception e) {
			retorno.setResultadoEvento(retorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
			e.printStackTrace();
			return retorno;
		}
		
		try {
			OmUsr omUsrRevisao = usrDAO.getOmUsrPorCdAtivoOrderById(dto.getDwGrupoFerramenta().getOmUsrByIdUsrrevisao().getCdUsr());
			grupoFerramentaOriginal.setOmUsrByIdUsrrevisao(omUsrRevisao);
			if (omUsrRevisao == null) {
				retorno.setResultadoEvento(retorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
				return retorno;
			}
		} catch (Exception e) {
			retorno.setResultadoEvento(retorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
			e.printStackTrace();
			return retorno;
		}
		
		if (retorno.getResultadoEvento() == retorno.getEVENTO_BEM_SUCEDIDO()) {
			try {
				grupoFerramentaOriginal = this.getDao().makePersistent(grupoFerramentaOriginal);
				if (grupoFerramentaAlteracao != null) {
					grupoFerramentaAlteracao = this.getDao().makePersistent(grupoFerramentaAlteracao);
				}
			} catch (Exception e) {
				retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
				e.printStackTrace();
				return retorno;
			}
		}
		
		// Se foi passada os NS do grupo, salvar aqueles que não tem id definido
		if (dto.getDwGrupoFerramenta().getDwRapGrupos() != null) {
			
			
			
			/* Excluir todos os grupos para depois incluir novamente */
			for (DwRapGrupo dwrapgrupo : grupoFerramentaOriginal.getDwRapGrupos()) {
				getDao().delete(dwrapgrupo);
			}
			
			
			// Incluir novamente os grupo enviados
			DwRapGrupoDAO rn = new DwRapGrupoDAO(getDaoSession());
			DwRapRN rrn = new DwRapRN(getDao());
			for (DwRapGrupo rapgrupo : dto.getDwGrupoFerramenta().getDwRapGrupos()) {
				// Pesquisa DwRap
				rrn.setIdRap(rapgrupo.getDwRap().getIdRap());
				DwRap dwrapPesq = rrn.pesquisarDwRapById();
				if (dwrapPesq == null)
					continue;
				
				// Pesquisa se existe, senao existir incluir
				DwRapGrupo dwrapgrupopesq = rn.getDwRapGrupo(grupoFerramentaOriginal, dwrapPesq);
				if (dwrapgrupopesq == null) {
					rapgrupo.setIdRapGrupo(null);
					rapgrupo.setDwGrupoFerramenta(grupoFerramentaOriginal);
					rapgrupo.setDwRap(dwrapPesq);
					
					getDao().makePersistent(rapgrupo);
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
//		// Se for passado os tipos de OS  em DwGftpos
		if (dto.getDwGrupoFerramenta().getDwGfTposes() != null) {
			
			
			
			/* Apagar todos os tipo os
			 * 
			 */
			for (DwGfTpos tpos : grupoFerramentaOriginal.getDwGfTposes()) {
				getDao().delete(tpos);
			}
			
			
			
			// Incluir os tipos de os
			TipoOSRN orn = new TipoOSRN(getDao());
			for (DwGfTpos tpos : dto.getDwGrupoFerramenta().getDwGfTposes()) {
				
				// Guarda a lista de emails enviada, caso seja uma alteracao
				Set<DwGfEmail> emailsDTO = tpos.getDwGfEmails();
				
				MmTpos mmTpos = orn.pesquisarMmTposById(tpos.getMmTpos().getIdTpos());

				// veriica se ja existe o tipoOS associado ao grupo
				DwGfTpos tposPesq = getDwTpos(grupoFerramentaOriginal, mmTpos);
				
				if (tposPesq == null) {
					tpos.setIdGftpos(null);
				} else {
					tposPesq.setSegIntervalo(tpos.getSegIntervalo());
					tposPesq.setQtCiclos(tpos.getQtCiclos());
					tpos = tposPesq;
				}
				
				tpos.setDwGrupoFerramenta(grupoFerramentaOriginal);
				tpos.setMmTpos(mmTpos);
				
				
				if (tpos.getDwGfEmails() != null) {
					for (DwGfEmail email : emailsDTO) {
						
						// Verifica se ja existe o cadastro
						OmUsr omUsrStAtivo = usrDAO.getOmUsrPorCdAtivoOrderById(email.getOmUsr().getCdUsr());
						
						DwGfEmail emailPesq = null;
						
						if (tpos.getIdGftpos() != null)
							emailPesq = getDwGfEmail(tpos, omUsrStAtivo);
							
						if (emailPesq ==  null) {
							email.setIdGfemail(null);
							email.setDwGfTpos(tpos);
							email.setOmUsr(omUsrStAtivo);
							
							tpos.getDwGfEmails().add(email);
						}
					}
				}
				getDao().makePersistent(tpos);
				
			}
		}
		
		
		retorno.setDwGrupoFerramenta(grupoFerramentaOriginal.clone());
		
		if (dto.getDwGrupoFerramenta().getDwGfTposes().isEmpty() == false) {
			retorno.getDwGrupoFerramenta().setDwGfTposes(new HashSet<DwGfTpos>());
			for (DwGfTpos os : dto.getDwGrupoFerramenta().getDwGfTposes()) {
				retorno.getDwGrupoFerramenta().getDwGfTposes().add(os.clone());
			}
		}
		
		// Clona ferramentas tambem
		if (grupoFerramentaOriginal.getDwRapGrupos().isEmpty() == false) {
			for (DwRapGrupo rapgrupo : grupoFerramentaOriginal.getDwRapGrupos()) {
				retorno.getDwGrupoFerramenta().getDwRapGrupos().add(rapgrupo.clone());
			}
		}

		return retorno;
	}
	
	private DwGfEmail getDwGfEmail(DwGfTpos tpos, OmUsr omUsrStAtivo) {
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from DwGfEmail a");
		q.append("where a.dwGfTpos = :dwgftpos");
		q.append("and a.omUsr = :omusr");
		
		q.defineParametro("dwgftpos", tpos);
		q.defineParametro("omusr", omUsrStAtivo);
		
		q.setMaxResults(1);
		
		return (DwGfEmail) q.uniqueResult();
		
	}
	
	private DwGfTpos getDwTpos(DwGrupoFerramenta dwgrupoferramenta, MmTpos mmtpos) {
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from DwGfTpos a");
		q.append("where a.dwGrupoFerramenta = :dwgrupoferramenta and");
		q.append("a.mmTpos = :tpos");
		
		q.defineParametro("dwgrupoferramenta", dwgrupoferramenta);
		q.defineParametro("tpos", mmtpos);
		
		q.setMaxResults(1);
		
		return (DwGfTpos) q.uniqueResult();
	}
	
	
	public GrupoFerramentaDTO excluirDwGrupoFerramenta(GrupoFerramentaDTO dto) {
		GrupoFerramentaDTO retorno = new GrupoFerramentaDTO();
		DwGrupoFerramentaDAO dao = new DwGrupoFerramentaDAO(getDaoSession());
		DwGrupoFerramenta dwGrupoFerramenta = dao.getDwGrupoFerramentaPorId(dto.getDwGrupoFerramenta().getIdGrupoFerramenta());
		if(dwGrupoFerramenta == null) {
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
			return retorno;
		} else if(dwGrupoFerramenta.getStAtivo() == 0) {
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
			return retorno;
		} else {
			dwGrupoFerramenta.setStAtivo((byte) 0);
			dwGrupoFerramenta.setDtStativo(new Date());
			
			try {
				OmUsrDAO usrDAO = new OmUsrDAO(getDaoSession());
				OmUsr omUsrStAtivo = usrDAO.getOmUsrPorCdAtivoOrderById(dwGrupoFerramenta.getOmUsrByIdUsrstativo().getCdUsr());
				dwGrupoFerramenta.setOmUsrByIdUsrstativo(omUsrStAtivo);
				if (omUsrStAtivo == null) {
					retorno.setResultadoEvento(retorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
					return retorno;
				}
			} catch (Exception e) {
				e.printStackTrace();
				retorno.setResultadoEvento(retorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
				return retorno;
			}

			try {
				dwGrupoFerramenta = this.getDao().makePersistent(dwGrupoFerramenta);
			} catch (Exception e) {
				e.printStackTrace();
			}

			retorno.setDwGrupoFerramenta(dwGrupoFerramenta.clone());
		}
		return retorno;
	}
	
	
	public GruposFerramentaDTO pesquisarGrupoFerramenta(String variavel) {
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from DwGrupoFerramenta a");
		q.append("where a.stAtivo = 1 and (a.dsGrupoFerramenta like :ds or");
		q.append("a.cdGrupoFerramenta like :cd)");
		
		q.defineParametro("cd", "%" + variavel + "%");
		q.defineParametro("ds", "%" + variavel + "%");
		
		List<DwGrupoFerramenta> lista = q.list();
		
		GruposFerramentaDTO retorno = new GruposFerramentaDTO();
		retorno.setListaGruposFerramenta(new ArrayList<GrupoFerramentaDTO>());
		for (DwGrupoFerramenta ft : lista) {
			GrupoFerramentaDTO parametro = new GrupoFerramentaDTO();
			parametro.setDwGrupoFerramenta(ft.clone(lista.size()  == 1));
			
			if (lista.size() == 1 && ft.getDwRapGrupos().isEmpty() == false) {
				for (DwRapGrupo rapgrupo : ft.getDwRapGrupos()) {
					parametro.getDwGrupoFerramenta().getDwRapGrupos().add(rapgrupo.clone());
				}
			}

			
			retorno.getListaGruposFerramenta().add(parametro);
			
		}
		
		return retorno;
	}




	public DwGrupoFerramenta pesquisarGrupoFerramentaByCd(String cd) {
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from DwGrupoFerramenta a");
		q.append("where a.stAtivo = 1 and ");
		q.append("a.cdGrupoFerramenta = :cd");
		
		q.defineParametro("cd", cd);
		q.setMaxResults(1);
		
		DwGrupoFerramenta retorno = (DwGrupoFerramenta) q.uniqueResult();
		
		return retorno;
	}
	
		

	@SuppressWarnings("unused")
	public ListaGrupoFerramentasDTO getGrpFerramentasDTO(FiltroPesquisaDTO filtro) {
		ListaGrupoFerramentasDTO retorno = new ListaGrupoFerramentasDTO();
		retorno.setItems(new ArrayList<GrupoFerramentasDTO2>());
		retorno.setMeta(new MetaDTO(filtro));
		
		MapQuery q = new MapQuery(this.getDaoSession());
		
		q.append("select t ");
		q.append("from DwGrupoFerramenta t ");
		q.append("where t.stAtivo = 1 ");
		
		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){
			q.append("AND (");
			q.append(" upper(t.cdGrupoFerramenta) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.dsGrupoFerramenta) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		}
		
		q.append("order by t.cdGrupoFerramenta");
		
		
		List<DwGrupoFerramenta> listaPesquisa = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
		
 		for (DwGrupoFerramenta registro : listaPesquisa) {
 			
 			GrupoFerramentasDTO2 regDTO = new GrupoFerramentasDTO2();
 			
 			regDTO.setIdGrupoFerramenta(registro.getIdGrupoFerramenta());
 			regDTO.setCdGrupoFerramenta(registro.getCdGrupoFerramenta());
 			regDTO.setDsGrupoFerramenta(registro.getDsGrupoFerramenta());
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
	public GrupoFerramentasDTO2 getGrpFerramentaByCd(String cdGrpFerramenta) {
		GrupoFerramentasDTO2 retorno = new GrupoFerramentasDTO2();
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select t ");
		q.append("from DwGrupoFerramenta t ");
		q.append("where t.stAtivo = 1 ");
		q.append("  AND t.cdGrupoFerramenta = :cdGrpFerramenta ");
		q.append("order by t.cdGrupoFerramenta");
		
 		q.defineParametro("cdGrpFerramenta", cdGrpFerramenta);
 		
 		List<DwGrupoFerramenta> lista = q.list();
 		
 		if (lista.size() == 1) {
 			
 			retorno.setIdGrupoFerramenta(lista.get(0).getIdGrupoFerramenta());
 			retorno.setCdGrupoFerramenta(lista.get(0).getCdGrupoFerramenta());
 			retorno.setDsGrupoFerramenta(lista.get(0).getDsGrupoFerramenta());
 			retorno.setStRegistro(lista.get(0).getStAtivo().intValue());
 			
 		}
		
		return retorno;
	}


	public DwGrupoFerramenta getDwGrpFerramentaPorCodigo(String cdGrupoFerramenta){
		
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("FROM DwGrupoFerramenta t ");
		q.append("where t.stAtivo = 1 ");
		q.append("AND t.cdGrupoFerramenta = :cdGrupoFerramenta ");
		q.defineParametro("cdGrupoFerramenta", cdGrupoFerramenta);
		return (DwGrupoFerramenta) q.uniqueResult();
		
	}
	
	/*
	public DwRapGrupo getDwRapGrupo(String cdGrupoFerramenta, String cdRap){
		
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("FROM DwRapGrupo t ");
		q.append("where t.dwGrupoFerramenta.stAtivo = 1 ");
		q.append("  and t.dwRap.stAtivo = 1 ");
		q.append("  and t.dwGrupoFerramenta.cdGrupoFerramenta = :cdGrupoFerramenta ");
		q.append("  and t.dwRap.cdRap = :cdRap ");
		q.defineParametro("cdGrupoFerramenta", cdGrupoFerramenta);
		q.defineParametro("cdRap", cdRap);		
		return (DwRapGrupo) q.uniqueResult();
		
	}
	*/
	
}
