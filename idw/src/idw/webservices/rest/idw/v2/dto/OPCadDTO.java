package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="op")
public class OPCadDTO implements Serializable {
	private static final long serialVersionUID = 1L; 

	private String nrDoc;
	private String cdFolha;
	private String cdCliente;
	private BigDecimal prodPlan;
	private String dthrIniPlan; //ymdhms
	private String dthrFimPlan; 
	private String dthrIniRealMs; //ymdhms.m
	private Boolean cpCritica;
	private String cdUsrRev;
	private List<OPPtCadDTO> listaOPsPorPt; 
	private List<OPPtCadDTO> ptsDisponiveis;
	private List<OPPtCadDTO> ptsSelecionados;
	
	public List<OPPtCadDTO> getPtsDisponiveis() {
		return ptsDisponiveis;
	}
	public void setPtsDisponiveis(List<OPPtCadDTO> ptsDisponiveis) {
		this.ptsDisponiveis = ptsDisponiveis;
	}
	public List<OPPtCadDTO> getPtsSelecionados() {
		return ptsSelecionados;
	}
	public void setPtsSelecionados(List<OPPtCadDTO> ptsSelecionados) {
		this.ptsSelecionados = ptsSelecionados;
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
	public Boolean getCpCritica() {
		return cpCritica;
	}
	public void setCpCritica(Boolean cpCritica) {
		this.cpCritica = cpCritica;
	}
	public List<OPPtCadDTO> getListaOPsPorPt() {
		return listaOPsPorPt;
	}
	public void setListaOPsPorPt(List<OPPtCadDTO> listaOPsPorPt) {
		this.listaOPsPorPt = listaOPsPorPt;
	}
	public String getCdUsrRev() {
		return cdUsrRev;
	}
	public void setCdUsrRev(String cdUsrRev) {
		this.cdUsrRev = cdUsrRev;
	}
	

 
}
