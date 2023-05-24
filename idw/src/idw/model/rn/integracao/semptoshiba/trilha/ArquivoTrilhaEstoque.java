package idw.model.rn.integracao.semptoshiba.trilha;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.model.rn.estoque.EstoqueRN;

public class ArquivoTrilhaEstoque extends ArquivoTrilha {
	
	private final OmCfg omCfg;
	private final Map<String, OmProduto> mapTodosProdutos;
	private final Map<String, Set<DwEstpro>> mapEstoquesProdutos;
	
	public ArquivoTrilhaEstoque(OmCfg omCfg, Map<String, OmProduto> mapTodosProdutos, Map<String, Set<DwEstpro>> mapEstoquesProdutos){
		this.omCfg = omCfg;
		this.mapTodosProdutos = mapTodosProdutos;
		this.mapEstoquesProdutos = mapEstoquesProdutos;
	}
	
	@Override
	protected String getFileName() {
		return "ESTOQUES.txt";
	}

	@Override
	protected String getHeader() {
		return ArquivoTrilhaUtils.gerarLinha("ItemCod", "Quantidade");
	}

	@Override
	protected String getBody() {
		StringBuilder sb = new StringBuilder();
		
		DwEst dwEstLiberacao = omCfg.getDwEstByIdEstliberado();

		Set<String> produtosJaTratados = new HashSet<String>();
				
		for (OmProduto omproduto : this.mapTodosProdutos.values()) {

			if(OmProdutoTemplate.TpProduto.PRODUTO_FINAL.equals(omproduto.getTpProduto()) == false){
				
				if (produtosJaTratados.add(omproduto.getCdProduto())){
					
					BigDecimal qtTotal = BigDecimal.ZERO;
					
					if(dwEstLiberacao != null){
						DwEstpro dwEstpro = EstoqueRN.getDwEstproFromMapProdutoEstoquesWithProdutoAndDwEst(mapEstoquesProdutos, omproduto.getCdProduto(), dwEstLiberacao);
						if(dwEstpro != null && dwEstpro.getQtTotal() != null){
							qtTotal = dwEstpro.getQtTotal();
						}
					}

					sb.append(gerarLinhaEstoque(omproduto.getCdProduto(), qtTotal));
					sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);
						
				}				
			}
		}
		
		return sb.toString();
	}

	
	private String gerarLinhaEstoque(String produto, BigDecimal quantidade){
		return ArquivoTrilhaUtils.gerarLinha(produto, ArquivoTrilhaUtils.formataBigDecimal(quantidade));
	}
	
	
}
