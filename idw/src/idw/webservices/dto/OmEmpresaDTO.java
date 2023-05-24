package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.OmEmpresa;

@SuppressWarnings("serial")
public class OmEmpresaDTO implements Serializable{

	private OmEmpresa omEmpresa;
	private boolean isFlex;
	private boolean isPst;
	private boolean isSemp;
	private ResultadoDTO resultado = new ResultadoDTO();
	
	public OmEmpresa getOmEmpresa() {
		return omEmpresa;
	}
	public void setOmEmpresa(OmEmpresa omEmpresa) {
		this.omEmpresa = omEmpresa;
	}
	public boolean isFlex() {
		return isFlex;
	}
	public void setFlex(boolean isFlex) {
		this.isFlex = isFlex;
	}
	public boolean isPst() {
		return isPst;
	}
	public void setPst(boolean isPst) {
		this.isPst = isPst;
	}
	public boolean isSemp() {
		return isSemp;
	}
	public void setSemp(boolean isSemp) {
		this.isSemp = isSemp;
	}
	public ResultadoDTO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	
		
	
}
