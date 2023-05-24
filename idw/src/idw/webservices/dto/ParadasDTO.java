package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ParadasDTO implements Serializable {

	private CamposEmUsoOmCfgDTO camposEmUsoOmCfg;
	private List<DWParadaDTO> dwTParadas;

	public CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg() {
		return camposEmUsoOmCfg;
	}

	public void setCamposEmUsoOmCfg(CamposEmUsoOmCfgDTO camposEmUsoOmCfg) {
		this.camposEmUsoOmCfg = camposEmUsoOmCfg;
	}

	public List<DWParadaDTO> getDwTParadas() {
		return dwTParadas;
	}

	public void setDwTParadas(List<DWParadaDTO> dwTParadas) {
		this.dwTParadas = dwTParadas;
	}

}
