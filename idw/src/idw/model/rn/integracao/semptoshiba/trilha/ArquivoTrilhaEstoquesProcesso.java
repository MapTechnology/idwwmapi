package idw.model.rn.integracao.semptoshiba.trilha;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.model.rn.estoque.EstoqueRN;


public class ArquivoTrilhaEstoquesProcesso extends ArquivoTrilha {	

	private final OmCfg omCfg;
	private final Map<String, Integer> mapProdutosUltimoEstagioIAC;
	private final Map<String, OmProduto> mapTodosProdutos;
	private final DAOGenerico daoGenerico;
	private final Map<String, Set<DwEstpro>> mapEstoquesProdutos;
	
	public ArquivoTrilhaEstoquesProcesso(DAOGenerico daoGenerico, OmCfg omCfg, Map<String, Integer> mapProdutosUltimoEstagioIAC, 
			Map<String, OmProduto> mapTodosProdutos, Map<String, Set<DwEstpro>> mapEstoquesProdutos) {
		this.omCfg = omCfg;
		this.mapProdutosUltimoEstagioIAC = mapProdutosUltimoEstagioIAC;
		this.mapTodosProdutos = mapTodosProdutos;
		this.daoGenerico = daoGenerico;
		this.mapEstoquesProdutos = mapEstoquesProdutos;
	}
	
	@Override
	protected String getFileName() {
		return "ESTOQUES_PROCESSO.txt";
	}

	@Override
	protected String getHeader() {
		return ArquivoTrilhaUtils.gerarLinha("ItemCod","Estagio","Quantidade");
	}
	
	
	@Override
	protected String getBody() {

		StringBuilder sb = new StringBuilder();
		DwEst dwEstProducao = omCfg.getDwEstByIdEstproducao();
		
		try{
			
			for(String cdProduto: this.mapProdutosUltimoEstagioIAC.keySet()){
				
				OmProduto omProduto = mapTodosProdutos.get(cdProduto);
				
				if(omProduto != null && omProduto.getTpProduto() != null){
					
					if(OmProdutoTemplate.TpProduto.SEMI_ACABADO.equals(omProduto.getTpProduto())){
						
						if(isProdutoTemTesteEletricoSempToshiba(cdProduto)){
							
							Integer estagio = mapProdutosUltimoEstagioIAC.get(cdProduto);
							
							if(estagio == null){
								estagio = new Integer(1);
							}
												
							BigDecimal quantidade = BigDecimal.ZERO;
							if(dwEstProducao != null){
								quantidade = EstoqueRN.getTotalFromMapProdutoEstoquesWithProdutoAndDwEst(mapEstoquesProdutos, cdProduto, dwEstProducao);
							}
							
							sb.append(gerarLinhaEstoqueEmProcesso(cdProduto, estagio, quantidade));							
							sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);
							
						}						
						
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

		
		return sb.toString();
		
	}
	
	
	private String gerarLinhaEstoqueEmProcesso(String cdProduto, Integer estagio, BigDecimal quantidade ){
		return ArquivoTrilhaUtils.gerarLinha(cdProduto, estagio.toString(), ArquivoTrilhaUtils.formataBigDecimal(quantidade));
	}

	
	private boolean isProdutoTemTesteEletricoSempToshiba(String cdProduto){
		
		MapQuery q = new MapQuery(daoGenerico.getSession());
		q.append("select dwRotapasso from DwRotapasso dwRotapasso");
		q.append("inner join dwRotapasso.dwRota dwRota");
		q.append("inner join dwRotapasso.dwFolha dwFolha");
		q.append("inner join dwFolha.dwFolhaiacs dwFolhaiac");
		q.append("inner join dwFolhaiac.omProduto omProduto");
		q.append("where omProduto.cdProduto = :cdProduto");
		q.append("and dwRota.stAtivo = :stAtivo");
		q.append("and (dwFolha.cdFolha like :ict OR dwFolha.cdFolha like :tri)");
		
		q.defineParametro("cdProduto", cdProduto);
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("ict","%-ICT");
		q.defineParametro("tri","%-TRI");
		
		q.setMaxResults(1);
		
		DwRotapasso dwRotapasso = (DwRotapasso) q.uniqueResult();
		
		return dwRotapasso != null;
		
	}	
	
}
