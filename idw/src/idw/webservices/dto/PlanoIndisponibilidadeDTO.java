package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.PpIndisp;
import idw.model.pojos.PpIndispRappt;

@SuppressWarnings("serial")
public class PlanoIndisponibilidadeDTO extends PpIndisp implements Serializable{

	private ResultadoDTO resultadoDTO = new ResultadoDTO();
	
	public PlanoIndisponibilidadeDTO() {
	}
	
	public PlanoIndisponibilidadeDTO(PpIndisp plano) {
		this.setCdIndisp(plano.getCdIndisp());
		this.setDsIndisp(plano.getDsIndisp());
		this.setDtRevisao(plano.getDtRevisao());
		this.setDtStativo(plano.getDtStativo());
		this.setIdIndisp(plano.getIdIndisp());
		
		if (plano.getOmUsrByIdUsrrevisao() != null)
			this.setOmUsrByIdUsrrevisao(plano.getOmUsrByIdUsrrevisao().clone());
		
		if (plano.getOmUsrByIdUsrstativo() != null)
			this.setOmUsrByIdUsrstativo(plano.getOmUsrByIdUsrstativo().clone());
		
		this.setRevisao(plano.getRevisao());
		this.setStAtivo(plano.getStAtivo());
		this.setStIndisp(plano.getStIndisp());

		for (PpIndispRappt p : plano.getPpIndispRappts()){
			this.getPpIndispRappts().add(p.clone());
		}
	}
	
	public void setResultadoDTO(ResultadoDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}
	public ResultadoDTO getResultadoDTO() {
		return resultadoDTO;
	}
}
