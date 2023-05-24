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
public class FolhasDTO implements Serializable {
    private List<FolhaDTO> folhas;
    private String mensagem = "";
    
	public List<FolhaDTO> getFolhas() {
		return folhas;
	}

	public void setFolhas(List<FolhaDTO> folhas) {
		this.folhas = folhas;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}