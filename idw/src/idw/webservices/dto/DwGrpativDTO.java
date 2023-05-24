package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.DwGrpativ;

@SuppressWarnings("serial")
public class DwGrpativDTO implements Serializable{
	
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_DESCONHECIDO = 1;
	private int ERRO_CD_JA_CADASTRADO = 2;
	private int resultadoEvento;
	
	private DwGrpativ dwGrpativ;
	private Integer ordem;
	
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}

	public void setEVENTO_BEM_SUCEDIDO(int eVENTO_BEM_SUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTO_BEM_SUCEDIDO;
	}

	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}

	public void setERRO_DESCONHECIDO(int eRRO_DESCONHECIDO) {
		ERRO_DESCONHECIDO = eRRO_DESCONHECIDO;
	}

	public int getERRO_CD_JA_CADASTRADO() {
		return ERRO_CD_JA_CADASTRADO;
	}

	public void setERRO_CD_JA_CADASTRADO(int eRRO_CD_JA_CADASTRADO) {
		ERRO_CD_JA_CADASTRADO = eRRO_CD_JA_CADASTRADO;
	}

	public int getResultadoEvento() {
		return resultadoEvento;
	}

	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}

	public DwGrpativ getDwGrpativ() {
		return dwGrpativ;
	}

	public void setDwGrpativ(DwGrpativ dwGrpativ) {
		this.dwGrpativ = dwGrpativ;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	
}