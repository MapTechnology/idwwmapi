package idw.model.rn.numeroserie;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwFolha;
import idw.model.pojos.OmProduto;
import idw.model.pojos.PpCp;
import idw.model.rn.numeroserie.ValidaNumeroSerieRN.TpRetornoValidaNS;

public class PostoValidacaoOutrosPostos extends PostoValidacaoFactory {

	@Override
	public int avaliarRegra(DwFolha dwfolha, PpCp ppcp, String ns, boolean isValidarMontagem, DAOGenerico dao) {
		
		// Alessandre em 20-12-18 comentei a linha abaixo e substitui pela seguinte a fim de testar o RUNCARD da flex
		// devemos encontrar outra situacao para validar
//		int retorno = TpRetornoValidaNS.RETORNO_NS_INVALIDO.getValue();  // invalido
		int retorno = TpRetornoValidaNS.RETORNO_NS_VALIDO.getValue();
		
		// Atualmente a unica regra para os outros postos que não sejam Embalagem e Montagem (posto teste simples
		// posto teste com defeito, posto passagem)
		// é o teste se o CB tem a plataforma ou o produto
		OmProduto omproduto = getCBProdutoOuPlataformaValido(ppcp, ns);
		
		if (omproduto != null)
			retorno = TpRetornoValidaNS.RETORNO_NS_VALIDO.getValue();
		
		// Avaliar se o CB tem limite de tamanho
		if (dwfolha != null && dwfolha.getIsAvaliarlimites() != null && dwfolha.getIsAvaliarlimites()) {
			if (ns.trim().length() >= dwfolha.getLimiteMinCb() && ns.trim().length() <= dwfolha.getLimiteMaxCb())
				retorno = TpRetornoValidaNS.RETORNO_NS_VALIDO.getValue();
			else
				retorno = TpRetornoValidaNS.RETORNO_NS_INVALIDO.getValue();
		}
		return retorno;
	}

}
