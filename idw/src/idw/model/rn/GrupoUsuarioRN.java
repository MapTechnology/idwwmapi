package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmResguiDAO;
import idw.model.dao.OmUsrgrpDAO;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGrnts;
import idw.model.pojos.OmResgui;
import idw.model.pojos.OmUsrgrp;
import idw.util.Util;
import idw.webservices.dto.CamposEmUsoOmCfgDTO;
import idw.webservices.dto.DireitoAcessoDTO;
import idw.webservices.dto.DireitosAcessoDTO;
import idw.webservices.dto.GrupoUsuarioDTO;
import idw.webservices.dto.GrupoUsuariosDTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.GrupoFerramentasDTO2;
import idw.webservices.rest.idw.v2.dto.GrupoUsrDTO;
import idw.webservices.rest.idw.v2.dto.ListaGruposAcessoUsrDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;
import idw.webservices.rest.idw.v2.dto.UsrDTO;

public class GrupoUsuarioRN extends AbstractRN<DAOGenerico> {

    public GrupoUsuarioRN(){
		this(null);
	}
	
	public GrupoUsuarioRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public GrupoUsuariosDTO getGrupoUsuariosDTO(GrupoUsuarioDTO filtro){

		OmUsrgrpDAO dao = new OmUsrgrpDAO(getDaoSession());
		List<OmUsrgrp> listaOmusrgrp = dao.getOmUsrgrps(filtro.getGrupoUsuario()); 
		
		List<GrupoUsuarioDTO> lista = new ArrayList<GrupoUsuarioDTO>();

		if (listaOmusrgrp != null) {
			for (OmUsrgrp omUsrgrp : listaOmusrgrp) {
				GrupoUsuarioDTO grupoUsuario = new GrupoUsuarioDTO();								
				grupoUsuario.setGrupoUsuario((OmUsrgrp)omUsrgrp.clone());
				grupoUsuario.setDireitosAcesso(new DireitosAcessoDTO());			

				List<DireitoAcessoDTO> direitosAcesso = new ArrayList<DireitoAcessoDTO>();
				for (OmGrnts item : omUsrgrp.getOmGrntses()) {
					DireitoAcessoDTO direitoAcesso = new DireitoAcessoDTO();
					direitoAcesso.setDireitoAcesso((OmGrnts)item.clone());
					direitosAcesso.add(direitoAcesso);
				}
				grupoUsuario.getDireitosAcesso().setDireitosAcesso(direitosAcesso);
				grupoUsuario.setDireitosAcessoParaExclusao(new DireitosAcessoDTO());
				grupoUsuario.getDireitosAcessoParaExclusao().setDireitosAcesso(new ArrayList<DireitoAcessoDTO>());
				grupoUsuario.setResultadoEvento(0);
				lista.add(grupoUsuario);
			}
		}
		GrupoUsuariosDTO grupoUsuarios = new GrupoUsuariosDTO();
		grupoUsuarios.setGrupoUsuarios(lista);
		return grupoUsuarios;
	}

	public GrupoUsuarioDTO setGrupoUsuarioDTO(GrupoUsuarioDTO grupoUsuario){
		GrupoUsuarioDTO grupoUsuarioRetorno = new GrupoUsuarioDTO();
		grupoUsuarioRetorno.setResultadoEvento(grupoUsuarioRetorno.getEVENTO_BEM_SUCEDIDO());

		if (grupoUsuario.getGrupoUsuario().getCdUsrgrp().trim().equals("")){
			grupoUsuarioRetorno.setResultadoEvento(grupoUsuarioRetorno.getERRO_CDUSRGRP_INVALIDO());
			return grupoUsuarioRetorno;
		}

		if (grupoUsuario.getGrupoUsuario().getDsUsrGrp().trim().equals("")){
			grupoUsuarioRetorno.setResultadoEvento(grupoUsuarioRetorno.getERRO_DESCRICAO_INVALIDA());			
			return grupoUsuarioRetorno;
		}

		boolean isInclusao = false;
		
		OmUsrgrpDAO usrgrpDAO = new OmUsrgrpDAO(getDaoSession());
		OmUsrgrp omUsrgrpOriginal = usrgrpDAO.getOmUsrgrpPorId(grupoUsuario.getGrupoUsuario().getIdUsrgrp());
		OmUsrgrp omUsrgrpAlteracao = null;

		if (omUsrgrpOriginal == null){			
			omUsrgrpOriginal = (OmUsrgrp)grupoUsuario.getGrupoUsuario().clone();
			omUsrgrpOriginal.setRevisao(1l);
			omUsrgrpOriginal.setDtRevisao(new Date());
			omUsrgrpOriginal.setStAtivo((byte)1);
			omUsrgrpOriginal.setDtStativo(new Date());			
			isInclusao = true;

			OmUsrgrp usrgrpAux = usrgrpDAO.getOmUsrgrpPorCd(omUsrgrpOriginal.getCdUsrgrp());
			if(usrgrpAux != null){
				grupoUsuarioRetorno.setResultadoEvento(grupoUsuarioRetorno.getERRO_GRUPO_USUARIO_JA_EXISTE());
				return grupoUsuarioRetorno;
			}
		}else{
			omUsrgrpAlteracao = new OmUsrgrp();
			omUsrgrpAlteracao.copy(omUsrgrpOriginal, false);
			omUsrgrpAlteracao.setIdUsrgrp(0l);			
			omUsrgrpAlteracao.setStAtivo((byte)0);
			omUsrgrpOriginal.copy(grupoUsuario.getGrupoUsuario(), false);			
			omUsrgrpOriginal.setDtRevisao(new Date());
		}	

		OmResguiDAO resguiDAO = new OmResguiDAO(getDaoSession());

		// Somente apos pesquisar se a nova revisao ja existe é que o pojo original deve ter a revisao somada, se for antes,
		// a pesquisa acima ira trazer o pojo somado
		if (isInclusao == false){			
			omUsrgrpOriginal.setRevisao(omUsrgrpOriginal.getRevisao() + 1);
			//Exclus�o
			if (grupoUsuario.getDireitosAcessoParaExclusao().getDireitosAcesso() != null){
				for (DireitoAcessoDTO item : grupoUsuario.getDireitosAcessoParaExclusao().getDireitosAcesso()) {
					for (Iterator<OmGrnts> iterator = omUsrgrpOriginal.getOmGrntses().iterator(); iterator.hasNext();) {
						OmGrnts itemGrnts = (OmGrnts) iterator.next();						
						if (item.getDireitoAcesso().getIdGrnts()==itemGrnts.getIdGrnts()){							
							getDao().delete(itemGrnts);
							iterator.remove();
							continue;
						}
					}				
				}
			}
			//inclus�o e altera��oo
			if (grupoUsuario.getDireitosAcesso().getDireitosAcesso() != null){
				for (DireitoAcessoDTO item : grupoUsuario.getDireitosAcesso().getDireitosAcesso()) {
					//inclus�o
					if (item.getDireitoAcesso().getIdGrnts()==0){
						OmGrnts omGrnts = new OmGrnts();
						omGrnts.copy(item.getDireitoAcesso(), false);

						omGrnts.setOmUsrgrp(omUsrgrpOriginal);
						try {
							OmResgui omResgui = resguiDAO.getOmResguiPorId(item.getDireitoAcesso().getOmResgui().getIdResgui());
							omGrnts.setOmResgui(omResgui);
						} catch (Exception e) {
							grupoUsuarioRetorno.setResultadoEvento(grupoUsuarioRetorno.getERRO_RESGUI_DESCONHECIDO());
							e.printStackTrace();
							return grupoUsuarioRetorno;
						}		

						omUsrgrpOriginal.getOmGrntses().add(omGrnts);
						//altera��oo
					}else{
						for (OmGrnts itemGrnts : omUsrgrpOriginal.getOmGrntses()){
							if (item.getDireitoAcesso().getIdGrnts()==itemGrnts.getIdGrnts()){
								itemGrnts.copy(item.getDireitoAcesso(), false);
							}
						}
					}
				}
			}

		}else {			
			Set<OmGrnts> omGrntses = new HashSet<OmGrnts>();
			if (grupoUsuario.getDireitosAcesso() != null && grupoUsuario.getDireitosAcesso().getDireitosAcesso() != null){
				for (DireitoAcessoDTO item : grupoUsuario.getDireitosAcesso().getDireitosAcesso()) {				
					omGrntses.add((OmGrnts)item.getDireitoAcesso().clone());
				}
			}
			omUsrgrpOriginal.setOmGrntses(omGrntses);
			omUsrgrpOriginal.setOmUsrs(null);

			//atualiza OmGrnts - OmUsrgrp e OmResgui
			for (OmGrnts item : omUsrgrpOriginal.getOmGrntses()) {				
				item.setOmUsrgrp(omUsrgrpOriginal);
				try {
					OmResgui omResgui = resguiDAO.getOmResguiPorId(item.getOmResgui().getIdResgui());
					item.setOmResgui(omResgui);
				} catch (Exception e) {
					grupoUsuarioRetorno.setResultadoEvento(grupoUsuarioRetorno.getERRO_RESGUI_DESCONHECIDO());
					e.printStackTrace();
					return grupoUsuarioRetorno;
				}			
			}
		}				

		try{
			omUsrgrpOriginal = (OmUsrgrp) getDao().makePersistent(omUsrgrpOriginal);
			if (omUsrgrpAlteracao != null){
				getDao().makePersistent(omUsrgrpAlteracao);
			}
		} catch (Exception e){
			grupoUsuarioRetorno.setResultadoEvento(grupoUsuarioRetorno.getERRO_DESCONHECIDO());
			e.printStackTrace();
		}				

		grupoUsuarioRetorno.setGrupoUsuario((OmUsrgrp)omUsrgrpOriginal.clone());
		grupoUsuarioRetorno.setDireitosAcesso(new DireitosAcessoDTO());			

		List<DireitoAcessoDTO> direitosAcesso = new ArrayList<DireitoAcessoDTO>();
		for (OmGrnts item : omUsrgrpOriginal.getOmGrntses()) {
			DireitoAcessoDTO direitoAcesso = new DireitoAcessoDTO();
			direitoAcesso.setDireitoAcesso((OmGrnts)item.clone());

			direitosAcesso.add(direitoAcesso);
		}
		grupoUsuarioRetorno.getDireitosAcesso().setDireitosAcesso(direitosAcesso);

		grupoUsuarioRetorno.setDireitosAcessoParaExclusao(new DireitosAcessoDTO());
		grupoUsuarioRetorno.getDireitosAcessoParaExclusao().setDireitosAcesso(new ArrayList<DireitoAcessoDTO>());		

		return grupoUsuarioRetorno;
	}	

	public GrupoUsuariosDTO removeGrupoUsuariosDTO(GrupoUsuariosDTO grupoUsuarios){
		List<GrupoUsuarioDTO> listaRetorno = new ArrayList<GrupoUsuarioDTO>();
		GrupoUsuariosDTO grupoUsuariosRetorno = new GrupoUsuariosDTO();
		
		//17/03/2017 Alex: nao remover codigo em uso na configuracao geral.
		CamposEmUsoOmCfgDTO camposEmUsoOmCfgDTO = getCamposEmUsoOmCfg(grupoUsuarios);
		grupoUsuariosRetorno.setCamposEmUsoOmCfg(camposEmUsoOmCfgDTO);
		if(camposEmUsoOmCfgDTO.getStatus() != camposEmUsoOmCfgDTO.getSTATUS_NENHUM_CAMPO_EM_USO()) {
			//se entrar nesse if eh pq existe algum codigo em uso
			return grupoUsuariosRetorno;
		}
		
		
		for (GrupoUsuarioDTO grupoUsuario : grupoUsuarios.getGrupoUsuarios()){
			GrupoUsuarioDTO grupoUsuarioRetorno = new GrupoUsuarioDTO();
			
			OmUsrgrpDAO usrgrpDAO = new OmUsrgrpDAO(getDaoSession());
			OmUsrgrp omUsrgrp = usrgrpDAO.getOmUsrgrpPorId(grupoUsuario.getGrupoUsuario().getIdUsrgrp());

			if (omUsrgrp == null){			
				grupoUsuarioRetorno.setResultadoEvento(4);
				grupoUsuarioRetorno.setGrupoUsuario(grupoUsuario.getGrupoUsuario());				
			}else if (omUsrgrp.getStAtivo() == 0){			
				grupoUsuarioRetorno.setResultadoEvento(4);
				grupoUsuarioRetorno.setGrupoUsuario(grupoUsuario.getGrupoUsuario());				
			}else{
				omUsrgrp.setStAtivo((byte)0);
				omUsrgrp.setDtStativo(new Date());				

				try{
					omUsrgrp = (OmUsrgrp) getDao().makePersistent(omUsrgrp);			
				} catch (Exception e){
					e.printStackTrace();
				}				

				grupoUsuarioRetorno.setGrupoUsuario((OmUsrgrp)omUsrgrp.clone());
				grupoUsuarioRetorno.setDireitosAcesso(new DireitosAcessoDTO());			

				List<DireitoAcessoDTO> direitosAcesso = new ArrayList<DireitoAcessoDTO>();
				for (OmGrnts item : omUsrgrp.getOmGrntses()) {
					DireitoAcessoDTO direitoAcesso = new DireitoAcessoDTO();
					direitoAcesso.setDireitoAcesso((OmGrnts)item.clone());

					direitosAcesso.add(direitoAcesso);
				}
				grupoUsuarioRetorno.getDireitosAcesso().setDireitosAcesso(direitosAcesso);

				grupoUsuarioRetorno.setDireitosAcessoParaExclusao(new DireitosAcessoDTO());
				grupoUsuarioRetorno.getDireitosAcessoParaExclusao().setDireitosAcesso(new ArrayList<DireitoAcessoDTO>());

				grupoUsuarioRetorno.setResultadoEvento(0);
			}									

			listaRetorno.add(grupoUsuarioRetorno);
		}
		
		grupoUsuariosRetorno.setGrupoUsuarios(listaRetorno);
		return grupoUsuariosRetorno;
	}
	
	private CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg(GrupoUsuariosDTO itens) {
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		
		//campos
		OmUsrgrp grupoSupervisorEmUso = omcfg.getOmUsrgrpByIdUsrgrpsupervisor();
		OmUsrgrp grupoOperadorEmUso = omcfg.getOmUsrgrpByIdUsrgrpoperador();
		
		CamposEmUsoOmCfgDTO camposEmUsoOmCfg = new CamposEmUsoOmCfgDTO();
		boolean isTemCodigoEmUso = false;
		for(GrupoUsuarioDTO item: itens.getGrupoUsuarios()) {
			camposEmUsoOmCfg.setCodigo(item.getGrupoUsuario().getCdUsrgrp());
			
			if(grupoSupervisorEmUso != null) {
				if(item.getGrupoUsuario().getCdUsrgrp().equals(grupoSupervisorEmUso.getCdUsrgrp())) {
					camposEmUsoOmCfg.setGrupoUsuarioSupervisor(true);
					isTemCodigoEmUso = true;
				}
			}
			
			if(grupoOperadorEmUso != null) {
				if(item.getGrupoUsuario().getCdUsrgrp().equals(grupoOperadorEmUso.getCdUsrgrp())) {
					camposEmUsoOmCfg.setGrupoUsuarioOperador(true);
					isTemCodigoEmUso = true;
				}
			}
			
		}
		
		if(isTemCodigoEmUso) {
			
			if(itens.getGrupoUsuarios() != null && itens.getGrupoUsuarios().size() > 1) {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_EXCLUSAO_ABORTADA());
			} else {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_TEM_CAMPO_EM_USO());
			}
			
		} else {
			camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_NENHUM_CAMPO_EM_USO());
		}
		
		return camposEmUsoOmCfg;
	}

	public GrupoUsuarioDTO ativaGrupoUsuarioDTO(GrupoUsuarioDTO grupoUsuario){
		GrupoUsuarioDTO grupoUsuarioRetorno = new GrupoUsuarioDTO();
		OmUsrgrpDAO usrgrpDAO = new OmUsrgrpDAO(getDaoSession());
		
		// Verifica se a revisao que está sendo reativada é a maior para o codigo
		OmUsrgrp usrgrpAux = usrgrpDAO.getOmUsrgrpMaiorRevisao(grupoUsuario.getGrupoUsuario().getCdUsrgrp(), 
				grupoUsuario.getGrupoUsuario().getRevisao());
		if(usrgrpAux != null){
			grupoUsuarioRetorno.setResultadoEvento(grupoUsuarioRetorno.getERRO_REATIVACAO_INDISPONIVEL());
			return grupoUsuarioRetorno;
		}

		OmUsrgrp omUsrgrp = usrgrpDAO.getOmUsrgrpPorId(grupoUsuario.getGrupoUsuario().getIdUsrgrp());

		if (omUsrgrp == null){			
			grupoUsuarioRetorno.setResultadoEvento(4);
			grupoUsuarioRetorno.setGrupoUsuario(grupoUsuario.getGrupoUsuario());
			return grupoUsuarioRetorno;
		}else if (omUsrgrp.getStAtivo() == 1){			
			grupoUsuarioRetorno.setResultadoEvento(4);
			grupoUsuarioRetorno.setGrupoUsuario(grupoUsuario.getGrupoUsuario());				
		}else{
			omUsrgrp.setStAtivo((byte)1);
			omUsrgrp.setDtStativo(new Date());

			try{
				omUsrgrp = (OmUsrgrp) getDao().makePersistent(omUsrgrp);			
			} catch (Exception e){
				e.printStackTrace();
			}				

			grupoUsuarioRetorno.setGrupoUsuario((OmUsrgrp)omUsrgrp.clone());
			grupoUsuarioRetorno.setDireitosAcesso(new DireitosAcessoDTO());			

			List<DireitoAcessoDTO> direitosAcesso = new ArrayList<DireitoAcessoDTO>();
			for (OmGrnts item : omUsrgrp.getOmGrntses()) {
				DireitoAcessoDTO direitoAcesso = new DireitoAcessoDTO();
				direitoAcesso.setDireitoAcesso((OmGrnts)item.clone());

				direitosAcesso.add(direitoAcesso);
			}
			grupoUsuarioRetorno.getDireitosAcesso().setDireitosAcesso(direitosAcesso);

			grupoUsuarioRetorno.setDireitosAcessoParaExclusao(new DireitosAcessoDTO());
			grupoUsuarioRetorno.getDireitosAcessoParaExclusao().setDireitosAcesso(new ArrayList<DireitoAcessoDTO>());
		}								

		return grupoUsuarioRetorno;
	}

	public DireitoAcessoDTO validarRecursoGUI(DireitoAcessoDTO direitoAcesso){
		DireitoAcessoDTO direitoAcessoRetorno = new DireitoAcessoDTO();		
		direitoAcessoRetorno.setResultadoEvento(direitoAcessoRetorno.getEVENTO_BEM_SUCEDIDO());

		OmResgui omResguiOriginal = null;

		try {
			OmResguiDAO resguiDAO = new OmResguiDAO(getDaoSession());
			omResguiOriginal = resguiDAO.getOmResguiPorCd(direitoAcesso.getDireitoAcesso().getOmResgui().getCdResgui());
			if(omResguiOriginal == null){
				direitoAcessoRetorno.setResultadoEvento(direitoAcessoRetorno.getERRO_RESGUI_INVALIDO());
			}
		} catch (Exception e) {
			direitoAcessoRetorno.setResultadoEvento(direitoAcessoRetorno.getERRO_RESGUI_INVALIDO());
			e.printStackTrace();
		}		

		OmGrnts omGrnts = new OmGrnts();
		omGrnts.setIdGrnts(direitoAcesso.getDireitoAcesso().getIdGrnts());
		omGrnts.setTpAcesso(direitoAcesso.getDireitoAcesso().getTpAcesso());
		omGrnts.setOmResgui(omResguiOriginal);

		direitoAcessoRetorno.setDireitoAcesso((OmGrnts)omGrnts.clone());		
		return direitoAcessoRetorno;			

	}
	
	public ListaGruposAcessoUsrDTO getGruposUsrDTO(FiltroPesquisaDTO filtro){
		ListaGruposAcessoUsrDTO retorno = new ListaGruposAcessoUsrDTO();
		retorno.setItems(new ArrayList<GrupoUsrDTO>());
		retorno.setMeta(new MetaDTO(filtro));
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT t");
		q.append("FROM OmUsrgrp t");
		q.append("WHERE t.stAtivo = 1");

		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){			
			q.append("AND (");
			q.append(" upper(t.cdUsrgrp) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.dsUsrGrp) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		} 
 		q.append("ORDER BY t.cdUsrgrp");

 
 		List<OmUsrgrp> lista = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
 		for (OmUsrgrp reg : lista) {
 			GrupoUsrDTO regDTO = new GrupoUsrDTO();

 			regDTO.setIdGrpUsr(reg.getIdUsrgrp());
 			regDTO.setCdGrpUsr(reg.getCdUsrgrp());
 			regDTO.setDsGrpUsr(reg.getDsUsrGrp());
 			regDTO.setStRegistro(reg.getStAtivo().intValue());
 			
 			retorno.getItems().add(regDTO);
 		}
		
		
 		if (lista.size() > 0) {
 			ResumoRetornoRegistrosRN resRN = new ResumoRetornoRegistrosRN(getDao());
 			retorno.setMeta(resRN.getMetaDTO(filtro, q, lista.size()));
 			resRN = null;
 		}
		
		q = null;
		lista = null;

		return retorno;
	}
	
	public GrupoUsrDTO getGrpUsrByCd(String cdUsrGrp){
		GrupoUsrDTO retorno = new GrupoUsrDTO();
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT t");
		q.append("FROM OmUsrgrp t");
		q.append("WHERE t.stAtivo = 1");
		q.append("AND t.cdUsrgrp = :cdUsrGrp");
 		q.append("ORDER BY t.cdUsrgrp");
 		
 		q.defineParametro("cdUsrGrp", cdUsrGrp);
 
 		List<OmUsrgrp> lista = q.list();
 		if (lista.size() == 1) {
 			retorno.setIdGrpUsr(lista.get(0).getIdUsrgrp());
 			retorno.setCdGrpUsr(lista.get(0).getCdUsrgrp());
 			retorno.setDsGrpUsr(lista.get(0).getDsUsrGrp());
 			retorno.setStRegistro(lista.get(0).getStAtivo().intValue()); 			 
 		}

		return retorno;
	}
	
	
	
}
