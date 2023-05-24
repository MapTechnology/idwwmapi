package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="oppt")
public class OPPtCadDTO  implements Serializable {
	private static final long serialVersionUID = 1L; 

	private Long idCp;
	private String cdCp;
	private String cdPt;
	private String nrDoc;
	private String cdFolha;
	private String cdCliente;
	private BigDecimal prodPlan;
	private String dthrIniPlan; //ymdhms
	private String dthrFimPlan; 
	private String dthrIniRealMs; //ymdhms.m
	private Integer statusCp;
	private Boolean cpCritica;
	private Boolean editavel;
	private String cdUsrRev;
	private Integer revisao;
	private Integer stRegistro;	
	private List<OPProdutoCadDTO> produtos;
	
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
	public String getNrDoc() {
		return nrDoc;
	}
	public void setNrDoc(String nrDoc) {
		this.nrDoc = nrDoc;
	}
	public String getCdFolha() {
		return cdFolha;
	}
	public void setCdFolha(String cdFolha) {
		this.cdFolha = cdFolha;
	}
	public String getCdCliente() {
		return cdCliente;
	}
	public void setCdCliente(String cdCliente) {
		this.cdCliente = cdCliente;
	}
	public BigDecimal getProdPlan() {
		return prodPlan;
	}
	public void setProdPlan(BigDecimal prodPlan) {
		this.prodPlan = prodPlan;
	}
	public String getDthrIniPlan() {
		return dthrIniPlan;
	}
	public void setDthrIniPlan(String dthrIniPlan) {
		this.dthrIniPlan = dthrIniPlan;
	}
	public String getDthrFimPlan() {
		return dthrFimPlan;
	}
	public void setDthrFimPlan(String dthrFimPlan) {
		this.dthrFimPlan = dthrFimPlan;
	}
	public String getDthrIniRealMs() {
		return dthrIniRealMs;
	}
	public void setDthrIniRealMs(String dthrIniRealMs) {
		this.dthrIniRealMs = dthrIniRealMs;
	}
	public Integer getStatusCp() {
		return statusCp;
	}
	public void setStatusCp(Integer statusCp) {
		this.statusCp = statusCp;
	}
	public Boolean getCpCritica() {
		return cpCritica;
	}
	public void setCpCritica(Boolean cpCritica) {
		this.cpCritica = cpCritica;
	}
	public String getCdUsrRev() {
		return cdUsrRev;
	}
	public void setCdUsrRev(String cdUsrRev) {
		this.cdUsrRev = cdUsrRev;
	}
	public Integer getRevisao() {
		return revisao;
	}
	public void setRevisao(Integer revisao) {
		this.revisao = revisao;
	}
	public Integer getStRegistro() {
		return stRegistro;
	}
	public void setStRegistro(Integer stRegistro) {
		this.stRegistro = stRegistro;
	}
	public List<OPProdutoCadDTO> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<OPProdutoCadDTO> produtos) {
		this.produtos = produtos;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public Boolean getEditavel() {
		return editavel;
	}
	public void setEditavel(Boolean editavel) {
		this.editavel = editavel;
	}	
}
