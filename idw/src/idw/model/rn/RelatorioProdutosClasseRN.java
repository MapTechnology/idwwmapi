package idw.model.rn;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgabc;
import idw.model.pojos.OmCfgabclim;
import idw.model.pojos.OmProduto;
import idw.model.pojos.template.OmCfgabclimTemplate.TpClasseABC;
import idw.model.rn.classificacaoabc.ClassificacaoABCRN;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroRelatorioAlertaDTO;
import idw.webservices.dto.RelatorioProdutoClasseDTO;

public class RelatorioProdutosClasseRN extends AbstractRN<DAOGenerico> {
	
	public RelatorioProdutosClasseRN() {
		this(null);
	}
	
	public RelatorioProdutosClasseRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public RelatorioProdutoClasseDTO getRelatorioProdutoClasse(FiltroRelatorioAlertaDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioProdutosClasseRN.getRelatorioProdutoClasse");
		log.info( idLog , 0, "RelatorioProdutosClasseRN.getRelatorioProdutoClasse filtro usado:" + filtro.toString());
		
		RelatorioProdutoClasseDTO retorno = new RelatorioProdutoClasseDTO();
		retorno.setItens(new ArrayList<RelatorioProdutoClasseDTO>());
		HashMap<String, RelatorioProdutoClasseDTO> mapProdutos = new HashMap<>();
		List<DwConsolid> listaConsolid = consultaRelatorio(filtro);
		
		HashMap<String, BigDecimal> saldoDaOp = new HashMap<>();
		
		for(DwConsolid consolid : listaConsolid) {
			
			for(DwConsol consol : consolid.getDwConsols()) {
				for(DwConsolpr consolpr : consol.getDwConsolprs()) {
					String cdProduto = consolpr.getOmProduto().getCdProduto();						
					
					//Calcula o saldo da OP por produto e OP total
					for(idw.model.pojos.PpCpproduto produto : consolpr.getOmProduto().getPpCpprodutos()){
						int status = produto.getPpCp().getStCp();					
						
						if(status == 6){
							if(!saldoDaOp.containsKey(cdProduto)){
								BigDecimal producaoPlanejada = produto.getPcsProducaoplanejada() != null ? produto.getPcsProducaoplanejada() : new BigDecimal(0);
								BigDecimal producaoBruta = produto.getPcsProducaobruta() != null ? produto.getPcsProducaobruta() : new BigDecimal(0);
								BigDecimal producaoRefugada = produto.getPcsProducaorefugada() != null ? produto.getPcsProducaorefugada() : new BigDecimal(0);
								
								BigDecimal saldoOP = producaoPlanejada.subtract(producaoBruta).subtract(producaoRefugada);								
								saldoDaOp.put(cdProduto, saldoOP);								
							}							
						}
						
					}
					
					BigDecimal custo2casas = (consolpr.getOmProduto().getVlCustounit() != null ? consolpr.getOmProduto().getVlCustounit() : BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP);					
					double custoUnitario = custo2casas.doubleValue();
					int producaoLiquida = consolpr.getPcsProducaoBruta() != null ? consolpr.getPcsProducaoBruta().intValue() : 0;
					if (consolpr.getPcsProducaoRefugada() != null)
						producaoLiquida -= consolpr.getPcsProducaoRefugada().intValue();
					
					RelatorioProdutoClasseDTO item = mapProdutos.get(cdProduto);
					if(item == null) {
						item = new RelatorioProdutoClasseDTO();
						item.setProduto(cdProduto);
						item.setCustoUnitario(custoUnitario);
						item.setProducaoLiquida(producaoLiquida);
						
						if(saldoDaOp.get(cdProduto) != null){
							item.setClasse(saldoDaOp.get(cdProduto).doubleValue());
						} else {
							item.setClasse(0);
						}
						
						
						mapProdutos.put(cdProduto, item);
					} else {
						int prodLiqSomada = item.getProducaoLiquida() +  producaoLiquida;
						item.setProducaoLiquida(prodLiqSomada);
					}					
				}
			}
		}
				
		/*
		 * Se foi solicitado que todos os produtos sejam apresentados, entao
		 * devemos acrescentar no map os produtos que nao tiveram producao. Apenas produtos Acabados e Semiacabados
		 */
		if (filtro.getHorarios() != null && filtro.getHorarios().equals("1")) {
			// Incluir os produtos sem producao
			ProdutoRN rn = new ProdutoRN(getDao());
			List<OmProduto> listaAcabadosSemi = rn.getTodosProdutosAcabadosESemiAtivos();
			for (OmProduto omproduto : listaAcabadosSemi) {
				RelatorioProdutoClasseDTO item = mapProdutos.get(omproduto.getCdProduto());
				if(item == null) {
					double custoUnitario = omproduto.getVlCustounit() != null ? omproduto.getVlCustounit().doubleValue() : 1;
					item = new RelatorioProdutoClasseDTO();
					item.setProduto(omproduto.getCdProduto());
					item.setCustoUnitario(custoUnitario);
					item.setProducaoLiquida(0);
					mapProdutos.put(omproduto.getCdProduto(), item);
				}
			}
		}
		
		//ENCONTRANDO O CUSTO TOTAL DE TODOS OS PRODUTOS		
		double custoTotalTodosProdutos = 0;
		for(String cdProduto : mapProdutos.keySet()) {
			RelatorioProdutoClasseDTO item = mapProdutos.get(cdProduto);
			double custoTotal = item.getCustoUnitario() * item.getProducaoLiquida();
			custoTotalTodosProdutos = custoTotalTodosProdutos + custoTotal;
			item.setCustoTotal(custoTotal);
			retorno.getItens().add(item);
		}
		
		Comparator<RelatorioProdutoClasseDTO> comparator = new Comparator<RelatorioProdutoClasseDTO>() {			
			@Override
			public int compare(RelatorioProdutoClasseDTO o1, RelatorioProdutoClasseDTO o2) {
				Double custo1 = o1.getCustoTotal();
				return custo1.compareTo(o2.getCustoTotal()) * -1;
			}
		};
		Collections.sort(retorno.getItens(), comparator);
		
		//SETANDO O indice de classificacao
		double classe = 0d;
		for(RelatorioProdutoClasseDTO item : retorno.getItens()) {
			double indiceClassificacao = 0d;
			
			if (custoTotalTodosProdutos > 0d) {			
				indiceClassificacao = (item.getCustoTotal() / custoTotalTodosProdutos) * 100;
			}  
			
			classe += indiceClassificacao;
			item.setClasse(classe);
			item.setIndiceClassificacao(indiceClassificacao);
		}
		
		getConfiguracaoABC(retorno);
		log.mostrarAvaliacaoCompleta();
		return retorno;
	}
	
	private void getConfiguracaoABC(RelatorioProdutoClasseDTO dto){
		ClassificacaoABCRN abcRN = new ClassificacaoABCRN(getDao());
		ConfiguracaoRN configuracaoRN = new ConfiguracaoRN();
		configuracaoRN.setSession(getDaoSession());
		OmCfg configuracao = configuracaoRN.getConfiguracao();
		OmCfgabc abc = abcRN.getOmCfgabcPorCdAtivoOrderByCd(configuracao.getOmCfgabc().getCdCfgabc());
		for(OmCfgabclim lim : abc.getOmCfgabclims()){
			//Marcos Sardinha: 2017-09-04 >> Defeito #4421
			if(TpClasseABC.CLASSE_A.equals(lim.getClasse())){
				dto.setIndiceClasseA(lim.getLimiteInfClasse().doubleValue());
			} else if(TpClasseABC.CLASSE_B.equals(lim.getClasse())){
				dto.setIndiceClasseBSuperior(lim.getLimiteSupClasse().doubleValue());
			} else if(TpClasseABC.CLASSE_C.equals(lim.getClasse())){
				dto.setIndiceClasseC(lim.getLimiteInfClasse().doubleValue());
			}
		}
		//Marcos Sardinha: 2017-09-04 >> Defeito #4421
		dto.setIndiceClasseBInferior(dto.getIndiceClasseA());
		dto.setIndiceClasseBSuperior(dto.getIndiceClasseC());
	}
	
	private List<DwConsolid> consultaRelatorio(FiltroRelatorioAlertaDTO filtro) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT distinct consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwConsols consol");
		q.append("JOIN consol.dwConsolprs consolpr");
		q.append("JOIN consolpr.omProduto produto");
		q.append("JOIN consolid.dwRt rt");
		q.append("join consolid.omPt ompt");
		q.append("join ompt.omObjs omobj");
		q.append("join omobj.omGtByIdGt omgt");
		q.append("WHERE consolid.dtReferencia BETWEEN :dataInicio AND :dataFim");
		q.append("and consolid.tpId = 1");
		q.append("and consolid.dwTurno.idTurno <> 1");
		
		if(filtro.getHorarios() == null) {
			q.append("AND rt.pcsProducaoliquidaOp IS NOT NULL");
			q.append("AND rt.pcsProducaoliquidaOp != 0");
		}
		if(filtro.getOmgt() != null) {
			q.append("AND omgt.cdGt = :cdGt");
			q.defineParametro("cdGt", filtro.getOmgt().getCdGt());
		}
		q.defineParametro("dataInicio", filtro.getPeriodoInicial());
		q.defineParametro("dataFim", DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));
		return q.list();
	}

}
