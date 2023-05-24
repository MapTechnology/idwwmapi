package idw.model.pojos.template;

import idw.model.pojos.SpLingua;

public class SpLinguaTemplate extends AbstractTemplate<SpLingua> {

	@Override
	protected SpLingua atribuir(SpLingua from, SpLingua to, boolean isCopiarFK) {
		if (to == null) {
			to = new SpLingua();
		}
		
		to.setIdLingua(from.getIdLingua());
		to.setDsLingua(from.getDsLingua());
		
		return to;
	}

}
