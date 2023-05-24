/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class ParametrosDTO implements Serializable {
	
	private CamposEmUsoOmCfgDTO camposEmUsoOmCfg;
    private List<ParametroDTO> parametros;

	public List<ParametroDTO> getParametros() {
		return parametros;
	}

	public void setParametros(List<ParametroDTO> parametros) {
		this.parametros = parametros;
	}

	public CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg() {
		return camposEmUsoOmCfg;
	}

	public void setCamposEmUsoOmCfg(CamposEmUsoOmCfgDTO camposEmUsoOmCfg) {
		this.camposEmUsoOmCfg = camposEmUsoOmCfg;
	}
		    
}