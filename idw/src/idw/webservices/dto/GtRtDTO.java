package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;

import idw.model.pojos.DwTurno;

@SuppressWarnings("serial")
public class GtRtDTO implements Serializable {
	
	private GtDTO gtDTO;
	private Date dtReferencia;	
	private DwTurno dwTurno;
	private ObjsRtDTO objsRtDTO;
	private Boolean isTurnoAtual = false; // Sera true qdo o check de turno atual da interface estiver marcado
	private Integer filtroOP = 0;
			// 0 - Turno - ultima OP
			// 1 - Turno - todas as OPs
			// 2 = Acumulado ultima OP
	
	private Long idPt = null;
	
	public DwTurno getDwTurno() {
		return dwTurno;
	}

	public Integer getFiltroOP() {
		return filtroOP;
	}

	public void setFiltroOP(Integer filtroOP) {
		this.filtroOP = filtroOP;
	}

	public void setDwTurno(DwTurno dwTurno) {
		this.dwTurno = dwTurno;
	}

	private int resultadoEvento;
	
	public GtDTO getGtDTO() {
		return gtDTO;
	}

	public void setGtDTO(GtDTO gt) {
		this.gtDTO = gt;
	}

	public Date getDtReferencia() {
		return dtReferencia;
	}
    	
	public int getResultadoEvento() {
		return resultadoEvento;
	}

	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}

	public void setObjsRtDTO(ObjsRtDTO objsRtDTO) {
		this.objsRtDTO = objsRtDTO;
	}
	
	public ObjsRtDTO getObjsRtDTO() {
		return  objsRtDTO;
	}

	public Boolean getIsTurnoAtual() {
		return isTurnoAtual;
	}

	public void setIsTurnoAtual(Boolean isTurnoAtual) {
		this.isTurnoAtual = isTurnoAtual;
	}

	public Long getIdPt() {
		return idPt;
	}

	public void setIdPt(Long idPt) {
		this.idPt = idPt;
	}
	
}
