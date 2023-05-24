package idw.model.pojos.template;

import idw.model.pojos.DwConsoldef;
import idw.model.pojos.DwTDefeito;

public class DwConsoldefTemplate extends AbstractTemplate<DwConsoldef>{

	@Override
	protected DwConsoldef atribuir(DwConsoldef from, DwConsoldef to,
			boolean isCopiarFK) {
		
		if (to == null) {
			to = new DwConsoldef();
		}
		
		to.setQtDefeitos(from.getQtDefeitos());
		
		if (isCopiarFK) {
			if (from.getDwTArea() != null) {
				to.setDwTArea(from.getDwTArea().clone(false));
			}

			if (from.getDwTDefeito() != null) {
				to.setDwTDefeito((DwTDefeito) from.getDwTDefeito().clone());
			}
			
			if (from.getDwConsol() != null) {
				to.setDwConsol(from.getDwConsol().clone(false));
			}
		}
		
		return to;
	}

}
