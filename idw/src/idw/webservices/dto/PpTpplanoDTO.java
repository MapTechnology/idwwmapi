package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.PpTpplano;

@SuppressWarnings("serial")
public class PpTpplanoDTO extends PpTpplano implements Serializable{
	
	private ResultadoDTO resultado;
	
	public PpTpplanoDTO() {
	}
	public PpTpplanoDTO(PpTpplano pptpplano) {
		this.setIdTpplano(pptpplano.getIdTpplano());
		this.setDsTpplano(pptpplano.getDsTpplano());
		this.setTpAlgoritmo(pptpplano.getTpAlgoritmo());
		this.setIndOee(pptpplano.getIndOee());
		this.setIsConsiderarcal(pptpplano.getIsConsiderarcal());
		this.setIsConsiderarcm(pptpplano.getIsConsiderarcm());
		this.setIsConsiderarest(pptpplano.getIsConsiderarest());
		this.setIsConsiderarindisp(pptpplano.getIsConsiderarindisp());
		this.setIsConsiderarmo(pptpplano.getIsConsiderarmo());
		this.setIsConsiderarmp(pptpplano.getIsConsiderarmp());
		this.setIsConsideraroeefinalserie(pptpplano.getIsConsideraroeefinalserie());
		this.setIsConsiderarprodutoturno(pptpplano.getIsConsiderarprodutoturno());
		this.setIsConsiderarrap(pptpplano.getIsConsiderarrap());
		this.setIsDeterminadocal(pptpplano.getIsDeterminadocal());
	}
	
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	public ResultadoDTO getResultado() {
		return resultado;
	}
	
}
