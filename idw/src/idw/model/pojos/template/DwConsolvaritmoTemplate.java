package idw.model.pojos.template;

import idw.model.pojos.DwConsolvaritmo;
import idw.model.pojos.DwConsolvaritmooco;

public class DwConsolvaritmoTemplate extends AbstractTemplate<DwConsolvaritmo>{

	@Override
	protected DwConsolvaritmo atribuir(DwConsolvaritmo from, DwConsolvaritmo to, boolean isCopiarFK) {
		if (to == null)
			to = new DwConsolvaritmo();
		
		to.setIdConsolvaritmo(from.getIdConsolvaritmo());
		to.setSegAutoTemporitmo(from.getSegAutoTemporitmo());
		to.setSegManuTemporitmo(from.getSegManuTemporitmo());
		
		if (isCopiarFK) {
			if (from.getDwConsol() != null)
				to.setDwConsol(from.getDwConsol().clone(false));
			
			if (from.getDwTRitmo() != null)
				to.setDwTRitmo(from.getDwTRitmo().clone(false));
			
			if (from.getDwConsolvaritmoocos() != null && from.getDwConsolvaritmoocos().isEmpty() == false) {
				for (DwConsolvaritmooco oco : from.getDwConsolvaritmoocos()) {
					DwConsolvaritmooco ocoClone = oco.clone(false);
					to.getDwConsolvaritmoocos().add(ocoClone);
				}
			}
		}
		
		return to;
	}

}
