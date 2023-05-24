package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class ObjsRtDTO implements Serializable {
	private Date dtReferencia;
	private List<ObjRtDTO> objsRt;

	private int resultadoEvento;
    
	public int getResultadoEvento() {
		return resultadoEvento;
	}

	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	
	public Date getDtHrReferencia() {
		return dtReferencia;
	}

	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}

	public void setObjsRt(List<ObjRtDTO> objsRt) {
		this.objsRt = objsRt;
	}
	
	public List<ObjRtDTO> getObjsRt() {
		return  objsRt;
	}
	
}
