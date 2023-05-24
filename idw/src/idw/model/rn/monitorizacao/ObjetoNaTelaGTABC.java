package idw.model.rn.monitorizacao;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgabclim;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.pojos.template.OmCfgabclimTemplate.TpClasseABC;
import idw.model.pojos.template.PpCpTemplate.StCp;
import idw.model.rn.classificacaoabc.ClassificacaoABCRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.util.AritmeticaUtil;
import idw.util.IdwLogger;
import idw.webservices.dto.ColorDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;
import idw.webservices.dto.PtDTO;

public class ObjetoNaTelaGTABC {

	private final Map<TpClasseABC, OmCfgabclim> limitesAbc;
	private final DAOGenerico dao;
	private final IdwLogger log;

	private final ClassificacaoABCRN classificacaoABCRN;

	public ObjetoNaTelaGTABC(DAOGenerico dao, IdwLogger log, OmCfg omcfg) {
		this.log = log;
		this.dao = dao;
		this.classificacaoABCRN = new ClassificacaoABCRN(dao);
		this.limitesAbc = classificacaoABCRN.getLimitesClassesABC(omcfg.getOmCfgabc());
	}

	public void criarDadosParaGtABC(ObjRtMonitorizacaoDTO retorno, OmObj omobj, Date dtreferencia, DwTurno dwturno, DwConsolidTemplate.TpId tpId, boolean isTurnoAtual, Integer filtroOp) {

		List<DwConsolid> ids = getDwConsolidsDoPeriodo(omobj, log, dtreferencia, dwturno, tpId, filtroOp);

		Map<String, List<DwConsolid>> dwConsolidsTurnoPorPt = new HashMap<String, List<DwConsolid>>();
		
		Map<String, BigDecimal> custosSaldosPorProduto = new HashMap<String, BigDecimal>();
		Map<String, Set<OmPt>> produtosMaquinas = new HashMap<String, Set<OmPt>>();
		BigDecimal custoSaldoTodosProdutos = agruparCustosSaldos(ids, dwConsolidsTurnoPorPt, custosSaldosPorProduto, produtosMaquinas);

		if (custoSaldoTodosProdutos.compareTo(BigDecimal.ZERO) > 0) {
			Map<TpClasseABC, Set<DwConsolid>> producaoClasseABCParaCalculoOEE = new HashMap<TpClasseABC, Set<DwConsolid>>();
			Map<TpClasseABC, Set<OmPt>> ptsPorClasseABC = new HashMap<TpClasseABC, Set<OmPt>>();
			agruparPorTpClasseABC(dwConsolidsTurnoPorPt, custosSaldosPorProduto, produtosMaquinas, custoSaldoTodosProdutos, producaoClasseABCParaCalculoOEE, ptsPorClasseABC);
			setObjRtMonitorizacao(retorno, producaoClasseABCParaCalculoOEE, ptsPorClasseABC);
		}

	}

	private void setObjRtMonitorizacao(ObjRtMonitorizacaoDTO retorno,
			Map<TpClasseABC, Set<DwConsolid>> producaoClasseABCParaCalculoOEE,
			Map<TpClasseABC, Set<OmPt>> ptsPorClasseABC) {

		Map<String, PtDTO> ptDTOs = new HashMap<String, PtDTO>();

		for (TpClasseABC tpClasseABC : ptsPorClasseABC.keySet()) {
			Set<OmPt> ptsDaClasse = ptsPorClasseABC.get(tpClasseABC);

			List<PtDTO> listaPtsDTO = new ArrayList<>();

			if (ptsDaClasse != null && !ptsDaClasse.isEmpty()) {
				Set<DwConsolid> producao = producaoClasseABCParaCalculoOEE.get(tpClasseABC);
				BigDecimal oee = classificacaoABCRN.calcularOEE(producao);

				OmCfgabclim omCfgabclim = limitesAbc.get(tpClasseABC);
				for (OmPt omPt : ptsPorClasseABC.get(tpClasseABC)) {
					PtDTO ptDTO = ptDTOs.get(omPt.getCdPt());
					if (ptDTO == null) {
						ptDTO = new PtDTO();
						ptDTO.setPt(omPt.clone(false));
					}
					listaPtsDTO.add(ptDTO);
				}

				if (tpClasseABC.equals(TpClasseABC.CLASSE_A)) {
					retorno.setIndOEEClasseA(oee.doubleValue());
					retorno.setIndOEEMetaClasseA(omCfgabclim.getLimiteSup().doubleValue());
					retorno.setCorGtClasseA(getCorClasseABC(oee, omCfgabclim));
					retorno.setQtdePostosClasseA(listaPtsDTO.size());
					retorno.setPtsClasseA(listaPtsDTO);
				} else if (tpClasseABC.equals(TpClasseABC.CLASSE_B)) {
					retorno.setIndOEEClasseB(oee.doubleValue());
					retorno.setIndOEEMetaClasseB(omCfgabclim.getLimiteSup().doubleValue());
					retorno.setCorGtClasseb(getCorClasseABC(oee, omCfgabclim));
					retorno.setQtdePostosClasseB(listaPtsDTO.size());
					retorno.setPtsClasseB(listaPtsDTO);
				} else if (tpClasseABC.equals(TpClasseABC.CLASSE_C)) {
					retorno.setIndOEEClasseC(oee.doubleValue());
					retorno.setIndOEEMetaClasseC(omCfgabclim.getLimiteSup().doubleValue());
					retorno.setCorGtClasseC(getCorClasseABC(oee, omCfgabclim));
					retorno.setQtdePostosClasseC(listaPtsDTO.size());
					retorno.setPtsClasseC(listaPtsDTO);
				}

			}

		}
	}

	private void agruparPorTpClasseABC(
			Map<String, List<DwConsolid>> dwConsolidsTurnoPorPt,
			Map<String, BigDecimal> custosSaldosPorProduto, 
			Map<String, Set<OmPt>> produtosMaquinas,
			BigDecimal custoSaldoTodosProdutos, 
			Map<TpClasseABC, Set<DwConsolid>> producaoClasseABCParaCalculoOEE,
			Map<TpClasseABC, Set<OmPt>> ptsPorClasseABC) {
		
		for (String cdProduto : custosSaldosPorProduto.keySet()) {
		
			BigDecimal custoSaldo = custosSaldosPorProduto.get(cdProduto);

			TpClasseABC tpClasseABC = classificacaoABCRN.getClasseAbc(custoSaldo, custoSaldoTodosProdutos, limitesAbc);

			Set<DwConsolid> producao = producaoClasseABCParaCalculoOEE.get(tpClasseABC);
			if (producao == null) {
				producao = new HashSet<DwConsolid>();
				producaoClasseABCParaCalculoOEE.put(tpClasseABC, producao);
			}
			Set<OmPt> ptsDaClasse = ptsPorClasseABC.get(tpClasseABC);
			if (ptsDaClasse == null) {
				ptsDaClasse = new HashSet<OmPt>();
				ptsPorClasseABC.put(tpClasseABC, ptsDaClasse);
			}

			Collection<OmPt> ptsComProduto = produtosMaquinas.get(cdProduto);
			if (ptsComProduto != null && !ptsComProduto.isEmpty()) {
				for (OmPt omPt : ptsComProduto) {
					producao.addAll(dwConsolidsTurnoPorPt.get(omPt.getCdPt()));
					ptsDaClasse.add(omPt);
				}
			}
		}
	}

	private ColorDTO getCorClasseABC(BigDecimal oee, OmCfgabclim omCfgabclim) {
		if (oee.compareTo(omCfgabclim.getLimiteInf()) < 0) {
			return new ColorDTO(Color.RED);
		} else if (oee.compareTo(omCfgabclim.getLimiteSup()) > 0) {
			return new ColorDTO(Color.GREEN);
		} else {
			return new ColorDTO(Color.YELLOW);
		}
	}

	private List<DwConsolid> getDwConsolidsDoPeriodo(OmObj omobj, IdwLogger log, Date dtreferencia, DwTurno dwturno, DwConsolidTemplate.TpId tpId, Integer filtroOp) {
		List<DwConsolid> ids;
		DetalheMonitorizacaoPTInsertRN rnid = new DetalheMonitorizacaoPTInsertRN(this.dao);
		FiltroDetalhePTInjetDTO filtro = new FiltroDetalhePTInjetDTO();

		filtro.setDtReferencia(dtreferencia);
		filtro.setDwTurno(dwturno);
		filtro.setTpId(tpId.getValue());
		filtro.setOmGt(omobj.getOmGtByIdGtfilho());
		filtro.setFiltroOp(filtroOp);

		ids = rnid.pesquisarDwConsolids(log, filtro);
		return ids;
	}

	/* Alessandre em 26-10-17 removi o metodo abaixo pois nao iremos mais usar os ultimos ids como referencia para postreior pegar os ids acumulados
	 * 
	private Collection<DwConsolid> getApenasUltimosDwConsolidDasMaquinas(List<DwConsolid> dwConsolids) {
		Map<String, DwConsolid> ultimosIds = new HashMap<String, DwConsolid>();

		for (DwConsolid dwConsolid : dwConsolids) {
			String cdPt = dwConsolid.getOmPt().getCdPt();
			Long id = dwConsolid.getIdConsolid();
			DwConsolid ultimoId = ultimosIds.get(cdPt);
			if (ultimoId == null || id.compareTo(ultimoId.getIdConsolid()) > 0) {
				ultimosIds.put(cdPt, dwConsolid);
			}

		}

		return ultimosIds.values();
	}
	 */

	private BigDecimal agruparCustosSaldos(
			Collection<DwConsolid> ids,
			Map<String, List<DwConsolid>> dwConsolidsTurnoPorPt, 
			Map<String, BigDecimal> custosSaldosPorProduto,
			Map<String, Set<OmPt>> produtosMaquinas) {


		BigDecimal custoSaldoTodosProdutos = BigDecimal.ZERO;

		for (DwConsolid id : ids) {

			OmPt omPt = id.getOmPt();

			// Se pt já foi adicionada não precisa mais acessar, seu custo do
			// saldo já foi calculado
			if (dwConsolidsTurnoPorPt.containsKey(omPt.getCdPt())) {
				List<DwConsolid> listaProducaoTurnoPt = dwConsolidsTurnoPorPt.get(omPt.getCdPt());
				listaProducaoTurnoPt.add(id);
				dwConsolidsTurnoPorPt.put(omPt.getCdPt(), listaProducaoTurnoPt);
			} else {

				//List<DwConsolid> listaProducaoTurnoPt = dwConsolidDAO.getProducaoDaOP(dwConsolid.getOmPt().getIdPt(), dwConsolid.getPpCp().getIdCp(), false, false, false);
				
				// Alessandre em 07-06-17 teve uma situacao em que listaProducaoAcumuladaPt esta vazia, pois ainda nao tem o ACUMULADA
				// Alessadnre em 26-07-17 removi o if pois nao estamos mais usando o tpId acumulado mas os ids do turno como  referencia
				//if (listaProducaoTurnoPt.isEmpty() == false) {
					//DwConsolid dwConsolTurno = listaProducaoTurnoPt.get(0);
					PpCp ppCp = id.getPpCp();
	
					if (StCp.INICIADA.equals(ppCp.getStCp())) {
	
						BigDecimal maiorCustoSaldoProdutoDoPt = BigDecimal.ZERO;
						OmProduto produtoComMaiorCustoSaldoDoPt = null;
	
						for (PpCpproduto ppCpproduto : ppCp.getPpCpprodutos()) {
							OmProduto omProduto = ppCpproduto.getOmProduto();
	
							BigDecimal custoSaldo = classificacaoABCRN.getCustoSaldo(ppCpproduto);
	
							if (custoSaldo.compareTo(BigDecimal.ZERO) > 0) {
	
								List<DwConsolid> listaProducaoTurnoPt = new ArrayList<>();
								listaProducaoTurnoPt.add(id);
								
								dwConsolidsTurnoPorPt.put(omPt.getCdPt(), listaProducaoTurnoPt);
	
								custoSaldoTodosProdutos = custoSaldoTodosProdutos.add(custoSaldo);
	
								BigDecimal custoSaldoTotalPorProduto = custosSaldosPorProduto.get(omProduto.getCdProduto());
								custoSaldoTotalPorProduto = AritmeticaUtil.somar(custoSaldo, custoSaldoTotalPorProduto);
								custosSaldosPorProduto.put(omProduto.getCdProduto(), custoSaldoTotalPorProduto);
	
								if (custoSaldo.compareTo(maiorCustoSaldoProdutoDoPt) > 0) {
									produtoComMaiorCustoSaldoDoPt = omProduto;
								}
							}
	
						}
	
						if (produtoComMaiorCustoSaldoDoPt != null) {
							Set<OmPt> pts = produtosMaquinas.get(produtoComMaiorCustoSaldoDoPt.getCdProduto());
							if (pts == null) {
								pts = new HashSet<OmPt>();
								produtosMaquinas.put(produtoComMaiorCustoSaldoDoPt.getCdProduto(), pts);
							}
							pts.add(omPt);
						}
	
					}
				//}
			}
		}

		return custoSaldoTodosProdutos;
	}

}
