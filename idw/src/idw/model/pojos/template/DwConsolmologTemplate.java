package idw.model.pojos.template;

import java.util.Date;

import idw.model.pojos.DwConsolmolog;

public class DwConsolmologTemplate extends AbstractTemplate<DwConsolmolog>{
	
	@Override
	protected DwConsolmolog atribuir(DwConsolmolog from, DwConsolmolog to, boolean isCopiarFK) {
		if(to == null){
			to = new DwConsolmolog();
		}

		to.setIdConsolmolog(from.getIdConsolmolog());
		if(from.getOmUsr() != null){
			to.setOmUsr(from.getOmUsr().clone());
		}
		if(from.getOmGt() != null){
			to.setOmGt(from.getOmGt().clone());
		}
		if(from.getOmPt() != null){
			to.setOmPt(from.getOmPt().clone());
		}
		if(from.getDthrIlogin() != null){
			to.setDthrIlogin((Date)from.getDthrIlogin().clone());
		}
		if(from.getMsDthrilogin() != null){
			to.setMsDthrilogin(new Integer(from.getMsDthrilogin()));
		}
		if(from.getDthrFlogin() != null){ 
			to.setDthrFlogin((Date)from.getDthrFlogin().clone());
		}
		if(from.getMsDthrflogin() != null){
			to.setMsDthrflogin(new Integer(from.getMsDthrflogin()));
		}
		
		return to;
	}
}
