package idw.model.pojos.template;

import idw.model.pojos.OmRegrasTags;

public class OmRegrasTagsTemplate extends AbstractTemplate<OmRegrasTags> {

	@Override
	protected OmRegrasTags atribuir(OmRegrasTags from, OmRegrasTags to, boolean isCopiarFK) {
		
		if(to == null){
			to = new OmRegrasTags();
		}
		
		to.setIdRegrasTags(from.getIdRegrasTags());
		to.setComplemento(from.getComplemento());
		to.setOrdem(from.getOrdem());
		
		if(from.getOmTags() != null) {
			to.setOmTags(from.getOmTags().clone(false));
		}
		
		if(isCopiarFK) {
			
			if(from.getOmRegrasNscb() != null) {
				to.setOmRegrasNscb(from.getOmRegrasNscb().clone(false));
			}
			
//			if(from.getOmTags() != null) {
//				to.setOmTags(from.getOmTags().clone(false));
//			}

		}
		
		return to;
	}

}