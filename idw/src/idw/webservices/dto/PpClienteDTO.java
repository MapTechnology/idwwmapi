package idw.webservices.dto;


import java.io.Serializable;

import idw.model.pojos.PpCliente;

@SuppressWarnings("serial")
public class PpClienteDTO implements Serializable {
	
	private PpCliente ppCliente;

	public PpCliente getPpCliente() {
		return ppCliente;
	}

	public void setPpCliente(PpCliente ppCliente) {
		this.ppCliente = ppCliente;
	}

}
