package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

public class GtParadaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idGt;
	private String cdGt;
	private String dsGt;
	private List<GtParadaDetalheDTO> paradas;

	public Long getIdGt() {
		return idGt;
	}
	public void setIdGt(Long idGt) {
		this.idGt = idGt;
	}
	public String getCdGt() {
		return cdGt;
	}
	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}
	public String getDsGt() {
		return dsGt;
	}
	public void setDsGt(String dsGt) {
		this.dsGt = dsGt;
	}
	public List<GtParadaDetalheDTO> getParadas() {
		return paradas;
	}
	public void setParadas(List<GtParadaDetalheDTO> paradas) {
		this.paradas = paradas;
	}
	
	
	
}