package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="filtromonit")
public class FiltroMonitDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private String dtReferencia; //ymd (yyyy-mm-dd)
    private Integer idTurno;
    private String cdGt;
    private Integer filtroOp;
    private Boolean turnoAtual;
    
	public String getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(String dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public Integer getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(Integer idTurno) {
		this.idTurno = idTurno;
	}
	public String getCdGt() {
		return cdGt;
	}
	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}
	public Integer getFiltroOp() {
		return filtroOp;
	}
	public void setFiltroOp(Integer filtroOp) {
		this.filtroOp = filtroOp;
	}
	public Boolean getTurnoAtual() {
		return turnoAtual;
	}
	public void setTurnoAtual(Boolean turnoAtual) {
		this.turnoAtual = turnoAtual;
	}
    
    
}
