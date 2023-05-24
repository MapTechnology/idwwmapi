package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ferramentadto")
public class FerramentaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cdRap;
	private String dsRap;
	private String cdEstoqueAtual;
	private String cdLocalEstoqueAtual;
	private String status = "200"; // codigo de sucesso
	private String title;

	private List<NaoConformidadeDTO> ncs;

	/**
	 * @return the dsRap
	 */
	public String getDsRap() {
		return dsRap;
	}

	/**
	 * @param dsRap the dsRap to set
	 */
	public void setDsRap(String dsRap) {
		this.dsRap = dsRap;
	}

	public String getCdRap() {
		return cdRap;
	}

	public void setCdRap(String cdRap) {
		this.cdRap = cdRap;
	}

	public List<NaoConformidadeDTO> getNcs() {
		return ncs;
	}

	public void setNcs(List<NaoConformidadeDTO> ncs) {
		this.ncs = ncs;
	}

	public String getCdEstoqueAtual() {
		return cdEstoqueAtual;
	}

	public void setCdEstoqueAtual(String cdEstoqueAtual) {
		this.cdEstoqueAtual = cdEstoqueAtual;
	}

	public String getCdLocalEstoqueAtual() {
		return cdLocalEstoqueAtual;
	}

	public void setCdLocalEstoqueAtual(String cdLocalEstoqueAtual) {
		this.cdLocalEstoqueAtual = cdLocalEstoqueAtual;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
