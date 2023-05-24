package idw.model.pojos.template;

import idw.model.pojos.OmCfgscrpimp;


public abstract class OmCfgscrpimpTemplate implements Cloneable{

	@Override
	public Object clone() {
		OmCfgscrpimp OmCfgscrpimp = (OmCfgscrpimp) this;
	    
	    OmCfgscrpimp clone = new OmCfgscrpimp();
		clone.setIdCfgscrpimp(OmCfgscrpimp.getIdCfgscrpimp());
		clone.setCdScrp(OmCfgscrpimp.getCdScrp());
		clone.setDsScrp(OmCfgscrpimp.getDsScrp());		
		clone.setScriptimpressao(OmCfgscrpimp.getScriptimpressao());
				
		clone.setRevisao(OmCfgscrpimp.getRevisao());
		clone.setStativo(OmCfgscrpimp.getStativo());
		
		return clone;

    }

	public void copy(OmCfgscrpimp omFrom, boolean copiarFK){
		OmCfgscrpimp omTo = (OmCfgscrpimp) this;
		omTo.setIdCfgscrpimp(omFrom.getIdCfgscrpimp());
		omTo.setCdScrp(omFrom.getCdScrp());
		omTo.setDsScrp(omFrom.getDsScrp());
		omTo.setScriptimpressao(omFrom.getScriptimpressao());
		omTo.setRevisao(omFrom.getRevisao());
		omTo.setStativo(omFrom.getStativo());
		
	}
}
