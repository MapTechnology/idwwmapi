package idw.model.pojos.template;

import idw.model.pojos.QqRoteiroMov;

public class QqRoteiroMovTemplate extends AbstractTemplate<QqRoteiroMov>{

	@Override
	protected QqRoteiroMov atribuir(QqRoteiroMov from, QqRoteiroMov to, boolean isCopiarFK) {
		if (to == null)
			to = new QqRoteiroMov();
		
		to.setIdRoteiromov(from.getIdRoteiromov());
		
		if (isCopiarFK) {
			if (from.getDwEstentrada() != null)
				to.setDwEstentrada(from.getDwEstentrada().clone(false));
			if (from.getDwEstsaida() != null)
				to.setDwEstsaida(from.getDwEstsaida().clone(false));
			if (from.getDwTpestentrada() != null)
				to.setDwTpestentrada(from.getDwTpestentrada().clone(false));
			if (from.getDwTpestsaida() != null)
				to.setDwTpestsaida(from.getDwTpestsaida().clone(false));
			if (from.getQqFolhainsrap() != null)
				to.setQqFolhainsrap(from.getQqFolhainsrap().clone(false));
		}
		
		return to;
	}

}
