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
public class GrupoUsuariosDTO implements Serializable {
	
	private CamposEmUsoOmCfgDTO camposEmUsoOmCfg;
    private List<GrupoUsuarioDTO> grupoUsuarios;

	public List<GrupoUsuarioDTO> getGrupoUsuarios() {
		return grupoUsuarios;
	}

	public void setGrupoUsuarios(List<GrupoUsuarioDTO> grupoUsuarios) {
		this.grupoUsuarios = grupoUsuarios;
	}

	public CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg() {
		return camposEmUsoOmCfg;
	}

	public void setCamposEmUsoOmCfg(CamposEmUsoOmCfgDTO camposEmUsoOmCfg) {
		this.camposEmUsoOmCfg = camposEmUsoOmCfg;
	}

    

    
}