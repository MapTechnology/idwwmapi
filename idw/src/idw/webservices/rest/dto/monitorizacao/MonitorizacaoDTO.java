package idw.webservices.rest.dto.monitorizacao;

import idw.webservices.rest.dto.GtDTO;
import idw.webservices.rest.idw.v2.dto.PtMonitDTO;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="monitorizacao")
public class MonitorizacaoDTO implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	private FiltroMonitorizacaoDTO filtro;
	private FiltroAnaliseGargaloDTO filtroAnaliseGargalo;
	private GtDTO gt;
	private List<GtMonitorizacaoDTO> gts;
	private List<PtMonitorizacaoDTO> pts;

	private List<PtMonitDTO> infoPts;
	
	
	public FiltroMonitorizacaoDTO getFiltro() {
		return filtro;
	}
	public void setFiltro(FiltroMonitorizacaoDTO filtro) {
		this.filtro = filtro;
	}
	public FiltroAnaliseGargaloDTO getFiltroAnaliseGargalo() {
		return filtroAnaliseGargalo;
	}
	public void setFiltroAnaliseGargalo(FiltroAnaliseGargaloDTO filtroAnaliseGargalo) {
		this.filtroAnaliseGargalo = filtroAnaliseGargalo;
	}
	public GtDTO getGt() {
		return gt;
	}
	public void setGt(GtDTO gt) {
		this.gt = gt;
	}
	public List<GtMonitorizacaoDTO> getGts() {
		return gts;
	}
	public void setGts(List<GtMonitorizacaoDTO> gts) {
		this.gts = gts;
	}
	public List<PtMonitorizacaoDTO> getPts() {
		return pts;
	}
	public void setPts(List<PtMonitorizacaoDTO> pts) {
		this.pts = pts;
	}
	public List<PtMonitDTO> getInfoPts() {
		return infoPts;
	}
	public void setInfoPts(List<PtMonitDTO> infoPts) {
		this.infoPts = infoPts;
	}
 
	
	

}
