package idw.webservices.dto;

import java.io.Serializable;

public class UsuarioCODTO implements Serializable {
	
	private static final long serialVersionUID = -521958984476534622L;
	
	private long idUsuario;
	private String matricula;
	private String apelido;
	private Boolean isAutorizado;
	private String dthrServidor;
	
	public String getDthrServidor() {
		return dthrServidor;
	}
	public void setDthrServidor(String dthrServidor) {
		this.dthrServidor = dthrServidor;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public Boolean getIsAutorizado() {
		return isAutorizado;
	}
	public void setIsAutorizado(Boolean isAutorizado) {
		this.isAutorizado = isAutorizado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioCODTO other = (UsuarioCODTO) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
}
