package idw.model.pojos.template;

import idw.model.pojos.OmHomogt;

public abstract class OmHomogtTemplate implements Cloneable{

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() {
		OmHomogt omHomogt = (OmHomogt) this;
	    
		OmHomogt clone = new OmHomogt();
		clone.setIdHomogt(omHomogt.getIdHomogt());
		clone.setDtHomogt(omHomogt.getDtHomogt());
		clone.setTpHomogt(omHomogt.getTpHomogt());
		
		clone.setOmGt(omHomogt.getOmGt().clone());		
		clone.setOmUsrByIdUsr(omHomogt.getOmUsrByIdUsr().clone());
		clone.setOmUsrByIdUsrhomologado(omHomogt.getOmUsrByIdUsrhomologado().clone());		
		
		return clone;

    }
	
	public void copy(OmHomogt omFrom, boolean copiarFK){
		OmHomogt omTo = (OmHomogt) this;
		omTo.setIdHomogt(omFrom.getIdHomogt());
		omTo.setDtHomogt(omFrom.getDtHomogt());
		omTo.setTpHomogt(omFrom.getTpHomogt());
		
		if (copiarFK){

			omTo.setOmGt(omFrom.getOmGt());
			omTo.setOmUsrByIdUsr(omFrom.getOmUsrByIdUsr());
			omTo.setOmUsrByIdUsrhomologado(omFrom.getOmUsrByIdUsrhomologado());			
		}

	}
}
