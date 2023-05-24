package idw.webservices.dto;

public class FiltroRelatorioUsuarioDTO {
	
	private String cdGrupo;
	private boolean ordenarUsuario;
	private Byte situacao;

	public boolean isOrdenarUsuario() {
		return ordenarUsuario;
	}
	public void setOrdenarUsuario(boolean ordenarUsuario) {
		this.ordenarUsuario = ordenarUsuario;
	}
	public Byte getSituacao() {
		return situacao;
	}
	public void setSituacao(Byte situacao) {
		this.situacao = situacao;
	}
	public String getCdGrupo() {
		return cdGrupo;
	}
	public void setCdGrupo(String cdGrupo) {
		this.cdGrupo = cdGrupo;
	}
	@Override
	public String toString() {
		
		String retorno;
		
		retorno = "FiltroRelatorioUsuarioDTO [";
		
		retorno += "cdGrupo=" + this.cdGrupo + ", " + 
				   "ordenarRefugo=" + this.ordenarUsuario + ", " +
				   "situacao=" + this.situacao + "]";
		
		return retorno;
		
		//return "FiltroRelatorioUsuarioDTO [cdGrupo=" + cdGrupo + ", ordenarUsuario=" + ordenarUsuario + ", situacao=" + situacao + "]";
	
	}
	
}
