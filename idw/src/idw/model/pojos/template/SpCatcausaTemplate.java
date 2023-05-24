package idw.model.pojos.template;

import idw.model.pojos.SpCatcausa;

public class SpCatcausaTemplate extends AbstractTemplate<SpCatcausa> {

	@Override
	protected SpCatcausa atribuir(SpCatcausa from, SpCatcausa to, boolean isCopiarFK) {

		if (to == null) {
			to = new SpCatcausa();
		}
		
		to.setIdCatcausa(from.getIdCatcausa());
		to.setCdCatcausa(from.getCdCatcausa());
		to.setStAtivo(from.getStAtivo());
		to.setRevisao(from.getRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setDtRevisao(from.getDtRevisao());
		
		if(isCopiarFK) {
			if(from.getOmUsrByIdUsrstativo() != null) {
				to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone(false));
			}
			if(from.getOmUsrByIdUsrrevisao() != null) {
				to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone(false));
			}
		}
		
		return to;
	}

}
