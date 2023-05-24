package idw.model.pojos.template;

import idw.model.pojos.DwConsolvaritmooco;

public class DwConsolvaritmoocoTemplate extends AbstractTemplate<DwConsolvaritmooco>{

	@Override
	protected DwConsolvaritmooco atribuir(DwConsolvaritmooco from, DwConsolvaritmooco to, boolean isCopiarFK) {
		if (to == null)
			to = new DwConsolvaritmooco();
		
		to.setDthrFvaritmo(from.getDthrFvaritmo());
		to.setDthrIvaritmo(from.getDthrIvaritmo());

		return to;
	}

}
