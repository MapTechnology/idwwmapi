package idw.model.rn;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwRota;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCliente;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpData;
import idw.model.pojos.PpCpPre;
import idw.model.pojos.PpCpTurno;
import idw.model.pojos.PpCpneccron;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.PpPlancol;
import idw.model.pojos.PpPlanec;
import idw.model.pojos.PpPlano;
import idw.model.pojos.PpPlanptgt;
import idw.model.pojos.PpTpplano;
import idw.util.IdwLogger;
import idw.webservices.dto.PlanoDTO;
import idw.webservices.dto.PlanoListDTO;
import idw.webservices.dto.PtGtDTO;
import idw.webservices.dto.ResultadoDTO;

@SuppressWarnings("serial")
public class ManipulacaoCpsGeradasRN extends PlanoDTO implements IDao {

	private DAOGenerico dao;
	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}

	@Override
	public void iniciaConexaoBanco(Session e) {
		this.dao.iniciaSessao();
		this.dao.iniciaTransacao();
	}

	@Override
	public void finalizaConexaoBanco() {
		this.dao.finalizaTransacao();
		this.dao.finalizaSessao();
	}

	public void iniciaConexaoBancoStatless() {
		this.dao.iniciaSessaoStateless();
		this.dao.iniciaTransacaoStateless();
	}

	public void finalizaConexaoBancoStatless() {
		this.dao.finalizaTransacaoStateless();
		this.dao.finalizaSessaoStateless();
	}

	public ManipulacaoCpsGeradasRN() {
		if (this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}

	public ManipulacaoCpsGeradasRN(DAOGenerico dao) {
		this.dao = dao;
	}

	public ManipulacaoCpsGeradasRN(PlanoDTO plano) {
		super(plano, null);

		if (this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}

	public PlanoListDTO pesquisarPlanoECPs(PlanoDTO planoDTO) {
		IdwLogger log = new IdwLogger("ManipulacaoCpsGeradas");

		log.iniciaAvaliacao("pesquisarPlanoECPs");

		PlanoListDTO retorno = new PlanoListDTO();
		retorno.setPlanos(new ArrayList<PlanoDTO>());
		ResultadoDTO resultado = new ResultadoDTO();
		retorno.setResultado(resultado);
		
		Calendar cal = Calendar.getInstance();
		retorno.setDthrAtualConsulta(cal.getTime());
		cal = null;

		MapQuery q = new MapQuery(this.dao.getSessionStateless());

		q.append("select distinct plano from PpPlano plano");
		q.append("join fetch plano.omUsrByIdUsrstativo omusrstativo");
		q.append("join fetch plano.omUsrByIdUsrrevisao omusrrevisao");
		q.append("left join fetch plano.ppCps ppcp");
		q.append("left join fetch ppcp.omPt ompt");
		q.append("left join fetch ppcp.omGt omgt");
		q.append("left join fetch ppcp.ppCpprodutos ppcpprod");
		q.append("left join fetch ppcpprod.omProduto produto");
		q.append("left join fetch ppcpprod.ppCpDatas cpdatas");
		q.append("left join fetch cpdatas.ppCpTurnos cpturnos");
		q.append("left join fetch ppcp.dwFolha dwfolha");
		q.append("left join fetch dwfolha.dwFolhaiacs folhaiacs");
		q.append("left join fetch folhaiacs.omProduto produtoiac");

		q.appendWhere(MapQuery._NULL, "plano.cdPlano = :cdplano", ((planoDTO.getCdPlano() != null) && (!planoDTO.getCdPlano().isEmpty())));
		q.appendWhere(MapQuery._AND, "plano.revisao = :revisao", (planoDTO.getRevisao() != null));
		q.appendWhere(MapQuery._AND, "plano.stPlano = :stplano", (planoDTO.getStPlano() != null));
		q.appendWhere(MapQuery._AND, "plano.stAtivo = :stativo", (planoDTO.getStAtivo() != null));
		q.appendWhere(MapQuery._AND, "ppcp.stAtivo = 1", true);
		
		q.append("order by plano.idPlano");
		
		q.defineParametro("cdplano", planoDTO.getCdPlano());
		q.defineParametro("revisao", planoDTO.getRevisao());
		q.defineParametro("stplano", planoDTO.getStPlano());
		q.defineParametro("stativo", planoDTO.getStAtivo());
		
		log.iniciaAvaliacao("pesquisarPlanoECPs.execucaoHQL");
		ScrollableResults lista = q.resultSet();

		boolean isPrimeiraVezControleParaLog = true;

		while (lista.next() == true) {
			if (isPrimeiraVezControleParaLog == true) {
				log.paraAvaliacao(dao);
				isPrimeiraVezControleParaLog = false;
			}
			PpPlano pp = null;

			pp = (PpPlano) lista.get(0);

			PlanoDTO plano = new PlanoDTO(pp, null);

			plano.setDwCal(null);
			plano.setPpPlanecs(null);
			plano.setPpTpplano(null);

			// pegar as CPs do Plano
			plano.setPpCps(new HashSet<PpCp>());
			log.iniciaAvaliacao("pesquisarPlanoECPs.interacaoNasCps");
			
			for (PpCp cp : pp.getPpCps()) {
				PpCp ppcp = clonaCp(cp);
				plano.getPpCps().add(ppcp);
			}
			log.paraAvaliacao(dao);
			
			// Pegar plancol
			q.novaConsulta();
			q.append("select ppplancol");
			q.append("from PpPlancol ppplancol");
			q.append("where ppplancol.ppPlano = :ppplano");
			q.defineParametro("ppplano", pp);
			q.setMaxResults(1);
			List<PpPlancol> listaPlancol = q.list();
			plano.setPpPlancols(new HashSet<PpPlancol>());
			for (PpPlancol col : listaPlancol){
				plano.getPpPlancols().add(col.clone(false));
			}
			
			
			
			// Pegar planptgt
			q.novaConsulta();
			q.append("select ppplanptgt");
			q.append("from PpPlanptgt ppplanptgt");
			q.append("left join fetch ppplanptgt.omPt ompt");
			q.append("left join fetch ppplanptgt.omGt omgt");
			q.append("where ppplanptgt.ppPlano = :ppplano");
			q.defineParametro("ppplano", pp);
			List<PpPlanptgt> listaPlanptgt = q.list();
			plano.setPpPlanptgts(new HashSet<PpPlanptgt>());
			for (PpPlanptgt ptgt : listaPlanptgt){
				OmPt ompt = null;
				OmGt omgt = null;
				if (ptgt.getOmPt() != null) {
					ompt = ptgt.getOmPt().clone(false);
					ompt.setPpCps(new HashSet<PpCp>());
				}
				if (ptgt.getOmGt() != null){
					omgt = ptgt.getOmGt().clone(false);
					omgt.setPpCps(new HashSet<PpCp>());
				}
				
				PpPlanptgt n = ptgt.clone(false);
				n.setOmGt(omgt);
				n.setOmPt(ompt);
				// Se PT estiver definido e ja existir na lista na mesma Aba, entao nao incluir no retorno
				boolean isExiste = false;
				if (ompt != null) {
					for (PpPlanptgt laypt : plano.getPpPlanptgts()) {
						if (laypt.getOmPt() != null && laypt.getOmPt().getIdPt().equals(ompt.getIdPt()) && laypt.getAba().equals(n.getAba()))
							isExiste = true;
					}
				}
				if (isExiste == false)
					plano.getPpPlanptgts().add(n);
			}
			
			retorno.getPlanos().add(plano);
		}

		// pesquisar configuracao
		OmCfg omCfg = null;
		q.novaConsulta();

		q.append("select omcfg");
		q.append("from OmCfg omcfg");
		q.append("left join omcfg.dwRap dwrap");
		q.append("where omcfg.stAtivo = 1");
		q.setMaxResults(1);

		omCfg = (OmCfg) q.uniqueResult();

		OmCfg cfg = new OmCfg();
		if (omCfg.getDwRap() != null) {
			cfg.setDwRap(omCfg.getDwRap().clone());
		}

		retorno.setConfiguracao(cfg);
		
		log.paraAvaliacao(dao);
		log.info(log.getAvaliacaoCompleta());

		resultado.setIdmensagem(resultado.COM_SUCESSO);
		return retorno;
	}

	private PpCp clonaCp(PpCp cp) {
		PpCp retorno = cp.clone(false);

		if (cp.getOmPt() != null) {
			retorno.setOmPt(cp.getOmPt().clone(false));
		}

		if (cp.getOmGt() != null) {
			retorno.setOmGt(cp.getOmGt().clone(false));
		}

		if (cp.getPpCpprodutos() != null) {
			retorno.setPpCpprodutos(new HashSet<PpCpproduto>());
			for (PpCpproduto prod : cp.getPpCpprodutos()) {
				PpCpproduto cpprod = prod.clone(true);

				retorno.getPpCpprodutos().add(cpprod);
			}
		}

		if (cp.getDwFolha() != null) {
			retorno.setDwFolha((DwFolha) cp.getDwFolha().clone(false));

			if (cp.getDwFolha().getDwFolharaps() != null) {
				retorno.getDwFolha().setDwFolharaps(new HashSet<DwFolharap>());

				MapQuery q = new MapQuery(dao.getSessionStateless());
				q.append("select dwfolharap");
				q.append("from  DwFolharap dwfolharap");
				q.append("left join fetch dwfolharap.dwRap");
				q.append("where dwfolharap.dwFolha = :dwfolha");
				q.defineParametro("dwfolha", cp.getDwFolha());

				List<DwFolharap> listarap = q.list();

				for (DwFolharap dwfolharap : listarap) {
					DwFolharap rap = dwfolharap.clone(false);
					rap.setDwRap(dwfolharap.getDwRap().clone(false));
					retorno.getDwFolha().getDwFolharaps().add(rap);
				}
			}

			// clona os folhaiac do dwfolha
			if ((cp.getDwFolha().getDwFolhaiacs() != null) && (!cp.getDwFolha().getDwFolhaiacs().isEmpty())) {
				retorno.getDwFolha().setDwFolhaiacs(new HashSet<DwFolhaiac>());
				for (DwFolhaiac folhaiac : cp.getDwFolha().getDwFolhaiacs()) {
					if (folhaiac != null) {
						OmProduto omprodutoClone = new OmProduto();
						omprodutoClone.copy(folhaiac.getOmProduto(), false);
						DwFolhaiac dwfolhaiacClone = folhaiac.clone(false);
						folhaiac.setOmProduto(omprodutoClone);
						
						retorno.getDwFolha().getDwFolhaiacs().add(dwfolhaiacClone);
					}
				}
			}
		}

		return retorno;
	}

	public PtGtDTO pesquisarCentrosTrabalho() {
		PtGtDTO retorno = new PtGtDTO();
		ResultadoDTO resultado = new ResultadoDTO();
		retorno.setResultadoDTO(resultado);

		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select ompt from OmPt ompt");
		q.appendWhere(MapQuery._NULL, "ompt.stAtivo = 1", true);
		q.appendWhere(MapQuery._AND, "ompt.isPlangt = :isplangt", true);

		q.defineParametro("isplangt", false);
		
		List<OmPt> listaOmPt = q.list();

		if ((listaOmPt != null) && (!listaOmPt.isEmpty())) {
			retorno.setListaPt(new ArrayList<OmPt>());

			for (OmPt ompt : listaOmPt) {
				OmPt pt = ompt.clone(false);
				pt.setPpCps(null);

				retorno.getListaPt().add(pt);
			}
		}

		q.novaConsulta();

		q.append("select distinct omgt from OmGt omgt");
		q.append("join omgt.omPts ompt");
		q.appendWhere(MapQuery._NULL, "ompt.isPlangt=1", true);
		q.appendWhere(MapQuery._AND, "ompt.stAtivo=1", true);

		List<OmGt> listaOmGt = q.list();

		if ((listaOmGt != null) && (!listaOmGt.isEmpty())) {
			retorno.setListaGt(new ArrayList<OmGt>());
			for (OmGt omgt : listaOmGt) {
				OmGt gt = omgt.clone(false);
				gt.setPpCps(null);

				retorno.getListaGt().add(gt);
			}
		}

		resultado.setIdmensagem(resultado.COM_SUCESSO);

		return retorno;
	}

	public PtGtDTO pesquisarCentrosComCPsDeProdutosIguais(OmProduto prod) {
		PtGtDTO retorno = null;

		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select distinct ompt ");
		q.append("from OmPt ompt");
		q.append("join fetch ompt.ppCps ppcp");
		q.append("join fetch ppcp.ppCpprodutos ppcpprod");
		q.append("join fetch ppcpprod.omProduto omprod");
		q.appendWhere(MapQuery._NULL, "ompt.stAtivo = 1", true);
		q.appendWhere(MapQuery._AND, "ompt.isPlangt = :isplangt", true);
		q.appendWhere(MapQuery._AND, "omprod=:omproduto", (prod != null));

		q.defineParametro("omproduto", prod);
		q.defineParametro("isplangt", false);

		List<OmPt> listaPt = q.list();

		retorno = new PtGtDTO();
		if (listaPt != null) {
			retorno.setListaPt(new ArrayList<OmPt>());

			for (OmPt ompt : listaPt) {
				OmPt pt = ompt.clone(false);

				if ((pt.getPpCps() != null) && (!pt.getPpCps().isEmpty())) {
					pt.setPpCps(new HashSet<PpCp>());

					for (PpCp ppcp : ompt.getPpCps()) {
						PpCp ppCp = ppcp.clone(true);
						ppCp.setOmPt(null);

						pt.getPpCps().add(ppCp);
					}
				}

				retorno.getListaPt().add(pt);
			}
		}

		// consultar o GTs
		q.novaConsulta();

		q.append("select distinct omgt from OmGt omgt");
		q.append("join fetch omgt.omPts ompt");
		q.append("join fetch omgt.ppCps ppcp");
		q.append("join fetch ppcp.ppCpprodutos ppcpprod");
		q.append("join fetch ppcpprod.omProduto omprod");
		q.appendWhere(MapQuery._NULL, "ompt.stAtivo = 1", true);
		q.appendWhere(MapQuery._AND, "ompt.isPlangt = :isplangt", true);
		q.appendWhere(MapQuery._AND, "omprod=:omproduto", (prod != null));

		q.defineParametro("omproduto", prod);
		q.defineParametro("isplangt", true);

		List<OmGt> listaGt = q.list();

		if (listaGt != null) {
			retorno.setListaGt(new ArrayList<OmGt>());

			for (OmGt omgt : listaGt) {
				OmGt gt = omgt.clone(false);

				if ((gt.getPpCps() != null) && (!gt.getPpCps().isEmpty())) {
					gt.setPpCps(new HashSet<PpCp>());

					for (PpCp ppcp : omgt.getPpCps()) {
						PpCp ppCp = ppcp.clone(true);
						ppCp.setOmGt(null);

						gt.getPpCps().add(ppCp);
					}
				}

				retorno.getListaGt().add(gt);
			}
		}

		return retorno;
	}

	public PlanoDTO salvarRegistro(PlanoDTO plano) {
		PlanoDTO retorno = new PlanoDTO();
		ResultadoDTO resultado = new ResultadoDTO();
		retorno.setResultadoDTO(resultado);

		PpPlano ppplano = pesquisarPlanoByCdESt(plano);
		if (ppplano == null) {
			resultado.setIdmensagem(resultado.PLANO_DESCONHECIDO);
			return retorno;
		}

		if ((this.getIdPlano() == null) || (this.getIdPlano() == 0)) {
			resultado.setIdmensagem(resultado.REGISTRO_JA_EXISTE);
			return retorno;
		}

		PlanoDTO planDTO = excluirRegistroById();
		if (planDTO.getResultadoDTO().getIdmensagem() != resultado.COM_SUCESSO) {
			resultado.setIdmensagem(planDTO.getResultadoDTO().getIdmensagem());
			return retorno;
		}

		PpPlano planoNovo = ppplano.clone(false);
		planoNovo.setIdPlano(null);
		planoNovo.setStPlano(0);
		planoNovo.setDtRevisao(DataHoraRN.getDataHoraAtual());
		planoNovo.setDtStativo(DataHoraRN.getDataHoraAtual());
		planoNovo.setStAtivo(1);
		planoNovo.setRevisao(plano.getRevisao() + 1);

		planoNovo.setDwCal(ppplano.getDwCal());

		// pesquisa o Usuario do stativo
		OmUsr omUsrStAtivo = null;
		OmUsr omUsrRevisao = null;
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(dao.getSession());

		try {
			omUsrStAtivo = usuarioRN.getOmUsr(this.getOmUsrByIdUsrstativo().getIdUsr());

			if (omUsrStAtivo == null) {
				resultado.setIdmensagem(Integer.valueOf(
						resultado.USUARIO_DESCONHECIDO).intValue());
				return retorno;
			}
		} catch (Exception e) {
			resultado.setIdmensagem(Integer.valueOf(
					resultado.USUARIO_DESCONHECIDO).intValue());
			return retorno;
		}

		try {
			omUsrRevisao = usuarioRN.getOmUsr(this.getOmUsrByIdUsrstativo().getIdUsr());

			if (omUsrRevisao == null) {
				resultado.setIdmensagem(Integer.valueOf(
						resultado.USUARIO_DESCONHECIDO).intValue());
				return retorno;

			}
		} catch (Exception e) {
			resultado.setIdmensagem(Integer.valueOf(
					resultado.USUARIO_DESCONHECIDO).intValue());
			return retorno;
		}

		planoNovo.setOmUsrByIdUsrstativo(omUsrStAtivo);
		planoNovo.setOmUsrByIdUsrrevisao(omUsrRevisao);

		//AJEITANTO CPs
		planoNovo.setPpCps(new HashSet<PpCp>());
		PpCp ppcp = null;
		for(PpCp cp : plano.getPpCps()) {
			if(cp.getIdCp() == null) {
				ppcp = criaNovaCp(cp);
			}
			else {
				ppcp = criaNovaCpTransferindoFilhos(cp.getIdCp());
			}
			
			ppcp.setPpPlano(planoNovo);
			
			planoNovo.getPpCps().add(ppcp);
		}
//		planoNovo.setPpCps(new HashSet<PpCp>());
//		for (PpCp cp : plano.getPpCps()) {
//			PpCp ppcp = pesquisarCpsById(cp);
//			
//			if (ppcp == null) {
//				resultado.setIdmensagem(resultado.CP_DESCONHECIDA);
//				return retorno;
//			}
//			planoNovo.getPpCps().add(ppcp);
//		}
		//FIM AJEITANDO CPs

		planoNovo.setPpPlanptgts(null);

		planoNovo.setPpPlancols(null);

		// pegar planecs
		planoNovo.setPpPlanecs(new HashSet<PpPlanec>());
		for (PpPlanec planec : ppplano.getPpPlanecs()) {
			planec.setPpPlano(planoNovo);
			planoNovo.getPpPlanecs().add(planec);
		}

		// pegar PpTpPlano
		PpTpplano tpPlano = ppplano.getPpTpplano();
		tpPlano.getPpPlanos().remove(ppplano);
		tpPlano.getPpPlanos().add(planoNovo);
		planoNovo.setPpTpplano(tpPlano);

		planoNovo = this.dao.makePersistent(planoNovo);

//		for (PpCp cp : plano.getPpCps()) {
//			ppcp = pesquisarCpsById(cp);
//
//			if (ppcp == null) {
//				resultado.setIdmensagem(resultado.CP_DESCONHECIDA);
//				return retorno;
//			}
//			ppcp.setPpPlano(planoNovo);
//			this.dao.makePersistent(ppcp);
//		}

		if ((plano.getPpPlanptgts() != null)
				&& (!plano.getPpPlanptgts().isEmpty())) {
			planoNovo.setPpPlanptgts(new HashSet<PpPlanptgt>());
			// List<PpPlanptgt> listaPtgt = new ArrayList<PpPlanptgt>();
			for (PpPlanptgt ptgt : plano.getPpPlanptgts()) {
				OmPt ompt = null;
				OmGt omgt = null;
				if (ptgt.getOmPt() != null) {
					ompt = pesquisarOmPtById(ptgt.getOmPt());
					if (ompt == null) {
						resultado.setIdmensagem(resultado.PT_DESCONHECIDO);
						return retorno;
					}
				} else {
					omgt = pesquisarOmGtById(ptgt.getOmGt());
					if(omgt == null) {
						resultado.setIdmensagem(resultado.ERROR_GT_DESCONHECIDO);
						return retorno;
					}
				}

				PpPlanptgt planPtgt = new PpPlanptgt();
				planPtgt.setColuna(ptgt.getColuna());
				planPtgt.setLinha(ptgt.getLinha());
				planPtgt.setOmPt(ompt);
				planPtgt.setOmGt(omgt);
				planPtgt.setPpPlano(planoNovo);

				planoNovo.getPpPlanptgts().add(planPtgt);
			}
		}

		if ((plano.getPpPlancols() != null)
				&& (!plano.getPpPlancols().isEmpty())) {
			planoNovo.setPpPlancols(new HashSet<PpPlancol>());
			for (PpPlancol plancol : plano.getPpPlancols()) {
				plancol.setPpPlano(planoNovo);
				// this.dao.makePersistent(plancol);
				planoNovo.getPpPlancols().add(plancol);
			}
		}

		this.dao.makePersistent(planoNovo);

		resultado.setIdmensagem(resultado.COM_SUCESSO);

		return retorno;
	}
	
	private PpCp criaNovaCpTransferindoFilhos(Long idCp) {
		PpCp retorno = null;
		
		MapQuery q = new MapQuery(this.dao.getSession());
		
		q.append("select distinct ppcp from PpCp ppcp");
		q.append("left join fetch ppcp.dwCal dwcal");
		q.append("left join fetch ppcp.dwFolha dwfolha");
		q.append("left join fetch ppcp.dwRota dwrota");
		q.append("left join fetch ppcp.omGt omgt");
		q.append("left join fetch ppcp.omPt ompt");
		q.append("left join fetch ppcp.ppCliente ppcliente");
		q.append("left join fetch ppcp.omUsrByIdUsrstativo usrstativo");
		q.append("left join fetch ppcp.omUsrByIdUsrrevisao usrrevisao");
		q.append("left join fetch ppcp.dwEst dwest");
		q.append("left join fetch ppcp.dwConsolids dwconsolid");
		q.append("left join fetch ppcp.ppCpPresForIdCp cppres");
		q.append("left join fetch ppcp.ppCpPresForIdCppredecessora cpprespredecessora");
		q.append("left join fetch ppcp.ppCpneccrons neccrons");
		q.append("left join fetch ppcp.ppCpprodutos ppcpprod");
		
		q.appendWhere(MapQuery._NULL, "ppcp.idCp = :idcp", ((idCp != null) && (idCp > 0)));
		
		q.defineParametro("idcp", idCp);
		q.setMaxResults(1);
		PpCp ppcp = (PpCp) q.uniqueResult();
		
		retorno = ppcp.clone(false);
		retorno.setIdCp(null);
		retorno.setDwCal(ppcp.getDwCal());
		retorno.setDwFolha(ppcp.getDwFolha());
		retorno.setDwRota(ppcp.getDwRota());
		retorno.setOmPt(ppcp.getOmPt());
		retorno.setOmGt(ppcp.getOmGt());
		retorno.setPpCliente(ppcp.getPpCliente());
		retorno.setOmUsrByIdUsrstativo(ppcp.getOmUsrByIdUsrstativo());
		retorno.setOmUsrByIdUsrrevisao(ppcp.getOmUsrByIdUsrrevisao());
		retorno.setDwEst(ppcp.getDwEst());
		retorno.setDwConsolids(null);
		retorno.setPpCpPresForIdCp(ppcp.getPpCpPresForIdCp());
		retorno.setPpCpPresForIdCppredecessora(ppcp.getPpCpPresForIdCppredecessora());
		
		retorno.setPpCpPresForIdCp(new HashSet<PpCpPre>());
		for(PpCpPre pre : ppcp.getPpCpPresForIdCp()) {
			PpCpPre ppCpPre = new PpCpPre();
			ppCpPre.setIdCppre(null);
			ppCpPre.setPpCpByIdCp(pre.getPpCpByIdCp());
			ppCpPre.setPpCpByIdCppredecessora(pre.getPpCpByIdCppredecessora());
			
			retorno.getPpCpPresForIdCp().add(ppCpPre);
		}
		
		retorno.setPpCpPresForIdCppredecessora(new HashSet<PpCpPre>());
		for(PpCpPre pre : ppcp.getPpCpPresForIdCppredecessora()) {
			PpCpPre ppCpPre = new PpCpPre();
			ppCpPre.setIdCppre(null);
			ppCpPre.setPpCpByIdCp(pre.getPpCpByIdCppredecessora());
			ppCpPre.setPpCpByIdCppredecessora(pre.getPpCpByIdCppredecessora());
			
			retorno.getPpCpPresForIdCppredecessora().add(ppCpPre);
		}
		
		retorno.setPpCpneccrons(new HashSet<PpCpneccron>());
		for(PpCpneccron neccron : ppcp.getPpCpneccrons()) {
			PpCpneccron cpNeccron = new PpCpneccron();
			cpNeccron.setIdCpneccron(null);
			cpNeccron.setQtAtendida(neccron.getQtAtendida());
			cpNeccron.setPpPlaneccron(neccron.getPpPlaneccron());
			cpNeccron.setPpCp(retorno);
			
			retorno.getPpCpneccrons().add(cpNeccron);
		}
		
		retorno.setPpCpprodutos(new HashSet<PpCpproduto>());
		for(PpCpproduto ppcpprod : ppcp.getPpCpprodutos()) {
			PpCpproduto cpProduto = ppcpprod.clone(false);
			cpProduto.setIdCpproduto(null);
			cpProduto.setOmProduto(ppcpprod.getOmProduto());
			cpProduto.setPpCp(retorno);
			
			cpProduto.setPpCpDatas(new HashSet<PpCpData>());
			for(PpCpData data : ppcpprod.getPpCpDatas()) {
				PpCpData cpData = data.clone(false);
				cpData.setIdCpData(null);
				cpData.setPpCpproduto(cpProduto);
				
				cpData.setPpCpTurnos(new HashSet<PpCpTurno>());
				for(PpCpTurno turno : data.getPpCpTurnos()) {
					PpCpTurno cpTurno = turno.clone(false);
					cpTurno.setIdCpTurno(null);
					cpTurno.setDwCalavu(turno.getDwCalavu());
					cpTurno.setDwTurno(turno.getDwTurno());
					cpTurno.setPpCpHoras(null);
					cpTurno.setPpCpData(cpData);
					
					cpData.getPpCpTurnos().add(cpTurno);
				}
				
				cpProduto.getPpCpDatas().add(cpData);
			}
			
			retorno.getPpCpprodutos().add(cpProduto);
		}
		
		return retorno;
	}
	
	private PpCp criaNovaCp(PpCp cp) {
		PpCp retorno = new PpCp();
		
		retorno = cp.clone(false);
		retorno.setIdCp(null);
		
		DwCal dwcal = cp.getDwCal();
		if(dwcal != null) {
			dwcal = pesquisarDwCalById(cp.getDwCal());
		}
		retorno.setDwCal(dwcal);
		
		retorno.setDwConsolids(null);
		
		DwEst dwest = cp.getDwEst();
		if(dwest != null) {
			dwest = pesquisarDwEstById(cp.getDwEst());
		}
		retorno.setDwEst(dwest);
		
		DwFolha dwfolha = cp.getDwFolha();
		if(dwfolha != null) {
			dwfolha = pesquisarDwFolhaById(cp.getDwFolha());
		}
		retorno.setDwFolha(dwfolha);
		
		DwRota dwrota = cp.getDwRota();
		if(dwrota != null) {
			dwrota = pesquisarDwRotaById(cp.getDwRota());
		}
		retorno.setDwRota(dwrota);
		
		OmPt ompt = cp.getOmPt();
		if(ompt != null) {
			ompt = pesquisarOmPtById(cp.getOmPt());
		}
		retorno.setOmPt(ompt);
		
		OmGt omgt = cp.getOmGt();
		if(omgt != null) {
			omgt = pesquisarOmGtById(cp.getOmGt());
		}
		retorno.setOmGt(omgt);
		
		OmUsr usr = cp.getOmUsrByIdUsrrevisao();
		if(usr != null) {
			usr = pesquisarOmUsrByIdUsrrevisao(cp.getOmUsrByIdUsrrevisao());
		}
		retorno.setOmUsrByIdUsrrevisao(usr);
		
		usr = cp.getOmUsrByIdUsrstativo();
		if(usr != null) {
			usr = pesquisarOmUsrByIdUsrstativo(cp.getOmUsrByIdUsrstativo());
		}
		retorno.setOmUsrByIdUsrstativo(usr);
		
		PpCliente cliente = cp.getPpCliente();
		if(cliente != null) {
			cliente = pesquisarPpClienteById(cliente);
		}
		retorno.setPpCliente(cliente);
		
		Set<PpCpneccron> cpneccrons = cp.getPpCpneccrons();
		if(cpneccrons != null) {
			cpneccrons = gerarPpCpneccronsNovos(cp.getPpCpneccrons(), retorno);
		}
		retorno.setPpCpneccrons(cpneccrons);
		
		retorno.setPpCpPresForIdCp(cp.getPpCpPresForIdCp());
		retorno.setPpCpPresForIdCppredecessora(cp.getPpCpPresForIdCppredecessora());
		
		Set<PpCpproduto> cpprodutos = cp.getPpCpprodutos();
		if(cpprodutos != null) {
			cpprodutos = gerarPpCpprodutosNovos(cp.getPpCpprodutos(), retorno);
		}
		retorno.setPpCpprodutos(cpprodutos);
		
		return retorno;
	}
	
	private Set<PpCpproduto> gerarPpCpprodutosNovos(Set<PpCpproduto> cpprodutos, PpCp cp) {
		Set<PpCpproduto> retorno = new HashSet<PpCpproduto>();
		
		MapQuery q = new MapQuery(this.dao.getSession());
		q.append("select ppcpprod from PpCpproduto ppcpprod");
		q.appendWhere(MapQuery._NULL, "ppcpprod.idCpproduto = :idcpprod", true);
		q.setMaxResults(1);
		
		for(PpCpproduto cpproduto : cpprodutos) {
			q.defineParametro("idcpprod", cpproduto.getIdCpproduto());
			PpCpproduto cpProduto = (PpCpproduto) q.uniqueResult();
			
			if(cpProduto != null) {
				PpCpproduto ppCpProduto = cpProduto.clone(false);
				ppCpProduto.setIdCpproduto(null);
				ppCpProduto.setOmProduto(cpProduto.getOmProduto());
				ppCpProduto.setPpCp(cp);
				
				ppCpProduto.setPpCpDatas(null);
				if((cpproduto.getPpCpDatas() != null) && (!cpproduto.getPpCpDatas().isEmpty())) {
					ppCpProduto.setPpCpDatas(new HashSet<PpCpData>());
					ppCpProduto.setPpCpDatas(gerarPpCpdataNovos(cpproduto.getPpCpDatas(), ppCpProduto));
				}
				
				retorno.add(ppCpProduto);
			}
		}
		
		return retorno;
	}
	
	private Set<PpCpData> gerarPpCpdataNovos(Set<PpCpData> cpdatas, PpCpproduto cpProduto) {
		Set<PpCpData> retorno = new HashSet<PpCpData>();
		
		MapQuery q = new MapQuery(this.dao.getSession());
		q.append("select cpdata from PpCpData cpdata");
		q.appendWhere(MapQuery._NULL, "cpdata.idCpData = :iddata", true);
		q.setMaxResults(1);
		
		for(PpCpData data : cpdatas) {
			q.defineParametro("iddata", data.getIdCpData());
			
			PpCpData cpData = (PpCpData) q.uniqueResult();
			
			if(cpData != null) {
				PpCpData ppCpData = cpData.clone(false);
				ppCpData.setIdCpData(null);
				ppCpData.setPpCpproduto(cpProduto);
				
				ppCpData.setPpCpTurnos(null);
				if((data.getPpCpTurnos() != null) && (!data.getPpCpTurnos().isEmpty())) {
					ppCpData.setPpCpTurnos(new HashSet<PpCpTurno>());
					ppCpData.setPpCpTurnos(gerarPpCpturnoNovos(data.getPpCpTurnos(), ppCpData));
				}
				
				retorno.add(ppCpData);
			}
		}
		
		return retorno;
	}
	
	private Set<PpCpTurno> gerarPpCpturnoNovos(Set<PpCpTurno> cpturnos, PpCpData cpdata) {
		Set<PpCpTurno> retorno = new HashSet<PpCpTurno>();
		
		MapQuery q = new MapQuery(this.dao.getSession());
		q.append("select turno from PpCpTurno turno");
		q.append("left join fetch turno.dwCalavu dwcalavu");
		q.append("left join fetch turno.dwTurno dwturno");
		
		q.appendWhere(MapQuery._NULL, "turno.idCpTurno = :idturno", true);
		q.setMaxResults(1);
		
		for(PpCpTurno turno : cpturnos) {
			q.defineParametro("idturno", turno.getIdCpTurno());
			PpCpTurno cpTurno = (PpCpTurno)q.uniqueResult();
			
			if(cpTurno != null) {
				PpCpTurno ppCpTurno = (PpCpTurno)cpTurno.clone(false);
				ppCpTurno.setIdCpTurno(null);
				ppCpTurno.setPpCpHoras(null);
				ppCpTurno.setPpCpData(cpdata);
				ppCpTurno.setDwCalavu(cpTurno.getDwCalavu());
				ppCpTurno.setDwTurno(cpTurno.getDwTurno());
				
				if (cpTurno.getDwTurno() == null)
					//System.out.println("deb2");
				retorno.add(ppCpTurno);
			}
		}
		
		return retorno;
	}
	
	private Set<PpCpneccron> gerarPpCpneccronsNovos(Set<PpCpneccron> cpneccrons, PpCp cp) {
		Set<PpCpneccron> retorno = new HashSet<PpCpneccron>();
		
		MapQuery q = new MapQuery(this.dao.getSession());
		q.append("select cpneccron from PpCpneccron cpneccron");
		q.append("left join fetch cpneccron.ppPlaneccron planecron");
		q.appendWhere(MapQuery._NULL, "cpneccron = :idcpneccron", true);
		q.setMaxResults(1);
		
		for(PpCpneccron cpneccron : cpneccrons) {
			q.defineParametro("idcpneccron", cpneccron.getIdCpneccron());
			
			PpCpneccron cpNeccron = (PpCpneccron) q.uniqueResult();
			
			if(cpNeccron != null) {
				PpCpneccron ppCpNeccron = cpNeccron.clone();
				ppCpNeccron.setIdCpneccron(null);
				ppCpNeccron.setPpCp(cp);
				ppCpNeccron.setPpPlaneccron(cpNeccron.getPpPlaneccron());
				
				retorno.add(ppCpNeccron);
			}
		}
		
		return retorno;
	}
	
	private PpCliente pesquisarPpClienteById(PpCliente cliente) {
		MapQuery q = new MapQuery(this.dao.getSession());
		q.append("select cliente from PpCliente cliente");
		q.appendWhere(MapQuery._NULL, "cliente.idCliente = :idcliente", ((cliente.getIdCliente() != null) && (cliente.getIdCliente() > 0)));
		
		q.defineParametro("idcliente", cliente.getIdCliente());
		
		q.setMaxResults(1);
		return (PpCliente)q.uniqueResult();
	}
	
	private OmUsr pesquisarOmUsrByIdUsrstativo(OmUsr omusr) {
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(this.dao.getSession());

		return usuarioRN.getOmUsr(omusr.getOmUsrByIdUsrstativo().getIdUsr());
	}
	
	private OmUsr pesquisarOmUsrByIdUsrrevisao(OmUsr omusr) {
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(this.dao.getSession());

		return usuarioRN.getOmUsr(omusr.getOmUsrByIdUsrrevisao().getIdUsr());
	}
	
	private DwRota pesquisarDwRotaById(DwRota dwrota) {
		MapQuery q = new MapQuery(this.dao.getSession());
		q.append("select dwrota from DwRota dwrota");
		q.appendWhere(MapQuery._NULL, "dwrota.idRota = :iddwrota", (dwrota.getIdRota() > 0));
		
		q.defineParametro("iddwrota", dwrota.getIdRota());
		
		q.setMaxResults(1);
		return (DwRota)q.uniqueResult();
	}
	
	private DwFolha pesquisarDwFolhaById(DwFolha dwfolha) {
		MapQuery q = new MapQuery(this.dao.getSession());
		q.append("select dwfolha from DwFolha dwfolha");
		q.appendWhere(MapQuery._NULL, "dwfolha.idFolha = :iddwfolha", ((dwfolha.getIdFolha() != null) && (dwfolha.getIdFolha() > 0)));
		
		q.defineParametro("iddwfolha", dwfolha.getIdFolha());
		
		q.setMaxResults(1);
		return (DwFolha)q.uniqueResult();
	}
	
	private DwEst pesquisarDwEstById(DwEst dwest) {
		MapQuery q = new MapQuery(this.dao.getSession());
		q.append("select dwest from DwEst dwest");
		q.appendWhere(MapQuery._NULL, "dwest.idEst = :idest", (dwest.getIdEst() > 0));
		
		q.defineParametro("idcal", dwest.getIdEst());
		
		q.setMaxResults(1);
		return (DwEst)q.uniqueResult();
	}
	
	private DwCal pesquisarDwCalById(DwCal dwcal) {
		MapQuery q = new MapQuery(this.dao.getSession());
		q.append("select dwcal from DwCal dwcal");
		q.appendWhere(MapQuery._NULL, "dwcal.idCal = :idcal", (dwcal.getIdCal() > 0));
		
		q.defineParametro("idcal", dwcal.getIdCal());
		
		q.setMaxResults(1);
		return (DwCal)q.uniqueResult();
	}
	
	private OmPt pesquisarOmPtById(OmPt ompt) {
		MapQuery q = new MapQuery(this.dao.getSession());
		q.append("select ompt from OmPt ompt");
		q.appendWhere(MapQuery._NULL, "ompt.idPt = :idpt",
				((ompt.getIdPt() != null) && (ompt.getIdPt() > 0)));
		q.defineParametro("idpt", ompt.getIdPt());

		q.setMaxResults(1);
		return (OmPt) q.uniqueResult();
	}

	private OmGt pesquisarOmGtById(OmGt omgt) {
		MapQuery q = new MapQuery(this.dao.getSession());
		q.append("select omgt from OmGt omgt");
		q.appendWhere(MapQuery._NULL, "omgt.idGt = :idgt",
				((omgt.getIdGt() != null) && (omgt.getIdGt() > 0)));
		q.defineParametro("idgt", omgt.getIdGt());

		q.setMaxResults(1);
		return (OmGt) q.uniqueResult();
	}

	public PlanoDTO excluirRegistroById() {
		PlanoDTO retorno = new PlanoDTO();
		ResultadoDTO resultado = new ResultadoDTO();
		retorno.setResultadoDTO(resultado);

		PpPlano plano = pesquisarPlanoById();
		if (plano == null) {
			resultado.setIdmensagem(resultado.PLANO_DESCONHECIDO);
			return retorno;
		}

		plano.setStAtivo(0);

		Date date = new Date();
		plano.setDtStativo(date);

		// pesquisa o Usuario do stativo
		OmUsr omUsrStAtivo = null;
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(dao.getSession());

		try {
			omUsrStAtivo = usuarioRN.getOmUsr(this.getOmUsrByIdUsrstativo().getIdUsr());

			if (omUsrStAtivo == null) {
				resultado.setIdmensagem(Integer.valueOf(
						resultado.USUARIO_DESCONHECIDO).intValue());
				return retorno;
			}
		} catch (Exception e) {
			resultado.setIdmensagem(Integer.valueOf(
					resultado.USUARIO_DESCONHECIDO).intValue());
			return retorno;
		}
		plano.setOmUsrByIdUsrstativo(omUsrStAtivo);

		this.dao.makePersistent(plano);

		resultado.setIdmensagem(resultado.COM_SUCESSO);

		return retorno;
	}

	private PpPlano pesquisarPlanoById() {
		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select plano from PpPlano plano");
		q.appendWhere(MapQuery._NULL, "plano.idPlano = :idplano",
				((this.getIdPlano() != null) && (this.getIdPlano() > 0)));
		q.defineParametro("idplano", this.getIdPlano());

		q.setMaxResults(1);

		return (PpPlano) q.uniqueResult();
	}

	public PpPlano pesquisarPlanoByCdESt(PlanoDTO plano) {
		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select plano from PpPlano plano");
		q.appendWhere(
				MapQuery._NULL,
				"plano.cdPlano = :cdplano",
				((plano.getCdPlano() != null) && (!plano.getCdPlano().isEmpty())));
		q.appendWhere(MapQuery._AND, "plano.stAtivo=1", true);
		q.defineParametro("cdplano", plano.getCdPlano());

		q.setMaxResults(1);

		return (PpPlano) q.uniqueResult();
	}

}
