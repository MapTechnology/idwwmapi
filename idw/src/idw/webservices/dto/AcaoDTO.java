package idw.webservices.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AcaoDTO implements Serializable {
	
	private long idTAcao;
	private String cb; // codigo de barras
	private long idTppt;
	private long idPt;
	private ResultadoDTO resultado = new ResultadoDTO();
	private DefeitoDTO defeito;
	private ComponenteDTO componente;
	
	public ComponenteDTO getComponente() {
		return componente;
	}
	public void setComponente(ComponenteDTO componente) {
		this.componente = componente;
	}
	public DefeitoDTO getDefeito() {
		return defeito;
	}
	public void setDefeito(DefeitoDTO defeito) {
		this.defeito = defeito;
	}
	public long getIdTAcao() {
		return idTAcao;
	}
	public void setIdTAcao(long idTAcao) {
		this.idTAcao = idTAcao;
	}
	
	public String getCb() {
		return cb;
	}
	public void setCb(String cb) {
		this.cb = cb;
	}
	
	public long getIdTppt() {
		return idTppt;
	}
	public void setIdTppt(long idTppt) {
		this.idTppt = idTppt;
	}
	
	public long getIdPt() {
		return idPt;
	}
	public void setIdPt(long idPt) {
		this.idPt = idPt;
	}
	
	
	public ResultadoDTO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	
}
