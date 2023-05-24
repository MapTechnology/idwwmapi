package idw.webservices.rest.wm.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ptGargaloDinamico")
public class PtGargaloDinamicoDTO implements Serializable {

	private PtDTO pt;
	private GtDTO gt;
	private BigDecimal bdTempoCicloPadrao;
	private BigDecimal bdTempoCicloRealMedio;

	
	public BigDecimal getTempoCicloPadrao() {
		return bdTempoCicloPadrao;
	}
	public void setTempoCicloPadrao(BigDecimal bdTempoCicloPadrao) {
		this.bdTempoCicloPadrao = bdTempoCicloPadrao;
	}

	public BigDecimal getTempoCicloRealMedio() {
		return bdTempoCicloRealMedio;
	}
	public void setTempoCicloRealMedio(BigDecimal bdTempoCicloRealMedio) {
		this.bdTempoCicloRealMedio = bdTempoCicloRealMedio;
	}
	public PtDTO getPt() {
		return pt;
	}
	public void setPt(PtDTO pt) {
		this.pt = pt;
	}
	public GtDTO getGt() {
		return gt;
	}
	public void setGt(GtDTO gt) {
		this.gt = gt;
	}
	private static final long serialVersionUID = 1L;

}
