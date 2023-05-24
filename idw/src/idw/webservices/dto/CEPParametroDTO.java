package idw.webservices.dto;

import java.math.BigDecimal;

public class CEPParametroDTO 
{
	private Long idFtParam;
	private String dsParametro;
	
    private BigDecimal limCriticoInf;
    private BigDecimal limAceitavelInfIni;
    private BigDecimal limAceitavelInfFim;
    
    private BigDecimal limIdealIni;
    private BigDecimal limIdealFim;
    
    private BigDecimal limAceitavelSupIni;
    private BigDecimal limAceitavelSupFim;
    private BigDecimal limCriticoSup;
    
    private Boolean temMinimo;
    private Boolean temMeta;
    private Boolean temMaximo;
	public Long getIdFtParam() {
		return idFtParam;
	}
	public void setIdFtParam(Long idFtParam) {
		this.idFtParam = idFtParam;
	}
	public String getDsParametro() {
		return dsParametro;
	}
	public void setDsParametro(String dsParametro) {
		this.dsParametro = dsParametro;
	}
	public BigDecimal getLimCriticoInf() {
		return limCriticoInf;
	}
	public void setLimCriticoInf(BigDecimal limCriticoInf) {
		this.limCriticoInf = limCriticoInf;
	}
	public BigDecimal getLimAceitavelInfIni() {
		return limAceitavelInfIni;
	}
	public void setLimAceitavelInfIni(BigDecimal limAceitavelInfIni) {
		this.limAceitavelInfIni = limAceitavelInfIni;
	}
	public BigDecimal getLimAceitavelInfFim() {
		return limAceitavelInfFim;
	}
	public void setLimAceitavelInfFim(BigDecimal limAceitavelInfFim) {
		this.limAceitavelInfFim = limAceitavelInfFim;
	}
	public BigDecimal getLimIdealIni() {
		return limIdealIni;
	}
	public void setLimIdealIni(BigDecimal limIdealIni) {
		this.limIdealIni = limIdealIni;
	}
	public BigDecimal getLimIdealFim() {
		return limIdealFim;
	}
	public void setLimIdealFim(BigDecimal limIdealFim) {
		this.limIdealFim = limIdealFim;
	}
	public BigDecimal getLimAceitavelSupIni() {
		return limAceitavelSupIni;
	}
	public void setLimAceitavelSupIni(BigDecimal limAceitavelSupIni) {
		this.limAceitavelSupIni = limAceitavelSupIni;
	}
	public BigDecimal getLimAceitavelSupFim() {
		return limAceitavelSupFim;
	}
	public void setLimAceitavelSupFim(BigDecimal limAceitavelSupFim) {
		this.limAceitavelSupFim = limAceitavelSupFim;
	}
	public BigDecimal getLimCriticoSup() {
		return limCriticoSup;
	}
	public void setLimCriticoSup(BigDecimal limCriticoSup) {
		this.limCriticoSup = limCriticoSup;
	}
	public Boolean getTemMinimo() {
		return temMinimo;
	}
	public void setTemMinimo(Boolean temMinimo) {
		this.temMinimo = temMinimo;
	}
	public Boolean getTemMeta() {
		return temMeta;
	}
	public void setTemMeta(Boolean temMeta) {
		this.temMeta = temMeta;
	}
	public Boolean getTemMaximo() {
		return temMaximo;
	}
	public void setTemMaximo(Boolean temMaximo) {
		this.temMaximo = temMaximo;
	}
 
    
}
