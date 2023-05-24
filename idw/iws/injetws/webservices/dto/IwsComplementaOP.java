package injetws.webservices.dto;

import java.io.Serializable;

public class IwsComplementaOP   implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3691258134050512970L;

	private boolean isOPValida=false;	
	private boolean requerComplemento=false;
	private boolean requerMolde=false;
	private boolean requerEstrutura=false;
	private boolean requerqtd=false;
	private String cdmolde =null;
	
	public String getCdmolde() {
		return cdmolde;
	}
	public void setCdmolde(String cdmolde) {
		this.cdmolde = cdmolde;
	}
	public String getCdestrutura() {
		return cdestrutura;
	}
	public void setCdestrutura(String cdestrutura) {
		this.cdestrutura = cdestrutura;
	}
	private String cdestrutura=null;
	
	public boolean isRequerMolde() {
		return requerMolde;
	}
	public void setRequerMolde(boolean requerMolde) {
		this.requerMolde = requerMolde;
	}
	public boolean isRequerEstrutura() {
		return requerEstrutura;
	}
	public void setRequerEstrutura(boolean requerEstrutura) {
		this.requerEstrutura = requerEstrutura;
	}
	public boolean isRequerqtd() {
		return requerqtd;
	}
	public void setRequerqtd(boolean requerqtd) {
		this.requerqtd = requerqtd;
	}
	private String txtMensagem=null;
	public boolean isOPValida() {
		return isOPValida;
	}
	public void setOPValida(boolean isOPValida) {
		this.isOPValida = isOPValida;
	}
	
	public boolean isRequerComplemento() {
		return requerComplemento;
	}
	public void setRequerComplemento(boolean requerComplemento) {
		this.requerComplemento = requerComplemento;
	}
	public String getTxtMensagem() {
		return txtMensagem;
	}
	public void setTxtMensagem(String txtMensagem) {
		this.txtMensagem = txtMensagem;
	}
		
}
