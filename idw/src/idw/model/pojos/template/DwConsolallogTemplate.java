package idw.model.pojos.template;

import java.util.Date;

import idw.model.pojos.DwConsolallog;

public class DwConsolallogTemplate extends AbstractTemplate<DwConsolallog>{
	
	@Override
	protected DwConsolallog atribuir(DwConsolallog from, DwConsolallog to, boolean isCopiarFK) {
		if(to == null){
			to = new DwConsolallog();
		}

		to.setIdConsolallog(from.getIdConsolallog());
		if(from.getDwTAlerta() != null){
			to.setDwTAlerta(from.getDwTAlerta().clone());
		}
		if(from.getOmPt() != null){
			to.setOmPt(from.getOmPt().clone());
		}
		if(from.getDthrIalerta() != null){
			to.setDthrIalerta((Date)from.getDthrIalerta().clone());
		}
		if(from.getMsDthrialerta() != null){
			to.setMsDthrialerta(from.getMsDthrialerta());
		}
		if(from.getDthrFalerta() != null){ 
			to.setDthrFalerta((Date)from.getDthrFalerta().clone());
		}
		if(from.getMsDthrfalerta() != null){
			to.setMsDthrfalerta(new Integer(from.getMsDthrfalerta()));
		}
		
		return to;
	}
}
