package ms.model.ic;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FirmwareDTO implements Serializable{
	
	private String nomeFirmware;
	
	public FirmwareDTO(){
		
	}
	
	public FirmwareDTO(String nomeFirmware){
		this.nomeFirmware = nomeFirmware;
	}

	public String getNomeFirmware() {
		return nomeFirmware;
	}

	public void setNomeFirmware(String nomeFirmware) {
		this.nomeFirmware = nomeFirmware;
	}

}
