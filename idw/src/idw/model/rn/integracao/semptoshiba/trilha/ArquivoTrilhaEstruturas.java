package idw.model.rn.integracao.semptoshiba.trilha;

import java.util.Map;

import idw.model.pojos.OmProcomest;
import idw.model.pojos.OmProduto;

public class ArquivoTrilhaEstruturas extends ArquivoTrilha {
	
	private final Map<String, OmProduto> mapProdutosFinaisDoPlanoProducaoTodos;
	
	public ArquivoTrilhaEstruturas(Map<String, OmProduto> mapProdutosFinaisDoPlanoProducaoTodos){
		this.mapProdutosFinaisDoPlanoProducaoTodos = mapProdutosFinaisDoPlanoProducaoTodos;
	}
	
	@Override
	protected String getFileName() {
		return "ESTRUTURAS.txt";
	}

	@Override
	protected String getHeader() {
		return ArquivoTrilhaUtils.gerarLinha("ItemPaiCod", "ItemFilhoCod", "Componencia");
	}

	@Override
	protected String getBody() {
		StringBuilder sb = new StringBuilder();

		for (OmProduto omProduto : this.mapProdutosFinaisDoPlanoProducaoTodos.values()){
			sb.append(gerarLinhasParaEstruturaProduto(omProduto));			 
		}
		
		return sb.toString();
		
	}

	
	/**
	 * Gerar linha para o arquivo de estrutura de produto
	 * @param sb
	 * @param omproduto
	 * @param omProcomest
	 */
	private String gerarLinhaEstruturaProduto(OmProcomest omProcomest  ){
		String itemPaiCod =  ArquivoTrilhaUtils.formatarRegistro(omProcomest.getOmProdutoByIdProduto().getCdProduto());
		String itemFilhoCod  = ArquivoTrilhaUtils.formatarRegistro(omProcomest.getOmProdutoByIdProdutomp().getCdProduto());
		String qtUsada = ArquivoTrilhaUtils.formataBigDecimal(omProcomest.getQtUsada());
		
		return ArquivoTrilhaUtils.gerarLinha(itemPaiCod, itemFilhoCod, qtUsada);
	}
	
	/**
	 * Gera recursivamente a estrutura do produto
	 * @param omproduto
	 */
	private String gerarLinhasParaEstruturaProduto(OmProduto omproduto){
		StringBuilder sb = new StringBuilder();
		for (OmProcomest omProcomest : omproduto.getOmProcomestsForIdProduto()) {
			
			sb.append(gerarLinhaEstruturaProduto(omProcomest));
			sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO); 
			
			// Exportar a estrutura para o item
			sb.append(gerarLinhasParaEstruturaProduto(omProcomest.getOmProdutoByIdProdutomp()));
		}
		return sb.toString();
	}	
}
