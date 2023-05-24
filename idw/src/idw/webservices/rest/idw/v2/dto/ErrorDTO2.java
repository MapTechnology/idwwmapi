package idw.webservices.rest.idw.v2.dto;

public class ErrorDTO2 {
	
	private String codigoErro;
	
	public ErrorDTO2() {		
	}
	
	public ErrorDTO2(String codigoErro) {	
		this.codigoErro = codigoErro;
	}
	
	public String getCodigoErro() {
		return codigoErro;
	}
	public void setCodigoErro(String codigoErro) {
		this.codigoErro = codigoErro;
	}
	
}
