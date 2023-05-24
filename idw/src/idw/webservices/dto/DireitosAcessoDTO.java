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
public class DireitosAcessoDTO implements Serializable {
    private List<DireitoAcessoDTO> direitosAcesso;

	public List<DireitoAcessoDTO> getDireitosAcesso() {
		return direitosAcesso;
	}

	public void setDireitosAcesso(List<DireitoAcessoDTO> direitosAcesso) {
		this.direitosAcesso = direitosAcesso;
	}

    

    
}