package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PosicoesCODTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6044141352191756587L;
	private List<PosicaoCODTO> posicoes;
	
	private boolean isPosicoesEspelhadas = false;
	public List<PosicaoCODTO> getPosicoes() {
		return posicoes;
	}

	public void setPosicoes(List<PosicaoCODTO> posicoes) {
		this.posicoes = posicoes;
	}

	public boolean isPosicoesEspelhadas() {
		return isPosicoesEspelhadas;
	}

	public void setPosicoesEspelhadas(boolean isPosicoesEspelhadas) {
		this.isPosicoesEspelhadas = isPosicoesEspelhadas;
	}
}
