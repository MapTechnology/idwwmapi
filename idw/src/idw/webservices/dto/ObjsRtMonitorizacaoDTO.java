package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class ObjsRtMonitorizacaoDTO implements Serializable {
	private Date dtReferencia;
	private List<ObjRtMonitorizacaoDTO> objsRtMonitorizacao;

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

	public void setObjsRtMonitorizacao(List<ObjRtMonitorizacaoDTO> objsRtMonitorizacao) {
		this.objsRtMonitorizacao = objsRtMonitorizacao;
	}

	public List<ObjRtMonitorizacaoDTO> getObjsRtMonitorizacao() {
		return objsRtMonitorizacao;
	}

	
	
}
