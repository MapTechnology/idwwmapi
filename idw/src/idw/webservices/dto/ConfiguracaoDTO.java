/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.OmCfg;


/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class ConfiguracaoDTO implements Serializable {
    private OmCfg configuracao;
    private ResultadoDTO resultado = new ResultadoDTO();
    
	public ResultadoDTO getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}

	public OmCfg getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(OmCfg configuracao) {
		this.configuracao = configuracao;
	}
}