package idw.webservices.dto;

import idw.model.pojos.DwEstlocal;

public class DwEstlocalDTO {
	
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_CD_LOCAL_ESTOQUE_INVALIDO = 1;
	private int ERRO_LOCAL_ESTOQUE_JA_EXISTE = 2;
	private int ERRO_USUARIO_STATIVO_DESCONHECIDO = 3;
	private int ERRO_USUARIO_REVISAO_DESCONHECIDO = 4;
	private int ERRO_ESTOQUE_DESCONHECIDO = 5;
	private int ERRO_DESCONHECIDO = 6;
	private int ERRO_REATIVACAO_INDISPONIVEL = 7;
	
	private DwEstlocal dwEstlocal;
	private int resultadoEvento;
	private CamposEmUsoOmCfgDTO camposEmUsoOmCfg;
	
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}

	public void setEVENTO_BEM_SUCEDIDO(int eVENTO_BEM_SUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTO_BEM_SUCEDIDO;
	}
	
	public int getERRO_CD_LOCAL_ESTOQUE_INVALIDO() {
		return ERRO_CD_LOCAL_ESTOQUE_INVALIDO;
	}

	public void setERRO_CD_LOCAL_ESTOQUE_INVALIDO(int eRRO_CD_LOCAL_ESTOQUE_INVALIDO) {
		ERRO_CD_LOCAL_ESTOQUE_INVALIDO = eRRO_CD_LOCAL_ESTOQUE_INVALIDO;
	}
	
	public int getERRO_LOCAL_ESTOQUE_JA_EXISTE() {
		return ERRO_LOCAL_ESTOQUE_JA_EXISTE;
	}

	public void setERRO_LOCAL_ESTOQUE_JA_EXISTE(int eRRO_LOCAL_ESTOQUE_JA_EXISTE) {
		ERRO_LOCAL_ESTOQUE_JA_EXISTE = eRRO_LOCAL_ESTOQUE_JA_EXISTE;
	}

	public int getERRO_USUARIO_STATIVO_DESCONHECIDO() {
		return ERRO_USUARIO_STATIVO_DESCONHECIDO;
	}

	public void setERRO_USUARIO_STATIVO_DESCONHECIDO(
			int eRRO_USUARIO_STATIVO_DESCONHECIDO) {
		ERRO_USUARIO_STATIVO_DESCONHECIDO = eRRO_USUARIO_STATIVO_DESCONHECIDO;
	}

	public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
		return ERRO_USUARIO_REVISAO_DESCONHECIDO;
	}

	public void setERRO_USUARIO_REVISAO_DESCONHECIDO(
			int eRRO_USUARIO_REVISAO_DESCONHECIDO) {
		ERRO_USUARIO_REVISAO_DESCONHECIDO = eRRO_USUARIO_REVISAO_DESCONHECIDO;
	}

	public int getERRO_ESTOQUE_DESCONHECIDO() {
		return ERRO_ESTOQUE_DESCONHECIDO;
	}

	public void setERRO_ESTOQUE_DESCONHECIDO(int eRRO_ESTOQUE_DESCONHECIDO) {
		ERRO_ESTOQUE_DESCONHECIDO = eRRO_ESTOQUE_DESCONHECIDO;
	}

	public DwEstlocal getDwEstlocal() {
		return dwEstlocal;
	}

	public void setDwEstlocal(DwEstlocal dwEstlocal) {
		this.dwEstlocal = dwEstlocal;
	}

	public int getResultadoEvento() {
		return resultadoEvento;
	}

	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}

	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}

	public void setERRO_DESCONHECIDO(int eRRO_DESCONHECIDO) {
		ERRO_DESCONHECIDO = eRRO_DESCONHECIDO;
	}

	public int getERRO_REATIVACAO_INDISPONIVEL() {
		return ERRO_REATIVACAO_INDISPONIVEL;
	}

	public void setERRO_REATIVACAO_INDISPONIVEL(int eRRO_REATIVACAO_INDISPONIVEL) {
		ERRO_REATIVACAO_INDISPONIVEL = eRRO_REATIVACAO_INDISPONIVEL;
	}

	public CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg() {
		return camposEmUsoOmCfg;
	}

	public void setCamposEmUsoOmCfg(CamposEmUsoOmCfgDTO camposEmUsoOmCfg) {
		this.camposEmUsoOmCfg = camposEmUsoOmCfg;
	}
	
}