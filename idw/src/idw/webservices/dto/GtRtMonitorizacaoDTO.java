package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class GtRtMonitorizacaoDTO implements Serializable {
	
	private Date dtReferencia;
	private Date dthrRefresh;

	private GtDTO gtDTO;
	private TurnoAtualDTO turnoReferencia;
	private ObjsRtMonitorizacaoDTO objsRtMonitorizacaoDTO;	

	private int filtroLabel = 0;
	private int filtroLabel2 = 0;
	private int resultadoEvento;
	private int tempoMiliAtualizacaoGt;
	
	
	public TurnoAtualDTO getTurnoReferencia() {
		return turnoReferencia;
	}

	public void setTurnoReferencia(TurnoAtualDTO turnoReferencia) {
		this.turnoReferencia = turnoReferencia;
	}

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

	public void setObjsRtMonitorizacaoDTO(ObjsRtMonitorizacaoDTO objsRtMonitorizacaoDTO) {
		this.objsRtMonitorizacaoDTO = objsRtMonitorizacaoDTO;
	}

	public ObjsRtMonitorizacaoDTO getObjsRtMonitorizacaoDTO() {
		return objsRtMonitorizacaoDTO;
	}

	public void setFiltroLabel(int filtroLabel) {
		this.filtroLabel = filtroLabel;
	}

	public int getFiltroLabel() {
		return filtroLabel;
	}

	public int getFiltroLabel2() {
		return filtroLabel2;
	}

	public void setFiltroLabel2(int filtroLabel2) {
		this.filtroLabel2 = filtroLabel2;
	}

	public int getTempoMiliAtualizacaoGt() {
		return tempoMiliAtualizacaoGt;
	}

	public void setTempoMiliAtualizacaoGt(int tempoMiliAtualizacaoGt) {
		this.tempoMiliAtualizacaoGt = tempoMiliAtualizacaoGt;
	}

	public Date getDthrRefresh() {
		return dthrRefresh;
	}

	public void setDthrRefresh(Date dthrRefresh) {
		this.dthrRefresh = dthrRefresh;
	}
	
}
