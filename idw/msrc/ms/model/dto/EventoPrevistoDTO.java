package ms.model.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EventoPrevistoDTO implements Serializable{
	public static int PORTA_USB = 0;
	public static int PORTA_RS232 = 1;
	public static int PORTA_RS485 = 2;
	public static int PORTA_ETHERNET = 3;
	
	private String reflectionTratadorSinal;
	private Integer tipoPorta;
	private PortaEthernetDTO portaEthernet;
	private PortaUSBDTO portaUSB;
	private PortaSerial232DTO portaSerial232;
	private PortaSerial485DTO portaSerial485;
	public Integer getTipoPorta() {
		return tipoPorta;
	}
	public void setTipoPorta(Integer tipoPorta) {
		this.tipoPorta = tipoPorta;
	}
	public PortaEthernetDTO getPortaEthernet() {
		return portaEthernet;
	}
	public void setPortaEthernet(PortaEthernetDTO portaEthernet) {
		this.portaEthernet = portaEthernet;
	}
	public PortaUSBDTO getPortaUSB() {
		return portaUSB;
	}
	public void setPortaUSB(PortaUSBDTO portaUSB) {
		this.portaUSB = portaUSB;
	}
	public PortaSerial232DTO getPortaSerial232() {
		return portaSerial232;
	}
	public void setPortaSerial232(PortaSerial232DTO portaSerial232) {
		this.portaSerial232 = portaSerial232;
	}
	public PortaSerial485DTO getPortaSerial485() {
		return portaSerial485;
	}
	public void setPortaSerial485(PortaSerial485DTO portaSerial485) {
		this.portaSerial485 = portaSerial485;
	}
	public String getReflectionTratadorSinal() {
		return reflectionTratadorSinal;
	}
	public void setReflectionTratadorSinal(String reflectionTratadorSinal) {
		this.reflectionTratadorSinal = reflectionTratadorSinal;
	}
}
