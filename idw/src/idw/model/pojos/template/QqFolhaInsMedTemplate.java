package idw.model.pojos.template;

import idw.model.pojos.QqFolhaInsMed;

public abstract class QqFolhaInsMedTemplate extends AbstractTemplate<QqFolhaInsMed>{

	@Override
	protected QqFolhaInsMed atribuir(QqFolhaInsMed from, QqFolhaInsMed to, boolean isCopiarFK) {
		if (to == null) {
			to = new QqFolhaInsMed();
		}
		to.setIdFolhainsmed(from.getIdFolhainsmed());
		to.setDsFolhainsmed(from.getDsFolhainsmed());
		to.setNomearquivo(from.getNomearquivo());
		to.setMedia(from.getMedia());
		to.setOrdem(from.getOrdem());
		
		return to;
	}

}
