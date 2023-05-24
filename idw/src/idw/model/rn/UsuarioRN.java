package idw.model.rn;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmCargoDAO;
import idw.model.dao.OmCcDAO;
import idw.model.dao.OmGtDAO;
import idw.model.dao.OmPtDAO;
import idw.model.dao.OmUsrDAO;
import idw.model.dao.OmUsrgrpDAO;
import idw.model.excessoes.DigestFileException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.excessoes.SemComunicacaoException;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.OmCargo;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGrnts;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmHomogt;
import idw.model.pojos.OmHomopt;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.OmUsrgrp;
import idw.model.pojos.template.OmUsrTemplate;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.CamposEmUsoOmCfgDTO;
import idw.webservices.dto.FiltroRelatorioUsuarioDTO;
import idw.webservices.dto.HomologacaoDTO;
import idw.webservices.dto.HomologacoesDTO;
import idw.webservices.dto.UsuarioCODTO;
import idw.webservices.dto.UsuarioDTO;
import idw.webservices.dto.UsuariosDTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.ListaUsuariosDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;
import idw.webservices.rest.idw.v2.dto.UsrDTO;


public class UsuarioRN extends AbstractRN<DAOGenerico> {

	public UsuarioRN() {
		super(new DAOGenerico());
	}

	public UsuarioRN(DAOGenerico dao) {
		super(dao);
	}

	public UsuariosDTO getUsuariosDTO(UsuarioDTO filtro){
		OmUsrDAO userDAO = new OmUsrDAO(getDaoSession());
		List<OmUsr> listaOmusr = userDAO.getOmUsrs(filtro.getUsuario());

		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();

		for (OmUsr omUsr : listaOmusr) {
			UsuarioDTO usuario = new UsuarioDTO();
			usuario.setUsuario(omUsr.clone());
			usuario.setVersaoServidor(Util.getVersao());

			usuario.setHomologacoes(new HomologacoesDTO());

			//HomoPts
			List<HomologacaoDTO> homologacoesPt = new ArrayList<HomologacaoDTO>();
			for (OmHomopt item : omUsr.getOmHomoptsForIdUsrhomologado()) {
				HomologacaoDTO homologacao = new HomologacaoDTO();
				homologacao.setHomologacaoPt((OmHomopt)item.clone(false));
				homologacao.getHomologacaoPt().setOmPt(item.getOmPt().clone(false));
				homologacao.getHomologacaoPt().getOmPt().setOmGt(item.getOmPt().getOmGt().clone(false));
				homologacao.getHomologacaoPt().getOmPt().setOmTppt(item.getOmPt().getOmTppt().clone(false));

				homologacoesPt.add(homologacao);
			}
			usuario.getHomologacoes().setHomologacoesPt(homologacoesPt);

			//HomoGts
			List<HomologacaoDTO> homologacoesGt = new ArrayList<HomologacaoDTO>();
			for (OmHomogt item : omUsr.getOmHomogtsForIdUsrhomologado()) {
				HomologacaoDTO homologacao = new HomologacaoDTO();
				homologacao.setHomologacaoGt((OmHomogt)item.clone());

				homologacoesGt.add(homologacao);
			}
			usuario.getHomologacoes().setHomologacoesGt(homologacoesGt);

			usuario.setResultadoEvento(0);
			lista.add(usuario);
		}

		UsuariosDTO usuarios = new UsuariosDTO();
		usuarios.setUsuarios(lista);
		return usuarios;
	}
	
	// pesquisar por like no cd e ds
	public UsuariosDTO getUsuariosDTO(String variavel){
		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from OmUsr a");
		q.append("where (a.cdUsr like :cd or a.dsNome like :ds)");
		q.append("and a.stAtivo = 1");
		
		q.defineParametro("cd", "%" + variavel + "%");
		q.defineParametro("ds", "%" + variavel + "%");
		
		List<OmUsr> listaOmusr = q.list();

		for (OmUsr omUsr : listaOmusr) {
			UsuarioDTO usuario = new UsuarioDTO();
			usuario.setUsuario(omUsr.clone(false));
			lista.add(usuario);
		}
		
		UsuariosDTO usuarios = new UsuariosDTO();
		usuarios.setUsuarios(lista);
		return usuarios;
	}


	public UsuarioDTO setUsuarioDTO(UsuarioDTO usuario){
		UsuarioDTO usuarioRetorno = new UsuarioDTO();
		usuarioRetorno.setResultadoEvento(usuarioRetorno.getEVENTO_BEM_SUCEDIDO());

		if (usuario.getUsuario().getCdUsr().trim().equals("")){
			usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_CDUSR_INVALIDO());
			return usuarioRetorno;
		}

		OmUsrDAO usrDAO = new OmUsrDAO(getDaoSession());
		OmGtDAO gtDAO = new OmGtDAO(getDaoSession());

		if ((usuario.getUsuario().getLogin() != null) && !usuario.getUsuario().getLogin().equals("")){
			OmUsr usrAux =  usrDAO.getOmUsrPorCdeLogin(usuario.getUsuario().getCdUsr(), usuario.getUsuario().getLogin());
			if(usrAux != null){
				usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_USUARIO_JA_EXISTE());
				return usuarioRetorno;
			}
		}
		
		if (usuario.getUsuario().getSenha() == null || usuario.getUsuario().getSenha().equals("")) {
			usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_LOGIN_INVALIDO());
			return usuarioRetorno;
		}

		if (usuario.getUsuario().getLogin() == null || usuario.getUsuario().getLogin().equals("")) {
			usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_LOGIN_INVALIDO());
			return usuarioRetorno;
		}

		OmUsr omUsrOriginal = usrDAO.getOmUsrPorId(usuario.getUsuario().getIdUsr());
		
		OmUsr omUsrAlteracao = null;

		boolean isInclusao = false;

		if (omUsrOriginal == null){
			omUsrOriginal = usuario.getUsuario().clone();
			omUsrOriginal.setRevisao(1l);
			omUsrOriginal.setDtRevisao(new Date());
			omUsrOriginal.setStAtivo((byte)1);
			omUsrOriginal.setDtStativo(new Date());
			isInclusao = true;

			OmUsr usrAux = usrDAO.getOmUsrPorCdAtivo(omUsrOriginal.getCdUsr());
			if(usrAux != null){
				usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_USUARIO_JA_EXISTE());
				return usuarioRetorno;
			}
		}else{
			omUsrAlteracao = new OmUsr();
			omUsrAlteracao.copy(omUsrOriginal, true);
			omUsrAlteracao.setOmUsrgrp(omUsrOriginal.getOmUsrgrp());
			omUsrAlteracao.setIdUsr(0l);
			omUsrAlteracao.setStAtivo((byte)0);
			omUsrAlteracao.setOmHomoptsForIdUsrhomologado(null);
			
			omUsrOriginal.copy(usuario.getUsuario(), false);
			omUsrOriginal.setDtStativo(DataHoraRN.getDataHoraAtual()); 
			omUsrOriginal.setDtRevisao(DataHoraRN.getDataHoraAtual());
			omUsrOriginal.setOmUsrgrp(omUsrAlteracao.getOmUsrgrp());
		}
		
		OmUsr omUsrRevisao = null;
		try {
			omUsrRevisao = usrDAO.getOmUsrPorCdAtivoOrderById(usuario.getUsuario().getOmUsrByIdUsrrevisao().getCdUsr());//(OmUsr) q.list().get(0);
			omUsrOriginal.setOmUsrByIdUsrrevisao(omUsrRevisao);
			if(omUsrRevisao == null){
				usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
				return usuarioRetorno;
			}
		} catch (Exception e) {
			usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
			e.printStackTrace();
			return usuarioRetorno;
		}

		try {
			OmUsr omUsrStAtivo = usrDAO.getOmUsrPorCdAtivoOrderById(usuario.getUsuario().getOmUsrByIdUsrstativo().getCdUsr());
			omUsrOriginal.setOmUsrByIdUsrstativo(omUsrStAtivo);
			if(omUsrStAtivo == null){
				usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
				return usuarioRetorno;
			}
		} catch (Exception e) {
			usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
			e.printStackTrace();
			return usuarioRetorno;
		}

		// Somente apos pesquisar se a nova revisao ja existe é que o pojo original deve ter a revisao somada, se for antes,
		// a pesquisa acima ira trazer o pojo somado
		if (isInclusao == false){
			omUsrOriginal.setRevisao(omUsrOriginal.getRevisao()+1);
			//HOMOPTS

			//Exclus�o
			if (omUsrOriginal.getOmHomoptsForIdUsrhomologado() != null){
				for (Iterator<OmHomopt> iterator = omUsrOriginal.getOmHomoptsForIdUsrhomologado().iterator(); iterator.hasNext();) {
					OmHomopt item = (OmHomopt) iterator.next();
					this.getDaoSession().delete(item);
					iterator.remove();
					continue;
				}
			}
			//inclus�o
			if ((usuario.getHomologacoes() != null) && (usuario.getHomologacoes().getHomologacoesPt() != null)){
				omUsrOriginal.setOmHomoptsForIdUsrhomologado(new HashSet<OmHomopt>());
				for (HomologacaoDTO item : usuario.getHomologacoes().getHomologacoesPt()) {
					//inclus�o
					OmHomopt omHomopt = new OmHomopt();
					omHomopt.copy(item.getHomologacaoPt(), false);
					omHomopt.setIdHomo(0);
					omHomopt.setDthrHomopt(new Date());

					//omHomopt.setOmUsrByIdUsrhomologado(omUsrOriginal);

					//Verifica se o usuário homologado existe
					try {
						OmUsr omUsrHomologado = usrDAO.getOmUsrPorId(usuario.getUsuario().getIdUsr());
						omHomopt.setOmUsrByIdUsrhomologado(omUsrHomologado);
						if(omUsrHomologado == null){
							usuarioRetorno.setResultadoEvento(usuario.getERRO_USUARIO_REVISAO_DESCONHECIDO());
							return usuarioRetorno;
						}
					} catch (Exception e) {
						usuarioRetorno.setResultadoEvento(usuario.getERRO_USUARIO_REVISAO_DESCONHECIDO());
						e.printStackTrace();
						return usuarioRetorno;
					}
					
					//Verifica se o usuário homologador existe
					try {
						OmUsr omUsrHomologador = usrDAO.getOmUsrPorId(omUsrRevisao.getIdUsr());
						omHomopt.setOmUsrByIdUsr(omUsrHomologador);
						if(omUsrHomologador == null){
							usuarioRetorno.setResultadoEvento(usuario.getERRO_USUARIO_REVISAO_DESCONHECIDO());
							return usuarioRetorno;
						}
					} catch (Exception e) {
						usuarioRetorno.setResultadoEvento(usuario.getERRO_USUARIO_REVISAO_DESCONHECIDO());
						e.printStackTrace();
						return usuarioRetorno;
					}
					
					//Verifica se o posto de trabalho existe
					try {
						OmPtDAO ptDAO = new OmPtDAO(getDaoSession());
						OmPt omPt = ptDAO.getOmPtPorId(item.getHomologacaoPt().getOmPt().getIdPt());
						omHomopt.setOmPt(omPt);
						if(omPt == null){
							usuarioRetorno.setResultadoEvento(usuario.getERRO_DESCONHECIDO());
							return usuarioRetorno;
						}
					} catch (Exception e) {
						usuarioRetorno.setResultadoEvento(usuario.getERRO_DESCONHECIDO());
						e.printStackTrace();
						return usuarioRetorno;
					}
					omUsrOriginal.getOmHomoptsForIdUsrhomologado().add(omHomopt);
				}
			}

			//HOMOGTS

			//Exclus�o
			if (omUsrOriginal.getOmHomogtsForIdUsrhomologado() != null){
				for (Iterator<OmHomogt> iterator = omUsrOriginal.getOmHomogtsForIdUsrhomologado().iterator(); iterator.hasNext();) {
					OmHomogt item = (OmHomogt) iterator.next();
					this.getDaoSession().delete(item);
				}
				omUsrOriginal.setOmHomogtsForIdUsrhomologado(new HashSet<OmHomogt>());
			}
			//inclus�o
			if ((usuario.getHomologacoes() != null) && (usuario.getHomologacoes().getHomologacoesGt() != null)){
				for (HomologacaoDTO item : usuario.getHomologacoes().getHomologacoesGt()) {
					//inclus�o
					OmHomogt omHomogt = new OmHomogt();
					omHomogt.copy(item.getHomologacaoGt(), false);
					omHomogt.setIdHomogt(0);
					omHomogt.setDtHomogt(new Date());

					//omHomopt.setOmUsrByIdUsrhomologado(omUsrOriginal);

					//Verifica se o usuário homologado existe
					try {
						OmUsr omUsr = usrDAO.getOmUsrPorId(usuario.getUsuario().getIdUsr());
						omHomogt.setOmUsrByIdUsrhomologado(omUsr);
						if(omUsr == null){
							usuarioRetorno.setResultadoEvento(usuario.getERRO_DESCONHECIDO());
							return usuarioRetorno;
						}
					} catch (Exception e) {
						usuarioRetorno.setResultadoEvento(usuario.getERRO_DESCONHECIDO());
						e.printStackTrace();
						return usuarioRetorno;
					}
					
					//Verifica se o usuário homologador existe
					try {
						OmUsr omUsr = usrDAO.getOmUsrPorId(omUsrRevisao.getIdUsr());
						omHomogt.setOmUsrByIdUsr(omUsr);
						if(omUsr == null){
							usuarioRetorno.setResultadoEvento(usuario.getERRO_DESCONHECIDO());
							return usuarioRetorno;
						}
					} catch (Exception e) {
						usuarioRetorno.setResultadoEvento(usuario.getERRO_DESCONHECIDO());
						e.printStackTrace();
						return usuarioRetorno;
					}
					
					//Verifica se o grupo de trabalho existe
					try {
						OmGt omGt = gtDAO.getOmGtPorCdAtivo(item.getHomologacaoGt().getOmGt().getCdGt());
						omHomogt.setOmGt(omGt);
						if(omGt == null){
							usuarioRetorno.setResultadoEvento(usuario.getERRO_DESCONHECIDO());
							return usuarioRetorno;
						}
					} catch (Exception e) {
						usuarioRetorno.setResultadoEvento(usuario.getERRO_DESCONHECIDO());
						e.printStackTrace();
						return usuarioRetorno;
					}

					omUsrOriginal.getOmHomogtsForIdUsrhomologado().add(omHomogt);
				}
			}
		}

		try {
			OmUsrgrpDAO usrgrpDAO = new OmUsrgrpDAO(getDaoSession());
			OmUsrgrp omUsrgrp = usrgrpDAO.getOmUsrgrpPorCdAtivoOrderById(usuario.getUsuario().getOmUsrgrp().getCdUsrgrp());//(OmUsrgrp) q.list().get(0);
			omUsrOriginal.setOmUsrgrp(omUsrgrp);
			if(omUsrgrp == null){
				usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_GRUPO_DESCONHECIDO());
				return usuarioRetorno;
			}
		} catch (Exception e) {
			usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_GRUPO_DESCONHECIDO());
			e.printStackTrace();
			return usuarioRetorno;
		}

		if((usuario.getUsuario().getOmGt() != null) && (usuario.getUsuario().getOmGt().getCdGt() != null) && !usuario.getUsuario().getOmGt().getCdGt().equals("")){
			try {
				OmGt omGt = gtDAO.getOmGtPorCdAtivo(usuario.getUsuario().getOmGt().getCdGt());
				omUsrOriginal.setOmGt(omGt);
				if(omGt == null){
					usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_GRUPO_DESCONHECIDO());
					return usuarioRetorno;	
				}
			} catch (Exception e) {
				usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_GRUPO_DESCONHECIDO());
				e.printStackTrace();
				return usuarioRetorno;
			}
		}else{
			omUsrOriginal.setOmGt(null);
		}

		if ((usuario.getUsuario().getOmCc() != null) && (usuario.getUsuario().getOmCc().getCdCc() != null) && !usuario.getUsuario().getOmCc().getCdCc().equals("")){
			try {
				OmCcDAO ccDAO = new OmCcDAO(getDaoSession());
				OmCc omCc = ccDAO.getOmCcPorCdAtivoOrderById(usuario.getUsuario().getOmCc().getCdCc());
				omUsrOriginal.setOmCc(omCc);
				if(omCc == null){
					usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_CC_DESCONHECIDO());
					return usuarioRetorno;
				}
			} catch (Exception e) {
				usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_CC_DESCONHECIDO());
				e.printStackTrace();
				return usuarioRetorno;
			}
		} else {
			omUsrOriginal.setOmCc(null);
		}
		
		if ((usuario.getUsuario().getOmCargo() != null) && (usuario.getUsuario().getOmCargo().getCdCargo() != null) && !usuario.getUsuario().getOmCargo().getCdCargo().equals("")){
			try {
				OmCargoDAO cargoDAO = new OmCargoDAO(getDaoSession());
				OmCargo omCargo = cargoDAO.getOmCargoOrderById(usuario.getUsuario().getOmCargo().getCdCargo());
				omUsrOriginal.setOmCargo(omCargo);
				if(omCargo == null){
					usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_CARGO_DESCONHECIDO());
					return usuarioRetorno;
				}
			} catch (Exception e) {
				usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_CARGO_DESCONHECIDO());
				e.printStackTrace();
				return usuarioRetorno;
			}
		} else {
			omUsrOriginal.setOmCargo(null);
		}

		if (usuarioRetorno.getResultadoEvento() == usuarioRetorno.getEVENTO_BEM_SUCEDIDO()){
			// Limita alguns campos
			if (omUsrOriginal.getDsApelido() != null && omUsrOriginal.getDsApelido().length() > 10) {
				omUsrOriginal.setDsApelido(omUsrOriginal.getDsApelido().substring(0, 10));
			}

			try{
				omUsrOriginal = this.getDao().makePersistent(omUsrOriginal);
				if (omUsrAlteracao != null){
					omUsrAlteracao = this.getDao().makePersistent(omUsrAlteracao);
				}
			} catch (Exception e){
				e.printStackTrace();
				usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_DESCONHECIDO());
			}

			usuarioRetorno.setUsuario(omUsrOriginal.clone());

			usuarioRetorno.setHomologacoes(new HomologacoesDTO());

			//HomoPts
			List<HomologacaoDTO> homologacoesPt = new ArrayList<HomologacaoDTO>();
			for (OmHomopt item : omUsrOriginal.getOmHomoptsForIdUsrhomologado()) {
				HomologacaoDTO homologacao = new HomologacaoDTO();
				homologacao.setHomologacaoPt((OmHomopt)item.clone());
				homologacao.getHomologacaoPt().setOmPt(item.getOmPt().clone(false));
				homologacao.getHomologacaoPt().getOmPt().setOmGt(item.getOmPt().getOmGt().clone(false));
				homologacao.getHomologacaoPt().getOmPt().setOmTppt(item.getOmPt().getOmTppt().clone(false));
				homologacoesPt.add(homologacao);
			}
			usuarioRetorno.getHomologacoes().setHomologacoesPt(homologacoesPt);

			//HomoGts
			List<HomologacaoDTO> homologacoesGt = new ArrayList<HomologacaoDTO>();
			for (OmHomogt item : omUsrOriginal.getOmHomogtsForIdUsrhomologado()) {
				HomologacaoDTO homologacao = new HomologacaoDTO();
				homologacao.setHomologacaoGt((OmHomogt)item.clone());

				homologacoesGt.add(homologacao);
			}
			usuarioRetorno.getHomologacoes().setHomologacoesGt(homologacoesGt);

			usuarioRetorno.setResultadoEvento(0);
		}
		return usuarioRetorno;
	}

	public UsuariosDTO removeUsuariosDTO(UsuariosDTO usuarios){
		UsuariosDTO usuariosRetorno = new UsuariosDTO();
		List<UsuarioDTO> listaRetorno = new ArrayList<UsuarioDTO>();
		
		ConsolidaRN rn = new ConsolidaRN(getDao());
		
		//17/03/2017 Alex: nao remover codigo em uso na configuracao geral.
		CamposEmUsoOmCfgDTO camposEmUsoOmCfgDTO = getCamposEmUsoOmCfg(usuarios);
		usuariosRetorno.setCamposEmUsoOmCfg(camposEmUsoOmCfgDTO);
		if(camposEmUsoOmCfgDTO.getStatus() != camposEmUsoOmCfgDTO.getSTATUS_NENHUM_CAMPO_EM_USO()) {
			//se entrar nesse if eh pq existe algum codigo em uso
			return usuariosRetorno;
		}
				
		
		for (UsuarioDTO usuario : usuarios.getUsuarios()){
			UsuarioDTO usuarioRetorno = new UsuarioDTO();
			OmUsrDAO usrDAO = new OmUsrDAO(getDaoSession());
			OmUsr omUsr = usrDAO.getOmUsrPorId(usuario.getUsuario().getIdUsr());

			if (omUsr == null){
				usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_CARGO_DESCONHECIDO());
				usuarioRetorno.setUsuario(usuario.getUsuario());
				
			} else if (omUsr.getStAtivo() == 0){
				usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
				usuarioRetorno.setUsuario(omUsr.clone());
			} else {
				/* Verificar se o usuario está logado em algum IHM. Se estiver então o mesmo não deve ser excluildo
				 * 
				 */
				DwConsolmolog molog = rn.getDwConsolmologComLoginAbertoECdLogin(omUsr.getLogin());
				
				if (molog != null) {
					usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_USUARIO_LOGADO());
					usuarioRetorno.setUsuario(omUsr.clone());
					
					usuariosRetorno.setResultadoEvento(usuariosRetorno.getERRO_USUARIO_LOGADO());
				} else {
					omUsr.setStAtivo((byte)0);
					omUsr.setDtStativo(new Date());
	
					try {
						OmUsr omUsrStAtivo = usrDAO.getOmUsrPorCdAtivo(usuario.getUsuario().getOmUsrByIdUsrstativo().getCdUsr());
						omUsr.setOmUsrByIdUsrstativo(omUsrStAtivo);
					} catch (Exception e) {
						e.printStackTrace();
					}
	
					try{
						omUsr = this.getDao().makePersistent(omUsr);
					} catch (Exception e){
						e.printStackTrace();
					}
	
					usuarioRetorno.setUsuario(omUsr.clone());
					usuarioRetorno.setResultadoEvento(usuarioRetorno.getEVENTO_BEM_SUCEDIDO());
				}
			}

			listaRetorno.add(usuarioRetorno);
		}
		
		usuariosRetorno.setUsuarios(listaRetorno);
		return usuariosRetorno;
	}
	
	private CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg(UsuariosDTO itens) {
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		
		//campos
		OmUsr usuarioEmUso = omcfg.getOmUsrimpprog();
		
		CamposEmUsoOmCfgDTO camposEmUsoOmCfg = new CamposEmUsoOmCfgDTO();
		boolean isTemCodigoEmUso = false;
		for(UsuarioDTO item: itens.getUsuarios()) {
			camposEmUsoOmCfg.setCodigo(item.getUsuario().getCdUsr());
			
			if(usuarioEmUso != null) {
				if(item.getUsuario().getCdUsr().equals(usuarioEmUso.getCdUsr())) {
					camposEmUsoOmCfg.setUsuarioParaImportarProgramasIAC(true);
					isTemCodigoEmUso = true;
				}
			}
			
		}
		
		if(isTemCodigoEmUso) {
			
			if(itens.getUsuarios() != null && itens.getUsuarios().size() > 1) {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_EXCLUSAO_ABORTADA());
			} else {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_TEM_CAMPO_EM_USO());
			}
			
		} else {
			camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_NENHUM_CAMPO_EM_USO());
		}
		
		return camposEmUsoOmCfg;
	}

	public UsuarioDTO ativaUsuarioDTO(UsuarioDTO usuario){
		UsuarioDTO usuarioRetorno = new UsuarioDTO();
		String hql = "";

		// Verifica se a revisao que está sendo reativada é a maior para o codigo
		hql = "";

		hql += "from OmUsr omusr ";
		hql += "where omusr.cdUsr = '::cdusr' ";
		hql += "and omusr.revisao > ::revisao ";

		hql = hql.replaceAll("::cdusr", usuario.getUsuario().getCdUsr());
		hql = hql.replaceAll("::revisao", String.valueOf((usuario.getUsuario().getRevisao())));
		Query qRev = this.getDaoSession().createQuery(hql);

		if (qRev.list().size() > 0){
			usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_REATIVACAO_INDISPONIVEL());
			return usuarioRetorno;
		}

		hql = "from OmUsr omusr where omusr.idUsr = ::idusuario";
		hql = hql.replaceAll("::idusuario", String.valueOf(usuario.getUsuario().getIdUsr()));

		Query q = this.getDaoSession().createQuery(hql);

		OmUsr omUsr = (OmUsr) q.uniqueResult();

		if (omUsr == null){
			usuarioRetorno.setResultadoEvento(4);
			usuarioRetorno.setUsuario(usuario.getUsuario());
			return usuarioRetorno;
		}else if (omUsr.getStAtivo()==1){
			usuarioRetorno.setResultadoEvento(4);
			usuarioRetorno.setUsuario(omUsr.clone());
		}else{
			omUsr.setStAtivo((byte)1);
			omUsr.setDtStativo(new Date());
		}

		try {
			hql = "from OmUsr t where t.cdUsr = '::cdUsr' ";
			hql = hql.replaceAll("::cdUsr", usuario.getUsuario().getOmUsrByIdUsrstativo().getCdUsr());

			q = this.getDaoSession().createQuery(hql);

			OmUsr omUsrStAtivo = (OmUsr) q.uniqueResult();

			omUsr.setOmUsrByIdUsrstativo(omUsrStAtivo);
		} catch (Exception e) {

		}

		try{
			omUsr = this.getDao().makePersistent(omUsr);
		} catch (Exception e){
			e.printStackTrace();
		}

		usuarioRetorno.setUsuario(omUsr.clone());
		return usuarioRetorno;
	}
	
	public OmUsr getUsuario(String login, String senha) {
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT usuario");
		q.append("FROM OmUsr usuario");
		q.append("LEFT JOIN FETCH usuario.omGt gt");
		q.append("WHERE UPPER(usuario.login) = :login AND usuario.stAtivo = :stAtivo");
		q.defineParametro("login", login.toUpperCase());
		q.defineParametro("stAtivo", (byte)1);
		q.setMaxResults(1);
		OmUsr usuario = (OmUsr) q.uniqueResult();
		
		if(usuario != null) {
			if(usuario.getSenha() == null) {
				usuario.setSenha("");
			}
			
			try {
				if(HashMD5.isSenhaValida(usuario.getSenha(), HashMD5.getHashCode(senha))) {
					return usuario;
				}
			} catch (DigestFileException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	public UsuarioDTO isUsuarioAutenticado(UsuarioDTO usuario) throws SemComunicacaoException{

		IdwLogger log = new IdwLogger("UsuarioAutenticacao");
		
		UsuarioDTO usuarioRetorno = new UsuarioDTO();

		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select distinct t ");
		q.append("from OmUsr t ");
		q.append("join fetch t.omUsrgrp omusrgrp ");
		q.append("left join fetch omusrgrp.omGrntses omgrntses ");
		q.append("left join fetch omgrntses.omResgui omresgui ");
		q.append("left join fetch t.omGt omgt ");
		q.append("where upper(login)=:login AND t.stAtivo = 1 ");

		q.defineParametro("login", usuario.getUsuario().getLogin().toUpperCase());
		q.setMaxResults(1);

		log.iniciaAvaliacao("pesquisar omusr");
		OmUsr omUsr = (OmUsr) q.uniqueResult();
		log.mostrarAvaliacaoCompleta();
		

		if (omUsr == null){
			log.info("usuario revisao desconhecida");
			usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
			usuarioRetorno.setUsuario(usuario.getUsuario());
			return usuarioRetorno;
		}

		try {
			// Se a senha for null, considerar como ""
			if (omUsr.getSenha() == null) {
				omUsr.setSenha("");
			}

			if (HashMD5.isSenhaValida(omUsr.getSenha(), usuario.getUsuario().getSenha()) == false){
				log.info("login invalido");
				usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_LOGIN_INVALIDO());
				usuarioRetorno.setUsuario(usuario.getUsuario());
				return usuarioRetorno;
			}
		} catch (Exception e1) {
			log.info("erro sem comunicacao: ", e1);
			e1.printStackTrace();
			throw new SemComunicacaoException();
		}

		usuarioRetorno.setResultadoEvento(usuarioRetorno.getEVENTO_BEM_SUCEDIDO());

		log.iniciaAvaliacao("clonando");
		OmUsr omusrClone = omUsr.clone(false);
		log.mostrarAvaliacaoCompleta();
		
		// O omgt abaixo sera usado para a monitorizacao, se estiver null, entao usar o configurado no omcfg
		if (omUsr.getOmGt() == null) {
			OmCfg omcfg = Util.getConfigGeral(getDaoSession());
			if (omcfg.getOmGtimpcic() != null && omcfg.getOmGtimpcic().getOmObjsForIdGt() != null && omcfg.getOmGtimpcic().getOmObjsForIdGt().size() > 0)
				omusrClone.setOmGt(omcfg.getOmGtimpcic().clone(false));
		} else {
			omusrClone.setOmGt(omUsr.getOmGt().clone(false));
		}
		
		// O grupo do usuario e os direitos de acesso tb devem ser clonados
		if (omUsr.getOmUsrgrp() != null) {
			omusrClone.setOmUsrgrp(omUsr.getOmUsrgrp().clone()); // eh necessario o clone true para os direitos de acesso irem para o cliente
		}
		
		usuarioRetorno.setUsuario(omusrClone);
		usuarioRetorno.setVersaoServidor(Util.getVersao());

		log.info("retornando = " + usuarioRetorno.getResultadoEvento());
		return usuarioRetorno;
	}
	
	/**
	 * 
	 * @return
	 * @throws SemComunicacaoException
	 */
	public UsuariosDTO getUsuariosSMED() throws SemComunicacaoException {
		
		IdwLogger log = new IdwLogger("getUsuariosOmUsr");

		UsuariosDTO listaRetorno =  new UsuariosDTO();
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("SELECT omusr ");
		q.append("FROM OmUsr omusr ");
		q.append("WHERE omusr.stAtivo = 1");
		
		log.iniciaAvaliacao("pesquisar omusr");
		
		List<OmUsr> listaOmUsr = q.list();
		log.paraAvaliacao();
		
		 
		if (listaOmUsr == null) {
			listaRetorno.setResultadoEvento(listaRetorno.getERRO_NAO_HA_USUARIOS());
			listaRetorno.setUsuarios(new ArrayList<UsuarioDTO>());
		}
		
		listaRetorno.setResultadoEvento(listaRetorno.getEVENTO_BEM_SUCEDIDO());
		
		List<UsuarioDTO> listaUsuariosDTO = new ArrayList<UsuarioDTO>();		
		
		for (OmUsr item : listaOmUsr) {
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setResultadoEvento(usuarioDTO.getEVENTO_BEM_SUCEDIDO());
			
			log.iniciaAvaliacao("clonando");
			OmUsr omusrClone = item.clone(false);
			log.paraAvaliacao();
			
			
			// O omgt abaixo sera usado para a monitorizacao, se estiver null, entao usar o configurado no omcfg
			if (item.getOmGt() == null) {
				OmCfg omcfg = Util.getConfigGeral(getDaoSession());
				if (omcfg.getOmGtimpcic() != null && omcfg.getOmGtimpcic().getOmObjsForIdGt() != null && omcfg.getOmGtimpcic().getOmObjsForIdGt().size() > 0)
					omusrClone.setOmGt(omcfg.getOmGtimpcic().clone(false));
			} else {
				omusrClone.setOmGt(item.getOmGt().clone(false));
			}
			
			// O grupo do usuario e os direitos de acesso tb devem ser clonados
			if (item.getOmUsrgrp() != null) {
				omusrClone.setOmUsrgrp(item.getOmUsrgrp().clone(false));
			}
			
			usuarioDTO.setUsuario(omusrClone);
			listaUsuariosDTO.add(usuarioDTO);
		}
		
		listaRetorno.setUsuarios(listaUsuariosDTO);
		
		listaUsuariosDTO = null;
		listaOmUsr = null;
		
		return listaRetorno;
	}

	public UsuarioDTO getUsuarioDTO(UsuarioDTO usuario) throws SemComunicacaoException{

		String hql = "";
		UsuarioDTO usuarioRetorno = new UsuarioDTO();

		hql += "select t ";
		hql += "from OmUsr t ";
		hql += "join fetch t.omUsrgrp omusrgrp ";
		hql += "left join fetch omusrgrp.omGrntses omgrntses ";
		hql += "left join fetch omgrntses.omResgui omresgui ";
		hql += "where login='::login' AND t.stAtivo = 1 ";

		hql = hql.replaceAll("::login", String.valueOf(usuario.getUsuario().getLogin()));

		Query q = this.getDaoSession().createQuery(hql);

		OmUsr omUsr = (OmUsr) q.uniqueResult();

		if (omUsr == null){
			usuarioRetorno.setResultadoEvento(usuarioRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
			usuarioRetorno.setUsuario(usuario.getUsuario());
			return usuarioRetorno;
		}

		usuarioRetorno.setResultadoEvento(usuarioRetorno.getEVENTO_BEM_SUCEDIDO());
		usuarioRetorno.setUsuario(omUsr.clone());

		return usuarioRetorno;
	}

	public UsuarioCODTO getUsuarioCODTO(String matricula){
		UsuarioCODTO usuario = new UsuarioCODTO();

		String hql="";
		hql += "select t ";
		hql += "from OmUsr t ";
		hql += "where t.cdUsr='::matricula:' AND t.stAtivo = 1 ";

		hql = hql.replaceAll("::matricula:", matricula);

		Query q = this.getDaoSession().createQuery(hql);

		OmUsr omUsr = (OmUsr) q.uniqueResult();

		if (omUsr != null){
			usuario = new UsuarioCODTO();

			usuario.setApelido(omUsr.getDsApelido());
			usuario.setIdUsuario(omUsr.getIdUsr());
			usuario.setIsAutorizado(true);
			usuario.setDthrServidor(DataHoraRN.getDataHoraAtualFormatada());
			usuario.setMatricula(omUsr.getLogin());
		}

		return usuario;
	}


	public UsuarioCODTO isUsuarioAutorizadoLiberarCF(String matricula){
		UsuarioCODTO usuario = new UsuarioCODTO();

		MapQuery q = new MapQuery(this.getDaoSession());
		
		q.append("select t ");
		q.append("from OmUsr t ");
		q.append("join fetch t.omUsrgrp omusrgrp");
		q.append("join fetch omusrgrp.omGrntses omgrntses");
		q.append("where t.cdUsr = :matricula AND t.stAtivo = 1 ");

		q.defineParametro("matricula", matricula);
		q.setMaxResults(1);

		OmUsr omUsr = (OmUsr) q.uniqueResult();

		if (omUsr != null  && omUsr.getOmUsrgrp() != null && omUsr.getOmUsrgrp().getOmGrntses() != null){
			// Verre os direitos de acesso para verificar se existe o direito 42 - Autoriza fim alimentacao
			boolean isAutorizado = false;
			for (OmGrnts grt : omUsr.getOmUsrgrp().getOmGrntses()){
				if (grt.getOmResgui().getIdResgui() == 42l && grt.getTpAcesso() == (byte) 0) {
					isAutorizado = true;
					break;
				}
			}
			if (isAutorizado == true) {
				usuario = new UsuarioCODTO();
	
				usuario.setApelido(omUsr.getDsApelido());
				usuario.setIdUsuario(omUsr.getIdUsr());
				usuario.setIsAutorizado(true);
				usuario.setDthrServidor(DataHoraRN.getDataHoraAtualFormatada());
				usuario.setMatricula(omUsr.getLogin());
			}
		} else {
			usuario.setIsAutorizado(false);
		}

		return usuario;
	}

	public boolean isRecursoAcessivel(int idAcesso, long idUsr){
		boolean retorno = true;

		String hql="";
		hql += "select t ";
		hql += "from OmUsr t ";
		hql += "join fetch t.omUsrgrp omusrgrp ";
		hql += "left join fetch omusrgrp.omGrntses omgrntses ";
		hql += "left join fetch omgrntses.omResgui omresgui ";
		hql += "where t.idUsr=::idusr AND t.stAtivo = 1 ";

		hql = hql.replaceAll("::idusr", String.valueOf(idUsr));

		Query q = this.getDaoSession().createQuery(hql);

		OmUsr omUsr = (OmUsr) q.uniqueResult();

		if (omUsr.getOmUsrgrp().getOmGrntses() != null){
			for (OmGrnts omgrnts : omUsr.getOmUsrgrp().getOmGrntses()){
				if ((omgrnts.getOmResgui().getIdResgui() == idAcesso) &&
						(omgrnts.getTpAcesso() == (byte) 1)) {
					retorno = false;
				}
			}
		}
		return retorno;
	}

	public HomologacoesDTO validarHomologacoesUsrPt(HomologacoesDTO homologacoes){
		String hql;
		HomologacoesDTO homologacoesDTO = new HomologacoesDTO();
		homologacoesDTO.setResultadoEvento(homologacoesDTO.getEVENTO_BEM_SUCEDIDO());
		homologacoesDTO.setHomologacoesPt(new ArrayList<HomologacaoDTO>());
		homologacoesDTO.setHomologacoesGt(new ArrayList<HomologacaoDTO>());

		for (HomologacaoDTO homologacaoDTO : homologacoes.getHomologacoesPt()) {
			homologacoesDTO.getHomologacoesPt().add(homologacaoDTO);
		}

		if (homologacoes.getHomologacoesGt() != null){
			for (HomologacaoDTO homologacaoDTO : homologacoes.getHomologacoesGt()) {
				homologacoesDTO.getHomologacoesGt().add(homologacaoDTO);
			}
			homologacoesDTO.setResultadoEvento(homologacoesDTO.getERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR());
			return homologacoesDTO;
		}

		for (HomologacaoDTO homologacaoDTO : homologacoesDTO.getHomologacoesPt()) {
			//Verifica se o usuário homologado existe
			try {
				hql = "from OmUsr t where t.idUsr = ::idUsr and t.stAtivo = 1";
				hql = hql.replaceAll("::idUsr", String.valueOf(homologacaoDTO.getHomologacaoPt().getOmUsrByIdUsrhomologado().getIdUsr()));

				Query q = this.getDaoSession().createQuery(hql);

				q.list().get(0);

			} catch (Exception e) {
				homologacoesDTO.setResultadoEvento(homologacoesDTO.getERRO_USUARIO_DESCONHECIDO());
				break;
			}
			//Verifica se o usuário homologador existe
			try {
				hql = "from OmUsr t where t.idUsr = ::idUsr and t.stAtivo = 1";
				hql = hql.replaceAll("::idUsr", String.valueOf(homologacaoDTO.getHomologacaoPt().getOmUsrByIdUsr().getIdUsr()));

				Query q = this.getDaoSession().createQuery(hql);

				q.list().get(0);

			} catch (Exception e) {
				homologacoesDTO.setResultadoEvento(homologacoesDTO.getERRO_USUARIO_DESCONHECIDO());
				break;
			}
			//Verifica se o posto de trabalho existe
			try {
				hql = "from OmPt t where t.idPt = ::idPt and t.stAtivo = 1";
				hql = hql.replaceAll("::idPt", String.valueOf(homologacaoDTO.getHomologacaoPt().getOmPt().getIdPt()));

				Query q = this.getDaoSession().createQuery(hql);

				q.list().get(0);

			} catch (Exception e) {
				homologacoesDTO.setResultadoEvento(homologacoesDTO.getERRO_PT_DESCONHECIDO());
				break;
			}
			//Verifica se o tipo da homologa��oo é valida
			if ((homologacaoDTO.getHomologacaoPt().getTpHomopt() < 0) || (homologacaoDTO.getHomologacaoPt().getTpHomopt() > 2)){
				homologacoesDTO.setResultadoEvento(homologacoesDTO.getERRO_TIPOHOMOLOGACAO_INVALIDA());
				break;
			}
		}

		return homologacoesDTO;

	}

	public HomologacoesDTO validarHomologacoesUsrGt(HomologacoesDTO homologacoes){
		String hql;
		HomologacoesDTO homologacoesDTO = new HomologacoesDTO();
		homologacoesDTO.setResultadoEvento(homologacoesDTO.getEVENTO_BEM_SUCEDIDO());
		homologacoesDTO.setHomologacoesPt(new ArrayList<HomologacaoDTO>());
		homologacoesDTO.setHomologacoesGt(new ArrayList<HomologacaoDTO>());

		for (HomologacaoDTO homologacaoDTO : homologacoes.getHomologacoesGt()) {
			homologacoesDTO.getHomologacoesGt().add(homologacaoDTO);
		}

		if (homologacoes.getHomologacoesPt() != null){
			for (HomologacaoDTO homologacaoDTO : homologacoes.getHomologacoesPt()) {
				homologacoesDTO.getHomologacoesPt().add(homologacaoDTO);
			}
			homologacoesDTO.setResultadoEvento(homologacoesDTO.getERRO_USUARIO_JA_HOMOLOGADO_OPERADOR());
			return homologacoesDTO;
		}

		for (HomologacaoDTO homologacaoDTO : homologacoesDTO.getHomologacoesGt()) {
			//Verifica se o usuário homologado existe
			try {
				hql = "from OmUsr t where t.idUsr = ::idUsr and t.stAtivo = 1";
				hql = hql.replaceAll("::idUsr", String.valueOf(homologacaoDTO.getHomologacaoGt().getOmUsrByIdUsrhomologado().getIdUsr()));

				Query q = this.getDaoSession().createQuery(hql);

				q.list().get(0);

			} catch (Exception e) {
				homologacoesDTO.setResultadoEvento(homologacoesDTO.getERRO_USUARIO_DESCONHECIDO());
				break;
			}
			//Verifica se o usuário homologador existe
			try {
				hql = "from OmUsr t where t.idUsr = ::idUsr and t.stAtivo = 1";
				hql = hql.replaceAll("::idUsr", String.valueOf(homologacaoDTO.getHomologacaoGt().getOmUsrByIdUsr().getIdUsr()));

				Query q = this.getDaoSession().createQuery(hql);

				q.list().get(0);

			} catch (Exception e) {
				homologacoesDTO.setResultadoEvento(homologacoesDTO.getERRO_USUARIO_DESCONHECIDO());
				break;
			}
			//Verifica se o grupo de trabalho existe
			try {
				hql = "from OmGt t where t.idGt = ::idGt and t.stAtivo = 1";
				hql = hql.replaceAll("::idGt", String.valueOf(homologacaoDTO.getHomologacaoGt().getOmGt().getIdGt()));

				Query q = this.getDaoSession().createQuery(hql);

				q.list().get(0);

			} catch (Exception e) {
				homologacoesDTO.setResultadoEvento(homologacoesDTO.getERRO_GT_DESCONHECIDO());
				break;
			}
			//Verifica se o tipo da homologa��oo é valida
			if ((homologacaoDTO.getHomologacaoGt().getTpHomogt() < 0) || (homologacaoDTO.getHomologacaoGt().getTpHomogt() > 2)){
				homologacoesDTO.setResultadoEvento(homologacoesDTO.getERRO_TIPOHOMOLOGACAO_INVALIDA());
				break;
			}
		}

		return homologacoesDTO;

	}

	public List<OmUsr> getTodosOmUsrAtivos() {
		MapQuery q = new MapQuery(this.getDaoSession());

		q.append("SELECT omusr ");
		q.append("FROM OmUsr omusr ");
		q.append("WHERE omusr.stAtivo = 1");

		return q.list();
	}
	
	public List<OmUsr> getTodosOmUsrAtivosComDireitoOperador() {
		MapQuery q = new MapQuery(this.getDaoSession());

		q.append("SELECT omusr ");
		q.append("FROM OmUsr omusr ");
		q.append("left join omusr.omUsrgrp omusrgrp");
		q.append("left join omusrgrp.omGrntses omgrnts");
		q.append("WHERE omusr.stAtivo = 1");
		q.append("and (omgrnts is null or ");
		q.append("(omgrnts.omResgui.idResgui in (58, 59) and omgrnts.tpAcesso <> 1) )");

		return q.list();
	}

	
	public OmUsr getUsuarioByCdEStAtivo(String cdUsr) {
		MapQuery q = new MapQuery(this.getDaoSession());

		// select * from om_usr where cd_usr = cb and st_ativo = 1

		q.append("SELECT omusr ");
		q.append("FROM OmUsr omusr ");
		q.append("WHERE omusr.cdUsr = :cdUsr AND ");
		q.append("omusr.stAtivo = 1");

		q.defineParametro("cdUsr", cdUsr);
		q.query().setMaxResults(1);

		OmUsr oOmUsr = null;
		oOmUsr = (OmUsr) q.query().uniqueResult();

		q = null;

		return(oOmUsr);
	}
	public OmUsr getUsuarioByLoginEStAtivo(String login) {
		MapQuery q = new MapQuery(this.getDaoSession());

		// select * from om_usr where cd_usr = cb and st_ativo = 1

		q.append("SELECT omusr ");
		q.append("FROM OmUsr omusr ");
		q.append("WHERE omusr.login = :login AND ");
		q.append("omusr.stAtivo = 1");
		q.append("order by omusr.idUsr desc");

		q.defineParametro("login", login);
		q.query().setMaxResults(1);

		OmUsr oOmUsr = null;
		oOmUsr = (OmUsr) q.query().uniqueResult();

		q = null;

		return(oOmUsr);
	}

	/**
	 * Desativa todos os registros da tabela de usrs
	 * @param dataHoraDesativacao
	 * @param omUsr Usuário que desativou a usr
	 */
	public void desativarUsrs(Date dataHoraDesativacao, OmUsr omUsr){
		this.getDao().desativarMuitos(OmUsr.class, OmUsrTemplate._FIELD_NAME_CD, null, false, dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa registros da tabela de usrs
	 * @param listaCdUsrDevemFicarAtivos Lista de códigos de devem ficar permanecer ativos
	 * @param dataHoraDesativacao
	 * @param omUsr Usuário que desativou a usr
	 */
	public void desativarUsrs(List<String> listaCdUsrDevemFicarAtivos, Date dataHoraDesativacao, OmUsr omUsr){
		listaCdUsrDevemFicarAtivos.add(OmUsrTemplate._CD_USR_MAP);
		
		// Alessandre: em 8-9-14 comentei a linha abaixo pois qdo existem muitos usuarios a serem mantidos (acima de 2100) o HQL da erro e n�o executa. Entao acrescentei um if
		// e um codigo extra para qdo a quantidade for superior a 2100.
		//this.getDao().desativarMuitos(OmUsr.class, OmUsrTemplate._FIELD_NAME_CD, listaCdUsrDevemFicarAtivos, true, dataHoraDesativacao, omUsr);
		if (listaCdUsrDevemFicarAtivos.size() <= 2100) {
			this.getDao().desativarMuitos(OmUsr.class, OmUsrTemplate._FIELD_NAME_CD, listaCdUsrDevemFicarAtivos, true, dataHoraDesativacao, omUsr);
		} else {
			// Entra em loop para exclusao individual dos usuarios
			List<OmUsr> lista = getTodosOmUsrAtivos();
			for (OmUsr omusr : lista) {
				if (listaCdUsrDevemFicarAtivos.contains(omusr.getCdUsr()) == false) {
					omusr.setStAtivo((byte) 0);
					getDao().makePersistent(omusr);
				}
			}
		}
	}

	/**
	 * Desativa relacionado ao código e tipo do posto de trabalho
	 * @param cdUsr
	 * @param date
	 * @param omUsr usuário que está desativando
	 * @throws RegistroJaDesativadoException
	 * @throws RegistroDesconhecidoException
	 */
	public void desativarUsr(String cdUsr, Date date, OmUsr omUsr) throws RegistroDesconhecidoException, RegistroJaDesativadoException{
		this.getDao().desativar(OmUsr.class,cdUsr, OmUsrTemplate._FIELD_NAME_CD, null, date, omUsr);
	}

	/**
	 * Desativa {@code OmUsr} relacionado ao id da usr
	 * @param idUsr
	 * @param dataHoraAtual
	 * @throws RegistroJaDesativadoException
	 */
	public void desativarUsr(long idUsr,  Date date, OmUsr omUsr) throws RegistroJaDesativadoException{
		this.getDao().desativar(OmUsr.class, idUsr, date, omUsr);
	}

	/**
	 * Pega {@code OmUsr} relacionado com o código da usr e que esteja ativo
	 * @param cdUsr
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public OmUsr getOmUsr(String cdUsr) throws RegistroDesconhecidoException{
		return this.getDao().findByCd(OmUsr.class, cdUsr, OmUsrTemplate._FIELD_NAME_CD, null, true);
	}
	
	public OmUsr getOmUsrByLoginStAtivo(String login) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select omusr from OmUsr omusr where omusr.login = :login and omusr.stAtivo = 1");
		q.defineParametro("login", login);
		q.setMaxResults(1);
		return (OmUsr) q.uniqueResult();
	}

	/**
	 * Pega {@code OmUsr} relacionado com o id
	 * @param idUsr
	 * @return
	 */
	public OmUsr getOmUsr(long idUsr){
		return this.getDao().findById(OmUsr.class, idUsr, false);
	}


	
//	 public int compare(Object o1, Object o2) {  
//  OmUsr p1 = (OmUsr) o1;  
//  OmUsr p2 = (OmUsr) o2;  
//  return p1.inicio < p2.inicio ? -1 : (p1.inicio > p2.inicio ? +1 : 0);  
//} 
	
	// O nome esta getOMUsuariosDTO porque ja existe um metodo com o nome getUsuariosDTO
	//para que nao fosse iguais o nome fico getOMUsuariosDTO
	public UsuariosDTO getOMUsuariosDTO(FiltroRelatorioUsuarioDTO filtro){
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "UsuarioRN.getOMUsuariosDTO");
		log.info( idLog , 0, "UsuarioRN.getOMUsuariosDTO filtro usado:" + filtro.toString());
		
		List<OmUsr> listaOmUsr = new ArrayList<OmUsr>();
		List<UsuarioDTO> listaUsuarioRetorno = new ArrayList<UsuarioDTO>();
		
		MapQuery query = new MapQuery(getDao().getSession());

		query.append("SELECT omusr");
		query.append("FROM OmUsr omusr");
			
		query.appendWhere(MapQuery._NULL, "omusr.omUsrgrp.cdUsrgrp = :cdgrupo ", filtro.getCdGrupo() != null && filtro.getCdGrupo().equals("") == false);
		query.appendWhere(MapQuery._AND, "omusr.stAtivo=:stAtivo", (filtro.getSituacao() != null  && filtro.getSituacao() <(byte)2));
		
		if(filtro.isOrdenarUsuario() == true){
			 query.append("ORDER BY omusr.cdUsr");
	    }else{
		  if(filtro.isOrdenarUsuario() == false){
			  query.append("ORDER BY omusr.dsNome");  
		  }
		}
		
		
		if (filtro.getSituacao() != null){
			 query.defineParametro("stAtivo", filtro.getSituacao());
		}
		query.defineParametro("cdgrupo", filtro.getCdGrupo());
		
		listaOmUsr = query.list();
		
		if(listaOmUsr != null){
			for(OmUsr omUsr :listaOmUsr){
			 UsuarioDTO usuarioDTO = new UsuarioDTO();
			 usuarioDTO.setUsuario(omUsr.clone(true));
			 listaUsuarioRetorno.add(usuarioDTO);
			}		
		}
		UsuariosDTO usuariosDTO = new UsuariosDTO();
		usuariosDTO.setUsuarios(listaUsuarioRetorno);
		
		log.mostrarAvaliacaoCompleta();
		
		return usuariosDTO;
	}
	
	public UsuariosDTO getOperadoresAtivos() {
		OmUsrDAO dao = new OmUsrDAO(getDaoSession());
		List<OmUsr> lista = dao.getOperadoresAtivos();
		UsuariosDTO retorno = new UsuariosDTO();
		retorno.setUsuarios(new ArrayList<UsuarioDTO>());
		for(OmUsr usuario : lista) {
			UsuarioDTO dto = new UsuarioDTO();
			dto.setUsuario(usuario.clone(false));
			retorno.getUsuarios().add(dto);
		}
		return retorno;
	}
	
	public OmUsr getOmUsrPorLoginSenha(String login, String senha) {
		OmUsrDAO dao = new OmUsrDAO(getDaoSession());
		return dao.getOmUsrPorLoginSenha(login, senha);
	}
	
	public List<OmUsr> getTodosOmUsrAtivosOrdenadoPorNome(String exclusiveEsteLogin) {
		OmUsrDAO dao = new OmUsrDAO(getDaoSession());
		return dao.getTodosOmUsrAtivosOrdenadoPorNome(exclusiveEsteLogin);
	}
	
	@SuppressWarnings("unused")
	public ListaUsuariosDTO getUsuariosDTO(FiltroPesquisaDTO filtro){
		ListaUsuariosDTO retorno = new ListaUsuariosDTO();
		retorno.setItems(new ArrayList<UsrDTO>());
		retorno.setMeta(new MetaDTO(filtro));
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select DISTINCT t");
		q.append("from OmUsr t");
		q.append("join fetch t.omUsrgrp gu");
		q.append("join fetch t.omGt gt");
		q.append("where t.stAtivo = 1");
		
		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){			
			q.append("AND (");
			q.append(" upper(t.cdUsr) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.dsNome) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		}
 
		q.append("order by t.cdUsr");
		
		List<OmUsr> lista = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());

		for (OmUsr reg : lista) {
			UsrDTO regDTO = new UsrDTO();
			regDTO.setIdUsr(reg.getIdUsr());
			regDTO.setCdUsr(reg.getCdUsr());
			regDTO.setDsUsr(reg.getDsNome());
			regDTO.setLogin(reg.getLogin());
			regDTO.setSenha("");
			
			
			if (reg.getUrlEmail() != null) {
				regDTO.setEmail(reg.getUrlEmail());
			} else {
				regDTO.setEmail("");
			}
			
 			if (reg.getOmGt() != null) {
 				regDTO.setCdGt(reg.getOmGt().getCdGt());
 				regDTO.setDsGt(reg.getOmGt().getDsGt());
 			} else {
 				regDTO.setCdGt("");
 				regDTO.setDsGt(""); 				 				
 			}
 			
 			if (reg.getOmCargo() != null) {
 				regDTO.setCdCargo(reg.getOmCargo().getCdCargo());
 			} else {
 				regDTO.setCdCargo(""); 		 				
 			}
 			
			regDTO.setCdUsrGrp(reg.getOmUsrgrp().getCdUsrgrp());
			regDTO.setDsUsrGrp(reg.getOmUsrgrp().getDsUsrGrp());
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
	
	@SuppressWarnings("unused")
	public UsrDTO getUsrByCd(String cdUsr){
		UsrDTO retorno = new UsrDTO();
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select DISTINCT t");
		q.append("from OmUsr t");
		//q.append("join fetch t.omUsrgrp gu");
		//q.append("join fetch t.omGt gt");
		q.append("where t.stAtivo = 1");
		
		q.append("AND t.cdUsr = :cdUsr");
 		q.append("ORDER BY t.cdUsr");
 		q.defineParametro("cdUsr", cdUsr);
 		

 		List<OmUsr> lista = q.list();
 		if (lista.size() == 1) {
 			retorno.setIdUsr(lista.get(0).getIdUsr());
 			retorno.setCdUsr(lista.get(0).getCdUsr());
 			retorno.setDsUsr(lista.get(0).getDsNome());
 			
 			retorno.setLogin(lista.get(0).getLogin());
 			retorno.setSenha("");
			
			
			if (lista.get(0).getUrlEmail() != null) {
				retorno.setEmail(lista.get(0).getUrlEmail());
			} else {
				retorno.setEmail("");
			}
			
 			
 			if (lista.get(0).getOmGt() != null) {
 	 			retorno.setCdGt(lista.get(0).getOmGt().getCdGt());
 	 			retorno.setDsGt(lista.get(0).getOmGt().getDsGt()); 				
 			} else {
 	 			retorno.setCdGt("");
 	 			retorno.setDsGt(""); 				 				
 			}
 			
 			if (lista.get(0).getOmCargo() != null) {
 				retorno.setCdCargo(lista.get(0).getOmCargo().getCdCargo());
 			} else {
 				retorno.setCdCargo(""); 		 				
 			}
 			
 			
 			retorno.setCdUsrGrp(lista.get(0).getOmUsrgrp().getCdUsrgrp());
 			retorno.setDsUsrGrp(lista.get(0).getOmUsrgrp().getDsUsrGrp());
 			retorno.setStRegistro(lista.get(0).getStAtivo().intValue()); 			 
 		}
				
		return retorno;
	}
	
	@SuppressWarnings("unused")
	public UsrDTO getUsrByLogin(String login){
		UsrDTO retorno = new UsrDTO();
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select t");
		q.append("from OmUsr t");
		//q.append("join fetch t.omUsrgrp gu");
		//q.append("join fetch t.omGt gt");
		q.append("where t.stAtivo = 1");
		
		q.append("AND t.login = :login");
 		q.append("ORDER BY t.cdUsr");
 		q.defineParametro("login", login);
 		

 		List<OmUsr> lista = q.list();
 		if (lista.size() == 1) {
 			retorno.setIdUsr(lista.get(0).getIdUsr());
 			retorno.setCdUsr(lista.get(0).getCdUsr());
 			retorno.setDsUsr(lista.get(0).getDsNome());
 			
 			if (lista.get(0).getOmGt() != null) {
 	 			retorno.setCdGt(lista.get(0).getOmGt().getCdGt());
 	 			retorno.setDsGt(lista.get(0).getOmGt().getDsGt()); 				
 			} else {
 	 			retorno.setCdGt("");
 	 			retorno.setDsGt(""); 				 				
 			}
 			
 			retorno.setCdUsrGrp(lista.get(0).getOmUsrgrp().getCdUsrgrp());
 			retorno.setDsUsrGrp(lista.get(0).getOmUsrgrp().getDsUsrGrp());
 			retorno.setStRegistro(lista.get(0).getStAtivo().intValue()); 			 
 		}
				
		return retorno;
	}
	
}