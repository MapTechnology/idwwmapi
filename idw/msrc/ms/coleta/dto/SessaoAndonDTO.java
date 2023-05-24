package ms.coleta.dto;

import java.util.List;

public class SessaoAndonDTO {
	private List<AndonSADTO> listaAndonSA;
	private long idAndon;
	
	public List<AndonSADTO> getListaAndonSA() {
		return listaAndonSA;
	}
	public void setListaAndonSA(List<AndonSADTO> listaAndonSA) {
		this.listaAndonSA = listaAndonSA;
	}
	public long getIdAndon() {
		return idAndon;
	}
	public void setIdAndon(long idAndon) {
		this.idAndon = idAndon;
	}
}
