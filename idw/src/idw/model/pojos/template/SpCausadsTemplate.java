package idw.model.pojos.template;

import idw.model.pojos.SpCausads;

public class SpCausadsTemplate extends AbstractTemplate<SpCausads> {
	
	@Override
	protected SpCausads atribuir(SpCausads from, SpCausads to, boolean isCopiarFK) {
		if (to == null) {
			to = new SpCausads();
		}
		
		to.setIdCausads(from.getIdCausads());
		to.setDsCausa(from.getDsCausa());
		
		if(isCopiarFK) {
			if(from.getSpLingua() != null) {
				to.setSpLingua(from.getSpLingua().clone(false));
			}
			if(from.getSpCausa() != null) {
				to.setSpCausa(from.getSpCausa().clone(false));
			}
		}
		
		return to;
	}

}
