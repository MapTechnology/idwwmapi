package idw.model.rn.alimentacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="alimentacaodto")
public class AlimentacaoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cdUsr; // usuario que executou
	private String cdPt;
	private String cdMapa;
	private Boolean isSucesso;
	
	private List<RealimentacaoDTO> alimentacoes = new ArrayList<>();

	public List<RealimentacaoDTO> getAlimentacoes() {
		return alimentacoes;
	}

	public void setAlimentacoes(List<RealimentacaoDTO> alimentacoes) {
		this.alimentacoes = alimentacoes;
	}

	public String getCdUsr() {
		return cdUsr;
	}

	public void setCdUsr(String cdUsr) {
		this.cdUsr = cdUsr;
	}

	public String getCdPt() {
		return cdPt;
	}

	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}

	public String getCdMapa() {
		return cdMapa;
	}

	public void setCdMapa(String cdMapa) {
		this.cdMapa = cdMapa;
	}

	public Boolean getIsSucesso() {
		return isSucesso;
	}

	public void setIsSucesso(Boolean isSucesso) {
		this.isSucesso = isSucesso;
	}
	
}
