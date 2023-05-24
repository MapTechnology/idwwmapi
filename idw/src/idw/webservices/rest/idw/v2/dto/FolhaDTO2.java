package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;
import java.math.BigDecimal; 
import java.util.List; 

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="folhaprocesso")
public class FolhaDTO2 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long idFolha;
	private String cdFolha;
	private String dsFolha; 
	private BigDecimal cicloMinimo;
	private BigDecimal cicloTimeout;
	private BigDecimal cicloPadrao;
	private Integer setup;
	private Byte tpFolha;
	private String tpPt;
	private String cdGt;
	private String cdUsrRev;
	private Integer stRegistro;
	private List<FolhaRapDTO2> ferramentas;
	public Long getIdFolha() {
		return idFolha;
	}
	public void setIdFolha(Long idFolha) {
		this.idFolha = idFolha;
	}
	public String getCdFolha() {
		return cdFolha;
	}
	public void setCdFolha(String cdFolha) {
		this.cdFolha = cdFolha;
	}
	public String getDsFolha() {
		return dsFolha;
	}
	public void setDsFolha(String dsFolha) {
		this.dsFolha = dsFolha;
	}
	public BigDecimal getCicloMinimo() {
		return cicloMinimo;
	}
	public void setCicloMinimo(BigDecimal cicloMinimo) {
		this.cicloMinimo = cicloMinimo;
	}
	public BigDecimal getCicloTimeout() {
		return cicloTimeout;
	}
	public void setCicloTimeout(BigDecimal cicloTimeout) {
		this.cicloTimeout = cicloTimeout;
	}
	public BigDecimal getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(BigDecimal cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public Integer getSetup() {
		return setup;
	}
	public void setSetup(Integer setup) {
		this.setup = setup;
	}
	public Byte getTpFolha() {
		return tpFolha;
	}
	public void setTpFolha(Byte tpFolha) {
		this.tpFolha = tpFolha;
	}
	public String getTpPt() {
		return tpPt;
	}
	public void setTpPt(String tpPt) {
		this.tpPt = tpPt;
	}
	public String getCdGt() {
		return cdGt;
	}
	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}
	public String getCdUsrRev() {
		return cdUsrRev;
	}
	public void setCdUsrRev(String cdUsrRev) {
		this.cdUsrRev = cdUsrRev;
	}
	public Integer getStRegistro() {
		return stRegistro;
	}
	public void setStRegistro(Integer stRegistro) {
		this.stRegistro = stRegistro;
	}
	public List<FolhaRapDTO2> getFerramentas() {
		return ferramentas;
	}
	public void setFerramentas(List<FolhaRapDTO2> ferramentas) {
		this.ferramentas = ferramentas;
	}
}
