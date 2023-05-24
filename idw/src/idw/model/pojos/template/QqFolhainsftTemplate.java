package idw.model.pojos.template;

import idw.model.pojos.QqFolhainsft;
import idw.util.CloneUtil;

public abstract class QqFolhainsftTemplate extends AbstractTemplate<QqFolhainsft>{

	@Override
	protected QqFolhainsft atribuir(QqFolhainsft from, QqFolhainsft to, boolean isCopiarFK) {
		if (to == null) {
			to = new QqFolhainsft();
		}
		to.setIdFolhainsft(from.getIdFolhainsft());
		to.setMinimo(from.getMinimo());
		to.setMeta(from.getMeta());
		to.setMaximo(from.getMaximo());
		to.setSt(from.getSt());
		
		if (isCopiarFK) {
			to.setDwFtParam(CloneUtil.clone(from.getDwFtParam(), false) );
		}
		return to;
	}

}
