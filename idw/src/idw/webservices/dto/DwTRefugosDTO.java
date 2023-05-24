package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

//Esta classe esta com o nome DwTRefugosDTO, pois estava dando conflito de nomes ao atualizar webservice

@SuppressWarnings("serial")
public class DwTRefugosDTO implements Serializable {

	private CamposEmUsoOmCfgDTO camposEmUsoOmCfg;
	private List<DwTRefugoDTO> dwTRefugos;

	public List<DwTRefugoDTO> getDwTRefugos() {
		return dwTRefugos;
	}

	public void setDwTRefugos(List<DwTRefugoDTO> dwTRefugos) {
		this.dwTRefugos = dwTRefugos;
	}

	public CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg() {
		return camposEmUsoOmCfg;
	}

	public void setCamposEmUsoOmCfg(CamposEmUsoOmCfgDTO camposEmUsoOmCfg) {
		this.camposEmUsoOmCfg = camposEmUsoOmCfg;
	}
	
	
}
