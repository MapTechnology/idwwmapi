package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjcfgmailcgqId generated by hbm2java
 */
@Embeddable
public class IjcfgmailcgqId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5892688476932601030L;
	private String emailorigem;
	private String assuntopadrao;
	private String mensagempadrao;
	private String smtpserver;
	private String smtpport;
	private String popserver;
	private String popport;
	private String loginautenticacao;
	private String senhaautenticacao;
	private BigDecimal timeoutprotocol;
	private BigDecimal timeoutconnect;

	public IjcfgmailcgqId() {
	}

	public IjcfgmailcgqId(String emailorigem, String smtpserver,
			BigDecimal timeoutprotocol, BigDecimal timeoutconnect) {
		this.emailorigem = emailorigem;
		this.smtpserver = smtpserver;
		this.timeoutprotocol = timeoutprotocol;
		this.timeoutconnect = timeoutconnect;
	}

	public IjcfgmailcgqId(String emailorigem, String assuntopadrao,
			String mensagempadrao, String smtpserver, String smtpport,
			String popserver, String popport, String loginautenticacao,
			String senhaautenticacao, BigDecimal timeoutprotocol,
			BigDecimal timeoutconnect) {
		this.emailorigem = emailorigem;
		this.assuntopadrao = assuntopadrao;
		this.mensagempadrao = mensagempadrao;
		this.smtpserver = smtpserver;
		this.smtpport = smtpport;
		this.popserver = popserver;
		this.popport = popport;
		this.loginautenticacao = loginautenticacao;
		this.senhaautenticacao = senhaautenticacao;
		this.timeoutprotocol = timeoutprotocol;
		this.timeoutconnect = timeoutconnect;
	}

	@Column(name = "EMAILORIGEM", nullable = false, length = 50)
	public String getEmailorigem() {
		return this.emailorigem;
	}

	public void setEmailorigem(String emailorigem) {
		this.emailorigem = emailorigem;
	}

	@Column(name = "ASSUNTOPADRAO", length = 100)
	public String getAssuntopadrao() {
		return this.assuntopadrao;
	}

	public void setAssuntopadrao(String assuntopadrao) {
		this.assuntopadrao = assuntopadrao;
	}

	@Column(name = "MENSAGEMPADRAO")
	public String getMensagempadrao() {
		return this.mensagempadrao;
	}

	public void setMensagempadrao(String mensagempadrao) {
		this.mensagempadrao = mensagempadrao;
	}

	@Column(name = "SMTPSERVER", nullable = false, length = 50)
	public String getSmtpserver() {
		return this.smtpserver;
	}

	public void setSmtpserver(String smtpserver) {
		this.smtpserver = smtpserver;
	}

	@Column(name = "SMTPPORT", length = 50)
	public String getSmtpport() {
		return this.smtpport;
	}

	public void setSmtpport(String smtpport) {
		this.smtpport = smtpport;
	}

	@Column(name = "POPSERVER", length = 50)
	public String getPopserver() {
		return this.popserver;
	}

	public void setPopserver(String popserver) {
		this.popserver = popserver;
	}

	@Column(name = "POPPORT", length = 50)
	public String getPopport() {
		return this.popport;
	}

	public void setPopport(String popport) {
		this.popport = popport;
	}

	@Column(name = "LOGINAUTENTICACAO", length = 50)
	public String getLoginautenticacao() {
		return this.loginautenticacao;
	}

	public void setLoginautenticacao(String loginautenticacao) {
		this.loginautenticacao = loginautenticacao;
	}

	@Column(name = "SENHAAUTENTICACAO", length = 50)
	public String getSenhaautenticacao() {
		return this.senhaautenticacao;
	}

	public void setSenhaautenticacao(String senhaautenticacao) {
		this.senhaautenticacao = senhaautenticacao;
	}

	@Column(name = "TIMEOUTPROTOCOL", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTimeoutprotocol() {
		return this.timeoutprotocol;
	}

	public void setTimeoutprotocol(BigDecimal timeoutprotocol) {
		this.timeoutprotocol = timeoutprotocol;
	}

	@Column(name = "TIMEOUTCONNECT", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTimeoutconnect() {
		return this.timeoutconnect;
	}

	public void setTimeoutconnect(BigDecimal timeoutconnect) {
		this.timeoutconnect = timeoutconnect;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjcfgmailcgqId))
			return false;
		IjcfgmailcgqId castOther = (IjcfgmailcgqId) other;

		return ((this.getEmailorigem() == castOther.getEmailorigem()) || (this
				.getEmailorigem() != null && castOther.getEmailorigem() != null && this
				.getEmailorigem().equals(castOther.getEmailorigem())))
				&& ((this.getAssuntopadrao() == castOther.getAssuntopadrao()) || (this
						.getAssuntopadrao() != null
						&& castOther.getAssuntopadrao() != null && this
						.getAssuntopadrao()
						.equals(castOther.getAssuntopadrao())))
				&& ((this.getMensagempadrao() == castOther.getMensagempadrao()) || (this
						.getMensagempadrao() != null
						&& castOther.getMensagempadrao() != null && this
						.getMensagempadrao().equals(
								castOther.getMensagempadrao())))
				&& ((this.getSmtpserver() == castOther.getSmtpserver()) || (this
						.getSmtpserver() != null
						&& castOther.getSmtpserver() != null && this
						.getSmtpserver().equals(castOther.getSmtpserver())))
				&& ((this.getSmtpport() == castOther.getSmtpport()) || (this
						.getSmtpport() != null
						&& castOther.getSmtpport() != null && this
						.getSmtpport().equals(castOther.getSmtpport())))
				&& ((this.getPopserver() == castOther.getPopserver()) || (this
						.getPopserver() != null
						&& castOther.getPopserver() != null && this
						.getPopserver().equals(castOther.getPopserver())))
				&& ((this.getPopport() == castOther.getPopport()) || (this
						.getPopport() != null && castOther.getPopport() != null && this
						.getPopport().equals(castOther.getPopport())))
				&& ((this.getLoginautenticacao() == castOther
						.getLoginautenticacao()) || (this
						.getLoginautenticacao() != null
						&& castOther.getLoginautenticacao() != null && this
						.getLoginautenticacao().equals(
								castOther.getLoginautenticacao())))
				&& ((this.getSenhaautenticacao() == castOther
						.getSenhaautenticacao()) || (this
						.getSenhaautenticacao() != null
						&& castOther.getSenhaautenticacao() != null && this
						.getSenhaautenticacao().equals(
								castOther.getSenhaautenticacao())))
				&& ((this.getTimeoutprotocol() == castOther
						.getTimeoutprotocol()) || (this.getTimeoutprotocol() != null
						&& castOther.getTimeoutprotocol() != null && this
						.getTimeoutprotocol().equals(
								castOther.getTimeoutprotocol())))
				&& ((this.getTimeoutconnect() == castOther.getTimeoutconnect()) || (this
						.getTimeoutconnect() != null
						&& castOther.getTimeoutconnect() != null && this
						.getTimeoutconnect().equals(
								castOther.getTimeoutconnect())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getEmailorigem() == null ? 0 : this.getEmailorigem()
						.hashCode());
		result = 37
				* result
				+ (getAssuntopadrao() == null ? 0 : this.getAssuntopadrao()
						.hashCode());
		result = 37
				* result
				+ (getMensagempadrao() == null ? 0 : this.getMensagempadrao()
						.hashCode());
		result = 37
				* result
				+ (getSmtpserver() == null ? 0 : this.getSmtpserver()
						.hashCode());
		result = 37 * result
				+ (getSmtpport() == null ? 0 : this.getSmtpport().hashCode());
		result = 37 * result
				+ (getPopserver() == null ? 0 : this.getPopserver().hashCode());
		result = 37 * result
				+ (getPopport() == null ? 0 : this.getPopport().hashCode());
		result = 37
				* result
				+ (getLoginautenticacao() == null ? 0 : this
						.getLoginautenticacao().hashCode());
		result = 37
				* result
				+ (getSenhaautenticacao() == null ? 0 : this
						.getSenhaautenticacao().hashCode());
		result = 37
				* result
				+ (getTimeoutprotocol() == null ? 0 : this.getTimeoutprotocol()
						.hashCode());
		result = 37
				* result
				+ (getTimeoutconnect() == null ? 0 : this.getTimeoutconnect()
						.hashCode());
		return result;
	}

}
