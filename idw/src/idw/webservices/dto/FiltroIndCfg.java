package idw.webservices.dto;

import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;

public class FiltroIndCfg {
	
	private OmPt omPt;
	private OmGt omGt;
	
	
	public OmPt getOmPt() {
		return omPt;
	}
	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}
	public OmGt getOmGt() {
		return omGt;
	}
	public void setOmGt(OmGt omGt) {
		this.omGt = omGt;
	}

	@Override
	public String toString() {

		String retorno;
		
		retorno = "FiltroIndCfg ["; 
		
		retorno += "omPt=";
		
		if (this.omPt != null) {
			retorno += this.omPt.getCdPt() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "omGt=";

		if (this.omGt != null) {
			retorno += this.omGt.getCdGt() + "]";
		} else {
			retorno += "null]";
		}
		
		return retorno;
		/*return "FiltroIndCfg [omPt=" + omPt + ", omGt=" + omGt + "]";*/
	}

}
