package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.PpNecimp;

@SuppressWarnings("serial")
public class ConfiguracaoNecessidadeDTO extends PpNecimp implements Serializable{
	
	private ResultadoDTO resultadoDTO;
	
	public ConfiguracaoNecessidadeDTO(){
		
	}
	public ConfiguracaoNecessidadeDTO(PpNecimp ppnecimp){
		this.setCdNecimp(ppnecimp.getCdNecimp());
		this.setDsNecimp(ppnecimp.getDsNecimp());
		this.setDtRevisao(ppnecimp.getDtRevisao());
		this.setDtStativo(ppnecimp.getDtStativo());
		this.setIdNecimp(ppnecimp.getIdNecimp());
		this.setOmUsrByIdUsrrevisao(ppnecimp.getOmUsrByIdUsrrevisao());
		this.setOmUsrByIdUsrstativo(ppnecimp.getOmUsrByIdUsrstativo());
		this.setPpNecimpurls(ppnecimp.getPpNecimpurls());
		this.setRevisao(ppnecimp.getRevisao());
		this.setStAtivo(ppnecimp.getStAtivo());
		this.setTpNecimp(ppnecimp.getTpNecimp());
		this.setPpNecimpurls(ppnecimp.getPpNecimpurls());				
	}
	
	public ResultadoDTO getResultadoDTO() {
		return resultadoDTO;
	}

	public void setResultadoDTO(ResultadoDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}		
}
