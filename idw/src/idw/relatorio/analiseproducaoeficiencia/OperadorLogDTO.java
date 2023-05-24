package idw.relatorio.analiseproducaoeficiencia;

import java.util.Date;

public class OperadorLogDTO {

	private String nome;
	private String loginFormatado;
	private String logoutFormatado;
	private Date login;
	private Date logout;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLoginFormatado() {
		return loginFormatado;
	}

	public void setLoginFormatado(String loginFormatado) {
		this.loginFormatado = loginFormatado;
	}

	public String getLogoutFormatado() {
		return logoutFormatado;
	}

	public void setLogoutFormatado(String logoutFormatado) {
		this.logoutFormatado = logoutFormatado;
	}

	public Date getLogin() {
		return login;
	}

	public void setLogin(Date login) {
		this.login = login;
	}

	public Date getLogout() {
		return logout;
	}

	public void setLogout(Date logout) {
		this.logout = logout;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((loginFormatado == null) ? 0 : loginFormatado.hashCode());
		result = prime * result + ((logout == null) ? 0 : logout.hashCode());
		result = prime * result + ((logoutFormatado == null) ? 0 : logoutFormatado.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		OperadorLogDTO other = (OperadorLogDTO) obj;
		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
			return false;
		}
		if (loginFormatado == null) {
			if (other.loginFormatado != null) {
				return false;
			}
		} else if (!loginFormatado.equals(other.loginFormatado)) {
			return false;
		}
		if (logout == null) {
			if (other.logout != null) {
				return false;
			}
		} else if (!logout.equals(other.logout)) {
			return false;
		}
		if (logoutFormatado == null) {
			if (other.logoutFormatado != null) {
				return false;
			}
		} else if (!logoutFormatado.equals(other.logoutFormatado)) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		return true;
	}

}
