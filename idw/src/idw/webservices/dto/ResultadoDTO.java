package idw.webservices.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@SuppressWarnings("serial")
public class ResultadoDTO implements Serializable {

	public final int ERRO_DESCONHECIDO = 0;
	public final int COM_SUCESSO = 1;
	public final int SEM_CONFIGURACAO = 2;
	public final int PT_DESCONHECIDO = 3;
	public final int TIPO_PT_DESCONHECIDO = 4;
	public final int USUARIO_DESCONHECIDO = 5;
	public final int LOGIN_NAO_HOMOLOGADO = 6;
	public final int LOGIN_GT_COM_SUCESSO = 7;
	public final int LOGIN_GT_PRE_EXISTENTE = 8;
	public final int LOGIN_PT_PRE_EXISTENTE = 9;
	public final int LOGIN_PT_COM_SUCESSO = 10;
	public final int SUPERVISOR_NAO_LOGADO = 11;
	public final int OUTRO_SUPERVISOR_LOGADO = 12;
	public final int LOGOUT_GT_COM_SUCESSO = 13;
	public final int OPERADOR_NAO_LOGADO = 14;
	public final int OUTRO_OPERADOR_LOGADO = 15;
	public final int LOGOUT_PT_COM_SUCESSO = 16;
	public final int PRODUTO_DESCONHECIDO = 17;
	public final int LOGON_DE_SUPERVISOR = 18;
	public final int LOGOFF_DE_SUPERVISOR = 19;
	public final int LOGON_DE_OPERADOR = 20;
	public final int LOGOFF_DE_OPERADOR = 21;
	public final int RE_NAO_AUTORIZADO = 22;
	public final int PRODUTO_NAO_DEVE_PASSAR_POR_POSTO = 23;
	public final int ROTEIRO_INCONSISTENTE = 24;
	public final int PRODUTO_ENTROU_NAO_CONFORME = 25;
	public final int DEFEITO_DESCONHECIDO = 26;
	public final int PRODUTO_NAO_ACEITO = 27;
	public final int ACOPLAMENTO_FINALIZADO = 28;
	public final int SEM_SGBD = 29;
	public final int ERROR_SEM_CALENDARIO = 30;
	public final int ERROR_GT_DESCONHECIDO = 31;
	public final int ACAO_DESCONHECIDA = 32;
	public final int CB_NULO = 33;
	public final int COMPONENTE_NAO_PERTENCE_AO_PRODUTO = 34;
	public final int CONFIGURACAO_DESCONHECIDA = 35;
	public final int ERRO_CONFIGURACAO_SENDO_USADA = 36;
	public final int ERRO_PEPRO_DESCONHECIDO = 37;
	public final int ERRO_CC_DESCONHECIDO = 38;
	public final int COMPONENTE_DESCONHECIDO = 39;
	public final int LOGIN_MANUTENCAO = 40;
	public final int LOGIN_AFERICAO = 41;
	public final int ERRO_EXCLUI_STATIVO_ZERO = 42;
	public final int CODIGO_DESCONHECIDO = 43;
	public final int PLANO_DESCONHECIDO = 44;
	public final int REGISTRO_JA_EXISTE = 45;
	public final int IMP_CLIENTE_DESCONHECIDO = 46;
	public final int IMP_PRODUTO_DESCONHECIDO = 47;
	public final int IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A = 48;
	public final int IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA = 49;
	public final int IMP_MES_DESCONHECIDO = 50;
	public final int IMP_ANO_DESCONHECIDO = 51;
	public final int IMP_DATA_INVALIDA = 52;
	public final int IMP_PPNECIMPURL_DESCONHECIDO = 53;
	public final int NECIMP_DESCONHECIDO = 54;
	public final int CALENDARIO_DESCONHECIDO = 55;
	public final int TIPO_PLANO_DESCONHECIDO = 56;
	public final int NECESSIDADE_DESCONHECIDA = 57;
	public final int CP_DESCONHECIDA = 58;
	public final int RAP_DESCONHECIDO = 59;
	public final int ERROR_PLANO_JA_FIRMADO = 60;
	public final int ERROR_PLANO_MUITO_ANTIGO = 61;
	public final int ERROR_PLANO_SEM_CP = 62;
	public final int ERROR_CICLO_PADRAO = 63;
	public final int ERRO_PARADA_DESCONHECIDA = 64;
	public final int EST_LOCAL_DESCONHECIDO = 65;
	public final int ESTOQUE_DESCONHECIDO = 66;
	public final int ERRO_RES_GUI_DESCONHECIDO = 67;
	public final int TIPO_GT_DESCONHECIDO = 68;
	public final int GRP_USUARIO_DESCONHECIDO = 69;
	public final int FT_PARAM_DESCONHECIDO = 70;
	public final int OP_COM_PRODUCAO = 71;
	public final int REFUGO_DESCONHECIDO = 72;
	public final int QTD_TEC_INVALIDA = 73;
	public final int ALERTA_TIPO_INVALIDO = 74;
	public final int PARADA_TIPO_INVALIDO = 75;
	public final int TIMEOUT_INVALIDO = 76;
	public final int CLASSIFICACAOABC_INVALIDO = 77;
	public final int RITMO_INVALIDO = 78;
	public final int EMPRESA_INVALIDA = 79;
	public final int CODIGO_EM_USO = 80;

	public final int PRODUTO_ACABADO_INVALIDO = 81;
	public final int PRODUTO_SEMI_ACABADO_INVALIDO = 82;
	public final int ALGORITMO_BALANCEAMENTO_INVALIDO = 83;
	public final int STATUS_BALANCEAMENTO_INVALIDO = 84;

	// 20160926FVA:
	public final int ERRO_REATIVACAO_INDISPONIVEL = 85;
	public final int ERRO_REGISTRO_DESCONHECIDO = 86;
	public final int FOLHA_DESCONHECIDA = 87;
	public final int ERRO_CODIGO_EM_USO_NA_COFIGURACAO_GERAL = 88;
	public final int ERRO_CC_VAZIO= 89;
	
	public final int FORA_FAIXA = 90;
	public final int SEM_MAC_DISPONIVEL = 91;
	
	public final int ORIGEM_DESCONHECIDA = 92;
	public final int FORA_LIMITE = 93;

	private int idmensagem;
	private String complemento;
	
	public int getERRO_REATIVACAO_INDISPONIVEL() {
		return ERRO_REATIVACAO_INDISPONIVEL;
	}

	public int getRAP_DESCONHECIDO() {
		return RAP_DESCONHECIDO;
	}

	public int getERRO_EXCLUI_STATIVO_ZERO() {
		return ERRO_EXCLUI_STATIVO_ZERO;
	}

	public int getLOGIN_MANUTENCAO() {
		return LOGIN_MANUTENCAO;
	}

	public int getLOGIN_AFERICAO() {
		return LOGIN_AFERICAO;
	}

	public int getCOMPONENTE_DESCONHECIDO() {
		return COMPONENTE_DESCONHECIDO;
	}

	public int getERRO_CONFIGURACAO_SENDO_USADA() {
		return ERRO_CONFIGURACAO_SENDO_USADA;
	}

	public int getCONFIGURACAO_DESCONHECIDA() {
		return CONFIGURACAO_DESCONHECIDA;
	}

	public int getCOMPONENTE_NAO_PERTENCE_AO_PRODUTO() {
		return COMPONENTE_NAO_PERTENCE_AO_PRODUTO;
	}

	public int getCB_NULO() {
		return CB_NULO;
	}

	public int getACAO_DESCONHECIDA() {
		return ACAO_DESCONHECIDA;
	}

	public int getERROR_GT_DESCONHECIDO() {
		return ERROR_GT_DESCONHECIDO;
	}

	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}

	public int getCOM_SUCESSO() {
		return COM_SUCESSO;
	}

	public int getSEM_CONFIGURACAO() {
		return SEM_CONFIGURACAO;
	}

	public int getPT_DESCONHECIDO() {
		return PT_DESCONHECIDO;
	}

	public int getTIPO_PT_DESCONHECIDO() {
		return TIPO_PT_DESCONHECIDO;
	}

	public int getUSUARIO_DESCONHECIDO() {
		return USUARIO_DESCONHECIDO;
	}

	public int getLOGIN_NAO_HOMOLOGADO() {
		return LOGIN_NAO_HOMOLOGADO;
	}

	public int getLOGIN_GT_COM_SUCESSO() {
		return LOGIN_GT_COM_SUCESSO;
	}

	public int getLOGIN_GT_PRE_EXISTENTE() {
		return LOGIN_GT_PRE_EXISTENTE;
	}

	public int getLOGIN_PT_PRE_EXISTENTE() {
		return LOGIN_PT_PRE_EXISTENTE;
	}

	public int getLOGIN_PT_COM_SUCESSO() {
		return LOGIN_PT_COM_SUCESSO;
	}

	public int getSUPERVISOR_NAO_LOGADO() {
		return SUPERVISOR_NAO_LOGADO;
	}

	public int getOUTRO_SUPERVISOR_LOGADO() {
		return OUTRO_SUPERVISOR_LOGADO;
	}

	public int getLOGOUT_GT_COM_SUCESSO() {
		return LOGOUT_GT_COM_SUCESSO;
	}

	public int getOPERADOR_NAO_LOGADO() {
		return OPERADOR_NAO_LOGADO;
	}

	public int getOUTRO_OPERADOR_LOGADO() {
		return OUTRO_OPERADOR_LOGADO;
	}

	public int getLOGOUT_PT_COM_SUCESSO() {
		return LOGOUT_PT_COM_SUCESSO;
	}

	public int getPRODUTO_DESCONHECIDO() {
		return PRODUTO_DESCONHECIDO;
	}

	public int getLOGON_DE_SUPERVISOR() {
		return LOGON_DE_SUPERVISOR;
	}

	public int getLOGOFF_DE_SUPERVISOR() {
		return LOGOFF_DE_SUPERVISOR;
	}

	public int getLOGON_DE_OPERADOR() {
		return LOGON_DE_OPERADOR;
	}

	public int getLOGOFF_DE_OPERADOR() {
		return LOGOFF_DE_OPERADOR;
	}

	public int getRE_NAO_AUTORIZADO() {
		return RE_NAO_AUTORIZADO;
	}

	public int getPRODUTO_NAO_DEVE_PASSAR_POR_POSTO() {
		return PRODUTO_NAO_DEVE_PASSAR_POR_POSTO;
	}

	public int getROTEIRO_INCONSISTENTE() {
		return ROTEIRO_INCONSISTENTE;
	}

	public int getPRODUTO_ENTROU_NAO_CONFORME() {
		return PRODUTO_ENTROU_NAO_CONFORME;
	}

	public int getDEFEITO_DESCONHECIDO() {
		return DEFEITO_DESCONHECIDO;
	}

	public int getPRODUTO_NAO_ACEITO() {
		return this.PRODUTO_NAO_ACEITO;
	}

	public int getACOPLAMENTO_FINALIZADO() {
		return ACOPLAMENTO_FINALIZADO;
	}

	public int getSEM_SGBD() {
		return SEM_SGBD;
	}

	public int getERROR_SEM_CALENDARIO() {
		return ERROR_SEM_CALENDARIO;
	}

	public int getIdmensagem() {
		return idmensagem;
	}

	public void setIdmensagem(int idmensagem) {
		this.idmensagem = idmensagem;
	}

	public int getERRO_PEPRO_DESCONHECIDO() {
		return ERRO_PEPRO_DESCONHECIDO;
	}

	public int getERRO_CC_DESCONHECIDO() {
		return ERRO_CC_DESCONHECIDO;
	}

	public int getCODIGO_DESCONHECIDO() {
		return CODIGO_DESCONHECIDO;
	}

	public boolean isComSucesso() {
		return (idmensagem == COM_SUCESSO);
	}

	public int getPLANO_DESCONHECIDO() {
		return PLANO_DESCONHECIDO;
	}

	public int getREGISTRO_JA_EXISTE() {
		return REGISTRO_JA_EXISTE;
	}

	public int getIMP_CLIENTE_DESCONHECIDO() {
		return IMP_CLIENTE_DESCONHECIDO;
	}

	public int getIMP_PRODUTO_DESCONHECIDO() {
		return IMP_PRODUTO_DESCONHECIDO;
	}

	public int getIMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A() {
		return IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A;
	}

	public int getIMP_NAO_EXISTE_QUANTIDADE_PLANEJADA() {
		return IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA;
	}

	public int getIMP_MES_DESCONHECIDO() {
		return IMP_MES_DESCONHECIDO;
	}

	public int getIMP_ANO_DESCONHECIDO() {
		return IMP_ANO_DESCONHECIDO;
	}

	public int getIMP_DATA_INVALIDA() {
		return IMP_DATA_INVALIDA;
	}

	public int getIMP_PPNECIMPURL_DESCONHECIDO() {
		return IMP_PPNECIMPURL_DESCONHECIDO;
	}

	public int getNECIMP_DESCONHECIDO() {
		return NECIMP_DESCONHECIDO;
	}

	public int getCALENDARIO_DESCONHECIDO() {
		return CALENDARIO_DESCONHECIDO;
	}

	public int getTIPO_PLANO_DESCONHECIDO() {
		return TIPO_PLANO_DESCONHECIDO;
	}

	public int getNECESSIDADE_DESCONHECIDA() {
		return NECESSIDADE_DESCONHECIDA;
	}

	public int getCP_DESCONHECIDA() {
		return CP_DESCONHECIDA;
	}

	public int getERROR_CICLO_PADRAO() {
		return ERROR_CICLO_PADRAO;
	}

	public int getERROR_PLANO_JA_FIRMADO() {
		return ERROR_PLANO_JA_FIRMADO;
	}

	public int getERROR_PLANO_MUITO_ANTIGO() {
		return ERROR_PLANO_MUITO_ANTIGO;
	}

	public int getERROR_PLANO_SEM_CP() {
		return ERROR_PLANO_SEM_CP;
	}

	public int getERRO_PARADA_DESCONHECIDA() {
		return ERRO_PARADA_DESCONHECIDA;
	}

	public int getEST_LOCAL_DESCONHECIDO() {
		return EST_LOCAL_DESCONHECIDO;
	}

	public int getESTOQUE_DESCONHECIDO() {
		return ESTOQUE_DESCONHECIDO;
	}

	public int getERRO_RES_GUI_DESCONHECIDO() {
		return ERRO_RES_GUI_DESCONHECIDO;
	}

	public int getTIPO_GT_DESCONHECIDO() {
		return TIPO_GT_DESCONHECIDO;
	}

	public int getGRP_USUARIO_DESCONHECIDO() {
		return GRP_USUARIO_DESCONHECIDO;
	}

	public int getFT_PARAM_DESCONHECIDO() {
		return FT_PARAM_DESCONHECIDO;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getOP_COM_PRODUCAO() {
		return OP_COM_PRODUCAO;
	}

	public int getREFUGO_DESCONHECIDO() {
		return REFUGO_DESCONHECIDO;
	}

	public int getALERTA_TIPO_INVALIDO() {
		return ALERTA_TIPO_INVALIDO;
	}

	public int getPARADA_TIPO_INVALIDO() {
		return PARADA_TIPO_INVALIDO;
	}

	public int getTIMEOUT_INVALIDO() {
		return TIMEOUT_INVALIDO;
	}

	public int getCLASSIFICACAOABC_INVALIDO() {
		return CLASSIFICACAOABC_INVALIDO;
	}

	public int getRITMO_INVALIDO() {
		return RITMO_INVALIDO;
	}

	public int getEMPRESA_INVALIDA() {
		return EMPRESA_INVALIDA;
	}

	public int getCODIGO_EM_USO() {
		return CODIGO_EM_USO;
	}

	public int getPRODUTO_ACABADO_INVALIDO() {
		return PRODUTO_ACABADO_INVALIDO;
	}

	public int getPRODUTO_SEMI_ACABADO_INVALIDO() {
		return PRODUTO_SEMI_ACABADO_INVALIDO;
	}

	public int getALGORITMO_BALANCEAMENTO_INVALIDO() {
		return ALGORITMO_BALANCEAMENTO_INVALIDO;
	}

	public int getSTATUS_BALANCEAMENTO_INVALIDO() {
		return STATUS_BALANCEAMENTO_INVALIDO;
	}

	public int getERRO_REGISTRO_DESCONHECIDO() {
		return ERRO_REGISTRO_DESCONHECIDO;
	}

	public int getFOLHA_DESCONHECIDA() {
		return FOLHA_DESCONHECIDA;
	}

	public int getERRO_CODIGO_EM_USO_NA_COFIGURACAO_GERAL() {
		return ERRO_CODIGO_EM_USO_NA_COFIGURACAO_GERAL;
	}

	public int getERRO_CC_VAZIO() {
		return ERRO_CC_VAZIO;
	}

	public String getDescricaoMensagem() {
		switch (idmensagem) {
		case (0): {
			return "ERRO_DESCONHECIDO";
		}
		case (1): {
			return "COM_SUCESSO";
		}
		case (2): {
			return "SEM_CONFIGURACAO";
		}
		case (3): {
			return "PT_DESCONHECIDO";
		}
		case (4): {
			return "TIPO_PT_DESCONHECIDO";
		}
		case (5): {
			return "USUARIO_DESCONHECIDO";
		}
		case (6): {
			return "LOGIN_NAO_HOMOLOGADO";
		}
		case (7): {
			return "LOGIN_GT_COM_SUCESSO";
		}
		case (8): {
			return "LOGIN_GT_PRE_EXISTENTE";
		}
		case (9): {
			return "LOGIN_PT_PRE_EXISTENTE";
		}
		case (10): {
			return "LOGIN_PT_COM_SUCESSO";
		}
		case (11): {
			return "SUPERVISOR_NAO_LOGADO";
		}
		case (12): {
			return "OUTRO_SUPERVISOR_LOGADO";
		}
		case (13): {
			return "LOGOUT_GT_COM_SUCESSO";
		}
		case (14): {
			return "OPERADOR_NAO_LOGADO";
		}
		case (15): {
			return "OUTRO_OPERADOR_LOGADO";
		}
		case (16): {
			return "LOGOUT_PT_COM_SUCESSO";
		}
		case (17): {
			return "PRODUTO_DESCONHECIDO";
		}
		case (18): {
			return "LOGON_DE_SUPERVISOR";
		}
		case (19): {
			return "LOGOFF_DE_SUPERVISOR";
		}
		case (20): {
			return "LOGON_DE_OPERADOR";
		}
		case (21): {
			return "LOGOFF_DE_OPERADOR";
		}
		case (22): {
			return "RE_NAO_AUTORIZADO";
		}
		case (23): {
			return "PRODUTO_NAO_DEVE_PASSAR_POR_POSTO";
		}
		case (24): {
			return "ROTEIRO_INCONSISTENTE";
		}
		case (25): {
			return "PRODUTO_ENTROU_NAO_CONFORME";
		}
		case (26): {
			return "DEFEITO_DESCONHECIDO";
		}
		case (27): {
			return "PRODUTO_NAO_ACEITO";
		}
		case (28): {
			return "ACOPLAMENTO_FINALIZADO";
		}
		case (29): {
			return "SEM_SGBD";
		}
		case (30): {
			return "ERROR_SEM_CALENDARIO";
		}
		case (31): {
			return "ERROR_GT_DESCONHECIDO";
		}
		case (32): {
			return "ACAO_DESCONHECIDA";
		}
		case (33): {
			return "CB_NULO";
		}
		case (34): {
			return "COMPONENTE_NAO_PERTENCE_AO_PRODUTO";
		}
		case (35): {
			return "CONFIGURACAO_DESCONHECIDA";
		}
		case (36): {
			return "ERRO_CONFIGURACAO_SENDO_USADA";
		}
		case (37): {
			return "ERRO_PEPRO_DESCONHECIDO";
		}
		case (38): {
			return "ERRO_CC_DESCONHECIDO";
		}
		case (39): {
			return "COMPONENTE_DESCONHECIDO";
		}
		case (40): {
			return "LOGIN_MANUTENCAO";
		}
		case (41): {
			return "LOGIN_AFERICAO";
		}
		case (42): {
			return "ERRO_EXCLUI_STATIVO_ZERO";
		}
		case (43): {
			return "CODIGO_DESCONHECIDO";
		}
		case (44): {
			return "PLANO_DESCONHECIDO";
		}
		case (45): {
			return "REGISTRO_JA_EXISTE";
		}
		case (46): {
			return "IMP_CLIENTE_DESCONHECIDO";
		}
		case (47): {
			return "IMP_PRODUTO_DESCONHECIDO";
		}
		case (48): {
			return "IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A";
		}
		case (49): {
			return "IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA";
		}
		case (50): {
			return "IMP_MES_DESCONHECIDO";
		}
		case (51): {
			return "IMP_ANO_DESCONHECIDO";
		}
		case (52): {
			return "IMP_DATA_INVALIDA";
		}
		case (53): {
			return "IMP_PPNECIMPURL_DESCONHECIDO";
		}
		case (54): {
			return "NECIMP_DESCONHECIDO";
		}
		case (55): {
			return "CALENDARIO_DESCONHECIDO";
		}
		case (56): {
			return "TIPO_PLANO_DESCONHECIDO";
		}
		case (57): {
			return "NECESSIDADE_DESCONHECIDA";
		}
		case (58): {
			return "CP_DESCONHECIDA";
		}
		case (59): {
			return "RAP_DESCONHECIDO";
		}
		case (60): {
			return "ERROR_PLANO_JA_FIRMADO";
		}
		case (61): {
			return "ERROR_PLANO_MUITO_ANTIGO";
		}
		case (62): {
			return "ERROR_PLANO_SEM_CP";
		}
		case (63): {
			return "ERROR_CICLO_PADRAO";
		}
		case (64): {
			return "ERRO_PARADA_DESCONHECIDA";
		}
		case (65): {
			return "EST_LOCAL_DESCONHECIDO";
		}
		case (66): {
			return "ESTOQUE_DESCONHECIDO";
		}
		case (67): {
			return "ERRO_RES_GUI_DESCONHECIDO";
		}
		case (68): {
			return "TIPO_GT_DESCONHECIDO";
		}
		case (69): {
			return "GRP_USUARIO_DESCONHECIDO";
		}
		case (70): {
			return "FT_PARAM_DESCONHECIDO";
		}
		case (71): {
			return "OP_COM_PRODUCAO";
		}
		case (72): {
			return "REFUGO_DESCONHECIDO";
		}
		case (73): {
			return "QTD_TEC_INVALIDA";
		}
		case (74): {
			return "ALERTA_TIPO_INVALIDO";
		}
		case (75): {
			return "PARADA_TIPO_INVALIDO";
		}
		case (76): {
			return "TIMEOUT_INVALIDO";
		}
		case (77): {
			return "CLASSIFICACAOABC_INVALIDO";
		}
		case (78): {
			return "RITMO_INVALIDO";
		}
		case (79): {
			return "EMPRESA_INVALIDA";
		}
		case (80): {
			return "CODIGO_EM_USO";
		}
		case (81): {
			return "PRODUTO_ACABADO_INVALIDO";
		}
		case (82): {
			return "PRODUTO_SEMI_ACABADO_INVALIDO";
		}
		case (83): {
			return "ALGORITMO_BALANCEAMENTO_INVALIDO";
		}
		case (84): {
			return "STATUS_BALANCEAMENTO_INVALIDO";

		}
		case (85): {
			return "ERRO_REATIVACAO_INDISPONIVEL";

		}
		case (86): {
			return "ERRO_REGISTRO_DESCONHECIDO";

		}
		case (87): {
			return "FOLHA_DESCONHECIDA";

		}
		case (88): {
			return "ERRO_CODIGO_EM_USO_NA_COFIGURACAO_GERAL";
		}
		case (89): {
			return "ERRO_CC_VAZIO";
		}
		case (92): {
			return "ORIGEM_DESCONHECIDA";
		}
		}
		return "desconhecido";
	}

	public int getFORA_FAIXA() {
		return FORA_FAIXA;
	}

	public int getSEM_MAC_DISPONIVEL() {
		return SEM_MAC_DISPONIVEL;
	}
	
	public int getORIGEM_DESCONHECIDA() {
		return ORIGEM_DESCONHECIDA;
	}

	@Override
	public String toString() {
		return "ResultadoDTO [ERRO_DESCONHECIDO=" + ERRO_DESCONHECIDO + ", COM_SUCESSO=" + COM_SUCESSO + ", SEM_CONFIGURACAO="
				+ SEM_CONFIGURACAO + ", PT_DESCONHECIDO=" + PT_DESCONHECIDO + ", TIPO_PT_DESCONHECIDO=" + TIPO_PT_DESCONHECIDO
				+ ", USUARIO_DESCONHECIDO=" + USUARIO_DESCONHECIDO + ", LOGIN_NAO_HOMOLOGADO=" + LOGIN_NAO_HOMOLOGADO
				+ ", LOGIN_GT_COM_SUCESSO=" + LOGIN_GT_COM_SUCESSO + ", LOGIN_GT_PRE_EXISTENTE=" + LOGIN_GT_PRE_EXISTENTE
				+ ", LOGIN_PT_PRE_EXISTENTE=" + LOGIN_PT_PRE_EXISTENTE + ", LOGIN_PT_COM_SUCESSO=" + LOGIN_PT_COM_SUCESSO
				+ ", SUPERVISOR_NAO_LOGADO=" + SUPERVISOR_NAO_LOGADO + ", OUTRO_SUPERVISOR_LOGADO=" + OUTRO_SUPERVISOR_LOGADO
				+ ", LOGOUT_GT_COM_SUCESSO=" + LOGOUT_GT_COM_SUCESSO + ", OPERADOR_NAO_LOGADO=" + OPERADOR_NAO_LOGADO
				+ ", OUTRO_OPERADOR_LOGADO=" + OUTRO_OPERADOR_LOGADO + ", LOGOUT_PT_COM_SUCESSO=" + LOGOUT_PT_COM_SUCESSO
				+ ", PRODUTO_DESCONHECIDO=" + PRODUTO_DESCONHECIDO + ", LOGON_DE_SUPERVISOR=" + LOGON_DE_SUPERVISOR
				+ ", LOGOFF_DE_SUPERVISOR=" + LOGOFF_DE_SUPERVISOR + ", LOGON_DE_OPERADOR=" + LOGON_DE_OPERADOR + ", LOGOFF_DE_OPERADOR="
				+ LOGOFF_DE_OPERADOR + ", RE_NAO_AUTORIZADO=" + RE_NAO_AUTORIZADO + ", PRODUTO_NAO_DEVE_PASSAR_POR_POSTO="
				+ PRODUTO_NAO_DEVE_PASSAR_POR_POSTO + ", ROTEIRO_INCONSISTENTE=" + ROTEIRO_INCONSISTENTE + ", PRODUTO_ENTROU_NAO_CONFORME="
				+ PRODUTO_ENTROU_NAO_CONFORME + ", DEFEITO_DESCONHECIDO=" + DEFEITO_DESCONHECIDO + ", PRODUTO_NAO_ACEITO="
				+ PRODUTO_NAO_ACEITO + ", ACOPLAMENTO_FINALIZADO=" + ACOPLAMENTO_FINALIZADO + ", SEM_SGBD=" + SEM_SGBD
				+ ", ERROR_SEM_CALENDARIO=" + ERROR_SEM_CALENDARIO + ", ERROR_GT_DESCONHECIDO=" + ERROR_GT_DESCONHECIDO
				+ ", ACAO_DESCONHECIDA=" + ACAO_DESCONHECIDA + ", CB_NULO=" + CB_NULO + ", COMPONENTE_NAO_PERTENCE_AO_PRODUTO="
				+ COMPONENTE_NAO_PERTENCE_AO_PRODUTO + ", CONFIGURACAO_DESCONHECIDA=" + CONFIGURACAO_DESCONHECIDA
				+ ", ERRO_CONFIGURACAO_SENDO_USADA=" + ERRO_CONFIGURACAO_SENDO_USADA + ", ERRO_PEPRO_DESCONHECIDO="
				+ ERRO_PEPRO_DESCONHECIDO + ", ERRO_CC_DESCONHECIDO=" + ERRO_CC_DESCONHECIDO + ", COMPONENTE_DESCONHECIDO="
				+ COMPONENTE_DESCONHECIDO + ", LOGIN_MANUTENCAO=" + LOGIN_MANUTENCAO + ", LOGIN_AFERICAO=" + LOGIN_AFERICAO
				+ ", ERRO_EXCLUI_STATIVO_ZERO=" + ERRO_EXCLUI_STATIVO_ZERO + ", CODIGO_DESCONHECIDO=" + CODIGO_DESCONHECIDO
				+ ", PLANO_DESCONHECIDO=" + PLANO_DESCONHECIDO + ", REGISTRO_JA_EXISTE=" + REGISTRO_JA_EXISTE
				+ ", IMP_CLIENTE_DESCONHECIDO=" + IMP_CLIENTE_DESCONHECIDO + ", IMP_PRODUTO_DESCONHECIDO=" + IMP_PRODUTO_DESCONHECIDO
				+ ", IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A=" + IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A
				+ ", IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA=" + IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA + ", IMP_MES_DESCONHECIDO="
				+ IMP_MES_DESCONHECIDO + ", IMP_ANO_DESCONHECIDO=" + IMP_ANO_DESCONHECIDO + ", IMP_DATA_INVALIDA=" + IMP_DATA_INVALIDA
				+ ", IMP_PPNECIMPURL_DESCONHECIDO=" + IMP_PPNECIMPURL_DESCONHECIDO + ", NECIMP_DESCONHECIDO=" + NECIMP_DESCONHECIDO
				+ ", CALENDARIO_DESCONHECIDO=" + CALENDARIO_DESCONHECIDO + ", TIPO_PLANO_DESCONHECIDO=" + TIPO_PLANO_DESCONHECIDO
				+ ", NECESSIDADE_DESCONHECIDA=" + NECESSIDADE_DESCONHECIDA + ", CP_DESCONHECIDA=" + CP_DESCONHECIDA + ", RAP_DESCONHECIDO="
				+ RAP_DESCONHECIDO + ", ERROR_PLANO_JA_FIRMADO=" + ERROR_PLANO_JA_FIRMADO + ", ERROR_PLANO_MUITO_ANTIGO="
				+ ERROR_PLANO_MUITO_ANTIGO + ", ERROR_PLANO_SEM_CP=" + ERROR_PLANO_SEM_CP + ", ERROR_CICLO_PADRAO=" + ERROR_CICLO_PADRAO
				+ ", ERRO_PARADA_DESCONHECIDA=" + ERRO_PARADA_DESCONHECIDA + ", EST_LOCAL_DESCONHECIDO=" + EST_LOCAL_DESCONHECIDO
				+ ", ESTOQUE_DESCONHECIDO=" + ESTOQUE_DESCONHECIDO + ", ERRO_RES_GUI_DESCONHECIDO=" + ERRO_RES_GUI_DESCONHECIDO
				+ ", TIPO_GT_DESCONHECIDO=" + TIPO_GT_DESCONHECIDO + ", GRP_USUARIO_DESCONHECIDO=" + GRP_USUARIO_DESCONHECIDO
				+ ", FT_PARAM_DESCONHECIDO=" + FT_PARAM_DESCONHECIDO + ", OP_COM_PRODUCAO=" + OP_COM_PRODUCAO + ", REFUGO_DESCONHECIDO="
				+ REFUGO_DESCONHECIDO + ", QTD_TEC_INVALIDA=" + QTD_TEC_INVALIDA + ", ALERTA_TIPO_INVALIDO=" + ALERTA_TIPO_INVALIDO
				+ ", PARADA_TIPO_INVALIDO=" + PARADA_TIPO_INVALIDO + ", TIMEOUT_INVALIDO=" + TIMEOUT_INVALIDO
				+ ", CLASSIFICACAOABC_INVALIDO=" + CLASSIFICACAOABC_INVALIDO + ", RITMO_INVALIDO=" + RITMO_INVALIDO + ", EMPRESA_INVALIDA="
				+ EMPRESA_INVALIDA + ", CODIGO_EM_USO=" + CODIGO_EM_USO + ", PRODUTO_ACABADO_INVALIDO=" + PRODUTO_ACABADO_INVALIDO
				+ ", PRODUTO_SEMI_ACABADO_INVALIDO=" + PRODUTO_SEMI_ACABADO_INVALIDO + ", ALGORITMO_BALANCEAMENTO_INVALIDO="
				+ ALGORITMO_BALANCEAMENTO_INVALIDO + ", STATUS_BALANCEAMENTO_INVALIDO=" + STATUS_BALANCEAMENTO_INVALIDO
				+ ", ERRO_REATIVACAO_INDISPONIVEL=" + ERRO_REATIVACAO_INDISPONIVEL + ", ERRO_REGISTRO_DESCONHECIDO="
				+ ERRO_REGISTRO_DESCONHECIDO + ", FOLHA_DESCONHECIDA=" + FOLHA_DESCONHECIDA + ", ERRO_CODIGO_EM_USO_NA_COFIGURACAO_GERAL="
				+ ERRO_CODIGO_EM_USO_NA_COFIGURACAO_GERAL + ", ERRO_CC_VAZIO=" + ERRO_CC_VAZIO + ", FORA_FAIXA=" + FORA_FAIXA
				+ ", SEM_MAC_DISPONIVEL=" + SEM_MAC_DISPONIVEL + ", ORIGEM_DESCONHECIDO=" + ORIGEM_DESCONHECIDA + ", idmensagem=" + idmensagem + ", complemento=" + complemento + "]";
	}

}
