package idw.webservices.dto;

import java.math.BigDecimal;

import idw.model.pojos.OmCfgind;
import idw.model.pojos.OmInd;
import idw.model.pojos.OmIndgt;
import idw.model.pojos.OmIndpt;
import idw.model.pojos.OmIndtppt;
import idw.model.rn.indicador.IndicadorValorDTO;

public class IndicadorMinMetaMaxDTO extends IndicadorValorDTO {
	
	private OmInd omInd;
	private BigDecimal indInferior;
	private BigDecimal indSuperior;
	private BigDecimal indMeta;
	
	public IndicadorMinMetaMaxDTO(){
	}

	public IndicadorMinMetaMaxDTO (OmInd omInd, BigDecimal indInferior, 
			BigDecimal indSuperior, BigDecimal indMeta){
		this.omInd = omInd;
		this.indInferior = indInferior;
		this.indSuperior = indSuperior;
		this.indMeta = indMeta;
	}

	
	public IndicadorMinMetaMaxDTO(OmInd omInd, OmIndgt omIndgt){
		this(omInd, omIndgt.getNumInf(), omIndgt.getNumSuperior(), omIndgt.getNumMeta());
	}
	
	public IndicadorMinMetaMaxDTO(OmInd omInd, OmIndpt omIndpt){
		this(omInd, omIndpt.getIndInferior(), omIndpt.getIndSuperior(), omIndpt.getIndMeta());
	}

	public IndicadorMinMetaMaxDTO(OmInd omInd, OmIndtppt omIndtppt){
		this(omInd, omIndtppt.getNumInferior(), omIndtppt.getNumSuperior(), omIndtppt.getNumMeta());
	}

	public IndicadorMinMetaMaxDTO(OmInd omInd, OmCfgind omCfgind){
		this(omInd, omCfgind.getIndInferior(), omCfgind.getIndSuperior(), omCfgind.getIndMeta());
	}
	
	public OmInd getOmInd() {
		return omInd;
	}
	public void setOmInd(OmInd omInd) {
		this.omInd = omInd;
	}
	public BigDecimal getIndInferior() {
		return indInferior;
	}
	public void setIndInferior(BigDecimal indInferior) {
		this.indInferior = indInferior;
	}
	public BigDecimal getIndSuperior() {
		return indSuperior;
	}
	public void setIndSuperior(BigDecimal indSuperior) {
		this.indSuperior = indSuperior;
	}
	public BigDecimal getIndMeta() {
		return indMeta;
	}
	public void setIndMeta(BigDecimal indMeta) {
		this.indMeta = indMeta;
	}
	
	
}