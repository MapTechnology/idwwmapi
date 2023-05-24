package idw.model.rn;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.hibernate.SQLQuery;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwFolhaDAO;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.dao.PpClienteDAO;
import idw.model.dao.PpCpDAO;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemSessaoHibernateException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwFolhasetup;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwProcativ;
import idw.model.pojos.DwProcedimento;
import idw.model.pojos.DwProrea;
import idw.model.pojos.DwRota;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.DwRt;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCliente;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpPre;
import idw.model.pojos.PpCpneccron;
import idw.model.pojos.PpCpnserie;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.PpNec;
import idw.model.pojos.PpNeccron;
import idw.model.pojos.PpPlano;
import idw.model.pojos.PpPlanptgt;
import idw.model.pojos.template.OmTpptTemplate;
import idw.model.pojos.template.PpCpTemplate;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.CpDTO;
import idw.webservices.dto.CpsDTO;
import idw.webservices.dto.DadosProdutoSADTO;
import idw.webservices.dto.DwFolhaDTO;
import idw.webservices.dto.ListaCPDTO;
import idw.webservices.dto.OrdemProducaoProdutoDTO;
import idw.webservices.dto.PpNecDTO;
import idw.webservices.dto.PpNecListDTO;
import idw.webservices.dto.ResultadoDTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.FolhaRapProdutoDTO;
import idw.webservices.rest.idw.v2.dto.ListaOPSimplesPesqDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;
import idw.webservices.rest.idw.v2.dto.OPCadDTO;
import idw.webservices.rest.idw.v2.dto.OPProdutoCadDTO;
import idw.webservices.rest.idw.v2.dto.OPPtCadDTO;
import idw.webservices.rest.idw.v2.dto.OPSimplesPesqDTO;
import idw.webservices.rest.idw.v2.dto.OpComRapDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.OPAutomaticaDTO;
import ms.model.rn.UpRN;
import ms.util.ConversaoTipos;

public class CpRN extends AbstractRN<DAOGenerico> implements IDao {
	public CpRN() {
		super(new DAOGenerico());
	}

	public CpRN(DAOGenerico dao) {
		super(dao);
	}

	public void determinaOStatusCP(IdwLogger log, int idLog, int identacao, PpCp ppcp, PpCpproduto ppcpproduto) {

		if (ppcpproduto.getOmProduto().getTpProducao() == null || ppcpproduto.getOmProduto().getTpProducao().equals(BigDecimal.ZERO)) { // producao
																																		// normal
			ppcp.setIsAntecipacao(false);
			ppcp.setIsBarrasete(false);
			ppcp.setIsCm(false);
			ppcp.setIsFinalserie(false);
			ppcp.setIsMassa(false);
			ppcp.setIsTryout(false);
			log.info(idLog, identacao, "Produçãoo normal, as outras opcoes sao try-out, massa, etc.");
		} else if (ppcpproduto.getOmProduto().getTpProducao().equals(BigDecimal.ONE)) { // producao try-out
			ppcp.setIsAntecipacao(false);
			ppcp.setIsBarrasete(false);
			ppcp.setIsCm(false);
			ppcp.setIsFinalserie(false);
			ppcp.setIsMassa(false);
			ppcp.setIsTryout(true);
			log.info(idLog, identacao, "Produçãoo try-out");
		} else if (ppcpproduto.getOmProduto().getTpProducao().equals(new BigDecimal(2))) { // producao massa
			ppcp.setIsAntecipacao(false);
			ppcp.setIsBarrasete(false);
			ppcp.setIsCm(false);
			ppcp.setIsFinalserie(false);
			ppcp.setIsMassa(true);
			ppcp.setIsTryout(false);
			log.info(idLog, identacao, "Produçãoo massa");
		} else if (ppcpproduto.getOmProduto().getTpProducao().equals(new BigDecimal(3))) { // producao final de linha
			ppcp.setIsAntecipacao(false);
			ppcp.setIsBarrasete(false);
			ppcp.setIsCm(false);
			ppcp.setIsFinalserie(true);
			ppcp.setIsMassa(false);
			ppcp.setIsTryout(false);
			log.info(idLog, identacao, "Produçãoo final de linha");
		}
	}

	public PpCp obtemFinalDaCpAnteriorA(IdwLogger log, int idLog, int identacao, List<PpCp> listaCps, PpCp cpReferencia) {
		// A listaCps ja deve estar em ordem decrescente pela DtHrInicio
		PpCp retorno = null;
		boolean isEncontrouCpReferencia = false;
		for (PpCp p : listaCps) {
			if (isEncontrouCpReferencia == true
					&& cpReferencia.getOmPt() != null) {
				if (p.getOmPt() != null
						&& cpReferencia.getOmPt().getIdPt()
								.equals(p.getOmPt().getIdPt())) {
					retorno = p;
					break;
				}
			}
			if (isEncontrouCpReferencia == true
					&& cpReferencia.getOmGt() != null) {
				if (p.getOmGt() != null
						&& cpReferencia.getOmGt().getIdGt()
								.equals(p.getOmGt().getIdGt())) {
					retorno = p;
					break;
				}
			}
			if (p.getIdCp().equals(cpReferencia.getIdCp()) == true) {
				log.info(idLog, identacao, "Encontrou a cp referencia"
						+ cpReferencia.getCdCp() + ". Procurando CP anterior.");
				isEncontrouCpReferencia = true;
			}
		}

		if (retorno != null) {
			log.info(idLog, identacao, "A CP anterior encontrada foi a " + retorno.getCdCp());
		} else {
			log.info(idLog, identacao, "Nenhuma CP anterior encontrada");
		}

		return retorno;
	}

	public PpCp encontrarUltimaCpProduto(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmProduto omproduto) {
		PpCp retorno = null;

		MapQuery q = new MapQuery(getDaoSession());

		q.append("select ppcp");
		q.append("from PpCp ppcp");
		q.append("join ppcp.ppCpprodutos ppcpproduto");
		q.append("where ppcp.stAtivo = 1");
		q.append("and ppcp.ppPlano = :ppplano");
		q.append("and ppcpproduto.omProduto = :omproduto");
		q.append("order by ppcp.idCp desc");
		q.setMaxResults(1);
		q.defineParametro("ppplano", ppplano);
		q.defineParametro("omproduto", omproduto);
		retorno = (PpCp) q.uniqueResult();

		return retorno;
	}

	public PpCp encontraCpSeguinte(IdwLogger log, int idLog, PpCp ppcp) {
		MapQuery q = new MapQuery(getDaoSession());

		q.append("select ppcp");
		q.append("from PpCp ppcp");

		q.appendWhere(MapQuery._NULL, "ppcp.omPt = :ompt",
				ppcp.getOmPt() != null);
		q.appendWhere(MapQuery._NULL, "ppcp.omGt = :omgt",
				ppcp.getOmGt() != null);
		q.appendWhere(MapQuery._AND, "ppcp.ppPlano = :ppplano", true);
		q.appendWhere(MapQuery._AND, "ppcp.stAtivo = 1", true);
		q.appendWhere(MapQuery._AND, "ppcp.dthrInicio > :dthrfinal", true);
		q.append("order by ppcp.dthrInicio");

		q.defineParametro("ompt", ppcp.getOmPt());
		q.defineParametro("omgt", ppcp.getOmGt());
		q.defineParametro("ppplano", ppcp.getPpPlano());
		q.defineParametroTimestamp("dthrfinal", ppcp.getDthrFinal());
		q.setMaxResults(1);

		PpCp retorno = (PpCp) q.uniqueResult();

		return retorno;
	}

	public CpsDTO pesquisarCpByProdutoFinal(String cdproduto) {
		CpsDTO retorno = new CpsDTO();

		MapQuery q = new MapQuery(getDaoSession());

		q.append("select A");
		q.append("from PpCp A");
		q.append("left join fetch A.omPt P");
		q.append("left join fetch A.omGt G");
		q.append("join fetch A.ppCpprodutos F");
		q.append("join fetch F.omProduto H");
		q.append("where H.cdProduto = :cdProduto");

		q.defineParametro("cdProduto", cdproduto);

		List<PpCp> lista = q.list();

		ResultadoDTO resultadoDTO = new ResultadoDTO();

		if (lista != null) {
			List<PpCp> listaClone = new ArrayList<PpCp>();
			for (PpCp item : lista) {
				listaClone.add(item.clone());
			}
			retorno.setListaCp(listaClone);
			resultadoDTO.setIdmensagem(resultadoDTO.getCOM_SUCESSO());
		} else {
			resultadoDTO.setIdmensagem(resultadoDTO.getCP_DESCONHECIDA());
		}

		retorno.setResultadoDTO(resultadoDTO);
		return retorno;
	}

	public CpsDTO pesquisarProximosCpsPorUsuario(String cdUsuario) {
		CpsDTO retorno = new CpsDTO();

		MapQuery q = new MapQuery(getDaoSession());

		q.append("SELECT DISTINCT a");
		q.append("FROM PpCp a");
		q.append("JOIN FETCH a.dwFolha b");
		q.append("JOIN FETCH b.dwProcedimento c");
		q.append("JOIN c.dwProcarhoms d");
		q.append("JOIN d.omCargo e");
		q.append("JOIN e.omUsrs f");
		q.append("WHERE f.cdUsr = :cdUsr");
		q.append("AND a.stAtivo = 1");
		q.append("AND (a.dthrIsetup IS NULL");
		q.append("OR a.dthrFsetup IS NULL)");
		q.append("AND ( a.omGt IS NOT NULL OR a.omPt IS NOT NULL ) ");
		q.append("and a.dthrInicio >= :dthr");
		q.append("AND b.dwProcedimento is not null");
		// q.append("and (dwprorea is null or (dwprorea is not null and dwprorea.stProrea = 0) )");
		q.append("ORDER BY a.dthrInicio");

		q.defineParametro("cdUsr", cdUsuario);
		q.defineParametroTimestamp("dthr", DataHoraRN.getDataSemHora(DataHoraRN.getDataHoraAtual()));

		List<PpCp> lista = q.list();

		// Prepara query para consultad consolids
		MapQuery qid = new MapQuery(getDaoSession());

		qid.append("select a");
		qid.append("from DwConsolid a");
		qid.append("join a.dwProreas b");
		qid.append("where a.omPt = :ompt");
		qid.append("and a.ppCp = :ppcp");
		qid.append("and a.tpId = 1");

		ResultadoDTO resultadoDTO = new ResultadoDTO();

		if (lista != null) {
			List<PpCp> listaClone = new ArrayList<PpCp>();
			for (PpCp item : lista) {

				// Clona ppCp
				PpCp cp = item.clone(false);
				if (item.getOmGt() != null) {
					cp.setOmGt(item.getOmGt().clone(false));
				}
				if (item.getOmPt() != null) {
					cp.setOmPt(item.getOmPt().clone(false));
				}
				if (item.getDwFolha() != null && item.getDwFolha().getDwProcedimento() != null) {
					DwFolha dwFolha = new DwFolha();
					dwFolha = item.getDwFolha().clone(false);
					DwProcedimento dwProcedimento = new DwProcedimento();
					dwProcedimento = item.getDwFolha().getDwProcedimento().clone(true);
					for (DwProcativ ativ : dwProcedimento.getDwProcativs()) {
						ativ.setDwDetativs(null);
					}
					dwFolha.setDwProcedimento(dwProcedimento);
					cp.setDwFolha(dwFolha);
				}

				// Consulta se existe algum consolid com procedimento realizado
				qid.defineParametro("ompt", item.getOmPt());
				qid.defineParametro("ppcp", item);
				List<DwConsolid> listaIds = qid.list();
				if (listaIds != null && listaIds.size() > 0) {

					cp.setDwConsolids(new HashSet<DwConsolid>());

					for (DwConsolid itemList : listaIds) {

						DwConsolid dwConsolid = itemList.clone(false);
						dwConsolid.setDwProreas(new HashSet<DwProrea>());

						if (itemList.getDwProreas() != null && itemList.getDwProreas().size() > 0) {

							for (DwProrea dwProrea : itemList.getDwProreas()) {
								DwProrea prorea = dwProrea.clone(true);
								dwConsolid.getDwProreas().add(prorea);
							}
						}

						cp.getDwConsolids().add(dwConsolid);
					}
				}
				listaClone.add(cp);
			}
			retorno.setListaCp(listaClone);
			resultadoDTO.setIdmensagem(resultadoDTO.getCOM_SUCESSO());
		} else {
			resultadoDTO.setIdmensagem(resultadoDTO.getCP_DESCONHECIDA());
		}

		retorno.setResultadoDTO(resultadoDTO);
		return retorno;
	}

	public PpNecListDTO pesquisarTodosCpComPedidoAtivo() {
		PpNecListDTO retorno = new PpNecListDTO();
		MapQuery q = new MapQuery(getDaoSession());

		q.append("select distinct ppnec");
		q.append("from PpNec ppnec");
		q.append("join fetch ppnec.omProduto produto");
		q.append("join ppnec.ppNeccrons ppneccron");
		q.append("join ppneccron.ppPlaneccrons ppplaneccron");
		q.append("join ppplaneccron.ppCpneccrons ppcpneccron");
		q.append("join ppcpneccron.ppCp ppcp");
		q.append("join ppcp.ppPlano plano");
		q.append("where ppnec.stAtivo = 1");
		q.append("and ppcp.stAtivo =1");
		q.append("and plano.stAtivo =1");
		// q.append("and ppnec.idNec = 1225");

		List<PpNec> listappnec = q.list();

		if (listappnec != null && listappnec.size() > 0) {

			boolean control = false;
			Date dataAtual = DataHoraRN.setHoraNaData(new Date(), 0, 0, 0, 0);

			retorno.setPpNecDTO(new ArrayList<PpNecDTO>());

			for (PpNec c : listappnec) {

				for (PpNeccron neccron : c.getPpNeccrons()) {
					if (DataHoraRN.after(neccron.getDtDesejada(), dataAtual)) {
						control = true;
						break;
					}
				}

				if (control == true) {
					PpNec clone = c.clone(false);

					OmProduto prod = c.getOmProduto().clone();
					clone.setOmProduto(prod);

					PpNecDTO necdto = new PpNecDTO(clone);

					retorno.getPpNecDTO().add(necdto);
				}
			}
		}

		return retorno;
	}

	public ListaCPDTO pesquisarCpComPedido(PpCp cp) {

		ListaCPDTO retorno = new ListaCPDTO();

		MapQuery q = new MapQuery(getDaoSession());

		q.append("select ppnec.idNec");
		q.append("from PpNec ppnec");
		q.append("join ppnec.ppNeccrons ppneccron");
		q.append("join ppneccron.ppPlaneccrons ppplaneccron");
		q.append("join ppplaneccron.ppCpneccrons ppcpneccron");
		q.append("join ppcpneccron.ppCp ppcp");
		q.append("where ppcp.idCp = :idcp");

		// Primeiro descobre a quais necessidade a cp estÃ¡ atendendo
		q.defineParametro("idcp", cp.getIdCp());

		List<Long> listappnec = q.list();

		// Depois obtem todas as cps que atendem a necessidade em questao
		q.novaConsulta();
		q.append("select distinct A");
		q.append("from PpCp A");
		q.append("left join fetch A.omPt P");
		q.append("left join fetch A.omGt G");
		q.append("join fetch  A.ppCpneccrons B");
		q.append("join fetch B.ppPlaneccron C");
		q.append("join fetch C.ppNeccron D");
		q.append("join fetch D.ppNec E");
		q.append("join fetch E.omProduto F");
		q.append("where E.idNec in (:lista)");
		q.append("and A.stAtivo = 1");
		q.append("and A.ppPlano.idPlano = :ppPlan");

		q.query().setParameterList("lista", listappnec);
		q.defineParametro("ppPlan", cp.getPpPlano().getIdPlano());

		List<PpCp> listappcp = q.list();

		ResultadoDTO resultadoDTO = new ResultadoDTO();

		if (listappcp != null && listappcp.size() > 0) {

			retorno.setListaCps(new ArrayList<CpDTO>());

			for (PpCp c : listappcp) {
				PpCp clone = c.clone(false);

				if (c.getOmPt() != null) {
					clone.setOmPt(c.getOmPt().clone(false));
					clone.getOmPt().setPpCps(null);
				}
				if (c.getOmGt() != null)
					clone.setOmGt(c.getOmGt().clone(false));

				for (PpCpproduto prod : c.getPpCpprodutos()) {
					clone.getPpCpprodutos().add(prod.clone());
				}

				if ((c.getPpCpneccrons() != null) && (!c.getPpCpneccrons().isEmpty())) {
					clone.setPpCpneccrons(new HashSet<PpCpneccron>());
					for (PpCpneccron p : c.getPpCpneccrons()) {

						PpCpneccron ppCpneccronClone = p.clone(true);
						ppCpneccronClone.setPpPlaneccron(p.getPpPlaneccron().clone(true));

						ppCpneccronClone
								.getPpPlaneccron()
								.getPpNeccron()
								.setPpNec(
										p.getPpPlaneccron().getPpNeccron()
												.getPpNec().clone(true));
						clone.getPpCpneccrons().add(ppCpneccronClone);

					}

				}

				CpDTO cpdto = new CpDTO();
				cpdto.setCp(clone);
				retorno.getListaCps().add(cpdto);
				resultadoDTO.setIdmensagem(resultadoDTO.COM_SUCESSO);
			}
		} else {

			resultadoDTO.setIdmensagem(resultadoDTO.CP_DESCONHECIDA);
		}

		retorno.setResultado(resultadoDTO);

		return retorno;

	}

	public ListaCPDTO pesquisaListaPredecessoraCP(Long idCp) {

		ListaCPDTO retorno = new ListaCPDTO();

		MapQuery q = new MapQuery(getDaoSession());

		q.append("select pre");
		q.append("from PpCpPre pre");
		q.append("join fetch pre.ppCpByIdCppredecessora A");
		q.append("left join fetch A.omPt P");
		q.append("left join fetch A.omGt G");
		q.append("join fetch A.ppCpprodutos ppcpproduto");
		q.append("join fetch A.dwFolha dwfolha");
		q.append("join fetch A.dwRota dwRota");
		q.append("join fetch dwfolha.dwRotapassos dwrotapasso");
		q.append("join fetch dwrotapasso.dwRota dwrota");
		q.append("join fetch ppcpproduto.omProduto omproduto");
		q.append("where pre.ppCpByIdCp.idCp = :idCp");
		q.append("and A.stAtivo = 1");
		q.append("and dwfolha.stAtivo = 1");
		q.append("and dwrota.idRota = dwRota.idRota");
		q.append("and dwrota.stAtivo = 1");

		q.defineParametro("idCp", idCp);

		List<PpCpPre> lista = q.list();

		List<CpDTO> cps = new ArrayList<CpDTO>();

		for (PpCpPre p : lista) {
			PpCp ppcp = p.getPpCpByIdCppredecessora().clone(false);
			if (p.getPpCpByIdCppredecessora().getOmGt() != null)
				ppcp.setOmGt(p.getPpCpByIdCppredecessora().getOmGt().clone(false));

			if (p.getPpCpByIdCppredecessora().getOmPt() != null)
				ppcp.setOmPt(p.getPpCpByIdCppredecessora().getOmPt().clone(false));

			if (p.getPpCpByIdCppredecessora().getDwFolha() != null) {
				ppcp.setDwFolha(p.getPpCpByIdCppredecessora().getDwFolha().clone());
			}

			for (DwRotapasso dwrotapasso : p.getPpCpByIdCppredecessora().getDwFolha().getDwRotapassos()) {
				DwRotapasso rotapasso = dwrotapasso.clone();
				rotapasso.setDwRota(dwrotapasso.getDwRota().clone());
				ppcp.getDwFolha().getDwRotapassos().add(rotapasso);
			}

			if (p.getPpCpByIdCppredecessora().getDwRota() != null) {
				ppcp.setDwRota(p.getPpCpByIdCppredecessora().getDwRota().clone(false));
			}

			Set<PpCpproduto> prods = new HashSet<PpCpproduto>();
			for (PpCpproduto pr : p.getPpCpByIdCppredecessora().getPpCpprodutos()) {
				OmProduto omproduto = pr.getOmProduto().clone();
				PpCpproduto clone = pr.clone(false);
				clone.setOmProduto(omproduto);
				prods.add(clone);
			}
			ppcp.setPpCpprodutos(prods);

			CpDTO cpdto = new CpDTO();
			cpdto.setCp(ppcp);
			cps.add(cpdto);
		}
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultado(resultadoDTO);
		retorno.setListaCps(cps);

		q.novaConsulta();
		q.append("select pre");
		q.append("from PpCpPre pre");
		q.append("join fetch pre.ppCpByIdCp A");
		q.append("left join fetch A.omPt P");
		q.append("left join fetch A.omGt G");
		q.append("join fetch A.ppCpprodutos ppcpproduto");
		q.append("join fetch ppcpproduto.omProduto omproduto");
		q.append("where pre.ppCpByIdCppredecessora.idCp = :idCp");
		q.append("and A.stAtivo = 1");

		q.defineParametro("idCp", idCp);

		lista = q.list();

		cps = new ArrayList<CpDTO>();

		for (PpCpPre p : lista) {
			PpCp ppcp = p.getPpCpByIdCp().clone(false);

			if (p.getPpCpByIdCp().getOmGt() != null)
				ppcp.setOmGt(p.getPpCpByIdCp().getOmGt().clone(false));

			if (p.getPpCpByIdCp().getOmPt() != null)
				ppcp.setOmPt(p.getPpCpByIdCp().getOmPt().clone(false));

			Set<PpCpproduto> prods = new HashSet<PpCpproduto>();
			for (PpCpproduto pr : p.getPpCpByIdCp().getPpCpprodutos()) {
				OmProduto omproduto = pr.getOmProduto().clone();
				PpCpproduto clone = pr.clone(false);
				clone.setOmProduto(omproduto);
				prods.add(clone);
			}
			ppcp.setPpCpprodutos(prods);

			CpDTO cpdto = new CpDTO();
			cpdto.setCp(ppcp);
			cps.add(cpdto);
			retorno.setListaCpsAux(cps);
		}
		return retorno;
	}

	/*
	 * Metodo usado para adiantar o inicio de um OP
	 */
	public void updatePpCpComNovoInicio(PpCp pp) {

		MapQuery q = new MapQuery(getDaoSession());
		q.append("update PpCp ppcp");
		q.append("set ppcp.dthrInicio= :idDthrInicio,");
		q.append("ppcp.dthrFinal= :idDthrFinal,");
		q.append("ppcp.stAtivo = 1");
		q.append("where ppcp.idCp = :idPpCp");

		q.defineParametro("idDthrInicio", pp.getDthrInicio());
		q.defineParametro("idDthrFinal", pp.getDthrFinal());
		q.defineParametro("idPpCp", pp.getIdCp());
		q.query().executeUpdate();
	}

	public PpCp pesquisarPpCpByIdCp(PpCp cp) {
		PpCp retorno = null;
		if (cp == null) {
			return null;
		}

		MapQuery q = new MapQuery(getDaoSession());

		q.append("select cp");
		q.append("from PpCp cp");
		q.append("join fetch cp.dwRota dwrota");
		q.append("join fetch cp.dwFolha dwfolha");
		q.append("left join fetch cp.omPt ompt");
		q.append("left join fetch cp.omGt omgt");
		q.append("join fetch dwfolha.dwRotapassos dwrotapasso");
		q.append("join fetch dwrotapasso.dwRota rota");
		q.append("where cp.idCp = :idcp");
		q.append("and dwrota.stAtivo = 1");
		q.append("and dwfolha.stAtivo = 1");
		q.append("and dwrota.idRota = rota.idRota");

		q.defineParametro("idcp", cp.getIdCp());
		q.setMaxResults(1);

		retorno = (PpCp) q.uniqueResult();

		return retorno;

	}

	public PpCpproduto pesquisarPpCpByIdCpEIdPt(Long idcp, Long idpt) {
		PpCpproduto retorno = null;

		MapQuery q = new MapQuery(getDaoSession());

		q.append("select ppcpproduto");
		q.append("from PpCpproduto ppcpproduto");
		q.append("left join fetch ppcpproduto.ppCp ppcp");
		q.append("left join fetch ppcp.omPt ompt");
		q.append("where ppcp.idCp = :idCp");
		q.append("and ompt.idPt = :idPt");
		q.append("and ppcp.stAtivo = 1");
		q.append("ORDER BY ppcpproduto.idCpproduto DESC");

		q.defineParametro("idCp", idcp);
		q.defineParametro("idPt", idpt);
		q.setMaxResults(1);

		retorno = (PpCpproduto) q.uniqueResult();

		return retorno;

	}

	public PpCp pesquisarPpCpeProdutoByIdCp(PpCp cp) {
		PpCp retorno = null;
		if (cp == null) {
			return null;
		}

		MapQuery q = new MapQuery(getDaoSession());

		q.append("select cp");
		q.append("from PpCp cp");
		q.append("join fetch cp.ppCpprodutos ppcpproduto");
		q.append("where cp.idCp = :idcp");
		q.append("and cp.stAtivo = 1");

		q.defineParametro("idcp", cp.getIdCp());
		q.setMaxResults(1);

		retorno = (PpCp) q.uniqueResult();

		return retorno;

	}

	public PpCp pesquisarPpCpByIdCpForSetup(PpCp cp) {
		PpCp retorno = null;
		if (cp == null) {
			return null;
		}

		MapQuery q = new MapQuery(getDaoSession());

		q.append(" select cp ");
		q.append(" from PpCp cp ");
		q.append(" join fetch cp.dwFolha dwfolha ");
		q.append(" left join fetch cp.omGt omgt ");
		q.append(" left join fetch cp.omPt ompt ");
		q.append(" left join fetch dwfolha.dwProcedimento dwProcedimento ");
		q.append(" where cp.idCp = :idcp ");

		q.defineParametro("idcp", cp.getIdCp());
		q.setMaxResults(1);

		retorno = (PpCp) q.uniqueResult();

		return retorno;

	}

	public List<String> pesquisarPpCpIntervaloDatas(Date rfInicio, Date rfFim) {

		List<String> cp = new ArrayList<String>();

		MapQuery q = new MapQuery(getDaoSession());

		// q.append("select distinct cp ");
		// q.append("from PpCp cp ");
		// q.append("join fetch cp.ppPlano plano ");
		// q.append("join fetch cp.ppCpprodutos prod ");
		// q.append("join fetch prod.omProduto p ");
		// q.append("join cp.ppCpneccrons pcpnecrons ");
		// q.append("join pcpnecrons.ppPlaneccron ppplaneccron ");
		// q.append("join ppplaneccron.ppNeccron ppneccron ");
		// q.append("join ppneccron.ppNec ppnec ");
		// q.append("join ppnec.omProduto produtoNec ");
		// q.append("left join cp.omGt gt ");
		// q.append("left join cp.omPt pt ");
		// q.append("left join cp.dwCal cal ");
		// q.append("left join cal.dwCalsems calS ");
		// q.append("join fetch cp.dwFolha folha ");
		// q.append("where cp.stAtivo = 1 and plano.stAtivo = 1 ");
		// q.append("and (gt.stAtivo = 1 or pt.stAtivo=1) ");
		// q.append("and folha.stAtivo =1 ");
		// q.append("and ( (:dtRefInicio between cp.dthrInicio and cp.dthrFinal ) ");
		// q.append(" or (cp.dthrInicio between :dtRefInicio and :dtRefFim) ");
		// q.append("or (:dtRefFim between cp.dthrInicio and cp.dthrFinal) ");
		// q.append("or (cp.dthrFinal between :dtRefInicio and :dtRefFim) ) ");
		// q.append(" order by produtoNec.cdProduto asc, cp.dthrInicio desc ");
		q.append("select distinct a.cdCp");
		q.append("from PpCp a");
		q.append("where a.stAtivo=1");
		q.append("and a.dtRevisao between :dtRefInicio and :dtRefFim");
		q.append("order by a.cdCp asc");

		q.defineParametro("dtRefInicio", getDataInicial(rfInicio));
		q.defineParametro("dtRefFim", getDataFinal(rfFim));

		cp = q.list();

		return cp;
	}

	public List<PpCp> pesquisarPpCpIntervaloDatasByProdutoFinal(Date rfInicio, Date rfFim, PpNec ppnec) {

		List<PpCp> cpFinal = new ArrayList<PpCp>();
		List<PpCp> cpRetorno = new ArrayList<PpCp>();

		MapQuery q = new MapQuery(getDaoSession());

		q.append("select cp ");
		q.append("from PpCp cp ");
		q.append("join fetch cp.ppPlano plano");
		q.append("join fetch cp.ppCpprodutos prod ");
		q.append("join fetch prod.omProduto p");
		// q.append("join cp.ppCpneccrons pcpnecrons");
		// q.append("join pcpnecrons.ppPlaneccron ppplaneccron");
		// q.append("join ppplaneccron.ppNeccron ppneccron");
		// q.append("join ppneccron.ppNec ppnec");
		// q.append("join ppnec.omProduto produtoNec");
		q.append("left join cp.omGt gt");
		q.append("left join cp.omPt pt");
		// q.append("left join cp.dwCal cal");
		// q.append("left join cal.dwCalsems calS");
		q.append("join fetch cp.dwFolha folha");
		q.append("where cp.stAtivo = 1 and plano.stAtivo = 1");
		// q.append(" and p.cdProduto = produtoNec.cdProduto");
		q.append("and (gt.stAtivo = 1 or pt.stAtivo=1) ");
		q.append("and folha.stAtivo =1 ");
		/*
		 * if (ppnec.getIdNec() != null) q.append("and ppnec.idNec =:idnec "); else // q.append("and produtoNec.cdProduto =:cdProd ");
		 */
		q.append("and p.cdProduto =:cdProd ");
		q.append("and ( (:dtRefInicio between cp.dthrInicio and cp.dthrFinal ) ");
		q.append(" or (cp.dthrInicio between :dtRefInicio and :dtRefFim) ");
		q.append("or (:dtRefFim between cp.dthrInicio and cp.dthrFinal) ");
		q.append("or (cp.dthrFinal between :dtRefInicio and :dtRefFim) ) ");
		q.append(" order by cp.dthrInicio desc, cp.dthrFinal desc");

		q.defineParametro("dtRefInicio", getDataInicial(rfInicio));
		q.defineParametro("dtRefFim", getDataFinal(rfFim));
		// if (ppnec.getIdNec() == null){
		q.defineParametro("cdProd", ppnec.getOmProduto().getCdProduto());
		// }else
		// q.defineParametro("idnec", ppnec.getIdNec());

		cpFinal = q.list();

		for (PpCp cp : cpFinal) {
			PpCp cpPai = cp.clone();
			cpRetorno.add(cpPai);
			pesqPredecessora(cpPai, rfInicio, rfFim, cpRetorno);
		}

		return cpRetorno;
	}

	public void pesqPredecessora(PpCp cpPai, Date rfInicio, Date rfFim, List<PpCp> cpPredecessora) {

		List<PpCpPre> cpResulPred;

		if (cpPredecessora == null)
			cpPredecessora = new ArrayList<PpCp>();

		cpResulPred = pesqCpPredecessora(cpPai.getIdCp(), rfInicio, rfFim);

		for (PpCpPre cpPre : cpResulPred) {

			PpCp cpFilho = cpPre.getPpCpByIdCppredecessora().clone();
			cpFilho.setPpCpPresForIdCp(new HashSet<PpCpPre>(0));
			cpFilho.getPpCpPresForIdCp().add(cpPre);
			cpPredecessora.add(cpFilho);
			pesqPredecessora(cpFilho, rfInicio, rfFim, cpPredecessora);

		}
	}

	public List<PpCpPre> pesqCpPredecessora(long idCp, Date rfInicio, Date rfFim) {

		List<PpCpPre> result = new ArrayList<PpCpPre>();

		MapQuery q = new MapQuery(getDaoSession());

		q.append("select pre");
		q.append("from PpCpPre pre");
		q.append("join fetch pre.ppCpByIdCppredecessora A ");
		q.append("join fetch A.ppPlano plano");
		q.append("left join fetch A.omPt P");
		q.append("left join fetch A.omGt G");
		q.append("join fetch A.ppCpprodutos ppcpproduto");
		q.append("join fetch A.dwFolha dwfolha");
		q.append("join fetch ppcpproduto.omProduto omproduto");
		q.append("where pre.ppCpByIdCp.idCp = :idCp");
		q.append("and A.stAtivo = 1 and plano.stAtivo = 1");
		q.append("and (G.stAtivo = 1 or P.stAtivo=1) ");
		q.append("and dwfolha.stAtivo = 1");
		q.append("and ( (:dtRefInicio between A.dthrInicio and A.dthrFinal ) ");
		q.append(" or (A.dthrInicio between :dtRefInicio and :dtRefFim) ");
		q.append("or (:dtRefFim between A.dthrInicio and A.dthrFinal) ");
		q.append("or (A.dthrFinal between :dtRefInicio and :dtRefFim) ) ");
		q.append(" order by A.dthrInicio desc, A.dthrFinal desc");

		q.defineParametro("idCp", idCp);
		q.defineParametro("dtRefInicio", getDataInicial(rfInicio));
		q.defineParametro("dtRefFim", getDataFinal(rfFim));

		result = q.list();

		return result;
	}

	public static Date getDataInicial(Date data) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	public static Date getDataFinal(Date data) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	public List<PpCp> encontraCpsSeguintesOrdenado(PpCp ppcp) {

		MapQuery q = new MapQuery(getDaoSession());

		q.append("select ppcp");
		q.append("from PpCp ppcp");

		q.appendWhere(MapQuery._NULL, "ppcp.omPt = :ompt",
				ppcp.getOmPt() != null);
		q.appendWhere(MapQuery._NULL, "ppcp.omGt = :omgt",
				ppcp.getOmGt() != null);
		q.appendWhere(MapQuery._AND, "ppcp.ppPlano = :ppplano", true);
		q.appendWhere(MapQuery._AND, "ppcp.stAtivo = 1", true);
		q.appendWhere(MapQuery._AND, "ppcp.dthrInicio > :dthrfinal", true);
		q.append("order by ppcp.dthrInicio");

		q.defineParametro("ompt", ppcp.getOmPt());
		q.defineParametro("omgt", ppcp.getOmGt());
		q.defineParametro("ppplano", ppcp.getPpPlano());
		q.defineParametroTimestamp("dthrfinal", ppcp.getDthrFinal());

		List<PpCp> retorno = q.list();

		return retorno;
	}

	/*
	 * Metodo para salvar uma CP cadastrada manualmente
	 */
	public void salvarNovaCp(PpCp ppcpParam) {
		ProdutoRN rn = new ProdutoRN(getDao());
		UsuarioRN rnUsu = new UsuarioRN(getDao());
		PTRN rnPt = new PTRN(getDao());
		GTRN rnGt = new GTRN();
		PlanoProducaoRN rnPla = new PlanoProducaoRN(getDao());
		FolhaRN rnFol = new FolhaRN(getDao());

		rnGt.setSession(getDaoSession());
		if (ppcpParam != null && ppcpParam.getPpPlano() != null && ppcpParam.getPpPlano().getIdPlano() != null)
			rnPla.setIdPlano(ppcpParam.getPpPlano().getIdPlano());

		// Pesquisa os usuarios
		PpCp ppcp = new PpCp();
		ppcp.setCdCp(ppcpParam.getCdCp());
		ppcp.setDthrFinal(ppcpParam.getDthrFinal());
		ppcp.setDthrInicio(ppcpParam.getDthrInicio());
		ppcp.setDtRevisao(DataHoraRN.getDataHoraAtual());
		ppcp.setDtStativo(DataHoraRN.getDataHoraAtual());
		if (ppcpParam != null && ppcpParam.getPpPlano() != null && ppcpParam.getPpPlano().getIdPlano() != null)
			ppcp.setPpPlano(rnPla.pesquisarPlanoById());
		else
			ppcp.setPpPlano(null);
		if (ppcpParam.getOmPt() != null)
			try {
				ppcp.setOmPt(rnPt.getOmPt(ppcpParam.getOmPt().getCdPt()));
			} catch (RegistroDesconhecidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		ppcp.setOmUsrByIdUsrrevisao(rnUsu.getOmUsr(ppcpParam.getOmUsrByIdUsrrevisao().getIdUsr()));
		ppcp.setOmUsrByIdUsrstativo(ppcp.getOmUsrByIdUsrrevisao());
		ppcp.setIsAntecipacao(false);
		ppcp.setStCp(0); // cadastrada
		ppcp.setTpCp(0); // verificar se eh zero mesmo
		ppcp.setIsFinalserie(false);
		ppcp.setIsMassa(false);
		ppcp.setIsTryout(false);
		ppcp.setIsCm(false);
		ppcp.setIsBarrasete(false);
		ppcp.setDwRota(null);
		ppcp.setIsFaltamp(false);
		ppcp.setIsApAberta(false);
		ppcp.setPpCpprodutos(new HashSet<PpCpproduto>());
		ppcp.setRevisao(1l);
		ppcp.setStAtivo((byte) 1);

		PpCliente ppCliente = null;
		OmProduto omproduto = null;
		for (PpCpproduto pp : ppcpParam.getPpCpprodutos()) {
			// Pesquisa o produto
			omproduto = rn.getProdutoByDepara(pp.getOmProduto().getCdProduto());
			ppCliente = omproduto.getPpCliente();
			pp.setIdCpproduto(null);
			pp.setOmProduto(omproduto);
			pp.setPpCp(ppcp);

			ppcp.getPpCpprodutos().add(pp);
		}
		ppcp.setPpCliente(ppCliente);
		// Encontra a folha
		String cdFolha = omproduto.getCdProduto() + "-" + ppcp.getOmPt().getOmTppt().getCdTppt();
		DwFolha dwfolha = rnFol.pesquisaFolhaByCdEStSemRota(cdFolha);
		ppcp.setDwFolha(dwfolha);

		// Verifica se o plano possui as abas definidas, senao definir para a CP nova aparecer se for soh ela
		if (ppcp.getPpPlano().getPpPlanptgts().isEmpty() == true) {
			PpPlanptgt pojo = new PpPlanptgt();
			pojo.setAba("Geral");
			pojo.setColuna(BigDecimal.ONE);
			pojo.setIdPlanptgt(null);
			pojo.setIsCoordenadarelativa(true);
			pojo.setLinha(BigDecimal.ONE);
			pojo.setOmGt(ppcp.getOmGt());
			pojo.setOmPt(ppcp.getOmPt());
			pojo.setPpPlano(ppcp.getPpPlano());

			getDao().makePersistent(pojo);
		} else {
			// Se ja existir, verificar se a maquina solicitada ja esta no layout Geral
			boolean isExiste = false;
			int coluna = 0;
			for (PpPlanptgt pojo : ppcp.getPpPlano().getPpPlanptgts()) {
				coluna++;
				if (pojo.getOmPt().equals(ppcp.getOmPt()))
					isExiste = true;
			}
			if (isExiste == false) {
				PpPlanptgt pojo = new PpPlanptgt();
				pojo.setAba("Geral");
				pojo.setColuna(new BigDecimal(coluna));
				pojo.setIdPlanptgt(null);
				pojo.setIsCoordenadarelativa(true);
				pojo.setLinha(BigDecimal.ONE);
				pojo.setOmGt(ppcp.getOmGt());
				pojo.setOmPt(ppcp.getOmPt());
				pojo.setPpPlano(ppcp.getPpPlano());

				getDao().makePersistent(pojo);
			}
		}
		getDao().makePersistent(ppcp);
	}

	public PpCp pesquisarPpCpByCdCpCdPt(String cdcp, String cdPt) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select ppcp");
		q.append("from PpCp ppcp");
		q.append("join ppcp.omPt ompt");
		q.append("where ppcp.cdCp = :cdcp");
		q.append("and ompt.cdPt = :cdpt");
		q.append("and ppcp.stAtivo = 1");

		q.defineParametro("cdcp", cdcp);
		q.defineParametro("cdpt", cdPt);
		q.setMaxResults(1);
		return (PpCp) q.uniqueResult();
	}

	public static void main(String[] args) {
		CpRN rn = new CpRN();
		rn.iniciaConexaoBanco();
		rn.pesquisarPpCpByNrDocCdPt("000004", "107");
		rn.finalizaConexaoBanco();
	}

	public PpCp pesquisarPpCpByNrDocCdPt(String cdcp, String cdPt) {
		// se nao foi passada a op entao ja retornar null
		if (cdcp == null)
			return null;

		MapQuery q = null;
		if (getDaoSession() != null)
			q = new MapQuery(getDaoSession());
		else {
			try {
				q = new MapQuery(getDaoSessionStatless());
			} catch (SemSessaoHibernateException e) {
			}
		}

		q.append("select ppcp");
		q.append("from PpCp ppcp");
		q.append("join ppcp.omPt ompt");
		q.append("join fetch ppcp.ppCpprodutos ppcpproduto");
		q.append("where ppcpproduto.nrDoc = :cdcp");
		q.append("and ompt.cdPt = :cdpt");
		q.append("and ppcp.stAtivo = 1");
		q.append("and ompt.stAtivo = 1");

		q.defineParametro("cdcp", cdcp); // tinha upper mas tirei pq nao encontrava
		q.defineParametro("cdpt", cdPt);
		q.setMaxResults(1);
		PpCp retorno = (PpCp) q.uniqueResult();
		return retorno;
	}

	public PpCp pesquisarPpCpByNrDocCdPtClone(String cdcp, String cdPt) {
		PpCp retorno = pesquisarPpCpByNrDocCdPt(cdcp, cdPt).clone();

		return retorno;
	}

	// Retorna as ops disponiveis para a linha. No caso a referencia sera o PT que troca OP pra linha
	public ListaCPDTO getOpsGT(String cdgt) {
		// Pesquisa qual o pt que aponta op pra linha
		PTRN rn = new PTRN(getDao());
		OmPt ompt = rn.pesquisarPtApontaOp(cdgt);

		if (ompt == null) {
			ListaCPDTO retorno = new ListaCPDTO();
			return retorno;
		}

		return getPpCpByCdPt(ompt);
	}

	public ListaCPDTO getPpCpByCdPt(OmPt ompt) {
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		PTRN prn = new PTRN(this.getDao());
		OmPt omptPesq;
		try {
			omptPesq = prn.getOmPt(ompt.getCdPt(), true);
		} catch (RegistroDesconhecidoException e) {
			omptPesq = null;
		}
		List<PpCp> lista = pesquisarPpCpByCdPt(ompt);
		ListaCPDTO retorno = new ListaCPDTO();
		retorno.setListaCps(new ArrayList<CpDTO>());
		for (PpCp ppcp : lista) {
			CpDTO dto = new CpDTO();
			dto.setCp(ppcp.clone(true)); // para trazer os produtos
			retorno.getListaCps().add(dto);
		}

		if (omptPesq != null &&
				(omptPesq.getIsSemop() != null && omptPesq.getIsSemop() == true) ||
				omptPesq.getPpCp() == null ||
				omptPesq.getIsSemop() == null) {
			retorno.setIsPtSemop(true);
		}

		if (omptPesq.getOmTppt().getIsIhmtrocaop() != null)
			retorno.setIsIhmtrocaop(omptPesq.getOmTppt().getIsIhmtrocaop());
		else
			retorno.setIsIhmtrocaop(omcfg.getIsIhmtrocaop());

		return retorno;
	}

	/*
	 * Metodo usado para retornar todas as ORDENS DE PRODUCAO ativas para determinada maquina
	 */
	public List<PpCp> pesquisarPpCpByCdPt(OmPt ompt) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select ppcp");
		q.append("from PpCp ppcp");
		q.append("join fetch ppcp.omPt ompt");
		q.append("where");
		q.append("ompt.cdPt = :cdpt");
		q.append("and ppcp.stAtivo = 1");
		q.append("and ompt.stAtivo = 1");
		q.append("order by ppcp.idCp desc");
		q.setMaxResults(100);
		q.defineParametro("cdpt", ompt.getCdPt());
		return q.list();
	}

	public PpCp pesquisarPpCpByCdCp(PpCp ppcp) {
		MapQuery q = new MapQuery(getDaoSession());

		q.append("select ppcp");
		q.append("from PpCp ppcp");
		q.append("where ppcp.cdCp = :cdcp");
		q.append("and ppcp.stAtivo = 1");

		q.defineParametro("cdcp", ppcp.getCdCp());
		q.setMaxResults(1);
		return (PpCp) q.uniqueResult();
	}

	public List<PpCp> pesquisarPpCpQuePassaramNaData(Date inicio, Date fim) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select distinct ppcp");
		q.append("from PpCp ppcp");
		q.append("join ppcp.dwConsolids dwconsolid");
		q.append("where dwconsolid.tpId = 1");
		q.append("and dwconsolid.dtReferencia between :inicio and :fim");
		q.defineParametroData("inicio", inicio);
		q.defineParametroData("fim", fim);
		List<PpCp> lista = q.list();
		return lista;
	}

	public List<PpCp> pesquisarPpCpQuePassaramNaDataDoPt(Date inicio, Date fim, OmPt ompt) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select distinct ppcp");
		q.append("from PpCp ppcp");
		q.append("join ppcp.dwConsolids dwconsolid");
		q.append("where dwconsolid.tpId = 1");
		q.append("and dwconsolid.dtReferencia between :inicio and :fim");
		q.append("and ppcp.omPt.cdPt = :cdpt");
		q.defineParametroData("inicio", inicio);
		q.defineParametroData("fim", fim);
		q.defineParametro("cdpt", ompt.getCdPt());
		List<PpCp> lista = q.list();
		return lista;
	}

	public ListaCPDTO getPpCpsDaFolha(DwFolha folha) {
		PpCpDAO cpDAO = new PpCpDAO(getDaoSession());
		List<PpCp> listaCps = cpDAO.getPpCpsDaFolha(folha.getIdFolha());
		List<CpDTO> listaCpsDTO = new ArrayList<>();
		for (PpCp cp : listaCps) {
			CpDTO dto = new CpDTO();
			DwFolha folhaClonada = cp.getDwFolha().clone(true);
			dto.setCp(cp.clone(true));
			dto.getCp().setDwFolha(folhaClonada);
			listaCpsDTO.add(dto);
		}
		ListaCPDTO retorno = new ListaCPDTO();
		retorno.setListaCps(listaCpsDTO);
		return retorno;
	}

	private boolean alterarProducaoPlanejadaEetiquetas(PpCp ppcp, ListaCPDTO listaCPDTO) {

		boolean isRetorno = false;
		NumeroSerieRN srn = new NumeroSerieRN(getDao());

		// Encontrar em ListaCPDTO o elemnto ppcp desejado
		PpCp ppcpPar = null;
		for (CpDTO dto : listaCPDTO.getListaCps()) {
			if (dto.getCp().getCdCp().equals(ppcp.getCdCp())) {
				ppcpPar = dto.getCp();
				break;
			}
		}

		// Se nao encontrou pode ser que o ppcp.cdCp nao tenha o prefixo para distinguir os PTs. Nesse caso procurar considerando o nr_doc e
		// o PT
		if (ppcpPar == null) {
			for (CpDTO dto : listaCPDTO.getListaCps()) {
				if (dto.getCp().getNrop().equals(ppcp.getNrop()) &&
						dto.getCp().getOmPt().getCdPt().equals(ppcp.getOmPt().getCdPt())) {
					ppcpPar = dto.getCp();
				}
			}
		}

		if (ppcpPar == null)
			return false;

		// Verifica se houve alteracao do GT
		if ((ppcp.getOmGt() == null && ppcpPar.getOmGt() != null) ||
				(ppcp.getOmGt() != null && ppcpPar.getOmGt() != null
						&& ppcp.getOmGt().getCdGt().equals(ppcpPar.getOmGt().getCdGt()) == false)) {
			// Pesquisar o OmGt
			GTRN grn = new GTRN();
			grn.setDao(getDao());
			OmGt omgt = grn.getOmGtByCdGt(ppcpPar.getOmGt().getCdGt());
			ppcp.setOmGt(omgt);

		}

		boolean isAlterouProducaoPlanejada = false;
		BigDecimal novaProducaoPlanejada = BigDecimal.ZERO;
		for (PpCpproduto prod : ppcp.getPpCpprodutos()) {
			// Encontra em ppcppar o produto correspondente
			PpCpproduto prodPar = ppcpPar.getPpCpproduto(prod.getOmProduto().getCdProduto());
			if (prodPar != null) {
				// alterar a producao planejada
				try {
					int pp = prod.getPcsProducaoplanejada().intValue();
					int ppAux = prodPar.getPcsProducaoplanejada().intValue();
					if (pp != ppAux) {
						prod.setPcsProducaoplanejada(prodPar.getPcsProducaoplanejada());
						novaProducaoPlanejada = novaProducaoPlanejada.add(prodPar.getPcsProducaoplanejada());
						isAlterouProducaoPlanejada = true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		/*
		 * Se a producao planejada tiver sido alterada entao modificar os dwrt com a nova producao planejada isso serve para a cor de fundo
		 * azul do icone deixar de ser azul
		 */
		if (isAlterouProducaoPlanejada) {
			List<DwRt> dwrts = pesquisarListaDwRtDaOp(ppcp);
			for (DwRt dwrt : dwrts) {
				dwrt.setPcsProducaoplanejadaOp(novaProducaoPlanejada);
				getDao().makePersistent(dwrt);
			}
		}

		// Incluir os novos numero de serie
		boolean isAlterouNS = false;
		for (PpCpnserie cpnserie : ppcpPar.getPpCpnseries()) {
			// Verificar se o NS existe. Se exisitr utiliza-lo senao cadastrar
			DwNserie ns = null;
			try {
				ns = srn.getDwNserieCb(cpnserie.getDwNserie().getCb());
			} catch (NumeroSerieIrregularException e) {
				continue;
			}
			if (ns == null) {
				ns = cpnserie.getDwNserie();
				getDao().makePersistent(ns);
			}
			// Verifica se ja existe o numero de serie na op, se existir nao
			// precisa fazer nada
			PpCpnserie cpnsAux = srn.getPpCpnserieByCpNserie(ppcp, ns);
			if (cpnsAux == null) {
				PpCpnserie novoserie = new PpCpnserie();
				novoserie.setDwNserie(ns);
				novoserie.setPpCp(ppcp);
				getDao().makePersistent(novoserie);
				isAlterouNS = true;
			}
		}

		// Se NENHUM numero de serie for passado, MAS a OP ainda tem numeros associados, entao o usuario mandou uma nova versao da OP
		// onde os NS foram todos excluidos. Nesse caso devemos exclui-los.
		if (ppcpPar.getPpCpnseries().isEmpty() && ppcp.getPpCpnseries().isEmpty() == false) {
			MapQuery q = new MapQuery(getDaoSession());
			q.append("delete from PpCpnserie where ppCp = :ppcp");
			q.defineParametro("ppcp", ppcp);
			q.query().executeUpdate();
		}

		if (isAlterouNS || isAlterouProducaoPlanejada)
			isRetorno = true;
		return isRetorno;
	}

	public ListaCPDTO salvarPpCpOrdemProducao(ListaCPDTO listaCPDTO) {

		PTRN rnPt = new PTRN(getDao());
		ProdutoRN rnProd = new ProdutoRN(getDao());

		GTRN rnGt = new GTRN();
		rnGt.setSession(getDaoSession());
		try {
			rnGt.setSessionStateless(getDaoSessionStatless());
		} catch (SemSessaoHibernateException e) {
		}
		PlanoProducaoRN rnPla = new PlanoProducaoRN(getDao());

		ListaCPDTO retorno = new ListaCPDTO();
		retorno.setListaCpsAux(new ArrayList<CpDTO>());

		MapQuery q;
		if (getDaoSession() != null)
			q = new MapQuery(getDaoSession());
		else
			q = new MapQuery(getDaoSessionStatless());

		q.append("select a");
		q.append("from DwFolha a");
		q.append("left join fetch a.dwFolhaiacs b");
		q.append("left join fetch b.omProduto c");
		q.append("left join fetch a.dwFolharaps d");
		q.append("left join fetch d.dwFolharapcoms e");
		q.append("left join fetch e.omProduto f");
		q.append("where a = :dwfolha");

		/*
		 * Verificar se os produtos da CP correspondem aos produtos da folha
		 */
		String nropAux = null;
		FolhaRN frn = new FolhaRN(getDao());
		for (CpDTO dto : listaCPDTO.getListaCps()) {
			retorno.getListaCpsAux().add(dto);
			PpCp ppcpAux = dto.getCp();
			DwFolha dwfolhaAux = ppcpAux.getDwFolha();
			nropAux = ppcpAux.getNrop();

			// Se a folha nao tiver sido passada, entao considerar q ppcp ja tem todos os produtos
			if (dwfolhaAux == null)
				continue;

			// Pesquisar a folha com fetch em dwfolhaiac e dwfolharap com omproduto
			q.defineParametro("dwfolha", dwfolhaAux);
			dwfolhaAux = (DwFolha) q.uniqueResult();

			List<OmProduto> produtoFolha = frn.getProdutosFromDwFolha(dwfolhaAux);
			for (OmProduto omproduto : produtoFolha) {
				boolean isExiste = false;
				for (PpCpproduto cpprodAux : ppcpAux.getPpCpprodutos()) {
					if (cpprodAux.getOmProduto().getCdProduto().equals(omproduto.getCdProduto()))
						isExiste = true;
				}
				if (isExiste == false) {
					retorno.setResultado(new ResultadoDTO());
					retorno.getResultado().setIdmensagem(retorno.getResultado().getPRODUTO_DESCONHECIDO());
					retorno.getResultado().setComplemento(dwfolhaAux.getCdFolha());
					return retorno;
				}
			}
		}

		/*
		 * Alessandre em 09-10-17 #1351. Se existir a OP para qq pt e for para incluir, retornar informando que a OP já existe
		 *
		 */
		ListaCPDTO cpdtoPesquisa = getOPProdutos(nropAux);

		if (cpdtoPesquisa != null && cpdtoPesquisa.getListaCps().isEmpty() == false && listaCPDTO.getIsInclusao() != null
				&& listaCPDTO.getIsInclusao()) {
			retorno.setResultado(new ResultadoDTO());
			retorno.getResultado().setIdmensagem(retorno.getResultado().getREGISTRO_JA_EXISTE());
			retorno.getResultado().setComplemento(nropAux);
			return retorno;
		}

		/*
		 * Alessandre em 15-08-17 modifiquei a estrategia para tratamento das OPs que já tem produção. Ao invés de sari quando a OP em algum
		 * PT tiver produção, iremos varrer todas os CPs e para os que tiverem produção iremos alterar apenas alguns dados da OP. Para os
		 * que não tem produção iremos fazer a alteração completa
		 */
		Iterator<CpDTO> icpdto = listaCPDTO.getListaCps().iterator();
		while (icpdto.hasNext()) {
			CpDTO cpDTO = icpdto.next();
			String nrop = cpDTO.getCp().getNrop();
			PpCp ppcpNoBanco = pesquisarPpCpByNrDocCdPt(nrop, cpDTO.getCp().getOmPt().getCdPt());

			// Se existir a CP cadastrada, avaliar se o registro passado pela interface possui id. Se possuir eh pq eh uma alteracao, entao
			// desativar a antiga e salvar a nova
			// se os ids forem diferentes entao avisar que a OP ja cadastrada
			if (ppcpNoBanco != null) {
				// Se tiver producao, alterar apenas a producao planejada
				if (ppcpNoBanco.getProducaoBruta() > 0d) {
					alterarProducaoPlanejadaEetiquetas(ppcpNoBanco, listaCPDTO);
					ppcpNoBanco.setNrLoteMp(cpDTO.getCp().getNrLoteMp());
					ppcpNoBanco.setDtLoteMp(cpDTO.getCp().getDtLoteMp());

					// Remover da lista geral para não ser incluido novamente
					icpdto.remove();
				} else {
					ppcpNoBanco.setStAtivo((byte) 0);
					getDao().makePersistent(ppcpNoBanco);
				}
			}
		}

		List<CpDTO> listaCps = new ArrayList<>();

		// APENAS PARA PEGAR A REFERENCIA DA ROTA CASO O USUARIO INFOME UM
		// PRODUTO FINAL
		DwRota rota = null;
		for (CpDTO cpDTO : listaCPDTO.getListaCps()) {
			if (cpDTO.getOrdensProducaoProdutoDTO() != null) {
				for (OrdemProducaoProdutoDTO dto : cpDTO.getOrdensProducaoProdutoDTO()) {
					if (dto.getProduto() != null) {
						RoteiroRN rn = new RoteiroRN(getDao());
						rota = rn.pesquisarDwRotaByIdProduto(dto.getProduto(), false);
						if (rota == null) {
							retorno.setResultado(new ResultadoDTO());
							retorno.getResultado().setIdmensagem(retorno.getResultado().getROTEIRO_INCONSISTENTE());
							return retorno;
						}
						break;
					}
				}
			}
		}

		// Loop para efetivar a inclusao e alteracao das ppcps
		for (CpDTO dto : listaCPDTO.getListaCps()) {

			dto.setResultadoDTO(new ResultadoDTO());
			dto.getResultadoDTO().setIdmensagem(dto.getResultadoDTO().COM_SUCESSO);

			PpCp ppCpOriginal = null;

			if (dto.getCp() != null && dto.getCp().getIdCp() != null)
				ppCpOriginal = getDao().findById(PpCp.class, dto.getCp().getIdCp(), false);

			PpCp ppCpAlteracao = null;

			// Se for inclusao entao ppCpOriginal sera null,
			if (ppCpOriginal == null) {

				ppCpOriginal = inclusaoCpDTO(rnPt, rnProd, rnPla, rota, dto);

			} else {

				ppCpAlteracao = alteracaoCpDTO(rota, dto, ppCpOriginal);
			}

			if (dto.getResultadoDTO().isComSucesso()) {
				try {
					ppCpOriginal = getDao().makePersistent(ppCpOriginal);
					// Como está sendo usado stateless session, o makepersist acima não está incluindo os ppcpprodutos. Assim devemos
					// incluir cada um individualmente
					for (PpCpproduto cpprod : ppCpOriginal.getPpCpprodutos()) {
						cpprod.setPpCp(ppCpOriginal);
						getDao().makePersistent(cpprod);
					}

					if (ppCpAlteracao != null) {
						ppCpAlteracao = getDao().makePersistent(ppCpAlteracao);

						// Enviar os NS pois nao envia em algumas situacoes
						if (ppCpAlteracao.getPpCpnseries().isEmpty() == false) {
							for (PpCpnserie ns : ppCpAlteracao.getPpCpnseries()) {
								if (ns.getIdCpserie() == null || ns.getIdCpserie() == 0l) {
									getDao().makePersistent(ns);
								}
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					retorno.setResultado(new ResultadoDTO());
					retorno.getResultado().setIdmensagem(retorno.getResultado().getERRO_DESCONHECIDO());
					return retorno;

				}
			}

			CpDTO dtoRetorno = new CpDTO();
			dtoRetorno.setCp(ppCpOriginal.clone(true));
			dtoRetorno.setResultadoDTO(dto.getResultadoDTO());
			listaCps.add(dtoRetorno);
		}

		/* realizar a exclusao das OPs que não foram recebidas mas que existem na base */
		ListaCPDTO listaCpCancelamento = new ListaCPDTO();
		for (CpDTO cpdto : cpdtoPesquisa.getListaCps()) {
			boolean isExiste = false;
			for (CpDTO dto : retorno.getListaCpsAux()) {
				if (cpdto.getCp().getNrop().equals(dto.getCp().getNrop())
						&& cpdto.getCp().getOmPt().getCdPt().equals(dto.getCp().getOmPt().getCdPt())) {
					isExiste = true;
					break;
				}
			}
			// Se nao existe na lista das CP recebidas entao excluir a OP
			if (isExiste == false) {
				listaCpCancelamento.getListaCps().add(cpdto);
			}
		}
		// Chama o cancelamento das OPs
		desativarPpCpOrdemProducao(listaCpCancelamento);

		retorno.setResultado(new ResultadoDTO());
		retorno.getResultado().setIdmensagem(retorno.getResultado().COM_SUCESSO);
		retorno.setListaCps(listaCps);

		return retorno;
	}

	private PpCp alteracaoCpDTO(DwRota rota, CpDTO dto, PpCp ppCpOriginal) {
		PpCp ppCpAlteracao;
		ppCpAlteracao = new PpCp();
		ppCpAlteracao.copy(dto.getCp(), true);
		ppCpAlteracao.setStAtivo((byte) 1);
		ppCpAlteracao.setIdCp(null);
		ppCpAlteracao.setRevisao(ppCpOriginal.getRevisao() + 1);
		ppCpAlteracao.setDtRevisao(new Date());
		if (dto.getCp().getPpCliente() != null) {
			PpClienteDAO clienteDAO = new PpClienteDAO(getDaoSession());
			PpCliente cliente = clienteDAO.getPpClientePorCdAtivo(dto.getCp().getPpCliente().getCdCliente());
			ppCpAlteracao.setPpCliente(cliente);
		} else {
			ppCpAlteracao.setPpCliente(null);
		}
		ppCpAlteracao.setPpNec(dto.getCp().getPpNec());
		ppCpAlteracao.setDwRota(rota);

		// eduardo - apenas para teste verificar com o ale como deve ser feito
		if (dto.getCp().getDwFolha() != null) {
			DwFolhaDAO folhaDAO = new DwFolhaDAO(getDaoSession());
			DwFolha folha = folhaDAO.getDwFolhaPorId(dto.getCp().getDwFolha().getIdFolha());
			ppCpAlteracao.setDwFolha(folha);
		}

		// Verifica o GT da OP
		if (dto.getCp().getOmGt() != null && dto.getCp().getOmGt().getCdGt() != null) {
			GTRN grn = new GTRN();
			grn.setDao(getDao());
			OmGt omgt = grn.getOmGtByCdGt(dto.getCp().getOmGt().getCdGt());
			ppCpAlteracao.setOmGt(omgt);
		}

		// Verifica se o Roteiro foi passado
		if (dto.getCp().getDwRota() != null && dto.getCp().getDwRota().getCdRota() != null) {
			RoteiroRN rrn = new RoteiroRN(getDao());
			DwRota dwrota = rrn.pesquisarDwRotaByCdRota(dto.getCp().getDwRota().getCdRota());
			ppCpAlteracao.setDwRota(dwrota);
		}

		for (PpCpproduto ppcpproduto : ppCpAlteracao.getPpCpprodutos()) {
			ppcpproduto.setIdCpproduto(null);
			ppcpproduto.setPpCp(ppCpAlteracao);
		}

		// Salva os numeros de serie.
		NumeroSerieRN srn = new NumeroSerieRN(getDao());
		System.out.println("incluind ns:" + dto.getCp().getPpCpnseries().size());
		for (PpCpnserie cpnserie : dto.getCp().getPpCpnseries()) {
			// Verificar se o NS existe. Se exisitr utiliza-lo senao cadastrar
			DwNserie ns = null;
			try {
				ns = srn.getDwNserieCb(cpnserie.getDwNserie().getCb());
			} catch (NumeroSerieIrregularException e) {
				continue;
			}
			if (ns == null) {
				System.out.println("...add ns " + cpnserie.getDwNserie().getCb());
				ns = cpnserie.getDwNserie();
				getDao().makePersistent(ns);
			}
			cpnserie.setIdCpserie(null);
			cpnserie.setDwNserie(ns);
			cpnserie.setPpCp(ppCpAlteracao);

			ppCpAlteracao.getPpCpnseries().add(cpnserie);
		}

		ppCpOriginal.setStAtivo((byte) 0);
		return ppCpAlteracao;
	}

	/*
	 * Metodo privado de apoio da inclusao de ops por roteiro
	 */
	private PpCp inclusaoCpDTO(PTRN rnPt, ProdutoRN rnProd, PlanoProducaoRN rnPla, DwRota rota, CpDTO dto) {
		PpCp ppCpOriginal;
		ppCpOriginal = dto.getCp().clone();

		// Se PT definido encontrar referencia no banco
		if (dto.getCp().getOmPt() != null) {
			try {
				ppCpOriginal.setOmPt(rnPt.getOmPt(dto.getCp().getOmPt().getCdPt()));
			} catch (RegistroDesconhecidoException e) {
				dto.getResultadoDTO().setIdmensagem(dto.getResultadoDTO().PT_DESCONHECIDO);
				return ppCpOriginal;
			}
		}

		// Se cliente definido encontrar referencia no banco
		if (dto.getCp().getPpCliente() != null) {
			PpClienteDAO clienteDAO = new PpClienteDAO(getDaoSession());
			PpCliente cliente = clienteDAO.getPpClientePorCdAtivo(dto.getCp().getPpCliente().getCdCliente());
			ppCpOriginal.setPpCliente(cliente);
		}

		// Se Gt definido encontrar referencia no banco
		if (dto.getCp().getOmGt() != null && dto.getCp().getOmGt().getCdGt().trim().equals("") == false) {
			GTRN grn = new GTRN();
			grn.setDao(rnPt.getDao());
			OmGt omgt = grn.getOmGtByCdGt(dto.getCp().getOmGt().getCdGt());
			ppCpOriginal.setOmGt(omgt);
		}

		// eduardo - apenas para teste verificar com o ale como deve ser feito
		if (dto.getCp().getDwFolha() != null) {
			DwFolhaDAO folhaDAO = new DwFolhaDAO(getDaoSession());
			try {
				folhaDAO.setSessionStateless(getDaoSessionStatless());
			} catch (SemSessaoHibernateException e) {
			}

			DwFolha folha = folhaDAO.getDwFolhaPorId(dto.getCp().getDwFolha().getIdFolha());
			ppCpOriginal.setDwFolha(folha);
		} else {
			String cdProduto = "";
			for (PpCpproduto pp : ppCpOriginal.getPpCpprodutos()) {
				cdProduto = pp.getOmProduto().getCdProduto();
			}
			// Procurar a folha possivel. Se nao existir deve retornar uma mensagem q a folha nao foi encontrada
			FolhaRN frn = new FolhaRN(getDao());
			DwFolha dwfolha = frn.pesquisarDwFolhaByCdProduto(cdProduto, ppCpOriginal.getOmPt().getCdPt());
			if (dwfolha == null) {
				dto.getResultadoDTO().setIdmensagem(dto.getResultadoDTO().getFOLHA_DESCONHECIDA());
				dto.getResultadoDTO().setComplemento(" produto: " + cdProduto + " posto: " + ppCpOriginal.getOmPt().getCdPt());
				return ppCpOriginal;
			}
			ppCpOriginal.setDwFolha(dwfolha);
		}

		if (rota != null) {
			ppCpOriginal.setDwRota(rota);
		}

		for (PpCpproduto pp : ppCpOriginal.getPpCpprodutos()) {
			// Procura cada produto
			OmProduto omproduto = null;
			try {
				omproduto = rnProd.getOmProduto(pp.getOmProduto().getCdProduto());
			} catch (RegistroDesconhecidoException e) {
				// Indicar que o produto nao existe para a op em questao mas deve-se continuar para verificar as outras ops
				dto.getResultadoDTO().setIdmensagem(dto.getResultadoDTO().PRODUTO_DESCONHECIDO);
				return ppCpOriginal;
			}

			pp.setOmProduto(omproduto);

			pp.setPpCp(ppCpOriginal);
		}

		ppCpOriginal.setDtRevisao(DataHoraRN.getDataHoraAtual());
		ppCpOriginal.setDtStativo(DataHoraRN.getDataHoraAtual());
		ppCpOriginal.setPpPlano(rnPla.getUltimoPlanoAtivoStPlano0());
		ppCpOriginal.setIsAntecipacao(false);

		// Determina se sera uma OP = 0 ou uma OR = 1 (ordem de retrabalho)
		if (dto.getCp().getTpCp() != null)
			ppCpOriginal.setTpCp(dto.getCp().getTpCp());
		else
			ppCpOriginal.setTpCp(0);

		ppCpOriginal.setStCp(0);
		ppCpOriginal.setIsFinalserie(dto.getCp().getIsFinalserie());
		ppCpOriginal.setIsMassa(false);
		ppCpOriginal.setIsTryout(false);
		ppCpOriginal.setIsCm(false);
		ppCpOriginal.setIsBarrasete(false);
		ppCpOriginal.setIsFaltamp(false);
		ppCpOriginal.setIsApAberta(false);
		ppCpOriginal.setRevisao(1l);
		ppCpOriginal.setStAtivo((byte) 1);

		// Salva os numeros de serie
		NumeroSerieRN srn = new NumeroSerieRN(getDao());
		for (PpCpnserie cpnserie : dto.getCp().getPpCpnseries()) {

			// Verificar se o NS existe. Se exisitr utiliza-lo senao cadastrar
			DwNserie ns = null;
			try {
				ns = srn.getDwNserieCb(cpnserie.getDwNserie().getCb());
			} catch (NumeroSerieIrregularException e) {
				continue;
			}
			if (ns == null) {
				ns = cpnserie.getDwNserie();
				getDao().makePersistent(ns);
			}
			cpnserie.setDwNserie(ns);
			cpnserie.setPpCp(ppCpOriginal);

			// O makePersist foi comentado pois sera feito atraves do cascade
			// getDao().makePersistent(cpnserie);
			ppCpOriginal.getPpCpnseries().add(cpnserie);
		}
		return ppCpOriginal;
	}

	public CpDTO desativarPpCpOrdemProducao(ListaCPDTO listaCPDTO) {

		CpDTO retorno = new CpDTO();
		retorno.setResultadoDTO(new ResultadoDTO());
		retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().COM_SUCESSO);

		PpCpDAO cpDAO = new PpCpDAO(getDaoSession());

		for (CpDTO dto : listaCPDTO.getListaCps()) {
			PpCp cp = cpDAO.getPpCpPorId(dto.getCp().getIdCp());
			// Se existir producao avisar que nao pode excluir pois existe producao
			/*
			 * Alessandre em 31-08-15 Comentei o if abaixo para permitir a exclusao da OP mesmo com producao boolean isExisteProducao =
			 * false; for (PpCpproduto produto : cp.getPpCpprodutos()) { if (produto.getPcsProducaobruta() != null &&
			 * produto.getPcsProducaobruta().compareTo(BigDecimal.ZERO) > 0) isExisteProducao = true; } if (isExisteProducao) {
			 * retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().OP_COM_PRODUCAO); } else {
			 */

			cp.setStAtivo((byte) 0);
			cp.setStCp(PpCpTemplate.StCp.CANCELADA.getValue());
			cp.setDtRevisao(new Date());
			try {
				getDao().makePersistent(cp);
				retorno.setCp(cp.clone());
			} catch (Exception e) {
				e.printStackTrace();
				retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().COM_SUCESSO);
				break;
			}
			// }
		}
		return retorno;
	}

	public List<PpCp> pesquisarTodasCpsAtivas() {
		MapQuery q = new MapQuery(getDaoSession());

		q.append("select ppcp");
		q.append("from PpCp ppcp");
		q.append("where ppcp.stAtivo = 1");

		return q.list();
	}

	public List<PpCp> pesquisarTodasCpsAtivasDoIC(String urlConexao) {
		MapQuery q = new MapQuery(getDaoSession());

		q.append("select distinct msup.cdUp");
		q.append("from MsUp msup");
		q.append("join msup.msMsicups msicup");
		q.append("join msicup.msIc msic");
		q.append("where msup.stAtivo = 1");
		q.append("and msic.stAtivo = 1");
		q.append("and msic.urlConexao = :urlconexao");

		q.defineParametro("urlconexao", urlConexao);

		List<Object> pts = q.list();

		// Alessandre em 29-7-15 Nao foi encontrado nenhum registro, se passar para o proximo select vai ocorrer a excessao
		// Exception in thread "Thread-6" org.hibernate.hql.internal.ast.QuerySyntaxException: unexpected end of subtree [ select ppcp from
		// idw.model.pojos.PpCp ppcp join ppcp.omPt ompt left join ppcp.ppCpnseries ppcpnseries where ppcp.stAtivo = 1 and ompt.cdPt in () ]
		if (pts == null || pts.size() <= 0)
			return new ArrayList<PpCp>();

		q.novaConsulta();
		q.append("select ppcp");
		q.append("from PpCp ppcp");
		q.append("join ppcp.omPt ompt");
		// q.append("left join ppcp.ppCpnseries ppcpnseries");
		q.append("where ppcp.stAtivo = 1");
		q.append("and ompt.cdPt in (:lista)");

		q.defineListaParametro("lista", pts);

		return q.list();
	}

	public List<PpCp> pesquisarTodasCpsAtivasDoPt(String cdPt) {
		MapQuery q = new MapQuery(getDaoSession());

		q.novaConsulta();
		q.append("select ppcp");
		q.append("from PpCp ppcp");
		q.append("join ppcp.omPt ompt");
		q.append("where ppcp.stAtivo = 1");
		q.append("and ompt.cdPt = :cdPt");

		q.defineParametro("cdPt", cdPt);

		return q.list();
	}

	public List<PpCp> pesquisarCpsAtivasRecentesDoPt(String cdPt) {
		MapQuery q = new MapQuery(getDaoSession());
		Date dthrRef = new Date(new Date().getTime() - TimeUnit.DAYS.toMillis(60));

		q.novaConsulta();
		q.append("select ppcp");
		q.append("from PpCp ppcp");
		q.append("join ppcp.omPt ompt");
		q.append("where ppcp.stAtivo = 1");
		q.append("and ompt.cdPt = :cdPt");
		q.append("and ppcp.dthrInicio > :dthrRef");

		q.defineParametro("cdPt", cdPt);
		q.defineParametro("dthrRef", dthrRef);

		return q.list();
	}

	public List<DwFolha> pesquisarTodasFolhasAtivasDoPT(String cdPt) {
		MapQuery q = new MapQuery(getDaoSession());

		q.novaConsulta();
		q.append("select distinct dwfolha");
		q.append("from PpCp ppcp");
		q.append("join ppcp.dwFolha dwfolha");
		q.append("where ppcp.omPt.cdPt = :cdPt");
		q.append("and ppcp.stAtivo = 1");

		q.defineParametro("cdPt", cdPt);

		return q.list();
	}

	public ListaCPDTO getOPProdutos(String nrOp) {
		PpCpDAO cpDAO = new PpCpDAO(getDaoSession());
		try {
			cpDAO.setSessionStateless(getDaoSessionStatless());
		} catch (SemSessaoHibernateException e) {
		}

		List<PpCp> ppCps = cpDAO.getPpCpLikeNrDoc(nrOp);
		List<CpDTO> cpsDTO = new ArrayList<>();
		for (PpCp ppcp : ppCps) {
			CpDTO dto = new CpDTO();
			dto.setCp(ppcp.clone(false));

			// coloquei o trecho abaixo porque quando usava o trecho acima com o clone true
			// estava dando estouro de memoiria
			if (ppcp.getDwFolha() != null) {
				dto.getCp().setDwFolha(ppcp.getDwFolha().clone(false));
				if (ppcp.getDwFolha().getDwFolhaiacs() != null) {
					DwFolhaiac iacClone = null;
					for (DwFolhaiac iac : ppcp.getDwFolha().getDwFolhaiacs()) {
						iacClone = iac.clone(); // para pegar o produto
					}
					if (iacClone != null)
						dto.getCp().getDwFolha().getDwFolhaiacs().add(iacClone);
				}
				if (ppcp.getDwFolha().getDwFolharaps() != null) {
					for (DwFolharap rap : ppcp.getDwFolha().getDwFolharaps()) {
						DwFolharap rapClone = rap.clone();
						dto.getCp().getDwFolha().getDwFolharaps().add(rapClone);
					}
				}
			}
			if (ppcp.getOmGt() != null) {
				dto.getCp().setOmGt(ppcp.getOmGt().clone(false));
			}
			if (ppcp.getOmPt() != null) {
				dto.getCp().setOmPt(ppcp.getOmPt().clone(false));
				dto.getCp().getOmPt().setOmGt(ppcp.getOmPt().getOmGt().clone(false));
				dto.getCp().getOmPt().setOmTppt(ppcp.getOmPt().getOmTppt().clone(false));
			}
			if (ppcp.getDwRota() != null && ppcp.getDwRota().getOmProduto() != null) {
				dto.getCp().setDwRota(ppcp.getDwRota().clone(false));
				dto.getCp().getDwRota().setOmProduto(ppcp.getDwRota().getOmProduto().clone(false));
			}
			if (ppcp.getPpCliente() != null) {
				dto.getCp().setPpCliente(ppcp.getPpCliente().clone(false));
			}
			dto.getCp().setPpCpprodutos(new HashSet<PpCpproduto>());
			for (PpCpproduto cpProd : ppcp.getPpCpprodutos()) {
				PpCpproduto cpproduto = cpProd.clone(false);
				if (cpProd.getOmProduto() != null) {
					cpproduto.setOmProduto(cpProd.getOmProduto().clone(false));
					if (cpProd.getOmProduto().getOmProgrp() != null) {
						cpproduto.getOmProduto().setOmProgrp(cpProd.getOmProduto().getOmProgrp().clone(false));
					}
				}
				dto.getCp().getPpCpprodutos().add(cpproduto);
			}

			// Se houverem NS associados a CP elas devem ser retornadas
			dto.getCp().setPpCpnseries(new HashSet<PpCpnserie>());
			if (ppcp.getPpCpnseries() != null) {
				for (PpCpnserie ns : ppcp.getPpCpnseries()) {
					PpCpnserie nsClone = new PpCpnserie();
					getDao().evict(nsClone);
					;
					nsClone.setIdCpserie(ns.getIdCpserie());
					nsClone.setDwNserie(ns.getDwNserie().clone(false));
					dto.getCp().getPpCpnseries().add(nsClone);
				}
			}

			/*
			 * Alessandre em 05-03-18 comentei o trecho abaixo para evitar que os NSs sejam transferidos para a GUI pois no ambiente de
			 * producao muitos NS sao gerados e qdo sao transferidos para a GUI a mesma fica muito lenta para pesquisar e salvar. Entao,
			 * modificar a GUI para ler e salvar os NS associados de forma separada a OP // Pegar os numeros de serie tb
			 * dto.getCp().setPpCpnseries(new HashSet<PpCpnserie>()); for (PpCpnserie ns : ppcp.getPpCpnseries()) { PpCpnserie
			 * ppcpnserieClonado = new PpCpnserie(); DwNserie dwnserie = ns.getDwNserie().clone(false);
			 * dwnserie.setOmProduto(ns.getDwNserie().getOmProduto().clone(false)); ppcpnserieClonado.setDwNserie(dwnserie);
			 * ppcpnserieClonado.setIdCpserie(ns.getIdCpserie()); dto.getCp().getPpCpnseries().add(ppcpnserieClonado); }
			 */
			cpsDTO.add(dto);
		}
		ListaCPDTO retorno = new ListaCPDTO();
		retorno.setListaCps(cpsDTO);
		return retorno;
	}

	// public static void main(String[] args) {
	// Date iniDate = DataHoraRN.getDataHora(2017, 1, 13, 10, 8, 37, 942);
	// long msIniDate = iniDate.getTime();
	// long msSetup = 0l;
	// long qtdPlanejada = 45687000l;
	// long qtdPcsPorCiclo = 20;
	// long cicloPadrao = 15l;
	//
	// long msFimDate = (long) (msIniDate + msSetup + ((qtdPlanejada) / qtdPcsPorCiclo) * cicloPadrao * 1000l);
	//
	// System.out.println("data final " + new Date(msFimDate));
	// }

	public boolean isNumeroSerieExiste(String cdpt, String nrOp, String ns, String cdproduto, MensagemRecebida mensagem) {
		// Denis em 24/07/2015 - retorno 0 para fail, 1 para sucesso
		MapQuery q = new MapQuery(getDaoSession());

		/*
		 * Alessandre em 18-10-17 modifiquei o teste para avaliar apenas se o CB existe em DWSERIE e nao mais em ppCP pois na GBR nao foi
		 * encontrado o NS no ppcp apesar de existir e o ciclo nao foi lancado e a producao nao foi contabilizada q.append("select ppcp");
		 * q.append("from PpCp ppcp"); q.append("join ppcp.omPt ompt"); q.append("join ppcp.ppCpprodutos ppcpproduto");
		 * q.append("join ppcpproduto.omProduto omprod"); q.append("join ppcp.ppCpnseries ppcpnseries");
		 * q.append("join ppcpnseries.dwNserie dwns");
		 * 
		 * // Alessandre em 7-7-15 comentado o filtro por codprod avaliar se em outros casos o campo NS serï¿½ usado o CB geral
		 * //q.append("where omprod.cdProduto = :cdprod"); q.append("where ppcpproduto.nrDoc = :nrop"); q.append("and ompt.cdPt = :cdpt");
		 * q.append("and dwns.ns = :ns"); q.append("and ppcp.stAtivo = 1");
		 * 
		 * //q.defineParametro("cdprod", cdproduto); q.defineParametro("nrop", nrOp); q.defineParametro("cdpt", cdpt);
		 */
		q.append("select a from DwNserie a where a.cb = :ns");

		q.defineParametro("ns", ns);
		q.setMaxResults(1);

		return q.uniqueResult() != null;
	}

	public OPAutomaticaDTO criarOPAutomatica(EventoColetado evento) {
		IdwLogger log = new IdwLogger("criaOPAutomatica" + evento.getUp());
		int idLog = log.getIdAleatorio();

		OmPt ompt;
		DwFolhaDTO folha;
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());

		Date iniDate;
		long qtdPlanejada;

		PTRN prn = new PTRN(getDao());
		try {
			ompt = prn.getOmPt(evento.getUp(), true);
		} catch (RegistroDesconhecidoException e1) {
			log.info(idLog, 0, "Nao criou ou pois " + evento.getUp() + " desconhecido.");
			return null;
		}

		LoginRN loginRN = new LoginRN();
		loginRN.setSession(this.getDaoSession());

		FolhaRN folhaRN = new FolhaRN();
		folhaRN.setDaoSession(this.getDaoSession());
		log.info(idLog, 0, "Procurando folha " + evento.getCdFolha() + " para o posto " + ompt.getCdPt());
		folha = folhaRN.getDwFolhaByCdFolhaEOmPt(evento.getCdFolha(), ompt);
		if (folha != null && folha.getDwFolha() != null)
			log.info(idLog, 0, "Encontrou folha com id " + folha.getDwFolha().getIdFolha());
		else {
			// Se for um posto ciclico nao se deve incluir folha automaticamente
			if (ompt.getOmTppt().isMaquinaCiclica())
				return null;

			log.info(idLog, 0, "Folha desconhecida. Incluindo folha automática");
			ConsolidaRN crn = new ConsolidaRN(getDao());
			folha = new DwFolhaDTO();
			folha.setDwFolha(crn.obtemDwFolha(ompt, null /* nrop sem uso */, evento.getCdFolha(), evento.getCdFolha(), omcfg,
					evento.getSegCiclopadrao()));
		}
		iniDate = evento.getDthrEvento();
		qtdPlanejada = Long.parseLong(evento.getQtde());

		// Se a producao planejda for <= 0 entao descartar criacao da op
		if (qtdPlanejada <= 0)
			return null;

		PlanoProducaoRN rnPla = new PlanoProducaoRN(loginRN.getDao());

		OPAutomaticaDTO retorno = null;

		OmUsr usuarioLogado = null;
		try {
			usuarioLogado = loginRN.getUsrsLoginPt(ompt.getIdPt()).get(0).getOmUsr();
		} catch (Exception e) {
		}

		double cicloPadrao = 1.0;
		try {
			cicloPadrao = folhaRN.getCicloPadraoFromDwFolhacisOuDwFolha(folha.getDwFolha(), ompt).doubleValue();
		} catch (SemCicloPadraoException e) {
			cicloPadrao = 1.0;
		}

		long cicloTimeout = 0l;
		try {
			cicloTimeout = folha.getDwFolha().getSegCiclotimeout().longValue();
		} catch (Exception e) {
			cicloTimeout = 0l;
		}

		double cicloMinimo = 0l;
		try {
			cicloMinimo = folha.getDwFolha().getSegCiclominimo().doubleValue();
		} catch (Exception e) {
			cicloMinimo = 0l;
		}

		long qtdPcsPorCiclo = 1l;
		try {
			qtdPcsPorCiclo = folhaRN.getPcsPorCicloAtivasFromDwFolha(folha.getDwFolha()).longValue();
		} catch (Exception e) {
			e.printStackTrace();
			qtdPcsPorCiclo = 1l;
		}

		PpPlano plano = rnPla.getUltimoPlanoAtivoStPlano0();

		long msIniDate = iniDate.getTime();
		long msSetup = 0l;

		if (folha.getDwFolha().getSegSetup() != null)
			msSetup = folha.getDwFolha().getSegSetup() * 1000;

		long msFimDate = (long) (msIniDate + msSetup + ((qtdPlanejada * 1000) / qtdPcsPorCiclo) * cicloPadrao);

		Date fimDate = new Date(msFimDate);

		DateFormat dateFormat = new SimpleDateFormat("ddMMHHmm");
		String nrDocDate = dateFormat.format(DataHoraRN.getDataHoraAtual());
		String nrDoc;
		if (evento.getCdop() != null && (evento.getCdop().equals("") == false)) {
			nrDoc = evento.getCdop();
		} else {
			nrDoc = folha.getDwFolha().getCdFolha() + nrDocDate + "-" + ompt.getIdPt();
		}

		/*
		 * Alessandre em 23-06-17 verifica se ja exsite OP cadastrada para o posto. Se existir retorna-la;
		 *
		 */
		PpCp ppcpPesquisa = pesquisarPpCpByNrDocCdPt(nrDoc, ompt.getCdPt());
		PpCp ppcpParam = new PpCp();
		ResultadoDTO resultado;
		String cdProduto = null;

		// Se o tipo de sessao for para criar OP entao necessariamente a OP deve ser criada ao inves de retornar a encontrada
		// por isso acrescentei o || no if abaixo
		if (ppcpPesquisa == null || ompt.isTipoSessaoCriaOP()) {

			if (ompt.isTipoSessaoCriaOP() || ompt.getOmTppt().getIdTppt() == OmTpptTemplate.Type.PVE.getId()) {
				String cdCp = nrDoc + "1";

				ppcpParam.setCdCp(cdCp);

				int i = 0;
				while (pesquisarPpCpByCdCp(ppcpParam) != null && i < 100) {
					i++;
					cdCp = nrDoc + i;
					ppcpParam.setCdCp(cdCp);
				}
				if (i >= 100) {
					log.info(idLog, 0, "i >= 100 saindo.");
					return null;
				}

				ppcpParam.setDthrFinal(fimDate);
				ppcpParam.setDthrInicio(iniDate);
				ppcpParam.setOmPt(ompt);
				ppcpParam.setOmUsrByIdUsrrevisao(usuarioLogado);
				ppcpParam.setPpCpprodutos(new HashSet<PpCpproduto>());
				ppcpParam.setPpPlano(plano);
				ppcpParam.setDwFolha(folha.getDwFolha());

				List<OmProduto> omProdutos = null;
				try {
					omProdutos = folhaRN.getProdutosFromDwFolha(folha.getDwFolha());
				} catch (Exception e) {
					omProdutos = new ArrayList<OmProduto>();
				}

				for (OmProduto omprod : omProdutos) {

					cdProduto = omprod.getCdProduto();

					PpCpproduto ppcpproduto = new PpCpproduto();
					ppcpproduto.setOmProduto(omprod);
					ppcpproduto.setPcsProducaoplanejada(new BigDecimal(qtdPlanejada));
					if (ompt.isTipoSessaoCriaOP())
						nrDoc = ppcpParam.getCdCp();

					ppcpproduto.setNrDoc(nrDoc);

					ppcpParam.getPpCpprodutos().add(ppcpproduto);

				}

				CpDTO cpDTO = new CpDTO();
				cpDTO.setCp(ppcpParam);

				ListaCPDTO listaCPDTO = new ListaCPDTO();
				listaCPDTO.setListaCps(new ArrayList<CpDTO>());
				listaCPDTO.getListaCps().add(cpDTO);

				log.info(idLog, 0, "Salvando ops");
				resultado = salvarPpCpOrdemProducao(listaCPDTO).getResultado();
			} else {
				resultado = new ResultadoDTO();
				resultado.setIdmensagem(resultado.getERROR_PLANO_SEM_CP());
			}

		} else {
			ppcpParam = ppcpPesquisa;
			resultado = new ResultadoDTO();
			resultado.setIdmensagem(resultado.getCOM_SUCESSO());
		}

		log.info(idLog, 0, "pesquisando se salvou realmente");
		PpCp novoPpCp = null;
		if (ppcpParam != null)
			novoPpCp = pesquisarPpCpByCdCp(ppcpParam);

		if (novoPpCp == null || resultado.getIdmensagem() != resultado.getCOM_SUCESSO()) {
			// FAIL
			if (novoPpCp == null)
				log.info(idLog, 0, "Nao salvou pois novoPpCp eh nulo");
			else
				log.info(idLog, 0, "Nao salvou pois idmensagem <> sucesso");
			return null;
		}

		long timeoutCIP = 0l;
		if (folha.getDwFolha() != null && folha.getDwFolha().getSegSetup() != null)
			timeoutCIP = folha.getDwFolha().getSegSetup();

		for (DwFolhasetup setup : folha.getDwFolha().getDwFolhasetupsForIdFolhaentrando()) {
			if (setup.getDwFolhaByIdFolhasaindo() != null
					&& ompt.getPpCp() != null
					&& ompt.getPpCp().getDwFolha() != null
					&& (setup.getDwFolhaByIdFolhasaindo().getIdFolha() == ompt.getPpCp().getDwFolha().getIdFolha())) {
				timeoutCIP = setup.getSegSetup().longValue();
				break;
			}
		}

		List<DadosProdutoSADTO> listaProdutosDTO = folhaRN.getDadosDeProdutoDaOPStandAlone(novoPpCp.getIdCp(), ompt.getIdPt());

		retorno = new OPAutomaticaDTO();
		retorno.setNrDoc(nrDoc);
		retorno.setQtdPlanejada(qtdPlanejada);
		retorno.setCdProduto(cdProduto);
		retorno.setCdFolha(folha.getDwFolha().getCdFolha());
		retorno.setIdFolha(folha.getDwFolha().getIdFolha());
		retorno.setCicloPadrao((long) cicloPadrao * 1000);
		retorno.setCicloTimeout(cicloTimeout);
		retorno.setCicloMinimo((long) cicloMinimo * 1000);
		retorno.setTimeoutCIP(timeoutCIP);
		retorno.setQtdPcsPorCiclo(qtdPcsPorCiclo);
		retorno.setListaProdutos(listaProdutosDTO);

		log.info(idLog, 0, "incluida op com sucesso");
		return retorno;
	}

	public PpCp pesquisarPpCpSemProducaoParaFerramenta(String cdpt, String cdFerramenta) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from PpCp a");
		q.append("join a.omPt b");
		q.append("join a.dwFolha c");
		q.append("join c.dwFolharaps d");
		q.append("join d.dwRap e");
		q.append("where a.stAtivo = 1");
		q.append("and b.cdPt = :cdpt");
		q.append("and upper(e.cdRap) = :cdrap");
		q.append("and a.dthrInicioreal is null");
		q.append("order by a.dthrInicio, a.idCp");

		q.defineParametro("cdpt", cdpt);
		q.defineParametro("cdrap", cdFerramenta.toUpperCase());

		q.setMaxResults(1);

		PpCp retorno = (PpCp) q.uniqueResult();

		return retorno;
	}

	public PpCp pesquisarPpCpSemProducaoPorProduto(String cdpt, String cdProduto) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from PpCp a");
		q.append("join a.omPt b");
		q.append("join a.dwFolha c");
		q.append("join c.dwFolharaps d");
		q.append("join d.dwFolharapcoms e");
		q.append("join e.omProduto f");
		q.append("where a.stAtivo = 1");
		q.append("and b.cdPt = :cdpt");
		q.append("and upper(f.cdProduto) = :cdproduto");
		q.append("and a.dthrInicioreal is null");
		// Nao pegar as ppcps que tiverem mais de um produto
		q.append("and (select count(*) from PpCpproduto a1 where a1.ppCp = a) = 1");
		q.append("order by a.dthrInicio, a.idCp");

		q.defineParametro("cdpt", cdpt);
		q.defineParametro("cdproduto", cdProduto.toUpperCase());
		q.setMaxResults(1);

		PpCp retorno = (PpCp) q.uniqueResult();

		if (retorno == null) {
			q.novaConsulta();
			q.append("select a");
			q.append("from PpCp a");
			q.append("join a.omPt b");
			q.append("join a.dwFolha c");
			q.append("join c.dwFolhaiacs d");
			q.append("join d.omProduto f");
			q.append("where a.stAtivo = 1");
			q.append("and b.cdPt = :cdpt");
			q.append("and f.cdProduto = :cdproduto");
			q.append("and a.dthrInicioreal is null");

			q.defineParametro("cdpt", cdpt);
			q.defineParametro("cdproduto", cdProduto);

			retorno = (PpCp) q.uniqueResult();
		}
		return retorno;
	}

	// Retorna a lista de dwrt de ppcp
	private List<DwRt> pesquisarListaDwRtDaOp(PpCp ppcp) {
		MapQuery q = new MapQuery(getDaoSession());

		q.append("select a");
		q.append("from DwRt a");
		q.append("where a.ppCp = :ppcp");

		q.defineParametro("ppcp", ppcp);

		return q.list();
	}

	public void trocarOP(String cdpt, String nrop, Date dthrevento) {
		UpRN upRN = new UpRN(getDao(), null);
		EventoColetado evento = new EventoColetado();
		IdwLogger log = new IdwLogger("trocaOP");
		int idLog = log.getIdAleatorio();
		int identacao = 0;

		// Inicializa o evento
		evento.setLog(log);
		evento.setIcUpDTO(Stubedelegate.getInstancia().getMsthread().getIcUp(cdpt));
		evento.setDthrEvento(dthrevento);

		// 1o Lancar envento de fim de planejamento
		evento.setTipoEvento(ServicoFactory._FINALIZA_OP);
		upRN.finalizarOP(log, idLog, identacao, evento);
		upRN.finalizarOPRestoLinha(log, idLog, identacao, evento);

		// 2o lancar evento de inicio de planejamento
		evento.setIcUpDTO(Stubedelegate.getInstancia().getMsthread().getIcUp(cdpt));
		evento.setTipoEvento(ServicoFactory._NOVA_OP);
		evento.setCdop(nrop);

		MsEvt msevt = upRN.iniciarNovaOP(evento);
		if (msevt != null) {
			upRN.iniciarNovaOpRestoLinha(evento);
		}
	}

	public PpCp pesquisarPpCpByNrDoc(String cdcp) {
		// se nao foi passada a op entao ja retornar null
		if (cdcp == null)
			return null;

		MapQuery q = null;
		if (getDaoSession() != null)
			q = new MapQuery(getDaoSession());
		else {
			try {
				q = new MapQuery(getDaoSessionStatless());
			} catch (SemSessaoHibernateException e) {
			}
		}

		q.append("select ppcp");
		q.append("from PpCp ppcp");
		q.append("join fetch ppcp.ppCpprodutos ppcpproduto");
		q.append("where ppcpproduto.nrDoc = :cdcp");
		q.append(" and ppcp.stAtivo = 1");

		q.defineParametro("cdcp", cdcp.toUpperCase());
		q.setMaxResults(1);
		PpCp retorno = (PpCp) q.uniqueResult();
		return retorno;
	}

	// Metodo que retona a lista de ppcp com todos os postos de um GT e determinado produto. Caso a OP exista entao utiliza-la como
	// referencia.
	public ListaCPDTO definePpCpParaOProduto(OmGt omgt, String cdproduto, String nrop) {
		ListaCPDTO retorno = new ListaCPDTO();
		// Obter as ppcps que ja existem
		MapQuery q = new MapQuery(getDaoSession());

		q.append("select a");
		q.append("from PpCp a");
		q.append("join fetch a.ppCpprodutos b");
		q.append("join fetch a.omPt c");
		q.append("join fetch c.omGt d");
		q.append("join fetch b.omProduto  e");
		q.append("join fetch a.dwFolha f");
		q.append("where a.stAtivo = 1");
		q.append("and b.nrDoc = :nrdoc");
		q.append("and d = :omgt");
		q.defineParametro("nrdoc", nrop);
		q.defineParametro("omgt", omgt);
		// Inicializa o retorno
		List<PpCp> ppcps = q.list();
		for (PpCp ppcp : ppcps) {
			CpDTO cpdto = new CpDTO();
			cpdto.setCp(ppcp.clone());
			cpdto.getCp().getOmPt().setOmTppt(ppcp.getOmPt().getOmTppt().clone(false));
			cpdto.getCp().getOmPt().setOmGt(ppcp.getOmPt().getOmGt().clone(false));
			retorno.getListaCps().add(cpdto);
		}

		// Obtem produto
		ProdutoRN drn = new ProdutoRN(getDao());
		OmProduto omproduto;
		try {
			omproduto = drn.getOmProduto(cdproduto);
		} catch (RegistroDesconhecidoException e) {
			return retorno;
		}

		// Obtem todos os postos do GT
		PTRN prn = new PTRN(getDao());
		List<OmPt> pts = prn.pesquisarPtByGt(omgt);

		OmProduto omprodutoClone = omproduto.clone(false);

		// Para cada posto, obter a OP pelo nrop
		for (OmPt ompt : pts) {

			System.out.println("cdpt:" + ompt.getCdPt());
			// Se NAO tiver OP, criar uma virtual com base no cdproduto
			if (retorno.isExistePt(ompt) == false) {
				System.out.println("nao existe ");
				// Criar uma OP virtual para retorno ao usuario
				CpDTO cpdto = new CpDTO();
				PpCp ppcp = criaOPVirtual(ompt, omprodutoClone, nrop);
				cpdto.setCp(ppcp);
				retorno.getListaCps().add(cpdto);
			} else {
				System.out.println("existe. atualizar folha se for desconhecida");
			}
		}
		return retorno;
	}

	private PpCp criaOPVirtual(OmPt ompt, OmProduto omproduto, String nrop) {
		PpCp ppcp = new PpCp();
		PpCpproduto ppcpproduto = new PpCpproduto();
		getDao().evict(ppcp);
		getDao().evict(ppcpproduto);

		ppcp.setIdCp(null);
		ppcp.setCdCp(nrop + "-" + ompt.getCdPt());
		ppcp.setDthrFinal(null);
		ppcp.setDthrInicio(null);
		ppcp.setDtRevisao(null);
		ppcp.setDwFolha(obtemFolha(ompt, omproduto));
		ppcp.setStCp(PpCpTemplate.StCp.CADASTRADA.getValue());
		ppcp.setStAtivo((byte) 1);
		ppcp.setTpCp(null);
		ppcp.setOmPt(ompt.clone(false));
		ppcp.getOmPt().setOmGt(ompt.getOmGt().clone(false));
		ppcp.getOmPt().setOmTppt(ompt.getOmTppt().clone(false));

		ppcpproduto.setIdCpproduto(null);
		ppcpproduto.setNrDoc(nrop);
		ppcpproduto.setOmProduto(omproduto);
		ppcpproduto.setPcsProducaoplanejada(null);

		Set<PpCpproduto> ppcpprodutos = new HashSet<>();
		ppcpprodutos.add(ppcpproduto);
		ppcp.setPpCpprodutos(ppcpprodutos);

		return ppcp;
	}

	private DwFolha obtemFolha(OmPt ompt, OmProduto omproduto) {
		FolhaRN frn = new FolhaRN(getDao());
		DwFolha retorno = frn.pesquisaProdutoNaFolha(omproduto, ompt.getOmTppt());
		if (retorno != null) {
			retorno = retorno.clone(false);
		}
		return retorno;
	}

	public PpCpnserie getPpCpnserie(PpCp ppcp, String cb) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from PpCpnserie a");
		q.append("join a.dwNserie c");
		q.append("where a.ppCp = :ppcp");
		q.append("and c.cb = :cb");

		q.setMaxResults(1);
		q.defineParametro("ppcp", ppcp);
		q.defineParametro("cb", cb);

		return (PpCpnserie) q.uniqueResult();
	}

	public PpCp pesquisarPpCpAtualByCdPt(String cdpt) {
		MapQuery q = new MapQuery(getDaoSession());

		q.append("select a");
		q.append("from PpCp a");
		q.append("join a.omPt b");
		q.append("join fetch a.ppCpprodutos c");
		q.append("where b.cdPt = :cdpt");
		q.append("and b.stAtivo = 1");

		q.defineParametro("cdpt", cdpt);
		q.setMaxResults(1);

		return (PpCp) q.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<FolhaRapProdutoDTO> getProdutosOPAtual(String cdPt) {
		List<FolhaRapProdutoDTO> retorno = new ArrayList<FolhaRapProdutoDTO>();

		int _cdpro = 0;
		int _dspro = _cdpro + 1;
		int _ppc = _dspro + 1;

		String strSQL = "";

		getDao().iniciaSessao();

		SQLQuery q = null;

		strSQL = strSQL.concat("SELECT pro.cd_produto, pro.ds_produto, frc.qt_ativa ");
		strSQL = strSQL.concat("  FROM om_pt pt  ");
		strSQL = strSQL.concat("  JOIN pp_cp cp ON (cp.id_cp = pt.id_cp) ");
		strSQL = strSQL.concat("  JOIN dw_folharap fr ON (fr.id_folha = cp.id_folha) ");
		strSQL = strSQL.concat("  JOIN dw_folharapcom frc ON (frc.id_folharap = fr.id_folharap) ");
		strSQL = strSQL.concat("  JOIN om_produto pro ON (pro.id_produto = frc.id_produto) ");
		strSQL = strSQL.concat(" WHERE pt.st_ativo = 1 ");
		strSQL = strSQL.concat("   AND pt.cd_pt = :cdPt ");
		strSQL = strSQL.concat(" ORDER BY pro.cd_produto");

		q = this.getDaoSession().createSQLQuery(strSQL);
		q.setParameter("cdPt", cdPt);
		List<Object> lista = q.list();

		for (Object reg : lista) {
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			FolhaRapProdutoDTO item = new FolhaRapProdutoDTO();
			item.setCdProduto((String) registroLido[_cdpro]);
			item.setDsProduto((String) registroLido[_dspro]);
			item.setQtAlocada(ConversaoTipos.converterParaBigDecimal(registroLido[_ppc]).setScale(4));

			retorno.add(item);
		}

		getDao().finalizaSessao();
		lista = null;

		return retorno;
	}

	@SuppressWarnings("unused")
	public ListaOPSimplesPesqDTO getOPsSimplesAtivas(FiltroPesquisaDTO filtro) {
		ListaOPSimplesPesqDTO retorno = new ListaOPSimplesPesqDTO();
		retorno.setItems(new ArrayList<OPSimplesPesqDTO>());
		retorno.setMeta(new MetaDTO(filtro));

		MapQuery q = new MapQuery(this.getDaoSession());

		q.append("select distinct t ");
		q.append("from PpCp t ");
		q.append("join fetch t.omPt pt ");
		q.append("join fetch t.ppCpprodutos pp ");
		q.append("join fetch t.dwFolha f ");
		q.append("join fetch f.dwFolharaps fr ");
		q.append("left join fetch t.ppCliente cli ");
		q.append("where t.stAtivo = 1 ");
		q.append("and pt.omTppt.cdTppt = 'CIC' ");

		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")) {
			q.append("AND (");
			q.append(" upper(pp.nrDoc) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(f.cdFolha) LIKE '%"
					+ filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(cli.cdCliente) LIKE '%"
					+ filtro.getConteudoPesquisa().toUpperCase() + "%' ");
			q.append(")");
		}

		q.append("order by pp.nrDoc, pt.cdPt");

		// Lista do pojo
		List<PpCp> listaPesquisa = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());

		// Percorre as ferramentas da folha
		for (PpCp registro : listaPesquisa) {

			OPSimplesPesqDTO regDTO = new OPSimplesPesqDTO();
			regDTO.setNrDoc(registro.getPpCpprodutos().iterator().next().getNrDoc());
			regDTO.setCdPt(registro.getOmPt().getCdPt());
			regDTO.setCdFolha(registro.getDwFolha().getCdFolha());
			regDTO.setProdPlan(new BigDecimal(registro.getQtPecasProduzir()).setScale(3));

			if (registro.getPpCliente() != null) {
				regDTO.setCdCliente(registro.getPpCliente().getCdCliente());
			} else {
				regDTO.setCdCliente("");
			}

			regDTO.setDthrIniPlan(DataHoraRN.dateToStringYYYYDDMMHHMMSS(registro.getDthrInicio()));
			if (registro.getDthrFinal() != null) {
				regDTO.setDthrFimPlan(DataHoraRN.dateToStringYYYYDDMMHHMMSS(registro.getDthrFinal()));
			} else {
				regDTO.setDthrFimPlan("");
			}

			if (registro.getDthrInicioreal() != null) {
				regDTO.setDthrIniRealMs(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(registro.getDthrInicioreal()));
			} else {
				regDTO.setDthrIniRealMs("");
			}

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

	public OPCadDTO getCpByCd(String nrDoc) {
		OPCadDTO retorno = new OPCadDTO();
		String listaCdPtSelParaNotIN = "";
		MapQuery q = new MapQuery(this.getDaoSession());

		q.append("select distinct t ");
		q.append("from PpCp t ");
		q.append("join fetch t.omPt pt ");
		q.append("join fetch t.ppCpprodutos pp ");
		q.append("join fetch t.dwFolha f ");
		q.append("join fetch f.dwFolharaps fr ");
		q.append("left join fetch t.ppCliente cli ");
		q.append("where t.stAtivo = 1 ");
		q.append("and pt.omTppt.cdTppt = 'CIC' ");
		q.append("and pp.nrDoc = :nrDoc ");
		q.append("order by t.dthrInicioreal, t.dthrInicio, pt.cdPt");

		q.defineParametro("nrDoc", nrDoc);

		// Lista do pojo
		List<PpCp> lista = q.list();
		if (lista.size() > 0) {
			retorno.setListaOPsPorPt(new ArrayList<OPPtCadDTO>());
			retorno.setPtsDisponiveis(new ArrayList<OPPtCadDTO>());
			retorno.setPtsSelecionados(new ArrayList<OPPtCadDTO>());
		}

		Boolean isPrimeiraCP = true;
		for (PpCp registro : lista) {
			OPPtCadDTO regPtOP = new OPPtCadDTO();
			regPtOP.setProdutos(new ArrayList<OPProdutoCadDTO>());

			regPtOP.setIdCp(registro.getId());
			regPtOP.setCdCp(registro.getCdCp());
			regPtOP.setCdPt(registro.getOmPt().getCdPt());
			regPtOP.setNrDoc(registro.getPpCpprodutos().iterator().next().getNrDoc());
			regPtOP.setCdFolha(registro.getDwFolha().getCdFolha());
			regPtOP.setProdPlan(new BigDecimal(registro.getQtPecasProduzir()).setScale(3));

			if (registro.getPpCliente() != null) {
				regPtOP.setCdCliente(registro.getPpCliente().getCdCliente());
			} else {
				regPtOP.setCdCliente("");
			}

			regPtOP.setDthrIniPlan(DataHoraRN.dateToStringYYYYDDMMHHMMSS(registro.getDthrInicio()));

			if (registro.getDthrFinal() != null) {
				regPtOP.setDthrFimPlan(DataHoraRN.dateToStringYYYYDDMMHHMMSS(registro.getDthrFinal()));
			} else {
				regPtOP.setDthrFimPlan("");
			}

			if (registro.getDthrInicioreal() != null) {
				regPtOP.setDthrIniRealMs(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(registro.getDthrInicioreal()));
			} else {
				regPtOP.setDthrIniRealMs("");
			}

			if (registro.getStCp() != null) {
				regPtOP.setStatusCp(registro.getStCp());
			} else {
				regPtOP.setStatusCp(0);
			}

			if (registro.getIsFinalserie() != null) {
				regPtOP.setCpCritica(registro.getIsFinalserie());
			} else {
				regPtOP.setCpCritica(false);
			}

			regPtOP.setRevisao(registro.getRevisao().intValue());
			regPtOP.setStRegistro(registro.getStAtivo().intValue());
			regPtOP.setCdUsrRev(registro.getOmUsrByIdUsrrevisao().getCdUsr());

			for (PpCpproduto produtoOP : registro.getPpCpprodutos()) {
				OPProdutoCadDTO produto = new OPProdutoCadDTO();
				produto.setCdProduto(produtoOP.getOmProduto().getCdProduto());
				produto.setDsProduto(produtoOP.getOmProduto().getDsProduto());
				produto.setProdPlan(produtoOP.getPcsProducaoplanejada());
				produto.setCdFerramenta(retorno.getCdFolha());

				if (registro.getDwFolha().getDwFolharaps() != null) {
					DwFolharapcom rapc = null;

					if (produtoOP.getOmProduto().getDwFolharapcoms() == null) {

					} else {
						rapc = produtoOP.getOmProduto().getDwFolharapcoms().iterator().next();
					}

					if (rapc != null) {
						produto.setProdPorCiclo(rapc.getQtAtiva());
					} else {
						produto.setProdPorCiclo(BigDecimal.ONE);
					}
				} else {
					produto.setProdPorCiclo(BigDecimal.ONE);
				}

				produto.setProdPorCiclo(produto.getProdPorCiclo().setScale(3));
				produto.setProdPlan(produto.getProdPlan().setScale(3));

				regPtOP.getProdutos().add(produto);
			}

			if (isPrimeiraCP) {
				// atribui valores "comuns" da interface de cadastro
				isPrimeiraCP = false;

				retorno.setNrDoc(regPtOP.getNrDoc());
				retorno.setCdCliente(regPtOP.getCdCliente());
				retorno.setCdFolha(regPtOP.getCdFolha());
				retorno.setCpCritica(regPtOP.getCpCritica());
				retorno.setDthrIniPlan(regPtOP.getDthrIniPlan());
				retorno.setDthrFimPlan(regPtOP.getDthrFimPlan());
				retorno.setDthrIniRealMs(regPtOP.getDthrIniRealMs());
				retorno.setProdPlan(regPtOP.getProdutos().get(0).getProdPlan());
			}

			// se quiser ver detahes por pt, habilitar a linha abaixo e desabilitar a seguinte
			// retorno.getListaOPsPorPt().add(regPtOP);
			retorno.setListaOPsPorPt(null);

			// adiciona pts selecionados na lista
			OPPtCadDTO ptSel = new OPPtCadDTO();
			ptSel.setCdPt(regPtOP.getCdPt());
			ptSel.setStatusCp(regPtOP.getStatusCp());
			ptSel.setEditavel(regPtOP.getDthrIniRealMs().equals(""));
			retorno.getPtsSelecionados().add(ptSel);

			if (!listaCdPtSelParaNotIN.equals("")) {
				listaCdPtSelParaNotIN = listaCdPtSelParaNotIN + ", ";
			}

			listaCdPtSelParaNotIN = listaCdPtSelParaNotIN + "'" + regPtOP.getCdPt() + "'";

		}

		lista = null;
		q = null;

		// ordena postos selecionados
		if (retorno.getPtsSelecionados() != null) {
			Collections.sort(retorno.getPtsSelecionados(), comparaCdPt);

			// recupera postos disponiveis (todos do tipo CIC que estejam ativos e não estejam na lista de pts selecionados);
			q = new MapQuery(this.getDaoSession());

			q.append("select distinct t ");
			q.append("  from OmPt t ");
			q.append(" where t.stAtivo = 1 ");
			q.append("   and t.omTppt.cdTppt = 'CIC' ");
			q.append(" AND t.tpSessao IN (0, 1, 2)");

			if (!listaCdPtSelParaNotIN.equals("")) {
				q.append(" and t.cdPt NOT IN (" + listaCdPtSelParaNotIN + ")");
			}
			q.append(" order by t.cdPt");

			// Lista do pojo
			List<OmPt> listaPts = q.list();
			for (OmPt pt : listaPts) {
				OPPtCadDTO ptDisp = new OPPtCadDTO();
				ptDisp.setCdPt(pt.getCdPt());
				ptDisp.setStatusCp(-1);
				ptDisp.setEditavel(true);
				retorno.getPtsDisponiveis().add(ptDisp);
			}

			q = null;
			listaPts = null;
		}

		return retorno;

	}

	public OpComRapDTO getProximaOPComRapProduto(String cdPt) {
		OpComRapDTO retorno = new OpComRapDTO();
 
		MapQuery q = new MapQuery(this.getDaoSession());

		q.append("select distinct t ");
		q.append("from PpCp t ");
		q.append("join fetch t.omPt pt ");
		q.append("join fetch t.ppCpprodutos pp ");
		q.append("join fetch t.dwFolha f ");
		q.append("join fetch f.dwFolharaps fr ");
		q.append("left join fetch t.ppCliente cli ");
		q.append("where t.stAtivo = 1 ");
		q.append("and t.stCp IN (0, 1) ");
		q.append("and pt.omTppt.cdTppt = 'CIC' ");
		q.append("and pt.cdPt = :cdPt ");
		q.append("order by t.dthrInicio");
		q.defineParametro("cdPt", cdPt);
		q.setMaxResults(1);

		// Lista do pojo
		List<PpCp> lista = q.list();
		if (lista.size() == 0) {
			retorno.setCdCp("");
			retorno.setNrDoc("");
			retorno.setCdRap("");
			retorno.setCdProduto("");
			retorno.setDthrIni("");
			retorno.setDtHrFim("");
			retorno.setStatusCP(0);
			retorno.setTpSessao(0);
		} else {
		 	PpCp op = lista.get(0);
 			retorno.setCdCp(op.getCdCp());
 			retorno.setNrDoc(op.getPpCpprodutos().iterator().next().getNrDoc());
 			retorno.setCdRap(op.getDwFolha().getDwFolharaps().iterator().next().getDwRap().getCdRap());
 			retorno.setCdProduto(op.getPpCpprodutos().iterator().next().getOmProduto().getCdProduto());
 			retorno.setDthrIni(DataHoraRN.dateToStringYYYYMMDDHHMMSS(op.getDthrInicio()));
 			retorno.setDtHrFim(op.getDthrFinal() == null ? "" : DataHoraRN.dateToStringYYYYMMDDHHMMSS(op.getDthrFinal()) );
 			retorno.setStatusCP(op.getStCp());
 			retorno.setTpSessao(op.getOmPt().getTpSessao().intValue());
		}

		
		lista = null;
		q = null;
 

		return retorno;

	}

	// comparators
	private static final Comparator<OPPtCadDTO> comparaCdPt = new Comparator<OPPtCadDTO>() {
		@Override
		public int compare(OPPtCadDTO o1, OPPtCadDTO o2) {
			return o1.getCdPt().compareTo(o2.getCdPt());
		}
	};

}
