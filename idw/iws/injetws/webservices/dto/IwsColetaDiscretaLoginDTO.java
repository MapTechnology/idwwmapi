package injetws.webservices.dto;

import java.io.Serializable;
import java.util.Date;


public class IwsColetaDiscretaLoginDTO  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String idloginaberto;
	String idup;
	String cdusuario;
	Date  dthrlogin;
	Double msdthrlogin;
	String cdoperacao;
	
	public String getIdLoginAberto() {
		return idloginaberto;
	}
	public void setIdLoginAberto(String idloginaberto) {
		this.idloginaberto = idloginaberto;
	}
	public String getIdUP() {
		return idup;
	}
	public void setIdUP(String idup) {
		this.idup = idup;
	}
	public String getCdUsuario() {
		return cdusuario;
	}
	public void setCdUsuario(String cdusuario) {
		this.cdusuario = cdusuario;
	}
	public Date getDtHrLogin() {
		return dthrlogin;
	}
	public void setDtHrLogin(Date dthrLogin) {
		this.dthrlogin = dthrLogin;
	}
	public Double getMsDtHrLogin() {
		return msdthrlogin;
	}
	public void setMsDtHrLogin(Double msdthrLogin) {
		this.msdthrlogin = msdthrLogin;
	}
	public String getCdOperacao() {
		return cdoperacao;
	}
	public void setCdOperacao(String cdoperacao) {
		this.cdoperacao = cdoperacao;
	}
	
		
	
}