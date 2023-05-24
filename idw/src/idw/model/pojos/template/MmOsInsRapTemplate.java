package idw.model.pojos.template;

import idw.model.pojos.MmOsInsRap;

public abstract class MmOsInsRapTemplate  extends AbstractTemplate<MmOsInsRap> {

	
	@Override
	protected MmOsInsRap atribuir(MmOsInsRap from, MmOsInsRap to, boolean isCopiarFK) {
		if (to == null)
			to = new MmOsInsRap();
		
		to.setIdOsinsrap(from.getIdOsinsrap());
		
		if (isCopiarFK) {
			if (from.getDwEstmovRap() != null)
				to.setDwEstmovRap(from.getDwEstmovRap().clone(false));
			else
				to.setDwEstmovRap(null);
			
			if (from.getDwRap() != null)
				to.setDwRap(from.getDwRap().clone(false));
			else
				to.setDwRap(null);
			
			if (from.getQqFolhaInsRap() != null)
				to.setQqFolhaInsRap(from.getQqFolhaInsRap().clone(false));
			else
				to.setQqFolhaInsRap(null);
		}
		
		return to;
	}

}
