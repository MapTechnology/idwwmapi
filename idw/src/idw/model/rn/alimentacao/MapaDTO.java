package idw.model.rn.alimentacao;

import java.io.Serializable;

public class MapaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cdpt;
	private String cdmapa;
	public String getCdpt() {
		return cdpt;
	}
	public void setCdpt(String cdpt) {
		this.cdpt = cdpt;
	}
	public String getCdmapa() {
		return cdmapa;
	}
	public void setCdmapa(String cdmapa) {
		this.cdmapa = cdmapa;
	}
	
	
}
