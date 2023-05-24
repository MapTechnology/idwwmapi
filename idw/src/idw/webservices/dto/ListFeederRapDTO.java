package idw.webservices.dto;

import java.util.List;

@SuppressWarnings("serial")
public class ListFeederRapDTO implements java.io.Serializable{
	private List<FeederRapDTO> listFeederRapDTO;
	private int Retorno;
	public ListFeederRapDTO(){
		
	}
	
	public ListFeederRapDTO(List<FeederRapDTO> lstFeederRapDTO){
		this.listFeederRapDTO = lstFeederRapDTO;
	}
	public void setListFeederRapDTO(List<FeederRapDTO> listFeederRapDTO) {
		this.listFeederRapDTO = listFeederRapDTO;
	}

	public List<FeederRapDTO> getListFeederRapDTO() {
		return listFeederRapDTO;
	}

	public void setRetorno(int retorno) {
		Retorno = retorno;
	}

	public int getRetorno() {
		return Retorno;
	}
	

}
