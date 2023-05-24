package injetws.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class IwsFitesaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<IwsFitesaDadosDTO> listUpProdLargura = new ArrayList<IwsFitesaDadosDTO>();
	private boolean temDado =false;
	
	public List<IwsFitesaDadosDTO> getListUpProdLargura() {
		return listUpProdLargura;
	}	
	public void addUpProdLargura(IwsFitesaDadosDTO upProdLargura) {
		this.listUpProdLargura.add(upProdLargura);
	}	
	public void setListUpProdLargura(List<IwsFitesaDadosDTO> listUpProdLargura) {
		this.listUpProdLargura = listUpProdLargura;
	}
	public boolean isTemDado() {
		return temDado;
	}
	public void setTemDado(boolean temDado) {
		this.temDado = temDado;
	}
	

}
