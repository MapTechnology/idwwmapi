package idw.model.pojos.template;

import idw.model.pojos.SpCausa;

public class SpCausaTemplate extends AbstractTemplate<SpCausa> {
	
	@Override
	protected SpCausa atribuir(SpCausa from, SpCausa to, boolean isCopiarFK) {
		if (to == null) {
			to = new SpCausa();
		}
		
		to.setIdCausa(from.getIdCausa());
		to.setCdCausa(from.getCdCausa());
		to.setStAtivo(from.getStAtivo());
		to.setRevisao(from.getRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setDtRevisao(from.getDtRevisao());
		
		if(isCopiarFK) {
			if(from.getOmUsrByIdUsrrevisao() != null) {
				to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone(false));
			}
			if(from.getOmUsrByIdUsrativo() != null) {
				to.setOmUsrByIdUsrativo(from.getOmUsrByIdUsrativo().clone(false));
			}
		}
		
		return to;
	}

}
