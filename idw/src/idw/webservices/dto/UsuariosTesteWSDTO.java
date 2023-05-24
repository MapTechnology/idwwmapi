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
public class UsuariosTesteWSDTO implements Serializable {

	List<UsuarioTesteWSDTO> usuarios;

	public List<UsuarioTesteWSDTO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioTesteWSDTO> usuarios) {
		this.usuarios = usuarios;
	}

	
}