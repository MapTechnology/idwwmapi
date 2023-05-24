package ms.model.ic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class FirmwaresDTO implements Serializable{
	
	private List<FirmwareDTO> listaFirmwares = new ArrayList<FirmwareDTO>();
 
	public FirmwaresDTO(){
		
	}

	public List<FirmwareDTO> getListaFirmwares() {
		return listaFirmwares;
	}

	public void setListaFirmwares(List<FirmwareDTO> listaFirmwares) {
		this.listaFirmwares = listaFirmwares;
	}

}
