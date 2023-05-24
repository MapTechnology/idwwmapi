package ms.coleta.dto;

import java.util.Date;

public class SessaoUsuarioDTO {
	
	private String cdUsuario = "";
	private String dsNome = "";
	private Long idGrupoUsuario;
	private Date dthrILogin;
	
	public String getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(String cdUsuario) {
		this.cdUsuario = cdUsuario;
	}
	public String getDsNome() {
		return dsNome;
	}
	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}
	public Long getIdGrupoUsuario() {
		return idGrupoUsuario;
	}
	public void setIdGrupoUsuario(Long idGrupoUsuario) {
		this.idGrupoUsuario = idGrupoUsuario;
	}
	public Date getDthrILogin() {
		return dthrILogin;
	}
	public void setDthrILogin(Date dthrILogin) {
		this.dthrILogin = dthrILogin;
	}

}
