package injetws.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.injet.Ijtbvarritmo;

@SuppressWarnings("serial")
public class IwsVariacaoRitmoValidaDTO implements Serializable{
	
	private Boolean isVariacaoValida=false;
	private String cdvariacaoritmo;
	private String dsvariacaoritmo;
	private Integer limitepercentual;	
	private long quantidade;
		
	/**
	 * @return the isVariacaoValida
	 */
	public Boolean getIsVariacaoValida() {
		return isVariacaoValida;
	}
	/**
	 * @param IsVariacaoValida the IsVariacaoValida to set
	 */
	public void setIsVariacaoValida(Boolean isVariacaoValida) {
		this.isVariacaoValida = isVariacaoValida;		
	}	
	
	/**
	 * @return the CdVariacaoRitmo
	 */
	public String getCdVariacaoRitmo() {
		return cdvariacaoritmo;
	}
	/**
	 * @param CdVariacaoRitmo the CdVariacaoRitmo to set
	 */
	public void setCdVariacaoRitmo(String cdvariacaoritmo) {
		this.cdvariacaoritmo = cdvariacaoritmo;		
	}	
	
	/**
	 * @return the DsVariacaoRitmo
	 */
	public String getDsVariacaoRitmo() {
		return dsvariacaoritmo;
	}
	/**
	 * @param DsVariacaoRitmo the DsVariacaoRitmo to set
	 */
	public void setDsVariacaoRitmo(String dsvariacaoritmo) {
		this.dsvariacaoritmo = dsvariacaoritmo;		
	}	
	
	/**
	 * @return the LimitePercentual
	 */
	public Integer getLimitePercentual() {
		return limitepercentual;
	}
	/**
	 * @param LimitePercentual the LimitePercentual to set
	 */
	public void setLimitePercentual(Integer limitepercentual) {
		this.limitepercentual = limitepercentual;		
	}	
	
	public void copyPrVariacaoRitmo(Ijtbvarritmo oVar){
		this.cdvariacaoritmo=oVar.getCdvarritmo();
		this.dsvariacaoritmo=oVar.getDsvarritmo();
		this.limitepercentual=oVar.getPercmax().intValue();
		this.isVariacaoValida=true;		
	}
	public long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}
}
