package idw.model.rn.relatorios.R100;

import java.io.Serializable;
import java.util.List;

public class GtR100DTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cdGt;
	private List<String> cdTurno;
	
	public String getCdGt() {
		return cdGt;
	}
	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}
	public List<String> getCdTurno() {
		return cdTurno;
	}
	public void setCdTurno(List<String> cdTurno) {
		this.cdTurno = cdTurno;
	}
	
	
	
}
