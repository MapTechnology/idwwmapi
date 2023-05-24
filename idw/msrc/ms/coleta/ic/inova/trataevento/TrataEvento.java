package ms.coleta.ic.inova.trataevento;

import java.util.Calendar;

import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import idw.util.IdwLogger;

public abstract class TrataEvento {
	
	protected String[] dadoRecebido = null;
	protected IcUpDTO lcup = null;
	protected Calendar dataEvento = null;
	
	protected  IdwLogger log = null;
	protected  Integer idLog = null; 
	
	public TrataEvento() {
	}
	
//	public TrataEvento(String[] dadoRecebido, IcUpDTO lcup, Calendar dataEvento) {
//		this.dadoRecebido = dadoRecebido;
//		this.lcup = lcup;
//		this.dataEvento = dataEvento;
//	}
	
	public abstract EventoColetado trataEvento();
	
	
	public String[] getDadoRecebido() {
		return dadoRecebido;
	}
	public void setDadoRecebido(String[] dadoRecebido) {
		this.dadoRecebido = dadoRecebido;
	}
	
	public IcUpDTO getLcup() {
		return lcup;
	}
	public void setLcup(IcUpDTO lcup) {
		this.lcup = lcup;
	}
	
	public Calendar getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(Calendar dataEvento) {
		this.dataEvento = dataEvento;
	}
	
	public IdwLogger getLog() {
		return log;
	}
	public void setLog(IdwLogger log) {
		this.log = log;
	}
	
	public Integer getIdLog() {
		return idLog;
	}
	public void setIdLog(Integer idLog) {
		this.idLog = idLog;
	}
	
	
}
