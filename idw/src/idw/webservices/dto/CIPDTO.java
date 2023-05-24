package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;

import idw.model.pojos.DwConsolid;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;

public class CIPDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PpCp ppcp;
	private OmPt ompt;
	private Date inicioCIP;
	private Date fimCIP;
	private Date inicioParada;
	private Date fimParada;
	private OmUsr inicioUsuario;
	private OmUsr fimUsuario;
	private DwConsolid inicioId;
	private DwConsolid fimId;
	public OmPt getOmpt() {
		return ompt;
	}
	public void setOmpt(OmPt ompt) {
		this.ompt = ompt;
	}
	public Date getInicioCIP() {
		return inicioCIP;
	}
	public void setInicioCIP(Date inicioCIP) {
		this.inicioCIP = inicioCIP;
	}
	public Date getFimCIP() {
		return fimCIP;
	}
	public void setFimCIP(Date fimCIP) {
		this.fimCIP = fimCIP;
	}
	public Date getInicioParada() {
		return inicioParada;
	}
	public void setInicioParada(Date inicioParada) {
		this.inicioParada = inicioParada;
	}
	public Date getFimParada() {
		return fimParada;
	}
	public void setFimParada(Date fimParada) {
		this.fimParada = fimParada;
	}
	public OmUsr getInicioUsuario() {
		return inicioUsuario;
	}
	public void setInicioUsuario(OmUsr inicioUsuario) {
		this.inicioUsuario = inicioUsuario;
	}
	public OmUsr getFimUsuario() {
		return fimUsuario;
	}
	public void setFimUsuario(OmUsr fimUsuario) {
		this.fimUsuario = fimUsuario;
	}
	public DwConsolid getInicioId() {
		return inicioId;
	}
	public void setInicioId(DwConsolid inicioId) {
		this.inicioId = inicioId;
	}
	public DwConsolid getFimId() {
		return fimId;
	}
	public void setFimId(DwConsolid fimId) {
		this.fimId = fimId;
	}
	public PpCp getPpcp() {
		return ppcp;
	}
	public void setPpcp(PpCp ppcp) {
		this.ppcp = ppcp;
	}
	
	
}
