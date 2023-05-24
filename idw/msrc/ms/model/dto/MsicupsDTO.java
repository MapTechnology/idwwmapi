/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ms.model.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class MsicupsDTO implements Serializable {
    private List<MsicupDTO> msicups;

	public List<MsicupDTO> getMsicups() {
		return msicups;
	}

	public void setMsicups(List<MsicupDTO> msicups) {
		this.msicups = msicups;
	}

	    
}