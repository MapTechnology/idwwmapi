package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class DwTRitmosDTO implements Serializable{
	
	private CamposEmUsoOmCfgDTO camposEmUsoOmCfg;
	private List<DwTRitmoDTO> listaRitmosDTO;

	public List<DwTRitmoDTO> getListaRitmosDTO() {
		return listaRitmosDTO;
	}

	public void setListaRitmosDTO(List<DwTRitmoDTO> listaRitmosDTO) {
		this.listaRitmosDTO = listaRitmosDTO;
	}

	public CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg() {
		return camposEmUsoOmCfg;
	}

	public void setCamposEmUsoOmCfg(CamposEmUsoOmCfgDTO camposEmUsoOmCfg) {
		this.camposEmUsoOmCfg = camposEmUsoOmCfg;
	}

}
