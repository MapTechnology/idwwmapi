package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement
public class AlertasGalpaoDTO implements Serializable {
	
	private List<AlertaGalpaoDTO> alertasGalpao;

	public List<AlertaGalpaoDTO> getAlertassGalpao() {
		return alertasGalpao;
	}

	public void setAlertasGalpao(List<AlertaGalpaoDTO> paradasGalpao) {
		this.alertasGalpao = paradasGalpao;
	}

}
