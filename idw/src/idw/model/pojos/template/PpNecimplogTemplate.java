package idw.model.pojos.template;

import idw.model.pojos.PpNecimplog;

public class PpNecimplogTemplate extends AbstractTemplate<PpNecimplog> {

	@Override
	protected PpNecimplog atribuir(PpNecimplog from, PpNecimplog to, boolean isCopiarFK) {
		if(to == null) {
			to = new PpNecimplog();
		}
		
		to.setIdNecimplog(from.getIdNecimplog());
		to.setAnoReferencia(from.getAnoReferencia());
		to.setDthrFimportacao(from.getDthrFimportacao());
		to.setDthrIimportacao(from.getDthrIimportacao());
		to.setMesReferencia(from.getMesReferencia());
		if(isCopiarFK) {
			to.setOmUsr(from.getOmUsr().clone(false));
		}
		
		return to;
	}

}
