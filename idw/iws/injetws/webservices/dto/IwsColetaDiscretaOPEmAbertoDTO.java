package injetws.webservices.dto;

import java.io.Serializable;
import java.util.Date;

public class IwsColetaDiscretaOPEmAbertoDTO  implements Serializable {

	private static final long serialVersionUID = 1L;
	
    String idOPEmAberto;
	String idUP;
	String nrOP;
	String nrOPEstendido;
	String cdMolde;
	String cdMolEstendido;
	String cdEstrutura;
	Date   DtHrIniPlanejada;
	String cdOperacao;
	
	public String getIdOPEmAberto() {
		return idOPEmAberto;
	}
	public void setIdOPEmAberto(String idOPEmAberto) {
		this.idOPEmAberto = idOPEmAberto;
	}
	public String getIdUP() {
		return idUP;
	}
	public void setIdUP(String idUP) {
		this.idUP = idUP;
	}
	public String getNrOP() {
		return nrOP;
	}
	public void setNrOP(String nrOP) {
		this.nrOP = nrOP;
	}
	public String getNrOPEstendido() {
		return nrOPEstendido;
	}
	public void setNrOPEstendido(String nrOPEstendido) {
		this.nrOPEstendido = nrOPEstendido;
	}
	public String getCdMolde() {
		return cdMolde;
	}
	public void setCdMolde(String cdMolde) {
		this.cdMolde = cdMolde;
	}
	public String getCdMolEstendido() {
		return cdMolEstendido;
	}
	public void setCdMolEstendido(String cdMolEstendido) {
		this.cdMolEstendido = cdMolEstendido;
	}
	public String getCdEstrutura() {
		return cdEstrutura;
	}
	public void setCdEstrutura(String cdEstrutura) {
		this.cdEstrutura = cdEstrutura;
	}
	public Date getDtHrIniPlanejada() {
		return DtHrIniPlanejada;
	}
	public void setDtHrIniPlanejada(Date dtHrIniPlanejada) {
		DtHrIniPlanejada = dtHrIniPlanejada;
	}
	public String getCdOperacao() {
		return cdOperacao;
	}
	public void setCdOperacao(String cdOperacao) {
		this.cdOperacao = cdOperacao;
	}
	
	
}
