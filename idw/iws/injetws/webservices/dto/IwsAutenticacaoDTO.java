package injetws.webservices.dto;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class IwsAutenticacaoDTO implements Serializable{
	
	public static final int AVALIAR_OPERADOR = 0;
	public static final int AVALIAR_TECNICO = 1;
	public static final int AVALIAR_TECQUALIDADE = 2;
	public static final int AVALIAR_TEC_1 = 3;
	public static final int AVALIAR_TEC_2 = 4;
	public static final int AVALIAR_TEC_RESP = 5;
	public static final int AVALIAR_TEC_CIP = 6;

	public static int HabilitadoSemQuedaNaViradaDoTurno = 0;
	public static int HabilitadoComQuedaNaViradaDoTurno = 1;
	public static int LoginDesconhecido = 2;
	public static int SenhaInvalida = 3;
	public static int ModNaoHomolagadaParaORAP = 4;
	public static int ModNaoHomologadaParaOCT = 5;
	public static int Autorizado = 6;
	public static int NaoAutorizado = 7;

	private String idOperador;
	private String cdusuario;
	private Boolean isAutorizado;
	private Integer resultadoAutenticacao;
	private Date DtHrLogin;
	private String nomeOperador;
	
	
	public String getCdUsuario() {
		return cdusuario;
	}
	public void setCdUsuario(String cdusuario) {
		this.cdusuario = cdusuario;
	}
	public String getNomeOperador() {
		return nomeOperador;
	}
	public void setNomeOperador(String NomeOperador) {
		this.nomeOperador = NomeOperador;
	}
	public String getIdOperador() {
		return idOperador;
	}
	public void setIdOperador(String idOperador) {
		this.idOperador = idOperador;
	}
	public Boolean getIsAutorizado() {
		return isAutorizado;
	}
	public void setIsAutorizado(Boolean isAutorizado) {
		this.isAutorizado = isAutorizado;
	}
	public Integer getResultadoAutenticacao() {
		return resultadoAutenticacao;
	}
	public void setResultadoAutenticacao(Integer resultadoAutenticacao) {
		this.resultadoAutenticacao = resultadoAutenticacao;
	}
	/**
	 * @return the DtHrLogin
	 */
	public Date getDtHrLogin() {
		return DtHrLogin;
	}
	/**
	 * @param DtHrLogin the DtHrLogin to set
	 */
	public void setDtHrLogin(Date DtHrLogin) {
		this.DtHrLogin = DtHrLogin;
	}

/*	onde resultadoAutenticacao: 
			0 - Habilitado sem queda na virada do turno
			1 - Habilitado com queda na virada do turno
			2 - login desconhecido
			3 - Senha invalida
			4 - Operador/Tecnico não homolagado para o RAP
			5 - Operador/Tecnico nao homologado para o CT
			6 - Autorizado
			7 - Não autorizado
*/
	
}
