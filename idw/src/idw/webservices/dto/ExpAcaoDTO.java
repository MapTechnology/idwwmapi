package idw.webservices.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ExpAcaoDTO implements Serializable {
	
	private String cdAcao;
	private String dsAcao;
	
	public String getCdAcao() {
		return cdAcao;
	}
	public void setCdAcao(String cdAcao) {
		this.cdAcao = cdAcao;
	}
	public String getDsAcao() {
		return dsAcao;
	}
	public void setDsAcao(String dsAcao) {
		this.dsAcao = dsAcao;
	}
	
}
