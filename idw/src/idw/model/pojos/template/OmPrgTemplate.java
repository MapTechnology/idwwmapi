package idw.model.pojos.template;

import idw.model.pojos.OmPrg;


public abstract class OmPrgTemplate implements Cloneable{

	@Override
	public Object clone() {
		OmPrg omPrg = (OmPrg) this;
	    
	    OmPrg clone = new OmPrg();
	    
	    clone.setCdPrg(omPrg.getCdPrg());
	    clone.setDsPrg(omPrg.getDsPrg());
	    clone.setDtRevisao(omPrg.getDtRevisao());
	    clone.setDtStativo(omPrg.getDtStativo());
	    clone.setIdPrg(omPrg.getIdPrg());
	    clone.setRevisao(omPrg.getRevisao());
	    clone.setStAtivo(omPrg.getStAtivo());

		return clone;

    }
	
	public void copy(OmPrg omFrom, boolean copiarFK){
		OmPrg omTo = (OmPrg) this;

		omTo.setCdPrg(omFrom.getCdPrg());
		omTo.setDsPrg(omFrom.getDsPrg());
		omTo.setDtRevisao(omFrom.getDtRevisao());
		omTo.setDtStativo(omFrom.getDtStativo());
		omTo.setIdPrg(omFrom.getIdPrg());
		omTo.setRevisao(omFrom.getRevisao());
	    omTo.setStAtivo(omFrom.getStAtivo());

		if (copiarFK){
		}

	}
}
