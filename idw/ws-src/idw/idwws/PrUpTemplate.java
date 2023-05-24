/**
 * PrUpTemplate.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public abstract class PrUpTemplate  implements java.io.Serializable {
    private java.lang.Boolean isSemPrograma;

    private java.lang.Boolean isEmRegulagem;

    private java.lang.Boolean isParadaEmAberto;

    private java.util.Calendar dthrUltimoHeartBeat;

    private java.lang.Double msDthrUltimoHeartBeat;

    private java.lang.Boolean isReiniciarUp;

    private java.util.Calendar dthrReferenciaParaEventos;

    private java.lang.Boolean deveLiparUsuarios;

    private idw.idwws.IwsDadosCIPDTO dadosCIP;

    private idw.idwws.IwsDadosBCDTO dadosBC;

    private idw.idwws.IwsDadosApontamentoDTO dadosApontamento;

    private java.lang.Boolean isLogoutNaViradaTurno;

    private java.lang.Boolean isFechaParadaNaViradaTurno;

    private java.lang.Boolean isAlertaProbQuali;

    private java.lang.Boolean isInspecaoPendente;

    private idw.idwws.IwsVariacaoRitmoDTO variacaoRitmoDTO;

    private java.lang.Integer resultadoUltimaInspecao;

    private java.lang.String isComApntSAP;

    private java.lang.String statusApntSap;

    private java.lang.String txtMessage;

    private idw.idwws.IwsModDTO[] listaLoginsEmAberto;

    private idw.idwws.IwsAlertaDTO[] listaAlertasEmAberto;

    private idw.idwws.IwsAlertaDTO[] listaAlertasDiarioDeBordo;

    private boolean isInjOuLiner;

    private boolean isOPConcluida;

    public PrUpTemplate() {
    }

    public PrUpTemplate(
           java.lang.Boolean isSemPrograma,
           java.lang.Boolean isEmRegulagem,
           java.lang.Boolean isParadaEmAberto,
           java.util.Calendar dthrUltimoHeartBeat,
           java.lang.Double msDthrUltimoHeartBeat,
           java.lang.Boolean isReiniciarUp,
           java.util.Calendar dthrReferenciaParaEventos,
           java.lang.Boolean deveLiparUsuarios,
           idw.idwws.IwsDadosCIPDTO dadosCIP,
           idw.idwws.IwsDadosBCDTO dadosBC,
           idw.idwws.IwsDadosApontamentoDTO dadosApontamento,
           java.lang.Boolean isLogoutNaViradaTurno,
           java.lang.Boolean isFechaParadaNaViradaTurno,
           java.lang.Boolean isAlertaProbQuali,
           java.lang.Boolean isInspecaoPendente,
           idw.idwws.IwsVariacaoRitmoDTO variacaoRitmoDTO,
           java.lang.Integer resultadoUltimaInspecao,
           java.lang.String isComApntSAP,
           java.lang.String statusApntSap,
           java.lang.String txtMessage,
           idw.idwws.IwsModDTO[] listaLoginsEmAberto,
           idw.idwws.IwsAlertaDTO[] listaAlertasEmAberto,
           idw.idwws.IwsAlertaDTO[] listaAlertasDiarioDeBordo,
           boolean isInjOuLiner,
           boolean isOPConcluida) {
           this.isSemPrograma = isSemPrograma;
           this.isEmRegulagem = isEmRegulagem;
           this.isParadaEmAberto = isParadaEmAberto;
           this.dthrUltimoHeartBeat = dthrUltimoHeartBeat;
           this.msDthrUltimoHeartBeat = msDthrUltimoHeartBeat;
           this.isReiniciarUp = isReiniciarUp;
           this.dthrReferenciaParaEventos = dthrReferenciaParaEventos;
           this.deveLiparUsuarios = deveLiparUsuarios;
           this.dadosCIP = dadosCIP;
           this.dadosBC = dadosBC;
           this.dadosApontamento = dadosApontamento;
           this.isLogoutNaViradaTurno = isLogoutNaViradaTurno;
           this.isFechaParadaNaViradaTurno = isFechaParadaNaViradaTurno;
           this.isAlertaProbQuali = isAlertaProbQuali;
           this.isInspecaoPendente = isInspecaoPendente;
           this.variacaoRitmoDTO = variacaoRitmoDTO;
           this.resultadoUltimaInspecao = resultadoUltimaInspecao;
           this.isComApntSAP = isComApntSAP;
           this.statusApntSap = statusApntSap;
           this.txtMessage = txtMessage;
           this.listaLoginsEmAberto = listaLoginsEmAberto;
           this.listaAlertasEmAberto = listaAlertasEmAberto;
           this.listaAlertasDiarioDeBordo = listaAlertasDiarioDeBordo;
           this.isInjOuLiner = isInjOuLiner;
           this.isOPConcluida = isOPConcluida;
    }


    /**
     * Gets the isSemPrograma value for this PrUpTemplate.
     * 
     * @return isSemPrograma
     */
    public java.lang.Boolean getIsSemPrograma() {
        return isSemPrograma;
    }


    /**
     * Sets the isSemPrograma value for this PrUpTemplate.
     * 
     * @param isSemPrograma
     */
    public void setIsSemPrograma(java.lang.Boolean isSemPrograma) {
        this.isSemPrograma = isSemPrograma;
    }


    /**
     * Gets the isEmRegulagem value for this PrUpTemplate.
     * 
     * @return isEmRegulagem
     */
    public java.lang.Boolean getIsEmRegulagem() {
        return isEmRegulagem;
    }


    /**
     * Sets the isEmRegulagem value for this PrUpTemplate.
     * 
     * @param isEmRegulagem
     */
    public void setIsEmRegulagem(java.lang.Boolean isEmRegulagem) {
        this.isEmRegulagem = isEmRegulagem;
    }


    /**
     * Gets the isParadaEmAberto value for this PrUpTemplate.
     * 
     * @return isParadaEmAberto
     */
    public java.lang.Boolean getIsParadaEmAberto() {
        return isParadaEmAberto;
    }


    /**
     * Sets the isParadaEmAberto value for this PrUpTemplate.
     * 
     * @param isParadaEmAberto
     */
    public void setIsParadaEmAberto(java.lang.Boolean isParadaEmAberto) {
        this.isParadaEmAberto = isParadaEmAberto;
    }


    /**
     * Gets the dthrUltimoHeartBeat value for this PrUpTemplate.
     * 
     * @return dthrUltimoHeartBeat
     */
    public java.util.Calendar getDthrUltimoHeartBeat() {
        return dthrUltimoHeartBeat;
    }


    /**
     * Sets the dthrUltimoHeartBeat value for this PrUpTemplate.
     * 
     * @param dthrUltimoHeartBeat
     */
    public void setDthrUltimoHeartBeat(java.util.Calendar dthrUltimoHeartBeat) {
        this.dthrUltimoHeartBeat = dthrUltimoHeartBeat;
    }


    /**
     * Gets the msDthrUltimoHeartBeat value for this PrUpTemplate.
     * 
     * @return msDthrUltimoHeartBeat
     */
    public java.lang.Double getMsDthrUltimoHeartBeat() {
        return msDthrUltimoHeartBeat;
    }


    /**
     * Sets the msDthrUltimoHeartBeat value for this PrUpTemplate.
     * 
     * @param msDthrUltimoHeartBeat
     */
    public void setMsDthrUltimoHeartBeat(java.lang.Double msDthrUltimoHeartBeat) {
        this.msDthrUltimoHeartBeat = msDthrUltimoHeartBeat;
    }


    /**
     * Gets the isReiniciarUp value for this PrUpTemplate.
     * 
     * @return isReiniciarUp
     */
    public java.lang.Boolean getIsReiniciarUp() {
        return isReiniciarUp;
    }


    /**
     * Sets the isReiniciarUp value for this PrUpTemplate.
     * 
     * @param isReiniciarUp
     */
    public void setIsReiniciarUp(java.lang.Boolean isReiniciarUp) {
        this.isReiniciarUp = isReiniciarUp;
    }


    /**
     * Gets the dthrReferenciaParaEventos value for this PrUpTemplate.
     * 
     * @return dthrReferenciaParaEventos
     */
    public java.util.Calendar getDthrReferenciaParaEventos() {
        return dthrReferenciaParaEventos;
    }


    /**
     * Sets the dthrReferenciaParaEventos value for this PrUpTemplate.
     * 
     * @param dthrReferenciaParaEventos
     */
    public void setDthrReferenciaParaEventos(java.util.Calendar dthrReferenciaParaEventos) {
        this.dthrReferenciaParaEventos = dthrReferenciaParaEventos;
    }


    /**
     * Gets the deveLiparUsuarios value for this PrUpTemplate.
     * 
     * @return deveLiparUsuarios
     */
    public java.lang.Boolean getDeveLiparUsuarios() {
        return deveLiparUsuarios;
    }


    /**
     * Sets the deveLiparUsuarios value for this PrUpTemplate.
     * 
     * @param deveLiparUsuarios
     */
    public void setDeveLiparUsuarios(java.lang.Boolean deveLiparUsuarios) {
        this.deveLiparUsuarios = deveLiparUsuarios;
    }


    /**
     * Gets the dadosCIP value for this PrUpTemplate.
     * 
     * @return dadosCIP
     */
    public idw.idwws.IwsDadosCIPDTO getDadosCIP() {
        return dadosCIP;
    }


    /**
     * Sets the dadosCIP value for this PrUpTemplate.
     * 
     * @param dadosCIP
     */
    public void setDadosCIP(idw.idwws.IwsDadosCIPDTO dadosCIP) {
        this.dadosCIP = dadosCIP;
    }


    /**
     * Gets the dadosBC value for this PrUpTemplate.
     * 
     * @return dadosBC
     */
    public idw.idwws.IwsDadosBCDTO getDadosBC() {
        return dadosBC;
    }


    /**
     * Sets the dadosBC value for this PrUpTemplate.
     * 
     * @param dadosBC
     */
    public void setDadosBC(idw.idwws.IwsDadosBCDTO dadosBC) {
        this.dadosBC = dadosBC;
    }


    /**
     * Gets the dadosApontamento value for this PrUpTemplate.
     * 
     * @return dadosApontamento
     */
    public idw.idwws.IwsDadosApontamentoDTO getDadosApontamento() {
        return dadosApontamento;
    }


    /**
     * Sets the dadosApontamento value for this PrUpTemplate.
     * 
     * @param dadosApontamento
     */
    public void setDadosApontamento(idw.idwws.IwsDadosApontamentoDTO dadosApontamento) {
        this.dadosApontamento = dadosApontamento;
    }


    /**
     * Gets the isLogoutNaViradaTurno value for this PrUpTemplate.
     * 
     * @return isLogoutNaViradaTurno
     */
    public java.lang.Boolean getIsLogoutNaViradaTurno() {
        return isLogoutNaViradaTurno;
    }


    /**
     * Sets the isLogoutNaViradaTurno value for this PrUpTemplate.
     * 
     * @param isLogoutNaViradaTurno
     */
    public void setIsLogoutNaViradaTurno(java.lang.Boolean isLogoutNaViradaTurno) {
        this.isLogoutNaViradaTurno = isLogoutNaViradaTurno;
    }


    /**
     * Gets the isFechaParadaNaViradaTurno value for this PrUpTemplate.
     * 
     * @return isFechaParadaNaViradaTurno
     */
    public java.lang.Boolean getIsFechaParadaNaViradaTurno() {
        return isFechaParadaNaViradaTurno;
    }


    /**
     * Sets the isFechaParadaNaViradaTurno value for this PrUpTemplate.
     * 
     * @param isFechaParadaNaViradaTurno
     */
    public void setIsFechaParadaNaViradaTurno(java.lang.Boolean isFechaParadaNaViradaTurno) {
        this.isFechaParadaNaViradaTurno = isFechaParadaNaViradaTurno;
    }


    /**
     * Gets the isAlertaProbQuali value for this PrUpTemplate.
     * 
     * @return isAlertaProbQuali
     */
    public java.lang.Boolean getIsAlertaProbQuali() {
        return isAlertaProbQuali;
    }


    /**
     * Sets the isAlertaProbQuali value for this PrUpTemplate.
     * 
     * @param isAlertaProbQuali
     */
    public void setIsAlertaProbQuali(java.lang.Boolean isAlertaProbQuali) {
        this.isAlertaProbQuali = isAlertaProbQuali;
    }


    /**
     * Gets the isInspecaoPendente value for this PrUpTemplate.
     * 
     * @return isInspecaoPendente
     */
    public java.lang.Boolean getIsInspecaoPendente() {
        return isInspecaoPendente;
    }


    /**
     * Sets the isInspecaoPendente value for this PrUpTemplate.
     * 
     * @param isInspecaoPendente
     */
    public void setIsInspecaoPendente(java.lang.Boolean isInspecaoPendente) {
        this.isInspecaoPendente = isInspecaoPendente;
    }


    /**
     * Gets the variacaoRitmoDTO value for this PrUpTemplate.
     * 
     * @return variacaoRitmoDTO
     */
    public idw.idwws.IwsVariacaoRitmoDTO getVariacaoRitmoDTO() {
        return variacaoRitmoDTO;
    }


    /**
     * Sets the variacaoRitmoDTO value for this PrUpTemplate.
     * 
     * @param variacaoRitmoDTO
     */
    public void setVariacaoRitmoDTO(idw.idwws.IwsVariacaoRitmoDTO variacaoRitmoDTO) {
        this.variacaoRitmoDTO = variacaoRitmoDTO;
    }


    /**
     * Gets the resultadoUltimaInspecao value for this PrUpTemplate.
     * 
     * @return resultadoUltimaInspecao
     */
    public java.lang.Integer getResultadoUltimaInspecao() {
        return resultadoUltimaInspecao;
    }


    /**
     * Sets the resultadoUltimaInspecao value for this PrUpTemplate.
     * 
     * @param resultadoUltimaInspecao
     */
    public void setResultadoUltimaInspecao(java.lang.Integer resultadoUltimaInspecao) {
        this.resultadoUltimaInspecao = resultadoUltimaInspecao;
    }


    /**
     * Gets the isComApntSAP value for this PrUpTemplate.
     * 
     * @return isComApntSAP
     */
    public java.lang.String getIsComApntSAP() {
        return isComApntSAP;
    }


    /**
     * Sets the isComApntSAP value for this PrUpTemplate.
     * 
     * @param isComApntSAP
     */
    public void setIsComApntSAP(java.lang.String isComApntSAP) {
        this.isComApntSAP = isComApntSAP;
    }


    /**
     * Gets the statusApntSap value for this PrUpTemplate.
     * 
     * @return statusApntSap
     */
    public java.lang.String getStatusApntSap() {
        return statusApntSap;
    }


    /**
     * Sets the statusApntSap value for this PrUpTemplate.
     * 
     * @param statusApntSap
     */
    public void setStatusApntSap(java.lang.String statusApntSap) {
        this.statusApntSap = statusApntSap;
    }


    /**
     * Gets the txtMessage value for this PrUpTemplate.
     * 
     * @return txtMessage
     */
    public java.lang.String getTxtMessage() {
        return txtMessage;
    }


    /**
     * Sets the txtMessage value for this PrUpTemplate.
     * 
     * @param txtMessage
     */
    public void setTxtMessage(java.lang.String txtMessage) {
        this.txtMessage = txtMessage;
    }


    /**
     * Gets the listaLoginsEmAberto value for this PrUpTemplate.
     * 
     * @return listaLoginsEmAberto
     */
    public idw.idwws.IwsModDTO[] getListaLoginsEmAberto() {
        return listaLoginsEmAberto;
    }


    /**
     * Sets the listaLoginsEmAberto value for this PrUpTemplate.
     * 
     * @param listaLoginsEmAberto
     */
    public void setListaLoginsEmAberto(idw.idwws.IwsModDTO[] listaLoginsEmAberto) {
        this.listaLoginsEmAberto = listaLoginsEmAberto;
    }

    public idw.idwws.IwsModDTO getListaLoginsEmAberto(int i) {
        return this.listaLoginsEmAberto[i];
    }

    public void setListaLoginsEmAberto(int i, idw.idwws.IwsModDTO _value) {
        this.listaLoginsEmAberto[i] = _value;
    }


    /**
     * Gets the listaAlertasEmAberto value for this PrUpTemplate.
     * 
     * @return listaAlertasEmAberto
     */
    public idw.idwws.IwsAlertaDTO[] getListaAlertasEmAberto() {
        return listaAlertasEmAberto;
    }


    /**
     * Sets the listaAlertasEmAberto value for this PrUpTemplate.
     * 
     * @param listaAlertasEmAberto
     */
    public void setListaAlertasEmAberto(idw.idwws.IwsAlertaDTO[] listaAlertasEmAberto) {
        this.listaAlertasEmAberto = listaAlertasEmAberto;
    }

    public idw.idwws.IwsAlertaDTO getListaAlertasEmAberto(int i) {
        return this.listaAlertasEmAberto[i];
    }

    public void setListaAlertasEmAberto(int i, idw.idwws.IwsAlertaDTO _value) {
        this.listaAlertasEmAberto[i] = _value;
    }


    /**
     * Gets the listaAlertasDiarioDeBordo value for this PrUpTemplate.
     * 
     * @return listaAlertasDiarioDeBordo
     */
    public idw.idwws.IwsAlertaDTO[] getListaAlertasDiarioDeBordo() {
        return listaAlertasDiarioDeBordo;
    }


    /**
     * Sets the listaAlertasDiarioDeBordo value for this PrUpTemplate.
     * 
     * @param listaAlertasDiarioDeBordo
     */
    public void setListaAlertasDiarioDeBordo(idw.idwws.IwsAlertaDTO[] listaAlertasDiarioDeBordo) {
        this.listaAlertasDiarioDeBordo = listaAlertasDiarioDeBordo;
    }

    public idw.idwws.IwsAlertaDTO getListaAlertasDiarioDeBordo(int i) {
        return this.listaAlertasDiarioDeBordo[i];
    }

    public void setListaAlertasDiarioDeBordo(int i, idw.idwws.IwsAlertaDTO _value) {
        this.listaAlertasDiarioDeBordo[i] = _value;
    }


    /**
     * Gets the isInjOuLiner value for this PrUpTemplate.
     * 
     * @return isInjOuLiner
     */
    public boolean isIsInjOuLiner() {
        return isInjOuLiner;
    }


    /**
     * Sets the isInjOuLiner value for this PrUpTemplate.
     * 
     * @param isInjOuLiner
     */
    public void setIsInjOuLiner(boolean isInjOuLiner) {
        this.isInjOuLiner = isInjOuLiner;
    }


    /**
     * Gets the isOPConcluida value for this PrUpTemplate.
     * 
     * @return isOPConcluida
     */
    public boolean isIsOPConcluida() {
        return isOPConcluida;
    }


    /**
     * Sets the isOPConcluida value for this PrUpTemplate.
     * 
     * @param isOPConcluida
     */
    public void setIsOPConcluida(boolean isOPConcluida) {
        this.isOPConcluida = isOPConcluida;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrUpTemplate)) return false;
        PrUpTemplate other = (PrUpTemplate) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.isSemPrograma==null && other.getIsSemPrograma()==null) || 
             (this.isSemPrograma!=null &&
              this.isSemPrograma.equals(other.getIsSemPrograma()))) &&
            ((this.isEmRegulagem==null && other.getIsEmRegulagem()==null) || 
             (this.isEmRegulagem!=null &&
              this.isEmRegulagem.equals(other.getIsEmRegulagem()))) &&
            ((this.isParadaEmAberto==null && other.getIsParadaEmAberto()==null) || 
             (this.isParadaEmAberto!=null &&
              this.isParadaEmAberto.equals(other.getIsParadaEmAberto()))) &&
            ((this.dthrUltimoHeartBeat==null && other.getDthrUltimoHeartBeat()==null) || 
             (this.dthrUltimoHeartBeat!=null &&
              this.dthrUltimoHeartBeat.equals(other.getDthrUltimoHeartBeat()))) &&
            ((this.msDthrUltimoHeartBeat==null && other.getMsDthrUltimoHeartBeat()==null) || 
             (this.msDthrUltimoHeartBeat!=null &&
              this.msDthrUltimoHeartBeat.equals(other.getMsDthrUltimoHeartBeat()))) &&
            ((this.isReiniciarUp==null && other.getIsReiniciarUp()==null) || 
             (this.isReiniciarUp!=null &&
              this.isReiniciarUp.equals(other.getIsReiniciarUp()))) &&
            ((this.dthrReferenciaParaEventos==null && other.getDthrReferenciaParaEventos()==null) || 
             (this.dthrReferenciaParaEventos!=null &&
              this.dthrReferenciaParaEventos.equals(other.getDthrReferenciaParaEventos()))) &&
            ((this.deveLiparUsuarios==null && other.getDeveLiparUsuarios()==null) || 
             (this.deveLiparUsuarios!=null &&
              this.deveLiparUsuarios.equals(other.getDeveLiparUsuarios()))) &&
            ((this.dadosCIP==null && other.getDadosCIP()==null) || 
             (this.dadosCIP!=null &&
              this.dadosCIP.equals(other.getDadosCIP()))) &&
            ((this.dadosBC==null && other.getDadosBC()==null) || 
             (this.dadosBC!=null &&
              this.dadosBC.equals(other.getDadosBC()))) &&
            ((this.dadosApontamento==null && other.getDadosApontamento()==null) || 
             (this.dadosApontamento!=null &&
              this.dadosApontamento.equals(other.getDadosApontamento()))) &&
            ((this.isLogoutNaViradaTurno==null && other.getIsLogoutNaViradaTurno()==null) || 
             (this.isLogoutNaViradaTurno!=null &&
              this.isLogoutNaViradaTurno.equals(other.getIsLogoutNaViradaTurno()))) &&
            ((this.isFechaParadaNaViradaTurno==null && other.getIsFechaParadaNaViradaTurno()==null) || 
             (this.isFechaParadaNaViradaTurno!=null &&
              this.isFechaParadaNaViradaTurno.equals(other.getIsFechaParadaNaViradaTurno()))) &&
            ((this.isAlertaProbQuali==null && other.getIsAlertaProbQuali()==null) || 
             (this.isAlertaProbQuali!=null &&
              this.isAlertaProbQuali.equals(other.getIsAlertaProbQuali()))) &&
            ((this.isInspecaoPendente==null && other.getIsInspecaoPendente()==null) || 
             (this.isInspecaoPendente!=null &&
              this.isInspecaoPendente.equals(other.getIsInspecaoPendente()))) &&
            ((this.variacaoRitmoDTO==null && other.getVariacaoRitmoDTO()==null) || 
             (this.variacaoRitmoDTO!=null &&
              this.variacaoRitmoDTO.equals(other.getVariacaoRitmoDTO()))) &&
            ((this.resultadoUltimaInspecao==null && other.getResultadoUltimaInspecao()==null) || 
             (this.resultadoUltimaInspecao!=null &&
              this.resultadoUltimaInspecao.equals(other.getResultadoUltimaInspecao()))) &&
            ((this.isComApntSAP==null && other.getIsComApntSAP()==null) || 
             (this.isComApntSAP!=null &&
              this.isComApntSAP.equals(other.getIsComApntSAP()))) &&
            ((this.statusApntSap==null && other.getStatusApntSap()==null) || 
             (this.statusApntSap!=null &&
              this.statusApntSap.equals(other.getStatusApntSap()))) &&
            ((this.txtMessage==null && other.getTxtMessage()==null) || 
             (this.txtMessage!=null &&
              this.txtMessage.equals(other.getTxtMessage()))) &&
            ((this.listaLoginsEmAberto==null && other.getListaLoginsEmAberto()==null) || 
             (this.listaLoginsEmAberto!=null &&
              java.util.Arrays.equals(this.listaLoginsEmAberto, other.getListaLoginsEmAberto()))) &&
            ((this.listaAlertasEmAberto==null && other.getListaAlertasEmAberto()==null) || 
             (this.listaAlertasEmAberto!=null &&
              java.util.Arrays.equals(this.listaAlertasEmAberto, other.getListaAlertasEmAberto()))) &&
            ((this.listaAlertasDiarioDeBordo==null && other.getListaAlertasDiarioDeBordo()==null) || 
             (this.listaAlertasDiarioDeBordo!=null &&
              java.util.Arrays.equals(this.listaAlertasDiarioDeBordo, other.getListaAlertasDiarioDeBordo()))) &&
            this.isInjOuLiner == other.isIsInjOuLiner() &&
            this.isOPConcluida == other.isIsOPConcluida();
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
        if (getIsSemPrograma() != null) {
            _hashCode += getIsSemPrograma().hashCode();
        }
        if (getIsEmRegulagem() != null) {
            _hashCode += getIsEmRegulagem().hashCode();
        }
        if (getIsParadaEmAberto() != null) {
            _hashCode += getIsParadaEmAberto().hashCode();
        }
        if (getDthrUltimoHeartBeat() != null) {
            _hashCode += getDthrUltimoHeartBeat().hashCode();
        }
        if (getMsDthrUltimoHeartBeat() != null) {
            _hashCode += getMsDthrUltimoHeartBeat().hashCode();
        }
        if (getIsReiniciarUp() != null) {
            _hashCode += getIsReiniciarUp().hashCode();
        }
        if (getDthrReferenciaParaEventos() != null) {
            _hashCode += getDthrReferenciaParaEventos().hashCode();
        }
        if (getDeveLiparUsuarios() != null) {
            _hashCode += getDeveLiparUsuarios().hashCode();
        }
        if (getDadosCIP() != null) {
            _hashCode += getDadosCIP().hashCode();
        }
        if (getDadosBC() != null) {
            _hashCode += getDadosBC().hashCode();
        }
        if (getDadosApontamento() != null) {
            _hashCode += getDadosApontamento().hashCode();
        }
        if (getIsLogoutNaViradaTurno() != null) {
            _hashCode += getIsLogoutNaViradaTurno().hashCode();
        }
        if (getIsFechaParadaNaViradaTurno() != null) {
            _hashCode += getIsFechaParadaNaViradaTurno().hashCode();
        }
        if (getIsAlertaProbQuali() != null) {
            _hashCode += getIsAlertaProbQuali().hashCode();
        }
        if (getIsInspecaoPendente() != null) {
            _hashCode += getIsInspecaoPendente().hashCode();
        }
        if (getVariacaoRitmoDTO() != null) {
            _hashCode += getVariacaoRitmoDTO().hashCode();
        }
        if (getResultadoUltimaInspecao() != null) {
            _hashCode += getResultadoUltimaInspecao().hashCode();
        }
        if (getIsComApntSAP() != null) {
            _hashCode += getIsComApntSAP().hashCode();
        }
        if (getStatusApntSap() != null) {
            _hashCode += getStatusApntSap().hashCode();
        }
        if (getTxtMessage() != null) {
            _hashCode += getTxtMessage().hashCode();
        }
        if (getListaLoginsEmAberto() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaLoginsEmAberto());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaLoginsEmAberto(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getListaAlertasDiarioDeBordo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaAlertasDiarioDeBordo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaAlertasDiarioDeBordo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isIsInjOuLiner() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsOPConcluida() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PrUpTemplate.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUpTemplate"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isSemPrograma");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isSemPrograma"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEmRegulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEmRegulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isParadaEmAberto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isParadaEmAberto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrUltimoHeartBeat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrUltimoHeartBeat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrUltimoHeartBeat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrUltimoHeartBeat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isReiniciarUp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isReiniciarUp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrReferenciaParaEventos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrReferenciaParaEventos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deveLiparUsuarios");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deveLiparUsuarios"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosCIP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dadosCIP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "iwsDadosCIPDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosBC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dadosBC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "iwsDadosBCDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosApontamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dadosApontamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "iwsDadosApontamentoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isLogoutNaViradaTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isLogoutNaViradaTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isFechaParadaNaViradaTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isFechaParadaNaViradaTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAlertaProbQuali");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isAlertaProbQuali"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isInspecaoPendente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isInspecaoPendente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("variacaoRitmoDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "variacaoRitmoDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "iwsVariacaoRitmoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoUltimaInspecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoUltimaInspecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isComApntSAP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isComApntSAP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statusApntSap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "statusApntSap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("txtMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "txtMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaLoginsEmAberto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaLoginsEmAberto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "iwsModDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaAlertasEmAberto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaAlertasEmAberto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "iwsAlertaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaAlertasDiarioDeBordo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaAlertasDiarioDeBordo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "iwsAlertaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isInjOuLiner");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isInjOuLiner"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isOPConcluida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isOPConcluida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
