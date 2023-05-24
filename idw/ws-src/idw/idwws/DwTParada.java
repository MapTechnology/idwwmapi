/**
 * DwTParada.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwTParada  extends idw.idwws.DwTParadaTemplate  implements java.io.Serializable {
    private java.lang.String cdTparada;

    private java.lang.String dsTparada;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwConsolpalog[] dwConsolpalogs;

    private idw.idwws.DwConsolpa[] dwConsolpas;

    private idw.idwws.DwTArea dwTArea;

    private java.lang.Long idTparada;

    private java.lang.Boolean isDefault;

    private java.lang.Boolean isFds;

    private java.lang.Boolean isMdo;

    private java.lang.Boolean isMtbf;

    private java.lang.Boolean isMttr;

    private java.lang.Boolean isPa;

    private java.lang.Boolean isPao;

    private java.lang.Boolean isPermitecorrecao;

    private java.lang.Boolean isPesa;

    private java.lang.Boolean isPp;

    private java.lang.Boolean isPrev;

    private java.lang.Boolean isPtp;

    private java.lang.Boolean isRegulagem;

    private java.lang.Boolean isRequerAcao;

    private java.lang.Boolean isRequerCausa;

    private java.lang.Boolean isRequerJust;

    private java.lang.Boolean isScp;

    private java.lang.Boolean isSemConexao;

    private java.lang.Boolean isSemEvento;

    private java.lang.Boolean isSemOp;

    private idw.idwws.OmCfg[] omCfgs;

    private idw.idwws.OmTppt omTppt;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.lang.Integer qtTec;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public DwTParada() {
    }

    public DwTParada(
           java.lang.Long id,
           java.lang.String cdTparada,
           java.lang.String dsTparada,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwConsolpalog[] dwConsolpalogs,
           idw.idwws.DwConsolpa[] dwConsolpas,
           idw.idwws.DwTArea dwTArea,
           java.lang.Long idTparada,
           java.lang.Boolean isDefault,
           java.lang.Boolean isFds,
           java.lang.Boolean isMdo,
           java.lang.Boolean isMtbf,
           java.lang.Boolean isMttr,
           java.lang.Boolean isPa,
           java.lang.Boolean isPao,
           java.lang.Boolean isPermitecorrecao,
           java.lang.Boolean isPesa,
           java.lang.Boolean isPp,
           java.lang.Boolean isPrev,
           java.lang.Boolean isPtp,
           java.lang.Boolean isRegulagem,
           java.lang.Boolean isRequerAcao,
           java.lang.Boolean isRequerCausa,
           java.lang.Boolean isRequerJust,
           java.lang.Boolean isScp,
           java.lang.Boolean isSemConexao,
           java.lang.Boolean isSemEvento,
           java.lang.Boolean isSemOp,
           idw.idwws.OmCfg[] omCfgs,
           idw.idwws.OmTppt omTppt,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.Integer qtTec,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        super(
            id);
        this.cdTparada = cdTparada;
        this.dsTparada = dsTparada;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwConsolpalogs = dwConsolpalogs;
        this.dwConsolpas = dwConsolpas;
        this.dwTArea = dwTArea;
        this.idTparada = idTparada;
        this.isDefault = isDefault;
        this.isFds = isFds;
        this.isMdo = isMdo;
        this.isMtbf = isMtbf;
        this.isMttr = isMttr;
        this.isPa = isPa;
        this.isPao = isPao;
        this.isPermitecorrecao = isPermitecorrecao;
        this.isPesa = isPesa;
        this.isPp = isPp;
        this.isPrev = isPrev;
        this.isPtp = isPtp;
        this.isRegulagem = isRegulagem;
        this.isRequerAcao = isRequerAcao;
        this.isRequerCausa = isRequerCausa;
        this.isRequerJust = isRequerJust;
        this.isScp = isScp;
        this.isSemConexao = isSemConexao;
        this.isSemEvento = isSemEvento;
        this.isSemOp = isSemOp;
        this.omCfgs = omCfgs;
        this.omTppt = omTppt;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.qtTec = qtTec;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdTparada value for this DwTParada.
     * 
     * @return cdTparada
     */
    public java.lang.String getCdTparada() {
        return cdTparada;
    }


    /**
     * Sets the cdTparada value for this DwTParada.
     * 
     * @param cdTparada
     */
    public void setCdTparada(java.lang.String cdTparada) {
        this.cdTparada = cdTparada;
    }


    /**
     * Gets the dsTparada value for this DwTParada.
     * 
     * @return dsTparada
     */
    public java.lang.String getDsTparada() {
        return dsTparada;
    }


    /**
     * Sets the dsTparada value for this DwTParada.
     * 
     * @param dsTparada
     */
    public void setDsTparada(java.lang.String dsTparada) {
        this.dsTparada = dsTparada;
    }


    /**
     * Gets the dtRevisao value for this DwTParada.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this DwTParada.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this DwTParada.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this DwTParada.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwConsolpalogs value for this DwTParada.
     * 
     * @return dwConsolpalogs
     */
    public idw.idwws.DwConsolpalog[] getDwConsolpalogs() {
        return dwConsolpalogs;
    }


    /**
     * Sets the dwConsolpalogs value for this DwTParada.
     * 
     * @param dwConsolpalogs
     */
    public void setDwConsolpalogs(idw.idwws.DwConsolpalog[] dwConsolpalogs) {
        this.dwConsolpalogs = dwConsolpalogs;
    }

    public idw.idwws.DwConsolpalog getDwConsolpalogs(int i) {
        return this.dwConsolpalogs[i];
    }

    public void setDwConsolpalogs(int i, idw.idwws.DwConsolpalog _value) {
        this.dwConsolpalogs[i] = _value;
    }


    /**
     * Gets the dwConsolpas value for this DwTParada.
     * 
     * @return dwConsolpas
     */
    public idw.idwws.DwConsolpa[] getDwConsolpas() {
        return dwConsolpas;
    }


    /**
     * Sets the dwConsolpas value for this DwTParada.
     * 
     * @param dwConsolpas
     */
    public void setDwConsolpas(idw.idwws.DwConsolpa[] dwConsolpas) {
        this.dwConsolpas = dwConsolpas;
    }

    public idw.idwws.DwConsolpa getDwConsolpas(int i) {
        return this.dwConsolpas[i];
    }

    public void setDwConsolpas(int i, idw.idwws.DwConsolpa _value) {
        this.dwConsolpas[i] = _value;
    }


    /**
     * Gets the dwTArea value for this DwTParada.
     * 
     * @return dwTArea
     */
    public idw.idwws.DwTArea getDwTArea() {
        return dwTArea;
    }


    /**
     * Sets the dwTArea value for this DwTParada.
     * 
     * @param dwTArea
     */
    public void setDwTArea(idw.idwws.DwTArea dwTArea) {
        this.dwTArea = dwTArea;
    }


    /**
     * Gets the idTparada value for this DwTParada.
     * 
     * @return idTparada
     */
    public java.lang.Long getIdTparada() {
        return idTparada;
    }


    /**
     * Sets the idTparada value for this DwTParada.
     * 
     * @param idTparada
     */
    public void setIdTparada(java.lang.Long idTparada) {
        this.idTparada = idTparada;
    }


    /**
     * Gets the isDefault value for this DwTParada.
     * 
     * @return isDefault
     */
    public java.lang.Boolean getIsDefault() {
        return isDefault;
    }


    /**
     * Sets the isDefault value for this DwTParada.
     * 
     * @param isDefault
     */
    public void setIsDefault(java.lang.Boolean isDefault) {
        this.isDefault = isDefault;
    }


    /**
     * Gets the isFds value for this DwTParada.
     * 
     * @return isFds
     */
    public java.lang.Boolean getIsFds() {
        return isFds;
    }


    /**
     * Sets the isFds value for this DwTParada.
     * 
     * @param isFds
     */
    public void setIsFds(java.lang.Boolean isFds) {
        this.isFds = isFds;
    }


    /**
     * Gets the isMdo value for this DwTParada.
     * 
     * @return isMdo
     */
    public java.lang.Boolean getIsMdo() {
        return isMdo;
    }


    /**
     * Sets the isMdo value for this DwTParada.
     * 
     * @param isMdo
     */
    public void setIsMdo(java.lang.Boolean isMdo) {
        this.isMdo = isMdo;
    }


    /**
     * Gets the isMtbf value for this DwTParada.
     * 
     * @return isMtbf
     */
    public java.lang.Boolean getIsMtbf() {
        return isMtbf;
    }


    /**
     * Sets the isMtbf value for this DwTParada.
     * 
     * @param isMtbf
     */
    public void setIsMtbf(java.lang.Boolean isMtbf) {
        this.isMtbf = isMtbf;
    }


    /**
     * Gets the isMttr value for this DwTParada.
     * 
     * @return isMttr
     */
    public java.lang.Boolean getIsMttr() {
        return isMttr;
    }


    /**
     * Sets the isMttr value for this DwTParada.
     * 
     * @param isMttr
     */
    public void setIsMttr(java.lang.Boolean isMttr) {
        this.isMttr = isMttr;
    }


    /**
     * Gets the isPa value for this DwTParada.
     * 
     * @return isPa
     */
    public java.lang.Boolean getIsPa() {
        return isPa;
    }


    /**
     * Sets the isPa value for this DwTParada.
     * 
     * @param isPa
     */
    public void setIsPa(java.lang.Boolean isPa) {
        this.isPa = isPa;
    }


    /**
     * Gets the isPao value for this DwTParada.
     * 
     * @return isPao
     */
    public java.lang.Boolean getIsPao() {
        return isPao;
    }


    /**
     * Sets the isPao value for this DwTParada.
     * 
     * @param isPao
     */
    public void setIsPao(java.lang.Boolean isPao) {
        this.isPao = isPao;
    }


    /**
     * Gets the isPermitecorrecao value for this DwTParada.
     * 
     * @return isPermitecorrecao
     */
    public java.lang.Boolean getIsPermitecorrecao() {
        return isPermitecorrecao;
    }


    /**
     * Sets the isPermitecorrecao value for this DwTParada.
     * 
     * @param isPermitecorrecao
     */
    public void setIsPermitecorrecao(java.lang.Boolean isPermitecorrecao) {
        this.isPermitecorrecao = isPermitecorrecao;
    }


    /**
     * Gets the isPesa value for this DwTParada.
     * 
     * @return isPesa
     */
    public java.lang.Boolean getIsPesa() {
        return isPesa;
    }


    /**
     * Sets the isPesa value for this DwTParada.
     * 
     * @param isPesa
     */
    public void setIsPesa(java.lang.Boolean isPesa) {
        this.isPesa = isPesa;
    }


    /**
     * Gets the isPp value for this DwTParada.
     * 
     * @return isPp
     */
    public java.lang.Boolean getIsPp() {
        return isPp;
    }


    /**
     * Sets the isPp value for this DwTParada.
     * 
     * @param isPp
     */
    public void setIsPp(java.lang.Boolean isPp) {
        this.isPp = isPp;
    }


    /**
     * Gets the isPrev value for this DwTParada.
     * 
     * @return isPrev
     */
    public java.lang.Boolean getIsPrev() {
        return isPrev;
    }


    /**
     * Sets the isPrev value for this DwTParada.
     * 
     * @param isPrev
     */
    public void setIsPrev(java.lang.Boolean isPrev) {
        this.isPrev = isPrev;
    }


    /**
     * Gets the isPtp value for this DwTParada.
     * 
     * @return isPtp
     */
    public java.lang.Boolean getIsPtp() {
        return isPtp;
    }


    /**
     * Sets the isPtp value for this DwTParada.
     * 
     * @param isPtp
     */
    public void setIsPtp(java.lang.Boolean isPtp) {
        this.isPtp = isPtp;
    }


    /**
     * Gets the isRegulagem value for this DwTParada.
     * 
     * @return isRegulagem
     */
    public java.lang.Boolean getIsRegulagem() {
        return isRegulagem;
    }


    /**
     * Sets the isRegulagem value for this DwTParada.
     * 
     * @param isRegulagem
     */
    public void setIsRegulagem(java.lang.Boolean isRegulagem) {
        this.isRegulagem = isRegulagem;
    }


    /**
     * Gets the isRequerAcao value for this DwTParada.
     * 
     * @return isRequerAcao
     */
    public java.lang.Boolean getIsRequerAcao() {
        return isRequerAcao;
    }


    /**
     * Sets the isRequerAcao value for this DwTParada.
     * 
     * @param isRequerAcao
     */
    public void setIsRequerAcao(java.lang.Boolean isRequerAcao) {
        this.isRequerAcao = isRequerAcao;
    }


    /**
     * Gets the isRequerCausa value for this DwTParada.
     * 
     * @return isRequerCausa
     */
    public java.lang.Boolean getIsRequerCausa() {
        return isRequerCausa;
    }


    /**
     * Sets the isRequerCausa value for this DwTParada.
     * 
     * @param isRequerCausa
     */
    public void setIsRequerCausa(java.lang.Boolean isRequerCausa) {
        this.isRequerCausa = isRequerCausa;
    }


    /**
     * Gets the isRequerJust value for this DwTParada.
     * 
     * @return isRequerJust
     */
    public java.lang.Boolean getIsRequerJust() {
        return isRequerJust;
    }


    /**
     * Sets the isRequerJust value for this DwTParada.
     * 
     * @param isRequerJust
     */
    public void setIsRequerJust(java.lang.Boolean isRequerJust) {
        this.isRequerJust = isRequerJust;
    }


    /**
     * Gets the isScp value for this DwTParada.
     * 
     * @return isScp
     */
    public java.lang.Boolean getIsScp() {
        return isScp;
    }


    /**
     * Sets the isScp value for this DwTParada.
     * 
     * @param isScp
     */
    public void setIsScp(java.lang.Boolean isScp) {
        this.isScp = isScp;
    }


    /**
     * Gets the isSemConexao value for this DwTParada.
     * 
     * @return isSemConexao
     */
    public java.lang.Boolean getIsSemConexao() {
        return isSemConexao;
    }


    /**
     * Sets the isSemConexao value for this DwTParada.
     * 
     * @param isSemConexao
     */
    public void setIsSemConexao(java.lang.Boolean isSemConexao) {
        this.isSemConexao = isSemConexao;
    }


    /**
     * Gets the isSemEvento value for this DwTParada.
     * 
     * @return isSemEvento
     */
    public java.lang.Boolean getIsSemEvento() {
        return isSemEvento;
    }


    /**
     * Sets the isSemEvento value for this DwTParada.
     * 
     * @param isSemEvento
     */
    public void setIsSemEvento(java.lang.Boolean isSemEvento) {
        this.isSemEvento = isSemEvento;
    }


    /**
     * Gets the isSemOp value for this DwTParada.
     * 
     * @return isSemOp
     */
    public java.lang.Boolean getIsSemOp() {
        return isSemOp;
    }


    /**
     * Sets the isSemOp value for this DwTParada.
     * 
     * @param isSemOp
     */
    public void setIsSemOp(java.lang.Boolean isSemOp) {
        this.isSemOp = isSemOp;
    }


    /**
     * Gets the omCfgs value for this DwTParada.
     * 
     * @return omCfgs
     */
    public idw.idwws.OmCfg[] getOmCfgs() {
        return omCfgs;
    }


    /**
     * Sets the omCfgs value for this DwTParada.
     * 
     * @param omCfgs
     */
    public void setOmCfgs(idw.idwws.OmCfg[] omCfgs) {
        this.omCfgs = omCfgs;
    }

    public idw.idwws.OmCfg getOmCfgs(int i) {
        return this.omCfgs[i];
    }

    public void setOmCfgs(int i, idw.idwws.OmCfg _value) {
        this.omCfgs[i] = _value;
    }


    /**
     * Gets the omTppt value for this DwTParada.
     * 
     * @return omTppt
     */
    public idw.idwws.OmTppt getOmTppt() {
        return omTppt;
    }


    /**
     * Sets the omTppt value for this DwTParada.
     * 
     * @param omTppt
     */
    public void setOmTppt(idw.idwws.OmTppt omTppt) {
        this.omTppt = omTppt;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this DwTParada.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this DwTParada.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this DwTParada.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this DwTParada.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the qtTec value for this DwTParada.
     * 
     * @return qtTec
     */
    public java.lang.Integer getQtTec() {
        return qtTec;
    }


    /**
     * Sets the qtTec value for this DwTParada.
     * 
     * @param qtTec
     */
    public void setQtTec(java.lang.Integer qtTec) {
        this.qtTec = qtTec;
    }


    /**
     * Gets the revisao value for this DwTParada.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this DwTParada.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this DwTParada.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this DwTParada.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwTParada)) return false;
        DwTParada other = (DwTParada) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdTparada==null && other.getCdTparada()==null) || 
             (this.cdTparada!=null &&
              this.cdTparada.equals(other.getCdTparada()))) &&
            ((this.dsTparada==null && other.getDsTparada()==null) || 
             (this.dsTparada!=null &&
              this.dsTparada.equals(other.getDsTparada()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dwConsolpalogs==null && other.getDwConsolpalogs()==null) || 
             (this.dwConsolpalogs!=null &&
              java.util.Arrays.equals(this.dwConsolpalogs, other.getDwConsolpalogs()))) &&
            ((this.dwConsolpas==null && other.getDwConsolpas()==null) || 
             (this.dwConsolpas!=null &&
              java.util.Arrays.equals(this.dwConsolpas, other.getDwConsolpas()))) &&
            ((this.dwTArea==null && other.getDwTArea()==null) || 
             (this.dwTArea!=null &&
              this.dwTArea.equals(other.getDwTArea()))) &&
            ((this.idTparada==null && other.getIdTparada()==null) || 
             (this.idTparada!=null &&
              this.idTparada.equals(other.getIdTparada()))) &&
            ((this.isDefault==null && other.getIsDefault()==null) || 
             (this.isDefault!=null &&
              this.isDefault.equals(other.getIsDefault()))) &&
            ((this.isFds==null && other.getIsFds()==null) || 
             (this.isFds!=null &&
              this.isFds.equals(other.getIsFds()))) &&
            ((this.isMdo==null && other.getIsMdo()==null) || 
             (this.isMdo!=null &&
              this.isMdo.equals(other.getIsMdo()))) &&
            ((this.isMtbf==null && other.getIsMtbf()==null) || 
             (this.isMtbf!=null &&
              this.isMtbf.equals(other.getIsMtbf()))) &&
            ((this.isMttr==null && other.getIsMttr()==null) || 
             (this.isMttr!=null &&
              this.isMttr.equals(other.getIsMttr()))) &&
            ((this.isPa==null && other.getIsPa()==null) || 
             (this.isPa!=null &&
              this.isPa.equals(other.getIsPa()))) &&
            ((this.isPao==null && other.getIsPao()==null) || 
             (this.isPao!=null &&
              this.isPao.equals(other.getIsPao()))) &&
            ((this.isPermitecorrecao==null && other.getIsPermitecorrecao()==null) || 
             (this.isPermitecorrecao!=null &&
              this.isPermitecorrecao.equals(other.getIsPermitecorrecao()))) &&
            ((this.isPesa==null && other.getIsPesa()==null) || 
             (this.isPesa!=null &&
              this.isPesa.equals(other.getIsPesa()))) &&
            ((this.isPp==null && other.getIsPp()==null) || 
             (this.isPp!=null &&
              this.isPp.equals(other.getIsPp()))) &&
            ((this.isPrev==null && other.getIsPrev()==null) || 
             (this.isPrev!=null &&
              this.isPrev.equals(other.getIsPrev()))) &&
            ((this.isPtp==null && other.getIsPtp()==null) || 
             (this.isPtp!=null &&
              this.isPtp.equals(other.getIsPtp()))) &&
            ((this.isRegulagem==null && other.getIsRegulagem()==null) || 
             (this.isRegulagem!=null &&
              this.isRegulagem.equals(other.getIsRegulagem()))) &&
            ((this.isRequerAcao==null && other.getIsRequerAcao()==null) || 
             (this.isRequerAcao!=null &&
              this.isRequerAcao.equals(other.getIsRequerAcao()))) &&
            ((this.isRequerCausa==null && other.getIsRequerCausa()==null) || 
             (this.isRequerCausa!=null &&
              this.isRequerCausa.equals(other.getIsRequerCausa()))) &&
            ((this.isRequerJust==null && other.getIsRequerJust()==null) || 
             (this.isRequerJust!=null &&
              this.isRequerJust.equals(other.getIsRequerJust()))) &&
            ((this.isScp==null && other.getIsScp()==null) || 
             (this.isScp!=null &&
              this.isScp.equals(other.getIsScp()))) &&
            ((this.isSemConexao==null && other.getIsSemConexao()==null) || 
             (this.isSemConexao!=null &&
              this.isSemConexao.equals(other.getIsSemConexao()))) &&
            ((this.isSemEvento==null && other.getIsSemEvento()==null) || 
             (this.isSemEvento!=null &&
              this.isSemEvento.equals(other.getIsSemEvento()))) &&
            ((this.isSemOp==null && other.getIsSemOp()==null) || 
             (this.isSemOp!=null &&
              this.isSemOp.equals(other.getIsSemOp()))) &&
            ((this.omCfgs==null && other.getOmCfgs()==null) || 
             (this.omCfgs!=null &&
              java.util.Arrays.equals(this.omCfgs, other.getOmCfgs()))) &&
            ((this.omTppt==null && other.getOmTppt()==null) || 
             (this.omTppt!=null &&
              this.omTppt.equals(other.getOmTppt()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.qtTec==null && other.getQtTec()==null) || 
             (this.qtTec!=null &&
              this.qtTec.equals(other.getQtTec()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo())));
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
        if (getCdTparada() != null) {
            _hashCode += getCdTparada().hashCode();
        }
        if (getDsTparada() != null) {
            _hashCode += getDsTparada().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDwConsolpalogs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolpalogs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolpalogs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolpas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolpas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolpas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTArea() != null) {
            _hashCode += getDwTArea().hashCode();
        }
        if (getIdTparada() != null) {
            _hashCode += getIdTparada().hashCode();
        }
        if (getIsDefault() != null) {
            _hashCode += getIsDefault().hashCode();
        }
        if (getIsFds() != null) {
            _hashCode += getIsFds().hashCode();
        }
        if (getIsMdo() != null) {
            _hashCode += getIsMdo().hashCode();
        }
        if (getIsMtbf() != null) {
            _hashCode += getIsMtbf().hashCode();
        }
        if (getIsMttr() != null) {
            _hashCode += getIsMttr().hashCode();
        }
        if (getIsPa() != null) {
            _hashCode += getIsPa().hashCode();
        }
        if (getIsPao() != null) {
            _hashCode += getIsPao().hashCode();
        }
        if (getIsPermitecorrecao() != null) {
            _hashCode += getIsPermitecorrecao().hashCode();
        }
        if (getIsPesa() != null) {
            _hashCode += getIsPesa().hashCode();
        }
        if (getIsPp() != null) {
            _hashCode += getIsPp().hashCode();
        }
        if (getIsPrev() != null) {
            _hashCode += getIsPrev().hashCode();
        }
        if (getIsPtp() != null) {
            _hashCode += getIsPtp().hashCode();
        }
        if (getIsRegulagem() != null) {
            _hashCode += getIsRegulagem().hashCode();
        }
        if (getIsRequerAcao() != null) {
            _hashCode += getIsRequerAcao().hashCode();
        }
        if (getIsRequerCausa() != null) {
            _hashCode += getIsRequerCausa().hashCode();
        }
        if (getIsRequerJust() != null) {
            _hashCode += getIsRequerJust().hashCode();
        }
        if (getIsScp() != null) {
            _hashCode += getIsScp().hashCode();
        }
        if (getIsSemConexao() != null) {
            _hashCode += getIsSemConexao().hashCode();
        }
        if (getIsSemEvento() != null) {
            _hashCode += getIsSemEvento().hashCode();
        }
        if (getIsSemOp() != null) {
            _hashCode += getIsSemOp().hashCode();
        }
        if (getOmCfgs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmTppt() != null) {
            _hashCode += getOmTppt().hashCode();
        }
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
        }
        if (getQtTec() != null) {
            _hashCode += getQtTec().hashCode();
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwTParada.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTParada"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdTparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdTparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsTparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsTparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("dwConsolpalogs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpalogs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpalog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolpas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTArea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTArea"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isFds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isFds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isMdo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isMdo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isMtbf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isMtbf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isMttr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isMttr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isPa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isPao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPermitecorrecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isPermitecorrecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPesa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isPesa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isPp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPrev");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isPrev"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPtp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isPtp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isRegulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isRegulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isRequerAcao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isRequerAcao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isRequerCausa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isRequerCausa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isRequerJust");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isRequerJust"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isScp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isScp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isSemConexao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isSemConexao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isSemEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isSemEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isSemOp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isSemOp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTppt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTppt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTppt"));
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
        elemField.setFieldName("qtTec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtTec"));
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
