package idw.model.pojos.template;

import idw.model.pojos.QqRoteiroUsr;

public class QqRoteiroUsrTemplate extends AbstractTemplate<QqRoteiroUsr>{

	@Override
	protected QqRoteiroUsr atribuir(QqRoteiroUsr from, QqRoteiroUsr to, boolean isCopiarFK) {
		if (to == null)
			to = new QqRoteiroUsr();
		
		to.setIdRoteirousr(from.getIdRoteirousr());
		
		if (isCopiarFK) {
			if (from.getOmusr() != null)
				to.setOmusr(from.getOmusr().clone(false));
			
			if (from.getOmusrgrp() != null)
				to.setOmusrgrp(from.getOmusrgrp().clone(false));
		}
		
		return to;
	}

}
