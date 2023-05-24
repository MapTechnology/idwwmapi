package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;

@SuppressWarnings("serial")
public class FiltroProducaoPtCpDTO implements Serializable{

	private OmPt omPt;
	private PpCp ppCp;
	
	public OmPt getOmPt() {
		return omPt;
	}
	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}
	public PpCp getPpCp() {
		return ppCp;
	}
	public void setPpCp(PpCp ppCp) {
		this.ppCp = ppCp;
	}
	
	

}