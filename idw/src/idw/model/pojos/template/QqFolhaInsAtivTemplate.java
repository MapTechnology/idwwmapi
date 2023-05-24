package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.pojos.QqFolhaInsAtiv;
import idw.model.pojos.QqFolhaInsMed;
import idw.model.pojos.QqFolhainsft;

public abstract class QqFolhaInsAtivTemplate extends AbstractTemplate<QqFolhaInsAtiv>{

	@Override
	protected QqFolhaInsAtiv atribuir(QqFolhaInsAtiv from, QqFolhaInsAtiv to, boolean isCopiarFK) {
		if (to == null) {
			to = new QqFolhaInsAtiv();
		}
		to.setIdFolhainsativ(from.getIdFolhainsativ());
		to.setDsFolhainsativ(from.getDsFolhainsativ());
		to.setOrdem(from.getOrdem());
		to.setSegDuracaoesperada(from.getSegDuracaoesperada());
		
		if (isCopiarFK) {
			if (from.getQqFolhaInsMeds() != null && from.getQqFolhaInsMeds().isEmpty() == false) {
				to.setQqFolhaInsMeds(new HashSet<QqFolhaInsMed>());
				for (QqFolhaInsMed med : from.getQqFolhaInsMeds()) {
					to.getQqFolhaInsMeds().add(med.clone());
				}
			}
			if (from.getQqFolhainsfts() != null && from.getQqFolhainsfts().isEmpty() == false) {
				to.setQqFolhainsfts(new HashSet<QqFolhainsft>());
				for (QqFolhainsft ft : from.getQqFolhainsfts()) {
					to.getQqFolhainsfts().add(ft.clone());
				}
			}
		}
		
		return to;
	}

}
