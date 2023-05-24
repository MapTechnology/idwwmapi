/*
 * Created on 23/02/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package idw.model.rn.injet.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import idw.model.pojos.injet.Ijtbpro;



/**
 * @author abarros
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ProdutoInjetDTO implements Serializable{
	private String cdProduto;
	private String dsProduto;
	private String cdMolde;
	private Ijtbpro ijtbpro;
	private BigDecimal qtcavidades;
	private BigDecimal qtcavativas;
	
	/**
	 * @return Returns the cdProduto.
	 */
	public String getCdProduto() {
		return cdProduto;
	}
	/**
	 * @param cdProduto The cdProduto to set.
	 */
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	/**
	 * @return Returns the dsProduto.
	 */
	public String getDsProduto() {
		return dsProduto;
	}
	/**
	 * @param dsProduto The dsProduto to set.
	 */
	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}
	public String getCdMolde() {
		return cdMolde;
	}
	public void setCdMolde(String cdMolde) {
		int Posicao = 6;
		Posicao = cdMolde.indexOf(" - ");
		try{
			this.cdMolde = cdMolde.substring(0, Posicao);
		} catch (StringIndexOutOfBoundsException e){
			this.cdMolde = cdMolde;
		}
	}
	public Ijtbpro getIjtbpro() {
		return ijtbpro;
	}
	public void setIjtbpro(Ijtbpro ijtbpro) {
		this.ijtbpro = ijtbpro;
	}
	public BigDecimal getQtcavidades() {
		return qtcavidades;
	}
	public void setQtcavidades(BigDecimal qtcavidades) {
		this.qtcavidades = qtcavidades;
	}
	public BigDecimal getQtcavativas() {
		return qtcavativas;
	}
	public void setQtcavativas(BigDecimal qtcavativas) {
		this.qtcavativas = qtcavativas;
	}
}
