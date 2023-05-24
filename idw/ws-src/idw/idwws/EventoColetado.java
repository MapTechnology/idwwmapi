/**
 * EventoColetado.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class EventoColetado  implements java.io.Serializable {
    private java.lang.String cdacao;

    private java.lang.String cdalerta;

    private java.lang.String cdcausa;

    private java.lang.String cdconsulta;

    private java.lang.String cdestrutura;

    private java.lang.String cdjustificativa;

    private java.lang.String cdmolde;

    private java.lang.String cdop;

    private java.lang.String cdparada;

    private java.lang.String cdproduto;

    private java.lang.String cdrefugo;

    private java.lang.String cdtec1;

    private java.lang.String cdtec2;

    private java.lang.String cdtecResponsavel;

    private boolean chamarInjetWs;

    private java.util.Calendar dthrEvento;

    private java.lang.String dthrUltimoRefugo;

    private idw.idwws.ErroInsersoraDTO erroInsersora;

    private boolean existeEvento;

    private idw.idwws.FeederDTO[] feeders;

    private idw.idwws.IcUpDTO icUpDTO;

    private java.math.BigDecimal idEvt;

    private int idLog;

    private java.lang.String idRdzProduto;

    private java.lang.String idUpPdba;

    private int identacao;

    private idw.idwws.IdwLogger log;

    private java.lang.String login;

    private java.lang.String milisec;

    private idw.idwws.NozzleDTO[] nozzles;

    private java.lang.String origem;

    private java.lang.Integer paradaDefault;

    private java.math.BigDecimal parametroLido;

    private java.lang.String qtde;

    private java.lang.String qtdeciclos;

    private java.lang.String senhaTec1;

    private java.lang.String senhaTec2;

    private java.lang.String senhaTecResponsavel;

    private java.lang.Integer sequencial;

    private int tipoEvento;

    private java.lang.String tpSessao;

    public EventoColetado() {
    }

    public EventoColetado(
           java.lang.String cdacao,
           java.lang.String cdalerta,
           java.lang.String cdcausa,
           java.lang.String cdconsulta,
           java.lang.String cdestrutura,
           java.lang.String cdjustificativa,
           java.lang.String cdmolde,
           java.lang.String cdop,
           java.lang.String cdparada,
           java.lang.String cdproduto,
           java.lang.String cdrefugo,
           java.lang.String cdtec1,
           java.lang.String cdtec2,
           java.lang.String cdtecResponsavel,
           boolean chamarInjetWs,
           java.util.Calendar dthrEvento,
           java.lang.String dthrUltimoRefugo,
           idw.idwws.ErroInsersoraDTO erroInsersora,
           boolean existeEvento,
           idw.idwws.FeederDTO[] feeders,
           idw.idwws.IcUpDTO icUpDTO,
           java.math.BigDecimal idEvt,
           int idLog,
           java.lang.String idRdzProduto,
           java.lang.String idUpPdba,
           int identacao,
           idw.idwws.IdwLogger log,
           java.lang.String login,
           java.lang.String milisec,
           idw.idwws.NozzleDTO[] nozzles,
           java.lang.String origem,
           java.lang.Integer paradaDefault,
           java.math.BigDecimal parametroLido,
           java.lang.String qtde,
           java.lang.String qtdeciclos,
           java.lang.String senhaTec1,
           java.lang.String senhaTec2,
           java.lang.String senhaTecResponsavel,
           java.lang.Integer sequencial,
           int tipoEvento,
           java.lang.String tpSessao) {
           this.cdacao = cdacao;
           this.cdalerta = cdalerta;
           this.cdcausa = cdcausa;
           this.cdconsulta = cdconsulta;
           this.cdestrutura = cdestrutura;
           this.cdjustificativa = cdjustificativa;
           this.cdmolde = cdmolde;
           this.cdop = cdop;
           this.cdparada = cdparada;
           this.cdproduto = cdproduto;
           this.cdrefugo = cdrefugo;
           this.cdtec1 = cdtec1;
           this.cdtec2 = cdtec2;
           this.cdtecResponsavel = cdtecResponsavel;
           this.chamarInjetWs = chamarInjetWs;
           this.dthrEvento = dthrEvento;
           this.dthrUltimoRefugo = dthrUltimoRefugo;
           this.erroInsersora = erroInsersora;
           this.existeEvento = existeEvento;
           this.feeders = feeders;
           this.icUpDTO = icUpDTO;
           this.idEvt = idEvt;
           this.idLog = idLog;
           this.idRdzProduto = idRdzProduto;
           this.idUpPdba = idUpPdba;
           this.identacao = identacao;
           this.log = log;
           this.login = login;
           this.milisec = milisec;
           this.nozzles = nozzles;
           this.origem = origem;
           this.paradaDefault = paradaDefault;
           this.parametroLido = parametroLido;
           this.qtde = qtde;
           this.qtdeciclos = qtdeciclos;
           this.senhaTec1 = senhaTec1;
           this.senhaTec2 = senhaTec2;
           this.senhaTecResponsavel = senhaTecResponsavel;
           this.sequencial = sequencial;
           this.tipoEvento = tipoEvento;
           this.tpSessao = tpSessao;
    }


    /**
     * Gets the cdacao value for this EventoColetado.
     * 
     * @return cdacao
     */
    public java.lang.String getCdacao() {
        return cdacao;
    }


    /**
     * Sets the cdacao value for this EventoColetado.
     * 
     * @param cdacao
     */
    public void setCdacao(java.lang.String cdacao) {
        this.cdacao = cdacao;
    }


    /**
     * Gets the cdalerta value for this EventoColetado.
     * 
     * @return cdalerta
     */
    public java.lang.String getCdalerta() {
        return cdalerta;
    }


    /**
     * Sets the cdalerta value for this EventoColetado.
     * 
     * @param cdalerta
     */
    public void setCdalerta(java.lang.String cdalerta) {
        this.cdalerta = cdalerta;
    }


    /**
     * Gets the cdcausa value for this EventoColetado.
     * 
     * @return cdcausa
     */
    public java.lang.String getCdcausa() {
        return cdcausa;
    }


    /**
     * Sets the cdcausa value for this EventoColetado.
     * 
     * @param cdcausa
     */
    public void setCdcausa(java.lang.String cdcausa) {
        this.cdcausa = cdcausa;
    }


    /**
     * Gets the cdconsulta value for this EventoColetado.
     * 
     * @return cdconsulta
     */
    public java.lang.String getCdconsulta() {
        return cdconsulta;
    }


    /**
     * Sets the cdconsulta value for this EventoColetado.
     * 
     * @param cdconsulta
     */
    public void setCdconsulta(java.lang.String cdconsulta) {
        this.cdconsulta = cdconsulta;
    }


    /**
     * Gets the cdestrutura value for this EventoColetado.
     * 
     * @return cdestrutura
     */
    public java.lang.String getCdestrutura() {
        return cdestrutura;
    }


    /**
     * Sets the cdestrutura value for this EventoColetado.
     * 
     * @param cdestrutura
     */
    public void setCdestrutura(java.lang.String cdestrutura) {
        this.cdestrutura = cdestrutura;
    }


    /**
     * Gets the cdjustificativa value for this EventoColetado.
     * 
     * @return cdjustificativa
     */
    public java.lang.String getCdjustificativa() {
        return cdjustificativa;
    }


    /**
     * Sets the cdjustificativa value for this EventoColetado.
     * 
     * @param cdjustificativa
     */
    public void setCdjustificativa(java.lang.String cdjustificativa) {
        this.cdjustificativa = cdjustificativa;
    }


    /**
     * Gets the cdmolde value for this EventoColetado.
     * 
     * @return cdmolde
     */
    public java.lang.String getCdmolde() {
        return cdmolde;
    }


    /**
     * Sets the cdmolde value for this EventoColetado.
     * 
     * @param cdmolde
     */
    public void setCdmolde(java.lang.String cdmolde) {
        this.cdmolde = cdmolde;
    }


    /**
     * Gets the cdop value for this EventoColetado.
     * 
     * @return cdop
     */
    public java.lang.String getCdop() {
        return cdop;
    }


    /**
     * Sets the cdop value for this EventoColetado.
     * 
     * @param cdop
     */
    public void setCdop(java.lang.String cdop) {
        this.cdop = cdop;
    }


    /**
     * Gets the cdparada value for this EventoColetado.
     * 
     * @return cdparada
     */
    public java.lang.String getCdparada() {
        return cdparada;
    }


    /**
     * Sets the cdparada value for this EventoColetado.
     * 
     * @param cdparada
     */
    public void setCdparada(java.lang.String cdparada) {
        this.cdparada = cdparada;
    }


    /**
     * Gets the cdproduto value for this EventoColetado.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this EventoColetado.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the cdrefugo value for this EventoColetado.
     * 
     * @return cdrefugo
     */
    public java.lang.String getCdrefugo() {
        return cdrefugo;
    }


    /**
     * Sets the cdrefugo value for this EventoColetado.
     * 
     * @param cdrefugo
     */
    public void setCdrefugo(java.lang.String cdrefugo) {
        this.cdrefugo = cdrefugo;
    }


    /**
     * Gets the cdtec1 value for this EventoColetado.
     * 
     * @return cdtec1
     */
    public java.lang.String getCdtec1() {
        return cdtec1;
    }


    /**
     * Sets the cdtec1 value for this EventoColetado.
     * 
     * @param cdtec1
     */
    public void setCdtec1(java.lang.String cdtec1) {
        this.cdtec1 = cdtec1;
    }


    /**
     * Gets the cdtec2 value for this EventoColetado.
     * 
     * @return cdtec2
     */
    public java.lang.String getCdtec2() {
        return cdtec2;
    }


    /**
     * Sets the cdtec2 value for this EventoColetado.
     * 
     * @param cdtec2
     */
    public void setCdtec2(java.lang.String cdtec2) {
        this.cdtec2 = cdtec2;
    }


    /**
     * Gets the cdtecResponsavel value for this EventoColetado.
     * 
     * @return cdtecResponsavel
     */
    public java.lang.String getCdtecResponsavel() {
        return cdtecResponsavel;
    }


    /**
     * Sets the cdtecResponsavel value for this EventoColetado.
     * 
     * @param cdtecResponsavel
     */
    public void setCdtecResponsavel(java.lang.String cdtecResponsavel) {
        this.cdtecResponsavel = cdtecResponsavel;
    }


    /**
     * Gets the chamarInjetWs value for this EventoColetado.
     * 
     * @return chamarInjetWs
     */
    public boolean isChamarInjetWs() {
        return chamarInjetWs;
    }


    /**
     * Sets the chamarInjetWs value for this EventoColetado.
     * 
     * @param chamarInjetWs
     */
    public void setChamarInjetWs(boolean chamarInjetWs) {
        this.chamarInjetWs = chamarInjetWs;
    }


    /**
     * Gets the dthrEvento value for this EventoColetado.
     * 
     * @return dthrEvento
     */
    public java.util.Calendar getDthrEvento() {
        return dthrEvento;
    }


    /**
     * Sets the dthrEvento value for this EventoColetado.
     * 
     * @param dthrEvento
     */
    public void setDthrEvento(java.util.Calendar dthrEvento) {
        this.dthrEvento = dthrEvento;
    }


    /**
     * Gets the dthrUltimoRefugo value for this EventoColetado.
     * 
     * @return dthrUltimoRefugo
     */
    public java.lang.String getDthrUltimoRefugo() {
        return dthrUltimoRefugo;
    }


    /**
     * Sets the dthrUltimoRefugo value for this EventoColetado.
     * 
     * @param dthrUltimoRefugo
     */
    public void setDthrUltimoRefugo(java.lang.String dthrUltimoRefugo) {
        this.dthrUltimoRefugo = dthrUltimoRefugo;
    }


    /**
     * Gets the erroInsersora value for this EventoColetado.
     * 
     * @return erroInsersora
     */
    public idw.idwws.ErroInsersoraDTO getErroInsersora() {
        return erroInsersora;
    }


    /**
     * Sets the erroInsersora value for this EventoColetado.
     * 
     * @param erroInsersora
     */
    public void setErroInsersora(idw.idwws.ErroInsersoraDTO erroInsersora) {
        this.erroInsersora = erroInsersora;
    }


    /**
     * Gets the existeEvento value for this EventoColetado.
     * 
     * @return existeEvento
     */
    public boolean isExisteEvento() {
        return existeEvento;
    }


    /**
     * Sets the existeEvento value for this EventoColetado.
     * 
     * @param existeEvento
     */
    public void setExisteEvento(boolean existeEvento) {
        this.existeEvento = existeEvento;
    }


    /**
     * Gets the feeders value for this EventoColetado.
     * 
     * @return feeders
     */
    public idw.idwws.FeederDTO[] getFeeders() {
        return feeders;
    }


    /**
     * Sets the feeders value for this EventoColetado.
     * 
     * @param feeders
     */
    public void setFeeders(idw.idwws.FeederDTO[] feeders) {
        this.feeders = feeders;
    }

    public idw.idwws.FeederDTO getFeeders(int i) {
        return this.feeders[i];
    }

    public void setFeeders(int i, idw.idwws.FeederDTO _value) {
        this.feeders[i] = _value;
    }


    /**
     * Gets the icUpDTO value for this EventoColetado.
     * 
     * @return icUpDTO
     */
    public idw.idwws.IcUpDTO getIcUpDTO() {
        return icUpDTO;
    }


    /**
     * Sets the icUpDTO value for this EventoColetado.
     * 
     * @param icUpDTO
     */
    public void setIcUpDTO(idw.idwws.IcUpDTO icUpDTO) {
        this.icUpDTO = icUpDTO;
    }


    /**
     * Gets the idEvt value for this EventoColetado.
     * 
     * @return idEvt
     */
    public java.math.BigDecimal getIdEvt() {
        return idEvt;
    }


    /**
     * Sets the idEvt value for this EventoColetado.
     * 
     * @param idEvt
     */
    public void setIdEvt(java.math.BigDecimal idEvt) {
        this.idEvt = idEvt;
    }


    /**
     * Gets the idLog value for this EventoColetado.
     * 
     * @return idLog
     */
    public int getIdLog() {
        return idLog;
    }


    /**
     * Sets the idLog value for this EventoColetado.
     * 
     * @param idLog
     */
    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }


    /**
     * Gets the idRdzProduto value for this EventoColetado.
     * 
     * @return idRdzProduto
     */
    public java.lang.String getIdRdzProduto() {
        return idRdzProduto;
    }


    /**
     * Sets the idRdzProduto value for this EventoColetado.
     * 
     * @param idRdzProduto
     */
    public void setIdRdzProduto(java.lang.String idRdzProduto) {
        this.idRdzProduto = idRdzProduto;
    }


    /**
     * Gets the idUpPdba value for this EventoColetado.
     * 
     * @return idUpPdba
     */
    public java.lang.String getIdUpPdba() {
        return idUpPdba;
    }


    /**
     * Sets the idUpPdba value for this EventoColetado.
     * 
     * @param idUpPdba
     */
    public void setIdUpPdba(java.lang.String idUpPdba) {
        this.idUpPdba = idUpPdba;
    }


    /**
     * Gets the identacao value for this EventoColetado.
     * 
     * @return identacao
     */
    public int getIdentacao() {
        return identacao;
    }


    /**
     * Sets the identacao value for this EventoColetado.
     * 
     * @param identacao
     */
    public void setIdentacao(int identacao) {
        this.identacao = identacao;
    }


    /**
     * Gets the log value for this EventoColetado.
     * 
     * @return log
     */
    public idw.idwws.IdwLogger getLog() {
        return log;
    }


    /**
     * Sets the log value for this EventoColetado.
     * 
     * @param log
     */
    public void setLog(idw.idwws.IdwLogger log) {
        this.log = log;
    }


    /**
     * Gets the login value for this EventoColetado.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this EventoColetado.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the milisec value for this EventoColetado.
     * 
     * @return milisec
     */
    public java.lang.String getMilisec() {
        return milisec;
    }


    /**
     * Sets the milisec value for this EventoColetado.
     * 
     * @param milisec
     */
    public void setMilisec(java.lang.String milisec) {
        this.milisec = milisec;
    }


    /**
     * Gets the nozzles value for this EventoColetado.
     * 
     * @return nozzles
     */
    public idw.idwws.NozzleDTO[] getNozzles() {
        return nozzles;
    }


    /**
     * Sets the nozzles value for this EventoColetado.
     * 
     * @param nozzles
     */
    public void setNozzles(idw.idwws.NozzleDTO[] nozzles) {
        this.nozzles = nozzles;
    }

    public idw.idwws.NozzleDTO getNozzles(int i) {
        return this.nozzles[i];
    }

    public void setNozzles(int i, idw.idwws.NozzleDTO _value) {
        this.nozzles[i] = _value;
    }


    /**
     * Gets the origem value for this EventoColetado.
     * 
     * @return origem
     */
    public java.lang.String getOrigem() {
        return origem;
    }


    /**
     * Sets the origem value for this EventoColetado.
     * 
     * @param origem
     */
    public void setOrigem(java.lang.String origem) {
        this.origem = origem;
    }


    /**
     * Gets the paradaDefault value for this EventoColetado.
     * 
     * @return paradaDefault
     */
    public java.lang.Integer getParadaDefault() {
        return paradaDefault;
    }


    /**
     * Sets the paradaDefault value for this EventoColetado.
     * 
     * @param paradaDefault
     */
    public void setParadaDefault(java.lang.Integer paradaDefault) {
        this.paradaDefault = paradaDefault;
    }


    /**
     * Gets the parametroLido value for this EventoColetado.
     * 
     * @return parametroLido
     */
    public java.math.BigDecimal getParametroLido() {
        return parametroLido;
    }


    /**
     * Sets the parametroLido value for this EventoColetado.
     * 
     * @param parametroLido
     */
    public void setParametroLido(java.math.BigDecimal parametroLido) {
        this.parametroLido = parametroLido;
    }


    /**
     * Gets the qtde value for this EventoColetado.
     * 
     * @return qtde
     */
    public java.lang.String getQtde() {
        return qtde;
    }


    /**
     * Sets the qtde value for this EventoColetado.
     * 
     * @param qtde
     */
    public void setQtde(java.lang.String qtde) {
        this.qtde = qtde;
    }


    /**
     * Gets the qtdeciclos value for this EventoColetado.
     * 
     * @return qtdeciclos
     */
    public java.lang.String getQtdeciclos() {
        return qtdeciclos;
    }


    /**
     * Sets the qtdeciclos value for this EventoColetado.
     * 
     * @param qtdeciclos
     */
    public void setQtdeciclos(java.lang.String qtdeciclos) {
        this.qtdeciclos = qtdeciclos;
    }


    /**
     * Gets the senhaTec1 value for this EventoColetado.
     * 
     * @return senhaTec1
     */
    public java.lang.String getSenhaTec1() {
        return senhaTec1;
    }


    /**
     * Sets the senhaTec1 value for this EventoColetado.
     * 
     * @param senhaTec1
     */
    public void setSenhaTec1(java.lang.String senhaTec1) {
        this.senhaTec1 = senhaTec1;
    }


    /**
     * Gets the senhaTec2 value for this EventoColetado.
     * 
     * @return senhaTec2
     */
    public java.lang.String getSenhaTec2() {
        return senhaTec2;
    }


    /**
     * Sets the senhaTec2 value for this EventoColetado.
     * 
     * @param senhaTec2
     */
    public void setSenhaTec2(java.lang.String senhaTec2) {
        this.senhaTec2 = senhaTec2;
    }


    /**
     * Gets the senhaTecResponsavel value for this EventoColetado.
     * 
     * @return senhaTecResponsavel
     */
    public java.lang.String getSenhaTecResponsavel() {
        return senhaTecResponsavel;
    }


    /**
     * Sets the senhaTecResponsavel value for this EventoColetado.
     * 
     * @param senhaTecResponsavel
     */
    public void setSenhaTecResponsavel(java.lang.String senhaTecResponsavel) {
        this.senhaTecResponsavel = senhaTecResponsavel;
    }


    /**
     * Gets the sequencial value for this EventoColetado.
     * 
     * @return sequencial
     */
    public java.lang.Integer getSequencial() {
        return sequencial;
    }


    /**
     * Sets the sequencial value for this EventoColetado.
     * 
     * @param sequencial
     */
    public void setSequencial(java.lang.Integer sequencial) {
        this.sequencial = sequencial;
    }


    /**
     * Gets the tipoEvento value for this EventoColetado.
     * 
     * @return tipoEvento
     */
    public int getTipoEvento() {
        return tipoEvento;
    }


    /**
     * Sets the tipoEvento value for this EventoColetado.
     * 
     * @param tipoEvento
     */
    public void setTipoEvento(int tipoEvento) {
        this.tipoEvento = tipoEvento;
    }


    /**
     * Gets the tpSessao value for this EventoColetado.
     * 
     * @return tpSessao
     */
    public java.lang.String getTpSessao() {
        return tpSessao;
    }


    /**
     * Sets the tpSessao value for this EventoColetado.
     * 
     * @param tpSessao
     */
    public void setTpSessao(java.lang.String tpSessao) {
        this.tpSessao = tpSessao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EventoColetado)) return false;
        EventoColetado other = (EventoColetado) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdacao==null && other.getCdacao()==null) || 
             (this.cdacao!=null &&
              this.cdacao.equals(other.getCdacao()))) &&
            ((this.cdalerta==null && other.getCdalerta()==null) || 
             (this.cdalerta!=null &&
              this.cdalerta.equals(other.getCdalerta()))) &&
            ((this.cdcausa==null && other.getCdcausa()==null) || 
             (this.cdcausa!=null &&
              this.cdcausa.equals(other.getCdcausa()))) &&
            ((this.cdconsulta==null && other.getCdconsulta()==null) || 
             (this.cdconsulta!=null &&
              this.cdconsulta.equals(other.getCdconsulta()))) &&
            ((this.cdestrutura==null && other.getCdestrutura()==null) || 
             (this.cdestrutura!=null &&
              this.cdestrutura.equals(other.getCdestrutura()))) &&
            ((this.cdjustificativa==null && other.getCdjustificativa()==null) || 
             (this.cdjustificativa!=null &&
              this.cdjustificativa.equals(other.getCdjustificativa()))) &&
            ((this.cdmolde==null && other.getCdmolde()==null) || 
             (this.cdmolde!=null &&
              this.cdmolde.equals(other.getCdmolde()))) &&
            ((this.cdop==null && other.getCdop()==null) || 
             (this.cdop!=null &&
              this.cdop.equals(other.getCdop()))) &&
            ((this.cdparada==null && other.getCdparada()==null) || 
             (this.cdparada!=null &&
              this.cdparada.equals(other.getCdparada()))) &&
            ((this.cdproduto==null && other.getCdproduto()==null) || 
             (this.cdproduto!=null &&
              this.cdproduto.equals(other.getCdproduto()))) &&
            ((this.cdrefugo==null && other.getCdrefugo()==null) || 
             (this.cdrefugo!=null &&
              this.cdrefugo.equals(other.getCdrefugo()))) &&
            ((this.cdtec1==null && other.getCdtec1()==null) || 
             (this.cdtec1!=null &&
              this.cdtec1.equals(other.getCdtec1()))) &&
            ((this.cdtec2==null && other.getCdtec2()==null) || 
             (this.cdtec2!=null &&
              this.cdtec2.equals(other.getCdtec2()))) &&
            ((this.cdtecResponsavel==null && other.getCdtecResponsavel()==null) || 
             (this.cdtecResponsavel!=null &&
              this.cdtecResponsavel.equals(other.getCdtecResponsavel()))) &&
            this.chamarInjetWs == other.isChamarInjetWs() &&
            ((this.dthrEvento==null && other.getDthrEvento()==null) || 
             (this.dthrEvento!=null &&
              this.dthrEvento.equals(other.getDthrEvento()))) &&
            ((this.dthrUltimoRefugo==null && other.getDthrUltimoRefugo()==null) || 
             (this.dthrUltimoRefugo!=null &&
              this.dthrUltimoRefugo.equals(other.getDthrUltimoRefugo()))) &&
            ((this.erroInsersora==null && other.getErroInsersora()==null) || 
             (this.erroInsersora!=null &&
              this.erroInsersora.equals(other.getErroInsersora()))) &&
            this.existeEvento == other.isExisteEvento() &&
            ((this.feeders==null && other.getFeeders()==null) || 
             (this.feeders!=null &&
              java.util.Arrays.equals(this.feeders, other.getFeeders()))) &&
            ((this.icUpDTO==null && other.getIcUpDTO()==null) || 
             (this.icUpDTO!=null &&
              this.icUpDTO.equals(other.getIcUpDTO()))) &&
            ((this.idEvt==null && other.getIdEvt()==null) || 
             (this.idEvt!=null &&
              this.idEvt.equals(other.getIdEvt()))) &&
            this.idLog == other.getIdLog() &&
            ((this.idRdzProduto==null && other.getIdRdzProduto()==null) || 
             (this.idRdzProduto!=null &&
              this.idRdzProduto.equals(other.getIdRdzProduto()))) &&
            ((this.idUpPdba==null && other.getIdUpPdba()==null) || 
             (this.idUpPdba!=null &&
              this.idUpPdba.equals(other.getIdUpPdba()))) &&
            this.identacao == other.getIdentacao() &&
            ((this.log==null && other.getLog()==null) || 
             (this.log!=null &&
              this.log.equals(other.getLog()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.milisec==null && other.getMilisec()==null) || 
             (this.milisec!=null &&
              this.milisec.equals(other.getMilisec()))) &&
            ((this.nozzles==null && other.getNozzles()==null) || 
             (this.nozzles!=null &&
              java.util.Arrays.equals(this.nozzles, other.getNozzles()))) &&
            ((this.origem==null && other.getOrigem()==null) || 
             (this.origem!=null &&
              this.origem.equals(other.getOrigem()))) &&
            ((this.paradaDefault==null && other.getParadaDefault()==null) || 
             (this.paradaDefault!=null &&
              this.paradaDefault.equals(other.getParadaDefault()))) &&
            ((this.parametroLido==null && other.getParametroLido()==null) || 
             (this.parametroLido!=null &&
              this.parametroLido.equals(other.getParametroLido()))) &&
            ((this.qtde==null && other.getQtde()==null) || 
             (this.qtde!=null &&
              this.qtde.equals(other.getQtde()))) &&
            ((this.qtdeciclos==null && other.getQtdeciclos()==null) || 
             (this.qtdeciclos!=null &&
              this.qtdeciclos.equals(other.getQtdeciclos()))) &&
            ((this.senhaTec1==null && other.getSenhaTec1()==null) || 
             (this.senhaTec1!=null &&
              this.senhaTec1.equals(other.getSenhaTec1()))) &&
            ((this.senhaTec2==null && other.getSenhaTec2()==null) || 
             (this.senhaTec2!=null &&
              this.senhaTec2.equals(other.getSenhaTec2()))) &&
            ((this.senhaTecResponsavel==null && other.getSenhaTecResponsavel()==null) || 
             (this.senhaTecResponsavel!=null &&
              this.senhaTecResponsavel.equals(other.getSenhaTecResponsavel()))) &&
            ((this.sequencial==null && other.getSequencial()==null) || 
             (this.sequencial!=null &&
              this.sequencial.equals(other.getSequencial()))) &&
            this.tipoEvento == other.getTipoEvento() &&
            ((this.tpSessao==null && other.getTpSessao()==null) || 
             (this.tpSessao!=null &&
              this.tpSessao.equals(other.getTpSessao())));
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
        if (getCdacao() != null) {
            _hashCode += getCdacao().hashCode();
        }
        if (getCdalerta() != null) {
            _hashCode += getCdalerta().hashCode();
        }
        if (getCdcausa() != null) {
            _hashCode += getCdcausa().hashCode();
        }
        if (getCdconsulta() != null) {
            _hashCode += getCdconsulta().hashCode();
        }
        if (getCdestrutura() != null) {
            _hashCode += getCdestrutura().hashCode();
        }
        if (getCdjustificativa() != null) {
            _hashCode += getCdjustificativa().hashCode();
        }
        if (getCdmolde() != null) {
            _hashCode += getCdmolde().hashCode();
        }
        if (getCdop() != null) {
            _hashCode += getCdop().hashCode();
        }
        if (getCdparada() != null) {
            _hashCode += getCdparada().hashCode();
        }
        if (getCdproduto() != null) {
            _hashCode += getCdproduto().hashCode();
        }
        if (getCdrefugo() != null) {
            _hashCode += getCdrefugo().hashCode();
        }
        if (getCdtec1() != null) {
            _hashCode += getCdtec1().hashCode();
        }
        if (getCdtec2() != null) {
            _hashCode += getCdtec2().hashCode();
        }
        if (getCdtecResponsavel() != null) {
            _hashCode += getCdtecResponsavel().hashCode();
        }
        _hashCode += (isChamarInjetWs() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDthrEvento() != null) {
            _hashCode += getDthrEvento().hashCode();
        }
        if (getDthrUltimoRefugo() != null) {
            _hashCode += getDthrUltimoRefugo().hashCode();
        }
        if (getErroInsersora() != null) {
            _hashCode += getErroInsersora().hashCode();
        }
        _hashCode += (isExisteEvento() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getFeeders() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFeeders());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFeeders(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIcUpDTO() != null) {
            _hashCode += getIcUpDTO().hashCode();
        }
        if (getIdEvt() != null) {
            _hashCode += getIdEvt().hashCode();
        }
        _hashCode += getIdLog();
        if (getIdRdzProduto() != null) {
            _hashCode += getIdRdzProduto().hashCode();
        }
        if (getIdUpPdba() != null) {
            _hashCode += getIdUpPdba().hashCode();
        }
        _hashCode += getIdentacao();
        if (getLog() != null) {
            _hashCode += getLog().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getMilisec() != null) {
            _hashCode += getMilisec().hashCode();
        }
        if (getNozzles() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNozzles());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNozzles(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOrigem() != null) {
            _hashCode += getOrigem().hashCode();
        }
        if (getParadaDefault() != null) {
            _hashCode += getParadaDefault().hashCode();
        }
        if (getParametroLido() != null) {
            _hashCode += getParametroLido().hashCode();
        }
        if (getQtde() != null) {
            _hashCode += getQtde().hashCode();
        }
        if (getQtdeciclos() != null) {
            _hashCode += getQtdeciclos().hashCode();
        }
        if (getSenhaTec1() != null) {
            _hashCode += getSenhaTec1().hashCode();
        }
        if (getSenhaTec2() != null) {
            _hashCode += getSenhaTec2().hashCode();
        }
        if (getSenhaTecResponsavel() != null) {
            _hashCode += getSenhaTecResponsavel().hashCode();
        }
        if (getSequencial() != null) {
            _hashCode += getSequencial().hashCode();
        }
        _hashCode += getTipoEvento();
        if (getTpSessao() != null) {
            _hashCode += getTpSessao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EventoColetado.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "eventoColetado"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcausa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcausa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdconsulta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdconsulta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdestrutura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdestrutura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdjustificativa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdjustificativa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdparada"));
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
        elemField.setFieldName("cdrefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdrefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtec1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtec1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtec2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtec2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtecResponsavel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtecResponsavel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chamarInjetWs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chamarInjetWs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrUltimoRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrUltimoRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("erroInsersora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "erroInsersora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "erroInsersoraDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("existeEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "existeEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feeders");
        elemField.setXmlName(new javax.xml.namespace.QName("", "feeders"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "feederDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("icUpDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "icUpDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "icUpDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idLog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idLog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("idUpPdba");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUpPdba"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "identacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("log");
        elemField.setXmlName(new javax.xml.namespace.QName("", "log"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "idwLogger"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("", "login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("milisec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "milisec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nozzles");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nozzles"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "nozzleDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("origem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "origem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parametroLido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parametroLido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdeciclos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdeciclos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senhaTec1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "senhaTec1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senhaTec2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "senhaTec2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senhaTecResponsavel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "senhaTecResponsavel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sequencial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sequencial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpSessao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpSessao"));
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
