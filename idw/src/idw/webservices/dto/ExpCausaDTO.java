package idw.webservices.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ExpCausaDTO implements Serializable {
	
	private long id_passcau;
	private String cdDefeito;
	private String dsDefeito;
	private ExpAcaoDTO acao;
	
	public String getCdDefeito() {
		return cdDefeito;
	}
	public void setCdDefeito(String cdDefeito) {
		this.cdDefeito = cdDefeito;
	}
	public String getDsDefeito() {
		return dsDefeito;
	}
	public void setDsDefeito(String dsDefeito) {
		this.dsDefeito = dsDefeito;
	}
	public ExpAcaoDTO getAcao() {
		return acao;
	}
	public void setAcao(ExpAcaoDTO acao) {
		this.acao = acao;
	}
	public long getId_passcau() {
		return id_passcau;
	}
	public void setId_passcau(long idPasscau) {
		id_passcau = idPasscau;
	}
	
	
		
}
