package idw.webservices.dto;

import java.io.Serializable;

public class ParametroCEPDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idFtParam;
	private String dsParametro;
	
	public Long getIdFtParam() {
		return idFtParam;
	}
	public void setIdFtParam(Long idFtParam) {
		this.idFtParam = idFtParam;
	}
	public String getDsParametro() {
		return dsParametro;
	}
	public void setDsParametro(String dsParametro) {
		this.dsParametro = dsParametro;
	}
	
	
}
