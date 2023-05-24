package injetws.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class IwsListaAlertaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5822301042050558545L;
	private List<IwsAlertaDTO> alertas = new ArrayList<IwsAlertaDTO>();

	public List<IwsAlertaDTO> getAlertas() {
		return alertas;
	}

	public void setAlertas(List<IwsAlertaDTO> alertas) {
		this.alertas = alertas;
	}
}
