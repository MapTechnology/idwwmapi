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
public class EtapaSubsDTO implements Serializable {
    private List<EtapaSubDTO> dwFtSubs;

	public List<EtapaSubDTO> getDwFtSubs() {
		return dwFtSubs;
	}

	public void setDwFtSubs(List<EtapaSubDTO> dwFtSubs) {
		this.dwFtSubs = dwFtSubs;
	}

	
    
}