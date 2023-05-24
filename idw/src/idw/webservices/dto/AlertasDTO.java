package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

public class AlertasDTO implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CamposEmUsoOmCfgDTO camposEmUsoOmCfg;
	private List<AlertaDTO> listaAlertasDTO;

	public List<AlertaDTO> getListaAlertasDTO() {
		return listaAlertasDTO;
	}

	public void setListaAlertasDTO(List<AlertaDTO> listaAlertasDTO) {
		this.listaAlertasDTO = listaAlertasDTO;
	}

	public CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg() {
		return camposEmUsoOmCfg;
	}

	public void setCamposEmUsoOmCfg(CamposEmUsoOmCfgDTO camposEmUsoOmCfg) {
		this.camposEmUsoOmCfg = camposEmUsoOmCfg;
	}
}
