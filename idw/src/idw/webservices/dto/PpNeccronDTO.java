package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.PpNeccron;

@SuppressWarnings("serial")
public class PpNeccronDTO extends PpNeccron implements Serializable {
	
	private ResultadoDTO resultadoDTO;
	
	
	public PpNeccronDTO() {
	}
	public PpNeccronDTO(PpNeccron ppneccron) {
		this.setDtDesejada(ppneccron.getDtDesejada());
		this.setPpNec(ppneccron.getPpNec());
		this.setQtDesejada(ppneccron.getQtDesejada());
	}

	public void setResultadoDTO(ResultadoDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}

	public ResultadoDTO getResultadoDTO() {
		return resultadoDTO;
	}

}
