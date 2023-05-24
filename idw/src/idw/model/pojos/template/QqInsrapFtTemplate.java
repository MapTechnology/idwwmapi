package idw.model.pojos.template;

import idw.model.pojos.QqInsrapFt;

public abstract class QqInsrapFtTemplate  extends AbstractTemplate<QqInsrapFt>{

	@Override
	protected QqInsrapFt atribuir(QqInsrapFt from, QqInsrapFt to, boolean isCopiarFK) {
		if (to == null)
			to = new QqInsrapFt();
		
		to.setIdInsrapft(from.getIdInsrapft());
		to.setVlMedido(from.getVlMedido());
		to.setStMedido(from.getStMedido());
		
		if (isCopiarFK) {
			if (from.getQqFolhainsft() != null)
				to.setQqFolhainsft(from.getQqFolhainsft().clone(false));
			else
				to.setQqFolhainsft(null);
			
			if (from.getQqInsRap() != null)
				to.setQqInsRap(from.getQqInsRap().clone(false));
			else
				to.setQqInsRap(null);
		}
		return to;
	}

}
