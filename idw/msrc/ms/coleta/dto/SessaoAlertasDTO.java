package ms.coleta.dto;

import java.util.List;

public class SessaoAlertasDTO {
	private List<SessaoAlertaDTO> listaAlertas;
	private long maiorIdConsolallog;
	
	public long getMaiorIdConsolallog() {
		return maiorIdConsolallog;
	}
	public void setMaiorIdConsolallog(long maiorIdConsolallog) {
		this.maiorIdConsolallog = maiorIdConsolallog;
	}
	public List<SessaoAlertaDTO> getListaAlertas() {
		return listaAlertas;
	}
	public void setListaAlertas(List<SessaoAlertaDTO> listaAlertas) {
		this.listaAlertas = listaAlertas;
	}
}
