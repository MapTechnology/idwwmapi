/**
 * PpCp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpCp  extends idw.idwws.PpCpTemplate  implements java.io.Serializable {
    private java.lang.String cdCp;

    private java.util.Calendar dtCobertura;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private java.util.Calendar dthrFinal;

    private java.util.Calendar dthrFinalreal;

    private java.util.Calendar dthrInicio;

    private java.util.Calendar dthrInicioreal;

    private idw.idwws.DwCal dwCal;

    private idw.idwws.DwConsolid[] dwConsolids;

    private idw.idwws.DwEst dwEst;

    private idw.idwws.DwFolha dwFolha;

    private idw.idwws.DwRota dwRota;

    private idw.idwws.DwRt[] dwRts;

    private java.lang.Long idCp;

    private java.lang.Boolean isAntecipacao;

    private java.lang.Boolean isApAberta;

    private java.lang.Boolean isBarrasete;

    private java.lang.Boolean isCm;

    private java.lang.Boolean isFaltamp;

    private java.lang.Boolean isFinalserie;

    private java.lang.Boolean isMassa;

    private java.lang.Boolean isTryout;

    private idw.idwws.OmGt omGt;

    private idw.idwws.OmPt omPt;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.math.BigDecimal passo;

    private idw.idwws.PpCliente ppCliente;

    private idw.idwws.PpCpPre[] ppCpPresForIdCp;

    private idw.idwws.PpCpPre[] ppCpPresForIdCppredecessora;

    private idw.idwws.PpCpfaltamp[] ppCpfaltamps;

    private idw.idwws.PpCpneccron[] ppCpneccrons;

    private idw.idwws.PpCpproduto[] ppCpprodutos;

    private idw.idwws.PpPlano ppPlano;

    private java.lang.Integer prioridade;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    private java.lang.Integer stCp;

    private java.lang.Integer tpCp;

    public PpCp() {
    }

    public PpCp(
           java.lang.Long id,
           java.lang.String cdCp,
           java.util.Calendar dtCobertura,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           java.util.Calendar dthrFinal,
           java.util.Calendar dthrFinalreal,
           java.util.Calendar dthrInicio,
           java.util.Calendar dthrInicioreal,
           idw.idwws.DwCal dwCal,
           idw.idwws.DwConsolid[] dwConsolids,
           idw.idwws.DwEst dwEst,
           idw.idwws.DwFolha dwFolha,
           idw.idwws.DwRota dwRota,
           idw.idwws.DwRt[] dwRts,
           java.lang.Long idCp,
           java.lang.Boolean isAntecipacao,
           java.lang.Boolean isApAberta,
           java.lang.Boolean isBarrasete,
           java.lang.Boolean isCm,
           java.lang.Boolean isFaltamp,
           java.lang.Boolean isFinalserie,
           java.lang.Boolean isMassa,
           java.lang.Boolean isTryout,
           idw.idwws.OmGt omGt,
           idw.idwws.OmPt omPt,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.math.BigDecimal passo,
           idw.idwws.PpCliente ppCliente,
           idw.idwws.PpCpPre[] ppCpPresForIdCp,
           idw.idwws.PpCpPre[] ppCpPresForIdCppredecessora,
           idw.idwws.PpCpfaltamp[] ppCpfaltamps,
           idw.idwws.PpCpneccron[] ppCpneccrons,
           idw.idwws.PpCpproduto[] ppCpprodutos,
           idw.idwws.PpPlano ppPlano,
           java.lang.Integer prioridade,
           java.lang.Long revisao,
           java.lang.Byte stAtivo,
           java.lang.Integer stCp,
           java.lang.Integer tpCp) {
        super(
            id);
        this.cdCp = cdCp;
        this.dtCobertura = dtCobertura;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dthrFinal = dthrFinal;
        this.dthrFinalreal = dthrFinalreal;
        this.dthrInicio = dthrInicio;
        this.dthrInicioreal = dthrInicioreal;
        this.dwCal = dwCal;
        this.dwConsolids = dwConsolids;
        this.dwEst = dwEst;
        this.dwFolha = dwFolha;
        this.dwRota = dwRota;
        this.dwRts = dwRts;
        this.idCp = idCp;
        this.isAntecipacao = isAntecipacao;
        this.isApAberta = isApAberta;
        this.isBarrasete = isBarrasete;
        this.isCm = isCm;
        this.isFaltamp = isFaltamp;
        this.isFinalserie = isFinalserie;
        this.isMassa = isMassa;
        this.isTryout = isTryout;
        this.omGt = omGt;
        this.omPt = omPt;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.passo = passo;
        this.ppCliente = ppCliente;
        this.ppCpPresForIdCp = ppCpPresForIdCp;
        this.ppCpPresForIdCppredecessora = ppCpPresForIdCppredecessora;
        this.ppCpfaltamps = ppCpfaltamps;
        this.ppCpneccrons = ppCpneccrons;
        this.ppCpprodutos = ppCpprodutos;
        this.ppPlano = ppPlano;
        this.prioridade = prioridade;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
        this.stCp = stCp;
        this.tpCp = tpCp;
    }


    /**
     * Gets the cdCp value for this PpCp.
     * 
     * @return cdCp
     */
    public java.lang.String getCdCp() {
        return cdCp;
    }


    /**
     * Sets the cdCp value for this PpCp.
     * 
     * @param cdCp
     */
    public void setCdCp(java.lang.String cdCp) {
        this.cdCp = cdCp;
    }


    /**
     * Gets the dtCobertura value for this PpCp.
     * 
     * @return dtCobertura
     */
    public java.util.Calendar getDtCobertura() {
        return dtCobertura;
    }


    /**
     * Sets the dtCobertura value for this PpCp.
     * 
     * @param dtCobertura
     */
    public void setDtCobertura(java.util.Calendar dtCobertura) {
        this.dtCobertura = dtCobertura;
    }


    /**
     * Gets the dtRevisao value for this PpCp.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this PpCp.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this PpCp.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this PpCp.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dthrFinal value for this PpCp.
     * 
     * @return dthrFinal
     */
    public java.util.Calendar getDthrFinal() {
        return dthrFinal;
    }


    /**
     * Sets the dthrFinal value for this PpCp.
     * 
     * @param dthrFinal
     */
    public void setDthrFinal(java.util.Calendar dthrFinal) {
        this.dthrFinal = dthrFinal;
    }


    /**
     * Gets the dthrFinalreal value for this PpCp.
     * 
     * @return dthrFinalreal
     */
    public java.util.Calendar getDthrFinalreal() {
        return dthrFinalreal;
    }


    /**
     * Sets the dthrFinalreal value for this PpCp.
     * 
     * @param dthrFinalreal
     */
    public void setDthrFinalreal(java.util.Calendar dthrFinalreal) {
        this.dthrFinalreal = dthrFinalreal;
    }


    /**
     * Gets the dthrInicio value for this PpCp.
     * 
     * @return dthrInicio
     */
    public java.util.Calendar getDthrInicio() {
        return dthrInicio;
    }


    /**
     * Sets the dthrInicio value for this PpCp.
     * 
     * @param dthrInicio
     */
    public void setDthrInicio(java.util.Calendar dthrInicio) {
        this.dthrInicio = dthrInicio;
    }


    /**
     * Gets the dthrInicioreal value for this PpCp.
     * 
     * @return dthrInicioreal
     */
    public java.util.Calendar getDthrInicioreal() {
        return dthrInicioreal;
    }


    /**
     * Sets the dthrInicioreal value for this PpCp.
     * 
     * @param dthrInicioreal
     */
    public void setDthrInicioreal(java.util.Calendar dthrInicioreal) {
        this.dthrInicioreal = dthrInicioreal;
    }


    /**
     * Gets the dwCal value for this PpCp.
     * 
     * @return dwCal
     */
    public idw.idwws.DwCal getDwCal() {
        return dwCal;
    }


    /**
     * Sets the dwCal value for this PpCp.
     * 
     * @param dwCal
     */
    public void setDwCal(idw.idwws.DwCal dwCal) {
        this.dwCal = dwCal;
    }


    /**
     * Gets the dwConsolids value for this PpCp.
     * 
     * @return dwConsolids
     */
    public idw.idwws.DwConsolid[] getDwConsolids() {
        return dwConsolids;
    }


    /**
     * Sets the dwConsolids value for this PpCp.
     * 
     * @param dwConsolids
     */
    public void setDwConsolids(idw.idwws.DwConsolid[] dwConsolids) {
        this.dwConsolids = dwConsolids;
    }

    public idw.idwws.DwConsolid getDwConsolids(int i) {
        return this.dwConsolids[i];
    }

    public void setDwConsolids(int i, idw.idwws.DwConsolid _value) {
        this.dwConsolids[i] = _value;
    }


    /**
     * Gets the dwEst value for this PpCp.
     * 
     * @return dwEst
     */
    public idw.idwws.DwEst getDwEst() {
        return dwEst;
    }


    /**
     * Sets the dwEst value for this PpCp.
     * 
     * @param dwEst
     */
    public void setDwEst(idw.idwws.DwEst dwEst) {
        this.dwEst = dwEst;
    }


    /**
     * Gets the dwFolha value for this PpCp.
     * 
     * @return dwFolha
     */
    public idw.idwws.DwFolha getDwFolha() {
        return dwFolha;
    }


    /**
     * Sets the dwFolha value for this PpCp.
     * 
     * @param dwFolha
     */
    public void setDwFolha(idw.idwws.DwFolha dwFolha) {
        this.dwFolha = dwFolha;
    }


    /**
     * Gets the dwRota value for this PpCp.
     * 
     * @return dwRota
     */
    public idw.idwws.DwRota getDwRota() {
        return dwRota;
    }


    /**
     * Sets the dwRota value for this PpCp.
     * 
     * @param dwRota
     */
    public void setDwRota(idw.idwws.DwRota dwRota) {
        this.dwRota = dwRota;
    }


    /**
     * Gets the dwRts value for this PpCp.
     * 
     * @return dwRts
     */
    public idw.idwws.DwRt[] getDwRts() {
        return dwRts;
    }


    /**
     * Sets the dwRts value for this PpCp.
     * 
     * @param dwRts
     */
    public void setDwRts(idw.idwws.DwRt[] dwRts) {
        this.dwRts = dwRts;
    }

    public idw.idwws.DwRt getDwRts(int i) {
        return this.dwRts[i];
    }

    public void setDwRts(int i, idw.idwws.DwRt _value) {
        this.dwRts[i] = _value;
    }


    /**
     * Gets the idCp value for this PpCp.
     * 
     * @return idCp
     */
    public java.lang.Long getIdCp() {
        return idCp;
    }


    /**
     * Sets the idCp value for this PpCp.
     * 
     * @param idCp
     */
    public void setIdCp(java.lang.Long idCp) {
        this.idCp = idCp;
    }


    /**
     * Gets the isAntecipacao value for this PpCp.
     * 
     * @return isAntecipacao
     */
    public java.lang.Boolean getIsAntecipacao() {
        return isAntecipacao;
    }


    /**
     * Sets the isAntecipacao value for this PpCp.
     * 
     * @param isAntecipacao
     */
    public void setIsAntecipacao(java.lang.Boolean isAntecipacao) {
        this.isAntecipacao = isAntecipacao;
    }


    /**
     * Gets the isApAberta value for this PpCp.
     * 
     * @return isApAberta
     */
    public java.lang.Boolean getIsApAberta() {
        return isApAberta;
    }


    /**
     * Sets the isApAberta value for this PpCp.
     * 
     * @param isApAberta
     */
    public void setIsApAberta(java.lang.Boolean isApAberta) {
        this.isApAberta = isApAberta;
    }


    /**
     * Gets the isBarrasete value for this PpCp.
     * 
     * @return isBarrasete
     */
    public java.lang.Boolean getIsBarrasete() {
        return isBarrasete;
    }


    /**
     * Sets the isBarrasete value for this PpCp.
     * 
     * @param isBarrasete
     */
    public void setIsBarrasete(java.lang.Boolean isBarrasete) {
        this.isBarrasete = isBarrasete;
    }


    /**
     * Gets the isCm value for this PpCp.
     * 
     * @return isCm
     */
    public java.lang.Boolean getIsCm() {
        return isCm;
    }


    /**
     * Sets the isCm value for this PpCp.
     * 
     * @param isCm
     */
    public void setIsCm(java.lang.Boolean isCm) {
        this.isCm = isCm;
    }


    /**
     * Gets the isFaltamp value for this PpCp.
     * 
     * @return isFaltamp
     */
    public java.lang.Boolean getIsFaltamp() {
        return isFaltamp;
    }


    /**
     * Sets the isFaltamp value for this PpCp.
     * 
     * @param isFaltamp
     */
    public void setIsFaltamp(java.lang.Boolean isFaltamp) {
        this.isFaltamp = isFaltamp;
    }


    /**
     * Gets the isFinalserie value for this PpCp.
     * 
     * @return isFinalserie
     */
    public java.lang.Boolean getIsFinalserie() {
        return isFinalserie;
    }


    /**
     * Sets the isFinalserie value for this PpCp.
     * 
     * @param isFinalserie
     */
    public void setIsFinalserie(java.lang.Boolean isFinalserie) {
        this.isFinalserie = isFinalserie;
    }


    /**
     * Gets the isMassa value for this PpCp.
     * 
     * @return isMassa
     */
    public java.lang.Boolean getIsMassa() {
        return isMassa;
    }


    /**
     * Sets the isMassa value for this PpCp.
     * 
     * @param isMassa
     */
    public void setIsMassa(java.lang.Boolean isMassa) {
        this.isMassa = isMassa;
    }


    /**
     * Gets the isTryout value for this PpCp.
     * 
     * @return isTryout
     */
    public java.lang.Boolean getIsTryout() {
        return isTryout;
    }


    /**
     * Sets the isTryout value for this PpCp.
     * 
     * @param isTryout
     */
    public void setIsTryout(java.lang.Boolean isTryout) {
        this.isTryout = isTryout;
    }


    /**
     * Gets the omGt value for this PpCp.
     * 
     * @return omGt
     */
    public idw.idwws.OmGt getOmGt() {
        return omGt;
    }


    /**
     * Sets the omGt value for this PpCp.
     * 
     * @param omGt
     */
    public void setOmGt(idw.idwws.OmGt omGt) {
        this.omGt = omGt;
    }


    /**
     * Gets the omPt value for this PpCp.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this PpCp.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this PpCp.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this PpCp.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this PpCp.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this PpCp.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the passo value for this PpCp.
     * 
     * @return passo
     */
    public java.math.BigDecimal getPasso() {
        return passo;
    }


    /**
     * Sets the passo value for this PpCp.
     * 
     * @param passo
     */
    public void setPasso(java.math.BigDecimal passo) {
        this.passo = passo;
    }


    /**
     * Gets the ppCliente value for this PpCp.
     * 
     * @return ppCliente
     */
    public idw.idwws.PpCliente getPpCliente() {
        return ppCliente;
    }


    /**
     * Sets the ppCliente value for this PpCp.
     * 
     * @param ppCliente
     */
    public void setPpCliente(idw.idwws.PpCliente ppCliente) {
        this.ppCliente = ppCliente;
    }


    /**
     * Gets the ppCpPresForIdCp value for this PpCp.
     * 
     * @return ppCpPresForIdCp
     */
    public idw.idwws.PpCpPre[] getPpCpPresForIdCp() {
        return ppCpPresForIdCp;
    }


    /**
     * Sets the ppCpPresForIdCp value for this PpCp.
     * 
     * @param ppCpPresForIdCp
     */
    public void setPpCpPresForIdCp(idw.idwws.PpCpPre[] ppCpPresForIdCp) {
        this.ppCpPresForIdCp = ppCpPresForIdCp;
    }

    public idw.idwws.PpCpPre getPpCpPresForIdCp(int i) {
        return this.ppCpPresForIdCp[i];
    }

    public void setPpCpPresForIdCp(int i, idw.idwws.PpCpPre _value) {
        this.ppCpPresForIdCp[i] = _value;
    }


    /**
     * Gets the ppCpPresForIdCppredecessora value for this PpCp.
     * 
     * @return ppCpPresForIdCppredecessora
     */
    public idw.idwws.PpCpPre[] getPpCpPresForIdCppredecessora() {
        return ppCpPresForIdCppredecessora;
    }


    /**
     * Sets the ppCpPresForIdCppredecessora value for this PpCp.
     * 
     * @param ppCpPresForIdCppredecessora
     */
    public void setPpCpPresForIdCppredecessora(idw.idwws.PpCpPre[] ppCpPresForIdCppredecessora) {
        this.ppCpPresForIdCppredecessora = ppCpPresForIdCppredecessora;
    }

    public idw.idwws.PpCpPre getPpCpPresForIdCppredecessora(int i) {
        return this.ppCpPresForIdCppredecessora[i];
    }

    public void setPpCpPresForIdCppredecessora(int i, idw.idwws.PpCpPre _value) {
        this.ppCpPresForIdCppredecessora[i] = _value;
    }


    /**
     * Gets the ppCpfaltamps value for this PpCp.
     * 
     * @return ppCpfaltamps
     */
    public idw.idwws.PpCpfaltamp[] getPpCpfaltamps() {
        return ppCpfaltamps;
    }


    /**
     * Sets the ppCpfaltamps value for this PpCp.
     * 
     * @param ppCpfaltamps
     */
    public void setPpCpfaltamps(idw.idwws.PpCpfaltamp[] ppCpfaltamps) {
        this.ppCpfaltamps = ppCpfaltamps;
    }

    public idw.idwws.PpCpfaltamp getPpCpfaltamps(int i) {
        return this.ppCpfaltamps[i];
    }

    public void setPpCpfaltamps(int i, idw.idwws.PpCpfaltamp _value) {
        this.ppCpfaltamps[i] = _value;
    }


    /**
     * Gets the ppCpneccrons value for this PpCp.
     * 
     * @return ppCpneccrons
     */
    public idw.idwws.PpCpneccron[] getPpCpneccrons() {
        return ppCpneccrons;
    }


    /**
     * Sets the ppCpneccrons value for this PpCp.
     * 
     * @param ppCpneccrons
     */
    public void setPpCpneccrons(idw.idwws.PpCpneccron[] ppCpneccrons) {
        this.ppCpneccrons = ppCpneccrons;
    }

    public idw.idwws.PpCpneccron getPpCpneccrons(int i) {
        return this.ppCpneccrons[i];
    }

    public void setPpCpneccrons(int i, idw.idwws.PpCpneccron _value) {
        this.ppCpneccrons[i] = _value;
    }


    /**
     * Gets the ppCpprodutos value for this PpCp.
     * 
     * @return ppCpprodutos
     */
    public idw.idwws.PpCpproduto[] getPpCpprodutos() {
        return ppCpprodutos;
    }


    /**
     * Sets the ppCpprodutos value for this PpCp.
     * 
     * @param ppCpprodutos
     */
    public void setPpCpprodutos(idw.idwws.PpCpproduto[] ppCpprodutos) {
        this.ppCpprodutos = ppCpprodutos;
    }

    public idw.idwws.PpCpproduto getPpCpprodutos(int i) {
        return this.ppCpprodutos[i];
    }

    public void setPpCpprodutos(int i, idw.idwws.PpCpproduto _value) {
        this.ppCpprodutos[i] = _value;
    }


    /**
     * Gets the ppPlano value for this PpCp.
     * 
     * @return ppPlano
     */
    public idw.idwws.PpPlano getPpPlano() {
        return ppPlano;
    }


    /**
     * Sets the ppPlano value for this PpCp.
     * 
     * @param ppPlano
     */
    public void setPpPlano(idw.idwws.PpPlano ppPlano) {
        this.ppPlano = ppPlano;
    }


    /**
     * Gets the prioridade value for this PpCp.
     * 
     * @return prioridade
     */
    public java.lang.Integer getPrioridade() {
        return prioridade;
    }


    /**
     * Sets the prioridade value for this PpCp.
     * 
     * @param prioridade
     */
    public void setPrioridade(java.lang.Integer prioridade) {
        this.prioridade = prioridade;
    }


    /**
     * Gets the revisao value for this PpCp.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this PpCp.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this PpCp.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this PpCp.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the stCp value for this PpCp.
     * 
     * @return stCp
     */
    public java.lang.Integer getStCp() {
        return stCp;
    }


    /**
     * Sets the stCp value for this PpCp.
     * 
     * @param stCp
     */
    public void setStCp(java.lang.Integer stCp) {
        this.stCp = stCp;
    }


    /**
     * Gets the tpCp value for this PpCp.
     * 
     * @return tpCp
     */
    public java.lang.Integer getTpCp() {
        return tpCp;
    }


    /**
     * Sets the tpCp value for this PpCp.
     * 
     * @param tpCp
     */
    public void setTpCp(java.lang.Integer tpCp) {
        this.tpCp = tpCp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpCp)) return false;
        PpCp other = (PpCp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdCp==null && other.getCdCp()==null) || 
             (this.cdCp!=null &&
              this.cdCp.equals(other.getCdCp()))) &&
            ((this.dtCobertura==null && other.getDtCobertura()==null) || 
             (this.dtCobertura!=null &&
              this.dtCobertura.equals(other.getDtCobertura()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dthrFinal==null && other.getDthrFinal()==null) || 
             (this.dthrFinal!=null &&
              this.dthrFinal.equals(other.getDthrFinal()))) &&
            ((this.dthrFinalreal==null && other.getDthrFinalreal()==null) || 
             (this.dthrFinalreal!=null &&
              this.dthrFinalreal.equals(other.getDthrFinalreal()))) &&
            ((this.dthrInicio==null && other.getDthrInicio()==null) || 
             (this.dthrInicio!=null &&
              this.dthrInicio.equals(other.getDthrInicio()))) &&
            ((this.dthrInicioreal==null && other.getDthrInicioreal()==null) || 
             (this.dthrInicioreal!=null &&
              this.dthrInicioreal.equals(other.getDthrInicioreal()))) &&
            ((this.dwCal==null && other.getDwCal()==null) || 
             (this.dwCal!=null &&
              this.dwCal.equals(other.getDwCal()))) &&
            ((this.dwConsolids==null && other.getDwConsolids()==null) || 
             (this.dwConsolids!=null &&
              java.util.Arrays.equals(this.dwConsolids, other.getDwConsolids()))) &&
            ((this.dwEst==null && other.getDwEst()==null) || 
             (this.dwEst!=null &&
              this.dwEst.equals(other.getDwEst()))) &&
            ((this.dwFolha==null && other.getDwFolha()==null) || 
             (this.dwFolha!=null &&
              this.dwFolha.equals(other.getDwFolha()))) &&
            ((this.dwRota==null && other.getDwRota()==null) || 
             (this.dwRota!=null &&
              this.dwRota.equals(other.getDwRota()))) &&
            ((this.dwRts==null && other.getDwRts()==null) || 
             (this.dwRts!=null &&
              java.util.Arrays.equals(this.dwRts, other.getDwRts()))) &&
            ((this.idCp==null && other.getIdCp()==null) || 
             (this.idCp!=null &&
              this.idCp.equals(other.getIdCp()))) &&
            ((this.isAntecipacao==null && other.getIsAntecipacao()==null) || 
             (this.isAntecipacao!=null &&
              this.isAntecipacao.equals(other.getIsAntecipacao()))) &&
            ((this.isApAberta==null && other.getIsApAberta()==null) || 
             (this.isApAberta!=null &&
              this.isApAberta.equals(other.getIsApAberta()))) &&
            ((this.isBarrasete==null && other.getIsBarrasete()==null) || 
             (this.isBarrasete!=null &&
              this.isBarrasete.equals(other.getIsBarrasete()))) &&
            ((this.isCm==null && other.getIsCm()==null) || 
             (this.isCm!=null &&
              this.isCm.equals(other.getIsCm()))) &&
            ((this.isFaltamp==null && other.getIsFaltamp()==null) || 
             (this.isFaltamp!=null &&
              this.isFaltamp.equals(other.getIsFaltamp()))) &&
            ((this.isFinalserie==null && other.getIsFinalserie()==null) || 
             (this.isFinalserie!=null &&
              this.isFinalserie.equals(other.getIsFinalserie()))) &&
            ((this.isMassa==null && other.getIsMassa()==null) || 
             (this.isMassa!=null &&
              this.isMassa.equals(other.getIsMassa()))) &&
            ((this.isTryout==null && other.getIsTryout()==null) || 
             (this.isTryout!=null &&
              this.isTryout.equals(other.getIsTryout()))) &&
            ((this.omGt==null && other.getOmGt()==null) || 
             (this.omGt!=null &&
              this.omGt.equals(other.getOmGt()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.passo==null && other.getPasso()==null) || 
             (this.passo!=null &&
              this.passo.equals(other.getPasso()))) &&
            ((this.ppCliente==null && other.getPpCliente()==null) || 
             (this.ppCliente!=null &&
              this.ppCliente.equals(other.getPpCliente()))) &&
            ((this.ppCpPresForIdCp==null && other.getPpCpPresForIdCp()==null) || 
             (this.ppCpPresForIdCp!=null &&
              java.util.Arrays.equals(this.ppCpPresForIdCp, other.getPpCpPresForIdCp()))) &&
            ((this.ppCpPresForIdCppredecessora==null && other.getPpCpPresForIdCppredecessora()==null) || 
             (this.ppCpPresForIdCppredecessora!=null &&
              java.util.Arrays.equals(this.ppCpPresForIdCppredecessora, other.getPpCpPresForIdCppredecessora()))) &&
            ((this.ppCpfaltamps==null && other.getPpCpfaltamps()==null) || 
             (this.ppCpfaltamps!=null &&
              java.util.Arrays.equals(this.ppCpfaltamps, other.getPpCpfaltamps()))) &&
            ((this.ppCpneccrons==null && other.getPpCpneccrons()==null) || 
             (this.ppCpneccrons!=null &&
              java.util.Arrays.equals(this.ppCpneccrons, other.getPpCpneccrons()))) &&
            ((this.ppCpprodutos==null && other.getPpCpprodutos()==null) || 
             (this.ppCpprodutos!=null &&
              java.util.Arrays.equals(this.ppCpprodutos, other.getPpCpprodutos()))) &&
            ((this.ppPlano==null && other.getPpPlano()==null) || 
             (this.ppPlano!=null &&
              this.ppPlano.equals(other.getPpPlano()))) &&
            ((this.prioridade==null && other.getPrioridade()==null) || 
             (this.prioridade!=null &&
              this.prioridade.equals(other.getPrioridade()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.stCp==null && other.getStCp()==null) || 
             (this.stCp!=null &&
              this.stCp.equals(other.getStCp()))) &&
            ((this.tpCp==null && other.getTpCp()==null) || 
             (this.tpCp!=null &&
              this.tpCp.equals(other.getTpCp())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getCdCp() != null) {
            _hashCode += getCdCp().hashCode();
        }
        if (getDtCobertura() != null) {
            _hashCode += getDtCobertura().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDthrFinal() != null) {
            _hashCode += getDthrFinal().hashCode();
        }
        if (getDthrFinalreal() != null) {
            _hashCode += getDthrFinalreal().hashCode();
        }
        if (getDthrInicio() != null) {
            _hashCode += getDthrInicio().hashCode();
        }
        if (getDthrInicioreal() != null) {
            _hashCode += getDthrInicioreal().hashCode();
        }
        if (getDwCal() != null) {
            _hashCode += getDwCal().hashCode();
        }
        if (getDwConsolids() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolids());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolids(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwEst() != null) {
            _hashCode += getDwEst().hashCode();
        }
        if (getDwFolha() != null) {
            _hashCode += getDwFolha().hashCode();
        }
        if (getDwRota() != null) {
            _hashCode += getDwRota().hashCode();
        }
        if (getDwRts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwRts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwRts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdCp() != null) {
            _hashCode += getIdCp().hashCode();
        }
        if (getIsAntecipacao() != null) {
            _hashCode += getIsAntecipacao().hashCode();
        }
        if (getIsApAberta() != null) {
            _hashCode += getIsApAberta().hashCode();
        }
        if (getIsBarrasete() != null) {
            _hashCode += getIsBarrasete().hashCode();
        }
        if (getIsCm() != null) {
            _hashCode += getIsCm().hashCode();
        }
        if (getIsFaltamp() != null) {
            _hashCode += getIsFaltamp().hashCode();
        }
        if (getIsFinalserie() != null) {
            _hashCode += getIsFinalserie().hashCode();
        }
        if (getIsMassa() != null) {
            _hashCode += getIsMassa().hashCode();
        }
        if (getIsTryout() != null) {
            _hashCode += getIsTryout().hashCode();
        }
        if (getOmGt() != null) {
            _hashCode += getOmGt().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
        }
        if (getPasso() != null) {
            _hashCode += getPasso().hashCode();
        }
        if (getPpCliente() != null) {
            _hashCode += getPpCliente().hashCode();
        }
        if (getPpCpPresForIdCp() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpCpPresForIdCp());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpCpPresForIdCp(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpCpPresForIdCppredecessora() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpCpPresForIdCppredecessora());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpCpPresForIdCppredecessora(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpCpfaltamps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpCpfaltamps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpCpfaltamps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpCpneccrons() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpCpneccrons());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpCpneccrons(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpCpprodutos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpCpprodutos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpCpprodutos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpPlano() != null) {
            _hashCode += getPpPlano().hashCode();
        }
        if (getPrioridade() != null) {
            _hashCode += getPrioridade().hashCode();
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        if (getStCp() != null) {
            _hashCode += getStCp().hashCode();
        }
        if (getTpCp() != null) {
            _hashCode += getTpCp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpCp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtCobertura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtCobertura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtRevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtRevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtStativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtStativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFinalreal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFinalreal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrInicioreal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrInicioreal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwCal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwCal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolids");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolids"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRota");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRota"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRota"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAntecipacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isAntecipacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isApAberta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isApAberta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isBarrasete");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isBarrasete"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isCm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isCm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isFaltamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isFaltamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isFinalserie");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isFinalserie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isMassa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isMassa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isTryout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isTryout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("passo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "passo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCliente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCpPresForIdCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCpPresForIdCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpPre"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCpPresForIdCppredecessora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCpPresForIdCppredecessora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpPre"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCpfaltamps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCpfaltamps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpfaltamp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCpneccrons");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCpneccrons"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpneccron"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCpprodutos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCpprodutos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpproduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppPlano");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppPlano"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppPlano"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prioridade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prioridade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAtivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
