package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.PpNecimp;

@SuppressWarnings("serial")
public class PpNecimpDTO extends PpNecimp implements Serializable {
	
	public PpNecimpDTO() {
	}
	public PpNecimpDTO(PpNecimp ppnecimp) {
		this.setCdNecimp(ppnecimp.getCdNecimp());
		this.setDsNecimp(ppnecimp.getDsNecimp());
		this.setDtRevisao(ppnecimp.getDtRevisao());
		this.setDtStativo(ppnecimp.getDtStativo());
		this.setOmUsrByIdUsrrevisao(ppnecimp.getOmUsrByIdUsrrevisao());
		this.setOmUsrByIdUsrstativo(ppnecimp.getOmUsrByIdUsrstativo());
		this.setPpNecimplogs(ppnecimp.getPpNecimplogs());
		this.setPpNecimpurls(ppnecimp.getPpNecimpurls());
		this.setRevisao(ppnecimp.getRevisao());
		this.setStAtivo(ppnecimp.getStAtivo());
		this.setTpNecimp(ppnecimp.getTpNecimp());
	}
	
}
