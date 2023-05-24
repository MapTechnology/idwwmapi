package idw.model.pojos.template;

import idw.model.pojos.OmJobdet;


public abstract class OmJobdetTemplate extends AbstractTemplate<OmJobdet>{

	@Override
	protected OmJobdet atribuir(OmJobdet from, OmJobdet to, boolean isCopiarFK) {
		if(to == null) {
			to = new OmJobdet();
		}
		
		to.setIdJobdet(from.getIdJobdet());
		to.setOrdem(from.getOrdem());
		to.setUrlOrigem(from.getUrlOrigem());
		
		if (isCopiarFK) {
			if (from.getOmJobRecurso() != null)
				to.setOmJobRecurso(from.getOmJobRecurso().clone(false));
		}
		
		return to;
	}
}
