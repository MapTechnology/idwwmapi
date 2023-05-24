package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.OmPtcnc;

@SuppressWarnings("serial")
public class OmPtcncDTO implements Serializable{
	
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_PTCNC_JA_EXISTE = 1;
	private int ERRO_TIPOPOSTO_DESCONHECIDO = 2;	
	private int ERRO_CC_DESCONHECIDO = 3;
	private int ERRO_USUARIO_REVISAO_DESCONHECIDO = 4;
	private int ERRO_USUARIO_STATUS_DESCONHECIDO = 5;
	private int ERRO_DESCONHECIDO = 6;
	private int ERRO_CDPT_INVALIDO = 7;
	private int ERRO_REATIVACAO_INDISPONIVEL = 8;
	private int ERRO_GRUPOTRABALHO_DESCONHECIDO = 9;
	private int ERRO_TP_IMPPROG = 10;
	private int ERRO_PT_NAO_EXISTE = 11;
	private int ERRO_PT_JA_VINCULADO = 12;
	
	private OmPtcnc omPtcnc;
	private int resultadoEvento;
	
	public OmPtcnc getOmPtcnc() {
		return omPtcnc;
	}
	public void setOmPtcnc(OmPtcnc omPtcnc) {
		this.omPtcnc = omPtcnc;
	}
	public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}
	public void setEVENTO_BEM_SUCEDIDO(int eVENTO_BEM_SUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTO_BEM_SUCEDIDO;
	}

	public int getERRO_TIPOPOSTO_DESCONHECIDO() {
		return ERRO_TIPOPOSTO_DESCONHECIDO;
	}
	public void setERRO_TIPOPOSTO_DESCONHECIDO(int eRRO_TIPOPOSTO_DESCONHECIDO) {
		ERRO_TIPOPOSTO_DESCONHECIDO = eRRO_TIPOPOSTO_DESCONHECIDO;
	}
	public int getERRO_CC_DESCONHECIDO() {
		return ERRO_CC_DESCONHECIDO;
	}
	public void setERRO_CC_DESCONHECIDO(int eRRO_CC_DESCONHECIDO) {
		ERRO_CC_DESCONHECIDO = eRRO_CC_DESCONHECIDO;
	}
	public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
		return ERRO_USUARIO_REVISAO_DESCONHECIDO;
	}
	public void setERRO_USUARIO_REVISAO_DESCONHECIDO(
			int eRRO_USUARIO_REVISAO_DESCONHECIDO) {
		ERRO_USUARIO_REVISAO_DESCONHECIDO = eRRO_USUARIO_REVISAO_DESCONHECIDO;
	}
	public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
		return ERRO_USUARIO_STATUS_DESCONHECIDO;
	}
	public void setERRO_USUARIO_STATUS_DESCONHECIDO(
			int eRRO_USUARIO_STATUS_DESCONHECIDO) {
		ERRO_USUARIO_STATUS_DESCONHECIDO = eRRO_USUARIO_STATUS_DESCONHECIDO;
	}
	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}
	public void setERRO_DESCONHECIDO(int eRRO_DESCONHECIDO) {
		ERRO_DESCONHECIDO = eRRO_DESCONHECIDO;
	}
	public int getERRO_CDPT_INVALIDO() {
		return ERRO_CDPT_INVALIDO;
	}
	public void setERRO_CDPT_INVALIDO(int eRRO_CDPT_INVALIDO) {
		ERRO_CDPT_INVALIDO = eRRO_CDPT_INVALIDO;
	}
	public int getERRO_REATIVACAO_INDISPONIVEL() {
		return ERRO_REATIVACAO_INDISPONIVEL;
	}
	public void setERRO_REATIVACAO_INDISPONIVEL(int eRRO_REATIVACAO_INDISPONIVEL) {
		ERRO_REATIVACAO_INDISPONIVEL = eRRO_REATIVACAO_INDISPONIVEL;
	}
	public int getERRO_GRUPOTRABALHO_DESCONHECIDO() {
		return ERRO_GRUPOTRABALHO_DESCONHECIDO;
	}
	public void setERRO_GRUPOTRABALHO_DESCONHECIDO(
			int eRRO_GRUPOTRABALHO_DESCONHECIDO) {
		ERRO_GRUPOTRABALHO_DESCONHECIDO = eRRO_GRUPOTRABALHO_DESCONHECIDO;
	}
	public int getERRO_TP_IMPPROG() {
		return ERRO_TP_IMPPROG;
	}
	public void setERRO_TP_IMPPROG(int eRRO_TP_IMPPROG) {
		ERRO_TP_IMPPROG = eRRO_TP_IMPPROG;
	}
	public int getERRO_PTCNC_JA_EXISTE() {
		return ERRO_PTCNC_JA_EXISTE;
	}
	public void setERRO_PTCNC_JA_EXISTE(int eRRO_PTCNC_JA_EXISTE) {
		ERRO_PTCNC_JA_EXISTE = eRRO_PTCNC_JA_EXISTE;
	}
	public int getERRO_PT_NAO_EXISTE() {
		return ERRO_PT_NAO_EXISTE;
	}
	public void setERRO_PT_NAO_EXISTE(int eRRO_PTCNC_NAO_EXISTE) {
		ERRO_PT_NAO_EXISTE = eRRO_PTCNC_NAO_EXISTE;
	}
	public int getERRO_PT_JA_VINCULADO() {
		return ERRO_PT_JA_VINCULADO;
	}
	public void setERRO_PT_JA_VINCULADO(int pT_JA_VINCULADO) {
		ERRO_PT_JA_VINCULADO = pT_JA_VINCULADO;
	}
	
}
