package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmCcDAO;
import idw.model.dao.OmGtDAO;
import idw.model.dao.OmImgDAO;
import idw.model.dao.OmTpgtDAO;
import idw.model.dao.OmUsrDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemSessaoHibernateException;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwFolha;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmHomogt;
import idw.model.pojos.OmImg;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTexto;
import idw.model.pojos.OmTpgt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.OmObjTemplate;
import idw.model.rn.estoque.EstoqueRN;
import idw.model.rn.monitorizacao.MonitorizacaoRN;
import idw.util.Util;
import idw.webservices.dto.CamposEmUsoOmCfgDTO;
import idw.webservices.dto.GTsDTO;
import idw.webservices.dto.GrupoTrabalhoDTO;
import idw.webservices.dto.GruposTrabalhoDTO;
import idw.webservices.dto.GtDTO;
import idw.webservices.dto.HomologacaoDTO;
import idw.webservices.dto.HomologacoesDTO;
import idw.webservices.dto.PTsDTO;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasDTO;
import idw.webservices.dto.PtDTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.GtDTO2;
import idw.webservices.rest.idw.v2.dto.GtLayoutDTO;
import idw.webservices.rest.idw.v2.dto.ListaGTsDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;
import idw.webservices.rest.idw.v2.dto.PtMonitDTO.TipoPostoNIDW;
import idw.model.rn.web.vf.monitorizacao.MonitorizacaoWebRN;

public class GTRN extends DAOGenerico {

	public GTsDTO getGTsDTO(GtDTO filtro) {
		OmGtDAO gtDAO = new OmGtDAO(getSession());
		List<OmGt> listaOmGt = gtDAO.getOmGts(filtro);
		List<GtDTO> lista = new ArrayList<GtDTO>();
		for (OmGt omGt : listaOmGt) {
			GtDTO gtDTO = new GtDTO();
			gtDTO.setGt((OmGt) omGt.clone());
			gtDTO.setHomologacoes(new HomologacoesDTO());
			List<HomologacaoDTO> homologacoes = new ArrayList<HomologacaoDTO>();
			for (OmHomogt item : omGt.getOmHomogts()) {
				HomologacaoDTO homologacao = new HomologacaoDTO();
				homologacao.setHomologacaoGt((OmHomogt) item.clone());
				homologacoes.add(homologacao);
			}
			gtDTO.getHomologacoes().setHomologacoesGt(homologacoes);

			gtDTO.getGt().setOmObjsForIdGt(new HashSet<OmObj>());
			if (omGt.getOmObjsForIdGt() != null) {
				for (OmObj itemObj : omGt.getOmObjsForIdGt()) {
					if (itemObj.getDwRotaByIdRota() == null) {
						OmObj passos = null;
						passos = itemObj.clone(true);
						
						if (passos.getOmGtByIdGtfilho() != null && passos.getOmImg() == null)
							continue;

						if (itemObj.getOmObjByIdObjorigem() != null) {
							OmObj omobjOrigem = new OmObj();
							omobjOrigem.setIdObj(itemObj.getOmObjByIdObjorigem().getIdObj());
							if (itemObj.getOmObjByIdObjorigem().getDwFolhaByIdFolha() != null) {
								omobjOrigem.setDwFolhaByIdFolha(
										itemObj.getOmObjByIdObjorigem().getDwFolhaByIdFolha().clone(false));
							}
							if (itemObj.getOmObjByIdObjorigem().getDwEstByIdEst() != null) {
								omobjOrigem.setDwEstByIdEst(
										itemObj.getOmObjByIdObjorigem().getDwEstByIdEst().clone(false));
							}
							if (itemObj.getOmObjByIdObjorigem().getOmImg() != null) {
								omobjOrigem.setOmImg(itemObj.getOmObjByIdObjorigem().getOmImg().clone(false));
							}

							passos.setOmObjByIdObjorigem(omobjOrigem);
						}
						if (itemObj.getOmObjByIdObjdestino() != null) {
							OmObj omobjDestino = new OmObj();
							omobjDestino.setIdObj(itemObj.getOmObjByIdObjdestino().getIdObj());
							if (itemObj.getOmObjByIdObjdestino().getDwFolhaByIdFolha() != null) {
								omobjDestino.setDwFolhaByIdFolha(
										itemObj.getOmObjByIdObjdestino().getDwFolhaByIdFolha().clone(false));
							}
							if (itemObj.getOmObjByIdObjdestino().getDwEstByIdEst() != null) {
								omobjDestino.setDwEstByIdEst(
										itemObj.getOmObjByIdObjdestino().getDwEstByIdEst().clone(false));
							}
							if (itemObj.getOmObjByIdObjdestino().getOmImg() != null) {
								omobjDestino.setOmImg(itemObj.getOmObjByIdObjdestino().getOmImg().clone(false));
							}

							passos.setOmObjByIdObjdestino(omobjDestino);
						}
						if (itemObj.getOmTexto() != null) {
							passos.setOmTexto(itemObj.getOmTexto().clone());
						}

						gtDTO.getGt().getOmObjsForIdGt().add(passos);
					}
				}
			}
			gtDTO.setResultadoEvento(0);
			lista.add(gtDTO);
		}

		GTsDTO gts = new GTsDTO();
		gts.setGts(lista);
		return gts;
	}

	public GTsDTO getGTsComLayoutDTO(GtDTO filtro) {
		OmGtDAO gtDAO = new OmGtDAO(getSession());
		List<OmGt> listaOmGt = gtDAO.getGtsComLayout();
		List<GtDTO> lista = new ArrayList<GtDTO>();
		for (OmGt omGt : listaOmGt) {
			GtDTO gt = new GtDTO();
			gt.setGt((OmGt) omGt.clone());
			gt.setHomologacoes(null);
			gt.setResultadoEvento(0);
			lista.add(gt);
		}
		GTsDTO gts = new GTsDTO();
		gts.setGts(lista);
		return gts;
	}

	/* METODO PARA SALVAR O GT JUNTAMENTE COM O LAYOUT */
	@SuppressWarnings("finally")
	public GtDTO setGTDTO(GtDTO gt) {
		PTRN prn = new PTRN(getDao());
		EstoqueRN ern = new EstoqueRN(getDao());
		DiversosRN drn = new DiversosRN();
		drn.setDao(getDao());

		GtDTO gtRetorno = new GtDTO();

		// SE FALHA A DESDE DESTE PONTO SER CONSIDERADO ERRO_DESCONHECIDO
		gtRetorno.setResultadoEvento(gtRetorno.getERRO_DESCONHECIDO());

		try {
			if (gt.getGt().getCdGt().trim().equals("")) {
				gtRetorno.setResultadoEvento(gtRetorno.getERRO_CDGT_INVALIDO());
				return gtRetorno;
			}

			OmGtDAO gtDAO = new OmGtDAO(getSession());

			OmGt omGtOriginal = null;
			if (gt.getGt().getIdGt() != null) {
				omGtOriginal = gtDAO.getOmGtPorId(gt.getGt().getIdGt());

			}

			OmGt omGtAlteracao = null;
			boolean isInclusao = false;

			if (omGtOriginal == null) {
				omGtOriginal = (OmGt) gt.getGt().clone();
				omGtOriginal.setIdGt(null);
				omGtOriginal.setRevisao(1l);
				omGtOriginal.setDtRevisao(new Date());
				omGtOriginal.setStAtivo((byte) 1);
				omGtOriginal.setDtStativo(new Date());
				isInclusao = true;

				// VERIFICA SE J EXISTE UM GT ATIVO COM O CD QUE SE DESEJA
				// CADASTRAR
				OmGt gtAux = gtDAO.getOmGtPorCdAtivo(omGtOriginal.getCdGt());
				if (gtAux != null) {
					gtRetorno.setResultadoEvento(gtRetorno.getERRO_GT_JA_EXISTE());
					return gtRetorno;
				}
			} else {
				omGtAlteracao = new OmGt();
				omGtAlteracao.copy(omGtOriginal, true);
				omGtAlteracao.setIdGt(null);
				omGtAlteracao.setStAtivo((byte) 0);
				omGtAlteracao.setOmHomogts(null);
				omGtAlteracao.setOmObjsForIdGt(null);
				omGtOriginal.copy(gt.getGt(), false);
				omGtOriginal.setDtRevisao(new Date());
			}

			// Exclus�o dos supervisores homologados, indenpendente se eh
			// inclusao ou alteracao
			if (omGtOriginal.getOmHomogts() != null && gt.getHomologacoes() != null
					&& gt.getHomologacoes().getHomologacoesGt() != null) {
				for (Iterator<OmHomogt> iterator = omGtOriginal.getOmHomogts().iterator(); iterator.hasNext();) {
					OmHomogt item = (OmHomogt) iterator.next();
					getSession().delete(item);
				}
			}

			String hql = "";
			OmUsrDAO usrDAO = new OmUsrDAO(getSession());

			// Somente apos pesquisar se a nova revisao ja existe é que o pojo
			// original deve ter a revisao somada, se for antes,
			// a pesquisa acima ira trazer o pojo somado
			if (isInclusao == false) {

				omGtOriginal.setRevisao(omGtOriginal.getRevisao() + 1);

				// inclus�o
				if (gt.getHomologacoes() != null && gt.getHomologacoes().getHomologacoesGt() != null) {
					omGtOriginal.setOmHomogts(new HashSet<OmHomogt>());
					for (HomologacaoDTO item : gt.getHomologacoes().getHomologacoesGt()) {

						// se falha a desde deste ponto será considerado
						// ERRO_CC_DESCONHECIDO
						gtRetorno.setResultadoEvento(gtRetorno.getERRO_DESCONHECIDO());

						// inclus�o
						OmHomogt omHomogt = new OmHomogt();
						omHomogt.copy(item.getHomologacaoGt(), false);
						omHomogt.setIdHomogt(0);
						omHomogt.setDtHomogt(new Date());

						// omHomogt.setOmUsrByIdUsrhomologado(omUsrOriginal);

						// Verifica se o usuário homologado existe
						OmUsr omUsr = usrDAO
								.getOmUsrPorId(item.getHomologacaoGt().getOmUsrByIdUsrhomologado().getIdUsr());
						omHomogt.setOmUsrByIdUsrhomologado(omUsr);
						if (omUsr == null) {
							gtRetorno.setResultadoEvento(gtRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
							return gtRetorno;
						}

						// Verifica se o usuário homologador existe
						omUsr = usrDAO.getOmUsrPorId(item.getHomologacaoGt().getOmUsrByIdUsr().getIdUsr());
						omHomogt.setOmUsrByIdUsr(omUsr);
						if (omUsr == null) {
							gtRetorno.setResultadoEvento(gtRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
							return gtRetorno;
						}

						// Verifica se o grupo de trabalho existe
						hql = "from OmGt t where t.idGt = ::idGt and t.stAtivo = 1";
						hql = hql.replaceAll("::idGt", String.valueOf(item.getHomologacaoGt().getOmGt().getIdGt()));

						omHomogt.setOmGt(omGtOriginal);
						omGtOriginal.getOmHomogts().add(omHomogt);
					}
				}
			}

			OmImgDAO imgDAO = new OmImgDAO(getSession());
			OmImg omImg = imgDAO.getOmImgPorCdAtivo(gt.getGt().getOmImg().getCdImg());
			if (omImg == null) {
				gtRetorno.setResultadoEvento(gtRetorno.getERRO_IMG_DESCONHECIDO());
				return gtRetorno;
			}
			omGtOriginal.setOmImg(omImg);

			OmTpgtDAO tpgtDAO = new OmTpgtDAO(getSession());
			OmTpgt omTpgt = tpgtDAO.getOmTpgtPorCdAtivoOrderById(gt.getGt().getOmTpgt().getCdTpgt());
			if (omTpgt == null) {
				gtRetorno.setResultadoEvento(gtRetorno.getERRO_TIPOGT_DESCONHECIDO());
				return gtRetorno;
			}
			omGtOriginal.setOmTpgt(omTpgt);

			OmGt omgtfase = null;
			try {
				omgtfase = gtDAO.getOmGtPorIdOuCdAtivos(gt.getGt().getOmGtfase().getIdGt(),
						gt.getGt().getOmGtfase().getCdGt());
			} catch (Exception e) {
				omgtfase = null;
			}

			omGtOriginal.setOmGtfase(omgtfase);

			// se falha a desde deste ponto será considerado
			// ERRO_CC_DESCONHECIDO
			if (gt.getGt().getOmCc() != null && gt.getGt().getOmCc().getCdCc() != null
					&& !gt.getGt().getOmCc().getCdCc().equals("")) {
				gtRetorno.setResultadoEvento(gtRetorno.getERRO_CC_DESCONHECIDO());
				OmCcDAO ccDAO = new OmCcDAO(getSession());
				OmCc omCc = ccDAO.getOmCcPorCdAtivoOrderById(gt.getGt().getOmCc().getCdCc());
				omGtOriginal.setOmCc(omCc);
				if (omCc == null) {
					gtRetorno.setResultadoEvento(gtRetorno.getERRO_CC_DESCONHECIDO());
					return gtRetorno;
				}
			} else {
				omGtOriginal.setOmCc(null);
			}

			OmUsr omUsrRevisao = usrDAO.getOmUsrPorCdAtivo(gt.getGt().getOmUsrByIdUsrrevisao().getCdUsr());
			if (omUsrRevisao == null) {
				gtRetorno.setResultadoEvento(gtRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
				return gtRetorno;
			}
			omGtOriginal.setOmUsrByIdUsrrevisao(omUsrRevisao);

			OmUsr omUsrStAtivo = usrDAO.getOmUsrPorCdAtivo(gt.getGt().getOmUsrByIdUsrstativo().getCdUsr());
			if (omUsrStAtivo == null) {
				gtRetorno.setResultadoEvento(gtRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
				return gtRetorno;
			}
			omGtOriginal.setOmUsrByIdUsrstativo(omUsrStAtivo);

			gtRetorno.setResultadoEvento(gtRetorno.getERRO_DESCONHECIDO());

			if (gt.isConsiderarObjs() == true && gt.getGt().getOmObjsForIdGt() != null) {
				// Remove objs antigos
				MonitorizacaoRN monitorizacaoRN = new MonitorizacaoRN();
				monitorizacaoRN.getDao().setSession(getSession());

				monitorizacaoRN.removeObjs(omGtOriginal);

				// Preparada cole��oo de objetos para atualizar no banco de
				// dados
				omGtOriginal.setOmObjsForIdGt(new HashSet<OmObj>()); // getOmObjsForIdGt().clear();
				Map<Long, OmObj> omobjsSalvos = new HashMap<Long, OmObj>();

				for (OmObj obj : gt.getGt().getOmObjsForIdGt()) {
					obj.setOmGtByIdGt(gt.getGt());
					// Incluir objetos diferentes da seta(linha)
					if (obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_INFO_MANUAL.getValue()) == false
							&& obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_INFO_ELETRO.getValue()) == false
							&& obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_KANBAN.getValue()) == false
							&& obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_EXTERNO_MATERIAL.getValue()) == false
							&& obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_EMPURRADA.getValue()) == false) {

						incluirOmObj(omobjsSalvos, prn, drn, ern, gt.getGt(), gtRetorno, omGtOriginal, obj);

						// se ocorreu algum erro retornar para a GUI
						if (gt.getResultadoEvento() != gt.getEVENTO_BEM_SUCEDIDO()) {
							return gt;
						}
					}
				}

				// Agora salvar as setas considerando os objetos de origem e
				// destino
				for (OmObj obj : gt.getGt().getOmObjsForIdGt()) {
					
					// Incluir apenas as setas
					if (obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_INFO_MANUAL.getValue()) == true
							|| obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_INFO_ELETRO.getValue()) == true
							|| obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_KANBAN.getValue()) == true
							|| obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_EXTERNO_MATERIAL.getValue()) == true
							|| obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_EMPURRADA.getValue()) == true) {

						incluirOmObj(omobjsSalvos, prn, drn, ern, gt.getGt(), gt, omGtOriginal, obj);

						// se ocorreu algum erro retornar para a GUI
						if (gt.getResultadoEvento() != gt.getEVENTO_BEM_SUCEDIDO()) {
							return gt;
						}
					}
				}

			}

			try {
				omGtOriginal = this.getDao().makePersistent(omGtOriginal);
				if (omGtAlteracao != null) {
					makePersistent(omGtAlteracao);
				}
			} catch (Exception e) {
				gt.setResultadoEvento(gt.getERRO_DESCONHECIDO());
				e.printStackTrace();
			}

			gtRetorno.setGt((OmGt) omGtOriginal.clone());

			gtRetorno.setHomologacoes(new HomologacoesDTO());

			List<HomologacaoDTO> homologacoes = new ArrayList<HomologacaoDTO>();
			for (OmHomogt item : omGtOriginal.getOmHomogts()) {
				HomologacaoDTO homologacao = new HomologacaoDTO();
				homologacao.setHomologacaoGt((OmHomogt) item.clone());

				homologacoes.add(homologacao);
			}
			gtRetorno.getHomologacoes().setHomologacoesGt(homologacoes);
			gtRetorno.setResultadoEvento(gtRetorno.getEVENTO_BEM_SUCEDIDO());

		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			return gtRetorno;
		}

	}

	public GTsDTO removeGTsDTO(GTsDTO gts) {
		GTsDTO gtsRetorno = new GTsDTO();
		List<GtDTO> listaRetorno = new ArrayList<GtDTO>();
		
		//17/03/2017 Alex: nao remover codigo em uso na configuracao geral.
		CamposEmUsoOmCfgDTO camposEmUsoOmCfgDTO = getCamposEmUsoOmCfg(gts);
		gtsRetorno.setCamposEmUsoOmCfg(camposEmUsoOmCfgDTO);
		if(camposEmUsoOmCfgDTO.getStatus() != camposEmUsoOmCfgDTO.getSTATUS_NENHUM_CAMPO_EM_USO()) {
			//se entrar nesse if eh pq existe algum codigo em uso
			gtsRetorno.setGts(new ArrayList<GtDTO>());
			return gtsRetorno;
		}				
		
		
		for (GtDTO gt : gts.getGts()) {
			GtDTO gtRetorno = new GtDTO();
			OmGtDAO gtDAO = new OmGtDAO(getSession());
			OmGt omGt = gtDAO.getOmGtPorId(gt.getGt().getIdGt());
			if (omGt == null) {
				gtRetorno.setResultadoEvento(gtRetorno.getERRO_DESCONHECIDO());
				gtRetorno.setGt(gt.getGt());
			} else if (omGt.getStAtivo() == 0) {
				gtRetorno.setResultadoEvento(gtRetorno.getERRO_DESCONHECIDO());
				gtRetorno.setGt((OmGt) omGt.clone());
			} else {
				omGt.setStAtivo((byte) 0);
				omGt.setDtStativo(new Date());
				try {
					OmUsrDAO usrDAO = new OmUsrDAO(getSession());
					OmUsr omUsrStAtivo = usrDAO.getOmUsrPorCdAtivo(gt.getGt().getOmUsrByIdUsrstativo().getCdUsr());
					omGt.setOmUsrByIdUsrstativo(omUsrStAtivo);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					omGt = (OmGt) makePersistent(omGt);
				} catch (Exception e) {
					e.printStackTrace();
				}
				gtRetorno.setGt((OmGt) omGt.clone());
				gtRetorno.setResultadoEvento(gtRetorno.getEVENTO_BEM_SUCEDIDO());
			}
			listaRetorno.add(gtRetorno);
		}
		
		gtsRetorno.setGts(listaRetorno);
		return gtsRetorno;
	}
	
	private CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg(GTsDTO itens) {
		OmCfg omcfg = Util.getConfigGeral(getSession());
		
		//campos
		OmGt gtEmUso = omcfg.getOmGtimpcic();
		
		CamposEmUsoOmCfgDTO camposEmUsoOmCfg = new CamposEmUsoOmCfgDTO();
		boolean isTemCodigoEmUso = false;
		for(GtDTO item: itens.getGts()) {
			camposEmUsoOmCfg.setCodigo(item.getGt().getCdGt());
			
			if(gtEmUso != null) {
				if(item.getGt().getCdGt().equals(gtEmUso.getCdGt())) {
					camposEmUsoOmCfg.setGT(true);
					isTemCodigoEmUso = true;
				}
			}
			
		}
		
		if(isTemCodigoEmUso) {
			
			if(itens.getGts() != null && itens.getGts().size() > 1) {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_EXCLUSAO_ABORTADA());
			} else {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_TEM_CAMPO_EM_USO());
			}
			
		} else {
			camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_NENHUM_CAMPO_EM_USO());
		}
		
		return camposEmUsoOmCfg;
	}

	public GtDTO ativaGTDTO(GtDTO gt) {
		GtDTO gtRetorno = new GtDTO();
		OmGtDAO gtDAO = new OmGtDAO(getSession());

		// VERIFICA SE A REVISAO QUE EST SENDO REATIVADA É A MAIOR PARA O CODIGO
		OmGt gtAux = gtDAO.getOmGtPorCdMaiorRevisao(gt.getGt().getCdGt(), gt.getGt().getRevisao());
		if (gtAux != null) {
			gtRetorno.setResultadoEvento(gtRetorno.getERRO_REATIVACAO_INDISPONIVEL());
			return gtRetorno;
		}

		OmGt omGt = gtDAO.getOmGtPorId(gt.getGt().getIdGt());
		if (omGt == null) {
			gtRetorno.setResultadoEvento(gtRetorno.getERRO_DESCONHECIDO());
			gtRetorno.setGt(gt.getGt());
			return gtRetorno;
		} else if (omGt.getStAtivo() == 1) {
			gtRetorno.setResultadoEvento(gtRetorno.getERRO_DESCONHECIDO());
			gtRetorno.setGt((OmGt) omGt.clone());
		} else {
			omGt.setStAtivo((byte) 1);
			omGt.setDtStativo(new Date());
		}

		try {
			OmUsrDAO usrDAO = new OmUsrDAO(getSession());
			OmUsr omUsrStAtivo = usrDAO.getOmUsrPorCd(gt.getGt().getOmUsrByIdUsrstativo().getCdUsr());
			omGt.setOmUsrByIdUsrstativo(omUsrStAtivo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			omGt = (OmGt) makePersistent(omGt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		gtRetorno.setGt((OmGt) omGt.clone());
		return gtRetorno;
	}

	public HomologacoesDTO validarHomologacoesGt(HomologacoesDTO homologacoes) {
		String hql;
		HomologacoesDTO homologacoesDTO = new HomologacoesDTO();
		homologacoesDTO.setResultadoEvento(homologacoesDTO.getEVENTO_BEM_SUCEDIDO());
		homologacoesDTO.setHomologacoesGt(new ArrayList<HomologacaoDTO>());
		OmUsrDAO usrDAO = new OmUsrDAO(getSession());
		OmGtDAO gtDAO = new OmGtDAO(getSession());

		for (HomologacaoDTO homologacaoDTO : homologacoes.getHomologacoesGt()) {
			homologacoesDTO.getHomologacoesGt().add(homologacaoDTO);
		}

		for (HomologacaoDTO homologacaoDTO : homologacoesDTO.getHomologacoesGt()) {
			// Verifica se o usuário homologado existe
			try {
				OmUsr usrAux = usrDAO
						.getOmUsrPorId(homologacaoDTO.getHomologacaoGt().getOmUsrByIdUsrhomologado().getIdUsr());
				if (usrAux == null) {
					homologacoesDTO.setResultadoEvento(homologacoesDTO.getERRO_USUARIO_DESCONHECIDO());
					break;
				}
			} catch (Exception e) {
				homologacoesDTO.setResultadoEvento(homologacoesDTO.getERRO_USUARIO_DESCONHECIDO());
				break;
			}

			// Verifica se o usuário homologador existe
			try {
				OmUsr usrAux = usrDAO.getOmUsrPorId(homologacaoDTO.getHomologacaoGt().getOmUsrByIdUsr().getIdUsr());
				if (usrAux == null) {
					homologacoesDTO.setResultadoEvento(homologacoesDTO.getERRO_USUARIO_DESCONHECIDO());
					break;
				}
			} catch (Exception e) {
				homologacoesDTO.setResultadoEvento(homologacoesDTO.getERRO_USUARIO_DESCONHECIDO());
				break;
			}

			// Verifica se o grupo de trabalho existe
			try {
				OmGt gtAux = gtDAO.getOmGtPorId(homologacaoDTO.getHomologacaoGt().getOmGt().getIdGt());
				if (gtAux == null) {
					homologacoesDTO.setResultadoEvento(homologacoesDTO.getERRO_GT_DESCONHECIDO());
					break;
				}
			} catch (Exception e) {
				homologacoesDTO.setResultadoEvento(homologacoesDTO.getERRO_GT_DESCONHECIDO());
				break;
			}
			// Verifica se o tipo da homologa��oo é valida
			if (homologacaoDTO.getHomologacaoGt().getTpHomogt() < 0
					|| homologacaoDTO.getHomologacaoGt().getTpHomogt() > 2) {
				homologacoesDTO.setResultadoEvento(homologacoesDTO.getERRO_TIPOHOMOLOGACAO_INVALIDA());
				break;
			}
			// Verifica se o usuario a ser homologado já existe no cadastro de
			// supervisores
			try {
				hql = "from OmHomopt t where t.omUsrByIdUsrhomologado.idUsr = ::idUsr";
				hql = hql.replaceAll("::idUsr",
						String.valueOf(homologacaoDTO.getHomologacaoGt().getOmUsrByIdUsrhomologado().getIdUsr()));

				Query q = getSession().createQuery(hql);

				q.list().get(0);

				homologacoesDTO.setResultadoEvento(homologacoesDTO.getERRO_USUARIO_JA_HOMOLOGADO_OPERADOR());
				break;
			} catch (Exception e) {

			}
		}

		return homologacoesDTO;

	}

	public GTsDTO getGTsDtoAtivos() throws RegistroDesconhecidoException {
		GTsDTO retorno = new GTsDTO();
		OmGtDAO gtDAO = new OmGtDAO(getSession());
		List<GtDTO> listagts = new ArrayList<GtDTO>();
		List<OmGt> listaOmGt = gtDAO.getOmGtsAtivos();
		if (listaOmGt == null) {
			throw new RegistroDesconhecidoException();
		}
		for (OmGt gt : listaOmGt) {
			GtDTO gtDTO = new GtDTO();
			gtDTO.setGt(gt.clone());
			
			// clonar os postos do gt
			for (OmPt ompt : gt.getOmPts()) {
				gtDTO.getGt().getOmPts().add(ompt.clone(false));
			}
			listagts.add(gtDTO);
		}
		retorno.setGts(listagts);
		return retorno;
	}

	public GruposTrabalhoDTO getGTsDtoAtivosSemPt() throws RegistroDesconhecidoException {
		GruposTrabalhoDTO retorno = new GruposTrabalhoDTO();
		OmGtDAO gtDAO = new OmGtDAO(getSession());
		List<OmGt> listaOmGt = gtDAO.getOmGtsAtivos();
		if (listaOmGt == null) {
			throw new RegistroDesconhecidoException();
		}
		for (OmGt gt : listaOmGt) {
			GrupoTrabalhoDTO gtDTO = new GrupoTrabalhoDTO();
			gtDTO.setCdGt(gt.getCdGt());
			retorno.getGruposTrabalho().add(gtDTO);
		}
		return retorno;
	}

	public GtDTO getOmGtPorIdOuCd(OmGt filtro) {
		GtDTO retorno = new GtDTO();
		OmGtDAO gtDAO = new OmGtDAO(getSession());
		OmGt gt = gtDAO.getOmGtPorIdOuCdAtivos(filtro.getIdGt(), filtro.getCdGt());
		retorno.setGt(gt);
		return retorno;
	}
	
	public OmGt getOmGtPorIdOuCd(Long idGt, String cdGt) {
		OmGtDAO gtDAO = new OmGtDAO(getSession());
		return gtDAO.getOmGtPorIdOuCdAtivos(idGt, cdGt);
	}

	private void incluirOmObj(Map<Long, OmObj> objs, PTRN prn, DiversosRN drn, EstoqueRN ern, OmGt omGtGeral,
			GtDTO dtoRetorno, OmGt itemOriginal, OmObj obj) {
		OmObj objNovo = obj.clone(true);
		// Arredonda x, y, x2 e y2 para no maximo 4 casas decimais
		objNovo.setX(Util.getBigDecimalComCasas(obj.getX(), 4));
		objNovo.setY(Util.getBigDecimalComCasas(obj.getY(), 4));
		objNovo.setX2(Util.getBigDecimalComCasas(obj.getX2(), 4));
		objNovo.setY2(Util.getBigDecimalComCasas(obj.getY2(), 4));

		// Pesquisar o estoque associado
		if (obj.getDwEstByIdEst() != null) {
			DwEst dwest = ern.pesquisarDwEstEStAtivoByCd(obj.getDwEstByIdEst().getCdEst());
			if (dwest == null) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
				return;
			}
			objNovo.setDwEstByIdEst(dwest);
		} else {
			objNovo.setDwEstByIdEst(null);
		}

		// Pesquisar a imagem associada
		if (obj.getOmImg() != null) {
			OmImg omimg = drn.pesquisarOmImgStAvitoByCd(obj.getOmImg().getCdImg());
			if (omimg == null) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
				return;
			}
			objNovo.setOmImg(omimg);
		} else {
			objNovo.setOmImg(null);
		}

		// Pesquisar o pt associado
		if (obj.getOmPt() != null) {
			OmPt ompt = prn.pesquisarPtByCdPtStAtivo(obj.getOmPt().getCdPt());
			if (ompt == null) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
				return;
			}
			objNovo.setOmPt(ompt);
		} else {
			objNovo.setOmPt(null);
		}

		// Pesquisar o texto associado
		if (obj.getOmTexto() != null) {
			try {
				OmTexto omTexto = drn.pesquisarOmTextoStAvitoById(obj.getOmTexto().getIdTexto());
				if (omTexto == null) {
					omTexto = obj.getOmTexto();
					omTexto = this.getDao().makePersistent(omTexto);
					objNovo.setOmTexto(omTexto);
				} else {
					omTexto.setDsTexto(obj.getOmTexto().getDsTexto());
					omTexto = this.getDao().makePersistent(omTexto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Se o objeto tiver um objeto de origem, pegar a referencia dele no
		// banco. Isso ocorre para a linha
		if (obj.getOmObjByIdObjorigem() != null) {
			objNovo.setOmObjByIdObjorigem(objs.get(obj.getOmObjByIdObjorigem().getIdObj()));

			/*
			 * for (OmObj omobj : itemOriginal.getOmObjsForIdRota()) { // os
			 * items de origem de uma seta podem ser uma folha, um estoque, uma
			 * imagem. Assim devemos pesquisar usando-se esse tres aspectos if
			 * (omobj.getDwFolhaByIdFolha() != null &&
			 * obj.getOmObjByIdObjorigem().getDwFolhaByIdFolha() != null) { if
			 * (omobj.getDwFolhaByIdFolha().getIdFolha().equals(obj.
			 * getOmObjByIdObjorigem().getDwFolhaByIdFolha().getIdFolha())) {
			 * objNovo.setOmObjByIdObjorigem(omobj); } } else if
			 * (omobj.getDwEstByIdEst() != null &&
			 * obj.getOmObjByIdObjorigem().getDwEstByIdEst() != null) { if
			 * (omobj.getDwEstByIdEst().getIdEst() ==
			 * obj.getOmObjByIdObjorigem().getDwEstByIdEst().getIdEst()) {
			 * objNovo.setOmObjByIdObjorigem(omobj); } } else if
			 * (omobj.getOmImg() != null &&
			 * obj.getOmObjByIdObjorigem().getOmImg() != null) { if
			 * (omobj.getOmImg().getIdImg() ==
			 * obj.getOmObjByIdObjorigem().getOmImg().getIdImg()) {
			 * objNovo.setOmObjByIdObjorigem(omobj); } } }
			 */
		}

		// Se o objeto tiver um objeto de destino, pegar a referencia dele no
		// banco. Isso ocorre para a linha
		if (obj.getOmObjByIdObjdestino() != null) {
			objNovo.setOmObjByIdObjdestino(objs.get(obj.getOmObjByIdObjdestino().getIdObj()));
			/*
			 * for (OmObj omobj : itemOriginal.getOmObjsForIdRota()) { // os
			 * items de origem de uma seta podem ser uma folha, um estoque, uma
			 * imagem. Assim devemos pesquisar usando-se esse tres aspectos if
			 * (omobj.getDwFolhaByIdFolha() != null &&
			 * obj.getOmObjByIdObjdestino().getDwFolhaByIdFolha() != null) { if
			 * (omobj.getDwFolhaByIdFolha().getIdFolha().equals(obj.
			 * getOmObjByIdObjdestino().getDwFolhaByIdFolha().getIdFolha())) {
			 * objNovo.setOmObjByIdObjdestino(omobj); } } else if
			 * (omobj.getDwEstByIdEst() != null &&
			 * obj.getOmObjByIdObjdestino().getDwEstByIdEst() != null) { if
			 * (omobj.getDwEstByIdEst().getIdEst() ==
			 * obj.getOmObjByIdObjdestino().getDwEstByIdEst().getIdEst()) {
			 * objNovo.setOmObjByIdObjdestino(omobj); } } else if
			 * (omobj.getOmImg() != null &&
			 * obj.getOmObjByIdObjdestino().getOmImg() != null) { if
			 * (omobj.getOmImg().getIdImg() ==
			 * obj.getOmObjByIdObjdestino().getOmImg().getIdImg()) {
			 * objNovo.setOmObjByIdObjdestino(omobj); } } }
			 */
		}

		// Preencher outros valores no pojo
		objNovo.setOmWebcam(null);
		objNovo.setOmGtByIdGt(itemOriginal);
		objNovo.setIdObj(null);
		// objNovo.setOmGtByIdGt(omGtGeral); //
		objNovo.setDwRotapasso(null);
		itemOriginal.getOmObjsForIdGt().add(objNovo);
		objs.put(obj.getIdObj(), objNovo);
	}

	public GTsDTO getOmGtsAtivosPorTp(int idTpGt) {
		GTsDTO retorno = new GTsDTO();
		retorno.setGts(new ArrayList<GtDTO>());
		OmGtDAO gtDAO = new OmGtDAO(getSession());
		List<OmGt> lista = gtDAO.getOmGtsAtivosPorTp(String.valueOf(idTpGt));
		for (OmGt gt : lista) {
			GtDTO dto = new GtDTO();
			dto.setGt(gt.clone());
			retorno.getGts().add(dto);
		}
		return retorno;
	}

	public PesquisasDTO pesquisaOmGtPorTp(PesquisaDTO pesquisa, Long idTpGt) {

		MapQuery q = new MapQuery(getSession());
		q.append("SELECT gt");
		q.append("FROM OmGt gt");
		q.append("JOIN gt.omTpgt tpgt");
		q.append("WHERE gt.stAtivo = :stAtivo");
		if (idTpGt != null) {
			q.append("AND tpgt.idTpgt = :idTpGt");
		}
		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			q.append("AND (gt.cdGt = :cdGt OR gt.dsGt = :dsGt)");
		} else if (!pesquisa.getCodigo().equals("")) {
			q.append("AND gt.cdGt = :cdGt");
		} else if (!pesquisa.getDescricao().equals("")) {
			q.append("AND gt.dsGt = :dsGt");
		}
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("idTpGt", idTpGt);
		q.defineParametro("cdGt", pesquisa.getCodigo());
		q.defineParametro("dsGt", pesquisa.getDescricao());

		List<OmGt> lista = q.list();
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();
		for (OmGt item : lista) {
			PesquisaDTO dto = new PesquisaDTO();
			dto.setCodigo(item.getCdGt());
			dto.setDescricao(item.getDsGt());
			dto.setRegistro(item.clone());
			listaDTO.add(dto);
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}

	public Boolean verificaOmGtVazio(Long idGt) {
		Boolean retorno = false;
		List<OmPt> ompts = null;

		MapQuery q = new MapQuery(getSession());

		q.append(" SELECT ompt ");
		q.append(" FROM OmPt ompt ");
		q.append(" WHERE ompt.omGt.idGt = :parIdGt ");
		q.defineParametro("parIdGt", idGt);

		ompts = q.list();

		if (ompts != null) {
			if (ompts.isEmpty()) {
				retorno = Boolean.TRUE;
			} else {
				retorno = Boolean.FALSE;
			}
		} else {
			retorno = Boolean.TRUE;
		}

		return retorno;
	}
	
	public OmGt getOmGtByCdGt(String cdGt){
		MapQuery q;
		try {
			if (getSession() != null)
				q = new MapQuery(getSession());
			else
				q = new MapQuery(getSessionStateless());
		} catch (SemSessaoHibernateException e) {
			q = new MapQuery(getSessionStateless());
		}
		q.append("FROM OmGt omgt");
		q.append("WHERE omgt.cdGt = :cdGt");
		q.append("AND omgt.stAtivo = 1");
		q.defineParametro("cdGt", cdGt);
		q.setMaxResults(1);
		return (OmGt) q.uniqueResult();
		
	}
	public OmGt getOmGtByDepara(String depara) {
		MapQuery q;
		try {
			if (getSession() != null)
				q = new MapQuery(getSession());
			else
				q = new MapQuery(getSessionStateless());
		} catch (SemSessaoHibernateException e) {
			q = new MapQuery(getSessionStateless());
		}
		
		q.append("select distinct a");
		q.append("from OmGt a");
		q.append("where a.stAtivo = 1");
		q.append("and a.depara = :depara");
		
		q.defineParametro("depara", depara);
		q.setMaxResults(1);
		
		OmGt retorno = (OmGt) q.uniqueResult();
		return retorno;
	}

	// Pesquisar os gts diretamente ligados ao PT
	public GTsDTO getOmGtLigadosAosPTs() {
		GTsDTO retorno = new GTsDTO();
		
		MapQuery q = new MapQuery(getSession());
		
		q.append("select distinct a");
		q.append("from OmGt a");
		q.append("join a.omPts b");
		q.append("where a.stAtivo = :stativo");
		q.append("and b.stAtivo = :stativo");
		q.append("and b.isApongt = :is");
		
		q.defineParametro("stativo", (byte) 1);
		q.defineParametro("is", true);
		
		List<OmGt> lista = q.list();
		List<GtDTO> gts = new ArrayList<>();
		for (OmGt gt : lista) {
			GtDTO dto = new GtDTO();
			dto.setGt(gt.clone(false));
			gts.add(dto);
		}
		retorno.setGts(gts);
		return retorno;
	}
	
	
	public PTsDTO getOmGtsAtivosPorFolha(DwFolha dwFolha) throws RegistroDesconhecidoException {
		PTsDTO retorno = new PTsDTO();
		retorno.setPts(new ArrayList<PtDTO>());
        FolhaRN folhaRN = new FolhaRN();
        folhaRN.setDao(getDao());
        DwFolha itemFolha = folhaRN.pesquisaFolhaByCdEStSemRota(dwFolha.getCdFolha());

        if (itemFolha == null)
        	throw new RegistroDesconhecidoException();
        
		List<OmPt> lista = pesquisarOmGtPorOmTppt(itemFolha.getOmTppt());
		for (OmPt pt : lista) {
			getDao().evict(pt);
			
			PtDTO dto = new PtDTO();
			dto.setPt(pt.clone(false));
			dto.getPt().setOmGt(pt.getOmGt().clone(false));
			dto.setIsMostrarGtDoPt(true);
			
			// Verifica se ja existe o GT na lista de retorno. Se nao existir incluir, se existir ignorar
			boolean isExiste = false;
			for (PtDTO dtoAux : retorno.getPts()) {
				if (dtoAux.getPt().getOmGt().getCdGt().equals(dto.getPt().getOmGt().getCdGt()))
					isExiste = true;
			}
			if (isExiste == false)
				retorno.getPts().add(dto);
		}
		return retorno;
	}

	public List<OmPt> pesquisarOmGtPorOmTppt(OmTppt omtppt) {
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select distinct a");
		q.append("from OmPt a");
		q.append("join fetch a.omGt b");
		q.append("where a.omTppt = :omtppt");
		q.append("and a.stAtivo = 1");
		q.append("and b.stAtivo = 1");
		q.append("and a.isApongt = :isapongt");
		
		q.defineParametro("omtppt", omtppt);
		q.defineParametro("isapongt", true);
		
		return q.list();
	}
	
	/*
	 * metodo para retornar os gts que estao nos cadastros do pts que apontam para o gt
	 */
	public List<OmGt> pesquisasrOmGtDosPostosQueApontamProducao() {
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select distinct a");
		q.append("from OmGt a");
		q.append("join a.omPts b");
		q.append("where a.stAtivo = 1");
		q.append("and b.stAtivo = 1");
		q.append("order by a.cdGt");
		
		return q.list();
	}
	
	
	/* O metodo abaixo retornar todos os GTs de determinada fase que tenha posto de trabalho ativos 
	 * usado no cf web para permitir ao operador escolher uma linha com postos que poderao ter alimentacao de mP*/
	public GTsDTO pesquisarGtdeUmFaseQueTenhaPts(String cdFase) {
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select distinct a");
		q.append("from OmGt a");
		q.append("join fetch a.omPts b");
		q.append("join a.omGtfase c");
		q.append("where a.stAtivo = 1");
		q.append("and b.stAtivo = 1");
		q.append("and c.cdGt = :cdgt");
		q.append("and c.stAtivo = 1");
		q.append("order by a.cdGt");
		
		q.defineParametro("cdgt",  cdFase);
		
		List<OmGt> lista = q.list();
		GTsDTO retorno = new GTsDTO();
		retorno.setGts(new ArrayList<GtDTO>());
		
		
		for (OmGt omgt : lista) {
			GtDTO gtdto = new GtDTO();
			gtdto.setGt(omgt.clone(false));
			gtdto.getGt().setOmPts(new HashSet<OmPt>());
			for (OmPt ompt : omgt.getOmPts()) {
				if (ompt.getStAtivo().equals((byte) 1))
					gtdto.getGt().getOmPts().add(ompt.clone(false));
			}
			retorno.getGts().add(gtdto);

		}
		return retorno;
	}
	
	@SuppressWarnings("unused")
	public ListaGTsDTO getGTsDTO(FiltroPesquisaDTO filtro) {
		ListaGTsDTO retorno = new ListaGTsDTO();
		retorno.setItems(new ArrayList<GtDTO2>());
		retorno.setMeta(new MetaDTO(filtro));
		
		MonitorizacaoWebRN monitRN = new MonitorizacaoWebRN(null);
		
		MapQuery q = new MapQuery(getSession());
		q.append("SELECT t");
		q.append("FROM OmGt t");
		q.append("WHERE t.stAtivo = 1");

		/*
		 *   No futuro os próximos 3 filtros deixarao de existir.
		 *   Filtro sendo forcado pra maq ciclica
		 */
		
		q.append(" AND t.omTpgt.cdTpgt = '1'");
		q.append(" AND t.omImg.cdImg = '0'");
		
		
		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){			
			q.append("AND (");
			q.append(" upper(t.cdGt) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.dsGt) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		}
 
 		q.append("ORDER BY t.cdGt");
 		
 		List<OmGt> listaOmGt =  q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
 		
 		for (OmGt gt : listaOmGt) {
 			GtDTO2 gtDTO = new GtDTO2();
 			gtDTO.setIdGt(gt.getIdGt());
 			gtDTO.setCdGt(gt.getCdGt());
 			gtDTO.setDsGt(gt.getDsGt());
 			gtDTO.setStRegistro(gt.getStAtivo().intValue());
 			
 			// -----------------------------------------------------------------
 			// Layout
 			// -----------------------------------------------------------------
 			
 			List<GtLayoutDTO> layouts = new ArrayList<GtLayoutDTO>();
 			
 			for (OmObj obj : gt.getOmObjsForIdGt()) {
 				
 				GtLayoutDTO layout = new GtLayoutDTO();
 	 			
 				layout.setCdPt(obj.getOmPt().getCdPt());
 	 			layout.setIdImg(monitRN.OmImgToIdPtNIDW(obj.getOmImg()));
 	 			layout.setX(obj.getX().intValue());
 	 			layout.setY(obj.getY().intValue());
 	 			
 	 			layouts.add(layout);
 	 			
 			}
 			
 			gtDTO.setLayout(layouts);
 			
 			// -----------------------------------------------------------------
 			
 			retorno.getItems().add(gtDTO);
 			
 		}
		
 		if (listaOmGt.size() > 0) {
 			ResumoRetornoRegistrosRN resRN = new ResumoRetornoRegistrosRN(getDao());
 			retorno.setMeta(resRN.getMetaDTO(filtro, q, listaOmGt.size()));
 			resRN = null;
 		}
		
		q = null;
		listaOmGt = null;
		
		return retorno;
	}

	@SuppressWarnings("unused")
	public GtDTO2 getGtByCd(String cdGT) {
		GtDTO2 retorno = new GtDTO2();
		
		MonitorizacaoWebRN monitRN = new MonitorizacaoWebRN(null);
		
		MapQuery q = new MapQuery(getSession());
		q.append("SELECT t");
		q.append("FROM OmGt t");
		q.append("WHERE t.stAtivo = 1");

		/*
		 *   No futuro os próximos 3 filtros deixarao de existir.
		 *   Filtro sendo forcado pra maq ciclica
		 */
		
		q.append(" AND t.omTpgt.cdTpgt = '1'");
		q.append(" AND t.omImg.cdImg = '0'");
		
		
		q.append("AND t.cdGt = :cdGt");
 		q.append("ORDER BY t.cdGt");
 		q.defineParametro("cdGt", cdGT);
 		

 		List<OmGt> listaOmGt =  q.list();
 		
 		if (listaOmGt.size() == 1) {
 			
 			retorno.setIdGt(listaOmGt.get(0).getIdGt());
 			retorno.setCdGt(listaOmGt.get(0).getCdGt());
 			retorno.setDsGt(listaOmGt.get(0).getDsGt());
 			retorno.setStRegistro(listaOmGt.get(0).getStAtivo().intValue());
 			
 			// -----------------------------------------------------------------
 			// Layout
 			// -----------------------------------------------------------------
 			
 			List<GtLayoutDTO> layouts = new ArrayList<GtLayoutDTO>();
 			
 			for (OmObj obj : listaOmGt.get(0).getOmObjsForIdGt()) {
 				
 				GtLayoutDTO layout = new GtLayoutDTO();
 	 			
 				layout.setCdPt(obj.getOmPt().getCdPt());
 	 			layout.setIdImg(monitRN.OmImgToIdPtNIDW(obj.getOmImg()));
 	 			layout.setX(obj.getX().intValue());
 	 			layout.setY(obj.getY().intValue());
 	 			
 	 			layouts.add(layout);
 	 			
 			}
 			
 			retorno.setLayout(layouts);
 			
 			// -----------------------------------------------------------------
 			
 		}
		
		
		return retorno;
	}
	
	public String CdPtNIDWToOmImg(int id) {
		
		String retorno = "";
		
		List<OmImg> imgs = new ArrayList<OmImg>();
		OmImgDAO rn = new OmImgDAO(getSession());
		imgs = rn.getOmImgAtivo();
		
		if (id == TipoPostoNIDW.EMBALADORA.getValor()) {
			retorno = CdOmImg(imgs, "EMBALADORA");
			
		} else if (id == TipoPostoNIDW.ENVASADORA.getValor()) {
			retorno = CdOmImg(imgs, "ENVASADORA");
		
		} else if (id == TipoPostoNIDW.FURADEIRA.getValor()) {		
			retorno = CdOmImg(imgs, "FURADEIRA");
		
		} else if (id == TipoPostoNIDW.GALVANOPLASTIA.getValor()) {
			retorno = CdOmImg(imgs, "GALVA_48X48");
		
		} else if (id == TipoPostoNIDW.INJETORA.getValor()) {
			retorno = CdOmImg(imgs, "INJETORA");
			
		} else if (id == TipoPostoNIDW.LINER.getValor()) {
			retorno = CdOmImg(imgs, "LINER_48X48");
			
		} else if (id == TipoPostoNIDW.LINHA.getValor()) {
			retorno = CdOmImg(imgs, "LINHA");
			
		} else if (id == TipoPostoNIDW.NAVIO.getValor()) {
			retorno = CdOmImg(imgs, "NAVIO_48X48");
		
		} else if (id == TipoPostoNIDW.PRENSA.getValor()) {
			retorno = CdOmImg(imgs, "PRENSA");
		
		} else if (id == TipoPostoNIDW.ROBO.getValor()) {
			retorno = CdOmImg(imgs, "ROB");
		
		} else if (id == TipoPostoNIDW.ROTULADORA.getValor()) {
			retorno = CdOmImg(imgs, "ROTULADORA");
		
		} else if (id == TipoPostoNIDW.SLITTER.getValor()) {
			retorno = CdOmImg(imgs, "SLITTER_48X48");
		
		} else if (id == TipoPostoNIDW.SOPRADORA.getValor()) {
			retorno = CdOmImg(imgs, "SOPRADORA");
		
		} else if (id == TipoPostoNIDW.TOP.getValor()) {
			retorno = CdOmImg(imgs, "TOP_48X48");
			
		} else if (id == TipoPostoNIDW.TORNO.getValor()) {
			retorno = CdOmImg(imgs, "TORNO_48X48");
		
		} else if (id == TipoPostoNIDW.USINAGEM.getValor()) {
			retorno = CdOmImg(imgs, "USI_48X48");
		
		} else if (id == TipoPostoNIDW.FORNO.getValor()) {
			retorno = CdOmImg(imgs, "FORNO-HELLER_48x48.png");
			
		} else {
			retorno = CdOmImg(imgs, "NXTL_48x48.png");
			
		}
		
		return retorno;
	}


	public int IdOmImg(List<OmImg> imgs, String dsImagem) {
	
		int retorno = 0;
		
		// Percorre itens de imgs
		for (OmImg img : imgs) {
			
			if (img.getDsImg().toUpperCase().equals(dsImagem)) {
				retorno = (int) img.getIdImg();
				break;
			}
	
		}
		
		return retorno;
		
	}
	

	public String CdOmImg(List<OmImg> imgs, String dsImagem) {
	
		String retorno = "";
		
		// Percorre itens de imgs
		for (OmImg img : imgs) {
			
			if (img.getDsImg().toUpperCase().equals(dsImagem)) {
				retorno = img.getCdImg();
				break;
			}
	
		}
		
		return retorno;
		
	}
	
	
}
