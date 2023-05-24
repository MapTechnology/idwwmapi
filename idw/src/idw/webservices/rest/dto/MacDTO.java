package idw.webservices.rest.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="mac")
public class MacDTO implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	private long idMacRange;
	private long idMacPai;
	private String cdMacInicio;
	private String cdMacFim;
	private String modelo;
	private String cdGt;
	private int qtdPorPeca;
	private String regraConsumo;
	private String cdUltimoMacConsumido;
	private String dtHr;
	private String cdUsr;
	private String dsApelido;
	private String quantidadeRestante;

	public MacDTO() {

	}

	public long getIdMacRange() {
		return idMacRange;
	}

	public void setIdMacRange(long idMacRange) {
		this.idMacRange = idMacRange;
	}

	public long getIdMacPai() {
		return idMacPai;
	}

	public void setIdMacPai(long idMacPai) {
		this.idMacPai = idMacPai;
	}

	public String getCdMacInicio() {
		return cdMacInicio;
	}

	public void setCdMacInicio(String cdMacInicio) {
		this.cdMacInicio = cdMacInicio;
	}

	public String getCdMacFim() {
		return cdMacFim;
	}

	public void setCdMacFim(String cdMacFim) {
		this.cdMacFim = cdMacFim;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCdGt() {
		return cdGt;
	}

	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}

	public int getQtdPorPeca() {
		return qtdPorPeca;
	}

	public void setQtdPorPeca(int qtdPorPeca) {
		this.qtdPorPeca = qtdPorPeca;
	}

	public String getRegraConsumo() {
		return regraConsumo;
	}

	public void setRegraConsumo(String regraConsumo) {
		this.regraConsumo = regraConsumo;
	}

	public String getCdUltimoMacConsumido() {
		return cdUltimoMacConsumido;
	}

	public void setCdUltimoMacConsumido(String cdUltimoMacConsumido) {
		this.cdUltimoMacConsumido = cdUltimoMacConsumido;
	}

	public String getDtHr() {
		return dtHr;
	}

	public void setDtHr(String dtHr) {
		this.dtHr = dtHr;
	}

	public String getCdUsr() {
		return cdUsr;
	}

	public void setCdUsr(String cdUsr) {
		this.cdUsr = cdUsr;
	}

	public String getQuantidadeRestante() {
		return quantidadeRestante;
	}

	public void setQuantidadeRestante(String quantidadeRestante) {
		this.quantidadeRestante = quantidadeRestante;
	}

	public String getDsApelido() {
		return dsApelido;
	}

	public void setDsApelido(String dsApelido) {
		this.dsApelido = dsApelido;
	}

	@Override
	public String toString() {
		return "MacDTO [idMacRange=" + idMacRange + ", cdMacInicio="
				+ cdMacInicio + ", cdMacFim=" + cdMacFim + ", modelo=" + modelo
				+ ", cdGt=" + cdGt + ", qtdPorPeca=" + qtdPorPeca
				+ ", regraConsumo=" + regraConsumo + ", cdUltimoMacConsumido="
				+ cdUltimoMacConsumido + ", dtHr=" + dtHr + ", cdUsr=" + cdUsr
				+ ", dsApelido=" + dsApelido + ", quantidadeRestante="
				+ quantidadeRestante + "]";
	}

	
}
