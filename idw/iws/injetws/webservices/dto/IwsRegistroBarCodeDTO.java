package injetws.webservices.dto;

import java.io.Serializable;
import java.util.Date;

public class IwsRegistroBarCodeDTO implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String idlinha;
	private Date dthrleitura;
	private String cdturno;
	private Date dtturno;
	private String nrserie;
	private String cdproduto;
	private String barcode;
	private Date dthrregistro;
	
	private String dtemisemb;
	private String cdprodutoemb;
	private String qtdprodemb;
	private String nrpedidoemb;
	private String sequencialemb;
	private String motivorecusa;
	
	public IwsRegistroBarCodeDTO(){
		
	}
	
	public IwsRegistroBarCodeDTO(String idlinha, Date dthrleitura,
			String cdturno, Date dtturno, String nrserie, String cdproduto,
			String barcode, Date dthrregistro) {
		this.idlinha = idlinha;
		this.dthrleitura = dthrleitura;
		this.cdturno = cdturno;
		this.dtturno = dtturno;
		this.nrserie = nrserie;
		this.cdproduto = cdproduto;
		this.barcode = barcode;
		this.dthrregistro = dthrregistro;
	}
	
	public String getIdlinha() {
		return idlinha;
	}
	public void setIdlinha(String idlinha) {
		this.idlinha = idlinha;
	}
	public Date getDthrleitura() {
		return dthrleitura;
	}
	public void setDthrleitura(Date dthrleitura) {
		this.dthrleitura = dthrleitura;
	}
	public String getCdturno() {
		return cdturno;
	}
	public void setCdturno(String cdturno) {
		this.cdturno = cdturno;
	}
	public Date getDtturno() {
		return dtturno;
	}
	public void setDtturno(Date dtturno) {
		this.dtturno = dtturno;
	}
	public String getNrserie() {
		return nrserie;
	}
	public void setNrserie(String nrserie) {
		this.nrserie = nrserie;
	}
	public String getCdproduto() {
		return cdproduto;
	}
	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public Date getDthrregistro() {
		return dthrregistro;
	}
	public void setDthrregistro(Date dthrregistro) {
		this.dthrregistro = dthrregistro;
	}
	public String getCdprodutoemb() {
		return cdprodutoemb;
	}
	public void setCdprodutoemb(String cdprodutoemb) {
		this.cdprodutoemb = cdprodutoemb;
	}
	public String getQtdprodemb() {
		return qtdprodemb;
	}
	public void setQtdprodemb(String qtdprodemb) {
		this.qtdprodemb = qtdprodemb;
	}
	public String getNrpedidoemb() {
		return nrpedidoemb;
	}
	public void setNrpedidoemb(String nrpedidoemb) {
		this.nrpedidoemb = nrpedidoemb;
	}
	public String getSequencialemb() {
		return sequencialemb;
	}
	public void setSequencialemb(String sequencialemb) {
		this.sequencialemb = sequencialemb;
	}
	public String getMotivorecusa() {
		return motivorecusa;
	}
	public void setMotivorecusa(String motivorecusa) {
		this.motivorecusa = motivorecusa;
	}
	public String getDtemisemb() {
		return dtemisemb;
	}
	public void setDtemisemb(String dtemisemb) {
		this.dtemisemb = dtemisemb;
	}	
		
}
