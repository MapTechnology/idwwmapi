package idw.webservices.rest.dto.monitorizacao;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="filtroDetalheRefugo")
public class FiltroDetalheRefugoDTO extends FiltroDetalhePostoDTO {

	private static final long serialVersionUID = 1L;
	
	private String cdRefugo;
	private String quantidadeRefugo;
	private String totalRefugo;
	private String totalRefugoPeriodo;
	
	public String getCdRefugo() {
		return cdRefugo;
	}
	public void setCdRefugo(String cdRefugo) {
		this.cdRefugo = cdRefugo;
	}
	public String getQuantidadeRefugo() {
		return quantidadeRefugo;
	}
	public void setQuantidadeRefugo(String quantidadeRefugo) {
		this.quantidadeRefugo = quantidadeRefugo;
	}
	public String getTotalRefugo() {
		return totalRefugo;
	}
	public void setTotalRefugo(String totalRefugo) {
		this.totalRefugo = totalRefugo;
	}
	public String getTotalRefugoPeriodo() {
		return totalRefugoPeriodo;
	}
	public void setTotalRefugoPeriodo(String totalRefugoPeriodo) {
		this.totalRefugoPeriodo = totalRefugoPeriodo;
	}
	

	
	
	
}
