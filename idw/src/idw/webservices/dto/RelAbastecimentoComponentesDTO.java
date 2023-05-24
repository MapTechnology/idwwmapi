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
public class RelAbastecimentoComponentesDTO implements Serializable {
    private List<RelAbastecimentoComponentesAlimreaDTO> alimRea;
    private String dataOperacao;
    private String maquina;
    private String mapa;
    private String dataProcessamento;
    private String versao;

	public List<RelAbastecimentoComponentesAlimreaDTO> getAlimRea() {
		return alimRea;
	}

	public void setAlimRea(List<RelAbastecimentoComponentesAlimreaDTO> alimRea) {
		this.alimRea = alimRea;
	}

	public String getDataOperacao() {
		return dataOperacao;
	}

	public void setDataOperacao(String dataOperacao) {
		this.dataOperacao = dataOperacao;
	}

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public String getMapa() {
		return mapa;
	}

	public void setMapa(String mapa) {
		this.mapa = mapa;
	}

	public String getDataProcessamento() {
		return dataProcessamento;
	}

	public void setDataProcessamento(String dataProcessamento) {
		this.dataProcessamento = dataProcessamento;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}
	      
}