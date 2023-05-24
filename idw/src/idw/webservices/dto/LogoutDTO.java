package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class LogoutDTO implements Serializable {
	
	private long idUsr;
	private String cdUsr; // crachá lido
	private Date dtHrFLogin; // data e hora do clp
	private long idPt;
	private long idGt;
	private BigDecimal segFeedbacklogin; // Tempo em segundos em que a luz de feed-back do login irá ficar acessa
	private BigDecimal segAutologout; // Tempo em segundos para o logout automático do operador quando nenhum teste estiver sendo realizado no posto. (Copiar atributo para a receita
	
	private ResultadoDTO resultado = new ResultadoDTO();
	
	
	public long getIdUsr() {
		return idUsr;
	}
	public void setIdUsr(long idUsr) {
		this.idUsr = idUsr;
	}

	public String getCdUsr() {
		return cdUsr;
	}
	public void setCdUsr(String cdUsr) {
		this.cdUsr = cdUsr;
	}

	public Date getDtHrFLogin() {
		return dtHrFLogin;
	}
	public void setDtHrFLogin(Date dtHrFLogin) {
		this.dtHrFLogin = dtHrFLogin;
	}

	public long getIdPt() {
		return idPt;
	}
	public void setIdPt(long idPt) {
		this.idPt = idPt;
	}

	public long getIdGt() {
		return idGt;
	}
	public void setIdGt(long idGt) {
		this.idGt = idGt;
	}

	public BigDecimal getSegFeedbacklogin() {
		return segFeedbacklogin;
	}
	public void setSegFeedbacklogin(BigDecimal segFeedbacklogin) {
		this.segFeedbacklogin = segFeedbacklogin;
	}

	public BigDecimal getSegAutologout() {
		return segAutologout;
	}
	public void setSegAutologout(BigDecimal segAutologout) {
		this.segAutologout = segAutologout;
	}

	
	public ResultadoDTO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}

}
