package ms.model.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PortaEthernetDTO implements Serializable{
	private String ip;
	private Integer porta;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getPorta() {
		return porta;
	}
	public void setPorta(Integer porta) {
		this.porta = porta;
	}
}
