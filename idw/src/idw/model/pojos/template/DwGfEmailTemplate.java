package idw.model.pojos.template;

import idw.model.pojos.DwGfEmail;

public abstract class DwGfEmailTemplate extends AbstractTemplate<DwGfEmail>{

	@Override
	protected DwGfEmail atribuir(DwGfEmail from, DwGfEmail to, boolean isCopiarFK) {
		if (to == null)
			to = new DwGfEmail();
		
		to.setIdGfemail(from.getIdGfemail());
		
		if (isCopiarFK) {
			if (from.getOmUsr() != null) {
				to.setOmUsr(from.getOmUsr().clone(false));
			}
		}
		
		return to;
	}

}
