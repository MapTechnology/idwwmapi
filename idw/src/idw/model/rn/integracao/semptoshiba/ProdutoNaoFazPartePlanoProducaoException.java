package idw.model.rn.integracao.semptoshiba;

import java.util.Set;

@SuppressWarnings("serial")
public final class ProdutoNaoFazPartePlanoProducaoException extends Exception {
	
	public ProdutoNaoFazPartePlanoProducaoException(Set<String> cdProdutos){		
		super("Produtos ( " + cdProdutos + " não fazem parte do plano de produção");
	}
	
	public ProdutoNaoFazPartePlanoProducaoException(String cdProduto){		
		super("Produto " + cdProduto + " não faz parte do plano de produção");
		
	}
	
	
}
