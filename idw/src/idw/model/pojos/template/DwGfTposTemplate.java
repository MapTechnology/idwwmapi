package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.pojos.DwGfEmail;
import idw.model.pojos.DwGfTpos;

public abstract class DwGfTposTemplate  extends AbstractTemplate<DwGfTpos>{

	@Override
	protected DwGfTpos atribuir(DwGfTpos from, DwGfTpos to, boolean isCopiarFK) {
		if (to == null)
			to = new DwGfTpos();
		
		to.setIdGftpos(from.getIdGftpos());
		to.setQtCiclos(from.getQtCiclos());
		to.setSegIntervalo(from.getSegIntervalo());
		
		if (isCopiarFK) {
			
			if (from.getMmTpos() != null)
				to.setMmTpos(from.getMmTpos().clone(false));
			
			if (from.getDwGfEmails() != null && from.getDwGfEmails().isEmpty() == false) {
				// Obtem os emails dos usuarios
				to.setDwGfEmails(new HashSet<DwGfEmail>());
				for (DwGfEmail email : from.getDwGfEmails()) {
					to.getDwGfEmails().add(email.clone());
				}
			}
		}
		
		return to;
	}

}
