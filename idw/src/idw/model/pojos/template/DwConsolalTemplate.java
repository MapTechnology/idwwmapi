package idw.model.pojos.template;

import idw.model.pojos.DwConsolal;

public class DwConsolalTemplate extends AbstractTemplate<DwConsolal>{
	
	@Override
	protected DwConsolal atribuir(DwConsolal from, DwConsolal to, boolean isCopiarFK) {
		if(to == null){
			to = new DwConsolal();
		}

		to.setIdConsolal(from.getIdConsolal());
		
		if(from.getDwTAlerta() != null){
			to.setDwTAlerta(from.getDwTAlerta().clone(false));
		}
		to.setSegAutoTempoalerta(from.getSegAutoTempoalerta());
		to.setSegManuTempoalerta(from.getSegManuTempoalerta());
		
		return to;
	}
}
