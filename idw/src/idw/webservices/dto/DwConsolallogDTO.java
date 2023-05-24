package idw.webservices.dto;

import idw.model.pojos.DwConsolallog;

public class DwConsolallogDTO {
	
	private DwConsolallog dwConsolallog;
	private String Observacao;
	private String usuario;
	private String dthrFinal;

	public DwConsolallog getDwConsolallog() {
		return dwConsolallog;
	}

	public void setDwConsolallog(DwConsolallog dwConsolallog) {
		this.dwConsolallog = dwConsolallog;
	}

	public String getObservacao() {
		return Observacao;
	}

	public void setObservacao(String observacao) {
		Observacao = observacao;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getDthrFinal() {
		return dthrFinal;
	}

	public void setDthrFinal(String dthrFinal) {
		this.dthrFinal = dthrFinal;
	}

}
