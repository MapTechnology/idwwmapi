package injetws.webservices.dto;

import java.io.Serializable;
import java.util.Date;

public class IwsColetaDiscretaParadaEmAbertoDTO  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String idUP;
	String idOPEmAberto;
	Date   dtHrIParada;
	double msDtHrIParada;
	String cdParada;
	String nrOP;
	
	public String getIdUP() {
		return idUP;
	}
	public void setIdUP(String idUP) {
		this.idUP = idUP;
	}
	public String getIdOPEmAberto() {
		return idOPEmAberto;
	}
	public void setIdOPEmAberto(String idOPEmAberto) {
		this.idOPEmAberto = idOPEmAberto;
	}
	public Date getDtHrIParada() {
		return dtHrIParada;
	}
	public void setDtHrIParada(Date dtHrIParada) {
		this.dtHrIParada = dtHrIParada;
	}
	public double getMsDtHrIParada() {
		return msDtHrIParada;
	}
	public void setMsDtHrIParada(double msDtHrIParada) {
		this.msDtHrIParada = msDtHrIParada;
	}
	public String getCdParada() {
		return cdParada;
	}
	public void setCdParada(String cdParada) {
		this.cdParada = cdParada;
	}
	public String getNrOP() {
		return nrOP;
	}
	public void setNrOP(String nrOP) {
		this.nrOP = nrOP;
	}
	
}
