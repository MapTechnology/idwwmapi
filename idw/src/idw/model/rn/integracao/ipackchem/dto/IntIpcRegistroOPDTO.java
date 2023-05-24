package idw.model.rn.integracao.ipackchem.dto;

import java.math.BigDecimal;
import java.util.Date;

public class IntIpcRegistroOPDTO 
{
	private String cdMaquina;
	private String nrop;
	private String cdMolde;
	private String cdEstrutura;
	private String cdProduto;
	private BigDecimal qtCavAtivas;
	private BigDecimal cicloPadrao;
	private Date dthrIniReal;
	private Date dthrIniPlan;
	private Date dthrFimPlan;
	public String getCdMaquina() {
		return cdMaquina;
	}
	public void setCdMaquina(String cdMaquina) {
		this.cdMaquina = cdMaquina;
	}
	public String getNrop() {
		return nrop;
	}
	public void setNrop(String nrop) {
		this.nrop = nrop;
	}
	public String getCdMolde() {
		return cdMolde;
	}
	public void setCdMolde(String cdMolde) {
		this.cdMolde = cdMolde;
	}
	public String getCdEstrutura() {
		return cdEstrutura;
	}
	public void setCdEstrutura(String cdEstrutura) {
		this.cdEstrutura = cdEstrutura;
	}
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public BigDecimal getQtCavAtivas() {
		return qtCavAtivas;
	}
	public void setQtCavAtivas(BigDecimal qtCavAtivas) {
		this.qtCavAtivas = qtCavAtivas;
	}
	public BigDecimal getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(BigDecimal cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public Date getDthrIniReal() {
		return dthrIniReal;
	}
	public void setDthrIniReal(Date dthrIniReal) {
		this.dthrIniReal = dthrIniReal;
	}
	public Date getDthrIniPlan() {
		return dthrIniPlan;
	}
	public void setDthrIniPlan(Date dthrIniPlan) {
		this.dthrIniPlan = dthrIniPlan;
	}
	public Date getDthrFimPlan() {
		return dthrFimPlan;
	}
	public void setDthrFimPlan(Date dthrFimPlan) {
		this.dthrFimPlan = dthrFimPlan;
	}
	
	
}
