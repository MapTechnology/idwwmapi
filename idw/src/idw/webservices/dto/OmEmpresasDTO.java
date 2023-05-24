package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class OmEmpresasDTO implements Serializable {
	
	private CamposEmUsoOmCfgDTO camposEmUsoOmCfg;
	private List<OmEmpresaDTO> listaEmpresa;

	public List<OmEmpresaDTO> getListaEmpresa() {
		return listaEmpresa;
	}

	public void setListaEmpresa(List<OmEmpresaDTO> listaEmpresa) {
		this.listaEmpresa = listaEmpresa;
	}

	public CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg() {
		return camposEmUsoOmCfg;
	}

	public void setCamposEmUsoOmCfg(CamposEmUsoOmCfgDTO camposEmUsoOmCfg) {
		this.camposEmUsoOmCfg = camposEmUsoOmCfg;
	}

}
