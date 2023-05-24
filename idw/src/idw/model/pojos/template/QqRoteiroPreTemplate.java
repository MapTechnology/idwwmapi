package idw.model.pojos.template;

import idw.model.pojos.QqRoteiroPre;

public abstract class QqRoteiroPreTemplate  extends AbstractTemplate<QqRoteiroPre>{

	@Override
	protected QqRoteiroPre atribuir(QqRoteiroPre from, QqRoteiroPre to, boolean isCopiarFK) {
		if (to == null)
			to = new QqRoteiroPre();
		
		to.setIdRoteiropre(from.getIdRoteiropre());
		
		if (isCopiarFK) {
			if (from.getQqRoteiroMovpre() != null)
				to.setQqRoteiroMovpre(from.getQqRoteiroMovpre().clone(false));
		}
		
		return to;
	}

}
