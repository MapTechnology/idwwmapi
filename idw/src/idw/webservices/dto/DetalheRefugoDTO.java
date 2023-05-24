package idw.webservices.dto;

import java.util.Date;

public class DetalheRefugoDTO {
	
	private String maquina;
	private String dsPt;
	private String ferramenta;
	private String produto;
	private String refugo;
	private double qtde_refugo;
	private Date dthrocorrencia;
	private String causa;
	private String acao;
	private String cdRap;
	
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getFerramenta() {
		return ferramenta;
	}
	public void setFerramenta(String ferramenta) {
		this.ferramenta = ferramenta;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getRefugo() {
		return refugo;
	}
	public void setRefugo(String refugo) {
		this.refugo = refugo;
	}
	public double getQtde_refugo() {
		return qtde_refugo;
	}
	public void setQtde_refugo(double qtde_refugo) {
		this.qtde_refugo = qtde_refugo;
	}
	public Date getDthrocorrencia() {
		return dthrocorrencia;
	}
	public void setDthrocorrencia(Date dthrocorrencia) {
		this.dthrocorrencia = dthrocorrencia;
	}
	public String getCausa() {
		return causa;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public String getDsPt() {
		return dsPt;
	}
	public void setDsPt(String dsPt) {
		this.dsPt = dsPt;
	}
	public String getCdRap() {
		return cdRap;
	}
	public void setCdRap(String cdRap) {
		this.cdRap = cdRap;
	}
	
	
}
