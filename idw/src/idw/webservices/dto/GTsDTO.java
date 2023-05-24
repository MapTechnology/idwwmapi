/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lineker
 */
@XmlRootElement
@SuppressWarnings("serial")
public class GTsDTO implements Serializable {
	
	private CamposEmUsoOmCfgDTO camposEmUsoOmCfg;
    private List<GtDTO> gts;

	public List<GtDTO> getGts() {
		return gts;
	}

	public void setGts(List<GtDTO> gts) {
		this.gts = gts;
	}

	public CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg() {
		return camposEmUsoOmCfg;
	}

	public void setCamposEmUsoOmCfg(CamposEmUsoOmCfgDTO camposEmUsoOmCfg) {
		this.camposEmUsoOmCfg = camposEmUsoOmCfg;
	}

    
}