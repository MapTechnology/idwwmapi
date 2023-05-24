package idw.webservices.dto;

import idw.model.pojos.OmCfgabc;

public class ClassificacaoABCDTO {

	private OmCfgabc omCfgabc;	
	private ResultadoDTO resultado = new ResultadoDTO();
	
	public OmCfgabc getOmCfgabc() {
		return omCfgabc;
	}
	public void setOmCfgabc(OmCfgabc omCfgabc) {
		this.omCfgabc = omCfgabc;
	}
	public ResultadoDTO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	
	
}
