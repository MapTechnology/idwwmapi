/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import idw.model.pojos.DwFolha;


/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class FolhaDTO implements Serializable {
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_FOLHA_JA_EXISTE = 1;
	private int ERRO_DESCONHECIDO = 3;
	private int ERRO_USUARIO_REVISAO_DESCONHECIDO = 4;
	private int ERRO_USUARIO_STATUS_DESCONHECIDO = 5;
	private int ERRO_CDFOLHA_INVALIDO = 6;
	private int ERRO_TIPOFOLHA_DESCONHECIDO = 7;
	private int ERRO_GT_DESCONHECIDO = 8;
	private int ERRO_TIPOPOSTO_DESCONHECIDO = 9;
	private int ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS = 10;
	private int ERRO_RELACAO_PARTES_FALTANDO = 11;
	private int ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO = 12;
	private int ERRO_PRODUTO_COMPONENTE_DESCONHECIDO = 13;
	private int ERRO_TENSAO_INVALIDA = 14;
	private int ERRO_PRODUTO_DESCONHECIDO = 15;
	private int ERRO_SUBETAPA_INVALIDA = 16;
	private int ERRO_TEMPO_POSFALHA_INVALIDO = 17;
	private int ERRO_PARAMETRO_INVALIDO = 18;
	private int ERRO_LIMITES_MEDICAO_INCONSISTENTES = 19;
	private int ERRO_VALOR_PARAMETRO_INVALIDO = 20;
	private int ERRO_DWRAP_DESCONHECIDA = 21;
	private int ERRO_OMPRG_DESCONHECIDO = 22;
	private int ERRO_FOLHA_DESCONHECIDA = 23;
	private int ERRO_PT_DESCONHECIDO = 24;
	private int ERRO_PROCEDIMENTO_DESCONHECIDO = 25;
	private int ERRO_CICLO_INVALIDO = 26;
	private int ERRO_PRODUCAO_CICLO_INVALIDA = 27;
	private int ERRO_OU_RAP_OU_PRODUTOFABRICADO = 28;
	private int ERRO_EMBALAGEM_DESCONHECIDA = 29;
	private int ERRO_SCRIPT_DESCONHECIDO = 30;

    private DwFolha folha;
    private Boolean pesquisaEtapasRevisao;
    private List<FolhaEtapaDTO> folhaEtapasDTO;
	private String mensagemTensaoAbaixoMinima;
	private String mensagemTensaoAcimaMaxima;
	private boolean isSalvarDetalhe;
	private boolean isFolhaComOpEmMaquina;

    private int resultadoEvento;
    private String etapaComErro;
	private String subetapaComErro;

	public String getEtapaComErro() {
		return etapaComErro;
	}
	public void setEtapaComErro(String etapaComErro) {
		this.etapaComErro = etapaComErro;
	}
    
    public String getSubetapaComErro() {
		return subetapaComErro;
	}
	public void setSubetapaComErro(String subetapaComErro) {
		this.subetapaComErro = subetapaComErro;
	}
	public String getMensagemTensaoAbaixoMinima() {
		return mensagemTensaoAbaixoMinima;
	}
	public void setMensagemTensaoAbaixoMinima(String mensagemTensaoAbaixoMinima) {
		this.mensagemTensaoAbaixoMinima = mensagemTensaoAbaixoMinima;
	}
	public String getMensagemTensaoAcimaMaxima() {
		return mensagemTensaoAcimaMaxima;
	}
	public void setMensagemTensaoAcimaMaxima(String mensagemTensaoAcimaMaxima) {
		this.mensagemTensaoAcimaMaxima = mensagemTensaoAcimaMaxima;
	}
	public boolean isSalvarDetalhe() {
		return isSalvarDetalhe;
	}
	public void setSalvarDetalhe(boolean isSalvarDetalhe) {
		this.isSalvarDetalhe = isSalvarDetalhe;
	}
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}
	public void setEVENTO_BEM_SUCEDIDO(int eVENTOBEMSUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTOBEMSUCEDIDO;
	}
	public int getERRO_FOLHA_JA_EXISTE() {
		return ERRO_FOLHA_JA_EXISTE;
	}
	public void setERRO_FOLHA_JA_EXISTE(int eRROFOLHAJAEXISTE) {
		ERRO_FOLHA_JA_EXISTE = eRROFOLHAJAEXISTE;
	}
	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}
	public void setERRO_DESCONHECIDO(int eRRODESCONHECIDO) {
		ERRO_DESCONHECIDO = eRRODESCONHECIDO;
	}
	public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
		return ERRO_USUARIO_REVISAO_DESCONHECIDO;
	}
	public void setERRO_USUARIO_REVISAO_DESCONHECIDO(
			int eRROUSUARIOREVISAODESCONHECIDO) {
		ERRO_USUARIO_REVISAO_DESCONHECIDO = eRROUSUARIOREVISAODESCONHECIDO;
	}
	public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
		return ERRO_USUARIO_STATUS_DESCONHECIDO;
	}
	public void setERRO_USUARIO_STATUS_DESCONHECIDO(
			int eRROUSUARIOSTATUSDESCONHECIDO) {
		ERRO_USUARIO_STATUS_DESCONHECIDO = eRROUSUARIOSTATUSDESCONHECIDO;
	}
	public int getERRO_CDFOLHA_INVALIDO() {
		return ERRO_CDFOLHA_INVALIDO;
	}
	public void setERRO_CDFOLHA_INVALIDO(int eRROCDFOLHAINVALIDO) {
		ERRO_CDFOLHA_INVALIDO = eRROCDFOLHAINVALIDO;
	}
	public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	public DwFolha getFolha() {
		return folha;
	}
	public void setFolha(DwFolha folha) {
		this.folha = folha;
	}
	public Boolean getPesquisaEtapasRevisao() {
		return pesquisaEtapasRevisao;
	}
	public void setPesquisaEtapasRevisao(Boolean pesquisaEtapasRevisao) {
		this.pesquisaEtapasRevisao = pesquisaEtapasRevisao;
	}
	public int getERRO_TIPOFOLHA_DESCONHECIDO() {
		return ERRO_TIPOFOLHA_DESCONHECIDO;
	}
	public void setERRO_TIPOFOLHA_DESCONHECIDO(int eRROTIPOFOLHADESCONHECIDO) {
		ERRO_TIPOFOLHA_DESCONHECIDO = eRROTIPOFOLHADESCONHECIDO;
	}
	public int getERRO_GT_DESCONHECIDO() {
		return ERRO_GT_DESCONHECIDO;
	}
	public void setERRO_GT_DESCONHECIDO(int eRROGTDESCONHECIDO) {
		ERRO_GT_DESCONHECIDO = eRROGTDESCONHECIDO;
	}
	public int getERRO_TIPOPOSTO_DESCONHECIDO() {
		return ERRO_TIPOPOSTO_DESCONHECIDO;
	}
	public void setERRO_TIPOPOSTO_DESCONHECIDO(int eRROTIPOPOSTODESCONHECIDO) {
		ERRO_TIPOPOSTO_DESCONHECIDO = eRROTIPOPOSTODESCONHECIDO;
	}
	public int getERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS() {
		return ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS;
	}
	public void setERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS(
			int eRROTESTEFUNCIONALNAODEFINIDOS) {
		ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS = eRROTESTEFUNCIONALNAODEFINIDOS;
	}
	public int getERRO_RELACAO_PARTES_FALTANDO() {
		return ERRO_RELACAO_PARTES_FALTANDO;
	}
	public void setERRO_RELACAO_PARTES_FALTANDO(int eRRORELACAOPARTESFALTANDO) {
		ERRO_RELACAO_PARTES_FALTANDO = eRRORELACAOPARTESFALTANDO;
	}
	public int getERRO_PRODUTO_PRINCIPAL_DESCONHECIDO() {
		return ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO;
	}
	public void setERRO_PRODUTO_PRINCIPAL_DESCONHECIDO(
			int eRROPRODUTOPRINCIPALDESCONHECIDO) {
		ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO = eRROPRODUTOPRINCIPALDESCONHECIDO;
	}
	public int getERRO_PRODUTO_COMPONENTE_DESCONHECIDO() {
		return ERRO_PRODUTO_COMPONENTE_DESCONHECIDO;
	}
	public void setERRO_PRODUTO_COMPONENTE_DESCONHECIDO(
			int eRROPRODUTOCOMPONENTEDESCONHECIDO) {
		ERRO_PRODUTO_COMPONENTE_DESCONHECIDO = eRROPRODUTOCOMPONENTEDESCONHECIDO;
	}
	public int getERRO_TENSAO_INVALIDA() {
		return ERRO_TENSAO_INVALIDA;
	}
	public void setERRO_TENSAO_INVALIDA(int eRROTENSAOINVALIDA) {
		ERRO_TENSAO_INVALIDA = eRROTENSAOINVALIDA;
	}
	public int getERRO_PRODUTO_DESCONHECIDO() {
		return ERRO_PRODUTO_DESCONHECIDO;
	}
	public void setERRO_PRODUTO_DESCONHECIDO(int eRROPRODUTODESCONHECIDO) {
		ERRO_PRODUTO_DESCONHECIDO = eRROPRODUTODESCONHECIDO;
	}
	public int getERRO_SUBETAPA_INVALIDA() {
		return ERRO_SUBETAPA_INVALIDA;
	}
	public void setERRO_SUBETAPA_INVALIDA(int eRROSUBETAPAINVALIDA) {
		ERRO_SUBETAPA_INVALIDA = eRROSUBETAPAINVALIDA;
	}
	public int getERRO_TEMPO_POSFALHA_INVALIDO() {
		return ERRO_TEMPO_POSFALHA_INVALIDO;
	}
	public void setERRO_TEMPO_POSFALHA_INVALIDO(int eRROTEMPOPOSFALHAINVALIDO) {
		ERRO_TEMPO_POSFALHA_INVALIDO = eRROTEMPOPOSFALHAINVALIDO;
	}
	public int getERRO_PARAMETRO_INVALIDO() {
		return ERRO_PARAMETRO_INVALIDO;
	}
	public void setERRO_PARAMETRO_INVALIDO(int eRROPARAMETROINVALIDO) {
		ERRO_PARAMETRO_INVALIDO = eRROPARAMETROINVALIDO;
	}
	public int getERRO_LIMITES_MEDICAO_INCONSISTENTES() {
		return ERRO_LIMITES_MEDICAO_INCONSISTENTES;
	}
	public void setERRO_LIMITES_MEDICAO_INCONSISTENTES(
			int eRROLIMITESMEDICAOINCONSISTENTES) {
		ERRO_LIMITES_MEDICAO_INCONSISTENTES = eRROLIMITESMEDICAOINCONSISTENTES;
	}
	public int getERRO_VALOR_PARAMETRO_INVALIDO() {
		return ERRO_VALOR_PARAMETRO_INVALIDO;
	}
	public void setERRO_VALOR_PARAMETRO_INVALIDO(int eRROVALORPARAMETROINVALIDO) {
		ERRO_VALOR_PARAMETRO_INVALIDO = eRROVALORPARAMETROINVALIDO;
	}
	public List<FolhaEtapaDTO> getFolhaEtapasDTO() {
		return folhaEtapasDTO;
	}
	public void setFolhaEtapasDTO(List<FolhaEtapaDTO> folhaEtapasDTO) {
		this.folhaEtapasDTO = folhaEtapasDTO;
	}
	public void setERRO_DWRAP_DESCONHECIDA(int eRRO_DWRAP_DESCONHECIDA) {
		ERRO_DWRAP_DESCONHECIDA = eRRO_DWRAP_DESCONHECIDA;
	}
	public int getERRO_DWRAP_DESCONHECIDA() {
		return ERRO_DWRAP_DESCONHECIDA;
	}
	public void setERRO_OMPRG_DESCONHECIDO(int eRRO_OMPRG_DESCONHECIDO) {
		ERRO_OMPRG_DESCONHECIDO = eRRO_OMPRG_DESCONHECIDO;
	}
	public int getERRO_OMPRG_DESCONHECIDO() {
		return ERRO_OMPRG_DESCONHECIDO;
	}
	public void setERRO_FOLHA_DESCONHECIDA(int eRRO_FOLHA_DESCONHECIDA) {
		ERRO_FOLHA_DESCONHECIDA = eRRO_FOLHA_DESCONHECIDA;
	}
	public int getERRO_FOLHA_DESCONHECIDA() {
		return ERRO_FOLHA_DESCONHECIDA;
	}
	public int getERRO_PT_DESCONHECIDO() {
		return ERRO_PT_DESCONHECIDO;
	}
	public void setERRO_PT_DESCONHECIDO(int eRRO_PT_DESCONHECIDO) {
		ERRO_PT_DESCONHECIDO = eRRO_PT_DESCONHECIDO;
	}
	public int getERRO_PROCEDIMENTO_DESCONHECIDO() {
		return ERRO_PROCEDIMENTO_DESCONHECIDO;
	}
	public void setERRO_PROCEDIMENTO_DESCONHECIDO(int eRRO_PROCEDIMENTO_DESCONHECIDO) {
		ERRO_PROCEDIMENTO_DESCONHECIDO = eRRO_PROCEDIMENTO_DESCONHECIDO;
	}
	public int getERRO_CICLO_INVALIDO() {
		return ERRO_CICLO_INVALIDO;
	}
	public void setERRO_CICLO_INVALIDO(int eRRO_CICLO_INVALIDO) {
		ERRO_CICLO_INVALIDO = eRRO_CICLO_INVALIDO;
	}
	
	public int getERRO_OU_RAP_OU_PRODUTOFABRICADO() {
		return ERRO_OU_RAP_OU_PRODUTOFABRICADO;
	}
	public void setERRO_OU_RAP_OU_PRODUTOFABRICADO(int eRRO_OU_RAP_OU_PRODUTOFABRICADO) {
		ERRO_OU_RAP_OU_PRODUTOFABRICADO = eRRO_OU_RAP_OU_PRODUTOFABRICADO;
	}
	public boolean isFolhaComOpEmMaquina() {
		return isFolhaComOpEmMaquina;
	}
	public void setFolhaComOpEmMaquina(boolean isFolhaComOpEmMaquina) {
		this.isFolhaComOpEmMaquina = isFolhaComOpEmMaquina;
	}
	public int getERRO_PRODUCAO_CICLO_INVALIDA() {
		return ERRO_PRODUCAO_CICLO_INVALIDA;
	}
	public void setERRO_PRODUCAO_CICLO_INVALIDA(int eRRO_PRODUCAO_CICLO_INVALIDA) {
		ERRO_PRODUCAO_CICLO_INVALIDA = eRRO_PRODUCAO_CICLO_INVALIDA;
	}
	public int getERRO_EMBALAGEM_DESCONHECIDA() {
		return ERRO_EMBALAGEM_DESCONHECIDA;
	}
	public void setERRO_EMBALAGEM_DESCONHECIDA(int eRRO_EMBALAGEM_DESCONHECIDA) {
		ERRO_EMBALAGEM_DESCONHECIDA = eRRO_EMBALAGEM_DESCONHECIDA;
	}
	public int getERRO_SCRIPT_DESCONHECIDO() {
		return ERRO_SCRIPT_DESCONHECIDO;
	}
	public void setERRO_SCRIPT_DESCONHECIDO(int eRRO_SCRIPT_DESCONHECIDO) {
		ERRO_SCRIPT_DESCONHECIDO = eRRO_SCRIPT_DESCONHECIDO;
	}

	
	public String getDescricaoResultado() {
		String retorno = "";
		if (this.resultadoEvento == 0) retorno = "EVENTO_BEM_SUCEDIDO";
		if (this.resultadoEvento == 1) retorno = "ERRO_FOLHA_JA_EXISTE";
		if (this.resultadoEvento == 3) retorno = "ERRO_DESCONHECIDO";
		if (this.resultadoEvento == 4) retorno = "ERRO_USUARIO_REVISAO_DESCONHECIDO";
		if (this.resultadoEvento == 5) retorno = "ERRO_USUARIO_STATUS_DESCONHECIDO";
		if (this.resultadoEvento == 6) retorno = "ERRO_CDFOLHA_INVALIDO";
		if (this.resultadoEvento == 7) retorno = "ERRO_TIPOFOLHA_DESCONHECIDO";
		if (this.resultadoEvento == 8) retorno = "ERRO_GT_DESCONHECIDO";
		if (this.resultadoEvento == 9) retorno = "ERRO_TIPOPOSTO_DESCONHECIDO";
		if (this.resultadoEvento == 10) retorno = "ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS";
		if (this.resultadoEvento == 11) retorno = "ERRO_RELACAO_PARTES_FALTANDO";
		if (this.resultadoEvento == 12) retorno = "ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO";
		if (this.resultadoEvento == 13) retorno = "ERRO_PRODUTO_COMPONENTE_DESCONHECIDO";
		if (this.resultadoEvento == 14) retorno = "ERRO_TENSAO_INVALIDA";
		if (this.resultadoEvento == 15) retorno = "ERRO_PRODUTO_DESCONHECIDO";
		if (this.resultadoEvento == 16) retorno = "ERRO_SUBETAPA_INVALIDA";
		if (this.resultadoEvento == 17) retorno = "ERRO_TEMPO_POSFALHA_INVALIDO";
		if (this.resultadoEvento == 18) retorno = "ERRO_PARAMETRO_INVALIDO";
		if (this.resultadoEvento == 19) retorno = "ERRO_LIMITES_MEDICAO_INCONSISTENTES";
		if (this.resultadoEvento == 20) retorno = "ERRO_VALOR_PARAMETRO_INVALIDO";
		if (this.resultadoEvento == 21) retorno = "ERRO_DWRAP_DESCONHECIDA";
		if (this.resultadoEvento == 22) retorno = "ERRO_OMPRG_DESCONHECIDO";
		if (this.resultadoEvento == 23) retorno = "ERRO_FOLHA_DESCONHECIDA";
		if (this.resultadoEvento == 24) retorno = "ERRO_PT_DESCONHECIDO";
		if (this.resultadoEvento == 25) retorno = "ERRO_PROCEDIMENTO_DESCONHECIDO";
		if (this.resultadoEvento == 26) retorno = "ERRO_CICLO_INVALIDO";
		if (this.resultadoEvento == 27) retorno = "ERRO_PRODUCAO_CICLO_INVALIDA";
		if (this.resultadoEvento == 28) retorno = "ERRO_OU_RAP_OU_PRODUTOFABRICADO";
		if (this.resultadoEvento == 29) retorno = "ERRO_EMBALAGEM_DESCONHECIDA";
		if (this.resultadoEvento == 30) retorno = "ERRO_SCRIPT_DESCONHECIDO";

		return retorno;
	}
}