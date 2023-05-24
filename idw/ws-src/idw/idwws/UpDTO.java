/**
 * UpDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class UpDTO  implements java.io.Serializable {
    private boolean bcOffLine;

    private java.lang.Boolean bloqPorParadaSemConexao;

    private java.lang.String cdBc;

    private java.lang.String cdParada;

    private java.lang.String cdRefugo;

    private java.lang.String cd_up;

    private java.lang.String cdmaqestendido;

    private java.lang.String cdproduto;

    private int debounce;

    private java.lang.String dsParada;

    private java.lang.String dsRefugo;

    private java.lang.String ds_up;

    private java.util.Calendar dtHrInicioCiclo;

    private java.util.Calendar dthrIParada;

    private java.util.Calendar dthrIRefugo;

    private java.util.Calendar dthrRevisao;

    private java.util.Calendar dthrStativo;

    private java.lang.String idAcao;

    private java.lang.String idCausa;

    private java.lang.String idJustificativa;

    private java.lang.String idLocal;

    private java.math.BigDecimal idParada;

    private java.lang.String idRdzProduto;

    private java.lang.String idTecnicoDois;

    private java.lang.String idTecnicoResponsavel;

    private java.lang.String idTecnicoUm;

    private java.math.BigDecimal idUp;

    private java.lang.String idUpPDBA;

    private boolean isAlertaProblemaQualidade;

    private boolean isComOP;

    private java.lang.Boolean isComOpSemProducao;

    private java.lang.Boolean isComVariacaoRitmoPend;

    private java.lang.Boolean isEnviarDadosParaIHM;

    private java.lang.Boolean isEnviarDadosParaWS;

    private boolean isInspecaoPendenteExecucao;

    private java.lang.Boolean isManterHistoricoAntesEnvio;

    private java.lang.Boolean isManterRegistroAposTimeout;

    private java.lang.Boolean isParadaSemConexao;

    private idw.idwws.MSalertaDTO[] listaAlertasEmAberto;

    private idw.idwws.AndonDTO[] listaEventosAndonUp;

    private idw.idwws.UsuarioMSDTO[] listaOperadoresLogados;

    private idw.idwws.PrUpProduto[] listaProdutos;

    private idw.idwws.IdwLogger log;

    private java.lang.String loginUsuario;

    private java.lang.String msdthrIRefugo;

    private java.lang.String nropestendido;

    private org.apache.axis.types.UnsignedShort paradaEmAberto;

    private boolean paradaPermiteCorrecao;

    private boolean paradaPersistente;

    private boolean paradaRegulagem;

    private boolean paradaRequerConfirmacaoParaFinalizar;

    private double percCicloPadraoTimeout;

    private boolean permCancelamento;

    private java.lang.String producaoliquida;

    private java.lang.String producaoplanejada;

    private boolean reqCancel;

    private int resultadoUltimaInspecao;

    private java.math.BigDecimal revisao;

    private double segCicloPadrao;

    private boolean sinalCicloAlto;

    private java.math.BigDecimal stAtivo;

    private java.lang.Float tamanhoPacoteCiclos;

    private int tpSessao;

    private boolean upParada;

    private boolean upTrabalhando;

    private idw.idwws.UpIhmDTO[] upihmColetados;

    private double vlEficienciaUltimoCiclo;

    private double msAdcParaAberturaParada;

    public UpDTO() {
    }

    public UpDTO(
           boolean bcOffLine,
           java.lang.Boolean bloqPorParadaSemConexao,
           java.lang.String cdBc,
           java.lang.String cdParada,
           java.lang.String cdRefugo,
           java.lang.String cd_up,
           java.lang.String cdmaqestendido,
           java.lang.String cdproduto,
           int debounce,
           java.lang.String dsParada,
           java.lang.String dsRefugo,
           java.lang.String ds_up,
           java.util.Calendar dtHrInicioCiclo,
           java.util.Calendar dthrIParada,
           java.util.Calendar dthrIRefugo,
           java.util.Calendar dthrRevisao,
           java.util.Calendar dthrStativo,
           java.lang.String idAcao,
           java.lang.String idCausa,
           java.lang.String idJustificativa,
           java.lang.String idLocal,
           java.math.BigDecimal idParada,
           java.lang.String idRdzProduto,
           java.lang.String idTecnicoDois,
           java.lang.String idTecnicoResponsavel,
           java.lang.String idTecnicoUm,
           java.math.BigDecimal idUp,
           java.lang.String idUpPDBA,
           boolean isAlertaProblemaQualidade,
           boolean isComOP,
           java.lang.Boolean isComOpSemProducao,
           java.lang.Boolean isComVariacaoRitmoPend,
           java.lang.Boolean isEnviarDadosParaIHM,
           java.lang.Boolean isEnviarDadosParaWS,
           boolean isInspecaoPendenteExecucao,
           java.lang.Boolean isManterHistoricoAntesEnvio,
           java.lang.Boolean isManterRegistroAposTimeout,
           java.lang.Boolean isParadaSemConexao,
           idw.idwws.MSalertaDTO[] listaAlertasEmAberto,
           idw.idwws.AndonDTO[] listaEventosAndonUp,
           idw.idwws.UsuarioMSDTO[] listaOperadoresLogados,
           idw.idwws.PrUpProduto[] listaProdutos,
           idw.idwws.IdwLogger log,
           java.lang.String loginUsuario,
           java.lang.String msdthrIRefugo,
           java.lang.String nropestendido,
           org.apache.axis.types.UnsignedShort paradaEmAberto,
           boolean paradaPermiteCorrecao,
           boolean paradaPersistente,
           boolean paradaRegulagem,
           boolean paradaRequerConfirmacaoParaFinalizar,
           double percCicloPadraoTimeout,
           boolean permCancelamento,
           java.lang.String producaoliquida,
           java.lang.String producaoplanejada,
           boolean reqCancel,
           int resultadoUltimaInspecao,
           java.math.BigDecimal revisao,
           double segCicloPadrao,
           boolean sinalCicloAlto,
           java.math.BigDecimal stAtivo,
           java.lang.Float tamanhoPacoteCiclos,
           int tpSessao,
           boolean upParada,
           boolean upTrabalhando,
           idw.idwws.UpIhmDTO[] upihmColetados,
           double vlEficienciaUltimoCiclo,
           double msAdcParaAberturaParada) {
           this.bcOffLine = bcOffLine;
           this.bloqPorParadaSemConexao = bloqPorParadaSemConexao;
           this.cdBc = cdBc;
           this.cdParada = cdParada;
           this.cdRefugo = cdRefugo;
           this.cd_up = cd_up;
           this.cdmaqestendido = cdmaqestendido;
           this.cdproduto = cdproduto;
           this.debounce = debounce;
           this.dsParada = dsParada;
           this.dsRefugo = dsRefugo;
           this.ds_up = ds_up;
           this.dtHrInicioCiclo = dtHrInicioCiclo;
           this.dthrIParada = dthrIParada;
           this.dthrIRefugo = dthrIRefugo;
           this.dthrRevisao = dthrRevisao;
           this.dthrStativo = dthrStativo;
           this.idAcao = idAcao;
           this.idCausa = idCausa;
           this.idJustificativa = idJustificativa;
           this.idLocal = idLocal;
           this.idParada = idParada;
           this.idRdzProduto = idRdzProduto;
           this.idTecnicoDois = idTecnicoDois;
           this.idTecnicoResponsavel = idTecnicoResponsavel;
           this.idTecnicoUm = idTecnicoUm;
           this.idUp = idUp;
           this.idUpPDBA = idUpPDBA;
           this.isAlertaProblemaQualidade = isAlertaProblemaQualidade;
           this.isComOP = isComOP;
           this.isComOpSemProducao = isComOpSemProducao;
           this.isComVariacaoRitmoPend = isComVariacaoRitmoPend;
           this.isEnviarDadosParaIHM = isEnviarDadosParaIHM;
           this.isEnviarDadosParaWS = isEnviarDadosParaWS;
           this.isInspecaoPendenteExecucao = isInspecaoPendenteExecucao;
           this.isManterHistoricoAntesEnvio = isManterHistoricoAntesEnvio;
           this.isManterRegistroAposTimeout = isManterRegistroAposTimeout;
           this.isParadaSemConexao = isParadaSemConexao;
           this.listaAlertasEmAberto = listaAlertasEmAberto;
           this.listaEventosAndonUp = listaEventosAndonUp;
           this.listaOperadoresLogados = listaOperadoresLogados;
           this.listaProdutos = listaProdutos;
           this.log = log;
           this.loginUsuario = loginUsuario;
           this.msdthrIRefugo = msdthrIRefugo;
           this.nropestendido = nropestendido;
           this.paradaEmAberto = paradaEmAberto;
           this.paradaPermiteCorrecao = paradaPermiteCorrecao;
           this.paradaPersistente = paradaPersistente;
           this.paradaRegulagem = paradaRegulagem;
           this.paradaRequerConfirmacaoParaFinalizar = paradaRequerConfirmacaoParaFinalizar;
           this.percCicloPadraoTimeout = percCicloPadraoTimeout;
           this.permCancelamento = permCancelamento;
           this.producaoliquida = producaoliquida;
           this.producaoplanejada = producaoplanejada;
           this.reqCancel = reqCancel;
           this.resultadoUltimaInspecao = resultadoUltimaInspecao;
           this.revisao = revisao;
           this.segCicloPadrao = segCicloPadrao;
           this.sinalCicloAlto = sinalCicloAlto;
           this.stAtivo = stAtivo;
           this.tamanhoPacoteCiclos = tamanhoPacoteCiclos;
           this.tpSessao = tpSessao;
           this.upParada = upParada;
           this.upTrabalhando = upTrabalhando;
           this.upihmColetados = upihmColetados;
           this.vlEficienciaUltimoCiclo = vlEficienciaUltimoCiclo;
           this.msAdcParaAberturaParada = msAdcParaAberturaParada;
    }


    /**
     * Gets the bcOffLine value for this UpDTO.
     * 
     * @return bcOffLine
     */
    public boolean isBcOffLine() {
        return bcOffLine;
    }


    /**
     * Sets the bcOffLine value for this UpDTO.
     * 
     * @param bcOffLine
     */
    public void setBcOffLine(boolean bcOffLine) {
        this.bcOffLine = bcOffLine;
    }


    /**
     * Gets the bloqPorParadaSemConexao value for this UpDTO.
     * 
     * @return bloqPorParadaSemConexao
     */
    public java.lang.Boolean getBloqPorParadaSemConexao() {
        return bloqPorParadaSemConexao;
    }


    /**
     * Sets the bloqPorParadaSemConexao value for this UpDTO.
     * 
     * @param bloqPorParadaSemConexao
     */
    public void setBloqPorParadaSemConexao(java.lang.Boolean bloqPorParadaSemConexao) {
        this.bloqPorParadaSemConexao = bloqPorParadaSemConexao;
    }


    /**
     * Gets the cdBc value for this UpDTO.
     * 
     * @return cdBc
     */
    public java.lang.String getCdBc() {
        return cdBc;
    }


    /**
     * Sets the cdBc value for this UpDTO.
     * 
     * @param cdBc
     */
    public void setCdBc(java.lang.String cdBc) {
        this.cdBc = cdBc;
    }


    /**
     * Gets the cdParada value for this UpDTO.
     * 
     * @return cdParada
     */
    public java.lang.String getCdParada() {
        return cdParada;
    }


    /**
     * Sets the cdParada value for this UpDTO.
     * 
     * @param cdParada
     */
    public void setCdParada(java.lang.String cdParada) {
        this.cdParada = cdParada;
    }


    /**
     * Gets the cdRefugo value for this UpDTO.
     * 
     * @return cdRefugo
     */
    public java.lang.String getCdRefugo() {
        return cdRefugo;
    }


    /**
     * Sets the cdRefugo value for this UpDTO.
     * 
     * @param cdRefugo
     */
    public void setCdRefugo(java.lang.String cdRefugo) {
        this.cdRefugo = cdRefugo;
    }


    /**
     * Gets the cd_up value for this UpDTO.
     * 
     * @return cd_up
     */
    public java.lang.String getCd_up() {
        return cd_up;
    }


    /**
     * Sets the cd_up value for this UpDTO.
     * 
     * @param cd_up
     */
    public void setCd_up(java.lang.String cd_up) {
        this.cd_up = cd_up;
    }


    /**
     * Gets the cdmaqestendido value for this UpDTO.
     * 
     * @return cdmaqestendido
     */
    public java.lang.String getCdmaqestendido() {
        return cdmaqestendido;
    }


    /**
     * Sets the cdmaqestendido value for this UpDTO.
     * 
     * @param cdmaqestendido
     */
    public void setCdmaqestendido(java.lang.String cdmaqestendido) {
        this.cdmaqestendido = cdmaqestendido;
    }


    /**
     * Gets the cdproduto value for this UpDTO.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this UpDTO.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the debounce value for this UpDTO.
     * 
     * @return debounce
     */
    public int getDebounce() {
        return debounce;
    }


    /**
     * Sets the debounce value for this UpDTO.
     * 
     * @param debounce
     */
    public void setDebounce(int debounce) {
        this.debounce = debounce;
    }


    /**
     * Gets the dsParada value for this UpDTO.
     * 
     * @return dsParada
     */
    public java.lang.String getDsParada() {
        return dsParada;
    }


    /**
     * Sets the dsParada value for this UpDTO.
     * 
     * @param dsParada
     */
    public void setDsParada(java.lang.String dsParada) {
        this.dsParada = dsParada;
    }


    /**
     * Gets the dsRefugo value for this UpDTO.
     * 
     * @return dsRefugo
     */
    public java.lang.String getDsRefugo() {
        return dsRefugo;
    }


    /**
     * Sets the dsRefugo value for this UpDTO.
     * 
     * @param dsRefugo
     */
    public void setDsRefugo(java.lang.String dsRefugo) {
        this.dsRefugo = dsRefugo;
    }


    /**
     * Gets the ds_up value for this UpDTO.
     * 
     * @return ds_up
     */
    public java.lang.String getDs_up() {
        return ds_up;
    }


    /**
     * Sets the ds_up value for this UpDTO.
     * 
     * @param ds_up
     */
    public void setDs_up(java.lang.String ds_up) {
        this.ds_up = ds_up;
    }


    /**
     * Gets the dtHrInicioCiclo value for this UpDTO.
     * 
     * @return dtHrInicioCiclo
     */
    public java.util.Calendar getDtHrInicioCiclo() {
        return dtHrInicioCiclo;
    }


    /**
     * Sets the dtHrInicioCiclo value for this UpDTO.
     * 
     * @param dtHrInicioCiclo
     */
    public void setDtHrInicioCiclo(java.util.Calendar dtHrInicioCiclo) {
        this.dtHrInicioCiclo = dtHrInicioCiclo;
    }


    /**
     * Gets the dthrIParada value for this UpDTO.
     * 
     * @return dthrIParada
     */
    public java.util.Calendar getDthrIParada() {
        return dthrIParada;
    }


    /**
     * Sets the dthrIParada value for this UpDTO.
     * 
     * @param dthrIParada
     */
    public void setDthrIParada(java.util.Calendar dthrIParada) {
        this.dthrIParada = dthrIParada;
    }


    /**
     * Gets the dthrIRefugo value for this UpDTO.
     * 
     * @return dthrIRefugo
     */
    public java.util.Calendar getDthrIRefugo() {
        return dthrIRefugo;
    }


    /**
     * Sets the dthrIRefugo value for this UpDTO.
     * 
     * @param dthrIRefugo
     */
    public void setDthrIRefugo(java.util.Calendar dthrIRefugo) {
        this.dthrIRefugo = dthrIRefugo;
    }


    /**
     * Gets the dthrRevisao value for this UpDTO.
     * 
     * @return dthrRevisao
     */
    public java.util.Calendar getDthrRevisao() {
        return dthrRevisao;
    }


    /**
     * Sets the dthrRevisao value for this UpDTO.
     * 
     * @param dthrRevisao
     */
    public void setDthrRevisao(java.util.Calendar dthrRevisao) {
        this.dthrRevisao = dthrRevisao;
    }


    /**
     * Gets the dthrStativo value for this UpDTO.
     * 
     * @return dthrStativo
     */
    public java.util.Calendar getDthrStativo() {
        return dthrStativo;
    }


    /**
     * Sets the dthrStativo value for this UpDTO.
     * 
     * @param dthrStativo
     */
    public void setDthrStativo(java.util.Calendar dthrStativo) {
        this.dthrStativo = dthrStativo;
    }


    /**
     * Gets the idAcao value for this UpDTO.
     * 
     * @return idAcao
     */
    public java.lang.String getIdAcao() {
        return idAcao;
    }


    /**
     * Sets the idAcao value for this UpDTO.
     * 
     * @param idAcao
     */
    public void setIdAcao(java.lang.String idAcao) {
        this.idAcao = idAcao;
    }


    /**
     * Gets the idCausa value for this UpDTO.
     * 
     * @return idCausa
     */
    public java.lang.String getIdCausa() {
        return idCausa;
    }


    /**
     * Sets the idCausa value for this UpDTO.
     * 
     * @param idCausa
     */
    public void setIdCausa(java.lang.String idCausa) {
        this.idCausa = idCausa;
    }


    /**
     * Gets the idJustificativa value for this UpDTO.
     * 
     * @return idJustificativa
     */
    public java.lang.String getIdJustificativa() {
        return idJustificativa;
    }


    /**
     * Sets the idJustificativa value for this UpDTO.
     * 
     * @param idJustificativa
     */
    public void setIdJustificativa(java.lang.String idJustificativa) {
        this.idJustificativa = idJustificativa;
    }


    /**
     * Gets the idLocal value for this UpDTO.
     * 
     * @return idLocal
     */
    public java.lang.String getIdLocal() {
        return idLocal;
    }


    /**
     * Sets the idLocal value for this UpDTO.
     * 
     * @param idLocal
     */
    public void setIdLocal(java.lang.String idLocal) {
        this.idLocal = idLocal;
    }


    /**
     * Gets the idParada value for this UpDTO.
     * 
     * @return idParada
     */
    public java.math.BigDecimal getIdParada() {
        return idParada;
    }


    /**
     * Sets the idParada value for this UpDTO.
     * 
     * @param idParada
     */
    public void setIdParada(java.math.BigDecimal idParada) {
        this.idParada = idParada;
    }


    /**
     * Gets the idRdzProduto value for this UpDTO.
     * 
     * @return idRdzProduto
     */
    public java.lang.String getIdRdzProduto() {
        return idRdzProduto;
    }


    /**
     * Sets the idRdzProduto value for this UpDTO.
     * 
     * @param idRdzProduto
     */
    public void setIdRdzProduto(java.lang.String idRdzProduto) {
        this.idRdzProduto = idRdzProduto;
    }


    /**
     * Gets the idTecnicoDois value for this UpDTO.
     * 
     * @return idTecnicoDois
     */
    public java.lang.String getIdTecnicoDois() {
        return idTecnicoDois;
    }


    /**
     * Sets the idTecnicoDois value for this UpDTO.
     * 
     * @param idTecnicoDois
     */
    public void setIdTecnicoDois(java.lang.String idTecnicoDois) {
        this.idTecnicoDois = idTecnicoDois;
    }


    /**
     * Gets the idTecnicoResponsavel value for this UpDTO.
     * 
     * @return idTecnicoResponsavel
     */
    public java.lang.String getIdTecnicoResponsavel() {
        return idTecnicoResponsavel;
    }


    /**
     * Sets the idTecnicoResponsavel value for this UpDTO.
     * 
     * @param idTecnicoResponsavel
     */
    public void setIdTecnicoResponsavel(java.lang.String idTecnicoResponsavel) {
        this.idTecnicoResponsavel = idTecnicoResponsavel;
    }


    /**
     * Gets the idTecnicoUm value for this UpDTO.
     * 
     * @return idTecnicoUm
     */
    public java.lang.String getIdTecnicoUm() {
        return idTecnicoUm;
    }


    /**
     * Sets the idTecnicoUm value for this UpDTO.
     * 
     * @param idTecnicoUm
     */
    public void setIdTecnicoUm(java.lang.String idTecnicoUm) {
        this.idTecnicoUm = idTecnicoUm;
    }


    /**
     * Gets the idUp value for this UpDTO.
     * 
     * @return idUp
     */
    public java.math.BigDecimal getIdUp() {
        return idUp;
    }


    /**
     * Sets the idUp value for this UpDTO.
     * 
     * @param idUp
     */
    public void setIdUp(java.math.BigDecimal idUp) {
        this.idUp = idUp;
    }


    /**
     * Gets the idUpPDBA value for this UpDTO.
     * 
     * @return idUpPDBA
     */
    public java.lang.String getIdUpPDBA() {
        return idUpPDBA;
    }


    /**
     * Sets the idUpPDBA value for this UpDTO.
     * 
     * @param idUpPDBA
     */
    public void setIdUpPDBA(java.lang.String idUpPDBA) {
        this.idUpPDBA = idUpPDBA;
    }


    /**
     * Gets the isAlertaProblemaQualidade value for this UpDTO.
     * 
     * @return isAlertaProblemaQualidade
     */
    public boolean isIsAlertaProblemaQualidade() {
        return isAlertaProblemaQualidade;
    }


    /**
     * Sets the isAlertaProblemaQualidade value for this UpDTO.
     * 
     * @param isAlertaProblemaQualidade
     */
    public void setIsAlertaProblemaQualidade(boolean isAlertaProblemaQualidade) {
        this.isAlertaProblemaQualidade = isAlertaProblemaQualidade;
    }


    /**
     * Gets the isComOP value for this UpDTO.
     * 
     * @return isComOP
     */
    public boolean isIsComOP() {
        return isComOP;
    }


    /**
     * Sets the isComOP value for this UpDTO.
     * 
     * @param isComOP
     */
    public void setIsComOP(boolean isComOP) {
        this.isComOP = isComOP;
    }


    /**
     * Gets the isComOpSemProducao value for this UpDTO.
     * 
     * @return isComOpSemProducao
     */
    public java.lang.Boolean getIsComOpSemProducao() {
        return isComOpSemProducao;
    }


    /**
     * Sets the isComOpSemProducao value for this UpDTO.
     * 
     * @param isComOpSemProducao
     */
    public void setIsComOpSemProducao(java.lang.Boolean isComOpSemProducao) {
        this.isComOpSemProducao = isComOpSemProducao;
    }


    /**
     * Gets the isComVariacaoRitmoPend value for this UpDTO.
     * 
     * @return isComVariacaoRitmoPend
     */
    public java.lang.Boolean getIsComVariacaoRitmoPend() {
        return isComVariacaoRitmoPend;
    }


    /**
     * Sets the isComVariacaoRitmoPend value for this UpDTO.
     * 
     * @param isComVariacaoRitmoPend
     */
    public void setIsComVariacaoRitmoPend(java.lang.Boolean isComVariacaoRitmoPend) {
        this.isComVariacaoRitmoPend = isComVariacaoRitmoPend;
    }


    /**
     * Gets the isEnviarDadosParaIHM value for this UpDTO.
     * 
     * @return isEnviarDadosParaIHM
     */
    public java.lang.Boolean getIsEnviarDadosParaIHM() {
        return isEnviarDadosParaIHM;
    }


    /**
     * Sets the isEnviarDadosParaIHM value for this UpDTO.
     * 
     * @param isEnviarDadosParaIHM
     */
    public void setIsEnviarDadosParaIHM(java.lang.Boolean isEnviarDadosParaIHM) {
        this.isEnviarDadosParaIHM = isEnviarDadosParaIHM;
    }


    /**
     * Gets the isEnviarDadosParaWS value for this UpDTO.
     * 
     * @return isEnviarDadosParaWS
     */
    public java.lang.Boolean getIsEnviarDadosParaWS() {
        return isEnviarDadosParaWS;
    }


    /**
     * Sets the isEnviarDadosParaWS value for this UpDTO.
     * 
     * @param isEnviarDadosParaWS
     */
    public void setIsEnviarDadosParaWS(java.lang.Boolean isEnviarDadosParaWS) {
        this.isEnviarDadosParaWS = isEnviarDadosParaWS;
    }


    /**
     * Gets the isInspecaoPendenteExecucao value for this UpDTO.
     * 
     * @return isInspecaoPendenteExecucao
     */
    public boolean isIsInspecaoPendenteExecucao() {
        return isInspecaoPendenteExecucao;
    }


    /**
     * Sets the isInspecaoPendenteExecucao value for this UpDTO.
     * 
     * @param isInspecaoPendenteExecucao
     */
    public void setIsInspecaoPendenteExecucao(boolean isInspecaoPendenteExecucao) {
        this.isInspecaoPendenteExecucao = isInspecaoPendenteExecucao;
    }


    /**
     * Gets the isManterHistoricoAntesEnvio value for this UpDTO.
     * 
     * @return isManterHistoricoAntesEnvio
     */
    public java.lang.Boolean getIsManterHistoricoAntesEnvio() {
        return isManterHistoricoAntesEnvio;
    }


    /**
     * Sets the isManterHistoricoAntesEnvio value for this UpDTO.
     * 
     * @param isManterHistoricoAntesEnvio
     */
    public void setIsManterHistoricoAntesEnvio(java.lang.Boolean isManterHistoricoAntesEnvio) {
        this.isManterHistoricoAntesEnvio = isManterHistoricoAntesEnvio;
    }


    /**
     * Gets the isManterRegistroAposTimeout value for this UpDTO.
     * 
     * @return isManterRegistroAposTimeout
     */
    public java.lang.Boolean getIsManterRegistroAposTimeout() {
        return isManterRegistroAposTimeout;
    }


    /**
     * Sets the isManterRegistroAposTimeout value for this UpDTO.
     * 
     * @param isManterRegistroAposTimeout
     */
    public void setIsManterRegistroAposTimeout(java.lang.Boolean isManterRegistroAposTimeout) {
        this.isManterRegistroAposTimeout = isManterRegistroAposTimeout;
    }


    /**
     * Gets the isParadaSemConexao value for this UpDTO.
     * 
     * @return isParadaSemConexao
     */
    public java.lang.Boolean getIsParadaSemConexao() {
        return isParadaSemConexao;
    }


    /**
     * Sets the isParadaSemConexao value for this UpDTO.
     * 
     * @param isParadaSemConexao
     */
    public void setIsParadaSemConexao(java.lang.Boolean isParadaSemConexao) {
        this.isParadaSemConexao = isParadaSemConexao;
    }


    /**
     * Gets the listaAlertasEmAberto value for this UpDTO.
     * 
     * @return listaAlertasEmAberto
     */
    public idw.idwws.MSalertaDTO[] getListaAlertasEmAberto() {
        return listaAlertasEmAberto;
    }


    /**
     * Sets the listaAlertasEmAberto value for this UpDTO.
     * 
     * @param listaAlertasEmAberto
     */
    public void setListaAlertasEmAberto(idw.idwws.MSalertaDTO[] listaAlertasEmAberto) {
        this.listaAlertasEmAberto = listaAlertasEmAberto;
    }

    public idw.idwws.MSalertaDTO getListaAlertasEmAberto(int i) {
        return this.listaAlertasEmAberto[i];
    }

    public void setListaAlertasEmAberto(int i, idw.idwws.MSalertaDTO _value) {
        this.listaAlertasEmAberto[i] = _value;
    }


    /**
     * Gets the listaEventosAndonUp value for this UpDTO.
     * 
     * @return listaEventosAndonUp
     */
    public idw.idwws.AndonDTO[] getListaEventosAndonUp() {
        return listaEventosAndonUp;
    }


    /**
     * Sets the listaEventosAndonUp value for this UpDTO.
     * 
     * @param listaEventosAndonUp
     */
    public void setListaEventosAndonUp(idw.idwws.AndonDTO[] listaEventosAndonUp) {
        this.listaEventosAndonUp = listaEventosAndonUp;
    }

    public idw.idwws.AndonDTO getListaEventosAndonUp(int i) {
        return this.listaEventosAndonUp[i];
    }

    public void setListaEventosAndonUp(int i, idw.idwws.AndonDTO _value) {
        this.listaEventosAndonUp[i] = _value;
    }


    /**
     * Gets the listaOperadoresLogados value for this UpDTO.
     * 
     * @return listaOperadoresLogados
     */
    public idw.idwws.UsuarioMSDTO[] getListaOperadoresLogados() {
        return listaOperadoresLogados;
    }


    /**
     * Sets the listaOperadoresLogados value for this UpDTO.
     * 
     * @param listaOperadoresLogados
     */
    public void setListaOperadoresLogados(idw.idwws.UsuarioMSDTO[] listaOperadoresLogados) {
        this.listaOperadoresLogados = listaOperadoresLogados;
    }

    public idw.idwws.UsuarioMSDTO getListaOperadoresLogados(int i) {
        return this.listaOperadoresLogados[i];
    }

    public void setListaOperadoresLogados(int i, idw.idwws.UsuarioMSDTO _value) {
        this.listaOperadoresLogados[i] = _value;
    }


    /**
     * Gets the listaProdutos value for this UpDTO.
     * 
     * @return listaProdutos
     */
    public idw.idwws.PrUpProduto[] getListaProdutos() {
        return listaProdutos;
    }


    /**
     * Sets the listaProdutos value for this UpDTO.
     * 
     * @param listaProdutos
     */
    public void setListaProdutos(idw.idwws.PrUpProduto[] listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public idw.idwws.PrUpProduto getListaProdutos(int i) {
        return this.listaProdutos[i];
    }

    public void setListaProdutos(int i, idw.idwws.PrUpProduto _value) {
        this.listaProdutos[i] = _value;
    }


    /**
     * Gets the log value for this UpDTO.
     * 
     * @return log
     */
    public idw.idwws.IdwLogger getLog() {
        return log;
    }


    /**
     * Sets the log value for this UpDTO.
     * 
     * @param log
     */
    public void setLog(idw.idwws.IdwLogger log) {
        this.log = log;
    }


    /**
     * Gets the loginUsuario value for this UpDTO.
     * 
     * @return loginUsuario
     */
    public java.lang.String getLoginUsuario() {
        return loginUsuario;
    }


    /**
     * Sets the loginUsuario value for this UpDTO.
     * 
     * @param loginUsuario
     */
    public void setLoginUsuario(java.lang.String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }


    /**
     * Gets the msdthrIRefugo value for this UpDTO.
     * 
     * @return msdthrIRefugo
     */
    public java.lang.String getMsdthrIRefugo() {
        return msdthrIRefugo;
    }


    /**
     * Sets the msdthrIRefugo value for this UpDTO.
     * 
     * @param msdthrIRefugo
     */
    public void setMsdthrIRefugo(java.lang.String msdthrIRefugo) {
        this.msdthrIRefugo = msdthrIRefugo;
    }


    /**
     * Gets the nropestendido value for this UpDTO.
     * 
     * @return nropestendido
     */
    public java.lang.String getNropestendido() {
        return nropestendido;
    }


    /**
     * Sets the nropestendido value for this UpDTO.
     * 
     * @param nropestendido
     */
    public void setNropestendido(java.lang.String nropestendido) {
        this.nropestendido = nropestendido;
    }


    /**
     * Gets the paradaEmAberto value for this UpDTO.
     * 
     * @return paradaEmAberto
     */
    public org.apache.axis.types.UnsignedShort getParadaEmAberto() {
        return paradaEmAberto;
    }


    /**
     * Sets the paradaEmAberto value for this UpDTO.
     * 
     * @param paradaEmAberto
     */
    public void setParadaEmAberto(org.apache.axis.types.UnsignedShort paradaEmAberto) {
        this.paradaEmAberto = paradaEmAberto;
    }


    /**
     * Gets the paradaPermiteCorrecao value for this UpDTO.
     * 
     * @return paradaPermiteCorrecao
     */
    public boolean isParadaPermiteCorrecao() {
        return paradaPermiteCorrecao;
    }


    /**
     * Sets the paradaPermiteCorrecao value for this UpDTO.
     * 
     * @param paradaPermiteCorrecao
     */
    public void setParadaPermiteCorrecao(boolean paradaPermiteCorrecao) {
        this.paradaPermiteCorrecao = paradaPermiteCorrecao;
    }


    /**
     * Gets the paradaPersistente value for this UpDTO.
     * 
     * @return paradaPersistente
     */
    public boolean isParadaPersistente() {
        return paradaPersistente;
    }


    /**
     * Sets the paradaPersistente value for this UpDTO.
     * 
     * @param paradaPersistente
     */
    public void setParadaPersistente(boolean paradaPersistente) {
        this.paradaPersistente = paradaPersistente;
    }


    /**
     * Gets the paradaRegulagem value for this UpDTO.
     * 
     * @return paradaRegulagem
     */
    public boolean isParadaRegulagem() {
        return paradaRegulagem;
    }


    /**
     * Sets the paradaRegulagem value for this UpDTO.
     * 
     * @param paradaRegulagem
     */
    public void setParadaRegulagem(boolean paradaRegulagem) {
        this.paradaRegulagem = paradaRegulagem;
    }


    /**
     * Gets the paradaRequerConfirmacaoParaFinalizar value for this UpDTO.
     * 
     * @return paradaRequerConfirmacaoParaFinalizar
     */
    public boolean isParadaRequerConfirmacaoParaFinalizar() {
        return paradaRequerConfirmacaoParaFinalizar;
    }


    /**
     * Sets the paradaRequerConfirmacaoParaFinalizar value for this UpDTO.
     * 
     * @param paradaRequerConfirmacaoParaFinalizar
     */
    public void setParadaRequerConfirmacaoParaFinalizar(boolean paradaRequerConfirmacaoParaFinalizar) {
        this.paradaRequerConfirmacaoParaFinalizar = paradaRequerConfirmacaoParaFinalizar;
    }


    /**
     * Gets the percCicloPadraoTimeout value for this UpDTO.
     * 
     * @return percCicloPadraoTimeout
     */
    public double getPercCicloPadraoTimeout() {
        return percCicloPadraoTimeout;
    }


    /**
     * Sets the percCicloPadraoTimeout value for this UpDTO.
     * 
     * @param percCicloPadraoTimeout
     */
    public void setPercCicloPadraoTimeout(double percCicloPadraoTimeout) {
        this.percCicloPadraoTimeout = percCicloPadraoTimeout;
    }


    /**
     * Gets the permCancelamento value for this UpDTO.
     * 
     * @return permCancelamento
     */
    public boolean isPermCancelamento() {
        return permCancelamento;
    }


    /**
     * Sets the permCancelamento value for this UpDTO.
     * 
     * @param permCancelamento
     */
    public void setPermCancelamento(boolean permCancelamento) {
        this.permCancelamento = permCancelamento;
    }


    /**
     * Gets the producaoliquida value for this UpDTO.
     * 
     * @return producaoliquida
     */
    public java.lang.String getProducaoliquida() {
        return producaoliquida;
    }


    /**
     * Sets the producaoliquida value for this UpDTO.
     * 
     * @param producaoliquida
     */
    public void setProducaoliquida(java.lang.String producaoliquida) {
        this.producaoliquida = producaoliquida;
    }


    /**
     * Gets the producaoplanejada value for this UpDTO.
     * 
     * @return producaoplanejada
     */
    public java.lang.String getProducaoplanejada() {
        return producaoplanejada;
    }


    /**
     * Sets the producaoplanejada value for this UpDTO.
     * 
     * @param producaoplanejada
     */
    public void setProducaoplanejada(java.lang.String producaoplanejada) {
        this.producaoplanejada = producaoplanejada;
    }


    /**
     * Gets the reqCancel value for this UpDTO.
     * 
     * @return reqCancel
     */
    public boolean isReqCancel() {
        return reqCancel;
    }


    /**
     * Sets the reqCancel value for this UpDTO.
     * 
     * @param reqCancel
     */
    public void setReqCancel(boolean reqCancel) {
        this.reqCancel = reqCancel;
    }


    /**
     * Gets the resultadoUltimaInspecao value for this UpDTO.
     * 
     * @return resultadoUltimaInspecao
     */
    public int getResultadoUltimaInspecao() {
        return resultadoUltimaInspecao;
    }


    /**
     * Sets the resultadoUltimaInspecao value for this UpDTO.
     * 
     * @param resultadoUltimaInspecao
     */
    public void setResultadoUltimaInspecao(int resultadoUltimaInspecao) {
        this.resultadoUltimaInspecao = resultadoUltimaInspecao;
    }


    /**
     * Gets the revisao value for this UpDTO.
     * 
     * @return revisao
     */
    public java.math.BigDecimal getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this UpDTO.
     * 
     * @param revisao
     */
    public void setRevisao(java.math.BigDecimal revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the segCicloPadrao value for this UpDTO.
     * 
     * @return segCicloPadrao
     */
    public double getSegCicloPadrao() {
        return segCicloPadrao;
    }


    /**
     * Sets the segCicloPadrao value for this UpDTO.
     * 
     * @param segCicloPadrao
     */
    public void setSegCicloPadrao(double segCicloPadrao) {
        this.segCicloPadrao = segCicloPadrao;
    }


    /**
     * Gets the sinalCicloAlto value for this UpDTO.
     * 
     * @return sinalCicloAlto
     */
    public boolean isSinalCicloAlto() {
        return sinalCicloAlto;
    }


    /**
     * Sets the sinalCicloAlto value for this UpDTO.
     * 
     * @param sinalCicloAlto
     */
    public void setSinalCicloAlto(boolean sinalCicloAlto) {
        this.sinalCicloAlto = sinalCicloAlto;
    }


    /**
     * Gets the stAtivo value for this UpDTO.
     * 
     * @return stAtivo
     */
    public java.math.BigDecimal getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this UpDTO.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.math.BigDecimal stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the tamanhoPacoteCiclos value for this UpDTO.
     * 
     * @return tamanhoPacoteCiclos
     */
    public java.lang.Float getTamanhoPacoteCiclos() {
        return tamanhoPacoteCiclos;
    }


    /**
     * Sets the tamanhoPacoteCiclos value for this UpDTO.
     * 
     * @param tamanhoPacoteCiclos
     */
    public void setTamanhoPacoteCiclos(java.lang.Float tamanhoPacoteCiclos) {
        this.tamanhoPacoteCiclos = tamanhoPacoteCiclos;
    }


    /**
     * Gets the tpSessao value for this UpDTO.
     * 
     * @return tpSessao
     */
    public int getTpSessao() {
        return tpSessao;
    }


    /**
     * Sets the tpSessao value for this UpDTO.
     * 
     * @param tpSessao
     */
    public void setTpSessao(int tpSessao) {
        this.tpSessao = tpSessao;
    }


    /**
     * Gets the upParada value for this UpDTO.
     * 
     * @return upParada
     */
    public boolean isUpParada() {
        return upParada;
    }


    /**
     * Sets the upParada value for this UpDTO.
     * 
     * @param upParada
     */
    public void setUpParada(boolean upParada) {
        this.upParada = upParada;
    }


    /**
     * Gets the upTrabalhando value for this UpDTO.
     * 
     * @return upTrabalhando
     */
    public boolean isUpTrabalhando() {
        return upTrabalhando;
    }


    /**
     * Sets the upTrabalhando value for this UpDTO.
     * 
     * @param upTrabalhando
     */
    public void setUpTrabalhando(boolean upTrabalhando) {
        this.upTrabalhando = upTrabalhando;
    }


    /**
     * Gets the upihmColetados value for this UpDTO.
     * 
     * @return upihmColetados
     */
    public idw.idwws.UpIhmDTO[] getUpihmColetados() {
        return upihmColetados;
    }


    /**
     * Sets the upihmColetados value for this UpDTO.
     * 
     * @param upihmColetados
     */
    public void setUpihmColetados(idw.idwws.UpIhmDTO[] upihmColetados) {
        this.upihmColetados = upihmColetados;
    }

    public idw.idwws.UpIhmDTO getUpihmColetados(int i) {
        return this.upihmColetados[i];
    }

    public void setUpihmColetados(int i, idw.idwws.UpIhmDTO _value) {
        this.upihmColetados[i] = _value;
    }


    /**
     * Gets the vlEficienciaUltimoCiclo value for this UpDTO.
     * 
     * @return vlEficienciaUltimoCiclo
     */
    public double getVlEficienciaUltimoCiclo() {
        return vlEficienciaUltimoCiclo;
    }


    /**
     * Sets the vlEficienciaUltimoCiclo value for this UpDTO.
     * 
     * @param vlEficienciaUltimoCiclo
     */
    public void setVlEficienciaUltimoCiclo(double vlEficienciaUltimoCiclo) {
        this.vlEficienciaUltimoCiclo = vlEficienciaUltimoCiclo;
    }


    /**
     * Gets the msAdcParaAberturaParada value for this UpDTO.
     * 
     * @return msAdcParaAberturaParada
     */
    public double getMsAdcParaAberturaParada() {
        return msAdcParaAberturaParada;
    }


    /**
     * Sets the msAdcParaAberturaParada value for this UpDTO.
     * 
     * @param msAdcParaAberturaParada
     */
    public void setMsAdcParaAberturaParada(double msAdcParaAberturaParada) {
        this.msAdcParaAberturaParada = msAdcParaAberturaParada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpDTO)) return false;
        UpDTO other = (UpDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.bcOffLine == other.isBcOffLine() &&
            ((this.bloqPorParadaSemConexao==null && other.getBloqPorParadaSemConexao()==null) || 
             (this.bloqPorParadaSemConexao!=null &&
              this.bloqPorParadaSemConexao.equals(other.getBloqPorParadaSemConexao()))) &&
            ((this.cdBc==null && other.getCdBc()==null) || 
             (this.cdBc!=null &&
              this.cdBc.equals(other.getCdBc()))) &&
            ((this.cdParada==null && other.getCdParada()==null) || 
             (this.cdParada!=null &&
              this.cdParada.equals(other.getCdParada()))) &&
            ((this.cdRefugo==null && other.getCdRefugo()==null) || 
             (this.cdRefugo!=null &&
              this.cdRefugo.equals(other.getCdRefugo()))) &&
            ((this.cd_up==null && other.getCd_up()==null) || 
             (this.cd_up!=null &&
              this.cd_up.equals(other.getCd_up()))) &&
            ((this.cdmaqestendido==null && other.getCdmaqestendido()==null) || 
             (this.cdmaqestendido!=null &&
              this.cdmaqestendido.equals(other.getCdmaqestendido()))) &&
            ((this.cdproduto==null && other.getCdproduto()==null) || 
             (this.cdproduto!=null &&
              this.cdproduto.equals(other.getCdproduto()))) &&
            this.debounce == other.getDebounce() &&
            ((this.dsParada==null && other.getDsParada()==null) || 
             (this.dsParada!=null &&
              this.dsParada.equals(other.getDsParada()))) &&
            ((this.dsRefugo==null && other.getDsRefugo()==null) || 
             (this.dsRefugo!=null &&
              this.dsRefugo.equals(other.getDsRefugo()))) &&
            ((this.ds_up==null && other.getDs_up()==null) || 
             (this.ds_up!=null &&
              this.ds_up.equals(other.getDs_up()))) &&
            ((this.dtHrInicioCiclo==null && other.getDtHrInicioCiclo()==null) || 
             (this.dtHrInicioCiclo!=null &&
              this.dtHrInicioCiclo.equals(other.getDtHrInicioCiclo()))) &&
            ((this.dthrIParada==null && other.getDthrIParada()==null) || 
             (this.dthrIParada!=null &&
              this.dthrIParada.equals(other.getDthrIParada()))) &&
            ((this.dthrIRefugo==null && other.getDthrIRefugo()==null) || 
             (this.dthrIRefugo!=null &&
              this.dthrIRefugo.equals(other.getDthrIRefugo()))) &&
            ((this.dthrRevisao==null && other.getDthrRevisao()==null) || 
             (this.dthrRevisao!=null &&
              this.dthrRevisao.equals(other.getDthrRevisao()))) &&
            ((this.dthrStativo==null && other.getDthrStativo()==null) || 
             (this.dthrStativo!=null &&
              this.dthrStativo.equals(other.getDthrStativo()))) &&
            ((this.idAcao==null && other.getIdAcao()==null) || 
             (this.idAcao!=null &&
              this.idAcao.equals(other.getIdAcao()))) &&
            ((this.idCausa==null && other.getIdCausa()==null) || 
             (this.idCausa!=null &&
              this.idCausa.equals(other.getIdCausa()))) &&
            ((this.idJustificativa==null && other.getIdJustificativa()==null) || 
             (this.idJustificativa!=null &&
              this.idJustificativa.equals(other.getIdJustificativa()))) &&
            ((this.idLocal==null && other.getIdLocal()==null) || 
             (this.idLocal!=null &&
              this.idLocal.equals(other.getIdLocal()))) &&
            ((this.idParada==null && other.getIdParada()==null) || 
             (this.idParada!=null &&
              this.idParada.equals(other.getIdParada()))) &&
            ((this.idRdzProduto==null && other.getIdRdzProduto()==null) || 
             (this.idRdzProduto!=null &&
              this.idRdzProduto.equals(other.getIdRdzProduto()))) &&
            ((this.idTecnicoDois==null && other.getIdTecnicoDois()==null) || 
             (this.idTecnicoDois!=null &&
              this.idTecnicoDois.equals(other.getIdTecnicoDois()))) &&
            ((this.idTecnicoResponsavel==null && other.getIdTecnicoResponsavel()==null) || 
             (this.idTecnicoResponsavel!=null &&
              this.idTecnicoResponsavel.equals(other.getIdTecnicoResponsavel()))) &&
            ((this.idTecnicoUm==null && other.getIdTecnicoUm()==null) || 
             (this.idTecnicoUm!=null &&
              this.idTecnicoUm.equals(other.getIdTecnicoUm()))) &&
            ((this.idUp==null && other.getIdUp()==null) || 
             (this.idUp!=null &&
              this.idUp.equals(other.getIdUp()))) &&
            ((this.idUpPDBA==null && other.getIdUpPDBA()==null) || 
             (this.idUpPDBA!=null &&
              this.idUpPDBA.equals(other.getIdUpPDBA()))) &&
            this.isAlertaProblemaQualidade == other.isIsAlertaProblemaQualidade() &&
            this.isComOP == other.isIsComOP() &&
            ((this.isComOpSemProducao==null && other.getIsComOpSemProducao()==null) || 
             (this.isComOpSemProducao!=null &&
              this.isComOpSemProducao.equals(other.getIsComOpSemProducao()))) &&
            ((this.isComVariacaoRitmoPend==null && other.getIsComVariacaoRitmoPend()==null) || 
             (this.isComVariacaoRitmoPend!=null &&
              this.isComVariacaoRitmoPend.equals(other.getIsComVariacaoRitmoPend()))) &&
            ((this.isEnviarDadosParaIHM==null && other.getIsEnviarDadosParaIHM()==null) || 
             (this.isEnviarDadosParaIHM!=null &&
              this.isEnviarDadosParaIHM.equals(other.getIsEnviarDadosParaIHM()))) &&
            ((this.isEnviarDadosParaWS==null && other.getIsEnviarDadosParaWS()==null) || 
             (this.isEnviarDadosParaWS!=null &&
              this.isEnviarDadosParaWS.equals(other.getIsEnviarDadosParaWS()))) &&
            this.isInspecaoPendenteExecucao == other.isIsInspecaoPendenteExecucao() &&
            ((this.isManterHistoricoAntesEnvio==null && other.getIsManterHistoricoAntesEnvio()==null) || 
             (this.isManterHistoricoAntesEnvio!=null &&
              this.isManterHistoricoAntesEnvio.equals(other.getIsManterHistoricoAntesEnvio()))) &&
            ((this.isManterRegistroAposTimeout==null && other.getIsManterRegistroAposTimeout()==null) || 
             (this.isManterRegistroAposTimeout!=null &&
              this.isManterRegistroAposTimeout.equals(other.getIsManterRegistroAposTimeout()))) &&
            ((this.isParadaSemConexao==null && other.getIsParadaSemConexao()==null) || 
             (this.isParadaSemConexao!=null &&
              this.isParadaSemConexao.equals(other.getIsParadaSemConexao()))) &&
            ((this.listaAlertasEmAberto==null && other.getListaAlertasEmAberto()==null) || 
             (this.listaAlertasEmAberto!=null &&
              java.util.Arrays.equals(this.listaAlertasEmAberto, other.getListaAlertasEmAberto()))) &&
            ((this.listaEventosAndonUp==null && other.getListaEventosAndonUp()==null) || 
             (this.listaEventosAndonUp!=null &&
              java.util.Arrays.equals(this.listaEventosAndonUp, other.getListaEventosAndonUp()))) &&
            ((this.listaOperadoresLogados==null && other.getListaOperadoresLogados()==null) || 
             (this.listaOperadoresLogados!=null &&
              java.util.Arrays.equals(this.listaOperadoresLogados, other.getListaOperadoresLogados()))) &&
            ((this.listaProdutos==null && other.getListaProdutos()==null) || 
             (this.listaProdutos!=null &&
              java.util.Arrays.equals(this.listaProdutos, other.getListaProdutos()))) &&
            ((this.log==null && other.getLog()==null) || 
             (this.log!=null &&
              this.log.equals(other.getLog()))) &&
            ((this.loginUsuario==null && other.getLoginUsuario()==null) || 
             (this.loginUsuario!=null &&
              this.loginUsuario.equals(other.getLoginUsuario()))) &&
            ((this.msdthrIRefugo==null && other.getMsdthrIRefugo()==null) || 
             (this.msdthrIRefugo!=null &&
              this.msdthrIRefugo.equals(other.getMsdthrIRefugo()))) &&
            ((this.nropestendido==null && other.getNropestendido()==null) || 
             (this.nropestendido!=null &&
              this.nropestendido.equals(other.getNropestendido()))) &&
            ((this.paradaEmAberto==null && other.getParadaEmAberto()==null) || 
             (this.paradaEmAberto!=null &&
              this.paradaEmAberto.equals(other.getParadaEmAberto()))) &&
            this.paradaPermiteCorrecao == other.isParadaPermiteCorrecao() &&
            this.paradaPersistente == other.isParadaPersistente() &&
            this.paradaRegulagem == other.isParadaRegulagem() &&
            this.paradaRequerConfirmacaoParaFinalizar == other.isParadaRequerConfirmacaoParaFinalizar() &&
            this.percCicloPadraoTimeout == other.getPercCicloPadraoTimeout() &&
            this.permCancelamento == other.isPermCancelamento() &&
            ((this.producaoliquida==null && other.getProducaoliquida()==null) || 
             (this.producaoliquida!=null &&
              this.producaoliquida.equals(other.getProducaoliquida()))) &&
            ((this.producaoplanejada==null && other.getProducaoplanejada()==null) || 
             (this.producaoplanejada!=null &&
              this.producaoplanejada.equals(other.getProducaoplanejada()))) &&
            this.reqCancel == other.isReqCancel() &&
            this.resultadoUltimaInspecao == other.getResultadoUltimaInspecao() &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            this.segCicloPadrao == other.getSegCicloPadrao() &&
            this.sinalCicloAlto == other.isSinalCicloAlto() &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.tamanhoPacoteCiclos==null && other.getTamanhoPacoteCiclos()==null) || 
             (this.tamanhoPacoteCiclos!=null &&
              this.tamanhoPacoteCiclos.equals(other.getTamanhoPacoteCiclos()))) &&
            this.tpSessao == other.getTpSessao() &&
            this.upParada == other.isUpParada() &&
            this.upTrabalhando == other.isUpTrabalhando() &&
            ((this.upihmColetados==null && other.getUpihmColetados()==null) || 
             (this.upihmColetados!=null &&
              java.util.Arrays.equals(this.upihmColetados, other.getUpihmColetados()))) &&
            this.vlEficienciaUltimoCiclo == other.getVlEficienciaUltimoCiclo() &&
            this.msAdcParaAberturaParada == other.getMsAdcParaAberturaParada();
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
        _hashCode += (isBcOffLine() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getBloqPorParadaSemConexao() != null) {
            _hashCode += getBloqPorParadaSemConexao().hashCode();
        }
        if (getCdBc() != null) {
            _hashCode += getCdBc().hashCode();
        }
        if (getCdParada() != null) {
            _hashCode += getCdParada().hashCode();
        }
        if (getCdRefugo() != null) {
            _hashCode += getCdRefugo().hashCode();
        }
        if (getCd_up() != null) {
            _hashCode += getCd_up().hashCode();
        }
        if (getCdmaqestendido() != null) {
            _hashCode += getCdmaqestendido().hashCode();
        }
        if (getCdproduto() != null) {
            _hashCode += getCdproduto().hashCode();
        }
        _hashCode += getDebounce();
        if (getDsParada() != null) {
            _hashCode += getDsParada().hashCode();
        }
        if (getDsRefugo() != null) {
            _hashCode += getDsRefugo().hashCode();
        }
        if (getDs_up() != null) {
            _hashCode += getDs_up().hashCode();
        }
        if (getDtHrInicioCiclo() != null) {
            _hashCode += getDtHrInicioCiclo().hashCode();
        }
        if (getDthrIParada() != null) {
            _hashCode += getDthrIParada().hashCode();
        }
        if (getDthrIRefugo() != null) {
            _hashCode += getDthrIRefugo().hashCode();
        }
        if (getDthrRevisao() != null) {
            _hashCode += getDthrRevisao().hashCode();
        }
        if (getDthrStativo() != null) {
            _hashCode += getDthrStativo().hashCode();
        }
        if (getIdAcao() != null) {
            _hashCode += getIdAcao().hashCode();
        }
        if (getIdCausa() != null) {
            _hashCode += getIdCausa().hashCode();
        }
        if (getIdJustificativa() != null) {
            _hashCode += getIdJustificativa().hashCode();
        }
        if (getIdLocal() != null) {
            _hashCode += getIdLocal().hashCode();
        }
        if (getIdParada() != null) {
            _hashCode += getIdParada().hashCode();
        }
        if (getIdRdzProduto() != null) {
            _hashCode += getIdRdzProduto().hashCode();
        }
        if (getIdTecnicoDois() != null) {
            _hashCode += getIdTecnicoDois().hashCode();
        }
        if (getIdTecnicoResponsavel() != null) {
            _hashCode += getIdTecnicoResponsavel().hashCode();
        }
        if (getIdTecnicoUm() != null) {
            _hashCode += getIdTecnicoUm().hashCode();
        }
        if (getIdUp() != null) {
            _hashCode += getIdUp().hashCode();
        }
        if (getIdUpPDBA() != null) {
            _hashCode += getIdUpPDBA().hashCode();
        }
        _hashCode += (isIsAlertaProblemaQualidade() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsComOP() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getIsComOpSemProducao() != null) {
            _hashCode += getIsComOpSemProducao().hashCode();
        }
        if (getIsComVariacaoRitmoPend() != null) {
            _hashCode += getIsComVariacaoRitmoPend().hashCode();
        }
        if (getIsEnviarDadosParaIHM() != null) {
            _hashCode += getIsEnviarDadosParaIHM().hashCode();
        }
        if (getIsEnviarDadosParaWS() != null) {
            _hashCode += getIsEnviarDadosParaWS().hashCode();
        }
        _hashCode += (isIsInspecaoPendenteExecucao() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getIsManterHistoricoAntesEnvio() != null) {
            _hashCode += getIsManterHistoricoAntesEnvio().hashCode();
        }
        if (getIsManterRegistroAposTimeout() != null) {
            _hashCode += getIsManterRegistroAposTimeout().hashCode();
        }
        if (getIsParadaSemConexao() != null) {
            _hashCode += getIsParadaSemConexao().hashCode();
        }
        if (getListaAlertasEmAberto() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaAlertasEmAberto());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaAlertasEmAberto(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaEventosAndonUp() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaEventosAndonUp());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaEventosAndonUp(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaOperadoresLogados() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaOperadoresLogados());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaOperadoresLogados(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaProdutos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaProdutos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaProdutos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLog() != null) {
            _hashCode += getLog().hashCode();
        }
        if (getLoginUsuario() != null) {
            _hashCode += getLoginUsuario().hashCode();
        }
        if (getMsdthrIRefugo() != null) {
            _hashCode += getMsdthrIRefugo().hashCode();
        }
        if (getNropestendido() != null) {
            _hashCode += getNropestendido().hashCode();
        }
        if (getParadaEmAberto() != null) {
            _hashCode += getParadaEmAberto().hashCode();
        }
        _hashCode += (isParadaPermiteCorrecao() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isParadaPersistente() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isParadaRegulagem() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isParadaRequerConfirmacaoParaFinalizar() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += new Double(getPercCicloPadraoTimeout()).hashCode();
        _hashCode += (isPermCancelamento() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getProducaoliquida() != null) {
            _hashCode += getProducaoliquida().hashCode();
        }
        if (getProducaoplanejada() != null) {
            _hashCode += getProducaoplanejada().hashCode();
        }
        _hashCode += (isReqCancel() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getResultadoUltimaInspecao();
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        _hashCode += new Double(getSegCicloPadrao()).hashCode();
        _hashCode += (isSinalCicloAlto() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        if (getTamanhoPacoteCiclos() != null) {
            _hashCode += getTamanhoPacoteCiclos().hashCode();
        }
        _hashCode += getTpSessao();
        _hashCode += (isUpParada() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isUpTrabalhando() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getUpihmColetados() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUpihmColetados());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUpihmColetados(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Double(getVlEficienciaUltimoCiclo()).hashCode();
        _hashCode += new Double(getMsAdcParaAberturaParada()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "upDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bcOffLine");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bcOffLine"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bloqPorParadaSemConexao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bloqPorParadaSemConexao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdBc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdBc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cd_up");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cd_up"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmaqestendido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmaqestendido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debounce");
        elemField.setXmlName(new javax.xml.namespace.QName("", "debounce"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ds_up");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ds_up"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtHrInicioCiclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtHrInicioCiclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrRevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrRevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrStativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrStativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idAcao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idAcao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCausa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCausa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idJustificativa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idJustificativa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idLocal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idLocal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idRdzProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idRdzProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTecnicoDois");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTecnicoDois"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTecnicoResponsavel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTecnicoResponsavel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTecnicoUm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTecnicoUm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUpPDBA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUpPDBA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAlertaProblemaQualidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isAlertaProblemaQualidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isComOP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isComOP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isComOpSemProducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isComOpSemProducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isComVariacaoRitmoPend");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isComVariacaoRitmoPend"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEnviarDadosParaIHM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEnviarDadosParaIHM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEnviarDadosParaWS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEnviarDadosParaWS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isInspecaoPendenteExecucao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isInspecaoPendenteExecucao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isManterHistoricoAntesEnvio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isManterHistoricoAntesEnvio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isManterRegistroAposTimeout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isManterRegistroAposTimeout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isParadaSemConexao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isParadaSemConexao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaAlertasEmAberto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaAlertasEmAberto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "mSalertaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaEventosAndonUp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaEventosAndonUp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "andonDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaOperadoresLogados");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaOperadoresLogados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "usuarioMSDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaProdutos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaProdutos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUpProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("log");
        elemField.setXmlName(new javax.xml.namespace.QName("", "log"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "idwLogger"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "loginUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msdthrIRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msdthrIRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nropestendido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nropestendido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaEmAberto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaEmAberto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaPermiteCorrecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaPermiteCorrecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaPersistente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaPersistente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaRegulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaRegulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaRequerConfirmacaoParaFinalizar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaRequerConfirmacaoParaFinalizar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("percCicloPadraoTimeout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "percCicloPadraoTimeout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("permCancelamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "permCancelamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoliquida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoliquida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producaoplanejada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producaoplanejada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reqCancel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reqCancel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoUltimaInspecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoUltimaInspecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCicloPadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCicloPadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sinalCicloAlto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sinalCicloAlto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAtivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tamanhoPacoteCiclos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tamanhoPacoteCiclos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpSessao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpSessao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("upParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "upParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("upTrabalhando");
        elemField.setXmlName(new javax.xml.namespace.QName("", "upTrabalhando"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("upihmColetados");
        elemField.setXmlName(new javax.xml.namespace.QName("", "upihmColetados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "upIhmDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlEficienciaUltimoCiclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlEficienciaUltimoCiclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msAdcParaAberturaParada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msAdcParaAberturaParada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
