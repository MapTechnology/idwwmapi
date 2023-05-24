package idw.model.pojos.template;

import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhasetup;

public class DwFolhasetupTemplate extends AbstractTemplate<DwFolhasetup> {

	@Override
	protected DwFolhasetup atribuir(DwFolhasetup from, DwFolhasetup to, boolean isCopiarFK) {
		if(to == null) {
			to = new DwFolhasetup();
		}

		to.setIdFolhasetup(from.getIdFolhasetup());
		to.setSegSetup(from.getSegSetup());
		
		if (isCopiarFK == true){
			if (from.getDwFolhaByIdFolhasaindo() != null)
				to.setDwFolhaByIdFolhasaindo((DwFolha) from.getDwFolhaByIdFolhasaindo().clone(false));
			
			if (from.getDwFolhaByIdFolhaentrando() != null)
				to.setDwFolhaByIdFolhaentrando((DwFolha) from.getDwFolhaByIdFolhaentrando().clone(false));
		}
		
		return to;
	}

}
