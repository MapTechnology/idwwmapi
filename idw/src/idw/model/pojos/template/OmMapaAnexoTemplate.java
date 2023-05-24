package idw.model.pojos.template;

import idw.model.pojos.OmMapa;
import idw.model.pojos.OmMapaAnexo;


public abstract class OmMapaAnexoTemplate extends AbstractTemplate<OmMapaAnexo>{

	@Override
	protected OmMapaAnexo atribuir(OmMapaAnexo from, OmMapaAnexo to, boolean isCopiarFK) {
		if(to == null) {
			to = new OmMapaAnexo();
		}
		to.setIdMapaAnexo(from.getIdMapaAnexo());
		
		if (isCopiarFK) {
			OmMapa filho = from.getOmMapaByIdMapaFilho().clone(false);
			to.setOmMapaByIdMapaFilho(filho);
		}
		
		return to;
	}
}
