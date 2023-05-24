package idw.model.pojos.template;

import java.util.HashSet;
import java.util.Set;

import idw.model.pojos.DwOperacao;
import idw.model.pojos.DwTOperacao;


public class DwTOperacaoTemplate extends AbstractTemplate<DwTOperacao> {

	@Override
	protected DwTOperacao atribuir(DwTOperacao from, DwTOperacao to,
			boolean isCopiarFK) {

		if (to == null) {
			to = new DwTOperacao();
		}
		
		to.setIdToperacao(from.getIdToperacao());
		to.setDsToperacao(from.getDsToperacao());
		
		if (isCopiarFK) {
			if(from.getDwOperacaos() != null){
				try{
					Set<DwOperacao> operacoes = new HashSet<DwOperacao>();
					for (DwOperacao operacao : from.getDwOperacaos()) {
						operacoes.add((DwOperacao) operacao.clone());
					}
					to.setDwOperacaos(operacoes);
				} catch(Exception e){
					to.setDwOperacaos(null);
				}
			}
		}
		
		return to;
	}

}
