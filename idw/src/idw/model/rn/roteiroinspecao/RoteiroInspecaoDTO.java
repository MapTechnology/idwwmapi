package idw.model.rn.roteiroinspecao;

import java.io.Serializable;

import idw.model.pojos.QqRoteiro;

public class RoteiroInspecaoDTO extends RetornoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private QqRoteiro roteiro;

	public QqRoteiro getRoteiro() {
		return roteiro;
	}

	public void setRoteiro(QqRoteiro roteiro) {
		this.roteiro = roteiro;
	}
}
