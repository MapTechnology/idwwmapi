package idw.model.rn.integracao.semptoshiba;

import java.util.Set;

@SuppressWarnings("serial")
public final class ProdutoNaoFazPartePlanoProducaoException extends Exception {
	
	public ProdutoNaoFazPartePlanoProducaoException(Set<String> cdProdutos){		
		super("Produtos ( " + cdProdutos + " n�o fazem parte do plano de produ��o");
	}
	
	public ProdutoNaoFazPartePlanoProducaoException(String cdProduto){		
		super("Produto " + cdProduto + " n�o faz parte do plano de produ��o");
		
	}
	
	
}
