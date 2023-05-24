package ms.coleta.ic.inova.trataretorno;

import injetws.model.excessoes.SemSGBDException;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.MSInova;
import idw.util.IdwLogger;

public abstract class TrataRetorno {
	
	protected ParametroDTO parametro = null;
	protected IdwLogger log = null;
	protected Integer idLog = null;
	
	protected MSInova ic = null;
	
	public TrataRetorno() {
	}
	
//	public TrataRetorno(ParametroDTO parametro) {
//		this.parametro = parametro;
//	}
	
	public abstract void trataRetorno() throws SemSGBDException;
	
	
	
	public ParametroDTO getParametro() {
		return parametro;
	}
	public void setParametro(ParametroDTO parametro) {
		this.parametro = parametro;
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
	
	public MSInova getIc() {
		return ic;
	}
	public void setIc(MSInova ic) {
		this.ic = ic;
	}
	
	
}
