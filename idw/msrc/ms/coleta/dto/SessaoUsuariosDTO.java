package ms.coleta.dto;

import java.util.List;

public class SessaoUsuariosDTO {
	private List<SessaoUsuarioDTO> listaUsuarios;
	private long maiorIdConsolmolog;
	public List<SessaoUsuarioDTO> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(List<SessaoUsuarioDTO> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	public long getMaiorIdConsolmolog() {
		return maiorIdConsolmolog;
	}
	public void setMaiorIdConsolmolog(long maiorIdConsolmolog) {
		this.maiorIdConsolmolog = maiorIdConsolmolog;
	}
}
