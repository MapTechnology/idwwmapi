package idw.model.pojos.template;

import idw.model.pojos.OmHomopt;

public abstract class OmHomoptTemplate implements Cloneable{

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone(){
		return clone(true);
	}
	public Object clone(boolean isFK) {
		OmHomopt omHomopt = (OmHomopt) this;
	    
		OmHomopt clone = new OmHomopt();
		clone.setIdHomo(omHomopt.getIdHomo());
		clone.setDthrHomopt(omHomopt.getDthrHomopt());
		clone.setTpHomopt(omHomopt.getTpHomopt());
		
		if (isFK == true){
			clone.setOmPt(omHomopt.getOmPt().clone(false));
			clone.setOmUsrByIdUsr(omHomopt.getOmUsrByIdUsr().clone(false));
			clone.setOmUsrByIdUsrhomologado(omHomopt.getOmUsrByIdUsrhomologado().clone(false));		
		}		
		return clone;

    }
	
	public void copy(OmHomopt omFrom, boolean copiarFK){
		OmHomopt omTo = (OmHomopt) this;
		omTo.setIdHomo(omFrom.getIdHomo());
		omTo.setDthrHomopt(omFrom.getDthrHomopt());
		omTo.setTpHomopt(omFrom.getTpHomopt());
		
		if (copiarFK){

			omTo.setOmPt(omFrom.getOmPt());
			omTo.setOmUsrByIdUsr(omFrom.getOmUsrByIdUsr());
			omTo.setOmUsrByIdUsrhomologado(omFrom.getOmUsrByIdUsrhomologado());			
		}

	}
}
