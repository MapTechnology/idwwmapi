package idw.model.rn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwConsolallogDAO;
import idw.model.dao.DwConsolptDAO;
import idw.model.dao.DwEstlocalDAO;
import idw.model.dao.DwProcedimentoDAO;
import idw.model.dao.MapQuery;
import idw.model.dao.OmPaDAO;
import idw.model.dao.OmPrgDAO;
import idw.model.dao.OmProdutoDAO;
import idw.model.dao.OmUsrDAO;
import idw.model.dao.PpClienteDAO;
import idw.model.dao.PpNecDAO;
import idw.model.excessoes.CicloJaContabilizadoException;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.ReprocessarMsEvtException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemConfiguracaoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolallog;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstlocal;
import idw.model.pojos.DwExpcvs;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhateste;
import idw.model.pojos.DwFtEtapa;
import idw.model.pojos.DwFtParam;
import idw.model.pojos.DwFtSub;
import idw.model.pojos.DwGrpativ;
import idw.model.pojos.DwMacrange;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwProcedimento;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwRota;
import idw.model.pojos.DwRt;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.DwTAlerta;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.DwTDefeito;
import idw.model.pojos.DwTParada;
import idw.model.pojos.DwTRefugo;
import idw.model.pojos.DwTRitmo;
import idw.model.pojos.DwTestesub;
import idw.model.pojos.DwTurno;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmAlgocor;
import idw.model.pojos.OmCargo;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgabc;
import idw.model.pojos.OmCfgscrpimp;
import idw.model.pojos.OmEmpresa;
import idw.model.pojos.OmFor;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmImg;
import idw.model.pojos.OmJob;
import idw.model.pojos.OmMapa;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmPrg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmRegrasNscb;
import idw.model.pojos.OmResgui;
import idw.model.pojos.OmTexto;
import idw.model.pojos.OmTpgt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUnidmedida;
import idw.model.pojos.OmUsr;
import idw.model.pojos.OmUsrgrp;
import idw.model.pojos.PpCliente;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.PpNec;
import idw.model.pojos.template.DwEstlocalTemplate;
import idw.model.pojos.template.DwMacrangeTemplate;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.model.rn.consolidacao.EventoInvalidoException;
import idw.model.rn.consolidacao.alerta.ConsolidacaoFimAlerta; 
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.EtiquetaDTO;
import idw.webservices.dto.EtiquetasDTO;
import idw.webservices.dto.GTsDTO;
import idw.webservices.dto.GtDTO;
import idw.webservices.dto.ListaPeproDTO;
import idw.webservices.dto.MapaAlimentacaoDTO;
import idw.webservices.dto.MapasAlimentacaoDTO;
import idw.webservices.dto.PAsDTO;
import idw.webservices.dto.PTsDTO;
import idw.webservices.dto.PaDTO;
import idw.webservices.dto.PassagensDTO;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasDTO;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.dto.ProdutosDTO;
import idw.webservices.dto.PtDTO;
import idw.webservices.rest.ColetaFacade;
import idw.webservices.rest.dto.CodigoDescricaoDTO;
import idw.webservices.rest.dto.DadosTempoRealDTO;
import injetws.model.excessoes.SemSGBDException;
import ms.util.ConversaoTipos;

@SuppressWarnings("unchecked")
public class DiversosRN extends DAOGenerico {

	public PesquisasDTO pesquisaTurno(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from DwTurno t ";
		hql += "where t.stAtivo=1 ";

		if (pesquisa.getCodigo() != null && pesquisa.getDescricao() != null
				&& !pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdTurno = '::cdTurno' or t.dsTurno = '::dsTurno' )";
		} else if (pesquisa.getCodigo() != null
				&& !pesquisa.getCodigo().equals("")) {
			hql += "and t.cdTurno = '::cdTurno' ";
		} else if (pesquisa.getDescricao() != null
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and t.dsTurno = '::dsTurno' ";
		}

		hql = hql.replaceAll("::cdTurno", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsTurno", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<DwTurno> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwTurno item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdTurno());
				itemDTO.setDescricao(item.getDsTurno());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaCliente(PesquisaDTO pesquisa) {
		PpClienteDAO clienteDAO = new PpClienteDAO(getSession());
		List<PpCliente> lista;
		if(pesquisa.getRegistro() != null) {
			PpNec pedido = (PpNec) pesquisa.getRegistro();
			lista = clienteDAO.getPpClienteAtivoPorCdNmOuPedido(pesquisa.getCodigo(), pesquisa.getDescricao(), pedido.getIdNec());
		}else{
			lista = clienteDAO.getPpClienteAtivoPorCdOuNm(pesquisa.getCodigo(), pesquisa.getDescricao());
		}
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();
		if (lista != null) {
			for (PpCliente item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdCliente());
				itemDTO.setDescricao(item.getNmCliente());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}

	public PesquisasDTO pesquisaUnidadeMedida(PesquisaDTO pesquisa){
		String hql = "";

		hql += "select t ";
		hql += "from OmUnidmedida t ";
		hql += "where t.stAtivo=1 ";

		if (pesquisa.getCodigo() != null && pesquisa.getDescricao() != null
				&& !pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdUnidmedida = '::cdUnidmedida' or t.dsUnidmedida = '::dsUnidmedida' )";
		} else if (pesquisa.getCodigo() != null
				&& !pesquisa.getCodigo().equals("")) {
			hql += "and t.cdUnidmedida = '::cdUnidmedida' ";
		} else if (pesquisa.getDescricao() != null
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and t.dsUnidmedida = '::dsUnidmedida' ";
		}

		hql = hql.replaceAll("::cdUnidmedida", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsUnidmedida", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<OmUnidmedida> listaUnidmedida = null;

		try{
			listaUnidmedida = q.list();
		}catch(Exception e){
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (listaUnidmedida != null) {
			for (OmUnidmedida item : listaUnidmedida) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdUnidmedida());
				itemDTO.setDescricao(item.getDsUnidmedida());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);

		return pesquisas;
	}

	public PesquisasDTO pesquisaFiltro(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from DwExpcvs t ";

		if (pesquisa.getCodigo() != null && pesquisa.getDescricao() != null
				&& !pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdExpcvs = '::cdExpcvs' or t.dsExpcvs= '::dsExpcvs' )";
		} else if (pesquisa.getCodigo() != null
				&& !pesquisa.getCodigo().equals("")) {
			hql += "and t.cdExpcvs= '::cdExpcvs' ";
		} else if (pesquisa.getDescricao() != null
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and t.dsExpcvs = '::dsExpcvs' ";
		}

		hql = hql.replaceAll("::cdExpcvs", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsExpcvs", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<DwExpcvs> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwExpcvs item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdExpcvs());
				itemDTO.setDescricao(item.getDsExpcvs());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaDwTDefeito(PesquisaDTO pesquisa) {

		MapQuery q = new MapQuery(getSession());
		q.append("select t ");
		q.append("from DwTDefeito t ");
		q.append("where t.stAtivo=1 ");

		if (pesquisa.getCodigo() != null && pesquisa.getDescricao() != null && !pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			q.append("and ( t.cdTdefeito = :cdTdefeito or t.dsTdefeito = :dsTdefeito )");
		} else if (pesquisa.getCodigo() != null && !pesquisa.getCodigo().equals("")) {
			q.append("and t.cdTdefeito = :cdTdefeito ");
		} else if (pesquisa.getDescricao() != null && !pesquisa.getDescricao().equals("")) {
			q.append("and t.dsTdefeito = :dsTdefeito ");
		}
		if (pesquisa.getRegistro() instanceof OmTppt) {
			q.append("and t.omTppt = :omtppt");
			q.defineParametro("omtppt", (OmTppt) pesquisa.getRegistro());
		}

		q.defineParametro("cdTdefeito", pesquisa.getCodigo());
		q.defineParametro("dsTdefeito", pesquisa.getDescricao());

		List<DwTDefeito> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwTDefeito item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdTdefeito());
				itemDTO.setDescricao(item.getDsTdefeito());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaDwTAcao(PesquisaDTO pesquisa) {

		MapQuery q = new MapQuery(getSession());
		
		q.append("select t ");
		q.append("from DwTAcao t ");
		q.append("where t.stAtivo=1 ");

		if (pesquisa.getCodigo() != null && pesquisa.getDescricao() != null && !pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			q.append("and ( t.cdTacao = :cdTacao or t.dsTacao = :dsTacao )");
		} else if (pesquisa.getCodigo() != null && !pesquisa.getCodigo().equals("")) {
			q.append("and t.cdTacao = :cdTacao ");
		} else if (pesquisa.getDescricao() != null && !pesquisa.getDescricao().equals("")) {
			q.append("and t.dsTacao = :dsTacao ");
		}
		if (pesquisa.getRegistro() instanceof OmTppt) {
			q.append("and t.omTppt = :omtppt");
			q.defineParametro("omtppt", (OmTppt) pesquisa.getRegistro() ); 
		}

		q.defineParametro("cdTacao", pesquisa.getCodigo());
		q.defineParametro("dsTacao", pesquisa.getDescricao());

		List<DwTAcao> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwTAcao item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdTacao());
				itemDTO.setDescricao(item.getDsTacao());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaEtapa(PesquisaDTO pesquisa) {

		StringBuilder hql = new StringBuilder();
		hql.append("select distinct t ");
		hql.append("from DwFtEtapa t ");
		hql.append("join fetch t.dwFtSubs dwftsub ");
		hql.append("join fetch dwftsub.dwTestesubs dwtestesub ");
		hql.append("join fetch dwtestesub.dwFolhateste dwfolhateste ");
		hql.append("join fetch dwfolhateste.dwFolha dwfolha ");
		hql.append("where t.stAtivo=1 ");

		if (pesquisa.getCodigo() != null && pesquisa.getDescricao() != null
				&& !pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql.append("and ( t.cdEtapa = :cdEtapa or t.dsEtapa = :dsEtapa )");
		} else if (pesquisa.getCodigo() != null
				&& !pesquisa.getCodigo().equals("")) {
			hql.append("and t.cdEtapa = :cdEtapa ");
		} else if (pesquisa.getDescricao() != null
				&& !pesquisa.getDescricao().equals("")) {
			hql.append("and t.dsEtapa = :dsEtapa ");
		}

		MapQuery q = new MapQuery(getSession().createQuery(hql.toString()));

		q.defineParametro("cdEtapa", pesquisa.getCodigo());
		q.defineParametro("dsEtapa", pesquisa.getDescricao());

		List<DwFtEtapa> lista = null;
		try {
			lista = q.query().list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwFtEtapa item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				for (DwFtSub dwftsub : item.getDwFtSubs()) {
					for (DwTestesub dwtestesub : dwftsub.getDwTestesubs()) {
						itemDTO.setCodigo(dwtestesub.getDwFolhateste()
								.getDwFolha().getCdFolha()); // + "/" +
																// dwtestesub.getOrdemEtapa());
					}
				}

				itemDTO.setDescricao(item.getDsEtapa());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaDwFolha(PesquisaDTO pesquisa) {

		MapQuery q = new MapQuery(getSession());
		
		q.append("select t ");
		q.append("from DwFolha t ");
		q.append("join t.omGt omgt ");
		q.append("left join t.dwFolhatestes dwfolhateste ");
		q.append("left join dwfolhateste.omProduto omproduto ");
		q.append("where t.stAtivo=1 ");

		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			q.append("and ( t.cdFolha like :cdFolha or t.dsFolha = :dsFolha )");
		} else if (!pesquisa.getCodigo().equals("")) {
			q.append("and t.cdFolha like :cdFolha ");
		} else if (!pesquisa.getDescricao().equals("")) {
			q.append("and t.dsFolha = :dsFolha ");
		} else if (pesquisa.getRegistro() != null) {
			OmGt omgt = ((DwFolha) pesquisa.getRegistro()).getOmGt();
			q.append("and omgt.cdGt = :cdgt and omgt.stAtivo = 1 ");
			q.defineParametro("cdgt", omgt.getCdGt());

			OmProduto omproduto = null;
			for (DwFolhateste dwfolhateste : ((DwFolha) pesquisa.getRegistro()).getDwFolhatestes()) {
				omproduto = dwfolhateste.getOmProduto();
			}
			if (omproduto != null && !omproduto.getCdProduto().equals("")) {
				q.append("and (omproduto.cdProduto = :cdproduto or omproduto.cdProduto is null) ");
				q.defineParametro("cdproduto", omproduto.getCdProduto());
			}
		}

		q.defineParametro("cdFolha", "%" + pesquisa.getCodigo() + "%");
		q.defineParametro("dsFolha", pesquisa.getDescricao());

		q.setMaxResults(50);

		List<DwFolha> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwFolha item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdFolha());
				itemDTO.setDescricao(item.getDsFolha());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaDwFolhaTesteFuncional(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select distinct t ";
		hql += "from DwFolha t ";
		// hql += "join fetch t.dwFolhatestes dwfolhateste ";
		// hql += "join fetch dwfolhateste.dwTestesubs dwtestesub ";
		// hql += "join fetch dwtestesub.dwTestesubetapas dwtestesubetapa ";
		// hql += "join fetch dwtestesub.dwFtSub dwftsub ";
		// hql += "join fetch dwftsub.dwFtEtapa dwftetapa ";
		// hql += "join t.omGt omgt ";
		hql += "where t.stAtivo=1 and t.tpFolha = 0 and t.isModelo = false ";

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdFolha = '::cdFolha' or t.dsFolha = '::dsFolha' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdFolha = '::cdFolha' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsFolha = '::dsFolha' ";
		} else if (pesquisa.getRegistro() != null) {
			OmGt omgt = ((DwFolha) pesquisa.getRegistro()).getOmGt();
			hql += "and omgt.cdGt = '::cdgt' and omgt.stAtivo = 1 ";
			hql = hql.replaceAll("::cdgt", omgt.getCdGt());
		}

		hql = hql.replaceAll("::cdFolha", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsFolha", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<DwFolha> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwFolha item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdFolha());
				itemDTO.setDescricao(item.getDsFolha());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaDwEst(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from DwEst t ";
		hql += "where t.stAtivo=1 ";

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdEst = '::cdEst' or t.dsEst = '::dsEst' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdEst = '::cdEst' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsEst = '::dsEst' ";
		}

		hql = hql.replaceAll("::cdEst", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsEst", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<DwEst> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwEst item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdEst());
				itemDTO.setDescricao(item.getDsEst());
				itemDTO.setRegistro(item.clone(false));
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaDwEstlocal(PesquisaDTO pesquisa) {
		DwEstlocalDAO dao = new DwEstlocalDAO(getSession());
		List<DwEstlocal> lista = dao.getDwEstLocals(pesquisa.getCodigo(), pesquisa.getDescricao(), null);

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwEstlocal item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdLocal());
				itemDTO.setDescricao(item.getDsLocal());
				itemDTO.setRegistro(item.clone(false));
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO retorno = new PesquisasDTO();
		retorno.setPesquisa(listaDTO);
		return retorno;
	}

	public PesquisasDTO pesquisaDwEstlocalDesalimentacao(PesquisaDTO pesquisa) {
		DwEstlocalDAO dao = new DwEstlocalDAO(getSession());
		List<DwEstlocal> lista = dao.getDwEstLocals(pesquisa.getCodigo(), pesquisa.getDescricao(), DwEstlocalTemplate.TpLocalEstoque.DESALIMENTACAO.getId());
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwEstlocal item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdLocal());
				itemDTO.setDescricao(item.getDsLocal());
				itemDTO.setRegistro(item.clone(false));
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO retorno = new PesquisasDTO();
		retorno.setPesquisa(listaDTO);
		return retorno;
	}

	public PesquisasDTO pesquisaDwCal(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from DwCal t ";
		hql += "where t.stAtivo=1 ";

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdCal = '::cdCal' or t.dsCal = '::dsCal' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdCal = '::cdCal' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsCal = '::dsCal' ";
		}

		hql = hql.replaceAll("::cdCal", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsCal", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<DwCal> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwCal item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdCal());
				itemDTO.setDescricao(item.getDsCal());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaDwTAlerta(PesquisaDTO pesquisa) {

		MapQuery q = new MapQuery(getSession());
		q.append("SELECT t");
		q.append("FROM DwTAlerta t");
		q.append("WHERE stAtivo = 1");

		DwTAlerta alerta = null;

		if (pesquisa.getRegistro() instanceof OmTppt) {
			q.append("AND t.omTppt = :id");
		}
		if(pesquisa.getRegistro() instanceof DwTAlerta) {
			alerta = (DwTAlerta) pesquisa.getRegistro();
			if(alerta.getIsTimeout() != null) {
				q.append("AND t.isTimeout = :isTimeout");
			}
			if (alerta.getIsAutomatico() != null) {
				q.append("AND t.isAutomatico = :isAutomatico");
			}
			if (alerta.getOmTppt() != null && alerta.getOmTppt().getCdTppt() != null && alerta.getOmTppt().getCdTppt().equals("") == false) {
				q.append("AND t.omTppt.cdTppt = :cdtppt");
			}
		}
		if (pesquisa.getRegistro() instanceof OmTppt)
			q.defineParametro("id", pesquisa.getRegistro());
		if (alerta != null) {
			q.defineParametro("isTimeout", alerta.getIsTimeout());
			q.defineParametro("isAutomatico", alerta.getIsAutomatico());
		}
		if (alerta != null && alerta.getOmTppt() != null)
			q.defineParametro("cdtppt", alerta.getOmTppt().getCdTppt());


		List<DwTAlerta> lista = q.list();
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwTAlerta item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdTalerta());
				itemDTO.setDescricao(item.getDsTalerta());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaDwTRefugo(PesquisaDTO pesquisa) {

		MapQuery q = new MapQuery(getSession());
		q.append("select t ");
		q.append("from DwTRefugo t ");
		q.append("where stAtivo = 1");

		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			q.append("and ( t.cdTrefugo = :cdTrefugo or t.dsTrefugo= :dsTrefugo )");
		} else if (!pesquisa.getCodigo().equals("")) {
			q.append("and t.cdTrefugo = :cdTrefugo ");
		} else if (!pesquisa.getDescricao().equals("")) {
			q.append("and t.dsTrefugo = :dsTrefugo ");
		}

		if (pesquisa.getRegistro() instanceof OmTppt) {
			q.append("and t.omTppt = :id");
			q.defineParametro("id", pesquisa.getRegistro());
		}

		q.defineParametro("cdTrefugo", pesquisa.getCodigo());
		q.defineParametro("dsTrefugo", pesquisa.getDescricao());

		List<DwTRefugo> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwTRefugo item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdTrefugo());
				itemDTO.setDescricao(item.getDsTrefugo());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaPpCp(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select distinct ppCpprodutos from PpCp ppCp ";
		hql += "INNER JOIN ppCp.ppCpprodutos ppCpprodutos ";
		hql += "where ppCp.stAtivo = 1";

		Query q = getSession().createQuery(hql);

		List<PpCpproduto> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (PpCpproduto item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getIdCpproduto().toString());
				itemDTO.setDescricao(item.getNrDoc());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaPpCpProduto(PesquisaDTO pesquisa,String cdOp) {

	String hql = "";
		hql += "SELECT DISTINCT omProduto from PpCp ppCp ";
		hql += "INNER JOIN ppCp.ppCpprodutos ppCpprodutos ";
		hql += "INNER JOIN ppCpprodutos.omProduto omProduto ";
		hql += "where ppCpprodutos.nrDoc = ':cdOp' ";
		hql += "and omProduto.stAtivo = 1 ";

		hql = hql.replaceAll(":cdOp", cdOp);

		Query q = getSession().createQuery(hql);

		List<OmProduto> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmProduto item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdProduto().toString());
				itemDTO.setDescricao(item.getDsProduto());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PassagensDTO getListaLeadTime(String op, String pt, String produto, String data1,String data2){

		return null;

	}

	public PesquisasDTO pesquisaDwFtParam(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from DwFtParam t";

		if (pesquisa.getCodigo() != null && pesquisa.getDescricao() != null
				&& !pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += " where t.dsParametro = '::cdParametro' or t.dsParametro = '::dsParametro' ";
		} else if (pesquisa.getCodigo() != null
				&& !pesquisa.getCodigo().equals("")) {
			hql += "and t.dsParametro = '::cdParametro' ";
		} else if (pesquisa.getDescricao() != null
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and t.dsParametro = '::dsParametro' ";
		}

		hql = hql.replaceAll("::cdParametro", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsParametro", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<DwFtParam> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwFtParam item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(String.valueOf(item.getIdFtParam()));
				itemDTO.setDescricao(item.getDsParametro());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaDwPepro(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from DwPepro t ";

		if (pesquisa.getCodigo() != null && pesquisa.getDescricao() != null
				&& !pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.dsPepro = '::cdParametro' or t.dsPepro = '::dsParametro' )";
		} else if (pesquisa.getCodigo() != null
				&& !pesquisa.getCodigo().equals("")) {
			hql += "and t.dsPepro = '::cdParametro' ";
		} else if (pesquisa.getDescricao() != null
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and t.dsPepro = '::dsParametro' ";
		}

		hql = hql.replaceAll("::cdParametro", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsParametro", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<DwPepro> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwPepro item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(String.valueOf(item.getIdPepro()));
				itemDTO.setDescricao(item.getDsPepro());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaGrupoProduto(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from OmProgrp t ";
		hql += "where t.stAtivo=1 ";

		if (pesquisa.getCodigo() != null && pesquisa.getDescricao() != null && !pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdProgrp = '::cdProgrp' or t.dsProgrp = '::dsProgrp' )";
		} else if (pesquisa.getCodigo() != null && !pesquisa.getCodigo().equals("")) {
			hql += "and t.cdProgrp = '::cdProgrp' ";
		} else if (pesquisa.getDescricao() != null && !pesquisa.getDescricao().equals("")) {
			hql += "and t.dsProgrp = '::dsProgrp' ";
		}

		hql = hql.replaceAll("::cdProgrp", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsProgrp", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<OmProgrp> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();
		if (lista != null) {
			for (OmProgrp item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdProgrp());
				itemDTO.setDescricao(item.getDsProgrp());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaOmgrpusr(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from OmUsrgrp t ";
		hql += "where t.stAtivo=1 ";

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdUsrgrp = '::cdUsrgrp' or t.dsUsrGrp = '::dsUsrGrp' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdUsrgrp = '::cdUsrgrp' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsUsrGrp = '::dsUsrGrp' ";
		}

		hql = hql.replaceAll("::cdUsrgrp", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsUsrGrp", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<OmUsrgrp> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmUsrgrp item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdUsrgrp());
				itemDTO.setDescricao(item.getDsUsrGrp());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaOmcc(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from OmCc t ";
		hql += "where t.stAtivo=1 ";

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdCc = '::cdCc' or t.dsCc = '::dsCc' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdCc = '::cdCc' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsCc = '::dsCc' ";
		}

		hql = hql.replaceAll("::cdCc", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsCc", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<OmCc> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmCc item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdCc());
				itemDTO.setDescricao(item.getDsCc());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaOmusr(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from OmUsr t ";
		hql += "where t.stAtivo=1 ";

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdUsr = '::cdUsr' or t.dsNome = '::dsNome' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdUsr = '::cdUsr' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsNome = '::dsNome' ";
		}

		hql = hql.replaceAll("::cdUsr", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsNome", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<OmUsr> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmUsr item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdUsr());
				itemDTO.setDescricao(item.getDsNome());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaOmresgui(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from OmResgui t ";
		hql += "where t.stAtivo=1 ";

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdResgui = '::cdResgui' or t.dsResgui = '::dsResgui' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdResgui = '::cdResgui' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsResgui = '::dsResgui' ";
		}

		hql = hql.replaceAll("::cdResgui", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsResgui", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<OmResgui> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmResgui item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdResgui());
				itemDTO.setDescricao(item.getDsResgui());

				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}
	public OmImg pesquisarOmimgLikeUrl(String url) {
		MapQuery q = new MapQuery(getSession());
		q.append("select omimg");
		q.append("from OmImg omimg");
		q.append("where omimg.urlImg like :url");
		q.defineParametro("url", "%" + url + "%");
		q.setMaxResults(1);
		OmImg omimg = (OmImg) q.uniqueResult();
		if (omimg != null)
			omimg = omimg.clone(false);
		else
			omimg = new OmImg();

		return omimg;
	}

	public PesquisasDTO pesquisaOmimg(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from OmImg t ";
		hql += "where t.stAtivo=1 ";

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdImg = '::cdImg' or t.dsImg = '::dsImg' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdImg = '::cdImg' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsImg = '::dsImg' ";
		}

		hql = hql.replaceAll("::cdImg", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsImg", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<OmImg> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmImg item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdImg());
				itemDTO.setDescricao(item.getDsImg());

				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public OmCfg pesquisaOmcfg() throws SemConfiguracaoException {

		String hql = "";
		hql += "select t ";
		hql += "from OmCfg t ";
		hql += "left join fetch t.dwFtParamByIdFtParamfluxoe a ";
		hql += "left join fetch t.dwFtParamByIdFtParamflusos b ";
		hql += "where t.stAtivo = 1 ";

		Query q = getSession().createQuery(hql);

		q.setMaxResults(1);

		OmCfg omcfg = null;

		try {
			omcfg = (OmCfg) q.uniqueResult();
		} catch (NullPointerException e) {
			omcfg = null;
		}
		if (omcfg == null)
			throw new SemConfiguracaoException();

		return omcfg;

	}

	public PesquisasDTO pesquisaOmEstoque(PesquisaDTO pesquisa) {
		MapQuery query = new MapQuery(getSession());
		query.append("from DwEst e");

		if (!pesquisa.getCodigo().equals("")) {
			query.append("Where e.cdEst like :codigo");
		}
		query.defineParametro("codigo", "%"+pesquisa.getCodigo()+"%");

		List<DwEst> lista = query.list();
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwEst estoque : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(estoque.getCdEst());
				itemDTO.setDescricao(estoque.getDsEst());
				itemDTO.setRegistro(estoque.clone());
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaOmCargo(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from OmCargo t ";
		hql += "where t.stAtivo=1 ";

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdCargo = '::cdCargo' or t.dsCargo = '::dsCargo' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdCargo = '::cdCargo' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsCargo = '::dsCargo' ";
		}

		hql = hql.replaceAll("::cdCargo", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsCargo", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<OmCargo> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmCargo item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdCargo());
				itemDTO.setDescricao(item.getDsCargo());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaDwGrpativ(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from DwGrpativ t ";
		hql += "where t.stAtivo=1 ";

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdGrpativ= '::cdGrpativ' or t.dsGrpativ= '::dsGrpativ' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdGrpativ = '::cdGrpativ' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsGrpativ = '::dsGrpativ' ";
		}

		hql = hql.replaceAll("::cdGrpativ", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsGrpativ", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<DwGrpativ> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwGrpativ item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdGrpativ());
				itemDTO.setDescricao(item.getDsGrpativ());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaOmgt(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from OmGt t ";
		hql += "where t.stAtivo=1 ";

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdGt = '::cdGt' or t.dsGt = '::dsGt' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdGt = '::cdGt' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsGt = '::dsGt' ";
		}

		hql = hql.replaceAll("::cdGt", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsGt", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<OmGt> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmGt item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdGt());
				itemDTO.setDescricao(item.getDsGt());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaOp(PesquisaDTO pesquisa){
		String hql = "";
		hql += "select distinct ppCp ";
		hql += "from PpCp ppCp ";
		hql += "JOIN ppCp.ppCpprodutos ppCpprodutos ";
		hql += "where ppCp.stAtivo = 1 ";

		if (!pesquisa.getCodigo().equals("")) {
			hql += "and ppCp.cdCp = '::cdOp' ";
		}

		hql = hql.replaceAll("::cdOp", pesquisa.getCodigo());

		Query q = getSession().createQuery(hql);

		List<PpCp> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (PpCp item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdCp());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}

	public PesquisasDTO pesquisaOmgtFabrica(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from OmGt t ";
		hql += "where t.stAtivo=1 and ";
		hql += "exists (from OmCfg a where  a.stAtivo = 1 and a.omTpgtByIdTpgtfabrica.idTpgt = t.omTpgt.idTpgt) ";

		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdGt = '::cdGt' or t.dsGt = '::dsGt' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdGt = '::cdGt' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsGt = '::dsGt' ";
		}

		hql = hql.replaceAll("::cdGt", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsGt", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<OmGt> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmGt item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdGt());
				itemDTO.setDescricao(item.getDsGt());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaOmtpgt(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from OmTpgt t ";
		hql += "where t.stAtivo=1 ";

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdTpgt = '::cdTpgt' or t.dsTpgt = '::dsTpgt' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdTpgt = '::cdTpgt' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsTpgt = '::dsTpgt' ";
		}

		hql = hql.replaceAll("::cdTpgt", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsTpgt", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<OmTpgt> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmTpgt item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdTpgt());
				itemDTO.setDescricao(item.getDsTpgt());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}
	public PesquisasDTO pesquisaOmGtFase(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select gt ";
		hql += "from OmGt gt ";
		hql += "left join gt.omTpgt tp ";
		hql += "where gt.stAtivo=1 and tp.idTpgt = 7 ";

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( gt.cdGt = '::cdGt' or gt.dsGt = '::dsGt' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and gt.cdGt = '::cdGt' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsGt = '::dsGt' ";
		}

		hql = hql.replaceAll("::cdGt", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsGt", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<OmGt> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmGt item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdGt());
				itemDTO.setDescricao(item.getDsGt());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public GTsDTO pesquisaOmGtFase(String variavel) {

		MapQuery q = new MapQuery(getSession());
		q.append("select gt ");
		q.append("from OmGt gt ");
		q.append("left join gt.omTpgt tp ");
		q.append("where gt.stAtivo=1 and tp.idTpgt = 7 ");
		q.append("and ( gt.cdGt = :cdGt or gt.dsGt = :dsGt )");

		q.defineParametro("cdGt", "%" + variavel + "%");
		q.defineParametro("dsGt", "%" + variavel + "%");

		List<OmGt> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<GtDTO> listaDTO = new ArrayList<GtDTO>();

		if (lista != null) {
			for (OmGt item : lista) {
				GtDTO itemDTO = new GtDTO();
				itemDTO.setGt(item.clone(false));
				listaDTO.add(itemDTO);
			}
		}
		GTsDTO pesquisas = new GTsDTO();
		pesquisas.setGts(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaOmAlgocor(PesquisaDTO pesquisa) {
		MapQuery q = new MapQuery(getSession());
		q.append("select a");
		q.append("from OmAlgocor a");
		q.append("where a.dsAlgocor like :ds");
		
		q.defineParametro("ds", "%" + pesquisa.getCodigo() + "%");
		
		List<OmAlgocor> lista = q.list();
		List<PesquisaDTO> dtos = new ArrayList<>();
		
		for (OmAlgocor algo : lista) {
			PesquisaDTO itemDTO = new PesquisaDTO();
			itemDTO.setCodigo(algo.getDsAlgocor());
			itemDTO.setDescricao(algo.getDsAlgocor());

			itemDTO.setRegistro(algo.clone(false));

			dtos.add(itemDTO);

		}
		
		PesquisasDTO retorno = new PesquisasDTO();
		
		retorno.setPesquisa(dtos);
		
		return retorno;
		
	}


	public PesquisasDTO pesquisaOmtppt(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from OmTppt t ";
		hql += "where t.stAtivo=1 ";

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdTppt = '::cdTppt' or t.dsTppt = '::dsTppt' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdTppt = '::cdTppt' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsTppt = '::dsTppt' ";
		}

		hql = hql.replaceAll("::cdTppt", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsTppt", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<OmTppt> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmTppt item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdTppt());
				itemDTO.setDescricao(item.getDsTppt());

				itemDTO.setRegistro(item.clone(false));

				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaArea(PesquisaDTO pesquisa){

		MapQuery qArea = new MapQuery(this.getDao().getSession());
		qArea.append("select t ");
		qArea.append("from DwTArea t ");
		qArea.append("where t.stAtivo=1 ");

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			qArea.append("and ( t.cdArea = '::cdArea' or t.dsArea = '::dsArea' )");
		} else if (!pesquisa.getCodigo().equals("")) {
			qArea.append("and t.cdArea = '::cdArea' ");
		} else if (!pesquisa.getDescricao().equals("")) {
			qArea.append("and t.dsArea = '::dsArea' ");
		}

		qArea.defineParametro("::cdArea", pesquisa.getCodigo());
		qArea.defineParametro("::dsArea", pesquisa.getDescricao());

		List<DwTArea> lista = null;
		try {
			lista = qArea.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwTArea item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdArea());
				itemDTO.setDescricao(item.getDsArea());

				itemDTO.setRegistro(item.clone());

				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}

	public PesquisasDTO pesquisaDwTParada(PesquisaDTO pesquisa){

		MapQuery qParada = new MapQuery(this.getDao().getSession());
		qParada.append("select distinct t ");
		qParada.append("from DwTParada t ");
		qParada.append("where t.stAtivo=1 ");

		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			qParada.append("and ( t.cdTparada = :cdTparada or t.dsTparada = :dsTparada )");
		} else if (!pesquisa.getCodigo().equals("")) {
			qParada.append("and t.cdTparada = :cdTparada ");
		} else if (!pesquisa.getDescricao().equals("")) {
			qParada.append("and t.dsTparada = :dsTparada ");
		}

		if (pesquisa.getRegistro() instanceof OmTppt) {
			OmTppt omtppt = (OmTppt) pesquisa.getRegistro();
			if (omtppt != null && omtppt.getIdTppt() != null && omtppt.getIdTppt() > 0) {
				qParada.append("and t.omTppt = :id");
				qParada.defineParametro("id", omtppt);
			} else if (omtppt.getCdTppt() != null && omtppt.getCdTppt().equals("") == false) {
				qParada.append("and t.omTppt.cdTppt = :id");
				qParada.defineParametro("id", omtppt.getCdTppt());
			}
		}

		qParada.defineParametro("cdTparada", pesquisa.getCodigo());
		qParada.defineParametro("dsTparada", pesquisa.getDescricao());

		List<DwTParada> lista = null;
		try {
			lista = qParada.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwTParada item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdTparada());
				itemDTO.setDescricao(item.getDsTparada() + " / " + item.getOmTppt().getCdTppt());

				itemDTO.setRegistro(item.clone());

				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}

	@SuppressWarnings("static-access")
	public PesquisasDTO pesquisaDwRap(PesquisaDTO pesquisa) {
		MapQuery q = new MapQuery(getSession());
		q.append("Select r");
		q.append("from DwRap r");
		q.appendWhere(q._NULL, "r.stAtivo = 1", true);

		q.appendWhere(q._AND, "r.cdRap = :cdRap",
				!pesquisa.getCodigo().equals(""));
		q.appendWhere(q._AND, "r.dsRap = :dsRap", !pesquisa.getDescricao()
				.equals(""));

		List<DwRap> listaDwRap = q.list();
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (listaDwRap != null) {
			for (DwRap item : listaDwRap) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdRap());
				itemDTO.setDescricao(item.getDsRap());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}

	public PesquisasDTO pesquisaOmprodutoFinal(PesquisaDTO pesquisa) {
		OmProdutoDAO dao = new OmProdutoDAO(getSession());
		List<OmProduto> lista = dao.getOmProdutos(pesquisa.getCodigo(), pesquisa.getDescricao(), OmProdutoTemplate.TpProduto.PRODUTO_FINAL.getId());

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmProduto item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdProduto());
				itemDTO.setDescricao(item.getDsProduto());
				//itemDTO.setRegistro(item.clone(false));
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO retorno = new PesquisasDTO();
		retorno.setPesquisa(listaDTO);
		return retorno;
	}
	public PesquisasDTO pesquisaOmprodutoEmbalagem(PesquisaDTO pesquisa) {
		OmProdutoDAO dao = new OmProdutoDAO(getSession());
		List<OmProduto> lista = dao.getOmProdutos(pesquisa.getCodigo(), pesquisa.getDescricao(), OmProdutoTemplate.TpProduto.EMBALAGEM.getId());

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmProduto item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdProduto());
				itemDTO.setDescricao(item.getDsProduto());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO retorno = new PesquisasDTO();
		retorno.setPesquisa(listaDTO);
		return retorno;
	}

	public PesquisasDTO pesquisaPedido(PesquisaDTO pesquisa) {
		PpNecDAO necDAO = new PpNecDAO(getSession());
		List<PpNec> listaNecessidades;
		if(pesquisa.getRegistro() != null) {
			PpCliente cliente = (PpCliente) pesquisa.getRegistro();
			listaNecessidades = necDAO.getPpNecAtivosPorCdOuCliente(pesquisa.getCodigo(), cliente.getIdCliente());
		}else{
			listaNecessidades = necDAO.getPpNecAtivosPorCdOuCliente(pesquisa.getCodigo(), null);
		}
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();
		for(PpNec necessidade : listaNecessidades){
			PesquisaDTO itemDTO = new PesquisaDTO();
			itemDTO.setCodigo(necessidade.getCdNec());
			itemDTO.setRegistro(necessidade.clone());
			listaDTO.add(itemDTO);
		}
		PesquisasDTO retorno = new PesquisasDTO();
		retorno.setPesquisa(listaDTO);
		return retorno;
	}

	public PesquisasDTO pesquisaOmprodutoTodosTp(PesquisaDTO pesquisa) {
		OmProdutoDAO dao = new OmProdutoDAO(getSession());
		List<OmProduto> lista = dao.getOmProdutos(pesquisa.getCodigo(), pesquisa.getDescricao(), null);
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();
		if (lista != null) {
			for (OmProduto item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdProduto());
				itemDTO.setDescricao(item.getDsProduto());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO retorno = new PesquisasDTO();
		retorno.setPesquisa(listaDTO);
		return retorno;
	}

	public PesquisasDTO pesquisaProgramaIAC(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select omprg from OmPrg omprg where st_ativo = 1 ";

		Query q = getSession().createQuery(hql);

		List<OmPrg> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmPrg item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdPrg());
				itemDTO.setDescricao(item.getDsPrg());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaProdutoIAC(PesquisaDTO pesquisa) {

		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select omproduto from OmProduto omproduto where st_ativo = 1 ");
		q.append("and omproduto.tpProduto in (:lista)");

		if ((pesquisa.getCodigo() != null) && (pesquisa.getCodigo().equals("") == false)) {
			q.append("and cd_produto like '%" + pesquisa.getCodigo() + "%' ");
		}

		if ((pesquisa.getDescricao() != null) && (pesquisa.getDescricao().equals("") == false)) {
			q.append("and ds_produto like '%" + pesquisa.getDescricao() + "%' ");
		}

		List<Object> listaTpProduto = new ArrayList<>();

		listaTpProduto.add(OmProdutoTemplate.TpProduto.PRODUTO_FINAL.getId());
		listaTpProduto.add(OmProdutoTemplate.TpProduto.SEMI_ACABADO.getId());

		q.defineListaParametro("lista", listaTpProduto);
		q.setMaxResults(50);

		List<OmProduto> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmProduto item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdProduto());
				itemDTO.setDescricao(item.getDsProduto());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}

	public PesquisasDTO pesquisaOmfornecedor(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from OmFor t ";
		hql += "where t.stAtivo=1 ";

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdFor = '::cdFor' or t.nmFornecedor = '::nmFornecedor' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdFor = '::cdFor' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.nmFornecedor = '::nmFornecedor' ";
		}

		hql = hql.replaceAll("::cdFor", pesquisa.getCodigo());
		hql = hql.replaceAll("::nmFornecedor", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<OmFor> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmFor item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdFor());
				itemDTO.setDescricao(item.getNmFornecedor());
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaOmprg(OmPt pt, PesquisaDTO pesquisa) {
		OmPrgDAO prgDAO = new OmPrgDAO(getSession());
		List<OmPrg> listaProgramas = prgDAO.getOmPrgs(pesquisa.getCodigo(), pesquisa.getDescricao(), pt.getIdPt());
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();
		for (OmPrg prg : listaProgramas) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(prg.getCdPrg());
				itemDTO.setDescricao(prg.getDsPrg());
				listaDTO.add(itemDTO);
		}
		PesquisasDTO retorno = new PesquisasDTO();
		retorno.setPesquisa(listaDTO);
		return retorno;
	}

	public PesquisasDTO pesquisaOmpa(OmPt pt, PesquisaDTO filtro) {
		OmPaDAO paDAO = new OmPaDAO(getSession());
		List<OmPa> lista = paDAO.getOmPas(filtro.getCodigo(), filtro.getDescricao(), pt.getIdPt());
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();
		if (lista != null) {
			for (OmPa item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setRegistro(item.clone(false));
				itemDTO.setCodigo(item.getCdPa());
				itemDTO.setDescricao(item.getDsPa());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}

	public PesquisasDTO pesquisaOmpt(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from OmPt t ";
		hql += "where t.stAtivo=1 ";

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdPt = '::cdPt' or t.dsPt = '::dsPt' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdPt = '::cdPt' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsPt = '::dsPt' ";
		}

		hql = hql.replaceAll("::cdPt", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsPt", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<OmPt> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmPt item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdPt());
				itemDTO.setDescricao(item.getDsPt());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaDwprocedimento(PesquisaDTO pesquisa) {

		List<DwProcedimento> lista = null;
		DwProcedimentoDAO dwProcedimentoDAO = new DwProcedimentoDAO(getSession());
		try {
			lista = dwProcedimentoDAO.getListaProcedimentos(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwProcedimento item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdProcedimento());
				itemDTO.setDescricao(item.getDsProcedimento());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaOmmapa(PesquisaDTO pesquisa) {

		MapQuery q = new MapQuery(getSession());
		q.append("select t ");
		q.append("from OmMapa t ");
		q.append("where t.stAtivo=1 ");

		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			q.append("and ( t.cdMapa = :cdMapa or t.dsMapa = :dsMapa )");
		} else if (!pesquisa.getCodigo().equals("")) {
			q.append("and t.cdMapa = :cdMapa ");
		} else if (!pesquisa.getDescricao().equals("")) {
			q.append("and t.dsMapa = :dsMapa ");
		}
		
		if (pesquisa.getRegistro() instanceof OmPt) {
			q.append("and t.omPt.cdPt = :cdpt and t.omPt.stAtivo = 1");
			OmPt ompt = (OmPt) pesquisa.getRegistro();
			q.defineParametro("cdpt", ompt.getCdPt());
		}

		q.defineParametro("cdMapa", pesquisa.getCodigo());
		q.defineParametro("dsMapa", pesquisa.getDescricao());

		List<OmMapa> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<>();

		if (lista != null) {
			for (OmMapa item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdMapa());
				itemDTO.setDescricao(item.getDsMapa());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaOmcfgscrpimp(PesquisaDTO pesquisa) {

		String hql = "";
		hql += "select t ";
		hql += "from OmCfgscrpimp t ";
		hql += "join t.omCfg omcfg ";
		hql += "where t.stativo=1 ";
		hql += "and omcfg.stAtivo = 1 ";

		if (!pesquisa.getCodigo().equals("")
				&& !pesquisa.getDescricao().equals("")) {
			hql += "and ( t.cdScrp = '::cdScrp' or t.dsScrp= '::dsScrp' )";
		} else if (!pesquisa.getCodigo().equals("")) {
			hql += "and t.cdScrp = '::cdScrp' ";
		} else if (!pesquisa.getDescricao().equals("")) {
			hql += "and t.dsScrp = '::dsScrp' ";
		}

		hql = hql.replaceAll("::cdScrp", pesquisa.getCodigo());
		hql = hql.replaceAll("::dsScrp", pesquisa.getDescricao());

		Query q = getSession().createQuery(hql);

		List<OmCfgscrpimp> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmCfgscrpimp item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdScrp());
				itemDTO.setDescricao(item.getDsScrp());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public EtiquetasDTO getEtiquetas(ProdutosDTO produtos, String script) {
		EtiquetasDTO etiquetas = new EtiquetasDTO();
		etiquetas.setEtiquetas(new ArrayList<EtiquetaDTO>());

		SimpleDateFormat formatterD = new SimpleDateFormat("dd/MM/yy");
		SimpleDateFormat formatterH = new SimpleDateFormat("HH:mm");
		Date data = new Date();
		String descricao2 = "DATA: " + formatterD.format(data) + " - " + formatterH.format(data);

		for (ProdutoDTO produto : produtos.getProdutos()) {
			OmProduto omProduto = produto.getProduto();
			EtiquetaDTO etiqueta = new EtiquetaDTO();
			etiqueta.setCodigoBarra(omProduto.getCdProduto());
			etiqueta.setDescricao(omProduto.getCdProduto());
			etiqueta.setDescricao2(descricao2);
			etiqueta.setDescricao3(omProduto.getOmUsrByIdUsrstativo().getDsNome());
			etiqueta.setDepara(omProduto.getDepara());
			etiqueta.setGPesoBruto(omProduto.getGPesoBruto());
			etiqueta.setCdSap(omProduto.getCdSap());
			etiqueta.setQtEmpilhamento(omProduto.getQtEmpilhamento());
			etiqueta.setCdModelo(omProduto.getCdModelo());
			etiqueta.setCdPartnumber(omProduto.getCdPartnumber());
			etiqueta.setScript(script);
			etiqueta.setCdproduto(omProduto.getCdProduto());
			etiqueta.setDsproduto(omProduto.getDsProduto());
			etiqueta.setPilha("SIM"); // temporario ate se criar um atributo em omproduto
			if (omProduto.getPpCliente() != null)
				etiqueta.setCliente(omProduto.getPpCliente().getCdCliente());

			etiquetas.getEtiquetas().add(etiqueta);
		}

		return getEtiquetas(etiquetas);
	}

	public EtiquetasDTO getEtiquetas(MapasAlimentacaoDTO mapas, String script) {
		EtiquetasDTO etiquetas = new EtiquetasDTO();
		etiquetas.setEtiquetas(new ArrayList<EtiquetaDTO>());

		for (MapaAlimentacaoDTO mapa : mapas.getMapas()) {
			EtiquetaDTO etiqueta = new EtiquetaDTO();
			etiqueta.setCodigoBarra(mapa.getOmmapa().getCdMapa());
			etiqueta.setDescricao(mapa.getOmmapa().getCdMapa());
			etiqueta.setDescricao2(mapa.getOmmapa().getCdMapa());
			etiqueta.setDescricao3(mapa.getOmmapa().getCdMapa());
			etiqueta.setScript(script);

			etiquetas.getEtiquetas().add(etiqueta);
		}

		return getEtiquetas(etiquetas);
	}

	public EtiquetasDTO getEtiquetas(PTsDTO pts, String script) {
		EtiquetasDTO etiquetas = new EtiquetasDTO();
		etiquetas.setEtiquetas(new ArrayList<EtiquetaDTO>());

		for (PtDTO pt : pts.getPts()) {
			EtiquetaDTO etiqueta = new EtiquetaDTO();
			etiqueta.setCodigoBarra(pt.getPt().getCdPt());
			etiqueta.setDescricao(pt.getPt().getCdPt());
			etiqueta.setDescricao2("");
			etiqueta.setDescricao3("");
			etiqueta.setScript(script);

			etiquetas.getEtiquetas().add(etiqueta);
		}

		return getEtiquetas(etiquetas);
	}

	public EtiquetasDTO getEtiquetas(PAsDTO pas, String script) {
		EtiquetasDTO etiquetas = new EtiquetasDTO();
		etiquetas.setEtiquetas(new ArrayList<EtiquetaDTO>());

		for (PaDTO pa : pas.getPas()) {
			EtiquetaDTO etiqueta = new EtiquetaDTO();
			etiqueta.setCodigoBarra(pa.getPa().getCdPa());
			etiqueta.setDescricao(pa.getPa().getCdPa());
			etiqueta.setDescricao2("");
			etiqueta.setDescricao3("");
			etiqueta.setScript(script);

			etiquetas.getEtiquetas().add(etiqueta);
		}

		return getEtiquetas(etiquetas);
	}

	private EtiquetasDTO getEtiquetas(EtiquetasDTO etiquetas) {

		for (EtiquetaDTO item : etiquetas.getEtiquetas()) {

			int intLeft1;
			int intLeft2;
			int intLeft3;
			String strDescricao = item.getDescricao();
			String strCodigoBarra = item.getCodigoBarra();
			String strDescricao2 = item.getDescricao2();
			String strDescricao3 = item.getDescricao3();
			String strScript = item.getScript();

			strDescricao = retirarCaracterEspecial(strDescricao);
			strCodigoBarra = retirarCaracterEspecial(strCodigoBarra);
			strDescricao2 = retirarCaracterEspecial(strDescricao2);
			strDescricao3 = retirarCaracterEspecial(strDescricao3);

			if (strDescricao.length() >= 37) {
				strDescricao = strDescricao.substring(37);
			}
			if (strDescricao2.length() >= 37) {
				strDescricao2 = strDescricao2.substring(37);
			}
			if (strDescricao3.length() >= 37) {
				strDescricao3 = strDescricao3.substring(37);
			}

			// fazer o c�lculo considerando 37 caracteres o m�ximo e 610 o width
			// (dots), porque sim
			intLeft1 = (37 - strDescricao.length() - ((37 - strDescricao
					.length()) / 2 * 15));
			intLeft2 = (37 - strDescricao2.length() - ((37 - strDescricao2
					.length()) / 2 * 15));
			intLeft3 = (37 - strDescricao3.length() - ((37 - strDescricao3
					.length()) / 2 * 15));

			// Retorna n�mero de arquivo livre para ser utilizado no Open
			strScript = strScript.replaceAll("<vbCrLf>",
					String.valueOf(((char) 13)) + String.valueOf(((char) 10)));
			strScript = strScript.replaceAll("<intLeft1>",
					String.valueOf(intLeft1));
			strScript = strScript.replaceAll("<intLeft2>",
					String.valueOf(intLeft2));
			strScript = strScript.replaceAll("<intLeft3>",
					String.valueOf(intLeft3));
			strScript = strScript.replaceAll("<Chr34>", "\"");
			strScript = strScript.replaceAll("<strDescricao>", strDescricao);
			strScript = strScript.replaceAll("<strDescricao2>", strDescricao2);
			strScript = strScript.replaceAll("<strDescricao3>", strDescricao3);
			strScript = strScript
					.replaceAll("<strCodigoBarra>", strCodigoBarra);

			item.setDescricao(strDescricao);
			item.setDescricao2(strDescricao2);
			item.setDescricao3(strDescricao3);
			item.setCodigoBarra(strCodigoBarra);
			item.setScript(strScript);

		}

		return etiquetas;
	}

	private String retirarCaracterEspecial(String string) {
		if (string == null) {
			string = "";
		}
		return string.trim().replaceAll("\"", "�");
	}

	public List<String> pesquisaProdutoDepara() {

		String hql = "";
		hql += "select distinct(t.cdProduto) as depara ";
		hql += "from OmProduto t ";
		hql += "where t.stAtivo=1 and t.cdProduto != null and t.tpProduto = 0 ";

		Query q = getSession().createQuery(hql);

		List<String> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;

	}

	public List<String> pesquisaProdutoComplemento() {

		String hql = "";
		hql += "select distinct(t.dsComplemento) as complemento ";
		hql += "from OmProduto t ";
		hql += "where t.stAtivo=1 and t.dsComplemento != null ";

		Query q = getSession().createQuery(hql);

		List<String> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;

	}

	public PesquisasDTO getResultadoFiltro(String strValor, String strTipo, String cdpt) {
		// Obtem lista do filtro
		PesquisaDTO pesquisa = new PesquisaDTO();
		pesquisa.setCodigo(strValor);
		pesquisa.setDescricao(strValor);
		
		// Se passou o pt entao inicializar o omtppt
		if (cdpt != null && cdpt.equals("") == false)  {
			PTRN rn = new PTRN();
			rn.setDaoSession(getSession());
			OmTppt omtppt;
			try {
				omtppt = rn.getOmPt(cdpt).getOmTppt();
			} catch (RegistroDesconhecidoException e) {
				omtppt = null;
			}
			pesquisa.setRegistro(omtppt);
		}

		if (strTipo.equals("produto")) {
			return this.pesquisaOmprodutoFinal(pesquisa);
		}
		if (strTipo.equals("defeito")) {
			return this.pesquisaDwTDefeito(pesquisa);
		}
		if (strTipo.equals("refugo")) {
			return this.pesquisaDwTRefugo(pesquisa);
		}
		if (strTipo.equals("acao")) {
			return this.pesquisaDwTAcao(pesquisa);
		}
		if (strTipo.equals("usuario")) {
			return this.pesquisaOmusr(pesquisa);
		}
		if (strTipo.equals("pt")) {
			return this.pesquisaOmpt(pesquisa);
		}
		if (strTipo.equals("filtro")) {
			return this.pesquisaFiltro(pesquisa);
		}
		if (strTipo.equals("area")) {
			return this.pesquisaArea(pesquisa);
		}
		if (strTipo.equals("causa")) {
			return this.pesquisaDwTCausa(pesquisa);
		}

		return new PesquisasDTO();
	}

	public PesquisasDTO pesquisaDwRota(PesquisaDTO pesquisa) {


		MapQuery q = new MapQuery(getSession());
		q.append("select t ");
		q.append("from DwRota t ");
		q.append("join t.omProduto b");
		q.append("where t.stAtivo=1 ");

		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			q.append("and ( t.cdRota = :cdRota or t.dsRota = :dsRota)");
		} else if (!pesquisa.getCodigo().equals("")) {
			q.append("and t.cdRota = :cdRota");
		} else if (!pesquisa.getDescricao().equals("")) {
			q.append("and t.dsRota = :dsRota");
		}
		
		// Verifica se o produto foi passado
		if (pesquisa.getRegistro() != null) {
			if (pesquisa.getRegistro() instanceof DwRota) {
				DwRota dwrotaAux = (DwRota) pesquisa.getRegistro();
				if (dwrotaAux.getOmProduto() != null && dwrotaAux.getOmProduto().getCdProduto() != null) {
					q.append("and b.cdProduto = :cdproduto and b.stAtivo = 1");
					q.defineParametro("cdproduto", dwrotaAux.getOmProduto().getCdProduto());
				}
			}
		}

		q.defineParametro("cdRota", pesquisa.getCodigo());
		q.defineParametro("dsRota", pesquisa.getDescricao());

		List<DwRota> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		for (DwRota item : lista) {
			PesquisaDTO itemDTO = new PesquisaDTO();
			itemDTO.setCodigo(item.getCdRota());
			itemDTO.setDescricao(item.getDsRota());
			itemDTO.setRegistro(item.clone());
			listaDTO.add(itemDTO);
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaRAPs(PesquisaDTO pesquisa) {
		MapQuery q = new MapQuery(getSession());

		q.append("select r ");
		q.append("from DwRap r ");
		q.append("where r.stAtivo=1 ");
		if (pesquisa.getCodigo() != null && pesquisa.getCodigo().equals("") == false)
			q.append("and r.cdRap like :cd");
		if (pesquisa.getDescricao() != null && pesquisa.getDescricao().equals("") == false)
			q.append("and r.dsRap like :ds");

		q.defineParametro("cd", "%" + pesquisa.getCodigo() + "%");
		q.defineParametro("ds", "%" + pesquisa.getDescricao() + "%");

		List<DwRap> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwRap item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdRap());
				itemDTO.setDescricao(item.getDsRap());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaDwFolhaRap() {
		StringBuilder hql = new StringBuilder();

		hql.append("select dw from DwFolharap dw left join fetch dw.dwRap rap");

		Query q = getSession().createQuery(hql.toString());

		List<DwRap> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwRap item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdRap());
				itemDTO.setDescricao(item.getDsRap());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public OmImg pesquisarOmImgStAvitoByCd(String cd) {
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select omimg");
		q.append("from OmImg omimg");
		q.append("where omimg.cdImg = :cdimg");
		q.append("and omimg.stAtivo = 1");
		q.setMaxResults(1);
		q.defineParametro("cdimg", cd);
		return (OmImg) q.uniqueResult();
	}
	public OmTexto pesquisarOmTextoStAvitoById(Long id) {
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select a");
		q.append("from OmTexto a");
		q.append("where a.idTexto= :id");
		q.defineParametro("id", id);
		return (OmTexto) q.uniqueResult();
	}

	public PesquisasDTO pesquisaCBNumSerie(PesquisaDTO pesquisa) {

		MapQuery q = new MapQuery(getSession());
		q.append("select t");
		q.append("from OmRegrasNscb t");
		q.append("where t.stAtivo=1");

		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			q.append("and ( t.cdRegrasNscb = :cdRegrasNscb or t.dsRegrasNscb = :dsRegrasNscb )");
		} else if (!pesquisa.getCodigo().equals("")) {
			q.append("and t.cdRegrasNscb = :cdRegrasNscb");
		} else if (!pesquisa.getDescricao().equals("")) {
			q.append("and t.dsRegrasNscb = :dsRegrasNscb");

		}

		q.defineParametro("cdRegrasNscb", pesquisa.getCodigo());
		q.defineParametro("dsRegrasNscb", pesquisa.getDescricao());

		List<OmRegrasNscb> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmRegrasNscb item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdRegrasNscb());
				itemDTO.setDescricao(item.getDsRegrasNscb());
				itemDTO.setRegistro(item.clone(false));
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}

	public OmRegrasNscb pesquisarOmRegrasnscb(String cd) {
		MapQuery q = new MapQuery(getSession());
		q.append("select t");
		q.append("from OmRegrasNscb t");
		q.append("where t.stAtivo=1");
		q.append("and t.cdRegrasNscb = :cd");

		q.defineParametro("cd", cd);
		q.setMaxResults(1);

		return (OmRegrasNscb) q.uniqueResult();

	}
	public PesquisasDTO pesquisaClassificacaoABC(PesquisaDTO pesquisa) {

		MapQuery q = new MapQuery(getSession());
		q.append("select abc");
		q.append("from OmCfgabc abc");
		q.append("where abc.stAtivo=1");

		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			q.append("and ( abc.cdCfgabc = :cdCfgabc or abc.dsCfgabc = :dsCfgabc )");
		} else if (!pesquisa.getCodigo().equals("")) {
			q.append("and abc.cdCfgabc = :cdCfgabc");
		} else if (!pesquisa.getDescricao().equals("")) {
			q.append("and abc.dsCfgabc = :dsCfgabc");
		}

		q.defineParametro("cdCfgabc", pesquisa.getCodigo());
		q.defineParametro("dsCfgabc", pesquisa.getDescricao());

		List<OmCfgabc> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmCfgabc item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdCfgabc());
				itemDTO.setDescricao(item.getDsCfgabc());
				itemDTO.setRegistro(item.clone(false));
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}

	public PesquisasDTO pesquisaRitmo(PesquisaDTO pesquisa) {

		MapQuery q = new MapQuery(getSession());
		q.append("select ritmo");
		q.append("from DwTRitmo ritmo");
		q.append("where ritmo.stAtivo=1");

		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			q.append("and ( ritmo.cdTritmo = :cdTritmo or ritmo.dsTritmo = :dsTritmo )");
		} else if (!pesquisa.getCodigo().equals("")) {
			q.append("and ritmo.cdTritmo = :cdTritmo");
		} else if (!pesquisa.getDescricao().equals("")) {
			q.append("and ritmo.dsTritmo = :dsTritmo");
		}

		q.defineParametro("cdTritmo", pesquisa.getCodigo());
		q.defineParametro("dsTritmo", pesquisa.getDescricao());

		List<DwTRitmo> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwTRitmo item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdTritmo());
				itemDTO.setDescricao(item.getDsTritmo());
				itemDTO.setRegistro(item.clone(false));
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}

	public PesquisasDTO pesquisaEmpresa(PesquisaDTO pesquisa) {

		MapQuery q = new MapQuery(getSession());
		q.append("select empresa");
		q.append("from OmEmpresa empresa");
		q.append("where 1=1");

		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			q.append("and ( empresa.cdEmpresa = :cdEmpresa or empresa.dsEmpresa = :dsEmpresa )");
		} else if (!pesquisa.getCodigo().equals("")) {
			q.append("and empresa.cdEmpresa = :cdEmpresa");
		} else if (!pesquisa.getDescricao().equals("")) {
			q.append("and empresa.dsEmpresa = :dsEmpresa");
		}

		q.defineParametro("cdEmpresa", pesquisa.getCodigo());
		q.defineParametro("dsEmpresa", pesquisa.getDescricao());

		List<OmEmpresa> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmEmpresa item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdEmpresa());
				itemDTO.setDescricao(item.getDsEmpresa());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}

	@Deprecated
	public void setAlteracaoDwConsolallog2(long idConsolallog,String obs,long idUsr){

		DwConsolallogDAO consolallogDAO = new DwConsolallogDAO(getDao().getSession());
		OmUsrDAO usrDAO = new OmUsrDAO(getDao().getSession());

		OmUsr omUsr = usrDAO.getOmUsrPorId(idUsr);
		System.out.println("id: "+idConsolallog);
		DwConsolallog consolallogAlteracao =  consolallogDAO.getDwConsolallogPorId(idConsolallog);

		if(consolallogAlteracao != null){
			consolallogAlteracao.setObs(obs);
			consolallogAlteracao.setOmUsr(omUsr);
			consolallogAlteracao.setDthrFalerta(DataHoraRN.getDataHoraAtual());
			makePersistent(consolallogAlteracao);
		}

		System.out.println(consolallogAlteracao.getObs());
		System.out.println(consolallogAlteracao.getOmUsr().getDsNome());

		/* Eh necessario remover o status de alerta da tela de monitorizacao
		 *
		 */
		TempoRealRN trn = new TempoRealRN(getDao());
		ConsolidaRN crn = new ConsolidaRN(getDao());
		DwRt dwrt = trn.getUltimoDwRt(consolallogAlteracao.getOmPt().getIdPt());
		List<DwConsolallog> dwConsolmoComAlertaAberto = crn.getDwConsolalComAlertaAberto(consolallogAlteracao.getOmPt());

		if (dwrt != null) {
			dwrt.setIsAlerta(!dwConsolmoComAlertaAberto.isEmpty());
			getDao().makePersistent(dwrt);
		}
	}

	public void setAlteracaoDwConsolallog(Long idConsolallog,String obs,long idUsr){
		IdwLogger log = new IdwLogger("FechaAlertaAutomatico");
		int idLog = log.getIdAleatorio();
		int identacao = 0;

		ConsolidacaoFimAlerta rn = new ConsolidacaoFimAlerta(getDao());
		TurnoRN turnoRN = new TurnoRN(getDao());

		DwConsolallogDAO consolallogDAO = new DwConsolallogDAO(getDao().getSession());
		OmUsrDAO usrDAO = new OmUsrDAO(getDao().getSession());

		OmUsr omUsr = usrDAO.getOmUsrPorId(idUsr);
		OmCfg omcfg = Util.getConfigGeral(getDao().getSession());

		DwConsolallog consolallogAlteracao =  consolallogDAO.getDwConsolallogPorId(idConsolallog);

		if(consolallogAlteracao != null){
			consolallogAlteracao.setObs(obs);
			consolallogAlteracao.setOmUsr(omUsr);
			makePersistent(consolallogAlteracao);
		}
		PpCp ppcp = consolallogAlteracao.getOmPt().getPpCp();
		String nrop = ppcp.getNrop();

		MsEvt msevt = new MsEvt();
		msevt.setDthrEventoanterior(consolallogAlteracao.getDthrIalerta());
		msevt.setDthrEvento(DataHoraRN.getDataHoraAtual());
		msevt.setNrop(nrop);
		msevt.setCdProduto(null);
		msevt.setCdAlerta(consolallogAlteracao.getDwTAlerta().getCdTalerta());

		getDao().evict(msevt);  //  um evict para nao correr o risco do hibernate incluir o registro

		DwConsolptDAO dwConsolptDAO = new DwConsolptDAO(getDao().getSession());
		DwConsolpt dwConsolpt = dwConsolptDAO.getDwConsolptSeNaoEncontraCria(consolallogAlteracao.getOmPt());
		List<DwCalsem> dwCalsems = null;
		try {
			dwCalsems = turnoRN.getCalendarioSemanalComTurnosIndefinidosParaPt(consolallogAlteracao.getOmPt(), msevt.getDthrEvento());
		} catch (SemCalendarioException e) {
			e.printStackTrace();
		}

		try {
			rn.executarConsolidacao(
					consolallogAlteracao.getOmPt(),
					dwConsolpt,
					dwCalsems,
					msevt,
					omcfg,
					log,
					idLog,
					identacao);
		} catch (RegistroDesconhecidoException | SemCalendarioException | SemSGBDException | SemCicloPadraoException | SemPlanejamentoException | EventoInvalidoException | ReprocessarMsEvtException | NumeroSerieIrregularException | CicloJaContabilizadoException e) {
			e.printStackTrace();
		}
	}

	public ListaPeproDTO pesquisarDwPeproTodos() {
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select a");
		q.append("from DwPepro a");

		ListaPeproDTO retorno = new ListaPeproDTO();
		List<DwPepro> lista = q.list();
		List<DwPepro> listaClone = new ArrayList<>();
		for (DwPepro pro : lista) {
			listaClone.add((DwPepro) pro.clone());
		}
		retorno.setPeriodosProdutivos(listaClone);
		return retorno;
	}

	public PesquisasDTO pesquisarOmJob(PesquisaDTO filtro) {
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select a");
		q.append("from OmJob a");
		q.appendWhere(MapQuery._NULL, "a.stAtivo = 1", true);
		q.appendWhere(MapQuery._AND, "a.cdJob = :cd", filtro.getCodigo() != null && filtro.getCodigo().equals("") == false);
		
		q.defineParametro("cd", filtro.getCodigo());

		List<OmJob> lista = q.list();
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();
		for (OmJob omjob : lista) {
			PesquisaDTO itemDTO = new PesquisaDTO();
			itemDTO.setCodigo(omjob.getCdJob());
			itemDTO.setDescricao(omjob.getDsJob());

			listaDTO.add(itemDTO);
		}
		PesquisasDTO retorno = new PesquisasDTO();
		retorno.setPesquisa(listaDTO);
		return retorno;
	}






	public PesquisasDTO pesquisaDwTCausa(PesquisaDTO pesquisa) {

		MapQuery q = new MapQuery(getSession());
		
		q.append("select t ");
		q.append("from DwTCausa t ");
		q.append("where t.stAtivo=1 ");

		if (pesquisa.getCodigo() != null && pesquisa.getDescricao() != null && !pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			q.append("and ( t.cdTcausa = :cd or t.dsTcausa = :ds )");
		} else if (pesquisa.getCodigo() != null && !pesquisa.getCodigo().equals("")) {
			q.append("and t.cdTcausa = :cd ");
		} else if (pesquisa.getDescricao() != null && !pesquisa.getDescricao().equals("")) {
			q.append("and t.dsTcausa = :ds ");
		}
		if (pesquisa.getRegistro() instanceof OmTppt) {
			q.append("and t.omTppt = :omtppt");
			q.defineParametro("omtppt", (OmTppt) pesquisa.getRegistro() ); 
		}

		q.defineParametro("cd", pesquisa.getCodigo());
		q.defineParametro("ds", pesquisa.getDescricao());

		List<DwTCausa> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (DwTCausa item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdTcausa());
				itemDTO.setDescricao(item.getDsTcausa());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}

	public PesquisasDTO pesquisaDwMacrangePAI(PesquisaDTO pesquisa) {
		MapQuery q = new MapQuery(getSession());
		q.append("select a");
		q.append("from DwMacrange a");
		q.append("where tpRegra = :tp");
		if (pesquisa.getCodigo() != null && pesquisa.getCodigo().trim().equals("") == false)
			q.append("and a.cdModelo = :cd");
		
		q.defineParametro("cd", pesquisa.getCodigo());
		q.defineParametro("tp", DwMacrangeTemplate.TpRegra.LIMITEGLOBAL.getId());
		
		List<DwMacrange> lista = q.list();
		PesquisasDTO retorno = new PesquisasDTO();
		retorno.setPesquisa(new ArrayList<PesquisaDTO>());
		for (DwMacrange range : lista) {
			PesquisaDTO dto = new PesquisaDTO();
			dto.setCodigo(range.getIdMacrange().toString());
			dto.setDescricao(range.getCdMacInicial());
			dto.setRegistro(range.clone(false));
			
			retorno.getPesquisa().add(dto);
		}
		
		return retorno;
	}
	
	public List<CodigoDescricaoDTO> getListaParadasAtivasPT(String cdMaquina) {
		List<CodigoDescricaoDTO> retorno = new ArrayList<CodigoDescricaoDTO>();
		
		int _codigo = 0;
		int _descricao = _codigo + 1;  
		
		String strSQL = "";
		strSQL = strSQL.concat("SELECT par.cd_tparada, par.ds_tparada "); 
		strSQL = strSQL.concat("  FROM dw_t_parada par ");
		strSQL = strSQL.concat("  JOIN om_tppt tppt ON (tppt.id_tppt = par.id_tppt) "); 
		strSQL = strSQL.concat("  JOIN om_pt pt ON (pt.id_tppt = tppt.id_tppt AND pt.st_ativo = 1 AND pt.cd_pt = :cdMaquina) ");
		strSQL = strSQL.concat(" WHERE par.st_ativo = 1 ");
		strSQL = strSQL.concat(" ORDER BY par.cd_tparada "); 
		
		List<Object> lista = new ArrayList<Object>(); 
		SQLQuery q = getSession().createSQLQuery(strSQL);
		q.setParameter("cdMaquina", cdMaquina);
		lista = q.list();
		
		for (Object reg : lista) {
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			CodigoDescricaoDTO cdds = new CodigoDescricaoDTO();
			cdds.setCodigo((String) registroLido[_codigo]); 
			cdds.setDescricao((String) registroLido[_descricao]); 
			
			retorno.add(cdds);			
		}
		
		q = null;
		lista = null;
		
		return retorno;
	}
 
	
	public DadosTempoRealDTO getDadosTempoReal(String cdMaquina) {
		DadosTempoRealDTO retorno = new DadosTempoRealDTO();
		
		int _prodliq = 0;
		int _stfunc = _prodliq + 1;
		int _idup = _stfunc + 1;
		int _dthripar = _idup + 1;
		int _dthrfpar = _dthripar + 1;
		int _cdpar = _dthrfpar + 1;
		int _cdcau = _cdpar + 1;
		int _cdacao = _cdcau + 1;
		int _cdjust = _cdacao + 1;
		int _isreg = _cdjust + 1;
		
		
		String strSQL = "";
		strSQL = strSQL.concat("SELECT rt.pcs_producaoliquida_op as prodliqop, rt.st_funcionamento, ");
		strSQL = strSQL.concat("       pt.cd_pt as id_up, par.dthr_iparada, par.dthr_fparada, tp.cd_tparada, tc.cd_tcausa, ta.cd_tacao, tj.cd_tjust, tp.is_regulagem ");		
		strSQL = strSQL.concat("  FROM (SELECT MAX(a.dthr_heartbeat) as dthr_heartbeat, MAX(a.dthr_evento) as dthr_evento");
		strSQL = strSQL.concat("          FROM dw_rt a ");
		strSQL = strSQL.concat("          JOIN om_pt b ON (b.id_pt = a.id_pt AND b.st_ativo = 1 AND b.cd_pt = :cdMaquina))  rtaux  ");
		strSQL = strSQL.concat("  JOIN dw_rt rt ON (rt.dthr_heartbeat = rtaux.dthr_heartbeat AND rt.dthr_evento = rtaux.dthr_evento) ");
		strSQL = strSQL.concat("  JOIN om_pt pt ON (pt.id_pt = rt.id_pt AND pt.st_ativo = 1 AND pt.cd_pt = :cdMaquina) "); 
		strSQL = strSQL.concat("  LEFT JOIN dw_consolpalog par ON (par.id_consolpalog = rt.id_consolpalog)  ");
		strSQL = strSQL.concat("  LEFT JOIN dw_t_parada tp ON (tp.id_tparada = par.id_tparada) ");
		strSQL = strSQL.concat("  LEFT JOIN dw_t_causa tc ON (tc.id_tcausa = par.id_tcausa) ");
		strSQL = strSQL.concat("  LEFT JOIN dw_t_acao ta ON (ta.id_tacao = par.id_tacao) ");
		strSQL = strSQL.concat("  LEFT JOIN dw_t_just tj ON (tj.id_tjust = par.id_tjust) ");
		
		List<Object> lista = new ArrayList<Object>(); 
		SQLQuery q = getSession().createSQLQuery(strSQL);
		q.setParameter("cdMaquina", cdMaquina);
		lista = q.list();
		
		if (lista.size() > 0) { 
			Object reg = lista.get(0);
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			retorno.setProdLiquida(ConversaoTipos.converterParaBigDecimal(registroLido[_prodliq]).intValue());
			retorno.setStFuncionamento(ConversaoTipos.converterParaBigDecimal(registroLido[_stfunc]).intValue());
			retorno.setIdUP((String) registroLido[_idup]);
			retorno.setDthrIPar("");
			retorno.setDthrFPar("");
			retorno.setCdParada("");
			retorno.setCdCausa("");
			retorno.setCdAcao("");
			retorno.setCdJust("");
			retorno.setRegulagem(false);
				
			
			if (registroLido[_dthripar] != null) {
				retorno.setDthrIPar(DataHoraRN.dateToStringYYYYMMDDHHMMSS((Date) registroLido[_dthripar]));				
			}
			
			if (registroLido[_dthrfpar] != null) {			
				retorno.setDthrFPar(DataHoraRN.dateToStringYYYYMMDDHHMMSS((Date) registroLido[_dthrfpar]));
			}
			
			if (registroLido[_cdpar] != null) {
				retorno.setCdParada((String) registroLido[_cdpar]);
			}

			if (registroLido[_cdcau] != null) {			
				retorno.setCdCausa((String) registroLido[_cdcau]);
			}
			
			if (registroLido[_cdacao] != null) {
				retorno.setCdAcao((String) registroLido[_cdacao]);			}
			
			if (registroLido[_cdjust] != null) {
				retorno.setCdJust((String) registroLido[_cdjust]);
			}
			
			if (registroLido[_isreg] != null) {
				retorno.setRegulagem(ConversaoTipos.converterParaBigDecimal(registroLido[_isreg]).intValue() == 1);
			}
		}
		
		q = null;
		lista = null;
		
		return retorno;
	}
}
