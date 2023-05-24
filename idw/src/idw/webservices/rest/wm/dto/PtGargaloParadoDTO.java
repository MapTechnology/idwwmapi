package idw.webservices.rest.wm.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ptGargaloParado")
public class PtGargaloParadoDTO implements Serializable {

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
	public ParadaDetalheDTO getParada() {
		return parada;
	}
	public void setParada(ParadaDetalheDTO parada) {
		this.parada = parada;
	}
	private static final long serialVersionUID = 1L;

	private PtDTO pt;
	private GtDTO gt;
	private ParadaDetalheDTO parada;
}
