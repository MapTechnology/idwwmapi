package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MonitorizacoesCheckFeederDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1173191641917652215L;
	private List<MonitorizacaoCheckFeederDTO> monitorizacoesCheckFeederList;

	
	public List<MonitorizacaoCheckFeederDTO> getMonitorizacoesCheckFeederList() {
		return monitorizacoesCheckFeederList;
	}

	public void setMonitorizacoesCheckFeederList(List<MonitorizacaoCheckFeederDTO> monitorizacoesCheckFeederList) {
		this.monitorizacoesCheckFeederList = monitorizacoesCheckFeederList;
	}
	
	
	
	

}
