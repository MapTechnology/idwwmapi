package idw.webservices.rest.idw.v2.dto;

import java.math.BigDecimal;

public class MaquinaIHMDTO {
	private Long idPt;
	private String cdPt;
	private Integer stFuncionamento; // 0 - parada, 1 - produzindo  
	private Integer offLine; // 0 - nao; 1- sim
	private Integer semPlanejamento; // 0 - nao; 1 -sim

	// metas
	private MetaIndicadorDTO2 metaOEE;
	private MetaIndicadorDTO2 metaDisp;
	private MetaIndicadorDTO2 metaRitmo;
	private MetaIndicadorDTO2 metaQld;
	
	// indicadores
	private BigDecimal oee;
	private BigDecimal disp;
	private BigDecimal ritmo;
	private BigDecimal qld;
	private BigDecimal efiRea;
	private BigDecimal indRef;
	
	private BigDecimal tempoParCP;
	private BigDecimal tempoParSP;
	private BigDecimal tempoPar;
	
	private String tempoParFormatado;
		 
	// funcoes que deverao estar habilitadas dependendo do estado da maq
	private Boolean habilitaFuncaoParada;
	private Boolean habilitaFuncaoRefugo;
	private Boolean habilitaFuncaoAlerta;
	private Boolean habilitaFuncaoLoginOper;
	private Boolean habilitaBotaoEntradaOP;
	private Boolean habilitaBotaoSaidaOP;
	private Boolean habilitaBotaoConsultas;

	// planejamento
	private Long idCp;
	private String cdCp; 
	private String dthrIniPlan; // YMDHMS
	private String dthrIniReal;
	private String dthrFimPlan;
	private String dthrFimPrev;	 
	
	// qtdes	
	private BigDecimal prodBruta;
	private BigDecimal prodLiq;
	private BigDecimal prodRef;
	private BigDecimal prodPrev;
	private BigDecimal prodPlan;
	private BigDecimal prodFaltante;
	public Long getIdPt() {
		return idPt;
	}
	public void setIdPt(Long idPt) {
		this.idPt = idPt;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public Integer getStFuncionamento() {
		return stFuncionamento;
	}
	public void setStFuncionamento(Integer stFuncionamento) {
		this.stFuncionamento = stFuncionamento;
	}
	public Integer getOffLine() {
		return offLine;
	}
	public void setOffLine(Integer offLine) {
		this.offLine = offLine;
	}
	public Integer getSemPlanejamento() {
		return semPlanejamento;
	}
	public void setSemPlanejamento(Integer semPlanejamento) {
		this.semPlanejamento = semPlanejamento;
	}
	public MetaIndicadorDTO2 getMetaOEE() {
		return metaOEE;
	}
	public void setMetaOEE(MetaIndicadorDTO2 metaOEE) {
		this.metaOEE = metaOEE;
	}
	public MetaIndicadorDTO2 getMetaDisp() {
		return metaDisp;
	}
	public void setMetaDisp(MetaIndicadorDTO2 metaDisp) {
		this.metaDisp = metaDisp;
	}
	public MetaIndicadorDTO2 getMetaRitmo() {
		return metaRitmo;
	}
	public void setMetaRitmo(MetaIndicadorDTO2 metaRitmo) {
		this.metaRitmo = metaRitmo;
	}
	public MetaIndicadorDTO2 getMetaQld() {
		return metaQld;
	}
	public void setMetaQld(MetaIndicadorDTO2 metaQld) {
		this.metaQld = metaQld;
	}
	public BigDecimal getOee() {
		return oee;
	}
	public void setOee(BigDecimal oee) {
		this.oee = oee;
	}
	public BigDecimal getDisp() {
		return disp;
	}
	public void setDisp(BigDecimal disp) {
		this.disp = disp;
	}
	public BigDecimal getRitmo() {
		return ritmo;
	}
	public void setRitmo(BigDecimal ritmo) {
		this.ritmo = ritmo;
	}
	public BigDecimal getQld() {
		return qld;
	}
	public void setQld(BigDecimal qld) {
		this.qld = qld;
	}
	public BigDecimal getEfiRea() {
		return efiRea;
	}
	public void setEfiRea(BigDecimal efiRea) {
		this.efiRea = efiRea;
	}
	public BigDecimal getIndRef() {
		return indRef;
	}
	public void setIndRef(BigDecimal indRef) {
		this.indRef = indRef;
	}
	public BigDecimal getTempoParCP() {
		return tempoParCP;
	}
	public void setTempoParCP(BigDecimal tempoParCP) {
		this.tempoParCP = tempoParCP;
	}
	public BigDecimal getTempoParSP() {
		return tempoParSP;
	}
	public void setTempoParSP(BigDecimal tempoParSP) {
		this.tempoParSP = tempoParSP;
	}
	public BigDecimal getTempoPar() {
		return tempoPar;
	}
	public void setTempoPar(BigDecimal tempoPar) {
		this.tempoPar = tempoPar;
	}
	public String getTempoParFormatado() {
		return tempoParFormatado;
	}
	public void setTempoParFormatado(String tempoParFormatado) {
		this.tempoParFormatado = tempoParFormatado;
	}
	public Boolean getHabilitaFuncaoParada() {
		return habilitaFuncaoParada;
	}
	public void setHabilitaFuncaoParada(Boolean habilitaFuncaoParada) {
		this.habilitaFuncaoParada = habilitaFuncaoParada;
	}
	public Boolean getHabilitaFuncaoRefugo() {
		return habilitaFuncaoRefugo;
	}
	public void setHabilitaFuncaoRefugo(Boolean habilitaFuncaoRefugo) {
		this.habilitaFuncaoRefugo = habilitaFuncaoRefugo;
	}
	public Boolean getHabilitaFuncaoAlerta() {
		return habilitaFuncaoAlerta;
	}
	public void setHabilitaFuncaoAlerta(Boolean habilitaFuncaoAlerta) {
		this.habilitaFuncaoAlerta = habilitaFuncaoAlerta;
	}
	public Boolean getHabilitaFuncaoLoginOper() {
		return habilitaFuncaoLoginOper;
	}
	public void setHabilitaFuncaoLoginOper(Boolean habilitaFuncaoLoginOper) {
		this.habilitaFuncaoLoginOper = habilitaFuncaoLoginOper;
	}
	public Boolean getHabilitaBotaoEntradaOP() {
		return habilitaBotaoEntradaOP;
	}
	public void setHabilitaBotaoEntradaOP(Boolean habilitaBotaoEntradaOP) {
		this.habilitaBotaoEntradaOP = habilitaBotaoEntradaOP;
	}
	public Boolean getHabilitaBotaoSaidaOP() {
		return habilitaBotaoSaidaOP;
	}
	public void setHabilitaBotaoSaidaOP(Boolean habilitaBotaoSaidaOP) {
		this.habilitaBotaoSaidaOP = habilitaBotaoSaidaOP;
	}
	public Boolean getHabilitaBotaoConsultas() {
		return habilitaBotaoConsultas;
	}
	public void setHabilitaBotaoConsultas(Boolean habilitaBotaoConsultas) {
		this.habilitaBotaoConsultas = habilitaBotaoConsultas;
	}
	public Long getIdCp() {
		return idCp;
	}
	public void setIdCp(Long idCp) {
		this.idCp = idCp;
	}
	public String getCdCp() {
		return cdCp;
	}
	public void setCdCp(String cdCp) {
		this.cdCp = cdCp;
	}
	public String getDthrIniPlan() {
		return dthrIniPlan;
	}
	public void setDthrIniPlan(String dthrIniPlan) {
		this.dthrIniPlan = dthrIniPlan;
	}
	public String getDthrIniReal() {
		return dthrIniReal;
	}
	public void setDthrIniReal(String dthrIniReal) {
		this.dthrIniReal = dthrIniReal;
	}
	public String getDthrFimPlan() {
		return dthrFimPlan;
	}
	public void setDthrFimPlan(String dthrFimPlan) {
		this.dthrFimPlan = dthrFimPlan;
	}
	public String getDthrFimPrev() {
		return dthrFimPrev;
	}
	public void setDthrFimPrev(String dthrFimPrev) {
		this.dthrFimPrev = dthrFimPrev;
	}
	public BigDecimal getProdBruta() {
		return prodBruta;
	}
	public void setProdBruta(BigDecimal prodBruta) {
		this.prodBruta = prodBruta;
	}
	public BigDecimal getProdLiq() {
		return prodLiq;
	}
	public void setProdLiq(BigDecimal prodLiq) {
		this.prodLiq = prodLiq;
	}
	public BigDecimal getProdRef() {
		return prodRef;
	}
	public void setProdRef(BigDecimal prodRef) {
		this.prodRef = prodRef;
	}
	public BigDecimal getProdPrev() {
		return prodPrev;
	}
	public void setProdPrev(BigDecimal prodPrev) {
		this.prodPrev = prodPrev;
	}
	public BigDecimal getProdPlan() {
		return prodPlan;
	}
	public void setProdPlan(BigDecimal prodPlan) {
		this.prodPlan = prodPlan;
	}
	public BigDecimal getProdFaltante() {
		return prodFaltante;
	}
	public void setProdFaltante(BigDecimal prodFaltante) {
		this.prodFaltante = prodFaltante;
	}
	 
}
