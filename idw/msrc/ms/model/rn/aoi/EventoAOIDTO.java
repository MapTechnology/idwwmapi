package ms.model.rn.aoi;

import java.io.Serializable;

public class EventoAOIDTO implements Serializable {
	
	public enum _ST_ENVIO {
		_SUCESSO(0),
		_FALHA(1);
		
		private final int stEnvio;
		
		private _ST_ENVIO(int valor) {
			this.stEnvio = valor;
		}
		
		public int getStEnvio() {
			return this.stEnvio;
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer stEnvio;
	private String cdParada;
	
	
	public Integer getStEnvio() {
		return stEnvio;
	}
	public void setStEnvio(Integer stEnvio) {
		this.stEnvio = stEnvio;
	}
	public String getCdParada() {
		return cdParada;
	}
	public void setCdParada(String cdParada) {
		this.cdParada = cdParada;
	}
	
	

}
