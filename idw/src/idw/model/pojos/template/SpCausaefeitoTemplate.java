package idw.model.pojos.template;

import java.math.BigDecimal;

import idw.model.pojos.SpCatcausa;
import idw.model.pojos.SpCausa;
import idw.model.pojos.SpCausaefeito;
import idw.model.pojos.SpProblema;

public class SpCausaefeitoTemplate extends AbstractTemplate<SpCausaefeito> {
	
	@Override
	protected SpCausaefeito atribuir(SpCausaefeito from, SpCausaefeito to, boolean isCopiarFK) {
		if (to == null) {
			to = new SpCausaefeito();
		}
		
		to.setIdCausaefeito(from.getIdCausaefeito());
		to.setSpCausa(from.getSpCausa());
		
		if(isCopiarFK) {
			if(from.getSpCausaefeito() != null) {
				to.setSpCausaefeito(from.getSpCausaefeito().clone(false));
			}
			if(from.getSpProblema() != null) {
				to.setSpProblema(from.getSpProblema());
			}
			if(from.getSpCatcausa() != null) {
				to.setSpCatcausa(from.getSpCatcausa().clone(false));
			}		
		}
		
		return to;
	}

}
