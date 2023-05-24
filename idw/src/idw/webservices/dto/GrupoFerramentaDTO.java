package idw.webservices.dto;

import javax.xml.bind.annotation.XmlRootElement;

import idw.model.pojos.DwGrupoFerramenta;

@XmlRootElement(name="grupoFerramentaDTO")
public class GrupoFerramentaDTO {
	
	private DwGrupoFerramenta dwGrupoFerramenta;
	
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_CD_INVALIDO = 1;
	private int ERRO_GP_FERRAMENTA_JA_EXISTE = 2;
	private int ERRO_USUARIO_STATUS_DESCONHECIDO = 3;
	private int ERRO_USUARIO_REVISAO_DESCONHECIDO = 4;
	private int ERRO_DESCONHECIDO = 5;
	private int ERRO_REATIVACAO_INDISPONIVEL = 7;
	
	private int resultadoEvento;
	
	public int getERRO_REATIVACAO_INDISPONIVEL() {
		return ERRO_REATIVACAO_INDISPONIVEL;
	}
	public void setERRO_REATIVACAO_INDISPONIVEL(int eRROREATIVACAOINDISPONIVEL) {
		ERRO_REATIVACAO_INDISPONIVEL = eRROREATIVACAOINDISPONIVEL;
	}
	
	
	public DwGrupoFerramenta getDwGrupoFerramenta() {
		return dwGrupoFerramenta;
	}
	public void setDwGrupoFerramenta(DwGrupoFerramenta dwGrupoFerramenta) {
		this.dwGrupoFerramenta = dwGrupoFerramenta;
	}
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}
	public void setEVENTO_BEM_SUCEDIDO(int eVENTO_BEM_SUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTO_BEM_SUCEDIDO;
	}
	public int getERRO_CD_INVALIDO() {
		return ERRO_CD_INVALIDO;
	}
	public void setERRO_CD_INVALIDO(int eRRO_CD_INVALIDO) {
		ERRO_CD_INVALIDO = eRRO_CD_INVALIDO;
	}
	public int getERRO_GP_FERRAMENTA_JA_EXISTE() {
		return ERRO_GP_FERRAMENTA_JA_EXISTE;
	}
	public void setERRO_GP_FERRAMENTA_JA_EXISTE(int eRRO_GP_FERRAMENTA_JA_EXISTE) {
		ERRO_GP_FERRAMENTA_JA_EXISTE = eRRO_GP_FERRAMENTA_JA_EXISTE;
	}
	public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
		return ERRO_USUARIO_STATUS_DESCONHECIDO;
	}
	public void setERRO_USUARIO_STATUS_DESCONHECIDO(
			int eRRO_USUARIO_STATUS_DESCONHECIDO) {
		ERRO_USUARIO_STATUS_DESCONHECIDO = eRRO_USUARIO_STATUS_DESCONHECIDO;
	}
	public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
		return ERRO_USUARIO_REVISAO_DESCONHECIDO;
	}
	public void setERRO_USUARIO_REVISAO_DESCONHECIDO(
			int eRRO_USUARIO_REVISAO_DESCONHECIDO) {
		ERRO_USUARIO_REVISAO_DESCONHECIDO = eRRO_USUARIO_REVISAO_DESCONHECIDO;
	}
	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}
	public void setERRO_DESCONHECIDO(int eRRO_DESCONHECIDO) {
		ERRO_DESCONHECIDO = eRRO_DESCONHECIDO;
	}
	public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}

}