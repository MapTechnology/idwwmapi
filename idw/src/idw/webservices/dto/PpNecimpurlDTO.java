package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.PpNecimpurl;

@SuppressWarnings("serial")
public class PpNecimpurlDTO extends PpNecimpurl implements Serializable {
	
	private ResultadoDTO resultadoDTO;
	
	public PpNecimpurlDTO() {
	}
	
	public PpNecimpurlDTO(PpNecimpurl ppnecimpurl) {
		this.setAba(ppnecimpurl.getAba());
		this.setMascara(ppnecimpurl.getMascara());
		this.setPpNecimp(ppnecimpurl.getPpNecimp());
		this.setPpNecimpurllogs(ppnecimpurl.getPpNecimpurllogs());
		this.setUrlFonte(ppnecimpurl.getUrlFonte());
	}

	public void setResultadoDTO(ResultadoDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}

	public ResultadoDTO getResultadoDTO() {
		return resultadoDTO;
	}
}
