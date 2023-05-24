package idw.webservices.rest.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import injetws.webservices.dto.IwsDadosApontamentoDTO;

@XmlRootElement(name="eventoresourcedto")
public class EventoResourceDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String idup;
	private String dthrEvento;
	private IwsDadosApontamentoDTO dados;
	public String getIdup() {
		return idup;
	}
	public void setIdup(String idup) {
		this.idup = idup;
	}
	public String getDthrEvento() {
		return dthrEvento;
	}
	public void setDthrEvento(String dthrEvento) {
		this.dthrEvento = dthrEvento;
	}
	public IwsDadosApontamentoDTO getDados() {
		return dados;
	}
	public void setDados(IwsDadosApontamentoDTO dados) {
		this.dados = dados;
	}
	
	

}
