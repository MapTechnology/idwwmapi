package ms.coleta.dto;

import java.util.Date;

public class SessaoVarRitmoDTO {
	private long idConsolRitmolog;
	private long idTRitmo;
	private String cdVarRitmo = "";
	private String dsVarRitmo = "";
	private Date dthrIVarRitmo;
	private Date dthrFVarRitmo;
	private boolean isVarRitmoAberto;
	private float duracao;
	
	public String getCdVarRitmo() {
		return cdVarRitmo;
	}
	public void setCdVarRitmo(String cdVarRitmo) {
		this.cdVarRitmo = cdVarRitmo;
	}
	public String getDsVarRitmo() {
		return dsVarRitmo;
	}
	public void setDsVarRitmo(String dsVarRitmo) {
		this.dsVarRitmo = dsVarRitmo;
	}
	public Date getDthrIVarRitmo() {
		return dthrIVarRitmo;
	}
	public void setDthrIVarRitmo(Date dthrIVarRitmo) {
		this.dthrIVarRitmo = dthrIVarRitmo;
	}
	public Date getDthrFVarRitmo() {
		return dthrFVarRitmo;
	}
	public void setDthrFVarRitmo(Date dthrFVarRitmo) {
		this.dthrFVarRitmo = dthrFVarRitmo;
	}
	public boolean isVarRitmoAberto() {
		return isVarRitmoAberto;
	}
	public void setVarRitmoAberto(boolean isVarRitmoAberto) {
		this.isVarRitmoAberto = isVarRitmoAberto;
	}
	public float getDuracao() {
		return duracao;
	}
	public void setDuracao(float duracao) {
		this.duracao = duracao;
	}
	public long getIdConsolRitmolog() {
		return idConsolRitmolog;
	}
	public void setIdConsolRitmolog(long idConsolRitmolog) {
		this.idConsolRitmolog = idConsolRitmolog;
	}
	public long getIdTRitmo() {
		return idTRitmo;
	}
	public void setIdTRitmo(long idTRitmo) {
		this.idTRitmo = idTRitmo;
	}
}
