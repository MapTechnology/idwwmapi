/**
 * FolhaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FolhaDTO  implements java.io.Serializable {
    private int ERRO_CDFOLHA_INVALIDO;

    private int ERRO_DESCONHECIDO;

    private int ERRO_DWRAP_DESCONHECIDA;

    private int ERRO_FOLHA_DESCONHECIDA;

    private int ERRO_FOLHA_JA_EXISTE;

    private int ERRO_GT_DESCONHECIDO;

    private int ERRO_LIMITES_MEDICAO_INCONSISTENTES;

    private int ERRO_OMPRG_DESCONHECIDO;

    private int ERRO_PARAMETRO_INVALIDO;

    private int ERRO_PRODUTO_COMPONENTE_DESCONHECIDO;

    private int ERRO_PRODUTO_DESCONHECIDO;

    private int ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO;

    private int ERRO_RELACAO_PARTES_FALTANDO;

    private int ERRO_SUBETAPA_INVALIDA;

    private int ERRO_TEMPO_POSFALHA_INVALIDO;

    private int ERRO_TENSAO_INVALIDA;

    private int ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS;

    private int ERRO_TIPOFOLHA_DESCONHECIDO;

    private int ERRO_TIPOPOSTO_DESCONHECIDO;

    private int ERRO_USUARIO_REVISAO_DESCONHECIDO;

    private int ERRO_USUARIO_STATUS_DESCONHECIDO;

    private int ERRO_VALOR_PARAMETRO_INVALIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private java.lang.String etapaComErro;

    private idw.idwws.DwFolha folha;

    private idw.idwws.FolhaEtapaDTO[] folhaEtapasDTO;

    private java.lang.String mensagemTensaoAbaixoMinima;

    private java.lang.String mensagemTensaoAcimaMaxima;

    private java.lang.Boolean pesquisaEtapasRevisao;

    private int resultadoEvento;

    private boolean salvarDetalhe;

    private java.lang.String subetapaComErro;

    public FolhaDTO() {
    }

    public FolhaDTO(
           int ERRO_CDFOLHA_INVALIDO,
           int ERRO_DESCONHECIDO,
           int ERRO_DWRAP_DESCONHECIDA,
           int ERRO_FOLHA_DESCONHECIDA,
           int ERRO_FOLHA_JA_EXISTE,
           int ERRO_GT_DESCONHECIDO,
           int ERRO_LIMITES_MEDICAO_INCONSISTENTES,
           int ERRO_OMPRG_DESCONHECIDO,
           int ERRO_PARAMETRO_INVALIDO,
           int ERRO_PRODUTO_COMPONENTE_DESCONHECIDO,
           int ERRO_PRODUTO_DESCONHECIDO,
           int ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO,
           int ERRO_RELACAO_PARTES_FALTANDO,
           int ERRO_SUBETAPA_INVALIDA,
           int ERRO_TEMPO_POSFALHA_INVALIDO,
           int ERRO_TENSAO_INVALIDA,
           int ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS,
           int ERRO_TIPOFOLHA_DESCONHECIDO,
           int ERRO_TIPOPOSTO_DESCONHECIDO,
           int ERRO_USUARIO_REVISAO_DESCONHECIDO,
           int ERRO_USUARIO_STATUS_DESCONHECIDO,
           int ERRO_VALOR_PARAMETRO_INVALIDO,
           int EVENTO_BEM_SUCEDIDO,
           java.lang.String etapaComErro,
           idw.idwws.DwFolha folha,
           idw.idwws.FolhaEtapaDTO[] folhaEtapasDTO,
           java.lang.String mensagemTensaoAbaixoMinima,
           java.lang.String mensagemTensaoAcimaMaxima,
           java.lang.Boolean pesquisaEtapasRevisao,
           int resultadoEvento,
           boolean salvarDetalhe,
           java.lang.String subetapaComErro) {
           this.ERRO_CDFOLHA_INVALIDO = ERRO_CDFOLHA_INVALIDO;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_DWRAP_DESCONHECIDA = ERRO_DWRAP_DESCONHECIDA;
           this.ERRO_FOLHA_DESCONHECIDA = ERRO_FOLHA_DESCONHECIDA;
           this.ERRO_FOLHA_JA_EXISTE = ERRO_FOLHA_JA_EXISTE;
           this.ERRO_GT_DESCONHECIDO = ERRO_GT_DESCONHECIDO;
           this.ERRO_LIMITES_MEDICAO_INCONSISTENTES = ERRO_LIMITES_MEDICAO_INCONSISTENTES;
           this.ERRO_OMPRG_DESCONHECIDO = ERRO_OMPRG_DESCONHECIDO;
           this.ERRO_PARAMETRO_INVALIDO = ERRO_PARAMETRO_INVALIDO;
           this.ERRO_PRODUTO_COMPONENTE_DESCONHECIDO = ERRO_PRODUTO_COMPONENTE_DESCONHECIDO;
           this.ERRO_PRODUTO_DESCONHECIDO = ERRO_PRODUTO_DESCONHECIDO;
           this.ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO = ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO;
           this.ERRO_RELACAO_PARTES_FALTANDO = ERRO_RELACAO_PARTES_FALTANDO;
           this.ERRO_SUBETAPA_INVALIDA = ERRO_SUBETAPA_INVALIDA;
           this.ERRO_TEMPO_POSFALHA_INVALIDO = ERRO_TEMPO_POSFALHA_INVALIDO;
           this.ERRO_TENSAO_INVALIDA = ERRO_TENSAO_INVALIDA;
           this.ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS = ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS;
           this.ERRO_TIPOFOLHA_DESCONHECIDO = ERRO_TIPOFOLHA_DESCONHECIDO;
           this.ERRO_TIPOPOSTO_DESCONHECIDO = ERRO_TIPOPOSTO_DESCONHECIDO;
           this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
           this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
           this.ERRO_VALOR_PARAMETRO_INVALIDO = ERRO_VALOR_PARAMETRO_INVALIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.etapaComErro = etapaComErro;
           this.folha = folha;
           this.folhaEtapasDTO = folhaEtapasDTO;
           this.mensagemTensaoAbaixoMinima = mensagemTensaoAbaixoMinima;
           this.mensagemTensaoAcimaMaxima = mensagemTensaoAcimaMaxima;
           this.pesquisaEtapasRevisao = pesquisaEtapasRevisao;
           this.resultadoEvento = resultadoEvento;
           this.salvarDetalhe = salvarDetalhe;
           this.subetapaComErro = subetapaComErro;
    }


    /**
     * Gets the ERRO_CDFOLHA_INVALIDO value for this FolhaDTO.
     * 
     * @return ERRO_CDFOLHA_INVALIDO
     */
    public int getERRO_CDFOLHA_INVALIDO() {
        return ERRO_CDFOLHA_INVALIDO;
    }


    /**
     * Sets the ERRO_CDFOLHA_INVALIDO value for this FolhaDTO.
     * 
     * @param ERRO_CDFOLHA_INVALIDO
     */
    public void setERRO_CDFOLHA_INVALIDO(int ERRO_CDFOLHA_INVALIDO) {
        this.ERRO_CDFOLHA_INVALIDO = ERRO_CDFOLHA_INVALIDO;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this FolhaDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this FolhaDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_DWRAP_DESCONHECIDA value for this FolhaDTO.
     * 
     * @return ERRO_DWRAP_DESCONHECIDA
     */
    public int getERRO_DWRAP_DESCONHECIDA() {
        return ERRO_DWRAP_DESCONHECIDA;
    }


    /**
     * Sets the ERRO_DWRAP_DESCONHECIDA value for this FolhaDTO.
     * 
     * @param ERRO_DWRAP_DESCONHECIDA
     */
    public void setERRO_DWRAP_DESCONHECIDA(int ERRO_DWRAP_DESCONHECIDA) {
        this.ERRO_DWRAP_DESCONHECIDA = ERRO_DWRAP_DESCONHECIDA;
    }


    /**
     * Gets the ERRO_FOLHA_DESCONHECIDA value for this FolhaDTO.
     * 
     * @return ERRO_FOLHA_DESCONHECIDA
     */
    public int getERRO_FOLHA_DESCONHECIDA() {
        return ERRO_FOLHA_DESCONHECIDA;
    }


    /**
     * Sets the ERRO_FOLHA_DESCONHECIDA value for this FolhaDTO.
     * 
     * @param ERRO_FOLHA_DESCONHECIDA
     */
    public void setERRO_FOLHA_DESCONHECIDA(int ERRO_FOLHA_DESCONHECIDA) {
        this.ERRO_FOLHA_DESCONHECIDA = ERRO_FOLHA_DESCONHECIDA;
    }


    /**
     * Gets the ERRO_FOLHA_JA_EXISTE value for this FolhaDTO.
     * 
     * @return ERRO_FOLHA_JA_EXISTE
     */
    public int getERRO_FOLHA_JA_EXISTE() {
        return ERRO_FOLHA_JA_EXISTE;
    }


    /**
     * Sets the ERRO_FOLHA_JA_EXISTE value for this FolhaDTO.
     * 
     * @param ERRO_FOLHA_JA_EXISTE
     */
    public void setERRO_FOLHA_JA_EXISTE(int ERRO_FOLHA_JA_EXISTE) {
        this.ERRO_FOLHA_JA_EXISTE = ERRO_FOLHA_JA_EXISTE;
    }


    /**
     * Gets the ERRO_GT_DESCONHECIDO value for this FolhaDTO.
     * 
     * @return ERRO_GT_DESCONHECIDO
     */
    public int getERRO_GT_DESCONHECIDO() {
        return ERRO_GT_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_GT_DESCONHECIDO value for this FolhaDTO.
     * 
     * @param ERRO_GT_DESCONHECIDO
     */
    public void setERRO_GT_DESCONHECIDO(int ERRO_GT_DESCONHECIDO) {
        this.ERRO_GT_DESCONHECIDO = ERRO_GT_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_LIMITES_MEDICAO_INCONSISTENTES value for this FolhaDTO.
     * 
     * @return ERRO_LIMITES_MEDICAO_INCONSISTENTES
     */
    public int getERRO_LIMITES_MEDICAO_INCONSISTENTES() {
        return ERRO_LIMITES_MEDICAO_INCONSISTENTES;
    }


    /**
     * Sets the ERRO_LIMITES_MEDICAO_INCONSISTENTES value for this FolhaDTO.
     * 
     * @param ERRO_LIMITES_MEDICAO_INCONSISTENTES
     */
    public void setERRO_LIMITES_MEDICAO_INCONSISTENTES(int ERRO_LIMITES_MEDICAO_INCONSISTENTES) {
        this.ERRO_LIMITES_MEDICAO_INCONSISTENTES = ERRO_LIMITES_MEDICAO_INCONSISTENTES;
    }


    /**
     * Gets the ERRO_OMPRG_DESCONHECIDO value for this FolhaDTO.
     * 
     * @return ERRO_OMPRG_DESCONHECIDO
     */
    public int getERRO_OMPRG_DESCONHECIDO() {
        return ERRO_OMPRG_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_OMPRG_DESCONHECIDO value for this FolhaDTO.
     * 
     * @param ERRO_OMPRG_DESCONHECIDO
     */
    public void setERRO_OMPRG_DESCONHECIDO(int ERRO_OMPRG_DESCONHECIDO) {
        this.ERRO_OMPRG_DESCONHECIDO = ERRO_OMPRG_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_PARAMETRO_INVALIDO value for this FolhaDTO.
     * 
     * @return ERRO_PARAMETRO_INVALIDO
     */
    public int getERRO_PARAMETRO_INVALIDO() {
        return ERRO_PARAMETRO_INVALIDO;
    }


    /**
     * Sets the ERRO_PARAMETRO_INVALIDO value for this FolhaDTO.
     * 
     * @param ERRO_PARAMETRO_INVALIDO
     */
    public void setERRO_PARAMETRO_INVALIDO(int ERRO_PARAMETRO_INVALIDO) {
        this.ERRO_PARAMETRO_INVALIDO = ERRO_PARAMETRO_INVALIDO;
    }


    /**
     * Gets the ERRO_PRODUTO_COMPONENTE_DESCONHECIDO value for this FolhaDTO.
     * 
     * @return ERRO_PRODUTO_COMPONENTE_DESCONHECIDO
     */
    public int getERRO_PRODUTO_COMPONENTE_DESCONHECIDO() {
        return ERRO_PRODUTO_COMPONENTE_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_PRODUTO_COMPONENTE_DESCONHECIDO value for this FolhaDTO.
     * 
     * @param ERRO_PRODUTO_COMPONENTE_DESCONHECIDO
     */
    public void setERRO_PRODUTO_COMPONENTE_DESCONHECIDO(int ERRO_PRODUTO_COMPONENTE_DESCONHECIDO) {
        this.ERRO_PRODUTO_COMPONENTE_DESCONHECIDO = ERRO_PRODUTO_COMPONENTE_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_PRODUTO_DESCONHECIDO value for this FolhaDTO.
     * 
     * @return ERRO_PRODUTO_DESCONHECIDO
     */
    public int getERRO_PRODUTO_DESCONHECIDO() {
        return ERRO_PRODUTO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_PRODUTO_DESCONHECIDO value for this FolhaDTO.
     * 
     * @param ERRO_PRODUTO_DESCONHECIDO
     */
    public void setERRO_PRODUTO_DESCONHECIDO(int ERRO_PRODUTO_DESCONHECIDO) {
        this.ERRO_PRODUTO_DESCONHECIDO = ERRO_PRODUTO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO value for this FolhaDTO.
     * 
     * @return ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO
     */
    public int getERRO_PRODUTO_PRINCIPAL_DESCONHECIDO() {
        return ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO value for this FolhaDTO.
     * 
     * @param ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO
     */
    public void setERRO_PRODUTO_PRINCIPAL_DESCONHECIDO(int ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO) {
        this.ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO = ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_RELACAO_PARTES_FALTANDO value for this FolhaDTO.
     * 
     * @return ERRO_RELACAO_PARTES_FALTANDO
     */
    public int getERRO_RELACAO_PARTES_FALTANDO() {
        return ERRO_RELACAO_PARTES_FALTANDO;
    }


    /**
     * Sets the ERRO_RELACAO_PARTES_FALTANDO value for this FolhaDTO.
     * 
     * @param ERRO_RELACAO_PARTES_FALTANDO
     */
    public void setERRO_RELACAO_PARTES_FALTANDO(int ERRO_RELACAO_PARTES_FALTANDO) {
        this.ERRO_RELACAO_PARTES_FALTANDO = ERRO_RELACAO_PARTES_FALTANDO;
    }


    /**
     * Gets the ERRO_SUBETAPA_INVALIDA value for this FolhaDTO.
     * 
     * @return ERRO_SUBETAPA_INVALIDA
     */
    public int getERRO_SUBETAPA_INVALIDA() {
        return ERRO_SUBETAPA_INVALIDA;
    }


    /**
     * Sets the ERRO_SUBETAPA_INVALIDA value for this FolhaDTO.
     * 
     * @param ERRO_SUBETAPA_INVALIDA
     */
    public void setERRO_SUBETAPA_INVALIDA(int ERRO_SUBETAPA_INVALIDA) {
        this.ERRO_SUBETAPA_INVALIDA = ERRO_SUBETAPA_INVALIDA;
    }


    /**
     * Gets the ERRO_TEMPO_POSFALHA_INVALIDO value for this FolhaDTO.
     * 
     * @return ERRO_TEMPO_POSFALHA_INVALIDO
     */
    public int getERRO_TEMPO_POSFALHA_INVALIDO() {
        return ERRO_TEMPO_POSFALHA_INVALIDO;
    }


    /**
     * Sets the ERRO_TEMPO_POSFALHA_INVALIDO value for this FolhaDTO.
     * 
     * @param ERRO_TEMPO_POSFALHA_INVALIDO
     */
    public void setERRO_TEMPO_POSFALHA_INVALIDO(int ERRO_TEMPO_POSFALHA_INVALIDO) {
        this.ERRO_TEMPO_POSFALHA_INVALIDO = ERRO_TEMPO_POSFALHA_INVALIDO;
    }


    /**
     * Gets the ERRO_TENSAO_INVALIDA value for this FolhaDTO.
     * 
     * @return ERRO_TENSAO_INVALIDA
     */
    public int getERRO_TENSAO_INVALIDA() {
        return ERRO_TENSAO_INVALIDA;
    }


    /**
     * Sets the ERRO_TENSAO_INVALIDA value for this FolhaDTO.
     * 
     * @param ERRO_TENSAO_INVALIDA
     */
    public void setERRO_TENSAO_INVALIDA(int ERRO_TENSAO_INVALIDA) {
        this.ERRO_TENSAO_INVALIDA = ERRO_TENSAO_INVALIDA;
    }


    /**
     * Gets the ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS value for this FolhaDTO.
     * 
     * @return ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS
     */
    public int getERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS() {
        return ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS;
    }


    /**
     * Sets the ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS value for this FolhaDTO.
     * 
     * @param ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS
     */
    public void setERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS(int ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS) {
        this.ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS = ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS;
    }


    /**
     * Gets the ERRO_TIPOFOLHA_DESCONHECIDO value for this FolhaDTO.
     * 
     * @return ERRO_TIPOFOLHA_DESCONHECIDO
     */
    public int getERRO_TIPOFOLHA_DESCONHECIDO() {
        return ERRO_TIPOFOLHA_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_TIPOFOLHA_DESCONHECIDO value for this FolhaDTO.
     * 
     * @param ERRO_TIPOFOLHA_DESCONHECIDO
     */
    public void setERRO_TIPOFOLHA_DESCONHECIDO(int ERRO_TIPOFOLHA_DESCONHECIDO) {
        this.ERRO_TIPOFOLHA_DESCONHECIDO = ERRO_TIPOFOLHA_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_TIPOPOSTO_DESCONHECIDO value for this FolhaDTO.
     * 
     * @return ERRO_TIPOPOSTO_DESCONHECIDO
     */
    public int getERRO_TIPOPOSTO_DESCONHECIDO() {
        return ERRO_TIPOPOSTO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_TIPOPOSTO_DESCONHECIDO value for this FolhaDTO.
     * 
     * @param ERRO_TIPOPOSTO_DESCONHECIDO
     */
    public void setERRO_TIPOPOSTO_DESCONHECIDO(int ERRO_TIPOPOSTO_DESCONHECIDO) {
        this.ERRO_TIPOPOSTO_DESCONHECIDO = ERRO_TIPOPOSTO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this FolhaDTO.
     * 
     * @return ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
        return ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this FolhaDTO.
     * 
     * @param ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public void setERRO_USUARIO_REVISAO_DESCONHECIDO(int ERRO_USUARIO_REVISAO_DESCONHECIDO) {
        this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this FolhaDTO.
     * 
     * @return ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
        return ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this FolhaDTO.
     * 
     * @param ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public void setERRO_USUARIO_STATUS_DESCONHECIDO(int ERRO_USUARIO_STATUS_DESCONHECIDO) {
        this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_VALOR_PARAMETRO_INVALIDO value for this FolhaDTO.
     * 
     * @return ERRO_VALOR_PARAMETRO_INVALIDO
     */
    public int getERRO_VALOR_PARAMETRO_INVALIDO() {
        return ERRO_VALOR_PARAMETRO_INVALIDO;
    }


    /**
     * Sets the ERRO_VALOR_PARAMETRO_INVALIDO value for this FolhaDTO.
     * 
     * @param ERRO_VALOR_PARAMETRO_INVALIDO
     */
    public void setERRO_VALOR_PARAMETRO_INVALIDO(int ERRO_VALOR_PARAMETRO_INVALIDO) {
        this.ERRO_VALOR_PARAMETRO_INVALIDO = ERRO_VALOR_PARAMETRO_INVALIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this FolhaDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this FolhaDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the etapaComErro value for this FolhaDTO.
     * 
     * @return etapaComErro
     */
    public java.lang.String getEtapaComErro() {
        return etapaComErro;
    }


    /**
     * Sets the etapaComErro value for this FolhaDTO.
     * 
     * @param etapaComErro
     */
    public void setEtapaComErro(java.lang.String etapaComErro) {
        this.etapaComErro = etapaComErro;
    }


    /**
     * Gets the folha value for this FolhaDTO.
     * 
     * @return folha
     */
    public idw.idwws.DwFolha getFolha() {
        return folha;
    }


    /**
     * Sets the folha value for this FolhaDTO.
     * 
     * @param folha
     */
    public void setFolha(idw.idwws.DwFolha folha) {
        this.folha = folha;
    }


    /**
     * Gets the folhaEtapasDTO value for this FolhaDTO.
     * 
     * @return folhaEtapasDTO
     */
    public idw.idwws.FolhaEtapaDTO[] getFolhaEtapasDTO() {
        return folhaEtapasDTO;
    }


    /**
     * Sets the folhaEtapasDTO value for this FolhaDTO.
     * 
     * @param folhaEtapasDTO
     */
    public void setFolhaEtapasDTO(idw.idwws.FolhaEtapaDTO[] folhaEtapasDTO) {
        this.folhaEtapasDTO = folhaEtapasDTO;
    }

    public idw.idwws.FolhaEtapaDTO getFolhaEtapasDTO(int i) {
        return this.folhaEtapasDTO[i];
    }

    public void setFolhaEtapasDTO(int i, idw.idwws.FolhaEtapaDTO _value) {
        this.folhaEtapasDTO[i] = _value;
    }


    /**
     * Gets the mensagemTensaoAbaixoMinima value for this FolhaDTO.
     * 
     * @return mensagemTensaoAbaixoMinima
     */
    public java.lang.String getMensagemTensaoAbaixoMinima() {
        return mensagemTensaoAbaixoMinima;
    }


    /**
     * Sets the mensagemTensaoAbaixoMinima value for this FolhaDTO.
     * 
     * @param mensagemTensaoAbaixoMinima
     */
    public void setMensagemTensaoAbaixoMinima(java.lang.String mensagemTensaoAbaixoMinima) {
        this.mensagemTensaoAbaixoMinima = mensagemTensaoAbaixoMinima;
    }


    /**
     * Gets the mensagemTensaoAcimaMaxima value for this FolhaDTO.
     * 
     * @return mensagemTensaoAcimaMaxima
     */
    public java.lang.String getMensagemTensaoAcimaMaxima() {
        return mensagemTensaoAcimaMaxima;
    }


    /**
     * Sets the mensagemTensaoAcimaMaxima value for this FolhaDTO.
     * 
     * @param mensagemTensaoAcimaMaxima
     */
    public void setMensagemTensaoAcimaMaxima(java.lang.String mensagemTensaoAcimaMaxima) {
        this.mensagemTensaoAcimaMaxima = mensagemTensaoAcimaMaxima;
    }


    /**
     * Gets the pesquisaEtapasRevisao value for this FolhaDTO.
     * 
     * @return pesquisaEtapasRevisao
     */
    public java.lang.Boolean getPesquisaEtapasRevisao() {
        return pesquisaEtapasRevisao;
    }


    /**
     * Sets the pesquisaEtapasRevisao value for this FolhaDTO.
     * 
     * @param pesquisaEtapasRevisao
     */
    public void setPesquisaEtapasRevisao(java.lang.Boolean pesquisaEtapasRevisao) {
        this.pesquisaEtapasRevisao = pesquisaEtapasRevisao;
    }


    /**
     * Gets the resultadoEvento value for this FolhaDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this FolhaDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the salvarDetalhe value for this FolhaDTO.
     * 
     * @return salvarDetalhe
     */
    public boolean isSalvarDetalhe() {
        return salvarDetalhe;
    }


    /**
     * Sets the salvarDetalhe value for this FolhaDTO.
     * 
     * @param salvarDetalhe
     */
    public void setSalvarDetalhe(boolean salvarDetalhe) {
        this.salvarDetalhe = salvarDetalhe;
    }


    /**
     * Gets the subetapaComErro value for this FolhaDTO.
     * 
     * @return subetapaComErro
     */
    public java.lang.String getSubetapaComErro() {
        return subetapaComErro;
    }


    /**
     * Sets the subetapaComErro value for this FolhaDTO.
     * 
     * @param subetapaComErro
     */
    public void setSubetapaComErro(java.lang.String subetapaComErro) {
        this.subetapaComErro = subetapaComErro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FolhaDTO)) return false;
        FolhaDTO other = (FolhaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ERRO_CDFOLHA_INVALIDO == other.getERRO_CDFOLHA_INVALIDO() &&
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.ERRO_DWRAP_DESCONHECIDA == other.getERRO_DWRAP_DESCONHECIDA() &&
            this.ERRO_FOLHA_DESCONHECIDA == other.getERRO_FOLHA_DESCONHECIDA() &&
            this.ERRO_FOLHA_JA_EXISTE == other.getERRO_FOLHA_JA_EXISTE() &&
            this.ERRO_GT_DESCONHECIDO == other.getERRO_GT_DESCONHECIDO() &&
            this.ERRO_LIMITES_MEDICAO_INCONSISTENTES == other.getERRO_LIMITES_MEDICAO_INCONSISTENTES() &&
            this.ERRO_OMPRG_DESCONHECIDO == other.getERRO_OMPRG_DESCONHECIDO() &&
            this.ERRO_PARAMETRO_INVALIDO == other.getERRO_PARAMETRO_INVALIDO() &&
            this.ERRO_PRODUTO_COMPONENTE_DESCONHECIDO == other.getERRO_PRODUTO_COMPONENTE_DESCONHECIDO() &&
            this.ERRO_PRODUTO_DESCONHECIDO == other.getERRO_PRODUTO_DESCONHECIDO() &&
            this.ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO == other.getERRO_PRODUTO_PRINCIPAL_DESCONHECIDO() &&
            this.ERRO_RELACAO_PARTES_FALTANDO == other.getERRO_RELACAO_PARTES_FALTANDO() &&
            this.ERRO_SUBETAPA_INVALIDA == other.getERRO_SUBETAPA_INVALIDA() &&
            this.ERRO_TEMPO_POSFALHA_INVALIDO == other.getERRO_TEMPO_POSFALHA_INVALIDO() &&
            this.ERRO_TENSAO_INVALIDA == other.getERRO_TENSAO_INVALIDA() &&
            this.ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS == other.getERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS() &&
            this.ERRO_TIPOFOLHA_DESCONHECIDO == other.getERRO_TIPOFOLHA_DESCONHECIDO() &&
            this.ERRO_TIPOPOSTO_DESCONHECIDO == other.getERRO_TIPOPOSTO_DESCONHECIDO() &&
            this.ERRO_USUARIO_REVISAO_DESCONHECIDO == other.getERRO_USUARIO_REVISAO_DESCONHECIDO() &&
            this.ERRO_USUARIO_STATUS_DESCONHECIDO == other.getERRO_USUARIO_STATUS_DESCONHECIDO() &&
            this.ERRO_VALOR_PARAMETRO_INVALIDO == other.getERRO_VALOR_PARAMETRO_INVALIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            ((this.etapaComErro==null && other.getEtapaComErro()==null) || 
             (this.etapaComErro!=null &&
              this.etapaComErro.equals(other.getEtapaComErro()))) &&
            ((this.folha==null && other.getFolha()==null) || 
             (this.folha!=null &&
              this.folha.equals(other.getFolha()))) &&
            ((this.folhaEtapasDTO==null && other.getFolhaEtapasDTO()==null) || 
             (this.folhaEtapasDTO!=null &&
              java.util.Arrays.equals(this.folhaEtapasDTO, other.getFolhaEtapasDTO()))) &&
            ((this.mensagemTensaoAbaixoMinima==null && other.getMensagemTensaoAbaixoMinima()==null) || 
             (this.mensagemTensaoAbaixoMinima!=null &&
              this.mensagemTensaoAbaixoMinima.equals(other.getMensagemTensaoAbaixoMinima()))) &&
            ((this.mensagemTensaoAcimaMaxima==null && other.getMensagemTensaoAcimaMaxima()==null) || 
             (this.mensagemTensaoAcimaMaxima!=null &&
              this.mensagemTensaoAcimaMaxima.equals(other.getMensagemTensaoAcimaMaxima()))) &&
            ((this.pesquisaEtapasRevisao==null && other.getPesquisaEtapasRevisao()==null) || 
             (this.pesquisaEtapasRevisao!=null &&
              this.pesquisaEtapasRevisao.equals(other.getPesquisaEtapasRevisao()))) &&
            this.resultadoEvento == other.getResultadoEvento() &&
            this.salvarDetalhe == other.isSalvarDetalhe() &&
            ((this.subetapaComErro==null && other.getSubetapaComErro()==null) || 
             (this.subetapaComErro!=null &&
              this.subetapaComErro.equals(other.getSubetapaComErro())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getERRO_CDFOLHA_INVALIDO();
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getERRO_DWRAP_DESCONHECIDA();
        _hashCode += getERRO_FOLHA_DESCONHECIDA();
        _hashCode += getERRO_FOLHA_JA_EXISTE();
        _hashCode += getERRO_GT_DESCONHECIDO();
        _hashCode += getERRO_LIMITES_MEDICAO_INCONSISTENTES();
        _hashCode += getERRO_OMPRG_DESCONHECIDO();
        _hashCode += getERRO_PARAMETRO_INVALIDO();
        _hashCode += getERRO_PRODUTO_COMPONENTE_DESCONHECIDO();
        _hashCode += getERRO_PRODUTO_DESCONHECIDO();
        _hashCode += getERRO_PRODUTO_PRINCIPAL_DESCONHECIDO();
        _hashCode += getERRO_RELACAO_PARTES_FALTANDO();
        _hashCode += getERRO_SUBETAPA_INVALIDA();
        _hashCode += getERRO_TEMPO_POSFALHA_INVALIDO();
        _hashCode += getERRO_TENSAO_INVALIDA();
        _hashCode += getERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS();
        _hashCode += getERRO_TIPOFOLHA_DESCONHECIDO();
        _hashCode += getERRO_TIPOPOSTO_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_REVISAO_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_STATUS_DESCONHECIDO();
        _hashCode += getERRO_VALOR_PARAMETRO_INVALIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        if (getEtapaComErro() != null) {
            _hashCode += getEtapaComErro().hashCode();
        }
        if (getFolha() != null) {
            _hashCode += getFolha().hashCode();
        }
        if (getFolhaEtapasDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFolhaEtapasDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFolhaEtapasDTO(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMensagemTensaoAbaixoMinima() != null) {
            _hashCode += getMensagemTensaoAbaixoMinima().hashCode();
        }
        if (getMensagemTensaoAcimaMaxima() != null) {
            _hashCode += getMensagemTensaoAcimaMaxima().hashCode();
        }
        if (getPesquisaEtapasRevisao() != null) {
            _hashCode += getPesquisaEtapasRevisao().hashCode();
        }
        _hashCode += getResultadoEvento();
        _hashCode += (isSalvarDetalhe() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSubetapaComErro() != null) {
            _hashCode += getSubetapaComErro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FolhaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "folhaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CDFOLHA_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CDFOLHA_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DWRAP_DESCONHECIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DWRAP_DESCONHECIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_FOLHA_DESCONHECIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_FOLHA_DESCONHECIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_FOLHA_JA_EXISTE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_FOLHA_JA_EXISTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_GT_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_GT_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_LIMITES_MEDICAO_INCONSISTENTES");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_LIMITES_MEDICAO_INCONSISTENTES"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_OMPRG_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_OMPRG_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PARAMETRO_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PARAMETRO_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PRODUTO_COMPONENTE_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PRODUTO_COMPONENTE_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PRODUTO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PRODUTO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_RELACAO_PARTES_FALTANDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_RELACAO_PARTES_FALTANDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_SUBETAPA_INVALIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_SUBETAPA_INVALIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_TEMPO_POSFALHA_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_TEMPO_POSFALHA_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_TENSAO_INVALIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_TENSAO_INVALIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_TIPOFOLHA_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_TIPOFOLHA_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_TIPOPOSTO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_TIPOPOSTO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_USUARIO_REVISAO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_USUARIO_REVISAO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_USUARIO_STATUS_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_USUARIO_STATUS_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_VALOR_PARAMETRO_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_VALOR_PARAMETRO_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EVENTO_BEM_SUCEDIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EVENTO_BEM_SUCEDIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etapaComErro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "etapaComErro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "folha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folhaEtapasDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "folhaEtapasDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "folhaEtapaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensagemTensaoAbaixoMinima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mensagemTensaoAbaixoMinima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensagemTensaoAcimaMaxima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mensagemTensaoAcimaMaxima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pesquisaEtapasRevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pesquisaEtapasRevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salvarDetalhe");
        elemField.setXmlName(new javax.xml.namespace.QName("", "salvarDetalhe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subetapaComErro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subetapaComErro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
