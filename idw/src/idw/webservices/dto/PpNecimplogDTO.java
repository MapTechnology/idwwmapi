package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.PpNecimplog;

@SuppressWarnings("serial")
public class PpNecimplogDTO extends PpNecimplog implements Serializable{
	
	private ResultadoDTO resultadoDTO;
	
	public PpNecimplogDTO() {
	}
	
	public PpNecimplogDTO(PpNecimplog ppnecimplog) {
		this.setIdNecimplog(ppnecimplog.getIdNecimplog());
		this.setMesReferencia(ppnecimplog.getMesReferencia());
		this.setAnoReferencia(ppnecimplog.getAnoReferencia());
		this.setDthrIimportacao(ppnecimplog.getDthrIimportacao());
		this.setDthrFimportacao(ppnecimplog.getDthrFimportacao());
		this.setOmUsr(ppnecimplog.getOmUsr());
		this.setPpNecimp(ppnecimplog.getPpNecimp());
	}

	public ResultadoDTO getResultadoDTO() {
		return resultadoDTO;
	}

	public void setResultadoDTO(ResultadoDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}

}
