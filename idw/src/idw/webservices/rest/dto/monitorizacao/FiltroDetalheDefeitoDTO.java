package idw.webservices.rest.dto.monitorizacao;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="filtroDetalheDefeito")
public class FiltroDetalheDefeitoDTO extends FiltroDetalhePostoDTO {

	private static final long serialVersionUID = 1L;
	
	private String cdDefeito;
	private String cdArea;
	
	public String getCdDefeito() {
		return cdDefeito;
	}
	public void setCdDefeito(String cdDefeito) {
		this.cdDefeito = cdDefeito;
	}
	public String getCdArea() {
		return cdArea;
	}
	public void setCdArea(String cdArea) {
		this.cdArea = cdArea;
	}
	
	
}
