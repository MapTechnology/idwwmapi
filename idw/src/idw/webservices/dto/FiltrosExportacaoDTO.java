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
public class FiltrosExportacaoDTO implements Serializable {
    private List<FiltroExportacaoDTO> filtros;

	public List<FiltroExportacaoDTO> getFiltros() {
		return filtros;
	}

	public void setFiltros(List<FiltroExportacaoDTO> filtros) {
		this.filtros = filtros;
	}

			    
}