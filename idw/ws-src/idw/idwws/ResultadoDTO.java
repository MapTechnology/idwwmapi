/**
 * ResultadoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ResultadoDTO  implements java.io.Serializable {
    private int ERRO_DESCONHECIDO;

    private int COM_SUCESSO;

    private int SEM_CONFIGURACAO;

    private int PT_DESCONHECIDO;

    private int TIPO_PT_DESCONHECIDO;

    private int USUARIO_DESCONHECIDO;

    private int LOGIN_NAO_HOMOLOGADO;

    private int LOGIN_GT_COM_SUCESSO;

    private int LOGIN_GT_PRE_EXISTENTE;

    private int LOGIN_PT_PRE_EXISTENTE;

    private int LOGIN_PT_COM_SUCESSO;

    private int SUPERVISOR_NAO_LOGADO;

    private int OUTRO_SUPERVISOR_LOGADO;

    private int LOGOUT_GT_COM_SUCESSO;

    private int OPERADOR_NAO_LOGADO;

    private int OUTRO_OPERADOR_LOGADO;

    private int LOGOUT_PT_COM_SUCESSO;

    private int PRODUTO_DESCONHECIDO;

    private int LOGON_DE_SUPERVISOR;

    private int LOGOFF_DE_SUPERVISOR;

    private int LOGON_DE_OPERADOR;

    private int LOGOFF_DE_OPERADOR;

    private int RE_NAO_AUTORIZADO;

    private int PRODUTO_NAO_DEVE_PASSAR_POR_POSTO;

    private int ROTEIRO_INCONSISTENTE;

    private int PRODUTO_ENTROU_NAO_CONFORME;

    private int DEFEITO_DESCONHECIDO;

    private int PRODUTO_NAO_ACEITO;

    private int ACOPLAMENTO_FINALIZADO;

    private int SEM_SGBD;

    private int ERROR_SEM_CALENDARIO;

    private int ERROR_GT_DESCONHECIDO;

    private int ACAO_DESCONHECIDA;

    private int CB_NULO;

    private int COMPONENTE_NAO_PERTENCE_AO_PRODUTO;

    private int CONFIGURACAO_DESCONHECIDA;

    private int ERRO_CONFIGURACAO_SENDO_USADA;

    private int ERRO_PEPRO_DESCONHECIDO;

    private int ERRO_CC_DESCONHECIDO;

    private int COMPONENTE_DESCONHECIDO;

    private int LOGIN_MANUTENCAO;

    private int LOGIN_AFERICAO;

    private int ERRO_EXCLUI_STATIVO_ZERO;

    private int CODIGO_DESCONHECIDO;

    private int PLANO_DESCONHECIDO;

    private int REGISTRO_JA_EXISTE;

    private int IMP_CLIENTE_DESCONHECIDO;

    private int IMP_PRODUTO_DESCONHECIDO;

    private int IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A;

    private int IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA;

    private int IMP_MES_DESCONHECIDO;

    private int IMP_ANO_DESCONHECIDO;

    private int IMP_DATA_INVALIDA;

    private int IMP_PPNECIMPURL_DESCONHECIDO;

    private int NECIMP_DESCONHECIDO;

    private int CALENDARIO_DESCONHECIDO;

    private int TIPO_PLANO_DESCONHECIDO;

    private int NECESSIDADE_DESCONHECIDA;

    private int CP_DESCONHECIDA;

    private int RAP_DESCONHECIDO;

    private int ERROR_PLANO_JA_FIRMADO;

    private int ERROR_PLANO_MUITO_ANTIGO;

    private int ERROR_PLANO_SEM_CP;

    private int ERROR_CICLO_PADRAO;

    private int ERRO_PARADA_DESCONHECIDA;

    private int idmensagem;

    public ResultadoDTO() {
    }

    public ResultadoDTO(
           int ERRO_DESCONHECIDO,
           int COM_SUCESSO,
           int SEM_CONFIGURACAO,
           int PT_DESCONHECIDO,
           int TIPO_PT_DESCONHECIDO,
           int USUARIO_DESCONHECIDO,
           int LOGIN_NAO_HOMOLOGADO,
           int LOGIN_GT_COM_SUCESSO,
           int LOGIN_GT_PRE_EXISTENTE,
           int LOGIN_PT_PRE_EXISTENTE,
           int LOGIN_PT_COM_SUCESSO,
           int SUPERVISOR_NAO_LOGADO,
           int OUTRO_SUPERVISOR_LOGADO,
           int LOGOUT_GT_COM_SUCESSO,
           int OPERADOR_NAO_LOGADO,
           int OUTRO_OPERADOR_LOGADO,
           int LOGOUT_PT_COM_SUCESSO,
           int PRODUTO_DESCONHECIDO,
           int LOGON_DE_SUPERVISOR,
           int LOGOFF_DE_SUPERVISOR,
           int LOGON_DE_OPERADOR,
           int LOGOFF_DE_OPERADOR,
           int RE_NAO_AUTORIZADO,
           int PRODUTO_NAO_DEVE_PASSAR_POR_POSTO,
           int ROTEIRO_INCONSISTENTE,
           int PRODUTO_ENTROU_NAO_CONFORME,
           int DEFEITO_DESCONHECIDO,
           int PRODUTO_NAO_ACEITO,
           int ACOPLAMENTO_FINALIZADO,
           int SEM_SGBD,
           int ERROR_SEM_CALENDARIO,
           int ERROR_GT_DESCONHECIDO,
           int ACAO_DESCONHECIDA,
           int CB_NULO,
           int COMPONENTE_NAO_PERTENCE_AO_PRODUTO,
           int CONFIGURACAO_DESCONHECIDA,
           int ERRO_CONFIGURACAO_SENDO_USADA,
           int ERRO_PEPRO_DESCONHECIDO,
           int ERRO_CC_DESCONHECIDO,
           int COMPONENTE_DESCONHECIDO,
           int LOGIN_MANUTENCAO,
           int LOGIN_AFERICAO,
           int ERRO_EXCLUI_STATIVO_ZERO,
           int CODIGO_DESCONHECIDO,
           int PLANO_DESCONHECIDO,
           int REGISTRO_JA_EXISTE,
           int IMP_CLIENTE_DESCONHECIDO,
           int IMP_PRODUTO_DESCONHECIDO,
           int IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A,
           int IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA,
           int IMP_MES_DESCONHECIDO,
           int IMP_ANO_DESCONHECIDO,
           int IMP_DATA_INVALIDA,
           int IMP_PPNECIMPURL_DESCONHECIDO,
           int NECIMP_DESCONHECIDO,
           int CALENDARIO_DESCONHECIDO,
           int TIPO_PLANO_DESCONHECIDO,
           int NECESSIDADE_DESCONHECIDA,
           int CP_DESCONHECIDA,
           int RAP_DESCONHECIDO,
           int ERROR_PLANO_JA_FIRMADO,
           int ERROR_PLANO_MUITO_ANTIGO,
           int ERROR_PLANO_SEM_CP,
           int ERROR_CICLO_PADRAO,
           int ERRO_PARADA_DESCONHECIDA,
           int idmensagem) {
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.COM_SUCESSO = COM_SUCESSO;
           this.SEM_CONFIGURACAO = SEM_CONFIGURACAO;
           this.PT_DESCONHECIDO = PT_DESCONHECIDO;
           this.TIPO_PT_DESCONHECIDO = TIPO_PT_DESCONHECIDO;
           this.USUARIO_DESCONHECIDO = USUARIO_DESCONHECIDO;
           this.LOGIN_NAO_HOMOLOGADO = LOGIN_NAO_HOMOLOGADO;
           this.LOGIN_GT_COM_SUCESSO = LOGIN_GT_COM_SUCESSO;
           this.LOGIN_GT_PRE_EXISTENTE = LOGIN_GT_PRE_EXISTENTE;
           this.LOGIN_PT_PRE_EXISTENTE = LOGIN_PT_PRE_EXISTENTE;
           this.LOGIN_PT_COM_SUCESSO = LOGIN_PT_COM_SUCESSO;
           this.SUPERVISOR_NAO_LOGADO = SUPERVISOR_NAO_LOGADO;
           this.OUTRO_SUPERVISOR_LOGADO = OUTRO_SUPERVISOR_LOGADO;
           this.LOGOUT_GT_COM_SUCESSO = LOGOUT_GT_COM_SUCESSO;
           this.OPERADOR_NAO_LOGADO = OPERADOR_NAO_LOGADO;
           this.OUTRO_OPERADOR_LOGADO = OUTRO_OPERADOR_LOGADO;
           this.LOGOUT_PT_COM_SUCESSO = LOGOUT_PT_COM_SUCESSO;
           this.PRODUTO_DESCONHECIDO = PRODUTO_DESCONHECIDO;
           this.LOGON_DE_SUPERVISOR = LOGON_DE_SUPERVISOR;
           this.LOGOFF_DE_SUPERVISOR = LOGOFF_DE_SUPERVISOR;
           this.LOGON_DE_OPERADOR = LOGON_DE_OPERADOR;
           this.LOGOFF_DE_OPERADOR = LOGOFF_DE_OPERADOR;
           this.RE_NAO_AUTORIZADO = RE_NAO_AUTORIZADO;
           this.PRODUTO_NAO_DEVE_PASSAR_POR_POSTO = PRODUTO_NAO_DEVE_PASSAR_POR_POSTO;
           this.ROTEIRO_INCONSISTENTE = ROTEIRO_INCONSISTENTE;
           this.PRODUTO_ENTROU_NAO_CONFORME = PRODUTO_ENTROU_NAO_CONFORME;
           this.DEFEITO_DESCONHECIDO = DEFEITO_DESCONHECIDO;
           this.PRODUTO_NAO_ACEITO = PRODUTO_NAO_ACEITO;
           this.ACOPLAMENTO_FINALIZADO = ACOPLAMENTO_FINALIZADO;
           this.SEM_SGBD = SEM_SGBD;
           this.ERROR_SEM_CALENDARIO = ERROR_SEM_CALENDARIO;
           this.ERROR_GT_DESCONHECIDO = ERROR_GT_DESCONHECIDO;
           this.ACAO_DESCONHECIDA = ACAO_DESCONHECIDA;
           this.CB_NULO = CB_NULO;
           this.COMPONENTE_NAO_PERTENCE_AO_PRODUTO = COMPONENTE_NAO_PERTENCE_AO_PRODUTO;
           this.CONFIGURACAO_DESCONHECIDA = CONFIGURACAO_DESCONHECIDA;
           this.ERRO_CONFIGURACAO_SENDO_USADA = ERRO_CONFIGURACAO_SENDO_USADA;
           this.ERRO_PEPRO_DESCONHECIDO = ERRO_PEPRO_DESCONHECIDO;
           this.ERRO_CC_DESCONHECIDO = ERRO_CC_DESCONHECIDO;
           this.COMPONENTE_DESCONHECIDO = COMPONENTE_DESCONHECIDO;
           this.LOGIN_MANUTENCAO = LOGIN_MANUTENCAO;
           this.LOGIN_AFERICAO = LOGIN_AFERICAO;
           this.ERRO_EXCLUI_STATIVO_ZERO = ERRO_EXCLUI_STATIVO_ZERO;
           this.CODIGO_DESCONHECIDO = CODIGO_DESCONHECIDO;
           this.PLANO_DESCONHECIDO = PLANO_DESCONHECIDO;
           this.REGISTRO_JA_EXISTE = REGISTRO_JA_EXISTE;
           this.IMP_CLIENTE_DESCONHECIDO = IMP_CLIENTE_DESCONHECIDO;
           this.IMP_PRODUTO_DESCONHECIDO = IMP_PRODUTO_DESCONHECIDO;
           this.IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A = IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A;
           this.IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA = IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA;
           this.IMP_MES_DESCONHECIDO = IMP_MES_DESCONHECIDO;
           this.IMP_ANO_DESCONHECIDO = IMP_ANO_DESCONHECIDO;
           this.IMP_DATA_INVALIDA = IMP_DATA_INVALIDA;
           this.IMP_PPNECIMPURL_DESCONHECIDO = IMP_PPNECIMPURL_DESCONHECIDO;
           this.NECIMP_DESCONHECIDO = NECIMP_DESCONHECIDO;
           this.CALENDARIO_DESCONHECIDO = CALENDARIO_DESCONHECIDO;
           this.TIPO_PLANO_DESCONHECIDO = TIPO_PLANO_DESCONHECIDO;
           this.NECESSIDADE_DESCONHECIDA = NECESSIDADE_DESCONHECIDA;
           this.CP_DESCONHECIDA = CP_DESCONHECIDA;
           this.RAP_DESCONHECIDO = RAP_DESCONHECIDO;
           this.ERROR_PLANO_JA_FIRMADO = ERROR_PLANO_JA_FIRMADO;
           this.ERROR_PLANO_MUITO_ANTIGO = ERROR_PLANO_MUITO_ANTIGO;
           this.ERROR_PLANO_SEM_CP = ERROR_PLANO_SEM_CP;
           this.ERROR_CICLO_PADRAO = ERROR_CICLO_PADRAO;
           this.ERRO_PARADA_DESCONHECIDA = ERRO_PARADA_DESCONHECIDA;
           this.idmensagem = idmensagem;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the COM_SUCESSO value for this ResultadoDTO.
     * 
     * @return COM_SUCESSO
     */
    public int getCOM_SUCESSO() {
        return COM_SUCESSO;
    }


    /**
     * Sets the COM_SUCESSO value for this ResultadoDTO.
     * 
     * @param COM_SUCESSO
     */
    public void setCOM_SUCESSO(int COM_SUCESSO) {
        this.COM_SUCESSO = COM_SUCESSO;
    }


    /**
     * Gets the SEM_CONFIGURACAO value for this ResultadoDTO.
     * 
     * @return SEM_CONFIGURACAO
     */
    public int getSEM_CONFIGURACAO() {
        return SEM_CONFIGURACAO;
    }


    /**
     * Sets the SEM_CONFIGURACAO value for this ResultadoDTO.
     * 
     * @param SEM_CONFIGURACAO
     */
    public void setSEM_CONFIGURACAO(int SEM_CONFIGURACAO) {
        this.SEM_CONFIGURACAO = SEM_CONFIGURACAO;
    }


    /**
     * Gets the PT_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return PT_DESCONHECIDO
     */
    public int getPT_DESCONHECIDO() {
        return PT_DESCONHECIDO;
    }


    /**
     * Sets the PT_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param PT_DESCONHECIDO
     */
    public void setPT_DESCONHECIDO(int PT_DESCONHECIDO) {
        this.PT_DESCONHECIDO = PT_DESCONHECIDO;
    }


    /**
     * Gets the TIPO_PT_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return TIPO_PT_DESCONHECIDO
     */
    public int getTIPO_PT_DESCONHECIDO() {
        return TIPO_PT_DESCONHECIDO;
    }


    /**
     * Sets the TIPO_PT_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param TIPO_PT_DESCONHECIDO
     */
    public void setTIPO_PT_DESCONHECIDO(int TIPO_PT_DESCONHECIDO) {
        this.TIPO_PT_DESCONHECIDO = TIPO_PT_DESCONHECIDO;
    }


    /**
     * Gets the USUARIO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return USUARIO_DESCONHECIDO
     */
    public int getUSUARIO_DESCONHECIDO() {
        return USUARIO_DESCONHECIDO;
    }


    /**
     * Sets the USUARIO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param USUARIO_DESCONHECIDO
     */
    public void setUSUARIO_DESCONHECIDO(int USUARIO_DESCONHECIDO) {
        this.USUARIO_DESCONHECIDO = USUARIO_DESCONHECIDO;
    }


    /**
     * Gets the LOGIN_NAO_HOMOLOGADO value for this ResultadoDTO.
     * 
     * @return LOGIN_NAO_HOMOLOGADO
     */
    public int getLOGIN_NAO_HOMOLOGADO() {
        return LOGIN_NAO_HOMOLOGADO;
    }


    /**
     * Sets the LOGIN_NAO_HOMOLOGADO value for this ResultadoDTO.
     * 
     * @param LOGIN_NAO_HOMOLOGADO
     */
    public void setLOGIN_NAO_HOMOLOGADO(int LOGIN_NAO_HOMOLOGADO) {
        this.LOGIN_NAO_HOMOLOGADO = LOGIN_NAO_HOMOLOGADO;
    }


    /**
     * Gets the LOGIN_GT_COM_SUCESSO value for this ResultadoDTO.
     * 
     * @return LOGIN_GT_COM_SUCESSO
     */
    public int getLOGIN_GT_COM_SUCESSO() {
        return LOGIN_GT_COM_SUCESSO;
    }


    /**
     * Sets the LOGIN_GT_COM_SUCESSO value for this ResultadoDTO.
     * 
     * @param LOGIN_GT_COM_SUCESSO
     */
    public void setLOGIN_GT_COM_SUCESSO(int LOGIN_GT_COM_SUCESSO) {
        this.LOGIN_GT_COM_SUCESSO = LOGIN_GT_COM_SUCESSO;
    }


    /**
     * Gets the LOGIN_GT_PRE_EXISTENTE value for this ResultadoDTO.
     * 
     * @return LOGIN_GT_PRE_EXISTENTE
     */
    public int getLOGIN_GT_PRE_EXISTENTE() {
        return LOGIN_GT_PRE_EXISTENTE;
    }


    /**
     * Sets the LOGIN_GT_PRE_EXISTENTE value for this ResultadoDTO.
     * 
     * @param LOGIN_GT_PRE_EXISTENTE
     */
    public void setLOGIN_GT_PRE_EXISTENTE(int LOGIN_GT_PRE_EXISTENTE) {
        this.LOGIN_GT_PRE_EXISTENTE = LOGIN_GT_PRE_EXISTENTE;
    }


    /**
     * Gets the LOGIN_PT_PRE_EXISTENTE value for this ResultadoDTO.
     * 
     * @return LOGIN_PT_PRE_EXISTENTE
     */
    public int getLOGIN_PT_PRE_EXISTENTE() {
        return LOGIN_PT_PRE_EXISTENTE;
    }


    /**
     * Sets the LOGIN_PT_PRE_EXISTENTE value for this ResultadoDTO.
     * 
     * @param LOGIN_PT_PRE_EXISTENTE
     */
    public void setLOGIN_PT_PRE_EXISTENTE(int LOGIN_PT_PRE_EXISTENTE) {
        this.LOGIN_PT_PRE_EXISTENTE = LOGIN_PT_PRE_EXISTENTE;
    }


    /**
     * Gets the LOGIN_PT_COM_SUCESSO value for this ResultadoDTO.
     * 
     * @return LOGIN_PT_COM_SUCESSO
     */
    public int getLOGIN_PT_COM_SUCESSO() {
        return LOGIN_PT_COM_SUCESSO;
    }


    /**
     * Sets the LOGIN_PT_COM_SUCESSO value for this ResultadoDTO.
     * 
     * @param LOGIN_PT_COM_SUCESSO
     */
    public void setLOGIN_PT_COM_SUCESSO(int LOGIN_PT_COM_SUCESSO) {
        this.LOGIN_PT_COM_SUCESSO = LOGIN_PT_COM_SUCESSO;
    }


    /**
     * Gets the SUPERVISOR_NAO_LOGADO value for this ResultadoDTO.
     * 
     * @return SUPERVISOR_NAO_LOGADO
     */
    public int getSUPERVISOR_NAO_LOGADO() {
        return SUPERVISOR_NAO_LOGADO;
    }


    /**
     * Sets the SUPERVISOR_NAO_LOGADO value for this ResultadoDTO.
     * 
     * @param SUPERVISOR_NAO_LOGADO
     */
    public void setSUPERVISOR_NAO_LOGADO(int SUPERVISOR_NAO_LOGADO) {
        this.SUPERVISOR_NAO_LOGADO = SUPERVISOR_NAO_LOGADO;
    }


    /**
     * Gets the OUTRO_SUPERVISOR_LOGADO value for this ResultadoDTO.
     * 
     * @return OUTRO_SUPERVISOR_LOGADO
     */
    public int getOUTRO_SUPERVISOR_LOGADO() {
        return OUTRO_SUPERVISOR_LOGADO;
    }


    /**
     * Sets the OUTRO_SUPERVISOR_LOGADO value for this ResultadoDTO.
     * 
     * @param OUTRO_SUPERVISOR_LOGADO
     */
    public void setOUTRO_SUPERVISOR_LOGADO(int OUTRO_SUPERVISOR_LOGADO) {
        this.OUTRO_SUPERVISOR_LOGADO = OUTRO_SUPERVISOR_LOGADO;
    }


    /**
     * Gets the LOGOUT_GT_COM_SUCESSO value for this ResultadoDTO.
     * 
     * @return LOGOUT_GT_COM_SUCESSO
     */
    public int getLOGOUT_GT_COM_SUCESSO() {
        return LOGOUT_GT_COM_SUCESSO;
    }


    /**
     * Sets the LOGOUT_GT_COM_SUCESSO value for this ResultadoDTO.
     * 
     * @param LOGOUT_GT_COM_SUCESSO
     */
    public void setLOGOUT_GT_COM_SUCESSO(int LOGOUT_GT_COM_SUCESSO) {
        this.LOGOUT_GT_COM_SUCESSO = LOGOUT_GT_COM_SUCESSO;
    }


    /**
     * Gets the OPERADOR_NAO_LOGADO value for this ResultadoDTO.
     * 
     * @return OPERADOR_NAO_LOGADO
     */
    public int getOPERADOR_NAO_LOGADO() {
        return OPERADOR_NAO_LOGADO;
    }


    /**
     * Sets the OPERADOR_NAO_LOGADO value for this ResultadoDTO.
     * 
     * @param OPERADOR_NAO_LOGADO
     */
    public void setOPERADOR_NAO_LOGADO(int OPERADOR_NAO_LOGADO) {
        this.OPERADOR_NAO_LOGADO = OPERADOR_NAO_LOGADO;
    }


    /**
     * Gets the OUTRO_OPERADOR_LOGADO value for this ResultadoDTO.
     * 
     * @return OUTRO_OPERADOR_LOGADO
     */
    public int getOUTRO_OPERADOR_LOGADO() {
        return OUTRO_OPERADOR_LOGADO;
    }


    /**
     * Sets the OUTRO_OPERADOR_LOGADO value for this ResultadoDTO.
     * 
     * @param OUTRO_OPERADOR_LOGADO
     */
    public void setOUTRO_OPERADOR_LOGADO(int OUTRO_OPERADOR_LOGADO) {
        this.OUTRO_OPERADOR_LOGADO = OUTRO_OPERADOR_LOGADO;
    }


    /**
     * Gets the LOGOUT_PT_COM_SUCESSO value for this ResultadoDTO.
     * 
     * @return LOGOUT_PT_COM_SUCESSO
     */
    public int getLOGOUT_PT_COM_SUCESSO() {
        return LOGOUT_PT_COM_SUCESSO;
    }


    /**
     * Sets the LOGOUT_PT_COM_SUCESSO value for this ResultadoDTO.
     * 
     * @param LOGOUT_PT_COM_SUCESSO
     */
    public void setLOGOUT_PT_COM_SUCESSO(int LOGOUT_PT_COM_SUCESSO) {
        this.LOGOUT_PT_COM_SUCESSO = LOGOUT_PT_COM_SUCESSO;
    }


    /**
     * Gets the PRODUTO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return PRODUTO_DESCONHECIDO
     */
    public int getPRODUTO_DESCONHECIDO() {
        return PRODUTO_DESCONHECIDO;
    }


    /**
     * Sets the PRODUTO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param PRODUTO_DESCONHECIDO
     */
    public void setPRODUTO_DESCONHECIDO(int PRODUTO_DESCONHECIDO) {
        this.PRODUTO_DESCONHECIDO = PRODUTO_DESCONHECIDO;
    }


    /**
     * Gets the LOGON_DE_SUPERVISOR value for this ResultadoDTO.
     * 
     * @return LOGON_DE_SUPERVISOR
     */
    public int getLOGON_DE_SUPERVISOR() {
        return LOGON_DE_SUPERVISOR;
    }


    /**
     * Sets the LOGON_DE_SUPERVISOR value for this ResultadoDTO.
     * 
     * @param LOGON_DE_SUPERVISOR
     */
    public void setLOGON_DE_SUPERVISOR(int LOGON_DE_SUPERVISOR) {
        this.LOGON_DE_SUPERVISOR = LOGON_DE_SUPERVISOR;
    }


    /**
     * Gets the LOGOFF_DE_SUPERVISOR value for this ResultadoDTO.
     * 
     * @return LOGOFF_DE_SUPERVISOR
     */
    public int getLOGOFF_DE_SUPERVISOR() {
        return LOGOFF_DE_SUPERVISOR;
    }


    /**
     * Sets the LOGOFF_DE_SUPERVISOR value for this ResultadoDTO.
     * 
     * @param LOGOFF_DE_SUPERVISOR
     */
    public void setLOGOFF_DE_SUPERVISOR(int LOGOFF_DE_SUPERVISOR) {
        this.LOGOFF_DE_SUPERVISOR = LOGOFF_DE_SUPERVISOR;
    }


    /**
     * Gets the LOGON_DE_OPERADOR value for this ResultadoDTO.
     * 
     * @return LOGON_DE_OPERADOR
     */
    public int getLOGON_DE_OPERADOR() {
        return LOGON_DE_OPERADOR;
    }


    /**
     * Sets the LOGON_DE_OPERADOR value for this ResultadoDTO.
     * 
     * @param LOGON_DE_OPERADOR
     */
    public void setLOGON_DE_OPERADOR(int LOGON_DE_OPERADOR) {
        this.LOGON_DE_OPERADOR = LOGON_DE_OPERADOR;
    }


    /**
     * Gets the LOGOFF_DE_OPERADOR value for this ResultadoDTO.
     * 
     * @return LOGOFF_DE_OPERADOR
     */
    public int getLOGOFF_DE_OPERADOR() {
        return LOGOFF_DE_OPERADOR;
    }


    /**
     * Sets the LOGOFF_DE_OPERADOR value for this ResultadoDTO.
     * 
     * @param LOGOFF_DE_OPERADOR
     */
    public void setLOGOFF_DE_OPERADOR(int LOGOFF_DE_OPERADOR) {
        this.LOGOFF_DE_OPERADOR = LOGOFF_DE_OPERADOR;
    }


    /**
     * Gets the RE_NAO_AUTORIZADO value for this ResultadoDTO.
     * 
     * @return RE_NAO_AUTORIZADO
     */
    public int getRE_NAO_AUTORIZADO() {
        return RE_NAO_AUTORIZADO;
    }


    /**
     * Sets the RE_NAO_AUTORIZADO value for this ResultadoDTO.
     * 
     * @param RE_NAO_AUTORIZADO
     */
    public void setRE_NAO_AUTORIZADO(int RE_NAO_AUTORIZADO) {
        this.RE_NAO_AUTORIZADO = RE_NAO_AUTORIZADO;
    }


    /**
     * Gets the PRODUTO_NAO_DEVE_PASSAR_POR_POSTO value for this ResultadoDTO.
     * 
     * @return PRODUTO_NAO_DEVE_PASSAR_POR_POSTO
     */
    public int getPRODUTO_NAO_DEVE_PASSAR_POR_POSTO() {
        return PRODUTO_NAO_DEVE_PASSAR_POR_POSTO;
    }


    /**
     * Sets the PRODUTO_NAO_DEVE_PASSAR_POR_POSTO value for this ResultadoDTO.
     * 
     * @param PRODUTO_NAO_DEVE_PASSAR_POR_POSTO
     */
    public void setPRODUTO_NAO_DEVE_PASSAR_POR_POSTO(int PRODUTO_NAO_DEVE_PASSAR_POR_POSTO) {
        this.PRODUTO_NAO_DEVE_PASSAR_POR_POSTO = PRODUTO_NAO_DEVE_PASSAR_POR_POSTO;
    }


    /**
     * Gets the ROTEIRO_INCONSISTENTE value for this ResultadoDTO.
     * 
     * @return ROTEIRO_INCONSISTENTE
     */
    public int getROTEIRO_INCONSISTENTE() {
        return ROTEIRO_INCONSISTENTE;
    }


    /**
     * Sets the ROTEIRO_INCONSISTENTE value for this ResultadoDTO.
     * 
     * @param ROTEIRO_INCONSISTENTE
     */
    public void setROTEIRO_INCONSISTENTE(int ROTEIRO_INCONSISTENTE) {
        this.ROTEIRO_INCONSISTENTE = ROTEIRO_INCONSISTENTE;
    }


    /**
     * Gets the PRODUTO_ENTROU_NAO_CONFORME value for this ResultadoDTO.
     * 
     * @return PRODUTO_ENTROU_NAO_CONFORME
     */
    public int getPRODUTO_ENTROU_NAO_CONFORME() {
        return PRODUTO_ENTROU_NAO_CONFORME;
    }


    /**
     * Sets the PRODUTO_ENTROU_NAO_CONFORME value for this ResultadoDTO.
     * 
     * @param PRODUTO_ENTROU_NAO_CONFORME
     */
    public void setPRODUTO_ENTROU_NAO_CONFORME(int PRODUTO_ENTROU_NAO_CONFORME) {
        this.PRODUTO_ENTROU_NAO_CONFORME = PRODUTO_ENTROU_NAO_CONFORME;
    }


    /**
     * Gets the DEFEITO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return DEFEITO_DESCONHECIDO
     */
    public int getDEFEITO_DESCONHECIDO() {
        return DEFEITO_DESCONHECIDO;
    }


    /**
     * Sets the DEFEITO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param DEFEITO_DESCONHECIDO
     */
    public void setDEFEITO_DESCONHECIDO(int DEFEITO_DESCONHECIDO) {
        this.DEFEITO_DESCONHECIDO = DEFEITO_DESCONHECIDO;
    }


    /**
     * Gets the PRODUTO_NAO_ACEITO value for this ResultadoDTO.
     * 
     * @return PRODUTO_NAO_ACEITO
     */
    public int getPRODUTO_NAO_ACEITO() {
        return PRODUTO_NAO_ACEITO;
    }


    /**
     * Sets the PRODUTO_NAO_ACEITO value for this ResultadoDTO.
     * 
     * @param PRODUTO_NAO_ACEITO
     */
    public void setPRODUTO_NAO_ACEITO(int PRODUTO_NAO_ACEITO) {
        this.PRODUTO_NAO_ACEITO = PRODUTO_NAO_ACEITO;
    }


    /**
     * Gets the ACOPLAMENTO_FINALIZADO value for this ResultadoDTO.
     * 
     * @return ACOPLAMENTO_FINALIZADO
     */
    public int getACOPLAMENTO_FINALIZADO() {
        return ACOPLAMENTO_FINALIZADO;
    }


    /**
     * Sets the ACOPLAMENTO_FINALIZADO value for this ResultadoDTO.
     * 
     * @param ACOPLAMENTO_FINALIZADO
     */
    public void setACOPLAMENTO_FINALIZADO(int ACOPLAMENTO_FINALIZADO) {
        this.ACOPLAMENTO_FINALIZADO = ACOPLAMENTO_FINALIZADO;
    }


    /**
     * Gets the SEM_SGBD value for this ResultadoDTO.
     * 
     * @return SEM_SGBD
     */
    public int getSEM_SGBD() {
        return SEM_SGBD;
    }


    /**
     * Sets the SEM_SGBD value for this ResultadoDTO.
     * 
     * @param SEM_SGBD
     */
    public void setSEM_SGBD(int SEM_SGBD) {
        this.SEM_SGBD = SEM_SGBD;
    }


    /**
     * Gets the ERROR_SEM_CALENDARIO value for this ResultadoDTO.
     * 
     * @return ERROR_SEM_CALENDARIO
     */
    public int getERROR_SEM_CALENDARIO() {
        return ERROR_SEM_CALENDARIO;
    }


    /**
     * Sets the ERROR_SEM_CALENDARIO value for this ResultadoDTO.
     * 
     * @param ERROR_SEM_CALENDARIO
     */
    public void setERROR_SEM_CALENDARIO(int ERROR_SEM_CALENDARIO) {
        this.ERROR_SEM_CALENDARIO = ERROR_SEM_CALENDARIO;
    }


    /**
     * Gets the ERROR_GT_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return ERROR_GT_DESCONHECIDO
     */
    public int getERROR_GT_DESCONHECIDO() {
        return ERROR_GT_DESCONHECIDO;
    }


    /**
     * Sets the ERROR_GT_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param ERROR_GT_DESCONHECIDO
     */
    public void setERROR_GT_DESCONHECIDO(int ERROR_GT_DESCONHECIDO) {
        this.ERROR_GT_DESCONHECIDO = ERROR_GT_DESCONHECIDO;
    }


    /**
     * Gets the ACAO_DESCONHECIDA value for this ResultadoDTO.
     * 
     * @return ACAO_DESCONHECIDA
     */
    public int getACAO_DESCONHECIDA() {
        return ACAO_DESCONHECIDA;
    }


    /**
     * Sets the ACAO_DESCONHECIDA value for this ResultadoDTO.
     * 
     * @param ACAO_DESCONHECIDA
     */
    public void setACAO_DESCONHECIDA(int ACAO_DESCONHECIDA) {
        this.ACAO_DESCONHECIDA = ACAO_DESCONHECIDA;
    }


    /**
     * Gets the CB_NULO value for this ResultadoDTO.
     * 
     * @return CB_NULO
     */
    public int getCB_NULO() {
        return CB_NULO;
    }


    /**
     * Sets the CB_NULO value for this ResultadoDTO.
     * 
     * @param CB_NULO
     */
    public void setCB_NULO(int CB_NULO) {
        this.CB_NULO = CB_NULO;
    }


    /**
     * Gets the COMPONENTE_NAO_PERTENCE_AO_PRODUTO value for this ResultadoDTO.
     * 
     * @return COMPONENTE_NAO_PERTENCE_AO_PRODUTO
     */
    public int getCOMPONENTE_NAO_PERTENCE_AO_PRODUTO() {
        return COMPONENTE_NAO_PERTENCE_AO_PRODUTO;
    }


    /**
     * Sets the COMPONENTE_NAO_PERTENCE_AO_PRODUTO value for this ResultadoDTO.
     * 
     * @param COMPONENTE_NAO_PERTENCE_AO_PRODUTO
     */
    public void setCOMPONENTE_NAO_PERTENCE_AO_PRODUTO(int COMPONENTE_NAO_PERTENCE_AO_PRODUTO) {
        this.COMPONENTE_NAO_PERTENCE_AO_PRODUTO = COMPONENTE_NAO_PERTENCE_AO_PRODUTO;
    }


    /**
     * Gets the CONFIGURACAO_DESCONHECIDA value for this ResultadoDTO.
     * 
     * @return CONFIGURACAO_DESCONHECIDA
     */
    public int getCONFIGURACAO_DESCONHECIDA() {
        return CONFIGURACAO_DESCONHECIDA;
    }


    /**
     * Sets the CONFIGURACAO_DESCONHECIDA value for this ResultadoDTO.
     * 
     * @param CONFIGURACAO_DESCONHECIDA
     */
    public void setCONFIGURACAO_DESCONHECIDA(int CONFIGURACAO_DESCONHECIDA) {
        this.CONFIGURACAO_DESCONHECIDA = CONFIGURACAO_DESCONHECIDA;
    }


    /**
     * Gets the ERRO_CONFIGURACAO_SENDO_USADA value for this ResultadoDTO.
     * 
     * @return ERRO_CONFIGURACAO_SENDO_USADA
     */
    public int getERRO_CONFIGURACAO_SENDO_USADA() {
        return ERRO_CONFIGURACAO_SENDO_USADA;
    }


    /**
     * Sets the ERRO_CONFIGURACAO_SENDO_USADA value for this ResultadoDTO.
     * 
     * @param ERRO_CONFIGURACAO_SENDO_USADA
     */
    public void setERRO_CONFIGURACAO_SENDO_USADA(int ERRO_CONFIGURACAO_SENDO_USADA) {
        this.ERRO_CONFIGURACAO_SENDO_USADA = ERRO_CONFIGURACAO_SENDO_USADA;
    }


    /**
     * Gets the ERRO_PEPRO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return ERRO_PEPRO_DESCONHECIDO
     */
    public int getERRO_PEPRO_DESCONHECIDO() {
        return ERRO_PEPRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_PEPRO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param ERRO_PEPRO_DESCONHECIDO
     */
    public void setERRO_PEPRO_DESCONHECIDO(int ERRO_PEPRO_DESCONHECIDO) {
        this.ERRO_PEPRO_DESCONHECIDO = ERRO_PEPRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_CC_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return ERRO_CC_DESCONHECIDO
     */
    public int getERRO_CC_DESCONHECIDO() {
        return ERRO_CC_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_CC_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param ERRO_CC_DESCONHECIDO
     */
    public void setERRO_CC_DESCONHECIDO(int ERRO_CC_DESCONHECIDO) {
        this.ERRO_CC_DESCONHECIDO = ERRO_CC_DESCONHECIDO;
    }


    /**
     * Gets the COMPONENTE_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return COMPONENTE_DESCONHECIDO
     */
    public int getCOMPONENTE_DESCONHECIDO() {
        return COMPONENTE_DESCONHECIDO;
    }


    /**
     * Sets the COMPONENTE_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param COMPONENTE_DESCONHECIDO
     */
    public void setCOMPONENTE_DESCONHECIDO(int COMPONENTE_DESCONHECIDO) {
        this.COMPONENTE_DESCONHECIDO = COMPONENTE_DESCONHECIDO;
    }


    /**
     * Gets the LOGIN_MANUTENCAO value for this ResultadoDTO.
     * 
     * @return LOGIN_MANUTENCAO
     */
    public int getLOGIN_MANUTENCAO() {
        return LOGIN_MANUTENCAO;
    }


    /**
     * Sets the LOGIN_MANUTENCAO value for this ResultadoDTO.
     * 
     * @param LOGIN_MANUTENCAO
     */
    public void setLOGIN_MANUTENCAO(int LOGIN_MANUTENCAO) {
        this.LOGIN_MANUTENCAO = LOGIN_MANUTENCAO;
    }


    /**
     * Gets the LOGIN_AFERICAO value for this ResultadoDTO.
     * 
     * @return LOGIN_AFERICAO
     */
    public int getLOGIN_AFERICAO() {
        return LOGIN_AFERICAO;
    }


    /**
     * Sets the LOGIN_AFERICAO value for this ResultadoDTO.
     * 
     * @param LOGIN_AFERICAO
     */
    public void setLOGIN_AFERICAO(int LOGIN_AFERICAO) {
        this.LOGIN_AFERICAO = LOGIN_AFERICAO;
    }


    /**
     * Gets the ERRO_EXCLUI_STATIVO_ZERO value for this ResultadoDTO.
     * 
     * @return ERRO_EXCLUI_STATIVO_ZERO
     */
    public int getERRO_EXCLUI_STATIVO_ZERO() {
        return ERRO_EXCLUI_STATIVO_ZERO;
    }


    /**
     * Sets the ERRO_EXCLUI_STATIVO_ZERO value for this ResultadoDTO.
     * 
     * @param ERRO_EXCLUI_STATIVO_ZERO
     */
    public void setERRO_EXCLUI_STATIVO_ZERO(int ERRO_EXCLUI_STATIVO_ZERO) {
        this.ERRO_EXCLUI_STATIVO_ZERO = ERRO_EXCLUI_STATIVO_ZERO;
    }


    /**
     * Gets the CODIGO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return CODIGO_DESCONHECIDO
     */
    public int getCODIGO_DESCONHECIDO() {
        return CODIGO_DESCONHECIDO;
    }


    /**
     * Sets the CODIGO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param CODIGO_DESCONHECIDO
     */
    public void setCODIGO_DESCONHECIDO(int CODIGO_DESCONHECIDO) {
        this.CODIGO_DESCONHECIDO = CODIGO_DESCONHECIDO;
    }


    /**
     * Gets the PLANO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return PLANO_DESCONHECIDO
     */
    public int getPLANO_DESCONHECIDO() {
        return PLANO_DESCONHECIDO;
    }


    /**
     * Sets the PLANO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param PLANO_DESCONHECIDO
     */
    public void setPLANO_DESCONHECIDO(int PLANO_DESCONHECIDO) {
        this.PLANO_DESCONHECIDO = PLANO_DESCONHECIDO;
    }


    /**
     * Gets the REGISTRO_JA_EXISTE value for this ResultadoDTO.
     * 
     * @return REGISTRO_JA_EXISTE
     */
    public int getREGISTRO_JA_EXISTE() {
        return REGISTRO_JA_EXISTE;
    }


    /**
     * Sets the REGISTRO_JA_EXISTE value for this ResultadoDTO.
     * 
     * @param REGISTRO_JA_EXISTE
     */
    public void setREGISTRO_JA_EXISTE(int REGISTRO_JA_EXISTE) {
        this.REGISTRO_JA_EXISTE = REGISTRO_JA_EXISTE;
    }


    /**
     * Gets the IMP_CLIENTE_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return IMP_CLIENTE_DESCONHECIDO
     */
    public int getIMP_CLIENTE_DESCONHECIDO() {
        return IMP_CLIENTE_DESCONHECIDO;
    }


    /**
     * Sets the IMP_CLIENTE_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param IMP_CLIENTE_DESCONHECIDO
     */
    public void setIMP_CLIENTE_DESCONHECIDO(int IMP_CLIENTE_DESCONHECIDO) {
        this.IMP_CLIENTE_DESCONHECIDO = IMP_CLIENTE_DESCONHECIDO;
    }


    /**
     * Gets the IMP_PRODUTO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return IMP_PRODUTO_DESCONHECIDO
     */
    public int getIMP_PRODUTO_DESCONHECIDO() {
        return IMP_PRODUTO_DESCONHECIDO;
    }


    /**
     * Sets the IMP_PRODUTO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param IMP_PRODUTO_DESCONHECIDO
     */
    public void setIMP_PRODUTO_DESCONHECIDO(int IMP_PRODUTO_DESCONHECIDO) {
        this.IMP_PRODUTO_DESCONHECIDO = IMP_PRODUTO_DESCONHECIDO;
    }


    /**
     * Gets the IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A value for this ResultadoDTO.
     * 
     * @return IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A
     */
    public int getIMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A() {
        return IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A;
    }


    /**
     * Sets the IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A value for this ResultadoDTO.
     * 
     * @param IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A
     */
    public void setIMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A(int IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A) {
        this.IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A = IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A;
    }


    /**
     * Gets the IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA value for this ResultadoDTO.
     * 
     * @return IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA
     */
    public int getIMP_NAO_EXISTE_QUANTIDADE_PLANEJADA() {
        return IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA;
    }


    /**
     * Sets the IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA value for this ResultadoDTO.
     * 
     * @param IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA
     */
    public void setIMP_NAO_EXISTE_QUANTIDADE_PLANEJADA(int IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA) {
        this.IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA = IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA;
    }


    /**
     * Gets the IMP_MES_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return IMP_MES_DESCONHECIDO
     */
    public int getIMP_MES_DESCONHECIDO() {
        return IMP_MES_DESCONHECIDO;
    }


    /**
     * Sets the IMP_MES_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param IMP_MES_DESCONHECIDO
     */
    public void setIMP_MES_DESCONHECIDO(int IMP_MES_DESCONHECIDO) {
        this.IMP_MES_DESCONHECIDO = IMP_MES_DESCONHECIDO;
    }


    /**
     * Gets the IMP_ANO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return IMP_ANO_DESCONHECIDO
     */
    public int getIMP_ANO_DESCONHECIDO() {
        return IMP_ANO_DESCONHECIDO;
    }


    /**
     * Sets the IMP_ANO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param IMP_ANO_DESCONHECIDO
     */
    public void setIMP_ANO_DESCONHECIDO(int IMP_ANO_DESCONHECIDO) {
        this.IMP_ANO_DESCONHECIDO = IMP_ANO_DESCONHECIDO;
    }


    /**
     * Gets the IMP_DATA_INVALIDA value for this ResultadoDTO.
     * 
     * @return IMP_DATA_INVALIDA
     */
    public int getIMP_DATA_INVALIDA() {
        return IMP_DATA_INVALIDA;
    }


    /**
     * Sets the IMP_DATA_INVALIDA value for this ResultadoDTO.
     * 
     * @param IMP_DATA_INVALIDA
     */
    public void setIMP_DATA_INVALIDA(int IMP_DATA_INVALIDA) {
        this.IMP_DATA_INVALIDA = IMP_DATA_INVALIDA;
    }


    /**
     * Gets the IMP_PPNECIMPURL_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return IMP_PPNECIMPURL_DESCONHECIDO
     */
    public int getIMP_PPNECIMPURL_DESCONHECIDO() {
        return IMP_PPNECIMPURL_DESCONHECIDO;
    }


    /**
     * Sets the IMP_PPNECIMPURL_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param IMP_PPNECIMPURL_DESCONHECIDO
     */
    public void setIMP_PPNECIMPURL_DESCONHECIDO(int IMP_PPNECIMPURL_DESCONHECIDO) {
        this.IMP_PPNECIMPURL_DESCONHECIDO = IMP_PPNECIMPURL_DESCONHECIDO;
    }


    /**
     * Gets the NECIMP_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return NECIMP_DESCONHECIDO
     */
    public int getNECIMP_DESCONHECIDO() {
        return NECIMP_DESCONHECIDO;
    }


    /**
     * Sets the NECIMP_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param NECIMP_DESCONHECIDO
     */
    public void setNECIMP_DESCONHECIDO(int NECIMP_DESCONHECIDO) {
        this.NECIMP_DESCONHECIDO = NECIMP_DESCONHECIDO;
    }


    /**
     * Gets the CALENDARIO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return CALENDARIO_DESCONHECIDO
     */
    public int getCALENDARIO_DESCONHECIDO() {
        return CALENDARIO_DESCONHECIDO;
    }


    /**
     * Sets the CALENDARIO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param CALENDARIO_DESCONHECIDO
     */
    public void setCALENDARIO_DESCONHECIDO(int CALENDARIO_DESCONHECIDO) {
        this.CALENDARIO_DESCONHECIDO = CALENDARIO_DESCONHECIDO;
    }


    /**
     * Gets the TIPO_PLANO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return TIPO_PLANO_DESCONHECIDO
     */
    public int getTIPO_PLANO_DESCONHECIDO() {
        return TIPO_PLANO_DESCONHECIDO;
    }


    /**
     * Sets the TIPO_PLANO_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param TIPO_PLANO_DESCONHECIDO
     */
    public void setTIPO_PLANO_DESCONHECIDO(int TIPO_PLANO_DESCONHECIDO) {
        this.TIPO_PLANO_DESCONHECIDO = TIPO_PLANO_DESCONHECIDO;
    }


    /**
     * Gets the NECESSIDADE_DESCONHECIDA value for this ResultadoDTO.
     * 
     * @return NECESSIDADE_DESCONHECIDA
     */
    public int getNECESSIDADE_DESCONHECIDA() {
        return NECESSIDADE_DESCONHECIDA;
    }


    /**
     * Sets the NECESSIDADE_DESCONHECIDA value for this ResultadoDTO.
     * 
     * @param NECESSIDADE_DESCONHECIDA
     */
    public void setNECESSIDADE_DESCONHECIDA(int NECESSIDADE_DESCONHECIDA) {
        this.NECESSIDADE_DESCONHECIDA = NECESSIDADE_DESCONHECIDA;
    }


    /**
     * Gets the CP_DESCONHECIDA value for this ResultadoDTO.
     * 
     * @return CP_DESCONHECIDA
     */
    public int getCP_DESCONHECIDA() {
        return CP_DESCONHECIDA;
    }


    /**
     * Sets the CP_DESCONHECIDA value for this ResultadoDTO.
     * 
     * @param CP_DESCONHECIDA
     */
    public void setCP_DESCONHECIDA(int CP_DESCONHECIDA) {
        this.CP_DESCONHECIDA = CP_DESCONHECIDA;
    }


    /**
     * Gets the RAP_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @return RAP_DESCONHECIDO
     */
    public int getRAP_DESCONHECIDO() {
        return RAP_DESCONHECIDO;
    }


    /**
     * Sets the RAP_DESCONHECIDO value for this ResultadoDTO.
     * 
     * @param RAP_DESCONHECIDO
     */
    public void setRAP_DESCONHECIDO(int RAP_DESCONHECIDO) {
        this.RAP_DESCONHECIDO = RAP_DESCONHECIDO;
    }


    /**
     * Gets the ERROR_PLANO_JA_FIRMADO value for this ResultadoDTO.
     * 
     * @return ERROR_PLANO_JA_FIRMADO
     */
    public int getERROR_PLANO_JA_FIRMADO() {
        return ERROR_PLANO_JA_FIRMADO;
    }


    /**
     * Sets the ERROR_PLANO_JA_FIRMADO value for this ResultadoDTO.
     * 
     * @param ERROR_PLANO_JA_FIRMADO
     */
    public void setERROR_PLANO_JA_FIRMADO(int ERROR_PLANO_JA_FIRMADO) {
        this.ERROR_PLANO_JA_FIRMADO = ERROR_PLANO_JA_FIRMADO;
    }


    /**
     * Gets the ERROR_PLANO_MUITO_ANTIGO value for this ResultadoDTO.
     * 
     * @return ERROR_PLANO_MUITO_ANTIGO
     */
    public int getERROR_PLANO_MUITO_ANTIGO() {
        return ERROR_PLANO_MUITO_ANTIGO;
    }


    /**
     * Sets the ERROR_PLANO_MUITO_ANTIGO value for this ResultadoDTO.
     * 
     * @param ERROR_PLANO_MUITO_ANTIGO
     */
    public void setERROR_PLANO_MUITO_ANTIGO(int ERROR_PLANO_MUITO_ANTIGO) {
        this.ERROR_PLANO_MUITO_ANTIGO = ERROR_PLANO_MUITO_ANTIGO;
    }


    /**
     * Gets the ERROR_PLANO_SEM_CP value for this ResultadoDTO.
     * 
     * @return ERROR_PLANO_SEM_CP
     */
    public int getERROR_PLANO_SEM_CP() {
        return ERROR_PLANO_SEM_CP;
    }


    /**
     * Sets the ERROR_PLANO_SEM_CP value for this ResultadoDTO.
     * 
     * @param ERROR_PLANO_SEM_CP
     */
    public void setERROR_PLANO_SEM_CP(int ERROR_PLANO_SEM_CP) {
        this.ERROR_PLANO_SEM_CP = ERROR_PLANO_SEM_CP;
    }


    /**
     * Gets the ERROR_CICLO_PADRAO value for this ResultadoDTO.
     * 
     * @return ERROR_CICLO_PADRAO
     */
    public int getERROR_CICLO_PADRAO() {
        return ERROR_CICLO_PADRAO;
    }


    /**
     * Sets the ERROR_CICLO_PADRAO value for this ResultadoDTO.
     * 
     * @param ERROR_CICLO_PADRAO
     */
    public void setERROR_CICLO_PADRAO(int ERROR_CICLO_PADRAO) {
        this.ERROR_CICLO_PADRAO = ERROR_CICLO_PADRAO;
    }


    /**
     * Gets the ERRO_PARADA_DESCONHECIDA value for this ResultadoDTO.
     * 
     * @return ERRO_PARADA_DESCONHECIDA
     */
    public int getERRO_PARADA_DESCONHECIDA() {
        return ERRO_PARADA_DESCONHECIDA;
    }


    /**
     * Sets the ERRO_PARADA_DESCONHECIDA value for this ResultadoDTO.
     * 
     * @param ERRO_PARADA_DESCONHECIDA
     */
    public void setERRO_PARADA_DESCONHECIDA(int ERRO_PARADA_DESCONHECIDA) {
        this.ERRO_PARADA_DESCONHECIDA = ERRO_PARADA_DESCONHECIDA;
    }


    /**
     * Gets the idmensagem value for this ResultadoDTO.
     * 
     * @return idmensagem
     */
    public int getIdmensagem() {
        return idmensagem;
    }


    /**
     * Sets the idmensagem value for this ResultadoDTO.
     * 
     * @param idmensagem
     */
    public void setIdmensagem(int idmensagem) {
        this.idmensagem = idmensagem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResultadoDTO)) return false;
        ResultadoDTO other = (ResultadoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.COM_SUCESSO == other.getCOM_SUCESSO() &&
            this.SEM_CONFIGURACAO == other.getSEM_CONFIGURACAO() &&
            this.PT_DESCONHECIDO == other.getPT_DESCONHECIDO() &&
            this.TIPO_PT_DESCONHECIDO == other.getTIPO_PT_DESCONHECIDO() &&
            this.USUARIO_DESCONHECIDO == other.getUSUARIO_DESCONHECIDO() &&
            this.LOGIN_NAO_HOMOLOGADO == other.getLOGIN_NAO_HOMOLOGADO() &&
            this.LOGIN_GT_COM_SUCESSO == other.getLOGIN_GT_COM_SUCESSO() &&
            this.LOGIN_GT_PRE_EXISTENTE == other.getLOGIN_GT_PRE_EXISTENTE() &&
            this.LOGIN_PT_PRE_EXISTENTE == other.getLOGIN_PT_PRE_EXISTENTE() &&
            this.LOGIN_PT_COM_SUCESSO == other.getLOGIN_PT_COM_SUCESSO() &&
            this.SUPERVISOR_NAO_LOGADO == other.getSUPERVISOR_NAO_LOGADO() &&
            this.OUTRO_SUPERVISOR_LOGADO == other.getOUTRO_SUPERVISOR_LOGADO() &&
            this.LOGOUT_GT_COM_SUCESSO == other.getLOGOUT_GT_COM_SUCESSO() &&
            this.OPERADOR_NAO_LOGADO == other.getOPERADOR_NAO_LOGADO() &&
            this.OUTRO_OPERADOR_LOGADO == other.getOUTRO_OPERADOR_LOGADO() &&
            this.LOGOUT_PT_COM_SUCESSO == other.getLOGOUT_PT_COM_SUCESSO() &&
            this.PRODUTO_DESCONHECIDO == other.getPRODUTO_DESCONHECIDO() &&
            this.LOGON_DE_SUPERVISOR == other.getLOGON_DE_SUPERVISOR() &&
            this.LOGOFF_DE_SUPERVISOR == other.getLOGOFF_DE_SUPERVISOR() &&
            this.LOGON_DE_OPERADOR == other.getLOGON_DE_OPERADOR() &&
            this.LOGOFF_DE_OPERADOR == other.getLOGOFF_DE_OPERADOR() &&
            this.RE_NAO_AUTORIZADO == other.getRE_NAO_AUTORIZADO() &&
            this.PRODUTO_NAO_DEVE_PASSAR_POR_POSTO == other.getPRODUTO_NAO_DEVE_PASSAR_POR_POSTO() &&
            this.ROTEIRO_INCONSISTENTE == other.getROTEIRO_INCONSISTENTE() &&
            this.PRODUTO_ENTROU_NAO_CONFORME == other.getPRODUTO_ENTROU_NAO_CONFORME() &&
            this.DEFEITO_DESCONHECIDO == other.getDEFEITO_DESCONHECIDO() &&
            this.PRODUTO_NAO_ACEITO == other.getPRODUTO_NAO_ACEITO() &&
            this.ACOPLAMENTO_FINALIZADO == other.getACOPLAMENTO_FINALIZADO() &&
            this.SEM_SGBD == other.getSEM_SGBD() &&
            this.ERROR_SEM_CALENDARIO == other.getERROR_SEM_CALENDARIO() &&
            this.ERROR_GT_DESCONHECIDO == other.getERROR_GT_DESCONHECIDO() &&
            this.ACAO_DESCONHECIDA == other.getACAO_DESCONHECIDA() &&
            this.CB_NULO == other.getCB_NULO() &&
            this.COMPONENTE_NAO_PERTENCE_AO_PRODUTO == other.getCOMPONENTE_NAO_PERTENCE_AO_PRODUTO() &&
            this.CONFIGURACAO_DESCONHECIDA == other.getCONFIGURACAO_DESCONHECIDA() &&
            this.ERRO_CONFIGURACAO_SENDO_USADA == other.getERRO_CONFIGURACAO_SENDO_USADA() &&
            this.ERRO_PEPRO_DESCONHECIDO == other.getERRO_PEPRO_DESCONHECIDO() &&
            this.ERRO_CC_DESCONHECIDO == other.getERRO_CC_DESCONHECIDO() &&
            this.COMPONENTE_DESCONHECIDO == other.getCOMPONENTE_DESCONHECIDO() &&
            this.LOGIN_MANUTENCAO == other.getLOGIN_MANUTENCAO() &&
            this.LOGIN_AFERICAO == other.getLOGIN_AFERICAO() &&
            this.ERRO_EXCLUI_STATIVO_ZERO == other.getERRO_EXCLUI_STATIVO_ZERO() &&
            this.CODIGO_DESCONHECIDO == other.getCODIGO_DESCONHECIDO() &&
            this.PLANO_DESCONHECIDO == other.getPLANO_DESCONHECIDO() &&
            this.REGISTRO_JA_EXISTE == other.getREGISTRO_JA_EXISTE() &&
            this.IMP_CLIENTE_DESCONHECIDO == other.getIMP_CLIENTE_DESCONHECIDO() &&
            this.IMP_PRODUTO_DESCONHECIDO == other.getIMP_PRODUTO_DESCONHECIDO() &&
            this.IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A == other.getIMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A() &&
            this.IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA == other.getIMP_NAO_EXISTE_QUANTIDADE_PLANEJADA() &&
            this.IMP_MES_DESCONHECIDO == other.getIMP_MES_DESCONHECIDO() &&
            this.IMP_ANO_DESCONHECIDO == other.getIMP_ANO_DESCONHECIDO() &&
            this.IMP_DATA_INVALIDA == other.getIMP_DATA_INVALIDA() &&
            this.IMP_PPNECIMPURL_DESCONHECIDO == other.getIMP_PPNECIMPURL_DESCONHECIDO() &&
            this.NECIMP_DESCONHECIDO == other.getNECIMP_DESCONHECIDO() &&
            this.CALENDARIO_DESCONHECIDO == other.getCALENDARIO_DESCONHECIDO() &&
            this.TIPO_PLANO_DESCONHECIDO == other.getTIPO_PLANO_DESCONHECIDO() &&
            this.NECESSIDADE_DESCONHECIDA == other.getNECESSIDADE_DESCONHECIDA() &&
            this.CP_DESCONHECIDA == other.getCP_DESCONHECIDA() &&
            this.RAP_DESCONHECIDO == other.getRAP_DESCONHECIDO() &&
            this.ERROR_PLANO_JA_FIRMADO == other.getERROR_PLANO_JA_FIRMADO() &&
            this.ERROR_PLANO_MUITO_ANTIGO == other.getERROR_PLANO_MUITO_ANTIGO() &&
            this.ERROR_PLANO_SEM_CP == other.getERROR_PLANO_SEM_CP() &&
            this.ERROR_CICLO_PADRAO == other.getERROR_CICLO_PADRAO() &&
            this.ERRO_PARADA_DESCONHECIDA == other.getERRO_PARADA_DESCONHECIDA() &&
            this.idmensagem == other.getIdmensagem();
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
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getCOM_SUCESSO();
        _hashCode += getSEM_CONFIGURACAO();
        _hashCode += getPT_DESCONHECIDO();
        _hashCode += getTIPO_PT_DESCONHECIDO();
        _hashCode += getUSUARIO_DESCONHECIDO();
        _hashCode += getLOGIN_NAO_HOMOLOGADO();
        _hashCode += getLOGIN_GT_COM_SUCESSO();
        _hashCode += getLOGIN_GT_PRE_EXISTENTE();
        _hashCode += getLOGIN_PT_PRE_EXISTENTE();
        _hashCode += getLOGIN_PT_COM_SUCESSO();
        _hashCode += getSUPERVISOR_NAO_LOGADO();
        _hashCode += getOUTRO_SUPERVISOR_LOGADO();
        _hashCode += getLOGOUT_GT_COM_SUCESSO();
        _hashCode += getOPERADOR_NAO_LOGADO();
        _hashCode += getOUTRO_OPERADOR_LOGADO();
        _hashCode += getLOGOUT_PT_COM_SUCESSO();
        _hashCode += getPRODUTO_DESCONHECIDO();
        _hashCode += getLOGON_DE_SUPERVISOR();
        _hashCode += getLOGOFF_DE_SUPERVISOR();
        _hashCode += getLOGON_DE_OPERADOR();
        _hashCode += getLOGOFF_DE_OPERADOR();
        _hashCode += getRE_NAO_AUTORIZADO();
        _hashCode += getPRODUTO_NAO_DEVE_PASSAR_POR_POSTO();
        _hashCode += getROTEIRO_INCONSISTENTE();
        _hashCode += getPRODUTO_ENTROU_NAO_CONFORME();
        _hashCode += getDEFEITO_DESCONHECIDO();
        _hashCode += getPRODUTO_NAO_ACEITO();
        _hashCode += getACOPLAMENTO_FINALIZADO();
        _hashCode += getSEM_SGBD();
        _hashCode += getERROR_SEM_CALENDARIO();
        _hashCode += getERROR_GT_DESCONHECIDO();
        _hashCode += getACAO_DESCONHECIDA();
        _hashCode += getCB_NULO();
        _hashCode += getCOMPONENTE_NAO_PERTENCE_AO_PRODUTO();
        _hashCode += getCONFIGURACAO_DESCONHECIDA();
        _hashCode += getERRO_CONFIGURACAO_SENDO_USADA();
        _hashCode += getERRO_PEPRO_DESCONHECIDO();
        _hashCode += getERRO_CC_DESCONHECIDO();
        _hashCode += getCOMPONENTE_DESCONHECIDO();
        _hashCode += getLOGIN_MANUTENCAO();
        _hashCode += getLOGIN_AFERICAO();
        _hashCode += getERRO_EXCLUI_STATIVO_ZERO();
        _hashCode += getCODIGO_DESCONHECIDO();
        _hashCode += getPLANO_DESCONHECIDO();
        _hashCode += getREGISTRO_JA_EXISTE();
        _hashCode += getIMP_CLIENTE_DESCONHECIDO();
        _hashCode += getIMP_PRODUTO_DESCONHECIDO();
        _hashCode += getIMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A();
        _hashCode += getIMP_NAO_EXISTE_QUANTIDADE_PLANEJADA();
        _hashCode += getIMP_MES_DESCONHECIDO();
        _hashCode += getIMP_ANO_DESCONHECIDO();
        _hashCode += getIMP_DATA_INVALIDA();
        _hashCode += getIMP_PPNECIMPURL_DESCONHECIDO();
        _hashCode += getNECIMP_DESCONHECIDO();
        _hashCode += getCALENDARIO_DESCONHECIDO();
        _hashCode += getTIPO_PLANO_DESCONHECIDO();
        _hashCode += getNECESSIDADE_DESCONHECIDA();
        _hashCode += getCP_DESCONHECIDA();
        _hashCode += getRAP_DESCONHECIDO();
        _hashCode += getERROR_PLANO_JA_FIRMADO();
        _hashCode += getERROR_PLANO_MUITO_ANTIGO();
        _hashCode += getERROR_PLANO_SEM_CP();
        _hashCode += getERROR_CICLO_PADRAO();
        _hashCode += getERRO_PARADA_DESCONHECIDA();
        _hashCode += getIdmensagem();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResultadoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COM_SUCESSO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COM_SUCESSO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SEM_CONFIGURACAO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SEM_CONFIGURACAO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PT_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PT_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TIPO_PT_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TIPO_PT_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("USUARIO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "USUARIO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOGIN_NAO_HOMOLOGADO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LOGIN_NAO_HOMOLOGADO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOGIN_GT_COM_SUCESSO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LOGIN_GT_COM_SUCESSO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOGIN_GT_PRE_EXISTENTE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LOGIN_GT_PRE_EXISTENTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOGIN_PT_PRE_EXISTENTE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LOGIN_PT_PRE_EXISTENTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOGIN_PT_COM_SUCESSO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LOGIN_PT_COM_SUCESSO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SUPERVISOR_NAO_LOGADO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SUPERVISOR_NAO_LOGADO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OUTRO_SUPERVISOR_LOGADO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OUTRO_SUPERVISOR_LOGADO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOGOUT_GT_COM_SUCESSO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LOGOUT_GT_COM_SUCESSO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OPERADOR_NAO_LOGADO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OPERADOR_NAO_LOGADO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OUTRO_OPERADOR_LOGADO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OUTRO_OPERADOR_LOGADO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOGOUT_PT_COM_SUCESSO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LOGOUT_PT_COM_SUCESSO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PRODUTO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PRODUTO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOGON_DE_SUPERVISOR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LOGON_DE_SUPERVISOR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOGOFF_DE_SUPERVISOR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LOGOFF_DE_SUPERVISOR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOGON_DE_OPERADOR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LOGON_DE_OPERADOR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOGOFF_DE_OPERADOR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LOGOFF_DE_OPERADOR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RE_NAO_AUTORIZADO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RE_NAO_AUTORIZADO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PRODUTO_NAO_DEVE_PASSAR_POR_POSTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PRODUTO_NAO_DEVE_PASSAR_POR_POSTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ROTEIRO_INCONSISTENTE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ROTEIRO_INCONSISTENTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PRODUTO_ENTROU_NAO_CONFORME");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PRODUTO_ENTROU_NAO_CONFORME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DEFEITO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DEFEITO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PRODUTO_NAO_ACEITO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PRODUTO_NAO_ACEITO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ACOPLAMENTO_FINALIZADO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ACOPLAMENTO_FINALIZADO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SEM_SGBD");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SEM_SGBD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERROR_SEM_CALENDARIO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERROR_SEM_CALENDARIO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERROR_GT_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERROR_GT_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ACAO_DESCONHECIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ACAO_DESCONHECIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CB_NULO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CB_NULO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COMPONENTE_NAO_PERTENCE_AO_PRODUTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COMPONENTE_NAO_PERTENCE_AO_PRODUTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONFIGURACAO_DESCONHECIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONFIGURACAO_DESCONHECIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CONFIGURACAO_SENDO_USADA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CONFIGURACAO_SENDO_USADA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PEPRO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PEPRO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CC_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CC_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COMPONENTE_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COMPONENTE_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOGIN_MANUTENCAO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LOGIN_MANUTENCAO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOGIN_AFERICAO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LOGIN_AFERICAO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_EXCLUI_STATIVO_ZERO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_EXCLUI_STATIVO_ZERO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CODIGO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CODIGO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PLANO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PLANO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("REGISTRO_JA_EXISTE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "REGISTRO_JA_EXISTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMP_CLIENTE_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IMP_CLIENTE_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMP_PRODUTO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IMP_PRODUTO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMP_MES_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IMP_MES_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMP_ANO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IMP_ANO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMP_DATA_INVALIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IMP_DATA_INVALIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMP_PPNECIMPURL_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IMP_PPNECIMPURL_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NECIMP_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NECIMP_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CALENDARIO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CALENDARIO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TIPO_PLANO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TIPO_PLANO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NECESSIDADE_DESCONHECIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NECESSIDADE_DESCONHECIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CP_DESCONHECIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CP_DESCONHECIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RAP_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RAP_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERROR_PLANO_JA_FIRMADO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERROR_PLANO_JA_FIRMADO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERROR_PLANO_MUITO_ANTIGO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERROR_PLANO_MUITO_ANTIGO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERROR_PLANO_SEM_CP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERROR_PLANO_SEM_CP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERROR_CICLO_PADRAO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERROR_CICLO_PADRAO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PARADA_DESCONHECIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PARADA_DESCONHECIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idmensagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idmensagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
